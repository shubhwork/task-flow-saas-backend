package com.task_flow_saas_backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.task_flow_saas_backend.entity.Task;
import com.task_flow_saas_backend.repository.TaskRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public Task createTask(Task task){
        return taskRepository.save(task);
    }
    public List<Task> getTaskByOrg(Long orgId){
        return taskRepository.findByOrganizationId(orgId);
    }
    
}
