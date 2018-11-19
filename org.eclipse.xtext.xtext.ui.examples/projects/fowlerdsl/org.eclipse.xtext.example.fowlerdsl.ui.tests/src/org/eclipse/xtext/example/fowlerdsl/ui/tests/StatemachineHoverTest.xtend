/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.fowlerdsl.ui.tests

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.testing.AbstractHoverTest
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(StatemachineUiInjectorProvider)
class StatemachineHoverTest extends AbstractHoverTest {

	@Test def hover_over_event() {
		'''
			events
				doorClosed   D1CL
				drawerOpened D2OP
				lightOn      L1ON
				doorOpened   D1OP
				panelClosed  PNCL
			end
		'''.hasHoverOver("doorClosed", '''Event <b>doorClosed</b>''')
	}

	@Test def hover_over_command() {
		'''
			commands
				unlockPanel PNUL
				lockPanel   NLK
				lockDoor    D1LK
				unlockDoor  D1UL
			end
		'''.hasHoverOver("unlockPanel", '''Command <b>unlockPanel</b>''')
	}

	@Test def hover_over_state() {
		'''
			state idle {}
		'''.hasHoverOver("idle", '''State <b>state idle</b>''')
	}
}