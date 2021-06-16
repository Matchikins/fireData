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
import com.br.cefops.cefopsBD.domain.Alunos;
import com.br.cefops.cefopsBD.repository.AlunoInterface;

@RestController
@CrossOrigin
public class AlunoResource {
	
	@Autowired
	AlunoInterface alunointerface;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<?> hello() {

		return ResponseEntity.status(HttpStatus.OK).body("tudo ok");
	}

	@ResponseBody
	@RequestMapping(value = "/alunos", method = RequestMethod.POST)
	public ResponseEntity<?> novoAluno(@RequestBody Alunos aluno) {
		Optional<Alunos> optAluno = alunointerface.findById(aluno.getId());
		if (optAluno.isPresent())
			return ResponseEntity.status(HttpStatus.CONFLICT).body("");
		alunointerface.save(aluno);
		return ResponseEntity.status(HttpStatus.CREATED).body(aluno);
	}

	@RequestMapping(value = "/alunos/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> obterAlunosRa(@PathVariable Integer id) {
		Optional<Alunos> optAluno = alunointerface.findById(id);
		if (optAluno.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(optAluno.get());
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

	@RequestMapping(value = "/alunos/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> eliminarAlunosRa(@PathVariable Integer id) {
		Optional<Alunos> optAluno = alunointerface.findById(id);
		if (!optAluno.isPresent()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		alunointerface.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body(optAluno.get());
	}

	@ResponseBody
	@RequestMapping(value = "/alunos/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> alterarAluno(@PathVariable Integer id, @RequestBody Alunos alunoNovo) {
		Optional<Alunos> optAluno = alunointerface.findById(id);
		if (!optAluno.isPresent())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");

		Alunos alunoCorrente = optAluno.get();
		if (alunoNovo.getEmail() != null && alunoNovo.getEmail().length() > 0) {
			alunoCorrente.setEmail(alunoNovo.getEmail());
		}
		if (alunoNovo.getName() != null && alunoNovo.getName().length() > 0) {
			alunoCorrente.setName(alunoNovo.getName());
		}
		alunointerface.save(alunoCorrente);
		return ResponseEntity.status(HttpStatus.OK).body(alunoCorrente);
	}

	@RequestMapping(value = "/alunos", method = RequestMethod.GET)
	public ResponseEntity<?> obterAlunos() {
		List<Alunos> alunos = alunointerface.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(alunos);
	}

	
}
