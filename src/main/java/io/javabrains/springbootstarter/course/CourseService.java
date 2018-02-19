package io.javabrains.springbootstarter.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.javabrains.springbootstarter.topic.Topic;
import io.javabrains.springbootstarter.topic.TopicService;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private TopicService topicService;
	

	public List<Course> getAllCourses(String topicId) {
		List<Course> courses = courseRepository.findByTopicId(topicId);
		return courses;
	}
	
	public Course getCourse(String id) {
		return courseRepository.findOne(id);
	}

	public Course addCourse(String topicId, Course course) {
		Topic topic = topicService.getTopic(topicId);
		course.setTopic(topic);
		return courseRepository.save(course);
	}

	public void updateCourse(String topicId, String id, Course course) {
		if ( getCourse(id) == null ) return;
		if (!(course.getId().equals(id))) return;
		course.setTopic(topicService.getTopic(topicId));
		courseRepository.save(course);
	}

	public void deleteCourse(String id) {
		courseRepository.delete(id);
		
	}
	
	

}
