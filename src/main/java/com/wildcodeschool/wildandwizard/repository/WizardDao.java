package com.wildcodeschool.wildandwizard.repository;

import com.wildcodeschool.wildandwizard.entity.Wizard;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WizardDao  {

    Wizard save(Wizard entity);

    Wizard findById(Long id);

    List<Wizard> findAll();

    Wizard update(Wizard entity);

    void deleteById(Long id);
}