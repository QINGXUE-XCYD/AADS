package Week2;

import java.util.Scanner;
import java.util.UUID;

public class MapConsoleTest {
    public static void main(String[] args) {
        UnsortedListMap<Integer, String> map = new UnsortedListMap<>();
        Scanner sc = new Scanner(System.in);
        int keyCounter = 1;

        System.out.println("==== Week2.UnsortedListMap Console Test ====");
        System.out.println("Commands:");
        System.out.println("1 - Print map");
        System.out.println("2 - Add entry (auto key, random value)");
        System.out.println("3 - Remove by key");
        System.out.println("4 - Replace value for key");
        System.out.println("5 - Clear all");
        System.out.println("0 - Exit");

        while (true) {
            System.out.print("\nEnter command: ");
            String cmd = sc.nextLine().trim();

            switch (cmd) {
                case "1":
                    if (map.size() == 0) {
                        System.out.println("(Map is empty)");
                    } else {
                        System.out.println("Current Map:");
                        for (var e : map.map) { // 直接访问你的 List<MapEntry>
                            System.out.println("  " + e.getKey() + " => " + e.getValue());
                        }
                    }
                    break;

                case "2":
                    String randomVal = UUID.randomUUID().toString().substring(0, 8);
                    map.put(keyCounter, randomVal);
                    System.out.println("Added: " + keyCounter + " => " + randomVal);
                    keyCounter++;
                    break;

                case "3":
                    System.out.print("Enter key to remove: ");
                    try {
                        int key = Integer.parseInt(sc.nextLine());
                        String removed = map.remove(key);
                        if (removed == null) System.out.println("Key not found.");
                        else System.out.println("Removed: " + key + " => " + removed);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input.");
                    }
                    break;

                case "4":
                    System.out.print("Enter key to replace: ");
                    try {
                        int key = Integer.parseInt(sc.nextLine());
                        if (!map.containsKey(key)) {
                            System.out.println("Key not found.");
                            break;
                        }
                        System.out.print("Enter new value: ");
                        String newVal = UUID.randomUUID().toString().substring(0, 8);
                        String oldValue = map.put(key, newVal);
                        System.out.println("Updated key " + key + " => " + newVal);
                        System.out.println("Old Value => " + oldValue);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input.");
                    }
                    break;

                case "5":
                    map.clear();
                    System.out.println("Map cleared.");
                    break;

                case "0":
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Unknown command. Try again.");
            }
        }
    }
}
