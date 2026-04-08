package com.task_flow_saas_backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task_flow_saas_backend.entity.Task;
import com.task_flow_saas_backend.service.TaskService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public Task createTask(@RequestBody Task task,HttpServletRequest request){
        String email = (String) request.getAttribute("email");  
        return taskService.createTask(task,email);
    }

    @GetMapping
    public List<Task> getTasks(HttpServletRequest request) {
    String email = (String) request.getAttribute("email");
        return taskService.getTasks(email);
    }
}
