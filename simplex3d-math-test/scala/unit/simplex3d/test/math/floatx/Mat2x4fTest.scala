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
import simplex3d.math.precisionsingle._
import simplex3d.math.precisiondoublex._
import simplex3d.math.precisionsinglex.functions._
import MatConstants._


/**
 * @author Aleksey Nikiforov (lex)
 */
class Mat2x4fTest extends FunSuite {
  
  test("Clone") {
    var t: ReadMat2x4 = Mat2x4(5)
    assert(t.clone ne t)
    assert(t.clone == t)

    t = ConstMat2x4(5)
    assert(t.clone eq t)
  }

  test("Factories") {
    var m: ReadMat2x4 = Mat2x4(1)

    m = Mat2x4(f00)
    expectResult(classOf[Mat2x4]) { m.getClass }
    expectResult((f00, 0, 0, 0)) { (m.m00, m.m01, m.m02, m.m03) }
    expectResult((0, f00, 0, 0)) { (m.m10, m.m11, m.m12, m.m13) }

    m = Mat2x4(
      f00, f01, f02, f03,
      f10, f11, f12, f13
    )
    expectResult(classOf[Mat2x4]) { m.getClass }
    expectResult((f00, f01, f02, f03)) { (m.m00, m.m01, m.m02, m.m03) }
    expectResult((f10, f11, f12, f13)) { (m.m10, m.m11, m.m12, m.m13) }

    m = Mat2x4(
      Vec4(f00, f01, f02, f03),
      Vec4(f10, f11, f12, f13)
    )
    expectResult(classOf[Mat2x4]) { m.getClass }
    expectResult((f00, f01, f02, f03)) { (m.m00, m.m01, m.m02, m.m03) }
    expectResult((f10, f11, f12, f13)) { (m.m10, m.m11, m.m12, m.m13) }

    m = Mat2x4(Mat2x2(
      f00, f01,
      f10, f11
    ))
    expectResult(classOf[Mat2x4]) { m.getClass }
    expectResult((f00, f01, 0, 0)) { (m.m00, m.m01, m.m02, m.m03) }
    expectResult((f10, f11, 0, 0)) { (m.m10, m.m11, m.m12, m.m13) }

    m = Mat2x4(Mat3x2(
      f00, f01,
      f10, f11,
      f20, f21
    ))
    expectResult(classOf[Mat2x4]) { m.getClass }
    expectResult((f00, f01, 0, 0)) { (m.m00, m.m01, m.m02, m.m03) }
    expectResult((f10, f11, 0, 0)) { (m.m10, m.m11, m.m12, m.m13) }

    m = Mat2x4(Mat4x2(
      f00, f01,
      f10, f11,
      f20, f21,
      f30, f31
    ))
    expectResult(classOf[Mat2x4]) { m.getClass }
    expectResult((f00, f01, 0, 0)) { (m.m00, m.m01, m.m02, m.m03) }
    expectResult((f10, f11, 0, 0)) { (m.m10, m.m11, m.m12, m.m13) }

    m = Mat2x4(Mat2x3(
      f00, f01, f02,
      f10, f11, f12
    ))
    expectResult(classOf[Mat2x4]) { m.getClass }
    expectResult((f00, f01, f02, 0)) { (m.m00, m.m01, m.m02, m.m03) }
    expectResult((f10, f11, f12, 0)) { (m.m10, m.m11, m.m12, m.m13) }

    m = Mat2x4(Mat3x3(
      f00, f01, f02,
      f10, f11, f12,
      f20, f21, f22
    ))
    expectResult(classOf[Mat2x4]) { m.getClass }
    expectResult((f00, f01, f02, 0)) { (m.m00, m.m01, m.m02, m.m03) }
    expectResult((f10, f11, f12, 0)) { (m.m10, m.m11, m.m12, m.m13) }

    m = Mat2x4(Mat4x3(
      f00, f01, f02,
      f10, f11, f12,
      f20, f21, f22,
      f30, f31, f32
    ))
    expectResult(classOf[Mat2x4]) { m.getClass }
    expectResult((f00, f01, f02, 0)) { (m.m00, m.m01, m.m02, m.m03) }
    expectResult((f10, f11, f12, 0)) { (m.m10, m.m11, m.m12, m.m13) }

    m = Mat2x4(Mat2x4(
      f00, f01, f02, f03,
      f10, f11, f12, f13
    ))
    expectResult(classOf[Mat2x4]) { m.getClass }
    expectResult((f00, f01, f02, f03)) { (m.m00, m.m01, m.m02, m.m03) }
    expectResult((f10, f11, f12, f13)) { (m.m10, m.m11, m.m12, m.m13) }

    m = Mat2x4(Mat3x4(
      f00, f01, f02, f03,
      f10, f11, f12, f13,
      f20, f21, f22, f23
    ))
    expectResult(classOf[Mat2x4]) { m.getClass }
    expectResult((f00, f01, f02, f03)) { (m.m00, m.m01, m.m02, m.m03) }
    expectResult((f10, f11, f12, f13)) { (m.m10, m.m11, m.m12, m.m13) }

    m = Mat2x4(Mat4x4(
      f00, f01, f02, f03,
      f10, f11, f12, f13,
      f20, f21, f22, f23,
      f30, f31, f32, f33
    ))
    expectResult(classOf[Mat2x4]) { m.getClass }
    expectResult((f00, f01, f02, f03)) { (m.m00, m.m01, m.m02, m.m03) }
    expectResult((f10, f11, f12, f13)) { (m.m10, m.m11, m.m12, m.m13) }

    m = Mat2x4(
      Vec4d(d00, d01, d02, d03),
      Vec4d(d10, d11, d12, d13)
    )
    expectResult(classOf[Mat2x4]) { m.getClass }
    expectResult((toFloat(d00), toFloat(d01), toFloat(d02), toFloat(d03))) { (m.m00, m.m01, m.m02, m.m03) }
    expectResult((toFloat(d10), toFloat(d11), toFloat(d12), toFloat(d13))) { (m.m10, m.m11, m.m12, m.m13) }

    m = Mat2x4(Mat2x2d(
      d00, d01,
      d10, d11
    ))
    expectResult(classOf[Mat2x4]) { m.getClass }
    expectResult((toFloat(d00), toFloat(d01), 0, 0)) { (m.m00, m.m01, m.m02, m.m03) }
    expectResult((toFloat(d10), toFloat(d11), 0, 0)) { (m.m10, m.m11, m.m12, m.m13) }

    m = Mat2x4(Mat3x2d(
      d00, d01,
      d10, d11,
      d20, d21
    ))
    expectResult(classOf[Mat2x4]) { m.getClass }
    expectResult((toFloat(d00), toFloat(d01), 0, 0)) { (m.m00, m.m01, m.m02, m.m03) }
    expectResult((toFloat(d10), toFloat(d11), 0, 0)) { (m.m10, m.m11, m.m12, m.m13) }

    m = Mat2x4(Mat4x2d(
      d00, d01,
      d10, d11,
      d20, d21,
      d30, d31
    ))
    expectResult(classOf[Mat2x4]) { m.getClass }
    expectResult((toFloat(d00), toFloat(d01), 0, 0)) { (m.m00, m.m01, m.m02, m.m03) }
    expectResult((toFloat(d10), toFloat(d11), 0, 0)) { (m.m10, m.m11, m.m12, m.m13) }

    m = Mat2x4(Mat2x3d(
      d00, d01, d02,
      d10, d11, d12
    ))
    expectResult(classOf[Mat2x4]) { m.getClass }
    expectResult((toFloat(d00), toFloat(d01), toFloat(d02), 0)) { (m.m00, m.m01, m.m02, m.m03) }
    expectResult((toFloat(d10), toFloat(d11), toFloat(d12), 0)) { (m.m10, m.m11, m.m12, m.m13) }

    m = Mat2x4(Mat3x3d(
      d00, d01, d02,
      d10, d11, d12,
      d20, d21, d22
    ))
    expectResult(classOf[Mat2x4]) { m.getClass }
    expectResult((toFloat(d00), toFloat(d01), toFloat(d02), 0)) { (m.m00, m.m01, m.m02, m.m03) }
    expectResult((toFloat(d10), toFloat(d11), toFloat(d12), 0)) { (m.m10, m.m11, m.m12, m.m13) }

    m = Mat2x4(Mat4x3d(
      d00, d01, d02,
      d10, d11, d12,
      d20, d21, d22,
      d30, d31, d32
    ))
    expectResult(classOf[Mat2x4]) { m.getClass }
    expectResult((toFloat(d00), toFloat(d01), toFloat(d02), 0)) { (m.m00, m.m01, m.m02, m.m03) }
    expectResult((toFloat(d10), toFloat(d11), toFloat(d12), 0)) { (m.m10, m.m11, m.m12, m.m13) }

    m = Mat2x4(Mat2x4d(
      d00, d01, d02, d03,
      d10, d11, d12, d13
    ))
    expectResult(classOf[Mat2x4]) { m.getClass }
    expectResult((toFloat(d00), toFloat(d01), toFloat(d02), toFloat(d03))) { (m.m00, m.m01, m.m02, m.m03) }
    expectResult((toFloat(d10), toFloat(d11), toFloat(d12), toFloat(d13))) { (m.m10, m.m11, m.m12, m.m13) }

    m = Mat2x4(Mat3x4d(
      d00, d01, d02, d03,
      d10, d11, d12, d13,
      d20, d21, d22, d23
    ))
    expectResult(classOf[Mat2x4]) { m.getClass }
    expectResult((toFloat(d00), toFloat(d01), toFloat(d02), toFloat(d03))) { (m.m00, m.m01, m.m02, m.m03) }
    expectResult((toFloat(d10), toFloat(d11), toFloat(d12), toFloat(d13))) { (m.m10, m.m11, m.m12, m.m13) }

    m = Mat2x4(Mat4x4d(
      d00, d01, d02, d03,
      d10, d11, d12, d13,
      d20, d21, d22, d23,
      d30, d31, d32, d33
    ))
    expectResult(classOf[Mat2x4]) { m.getClass }
    expectResult((toFloat(d00), toFloat(d01), toFloat(d02), toFloat(d03))) { (m.m00, m.m01, m.m02, m.m03) }
    expectResult((toFloat(d10), toFloat(d11), toFloat(d12), toFloat(d13))) { (m.m10, m.m11, m.m12, m.m13) }


    m = ConstMat2x4(
      f00, f01, f02, f03,
      f10, f11, f12, f13
    )
    expectResult(classOf[ConstMat2x4]) { m.getClass }
    expectResult((f00, f01, f02, f03)) { (m.m00, m.m01, m.m02, m.m03) }
    expectResult((f10, f11, f12, f13)) { (m.m10, m.m11, m.m12, m.m13) }

    m = ConstMat2x4(
      Vec4(f00, f01, f02, f03),
      Vec4(f10, f11, f12, f13)
    )
    expectResult(classOf[ConstMat2x4]) { m.getClass }
    expectResult((f00, f01, f02, f03)) { (m.m00, m.m01, m.m02, m.m03) }
    expectResult((f10, f11, f12, f13)) { (m.m10, m.m11, m.m12, m.m13) }

    m = ConstMat2x4(Mat2x4(
      f00, f01, f02, f03,
      f10, f11, f12, f13
    ))
    expectResult(classOf[ConstMat2x4]) { m.getClass }
    expectResult((f00, f01, f02, f03)) { (m.m00, m.m01, m.m02, m.m03) }
    expectResult((f10, f11, f12, f13)) { (m.m10, m.m11, m.m12, m.m13) }

    m = ConstMat2x4(
      Vec4d(d00, d01, d02, d03),
      Vec4d(d10, d11, d12, d13)
    )
    expectResult(classOf[ConstMat2x4]) { m.getClass }
    expectResult((toFloat(d00), toFloat(d01), toFloat(d02), toFloat(d03))) { (m.m00, m.m01, m.m02, m.m03) }
    expectResult((toFloat(d10), toFloat(d11), toFloat(d12), toFloat(d13))) { (m.m10, m.m11, m.m12, m.m13) }

    m = ConstMat2x4(Mat2x4d(
      d00, d01, d02, d03,
      d10, d11, d12, d13
    ))
    expectResult(classOf[ConstMat2x4]) { m.getClass }
    expectResult((toFloat(d00), toFloat(d01), toFloat(d02), toFloat(d03))) { (m.m00, m.m01, m.m02, m.m03) }
    expectResult((toFloat(d10), toFloat(d11), toFloat(d12), toFloat(d13))) { (m.m10, m.m11, m.m12, m.m13) }
  }

