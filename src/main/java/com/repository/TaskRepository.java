package com.repository;

import com.domain.Status;
import com.domain.Task;
import com.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    boolean existsByIdAndOwner(Long id, User user);

    List<Task> findAllByOwnerAndStatus(User owner, Status status);
}
