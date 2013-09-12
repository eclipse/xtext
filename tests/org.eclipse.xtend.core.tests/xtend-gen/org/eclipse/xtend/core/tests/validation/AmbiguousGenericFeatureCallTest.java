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
public class AmbiguousGenericFeatureCallTest extends AmbiguityValidationTest {
  @Test
  public void testAmbiguousMethods_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void n(StringBuilder b) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m2(b)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <T extends CharSequence> void m2(T c) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <X extends Appendable> void m2(X a) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertAmbiguous(_builder, "<T extends CharSequence> m2(T)", "<X extends Appendable> m2(X)");
  }
  
  @Test
  public void testAmbiguousMethods_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void n(StringBuilder b) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m2(get)");
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
    _builder.append("\t");
    _builder.append("def <T> T get() {}");
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
  public void testAmbiguousMethods_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void n(D<String> it) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m(\'\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class D<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(String s) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(T t) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Ambiguous feature call.");
    _builder_1.newLine();
    _builder_1.append("The methods");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m(String) in D and");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m(T) in D");
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
    _builder.append("def void m(D<String> it) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("add(\'\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class D<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void add(T t) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <X extends String> void add(X x) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Ambiguous feature call.");
    _builder_1.newLine();
    _builder_1.append("The methods");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("add(T) in D and");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("<X extends String> add(X) in D");
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
    _builder.append("def void m(D<String> it) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("add(\'\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <X extends String> void add(X x) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class D<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void add(T t) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Ambiguous feature call.");
    _builder_1.newLine();
    _builder_1.append("The methods");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("add(T) in D and");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("<X extends String> add(X) in C");
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
    _builder.append("def void n(E<String> it) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m(\'\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class D<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(T t) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class E<T> extends D<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(String s) {}");
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
    _builder.append("def void n(D<CharSequence> it) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m(\'\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class D<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(String s) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(T t) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
}
