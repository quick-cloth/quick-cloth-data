package org.example.quickclothdata.service.intf;

import org.example.quickclothdata.model.*;
import org.example.quickclothdata.payload.request.CreateMinimumStockRequest;
import org.example.quickclothdata.payload.request.OrderRequest;
import org.example.quickclothdata.payload.request.SaleRequest;
import org.example.quickclothdata.payload.response.CreateMinimumStockResponse;
import org.example.quickclothdata.payload.response.CustomerProjection;
import org.example.quickclothdata.payload.response.MinimumStockProjection;
import org.example.quickclothdata.payload.response.TopSellingClothesProjection;

import java.util.List;
import java.util.UUID;

public interface IWardRobeService {
    Wardrobe saveWardRope(Wardrobe wardrope);
    Wardrobe updateWardRope(Wardrobe wardrope);
    Wardrobe findWardRopeByUuid(UUID uuid);
    List<Wardrobe> finAllWardRopeByClotheBankUuid(UUID clotheBankUuid);
    List<Inventory> findInventoriesByWardRopeUuid(UUID wardRopeUuid);
    List<Inventory> saveInventories(List<Inventory> inventories);
    Inventory updateInventory(Inventory inventory);
    Inventory findInventoryByUuid(UUID clotheUuid, UUID wardRopeUuid);
    Sale saveSale(SaleRequest sale);
    List<Sale> findSalesByWardRopeUuid(UUID wardRopeUuid);
    List<SaleList> findSaleListsBySaleUuid(UUID saleUuid);
    Order saveOrder(OrderRequest order);
    OrderState findOrderStateByName(String orderName);
    List<OrderState> findAllOrderStates();
    Order confirmOrder(OrderRequest order, UUID orderUuid);
    List<Order> findOrdersByWardRobeUuid(UUID wardRopeUuid);
    SendEmail saveSendEmail(SendEmail sendEmail);
    List<TopSellingClothesProjection> getTopSellingClothes(UUID wardRopeUuid);
    List<CustomerProjection> findCustomersByWardrobeAndClothes(UUID wardrobeUuid, List<UUID> clotheUuids);
    List<MinimumStockProjection> getMinimumStocks(UUID wardrobeUuid);
    List<CreateMinimumStockResponse> saveMinimumStock(List<CreateMinimumStockRequest> minimumStocksRequest);
}
