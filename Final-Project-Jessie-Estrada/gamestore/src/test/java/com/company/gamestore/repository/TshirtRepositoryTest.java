package com.company.gamestore.repository;

import com.company.gamestore.model.Invoice;
import com.company.gamestore.model.Tshirt;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TshirtRepositoryTest {

    @Autowired TshirtRepository tshirtRepository;

    @Before
    public void setUp() throws Exception {
        tshirtRepository.deleteAll();
    }

    //    {
//        "tShirtId": 3,
//            "size": "L",
//            "color": "Blue",
//            "description": "A comfortable and stylish T-shirt for everyday wear",
//            "price": 19.99,
//            "quantity": 20
//    }

    @Test
    public void addGetDeleteTShirts(){

        //Add
        Tshirt tshirt = new Tshirt();
        tshirt.setSize("L");
        tshirt.setColor("Blue");
        tshirt.setDescription("A comfortable and stylish T-shirt for everyday wear");
        tshirt.setPrice(new BigDecimal("19.99"));
        tshirt.setQuantity(20);

        tshirt = tshirtRepository.save(tshirt);

        //Get
        Optional<Tshirt> tshirt1 = tshirtRepository.findById(tshirt.gettShirtId());

        assertEquals(tshirt1.get(),tshirt);

        //Delete
        tshirtRepository.deleteById(tshirt.gettShirtId());

        tshirt1 = tshirtRepository.findById(tshirt.gettShirtId());

        assertFalse(tshirt1.isPresent());
    }

    @Test
    public void getAllTshirts(){
        //Add
        Tshirt tshirt = new Tshirt();
        tshirt.setSize("L");
        tshirt.setColor("Blue");
        tshirt.setDescription("A comfortable and stylish T-shirt for everyday wear");
        tshirt.setPrice(new BigDecimal("19.99"));
        tshirt.setQuantity(20);

        tshirt = tshirtRepository.save(tshirt);

        //Second T Shirt
        Tshirt tshirt2 = new Tshirt();
        tshirt2.setSize("M");
        tshirt2.setColor("Red");
        tshirt2.setDescription("A vibrant T-shirt that stands out from the crowd");
        tshirt2.setPrice(new BigDecimal("24.99"));
        tshirt2.setQuantity(15);

        tshirt2 = tshirtRepository.save(tshirt2);


        List<Tshirt> tshirtList = tshirtRepository.findAll();

        assertEquals(tshirtList.size(), 2);

    }

    @Test
    public void updateTshirt(){
        //Add
        Tshirt tshirt = new Tshirt();
        tshirt.setSize("L");
        tshirt.setColor("Blue");
        tshirt.setDescription("A comfortable and stylish T-shirt for everyday wear");
        tshirt.setPrice(new BigDecimal("19.99"));
        tshirt.setQuantity(20);

        tshirt = tshirtRepository.save(tshirt);

        //Update
        tshirt.setColor("Red");
        tshirt.setDescription("A vibrant T-shirt that stands out from the crowd");

        tshirtRepository.save(tshirt);


        Optional<Tshirt> tshirt1 = tshirtRepository.findById(tshirt.gettShirtId());
        assertEquals(tshirt1.get(),tshirt);
    }
}