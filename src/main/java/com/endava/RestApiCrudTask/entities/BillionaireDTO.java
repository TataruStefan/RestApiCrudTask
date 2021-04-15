package com.endava.RestApiCrudTask.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillionaireDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String career;

    public BillionaireDTO(Billionaire billionaire){
        this.id= billionaire.getId();
        this.firstName = billionaire.getFirstName();
        this.lastName = billionaire.getLastName();
        this.career = billionaire.getCareer();
    }
}
