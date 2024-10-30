package org.example.quickclothdata.payload.request;

import lombok.*;
import org.example.quickclothdata.model.ContactUser;
import org.example.quickclothdata.model.Foundation;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FoundationRequest {
    private Foundation foundation;
    private ContactUser contactUser;
}
