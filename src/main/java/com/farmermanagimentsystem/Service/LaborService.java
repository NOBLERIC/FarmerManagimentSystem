package com.farmermanagimentsystem.Service;


import com.farmermanagimentsystem.Repository.LaborRepository;
import com.farmermanagimentsystem.Repository.Modal.Labor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class FarmerService {

    @Autowired
    private LaborRepository farmerRepository;

    public FarmerService(LaborRepository farmerRepository) {
        this.farmerRepository = farmerRepository;
    }

    //Save Labor
    public void saveLabor(Labor labor) {
        try {
            farmerRepository.save(labor);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //delete labor
    public void deleteLabor(String id) {
        try {
            Optional<Labor> foundLabor = farmerRepository.findById(id);
            if (foundLabor.isPresent()) {
                Labor labor = foundLabor.get();
                farmerRepository.delete(labor);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //get labor by id
    public Optional<Labor> findLabour(String id) {
        try {
            return farmerRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //get All labors
    public List<Labor> getAllLabor() {
        try {
            return farmerRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Update Labor using 'name' attribute
    public void updateLabor(String id, Labor updatedLabor) {
        try {
            Optional<Labor> existingLaborOptional = farmerRepository.findById(id);

            if (existingLaborOptional.isPresent()) {
                Labor existingLabor = existingLaborOptional.get();

                // Update 'name' attribute with the new value
                existingLabor.setName(updatedLabor.getName());

                // Update other attributes if needed
                existingLabor.setPhone(updatedLabor.getPhone());
                existingLabor.setGender(updatedLabor.getGender());

                farmerRepository.save(existingLabor);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
