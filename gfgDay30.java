import java.util.*;

class Solution {

    public static int minTime(Node root, int target) {

        // Step 1: Map parent pointers
        HashMap<Node, Node> parentMap = new HashMap<>();
        Node targetNode = buildParentMap(root, parentMap, target);

        // Step 2: BFS from target
        Queue<Node> q = new LinkedList<>();
        HashSet<Node> visited = new HashSet<>();

        q.add(targetNode);
        visited.add(targetNode);

        int time = 0;

        while (!q.isEmpty()) {

            int size = q.size();
            boolean burned = false;

            for (int i = 0; i < size; i++) {

                Node curr = q.poll();

                if (curr.left != null && !visited.contains(curr.left)) {
                    q.add(curr.left);
                    visited.add(curr.left);
                    burned = true;
                }

                if (curr.right != null && !visited.contains(curr.right)) {
                    q.add(curr.right);
                    visited.add(curr.right);
                    burned = true;
                }

                Node parent = parentMap.get(curr);
                if (parent != null && !visited.contains(parent)) {
                    q.add(parent);
                    visited.add(parent);
                    burned = true;
                }
            }

            if (burned) time++;
        }

        return time;
    }
    static Node buildParentMap(Node root, HashMap<Node, Node> parentMap, int target) {

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        Node targetNode = null;

        while (!q.isEmpty()) {

            Node curr = q.poll();

            if (curr.data == target) {
                targetNode = curr;
            }

            if (curr.left != null) {
                parentMap.put(curr.left, curr);
                q.add(curr.left);
            }

            if (curr.right != null) {
                parentMap.put(curr.right, curr);
                q.add(curr.right);
            }
        }

        return targetNode;
    }
}
