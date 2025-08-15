package me.choejonggeon.project.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.choejonggeon.project.Entity.To_do;
import me.choejonggeon.project.Entity.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddTodoRequest {
    private Long id;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private int priority;

    private String category;

    private int isSuccessed;

    private String title;

    private String content;

    public To_do toEntity(User user){
        return To_do.builder()
                .id(id)
                .category(category)
                .startTime(startTime)
                .endTime(endTime)
                .priority(priority)
                .isSuccessed(isSuccessed)
                .user(user)
                .title(title)
                .content(content)
                .build();

    }
}
