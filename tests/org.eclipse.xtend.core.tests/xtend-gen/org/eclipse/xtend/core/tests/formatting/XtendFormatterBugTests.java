package org.eclipse.xtend.core.tests.formatting;

import org.eclipse.xtend.core.tests.formatting.AbstractXtendFormatterTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.junit.Test;

@SuppressWarnings("all")
public class XtendFormatterBugTests extends AbstractXtendFormatterTest {
  @Test
  public void testBug398718() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def testVisibilityOfDispatchMethods() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("```");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("package foo;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("import java.util.Arrays;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("@SuppressWarnings(\"all\")");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("public class NoSuchElementException {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("```");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    String _decode = this.decode(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package foo");
    _builder_1.newLine();
    _builder_1.append("class bar {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def testVisibilityOfDispatchMethods() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("```");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("package foo;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("import java.util.Arrays;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("public class NoSuchElementException {");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t\t  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("```");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    String _decode_1 = this.decode(_builder_1);
    this.assertFormatted(_decode, _decode_1);
  }
  
  @Test
  public void testBug398625() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def modify(List<? extends MutableMethodDeclaration> annotatedMethods,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ModifyContext context) {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("setExceptions(\"42\", [])");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_builder);
  }
  
  @Test
  public void testBug398625_2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def modify(List<? extends MutableMethodDeclaration> annotatedMethods,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ModifyContext context) {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("setExceptions(\"42\")[]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_builder);
  }
  
  @Test
  public void testBug398625_3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def modify(List<? extends MutableMethodDeclaration> annotatedMethods,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ModifyContext context) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ctx = context");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("annotatedMethods.forEach[val type = addTypeParameter(\'A\')");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("addParameter(\'myParam\',");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("compilationUnit.typeReferenceProvider.newTypeReference(type))");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("setExceptions(");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("newArrayList(");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("compilationUnit.typeReferenceProvider.");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("newTypeReference(\'java.lang.Exception\')))[]]");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_builder);
  }
}
