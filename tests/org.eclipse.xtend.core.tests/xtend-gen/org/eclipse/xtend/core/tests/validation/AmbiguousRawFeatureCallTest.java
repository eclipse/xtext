/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.validation;

import org.eclipse.xtend.core.tests.validation.AmbiguityValidationTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class AmbiguousRawFeatureCallTest extends AmbiguityValidationTest {
  @Test
  public void testAmbiguousMethods_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void n() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m(newArrayList)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(Iterable i) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(java.io.Serializable s) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Ambiguous feature call.");
    _builder_1.newLine();
    _builder_1.append("The methods");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m(Iterable) in C and");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m(Serializable) in C");
    _builder_1.newLine();
    _builder_1.append("both match.");
    this.assertAmbiguous(_builder, _builder_1.toString());
  }
  
  @Test
  public void testUnambiguousMethods_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void n() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m(newArrayList)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(Iterable i) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(Object o) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testUnambiguousMethods_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void n() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("new C(newArrayList)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new(Collection i) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new(Object s) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
}
