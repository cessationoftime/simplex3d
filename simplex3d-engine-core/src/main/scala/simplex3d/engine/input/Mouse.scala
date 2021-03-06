/*
 * Simplex3dEngine - Core Module
 * Copyright (C) 2011, Aleksey Nikiforov
 *
 * This file is part of Simplex3dEngine.
 *
 * Simplex3dEngine is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Simplex3dEngine is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package simplex3d.engine.input

import simplex3d.math._
import simplex3d.math.precisiondouble._


abstract class Mouse {
  var sensitivity: ConstVec2
  var wheelSensitivity :Double
  
  def isGrabbed_=(grabbed: Boolean) :Unit
  def isGrabbed: Boolean
  
  def setPosition(position: inVec2i) :Unit
  //def setCursor() :Unit // TODO add later
  
  def isButtonDown(buttonCode: Int) :Boolean
  def position: Option[ConstVec2i]
  def delta: ConstVec2
  def wheelDelta: Double
}
