/*
 * Simplex3dMath - Test Package
 * Copyright (C) 2010-2011, Aleksey Nikiforov
 *
 * This file is part of Simplex3dMathTest.
 *
 * Simplex3dMathTest is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Simplex3dMathTest is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package simplex3d.test.math.floatx

import org.scalatest._

import simplex3d.math._
import simplex3d.math.float._
import simplex3d.math.doublex._
import simplex3d.math.floatx.functions._
import MatConstants._


/**
 * @author Aleksey Nikiforov (lex)
 */
class Mat3x3fTest extends FunSuite {
  
  val M = Mat4(
    m00, m01, m02, m03,
    m10, m11, m12, m13,
    m20, m21, m22, m23,
    m30, m31, m32, m33
  )

  test("Clone") {
    var t: ReadMat3x3 = Mat3x3(5)
    assert(t.clone ne t)
    assert(t.clone == t)

    t = ConstMat3x3(5)
    assert(t.clone eq t)
  }

  test("Factories") {
    var m: ReadMat3x3 = Mat3x3(1)

    m = Mat3x3(f00)
    expectResult(classOf[Mat3x3]) { m.getClass }
    expectResult((f00, 0, 0)) { (m.m00, m.m01, m.m02) }
    expectResult((0, f00, 0)) { (m.m10, m.m11, m.m12) }
    expectResult((0, 0, f00)) { (m.m20, m.m21, m.m22) }

    m = Mat3x3(
      f00, f01, f02,
      f10, f11, f12,
      f20, f21, f22
    )
    expectResult(classOf[Mat3x3]) { m.getClass }
    expectResult((f00, f01, f02)) { (m.m00, m.m01, m.m02) }
    expectResult((f10, f11, f12)) { (m.m10, m.m11, m.m12) }
    expectResult((f20, f21, f22)) { (m.m20, m.m21, m.m22) }

    m = Mat3x3(
      Vec3(f00, f01, f02),
      Vec3(f10, f11, f12),
      Vec3(f20, f21, f22)
    )
    expectResult(classOf[Mat3x3]) { m.getClass }
    expectResult((f00, f01, f02)) { (m.m00, m.m01, m.m02) }
    expectResult((f10, f11, f12)) { (m.m10, m.m11, m.m12) }
    expectResult((f20, f21, f22)) { (m.m20, m.m21, m.m22) }

    m = Mat3x3(Mat2x2(
      f00, f01,
      f10, f11
    ))
    expectResult(classOf[Mat3x3]) { m.getClass }
    expectResult((f00, f01, 0)) { (m.m00, m.m01, m.m02) }
    expectResult((f10, f11, 0)) { (m.m10, m.m11, m.m12) }
    expectResult((0, 0, 1)) { (m.m20, m.m21, m.m22) }

    m = Mat3x3(Mat3x2(
      f00, f01,
      f10, f11,
      f20, f21
    ))
    expectResult(classOf[Mat3x3]) { m.getClass }
    expectResult((f00, f01, 0)) { (m.m00, m.m01, m.m02) }
    expectResult((f10, f11, 0)) { (m.m10, m.m11, m.m12) }
    expectResult((f20, f21, 1)) { (m.m20, m.m21, m.m22) }

    m = Mat3x3(Mat4x2(
      f00, f01,
      f10, f11,
      f20, f21,
      f30, f31
    ))
    expectResult(classOf[Mat3x3]) { m.getClass }
    expectResult((f00, f01, 0)) { (m.m00, m.m01, m.m02) }
    expectResult((f10, f11, 0)) { (m.m10, m.m11, m.m12) }
    expectResult((f20, f21, 1)) { (m.m20, m.m21, m.m22) }

    m = Mat3x3(Mat2x3(
      f00, f01, f02,
      f10, f11, f12
    ))
    expectResult(classOf[Mat3x3]) { m.getClass }
    expectResult((f00, f01, f02)) { (m.m00, m.m01, m.m02) }
    expectResult((f10, f11, f12)) { (m.m10, m.m11, m.m12) }
    expectResult((0, 0, 1)) { (m.m20, m.m21, m.m22) }

    m = Mat3x3(Mat3x3(
      f00, f01, f02,
      f10, f11, f12,
      f20, f21, f22
    ))
    expectResult(classOf[Mat3x3]) { m.getClass }
    expectResult((f00, f01, f02)) { (m.m00, m.m01, m.m02) }
    expectResult((f10, f11, f12)) { (m.m10, m.m11, m.m12) }
    expectResult((f20, f21, f22)) { (m.m20, m.m21, m.m22) }

    m = Mat3x3(Mat4x3(
      f00, f01, f02,
      f10, f11, f12,
      f20, f21, f22,
      f30, f31, f32
    ))
    expectResult(classOf[Mat3x3]) { m.getClass }
    expectResult((f00, f01, f02)) { (m.m00, m.m01, m.m02) }
    expectResult((f10, f11, f12)) { (m.m10, m.m11, m.m12) }
    expectResult((f20, f21, f22)) { (m.m20, m.m21, m.m22) }

    m = Mat3x3(Mat2x4(
      f00, f01, f02, f03,
      f10, f11, f12, f13
    ))
    expectResult(classOf[Mat3x3]) { m.getClass }
    expectResult((f00, f01, f02)) { (m.m00, m.m01, m.m02) }
    expectResult((f10, f11, f12)) { (m.m10, m.m11, m.m12) }
    expectResult((0, 0, 1)) { (m.m20, m.m21, m.m22) }

    m = Mat3x3(Mat3x4(
      f00, f01, f02, f03,
      f10, f11, f12, f13,
      f20, f21, f22, f23
    ))
    expectResult(classOf[Mat3x3]) { m.getClass }
    expectResult((f00, f01, f02)) { (m.m00, m.m01, m.m02) }
    expectResult((f10, f11, f12)) { (m.m10, m.m11, m.m12) }
    expectResult((f20, f21, f22)) { (m.m20, m.m21, m.m22) }

    m = Mat3x3(Mat4x4(
      f00, f01, f02, f03,
      f10, f11, f12, f13,
      f20, f21, f22, f23,
      f30, f31, f32, f33
    ))
    expectResult(classOf[Mat3x3]) { m.getClass }
    expectResult((f00, f01, f02)) { (m.m00, m.m01, m.m02) }
    expectResult((f10, f11, f12)) { (m.m10, m.m11, m.m12) }
    expectResult((f20, f21, f22)) { (m.m20, m.m21, m.m22) }

    m = Mat3x3(
      Vec3d(d00, d01, d02),
      Vec3d(d10, d11, d12),
      Vec3d(d20, d21, d22)
    )
    expectResult(classOf[Mat3x3]) { m.getClass }
    expectResult((toFloat(d00), toFloat(d01), toFloat(d02))) { (m.m00, m.m01, m.m02) }
    expectResult((toFloat(d10), toFloat(d11), toFloat(d12))) { (m.m10, m.m11, m.m12) }
    expectResult((toFloat(d20), toFloat(d21), toFloat(d22))) { (m.m20, m.m21, m.m22) }

    m = Mat3x3(Mat2x2d(
      d00, d01,
      d10, d11
    ))
    expectResult(classOf[Mat3x3]) { m.getClass }
    expectResult((toFloat(d00), toFloat(d01), 0)) { (m.m00, m.m01, m.m02) }
    expectResult((toFloat(d10), toFloat(d11), 0)) { (m.m10, m.m11, m.m12) }
    expectResult((0, 0, 1)) { (m.m20, m.m21, m.m22) }

    m = Mat3x3(Mat3x2d(
      d00, d01,
      d10, d11,
      d20, d21
    ))
    expectResult(classOf[Mat3x3]) { m.getClass }
    expectResult((toFloat(d00), toFloat(d01), 0)) { (m.m00, m.m01, m.m02) }
    expectResult((toFloat(d10), toFloat(d11), 0)) { (m.m10, m.m11, m.m12) }
    expectResult((toFloat(d20), toFloat(d21), 1)) { (m.m20, m.m21, m.m22) }

    m = Mat3x3(Mat4x2d(
      d00, d01,
      d10, d11,
      d20, d21,
      d30, d31
    ))
    expectResult(classOf[Mat3x3]) { m.getClass }
    expectResult((toFloat(d00), toFloat(d01), 0)) { (m.m00, m.m01, m.m02) }
    expectResult((toFloat(d10), toFloat(d11), 0)) { (m.m10, m.m11, m.m12) }
    expectResult((toFloat(d20), toFloat(d21), 1)) { (m.m20, m.m21, m.m22) }

    m = Mat3x3(Mat2x3d(
      d00, d01, d02,
      d10, d11, d12
    ))
    expectResult(classOf[Mat3x3]) { m.getClass }
    expectResult((toFloat(d00), toFloat(d01), toFloat(d02))) { (m.m00, m.m01, m.m02) }
    expectResult((toFloat(d10), toFloat(d11), toFloat(d12))) { (m.m10, m.m11, m.m12) }
    expectResult((0, 0, 1)) { (m.m20, m.m21, m.m22) }

    m = Mat3x3(Mat3x3d(
      d00, d01, d02,
      d10, d11, d12,
      d20, d21, d22
    ))
    expectResult(classOf[Mat3x3]) { m.getClass }
    expectResult((toFloat(d00), toFloat(d01), toFloat(d02))) { (m.m00, m.m01, m.m02) }
    expectResult((toFloat(d10), toFloat(d11), toFloat(d12))) { (m.m10, m.m11, m.m12) }
    expectResult((toFloat(d20), toFloat(d21), toFloat(d22))) { (m.m20, m.m21, m.m22) }

    m = Mat3x3(Mat4x3d(
      d00, d01, d02,
      d10, d11, d12,
      d20, d21, d22,
      d30, d31, d32
    ))
    expectResult(classOf[Mat3x3]) { m.getClass }
    expectResult((toFloat(d00), toFloat(d01), toFloat(d02))) { (m.m00, m.m01, m.m02) }
    expectResult((toFloat(d10), toFloat(d11), toFloat(d12))) { (m.m10, m.m11, m.m12) }
    expectResult((toFloat(d20), toFloat(d21), toFloat(d22))) { (m.m20, m.m21, m.m22) }

    m = Mat3x3(Mat2x4d(
      d00, d01, d02, d03,
      d10, d11, d12, d13
    ))
    expectResult(classOf[Mat3x3]) { m.getClass }
    expectResult((toFloat(d00), toFloat(d01), toFloat(d02))) { (m.m00, m.m01, m.m02) }
    expectResult((toFloat(d10), toFloat(d11), toFloat(d12))) { (m.m10, m.m11, m.m12) }
    expectResult((0, 0, 1)) { (m.m20, m.m21, m.m22) }

    m = Mat3x3(Mat3x4d(
      d00, d01, d02, d03,
      d10, d11, d12, d13,
      d20, d21, d22, d23
    ))
    expectResult(classOf[Mat3x3]) { m.getClass }
    expectResult((toFloat(d00), toFloat(d01), toFloat(d02))) { (m.m00, m.m01, m.m02) }
    expectResult((toFloat(d10), toFloat(d11), toFloat(d12))) { (m.m10, m.m11, m.m12) }
    expectResult((toFloat(d20), toFloat(d21), toFloat(d22))) { (m.m20, m.m21, m.m22) }

    m = Mat3x3(Mat4x4d(
      d00, d01, d02, d03,
      d10, d11, d12, d13,
      d20, d21, d22, d23,
      d30, d31, d32, d33
    ))
    expectResult(classOf[Mat3x3]) { m.getClass }
    expectResult((toFloat(d00), toFloat(d01), toFloat(d02))) { (m.m00, m.m01, m.m02) }
    expectResult((toFloat(d10), toFloat(d11), toFloat(d12))) { (m.m10, m.m11, m.m12) }
    expectResult((toFloat(d20), toFloat(d21), toFloat(d22))) { (m.m20, m.m21, m.m22) }


    m = ConstMat3x3(
      f00, f01, f02,
      f10, f11, f12,
      f20, f21, f22
    )
    expectResult(classOf[ConstMat3x3]) { m.getClass }
    expectResult((f00, f01, f02)) { (m.m00, m.m01, m.m02) }
    expectResult((f10, f11, f12)) { (m.m10, m.m11, m.m12) }
    expectResult((f20, f21, f22)) { (m.m20, m.m21, m.m22) }

    m = ConstMat3x3(
      Vec3(f00, f01, f02),
      Vec3(f10, f11, f12),
      Vec3(f20, f21, f22)
    )
    expectResult(classOf[ConstMat3x3]) { m.getClass }
    expectResult((f00, f01, f02)) { (m.m00, m.m01, m.m02) }
    expectResult((f10, f11, f12)) { (m.m10, m.m11, m.m12) }
    expectResult((f20, f21, f22)) { (m.m20, m.m21, m.m22) }

    m = ConstMat3x3(Mat3x3(
      f00, f01, f02,
      f10, f11, f12,
      f20, f21, f22
    ))
    expectResult(classOf[ConstMat3x3]) { m.getClass }
    expectResult((f00, f01, f02)) { (m.m00, m.m01, m.m02) }
    expectResult((f10, f11, f12)) { (m.m10, m.m11, m.m12) }
    expectResult((f20, f21, f22)) { (m.m20, m.m21, m.m22) }

    m = ConstMat3x3(
      Vec3d(d00, d01, d02),
      Vec3d(d10, d11, d12),
      Vec3d(d20, d21, d22)
    )
    expectResult(classOf[ConstMat3x3]) { m.getClass }
    expectResult((toFloat(d00), toFloat(d01), toFloat(d02))) { (m.m00, m.m01, m.m02) }
    expectResult((toFloat(d10), toFloat(d11), toFloat(d12))) { (m.m10, m.m11, m.m12) }
    expectResult((toFloat(d20), toFloat(d21), toFloat(d22))) { (m.m20, m.m21, m.m22) }

    m = ConstMat3x3(Mat3x3d(
      d00, d01, d02,
      d10, d11, d12,
      d20, d21, d22
    ))
    expectResult(classOf[ConstMat3x3]) { m.getClass }
    expectResult((toFloat(d00), toFloat(d01), toFloat(d02))) { (m.m00, m.m01, m.m02) }
    expectResult((toFloat(d10), toFloat(d11), toFloat(d12))) { (m.m10, m.m11, m.m12) }
    expectResult((toFloat(d20), toFloat(d21), toFloat(d22))) { (m.m20, m.m21, m.m22) }
  }

