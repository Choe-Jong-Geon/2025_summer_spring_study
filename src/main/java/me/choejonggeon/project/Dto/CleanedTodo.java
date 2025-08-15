package me.choejonggeon.project.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.choejonggeon.project.Entity.To_do;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CleanedTodo {

    private Long id;

    private String title;

    private String content;

    private String startTime;

    private String endTime;

    private String category;

    private String isSuccessed;

    private String priority;

    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");


    public static List<CleanedTodo> cleanData(List<To_do> todoList) {

        return todoList.stream().map(todo -> new CleanedTodo(
                todo.getId(),
                todo.getTitle(),
                todo.getContent(),
                todo.getStartTime().format(formatter),
                todo.getEndTime().format(formatter),
                todo.getCategory(),
                todo.getIsSuccessed() == 1 ? "완료됨" : "미완료",
                switch (todo.getPriority()) {
                    case 0 -> "보통";
                    case -1 -> "낮음";
                    case 1 -> "높음";
                    default -> "null";
                }
        )).toList();

    }
}
