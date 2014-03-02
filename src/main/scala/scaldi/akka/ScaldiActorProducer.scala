package scaldi.akka

import akka.actor._

  class ScaldiActorProducer[A <: Actor](actorProvider: () => A, clazz: Class[A]) extends IndirectActorProducer {
  def produce() = actorProvider()
  def actorClass = clazz
}