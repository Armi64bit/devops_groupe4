package tn.esprit.devopsproject.services.Iservices;

import tn.esprit.devopsproject.entities.Stock;

import java.util.List;

public interface IStockService {

    Stock addStock(Stock stock);
    Stock retrieveStock(Long id);
    List<Stock> retrieveAllStock();

}
