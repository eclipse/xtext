/**
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.macro;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.junit.Test;

/**
 * @author Christian Dietrich - Initial contribution and API
 */
@SuppressWarnings("all")
public class AnnotationPropertyTest extends AbstractActiveAnnotationTest {
  @Test
  public void testAnnotationProperty_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@org.eclipse.xtend.core.tests.macro.ToAnno()");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("MULTIPLE FILES WERE GENERATED");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("File 1 : /myProject/xtend-gen/C.java");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtend.core.tests.macro.ToAnno;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@ToAnno");
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("File 2 : /myProject/xtend-gen/CAnno.java");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public @interface CAnno {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("/**");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("* Best building strategy game ever");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public int anno() default 1602;");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    this._xtendCompilerTester.assertCompilesTo(_builder, _builder_1);
  }

  @Test
  public void testAnnotationProperty_2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@org.eclipse.xtend.core.tests.macro.ToAnno(defaultValue=false)");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("MULTIPLE FILES WERE GENERATED");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("File 1 : /myProject/xtend-gen/C.java");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtend.core.tests.macro.ToAnno;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@ToAnno(defaultValue = false)");
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("File 2 : /myProject/xtend-gen/CAnno.java");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public @interface CAnno {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("/**");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("* Best building strategy game ever");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public int anno();");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    this._xtendCompilerTester.assertCompilesTo(_builder, _builder_1);
  }
}
