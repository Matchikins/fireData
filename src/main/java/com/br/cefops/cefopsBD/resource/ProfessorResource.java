package com.br.cefops.cefopsBD.resource;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.br.cefops.cefopsBD.domain.Professor;
import com.br.cefops.cefopsBD.repository.ProfessorInterface;

@RestController
@CrossOrigin
public class ProfessorResource {
	@Autowired
	ProfessorInterface professorinterface; 
	
	

	@ResponseBody
	@RequestMapping(value = "/professors", method = RequestMethod.POST)
	public ResponseEntity<?> novoprofessor(@RequestBody Professor professor) {
		Optional<Professor> optprofessor = professorinterface.findById(professor.getId());
		if (optprofessor.isPresent())
			return ResponseEntity.status(HttpStatus.CONFLICT).body("");
		professorinterface.save(professor);
		return ResponseEntity.status(HttpStatus.CREATED).body(professor);
	}

	@RequestMapping(value = "/professors/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> obterprofessorsRa(@PathVariable Integer id) {
		Optional<Professor> optprofessor = professorinterface.findById(id);
		if (optprofessor.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(optprofessor.get());
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

	@RequestMapping(value = "/professors/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> eliminarprofessorsRa(@PathVariable Integer id) {
		Optional<Professor> optprofessor = professorinterface.findById(id);
		if (!optprofessor.isPresent()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		professorinterface.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body(optprofessor.get());
	}

	@ResponseBody
	@RequestMapping(value = "/professors/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> alterarprofessor(@PathVariable Integer id, @RequestBody Professor professorNovo) {
		Optional<Professor> optprofessor = professorinterface.findById(id);
		if (!optprofessor.isPresent())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");

		Professor professorCorrente = optprofessor.get();
		if (professorNovo.getEmail() != null && professorNovo.getEmail().length() > 0) {
			professorCorrente.setEmail(professorNovo.getEmail());
		}
		if (professorNovo.getName() != null && professorNovo.getName().length() > 0) {
			professorCorrente.setName(professorNovo.getName());
		}
		professorinterface.save(professorCorrente);
		return ResponseEntity.status(HttpStatus.OK).body(professorCorrente);
	}

	@RequestMapping(value = "/professors", method = RequestMethod.GET)
	public ResponseEntity<?> obterprofessors() {
		List<Professor> professors = professorinterface.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(professors);
	}

}
