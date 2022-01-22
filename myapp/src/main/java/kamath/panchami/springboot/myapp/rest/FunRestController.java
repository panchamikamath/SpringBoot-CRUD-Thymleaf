package kamath.panchami.springboot.myapp.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	@Value("${coach.name}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;
	
	@GetMapping("/")
	public String getHello() {
		return "Hello World! Time on Server is " + LocalDateTime.now();
	}
	
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Daily workouts are important";
	}
	
	@GetMapping("/teamInfo")
	public String getProperties() {
		return "Coach " + coachName + ", Team name " + teamName;
	}
}

