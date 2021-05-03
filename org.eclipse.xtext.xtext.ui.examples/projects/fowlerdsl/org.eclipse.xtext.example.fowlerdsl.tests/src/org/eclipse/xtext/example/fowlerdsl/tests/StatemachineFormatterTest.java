/**
 * Copyright (c) 2019, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.fowlerdsl.tests;

import org.eclipse.xtext.formatting2.FormatterPreferenceKeys;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.formatter.FormatterTestHelper;
import org.eclipse.xtext.testing.formatter.FormatterTestRequest;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(StatemachineInjectorProvider.class)
public class StatemachineFormatterTest {
	@Inject
	private FormatterTestHelper formatterTestHelper;
	
	public void assertFormatted(Procedure1<FormatterTestRequest> init) {
		formatterTestHelper.assertFormatted(new Procedure1<FormatterTestRequest>() {
			@Override
			public void apply(FormatterTestRequest p) {
				p.preferences(m -> m.put(FormatterPreferenceKeys.lineSeparator, "\n"));
				init.apply(p);
			}
		});
	}

	@Test
	public void events() {
		assertFormatted((FormatterTestRequest it) -> {
			it.setToBeFormatted(
					"events doorClosed D1CL drawerOpened D2OP lightOn L1ON doorOpened D1OP panelClosed PNCL end\n");
			it.setExpectation(
					"events\n" +
					"	doorClosed   D1CL\n" +
					"	drawerOpened D2OP\n" +
					"	lightOn      L1ON\n" +
					"	doorOpened   D1OP\n" +
					"	panelClosed  PNCL\n" +
					"end\n");
		});
	}

	@Test
	public void commands() {
		assertFormatted((FormatterTestRequest it) -> {
			it.setToBeFormatted("commands unlockPanel PNUL lockPanel NLK lockDoor D1LK unlockDoor D1UL end\n");
			it.setExpectation(
					"commands\n" +
					"	unlockPanel PNUL\n" +
					"	lockPanel   NLK\n" +
					"	lockDoor    D1LK\n" +
					"	unlockDoor  D1UL\n" +
					"end\n");
		});
	}

	@Test
	public void states() {
		assertFormatted((FormatterTestRequest it) -> {
			it.setToBeFormatted(
					"state idle end state active end state waitingForLight end\n" +
					"state waitingForDrawer end state unlockedPanel end\n");
			it.setExpectation(
					"state idle\n" +
					"end\n" +
					"\n" +
					"state active\n" +
					"end\n" +
					"\n" +
					"state waitingForLight\n" +
					"end\n" +
					"\n" +
					"state waitingForDrawer\n" +
					"end\n" +
					"\n" +
					"state unlockedPanel\n" +
					"end\n");
		});
	}

	@Test
	public void resetEvent() {
		assertFormatted((FormatterTestRequest it) -> {
			it.setToBeFormatted(
					"events doorClosed D1CL drawerOpened D2OP lightOn L1ON doorOpened D1OP panelClosed PNCL end\n" +
					"resetEvents doorOpened end\n");
			it.setExpectation(
					"events\n" +
					"	doorClosed   D1CL\n" +
					"	drawerOpened D2OP\n" +
					"	lightOn      L1ON\n" +
					"	doorOpened   D1OP\n" +
					"	panelClosed  PNCL\n" +
					"end\n" +
					"\n" +
					"resetEvents\n" +
					"	doorOpened\n" +
					"end\n");
		});
	}

	@Test
	public void resetEvents() {
		assertFormatted((FormatterTestRequest it) -> {
			it.setToBeFormatted(
					"events doorClosed D1CL drawerOpened D2OP lightOn L1ON doorOpened D1OP panelClosed PNCL end\n" +
					"resetEvents doorClosed doorOpened end\n");
			it.setExpectation(
					"events\n" +
					"	doorClosed   D1CL\n" +
					"	drawerOpened D2OP\n" +
					"	lightOn      L1ON\n" +
					"	doorOpened   D1OP\n" +
					"	panelClosed  PNCL\n" +
					"end\n" +
					"\n" +
					"resetEvents\n" +
					"	doorClosed\n" +
					"	doorOpened\n" +
					"end\n");
		});
	}

	@Test
	public void events_commands() {
		assertFormatted((FormatterTestRequest it) -> {
			it.setToBeFormatted(
					"events doorClosed D1CL drawerOpened D2OP lightOn L1ON doorOpened D1OP panelClosed PNCL end\n" +
					"commands unlockPanel PNUL lockPanel NLK lockDoor D1LK unlockDoor D1UL end\n");
			it.setExpectation(
					"events\n" +
					"	doorClosed   D1CL\n" +
					"	drawerOpened D2OP\n" +
					"	lightOn      L1ON\n" +
					"	doorOpened   D1OP\n" +
					"	panelClosed  PNCL\n" +
					"end\n" +
					"\n" +
					"commands\n" +
					"	unlockPanel PNUL\n" +
					"	lockPanel   NLK\n" +
					"	lockDoor    D1LK\n" +
					"	unlockDoor  D1UL\n" +
					"end\n");
		});
	}

	@Test
	public void events_state() {
		assertFormatted((FormatterTestRequest it) -> {
			it.setToBeFormatted(
					"events doorClosed D1CL drawerOpened D2OP lightOn L1ON doorOpened D1OP panelClosed PNCL end\n" +
					"state idle end\n");
			it.setExpectation(
					"events\n" +
					"	doorClosed   D1CL\n" +
					"	drawerOpened D2OP\n" +
					"	lightOn      L1ON\n" +
					"	doorOpened   D1OP\n" +
					"	panelClosed  PNCL\n" +
					"end\n" +
					"\n" +
					"state idle\n" +
					"end\n");
		});
	}

	@Test
	public void events_resetEvents_commands() {
		assertFormatted((FormatterTestRequest it) -> {
			it.setToBeFormatted(
					"events doorClosed D1CL drawerOpened D2OP lightOn L1ON doorOpened D1OP panelClosed PNCL end\n" +
					"resetEvents doorOpened end\n" +
					"commands unlockPanel PNUL lockPanel NLK lockDoor D1LK unlockDoor D1UL end\n");
			it.setExpectation(
					"events\n" +
					"	doorClosed   D1CL\n" +
					"	drawerOpened D2OP\n" +
					"	lightOn      L1ON\n" +
					"	doorOpened   D1OP\n" +
					"	panelClosed  PNCL\n" +
					"end\n" +
					"\n" +
					"resetEvents\n" +
					"	doorOpened\n" +
					"end\n" +
					"\n" +
					"commands\n" +
					"	unlockPanel PNUL\n" +
					"	lockPanel   NLK\n" +
					"	lockDoor    D1LK\n" +
					"	unlockDoor  D1UL\n" +
					"end\n");
		});
	}

	@Test
	public void events_resetEvents_state() {
		assertFormatted((FormatterTestRequest it) -> {
			it.setToBeFormatted(
					"events doorClosed D1CL drawerOpened D2OP lightOn L1ON doorOpened D1OP panelClosed PNCL end\n" +
					"resetEvents doorOpened end state idle doorClosed => active end\n");
			it.setExpectation(
					"events\n" +
					"	doorClosed   D1CL\n" +
					"	drawerOpened D2OP\n" +
					"	lightOn      L1ON\n" +
					"	doorOpened   D1OP\n" +
					"	panelClosed  PNCL\n" +
					"end\n" +
					"\n" +
					"resetEvents\n" +
					"	doorOpened\n" +
					"end\n" +
					"\n" +
					"state idle\n" +
					"	doorClosed => active\n" +
					"end\n");
		});
	}

	@Test
	public void events_resetEvents_commands_state() {
		assertFormatted((FormatterTestRequest it) -> {
			it.setToBeFormatted(
					"events doorClosed D1CL drawerOpened D2OP lightOn L1ON doorOpened D1OP panelClosed PNCL end\n" +
					"resetEvents doorOpened end\n" +
					"commands unlockPanel PNUL lockPanel NLK lockDoor D1LK unlockDoor D1UL end\n" +
					"state idle actions {unlockDoor lockPanel} doorClosed => active end\n");
			it.setExpectation(
					"events\n" +
					"	doorClosed   D1CL\n" +
					"	drawerOpened D2OP\n" +
					"	lightOn      L1ON\n" +
					"	doorOpened   D1OP\n" +
					"	panelClosed  PNCL\n" +
					"end\n" +
					"\n" +
					"resetEvents\n" +
					"	doorOpened\n" +
					"end\n" +
					"\n" +
					"commands\n" +
					"	unlockPanel PNUL\n" +
					"	lockPanel   NLK\n" +
					"	lockDoor    D1LK\n" +
					"	unlockDoor  D1UL\n" +
					"end\n" +
					"\n" +
					"state idle\n" +
					"	actions {unlockDoor lockPanel}\n" +
					"	doorClosed => active\n" +
					"end\n");
		});
	}

	@Test
	public void events_resetEvents_commands_states() {
		assertFormatted((FormatterTestRequest it) -> {
			it.setToBeFormatted(
					"events doorClosed D1CL drawerOpened D2OP lightOn L1ON doorOpened D1OP panelClosed PNCL end\n" +
					"resetEvents doorOpened end\n" +
					"commands unlockPanel PNUL lockPanel NLK lockDoor D1LK unlockDoor D1UL end\n" +
					"state idle actions {unlockDoor lockPanel} doorClosed => active end\n" +
					"state active drawerOpened => waitingForLight lightOn => waitingForDrawer end\n" +
					"state waitingForLight lightOn => unlockedPanel end\n" +
					"state waitingForDrawer drawerOpened => unlockedPanel end\n" +
					"state unlockedPanel actions {unlockPanel lockDoor} panelClosed => idle end\n");
			it.setExpectation(
					"events\n" +
					"	doorClosed   D1CL\n" +
					"	drawerOpened D2OP\n" +
					"	lightOn      L1ON\n" +
					"	doorOpened   D1OP\n" +
					"	panelClosed  PNCL\n" +
					"end\n" +
					"\n" +
					"resetEvents\n" +
					"	doorOpened\n" +
					"end\n" +
					"\n" +
					"commands\n" +
					"	unlockPanel PNUL\n" +
					"	lockPanel   NLK\n" +
					"	lockDoor    D1LK\n" +
					"	unlockDoor  D1UL\n" +
					"end\n" +
					"\n" +
					"state idle\n" +
					"	actions {unlockDoor lockPanel}\n" +
					"	doorClosed => active\n" +
					"end\n" +
					"\n" +
					"state active\n" +
					"	drawerOpened => waitingForLight\n" +
					"	lightOn      => waitingForDrawer\n" +
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
					"end\n");
		});
	}
}
