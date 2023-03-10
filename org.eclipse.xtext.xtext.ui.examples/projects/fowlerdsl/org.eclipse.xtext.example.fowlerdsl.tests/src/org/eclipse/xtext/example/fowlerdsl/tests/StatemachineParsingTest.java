/**
 * Copyright (c) 2018, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.fowlerdsl.tests;

import org.eclipse.xtext.example.fowlerdsl.statemachine.Statemachine;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(StatemachineInjectorProvider.class)
public class StatemachineParsingTest {
	@Inject
	private ParseHelper<Statemachine> parseHelper;

	@Inject
	private ValidationTestHelper validationTestHelper;

	@Test
	public void loadModel() throws Exception {
		String model =
				"events\n" +
				"	doorClosed		D1CL\n" +
				"	drawerOpened	D2OP\n" +
				"	lightOn			L1ON\n" +
				"	doorOpened		D1OP\n" +
				"	panelClosed		PNCL\n" +
				"end\n" +
				"\n" +
				"resetEvents\n" +
				"	doorOpened\n" +
				"end\n" +
				"\n" +
				"commands\n" +
				"	unlockPanel PNUL\n" +
				"	lockPanel	NLK\n" +
				"	lockDoor	D1LK\n" +
				"	unlockDoor	D1UL\n" +
				"end\n" +
				"\n" +
				"state idle\n" +
				"	actions {unlockDoor lockPanel}\n" +
				"	doorClosed => active\n" +
				"end\n" +
				"\n" +
				"state active\n" +
				"	drawerOpened => waitingForLight\n" +
				"	lightOn		 => waitingForDrawer\n" +
				"end\n" +
				"\n" +
				"state waitingForLight\n" +
				"	lightOn => unlockedPanel\n" +
				"end\n" +
				"\n" +
				"state waitingForDrawer\n" +
				"	drawerOpened => unlockedPanel\n" +
				"end\n" +
				"\n" +
				"state unlockedPanel\n" +
				"	actions {unlockPanel lockDoor}\n" +
				"	panelClosed => idle\n" +
				"end\n";
		validationTestHelper.assertNoErrors(parseHelper.parse(model));
	}
}
