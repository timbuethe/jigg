# Introduction #

This page should give you a short overview, some examples and links.

# Overview #

You can read the Basic Concepts of the digg.com API [here](http://apidoc.digg.com/BasicConcepts). In a nutshell, you have to call some URL like `http://services.digg.com/stories...` and you'll get the answer (among other formats) as XML. **Jigg** wraps this nicely and provides methods for all the API endpoints so you don't have to build an URL, parse the response and handle http errors etc.

# Setup #

Just download the latest jigg-x.x.jar from [Downloads](http://code.google.com/p/jigg/downloads/list) and put it in your classpath.

# Examples #

First of all you have to construct a jigg object. While doing this you have to provide an [application key](http://apidoc.digg.com/ApplicationKeys). This just have to be a valid URL.

```
Jigg jigg = new Jigg("http://code.google.com/p/jigg/");
```

## Stories ##

List stories from topic _apple_:
```
for (Story story : jigg.getStories(new Topic("Apple", "apple"))) {
  System.out.println(story.getTitle());
}
```

Get a story by id:
```
System.out.println(jigg.getStory(1489));
```

List stories by id list:
```
for (Story story : jigg.getStories(984,1489,8575,174)) {
  System.out.println(story.getTitle() + "(" + story.getId() + ")");
}
```

List popular stories:
```
for (Story story : jigg.getPopularStories()) {
  System.out.println(story.getTitle() + "(" + story.getId() + ")");
}
```

## Topics ##

List topics:
```
for (Topic topic : jigg.getTopics()) {
  System.out.println(topic.getName() + "(" + topic.getShortName() + ")");
}
```

So, i think that gives something to play around with. To see what else can be done, simple check the methods in _de.thesuntoucher.jigg.Jigg_. The class should provide a method for every endpoint described in the [api](http://apidoc.digg.com/). You can see an Alphabetical List and the corresponding jigg method in the [Endpoints-Page](Endpoints.md).