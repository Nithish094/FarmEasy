package com.farmeasy.controller;

import com.farmeasy.model.Machine;
import com.farmeasy.repository.MachineRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/machines")
public class MachineController {

    private final MachineRepository repo;

    public MachineController(MachineRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public Machine addMachine(@RequestBody Machine machine) {
        return repo.save(machine);
    }

    @GetMapping
    public List<Machine> getMachines() {
        return repo.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteMachine(@PathVariable Long id) {
        repo.deleteById(id);
    }
}