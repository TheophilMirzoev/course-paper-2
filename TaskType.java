public enum TaskType {
    WORK("рабочая задача"),
    PERSONAL("личная задача");
    String name;

    TaskType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TypeTask{" +
                "name='" + name + '\'' +
                '}';
    }
}
