package de.thesuntoucher.jigg.data;

/**
 * <container name="Technology" short_name="technology"/>
 * 
 */
public class Container {

	private String name, shortName;

	/**
	 * @param name
	 * @param shortName
	 */
	public Container(String name, String shortName) {
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name + " (" + shortName + ")";
	}
}