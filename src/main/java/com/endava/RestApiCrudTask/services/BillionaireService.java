package com.endava.RestApiCrudTask.services;

import com.endava.RestApiCrudTask.daos.BillionaireDAO;
import com.endava.RestApiCrudTask.entities.Billionaire;
import com.endava.RestApiCrudTask.entities.BillionaireDTO;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class BillionaireService {
    private final BillionaireDAO billionaireDAO;

    public List<BillionaireDTO> getBillionaires() {
        List<BillionaireDTO> billionaireDTOS = new ArrayList<>();
        List<Billionaire> billionaires = billionaireDAO.findAll();

        for (Billionaire billionaire : billionaires) {
            billionaireDTOS.add(new BillionaireDTO(billionaire));
        }
        return billionaireDTOS;
    }

    public void addBillionaire(BillionaireDTO billionaireDTO) throws Exception {
        try {
            billionaireDAO.save(new Billionaire(billionaireDTO));
        } catch (Exception e) {
            throw new Exception("The billionaire could not be saved");
        }
    }

    public void removeBillionaire(Long id) throws Exception {
        try {
            billionaireDAO.deleteById(id);
        } catch (Exception e) {
            throw new Exception("The billionaire could not be deleted");
        }
    }

    public void updateBillionaire(BillionaireDTO billionaireDTO) throws Exception {
        Optional<Billionaire> optionalBillionaire = billionaireDAO.findById(billionaireDTO.getId());

        Billionaire toBeUpdated = optionalBillionaire.get();
        toBeUpdated.setFirstName(billionaireDTO.getFirstName());
        toBeUpdated.setLastName(billionaireDTO.getLastName());
        toBeUpdated.setCareer(billionaireDTO.getCareer());
        try {
            billionaireDAO.save(toBeUpdated);
        } catch (Exception e) {
            throw new Exception("The billionaire could not be saved");
        }
    }

    public BillionaireDTO getOneBillionaire(Long id) throws Exception {
        Optional<Billionaire> optionalBillionaire = billionaireDAO.findById(id);
        if (optionalBillionaire.isPresent()) {
            return new BillionaireDTO(optionalBillionaire.get());
        }
        throw new Exception("The billionaire could not be found");
    }
}
