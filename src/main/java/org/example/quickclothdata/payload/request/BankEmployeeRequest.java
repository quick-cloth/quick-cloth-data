package org.example.quickclothdata.payload.request;

import lombok.*;
import org.example.quickclothdata.model.ClotheBank;
import org.example.quickclothdata.model.User;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BankEmployeeRequest {
    ClotheBank clotheBank;
    User user;
}
