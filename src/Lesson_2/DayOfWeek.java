package Lesson_2;

public enum DayOfWeek {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}
class DayOfWeekMain {

    public static void main(final String[] args) {
        System.out.println(getWorkingHours(DayOfWeek.MONDAY));
        System.out.println(getWorkingHours(DayOfWeek.TUESDAY));
        System.out.println(getWorkingHours(DayOfWeek.WEDNESDAY));
        System.out.println(getWorkingHours(DayOfWeek.THURSDAY));
        System.out.println(getWorkingHours(DayOfWeek.FRIDAY));
        System.out.println(getWorkingHours(DayOfWeek.SATURDAY));
        System.out.println(getWorkingHours(DayOfWeek.SUNDAY));
    }
    public static String getWorkingHours(DayOfWeek currentDay) {
        String workingHoursLeftSTR;
        int currDayNum = currentDay.ordinal();
        int workingHours = 40;
        int workingHoursLeft;
        int workingHoursDaily = 8;
        if (currDayNum == 5 || currDayNum == 6) {
            workingHoursLeftSTR ="Weekend";
            return workingHoursLeftSTR;
        }
        workingHoursLeft = workingHours - (workingHoursDaily * currDayNum);
        workingHoursLeftSTR = String.format("%d hours left to work!", workingHoursLeft);
        return workingHoursLeftSTR;
    }
}