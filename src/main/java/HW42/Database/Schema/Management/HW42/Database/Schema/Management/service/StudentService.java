package HW42.Database.Schema.Management.HW42.Database.Schema.Management.service;

import HW42.Database.Schema.Management.HW42.Database.Schema.Management.model.Faculty;
import HW42.Database.Schema.Management.HW42.Database.Schema.Management.model.Student;
import HW42.Database.Schema.Management.HW42.Database.Schema.Management.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;


@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student find(long id) {
        return studentRepository.findById(id).get();
    }


    public Student changeStudentInfo(Student student) {
        return studentRepository.save(student);
    }

    public void removeStudent(Long id) {
        studentRepository.deleteById(id);
    }


    public Collection<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Collection<Student> findStudentByAge(int age) {
        return studentRepository.findStudentByAge(age);
    }

    public Collection<Student> findByAgeBetween(int min, int max) {
        return studentRepository.findByAgeBetweenIgnoreCase(min, max);
    }

    public Faculty findFacultyByStudent(long id) {
        return studentRepository.getReferenceById(id).getFaculty();
    }

    public List<Integer> countNumberOfAllStudents (){
        return studentRepository.countNumberOfAllStudents();
    }

    public List<Double> countAvgAge (){
        return studentRepository.countAverageAge();
    }
    public List<Student> countLastFiveStudents(){
        return studentRepository.getLastFiveStudents();
    }


}
