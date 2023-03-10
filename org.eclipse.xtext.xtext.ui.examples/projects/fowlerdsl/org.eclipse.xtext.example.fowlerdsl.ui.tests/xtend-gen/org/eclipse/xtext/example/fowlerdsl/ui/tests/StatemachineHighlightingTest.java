/**
 * Copyright (c) 2018, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.fowlerdsl.ui.tests;

import org.eclipse.swt.SWT;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.AbstractHighlightingTest;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(StatemachineUiInjectorProvider.class)
@SuppressWarnings("all")
public class StatemachineHighlightingTest extends AbstractHighlightingTest {
  @Test
  public void events_keyword() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("events");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("doorClosed   D1CL");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("drawerOpened D2OP");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("lightOn      L1ON");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("doorOpened   D1OP");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("panelClosed  PNCL");
    _builder.newLine();
    _builder.append("end");
    _builder.newLine();
    this.testHighlighting(_builder, "events", SWT.BOLD, 127, 0, 85);
  }

  @Test
  public void end_keyword() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("events");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("doorClosed   D1CL");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("drawerOpened D2OP");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("lightOn      L1ON");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("doorOpened   D1OP");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("panelClosed  PNCL");
    _builder.newLine();
    _builder.append("end");
    _builder.newLine();
    this.testHighlighting(_builder, "end", SWT.BOLD, 127, 0, 85);
  }

  @Test
  public void resetEvents_keyword() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("events");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("doorClosed   D1CL");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("drawerOpened D2OP");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("lightOn      L1ON");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("doorOpened   D1OP");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("panelClosed  PNCL");
    _builder.newLine();
    _builder.append("end");
    _builder.newLine();
    _builder.newLine();
    _builder.append("resetEvents");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("doorOpened doorClosed");
    _builder.newLine();
    _builder.append("end");
    _builder.newLine();
    this.testHighlighting(_builder, "resetEvents", SWT.BOLD, 127, 0, 85);
  }

  @Test
  public void commands_keyword() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("commands");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("unlockPanel PNUL");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("lockPanel   NLK");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("lockDoor    D1LK");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("unlockDoor  D1UL");
    _builder.newLine();
    _builder.append("end");
    _builder.newLine();
    this.testHighlighting(_builder, "commands", SWT.BOLD, 127, 0, 85);
  }

  @Test
  public void state_keyword() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("events");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("doorClosed   D1CL");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("drawerOpened D2OP");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("lightOn      L1ON");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("doorOpened   D1OP");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("panelClosed  PNCL");
    _builder.newLine();
    _builder.append("end");
    _builder.newLine();
    _builder.newLine();
    _builder.append("resetEvents");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("doorOpened");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("doorClosed");
    _builder.newLine();
    _builder.append("end");
    _builder.newLine();
    _builder.newLine();
    _builder.append("commands");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("unlockPanel PNUL");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("lockPanel   NLK");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("lockDoor    D1LK");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("unlockDoor  D1UL");
    _builder.newLine();
    _builder.append("end");
    _builder.newLine();
    _builder.newLine();
    _builder.append("state idle");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("actions {unlockDoor lockPanel}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("doorClosed => active");
    _builder.newLine();
    _builder.append("end");
    _builder.newLine();
    _builder.newLine();
    _builder.append("state active");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("drawerOpened => waitingForLight");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("lightOn      => waitingForDrawer");
    _builder.newLine();
    _builder.append("end");
    _builder.newLine();
    _builder.newLine();
    _builder.append("state waitingForLight");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("lightOn => unlockedPanel");
    _builder.newLine();
    _builder.append("end");
    _builder.newLine();
    _builder.newLine();
    _builder.append("state waitingForDrawer");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("drawerOpened => unlockedPanel");
    _builder.newLine();
    _builder.append("end");
    _builder.newLine();
    _builder.newLine();
    _builder.append("state unlockedPanel");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("actions {unlockPanel lockDoor}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("panelClosed => idle");
    _builder.newLine();
    _builder.append("end");
    _builder.newLine();
    this.testHighlighting(_builder, "state", SWT.BOLD, 127, 0, 85);
  }

  @Test
  public void actions_keyword() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("events");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("doorClosed   D1CL");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("drawerOpened D2OP");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("lightOn      L1ON");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("doorOpened   D1OP");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("panelClosed  PNCL");
    _builder.newLine();
    _builder.append("end");
    _builder.newLine();
    _builder.newLine();
    _builder.append("resetEvents");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("doorOpened");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("doorClosed");
    _builder.newLine();
    _builder.append("end");
    _builder.newLine();
    _builder.newLine();
    _builder.append("commands");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("unlockPanel PNUL");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("lockPanel   NLK");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("lockDoor    D1LK");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("unlockDoor  D1UL");
    _builder.newLine();
    _builder.append("end");
    _builder.newLine();
    _builder.newLine();
    _builder.append("state idle");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("actions {unlockDoor lockPanel}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("doorClosed => active");
    _builder.newLine();
    _builder.append("end");
    _builder.newLine();
    _builder.newLine();
    _builder.append("state active");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("drawerOpened => waitingForLight");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("lightOn      => waitingForDrawer");
    _builder.newLine();
    _builder.append("end");
    _builder.newLine();
    _builder.newLine();
    _builder.append("state waitingForLight");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("lightOn => unlockedPanel");
    _builder.newLine();
    _builder.append("end");
    _builder.newLine();
    _builder.newLine();
    _builder.append("state waitingForDrawer");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("drawerOpened => unlockedPanel");
    _builder.newLine();
    _builder.append("end");
    _builder.newLine();
    _builder.newLine();
    _builder.append("state unlockedPanel");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("actions {unlockPanel lockDoor}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("panelClosed => idle");
    _builder.newLine();
    _builder.append("end");
    _builder.newLine();
    this.testHighlighting(_builder, "actions", SWT.BOLD, 127, 0, 85);
  }

  @Test
  public void single_line_comment() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// An implementation of Martin Fowler\'s secret compartment state machine");
    _builder.newLine();
    this.testHighlighting(_builder, "An implementation of Martin Fowler\'s secret compartment state machine", 
      SWT.NORMAL, 63, 127, 95);
  }

  @Test
  public void multi_line_comment() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* An implementation of Martin Fowler\'s secret compartment state machine");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* ");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* http://martinfowler.com/dslwip/Intro.html");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("/*");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("* An implementation of Martin Fowler\'s secret compartment state machine");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("* ");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("* http://martinfowler.com/dslwip/Intro.html");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("*/");
    _builder_1.newLine();
    this.testHighlighting(_builder, _builder_1.toString(), SWT.NORMAL, 63, 127, 95);
  }

  @Test
  public void fixme_task_in_comment() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// FIXME");
    _builder.newLine();
    this.testHighlighting(_builder, "FIXME", SWT.BOLD, 127, 159, 191);
  }

  @Test
  public void todo_task_in_comment() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// TODO");
    _builder.newLine();
    this.testHighlighting(_builder, "TODO", SWT.BOLD, 127, 159, 191);
  }

  @Test
  public void xxx_task_in_comment() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// XXX");
    _builder.newLine();
    this.testHighlighting(_builder, "XXX", SWT.BOLD, 127, 159, 191);
  }
}
