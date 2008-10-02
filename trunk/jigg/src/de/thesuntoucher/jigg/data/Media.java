package de.thesuntoucher.jigg.data;

/**
 * http://apidoc.digg.com/ListMedia
 * 
 * <media timestamp="1196888458">
 * 	<medium name="News" short_name="news" />
 * 	<medium name="Videos" short_name="videos" />
 * 	<medium name="Images" short_name="images" />
 * </media>
 */
public enum Media {
	
	NEWS("News", "news"), VIDEOS("Videos", "videos"), IMAGES("Images", "images");

	private final String name, shortName;
	
	Media(String name, String shortName) {
		this.name = name;
		this.shortName = shortName;
	}

	public String getName() {
		return name;
	}

	public String getShortName() {
		return shortName;
	}
}
