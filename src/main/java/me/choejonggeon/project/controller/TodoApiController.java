package me.choejonggeon.project.controller;

import me.choejonggeon.project.Dto.AddTodoRequest;
import me.choejonggeon.project.Dto.UpdateTodoRequest;
import me.choejonggeon.project.Dto.isSuccessedPatch;
import me.choejonggeon.project.Entity.To_do;
import me.choejonggeon.project.service.TodoApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class TodoApiController {

    @Autowired
    private TodoApiService todoApiService;

    @PostMapping("/api/todos")
    public ResponseEntity<To_do> addTodo(@RequestBody AddTodoRequest addTodoRequest, Principal principal){
        To_do savedtodo = todoApiService.putTo_do(addTodoRequest, principal);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedtodo);
    }


    @PatchMapping("/api/todos/{id}")
    public ResponseEntity<To_do> update(@PathVariable("id") long id, @RequestBody UpdateTodoRequest
                                        updateTodoRequest){
        To_do todo = todoApiService.updateTo_do(id, updateTodoRequest);

        return ResponseEntity.ok()
                .body(todo);
    }


    @DeleteMapping("/api/todos/{id}")
    public ResponseEntity<To_do> delete(@PathVariable("id") long id){
        todoApiService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @PatchMapping("/api/todos/changedisSuccessed/{id}")
    public ResponseEntity<To_do> changedisSuccessed(@PathVariable long id,
                                                    @RequestBody isSuccessedPatch isSuccessedPatch){

        To_do to_do = todoApiService.changeIsSuccessed(id, isSuccessedPatch);
        return ResponseEntity.ok().body(to_do);

    }

}
