package sg.edu.iss.sa50.t8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JsonParsingService implements ParsingService {
	
	@Autowired
	private RestTemplate restTemplate; 
	
	@Override
	public Object parse(String url) {
		// TODO Auto-generated method stub
		return restTemplate.getForObject(url, Object.class);
	}

}
