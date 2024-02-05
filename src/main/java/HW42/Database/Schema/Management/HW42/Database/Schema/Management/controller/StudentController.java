package HW42.Database.Schema.Management.HW42.Database.Schema.Management.controller;


import hogwarts.HW41.SQL.and.Paging.Hogwarts.model.Student;
import hogwarts.HW41.SQL.and.Paging.Hogwarts.service.AvatarService;
import hogwarts.HW41.SQL.and.Paging.Hogwarts.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;


@RestController
@RequestMapping("student")
public class StudentController {

    private final StudentService studentService;
    private final AvatarService avatarService;

    public StudentController(StudentService studentService, AvatarService avatarService) {
        this.studentService = studentService;
        this.avatarService = avatarService;
    }


    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> find(@PathVariable Long id) {
        Student student = studentService.find(id);
        if (student == null) {
            return ResponseEntity.notFound().build();

        }
        return ResponseEntity.ok(student);

    }

    @PutMapping
    public ResponseEntity<Student> changeStudentInfo(@RequestBody Student student) {
        Student changeStudent = studentService.changeStudentInfo(student);
        if (changeStudent == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(changeStudent);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Student> removeStudent(@PathVariable Long id) {
        studentService.removeStudent(id);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/all-students")
    public ResponseEntity<Collection<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/search-age")
    public Collection<Student> findStudentByAge(@PathVariable Integer age) {
        return studentService.findStudentByAge(age);
    }

    @GetMapping("/sort-age")
    public Collection<Student> findByAgeBetween(@RequestParam int min, @RequestParam int max) {
        return studentService.findByAgeBetween(min, max);

    }

    @GetMapping("/get-all-student-amount")
    public List<Integer> countNumberOfAllStudents() {
        return studentService.countNumberOfAllStudents();
    }

    @GetMapping("/average-age")
    public List<Double> countAvgAge() {
        return studentService.countAvgAge();
    }

    @GetMapping ("/show-last-five-students")
    public List <Student> countLastFiveStudents(){
        return studentService.countLastFiveStudents();
    }

}
