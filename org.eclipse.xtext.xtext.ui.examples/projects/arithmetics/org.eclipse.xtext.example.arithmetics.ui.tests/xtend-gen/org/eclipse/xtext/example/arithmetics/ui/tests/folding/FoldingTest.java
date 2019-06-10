/**
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.arithmetics.ui.tests.folding;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.example.arithmetics.ui.tests.ArithmeticsUiInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.AbstractFoldingTest;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(ArithmeticsUiInjectorProvider.class)
@SuppressWarnings("all")
public class FoldingTest extends AbstractFoldingTest {
  @Test
  public void function001() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module arithmetics");
    _builder.newLine();
    _builder.newLine();
    _builder.append("def add(a, b) :\ta + b;");
    _builder.newLine();
    this.testFoldingRegions(_builder);
  }
  
  @Test
  public void function002() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module arithmetics");
    _builder.newLine();
    _builder.newLine();
    _builder.append("[>def add(a, b) :");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("a + b;<]");
    _builder.newLine();
    this.testFoldingRegions(_builder);
  }
  
  @Test
  public void function003() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module arithmetics");
    _builder.newLine();
    _builder.newLine();
    _builder.append("[>def add(a, b) :");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("a + b;<]");
    _builder.newLine();
    _builder.newLine();
    _builder.append("[>def multiply(a, b) :");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("a * b;<]");
    _builder.newLine();
    this.testFoldingRegions(_builder);
  }
}
