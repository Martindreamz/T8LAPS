package sg.edu.iss.sa50.t8.service;

import org.springframework.stereotype.Service;

@Service
public interface ParsingService {
	Object parse(String url);
}
