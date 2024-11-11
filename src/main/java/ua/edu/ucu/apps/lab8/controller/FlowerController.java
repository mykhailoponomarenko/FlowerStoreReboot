package ua.edu.ucu.apps.lab8.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.edu.ucu.apps.lab8.model.Flower;
import ua.edu.ucu.apps.lab8.service.FlowerService;

@RestController
@RequestMapping("/api/v1")
public class FlowerController {

    private FlowerService flowerService;

    public FlowerController(FlowerService flowerService) {
        this.flowerService = flowerService;
    }
    @GetMapping("/postgres")
    public List<Flower> getFlowers() {
        return flowerService.getFlowers();

    }
    
}
