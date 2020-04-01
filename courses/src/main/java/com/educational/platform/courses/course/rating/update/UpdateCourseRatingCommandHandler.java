package com.educational.platform.courses.course.rating.update;

import com.educational.platform.common.exception.ResourceNotFoundException;
import com.educational.platform.courses.course.Course;
import com.educational.platform.courses.course.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Command handler for {@link UpdateCourseRatingCommand} updates a rating course.
 */
@RequiredArgsConstructor
@Component
@Transactional
public class UpdateCourseRatingCommandHandler {

    private final CourseRepository repository;

    public void handle(UpdateCourseRatingCommand command) {
        final Optional<Course> dbResult = repository.findById(command.getId());
        if (dbResult.isEmpty()) {
            throw new ResourceNotFoundException(String.format("Course with id: %s not found", command.getId()));
        }

        final Course course = dbResult.get();
        course.updateRating(command.getRating());
        repository.save(course);
    }

}
