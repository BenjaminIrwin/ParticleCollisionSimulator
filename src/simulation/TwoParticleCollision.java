package simulation;

public class TwoParticleCollision extends Collision {

  public TwoParticleCollision(Particle p1, Particle p2, double time) {
    super(time,new Particle[]{p1,p2});
  }

  @Override
  public void happen(ParticleEventHandler handler) {
    Particle.collide(this.particles[0], this.particles[1]);
    handler.reactTo(this);
  }
}
