package me.choejonggeon.project.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@Entity(name = "to_do")
@NoArgsConstructor
@AllArgsConstructor

public class To_do {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "owner", nullable = false)
    private User user;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalDateTime endTime;

    @Column(name = "priority", columnDefinition = "INT DEFAULT = 0")
    private int priority;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "issuccessed", columnDefinition = "INT DEFAULT = 0")
    private int isSuccessed;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Builder
    public To_do(Long id, LocalDateTime startTime, User user, LocalDateTime endTime,
                 int priority, String category, int isSuccessed, String title, String content) {

        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
        this.category = category;
        this.isSuccessed = isSuccessed;
        this.user = user;
        this.title = title;
        this.content = content;
    }


}


