package com.team_3.School_Medical_Management_System.InterfaceRepo;

import com.team_3.School_Medical_Management_System.DTO.MedicalSupplyDTO;
import com.team_3.School_Medical_Management_System.Model.MedicalSupply;

import java.util.List;

public interface MedicalSupplyInterFace {
    public void addMedicalSupply(MedicalSupply medicalSupply);
    public void removeMedicalSupply(int id);
    public MedicalSupply getMedicalSupply(int id);
    public List<MedicalSupply> getAllMedicalSupply();
    public MedicalSupply updateMedicalSupply(MedicalSupplyDTO medicalSupplyDTO);
}