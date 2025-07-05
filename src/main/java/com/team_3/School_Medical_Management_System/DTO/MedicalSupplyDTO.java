package com.team_3.School_Medical_Management_System.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MedicalSupplyDTO {
    @NotBlank(message = "Name Not allow empty")
    private String Name;
    
    @NotBlank(message = "Description Not allow empty")
    private String Description;
    
    @NotNull(message = "Quantity is required")
    private int Quantity;
    
    private String Unit;
    private double Price;
}