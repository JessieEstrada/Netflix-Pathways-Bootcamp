package com.company.gamestore.service;

import com.company.gamestore.model.*;
import com.company.gamestore.repository.*;
import com.company.gamestore.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class ServiceLayer {

    private ConsoleRepository consoleRepository;

    private FeeRepository feeRepository;

    private GameRepository gameRepository;

    private InvoiceRepository invoiceRepository;

    private TaxRepository taxRepository;

    private TshirtRepository tShirtRepository;

    @Autowired
    public ServiceLayer(ConsoleRepository consoleRepository, FeeRepository feeRepository, GameRepository gameRepository, InvoiceRepository invoiceRepository, TaxRepository taxRepository, TshirtRepository tShirtRepository) {
        this.consoleRepository = consoleRepository;
        this.feeRepository = feeRepository;
        this.gameRepository = gameRepository;
        this.invoiceRepository = invoiceRepository;
        this.taxRepository = taxRepository;
        this.tShirtRepository = tShirtRepository;
    }

    public Console saveConsole(Console console){

        return consoleRepository.save(console);
    }

    public Console findConsole(int id){
        Optional<Console> console = consoleRepository.findById(id);

        return console.isPresent() ? console.get() : null;
    }

    public List<Console> getAllConsoles(){
        return consoleRepository.findAll();
    }

    public void updateConsole(Console console){
        consoleRepository.save(console);
    }

    public void deleteConsole(int id){
        consoleRepository.deleteById(id);
    }

    public List<Console> getAllConsolesByManufacturer(String manufacturer){
        String cleanedManufacturer = manufacturer.replaceAll("\"", ""); // remove all quotes from title
        return consoleRepository.findAllByManufacturer(cleanedManufacturer);
    }

    public Game saveGame(Game game){

        return gameRepository.save(game);
    }

    public Game findGame(int id){
        Optional<Game> game = gameRepository.findById(id); // this Optional returns -> True or False

        return game.isPresent() ? game.get() : null;
    }

    public List<Game> getAllGames(){
        return gameRepository.findAll();
    }

    public void updateGame(Game game){
        gameRepository.save(game);
    }

    public void deleteGame(int id){
        gameRepository.deleteById(id);
    }

    public List<Game> getAllGamesByStudio(String studio){
        String cleanedStudio= studio.replaceAll("\"", ""); // remove all quotes from title
        return gameRepository.findAllByStudio(cleanedStudio);
    }

    public List<Game> getAllGamesByESRB(String esrb){
        String cleanedESRB = esrb;

        if (esrb.startsWith("\"") && esrb.endsWith("\"")) {
            cleanedESRB = esrb.substring(1, esrb.length() - 1); // remove quotes only if they are at the beginning and end of the string
        }
        return gameRepository.findAllByEsrbRating(cleanedESRB);
    }


    public List<Game> getAllGamesByTitle(String title){
        String cleanedTitle = title.replaceAll("\"", ""); // remove all quotes from title
        System.out.println(cleanedTitle);
        return gameRepository.findAllByTitle(cleanedTitle);
    }



    //
    // INVOICE API
    //



    @Transactional
    public InvoiceViewModel saveInvoice(InvoiceViewModel viewModel){

        //initialize tax
        BigDecimal taxRate = null;
        Optional<Tax> stateTaxOptional = taxRepository.findByState(viewModel.getState());

        if(!stateTaxOptional.isPresent()){
            throw new IllegalArgumentException("Invalid State: " + viewModel.getState());
        }
        else taxRate = viewModel.getTax();


        //Checking Type

        //Checking for Game removal
        Game foundGame = null;
        boolean removeGame = false;

        //Checking for Console removal
        Console foundConsole = null;
        boolean removeConsole = false;


        //Checking for TShirt removal
        Tshirt foundTShirt = null;
        boolean removeTshirt = false;


        if (!viewModel.getItemType().equals("Game") && !viewModel.getItemType().equals("Console") && !viewModel.getItemType().equals("T-Shirt")){
            //If  the given item is not  the type that we accept
            throw new IllegalArgumentException("There is no Item with type: " + viewModel.getItemType());

        }else if(viewModel.getItemType().equals("Game") ){
            //If it is a game then we use the Game Repository to check if the id provided is in one of our items inside the repo

            Optional<Game> game = gameRepository.findById(viewModel.getItemId()); // this Optional returns -> True or False

            //Hand
            if(!game.isPresent()){
                throw new IllegalArgumentException("There is no item in the Game section attached to Item ID: " + viewModel.getItemId());
            }

            //Now that we know that the id is present in the  repository
            // we can start checking if the quantity in "inventory" is sufficient

            ////Getting the actual Game Object in order to check the quantity

            //initialize variable that will store the Object of the Game(This will not be null since we already checked that is inside the repository)

            //Getting by id but using for loop
            for(Game itemGame : gameRepository.findAll()){
                if(itemGame.getGameId() == viewModel.getItemId()){
                    foundGame = itemGame;
                    break;
                }
            }

            //If the quantity of our object found is less than what customer is buying
            if(foundGame.getQuantity() < viewModel.getQuantity()){
                //then throw error
                throw new IllegalArgumentException("There is an insufficient quantity of items. There are only: " + foundGame.getQuantity() + " available.");
            }
            //new quantity value for the Game

            if(foundGame.getQuantity() == viewModel.getQuantity()){
                removeGame = true;
            }
            else {
                // Now remove Games depending on how many the user bought
                Integer quantityBought = viewModel.getQuantity();
                Integer quantityAvailable = foundGame.getQuantity();

                quantityAvailable -= quantityBought; // now we can use quantity available variable to update the game
                foundGame.setQuantity(quantityAvailable);
                //updating with new quantity
                gameRepository.save(foundGame);
            }


        } else if(viewModel.getItemType().equals("Console")){
            //If it is a console then we use the Console Repository to check if the id provided is in one of our items inside the repo
            Optional<Console> console = consoleRepository.findById(viewModel.getItemId()); // this Optional returns -> True or False
            if(!console.isPresent()){
                throw new IllegalArgumentException("There is no item in the Console section attached to Item ID: " + viewModel.getItemId());
            }

            //Now that we know that the id is present in the  repository. We can start checking if the quantity in "inventory" is sufficient

            //Getting the actual Game Object in order to check the quantity

            //initialize variable that will store the Object of the Game(This will not be null since we already checked that is inside the repository)


            //Getting by id but using for loop
            for(Console itemConsole : consoleRepository.findAll()){
                if(itemConsole.getConsoleId() == viewModel.getItemId()){
                    foundConsole = itemConsole;
                    break;
                }
            }

            //If the quantity of our object found is less than what customer is buying
            if(foundConsole.getQuantity() < viewModel.getQuantity()){
                //then throw error
                throw new IllegalArgumentException("There is an insufficient quantity of items. There are only: " + foundConsole.getQuantity() + " available.");
            }
            // Now remove Consoles depending on how many the user bought
            Integer quantityBought = viewModel.getQuantity();
            Integer quantityAvailable = foundConsole.getQuantity();

            //new quantity value for the Game
            if(foundConsole.getQuantity() == viewModel.getQuantity()){
                removeConsole = true;
            } else {

                quantityAvailable -= quantityBought; // now we can use quantity available variable to update the game
                foundConsole.setQuantity(quantityAvailable);
                //updating with new quantity
                consoleRepository.save(foundConsole);
            }











        } else if(viewModel.getItemType().equals("T-Shirt")){
            //If it is a T-Shirt then we use the T-shirt Repository to check if the id provided is in one of our items inside the repo
            Optional<Tshirt> tshirt = tShirtRepository.findById(viewModel.getItemId()); // this Optional returns -> True or False
            if(!tshirt.isPresent()){
                throw new IllegalArgumentException("There is no item in the T-Shirt section attached to Item ID: " + viewModel.getItemId());
            }

            //Now that we know that the id is present in the  repository
            // we can start checking if the quantity in "inventory" is sufficient

            ////Getting the actual Game Object in order to check the quantity

            //initialize variable that will store the Object of the Game(This will not be null since we already checked that is inside the repository)
            Tshirt foundTshirt = null;

            //Getting by id but using for loop
            for(Tshirt itemTshirt : tShirtRepository.findAll()){
                if(itemTshirt.gettShirtId() == viewModel.getItemId()){
                    foundTshirt = itemTshirt;
                    break;
                }
            }

            //If the quantity of our object found is less than what customer is buying
            if(foundTshirt.getQuantity() < viewModel.getQuantity()){
                //then throw error
                throw new IllegalArgumentException("There is an insufficient quantity of items. There are only: " + foundTshirt.getQuantity() + " available.");
            }
            // Now remove Games depending on how many the user bought
            Integer quantityBought = viewModel.getQuantity();
            Integer quantityAvailable = foundTshirt.getQuantity();

            //new quantity value for the Game
            if(foundTshirt.getQuantity() < viewModel.getQuantity()){
                removeTshirt = true;
            } else {

                quantityAvailable -= quantityBought; // now we can use quantity available variable to update the game
                foundTshirt.setQuantity(quantityAvailable);
                //updating with new quantity
                tShirtRepository.save(foundTshirt);
            }



        }




        // Calculate the unit price, subtotal, tax, processing fee, and total (MATH and cheking tables from databasde)
        // System.out.println("Ahora vamos a caluclar numeros");
        BigDecimal unitPrice;
        // Retrieve the item price based on the item type
        if (viewModel.getItemType().equals("Game")) {
            Optional<Game> game = gameRepository.findById(viewModel.getItemId());
            if (!game.isPresent()) {
                throw new IllegalArgumentException("Invalid game id: " + viewModel.getItemId());
            }
            unitPrice = game.get().getPrice();
        } else if (viewModel.getItemType().equals("Console")) {
            Optional<Console> console = consoleRepository.findById(viewModel.getItemId());
            if (!console.isPresent()) {
                throw new IllegalArgumentException("Invalid console id: " + viewModel.getItemId());
            }
            unitPrice = console.get().getPrice();
        } else if (viewModel.getItemType().equals("T-Shirt")) {
            Optional<Tshirt> tshirt = tShirtRepository.findById(viewModel.getItemId());
            if (!tshirt.isPresent()) {
                throw new IllegalArgumentException("Invalid T-Shirt id: " + viewModel.getItemId());
            }
            unitPrice = tshirt.get().getPrice();
        } else {
            throw new IllegalArgumentException("Invalid item type: " + viewModel.getItemType());
        }

        // Calculate subtotal
        BigDecimal subtotal = unitPrice.multiply(new BigDecimal(viewModel.getQuantity()));

        // Calculate tax
        Optional<Tax> stateTax = taxRepository.findByState(viewModel.getState());
        if (!stateTax.isPresent()) {
            throw new IllegalArgumentException("Invalid state: " + viewModel.getState());
        }

        BigDecimal taxGettingRate = stateTax.get().getRate();
        BigDecimal tax = subtotal.multiply(taxGettingRate);


        // Calculate processing fee
        Optional<Fee> itemTypeFee = feeRepository.findById(viewModel.getItemType());
        if (!itemTypeFee.isPresent()) {
            throw new IllegalArgumentException("Processing fee not found for item type: " + viewModel.getItemType());
        }
        BigDecimal processingFee = BigDecimal.valueOf(itemTypeFee.get().getFee());

        System.out.println("Puede que aca comienza el error");
        if (viewModel.getQuantity() > 10) {
            processingFee = processingFee.add(new BigDecimal("15.49"));
        }

        // Calculate total
        BigDecimal total = subtotal.add(tax).add(processingFee);


        System.out.println("ViewModel: " + viewModel);

        System.out.println("Unit Price: " + unitPrice);
        viewModel.setUnitPrice(unitPrice);
        System.out.println("Subtotal: " + subtotal);
        viewModel.setSubtotal(subtotal);
        System.out.println("Tax: " + tax);
        viewModel.setTax(tax);
        System.out.println("Processing Fee: " + processingFee);
        viewModel.setProcessingFee(processingFee);
        System.out.println("Total: " + total);
        viewModel.setTotal(total);




        //Assigning all the attributes to the InvoiceViewModel
        //Creating an instance of the view model that we are giving to the user
        Invoice userInvoice = new Invoice();
        userInvoice.setId(viewModel.getId());
        userInvoice.setName(viewModel.getName());
        userInvoice.setStreet(viewModel.getStreet());
        userInvoice.setCity(viewModel.getCity());
        userInvoice.setState(viewModel.getState());
        userInvoice.setZipcode(viewModel.getZipcode());
        userInvoice.setItemType(viewModel.getItemType());
        userInvoice.setItemId(viewModel.getItemId());
        userInvoice.setUnitPrice(viewModel.getUnitPrice());
        userInvoice.setQuantity(viewModel.getQuantity());
        userInvoice.setSubtotal(viewModel.getSubtotal());
        userInvoice.setTax(viewModel.getTax());
        userInvoice.setProcessingFee(viewModel.getProcessingFee());
        userInvoice.setTotal(viewModel.getTotal());

        //Saving our changes
        userInvoice = invoiceRepository.save(userInvoice);
        //Making this viewmodel point to our updated invoice
        viewModel.setId(userInvoice.getId());

        // Removing either Game, Console, or Tshirt if supply is down to 0.]
        if(removeGame){
            gameRepository.deleteById(foundGame.getGameId());
        }
        if(removeConsole){
            consoleRepository.deleteById(foundConsole.getConsoleId());
        }
        if(removeTshirt){
            tShirtRepository.deleteById(foundTShirt.gettShirtId());
        }

        return viewModel;







    }

    public Invoice findInvoice(int id){
        Optional<Invoice> invoice = invoiceRepository.findById(id);

        return invoice.isPresent() ? invoice.get() : null;
    }

    public List<Invoice> getAllInvoices(){
        return invoiceRepository.findAll();
    }

    public List<Invoice> getAllInvoicesByCustomerName(String name){
        String cleanedName= name.replaceAll("\"", ""); // remove all quotes from title
        return invoiceRepository.findByName(cleanedName);
    }

    //
    // TSHIRT API
    //

    public Tshirt saveTshirt(Tshirt tshirt){

        return tShirtRepository.save(tshirt);
    }

    public Tshirt findTshirt(int id){
        Optional<Tshirt> tshirt = tShirtRepository.findById(id);

        return tshirt.isPresent() ? tshirt.get() : null;
    }

    public List<Tshirt> getAllTshirts(){
        return tShirtRepository.findAll();
    }

    public void updateTshirt(Tshirt tshirt){
        tShirtRepository.save(tshirt);
    }

    public void deleteTshirt(int id){
        tShirtRepository.deleteById(id);
    }

    public List<Tshirt> getAllTshirtsByColor(String color){
        String cleanedColor = color.replaceAll("\"", ""); // remove all quotes from title
        return tShirtRepository.findAllByColor(cleanedColor);
    }

    public List<Tshirt> getAllTshirtBySize(String size){
        String cleanedSize = size.replaceAll("\"", ""); // remove all quotes from title
        return tShirtRepository.findAllBySize(cleanedSize);
    }

}
