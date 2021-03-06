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

import scala.collection.mutable.ArrayBuffer
import sbt._
import Keys._


object Simplex3dEngine extends Build {
  
  val buildSettings = Common.buildSettings ++ Seq(
    version := Simplex3d.EngineVersion,
    startYear := Some(2011),
    licenses := Seq(("LGPLv3+", new URL("http://www.gnu.org/licenses/lgpl.html")))
  )

  lazy val core = Project(
    id = "engine-core",
    base = file("simplex3d-engine-core"),
    settings = buildSettings ++ Common.publishSettings ++ Seq(
      name := "simplex3d-engine-core",
      description := "Simplex3D Engine, Core Module.",
      libraryDependencies += "org.scala-lang" % "scala-reflect" % Simplex3d.ScalaVersion
    )
  ) dependsOn(
    Simplex3dMath.core, Simplex3dMath.double,
    Simplex3dData.core, Simplex3dData.double, Simplex3dData.format,
    Simplex3dAlgorithm.intersection
  )
  
  lazy val sceneGraph = Project(
    id = "engine-scenegraph",
    base = file("simplex3d-engine-scenegraph"),
    settings = buildSettings ++ Common.publishSettings ++ Seq(
      name := "simplex3d-engine-scenegraph",
      description := "Simplex3D Engine, Scenegraph Module."
    )
  ) dependsOn(core)
  
  lazy val renderer = Project(
    id = "engine-renderer",
    base = file("simplex3d-engine-renderer"),
    settings = buildSettings ++ Common.publishSettings ++ Seq(
      name := "simplex3d-engine-renderer",
      description := "Simplex3D Engine, Renderer Module."
    )
  ) dependsOn(core)
  
  lazy val backendOpengl = Project(
    id = "engine-backend-opengl",
    base = file("simplex3d-engine-backend-opengl"),
    settings = buildSettings ++ Common.publishSettings ++ Seq(
      name := "simplex3d-engine-backend-opengl",
      description := "Simplex3D Engine, Common OpenGL Backend."
    )
  ) dependsOn(core)
  
  lazy val backendLwjgl = Project(
    id = "engine-backend-lwjgl",
    base = file("simplex3d-engine-backend-lwjgl"),
    settings = buildSettings ++ Common.publishSettings ++ Common.lwjglSettings ++ Seq(
      name := "simplex3d-engine-backend-lwjgl",
      description := "Simplex3D Engine, LWJGL Backend."
    )
  ) dependsOn(core, backendOpengl)
  
  lazy val vanilla = Project(
    id = "engine-vanilla",
    base = file("simplex3d-engine-vanilla"),
    settings = buildSettings ++ Common.publishSettings ++ Seq(
      name := "simplex3d-engine-vanilla",
      description := "Simplex3D Engine, Default Implementation."
    )
  ) dependsOn(core, sceneGraph, renderer, backendOpengl, backendLwjgl)
  
  
  //lazy val doc = Project(
  //  id = "engine-doc",
  //  base = file("simplex3d-engine"),
  //  settings = buildSettings ++ Seq(
  //    target := new File("target/engine/doc"),
  //    sourceGenerators in Compile <+= baseDirectory map { base =>
  //      val files = new ArrayBuffer[File]
  //      def index(dir: File) = {
  //        new FileSet(dir).foreach((path, _) => files += new File(dir, path))
  //        files: Seq[File]
  //      }
  //      index(base / "src/core") ++
  //      index(base / "src/scenegraph") ++
  //      index(base / "src/renderer") ++
  //      index(base / "src/vanilla")
  //    }
  //  )
  //) dependsOn(
   // Simplex3dMath.core, Simplex3dMath.double,
   // Simplex3dData.core, Simplex3dData.double, Simplex3dData.format,
   // Simplex3dAlgorithm.intersection
 // )
  
  lazy val test = Project(
    id = "engine-test",
    base = file("simplex3d-engine-test"),
    settings = buildSettings ++ Common.lwjglSettings ++ Seq(
      name := "simplex3d-engine-test",
      description := "Engine Tests.",
      licenses := Seq(("GPLv3+", new URL("http://www.gnu.org/licenses/gpl.html"))),
      libraryDependencies += "org.scalatest" %% "scalatest" % Simplex3d.ScalatestVersion % "test",
     unmanagedSourceDirectories in Compile <++= baseDirectory { base =>
       Seq(
         base / "/test/visual",
         base / "test/bench"
       )
     },
     scalaSource in Test <<= baseDirectory(_ / "test/unit")
   )
 ) dependsOn(
   Simplex3dAlgorithm.mesh, Simplex3dAlgorithm.noise,
   core, sceneGraph, renderer, backendOpengl, backendLwjgl, vanilla
 )
  
  lazy val example = Project(
    id = "engine-example",
    base = file("simplex3d-engine-example"),
    settings = buildSettings ++ Common.exampleSettings ++ Seq(
	  name := "simplex3d-engine-example"
	)
  ) dependsOn(
    core, sceneGraph, renderer, backendOpengl, backendLwjgl, vanilla,
    Simplex3dAlgorithm.mesh, Simplex3dAlgorithm.noise
  )
}
