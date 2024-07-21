package ir.group_3_and_4.service;

import ir.group_3_and_4.exception.DuplicateInformationException;
import ir.group_3_and_4.exception.NotFoundEntityException;
import ir.group_3_and_4.model.User;
import ir.group_3_and_4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User saveUser(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new DuplicateInformationException("duplicate username: " + user.getUsername());
        }
        return userRepository.save(user);

    }

    public User findByUserName(String username) {
        return userRepository.findByUsername(username).orElseThrow(
                () -> new NotFoundEntityException("Not found user!")
        );


    }

    public User findById(long userId) {
        return userRepository.findById(userId).orElseThrow(
                () -> new NotFoundEntityException("user not found"));
    }

    public void delete(long userId) {
        userRepository.delete(findById(userId));

    }

    public User updateUser(User user) {
        User updateUser = findById(user.getId());
        if (userRepository.findByUsername(user.getUsername()).isPresent())
            throw new DuplicateInformationException("username is duplicate!");
        Optional.ofNullable(user.getUsername()).ifPresent(updateUser::setUsername);
        Optional.ofNullable(user.getName()).ifPresent(updateUser::setName);
       return userRepository.save(updateUser);


    }


}
