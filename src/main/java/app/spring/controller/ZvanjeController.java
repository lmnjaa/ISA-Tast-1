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

import app.spring.dto.ZvanjeDTO;
import app.spring.model.Nastavnik;
import app.spring.model.Zvanje;
import app.spring.service.NastavnikService;
import app.spring.service.ZvanjeService;


@Controller
@RequestMapping(path = "/api/zvanja")
public class ZvanjeController
{

    @Autowired
    private ZvanjeService zvanjeService;

    @Autowired
    NastavnikService nastavnikService;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ResponseEntity<List<ZvanjeDTO>> getAllZvanja(){
        List<ZvanjeDTO> zvanja = new ArrayList<>();

        for(Zvanje z: zvanjeService.findAll()){
            zvanja.add(new ZvanjeDTO(z));
        }

        return new ResponseEntity<>(zvanja, HttpStatus.OK);

    }
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ZvanjeDTO> getZvanje(@PathVariable("id") Long id){
        Zvanje zvanje = zvanjeService.findById(id);
        if(zvanje == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ZvanjeDTO zvanjeDTO = new ZvanjeDTO(zvanje);
        return new ResponseEntity<ZvanjeDTO>(zvanjeDTO, HttpStatus.OK);
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<ZvanjeDTO> store(@RequestBody ZvanjeDTO novoZvanje){
        Nastavnik nastavnik = nastavnikService.findById(novoZvanje.getNastavnikId());
        if(nastavnik == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Zvanje zvanje = new Zvanje(novoZvanje.getDatumIzbora(), novoZvanje.getDatumPrestanka(), null, nastavnik, null);
        zvanjeService.save(zvanje);
        return new ResponseEntity<ZvanjeDTO>(new ZvanjeDTO(zvanje), HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ZvanjeDTO> update(@PathVariable("id") Long id, @RequestBody Zvanje dobijenoZvanje){
        Zvanje zvanje = zvanjeService.findById(id);
        if(zvanje == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        zvanje.setDatumIzbora(dobijenoZvanje.getDatumIzbora());
        zvanje.setDatumPrestanka(dobijenoZvanje.getDatumPrestanka());
        zvanjeService.save(zvanje);
        ZvanjeDTO zvanjeDTO = new ZvanjeDTO(zvanje);
        return new ResponseEntity<ZvanjeDTO>(zvanjeDTO, HttpStatus.OK);

    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ZvanjeDTO> delete(@PathVariable("id") Long id){
        Zvanje zvanje = zvanjeService.findById(id);
        if(zvanje == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        zvanjeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}