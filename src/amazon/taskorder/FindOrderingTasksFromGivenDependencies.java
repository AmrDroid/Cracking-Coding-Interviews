package amazon.taskorder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
//https://algorithms.tutorialhorizon.com/determine-the-order-of-tests-when-tests-have-dependencies-on-each-other/
//Time Complexity: O(N), N – Number of test cases.
//https://www.geeksforgeeks.org/find-the-ordering-of-tasks-from-given-dependencies/
public class FindOrderingTasksFromGivenDependencies {
    static class tNode {
        char destination;
        char source;

        tNode(char source, char destination) {
            this.source = source;
            this.destination = destination;
        }
    }

    static class Graph {
        int vertices;
        LinkedList<tNode>[] adjList;

        Graph(int vertices) {
            this.vertices = vertices;
            adjList = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjList[i] = new LinkedList<tNode>();
            }
        }

        public void addEgde(char source, char destination,  ArrayList<Character> testCases) {
            tNode tNode = new tNode(source, destination);
            adjList[testCases.indexOf(source)].addFirst(tNode);
        }

        public void topologicalSorting(ArrayList<Character> testCases) {
            boolean[] visited = new boolean[vertices];
            Stack<Character> stack = new Stack<Character>();
            //visit from each tNode if not already visited
            for (int i = 0; i < vertices; i++) {
                if (!visited[i]) {
                    topologicalSortUtil(testCases.get(i), visited, stack, testCases);
                }
            }
            System.out.println("Test Case Sequence: ");
            int size = stack.size();
            for (int i = 0; i <size ; i++) {
                System.out.print(stack.pop() + " ");
            }
        }

        public void topologicalSortUtil(char sftwr, boolean[] visited, Stack<Character> stack, ArrayList<Character> testCases) {
            int index = testCases.indexOf(sftwr);
            visited[index] = true;
            for (int i = 0; i < adjList[testCases.indexOf(sftwr)].size(); i++) {
                tNode tNode = adjList[index].get(i);
                if (!visited[testCases.indexOf(tNode.destination)])
                    topologicalSortUtil(tNode.destination, visited, stack, testCases);
            }
            stack.push(sftwr);
        }
    }

    public static void main(String[] args) {
        ArrayList<Character> testCase= new ArrayList<Character>();
        testCase.add('0');
        testCase.add('1');
        testCase.add('2');
        testCase.add('3');

        int vertices = testCase.size();
        Graph graph = new Graph(vertices);
        graph.addEgde('1', '0', testCase);
        graph.addEgde('2', '0', testCase);
        graph.addEgde('3', '1', testCase);
        graph.addEgde('3', '2', testCase);
        graph.addEgde('1', '2', testCase);
        graph.topologicalSorting(testCase);
    }


}
