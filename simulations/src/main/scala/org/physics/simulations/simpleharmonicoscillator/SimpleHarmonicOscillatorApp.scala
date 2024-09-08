package org.physics.simulations.simpleharmonicoscillator

import org.opensourcephysics.controls.OSPControl

object SimpleHarmonicOscillatorApp extends App {
  val animation: SimpleHarmonicOscillatorView = SimpleHarmonicOscillatorView()
  val control: OSPControl = new OSPControl(animation)

  control.addButton("startAnimation", "Start")
  control.addButton("stopAnimation", "Stop")
  control.addButton("initializeAnimation", "Initialize")

  animation.setControl(control)
}
