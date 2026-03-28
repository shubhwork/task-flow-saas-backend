package com.task_flow_saas_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task_flow_saas_backend.entity.Task;

public interface TaskRepository extends JpaRepository<Task,Long> {

    List<Task> findByOrganizationId(Long orgId);

}
