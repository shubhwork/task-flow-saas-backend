package com.task_flow_saas_backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.task_flow_saas_backend.entity.Task;
import com.task_flow_saas_backend.entity.User;
import com.task_flow_saas_backend.repository.TaskRepository;
import com.task_flow_saas_backend.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    private final UserRepository userRepository;

    public Task createTask(Task task, String email) {

    User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found"));

    task.setUser(user);

    task.setOrganization(user.getOrganization());

    return taskRepository.save(task);
}
     public List<Task> getTasks(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Long orgId = user.getOrganization().getId();

        return taskRepository.findByOrganizationId(orgId);
    }
    
}
