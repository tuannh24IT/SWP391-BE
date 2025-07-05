package com.team_3.School_Medical_Management_System.Service;

import com.team_3.School_Medical_Management_System.DTO.MedicalSupplyDTO;
import com.team_3.School_Medical_Management_System.InterFaceSerivceInterFace.MedicalSupplyServiceInterFace;
import com.team_3.School_Medical_Management_System.InterfaceRepo.MedicalSupplyInterFace;
import com.team_3.School_Medical_Management_System.Model.MedicalSupply;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class MedicalSupplyService implements MedicalSupplyServiceInterFace {
    private MedicalSupplyInterFace medicalSupplyInterFace;

    @Autowired
    public MedicalSupplyService(MedicalSupplyInterFace medicalSupplyInterFace) {
        this.medicalSupplyInterFace = medicalSupplyInterFace;
    }

    @Override
    public void addMedicalSupply(MedicalSupplyDTO medicalSupplyDTO) {
        if (medicalSupplyDTO.getName() == null || medicalSupplyDTO.getName().isEmpty()) {
            throw new RuntimeException("Medical supply name cannot be empty");
        }
        if (medicalSupplyDTO.getQuantity() < 0) {
            throw new RuntimeException("Medical supply quantity cannot be negative");
        }
        
        MedicalSupply medicalSupply = new MedicalSupply();
        medicalSupply.setName(medicalSupplyDTO.getName());
        medicalSupply.setDescription(medicalSupplyDTO.getDescription());
        medicalSupply.setQuantity(medicalSupplyDTO.getQuantity());
        medicalSupply.setUnit(medicalSupplyDTO.getUnit());
        medicalSupply.setPrice(medicalSupplyDTO.getPrice());
        medicalSupply.setIsActive(1); // Set as active by default
        
        medicalSupplyInterFace.addMedicalSupply(medicalSupply);
    }

    @Override
    public void removeMedicalSupply(int id) {
        var medicalSupply = getMedicalSupply(id);
        if (medicalSupply != null) {
            medicalSupplyInterFace.removeMedicalSupply(id);
        } else {
            throw new RuntimeException("Medical supply not found");
        }
    }

    @Override
    public MedicalSupply getMedicalSupply(int id) {
        return medicalSupplyInterFace.getMedicalSupply(id);
    }

    @Override
    public List<MedicalSupply> getAllMedicalSupply() {
        return medicalSupplyInterFace.getAllMedicalSupply();
    }

    @Override
    public MedicalSupply updateMedicalSupply(MedicalSupplyDTO medicalSupplyDTO) {
        if (medicalSupplyDTO.getName() == null || medicalSupplyDTO.getName().isEmpty()) {
            throw new RuntimeException("Medical supply name cannot be empty");
        }
        if (medicalSupplyDTO.getQuantity() < 0) {
            throw new RuntimeException("Medical supply quantity cannot be negative");
        }
        
        return medicalSupplyInterFace.updateMedicalSupply(medicalSupplyDTO);
    }
}