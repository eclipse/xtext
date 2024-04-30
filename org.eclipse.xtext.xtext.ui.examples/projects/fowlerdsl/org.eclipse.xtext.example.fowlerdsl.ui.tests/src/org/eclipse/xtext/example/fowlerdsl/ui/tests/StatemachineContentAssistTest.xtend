/*******************************************************************************
 * Copyright (c) 2018, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.example.fowlerdsl.ui.tests

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.testing.AbstractContentAssistTest
import org.junit.Test
import org.junit.runner.RunWith

import static org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil.waitForBuild

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(StatemachineUiInjectorProvider)
class StatemachineContentAssistTest extends AbstractContentAssistTest {

	@Test def empty() throws Exception {
		'''
			«c»
		'''.assertContentAssistant(#[
			'commands',
			'events',
			'resetEvents',
			'state'
		], 'resetEvents', '''
			resetEvents
		''')
	}

	@Test def statemachine_resetEvents() throws Exception {
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
		'''.assertContentAssistant(#[
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

	@Test def state_actions() throws Exception {
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
		'''.assertContentAssistant(#[
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

	@Test def transition_event() throws Exception {
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
		'''.assertContentAssistant(#[
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

	@Test def transition_state() throws Exception {
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
		'''.assertContentAssistant(#[
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

	@Test def transition_template() throws Exception {
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
		'''.assertContentAssistant(#[
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

	@Test def events_from_another_file() {
		"events".createDslFile('''
			events
				doorClosed   D1CL
				drawerOpened D2OP
				lightOn      L1ON
				doorOpened   D1OP
				panelClosed  PNCL
			end
		''')

		waitForBuild

		'''
			resetEvents
				«c»
			end
		'''.assertContentAssistant('''
			doorClosed
			drawerOpened
			lightOn
			doorOpened
			panelClosed
		''', 'doorOpened', '''
			resetEvents
				doorOpened
			end
		''')
	}
}
