package Lesson_1.Marathon;

public class Course {
    Obstacle[] obstacles;

    protected Course(Obstacle... obstacles) {
        this.obstacles = obstacles;
    }
    protected void executeCross(Team team) {
        for (Competitor comp : team.competitors) {
            for (Obstacle o : obstacles) {
                o.doIt(comp);
                if (!comp.isOnDistance()) break;
            }
        }
    }
}
