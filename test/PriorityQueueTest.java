import utils.MinPriorityQueue;

import org.junit.Test;

public class PriorityQueueTest {

  @Test
  public void queueTestAdd() {
    MinPriorityQueue<Integer> q = new MinPriorityQueue<>();
    q.add(12);
    q.display();
    q.add(121);
    q.display();
    q.add(1);
    q.display();
    q.add(0);
    q.display();
  }

  @Test
  public void queueTestRemove() {
    MinPriorityQueue<Integer> q = new MinPriorityQueue<>();
    q.add(12);
    q.display();
    q.add(121);
    q.display();
    q.add(1);
    q.display();
    q.add(0);
    q.display();
    q.add(-11);
    q.display();
    q.add(31);
    q.display();
    q.add(-12);
    q.display();
    q.remove();
  }
}