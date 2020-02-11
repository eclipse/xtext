/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.example.fowlerdsl.ui.tests

import java.util.List
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.testing.AbstractContentAssistTest
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(StatemachineUiInjectorProvider)
class StatemachineContentAssistTest extends AbstractContentAssistTest {

	// cursor position marker
	val c = '''<|>'''

	@Test def empty() {
		'''
			«c»
		'''.testContentAssistant(#[
			'commands',
			'events',
			'resetEvents',
			'state'
		], 'resetEvents', '''
			resetEvents
		''')
	}

	@Test def statemachine_resetEvents() {
		'''
			events
				doorClosed   D1CL
				drawerOpened D2OP
				lightOn      L1ON
				doorOpened   D1OP
				panelClosed  PNCL
			end
			
			resetEvents
				«c»
			end
		'''.testContentAssistant(#[
			'doorClosed',
			'drawerOpened',
			'lightOn',
			'doorOpened',
			'panelClosed'
		], 'doorOpened', '''
			events
				doorClosed   D1CL
				drawerOpened D2OP
				lightOn      L1ON
				doorOpened   D1OP
				panelClosed  PNCL
			end
			
			resetEvents
				doorOpened
			end
		''')
	}

	@Test def state_actions() {
		'''
			commands
				unlockPanel PNUL
				lockPanel   NLK
				lockDoor    D1LK
				unlockDoor  D1UL
			end
			
			state idle
				actions {«c»}
			end
		'''.testContentAssistant(#[
			'unlockPanel',
			'lockPanel',
			'lockDoor',
			'unlockDoor',
			'{'
		], 'unlockDoor', '''
			commands
				unlockPanel PNUL
				lockPanel   NLK
				lockDoor    D1LK
				unlockDoor  D1UL
			end
			
			state idle
				actions {unlockDoor}
			end
		''')
	}

	@Test def transition_event() {
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
			
			commands
				unlockPanel PNUL
				lockPanel   NLK
				lockDoor    D1LK
				unlockDoor  D1UL
			end
			
			state idle
				actions {unlockDoor lockPanel}
				«c»
			end
		'''.testContentAssistant(#[
			'Transition - Template for a Transition',
			'doorClosed',
			'drawerOpened',
			'lightOn',
			'doorOpened',
			'panelClosed',
			'end'
		], 'doorClosed', '''
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
			
			commands
				unlockPanel PNUL
				lockPanel   NLK
				lockDoor    D1LK
				unlockDoor  D1UL
			end
			
			state idle
				actions {unlockDoor lockPanel}
				doorClosed
			end
		''')
	}

	@Test def transition_state() {
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
				panelClosed => «c»
			end
		'''.testContentAssistant(#[
			'idle',
			'active',
			'waitingForLight',
			'waitingForDrawer',
			'unlockedPanel'
		], 'idle', '''
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
		''')
	}

	@Test def transition_template() {
		'''
			events
				doorClosed   D1CL
				drawerOpened D2OP
				lightOn      L1ON
				doorOpened   D1OP
				panelClosed  PNCL
			end
			
			state idle
				«c»
			end
			
			state active
			end
		'''.testContentAssistant(#[
			'doorClosed',
			'drawerOpened',
			'lightOn',
			'doorOpened',
			'panelClosed',
			'actions',
			'end',
			'Transition - Template for a Transition'
		], 'Transition - Template for a Transition', '''
			events
				doorClosed   D1CL
				drawerOpened D2OP
				lightOn      L1ON
				doorOpened   D1OP
				panelClosed  PNCL
			end
			
			state idle
				doorClosed => idle
			end
			
			state active
			end
		''')
	}

	private def void testContentAssistant(CharSequence text, List<String> expectedProposals,
		String proposalToApply, String expectedContent) {
		
		val cursorPosition = text.toString.indexOf(c)
		val content = text.toString.replace(c, "")
		
		newBuilder.append(content).
		assertTextAtCursorPosition(cursorPosition, expectedProposals).
		applyProposal(cursorPosition, proposalToApply).
		expectContent(expectedContent)
	}
}
