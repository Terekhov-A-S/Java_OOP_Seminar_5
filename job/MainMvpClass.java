package job;

import job.model.attandance.AttendanceGroup;
import job.model.attandance.AttendanceVisitStudent;
import job.model.students.Student;
import job.model.students.StudentGroup;
import job.presenter.Presenter;
import job.view.controller.*;

public class MainMvpClass {

    public static void main(String[] args) {
// Создание объектов студентов
        Student Vasiliy = new Student("Василий", 1);
        Student Viktoriya = new Student("Виктория", 1);
        Student Afanasiy = new Student("Афанасий", 1);
        Student Sofiya = new Student("София", 1);
// Создание объекта группы студентов
        StudentGroup studentGroupOneCourse = new StudentGroup();
// Добавление студентов в группу студентов
        studentGroupOneCourse.addStudentInGroup(Vasiliy);
        studentGroupOneCourse.addStudentInGroup(Viktoriya);
        studentGroupOneCourse.addStudentInGroup(Afanasiy);
        studentGroupOneCourse.addStudentInGroup(Sofiya);
        // System.out.println(studentGroupOneCourse);


// Создание объекта о посещении студентов
        AttendanceVisitStudent attendanceVisitingVasiliy = new AttendanceVisitStudent(Vasiliy);
        AttendanceVisitStudent attendanceVisitingViktoriya = new AttendanceVisitStudent(Viktoriya);
        AttendanceVisitStudent attendanceVisitingAfanasiy = new AttendanceVisitStudent(Afanasiy);
        AttendanceVisitStudent attendanceVisitingSofiya = new AttendanceVisitStudent(Sofiya);
// список посещений студентов
        attendanceVisitingViktoriya.addVisiting("01-01-2023", true);
        attendanceVisitingViktoriya.addVisiting("02-01-2023", true);
        attendanceVisitingViktoriya.addVisiting("03-01-2023", true);
        attendanceVisitingViktoriya.addVisiting("04-01-2023", true);
        attendanceVisitingViktoriya.addVisiting("05-01-2023", true);
        attendanceVisitingViktoriya.addVisiting("06-01-2023", false);
        attendanceVisitingViktoriya.addVisiting("07-01-2023", true);

        attendanceVisitingAfanasiy.addVisiting("01-01-2023", false);
        attendanceVisitingAfanasiy.addVisiting("02-01-2023", false);
        attendanceVisitingAfanasiy.addVisiting("03-01-2023", false);
        attendanceVisitingAfanasiy.addVisiting("04-01-2023", false);
        attendanceVisitingAfanasiy.addVisiting("05-01-2023", false);
        attendanceVisitingAfanasiy.addVisiting("06-01-2023", false);
        attendanceVisitingAfanasiy.addVisiting("07-01-2023", true);

        attendanceVisitingSofiya.addVisiting("01-01-2023", true);
        attendanceVisitingSofiya.addVisiting("02-01-2023", true);
        attendanceVisitingSofiya.addVisiting("03-01-2023", true);
        attendanceVisitingSofiya.addVisiting("04-01-2023", true);
        attendanceVisitingSofiya.addVisiting("05-01-2023", true);
        attendanceVisitingSofiya.addVisiting("06-01-2023", true);
        attendanceVisitingSofiya.addVisiting("07-01-2023", true);

        attendanceVisitingVasiliy.addVisiting("01-01-2023", true);
        attendanceVisitingVasiliy.addVisiting("02-01-2023", false);
        attendanceVisitingVasiliy.addVisiting("03-01-2023", true);
        attendanceVisitingVasiliy.addVisiting("04-01-2023", true);
        attendanceVisitingVasiliy.addVisiting("05-01-2023", true);
        attendanceVisitingVasiliy.addVisiting("06-01-2023", false);
        attendanceVisitingVasiliy.addVisiting("07-01-2023", true);
// Создание объекта посещаемости группы
        AttendanceGroup attendanceGroupOneCourse = new AttendanceGroup();
// Добавление в группу посещаемости, студентов с их посещаемостью
        attendanceGroupOneCourse.addAttendanceVisit(attendanceVisitingVasiliy);
        attendanceGroupOneCourse.addAttendanceVisit(attendanceVisitingAfanasiy);
        attendanceGroupOneCourse.addAttendanceVisit(attendanceVisitingViktoriya);
        attendanceGroupOneCourse.addAttendanceVisit(attendanceVisitingSofiya);
// Создание объекта контроллера посещения группы
        ControllerAttendanceGroup controllerGroup = new ControllerAttendanceGroup(attendanceGroupOneCourse);

// Работа методов объекта контроллера
        // controllerGroup.PrintStudentsVisitingPercent(studentGroupOneCourse);
        // controllerGroup.PrintStudentsVisitingLess25Persent(studentGroupOneCourse);
        // controllerGroup.PrintSortStudentsVisiting(studentGroupOneCourse);

// Работа Presenter одна кнопка для всех команд
        Presenter presenter = new Presenter(controllerGroup, studentGroupOneCourse);
        presenter.button_start_all_command();
    }
}