  test("Unapply") {
    Mat3x3(
      f00, f01, f02,
      f10, f11, f12,
      f20, f21, f22
    ) match {
      case Mat3x3(c1, c2, c3) =>
        if (
          c1 != Vec3(f00, f01, f02) ||
          c2 != Vec3(f10, f11, f12) ||
          c3 != Vec3(f20, f21, f22)
        ) throw new AssertionError()
    }
    ConstMat3x3(
      f00, f01, f02,
      f10, f11, f12,
      f20, f21, f22
    ) match {
      case Mat3x3(c1, c2, c3) =>
        if (
          c1 != Vec3(f00, f01, f02) ||
          c2 != Vec3(f10, f11, f12) ||
          c3 != Vec3(f20, f21, f22)
        ) throw new AssertionError()
    }
  }

  test("Const conversions") {
    val i = Mat3x3(
      m00, m01, m02,
      m10, m11, m12,
      m20, m21, m22
    )

    val t: ConstMat3x3 = i
    expectResult(classOf[ConstMat3]) { t.getClass }
    assert(i == t)

    var c = ConstMat3x3(2); val v = i
    expectResult(classOf[Mat3]) { v.getClass }
    c = v; assert(i == c)
    expectResult(classOf[ConstMat3]) { c.getClass }
  }

