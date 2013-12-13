package org.eclipse.xtext.example.tutorial;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@SuppressWarnings("all")
public class TypesBuilderExercise {
  /**
   * The test helper allows to compile DSL code on the fly to Java.
   * We want to use its utility function
   * {@link CompilationTestHelper#assertCompilesTo(CharSequence, CharSequence) assertCompilesTo(..)}
   * to test drive the {@link TutorialJvmModelInferrer model inferrer}.
   */
  @Inject
  @Extension
  private CompilationTestHelper _compilationTestHelper;
  
  @Test
  public void testMe() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package tutorial");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import java.util.Date");
      _builder.newLine();
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* A simple entity to describe a Person");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("entity Person {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("firstName: String");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("lastName: String");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("birthday: Date");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package tutorial;");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("import java.util.Date;");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("/**");
      _builder_1.newLine();
      _builder_1.append(" ");
      _builder_1.append("* A simple entity to describe a Person");
      _builder_1.newLine();
      _builder_1.append(" ");
      _builder_1.append("*/");
      _builder_1.newLine();
      _builder_1.append("public class Person {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("private String firstName;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public String getFirstName() {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("return this.firstName;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public void setFirstName(final String firstName) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("this.firstName = firstName;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("private String lastName;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public String getLastName() {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("return this.lastName;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public void setLastName(final String lastName) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("this.lastName = lastName;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("private Date birthday;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public Date getBirthday() {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("return this.birthday;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public void setBirthday(final Date birthday) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("this.birthday = birthday;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this._compilationTestHelper.assertCompilesTo(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public TypesBuilderExercise() {
    System.setProperty("line.separator", "\n");
  }
}
