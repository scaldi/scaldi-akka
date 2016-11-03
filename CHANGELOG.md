## v0.5.8 (2016-11-03)

* Updated scaldi v0.5.8
* Cross-compile for scala 2.11 and 2.12
* Updated dependencies

## v0.5.7 (2015-12-11)

* Updated scaldi v0.5.7
* Updated akka v2.4.1
* Compiled with Java 8 from now on

## v0.5.6 (28.05.2015)

* Updated to scaldi version 0.5.6

## v0.5.5 (29.04.2015)

* Updated to scaldi version 0.5.5

## v0.5.4 (11.04.2015)

* Updated to scaldi version 0.5.4

## v0.5.4 (11.04.2015)

* Updated to scaldi version 0.5.4

## v0.5.3 (03.02.2015)

* Updated to scaldi version 0.5.3

## v0.5.1 (01.02.2015)

* Updated to scaldi version 0.5.1

## v0.5 (31.01.2015)

* Updated to scaldi version 0.5

## v0.4 (22.06.2014)

* Updated to scaldi version 0.4

## v0.3.3 (24.04.2014)

* Updated to scaldi version 0.3.2

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
