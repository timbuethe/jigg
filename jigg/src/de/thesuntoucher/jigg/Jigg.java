package de.thesuntoucher.jigg;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import de.thesuntoucher.jigg.args.*;
import de.thesuntoucher.jigg.data.*;
import de.thesuntoucher.jigg.data.Error;
import de.thesuntoucher.jigg.handler.*;
import de.thesuntoucher.jigg.net.DefaultHttpClient;
import de.thesuntoucher.jigg.net.JiggHttpClient;

/**
 * 
 * <a href="http://apidoc.digg.com">http://apidoc.digg.com</a>
 * 
 */
public class Jigg {
	
	private final String baseUrl = "http://services.digg.com/";
	private final String appKey;
	private JiggHttpClient httpClient = new DefaultHttpClient();
	
	/**
	 * @param appKey see http://apidoc.digg.com/ApplicationKeys
	 */
	public Jigg(String appKey){
		this.appKey = encodeUrl(appKey);
	}
	
	/**
	 * GET /topics
	 * Get a list of all topics.
	 * 
	 * @return 
	 */
	public Topics getTopics(){
		return getTopics(new TopicsArguments());
	}
	
	/**
	 * GET /topics
	 * Get a list of all topics.
	 * 
	 * @param args 
	 * @return 
	 */
	public Topics getTopics(TopicsArguments args){
		TopicsResponseHandler handler = new TopicsResponseHandler();
		fetch(url("topics", args), handler);
		return handler.getTopics();
	}
    
	/**
	 * GET /topic/{topic short_name}
	 * Get the specified topic.
	 * 
	 * @param topic 
	 * @return 
	 */
	public Topics getTopics(String topic){
		return getTopics(topic, new TopicsArguments());
	}
    
	/**
	 * GET /topic/{topic short_name}
	 * Get the specified topic.
	 * 
	 * @param topic 
	 * @param args 
	 * @return 
	 */
	public Topics getTopics(String topic, TopicsArguments args){
		TopicsResponseHandler handler = new TopicsResponseHandler();
		fetch(url("topics/" + topic, args), handler);
		return handler.getTopics();
	}
	
	/**
	 * GET /users
	 * 
	 * @return All users.
	 */
	public Users getUsers(){
		return getUsers(new UsersArguments());
	}
	
	/**
	 * GET /users
	 * 
	 * @param args 
	 * @return All users.
	 */
	public Users getUsers(UsersArguments args){
		UsersResponseHandler handler = new UsersResponseHandler();
		fetch(url("users", args), handler);
		return handler.getUsers();
	}
	
	/**
	 * GET /user/{user name}
	 * 404 Not Found response if the user does not exist.
	 * 
	 * @param username 
	 * @return Named user.
	 * 
	 */
	public User getUser(String username){
		return getUser(username, new UsersArguments());
	}
	
	/**
	 * GET /user/{user name}
	 * 404 Not Found response if the user does not exist.
	 * 
	 * @param username 
	 * @param args 
	 * @return Named user.
	 * 
	 */
	public User getUser(String username, UsersArguments args){
		UsersResponseHandler handler = new UsersResponseHandler();
		fetch(url("user/" + username, args), handler);
		return handler.getUsers().get(0);
	}
	
	/**
	 * GET /user/{user name}/friends
	 * 404 Not Found response if the user does not exist.
	 * 
	 * @param username 
	 * @return Named user's friends.
	 */
	public Users getUserFriends(String username){
		return getUserFriends(username, new UsersArguments());
	}

	/**
	 * GET /user/{user name}/friends
	 * 404 Not Found response if the user does not exist.
	 * 
	 * @param username 
	 * @param args 
	 * @return Named user's friends.
	 */
	public Users getUserFriends(String username, UsersArguments args){
		UsersResponseHandler handler = new UsersResponseHandler();
		fetch(url("user/" + username + "/friends", args), handler);
		return handler.getUsers();
	}
	
