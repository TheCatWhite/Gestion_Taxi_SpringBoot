package com.example.demo.Controller.Vehicule;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Service.VehiculeService;
import com.example.demo.dto.Vehicule.VehiculeReponse;
import com.example.demo.dto.Vehicule.VehiculeRequest;



@Controller
@RequestMapping("/vehicules")
public class VehiculeController {
    private final VehiculeService vehiculeService;
    public VehiculeController(VehiculeService vehiculeService) {
        this.vehiculeService = vehiculeService;
    }
    
    @GetMapping()
    public String listVehicules(Model model) {
        List<VehiculeReponse> vehicules = vehiculeService.findAll();
        model.addAttribute("vehicules", vehicules);
        return "vehicules/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("vehicule", new VehiculeRequest());
        return "vehicules/create";
    }

    @PostMapping
    public String createVehicule(@ModelAttribute VehiculeRequest vehiculeRequest) {
        vehiculeService.create(vehiculeRequest);
        return "redirect:/vehicules";
    }

    @GetMapping("/{id}")
    public String showVehiculeDetails(@PathVariable Long id, Model model) {
        VehiculeReponse vehicule = vehiculeService.findById(id);
        model.addAttribute("vehicule", vehicule);
        return "vehicules/detail";
    }

    @GetMapping("/{id}/delete")
    public String deleteVehicule(@PathVariable Long id) {
        vehiculeService.delete(id);
        return "redirect:/vehicules";
    }
}
