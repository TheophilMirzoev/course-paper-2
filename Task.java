import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Task {
    private  String taskHeading;           //заголовок
    private  TaskType type;                // тип в enum
    private  String taskDescription;       // описание
    private  LocalDateTime dateTime;       // время создания
    private  int id;
    private static int counter;

    public Task(String taskHeading, TaskType type, String taskDescription, LocalDateTime dateTime) throws IncorrectArgumentException   {
        if ((taskHeading.isBlank() || taskHeading.isEmpty()) || (type.name.isEmpty() || type.name.isBlank())
                || (taskDescription.isBlank() || taskDescription.isEmpty()) || (dateTime == null)) {
            throw new IncorrectArgumentException("не верные данные", "");
        }
        this.taskHeading = taskHeading;
        this.type = type;
        this.taskDescription = taskDescription;
        this.dateTime = dateTime;

        id = counter++;
    }

    public boolean appearsIn(LocalDate localDate) {
        return true;
    }

    public String getTaskHeading() {
        return taskHeading;
    }

    public TaskType getType() {
        return type;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public int getId() {
        return id;
    }

    public void setTaskHeading(String taskHeading) {
        this.taskHeading = taskHeading;
    }

    public void setType(TaskType type) {
        this.type = type;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(taskHeading, task.taskHeading) && type == task.type && Objects.equals(taskDescription, task.taskDescription) && Objects.equals(dateTime, task.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskHeading, type, taskDescription, dateTime, id);
    }

    @Override
    public String toString() {
        return "Task{" + Task.class.getName() +
                "taskHeading='" + taskHeading + '\'' +
                ", type=" + type +
                ", taskDescription='" + taskDescription + '\'' +
                ", dateTime=" + dateTime +
                ", id=" + id +
                '}';
    }
}
