package org.example.quickclothdata.service.impl;

import org.example.quickclothdata.model.*;
import org.example.quickclothdata.payload.request.CreateMinimumStockRequest;
import org.example.quickclothdata.payload.request.OrderRequest;
import org.example.quickclothdata.payload.request.SaleRequest;
import org.example.quickclothdata.payload.response.CreateMinimumStockResponse;
import org.example.quickclothdata.payload.response.CustomerProjection;
import org.example.quickclothdata.payload.response.MinimumStockProjection;
import org.example.quickclothdata.payload.response.TopSellingClothesProjection;
import org.example.quickclothdata.repositoty.*;
import org.example.quickclothdata.service.intf.IWardRobeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
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
    private final ISendEmailRepository sendEmailRepository;

    public WardRobeService(IWardRobeRepository wardRopeRepository1, IInventoryRepository inventoryRepository, ISaleRepository saleRepository, ISaleListRepository saleListRepository, IOrderRepository orderRepository, IOrderListRepository orderListRepository, IOrderStateRepository orderStateRepository, IUserRepository userRepository, ISendEmailRepository sendEmailRepository) {
        this.wardRopeRepository = wardRopeRepository1;
        this.inventoryRepository = inventoryRepository;
        this.saleRepository = saleRepository;
        this.saleListRepository = saleListRepository;
        this.orderRepository = orderRepository;
        this.orderListRepository = orderListRepository;
        this.orderStateRepository = orderStateRepository;
        this.userRepository = userRepository;
        this.sendEmailRepository = sendEmailRepository;
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

    @Override
    public List<OrderState> findAllOrderStates() {
        return orderStateRepository.findAll();
    }

    @Transactional
    @Override
    public Order confirmOrder(OrderRequest order, UUID orderUuid) {
        List<Inventory> newInventory = new ArrayList<>();

        Order orderConfirm = orderRepository.save(order.getOrder());
        order.getOrderList().forEach(orderList -> orderList.setOrder(orderConfirm));

        List<OrderList> orderListsConfirm = orderListRepository.saveAll(order.getOrderList());

        for(OrderList orl : orderListsConfirm){
            Inventory i = inventoryRepository.findByClotheAndWardrope(orl.getClothe().getUuid(), order.getOrder().getWardrobe().getUuid());

            if (i == null){
                i = inventoryRepository.save(
                        Inventory.builder()
                                .uuid(UUID.randomUUID())
                                .clothe(orl.getClothe())
                                .minimum_stock(0)
                                .stock(orl.getDelivery_value())
                                .wardrobe(order.getOrder().getWardrobe())
                                .build()
                );
            }

            i.setStock(i.getStock() + orl.getDelivery_value());
            newInventory.add(i);
        }

        inventoryRepository.saveAll(newInventory);

        return orderConfirm;
    }

    @Override
    public List<Order> findOrdersByWardRobeUuid(UUID wardRopeUuid) {
        return orderRepository.findAllByWardRopeUuid(wardRopeUuid);
    }

    @Override
    public SendEmail saveSendEmail(SendEmail sendEmail) {
        return sendEmailRepository.save(sendEmail);
    }

    @Override
    public List<TopSellingClothesProjection> getTopSellingClothes(UUID wardrobeUuid, LocalDate startDate, LocalDate endDate) {

        // If the dates are not provided, return the top selling clothes of the last week
        if(startDate == null || endDate == null){
            endDate = LocalDate.now();
            startDate = endDate.minusDays(7);
        }

        return wardRopeRepository.getTopSellingClothes(wardrobeUuid, startDate, endDate);
    }

    @Override
    public List<CustomerProjection> findCustomersByWardrobeAndClothes(UUID wardrobeUuid, List<UUID> clotheUuids) {
        return wardRopeRepository.findCustomersByWardrobeAndClothes(wardrobeUuid, clotheUuids);
    }
    
    @Override
    public List<MinimumStockProjection> getMinimumStocks(UUID wardrobeUuid) {
        return wardRopeRepository.findMinimumStocksByWardrobeUuid(wardrobeUuid);
    }
    
    @Override
    public List<CreateMinimumStockResponse> saveMinimumStock(List<CreateMinimumStockRequest> minimumStocksRequest) {
        
        List<UUID> inventoryUuids = new ArrayList<>();
        
        for(CreateMinimumStockRequest request : minimumStocksRequest){
            inventoryUuids.add(request.getInventoryUuid());
        }
        
        List<Inventory> inventories = inventoryRepository.findAllByUuids(inventoryUuids);
        
        for(Inventory i : inventories){
            i.setMinimum_stock(minimumStocksRequest.stream()
                    .filter(request -> request.getInventoryUuid().equals(i.getUuid()))
                    .findFirst()
                    .get()
                    .getMinimumStock());
        }

        
        inventoryRepository.saveAll(inventories);
        
        
        List<CreateMinimumStockResponse> response = new ArrayList<>();
        
        for(Inventory i : inventories){
            response.add(new CreateMinimumStockResponse(i.getUuid() ,i.getStock(), i.getMinimum_stock(), i.getWardrobe().getUuid(), i.getClothe()));
        }
        
        return  response;
    }

}
