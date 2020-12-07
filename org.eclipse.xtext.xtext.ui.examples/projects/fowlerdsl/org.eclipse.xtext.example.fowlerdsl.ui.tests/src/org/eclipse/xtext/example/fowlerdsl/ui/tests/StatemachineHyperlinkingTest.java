/**
 * Copyright (c) 2019, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.fowlerdsl.ui.tests;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.AbstractHyperlinkingTest;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(StatemachineUiInjectorProvider.class)
public class StatemachineHyperlinkingTest extends AbstractHyperlinkingTest {
	@Test
	public void hyperlink_on_event() {
		String model =
				"events\n" +
				"	doorClosed D1CL\n" +
				"end\n" +
				"\n" +
				"state idle\n" +
				"	<|>doorClosed<|> => active\n" +
				"end\n" +
				"\n" +
				"state active\n" +
				"end\n";
		hasHyperlinkTo(model, "doorClosed");
	}

	@Test
	public void hyperlink_on_command() {
		String model =
				"commands\n" +
				"	unlockDoor D1UL\n" +
				"end\n" +
				"\n" +
				"state idle\n" +
				"	actions {<|>unlockDoor<|>}\n" +
				"end\n";
		hasHyperlinkTo(model, "unlockDoor");
	}

	@Test
	public void hyperlink_on_state() {
		String model =
				"events\n" +
				"	doorClosed D1CL\n" +
				"end\n" +
				"\n" +
				"state idle\n" +
				"	doorClosed => <|>active<|>\n" +
				"end\n" +
				"\n" +
				"state active\n" +
				"end\n";
		hasHyperlinkTo(model, "active");
	}
}
