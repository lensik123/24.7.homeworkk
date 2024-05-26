package org.example.comparator.university.comparator;

import java.util.Comparator;
import org.example.model.University;

public interface UniversityComparator extends Comparator<University> {

  @Override
  int compare(University o1, University o2);
}
