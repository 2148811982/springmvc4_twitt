package twitt.service;

import java.util.List;

import twitt.domain.Tweet;

public interface ISearchSerivce {

	List<Tweet> search(String searchType, List<String> keywords);
}
