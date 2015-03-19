/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
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
public class CompilerBug462260Test extends AbstractXtendCompilerTest {
  @Test
  public void test_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Set");
    _builder.newLine();
    _builder.append("import java.util.Map");
    _builder.newLine();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.newLine();
    _builder.append("abstract class Bug {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <E> Map<E, E> graph(Set<E> vertices, Map<E, List<E>> edges)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def test() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("graph(#{\"a\"}, #{\"a\" -> #[\"b\"]})");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.Collections;");
    _builder_1.newLine();
    _builder_1.append("import java.util.List;");
    _builder_1.newLine();
    _builder_1.append("import java.util.Map;");
    _builder_1.newLine();
    _builder_1.append("import java.util.Set;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.CollectionLiterals;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.Pair;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public abstract class Bug {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public abstract <E extends Object> Map<E, E> graph(final Set<E> vertices, final Map<E, List<E>> edges);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Map<String, String> test() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Pair<String, List<String>> _mappedTo = Pair.<String, List<String>>of(\"a\", Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(\"b\")));");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return this.<String>graph(Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet(\"a\")), Collections.<String, List<String>>unmodifiableMap(CollectionLiterals.<String, List<String>>newHashMap(_mappedTo)));");
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
    _builder.append("import java.util.Set");
    _builder.newLine();
    _builder.append("import java.util.Map");
    _builder.newLine();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.newLine();
    _builder.append("abstract class Bug {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <E> Map<E, E> graph(Set<E> vertices, Map<E, List<E>> edges)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def test() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("graph(#{}, #{})");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.Collections;");
    _builder_1.newLine();
    _builder_1.append("import java.util.List;");
    _builder_1.newLine();
    _builder_1.append("import java.util.Map;");
    _builder_1.newLine();
    _builder_1.append("import java.util.Set;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.CollectionLiterals;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public abstract class Bug {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public abstract <E extends Object> Map<E, E> graph(final Set<E> vertices, final Map<E, List<E>> edges);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Map<Object, Object> test() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return this.<Object>graph(Collections.<Object>unmodifiableSet(CollectionLiterals.<Object>newHashSet()), Collections.<Object, List<Object>>unmodifiableMap(CollectionLiterals.<Object, List<Object>>newHashMap()));");
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
    _builder.append("import java.util.Set");
    _builder.newLine();
    _builder.append("import java.util.Map");
    _builder.newLine();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.newLine();
    _builder.append("abstract class Bug {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <E, M extends Map<E, List<E>>> Map<E, E> graph(Set<E> vertices, M edges)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def test() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("graph(#{\"a\"}, #{\"a\" -> #[\"b\"]})");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.Collections;");
    _builder_1.newLine();
    _builder_1.append("import java.util.List;");
    _builder_1.newLine();
    _builder_1.append("import java.util.Map;");
    _builder_1.newLine();
    _builder_1.append("import java.util.Set;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.CollectionLiterals;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.Pair;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public abstract class Bug {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public abstract <E extends Object, M extends Map<E, List<E>>> Map<E, E> graph(final Set<E> vertices, final M edges);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Map<String, String> test() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Pair<String, List<String>> _mappedTo = Pair.<String, List<String>>of(\"a\", Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(\"b\")));");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return this.<String, Map<String, List<String>>>graph(Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet(\"a\")), Collections.<String, List<String>>unmodifiableMap(CollectionLiterals.<String, List<String>>newHashMap(_mappedTo)));");
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
    _builder.append("import java.util.Set");
    _builder.newLine();
    _builder.append("import java.util.Map");
    _builder.newLine();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.newLine();
    _builder.append("abstract class Bug {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <E, M extends Map<E, List<E>>> Map<E, E> graph(Set<E> vertices, M edges)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def test() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("graph(#{}, #{})");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.Collections;");
    _builder_1.newLine();
    _builder_1.append("import java.util.List;");
    _builder_1.newLine();
    _builder_1.append("import java.util.Map;");
    _builder_1.newLine();
    _builder_1.append("import java.util.Set;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.CollectionLiterals;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public abstract class Bug {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public abstract <E extends Object, M extends Map<E, List<E>>> Map<E, E> graph(final Set<E> vertices, final M edges);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Map<Object, Object> test() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return this.<Object, Map<Object, List<Object>>>graph(Collections.<Object>unmodifiableSet(CollectionLiterals.<Object>newHashSet()), Collections.<Object, List<Object>>unmodifiableMap(CollectionLiterals.<Object, List<Object>>newHashMap()));");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void test_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Set");
    _builder.newLine();
    _builder.append("import java.util.Map");
    _builder.newLine();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.newLine();
    _builder.append("abstract class Bug {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <E> void graph(E e1, E e2)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def test() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("graph(newHashMap, #{})");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.Collections;");
    _builder_1.newLine();
    _builder_1.append("import java.util.HashMap;");
    _builder_1.newLine();
    _builder_1.append("import java.util.Map;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.CollectionLiterals;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public abstract class Bug {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public abstract <E extends Object> void graph(final E e1, final E e2);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void test() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("HashMap<Object, Object> _newHashMap = CollectionLiterals.<Object, Object>newHashMap();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("this.<Map<Object, Object>>graph(_newHashMap, Collections.<Object, Object>unmodifiableMap(CollectionLiterals.<Object, Object>newHashMap()));");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
}
