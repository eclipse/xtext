/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.fowlerdsl.tests

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.formatter.FormatterTestHelper
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(StatemachineInjectorProvider)
class StatemachineFormatterTest {

	@Inject extension FormatterTestHelper

	@Test def events() {
		assertFormatted[
			toBeFormatted = '''
				events doorClosed D1CL drawerOpened D2OP lightOn L1ON doorOpened D1OP panelClosed PNCL end
			'''
			expectation = '''
				events
					doorClosed   D1CL
					drawerOpened D2OP
					lightOn      L1ON
					doorOpened   D1OP
					panelClosed  PNCL
				end
			'''
		]
	}

	@Test def commands() {
		assertFormatted[
			
			toBeFormatted = '''
				commands unlockPanel PNUL lockPanel NLK lockDoor D1LK unlockDoor D1UL end
			'''			
			expectation = '''
				commands
					unlockPanel PNUL
					lockPanel   NLK
					lockDoor    D1LK
					unlockDoor  D1UL
				end
			'''
		]
	}

	@Test def states() {
		assertFormatted[
			toBeFormatted = '''
				state idle end state active end state waitingForLight end
				state waitingForDrawer end state unlockedPanel end
			'''
			expectation = '''
				state idle
				end
				
				state active
				end
				
				state waitingForLight
				end
				
				state waitingForDrawer
				end
				
				state unlockedPanel
				end
			'''
		]
	}

	@Test def resetEvent() {
		assertFormatted[
			toBeFormatted = '''
				events doorClosed D1CL drawerOpened D2OP lightOn L1ON doorOpened D1OP panelClosed PNCL end
				resetEvents doorOpened end
			'''
			expectation = '''
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
			'''
		]
	}

	@Test def resetEvents() {
		assertFormatted[
			toBeFormatted = '''
				events doorClosed D1CL drawerOpened D2OP lightOn L1ON doorOpened D1OP panelClosed PNCL end
				resetEvents doorClosed doorOpened end
			'''
			expectation = '''
				events
					doorClosed   D1CL
					drawerOpened D2OP
					lightOn      L1ON
					doorOpened   D1OP
					panelClosed  PNCL
				end
				
				resetEvents
					doorClosed
					doorOpened
				end
			'''
		]
	}

	@Test def events_commands() {
		assertFormatted[
			toBeFormatted = '''
				events doorClosed D1CL drawerOpened D2OP lightOn L1ON doorOpened D1OP panelClosed PNCL end
				commands unlockPanel PNUL lockPanel NLK lockDoor D1LK unlockDoor D1UL end
			'''
			expectation = '''
				events
					doorClosed   D1CL
					drawerOpened D2OP
					lightOn      L1ON
					doorOpened   D1OP
					panelClosed  PNCL
				end
				
				commands
					unlockPanel PNUL
					lockPanel   NLK
					lockDoor    D1LK
					unlockDoor  D1UL
				end
			'''
		]
	}

	@Test def events_state() {
		assertFormatted[
			toBeFormatted = '''
				events doorClosed D1CL drawerOpened D2OP lightOn L1ON doorOpened D1OP panelClosed PNCL end
				state idle end
			'''
			expectation = '''
				events
					doorClosed   D1CL
					drawerOpened D2OP
					lightOn      L1ON
					doorOpened   D1OP
					panelClosed  PNCL
				end
				
				state idle
				end
			'''
		]
	}

	@Test def events_resetEvents_commands() {
		assertFormatted[
			toBeFormatted = '''
				events doorClosed D1CL drawerOpened D2OP lightOn L1ON doorOpened D1OP panelClosed PNCL end
				resetEvents doorOpened end
				commands unlockPanel PNUL lockPanel NLK lockDoor D1LK unlockDoor D1UL end
			'''
			expectation = '''
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
				
				commands
					unlockPanel PNUL
					lockPanel   NLK
					lockDoor    D1LK
					unlockDoor  D1UL
				end
			'''
		]
	}

	@Test def events_resetEvents_state() {
		assertFormatted[
			toBeFormatted = '''
				events doorClosed D1CL drawerOpened D2OP lightOn L1ON doorOpened D1OP panelClosed PNCL end
				resetEvents doorOpened end state idle doorClosed => active end
			'''
			expectation = '''
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
				
				state idle
					doorClosed => active
				end
			'''
		]
	}

	@Test def events_resetEvents_commands_state() {
		assertFormatted[
			toBeFormatted = '''
				events doorClosed D1CL drawerOpened D2OP lightOn L1ON doorOpened D1OP panelClosed PNCL end
				resetEvents doorOpened end
				commands unlockPanel PNUL lockPanel NLK lockDoor D1LK unlockDoor D1UL end
				state idle actions {unlockDoor lockPanel} doorClosed => active end
			'''
			expectation = '''
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
			'''
		]
	}

	@Test def events_resetEvents_commands_states() {
		assertFormatted[
			toBeFormatted = '''
				events doorClosed D1CL drawerOpened D2OP lightOn L1ON doorOpened D1OP panelClosed PNCL end
				resetEvents doorOpened end
				commands unlockPanel PNUL lockPanel NLK lockDoor D1LK unlockDoor D1UL end
				state idle actions {unlockDoor lockPanel} doorClosed => active end
				state active drawerOpened => waitingForLight lightOn => waitingForDrawer end
				state waitingForLight lightOn => unlockedPanel end
				state waitingForDrawer drawerOpened => unlockedPanel end
				state unlockedPanel actions {unlockPanel lockDoor} panelClosed => idle end
			'''
			expectation = '''
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
			'''
		]
	}
}