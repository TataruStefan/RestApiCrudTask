package com.endava.RestApiCrudTask.controllers;

import com.endava.RestApiCrudTask.entities.BillionaireDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.endava.RestApiCrudTask.services.BillionaireService;

import static org.springframework.http.HttpStatus.*;

@Data
@AllArgsConstructor
@RestController
@RequestMapping("/rest/billionaires")
public class RestBillionaire {


    private final BillionaireService billionaireService;
    //private final ExceptionsHandler exceptionsHandler;

    @GetMapping("/")
    public ResponseEntity<Object> billionaires(@RequestParam(required = false) Long limit) throws Exception {
        try {
            return new ResponseEntity<>(billionaireService.getBillionaires(), OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), BAD_REQUEST);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Object> add(@RequestBody BillionaireDTO billionaireDTO) throws Exception {
        try {
            billionaireService.addBillionaire(billionaireDTO);
            return new ResponseEntity<>("All good, billionaire saved", CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> remove(@PathVariable("id") String id) {
        try {
            billionaireService.removeBillionaire(Long.parseLong(id));
            return new ResponseEntity<>("Billionaire deleted", OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getBillionaireDetails(@PathVariable Long id) throws Exception {
        try {
            return new ResponseEntity<>(billionaireService.getOneBillionaire(id), OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateBillionaireDetails(@PathVariable Long id, @RequestBody BillionaireDTO billionaireDTO) throws Exception {
        try {
            billionaireDTO.setId(id);
            billionaireService.updateBillionaire(billionaireDTO);
            return new ResponseEntity<>("Billionaire updated successfully", OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), BAD_REQUEST);
        }
    }
}

