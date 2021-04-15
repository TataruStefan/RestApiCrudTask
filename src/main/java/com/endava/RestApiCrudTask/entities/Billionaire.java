package com.endava.RestApiCrudTask.entities;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "billionaires")
@NoArgsConstructor
@Data
public class Billionaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String career;

    public Billionaire(BillionaireDTO billionaireDTO){
        this.firstName= billionaireDTO.getFirstName();
        this.lastName= billionaireDTO.getLastName();
        this.career= billionaireDTO.getCareer();
    }
}
