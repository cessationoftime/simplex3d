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


object Simplex3dAlgorithm extends Build {
  
  val buildSettings = Common.buildSettings ++ Seq(
    startYear := Some(2010),
    licenses := Seq(("LGPLv3+", new URL("http://www.gnu.org/licenses/lgpl.html")))
  )
  
  //lazy val root = Project(
  //  id = "algorithm",
  //  base = file("."),
  //  settings = buildSettings
  //) aggregate(intersection, mesh, noise)
  
  lazy val intersection = Project(
    id = "algorithm-intersection",
    base = file("simplex3d-algorithm-intersection"),
    settings = buildSettings ++ Common.publishSettings ++ Seq(
      version := Simplex3d.AlgorithmIntersectionVersion,
      name := "simplex3d-algorithm-intersection",
      description := "Intersection and Collision Algorithms."
    )
  ) dependsOn(Simplex3dMath.core, Simplex3dMath.double)
  
  lazy val mesh = Project(
    id = "algorithm-mesh",
    base = file("simplex3d-algorithm-mesh"),
    settings = buildSettings ++ Common.publishSettings ++ Seq(
      version := Simplex3d.AlgorithmMeshVersion,
      name := "simplex3d-algorithm-mesh",
      description := "Algorithms to generate and work with mesh data."
    )
  ) dependsOn(Simplex3dMath.core, Simplex3dMath.double, Simplex3dData.core, Simplex3dData.double)
  
  lazy val noise = Project(
    id = "algorithm-noise",
    base = file("simplex3d-algorithm-noise"),
    settings = buildSettings ++ Common.publishSettings ++ Seq(
      version := Simplex3d.AlgorithmNoiseVersion,
      name := "simplex3d-algorithm-noise",
      description := "Noise Algorithms."
    )
  ) dependsOn(Simplex3dMath.core, Simplex3dMath.double)
  
  
 // lazy val doc = Project(
    //id = "algorithm-doc",
    //base = file("simplex3d-algorithm"),
    //settings = buildSettings ++ Seq(
  //    scalaSource in Compile <<= baseDirectory(_ / "src")
//    )
  //) dependsOn(Simplex3dMath.core, Simplex3dMath.double, Simplex3dData.core, Simplex3dData.double)
  
  //lazy val test = Project(
   //id = "algorithm-test",
   //base = file("simplex3d-algorithm-test"),
   //settings = buildSettings ++ Common.testSettings ++ Seq(
      //name := "simplex3d-algorithm-test",
      //description := "Algorithm Tests.",
      //licenses := Seq(("GPLv3+", new URL("http://www.gnu.org/licenses/gpl.html"))),
      //target := new File("target/algorithm/test")
    //)
  //) dependsOn(intersection, mesh, noise)
  
  lazy val example = Project(
    id = "algorithm-example",
    base = file("simplex3d-algorithm-example"),
    settings = buildSettings ++ Common.exampleSettings
  ) dependsOn(intersection, mesh, noise, Simplex3dScript.core)
}
