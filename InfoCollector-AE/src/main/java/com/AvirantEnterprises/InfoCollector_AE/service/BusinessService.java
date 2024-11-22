package com.AvirantEnterprises.InfoCollector_AE.service;

import com.AvirantEnterprises.InfoCollector_AE.model.BusinessEntity;
import com.AvirantEnterprises.InfoCollector_AE.repository.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BusinessService {

    @Autowired
    private BusinessRepository businessRepository;

    // Save business form to the database
    public void saveBusiness(BusinessEntity businessEntity) {
        // Save to the repository
        businessRepository.save(businessEntity);
    }

    // Get all business forms submitted (for admin)
    public List<BusinessEntity> getAllBusinessForms() {
        return businessRepository.findAll();
    }

    // Get business forms for a specific user (for user dashboard)
    public List<BusinessEntity> getBusinessFormsForUser() {
        // For now, this can return all forms. You can add user filtering logic here.
        return businessRepository.findAll();
    }

    // Delete business form by ID (admin functionality)
    public void deleteBusiness(Long id) {
        businessRepository.deleteById(id);
    }
}
