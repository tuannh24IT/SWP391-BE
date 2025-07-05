package com.team_3.School_Medical_Management_System.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MedicalSupply {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int MedicalSupplyID;
    
    @NotBlank(message = "Name Not allow empty")
    private String Name;
    
    @NotBlank(message = "Description Not allow empty")
    private String Description;
    
    private int Quantity;
    private String Unit;
    private double Price;
    private int IsActive;
}