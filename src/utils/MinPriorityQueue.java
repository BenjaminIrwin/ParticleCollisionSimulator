package utils;

import java.util.ArrayList;

public class MinPriorityQueue<T extends Comparable<T>> {

  public ArrayList<T> queue;

  /** Creates an empty queue. */
  public MinPriorityQueue() {
    queue = new ArrayList<>();
  }

  private int get_parent_node(int index) { return (index - 1) / 2; }

  private int get_left_node(int index) {
    return (2 * index) + 1;
  }

  private int get_right_node(int index) { return (2 * index) + 2; }

  /** Returns the number of elements currently in the queue. */
  public int size() {
    return queue.size();
  }

  private void swap(int i, int j) {
    if (i >= size() || j >= size()) {
      return;
    }
    if (i < 0 || j < 0) {
      return;
    }
    T temp = queue.get(i);
    queue.set(i, queue.get(j));
    queue.set(j, temp);
  }

  /** Adds elem to the queue. */
  public void add(T elem) {
    if (isEmpty()) {
      queue.add(elem);
      return;
    }

    queue.add(elem);
    recursive_sort(queue.size() - 1, get_parent_node(queue.size() - 1));
  }

  private void recursive_sort(int current_index, int parent_node_index) {

    //System.out.println(queue + "  " + current_index + "  " + parent_node_index);
    if (current_index == 0) {
      return;
    }

    if (queue.get(parent_node_index).compareTo(queue.get(current_index)) > 0) {
      swap(current_index, parent_node_index);
      current_index = parent_node_index;
      int new_parent_node_index = get_parent_node(current_index);
      recursive_sort(current_index, new_parent_node_index);
    }
  }

  private void heapify(int root_node_index) {

    T root_node = queue.get(root_node_index);
    int left_node_index = get_left_node(root_node_index);
    int right_node_index = get_right_node(root_node_index);

    T left_child_node = null;
    T right_child_node = null;

    if (left_node_index < size()) {
      left_child_node = queue.get(left_node_index);//If the left child node is bigger than the array, then the right child node must also be?!
    }

    if (right_node_index < size()) {
      right_child_node = queue.get(right_node_index);
    }

    if (left_child_node == null && right_child_node == null) {//We are the last element in the heap
      return;
    }

    if (left_child_node == null && right_child_node.compareTo(root_node) < 0) {//Does this ever happen? I don't think so
      swap(root_node_index, right_node_index);
      return;
    }

    if (right_child_node == null && left_child_node.compareTo(root_node) < 0) {//We are at the end and the last node is smaller
      swap(root_node_index, left_node_index);
      return;
    }

    if (left_child_node == null || right_child_node == null) {//Child nodes are bigger so right place in heap
      return;
    }

    if (left_child_node.compareTo(root_node) >= 0 && right_child_node.compareTo(root_node) >= 0) {//Child nodes are the same or bigger so right place.
      return;
    }

    int child_min_index = -1;
    if (left_child_node.compareTo(root_node) < 0) {
      child_min_index = left_node_index;
    }
    if (right_child_node.compareTo(root_node) < 0
        && right_child_node.compareTo(left_child_node) < 0) {
      child_min_index = right_node_index;
    }

    swap(root_node_index, child_min_index);
    heapify(child_min_index);
  }

  /** Removes, and returns, the element at the front of the queue. */
  public T remove() {//What about case where there is only one element in the queue?!?!
    T root = queue.get(0);
    swap(0, size() - 1);
    queue.remove(size() - 1);
    heapify(0);
    return root;
  }

  /** Returns true if the queue is empty, false otherwise. */
  public boolean isEmpty() {
    return size() == 0;
  }
}
