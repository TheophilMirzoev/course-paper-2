import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

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

    public static void main(String[] args) throws TaskNotFoundException {
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

                        System.out.println("тип задачи  0 - WORK , 1 - PERSONAL");
                        int taskTypeInt = scanner.nextInt();
                        TaskType taskType;

                        if (taskTypeInt == 0) {
                            taskType = TaskType.WORK;
                        } else if (taskTypeInt == 1) {
                            taskType = TaskType.PERSONAL;
                        } else {
                            try {
                                throw new IncorrectArgumentException("нельзя ", "ввести");
                            } catch (IncorrectArgumentException e) {
                                System.out.println("нельзя ввести цифру");
                                break;
                            }
                        }

                        System.out.println("описание");
                        scanner.nextLine();
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
                                try {
                                    new TaskService().addTask(new OneTimeTask(name, taskType, des, localDateTime));
                                } catch (IncorrectArgumentException e) {
                                    System.out.println("не корректно внесены данные");
                                }
                                break;
                            case 2:
                                try {
                                    new TaskService().addTask(new DailyTask(name, taskType, des, localDateTime));
                                } catch (IncorrectArgumentException e) {
                                    System.out.println("не корректно внесены данные");
                                }
                                break;
                            case 3:
                                try {
                                    new TaskService().addTask(new WeeklyTask(name, taskType, des, localDateTime));
                                } catch (IncorrectArgumentException e) {
                                    System.out.println("не корректно внесены данные");
                                }
                                break;
                            case 4:
                                try {
                                    new TaskService().addTask(new MonthlyTask(name, taskType, des, localDateTime));
                                } catch (IncorrectArgumentException e) {
                                    System.out.println("не корректно внесены данные");
                                }
                                break;
                            case 5:
                                try {
                                    new TaskService().addTask(new YearlyTask(name, taskType, des, localDateTime));
                                } catch (IncorrectArgumentException e) {
                                    System.out.println("не корректно внесены данные");
                                }
                                break;
                        }
                        break;
                    case 2:         // список всех задач
                        System.out.println(taskMap);
                        break;
                    case 3:        //задачи на день
                        System.out.println("введите дату гггг мм дд");
                        LocalDate localDate = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
                        new TaskService().getAllByDate(localDate);
                        break;
                    case 4:           //Удаление задач
                        System.out.println("введите ID задачи для удаления");
                        int id = scanner.nextInt();
                        new TaskService().remove(id);
                        break;
                }
            }

    }

    public void addTask (Task task1) {
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


