import java.time.LocalDate;
import java.time.LocalDateTime;

public class YearlyTask extends Task{
    public YearlyTask (String taskHeading, TaskType type, String taskDescription, LocalDateTime dateTime) throws IncorrectArgumentException{
        super(taskHeading, type, taskDescription, dateTime);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        LocalDate taskDate = this.getDateTime().toLocalDate();
        return localDate.equals(taskDate) || (localDate.isAfter(taskDate) && localDate.getMonth() == taskDate.getMonth() && localDate.getDayOfMonth() == taskDate.getDayOfMonth());
    }
}
