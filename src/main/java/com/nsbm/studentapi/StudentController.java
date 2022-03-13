package com.nsbm.studentapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(path = "/api")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    private static Logger logger = LoggerFactory.getLogger(StudentController.class);

    @PostMapping(value = "/members",consumes = "application/json", produces = "application/json")
    public Student saveNewStudent(@RequestBody Student student){
        // FileHandler fh;
        // fh =new FileHandler("StudentController.log");
        // logger.addHandler(fh);
        logger.info("Successfully created  "+ student);
        return studentRepository.save(student);
    }

    @GetMapping(value = "/members/{id}")
    public Optional<Student> getStudent(@PathVariable Long id){
        return studentRepository.findById(id);
    }

    @PutMapping(value = "/members/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student){
        Student oldStudent = studentRepository.findById(id).get();
        BeanUtils.copyProperties(student,oldStudent);
        oldStudent.setId(id);
        logger.info("successfully updated student "+id);
        return studentRepository.save(oldStudent);
    }

    @GetMapping(value = "/{category}/members")
    public List<Student> filterStudentByCategory(@PathVariable String category){
        Iterable<Student> elements = studentRepository.findAll();
        List<Student> list = StreamSupport.stream(elements.spliterator(),false).collect(Collectors.toList());
        List<Student> filtered = list.stream().filter(student -> student.getType().equals(category)).collect(Collectors.toList());
        return filtered;
    }

    @DeleteMapping(value = "/members/{id}")
    public ResponseEntity<Long> deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
        logger.info("Successfully deleted the student "+id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping(value = "/allmembers")
    public Iterable<Student> getAllStudents(){
        return studentRepository.findAll();
    }

}
