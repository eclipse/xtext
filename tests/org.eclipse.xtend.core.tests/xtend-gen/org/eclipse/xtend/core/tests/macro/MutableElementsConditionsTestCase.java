/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.macro;

import org.eclipse.xtend.core.tests.macro.AbstractActiveAnnotationTest;
import org.eclipse.xtend.core.tests.macro.CheckMutableClassDeclaration;
import org.eclipse.xtend.core.tests.macro.CheckMutableEnumerationTypeDeclaration;
import org.eclipse.xtend.core.tests.macro.CheckMutableFieldDeclaration;
import org.eclipse.xtend.core.tests.macro.CheckMutableInterfaceDeclaration;
import org.eclipse.xtend.core.tests.macro.CheckMutableMethodDeclaration;
import org.eclipse.xtend.core.tests.macro.CheckMutableParameterDeclaration;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.junit.Test;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class MutableElementsConditionsTestCase extends AbstractActiveAnnotationTest {
  @Test
  public void checkMutableClassDeclaration() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@");
    String _name = CheckMutableClassDeclaration.class.getName();
    _builder.append(_name, "");
    _builder.append(" class Foo {}");
    _builder.newLineIfNotEmpty();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("MULTIPLE FILES WERE GENERATED");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("File 1 : Foo.java");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import ");
    String _name_1 = CheckMutableClassDeclaration.class.getName();
    _builder_1.append(_name_1, "");
    _builder_1.append(";");
    _builder_1.newLineIfNotEmpty();
    _builder_1.newLine();
    _builder_1.append("@");
    String _simpleName = CheckMutableClassDeclaration.class.getSimpleName();
    _builder_1.append(_simpleName, "");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Foo<foo> {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("File 2 : foo/Bar.java");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("package foo;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Bar {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("File 3 : foo/Bar2.java");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("package foo;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("public @interface Bar2 {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("File 4 : foo/Bar3.java");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("package foo;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public enum Bar3 {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("File 5 : foo/Bar4.java");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("package foo;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public interface Bar4 {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    this._xtendCompilerTester.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void checkMutableInterfaceDeclaration() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@");
    String _name = CheckMutableInterfaceDeclaration.class.getName();
    _builder.append(_name, "");
    _builder.append(" interface Foo {}");
    _builder.newLineIfNotEmpty();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import ");
    String _name_1 = CheckMutableInterfaceDeclaration.class.getName();
    _builder_1.append(_name_1, "");
    _builder_1.append(";");
    _builder_1.newLineIfNotEmpty();
    _builder_1.newLine();
    _builder_1.append("@");
    String _simpleName = CheckMutableInterfaceDeclaration.class.getSimpleName();
    _builder_1.append(_simpleName, "");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public interface Foo {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this._xtendCompilerTester.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void checkMutableMethodDeclaration() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@");
    String _name = CheckMutableMethodDeclaration.class.getName();
    _builder.append(_name, "\t");
    _builder.append(" def void foo () {}");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import ");
    String _name_1 = CheckMutableMethodDeclaration.class.getName();
    _builder_1.append(_name_1, "");
    _builder_1.append(";");
    _builder_1.newLineIfNotEmpty();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Foo {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@");
    String _simpleName = CheckMutableMethodDeclaration.class.getSimpleName();
    _builder_1.append(_simpleName, "  ");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("  ");
    _builder_1.append("public void foo() {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this._xtendCompilerTester.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void checkMutableFieldDeclaration() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@");
    String _name = CheckMutableFieldDeclaration.class.getName();
    _builder.append(_name, "\t");
    _builder.append(" Object foo");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import ");
    String _name_1 = CheckMutableFieldDeclaration.class.getName();
    _builder_1.append(_name_1, "");
    _builder_1.append(";");
    _builder_1.newLineIfNotEmpty();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Foo {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@");
    String _simpleName = CheckMutableFieldDeclaration.class.getSimpleName();
    _builder_1.append(_simpleName, "  ");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("  ");
    _builder_1.append("private Object foo;");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this._xtendCompilerTester.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void checkMutableParameterDeclaration() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void foo (@");
    String _name = CheckMutableParameterDeclaration.class.getName();
    _builder.append(_name, "\t");
    _builder.append(" Object foo) {}");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import ");
    String _name_1 = CheckMutableParameterDeclaration.class.getName();
    _builder_1.append(_name_1, "");
    _builder_1.append(";");
    _builder_1.newLineIfNotEmpty();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Foo {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void foo(@");
    String _simpleName = CheckMutableParameterDeclaration.class.getSimpleName();
    _builder_1.append(_simpleName, "  ");
    _builder_1.append(" final Object foo) {");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this._xtendCompilerTester.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void checkMutableEnumerationTypeDeclaration() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@");
    String _name = CheckMutableEnumerationTypeDeclaration.class.getName();
    _builder.append(_name, "");
    _builder.newLineIfNotEmpty();
    _builder.append("enum Foo {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import ");
    String _name_1 = CheckMutableEnumerationTypeDeclaration.class.getName();
    _builder_1.append(_name_1, "");
    _builder_1.append(";");
    _builder_1.newLineIfNotEmpty();
    _builder_1.newLine();
    _builder_1.append("@");
    String _simpleName = CheckMutableEnumerationTypeDeclaration.class.getSimpleName();
    _builder_1.append(_simpleName, "");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public enum Foo {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("A;");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this._xtendCompilerTester.assertCompilesTo(_builder, _builder_1);
  }
}
