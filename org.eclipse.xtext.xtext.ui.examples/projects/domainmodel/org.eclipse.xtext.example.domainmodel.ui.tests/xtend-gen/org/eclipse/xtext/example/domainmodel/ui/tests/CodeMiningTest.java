/**
 * Copyright (c) 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.domainmodel.ui.tests;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.AbstractCodeMiningTest;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(DomainmodelUiInjectorProvider.class)
@SuppressWarnings("all")
public class CodeMiningTest extends AbstractCodeMiningTest {
  @Test
  public void implicit_return_type_is_presented_as_code_mining() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("entity E {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("s: String");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("op getS() { s }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("1 property | 1 operation");
    _builder_1.newLine();
    _builder_1.append("entity E {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("s: String");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("op getS() : String { s }");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.testCodeMining(_builder, _builder_1.toString());
  }

  @Test
  public void explicit_return_type_is_not_presented_as_code_mining() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("entity E {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("s: String");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("op getS() : String { s }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("1 property | 1 operation");
    _builder_1.newLine();
    _builder_1.append("entity E {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("s: String");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("op getS() : String { s }");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.testCodeMining(_builder, _builder_1.toString());
  }

  @Test
  public void several_entities_001() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("entity E1 {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("entity E2 {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("0 properties | 0 operations");
    _builder_1.newLine();
    _builder_1.append("entity E1 {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("0 properties | 0 operations");
    _builder_1.newLine();
    _builder_1.append("entity E2 {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.testCodeMining(_builder, _builder_1.toString());
  }

  @Test
  public void several_entities_002() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("entity E1 {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("entity E2 {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("0 properties | 0 operations");
    _builder_1.newLine();
    _builder_1.append("entity E1 {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("0 properties | 0 operations");
    _builder_1.newLine();
    _builder_1.append("entity E2 {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.testCodeMining(_builder, _builder_1.toString());
  }
}
