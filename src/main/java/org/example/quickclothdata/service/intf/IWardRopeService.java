package org.example.quickclothdata.service.intf;

import org.example.quickclothdata.model.*;
import org.example.quickclothdata.payload.request.OrderRequest;
import org.example.quickclothdata.payload.request.SaleRequest;

import java.util.List;
import java.util.UUID;

public interface IWardRopeService {
    Wardrope saveWardRope(Wardrope wardrope);
    Wardrope updateWardRope(Wardrope wardrope);
    Wardrope findWardRopeByUuid(UUID uuid);
    List<Wardrope> finAllWardRopeByClotheBankUuid(UUID clotheBankUuid);
    List<Inventory> findInventoriesByWardRopeUuid(UUID wardRopeUuid);
    List<Inventory> saveInventories(List<Inventory> inventories);
    Inventory updateInventory(Inventory inventory);
    Sale saveSale(SaleRequest sale);
    List<Sale> findSalesByWardRopeUuid(UUID wardRopeUuid);
    List<SaleList> findSaleListsBySaleUuid(UUID saleUuid);
    Order saveOrder(OrderRequest order);
}
