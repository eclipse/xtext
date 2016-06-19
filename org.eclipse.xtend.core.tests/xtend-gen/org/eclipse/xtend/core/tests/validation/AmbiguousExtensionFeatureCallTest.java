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
public class AmbiguousExtensionFeatureCallTest extends AmbiguityValidationTest {
  @Test
  public void testAmbiguousMethods_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(StringBuilder b) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("b.m2");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m2(CharSequence c) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m2(Appendable a) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Ambiguous feature call.");
    _builder_1.newLine();
    _builder_1.append("The extension methods");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m2(CharSequence) in C and");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m2(Appendable) in C");
    _builder_1.newLine();
    _builder_1.append("both match.");
    this.assertAmbiguous(_builder, _builder_1.toString());
  }
  
  @Test
  public void testAmbiguousMethods_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(StringBuilder it) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m2");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m2(CharSequence c) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m2(Appendable a) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Ambiguous feature call.");
    _builder_1.newLine();
    _builder_1.append("The extension methods");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m2(CharSequence) in C and");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m2(Appendable) in C");
    _builder_1.newLine();
    _builder_1.append("both match.");
    this.assertAmbiguous(_builder, _builder_1.toString());
  }
  
  @Test
  public void testAmbiguousMethods_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C extends D {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(StringBuilder it) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m2");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m2(Appendable a) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class D {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m2(CharSequence c) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Ambiguous feature call.");
    _builder_1.newLine();
    _builder_1.append("The extension methods");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m2(Appendable) in C and");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m2(CharSequence) in D");
    _builder_1.newLine();
    _builder_1.append("both match.");
    this.assertAmbiguous(_builder, _builder_1.toString());
  }
  
  @Test
  public void testAmbiguousMethods_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(StringBuilder it, extension D d, extension E e) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m2");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class D {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m2(CharSequence c) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class E {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m2(Appendable a) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Ambiguous feature call.");
    _builder_1.newLine();
    _builder_1.append("The extension methods");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m2(CharSequence) in D and");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m2(Appendable) in E");
    _builder_1.newLine();
    _builder_1.append("both match.");
    this.assertAmbiguous(_builder, _builder_1.toString());
  }
  
  @Test
  public void testAmbiguousMethods_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(StringBuilder it) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m2");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("extension D");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("extension E");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class D {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m2(CharSequence c) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class E {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m2(Appendable a) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Ambiguous feature call.");
    _builder_1.newLine();
    _builder_1.append("The extension methods");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m2(CharSequence) in D and");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m2(Appendable) in E");
    _builder_1.newLine();
    _builder_1.append("both match.");
    this.assertAmbiguous(_builder, _builder_1.toString());
  }
  
  @Test
  public void testAmbiguousMethods_06() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(StringBuilder it) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val extension D d = null");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val extension E e = null");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m2");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class D {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m2(CharSequence c) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class E {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m2(Appendable a) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Ambiguous feature call.");
    _builder_1.newLine();
    _builder_1.append("The extension methods");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m2(Appendable) in E and");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m2(CharSequence) in D");
    _builder_1.newLine();
    _builder_1.append("both match.");
    this.assertAmbiguous(_builder, _builder_1.toString());
  }
  
  @Test
  public void testAmbiguousMethods_07() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import static extension D.*");
    _builder.newLine();
    _builder.append("import static extension E.*");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(StringBuilder it) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m2");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class D {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static void m2(CharSequence c) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class E {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static void m2(Appendable a) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Ambiguous feature call.");
    _builder_1.newLine();
    _builder_1.append("The extension methods");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m2(CharSequence) in D and");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m2(Appendable) in E");
    _builder_1.newLine();
    _builder_1.append("both match.");
    this.assertAmbiguous(_builder, _builder_1.toString());
  }
  
  @Test
  public void testAmbiguousMethods_08() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(StringBuilder it) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val extension D d = null");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m2");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("extension E");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class D {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m2(CharSequence c) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class E {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m2(Appendable a) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Ambiguous feature call.");
    _builder_1.newLine();
    _builder_1.append("The extension methods");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m2(CharSequence) in D and");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m2(Appendable) in E");
    _builder_1.newLine();
    _builder_1.append("both match.");
    this.assertAmbiguous(_builder, _builder_1.toString());
  }
  
  @Test
  public void testAmbiguousMethods_09() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(StringBuilder it) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val extension D d = null");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val extension E e = null");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m2");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class D {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m2(CharSequence c) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class E {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m2(CharSequence a) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Ambiguous feature call.");
    _builder_1.newLine();
    _builder_1.append("The extension methods");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m2(CharSequence) in E and");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m2(CharSequence) in D");
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
    _builder.append("def void m(StringBuilder it) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val extension D d = null");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("val extension E e = null");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("m2");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class D {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m2(CharSequence c) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class E {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m2(CharSequence a) {}");
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
    _builder.append("def void m(StringBuilder it) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val extension D d = null");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m2");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("extension E");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class D {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m2(CharSequence c) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class E {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m2(CharSequence a) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testUnambiguousMethods_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(StringBuilder it) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val extension D d1 = null");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val extension D d2 = null");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("val extension E e = null");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("m2");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class D {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m2(CharSequence c) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class E {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m2(StringBuilder bd) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testUnambiguousMethods_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(StringBuilder it) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val extension E e = null");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val extension D d1 = null");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val extension D d2 = null");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m2");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class D {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m2(CharSequence c) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class E {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m2(StringBuilder bd) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
}
