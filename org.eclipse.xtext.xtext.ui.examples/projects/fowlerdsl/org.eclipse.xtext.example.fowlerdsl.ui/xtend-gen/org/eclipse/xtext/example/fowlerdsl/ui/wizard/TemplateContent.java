/**
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.fowlerdsl.ui.wizard;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

/**
 * @author miklossy - Initial contribution and API
 */
@SuppressWarnings("all")
public class TemplateContent {
  public static final String MrsGrantsSecretCompartments = new Function0<String>() {
    @Override
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("events");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("doorClosed  D1CL");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("drawOpened  D2OP");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("lightOn     L1ON");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("doorOpened  D1OP");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("panelClosed PNCL");
      _builder.newLine();
      _builder.append("end");
      _builder.newLine();
      _builder.newLine();
      _builder.append("resetEvents");
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
      _builder.append("lockPanel   PNLK");
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
      _builder.append("drawOpened => waitingForLight");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("lightOn    => waitingForDraw");
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
      _builder.append("state waitingForDraw");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("drawOpened => unlockedPanel");
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
      return _builder.toString();
    }
  }.apply();
}