  test("Unapply") {
    Mat2x4(
      f00, f01, f02, f03,
      f10, f11, f12, f13
    ) match {
      case Mat2x4(c1, c2) =>
        if (
          c1 != Vec4(f00, f01, f02, f03) ||
          c2 != Vec4(f10, f11, f12, f13)
        ) throw new AssertionError()
    }
    ConstMat2x4(
      f00, f01, f02, f03,
      f10, f11, f12, f13
    ) match {
      case Mat2x4(c1, c2) =>
        if (
          c1 != Vec4(f00, f01, f02, f03) ||
          c2 != Vec4(f10, f11, f12, f13)
        ) throw new AssertionError()
    }
  }

  test("Const conversions") {
    val i = Mat2x4(
      m00, m01, m02, m03,
      m10, m11, m12, m13
    )

    val t: ConstMat2x4 = i
    expectResult(classOf[ConstMat2x4]) { t.getClass }
    assert(i == t)

    var c = ConstMat2x4(2); val v = i
    expectResult(classOf[Mat2x4]) { v.getClass }
    c = v; assert(i == c)
    expectResult(classOf[ConstMat2x4]) { c.getClass }
  }

  test("Equality methods") {
    val m = Mat2x4(
      m00, m01, m02, m03,
      m10, m11, m12, m13
    )
    val n = ConstMat2x4(
      m00, m01, m02, m03,
      m10, m11, m12, m13
    )
    assert(m == m)
    assert(m == n)
    assert(n == m)
    assert(n == n)

    assert(m.equals(n))
    assert(!m.equals(Nil))

    for (r <- 0 until 4; c <- 0 until 2) {
      val t = Mat2x4(n)
      t(c, r) = -1
      assert(t != n)
    }

    assert(m == Mat2x4d(M))
    for (r <- 0 until 4; c <- 0 until 2) {
      val t = Mat2x4d(M)
      t(c, r) = -1
      assert(m != t)
    }
  }

