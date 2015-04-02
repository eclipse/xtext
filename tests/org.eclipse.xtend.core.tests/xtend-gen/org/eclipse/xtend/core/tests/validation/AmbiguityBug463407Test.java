/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
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
public class AmbiguityBug463407Test extends AmbiguityValidationTest {
  @Test
  public void testUnambiguousMethod_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.eclipse.xtext.xbase.lib.Functions.Function0");
    _builder.newLine();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def m() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("aSetter(#[\"\", \"\"])");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def void aSetter(List<Object> c) {}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def void aSetter(Function0<List<Object>> c) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testUnambiguousMethod_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.eclipse.xtext.xbase.lib.Functions.Function0");
    _builder.newLine();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def m() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("aSetter(#[\'\'])");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def void aSetter(List<Object> c) {}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def void aSetter(Function0<List<Object>> c) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testUnambiguousMethod_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.eclipse.xtext.xbase.lib.Functions.Function0");
    _builder.newLine();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def m() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("aSetter(#[])");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def void aSetter(List<Object> c) {}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def void aSetter(Function0<List<Object>> c) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testUnambiguousMethod_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.eclipse.xtext.xbase.lib.Functions.Function0");
    _builder.newLine();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def m() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("aSetter(newArrayList(\'\'))");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def void aSetter(List<Object> c) {}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def void aSetter(Function0<List<Object>> c) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testUnambiguousMethod_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.eclipse.xtext.xbase.lib.Functions.Function0");
    _builder.newLine();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def m() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("aSetter(newArrayList)");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def void aSetter(List<Object> c) {}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def void aSetter(Function0<List<Object>> c) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testUnambiguousMethod_06() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.eclipse.xtext.xbase.lib.Functions.Function0");
    _builder.newLine();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def m() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("#[\"\", \"\"].aSetter");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def void aSetter(List<? extends Object> c) {}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def void aSetter(Function0<List<Object>> c) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testUnambiguousMethod_07() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.eclipse.xtext.xbase.lib.Functions.Function0");
    _builder.newLine();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def m() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("aSetter[]");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def void aSetter(List<Object> c) {}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def void aSetter(Function0<List<Object>> c) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testUnambiguousMethod_08() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.eclipse.xtext.xbase.lib.Functions.Function0");
    _builder.newLine();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def m() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("aSetter[|]");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def void aSetter(List<Object> c) {}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def void aSetter(Function0<List<Object>> c) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testAmbiguousMethod_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.eclipse.xtext.xbase.lib.Functions.Function0");
    _builder.newLine();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def m() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("aSetter(null)");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def void aSetter(List<Object> c) {}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def void aSetter(Function0<List<Object>> c) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Ambiguous feature call.");
    _builder_1.newLine();
    _builder_1.append("The methods");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("aSetter(List<Object>) in A and");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("aSetter(Function0<List<Object>>) in A");
    _builder_1.newLine();
    _builder_1.append("both match.");
    this.assertAmbiguous(_builder, _builder_1.toString());
  }
}
