package me.choejonggeon.project.service;


import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import me.choejonggeon.project.Dto.AddTodoRequest;
import me.choejonggeon.project.Dto.UpdateTodoRequest;
import me.choejonggeon.project.Dto.isSuccessedPatch;
import me.choejonggeon.project.Entity.To_do;
import me.choejonggeon.project.Entity.User;
import me.choejonggeon.project.repository.To_doRepository;
import me.choejonggeon.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.List;


@Service
@RequiredArgsConstructor
public class TodoApiService {

    @Autowired
    private To_doRepository to_doRepository;

    @Autowired
    private UserRepository userRepository;


    public To_do putTo_do(AddTodoRequest addTodoRequest, Principal principal){
        String userId = principal.getName();

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자"));

        return to_doRepository.save(addTodoRequest.toEntity(user));
    }


    public List<To_do> findAllByUserId(Principal principal) {
        String id = principal.getName();
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자"));
        return to_doRepository.findAllByUser(user);
         }

    @Transactional
    public To_do updateTo_do(long id, UpdateTodoRequest updateTodoRequest) {

        To_do to_do = to_doRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());

       to_do.setCategory(updateTodoRequest.getCategory());
       to_do.setContent(updateTodoRequest.getContent());
       to_do.setTitle(updateTodoRequest.getTitle());
       to_do.setPriority(updateTodoRequest.getPriority());
       to_do.setStartTime(updateTodoRequest.getStartTime());
       to_do.setEndTime(updateTodoRequest.getEndTime());

        return to_doRepository.save(to_do);
    }


    public void deleteById(long id) {
        to_doRepository.deleteById(id);
    }

    public To_do findById(Long id) {
        To_do to_do = to_doRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        return to_do;
    }



    @Transactional
    public To_do changeIsSuccessed(long id, isSuccessedPatch isSuccessedPatch) {
        To_do to_do = to_doRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        to_do.setIsSuccessed(isSuccessedPatch.getIsSuccessed());
        return to_doRepository.save(to_do);
    }

}

