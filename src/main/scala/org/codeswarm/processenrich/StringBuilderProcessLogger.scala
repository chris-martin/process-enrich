package org.codeswarm.processenrich

import scala.sys.process.ProcessLogger

/** Implementation of `ProcessLogger` that appends all output to `StringBuilder`s for the
  * purpose of ultimately constructing a `ProcessOutput[String]` with the final result.
  */
case class StringBuilderProcessLogger
    (v: ProcessOutput[StringBuilder] = ProcessOutput(() => new StringBuilder()))
    extends ProcessLogger {

  import StringBuilderProcessLogger._

  override def out(s: => String) { appendLine(v.out, s) }
  override def err(s: => String) { appendLine(v.err, s) }

  override def buffer[T](f: => T): T = f

  /** Turn the `StringBuffer`s into `String`s. */
  def stringOutput: ProcessOutput[String] = v map (_.mkString)

}

object StringBuilderProcessLogger {

  val lineSeparator: String = sys.props("line.separator")

  def appendLine(sb: StringBuilder, x: String) {
    sb.append(x).append(lineSeparator)
  }

}
