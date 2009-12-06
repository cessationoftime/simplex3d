/*
 * Simplex3D, Math tests
 * Copyright (C) 2009 Simplex3D team
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

package test.math

import org.scalatest._

import simplex3d.math.intm._
import simplex3d.math.floatm.renamed._
import simplex3d.math.floatm.FloatMath._


/**
 * @author Aleksey Nikiforov (lex)
 */
class Vec4fTest extends FunSuite {

    test("Mutable factories") {
        var u = Vec4(5)
        expect(classOf[Vec4]) { u.getClass }
        expect(5) { u.x }
        expect(5) { u.y }
        expect(5) { u.z }
        expect(5) { u.w }

        u = Vec4(2, 3, 4, 5)
        expect(classOf[Vec4]) { u.getClass }
        expect(2) { u.x }
        expect(3) { u.y }
        expect(4) { u.z }
        expect(5) { u.w }

        u = Vec4(6, 7, Vec2(8, 9))
        expect(classOf[Vec4]) { u.getClass }
        expect(6) { u.x }
        expect(7) { u.y }
        expect(8) { u.z }
        expect(9) { u.w }

        u = Vec4(6, Vec2(7, 8), 9)
        expect(classOf[Vec4]) { u.getClass }
        expect(6) { u.x }
        expect(7) { u.y }
        expect(8) { u.z }
        expect(9) { u.w }

        u = Vec4(Vec2(6, 7), 8, 9)
        expect(classOf[Vec4]) { u.getClass }
        expect(6) { u.x }
        expect(7) { u.y }
        expect(8) { u.z }
        expect(9) { u.w }

        u = Vec4(6, Vec3(7, 8, 9))
        expect(classOf[Vec4]) { u.getClass }
        expect(6) { u.x }
        expect(7) { u.y }
        expect(8) { u.z }
        expect(9) { u.w }

        u = Vec4(Vec3(6, 7, 8), 9)
        expect(classOf[Vec4]) { u.getClass }
        expect(6) { u.x }
        expect(7) { u.y }
        expect(8) { u.z }
        expect(9) { u.w }

        u = Vec4(Vec4(4, 5, 6, 7))
        expect(classOf[Vec4]) { u.getClass }
        expect(4) { u.x }
        expect(5) { u.y }
        expect(6) { u.z }
        expect(7) { u.w }

        u = Vec4(6, 7, Vec2i(8, 9))
        expect(classOf[Vec4]) { u.getClass }
        expect(6) { u.x }
        expect(7) { u.y }
        expect(8) { u.z }
        expect(9) { u.w }

        u = Vec4(6, Vec2i(7, 8), 9)
        expect(classOf[Vec4]) { u.getClass }
        expect(6) { u.x }
        expect(7) { u.y }
        expect(8) { u.z }
        expect(9) { u.w }

        u = Vec4(Vec2i(6, 7), 8, 9)
        expect(classOf[Vec4]) { u.getClass }
        expect(6) { u.x }
        expect(7) { u.y }
        expect(8) { u.z }
        expect(9) { u.w }

        u = Vec4(6, Vec3i(7, 8, 9))
        expect(classOf[Vec4]) { u.getClass }
        expect(6) { u.x }
        expect(7) { u.y }
        expect(8) { u.z }
        expect(9) { u.w }

        u = Vec4(Vec3i(6, 7, 8), 9)
        expect(classOf[Vec4]) { u.getClass }
        expect(6) { u.x }
        expect(7) { u.y }
        expect(8) { u.z }
        expect(9) { u.w }

        u = Vec4(Vec4i(4, 5, 6, 7))
        expect(classOf[Vec4]) { u.getClass }
        expect(4) { u.x }
        expect(5) { u.y }
        expect(6) { u.z }
        expect(7) { u.w }
    }

    test("Const conversions") {
        var c = const(Vec4(5)); var v = Vec4(3)
        v = c; assert(Vec4(5) == v)

        c = const(Vec4(5)); v = Vec4(3)
        c = v; assert(Vec4(3) == c)

        val t: ConstVec4 = Vec4(9)
        assert(Vec4(9) == t)
    }

    test("Equality methods") {
        assert(Vec4(4, 7, 9, 1) == const(Vec4(4, 7, 9, 1)))
        assert(const(Vec4(4, 7, 9, 1)) == Vec4(4, 7, 9, 1))

        assert(Vec4(1, 2, 3, 4) != Vec4(9, 2, 3, 4))
        assert(Vec4(1, 2, 3, 4) != Vec4(1, 9, 3, 4))
        assert(Vec4(1, 2, 3, 4) != Vec4(1, 2, 9, 4))
        assert(Vec4(1, 2, 3, 4) != Vec4(1, 2, 3, 9))
    }

