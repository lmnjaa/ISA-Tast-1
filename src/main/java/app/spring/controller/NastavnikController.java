package app.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import app.spring.dto.NastavnikDTO;
import app.spring.model.Nastavnik;
import app.spring.service.NastavnikService;

@Controller
@RequestMapping(path = "/api/nastavnici")
public class NastavnikController {
	
	@Autowired
    private NastavnikService nastavnikService;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ResponseEntity<List<NastavnikDTO>> getAllNastavnici(){
        List<NastavnikDTO> nastavnici = new ArrayList<>();

        for(Nastavnik n: nastavnikService.findAll()){
            nastavnici.add(new NastavnikDTO(n));
        }
        return new ResponseEntity<>(nastavnici, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<NastavnikDTO> getNastavnik(@PathVariable("id") Long id){
        Nastavnik nastavnik = nastavnikService.findById(id);
        if(nastavnik == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        NastavnikDTO nastavnikDTO = new NastavnikDTO(nastavnik);

        return new ResponseEntity<NastavnikDTO>(nastavnikDTO, HttpStatus.OK);

    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<NastavnikDTO> store(@RequestBody Nastavnik noviNastavnik){
        if(nastavnikService.findOne(noviNastavnik.getJmbg()) != null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        nastavnikService.save(noviNastavnik);
        NastavnikDTO nastavnikDTO = new NastavnikDTO(noviNastavnik);
        return new ResponseEntity<NastavnikDTO>(nastavnikDTO, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<NastavnikDTO> update(@PathVariable("id") Long id, @RequestBody Nastavnik dobijeniNastavnik){
        Nastavnik nastavnik = nastavnikService.findById(id);
        if(nastavnik == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        nastavnik.setIme(dobijeniNastavnik.getIme());
        nastavnik.setBiografija(dobijeniNastavnik.getBiografija());
        nastavnikService.save(nastavnik);
        NastavnikDTO nastavnikDTO = new NastavnikDTO(nastavnik);
        return new ResponseEntity<NastavnikDTO>(nastavnikDTO, HttpStatus.OK);

    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<NastavnikDTO> delete(@PathVariable("id") Long id){
        Nastavnik nastavnik = nastavnikService.findById(id);
        if(nastavnik == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        nastavnikService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
