package org.example.comparator.student.comparator;

import java.util.Comparator;
import org.example.model.Student;


public interface StudentComparator extends Comparator<Student> {

  @Override
  int compare(Student o1, Student o2);
}
