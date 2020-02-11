import utils.MinPriorityQueue;

import org.junit.Test;
import org.junit.Assert.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class PriorityQueueTest {

  @Test
  public void queueTestAdd() {
    MinPriorityQueue<Integer> q = new MinPriorityQueue<>();
    q.add(12);
    q.add(121);
    q.add(1);
    q.add(0);
    Integer[] array = {null, 0, 1, 12, 121};
    assertArrayEquals(q.queue.toArray(), array);
  }

  @Test
  public void queueTestRemove() {
    MinPriorityQueue<Integer> q = new MinPriorityQueue<>();
    q.add(12);
    q.add(121);
    q.add(1);
    q.add(0);
    q.add(-11);
    q.add(31);
    q.add(-12);
    q.remove();

    Integer[] array = {null, -11, 0, 12, 121, 1, 31};

    assertArrayEquals(q.queue.toArray(), array);
  }
}