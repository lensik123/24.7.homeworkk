package org.example;


import lombok.Builder;

@Builder
public class Student {
    String fullName, universityId;
    int currentCourseNumber;
    float avgExamScore;

    public Student() {
    }

    public Student(String fullName, String universityId, int currentCourseNumber, float avgExamScore) {
        this.fullName = fullName;
        this.universityId = universityId;
        this.currentCourseNumber = currentCourseNumber;
        this.avgExamScore = avgExamScore;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUniversityId() {
        return universityId;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    @Override
    public String toString() {
        return "Student:" +
                "{\nName: " + this.fullName +
                "\nUniversity id: " + this.universityId +
                "\nCurrent course number: " + this.currentCourseNumber +
                "\nAverage exam score: " + avgExamScore +
                "\n}";
    }

    //использовал вместо этого библиотеку lombok;

//    public static class studentBuilder {
//        String fullName, universityId;
//        int currentCourseNumber;
//        float avgExamScore;
//
//        public studentBuilder fullName(String fullName) {
//            this.fullName = fullName;
//            return this;
//        }
//
//        public studentBuilder universityId(String universityId) {
//            this.universityId = universityId;
//            return this;
//        }
//
//        public studentBuilder currentCourseNumber(int currentCourseNumber) {
//            this.currentCourseNumber = currentCourseNumber;
//            return this;
//        }
//
//        public studentBuilder avgExamScore(float avgExamScore) {
//            this.avgExamScore = avgExamScore;
//            return this;
//        }
//
//        public Student build(){
//            return new Student(fullName, universityId, currentCourseNumber, avgExamScore);
//        }
//    }

}
