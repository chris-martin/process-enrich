package org.codeswarm.processenrich

import scala.sys.process.ProcessLogger

/** Implementation of `ProcessLogger` that appends all output to `StringBuilder`s for the
  * purpose of ultimately constructing a `ProcessOutput[String]` with the final result.
  */
case class StringBuilderProcessLogger
    (v: ProcessOutput[StringBuilder] = ProcessOutput(() => new StringBuilder()))
    extends ProcessLogger {

  override def out(s: => String) { v.out append s }
  override def err(s: => String) { v.err append s }

  override def buffer[T](f: => T): T = f

  /** Turn the `StringBuffer`s into `String`s. */
  def stringOutput: ProcessOutput[String] = v map (_.mkString)

}
