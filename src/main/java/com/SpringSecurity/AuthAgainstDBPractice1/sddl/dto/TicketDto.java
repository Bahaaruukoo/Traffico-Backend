package com.SpringSecurity.AuthAgainstDBPractice1.sddl.dto;

import lombok.*;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketDto {
    private String referenceNumber;
    private String licenseNumber;
    private String chargeCode;
    private String chargeDate;
    private String chargeTime;
    private String officerId;
    //private int status;
}
