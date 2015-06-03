/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.web.test

import org.eclipse.xtext.web.server.contentassist.ContentAssistResult
import org.junit.Test

class ContentAssistTest extends AbstractXbaseWebTest {
	
	protected def assertContentAssistResult(CharSequence resourceContent, CharSequence expectedResult) {
		var contentString = resourceContent.toString
		val cursorOffset = contentString.indexOf('|')
		if (cursorOffset >= 0) {
			contentString = contentString.substring(0, cursorOffset) + contentString.substring(cursorOffset + 1)
			assertContentAssistResult(contentString, cursorOffset, expectedResult)
		} else
			assertContentAssistResult(resourceContent, 0, expectedResult)
	}
	
	protected def assertContentAssistResult(CharSequence resourceContent, int offset, CharSequence expectedResult) {
		val sessionStore = new HashMapSessionStore
		val contentAssist = dispatcher.getService('/content-assist', #{
				'fullText' -> resourceContent.toString,
				'caretOffset' -> offset.toString
			}, sessionStore)
		val result = contentAssist.service.apply() as ContentAssistResult
		assertEquals(expectedResult.toString, result.toString)
	}
	
	@Test def testExtendsType() {
		'entity Foo extends AbstractQu|'.assertContentAssistResult('''
			ContentAssistResult [
			  stateId = "-80000000"
			  entries = ArrayList (
			    Entry [
			      prefix = "AbstractQu"
			      proposal = "AbstractQueue"
			      description = "java.util.AbstractQueue"
			      escapePosition = 0
			      textReplacements = ArrayList (
			        replace region [0 / length: 0] '
			        import java.util.AbstractQueue'
			      )
			      editPositions = ArrayList ()
			    ],
			    Entry [
			      prefix = "AbstractQu"
			      proposal = "AbstractQueuedLongSynchronizer"
			      description = "java.util.concurrent.locks.AbstractQueuedLongSynchronizer"
			      escapePosition = 0
			      textReplacements = ArrayList (
			        replace region [0 / length: 0] '
			        import java.util.concurrent.locks.AbstractQueuedLongSynchronizer'
			      )
			      editPositions = ArrayList ()
			    ],
			    Entry [
			      prefix = "AbstractQu"
			      proposal = "AbstractQueuedSynchronizer"
			      description = "java.util.concurrent.locks.AbstractQueuedSynchronizer"
			      escapePosition = 0
			      textReplacements = ArrayList (
			        replace region [0 / length: 0] '
			        import java.util.concurrent.locks.AbstractQueuedSynchronizer'
			      )
			      editPositions = ArrayList ()
			    ]
			  )
			]''')
	}
	
	@Test def testPropertyType() {
		'entity Foo { bar: AbstractQu| }'.assertContentAssistResult('''
			ContentAssistResult [
			  stateId = "-80000000"
			  entries = ArrayList (
			    Entry [
			      prefix = "AbstractQu"
			      proposal = "AbstractQueue"
			      description = "java.util.AbstractQueue"
			      escapePosition = 0
			      textReplacements = ArrayList (
			        replace region [0 / length: 0] '
			        import java.util.AbstractQueue'
			      )
			      editPositions = ArrayList ()
			    ],
			    Entry [
			      prefix = "AbstractQu"
			      proposal = "AbstractQueuedLongSynchronizer"
			      description = "java.util.concurrent.locks.AbstractQueuedLongSynchronizer"
			      escapePosition = 0
			      textReplacements = ArrayList (
			        replace region [0 / length: 0] '
			        import java.util.concurrent.locks.AbstractQueuedLongSynchronizer'
			      )
			      editPositions = ArrayList ()
			    ],
			    Entry [
			      prefix = "AbstractQu"
			      proposal = "AbstractQueuedSynchronizer"
			      description = "java.util.concurrent.locks.AbstractQueuedSynchronizer"
			      escapePosition = 0
			      textReplacements = ArrayList (
			        replace region [0 / length: 0] '
			        import java.util.concurrent.locks.AbstractQueuedSynchronizer'
			      )
			      editPositions = ArrayList ()
			    ]
			  )
			]''')
	}
	
	@Test def testListMethods() {
		'entity Foo { op bar(): void { #[\'blub\'].add| } }'.assertContentAssistResult('''
			ContentAssistResult [
			  stateId = "-80000000"
			  entries = ArrayList (
			    Entry [
			      prefix = "add"
			      proposal = "add()"
			      name = "add(E arg0) : boolean"
			      description = "List"
			      escapePosition = 45
			      textReplacements = ArrayList ()
			      editPositions = ArrayList (
			        [44:0]
			      )
			    ],
			    Entry [
			      prefix = "add"
			      proposal = "add()"
			      name = "add(int arg0, E arg1) : void"
			      description = "List"
			      escapePosition = 45
			      textReplacements = ArrayList ()
			      editPositions = ArrayList (
			        [44:0]
			      )
			    ],
			    Entry [
			      prefix = "add"
			      proposal = "addAll()"
			      name = "addAll(Collection<? extends E> arg0) : boolean"
			      description = "List"
			      escapePosition = 48
			      textReplacements = ArrayList ()
			      editPositions = ArrayList (
			        [47:0]
			      )
			    ],
			    Entry [
			      prefix = "add"
			      proposal = "addAll()"
			      name = "addAll(Iterable<? extends T> arg1) : boolean"
			      description = "CollectionExtensions"
			      escapePosition = 48
			      textReplacements = ArrayList ()
			      editPositions = ArrayList (
			        [47:0]
			      )
			    ],
			    Entry [
			      prefix = "add"
			      proposal = "addAll()"
			      name = "addAll(T... arg1) : boolean"
			      description = "CollectionExtensions"
			      escapePosition = 48
			      textReplacements = ArrayList ()
			      editPositions = ArrayList (
			        [47:0]
			      )
			    ],
			    Entry [
			      prefix = "add"
			      proposal = "addAll()"
			      name = "addAll(int arg0, Collection<? extends E> arg1) : boolean"
			      description = "List"
			      escapePosition = 48
			      textReplacements = ArrayList ()
			      editPositions = ArrayList (
			        [47:0]
			      )
			    ]
			  )
			]''')
	}
	
	@Test def testMembers() {
		'''
			entity Foo {
				foobar1: String
				op foobar2(): String {}
				op baz(): void {
					println(foob|)
				}
			}
		'''.assertContentAssistResult('''
			ContentAssistResult [
			  stateId = "-80000000"
			  entries = ArrayList (
			    Entry [
			      prefix = "foob"
			      proposal = "foobar1"
			      name = "foobar1 : String"
			      description = "Foo"
			      escapePosition = 90
			      textReplacements = ArrayList ()
			      editPositions = ArrayList ()
			    ],
			    Entry [
			      prefix = "foob"
			      proposal = "foobar1 = value"
			      name = "foobar1 = value : void"
			      description = "Foo.setFoobar1()"
			      escapePosition = 98
			      textReplacements = ArrayList ()
			      editPositions = ArrayList (
			        [93:5]
			      )
			    ],
			    Entry [
			      prefix = "foob"
			      proposal = "foobar2"
			      name = "foobar2 : String"
			      description = "Foo.foobar2()"
			      escapePosition = 90
			      textReplacements = ArrayList ()
			      editPositions = ArrayList ()
			    ]
			  )
			]''')
	}
	
}
