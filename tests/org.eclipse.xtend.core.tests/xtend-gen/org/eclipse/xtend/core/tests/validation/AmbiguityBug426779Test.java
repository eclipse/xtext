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
public class AmbiguityBug426779Test extends AmbiguityValidationTest {
  @Test
  public void testUnambiguousMethod_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Bug {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(String s) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <T extends CharSequence> void m(T t) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void n(Iterable<String> it) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m(it.head)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testUnambiguousMethod_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Bug {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <T extends Object> void m(T t) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <T extends CharSequence> void m(T t) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void n(Iterable<String> it) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m(it.head)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testUnambiguousMethod_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Bug {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(Object t) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(CharSequence t) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void n(Iterable<String> it) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m(it.head)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testUnambiguousMethod_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Bug {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <T extends Object> void m(T t) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(CharSequence t) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void n(Iterable<String> it) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m(it.head)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testAmbiguousMethod_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Bug {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void n(Iterable<String> it) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m(it.head)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(java.io.Serializable s) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(CharSequence t) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Ambiguous feature call.");
    _builder_1.newLine();
    _builder_1.append("The methods");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m(Serializable) in Bug and");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m(CharSequence) in Bug");
    _builder_1.newLine();
    _builder_1.append("both match.");
    this.assertAmbiguous(_builder, _builder_1.toString());
  }
}
