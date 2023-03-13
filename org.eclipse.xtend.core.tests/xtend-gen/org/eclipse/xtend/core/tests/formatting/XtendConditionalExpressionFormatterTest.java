/**
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.formatting;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.junit.Test;

/**
 * @author Eva Poell - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendConditionalExpressionFormatterTest extends AbstractXtendFormatterTest {
  @Test
  public void formatIfElseCondExpSL1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("c = (a < b) ? 3 : 4");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("c = (a < b) ? 3 : 4");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }

  @Test
  public void formatIfElseCondExpSL2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("c = (a < b) ? 3 : 4");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("c =(a<b)?3:4");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }

  @Test
  public void formatIfElseCondExpSL3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("c = (a < b) ? (b < d) ? 5 : (b < d) ? 7 : 8");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("c =(a<b)?(b<d)?5:(b<d)?7:8");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }

  @Test
  public void formatIfElseCondExpML() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("c = (a < b)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("? 3");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(": 4");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("c=(a<b)?");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("3:");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("4");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
}
