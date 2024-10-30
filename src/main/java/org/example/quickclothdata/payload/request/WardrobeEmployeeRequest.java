package org.example.quickclothdata.payload.request;

import lombok.*;
import org.example.quickclothdata.model.User;
import org.example.quickclothdata.model.Wardrobe;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WardrobeEmployeeRequest {
    private UUID uuid;
    private Wardrobe wardrope;
    private User user;
}
