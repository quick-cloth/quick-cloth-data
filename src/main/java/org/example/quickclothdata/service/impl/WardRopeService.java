package org.example.quickclothdata.service.impl;

import org.example.quickclothdata.model.*;
import org.example.quickclothdata.payload.request.OrderRequest;
import org.example.quickclothdata.payload.request.SaleRequest;
import org.example.quickclothdata.repositoty.*;
import org.example.quickclothdata.service.intf.IWardRopeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class WardRopeService implements IWardRopeService {
    private final IWardRopeRepository wardRopeRepository;
    private final IInventoryRepository inventoryRepository;
    private final ISaleRepository saleRepository;
    private final ISaleListRepository saleListRepository;
    private final IOrderRepository orderRepository;
    private final IOrderListRepository orderListRepository;

    public WardRopeService(IWardRopeRepository wardRopeRepository1, IInventoryRepository inventoryRepository, ISaleRepository saleRepository, ISaleListRepository saleListRepository, IOrderRepository orderRepository, IOrderListRepository orderListRepository) {
        this.wardRopeRepository = wardRopeRepository1;
        this.inventoryRepository = inventoryRepository;
        this.saleRepository = saleRepository;
        this.saleListRepository = saleListRepository;
        this.orderRepository = orderRepository;
        this.orderListRepository = orderListRepository;
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
        List<Inventory> newInventory = new ArrayList<>();

        Sale newSale = saleRepository.save(sale.getSale());
        sale.getSaleListRequests().forEach(saleList -> saleList.setSale(newSale));
        saleListRepository.saveAll(sale.getSaleListRequests());

        for (SaleList saleList : sale.getSaleListRequests()) {
            Inventory i = inventoryRepository.findByClotheAndWardrope(saleList.getClothe().getUuid(), sale.getSale().getWardrope().getUuid());
            i.setStock(i.getStock() - saleList.getQuantity());
            newInventory.add(i);
        }

        inventoryRepository.saveAll(newInventory);

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

    @Transactional
    @Override
    public Order saveOrder(OrderRequest order) {
        Order newOrder = orderRepository.save(order.getOrder());
        order.getOrderList().forEach(orderList -> orderList.setOrder(newOrder));

        orderListRepository.saveAll(order.getOrderList());
        return newOrder;
    }
}
