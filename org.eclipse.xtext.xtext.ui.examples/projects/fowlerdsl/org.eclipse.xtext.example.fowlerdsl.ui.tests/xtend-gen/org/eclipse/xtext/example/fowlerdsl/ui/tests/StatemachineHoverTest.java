/**
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.fowlerdsl.ui.tests;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.example.fowlerdsl.ui.tests.StatemachineUiInjectorProvider;
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
@SuppressWarnings("all")
public class StatemachineHoverTest extends AbstractHoverTest {
  @Test
  public void hover_over_event() {
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
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Event <b>doorClosed</b>");
    this.hasHoverOver(_builder, "doorClosed", _builder_1.toString());
  }
  
  @Test
  public void hover_over_command() {
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
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Command <b>unlockPanel</b>");
    this.hasHoverOver(_builder, "unlockPanel", _builder_1.toString());
  }
  
  @Test
  public void hover_over_state() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("state idle {}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("State <b>state idle</b>");
    this.hasHoverOver(_builder, "idle", _builder_1.toString());
  }
}