  test("Indexed read") {
    val m = ConstMat2x4(
      m00, m01, m02, m03,
      m10, m11, m12, m13
    )

    var count = 0
    for (c <- 0 until 2; r <- 0 until 4) {
      count += 1
      expectResult(count) { m(c, r) }
    }

    intercept[IndexOutOfBoundsException] {
      m(2, 1)
    }
    intercept[IndexOutOfBoundsException] {
      m(-1, 1)
    }

    intercept[IndexOutOfBoundsException] {
      m(1, 4)
    }
    intercept[IndexOutOfBoundsException] {
      m(1, -1)
    }

    expectResult(Vec4(m00, m01, m02, m03)) { m(0) }
    expectResult(Vec4(m10, m11, m12, m13)) { m(1) }

    expectResult(classOf[ConstVec4]) { m(0).getClass }
    expectResult(classOf[ConstVec4]) { m(1).getClass }

    intercept[IndexOutOfBoundsException] {
      m(2)
    }
    intercept[IndexOutOfBoundsException] {
      m(-1)
    }
  }

  test("Indexed write") {
    var m = Mat2x4(
      m00, m01, m02, m03,
      m10, m11, m12, m13
    )

    var count = 0
    for (c <- 0 until 2; r <- 0 until 4) {
      count += 1
      m(c, r) = count + 1
      expectResult(count + 1) { m(c, r) }
    }

    intercept[IndexOutOfBoundsException] {
      m(2, 1) = 1
    }
    intercept[IndexOutOfBoundsException] {
      m(-1, 1) = 1
    }

    intercept[IndexOutOfBoundsException] {
      m(1, 4) = 1
    }
    intercept[IndexOutOfBoundsException] {
      m(1, -1) = 1
    }

    m = Mat2x4(0)

    m(0) = Vec4(m00, m01, m02, m03)
    m(1) = Vec4(m10, m11, m12, m13)

    expectResult(Vec4(m00, m01, m02, m03)) { m(0) }
    expectResult(Vec4(m10, m11, m12, m13)) { m(1) }

    m = Mat2x4(0)

    m(0) = Vec3(m00, m01, m02)
    m(1) = Vec3(m10, m11, m12)

    expectResult(Vec4(m00, m01, m02, 0)) { m(0) }
    expectResult(Vec4(m10, m11, m12, 0)) { m(1) }

    m = Mat2x4(0)

    m(0) = Vec2(m00, m01)
    m(1) = Vec2(m10, m11)

    expectResult(Vec4(m00, m01, 0, 0)) { m(0) }
    expectResult(Vec4(m10, m11, 0, 0)) { m(1) }

    intercept[IndexOutOfBoundsException] {
      m(2) = Vec4(1)
      m(2) = Vec3(1)
      m(2) = Vec2(1)
    }
    intercept[IndexOutOfBoundsException] {
      m(-1) = Vec4(1)
      m(-1) = Vec3(1)
      m(-1) = Vec2(1)
    }
  }

