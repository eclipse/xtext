/**
 * Copyright (c) 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.arithmetics.ui.tests.codemining;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.example.arithmetics.ui.tests.ArithmeticsUiInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.AbstractCodeMiningTest;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(ArithmeticsUiInjectorProvider.class)
@SuppressWarnings("all")
public class CodeMiningTest extends AbstractCodeMiningTest {
  @Test
  public void evaluation_value_is_presented_as_code_mining() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module volume");
    _builder.newLine();
    _builder.newLine();
    _builder.append("def cubeVolume(l): boxVolume(l,l,l);");
    _builder.newLine();
    _builder.append("def boxVolume(l,w,h): l*w*h;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("cubeVolume(10);");
    _builder.newLine();
    _builder.append("cubeVolume(2);");
    _builder.newLine();
    _builder.append("boxVolume(1,3,5);");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("module volume");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("def cubeVolume(l): boxVolume(l,l,l);");
    _builder_1.newLine();
    _builder_1.append("def boxVolume(l,w,h): l*w*h;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("cubeVolume(10) = 1000;");
    _builder_1.newLine();
    _builder_1.append("cubeVolume(2) = 8;");
    _builder_1.newLine();
    _builder_1.append("boxVolume(1,3,5) = 15;");
    _builder_1.newLine();
    this.testCodeMining(_builder, _builder_1.toString());
  }
}
