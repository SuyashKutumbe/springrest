package spring.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import spring.bean.Country;

@XmlRootElement(name = "countries")
public class CountryService implements Serializable {
	static List<Country> listOfCountries = new ArrayList<>();
	/**
	 * 
	 */
	private static final long serialVersionUID = -3265677030195409959L;

	public CountryService() {
		Country indiaCountry = new Country(1, "India");
		Country chinaCountry = new Country(4, "China");
		Country nepalCountry = new Country(3, "Nepal");
		Country bhutanCountry = new Country(2, "Bhutan");

		
		listOfCountries.add(indiaCountry);
		listOfCountries.add(chinaCountry);
		listOfCountries.add(nepalCountry);
		listOfCountries.add(bhutanCountry);
	}
	
	// Utiliy method to create country list.
	public static List<Country> createCountryList() {
		return listOfCountries;
	}
	
	public List<Country> sortCountryListByGivenParameter(final String sortBy) {
		if(sortBy != null) {
			Collections.sort(listOfCountries, new Comparator<Country>(){
			
				@Override
				public int compare(Country c1, Country c2) {
					if("id".equals(sortBy))
						return c1.getId()-c2.getId();
					else
						return c1.getCountryName().compareTo(c2.getCountryName());
				}		
			});
		}
		return listOfCountries;
	}

	public Country addCountry(Country country) {
		Country newCountry = country;
		newCountry.setId(listOfCountries.get(listOfCountries.size() - 1).getId() + 1);
		listOfCountries.add(newCountry);
		
		return newCountry;
	
	}

	public boolean deleteCountry(int id) {
		Iterator<Country> iterator = listOfCountries.iterator();
		boolean deleteSuccess=false;
		while(iterator.hasNext()) {
			if(id == iterator.next().getId()) {
				iterator.remove();
				deleteSuccess = true;
				break;
			}
		}
		return deleteSuccess;
	}

	public Country updateCountry(int id, Country country) {
		Country newCountry = country;
		newCountry.setId(id);
		Iterator<Country> iterator = listOfCountries.iterator();
		while(iterator.hasNext()) {
			if(id == iterator.next().getId()) {
				iterator.remove();
				break;
			}
		}
		listOfCountries.add(newCountry);
		return newCountry;
	}
}
