package me.choejonggeon.project.Dto;

import lombok.Getter;
import me.choejonggeon.project.Entity.To_do;
import me.choejonggeon.project.Entity.User;

import java.time.LocalDateTime;

@Getter
public class TodoResponse {

    private Long id;

    private User owner;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private int priority;

    private String category;

    private int isSuccessed;

    private String content;

    private String title;

    public TodoResponse(To_do to_do){
        this.id = to_do.getId();
        this.owner = to_do.getUser();
        this.startTime = to_do.getStartTime();
        this.endTime = to_do.getEndTime();
        this.priority = to_do.getPriority();
        this.category = to_do.getCategory();
        this.isSuccessed = to_do.getIsSuccessed();
        this.content = to_do.getContent();
        this.title = to_do.getTitle();
    }

}



