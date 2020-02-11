/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.example.fowlerdsl.ui.tests

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.testing.AbstractHyperlinkingTest
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(StatemachineUiInjectorProvider)
class StatemachineHyperlinkingTest extends AbstractHyperlinkingTest {

	@Test def hyperlink_on_event() {
		'''
			events
				doorClosed D1CL
			end
			
			state idle
				«c»doorClosed«c» => active
			end
			
			state active
			end
		'''.hasHyperlinkTo("doorClosed")
	}

	@Test def hyperlink_on_command() {
		'''
			commands
				unlockDoor D1UL
			end
			
			state idle
				actions {«c»unlockDoor«c»}
			end
		'''.hasHyperlinkTo("unlockDoor")
	}

	@Test def hyperlink_on_state() {
		'''
			events
				doorClosed D1CL
			end
			
			state idle
				doorClosed => «c»active«c»
			end
			
			state active
			end
		'''.hasHyperlinkTo("active")
	}
}