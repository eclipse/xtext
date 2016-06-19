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
public class AmbiguousPlainFeatureCallTest extends AmbiguityValidationTest {
  @Test
  public void testAmbiguousMethods_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(StringBuilder b) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m2(b)");
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
    _builder_1.append("The methods");
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
    _builder.append("def void m(StringBuilder b) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m2(b)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m2(CharSequence c) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m2(java.io.Serializable s) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m2(Appendable a) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Ambiguous feature call.");
    _builder_1.newLine();
    _builder_1.append("The methods");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m2(CharSequence) in C,");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m2(Serializable) in C and");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m2(Appendable) in C");
    _builder_1.newLine();
    _builder_1.append("all match.");
    this.assertAmbiguous(_builder, _builder_1.toString());
  }
  
  @Test
  public void testAmbiguousMethods_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C extends D {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(StringBuilder b) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m2(b)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m2(CharSequence c) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class D {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m2(Appendable a) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Ambiguous feature call.");
    _builder_1.newLine();
    _builder_1.append("The methods");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m2(CharSequence) in C and");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m2(Appendable) in D");
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
    _builder.append("def void m(StringBuilder b, D it) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m2(b)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m2(CharSequence c) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class D {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m2(Appendable a) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertAmbiguous(_builder, "m2(Appendable) in D", "m2(CharSequence) in C");
  }
  
  @Test
  public void testAmbiguousMethods_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m2");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void getM2() {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m2() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Ambiguous feature call.");
    _builder_1.newLine();
    _builder_1.append("The methods");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m2() in C and");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("getM2() in C");
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
    _builder.append("def void n() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m(#[ null ])");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(String[] s) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(Boolean[] s) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Ambiguous feature call.");
    _builder_1.newLine();
    _builder_1.append("The methods");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m(String[]) in C and");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m(Boolean[]) in C");
    _builder_1.newLine();
    _builder_1.append("both match.");
    this.assertAmbiguous(_builder, _builder_1.toString());
  }
  
  @Test
  public void testAmbiguousMethods_07() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void n() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m(#[])");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(String[] s) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(Boolean[] s) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Ambiguous feature call.");
    _builder_1.newLine();
    _builder_1.append("The methods");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m(String[]) in C and");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m(Boolean[]) in C");
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
    _builder.append("def void n() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m(#[])");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(String... s) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(Boolean... s) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Ambiguous feature call.");
    _builder_1.newLine();
    _builder_1.append("The methods");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m(String[]) in C and");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m(Boolean[]) in C");
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
    _builder.append("def void n() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m(null)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(String... s) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(Boolean... s) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Ambiguous feature call.");
    _builder_1.newLine();
    _builder_1.append("The methods");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m(String[]) in C and");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m(Boolean[]) in C");
    _builder_1.newLine();
    _builder_1.append("both match.");
    this.assertAmbiguous(_builder, _builder_1.toString());
  }
  
  @Test
  public void testAmbiguousMethods_10() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void n() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(String... s) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(Boolean... s) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Ambiguous feature call.");
    _builder_1.newLine();
    _builder_1.append("The methods");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m(String[]) in C and");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m(Boolean[]) in C");
    _builder_1.newLine();
    _builder_1.append("both match.");
    this.assertAmbiguous(_builder, _builder_1.toString());
  }
  
  @Test
  public void testAmbiguousMethods_11() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.*");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void n() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m(#[])");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(List<String> s) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(Collection<Boolean> s) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Ambiguous feature call.");
    _builder_1.newLine();
    _builder_1.append("The methods");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m(List<String>) in C and");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m(Collection<Boolean>) in C");
    _builder_1.newLine();
    _builder_1.append("both match.");
    this.assertAmbiguous(_builder, _builder_1.toString());
  }
  
  @Test
  public void testAmbiguousMethods_12() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.*");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void n() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m []");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m((int, int, int)=>void p) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m((int, int)=>void p) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Ambiguous feature call.");
    _builder_1.newLine();
    _builder_1.append("The methods");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m((int, int, int)=>void) in C and");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m((int, int)=>void) in C");
    _builder_1.newLine();
    _builder_1.append("both match.");
    this.assertAmbiguous(_builder, _builder_1.toString());
  }
  
  @Test
  public void testAmbiguousMethods_13() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.*");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void n() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m []");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(()=>void p) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m((int, int)=>void p) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Ambiguous feature call.");
    _builder_1.newLine();
    _builder_1.append("The methods");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m(()=>void) in C and");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m((int, int)=>void) in C");
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
    _builder.append("def void m(StringBuilder b, D it) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m2(b)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m2(Object o) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class D {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m2(Appendable a) {}");
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
    _builder.append("def void m(Object o) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("switch o {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("I : switch o {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("J : o.m2");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface I {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m2()");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface J {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m2()");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testUnambiguousMethods_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import static D.*");
    _builder.newLine();
    _builder.append("class C extends D {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m() {");
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
    _builder.append("def static void m2() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testUnambiguousMethods_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import static D.*");
    _builder.newLine();
    _builder.append("class C extends D {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m() {");
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
    _builder.append("def static void m2() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testUnambiguousMethods_06() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m2()");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("getM2");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void getM2() {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m2() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testUnambiguousMethods_07() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m2");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String m2");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void getM2() {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m2() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testUnambiguousMethods_08() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import static D.*");
    _builder.newLine();
    _builder.append("import static E.*");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m() {");
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
    _builder.append("def static void m2() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class E extends D {}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testUnambiguousMethods_09() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import static D.*");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("E.m2");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class D {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static void m2() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class E extends D {}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testUnambiguousMethods_10() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void n() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m(#[ null ])");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(String[] s) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(boolean[] s) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testUnambiguousMethods_11() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void n() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m(#[ true ])");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(String[] s) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(boolean[] s) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testUnambiguousMethods_12() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void n() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m(#[ \'\' ])");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(String[] s) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(boolean[] s) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testUnambiguousMethods_13() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void n() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m(true)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(String... s) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(boolean... s) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testUnambiguousMethods_14() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void n() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m(\'\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(String... s) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(boolean... s) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testUnambiguousMethods_15() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void n() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m(#[ null ])");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(String... s) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(boolean... s) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testUnambiguousMethods_16() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void n() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m(#[ true ])");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(String... s) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(boolean... s) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testUnambiguousMethods_17() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void n() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m(#[ \'\' ])");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(String... s) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(boolean... s) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testUnambiguousMethods_18() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.*");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void n() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m(#[ true ])");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(List<String> s) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(Collection<Boolean> s) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testUnambiguousMethods_19() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.*");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void n() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m(#[ \'\' ])");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(List<String> s) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(Collection<Boolean> s) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testUnambiguousMethods_20() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.*");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void n() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m []");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(()=>void p) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m((int)=>void p) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testUnambiguousMethods_21() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.*");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void n() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m []");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m((int, int)=>void p) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m((int)=>void p) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
}
