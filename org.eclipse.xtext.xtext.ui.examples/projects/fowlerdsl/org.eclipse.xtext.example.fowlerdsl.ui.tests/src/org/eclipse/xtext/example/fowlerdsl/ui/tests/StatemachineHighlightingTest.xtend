/*******************************************************************************
 * Copyright (c) 2018, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.example.fowlerdsl.ui.tests

import org.eclipse.swt.SWT
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.testing.AbstractHighlightingTest
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(StatemachineUiInjectorProvider)
class StatemachineHighlightingTest extends AbstractHighlightingTest {

	@Test def events_keyword() {
		'''
			events
				doorClosed   D1CL
				drawerOpened D2OP
				lightOn      L1ON
				doorOpened   D1OP
				panelClosed  PNCL
			end
		'''.testHighlighting("events", SWT.BOLD, 127, 0, 85)
	}

	@Test def end_keyword() {
		'''
			events
				doorClosed   D1CL
				drawerOpened D2OP
				lightOn      L1ON
				doorOpened   D1OP
				panelClosed  PNCL
			end
		'''.testHighlighting("end", SWT.BOLD, 127, 0, 85)
	}

	@Test def resetEvents_keyword() {
		'''
			events
				doorClosed   D1CL
				drawerOpened D2OP
				lightOn      L1ON
				doorOpened   D1OP
				panelClosed  PNCL
			end
			
			resetEvents
				doorOpened doorClosed
			end
		'''.testHighlighting("resetEvents", SWT.BOLD, 127, 0, 85)
	}

	@Test def commands_keyword() {
		'''
			commands
				unlockPanel PNUL
				lockPanel   NLK
				lockDoor    D1LK
				unlockDoor  D1UL
			end
		'''.testHighlighting("commands", SWT.BOLD, 127, 0, 85)
	}

	@Test def state_keyword() {
		'''
			events
				doorClosed   D1CL
				drawerOpened D2OP
				lightOn      L1ON
				doorOpened   D1OP
				panelClosed  PNCL
			end
			
			resetEvents
				doorOpened
				doorClosed
			end
			
			commands
				unlockPanel PNUL
				lockPanel   NLK
				lockDoor    D1LK
				unlockDoor  D1UL
			end
			
			state idle
				actions {unlockDoor lockPanel}
				doorClosed => active
			end
			
			state active
				drawerOpened => waitingForLight
				lightOn      => waitingForDrawer
			end
			
			state waitingForLight
				lightOn => unlockedPanel
			end
			
			state waitingForDrawer
				drawerOpened => unlockedPanel
			end
			
			state unlockedPanel
				actions {unlockPanel lockDoor}
				panelClosed => idle
			end
		'''.testHighlighting("state", SWT.BOLD, 127, 0, 85)
	}

	@Test def actions_keyword() {
		'''
			events
				doorClosed   D1CL
				drawerOpened D2OP
				lightOn      L1ON
				doorOpened   D1OP
				panelClosed  PNCL
			end
			
			resetEvents
				doorOpened
				doorClosed
			end
			
			commands
				unlockPanel PNUL
				lockPanel   NLK
				lockDoor    D1LK
				unlockDoor  D1UL
			end
			
			state idle
				actions {unlockDoor lockPanel}
				doorClosed => active
			end
			
			state active
				drawerOpened => waitingForLight
				lightOn      => waitingForDrawer
			end
			
			state waitingForLight
				lightOn => unlockedPanel
			end
			
			state waitingForDrawer
				drawerOpened => unlockedPanel
			end
			
			state unlockedPanel
				actions {unlockPanel lockDoor}
				panelClosed => idle
			end
		'''.testHighlighting("actions", SWT.BOLD, 127, 0, 85)
	}

	@Test def single_line_comment() {
		'''
			// An implementation of Martin Fowler's secret compartment state machine
		'''.testHighlighting("An implementation of Martin Fowler's secret compartment state machine",
				SWT.NORMAL, 63, 127, 95
		)
	}

	@Test def multi_line_comment() {
		'''
			/*
			 * An implementation of Martin Fowler's secret compartment state machine
			 * 
			 * http://martinfowler.com/dslwip/Intro.html
			 */
		'''.testHighlighting('''
			/*
			 * An implementation of Martin Fowler's secret compartment state machine
			 * 
			 * http://martinfowler.com/dslwip/Intro.html
			 */
		''', SWT.NORMAL, 63, 127, 95)
	}

	@Test def fixme_task_in_comment() {
		'''
			// FIXME
		'''.testHighlighting('FIXME', SWT.BOLD, 127, 159, 191)
	}

	@Test def todo_task_in_comment() {
		'''
			// TODO
		'''.testHighlighting('TODO', SWT.BOLD, 127, 159, 191)
	}

	@Test def xxx_task_in_comment() {
		'''
			// XXX
		'''.testHighlighting('XXX', SWT.BOLD, 127, 159, 191)
	}
}
