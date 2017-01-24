package spring.controller;
	
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.bean.Country;
import spring.service.CountryService;
@RestController
public class CountryController {

	CountryService countryService = new CountryService();
	//@RequestMapping(value = "/countries", method=RequestMethod.GET, headers = "Accept=application/json", produces=MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/countries", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Country> getCountries() {
		List<Country> listOfCountries;
		listOfCountries = CountryService.createCountryList();
		return listOfCountries;
	}

	@RequestMapping(value = "/countries/{id}", method = RequestMethod.GET)
	public Country getCountryById(@PathVariable int id) {
		List<Country> listOfCountries;
		listOfCountries = CountryService.createCountryList();

		for (Country country : listOfCountries) {
			if (country.getId() == id)
				return country;
		}

		return null;
	}

	@RequestMapping(value="/countries", params={"sortBy"})
	public List<Country> getCountryByFilter(@RequestParam(value="sortBy") String sortBy){
			return countryService.sortCountryListByGivenParameter(sortBy);
		
	}
	
	@RequestMapping(value="/countries/add", method=RequestMethod.POST)
	public Country addCountry(@RequestBody Country country) {
		return countryService.addCountry(country);
	}
	
	@RequestMapping(value="/countries/delete/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?>  deleteCountry(@PathVariable int id) {
		boolean deleteSuccess = countryService.deleteCountry(id);
		if(deleteSuccess) 
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/countries/update/{id}", method=RequestMethod.PUT)
	public Country updateCountry(@PathVariable int id, @RequestBody Country country) {
		return countryService.updateCountry(id, country);
	}
	
}