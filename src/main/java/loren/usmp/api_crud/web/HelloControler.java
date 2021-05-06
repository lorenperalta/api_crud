package loren.usmp.api_crud.web;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.*;
import loren.usmp.api_crud.domain.*;
import loren.usmp.api_crud.repository.*;


@RestController
public class HelloControler {

    private EmployeeRepository employeeRepository;
    
    @RequestMapping("/")
    public String Index(){
        return "Aloja";
    }

    public HelloControler(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    
    @RequestMapping("/empleaos")
    public List<Employee> index(){
        return employeeRepository.findAll();
    }

    @GetMapping(value = "/empleaos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> employees(){
        return  new ResponseEntity<List<Employee>>(
            employeeRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/empleao", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> create(@RequestBody Employee e){
        employeeRepository.save(e);
        employeeRepository.flush();
        return new ResponseEntity<Integer>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/empleaos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> employees(@PathVariable int id){
        Optional<Employee> optinalEntity = employeeRepository.findById(id);
        if(optinalEntity.isPresent())
            return new ResponseEntity<Employee>(
                optinalEntity.get(), HttpStatus.OK);
        else
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/empleaos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@PathVariable int id){
        employeeRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(value = "/empleao", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> update(@RequestBody Employee e){
        create(e);
        return new ResponseEntity<Employee>(HttpStatus.OK);
    }

}
