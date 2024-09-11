package org.example.quickclothdata.service.impl;

import org.example.quickclothdata.model.Inventory;
import org.example.quickclothdata.model.Sale;
import org.example.quickclothdata.model.SaleList;
import org.example.quickclothdata.model.Wardrope;
import org.example.quickclothdata.payload.request.SaleRequest;
import org.example.quickclothdata.repositoty.IInventoryRepository;
import org.example.quickclothdata.repositoty.ISaleListRepository;
import org.example.quickclothdata.repositoty.ISaleRepository;
import org.example.quickclothdata.repositoty.IWardRopeRepository;
import org.example.quickclothdata.service.intf.IWardRopeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class WardRopeService implements IWardRopeService {
    private final IWardRopeRepository wardRopeRepository;
    private final IInventoryRepository inventoryRepository;
    private final ISaleRepository saleRepository;
    private final ISaleListRepository saleListRepository;

    public WardRopeService(IWardRopeRepository wardRopeRepository1, IInventoryRepository inventoryRepository, ISaleRepository saleRepository, ISaleListRepository saleListRepository) {
        this.wardRopeRepository = wardRopeRepository1;
        this.inventoryRepository = inventoryRepository;
        this.saleRepository = saleRepository;
        this.saleListRepository = saleListRepository;
    }

    @Override
    public Wardrope saveWardRope(Wardrope wardrope) {
        return wardRopeRepository.save(wardrope);
    }

    @Override
    public Wardrope updateWardRope(Wardrope wardrope) {
        return wardRopeRepository.save(wardrope);
    }

    @Override
    public Wardrope findWardRopeByUuid(UUID uuid) {
        return wardRopeRepository.findById(uuid).orElse(null);
    }

    @Override
    public List<Wardrope> finAllWardRopeByClotheBankUuid(UUID clotheBankUuid) {
        return wardRopeRepository.findAllByClotheBankUuid(clotheBankUuid);
    }

    @Override
    public List<Inventory> findInventoriesByWardRopeUuid(UUID wardRopeUuid) {
        return inventoryRepository.findAllByWardRopeUuid(wardRopeUuid);
    }

    @Override
    public List<Inventory> saveInventories(List<Inventory> inventories) {
        return inventoryRepository.saveAll(inventories);
    }

    @Override
    public Inventory updateInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Transactional
    @Override
    public Sale saveSale(SaleRequest sale) {
        Sale newSale = saleRepository.save(sale.getSale());
        sale.getSaleListRequests().forEach(saleList -> saleList.setSale(newSale));
        saleListRepository.saveAll(sale.getSaleListRequests());
        return newSale;
    }

    @Override
    public List<Sale> findSalesByWardRopeUuid(UUID wardRopeUuid) {
        return saleRepository.findAllByWardRopeUuid(wardRopeUuid);
    }

    @Override
    public List<SaleList> findSaleListsBySaleUuid(UUID saleUuid) {
        return saleListRepository.findAllBySaleUuid(saleUuid);
    }
}
