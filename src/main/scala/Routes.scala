package com.group.quasi

import cats.effect.Sync
import cats.implicits.*
import org.http4s.HttpRoutes
import org.http4s.dsl.Http4sDsl
import org.typelevel.log4cats.Logger

final class Routes[F[_] : Sync : Logger]:
  private val dsl = Http4sDsl[F]

  import dsl._

  def nothing: HttpRoutes[F] = HttpRoutes.empty[F]


object Routes:
  def routes[F[_] : Sync : Logger]: Routes[F] = new Routes[F]

  def health[F[_] : Sync]: HttpRoutes[F] =
    val dsl = Http4sDsl[F]
    import dsl._
    HttpRoutes.of[F] {
      case GET -> Root / "health" | GET -> Root => Ok()
    }
