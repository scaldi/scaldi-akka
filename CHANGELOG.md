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
