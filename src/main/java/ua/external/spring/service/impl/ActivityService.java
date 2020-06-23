package ua.external.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.external.spring.entity.Activity;
import ua.external.spring.repository.ActivityRepository;
import ua.external.spring.service.IActivityService;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityService implements IActivityService {
    @Autowired
    ActivityRepository activityRepository;

    @Override
    public Optional<Activity> findActivityById(Long id) {
        return activityRepository.findById(id);
    }

    @Override
    public List<Activity> findAllActivities() {
        return activityRepository.findAll();
    }

    @Override
    public boolean create(Activity activity) {
        activityRepository.save(activity);
        return true;
    }
}
