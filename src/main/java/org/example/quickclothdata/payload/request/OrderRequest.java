package org.example.quickclothdata.payload.request;

import lombok.*;
import org.example.quickclothdata.model.Order;
import org.example.quickclothdata.model.OrderList;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderRequest {
    Order order;
    List<OrderList> orderList;
}