  test("Equality methods") {
    val m = Mat3x3(
      m00, m01, m02,
      m10, m11, m12,
      m20, m21, m22
    )
    val n = ConstMat3x3(
      m00, m01, m02,
      m10, m11, m12,
      m20, m21, m22
    )
    assert(m == m)
    assert(m == n)
    assert(n == m)
    assert(n == n)

    assert(m.equals(n))
    assert(!m.equals(Nil))

    for (r <- 0 until 3; c <- 0 until 3) {
      val t = Mat3x3(n)
      t(c, r) = -1
      assert(t != n)
    }

    assert(m == Mat3x3d(M))
    for (r <- 0 until 3; c <- 0 until 3) {
      val t = Mat3x3d(M)
      t(c, r) = -1
      assert(m != t)
    }
  }

  test("Indexed read") {
    {
      val m = ConstMat3x3(
        1, 2, 3,
        4, 5, 6,
        7, 8, 9
      )

      var count = 0
      for (c <- 0 until 3; r <- 0 until 3) {
        count += 1
        expectResult(count) { m(c, r) }
      }

      intercept[IndexOutOfBoundsException] {
        m(3, 1)
      }
      intercept[IndexOutOfBoundsException] {
        m(-1, 1)
      }

      intercept[IndexOutOfBoundsException] {
        m(1, 3)
      }
      intercept[IndexOutOfBoundsException] {
        m(1, -1)
      }
    }

    val m = ConstMat3x3(
      m00, m01, m02,
      m10, m11, m12,
      m20, m21, m22
    )

    expectResult(Vec3(m00, m01, m02)) { m(0) }
    expectResult(Vec3(m10, m11, m12)) { m(1) }
    expectResult(Vec3(m20, m21, m22)) { m(2) }

    expectResult(classOf[ConstVec3]) { m(0).getClass }
    expectResult(classOf[ConstVec3]) { m(1).getClass }
    expectResult(classOf[ConstVec3]) { m(2).getClass }

    intercept[IndexOutOfBoundsException] {
      m(3)
    }
    intercept[IndexOutOfBoundsException] {
      m(-1)
    }
  }

