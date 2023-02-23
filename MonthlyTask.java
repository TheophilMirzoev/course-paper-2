import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyTask extends Task{
    public MonthlyTask(String taskHeading, TaskType type, String taskDescription, LocalDateTime dateTime) {
        super(taskHeading, type, taskDescription, dateTime);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        LocalDate taskDate = this.getDateTime().toLocalDate();
        return localDate.equals(taskDate) || (localDate.isAfter(taskDate) && localDate.getMonth() == taskDate.getMonth());
    }
}