  test("Setters") {
    var m = Mat2x4(0)
    val i = ConstMat2x4(
      m00, m01, m02, m03,
      m10, m11, m12, m13
    )

    m = Mat2x4(0)
    m := i
    expectResult((m00, m01, m02, m03)) { (m.m00, m.m01, m.m02, m.m03) }
    expectResult((m10, m11, m12, m13)) { (m.m10, m.m11, m.m12, m.m13) }
  }

  test("Const math") {
    val m = ConstMat2x4(
      m00, m01, m02, m03,
      m10, m11, m12, m13
    )
    assert(+m eq m)

    var t = Mat2x4(
      -m00, -m01, -m02, -m03,
      -m10, -m11, -m12, -m13
    )
    assert(-m == t)

    t = Mat2x4(
      2*m00, 2*m01, 2*m02, 2*m03,
      2*m10, 2*m11, 2*m12, 2*m13
    )
    assert(m*2 == t)

    t = Mat2x4(
      m00/2, m01/2, m02/2, m03/2,
      m10/2, m11/2, m12/2, m13/2
    )
    assert(m/2 == t)

    t = Mat2x4(
      m00+2, m01+2, m02+2, m03+2,
      m10+2, m11+2, m12+2, m13+2
    )
    assert(m + 2 == t)

    t = Mat2x4(
      m00-2, m01-2, m02-2, m03-2,
      m10-2, m11-2, m12-2, m13-2
    )
    assert(m - 2 == t)

    val n: ConstMat2x4 = m*3

    t = Mat2x4(
      4*m00, 4*m01, 4*m02, 4*m03,
      4*m10, 4*m11, 4*m12, 4*m13
    )
    assert(n + m == t)

    t = Mat2x4(
      2*m00, 2*m01, 2*m02, 2*m03,
      2*m10, 2*m11, 2*m12, 2*m13
    )
    assert(n - m == t)

    t = Mat2x4(
      3, 3, 3, 3,
      3, 3, 3, 3
    )
    assert(n / m == t)


    val mul22 = Mat2x4(
      11, 14, 17, 20,
      35, 46, 57, 68
    )
    assert(m*Mat2x2(M) == mul22)

    val mul32 = Mat3x4(
      11, 14, 17, 20,
      35, 46, 57, 68,
      59, 78, 97, 116
    )
    assert(m*Mat3x2(M) == mul32)

    val mul42 = Mat4x4(
      11, 14, 17, 20,
      35, 46, 57, 68,
      59, 78, 97, 116,
      83, 110, 137, 164
    )
    assert(m*Mat4x2(M) == mul42)

    assert(m*Vec2(1, 2) == Vec4(11, 14, 17, 20))
  }

