package org.example.quickclothdata.payload.request;

import lombok.*;
import org.example.quickclothdata.model.Foundation;
import org.example.quickclothdata.model.User;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FoundationEmployeeRequest {
    private UUID uuid;
    private Foundation foundation;
    private User user;
}
