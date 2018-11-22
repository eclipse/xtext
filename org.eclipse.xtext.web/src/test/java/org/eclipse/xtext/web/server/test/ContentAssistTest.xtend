/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.test

import org.eclipse.xtext.web.example.statemachine.ide.StatemachineIdeModule
import org.eclipse.xtext.web.example.statemachine.ide.StatemachineTemplateProposalProvider
import org.eclipse.xtext.web.server.ServiceConflictResult
import org.eclipse.xtext.web.server.contentassist.ContentAssistResult
import org.junit.Test

import static org.hamcrest.core.IsInstanceOf.*
import static org.junit.Assert.*

class ContentAssistTest extends AbstractWebServerTest {
	
	override protected getIdeModule() {
		new StatemachineIdeModule() {
				def Class<? extends StatemachineTemplateProposalProvider> bindStatemachineTemplateProposalProvider() {
				StatemachineTemplateProposalProvider2
			}

		}
	}
	
	static class StatemachineTemplateProposalProvider2 extends StatemachineTemplateProposalProvider {
		
		override protected getLineDelimiter() {
			"\n"
		}
		
	}
	
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
		val contentAssist = getService(#{
				'serviceType' -> 'assist',
				'fullText' -> resourceContent.toString,
				'caretOffset' -> offset.toString
			})
		assertFalse(contentAssist.hasSideEffects)
		val result = contentAssist.service.apply() as ContentAssistResult
		assertEquals(expectedResult.toString, result.toString)
	}
	
	@Test def testKeywords() {
		'state foo | end'.assertContentAssistResult('''
			ContentAssistResult [
			  stateId = "-80000000"
			  entries = ArrayList (
			    ContentAssistEntry [
			      prefix = ""
			      proposal = "state name\n	\nend\n"
			      label = "state"
			      description = "Create a new state"
			      escapePosition = 22
			      textReplacements = ArrayList ()
			      editPositions = ArrayList (
			        [16:4]
			      )
			      kind = "UNKNOWN"
			    ],
			    ContentAssistEntry [
			      prefix = ""
			      proposal = "end"
			      textReplacements = ArrayList ()
			      editPositions = ArrayList ()
			      kind = "KEYWORD"
			    ],
			    ContentAssistEntry [
			      prefix = ""
			      proposal = "if"
			      textReplacements = ArrayList ()
			      editPositions = ArrayList ()
			      kind = "KEYWORD"
			    ],
			    ContentAssistEntry [
			      prefix = ""
			      proposal = "set"
			      textReplacements = ArrayList ()
			      editPositions = ArrayList ()
			      kind = "KEYWORD"
			    ]
			  )
			]''')
	}
	
	@Test def testKeywordWithPrefix() {
		'inp|'.assertContentAssistResult('''
			ContentAssistResult [
			  stateId = "-80000000"
			  entries = ArrayList (
			    ContentAssistEntry [
			      prefix = "inp"
			      proposal = "input"
			      textReplacements = ArrayList ()
			      editPositions = ArrayList ()
			      kind = "KEYWORD"
			    ]
			  )
			]''')
	}
	
	@Test def testTemplate() {
		'state foo end |'.assertContentAssistResult('''
			ContentAssistResult [
			  stateId = "-80000000"
			  entries = ArrayList (
			    ContentAssistEntry [
			      prefix = ""
			      proposal = "state name\n	\nend\n"
			      label = "state"
			      description = "Create a new state"
			      escapePosition = 26
			      textReplacements = ArrayList ()
			      editPositions = ArrayList (
			        [20:4]
			      )
			      kind = "UNKNOWN"
			    ]
			  )
			]''')
	}
	
	@Test def testIndentedTemplate() {
		'''
			state foo end
				|
		'''.toString.normalizeLineSeparator.assertContentAssistResult('''
			ContentAssistResult [
			  stateId = "-80000000"
			  entries = ArrayList (
			    ContentAssistEntry [
			      prefix = ""
			      proposal = "state name\n		\n	end\n"
			      label = "state"
			      description = "Create a new state"
			      escapePosition = 28
			      textReplacements = ArrayList ()
			      editPositions = ArrayList (
			        [21:4]
			      )
			      kind = "UNKNOWN"
			    ]
			  )
			]''')
	}
	
	@Test def testTerminal() {
		'state | end'.assertContentAssistResult('''
			ContentAssistResult [
			  stateId = "-80000000"
			  entries = ArrayList (
			    ContentAssistEntry [
			      prefix = ""
			      proposal = "name"
			      description = "ID"
			      textReplacements = ArrayList ()
			      editPositions = ArrayList (
			        [6:4]
			      )
			      kind = "VALUE"
			    ]
			  )
			]''')
	}
	
	@Test def testCrossref() {
		'''
			input signal x
			state foo
			end
			state bar
				if x == true goto |
			end
		'''.assertContentAssistResult('''
			ContentAssistResult [
			  stateId = "-80000000"
			  entries = ArrayList (
			    ContentAssistEntry [
			      prefix = ""
			      proposal = "bar"
			      description = "State"
			      textReplacements = ArrayList ()
			      editPositions = ArrayList ()
			      kind = "REFERENCE"
			    ],
			    ContentAssistEntry [
			      prefix = ""
			      proposal = "foo"
			      description = "State"
			      textReplacements = ArrayList ()
			      editPositions = ArrayList ()
			      kind = "REFERENCE"
			    ]
			  )
			]''')
	}
	
	@Test def testFqnCrossref() {
		'''
			input signal x
			state foo
				state inner1 end
				state inner2 end
			end
			state bar
				if x == true goto |
			end
		'''.assertContentAssistResult('''
			ContentAssistResult [
			  stateId = "-80000000"
			  entries = ArrayList (
			    ContentAssistEntry [
			      prefix = ""
			      proposal = "bar"
			      description = "State"
			      textReplacements = ArrayList ()
			      editPositions = ArrayList ()
			      kind = "REFERENCE"
			    ],
			    ContentAssistEntry [
			      prefix = ""
			      proposal = "foo"
			      description = "State"
			      textReplacements = ArrayList ()
			      editPositions = ArrayList ()
			      kind = "REFERENCE"
			    ],
			    ContentAssistEntry [
			      prefix = ""
			      proposal = "foo.inner1"
			      description = "State"
			      textReplacements = ArrayList ()
			      editPositions = ArrayList ()
			      kind = "REFERENCE"
			    ],
			    ContentAssistEntry [
			      prefix = ""
			      proposal = "foo.inner2"
			      description = "State"
			      textReplacements = ArrayList ()
			      editPositions = ArrayList ()
			      kind = "REFERENCE"
			    ]
			  )
			]''')
	}
	
	@Test def testCustomTerminal() {
		'''
			output signal x
			state foo
				set x = |
			end
		'''.assertContentAssistResult('''
			ContentAssistResult [
			  stateId = "-80000000"
			  entries = ArrayList (
			    ContentAssistEntry [
			      prefix = ""
			      proposal = "false"
			      textReplacements = ArrayList ()
			      editPositions = ArrayList ()
			      kind = "UNKNOWN"
			    ],
			    ContentAssistEntry [
			      prefix = ""
			      proposal = "true"
			      textReplacements = ArrayList ()
			      editPositions = ArrayList ()
			      kind = "UNKNOWN"
			    ]
			  )
			]''')
	}
	
	@Test def testCustomCrossref() {
		'''
			input signal x
			output signal z
			state foo
				if | == true goto foo
			end
		'''.assertContentAssistResult('''
			ContentAssistResult [
			  stateId = "-80000000"
			  entries = ArrayList (
			    ContentAssistEntry [
			      prefix = ""
			      proposal = "x"
			      description = "input signal"
			      textReplacements = ArrayList ()
			      editPositions = ArrayList ()
			      kind = "UNKNOWN"
			    ]
			  )
			]''')
	}
	
	@Test def testCrossrefWithPrefix1() {
		'''
			input signal x
			state foo
				if x == true goto fo|
			end
			state bar
			end
		'''.assertContentAssistResult('''
			ContentAssistResult [
			  stateId = "-80000000"
			  entries = ArrayList (
			    ContentAssistEntry [
			      prefix = "fo"
			      proposal = "foo"
			      description = "State"
			      textReplacements = ArrayList ()
			      editPositions = ArrayList ()
			      kind = "REFERENCE"
			    ]
			  )
			]''')
	}
	
	@Test def testCrossrefWithPrefix2() {
		'''
			input signal x
			state Foooo
				if x == true goto fOoO|
			end
			state Baaar
			end
		'''.assertContentAssistResult('''
			ContentAssistResult [
			  stateId = "-80000000"
			  entries = ArrayList (
			    ContentAssistEntry [
			      prefix = "fOoO"
			      proposal = "Foooo"
			      description = "State"
			      textReplacements = ArrayList ()
			      editPositions = ArrayList ()
			      kind = "REFERENCE"
			    ]
			  )
			]''')
	}
	
	@Test def testFqnCrossrefWithPrefix1() {
		'''
			input signal x
			state foo
				state inner1 end
				state inner2 end
			end
			state bar
				if x == true goto foo.|
			end
		'''.assertContentAssistResult('''
			ContentAssistResult [
			  stateId = "-80000000"
			  entries = ArrayList (
			    ContentAssistEntry [
			      prefix = "foo."
			      proposal = "foo.inner1"
			      description = "State"
			      textReplacements = ArrayList ()
			      editPositions = ArrayList ()
			      kind = "REFERENCE"
			    ],
			    ContentAssistEntry [
			      prefix = "foo."
			      proposal = "foo.inner2"
			      description = "State"
			      textReplacements = ArrayList ()
			      editPositions = ArrayList ()
			      kind = "REFERENCE"
			    ]
			  )
			]''')
	}
	
	@Test def testFqnCrossrefWithPrefix2() {
		'''
			input signal x
			state foo
				state inner1 end
				state inner2 end
			end
			state bar
				if x == true goto inner|
			end
		'''.assertContentAssistResult('''
			ContentAssistResult [
			  stateId = "-80000000"
			  entries = ArrayList (
			    ContentAssistEntry [
			      prefix = "inner"
			      proposal = "foo.inner1"
			      description = "State"
			      textReplacements = ArrayList ()
			      editPositions = ArrayList ()
			      kind = "REFERENCE"
			    ],
			    ContentAssistEntry [
			      prefix = "inner"
			      proposal = "foo.inner2"
			      description = "State"
			      textReplacements = ArrayList ()
			      editPositions = ArrayList ()
			      kind = "REFERENCE"
			    ]
			  )
			]''')
	}
	
	@Test def testFqnCrossrefWithPrefix3() {
		'''
			input signal x
			state foo
				state inner1
					state inner2 end
					state inner3 end
				end
			end
			state bar
				if x == true goto f.i.i|
			end
		'''.assertContentAssistResult('''
			ContentAssistResult [
			  stateId = "-80000000"
			  entries = ArrayList (
			    ContentAssistEntry [
			      prefix = "f.i.i"
			      proposal = "foo.inner1.inner2"
			      description = "State"
			      textReplacements = ArrayList ()
			      editPositions = ArrayList ()
			      kind = "REFERENCE"
			    ],
			    ContentAssistEntry [
			      prefix = "f.i.i"
			      proposal = "foo.inner1.inner3"
			      description = "State"
			      textReplacements = ArrayList ()
			      editPositions = ArrayList ()
			      kind = "REFERENCE"
			    ]
			  )
			]''')
	}
	
	@Test def testTerminalWithPrefix() {
		'''
			state foo|
		'''.assertContentAssistResult('''
			ContentAssistResult [
			  stateId = "-80000000"
			  entries = ArrayList ()
			]''')
	}
	
	@Test def testCustomTerminalWithPrefix() {
		'''
			output signal x
			state foo
				set x = f|
			end
		'''.assertContentAssistResult('''
			ContentAssistResult [
			  stateId = "-80000000"
			  entries = ArrayList (
			    ContentAssistEntry [
			      prefix = "f"
			      proposal = "false"
			      textReplacements = ArrayList ()
			      editPositions = ArrayList ()
			      kind = "UNKNOWN"
			    ]
			  )
			]''')
	}
	
	@Test def testIncorrectStateId() {
		val file = createFile('state foo end')
		val contentAssist = getService(#{
				'serviceType' -> 'assist',
				'resource' -> file.name,
				'caretOffset' -> '3',
				'requiredStateId' -> 'totalerquatsch'
			})
		assertTrue(contentAssist.hasConflict)
		val result = contentAssist.service.apply()
		assertThat(result, instanceOf(ServiceConflictResult))
		assertEquals((result as ServiceConflictResult).conflict, 'invalidStateId')
	}
	
}
