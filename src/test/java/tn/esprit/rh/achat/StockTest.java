package tn.esprit.rh.achat;

import org.junit.jupiter.api.Test;

import tn.esprit.rh.achat.entities.Stock;
import static org.junit.jupiter.api.Assertions.*;
import tn.esprit.rh.achat.services.*;

public class StockTest {

    /**
     * 
     */
    @Test
	public void testAddStock() {

        Stock s = new Stock("stock test",20,100);

        StockServiceImpl stockservice = new StockServiceImpl();

        try{
            Stock savedStock= stockservice.addStock(s);
		    assertNotNull(savedStock.getIdStock());
            stockservice.deleteStock(savedStock.getIdStock());
        }catch (Exception e) {
            System.out.println(e);
        }
    
		
    }

}
