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
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class AmbiguityBug421831Test extends AmbiguityValidationTest {
  @Test
  public void testAmbiguousStaticImports_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import static MockitoMatchers.* ");
    _builder.newLine();
    _builder.append("import static HarmcrestMatchers.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Bug {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def static accept(Bug bug) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("any(Bug)");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class MockitoMatchers {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static def <T> Matcher<T> any(Class<T> type) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class Matcher<T> {}");
    _builder.newLine();
    _builder.append("class HarmcrestMatchers {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static def <T> T any(Class<T> clazz) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Ambiguous feature call.");
    _builder_1.newLine();
    _builder_1.append("The methods");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("<T> any(Class<T>) in MockitoMatchers and");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("<T> any(Class<T>) in HarmcrestMatchers");
    _builder_1.newLine();
    _builder_1.append("both match.");
    this.assertAmbiguous(_builder, _builder_1.toString());
  }
  
  @Test
  public void testUnambiguousStaticImports_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import static MockitoMatchers.* ");
    _builder.newLine();
    _builder.append("import static HarmcrestMatchers.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Bug {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def static accept(Bug bug) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("any(Bug)");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class MockitoMatchers {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static def <T extends Number> Matcher<T> any(Class<T> type) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class Matcher<T> {}");
    _builder.newLine();
    _builder.append("class HarmcrestMatchers {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static def <T> T any(Class<T> clazz) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Ignore("TODO fix me")
  @Test
  public void testUnambiguousStaticImports_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import static MockitoMatchers.* ");
    _builder.newLine();
    _builder.append("import static HarmcrestMatchers.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Bug {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def static accept(Bug bug) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("any(Bug)");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class MockitoMatchers {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static def <T> Matcher<T> any(Class<T> type) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class Matcher<T> {}");
    _builder.newLine();
    _builder.append("class HarmcrestMatchers {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static def Bug any(Class<? extends Bug> clazz) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Ignore("TODO fix me")
  @Test
  public void testUnambiguousStaticImports_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import static MockitoMatchers.* ");
    _builder.newLine();
    _builder.append("import static HarmcrestMatchers.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Bug {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def static accept(Bug bug) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("any(Bug)");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class MockitoMatchers {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static def <T> Matcher<T> any(Class<T> type) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class Matcher<T> {}");
    _builder.newLine();
    _builder.append("class HarmcrestMatchers {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static def <T extends Bug> T any(Class<T> clazz) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
}