  test("Mutable math") {
    val m = Mat2x4(0)
    val i = ConstMat2x4(
      m00, m01, m02, m03,
      m10, m11, m12, m13
    )

    var t = Mat2x4(
      2*m00, 2*m01, 2*m02, 2*m03,
      2*m10, 2*m11, 2*m12, 2*m13
    )
    m := i; m *= 2; assert(m == t)

    t = Mat2x4(
      m00/2, m01/2, m02/2, m03/2,
      m10/2, m11/2, m12/2, m13/2
    )
    m := i; m /= 2; assert(m == t)

    t = Mat2x4(
      m00+2, m01+2, m02+2, m03+2,
      m10+2, m11+2, m12+2, m13+2
    )
    m := i; m += 2; assert(m == t)

    t = Mat2x4(
      m00-2, m01-2, m02-2, m03-2,
      m10-2, m11-2, m12-2, m13-2
    )
    m := i; m -= 2; assert(m == t)

    val n: ConstMat2x4 = i*3

    t = Mat2x4(
      4*m00, 4*m01, 4*m02, 4*m03,
      4*m10, 4*m11, 4*m12, 4*m13
    )
    m := i; m += n; assert(m == t)

    t = Mat2x4(
      -2*m00, -2*m01, -2*m02, -2*m03,
      -2*m10, -2*m11, -2*m12, -2*m13
    )
    m := i; m -= n; assert(m == t)

    t = Mat2x4(
      11, 14, 17, 20,
      35, 46, 57, 68
    )
    m := i; m *= Mat2(M); assert(m == t)

    t = Mat2x4(
      1, 1, 1, 1,
      1, 1, 1, 1
    )
    m := i; m/= m; assert(m == t)
  }

}
