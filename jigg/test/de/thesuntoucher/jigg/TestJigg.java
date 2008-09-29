package de.thesuntoucher.jigg;

import java.util.Date;

import de.thesuntoucher.jigg.args.StoriesArguments;
import de.thesuntoucher.jigg.data.Stories;
import de.thesuntoucher.jigg.data.Story;

public class TestJigg {
	
	public static void main(String[] args) {
		
		Date today = new Date();
		
		Jigg jigg = new Jigg("http://code.google.com/p/jigg/");
		
		Stories stories = jigg.getStories(new StoriesArguments()
				.setMaxSubmit(today)
				.setCount(5));
		
		for (Story story : stories) {
			System.out.println(story.getTitle());
		}
		
		
//		System.out.println(new Date(1222674335l * 1000l));
//		System.out.println(new Date(1222674255675l));
		
	}

}
