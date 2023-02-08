/**
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.fowlerdsl.ui.tests;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.AbstractFoldingTest;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(StatemachineUiInjectorProvider.class)
@SuppressWarnings("all")
public class StatemachineFoldingTest extends AbstractFoldingTest {
  @Test
  public void events() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[>events");
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
    _builder.append("end<]");
    _builder.newLine();
    this.testFoldingRegions(_builder);
  }

  @Test
  public void resetEvents() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[>resetEvents");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("doorOpened");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("doorClosed");
    _builder.newLine();
    _builder.append("end<]");
    _builder.newLine();
    this.testFoldingRegions(_builder);
  }

  @Test
  public void commands() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[>commands");
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
    _builder.append("end<]");
    _builder.newLine();
    this.testFoldingRegions(_builder);
  }

  @Test
  public void state001() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[>state idle");
    _builder.newLine();
    _builder.append("end<]");
    _builder.newLine();
    this.testFoldingRegions(_builder);
  }

  @Test
  public void state002() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[>state idle");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("end<]");
    _builder.newLine();
    this.testFoldingRegions(_builder);
  }

  @Test
  public void complex() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[>events");
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
    _builder.append("end<]");
    _builder.newLine();
    _builder.newLine();
    _builder.append("[>resetEvents");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("doorOpened");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("doorClosed");
    _builder.newLine();
    _builder.append("end<]");
    _builder.newLine();
    _builder.newLine();
    _builder.append("[>commands");
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
    _builder.append("end<]");
    _builder.newLine();
    _builder.newLine();
    _builder.append("[>state idle");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("actions {unlockDoor lockPanel}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("doorClosed => active");
    _builder.newLine();
    _builder.append("end<]");
    _builder.newLine();
    _builder.newLine();
    _builder.append("[>state active");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("drawerOpened => waitingForLight");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("lightOn      => waitingForDrawer");
    _builder.newLine();
    _builder.append("end<]");
    _builder.newLine();
    _builder.newLine();
    _builder.append("[>state waitingForLight");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("lightOn => unlockedPanel");
    _builder.newLine();
    _builder.append("end<]");
    _builder.newLine();
    _builder.newLine();
    _builder.append("[>state waitingForDrawer");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("drawerOpened => unlockedPanel");
    _builder.newLine();
    _builder.append("end<]");
    _builder.newLine();
    _builder.newLine();
    _builder.append("[>state unlockedPanel");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("actions {unlockPanel lockDoor}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("panelClosed => idle");
    _builder.newLine();
    _builder.append("end<]");
    _builder.newLine();
    this.testFoldingRegions(_builder);
  }
}
