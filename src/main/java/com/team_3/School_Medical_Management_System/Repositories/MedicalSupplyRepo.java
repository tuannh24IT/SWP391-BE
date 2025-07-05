package com.team_3.School_Medical_Management_System.Repositories;

import com.team_3.School_Medical_Management_System.DTO.MedicalSupplyDTO;
import com.team_3.School_Medical_Management_System.InterfaceRepo.MedicalSupplyInterFace;
import com.team_3.School_Medical_Management_System.Model.MedicalSupply;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MedicalSupplyRepo implements MedicalSupplyInterFace {
    private EntityManager entityManager;

    @Autowired
    public MedicalSupplyRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addMedicalSupply(MedicalSupply medicalSupply) {
        entityManager.persist(medicalSupply);
    }

    @Override
    public void removeMedicalSupply(int id) {
        MedicalSupply medicalSupply = entityManager.find(MedicalSupply.class, id);
        if (medicalSupply != null) {
            entityManager.remove(medicalSupply);
        }
    }

    @Override
    public MedicalSupply getMedicalSupply(int id) {
        return entityManager.find(MedicalSupply.class, id);
    }

    @Override
    public List<MedicalSupply> getAllMedicalSupply() {
        String sql = "select ms from MedicalSupply ms";
        return entityManager.createQuery(sql, MedicalSupply.class).getResultList();
    }

    @Override
    public MedicalSupply updateMedicalSupply(MedicalSupplyDTO medicalSupplyDTO) {
        // This method should typically receive an ID to update existing entity
        // For now, creating a basic implementation
        MedicalSupply medicalSupply = new MedicalSupply();
        medicalSupply.setName(medicalSupplyDTO.getName());
        medicalSupply.setDescription(medicalSupplyDTO.getDescription());
        medicalSupply.setQuantity(medicalSupplyDTO.getQuantity());
        medicalSupply.setUnit(medicalSupplyDTO.getUnit());
        medicalSupply.setPrice(medicalSupplyDTO.getPrice());
        return entityManager.merge(medicalSupply);
    }
}