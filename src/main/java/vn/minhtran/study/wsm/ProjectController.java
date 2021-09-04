package vn.minhtran.study.wsm;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("project")
public class ProjectController {

	@GetMapping("/get/{id}")
	public Project get(@PathVariable(name = "id", required = true) String id) {
		return null;
	}
}