  test("Indexed write") {
    var m = Mat3x3(
      m00, m01, m02,
      m10, m11, m12,
      m20, m21, m22
    )

    var count = 0
    for (c <- 0 until 3; r <- 0 until 3) {
      count += 1
      m(c, r) = count + 1
      expectResult(count + 1) { m(c, r) }
    }

    intercept[IndexOutOfBoundsException] {
      m(3, 1) = 1
    }
    intercept[IndexOutOfBoundsException] {
      m(-1, 1) = 1
    }

    intercept[IndexOutOfBoundsException] {
      m(1, 3) = 1
    }
    intercept[IndexOutOfBoundsException] {
      m(1, -1) = 1
    }

    m = Mat3x3(0)

    m(0) = Vec3(m00, m01, m02)
    m(1) = Vec3(m10, m11, m12)
    m(2) = Vec3(m20, m21, m22)

    expectResult(Vec3(m00, m01, m02)) { m(0) }
    expectResult(Vec3(m10, m11, m12)) { m(1) }
    expectResult(Vec3(m20, m21, m22)) { m(2) }

    m = Mat3x3(0)

    m(0) = Vec2(m00, m01)
    m(1) = Vec2(m10, m11)
    m(2) = Vec2(m20, m21)

    expectResult(Vec3(m00, m01, 0)) { m(0) }
    expectResult(Vec3(m10, m11, 0)) { m(1) }
    expectResult(Vec3(m20, m21, 0)) { m(2) }

    intercept[IndexOutOfBoundsException] {
      m(3) = Vec3(1)
      m(3) = Vec2(1)
    }
    intercept[IndexOutOfBoundsException] {
      m(-1) = Vec3(1)
      m(-1) = Vec2(1)
    }
  }

