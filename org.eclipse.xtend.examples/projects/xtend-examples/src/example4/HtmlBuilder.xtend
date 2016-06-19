/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package example4

import java.util.ArrayList
import org.eclipse.xtend.lib.annotations.Data
import org.junit.Test

/**
 * This examples shows 
 *  - the usage and declaration of a builder API.
 *  - usage of @Data annotation
 *  - non-static extension methods
 */
class DomExample {
	
	extension DomBuilder db = new DomBuilder
	extension DomSerializer ds = new DomSerializer
	
	@Test
	def void processDom() {
		val dom = buildDom
		println(dom.toText)
	}
	
	def buildDom() {
		new Html => [
		  head [
		    it.title [$("HTML with Xtend")]
		  ]
		  body [
		    h1 [$("HTML with Xtend")]
		    p [$("this format can be used as an alternative to templates.")]
		
		    // an element with attributes and text content
		    a("http://www.xtend-lang.org") [$("Xtend")]
		
		    // mixed content
		    p [
		      $("This is some ") 
		      b[$("mixed")] 
		      $(" text. For more see the ") 
		      a("http://www.xtend-lang.org")[$("Xtend")] 
		      $(" project")
		    ]
		    p [$("More text.")]
		  ]
		]
	}

}

class DomBuilder {
	
	def $(Node it, CharSequence contents) {
		val text = new Contents(contents)
		it.contents += text
	}
	
	def head(Html it, (Head)=>void init) {
		addAndApply(it, new Head, init)
	}
	def title(Head it, (Title)=>void init) {
		addAndApply(it, new Title, init)
	}
	
	def body(Html it, (Body)=>void init) {
		addAndApply(it, new Body, init)
	}
	
	def b(Node it, (B)=>void init) {
		addAndApply(it, new B, init)
	}
	def p(Node it, (P)=>void init) {
		addAndApply(it, new P, init)
	}
	
	def a(Node it, String href, (A)=>void init) {
		val a = new A(href)
		addAndApply(it, a, init)
	}
	
	def h1(Node it, (H1)=>void init) {
		addAndApply(it, new H1, init)
	}
	
	def h2(Node it, (H2)=>void init) {
		addAndApply(it, new H2, init)
	}
	
	def private <T extends Node> void addAndApply(Node parent, T t, (T)=>void init) {
		parent.contents += t
		init.apply(t)
	}
}

class DomSerializer {
	
	def CharSequence toText(Node n) {
		switch n {
			Contents : 
				n.text
				
			A : 
				'''<a href="«n.href»">«n.applyContents»</a>'''
				
			default : '''
				<«n.tagName»>
					«n.applyContents»
				</«n.tagName»>
			'''
		}
	}
	
	def private applyContents(Node n) {
		n.contents?.map[ toText ]?.join
	}
}

@Data class Node {
	ArrayList<Node> contents = newArrayList
	def String tagName() {
		getClass.simpleName.toLowerCase
	}
}

@Data class Html extends Node {
}
@Data class Head extends Node {}
@Data class Title extends Node {}

@Data class ContentNode extends Node {}
@Data class Body extends ContentNode {}
@Data class P extends ContentNode {}
@Data class B extends ContentNode {}
@Data class H1 extends ContentNode {}
@Data class H2 extends ContentNode {}
@Data class A extends ContentNode {
	String href
}
@Data class Contents extends ContentNode {
	CharSequence text
}