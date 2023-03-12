import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeeklyTask extends  Task{
    public WeeklyTask(String taskHeading, TaskType type, String taskDescription, LocalDateTime dateTime)throws IncorrectArgumentException {
        super(taskHeading, type, taskDescription, dateTime);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        LocalDate taskDate = this.getDateTime().toLocalDate();
        return  localDate.equals(taskDate) || (localDate.isAfter(taskDate) && localDate.getDayOfWeek().equals(taskDate.getDayOfWeek()));
    }
}
