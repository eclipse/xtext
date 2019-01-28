/**
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
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
import org.eclipse.xtext.ui.testing.AbstractHyperlinkingTest;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(StatemachineUiInjectorProvider.class)
@SuppressWarnings("all")
public class StatemachineHyperlinkingTest extends AbstractHyperlinkingTest {
  @Test
  public void hyperlink_on_event() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("events");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("doorClosed D1CL");
    _builder.newLine();
    _builder.append("end");
    _builder.newLine();
    _builder.newLine();
    _builder.append("state idle");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(this.c, "\t");
    _builder.append("doorClosed");
    _builder.append(this.c, "\t");
    _builder.append(" => active");
    _builder.newLineIfNotEmpty();
    _builder.append("end");
    _builder.newLine();
    _builder.newLine();
    _builder.append("state active");
    _builder.newLine();
    _builder.append("end");
    _builder.newLine();
    this.hasHyperlinkTo(_builder, "doorClosed");
  }
  
  @Test
  public void hyperlink_on_command() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("commands");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("unlockDoor D1UL");
    _builder.newLine();
    _builder.append("end");
    _builder.newLine();
    _builder.newLine();
    _builder.append("state idle");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("actions {");
    _builder.append(this.c, "\t");
    _builder.append("unlockDoor");
    _builder.append(this.c, "\t");
    _builder.append("}");
    _builder.newLineIfNotEmpty();
    _builder.append("end");
    _builder.newLine();
    this.hasHyperlinkTo(_builder, "unlockDoor");
  }
  
  @Test
  public void hyperlink_on_state() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("events");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("doorClosed D1CL");
    _builder.newLine();
    _builder.append("end");
    _builder.newLine();
    _builder.newLine();
    _builder.append("state idle");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("doorClosed => ");
    _builder.append(this.c, "\t");
    _builder.append("active");
    _builder.append(this.c, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("end");
    _builder.newLine();
    _builder.newLine();
    _builder.append("state active");
    _builder.newLine();
    _builder.append("end");
    _builder.newLine();
    this.hasHyperlinkTo(_builder, "active");
  }
}
