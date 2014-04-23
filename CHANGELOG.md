## v0.3.2 (23.04.2014)

* Added support for scala 2.11 (cross-compiling with 2.10 and 2.11)
* Updated scaldi to version 0.3.1

## v0.3.1 (03.03.2014)

* Now using implicit `ActorRefFactory` instead of `ActorSystem` in order to use `ActorContext` when available

## v0.3 (02.03.2014 - Initial release)

* Allows to inject actor `Props` and `ActorRef` for the actor bindings:
  ```
  // bind
  binding toProvider new Greeter
  bind [GreetPrinter] toProvider new GreetPrinter

  // inject
  injectActorProps [GreetPrinter]
  injectActorRef [GreetPrinter]
  injectActorRef [GreetPrinter] ("printer")
  ```
  It is important to note, that `Actor` bindings should always be providers (bound with `toProvider` method, which will create new instances each time it gets injected)
