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
        Student Jon = new Student("Jon", 1);
        Student Sara = new Student("Sara", 1);
        Student Bill = new Student("Bill", 1);
// Создание объекта группы студентов
        StudentGroup studentGroupOneCourse = new StudentGroup();
// Добавление студентов в группу студентов
        studentGroupOneCourse.addStudentInGroup(Jon);
        studentGroupOneCourse.addStudentInGroup(Sara);
        studentGroupOneCourse.addStudentInGroup(Bill);
        // System.out.println(studentGroupOneCourse);


// Создание объекта о посещении студентов
        AttendanceVisitStudent attendanceVisitingJon = new AttendanceVisitStudent(Jon);
        AttendanceVisitStudent attendanceVisitingSara = new AttendanceVisitStudent(Sara);
        AttendanceVisitStudent attendanceVisitingBill = new AttendanceVisitStudent(Bill);
// список посещений студентов
        attendanceVisitingSara.addVisiting("01-01-2023", true);
        attendanceVisitingSara.addVisiting("02-01-2023", true);
        attendanceVisitingSara.addVisiting("03-01-2023", true);
        attendanceVisitingSara.addVisiting("04-01-2023", true);
        attendanceVisitingSara.addVisiting("05-01-2023", true);
        attendanceVisitingSara.addVisiting("06-01-2023", true);
        attendanceVisitingSara.addVisiting("07-01-2023", true);

        attendanceVisitingBill.addVisiting("01-01-2023", false);
        attendanceVisitingBill.addVisiting("02-01-2023", false);
        attendanceVisitingBill.addVisiting("03-01-2023", false);
        attendanceVisitingBill.addVisiting("04-01-2023", false);
        attendanceVisitingBill.addVisiting("05-01-2023", false);
        attendanceVisitingBill.addVisiting("06-01-2023", false);
        attendanceVisitingBill.addVisiting("07-01-2023", true);

        attendanceVisitingJon.addVisiting("01-01-2023", true);
        attendanceVisitingJon.addVisiting("02-01-2023", false);
        attendanceVisitingJon.addVisiting("03-01-2023", true);
        attendanceVisitingJon.addVisiting("04-01-2023", true);
        attendanceVisitingJon.addVisiting("05-01-2023", true);
        attendanceVisitingJon.addVisiting("06-01-2023", false);
        attendanceVisitingJon.addVisiting("07-01-2023", true);
// Создание объекта посещаемости группы
        AttendanceGroup attendanceGroupOneCourse = new AttendanceGroup();
// Добавление в группу посещаемости, студентов с их посещаемостью
        attendanceGroupOneCourse.addAttendanceVisit(attendanceVisitingJon);
        attendanceGroupOneCourse.addAttendanceVisit(attendanceVisitingBill);
        attendanceGroupOneCourse.addAttendanceVisit(attendanceVisitingSara);
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