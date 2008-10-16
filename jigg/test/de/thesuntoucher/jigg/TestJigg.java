package de.thesuntoucher.jigg;

import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;
import de.thesuntoucher.jigg.args.EventsArguments;
import de.thesuntoucher.jigg.args.StoriesArguments;
import de.thesuntoucher.jigg.data.*;
import de.thesuntoucher.jigg.net.ApacheHttpClient;

public class TestJigg extends TestCase {
	
	private Jigg jigg = null;
	
	@Override
	protected void setUp() throws Exception {
		jigg = new Jigg("http://code.google.com/p/jigg/");
		jigg.setHttpClient(new ApacheHttpClient());
	}

	public void testGetStories(){
		
		// get 5 Stories
		Stories stories = jigg.getStories(new StoriesArguments()
			.setSort(StoriesArguments.SORT_DIGG_COUNT_DESC)
			.setCount(5));
		
		assertEquals(5, stories.size());
		
		sleep();
		
		// get only VIDEOS and IMAGES 
		List<Media> validMedia = Arrays.asList(Media.VIDEOS, Media.IMAGES);
		stories = jigg.getStories(new StoriesArguments().setMedia(Media.VIDEOS, Media.IMAGES));
	
		for (Story story : stories) {
			assertTrue("Media was '" + story.getMedia() + "' but should be one of " + validMedia, 
					validMedia.contains(story.getMedia()));
		}
		
		sleep();
		
		// Popular Stories must have a PromoteDate
		for (Story story : jigg.getPopularStories()) {
			assertNotNull(story.getPromoteDate());
		}
	}
	
	public void testGetDiggs(){
		
		Events<Digg> diggs = jigg.getDiggs(new EventsArguments().setCount(100));
		for (Digg digg : diggs) {
			System.out.println(digg);
		}
		
	}
	
	private void sleep(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
		TestJigg testJigg = new TestJigg();
		testJigg.setUp();
		testJigg.testGetDiggs();
	}

}
