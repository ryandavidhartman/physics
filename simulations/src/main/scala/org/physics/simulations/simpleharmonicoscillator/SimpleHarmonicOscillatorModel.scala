package org.physics.simulations.simpleharmonicoscillator

import org.opensourcephysics.display.Circle
import org.opensourcephysics.numerics.{ODE, ODESolver, RK4}

class SimpleHarmonicOscillatorModel() extends Circle with ODE {

  // initial state values = {x, v, t}
  var state: Array[Double] = Array[Double](0.0, 0.0, 0.0)
  var k: Double = 1.0   // spring constant
  var b: Double = 0.001    // damping constant
  val ode_solver: ODESolver = new RK4(this)

  /**
   * Initializes the position, velocity, and time.
   *
   * @param x
   * @param v
   * @param t
   */
  def initialize(x: Double, v: Double, k: Double, b: Double, t: Double): Unit = {
    this.x = x
    this.k = k
    this.b = b

    state = Array[Double](x, v, t)
  }

  /**
   * Gets the time.
   * @return
   */
  def getTime(): Double  = {
    state(2)
  }

  /**
   * Gets the state array.
   *
   * @return an array containing {x, v, t}
   */
  def getState(): Array[Double] =  {
    state
  }

  /**
   * Calculates the rate array using the given state.
   *
   * Values in the rate array are overwritten.
   *
   * @param state  the state
   * @param rate   the rate
   */
  def getRate(state: Array[Double], rate: Array[Double]): Unit  = {
    val force: Double = -k * state(0) - b * state(1)
    rate.update(0, state(1)) // dx/dt = v
    rate.update(1, force) // dv/dt = force
    rate.update(2, 1) // dt/dt = 1
  }

  /**
   * Moves the particle.
   */
  def move(): Unit = {
    ode_solver.step()
    setX(state(0))
  }

}