  test("Setters") {
    var m = Mat3x3(0)
    val i = ConstMat3x3(
      m00, m01, m02,
      m10, m11, m12,
      m20, m21, m22
    )

    m = Mat3x3(0)
    m := i
    expectResult((m00, m01, m02)) { (m.m00, m.m01, m.m02) }
    expectResult((m10, m11, m12)) { (m.m10, m.m11, m.m12) }
    expectResult((m20, m21, m22)) { (m.m20, m.m21, m.m22) }
  }

  test("Const math") {
    val m = ConstMat3x3(
      m00, m01, m02,
      m10, m11, m12,
      m20, m21, m22
    )
    assert(+m eq m)

    var t = Mat3x3(
      -m00, -m01, -m02,
      -m10, -m11, -m12,
      -m20, -m21, -m22
    )
    assert(-m == t)

    t = Mat3x3(
      2*m00, 2*m01, 2*m02,
      2*m10, 2*m11, 2*m12,
      2*m20, 2*m21, 2*m22
    )
    assert(m*2 == t)

    t = Mat3x3(
      m00/2, m01/2, m02/2,
      m10/2, m11/2, m12/2,
      m20/2, m21/2, m22/2
    )
    assert(m/2 == t)

    t = Mat3x3(
      m00+2, m01+2, m02+2,
      m10+2, m11+2, m12+2,
      m20+2, m21+2, m22+2
    )
    assert(m + 2 == t)

    t = Mat3x3(
      m00-2, m01-2, m02-2,
      m10-2, m11-2, m12-2,
      m20-2, m21-2, m22-2
    )
    assert(m - 2 == t)

    val n: ConstMat3x3 = m*3

    t = Mat3x3(
      4*m00, 4*m01, 4*m02,
      4*m10, 4*m11, 4*m12,
      4*m20, 4*m21, 4*m22
    )
    assert(n + m == t)

    t = Mat3x3(
      2*m00, 2*m01, 2*m02,
      2*m10, 2*m11, 2*m12,
      2*m20, 2*m21, 2*m22
    )
    assert(n - m == t)

    t = Mat3x3(
      3, 3, 3,
      3, 3, 3,
      3, 3, 3
    )
    assert(n / m == t)

    
    val mul23 = Mat2x3(
      38, 44, 50,
      98, 116, 134
    )
    assert(m*Mat2x3(M) == mul23)

    val mul33 = Mat3x3(
      38, 44, 50,
      98, 116, 134,
      158, 188, 218
    )
    assert(m*Mat3x3(M) == mul33)

    val mul43 = Mat4x3(
      38, 44, 50,
      98, 116, 134,
      158, 188, 218,
      218, 260, 302
    )
    assert(m*Mat4x3(M) == mul43)

    assert(m*Vec3(1, 2, 3) == Vec3(38, 44, 50))
  }

