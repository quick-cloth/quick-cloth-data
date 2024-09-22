package org.example.quickclothdata.service.impl;

import org.example.quickclothdata.model.*;
import org.example.quickclothdata.payload.request.OrderRequest;
import org.example.quickclothdata.payload.request.SaleRequest;
import org.example.quickclothdata.repositoty.*;
import org.example.quickclothdata.service.intf.IWardRobeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class WardRobeService implements IWardRobeService {
    private final IWardRobeRepository wardRopeRepository;
    private final IInventoryRepository inventoryRepository;
    private final ISaleRepository saleRepository;
    private final ISaleListRepository saleListRepository;
    private final IOrderRepository orderRepository;
    private final IOrderListRepository orderListRepository;
    private final IOrderStateRepository orderStateRepository;
    private final IUserRepository userRepository;

    public WardRobeService(IWardRobeRepository wardRopeRepository1, IInventoryRepository inventoryRepository, ISaleRepository saleRepository, ISaleListRepository saleListRepository, IOrderRepository orderRepository, IOrderListRepository orderListRepository, IOrderStateRepository orderStateRepository, IUserRepository userRepository) {
        this.wardRopeRepository = wardRopeRepository1;
        this.inventoryRepository = inventoryRepository;
        this.saleRepository = saleRepository;
        this.saleListRepository = saleListRepository;
        this.orderRepository = orderRepository;
        this.orderListRepository = orderListRepository;
        this.orderStateRepository = orderStateRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Wardrobe saveWardRope(Wardrobe wardrope) {
        return wardRopeRepository.save(wardrope);
    }

    @Override
    public Wardrobe updateWardRope(Wardrobe wardrope) {
        return wardRopeRepository.save(wardrope);
    }

    @Override
    public Wardrobe findWardRopeByUuid(UUID uuid) {
        return wardRopeRepository.findById(uuid).orElse(null);
    }

    @Override
    public List<Wardrobe> finAllWardRopeByClotheBankUuid(UUID clotheBankUuid) {
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

    @Override
    public Inventory findInventoryByUuid(UUID clotheUuid, UUID wardRopeUuid) {
        return inventoryRepository.findByClotheAndWardrope(clotheUuid, wardRopeUuid);
    }

    @Transactional
    @Override
    public Sale saveSale(SaleRequest sale) {
        List<Inventory> newInventory = new ArrayList<>();

        Sale newSale = saleRepository.save(sale.getSale());
        newSale.setUser(userRepository.save(sale.getSale().getUser()));
        sale.getSaleListRequests().forEach(saleList -> saleList.setSale(newSale));
        saleListRepository.saveAll(sale.getSaleListRequests());

        for (SaleList saleList : sale.getSaleListRequests()) {
            Inventory i = inventoryRepository.findByClotheAndWardrope(saleList.getClothe().getUuid(), sale.getSale().getWardrobe().getUuid());
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

    @Override
    public OrderState findOrderStateByName(String orderName) {
        return orderStateRepository.findOrderStateByName(orderName);
    }
}
