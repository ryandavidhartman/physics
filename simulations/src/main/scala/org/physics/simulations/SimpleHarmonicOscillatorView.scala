package org.physics.simulations

import org.opensourcephysics.controls.AbstractAnimation
import org.opensourcephysics.display.Dataset
import org.opensourcephysics.display.DrawingFrame
import org.opensourcephysics.display.DrawingPanel
import org.opensourcephysics.display.PlottingPanel
import org.opensourcephysics.display.Stripchart
import org.opensourcephysics.display.axes.XAxis


/**
 * SHOView draws the oscillator in a drawing panel and plots the oscillator position graph.
 *
 * The oscillator is represented as a red ball.
 *
 * @author W. Christian
 * @version 1.0
 */
class SimpleHarmonicOscillatorView() extends AbstractAnimation {
  val plot = new PlottingPanel("time", "x", "x(t)")
  val plottingFrame = new DrawingFrame("SHO Data", plot)
  val drawing = new DrawingPanel
  val drawingFrame = new DrawingFrame("SHO Simulation", drawing)
  val stripChart = new Stripchart(20, 10) // strip chart of x(t)

  drawing.setPreferredMinMax(-5, 5, -1, 1)
  drawing.addDrawable(new XAxis("x"))
  drawing.addDrawable(sho)
  drawingFrame.setSize(300, 150)
  drawingFrame.setVisible(true)
  plot.addDrawable(stripChart)
  plottingFrame.setSize(300, 375)
  plottingFrame.setVisible(true)

  val sho = new SimpleHarmonicOscillatorModel() // harmonic oscillator

  /**
   * Initializes the animation.
   */
  override def initializeAnimation(): Unit = {
    super.initializeAnimation()
    val x = control.getDouble("x0")
    val v = control.getDouble("v0")
    sho.initialize(x, v, 0)
    drawing.setMessage("t=0")
    stripChart.clear()
    stripChart.append(0, x)
    drawing.repaint()
    plot.repaint()
  }

  /**
   * Does an animation step.
   */
  override protected def doStep(): Unit = {
    sho.move // moves the particle

    stripChart.append(sho.getTime, sho.getX)
    drawing.setMessage("t=" + decimalFormat.format(sho.getTime))
    drawing.repaint()
    plot.repaint()
  }

  /**
   * Resets the animation to a predefined state.
   */
  override def resetAnimation(): Unit = {
    super.resetAnimation()
    control.setValue("x0", 4)
    control.setValue("v0", 0)
    initializeAnimation()
  }
}
