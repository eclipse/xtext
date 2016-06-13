package org.eclipse.xtext.idea.sdomain.idea.tests.structureview;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.idea.sdomain.idea.lang.SDomainFileType;
import org.eclipse.xtext.idea.tests.LightToolingTest;
import org.junit.Ignore;

/**
 * Fails in new Gradle build.
 * TODO Reactivate these tests
 */
@Ignore
@SuppressWarnings("all")
public class OutlineTest extends LightToolingTest {
  public OutlineTest() {
    super(SDomainFileType.INSTANCE);
  }
  
  public void testEmpty() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("aaa.sdomain");
    _builder.newLine();
    this.testStructureView("", _builder.toString());
  }
  
  public void testNamespace() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("a.b.c {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("aaa.sdomain");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("aaa");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("a.b.c");
    _builder_1.newLine();
    this.testStructureView(_builder.toString(), _builder_1.toString());
  }
  
  public void testEntity() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("Bar {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("aaa.sdomain");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("aaa");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("Foo");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("Bar");
    _builder_1.newLine();
    this.testStructureView(_builder.toString(), _builder_1.toString());
  }
  
  public void testDatatype() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("datatype Long");
    _builder.newLine();
    _builder.append("datatype String");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("aaa.sdomain");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("aaa");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("Long");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("String");
    _builder_1.newLine();
    this.testStructureView(_builder.toString(), _builder_1.toString());
  }
  
  public void testImport() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import java.lang.*");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("entity Foo {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String name");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Long age");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("java.lang {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("datatype Long");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("datatype String");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("aaa.sdomain");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("aaa");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("foo");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("java.lang.*");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("Foo");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("name");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("age");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("java.lang");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("Long");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("String");
    _builder_1.newLine();
    this.testStructureView(_builder.toString(), _builder_1.toString());
  }
}
