package org.example.quickclothdata.payload.request;

import lombok.*;
import org.example.quickclothdata.model.User;
import org.example.quickclothdata.model.Wardrope;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WardropeEmployeeRequest {
    private UUID uuid;
    private Wardrope wardrope;
    private User user;
}
