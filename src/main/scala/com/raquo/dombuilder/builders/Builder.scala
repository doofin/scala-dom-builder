package com.raquo.dombuilder.builders

import com.raquo.dombuilder.domapi.JsDomApi
import com.raquo.dombuilder.nodes.{Comment, Element, Text}

// @TODO[API] These two classes need a better name. DOMBuilder or soemthing?

trait Builder[N] {

  // @TODO[API] Genericize later
  val domapi: JsDomApi.type = JsDomApi
}

// @TODO[API] We don't really need to know about the types Element / Text / Comment here.
// @TODO[API] Really, this trait could have just one type param and one method, node()
// @TODO[API] And then if we need a builder that builds a node somewhere, we just require a Text type param

trait NodeBuilder[+El <: Element[N], +C <: Comment[N], N] {

  def element(tagName: String): El with N

  def commentNode(text: String): C with N
}

trait HasBuilder[N] {
  val builder: Builder[N]
}

trait HasNodeBuilder[+El <: Element[N], +C <: Comment[N], N] {
  val nodeBuilder: NodeBuilder[El, C, N]
}