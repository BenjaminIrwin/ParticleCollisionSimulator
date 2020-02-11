package simulation;

public abstract class Collision extends AbstractEvent {

  protected Particle[] particles = null;
  private int initial_hits = 0;

  /** Constructor for Collision */
  public Collision(double t, Particle[] ps) {
    super(t);
    this.particles = ps;

    for (Particle particle : particles) initial_hits += particle.collisions();
  }

  public Collision() {
    super(-1);
  }

  /** Returns true if this Collision is (still) valid. */
  @Override
  public boolean isValid() {
    int sum_collisions = 0;
    for (Particle particle : particles) sum_collisions += particle.collisions();
    return sum_collisions == initial_hits;
  }

  /** Returns an array containing the Particles involved in this Collision. */
  public Particle[] getParticles() {
    return particles;
  }
}
