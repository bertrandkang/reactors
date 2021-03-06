package io.reactors






/** Debugger interface for the reactor system.
 */
abstract class DebugApi {
  /** Returns `true` iff debugging is currently enabled.
   */
  def isEnabled: Boolean

  /** Called when an event is sent on a channel.
   */
  def eventSent[@spec(Int, Long, Double) T](c: Channel[T], x: T): Unit

  /** Called by a reactor when an event is delivered.
   */
  def eventDelivered[@spec(Int, Long, Double) T](c: Channel[T], x: T): Unit

  /** Called when a reactor starts.
   */
  def reactorStarted(r: Reactor[_]): Unit

  /** Called when a reactor is scheduled, i.e. gets execution time on some CPU.
   */
  def reactorScheduled(r: Reactor[_]): Unit

  /** Called when a reactor is preempted by the scheduler.
   */
  def reactorPreempted(r: Reactor[_]): Unit

  /** Called when a reactor dies due to an error.
   */
  def reactorDied(r: Reactor[_]): Unit

  /** Called when a reactor terminates.
   */
  def reactorTerminated(r: Reactor[_]): Unit

  /** Called when a connector is created.
   */
  def connectorOpened[T](c: Connector[T]): Unit

  /** Called when a connector is sealed.
   */
  def connectorSealed[T](c: Connector[T]): Unit

  /** Print the specified message to the debugger.
   */
  def log(x: Any): Unit
}


object DebugApi {
  /** A debugger API implementation that ignores all debugger actions.
   */
  class Zero(val system: ReactorSystem) extends DebugApi {
    def isEnabled = false

    def eventSent[@spec(Int, Long, Double) T](c: Channel[T], x: T) {
    }

    def eventDelivered[@spec(Int, Long, Double) T](c: Channel[T], x: T) {
    }

    def reactorStarted(r: Reactor[_]) {
    }

    def reactorScheduled(r: Reactor[_]) {
    }

    def reactorPreempted(r: Reactor[_]) {
    }

    def reactorDied(r: Reactor[_]) {
    }

    def reactorTerminated(r: Reactor[_]) {
    }

    def connectorOpened[T](c: Connector[T]) {
    }

    def connectorSealed[T](c: Connector[T]) {
    }

    def log(x: Any){
    }
  }
}
