package com.raquo.dombuilder

import com.raquo.dombuilder.jsdom.simple.implicits._
import com.raquo.dombuilder.jsdom.simple.tags.div

class RefSpec extends UnitSpec {

  it("creates ref right away") {
    val node = div()
    node.ref shouldNot be(null) // @TODO Scala.js bug  prevents us from checking type with an[dom.Element], check again with 0.6.18
    node.ref.parentNode shouldBe null

    mount(node)
    node.ref.parentNode shouldBe containerNode

    unmount()
    node.ref.parentNode shouldBe null
  }
}
