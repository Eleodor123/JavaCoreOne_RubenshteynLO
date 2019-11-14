package Lesson_1.Marathon;

public class Main {
    public static void main(String[] args) {
        Course c = new Course(new Cross(80), new Water(2), new Wall(1), new Cross(120));
        Team team = new Team("Команда", new Human("Боб"), new Cat("Барсик"), new Dog("Бобик"));
        c.executeCross(team);
        team.showResults();
        team.showResultsSuccess();
    }
}