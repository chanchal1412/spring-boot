package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	

	public List<Topic> getAllTopics() {
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics :: add);
		return topics;
	}
	
	public Topic getTopic(String id) {
		return topicRepository.findOne(id);
	}

	public Topic addTopic(Topic topic) {
		return topicRepository.save(topic);
	}

	public void updateTopic(String id, Topic topic) {
		if (!(topic.getId().equals(id))) return;
		Topic old = getTopic(id);
		if (old != null) {
			topicRepository.save(topic);
		}
	
	}

	public void deleteTopic(String id) {
		topicRepository.delete(id);
		
	}
	
	

}