    test("Indexed read") {
        val u = const(Vec4(3, 4, 5, 6))

        expect(3) { u(0) }
        expect(4) { u(1) }
        expect(5) { u(2) }
        expect(6) { u(3) }

        intercept[IndexOutOfBoundsException] {
            u(4)
        }
        intercept[IndexOutOfBoundsException] {
            u(-1)
        }
    }

    test("Indexed write") {
        val u = Vec4(3, 4, 5, 6)

        u(0) = 5
        assert(Vec4(5, 4, 5, 6) == u)

        u(1) = 6
        assert(Vec4(5, 6, 5, 6) == u)

        u(2) = 7
        assert(Vec4(5, 6, 7, 6) == u)

        u(3) = 8
        assert(Vec4(5, 6, 7, 8) == u)

        intercept[IndexOutOfBoundsException] {
            u(4) = 1
        }
        intercept[IndexOutOfBoundsException] {
            u(-1) = 1
        }
    }

    test("Const math") {
        val u = const(Vec4(6, 7, 8, 9))

        assert(Vec4(-6, -7, -8, -9) == -u)

        assert(Vec4(12, 14, 16, 18) == u*2)
        assert(Vec4(12, 14, 16, 18) == 2*u)
        assert(Vec4(3, 3.5f, 4, 4.5f) == u/2)
        assert(Vec4(7/6f, 1, 7/8f, 7/9f) == 7/u)

        val v = const(Vec4(2, 3, 4, 5))

        assert(Vec4(8, 10, 12, 14) == u + v)
        assert(Vec4(4) == u - v)
        assert(Vec4(12, 21, 32, 45) == u*v)
        assert(Vec4(3, 7/3f, 2, 9/5f) == u/v)

        val m4x2 = const(Mat4x2(
            2, 5, 4, 6,
            3, 4, 8, 2
        ))
        assert(Vec2(65, 60) == v*m4x2)

        val m4x3 = const(Mat4x3(
            2, 5, 4, 6,
            3, 4, 8, 2,
            7, 4, 2, 5
        ))
        assert(Vec3(65, 60, 59) == v*m4x3)

        val m4 = const(Mat4(
            2, 5, 4, 6,
            3, 4, 8, 2,
            7, 4, 2, 5,
            5, 9, 2, 3
        ))
        assert(Vec4(65, 60, 59, 60) == v*m4)
    }

    test("Mutable math") {
        var u = Vec4(2, 3, 4, 5)

        u = Vec4(2, 3, 4, 5); u *= 2; assert(Vec4(4, 6, 8, 10) == u)
        u = Vec4(2, 3, 4, 5); u /= 2; assert(Vec4(1, 1.5f, 2, 2.5f) == u)

        u = Vec4(2, 3, 4, 5); u += Vec4(3, 4, 5, 6); assert(Vec4(5, 7, 9, 11) == u)
        u = Vec4(2, 3, 4, 5); u += u; assert(Vec4(4, 6, 8, 10) == u)
        u = Vec4(2, 3, 4, 5); u -= Vec4(2, 3, 4, 5); assert(Vec4(0) == u)
        u = Vec4(2, 3, 4, 5); u -= u; assert(Vec4(0) == u)

        u = Vec4(2, 3, 4, 5); u *= Vec4(5, 10, 15, 2); assert(Vec4(10, 30, 60, 10) == u)
        u = Vec4(2, 3, 4, 5); u *= u; assert(Vec4(4, 9, 16, 25) == u)
        u = Vec4(2, 3, 4, 5); u /= Vec4(2, 6, 2, 2); assert(Vec4(1, 0.5f, 2, 2.5f) == u)
        u = Vec4(2, 3, 4, 5); u /= u; assert(Vec4(1) == u)

        u = Vec4(2, 3, 4, 5); u := Vec4(11, 12, 13, 14); assert(Vec4(11, 12, 13, 14) == u)
        u = Vec4(2, 3, 4, 5); u.set(22, 33, 44, 55); assert(Vec4(22, 33, 44, 55) == u)

        u = Vec4(2, 3, 4, 5)
        val m4 = const(Mat4(
            2, 5, 4, 6,
            3, 4, 8, 2,
            7, 4, 2, 5,
            5, 9, 2, 3
        ))
        u *= m4
        assert(Vec4(65, 60, 59, 60) == u)
    }
}
