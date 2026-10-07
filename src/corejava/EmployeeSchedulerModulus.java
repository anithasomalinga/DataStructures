package corejava;

public class EmployeeSchedulerModulus {
    public static void main(String[] args) {

        String[] weekdays = {"Mon", "Tue", "Wed", "Thu", "Fri"};
        int dayCount = weekdays.length;
        int employeeCount = 14;

        for (int i = 0; i < employeeCount; i++) {
            int dayIndex = i % dayCount;  // no +1 needed, java is 0-indexed
            String weekday = weekdays[dayIndex];
            System.out.println("Scheduling employee " + i + " on " + weekday);
        }
    }
}
