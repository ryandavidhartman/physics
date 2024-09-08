package org.physics.simulations

import org.opensourcephysics.controls.Animation
import org.opensourcephysics.controls.OSPControl


object SimpleHarmonicOscillatorApp extends App {
  val animation = new SimpleHarmonicOscillatorView()
  val control = new OSPControl(animation)
  control.addButton("startAnimation", "Start")
  control.addButton("stopAnimation", "Stop")
  control.addButton("initializeAnimation", "Initialize")
  animation.setControl(control)

}
