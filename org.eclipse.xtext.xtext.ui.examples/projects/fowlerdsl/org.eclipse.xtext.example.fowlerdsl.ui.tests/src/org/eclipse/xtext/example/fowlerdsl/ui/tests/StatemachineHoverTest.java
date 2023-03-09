/**
 * Copyright (c) 2018, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.fowlerdsl.ui.tests;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.AbstractHoverTest;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(StatemachineUiInjectorProvider.class)
public class StatemachineHoverTest extends AbstractHoverTest {
	@Test
	public void hover_over_event() {
		String model =
				"events\n" +
				"	doorClosed   D1CL\n" +
				"	drawerOpened D2OP\n" +
				"	lightOn      L1ON\n" +
				"	doorOpened   D1OP\n" +
				"	panelClosed  PNCL\n" +
				"end\n";
		hasHoverOver(model, "doorClosed", "Event <b>doorClosed</b>");
	}

	@Test
	public void hover_over_command() {
		String model =
				"commands\n" +
				"	unlockPanel PNUL\n" +
				"	lockPanel   NLK\n" +
				"	lockDoor    D1LK\n" +
				"	unlockDoor  D1UL\n" +
				"end\n";
		hasHoverOver(model, "unlockPanel", "Command <b>unlockPanel</b>");
	}

	@Test
	public void hover_over_state() {
		String model = "state idle {}\n";
		hasHoverOver(model, "idle", "State <b>state idle</b>");
	}
}
