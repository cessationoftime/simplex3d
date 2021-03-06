/*
 * Simplex3d Build Script
 * Copyright (C) 2011, Aleksey Nikiforov
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import sbt._
import Keys._


object Simplex3dData extends Build {
  
  val buildSettings = Common.buildSettings ++ Seq(
    version := Simplex3d.DataVersion,
    startYear := Some(2010),
    licenses := Seq(("LGPLv3+", new URL("http://www.gnu.org/licenses/lgpl.html")))
  )
  
  lazy val core = Project(
    id = "data-core",
    base = file("simplex3d-data-core"),
    settings = buildSettings ++ Common.publishSettings ++ Seq(
      name := "simplex3d-data-core",
      description := "Data Binding API, Core Module.",
      libraryDependencies += "org.scala-lang" % "scala-reflect" % Simplex3d.ScalaVersion
    )
  ) dependsOn(Simplex3dMath.core)
  
  lazy val double = Project(
    id = "data-precisiondouble",
    base = file("simplex3d-data-precisiondouble"),
    settings = buildSettings ++ Common.publishSettings ++ Seq(
      name := "simplex3d-data-precisiondouble",
      description := "Data Binding API, Double Module."
    )
  ) dependsOn(core, Simplex3dMath.double)
  
  lazy val float = Project(
    id = "data-precisionsingle",
    base = file("simplex3d-data-precisionsingle"),
    settings = buildSettings ++ Common.publishSettings ++ Seq(
      name := "simplex3d-data-precisionsingle",
      description := "Data Binding API, Float Module."
    )
  ) dependsOn(core, Simplex3dMath.float)
  
  lazy val format = Project(
    id = "data-format",
    base = file("simplex3d-data-format"),
    settings = buildSettings ++ Common.publishSettings ++ Seq(
      name := "simplex3d-data-format",
      description := "Additional data formats for Data Binding API."
    )
  ) dependsOn(core, double, Simplex3dMath.double)
  
  
 // lazy val doc = Project(
 //   id = "data-doc",
 //   base = file("simplex3d-data-doc"),
 //   settings = buildSettings ++ Seq(
 //     target := new File("target/data/doc"),
 //     scalaSource in Compile <<= baseDirectory(_ / "src")
 //   )
 // ) dependsOn(Simplex3dMath.core, Simplex3dMath.double, Simplex3dMath.float)
  
  lazy val test = Project(
    id = "data-test",
    base = file("simplex3d-data-test"),
    settings = buildSettings ++ Common.testSettings ++ Seq(
      name := "simplex3d-data-test",
      description := "Data Binding API, Tests.",
      licenses := Seq(("GPLv3+", new URL("http://www.gnu.org/licenses/gpl.html")))
    )
  ) dependsOn(core, double, float, format)
  
  lazy val example = Project(
    id = "data-example",
    base = file("simplex3d-data-example"),
    settings = buildSettings ++ Common.exampleSettings ++ Seq(
	   name := "simplex3d-data-example"
	)
  ) dependsOn(core, double, format)
}
