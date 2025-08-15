package me.choejonggeon.project.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.choejonggeon.project.Entity.User;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UpdateTodoRequest {

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private int priority;

    private String category;

    private String content;

    private String title;

}
