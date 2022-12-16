package com.group.quasi

import cats.effect.{Async, Resource}

object Config:
  final case class App()

  def load[F[_] : Async]: Resource[F, App] = Resource.pure(App())

