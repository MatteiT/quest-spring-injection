package com.wildcodeschool.wildandwizard.repository;

import com.wildcodeschool.wildandwizard.entity.Wizard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Repository
public class WizardRepository implements WizardDao {
    private final List<Wizard> wizards;

    @Autowired
    public WizardRepository(List<Wizard> wizards) {
        this.wizards = wizards;
    }

    @Override
    public Wizard save(Wizard wizard) {

        wizard.setId((long) (wizards.size() + 1));
        wizards.add(wizard);
        return wizard;
    }



    @Override
    public Wizard findById(Long id) {

        for (Wizard wizard : wizards) {
            if (wizard.getId().equals(id)) {
                return wizard;
            }
        }
        return null;
    }

    @Override
    public List<Wizard> findAll() {

        return wizards;
    }

    @Override
    public Wizard update(Wizard wizard) {

        for (Wizard update : wizards) {
            if (update.getId().equals(wizard.getId())) {
                update.setFirstName(wizard.getFirstName());
                update.setLastName(wizard.getLastName());
                update.setBirthday(wizard.getBirthday());
                update.setBirthPlace(wizard.getBirthPlace());
                update.setBiography(wizard.getBiography());
                update.setMuggle(wizard.isMuggle());

                return update;
            }
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {

        for (Wizard wizard : wizards) {
            if (wizard.getId().equals(id)) {
                wizards.remove(wizard);
                break;
            }
        }
    }
}