	/**
	 * GET /user/{user name}/friend/{friend user name}
	 * 404 Not Found if one of the users does not exist, or the first user has not befriended the second user.
	 * 
	 * @param username the befriender
	 * @param friendname the befriended
	 * @return Named user's friend.
	 */
	public User getUserFriend(String username, String friendname){
		return getUserFriend(username, friendname, new UsersArguments());
	}
	
	/**
	 * GET /user/{user name}/friend/{friend user name}
	 * 404 Not Found if one of the users does not exist, or the first user has not befriended the second user.
	 * 
	 * @param username the befriender
	 * @param friendname the befriended
	 * @param args 
	 * @return Named user's friend.
	 */
	public User getUserFriend(String username, String friendname, UsersArguments args){
		UsersResponseHandler handler = new UsersResponseHandler();
		fetch(url("user/" + username + "/friend/" + friendname, args), handler);
		return handler.getUsers().get(0);
	}
	
	/**
	 * GET /user/{user name}/fans
	 * 404 Not Found response if the user does not exist.
	 * 
	 * @param username 
	 * @return Users who count the named user as a friend.
	 */
	public Users getUserFans(String username){
		return getUserFans(username, new UsersArguments());
	}
	
	/**
	 * GET /user/{user name}/fans
	 * 404 Not Found response if the user does not exist.
	 * 
	 * @param username 
	 * @param args 
	 * @return Users who count the named user as a friend.
	 */
	public Users getUserFans(String username, UsersArguments args){
		UsersResponseHandler handler = new UsersResponseHandler();
		fetch(url("user/" + username + "/fans", args), handler);
		return handler.getUsers();
	} 
	
	/**
	 * GET /user/{user name}/fan/{fan user name}
	 * 404 Not Found if one of the users does not exist, or the second user has not befriended the first user.
	 * 
	 * @param username the befriended
	 * @param fanname the befriender
	 * @return User who counts the named user as a friend.
	 */
	public User getUserFan(String username, String fanname){
		return getUserFan(username, fanname, new UsersArguments());
	} 
	
	/**
	 * GET /user/{user name}/fan/{fan user name}
	 * 404 Not Found if one of the users does not exist, or the second user has not befriended the first user.
	 * 
	 * @param username the befriended
	 * @param fanname the befriender
	 * @param args 
	 * @return User who counts the named user as a friend.
	 */
	public User getUserFan(String username, String fanname, UsersArguments args){
		UsersResponseHandler handler = new UsersResponseHandler();
		fetch(url("user/" + username + "/fan/" + fanname, args), handler);
		return handler.getUsers().get(0);
	}
	
	/**
	 * GET /stories
	 * 
	 * @return All stories.
	 */
	public Stories getStories() {
		return getStories(new StoriesArguments());
	}
	
	/**
	 * GET /stories
	 * 
	 * @param args 
	 * @return All stories.
	 */
	public Stories getStories(StoriesArguments args) {
		StoriesResponseHandler handler = new StoriesResponseHandler();
		fetch(url("stories", args), handler);
		return handler.getStories();
	}
	
	/**
	 * GET /stories/popular
	 * 
	 * @return Popular stories.
	 */
	public Stories getPopularStories() {
		return getPopularStories(new StoriesArguments());
	}
	
	/**
	 * GET /stories/popular
	 * 
	 * @param args 
	 * @return Popular stories.
	 */
	public Stories getPopularStories(StoriesArguments args) {
		StoriesResponseHandler handler = new StoriesResponseHandler();
		fetch(url("stories/popular", args), handler);
		return handler.getStories();
	}
	
	/**
	 * GET /stories/upcoming
	 * 
	 * @return Upcoming stories.
	 */
	public Stories getUpcomingStories() {
		return getStories(new StoriesArguments());
	}
	
