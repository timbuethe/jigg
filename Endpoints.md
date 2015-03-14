# Introduction #

This refers to the [Alphabetical List of Endpoints](http://apidoc.digg.com/CompleteList) and names the jigg-Method for each. All methods can be found in **de.thesuntoucher.jigg.Jigg**


# Endpoints and jigg Methods #

_todo means 'not yet in this list, but may exist'_

|/containers (List Containers)|todo|
|:----------------------------|:---|
|/container/{container short\_name} (List Containers)|todo|
|/errors (List Errors)|getErrors(), getErrors(ErrorsArguments args)|
|/error/{code} (List Errors)|getError(int code), getError(int code, ErrorsArguments args)|
|/galleryphotos (List Gallery Photos)|todo|
|/galleryphotos/comments (List Gallery Photos)|todo|
|/galleryphoto/{id} (List Gallery Photos)|todo|
|/galleryphoto/{id}/comments (List Gallery Photos)|todo|
|/galleryphoto/{id}/comment/{id} (List Gallery Photos)|todo|
|/galleryphoto/{id}/comment/{id}/replies (List Gallery Photos)|todo|
|/galleryphotos/{list} (List Gallery Photos)|todo|
|/galleryphotos/{list}/comments (List Gallery Photos)|todo|
|/media (List Media)|todo|
|/medium/{medium short\_name} (List Media)|todo|
|/stories (List Stories)|getStories(), getStories(StoriesArguments args)|
|/stories/{comma-separated list of story ids} (List Stories)|getStories(int...storyIds)|
|/stories/{comma-separated list of story ids}/comments (List Events)|todo|
|/stories/{comma-separated list of story ids}/diggs (List Events)|todo|
|/stories/comments (List Events)|todo|
|/stories/container/{container name} (List Stories)|getStories(Container container), getStories(Container container, StoriesArguments args)|
|/stories/container/{container name}/hot (List Stories)|todo|
|/stories/container/{container name}/popular (List Stories)|getPopularStories(Container container), getPopularStories(Container container, StoriesArguments args)|
|/stories/container/{container name}/top (List Stories)|todo|
|/stories/container/{container name}/upcoming (List Stories)|getUpcomingStories(Container container), getUpcomingStories(Container container, StoriesArguments args)|
|/stories/diggs (List Events)|getDiggs(), getDiggs(EventsArguments args)|
|/stories/hot (List Stories)|todo|
|/stories/popular (List Stories)|getPopularStories(), getPopularStories(StoriesArguments args)|
|/stories/popular/comments (List Events)|todo|
|/stories/popular/diggs (List Events)|getPopularDiggs(), getPopularDiggs(EventsArguments args)|
|/stories/top (List Stories)|todo|
|/stories/topic/{topic name} (List Stories)|getStories(Topic topic), getStories(Topic topic, StoriesArguments args)|
|/stories/topic/{topic name}/hot (List Stories)|todo|
|/stories/topic/{topic name}/popular (List Stories)|getPopularStories(Topic topic), getPopularStories(Topic topic, StoriesArguments args)|
|/stories/topic/{topic name}/top (List Stories)|todo|
|/stories/topic/{topic name}/upcoming (List Stories)|getUpcomingStories(Topic topic), getUpcomingStories(Topic topic, StoriesArguments args)|
|/stories/upcoming (List Stories)|getUpcomingStories(), getUpcomingStories(StoriesArguments args)|
|/stories/upcoming/comments (List Events)|todo|
|/stories/upcoming/diggs (List Events)|getUpcomingDiggs(), getUpcomingDiggs(EventsArguments args)|
|/story/{story clean title}_([missing in the original list?](http://groups.google.de/group/diggapi/browse_thread/thread/61249e07e29f5559))_|getStory(String title)|
|/story/{story id} (List Stories)|getStory(int storyId)|
|/story/{story id}/activity (Activity, deprecated)|_will not be implemented_|
|/story/{story id}/activity/comments (Activity, deprecated)|_will not be implemented_|
|/story/{story id}/activity/diggs (Activity, deprecated)|_will not be implemented_|
|/story/{story id}/comments (List Events)|todo|
|/story/{story id}/diggs (List Events)|getDiggs(int storyId), getDiggs(int storyId, EventsArguments args)|
|/story/{story id}/comment/{comment id} (List Events)|todo|
|/story/{story id}/comment/{comment id}/replies (List Events)|todo|
|/story/{story id}/user/{user name}/digg (List Events)|todo|
|/topic/{topic short\_name} _([missing in the original list?](http://groups.google.de/group/diggapi/browse_thread/thread/61249e07e29f5559))_|getTopics(String topic), getTopics(String topic, TopicsArguments args)|
|/topics (List Topics)|getTopics(), getTopics(TopicsArguments args)|
|/user/{user name} (List Users)|getUser(String username), getUser(String username, UsersArguments args)|
|/user/{user name}/activity (Activity, deprecated)|_will not be implemented_|
|/user/{user name}/activity/comments (Activity, deprecated)|_will not be implemented_|
|/user/{user name}/activity/diggs (Activity, deprecated)|_will not be implemented_|
|/user/{user name}/commented (List Stories)|todo|
|/user/{user name}/comments (List Events)|todo|
|/user/{user name}/diggs (List Events)|todo|
|/user/{user name}/dugg (List Stories)|todo|
|/user/{user name}/fan/{fan user name} (List Users)|getUserFan(String username, String fanname), getUserFan(String username, String fanname, UsersArguments args)|
|/user/{user name}/fans (List Users)|getUserFans(String username), getUserFans(String username, UsersArguments args)|
|/user/{user name}/friend/{friend user name} (List Users)|getUserFriend(String username, String friendname), getUserFriend(String username, String friendname, UsersArguments args)|
|/user/{user name}/friends (List Users)|getUserFriends(String username), getUserFriends(String username, UsersArguments args)|
|/user/{user name}/friends/commented (List Stories)|todo|
|/user/{user name}/friends/dugg (List Stories)|todo|
|/user/{user name}/friends/commented (List Stories)|todo|
|/user/{user name}/friends/popular (List Stories)|todo|
|/user/{user name}/friends/submissions (List Stories)|todo|
|/user/{user name}/friends/upcoming (List Stories)|todo|
|/user/{user name}/popular (List Stories)|todo|
|/user/{user name}/submissions (List Stories)|getStories(User user), getStories(User user, StoriesArguments args)|
|/users (List Users)|getUsers(), getUsers(UsersArguments args)|
|/user/{user name}/upcoming (List Stories)|todo|
|/users/{comma-separated list of user names}/comments (List Events)|todo|
|/users/{comma-separated list of user names}/diggs (List Events)|getUsersDiggs(EventsArguments args, String...usernames)|