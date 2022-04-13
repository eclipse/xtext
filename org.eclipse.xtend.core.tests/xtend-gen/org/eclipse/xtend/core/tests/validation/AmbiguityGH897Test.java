/**
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.validation;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class AmbiguityGH897Test extends AmbiguityValidationTest {
  @Test
  public void testAmbiguousConstructorCall_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class SampleImpl implements Sample {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def x() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("new Demo(null)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface Sample {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("class Demo {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("new(String s) {}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("new(Integer s) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Ambiguous constructor call.");
    _builder_1.newLine();
    _builder_1.append("The constructors");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("Demo(String) and");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("Demo(Integer)");
    _builder_1.newLine();
    _builder_1.append("both match.");
    this.assertAmbiguous(_builder, _builder_1.toString());
  }

  @Test
  public void testUnambiguousConstructorCall_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("interface Sample {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("class Demo {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static class SampleImpl implements Sample {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("def x() {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("new Demo");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
}
