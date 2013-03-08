package org.eclipse.xtend.core.tests.macro;

import org.eclipse.xtend.core.tests.macro.AbstractActiveAnnotationTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.junit.Test;

@SuppressWarnings("all")
public class HttpGetAnnotationTest extends AbstractActiveAnnotationTest {
  @Test
  public void testGetAnnotation() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.eclipse.xtend.core.tests.macro.Get");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class MyServlet {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Get(\"user/:id\") def findUser() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import org.eclipse.xtend.core.tests.macro.Get;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class MyServlet {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Get(\"user/:id\")");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Object findUser() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return null;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this._xtendCompilerTester.assertCompilesTo(_builder, _builder_1);
  }
}
