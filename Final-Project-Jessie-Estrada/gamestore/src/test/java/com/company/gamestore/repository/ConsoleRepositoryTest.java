package com.company.gamestore.repository;

import com.company.gamestore.model.Console;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ConsoleRepositoryTest {

    @Autowired
    ConsoleRepository consoleRepository;

    @Before
    public void setUp() throws Exception{
        consoleRepository.deleteAll();
    }



    @Test
    public void addGetDeleteConsole(){


        //Add
        Console console = new Console();
        console.setModel("Nintendo Switch");
        console.setManufacturer("Nintendo");
        console.setMemoryAmount("1T");
        console.setProcessor("NVIDIA Custom Tegra processor");
        console.setPrice(new BigDecimal( "299.99"));
        console.setQuantity(100);

        console = consoleRepository.save(console);

        //Get
        Optional<Console> console1 = consoleRepository.findById(console.getConsoleId());
        assertEquals(console1.get(),console);

        //Delete
        consoleRepository.deleteById(console.getConsoleId());

        console1 = consoleRepository.findById(console.getConsoleId());

        assertFalse(console1.isPresent());

    }

    @Test
    public void getAllConsoles(){
        //Add
        Console console = new Console();
        console.setModel("Nintendo Switch");
        console.setManufacturer("Nintendo");
        console.setMemoryAmount("1T");
        console.setProcessor("NVIDIA Custom Tegra processor");
        console.setPrice(new BigDecimal( "299.99"));
        console.setQuantity(100);

        console = consoleRepository.save(console);

        //Second console:

        Console console2 = new Console();

        console2.setModel("PlayStation 5");
        console2.setManufacturer("Sony");
        console2.setMemoryAmount("825GB SSD");
        console2.setProcessor("AMD Zen 2, 8-core, up to 3.5 GHz");
        console2.setPrice(new BigDecimal("499.99"));
        console2.setQuantity(50);

        console2 = consoleRepository.save(console2);

        List<Console> consoleList = consoleRepository.findAll();
        assertEquals(consoleList.size(),2);

    }

    @Test
    public void updateConsole(){
        //Add
        Console console = new Console();
        console.setModel("Nintendo Switch");
        console.setManufacturer("Nintendo");
        console.setMemoryAmount("1T");
        console.setProcessor("NVIDIA Custom Tegra processor");
        console.setPrice(new BigDecimal( "299.99"));
        console.setQuantity(100);

        console = consoleRepository.save(console);

        //Update:
        console.setManufacturer("PlayStation 20");
        console.setMemoryAmount("100T");
        console.setQuantity(1);

        //updated!
        consoleRepository.save(console);

        Optional<Console> console1 = consoleRepository.findById(console.getConsoleId());
        assertEquals(console1.get(),console);
    }

}