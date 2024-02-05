package HW42.Database.Schema.Management.HW42.Database.Schema.Management.repository;

import hogwarts.HW41.SQL.and.Paging.Hogwarts.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Collection<Student> findStudentByAge (int age);
    Collection<Student> findByAgeBetweenIgnoreCase(int min, int max);

    @Query(value = "SELECT COUNT(name) FROM students", nativeQuery = true)
    List<Integer> countNumberOfAllStudents ();

    @Query(value = "SELECT AVG (age) FROM students",nativeQuery = true)
    List<Double> countAverageAge();

    @Query(value = "SELECT * FROM students OFFSET (SELECT COUNT(*) - 5 FROM students) LIMIT 5", nativeQuery = true)
    List<Student> getLastFiveStudents();



}
