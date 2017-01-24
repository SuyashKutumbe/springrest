package spring.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="country")
@XmlAccessorType(XmlAccessType.NONE)
public class Country implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3667574663539814126L;

	@XmlElement
	int id;
	
	@XmlElement
	String countryName;

	public Country() {
		// TODO Auto-generated constructor stub
	}
	
	public Country(int i, String countryName) {
		super();
		this.id = i;
		this.countryName = countryName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@Override
	public String toString() {
		return "Country [getId()=" + getId() + ", getCountryName()=" + getCountryName() + "]";
	}

	
}
