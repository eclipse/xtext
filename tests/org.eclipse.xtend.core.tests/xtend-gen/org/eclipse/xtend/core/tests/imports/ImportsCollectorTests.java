/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.imports;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.imports.ImportsAcceptor;
import org.eclipse.xtext.xbase.imports.ImportsCollector;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class ImportsCollectorTests extends AbstractXtendTestCase {
  @Inject
  private ImportsCollector importsCollector;
  
  @Test
  public void testSimpleName_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.io.Serializable");
    _builder.newLine();
    _builder.append("class C implements |Serializable {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasTypeImport(_builder, "java.io.Serializable");
  }
  
  @Test
  public void testSimpleName_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.io.Serializable");
    _builder.newLine();
    _builder.append("|class C implements Serializable {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasTypeImport(_builder, "java.io.Serializable");
  }
  
  @Test
  public void testJavadoc_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.io.Serializable");
    _builder.newLine();
    _builder.append("|class C  {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/** ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("* @see java.io.Serializable");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val l = null");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasTypeImport(_builder, "java.io.Serializable");
  }
  
  @Test
  public void testJavadoc_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.io.Serializable");
    _builder.newLine();
    _builder.append("class C  {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/** ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("* |@see java.io.Serializable|");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void doStuff(){}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasTypeImport(_builder, "java.io.Serializable");
  }
  
  @Test
  public void testSimpleConstructorCall() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.HashMap");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("|var h = new HashMap()|");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasTypeImport(_builder, "java.util.HashMap");
  }
  
  @Test
  public void testSimpleStaticImport() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import static com.google.common.base.Strings.isNullOrEmpty");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("|var h = isNullOrEmpty(\'\')|");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasStaticImport(_builder, "com.google.common.base.Strings.isNullOrEmpty");
  }
  
  @Test
  public void testWildcardStaticImport() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import static com.google.common.base.Strings.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("|var h = isNullOrEmpty(\'\')|");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasStaticImport(_builder, "com.google.common.base.Strings.isNullOrEmpty");
  }
  
  @Test
  public void testSimpleExtension() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import static extension com.google.common.base.Strings.isNullOrEmpty");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("|var h = \'\'.nullOrEmpty|");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasExtensionImport(_builder, "com.google.common.base.Strings.isNullOrEmpty");
  }
  
  @Test
  public void testLibExtension() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("|var h = \'\'.nullOrEmpty|");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasExtensionImport(_builder, "org.eclipse.xtext.xbase.lib.StringExtensions.isNullOrEmpty");
  }
  
  @Test
  public void testOperatorOverloading() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("|var h = \'1\'+\'2\'|");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasExtensionImport(_builder, "org.eclipse.xtext.xbase.lib.StringExtensions.operator_plus");
  }
  
  @Test
  public void testTypeLiteral() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Map");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("|var h = typeof(Map)|");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasTypeImport(_builder, "java.util.Map");
  }
  
  @Test
  public void testNestedType_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Map");
    _builder.newLine();
    _builder.append("class C implements |Map.Entry| {}");
    _builder.newLine();
    this.hasTypeImport(_builder, "java.util.Map");
  }
  
  @Test
  public void testNestedType_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Map.Entry");
    _builder.newLine();
    _builder.append("|class C implements Entry| {}");
    _builder.newLine();
    this.hasTypeImport(_builder, "java.util.Map$Entry");
  }
  
  @Test
  public void testNestedType_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Map");
    _builder.newLine();
    _builder.append("class C implements |Map$Entry| {}");
    _builder.newLine();
    this.hasTypeImport(_builder, "java.util.Map");
  }
  
  @Test
  public void testNestedTypeLiteral_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Map");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val entry = |typeof(Map.Entry)|");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasTypeImport(_builder, "java.util.Map");
  }
  
  @Test
  public void testNestedTypeLiteral_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Map.Entry");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val entry = |typeof(Entry)|");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasTypeImport(_builder, "java.util.Map$Entry");
  }
  
  @Test
  public void testTypeParameter_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.io.Serializable");
    _builder.newLine();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("abstract class C implements |List<Serializable>|{");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasTypeImport(_builder, "java.io.Serializable", "java.util.List");
  }
  
  @Test
  public void testTypeParameter_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.io.Serializable");
    _builder.newLine();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("abstract class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("|val v = null as List<Serializable>|");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasTypeImport(_builder, "java.io.Serializable", "java.util.List");
  }
  
  @Test
  public void testAnnotation_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import com.google.common.eventbus.AllowConcurrentEvents");
    _builder.newLine();
    _builder.append("abstract class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("|@AllowConcurrentEvents");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def int annotated(){");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}|");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasTypeImport(_builder, "com.google.common.eventbus.AllowConcurrentEvents");
  }
  
  private void hasTypeImport(final CharSequence xtendFile, final String... typeNames) {
    final Function1<ImportsAcceptor.DefaultImportsAcceptor, Set<String>> _function = new Function1<ImportsAcceptor.DefaultImportsAcceptor, Set<String>>() {
      public Set<String> apply(final ImportsAcceptor.DefaultImportsAcceptor ia) {
        return ia.getTypes();
      }
    };
    this.has(xtendFile, _function, typeNames);
  }
  
  private void has(final CharSequence xtendFile, final Function1<? super ImportsAcceptor.DefaultImportsAcceptor, ? extends Set<String>> set, final String... typeNames) {
    try {
      String contentAsString = xtendFile.toString();
      int start = 0;
      int end = contentAsString.length();
      int selector = contentAsString.indexOf("|");
      if ((selector != (-1))) {
        start = selector;
        String _replaceFirst = contentAsString.replaceFirst("\\|", "");
        contentAsString = _replaceFirst;
        int _indexOf = contentAsString.indexOf("|");
        selector = _indexOf;
        int _length = contentAsString.length();
        end = _length;
        if ((selector != (-1))) {
          end = selector;
          String _replaceFirst_1 = contentAsString.replaceFirst("\\|", "");
          contentAsString = _replaceFirst_1;
        }
      }
      XtendFile _file = this.file(contentAsString);
      final Resource resource = _file.eResource();
      final ImportsAcceptor.DefaultImportsAcceptor acceptor = new ImportsAcceptor.DefaultImportsAcceptor();
      this.importsCollector.collectImports(((XtextResource) resource), start, (start + end), acceptor);
      final Set<String> actual = set.apply(acceptor);
      Set<String> _set = IterableExtensions.<String>toSet(((Iterable<String>)Conversions.doWrapArray(typeNames)));
      Assert.assertEquals(_set, actual);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private void hasExtensionImport(final CharSequence xtendFile, final String... typeNames) {
    final Function1<ImportsAcceptor.DefaultImportsAcceptor, Set<String>> _function = new Function1<ImportsAcceptor.DefaultImportsAcceptor, Set<String>>() {
      public Set<String> apply(final ImportsAcceptor.DefaultImportsAcceptor it) {
        return it.getExtensions();
      }
    };
    this.has(xtendFile, _function, typeNames);
  }
  
  private void hasStaticImport(final CharSequence xtendFile, final String... typeNames) {
    final Function1<ImportsAcceptor.DefaultImportsAcceptor, Set<String>> _function = new Function1<ImportsAcceptor.DefaultImportsAcceptor, Set<String>>() {
      public Set<String> apply(final ImportsAcceptor.DefaultImportsAcceptor it) {
        return it.getStaticImport();
      }
    };
    this.has(xtendFile, _function, typeNames);
  }
}