	/**
	 * GET /stories/upcoming
	 * 
	 * @param args 
	 * @return Upcoming stories.
	 */
	public Stories getUpcomingStories(StoriesArguments args) {
		StoriesResponseHandler handler = new StoriesResponseHandler();
		fetch(url("stories/upcoming", args), handler);
		return handler.getStories();
	}
	
	/**
	 * GET /stories/container/{container name}
	 * 404 Not Found if the container does not exist.
	 * 
	 * @param container 
	 * @return All stories from a given container.
	 */
	public Stories getStories(Container container) {
		return getStories(container, new StoriesArguments());
	}
	
	/**
	 * GET /stories/container/{container name}
	 * 404 Not Found if the container does not exist.
	 * 
	 * @param container 
	 * @param args 
	 * @return All stories from a given container.
	 */
	public Stories getStories(Container container, StoriesArguments args) {
		StoriesResponseHandler handler = new StoriesResponseHandler();
		fetch(url("stories/container/" + container, args), handler);
		return handler.getStories();
	}
	
	/**
	 * GET /stories/container/{container name}/popular
	 * 404 Not Found if the container does not exist.
	 * 
	 * @param container 
	 * @return Popular stories from a given container.
	 */
	public Stories getPopularStories(Container container) {
		return getPopularStories(container, new StoriesArguments());
	}
	
	/**
	 * GET /stories/container/{container name}/popular
	 * 404 Not Found if the container does not exist.
	 * 
	 * @param container 
	 * @param args 
	 * @return Popular stories from a given container.
	 */
	public Stories getPopularStories(Container container, StoriesArguments args) {
		StoriesResponseHandler handler = new StoriesResponseHandler();
		fetch(url("stories/container/" + container + "/popular", args), handler);
		return handler.getStories();
	}
	
	/**
	 * GET /stories/container/{container name}/upcoming
	 * 404 Not Found if the container does not exist.
	 * 
	 * @param container 
	 * @return Upcoming stories from a given container.
	 */
	public Stories getUpcomingStories(Container container) {
		return getUpcomingStories(container, new StoriesArguments());
	}
	
	/**
	 * GET /stories/container/{container name}/upcoming
	 * 404 Not Found if the container does not exist.
	 * 
	 * @param container 
	 * @param args 
	 * @return Upcoming stories from a given container.
	 */
	public Stories getUpcomingStories(Container container, StoriesArguments args) {
		StoriesResponseHandler handler = new StoriesResponseHandler();
		fetch(url("stories/container/" + container + "/upcoming", args), handler);
		return handler.getStories();
	}
	
	/**
	 * GET /stories/topic/{topic name}
	 * 404 Not Found if the topic does not exist.
	 * 
	 * @param topic
	 * @return All stories from a given topic.
	 */
	public Stories getStories(Topic topic) {
		return getStories(topic, new StoriesArguments());
	}
	
	/**
	 * GET /stories/topic/{topic name}
	 * 404 Not Found if the topic does not exist.
	 * 
	 * @param topic
	 * @param args 
	 * @return All stories from a given topic.
	 */
	public Stories getStories(Topic topic, StoriesArguments args) {
		StoriesResponseHandler handler = new StoriesResponseHandler();
		fetch(url("stories/topic/" + topic.getShortName(), args), handler);
		return handler.getStories();
	}
	
	/**
	 * GET /stories/topic/{topic name}/popular
	 * 404 Not Found if the topic does not exist.
	 * 
	 * @param topic 
	 * @return Popular stories from a given topic.
	 */
	public Stories getPopularStories(Topic topic) {
		return getPopularStories(topic, new StoriesArguments());
	}
	
	/**
	 * GET /stories/topic/{topic name}/popular
	 * 404 Not Found if the topic does not exist.
	 * 
	 * @param topic 
	 * @param args 
	 * @return Popular stories from a given topic.
	 */
	public Stories getPopularStories(Topic topic, StoriesArguments args) {
		StoriesResponseHandler handler = new StoriesResponseHandler();
		fetch(url("stories/topic/" + topic.getShortName() + "/popular", args), handler);
		return handler.getStories();
	}

