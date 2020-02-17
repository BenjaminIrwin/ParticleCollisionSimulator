package simulation;

import utils.MinPriorityQueue;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class ParticleSimulation implements Runnable, ParticleEventHandler {

  private static final long FRAME_INTERVAL_MILLIS = 40;

  private final ParticlesModel model;
  private final ParticlesView screen;
  private double clock = 0;
  private MinPriorityQueue<Event> queue;

  /** Constructor. */
  public ParticleSimulation(String name, ParticlesModel model) {
    this.model = model;
    this.screen = new ParticlesView(name, model);
    queue = new MinPriorityQueue<>();
    queue.add(new Tick(1));
    for (Event event : model.predictAllCollisions(clock)) {
      queue.add(event);
    }
  }

  /** Runs the simulation. */
  @Override
  public void run() {
    try {
      SwingUtilities.invokeAndWait(screen);
    } catch (InvocationTargetException | InterruptedException e) {
      e.printStackTrace();
    }

    while (true) {
      Event event = queue.remove();
      if (event.isValid()) {
        model.moveParticles(event.time() - clock);
        clock = event.time();
        event.happen(this);
      }
    }
  }

  @Override
  public void reactTo(Tick tick) {
    try {
      Thread.sleep(FRAME_INTERVAL_MILLIS);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    screen.update();
    queue.add(new Tick(clock + 1));
  }

  @Override
  public void reactTo(Collision c) {

    for(Particle p:c.getParticles()){
      for (Event event : model.predictCollisions(p,clock)) {
        queue.add(event);
    }
    }

  }
}
