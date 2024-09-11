package org.example.quickclothdata.payload.request;

import lombok.*;
import org.example.quickclothdata.model.Foundation;
import org.example.quickclothdata.model.User;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FoundationEmployeeRequest {
    Foundation foundation;
    User user;
}
