/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
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
public class AmbiguityBug438461Test extends AmbiguityValidationTest {
  @Test
  public void testUnambiguousMethod_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.concurrent.ExecutorService");
    _builder.newLine();
    _builder.append("class Bug {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(ExecutorService service) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("service.submit [ \"\".notify() ]");
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
    _builder.append("import java.util.concurrent.ExecutorService");
    _builder.newLine();
    _builder.append("class Bug {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(ExecutorService service) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("service.submit [ return \'\' ]");
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
    _builder.append("import java.util.concurrent.ExecutorService");
    _builder.newLine();
    _builder.append("class Bug {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(ExecutorService service) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("service.submit [ return ]");
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
    _builder.append("import java.util.concurrent.ExecutorService");
    _builder.newLine();
    _builder.append("class Bug {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(ExecutorService service) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("service.submit [ \"\" ]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testUnambiguousMethod_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.concurrent.ExecutorService");
    _builder.newLine();
    _builder.append("class Bug {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(ExecutorService service) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("service.submit [ return null ]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testUnambiguousMethod_06() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.concurrent.ExecutorService");
    _builder.newLine();
    _builder.append("class Bug {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(ExecutorService service) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("service.submit [ null ]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testUnambiguousMethod_07() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.concurrent.ExecutorService");
    _builder.newLine();
    _builder.append("class Bug {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(ExecutorService service) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("service.submit [ if (true) return null else null ]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testUnambiguousMethod_08() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.concurrent.ExecutorService");
    _builder.newLine();
    _builder.append("class Bug {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(ExecutorService service) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("service.submit []");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
}
