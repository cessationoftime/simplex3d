package simplex3d.example.script

import simplex3d.math._
import simplex3d.math.precisiondouble._
import simplex3d.math.precisiondouble.functions._
import simplex3d.data._
import simplex3d.data.precisiondouble._
import simplex3d.script.ImageUtils._


/**
 * @author Aleksey Nikiforov (lex)
 */
object DrawFunction extends App {

  drawFunction { (dims, p) =>
    Vec3(p/dims, 1)
  }

}
