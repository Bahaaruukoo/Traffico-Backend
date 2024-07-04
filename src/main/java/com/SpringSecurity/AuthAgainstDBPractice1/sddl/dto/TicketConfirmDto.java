package com.SpringSecurity.AuthAgainstDBPractice1.sddl.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketConfirmDto {
    String referenceNumber;
    String licenseNumber;
    String chargeCode;
}
