/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.compiler;

import org.eclipse.xtend.core.tests.compiler.AbstractXtendCompilerTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class CompilerBug413138Test extends AbstractXtendCompilerTest {
  @Test
  public void test_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("StringRepository repository");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m()\t{");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("var string = repository.findByStringId(1L)");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("repository.save(string)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("public interface StringRepository extends GraphRepository<String> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def String findByStringId(Long id);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface GraphRepository<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <U extends T> U save(U entity);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def <U extends T> Iterable<U> save(Iterable<U> entities);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private StringRepository repository;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public String m() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("String _xblockexpression = null;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("{");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("String string = this.repository.findByStringId(Long.valueOf(1L));");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("_xblockexpression = this.repository.<String>save(string);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return _xblockexpression;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void test_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("StringRepository repository");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m()\t{");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("repository.save(#[])");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("public interface StringRepository extends GraphRepository<String> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def String findByStringId(Long id);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface GraphRepository<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <U extends T> U save(U entity);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def <U extends T> Iterable<U> save(Iterable<U> entities);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.Collections;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.CollectionLiterals;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private StringRepository repository;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Iterable<String> m() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return this.repository.<String>save(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList()));");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void test_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("CharSeqRepository repository");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m()\t{");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("repository.<String>save(newArrayList)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("public interface CharSeqRepository extends GraphRepository<CharSequence> {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface GraphRepository<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <U extends T> U save(U entity);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def <U extends T> Iterable<U> save(Iterable<U> entities);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.ArrayList;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.CollectionLiterals;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private CharSeqRepository repository;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Iterable<String> m() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return this.repository.<String>save(_newArrayList);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void test_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("CharSeqRepository repository");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m()\t{");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("repository.save(#[\'a\'])");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("public interface CharSeqRepository extends GraphRepository<CharSequence> {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface GraphRepository<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <U extends T> U save(U entity);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def <U extends T> Iterable<U> save(Iterable<U> entities);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.Collections;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.CollectionLiterals;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private CharSeqRepository repository;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Iterable<String> m() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return this.repository.<String>save(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(\"a\")));");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
}
