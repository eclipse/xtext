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
public class AmbiguityGH389Test extends AmbiguityValidationTest {
  @Test
  public void testAmbiguousConstructorCall_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Bug {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def static m() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("new Bug(null)");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("new(String s) {}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("new(Void v) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Ambiguous constructor call.");
    _builder_1.newLine();
    _builder_1.append("The constructors");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("Bug(String) and");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("Bug(Void)");
    _builder_1.newLine();
    _builder_1.append("both match.");
    this.assertAmbiguous(_builder, _builder_1.toString());
  }

  @Test
  public void testUnambiguousConstructorCall_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Bug {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def static m() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("new Bug(null)");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("new(String s) {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("new(CharSequence c) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
}
