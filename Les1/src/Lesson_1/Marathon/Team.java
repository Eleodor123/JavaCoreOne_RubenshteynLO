package Lesson_1.Marathon;

import Lesson_1.Marathon.Competitor;

public class Team {
    Competitor[] competitors;
    String teamName;


    public Team(String teamName, Competitor... competitors) {
        this.teamName = teamName;
        this.competitors = competitors;
    }

    protected void showResults() {
        for (Competitor c : competitors) {
            c.info();
        }
    }

    protected void showResultsSuccess() {
        for (Competitor c : competitors) {
            if (c.isOnDistance() == true) {
                c.info();
            }
        }
    }

}
