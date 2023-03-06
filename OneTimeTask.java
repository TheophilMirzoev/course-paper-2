import java.time.LocalDate;
import java.time.LocalDateTime;

public class OneTimeTask extends Task{
    public OneTimeTask(String taskHeading, TaskType type, String taskDescription, LocalDateTime dateTime) throws IncorrectArgumentException{
        super(taskHeading, type, taskDescription, dateTime);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
       return localDate.equals(this.getDateTime().toLocalDate());
    }

}