	/**
	 * GET /stories/topic/{topic name}/upcoming
	 * 404 Not Found if the topic does not exist.
	 * 
	 * @param topic 
	 * @return Upcoming stories from a given topic.
	 */
	public Stories getUpcomingStories(Topic topic) {
		return getUpcomingStories(topic, new StoriesArguments());
	}
	
	/**
	 * GET /stories/topic/{topic name}/upcoming
	 * 404 Not Found if the topic does not exist.
	 * 
	 * @param topic 
	 * @param args 
	 * @return Upcoming stories from a given topic.
	 */
	public Stories getUpcomingStories(Topic topic, StoriesArguments args) {
		StoriesResponseHandler handler = new StoriesResponseHandler();
		fetch(url("stories/topic/" + topic.getShortName() + "/upcoming", args), handler);
		return handler.getStories();
	}
	
	/**
	 * GET /story/{story id}
	 * 404 Not Found for non-existent story.
	 * 
	 * @param storyId
	 * @return Identified story.
	 */
	public Story getStory(int storyId) {
		StoriesResponseHandler handler = new StoriesResponseHandler();
		fetch(url("story/" + storyId), handler);
		return handler.getStories().get(0);
	}
	
	/**
	 * GET /stories/{comma-separated list of story ids}
	 * 403 Forbidden with explanatory message for more than 100 ids.
	 * 
	 * @param storyIds 
	 * @return A list of stories with the given ids. (E.g., GET /stories/984,1489,8575,174)
	 */
	public Stories getStories(int...storyIds) {
		StoriesResponseHandler handler = new StoriesResponseHandler();
		fetch(url("stories/" + join(storyIds), new StoriesArguments()), handler);
		return handler.getStories();
	}
	
	/**
	 * GET /story/{story clean title}
	 * Generally, this endpoint is used to obtain the details of a story for which the URL on digg.com is known.
	 * 404 Not Found for non-existent story.
	 * 
	 * @param title
	 * @return Identified story.
	 */
	public Story getStory(String title) {
		StoriesResponseHandler handler = new StoriesResponseHandler();
		fetch(url("story/" + title, new StoriesArguments()), handler);
		return handler.getStories().get(0);
	}
	
	/**
	 * GET /user/{user name}/submissions
	 * 404 Not Found indicates that the given user does not exist.
	 * 
	 * @param user 
	 * @return Stories submitted by given user.
	 */
	public Stories getStories(User user) {
		return getStories(user, new StoriesArguments());
	}
	
	/**
	 * GET /user/{user name}/submissions
	 * 404 Not Found indicates that the given user does not exist.
	 * 
	 * @param user 
	 * @param args 
	 * @return Stories submitted by given user.
	 */
	public Stories getStories(User user, StoriesArguments args) {
		StoriesResponseHandler handler = new StoriesResponseHandler();
		fetch(url("user/" + user.getName() + "/submissions", args), handler);
		return handler.getStories();
	}
	
	/**
	 * GET /errors
	 * 
	 * @return a list of all error codes and messages
	 */
	public Errors getErrors() {
		return getErrors(new ErrorsArguments());
	}
	
	/**
	 * GET /errors
	 * 
	 * @param args 
	 * @return a list of all error codes and messages
	 */
	public Errors getErrors(ErrorsArguments args) {
		ErrorsResponseHandler handler = new ErrorsResponseHandler();
		fetch(url("errors", args), handler);
		return handler.getErrors();
	}
	
	/**
	 * GET /error/{code}
	 * 
	 * @param code
	 * @param args
	 * @return the message for a specific error code
	 */
	public Error getError(int code) {
		return getError(code, new ErrorsArguments());
	}

