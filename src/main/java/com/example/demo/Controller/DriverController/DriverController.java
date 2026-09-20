package com.example.demo.Controller.DriverController;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.demo.Service.DriverService;
import com.example.demo.dto.Driver.DriverRequest;
import com.example.demo.dto.Driver.DriverResponse;


@Controller
@RequestMapping("/drivers")
public class DriverController {

    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    // Afficher la liste des chauffeurs
    @GetMapping
    public String listDrivers(Model model) {

        List<DriverResponse> drivers = driverService.findAll();

        model.addAttribute("drivers", drivers);

        return "drivers/list";
    }

    // Afficher le formulaire de création
    @GetMapping("/new")
    public String showCreateForm(Model model) {

        model.addAttribute("driverRequest", new DriverRequest());

        return "drivers/create";
    }

    // Traiter le formulaire de création
    @PostMapping
    public String createDriver(
            @ModelAttribute DriverRequest request
    ) {

        driverService.create(request);

        return "redirect:/drivers";
    }

    // Afficher les informations d'un chauffeur
    @GetMapping("/{id}")
    public String showDriver(
            @PathVariable Long id,
            Model model
    ) {

        DriverResponse driver = driverService.findById(id);

        model.addAttribute("driver", driver);

        return "drivers/detail";
    }

    // Afficher le formulaire de modification
    @GetMapping("/{id}/edit")
    public String showEditForm(
            @PathVariable Long id,
            Model model
    ) {

        DriverResponse driver = driverService.findById(id);

        model.addAttribute("driver", driver);

        return "drivers/edit";
    }

    //Avoir les chauffeurs qui on une license valide
    @GetMapping("/valid-license")
    public String findDriversWithValidLicense(Model model) {
        List<DriverResponse> drivers = driverService.findDriversWithValidLicense();
        model.addAttribute("drivers", drivers);
        return "drivers/list";
    }
    
}