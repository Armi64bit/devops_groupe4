package tn.esprit.devops_project.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.repositories.StockRepository;
import tn.esprit.devops_project.services.StockServiceImpl;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

 class StockServiceImplTest {

    @Mock
    private StockRepository stockRepository;

    @InjectMocks
    private StockServiceImpl stockService;

    @BeforeEach
     void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
     void addStock() {
        Stock stockToAdd = new Stock();
        stockToAdd.setIdStock(1);
        stockToAdd.setTitle("test");
        Stock expectedStock = new Stock();
        expectedStock.setIdStock(1);
        expectedStock.setTitle("test");
        when(stockRepository.save(stockToAdd)).thenReturn(expectedStock);
        Stock actualStock = stockService.addStock(stockToAdd);
        assertEquals(expectedStock, actualStock);
    }

    @Test
     void retrieveStock() {
        Long stockId = 1L; // Provide a valid stock id
        Stock expectedStock = new Stock(/* provide necessary arguments for expected Stock object */);
        when(stockRepository.findById(stockId)).thenReturn(java.util.Optional.of(expectedStock));
        Stock actualStock = stockService.retrieveStock(stockId);
        assertEquals(expectedStock, actualStock);
    }

    @Test
     void retrieveAllStock() {
        List<Stock> expectedStockList = new ArrayList<>();
        // Add some dummy stock objects to the expected list
        when(stockRepository.findAll()).thenReturn(expectedStockList);
        List<Stock> actualStockList = stockService.retrieveAllStock();
        assertEquals(expectedStockList, actualStockList);
    }
}
