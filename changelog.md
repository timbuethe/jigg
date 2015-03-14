# Versions #

0.5 Oct 16, 2008
  * fixed wrong handling of dates, using seconds instead of milliseconds since 1.1.1970 (again)
  * added the JiggHttpClient-Interface to enable custom httpclients plugability

0.4 Oct 02, 2008
  * fixed getPopularStories() to use getPopularStories(StoriesArguments) instead of getStories(StoriesArguments)
  * created Media as an enum of News, Videos, Images
  * added "SORT\_DIGG\_COUNT\_ASC" and "SORT\_DIGG\_COUNT\_DESC to StoriesArguments
  * added setMinDate(Date) and setMaxDate(Date) to StoriesArguments
  * added setMedia(Media...) to StoriesArguments
  * added getMedia() to Story

0.3 Oct 01, 2008
  * implemented more endpoints

0.2 Sep 29, 2008
  * refactoring of the Arguments classes
  * fixed wrong handling of dates, using seconds instead of milliseconds since 1.1.1970

0.1 Nov 03, 2007
  * first version released