package com.endava.RestApiCrudTask.daos;


import com.endava.RestApiCrudTask.entities.Billionaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillionaireDAO extends JpaRepository<Billionaire, Long> {

}
