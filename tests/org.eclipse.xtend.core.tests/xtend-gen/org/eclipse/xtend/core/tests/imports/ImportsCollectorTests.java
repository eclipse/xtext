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
import org.eclipse.xtext.util.TextRegion;
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
  public void testUnknownType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C implements |Serializable {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertTypeImport(_builder);
  }
  
  @Test
  public void testPackageSelected() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("|package foo");
    _builder.newLine();
    _builder.append("import java.io.Serializable");
    _builder.newLine();
    _builder.append("class C implements Serializable| {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertTypeImport(_builder, "java.io.Serializable");
  }
  
  @Test
  public void testImportSelected() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("|package foo");
    _builder.newLine();
    _builder.append("import java.io.Serializable|");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertTypeImport(_builder);
  }
  
  @Test
  public void testSimpleName_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.io.Serializable");
    _builder.newLine();
    _builder.append("class C implements |Serializable {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertTypeImport(_builder, "java.io.Serializable");
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
    this.assertTypeImport(_builder, "java.io.Serializable");
  }
  
  @Test
  public void testSimpleName_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import com.google.common.base.Strings");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("|var h = Strings::isNullOrEmpty(\'\')|");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ImportsAcceptor.DefaultImportsAcceptor _assertTypeImport = this.assertTypeImport(_builder, "com.google.common.base.Strings");
    ImportsAcceptor.DefaultImportsAcceptor _assertStaticImport = this.assertStaticImport(_assertTypeImport);
    this.assertExtensionImport(_assertStaticImport);
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
    _builder.append("* @see java.util.List - fqn doesn\'t need an import");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("* @see Serializable");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val l = null");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertTypeImport(_builder, "java.io.Serializable");
  }
  
  @Test
  public void testJavadoc_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.io.Serializable");
    _builder.newLine();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("import javax.sound.sampled.Line");
    _builder.newLine();
    _builder.append("class C  {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/** ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("* {@link Line}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("* @see List");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("* @see |Serializable|");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void doStuff(){}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ImportsAcceptor.DefaultImportsAcceptor _assertTypeImport = this.assertTypeImport(_builder, "java.io.Serializable");
    ImportsAcceptor.DefaultImportsAcceptor _assertStaticImport = this.assertStaticImport(_assertTypeImport);
    this.assertExtensionImport(_assertStaticImport);
  }
  
  @Test
  public void testJavadoc_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.io.Serializable");
    _builder.newLine();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("import javax.sound.sampled.Line");
    _builder.newLine();
    _builder.append("class C  {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/** ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("* @see |List");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("* {@link Line}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("* @see java.io.Serializable|");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void doStuff(){}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ImportsAcceptor.DefaultImportsAcceptor _assertTypeImport = this.assertTypeImport(_builder, "java.util.List", "javax.sound.sampled.Line");
    ImportsAcceptor.DefaultImportsAcceptor _assertStaticImport = this.assertStaticImport(_assertTypeImport);
    this.assertExtensionImport(_assertStaticImport);
  }
  
  @Test
  public void testJavadoc_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.io.Serializable");
    _builder.newLine();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("class C  {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/** ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("* @see List");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("* @see java.io.Serializable");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("|def void doStuff(){}|");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ImportsAcceptor.DefaultImportsAcceptor _assertTypeImport = this.assertTypeImport(_builder);
    ImportsAcceptor.DefaultImportsAcceptor _assertStaticImport = this.assertStaticImport(_assertTypeImport);
    this.assertExtensionImport(_assertStaticImport);
  }
  
  @Test
  public void testSimpleConstructorCall() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.HashMap");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("|var Object h = new HashMap()|");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertTypeImport(_builder, "java.lang.Object", "java.util.HashMap");
  }
  
  @Test
  public void testSimpleStaticImport_02() {
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
    ImportsAcceptor.DefaultImportsAcceptor _assertStaticImport = this.assertStaticImport(_builder, "com.google.common.base.Strings.isNullOrEmpty");
    ImportsAcceptor.DefaultImportsAcceptor _assertTypeImport = this.assertTypeImport(_assertStaticImport);
    this.assertExtensionImport(_assertTypeImport);
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
    this.assertStaticImport(_builder, "com.google.common.base.Strings.isNullOrEmpty");
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
    this.assertExtensionImport(_builder, "com.google.common.base.Strings.isNullOrEmpty");
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
    this.assertExtensionImport(_builder, "org.eclipse.xtext.xbase.lib.StringExtensions.isNullOrEmpty");
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
    this.assertExtensionImport(_builder, "org.eclipse.xtext.xbase.lib.StringExtensions.operator_plus");
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
    this.assertTypeImport(_builder, "java.util.Map");
  }
  
  @Test
  public void testNestedType_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Map");
    _builder.newLine();
    _builder.append("class C implements |Map.Entry| {}");
    _builder.newLine();
    this.assertTypeImport(_builder, "java.util.Map");
  }
  
  @Test
  public void testNestedType_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Map.Entry");
    _builder.newLine();
    _builder.append("|class C implements Entry| {}");
    _builder.newLine();
    this.assertTypeImport(_builder, "java.util.Map.Entry");
  }
  
  @Test
  public void testNestedType_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Map");
    _builder.newLine();
    _builder.append("class C implements |Map$Entry| {}");
    _builder.newLine();
    this.assertTypeImport(_builder, "java.util.Map");
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
    this.assertTypeImport(_builder, "java.util.Map");
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
    this.assertTypeImport(_builder, "java.util.Map.Entry");
  }
  
  @Test
  public void testNestedTypeLiteral_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Map");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val entry = |Map.Entry|");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertTypeImport(_builder, "java.util.Map");
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
    this.assertTypeImport(_builder, "java.io.Serializable", "java.util.List");
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
    this.assertTypeImport(_builder, "java.io.Serializable", "java.util.List");
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
    this.assertTypeImport(_builder, "com.google.common.eventbus.AllowConcurrentEvents");
  }
  
  @Test
  public void testEnum_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import javax.annotation.Resource");
    _builder.newLine();
    _builder.append("import static javax.annotation.Resource.AuthenticationType.*");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("|val en =  CONTAINER");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("var en2 = Resource.AuthenticationType.APPLICATION|");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ImportsAcceptor.DefaultImportsAcceptor _assertTypeImport = this.assertTypeImport(_builder, "javax.annotation.Resource");
    ImportsAcceptor.DefaultImportsAcceptor _assertStaticImport = this.assertStaticImport(_assertTypeImport, 
      "javax.annotation.Resource.AuthenticationType.CONTAINER");
    this.assertExtensionImport(_assertStaticImport);
  }
  
  @Test
  public void testAnonymousClass_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.ArrayList");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("|val l = new ArrayList() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("override clear() {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("super.clear()");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}|");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ImportsAcceptor.DefaultImportsAcceptor _assertTypeImport = this.assertTypeImport(_builder, "java.util.ArrayList");
    ImportsAcceptor.DefaultImportsAcceptor _assertStaticImport = this.assertStaticImport(_assertTypeImport);
    this.assertExtensionImport(_assertStaticImport);
  }
  
  @Test
  public void testAnonymousClass_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.ArrayList");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static String foo");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("|val l = new ArrayList() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("override clear() {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("val i = foo");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("super.clear()");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}|");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ImportsAcceptor.DefaultImportsAcceptor _assertTypeImport = this.assertTypeImport(_builder, "java.util.ArrayList");
    ImportsAcceptor.DefaultImportsAcceptor _assertStaticImport = this.assertStaticImport(_assertTypeImport, "C.foo");
    this.assertExtensionImport(_assertStaticImport);
  }
  
  @Test
  public void testImplicitReciever_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("|def void doStuff(String it) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return substring(length)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("|");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ImportsAcceptor.DefaultImportsAcceptor _assertTypeImport = this.assertTypeImport(_builder, "java.lang.String");
    ImportsAcceptor.DefaultImportsAcceptor _assertStaticImport = this.assertStaticImport(_assertTypeImport);
    this.assertExtensionImport(_assertStaticImport);
  }
  
  private ImportsAcceptor.DefaultImportsAcceptor assertTypeImport(final CharSequence xtendFile, final String... typeNames) {
    ImportsAcceptor.DefaultImportsAcceptor _collect = this.collect(xtendFile);
    return this.assertTypeImport(_collect, typeNames);
  }
  
  private ImportsAcceptor.DefaultImportsAcceptor assertTypeImport(final ImportsAcceptor.DefaultImportsAcceptor acceptor, final String... typeNames) {
    final Function1<ImportsAcceptor.DefaultImportsAcceptor, Set<String>> _function = new Function1<ImportsAcceptor.DefaultImportsAcceptor, Set<String>>() {
      @Override
      public Set<String> apply(final ImportsAcceptor.DefaultImportsAcceptor it) {
        return acceptor.getTypes();
      }
    };
    return this.has(acceptor, _function, typeNames);
  }
  
  private ImportsAcceptor.DefaultImportsAcceptor assertExtensionImport(final CharSequence xtendFile, final String... typeNames) {
    ImportsAcceptor.DefaultImportsAcceptor _collect = this.collect(xtendFile);
    return this.assertExtensionImport(_collect, typeNames);
  }
  
  private ImportsAcceptor.DefaultImportsAcceptor assertExtensionImport(final ImportsAcceptor.DefaultImportsAcceptor acceptor, final String... typeNames) {
    final Function1<ImportsAcceptor.DefaultImportsAcceptor, Set<String>> _function = new Function1<ImportsAcceptor.DefaultImportsAcceptor, Set<String>>() {
      @Override
      public Set<String> apply(final ImportsAcceptor.DefaultImportsAcceptor it) {
        return acceptor.getExtensions();
      }
    };
    return this.has(acceptor, _function, typeNames);
  }
  
  private ImportsAcceptor.DefaultImportsAcceptor assertStaticImport(final CharSequence xtendFile, final String... typeNames) {
    ImportsAcceptor.DefaultImportsAcceptor _collect = this.collect(xtendFile);
    return this.assertStaticImport(_collect, typeNames);
  }
  
  private ImportsAcceptor.DefaultImportsAcceptor assertStaticImport(final ImportsAcceptor.DefaultImportsAcceptor acceptor, final String... typeNames) {
    final Function1<ImportsAcceptor.DefaultImportsAcceptor, Set<String>> _function = new Function1<ImportsAcceptor.DefaultImportsAcceptor, Set<String>>() {
      @Override
      public Set<String> apply(final ImportsAcceptor.DefaultImportsAcceptor it) {
        return acceptor.getStaticImport();
      }
    };
    return this.has(acceptor, _function, typeNames);
  }
  
  private ImportsAcceptor.DefaultImportsAcceptor has(final ImportsAcceptor.DefaultImportsAcceptor acceptor, final Function1<? super ImportsAcceptor.DefaultImportsAcceptor, ? extends Set<String>> getter, final String... typeNames) {
    Set<String> _set = IterableExtensions.<String>toSet(((Iterable<String>)Conversions.doWrapArray(typeNames)));
    Set<String> _apply = getter.apply(acceptor);
    Assert.assertEquals(_set, _apply);
    return acceptor;
  }
  
  private ImportsAcceptor.DefaultImportsAcceptor collect(final CharSequence xtendFile) {
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
      TextRegion _textRegion = new TextRegion(start, (end - start));
      this.importsCollector.collectImports(((XtextResource) resource), _textRegion, acceptor);
      return acceptor;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
