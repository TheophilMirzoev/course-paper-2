package ticket16;

public class Man {
    String name;
    public enum Word{WORD("слово");
        String word;

        Word(String word) {
            this.word = word;
        }

    }


    public Man(String name) throws Incorect {
        if (name.isEmpty() || name.isBlank() || name == null) {
            throw new Incorect("incorect");
        } else {
            this.name = name;
        }
    }
}