	/**
	 * GET /error/{code}
	 * 
	 * @param code
	 * @param args
	 * @return the message for a specific error code
	 */
	public Error getError(int code, ErrorsArguments args) {
		ErrorsResponseHandler handler = new ErrorsResponseHandler();
		fetch(url("error/" + code, args), handler);
		return handler.getErrors().isEmpty() ? null : handler.getErrors().get(0);
	}

	/**
	 * GET /stories/diggs
     * 
	 * @return All diggs.
	 */
	public Events<Digg> getDiggs(){
		return getDiggs(new EventsArguments());
	}
	
	/**
	 * GET /stories/diggs
	 * 
	 * @param args 
	 * @return All diggs.
	 */
	public Events<Digg> getDiggs(EventsArguments args){
		EventsResponseHandler<Digg> handler = new EventsResponseHandler<Digg>();
		fetch(url("stories/diggs", args), handler);
		return handler.getEvents();
	}
	
	/**
	 * GET /stories/popular/diggs
     * 
	 * @return All diggs on popular stories.
	 */
	public Events<Digg> getPopularDiggs(){
		return getPopularDiggs(new EventsArguments());
	}
	
	/**
	 * GET /stories/popular/diggs
	 * 
	 * @param args 
	 * @return All diggs on popular stories.
	 */
	public Events<Digg> getPopularDiggs(EventsArguments args){
		EventsResponseHandler<Digg> handler = new EventsResponseHandler<Digg>();
		fetch(url("/stories/popular/diggs", args), handler);
		return handler.getEvents();
	}
	
	/**
	 * GET /stories/upcoming/diggs
	 * 
	 * @return All diggs on upcoming stories.
	 */
	public Events<Digg> getUpcomingDiggs(){
		return getUpcomingDiggs(new EventsArguments());
	}
	
	/**
	 * GET /stories/upcoming/diggs
	 * 
	 * @param args 
	 * @return All diggs on upcoming stories.
	 */
	public Events<Digg> getUpcomingDiggs(EventsArguments args){
		EventsResponseHandler<Digg> handler = new EventsResponseHandler<Digg>();
		fetch(url("/stories/popular/diggs", args), handler);
		return handler.getEvents();
	}
	
	/**
	 * GET /story/{story id}/diggs
	 * 404 Not Found response if the story does not exist.
	 * 
	 * @param storyId
	 * @param args
	 * @return All diggs for a given story.
	 */
	public Events<Digg> getDiggs(int storyId){
		return getDiggs(storyId, new EventsArguments());
	}
	
	/**
	 * GET /story/{story id}/diggs
	 * 404 Not Found response if the story does not exist.
	 * 
	 * @param storyId
	 * @param args
	 * @return All diggs for a given story.
	 */
	public Events<Digg> getDiggs(int storyId, EventsArguments args){
		EventsResponseHandler<Digg> handler = new EventsResponseHandler<Digg>();
		fetch(url("/stories/" + storyId + "/diggs", args), handler);
		return handler.getEvents();
	}

	// TODO
//	GET /stories/{comma-separated list of story ids}/diggs
//	    All diggs for a list of stories with the given ids. (E.g., GET /stories/984,1489,8575,174/diggs)
//	GET /user/{user name}/diggs
//	    One user's diggs for all stories.
//	    404 Not Found response if the user is unknown. 
	
