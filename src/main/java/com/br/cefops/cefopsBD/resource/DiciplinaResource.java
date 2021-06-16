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
import com.br.cefops.cefopsBD.domain.Disciplinas;
import com.br.cefops.cefopsBD.repository.DiciplinaInterface;

@RestController
@CrossOrigin
public class DiciplinaResource {
	@Autowired
	DiciplinaInterface diciplinainterface;
	
	
	@ResponseBody
	@RequestMapping(value = "/diciplinas", method = RequestMethod.POST)
	public ResponseEntity<?> novodiciplina(@RequestBody Disciplinas diciplina) {
		Optional<Disciplinas> optdiciplina = diciplinainterface.findById(diciplina.getId());
		if (optdiciplina.isPresent())
			return ResponseEntity.status(HttpStatus.CONFLICT).body("");
		diciplinainterface.save(diciplina);
		return ResponseEntity.status(HttpStatus.CREATED).body(diciplina);
	}


	@RequestMapping(value = "/diciplinas", method = RequestMethod.GET)
	public ResponseEntity<?> obterdiciplinas() {
		List<Disciplinas> diciplinas = diciplinainterface.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(diciplinas);
	}

}
