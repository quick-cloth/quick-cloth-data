package org.example.quickclothdata.payload.request;

import lombok.*;
import org.example.quickclothdata.model.ClotheBank;
import org.example.quickclothdata.model.User;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BankEmployeeRequest {
    private UUID uuid;
    private ClotheBank clotheBank;
    private User user;
}
