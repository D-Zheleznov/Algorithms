package graph;

import java.util.*;

//Поиск в ширину (поиск кратчайшего пути для невзвешенных графов)
public class BreadthSearch {

    //O = V + E
    //V - Количество вершин
    //E - Количество рёбер
    public static boolean run(String searchKey) {
        List<String> checkedFriends = new ArrayList<>();
        Deque<String> graphMapQueue = new LinkedList<>();
        Map<String, String[]> graph = Map.of("START", new String[]{"Ivan", "Nikita", "Kolyan"},
                                             "Ivan", new String[]{"Vika", "Pavel", "Anna"},
                                             "Nikita", new String[]{searchKey},
                                             "Kolyan", new String[]{"Anna", "Alex"},
                                             "Vika", new String[]{},
                                             "Pavel", new String[]{},
                                             "Anna", new String[]{},
                                             "Alex", new String[]{},
                                             "Nika", new String[]{});

        Arrays.stream(graph.get("START")).forEach(graphMapQueue::offer);

        while (!graphMapQueue.isEmpty()) {
            String friend = graphMapQueue.poll();
            if (!checkedFriends.contains(friend) && !friend.equals(searchKey)) {
                checkedFriends.add(friend);
                Arrays.stream(graph.get(friend)).forEach(graphMapQueue::offer);
            } else
                return true;
        }
        return false;
    }
}
