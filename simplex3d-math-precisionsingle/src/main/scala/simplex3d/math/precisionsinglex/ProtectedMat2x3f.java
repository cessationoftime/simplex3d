/*
 * Simplex3dMath - Float Module
 * Copyright (C) 2009-2011, Aleksey Nikiforov
 *
 * This file is part of Simplex3dMath.
 *
 * Simplex3dMath is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Simplex3dMath is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package simplex3d.math.precisionsinglex;

import java.io.Serializable;
import simplex3d.math.types.*;


/**
 * @author Aleksey Nikiforov (lex)
 */
abstract class ProtectedMat2x3f<P> extends AnyMat2x3<P> implements Serializable {
    public static final long serialVersionUID = 8104346712419693669L;
    float p00; float p01; float p02;
    float p10; float p11; float p12;
}