  test("Mutable math") {
    val m = Mat3x3(0)
    val i = ConstMat3x3(
      m00, m01, m02,
      m10, m11, m12,
      m20, m21, m22
    )

    var t = Mat3x3(
      2*m00, 2*m01, 2*m02,
      2*m10, 2*m11, 2*m12,
      2*m20, 2*m21, 2*m22
    )
    m := i; m *= 2; assert(m == t)

    t = Mat3x3(
      m00/2, m01/2, m02/2,
      m10/2, m11/2, m12/2,
      m20/2, m21/2, m22/2
    )
    m := i; m /= 2; assert(m == t)

    t = Mat3x3(
      m00+2, m01+2, m02+2,
      m10+2, m11+2, m12+2,
      m20+2, m21+2, m22+2
    )
    m := i; m += 2; assert(m == t)

    t = Mat3x3(
      m00-2, m01-2, m02-2,
      m10-2, m11-2, m12-2,
      m20-2, m21-2, m22-2
    )
    m := i; m -= 2; assert(m == t)

    val n: ConstMat3x3 = i*3

    t = Mat3x3(
      4*m00, 4*m01, 4*m02,
      4*m10, 4*m11, 4*m12,
      4*m20, 4*m21, 4*m22
    )
    m := i; m += n; assert(m == t)

    t = Mat3x3(
      -2*m00, -2*m01, -2*m02,
      -2*m10, -2*m11, -2*m12,
      -2*m20, -2*m21, -2*m22
    )
    m := i; m -= n; assert(m == t)

    t = Mat3x3(
      38, 44, 50,
      98, 116, 134,
      158, 188, 218
    )
    m := i; m *= m; assert(m == t)

    t = Mat3x3(
      1, 1, 1,
      1, 1, 1,
      1, 1, 1
    )
    m := i; m/= m; assert(m == t)
  }

}