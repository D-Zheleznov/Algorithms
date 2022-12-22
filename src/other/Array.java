package other;

public class Array {

    public static boolean multidimensionalSearch(String key) {
        String[][] graphArray = {
                {"Denis", "Ivan", "Nikita", "Kolyan", "Vika", "Pavel", "Anna", "Alex", "Nika"},
                {"Ivan", "Nikita", "Kolyan"},
                {"Vika", "Pavel"},
                {"Nika"},
                {"Anna", "Alex"},
                {},
                {},
                {},
                {},
                {}
        };
        for (int i = 1; i < graphArray.length; i++) {
            for (String friend : graphArray[i]) {
                if (friend.equals(key)) {
                    return true;
                }
            }
        }
        return false;
    }
}