	/**
	 * GET /users/{comma-separated list of user names}/diggs
	 * 404 Not Found response if any of the users is unknown.
	 * 
	 * @param args 
	 * @param usernames comma separated list of usernamens, at most 100 user names may be listed.
	 * @return Several users' diggs for all stories.
	 */
	public Events<Digg> getUsersDiggs(EventsArguments args, String...usernames){
		
		if(usernames.length > 100){
			throw new JiggException(
					new IllegalArgumentException("usernames > 100"));
		}
				
		EventsResponseHandler<Digg> handler = new EventsResponseHandler<Digg>();
		fetch(url("/users/" + join(usernames) + "/diggs", args), handler);
		return handler.getEvents();
	}
	
//	TODO
//
//	GET /story/{story id}/user/{user name}/digg
//	    One user digg for a given story.
//	    404 Not Found response if the user has not dugg the story.
//	GET /stories/comments
//	    All comments.
//	GET /stories/popular/comments
//	    All comments on popular stories.
//	GET /stories/upcoming/comments
//	    All comments on upcoming stories.
//	GET /stories/{comma-separated list of story ids}/comments
//	    All comments for a list of stories with the given ids. (e.g. GET /stories/984,1489,8575,174/comments) At most 100 story ids may be listed
//	GET /story/{story id}/comments
//	    Top-level comments for a given story.
//	    404 Not Found response if the story does not exist.
//	GET /user/{user name}/comments
//	    One user's comments for all stories.
//	    404 Not Found response if the user does not exist.
//	GET /users/{comma-separated list of user names}/comments
//	    Several users' comments for all stories. (e.g. GET /users/sbwms,kevinrose/comments) At most 100 user names may be listed.
//	    404 Not Found response if any of the users is unknown.
//	GET /story/{story id}/comment/{comment id}
//	    One comment for a given story.
//	    404 Not Found response if the story or comment do not exist.
//	GET /story/{story id}/comment/{comment id}/replies
//	    One level of replies to one comment for a given story.
//	    404 Not Found response if the story or comment do not exist. 
	
	
	

//	GET /media
//	    Get a list of all media.
//	GET /medium/{medium short_name}
//	    Get a specified medium. 
	
	/**
	 * @param url
	 * @param handler
	 */
	private void fetch(URL url, ResponseHandler handler){
		this.httpClient.fetch(url, handler);
	}
	
	/**
	 * @param endpoint
	 * @return
	 */
	private URL url(String endpoint) {
		return url(endpoint, Arguments.EMPTY_ARGUMENTS); 
	}
	
	/**
	 * @param endpoint
	 * @param args 
	 * @return
	 */
	private URL url(String endpoint, Arguments args) {
		
		try {

			return new URL(baseUrl + endpoint + 
					(endpoint.indexOf("?") >= 0 ? "&" : "?") + "appkey=" + appKey + 
					"&type=xml" + args);

		} catch (MalformedURLException e) {
			throw new JiggException(e);
		}
	}
	
	/**
	 * @param string
	 * @return
	 */
	public static String encodeUrl(String string){
		try {
			return URLEncoder.encode(string, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new JiggException(e);
		}
	}
	
	private static String join(Object...values){
		return join(",", values);
	}
	
	private static String join(String separator, Object...values){
		
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < values.length; i++) {
			result.append(values[i]);
			if(i+1 < values.length){
				result.append(separator);
			}
		}
		
		return result.toString();
	}

	public JiggHttpClient getHttpClient() {
		return httpClient;
	}

	public void setHttpClient(JiggHttpClient httpClient) {
		this.httpClient = httpClient;
	}
	
//	TODO: i think i can't implement this, because of point 4 
//
//	/**
//	 * The "clean title" is the story's title as it appears in the story's URL on digg.com. 
//	 * The clean title is assigned by digg.com when the story is submitted. It is formed as follows:<br>
//	 * <br>
//	 * 1. Characters other than A through Z and 0 through 9 are replaced with spaces.<br>
//	 * 2. Leading and trailing spaces are discarded.<br>
//	 * 3. Each instance of one or more spaces is replaced by a single underscore.<br>
//	 * 4. If the resulting clean title is already used by another story, an underscore and a number are appended.<br>
//	 * <br>
//	 * 
//	 * @param title 
//	 * @return cleaned title
//	 */
//	public static String cleanUpTitle(String title){
//		title = title.replaceAll("", replacement);
//		title = title.trim();
//		title = title.replaceAll("\\s", "_");
//	}
}
