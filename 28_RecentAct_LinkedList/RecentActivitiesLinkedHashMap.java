import java.util.*;

public class RecentActivitiesLinkedHashMap {
    public static void main(String[] args) {
        LinkedHashMap<String, String> activities = new LinkedHashMap<>();
        activities.put("10:00 AM", "Login");
        activities.put("10:15 AM", "Viewed Profile");
        activities.put("10:30 AM", "Logged Out");

        System.out.println("User Activities (in order):");
        for (Map.Entry<String, String> entry : activities.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
