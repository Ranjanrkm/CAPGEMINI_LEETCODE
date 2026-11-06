import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class ParkingSystem {
    private int big;
    private int medium;
    private int small;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }
    
    public boolean addCar(int carType) {
        if (carType == 1) {
            if (big > 0) {
                big--;
                return true;
            }
        } else if (carType == 2) {
            if (medium > 0) {
                medium--;
                return true;
            }
        } else if (carType == 3) {
            if (small > 0) {
                small--;
                return true;
            }
        }
        return false;
    }
}

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLine()) return;
        String line1 = scanner.nextLine().trim();
        if (!scanner.hasNextLine()) return;
        String line2 = scanner.nextLine().trim();

        // Parse operations
        List<String> ops = new ArrayList<>();
        Matcher m1 = Pattern.compile("\"([^\"]*)\"").matcher(line1);
        while (m1.find()) {
            ops.add(m1.group(1));
        }

        // Parse arguments
        List<List<Integer>> argsList = new ArrayList<>();
        Matcher m2 = Pattern.compile("\\[([^\\[\\]]*)\\]").matcher(line2);
        while (m2.find()) {
            String inner = m2.group(1).trim();
            if (!inner.isEmpty()) {
                List<Integer> nums = new ArrayList<>();
                for (String part : inner.split(",")) {
                    part = part.trim();
                    if (!part.isEmpty()) {
                        nums.add(Integer.parseInt(part));
                    }
                }
                argsList.add(nums);
            }
        }

        ParkingSystem ps = null;
        List<String> results = new ArrayList<>();

        for (int i = 0; i < ops.size(); i++) {
            String op = ops.get(i);
            List<Integer> arg = argsList.get(i);
            if (op.equals("ParkingSystem")) {
                ps = new ParkingSystem(arg.get(0), arg.get(1), arg.get(2));
                results.add("null");
            } else if (op.equals("addCar")) {
                boolean res = ps.addCar(arg.get(0));
                results.add(String.valueOf(res));
            }
        }

        System.out.println("[" + String.join(", ", results) + "]");
    }
}