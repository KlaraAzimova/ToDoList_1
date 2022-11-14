package com.api;

import com.dto.form.TaskEditForm;
import com.dto.form.TaskForm;
import com.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class TaskApi {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<?> createTask(@ModelAttribute TaskForm taskForm, Authentication auth) {
        return ResponseEntity.ok(taskService.createTask(taskForm, auth));
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<?> finishTask(@PathVariable Long taskId, Authentication auth) {
        return taskService.finishTask(taskId, auth);
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<?> deleteTask(@PathVariable Long taskId, Authentication auth) {
        return taskService.deleteTask(taskId, auth);
    }

    @DeleteMapping
    public ResponseEntity<?> clearTrash(Authentication auth) {
        return taskService.clearTrash(auth);
    }

    @PutMapping
    public ResponseEntity<?> editTask(@ModelAttribute TaskEditForm taskEditForm, Authentication auth) {
        if (taskEditForm.getId() == null)
            return ResponseEntity.badRequest().body("You can't edit the task without ID!");
        return taskService.editTask(taskEditForm, auth);
    }
}
