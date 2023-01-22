package job.presenter;

import job.model.students.StudentGroup;
import job.view.controller.ControllerAttendanceGroup;

public class Presenter {
    private ControllerAttendanceGroup view;
    private StudentGroup model;

    public Presenter(ControllerAttendanceGroup view, StudentGroup model) {
        this.view = view;
        this.model = model;
    }

    // создание кнопки для вывода всех команд в задании
    public void button_start_all_command() {
        view.PrintStudentsVisitingPercent(model);
        view.PrintStudentsVisitingLess25Persent(model);
        view.PrintSortStudentsVisiting(model);
    }


}
