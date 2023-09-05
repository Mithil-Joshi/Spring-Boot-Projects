package com.mj.springbootstarter.topic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();	
	}
	
	@RequestMapping("/topics/{id}")
	public Optional<Topic> getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	//@RequestMapping(method = RequestMethod.POST, value = "/topics")
	@PostMapping("/topics")
	public String postTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
		return "Topic added successfully";
	}
	
	@PutMapping("/topics/{id}")
	public String putTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(topic, id);
		return "Topic updated successfully";
	}
	
	@DeleteMapping("/topics/{id}")
	public String deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
		return "Topic deleted successfully";
	}
}
