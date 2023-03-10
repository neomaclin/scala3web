package com.group.quasi

import cats.effect.{ExitCode, IO, IOApp, Resource, ResourceApp}
import cats.syntax.all.*
import org.typelevel.log4cats._
import org.typelevel.log4cats.slf4j._

object Main extends ResourceApp.Forever:
  implicit val logger: SelfAwareStructuredLogger[IO] = Slf4jFactory[IO].getLogger

  def run(args: List[String]): Resource[IO, Unit] = Config.load[IO] >>= Server.init[IO]

