package de.thesuntoucher.jigg.data;

/**
 * <topic name="Apple" short_name="apple"/>
 * 
 */
public class Topic {

	private String name, shortName;
	private Container container;

	/**
	 * @param name
	 * @param shortName
	 */
	public Topic(String name, String shortName) {
		this.name = name;
		this.shortName = shortName;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the shortName
	 */
	public String getShortName() {
		return shortName;
	}

	/**
	 * @param shortName the shortName to set
	 */
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	/**
	 * @return the container
	 */
	public Container getContainer() {
		return container;
	}

	/**
	 * @param container the container to set
	 */
	public void setContainer(Container container) {
		this.container = container;
	}
}