package com.wildcodeschool.wildandwizard.controller;

import com.wildcodeschool.wildandwizard.entity.Wizard;
import com.wildcodeschool.wildandwizard.repository.WizardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class WizardController implements WizardDao {
    private final WizardDao wizardDao;

    @Autowired
    public WizardController(@Qualifier("wizardRepository") WizardDao wizardDao) {
        this.wizardDao = wizardDao;
    }
    @GetMapping("/wizards")
    public String getAll(Model model) {

        model.addAttribute("wizards", wizardDao.findAll());

        return "wizards";
    }

    @GetMapping("/wizard")
    public String getWizard(Model model,
                            @RequestParam(required = false) Long id) {

        Wizard wizard = new Wizard();
        if (id != null) {
            wizard = wizardDao.findById(id);
        }
        model.addAttribute("wizard", wizard);

        return "wizard";
    }

    @PostMapping("/wizard")
    public String postWizard(@ModelAttribute Wizard wizard) {

        if (wizard.getId() != null) {
            wizardDao.update(wizard);
        } else {
            wizard = wizardDao.save(wizard);
        }
        return "redirect:/wizards";
    }

    @GetMapping("/wizard/delete")
    public String deleteWizard(@RequestParam Long id) {

        wizardDao.deleteById(id);

        return "redirect:/wizards";
    }

    @GetMapping("/")
    public String index() {

        return "redirect:/wizards";
    }

    @Override
    public Wizard update(Wizard entity) {
        return wizardDao.update(entity);
    }


    @Override
    public void deleteById(Long id) {

    }


    @Override
    public Wizard save(Wizard entity) {
        return null;
    }

    @Override
    public Wizard findById(Long id) {
        return null;
    }

    @Override
    public List<Wizard> findAll() {
        return null;
    }

}