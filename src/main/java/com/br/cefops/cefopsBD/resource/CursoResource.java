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

import com.br.cefops.cefopsBD.domain.Curso;
import com.br.cefops.cefopsBD.repository.CursoInterface;

@RestController
@CrossOrigin
public class CursoResource {
	@Autowired
	CursoInterface cursointerface;
	

	@ResponseBody
	@RequestMapping(value = "/cursos", method = RequestMethod.POST)
	public ResponseEntity<?> novoAluno(@RequestBody Curso curso) {
		Optional<Curso> optCurso = cursointerface.findById(curso.getId());
		if (optCurso.isPresent())
			return ResponseEntity.status(HttpStatus.CONFLICT).body("");
		cursointerface.save(curso);
		return ResponseEntity.status(HttpStatus.CREATED).body(curso);
	}

	@RequestMapping(value = "/cursos/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> obterAlunosRa(@PathVariable Integer id) {
		Optional<Curso> optCurso = cursointerface.findById(id);
		if (optCurso.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(optCurso.get());
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

	@RequestMapping(value = "/cursos/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> eliminarAlunosRa(@PathVariable Integer id) {
		Optional<Curso> optCurso = cursointerface.findById(id);
		if (!optCurso.isPresent()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		cursointerface.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body(optCurso.get());
	}

	@ResponseBody
	@RequestMapping(value = "/cursos/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> alterarAluno(@PathVariable Integer id, @RequestBody Curso CursoNovo) {
		Optional<Curso> optCurso = cursointerface.findById(id);
		if (!optCurso.isPresent())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");

		Curso CursoCorrente = optCurso.get();
		
		if (CursoNovo.getName() != null && CursoNovo.getName().length() > 0) {
			CursoCorrente.setName(CursoNovo.getName());
		}
		cursointerface.save(CursoCorrente);
		return ResponseEntity.status(HttpStatus.OK).body(CursoCorrente);
	}

	@RequestMapping(value = "/cursos", method = RequestMethod.GET)
	public ResponseEntity<?> obterCursos() {
		List<Curso> cursos = cursointerface.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(cursos);
	}

}
