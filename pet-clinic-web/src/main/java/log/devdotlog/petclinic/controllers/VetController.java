package log.devdotlog.petclinic.controllers;

import log.devdotlog.petclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {
    private final VetService vetService;
    public VetController(VetService vetService) {
        this.vetService = vetService;
    }
    @RequestMapping({ "/vets", "/vets/", "/vets/index", "/vets/index.html", "/vets.html"})
    public String listOfVets(Model model){
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }
}
