package graph;

import java.util.*;

//Поиск кратчайшего пути для направленного взвешенного ацикличного графа (без отрицательный значений)
public class DijkstraSearch {

    //O =
    public static Map<Deque<String>, Integer> run(String searchKey) {
        Map<String, Map<String, Integer>> graph = Map.of("START", Map.of("A", 6, "B", 2),
                                                         "A", Map.of("END", 1),
                                                         "B", Map.of("A", 3, searchKey, 5),
                                                             searchKey, Map.of());
        //Стоимость прохода к узлу от START
        Map<String, Integer> costs = new HashMap<>();
        costs.put("A", 6);
        costs.put("B", 2);
        costs.put(searchKey, Integer.MAX_VALUE);

        //Родительские узлы
        Map<String, String> parents = new HashMap<>();
        parents.put("A", "START");
        parents.put("B", "START");
        parents.put(searchKey, null);

        List<String> checkedNodes = new ArrayList<>();
        checkedNodes.add("START");
        checkedNodes.add(searchKey);

        while (checkedNodes.size() < graph.size()) {
            //Берём самый близкий узел от старта
            Map.Entry<String, Integer> lowestNode = costs
                    .entrySet().stream()
                    .filter(entry -> !checkedNodes.contains(entry.getKey()))
                    .min(Map.Entry.comparingByValue())
                    .get();

            //Берём соседей этого узла
            Map<String, Integer> neighbors = graph.get(lowestNode.getKey());
            //Обновляем стоимости для каждого соседа
            neighbors.forEach((key, value) -> {
                Integer neighborCost = costs.get(key);
                if (neighborCost != null) {
                    int newCost = value + costs.get(lowestNode.getKey());
                    //Если стоимость пути меньше то обновляем её в costs и устанавливаем другого родителя
                    if (newCost < neighborCost) {
                        costs.put(key, newCost);
                        parents.put(key, lowestNode.getKey());
                    }
                }
            });
            checkedNodes.add(lowestNode.getKey());
        }
        int pathSum = 0;
        Deque<String> shortestPath = new LinkedList<>();
        shortestPath.add(searchKey);
        String currentKey = parents.get(searchKey);
        while (!currentKey.equals("START")) {
            shortestPath.push(currentKey);
            pathSum += costs.get(currentKey);
            currentKey = parents.get(currentKey);
        }
        shortestPath.push("START");
        return Map.of(shortestPath, pathSum);
    }
}
