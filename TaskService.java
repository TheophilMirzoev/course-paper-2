import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskService {
    private static ArrayList<Task> arrayList = new ArrayList<>();
    private static Map<Integer, Task> tasksByDate = new HashMap<>();
    private static Map<Integer, Task> taskMap = new HashMap<>();

    public ArrayList<Task> getArrayList() {
        return arrayList;
    }

    public static Map<Integer, Task> getTaskMap() {
        return taskMap;
    }

    public static Map<Integer, Task> getTasksByDate() {
        return tasksByDate;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1 добавить задачу");
            System.out.println("2 список всех задач");
            System.out.println("3 задачи на день");
            System.out.println("4 удалить задачу по ID");

            int action = scanner.nextInt();
            switch (action) {
                case 1:                      // добавить задачу
                    scanner.nextLine();

                    System.out.println("заголовок");
                    String name = scanner.nextLine();

                    System.out.println("тип задачи WORK , PERSONAL");
                    TaskType taskType = TaskType.valueOf(scanner.nextLine());

                    System.out.println("описание");
                    String des = scanner.nextLine();

                    System.out.println("дата время в формате год, месяц, число, час, минута");
                    LocalDateTime localDateTime = LocalDateTime.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());

                    System.out.println("одноразовая задача 1");
                    System.out.println("ежедневная задача 2");
                    System.out.println("еженедельная задача 3");
                    System.out.println("ежемесячная задача 4");
                    System.out.println("ежегодная задача 5");
                    int repeatability = scanner.nextInt();
                    switch (repeatability) {
                        case 1:
                            new TaskService().addTask(new OneTimeTask(name, taskType, des, localDateTime));
                            break;
                        case 2:
                            new TaskService().addTask(new DailyTask(name, taskType, des, localDateTime));
                            break;
                        case 3:
                            new TaskService().addTask(new WeeklyTask(name, taskType, des, localDateTime));
                            break;
                        case 4:
                            new TaskService().addTask(new MonthlyTask(name, taskType, des, localDateTime));
                            break;
                        case 5:
                            new TaskService().addTask(new YearlyTask(name, taskType, des, localDateTime));
                            break;
                    }
                    break;
                case 2:         // список всех задач
                    System.out.println(taskMap);
                    break;
                case 3:        //задачи на день
                    System.out.println("введите дату гггг мм дд");
                    LocalDate localDate = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
                    new  TaskService().getAllByDate(localDate);
                    break;
                case 4:           //Удаление задач
                    System.out.println("введите ID задачи для удаления");
                    int id = scanner.nextInt();
                    new TaskService().remove(id);
                    break;
            }
        }
    }

    public void addTask(Task task1) {
        arrayList.add(task1);
        taskMap.put(task1.getId(), task1);
    }

    public void remove(Integer integer) {
        taskMap.remove(integer);
        tasksByDate.remove(integer);
    }

    public void getAllByDate(LocalDate localDate) {
        for (Map.Entry<Integer, Task> pair : taskMap.entrySet()) {
            if (pair.getValue().appearsIn(localDate)) {
                tasksByDate.put(pair.getKey(), pair.getValue());
            }
        }
        System.out.println(tasksByDate);
    }
}


