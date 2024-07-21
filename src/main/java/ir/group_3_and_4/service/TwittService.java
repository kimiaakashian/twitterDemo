package ir.group_3_and_4.service;

import ir.group_3_and_4.exception.NotFoundEntityException;
import ir.group_3_and_4.model.Twitt;
import ir.group_3_and_4.repository.TwittRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TwittService {
    private final TwittRepository twittRepository;
    private final UserService userService;


    public Twitt saveTwitt(Twitt twitt, Long userId) {

        twitt.setUser(userService.findById(userId));
        twitt.setTwittDateTime(LocalDateTime.now());
        return twittRepository.save(twitt);

    }




    public List<Twitt> displayAllTwittsByUserId(Long userId) {
        return twittRepository.findTwittsByUser(userService.findById(userId));
    }

    public Twitt findById(Long twittId){
       return twittRepository.findById(twittId).orElseThrow(
                () ->new  NotFoundEntityException ("twitt with id:" + twittId+ " not found"));
    }

    public void deleteTwitt(Long twittId){
        twittRepository.deleteById(findById(twittId).getId());

    }

    public Twitt updateTwitt(Twitt twitt){
        Twitt updateTwitt = findById(twitt.getId());
        Optional.ofNullable(twitt.getTwitt()).ifPresent(updateTwitt::setTwitt);
        return twittRepository.save(updateTwitt);
    }
}
