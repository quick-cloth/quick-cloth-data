package org.example.quickclothdata.payload.request;

import lombok.*;
import org.example.quickclothdata.model.Sale;
import org.example.quickclothdata.model.SaleList;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SaleRequest {
    Sale sale;
    List<SaleList> saleListRequests;
}
