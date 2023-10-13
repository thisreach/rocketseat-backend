package me.reach.rocketseat.controllers;

import me.reach.rocketseat.models.TaskModel;
import me.reach.rocketseat.repository.ITaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private ITaskRepository repository;

    @PostMapping("/")
    public TaskModel create(@RequestBody TaskModel model){
        return this.repository.save(model);
    }

}
