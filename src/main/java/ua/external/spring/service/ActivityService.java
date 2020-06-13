package ua.external.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.external.spring.entity.Activity;
import ua.external.spring.repository.ActivityRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {
    @Autowired
    ActivityRepository activityRepository;

    public Optional<Activity> findActivityById(Long id){
        return activityRepository.findById(id);
    }

    public List<Activity> findAllActivities(){
        return activityRepository.findAll();
    }

    public boolean create(Activity activity){
        activityRepository.save(activity);
        return true;
    }
}
