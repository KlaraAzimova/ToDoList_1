package com.mapper;

import com.domain.Status;
import com.domain.Task;
import com.domain.User;
import com.dto.TaskDto;
import com.dto.form.TaskEditForm;
import com.dto.form.TaskForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class TaskMapper {

    private final UserMapper userMapper;

    public TaskDto mapToTaskDto(Task task) {
        return TaskDto.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .fileName(task.getFileName())
                .time(task.getTime())
                .owner(userMapper.mapToUserDto(task.getOwner()))
                .status(task.getStatus())
                .build();
    }

    public Task mapToTask(TaskForm taskForm, User user, String fileName) {
        return Task.builder()
                .title(taskForm.getTitle())
                .description(taskForm.getDescription())
                .fileName(fileName)
                .time(LocalDateTime.now())
                .owner(user)
                .status(Status.NOT_FINISHED)
                .build();
    }

    public Task mapToTask(Task task, TaskEditForm taskEditForm, String fileName) {
        if (taskEditForm.getTitle() != null)
            task.setTitle(taskEditForm.getTitle());
        if (taskEditForm.getDescription() != null)
            task.setDescription(taskEditForm.getDescription());
        if (taskEditForm.getStatus() != null)
            task.setStatus(taskEditForm.getStatus());
        if (fileName != null)
            task.setFileName(fileName);
        return task;
    }
}
