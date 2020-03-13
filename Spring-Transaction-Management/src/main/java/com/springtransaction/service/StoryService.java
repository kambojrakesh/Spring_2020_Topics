package com.springtransaction.service;

import org.springframework.stereotype.Component;

import com.springtransaction.entity.Story;

@Component
public interface StoryService {
	public void saveStory(Story story);
}