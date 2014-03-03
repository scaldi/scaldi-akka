package scaldi.akka

import scaldi.{InjectConstraints, Identifier, Injector, Injectable}
import scala.reflect.ClassTag
import scala.reflect.runtime.universe.TypeTag
import scaldi.util.constraints.{Or, NotNothing}
import akka.actor._
import scaldi.InjectConstraints

trait AkkaInjectable extends Injectable {
  protected def injectActorProps[T](implicit injector: Injector, ct: ClassTag[T], tt: TypeTag[T], nn: NotNothing[T]): Props =
    Props.create(classOf[ScaldiActorProducer[T]], injectProvider[T](injector, tt, nn), ct.runtimeClass)

  protected def injectActorRef[T](implicit f: ActorRefFactory, injector: Injector, ct: ClassTag[T], tt: TypeTag[T], nn: NotNothing[T]): ActorRef =
    f.actorOf(injectActorProps(injector, ct, tt, nn))

  protected def injectActorRef[T](name: String)
                                 (implicit f: ActorRefFactory, injector: Injector, ct: ClassTag[T], tt: TypeTag[T], nn: NotNothing[T]): ActorRef =
    f.actorOf(injectActorProps(injector, ct, tt, nn), name)

  protected def injectActorProps[T](identifiers: Identifier*)
                                   (implicit injector: Injector, ct: ClassTag[T], tt: TypeTag[T], nn: NotNothing[T]): Props =
    Props.create(classOf[ScaldiActorProducer[T]], injectProvider[T](identifiers: _*)(injector, tt, nn), ct.runtimeClass)

  protected def injectActorRef[T](identifiers: Identifier*)
                                 (implicit f: ActorRefFactory, injector: Injector, ct: ClassTag[T], tt: TypeTag[T], nn: NotNothing[T]): ActorRef =
    f.actorOf(injectActorProps(identifiers: _*)(injector, ct, tt, nn))

  protected def injectNamedActorRef[T](identifiers: Identifier*)
                                      (name: String)
                                      (implicit f: ActorRefFactory, injector: Injector, ct: ClassTag[T], tt: TypeTag[T], nn: NotNothing[T]): ActorRef =
    f.actorOf(injectActorProps(identifiers: _*)(injector, ct, tt, nn), name)

  protected def injectActorProps[T](constraints: => InjectConstraints[T])
                                   (implicit injector: Injector, ct: ClassTag[T], tt: TypeTag[T], nn: NotNothing[T]): Props =
    Props.create(classOf[ScaldiActorProducer[T]], injectProvider[T](constraints)(injector, tt, nn), ct.runtimeClass)

  protected def injectActorRef[T](constraints: => InjectConstraints[T])
                                 (implicit f: ActorRefFactory, injector: Injector, ct: ClassTag[T], tt: TypeTag[T], nn: NotNothing[T]): ActorRef =
    f.actorOf(injectActorProps(constraints)(injector, ct, tt, nn))

  protected def injectNamedActorRef[T](constraints: => InjectConstraints[T])
                                      (name: String)
                                      (implicit f: ActorRefFactory, injector: Injector, ct: ClassTag[T], tt: TypeTag[T], nn: NotNothing[T]): ActorRef =
    f.actorOf(injectActorProps(constraints)(injector, ct, tt, nn), name)
}

object AkkaInjectable extends OpenAkkaInjectable

trait OpenAkkaInjectable extends AkkaInjectable {
  override def injectActorProps[T](implicit injector: Injector, ct: ClassTag[T], tt: TypeTag[T], nn: NotNothing[T]): Props =
    super.injectActorProps[T](injector, ct, tt, nn)

  override def injectActorRef[T](implicit f: ActorRefFactory, injector: Injector, ct: ClassTag[T], tt: TypeTag[T], nn: NotNothing[T]): ActorRef =
    super.injectActorRef[T](f, injector, ct, tt, nn)

  override def injectActorRef[T](name: String)
                                (implicit f: ActorRefFactory, injector: Injector, ct: ClassTag[T], tt: TypeTag[T], nn: NotNothing[T]): ActorRef =
    super.injectActorRef[T](name)(f, injector, ct, tt, nn)

  override def injectActorProps[T](identifiers: Identifier*)
                                  (implicit injector: Injector, ct: ClassTag[T], tt: TypeTag[T], nn: NotNothing[T]): Props =
    super.injectActorProps[T](identifiers: _*)(injector, ct, tt, nn)

  override def injectActorRef[T](identifiers: Identifier*)
                                (implicit f: ActorRefFactory, injector: Injector, ct: ClassTag[T], tt: TypeTag[T], nn: NotNothing[T]): ActorRef =
    super.injectActorRef[T](identifiers: _*)(f, injector, ct, tt, nn)

  override def injectNamedActorRef[T](identifiers: Identifier*)
                                     (name: String)
                                     (implicit f: ActorRefFactory, injector: Injector, ct: ClassTag[T], tt: TypeTag[T], nn: NotNothing[T]): ActorRef =
    super.injectNamedActorRef[T](identifiers: _*)(name)(f, injector, ct, tt, nn)

  override def injectActorProps[T](constraints: => InjectConstraints[T])
                                  (implicit injector: Injector, ct: ClassTag[T], tt: TypeTag[T], nn: NotNothing[T]): Props =
    super.injectActorProps[T](constraints)(injector, ct, tt, nn)

  override def injectActorRef[T](constraints: => InjectConstraints[T])
                                 (implicit f: ActorRefFactory, injector: Injector, ct: ClassTag[T], tt: TypeTag[T], nn: NotNothing[T]): ActorRef =
    super.injectActorRef[T](constraints)(f, injector, ct, tt, nn)

  override def injectNamedActorRef[T](constraints: => InjectConstraints[T])
                                     (name: String)
                                     (implicit f: ActorRefFactory, injector: Injector, ct: ClassTag[T], tt: TypeTag[T], nn: NotNothing[T]): ActorRef =
    super.injectNamedActorRef[T](constraints)(name)(f, injector, ct, tt, nn)
}