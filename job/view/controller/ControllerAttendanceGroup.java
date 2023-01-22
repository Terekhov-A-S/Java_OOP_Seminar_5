package job.view.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import job.model.attandance.AttendanceGroup;
import job.model.attandance.AttendanceVisitStudent;
import job.model.students.Student;
import job.model.students.StudentGroup;

public class ControllerAttendanceGroup {

    AttendanceGroup attendanceGroup;
    Student student;
    AttendanceVisitStudent attendanceVisit;
    Map<String, Integer> sortedStudentVisit;

    public ControllerAttendanceGroup(AttendanceGroup attendanceGroup) {
        this.attendanceGroup = attendanceGroup;
        this.sortedStudentVisit = new TreeMap<>();
    }

    public AttendanceGroup getAttendanceGroup() {
        return attendanceGroup;
    }

    public Student getStudent() {
        return student;
    }

    public AttendanceVisitStudent getAttendanceVisit() {
        return attendanceVisit;
    }

    // Метод сортировки группы студентов по посещаемости
    public void PrintSortStudentsVisiting(StudentGroup studentGroup) {
        List<String> sortListStudent = new ArrayList<>();
        for (AttendanceVisitStudent attendanceVisit : attendanceGroup.getAttendanceView()) {
            int countTrue = 0;
            for (Boolean boolean1 : attendanceVisit.getVisit().values()) {
                if (boolean1 == true) {
                    countTrue++;
                }
            }
            sortedStudentVisit.put(attendanceVisit.getStudent().getName(), countTrue);
        }
        for (String iterable : sortedStudentVisit.keySet()) {
            sortListStudent.add(iterable);
        }
        System.out.println("_-=#=-_-=#=-_-=#=-_-=#=-_-=#=-_-=#=-_-=#=-_");
        System.out.println("Список посещаемости студентов по убыванию:");
        for (int i = sortListStudent.size() - 1; i >= 0; i--) {
            System.out.println(sortListStudent.get(i));
        }
    }

    // Метод выводящий список людей из группы с посещаемостью ниже 25%
    public void PrintStudentsVisitingLess25Persent(StudentGroup studentGroup) {
        for (AttendanceVisitStudent attendanceVisit : attendanceGroup.getAttendanceView()) {
            int count = 0;
            int countTrue = 0;
            for (Boolean boolean1 : attendanceVisit.getVisit().values()) {
                if (boolean1 == true) {
                    countTrue++;
                }
                count++;
            }
            if ((float) count / 100 * 25 > countTrue) {
                System.out.println(attendanceVisit.getStudent().getName() + " - процент посещения ниже 25%");
            }
        }
    }

    // Метод показывающий в процентах посещение студентов группы
    public void PrintStudentsVisitingPercent(StudentGroup studentGroup) {
        for (AttendanceVisitStudent attendanceVisit : attendanceGroup.getAttendanceView()) {
            int count = 0;
            int countTrue = 0;
            for (Boolean boolean1 : attendanceVisit.getVisit().values()) {
                if (boolean1 == true) {
                    countTrue++;
                }
                count++;
            }
            System.out.println(attendanceVisit.getStudent().getName() + " - процент посещения = "
                    + (float) countTrue * 100 / count + "\n");
        }
    }

}