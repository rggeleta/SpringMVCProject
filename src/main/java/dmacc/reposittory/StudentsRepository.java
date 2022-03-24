package dmacc.reposittory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.model.Student;


@Repository
public interface StudentsRepository extends JpaRepository<Student, Long> {

}