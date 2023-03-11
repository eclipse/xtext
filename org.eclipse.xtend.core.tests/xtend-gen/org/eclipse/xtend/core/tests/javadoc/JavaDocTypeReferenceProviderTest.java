/**
 * Copyright (c) 2012, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.javadoc;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.documentation.IJavaDocTypeReferenceProvider;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class JavaDocTypeReferenceProviderTest extends AbstractXtendTestCase {
  @Inject
  private IJavaDocTypeReferenceProvider javaDocTypeReferenceProvider;

  @Test
  public void testComputation() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo");
      _builder.newLine();
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append("* {@link List}");
      _builder.newLine();
      _builder.append("* {@link String}");
      _builder.newLine();
      _builder.append("* {@link Integer");
      _builder.newLine();
      _builder.append("* {@link ArrayList}");
      _builder.newLine();
      _builder.append("*/");
      _builder.newLine();
      _builder.append("class Foo{}");
      _builder.newLine();
      final String input = _builder.toString();
      Resource _eResource = this.clazz(input).eResource();
      final XtextResource resource = ((XtextResource) _eResource);
      final ICompositeNode rootNode = resource.getParseResult().getRootNode();
      final List<ReplaceRegion> regions = this.javaDocTypeReferenceProvider.computeTypeRefRegions(rootNode);
      Assert.assertEquals(3, regions.size());
      Assert.assertEquals("List", IterableExtensions.<ReplaceRegion>head(regions).getText());
      Assert.assertEquals(input.indexOf("List"), IterableExtensions.<ReplaceRegion>head(regions).getOffset());
      Assert.assertEquals("List".length(), IterableExtensions.<ReplaceRegion>head(regions).getLength());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testComputation_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo");
      _builder.newLine();
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append("* {@link java.util.ArrayList @see Integer}");
      _builder.newLine();
      _builder.append("*/");
      _builder.newLine();
      _builder.append("class Foo{}");
      _builder.newLine();
      final String input = _builder.toString();
      Resource _eResource = this.clazz(input).eResource();
      final XtextResource resource = ((XtextResource) _eResource);
      final ICompositeNode rootNode = resource.getParseResult().getRootNode();
      final List<ReplaceRegion> regions = this.javaDocTypeReferenceProvider.computeTypeRefRegions(rootNode);
      Assert.assertEquals(1, regions.size());
      Assert.assertEquals("java.util.ArrayList", IterableExtensions.<ReplaceRegion>head(regions).getText());
      Assert.assertEquals(input.indexOf("java.util.ArrayList"), IterableExtensions.<ReplaceRegion>head(regions).getOffset());
      Assert.assertEquals("java.util.ArrayList".length(), IterableExtensions.<ReplaceRegion>head(regions).getLength());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testComputation_3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo");
      _builder.newLine();
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append("* {@link java.util.ArrayList");
      _builder.newLine();
      _builder.append("*/");
      _builder.newLine();
      _builder.append("class Foo{}");
      _builder.newLine();
      final String input = _builder.toString();
      Resource _eResource = this.clazz(input).eResource();
      final XtextResource resource = ((XtextResource) _eResource);
      final ICompositeNode rootNode = resource.getParseResult().getRootNode();
      final List<ReplaceRegion> regions = this.javaDocTypeReferenceProvider.computeTypeRefRegions(rootNode);
      Assert.assertEquals(0, regions.size());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testComputation_4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo");
      _builder.newLine();
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append("* {@link java.util.ArrayList");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("class Foo{}");
      _builder.newLine();
      final String input = _builder.toString();
      Resource _eResource = this.clazz(input).eResource();
      final XtextResource resource = ((XtextResource) _eResource);
      final ICompositeNode rootNode = resource.getParseResult().getRootNode();
      final List<ReplaceRegion> regions = this.javaDocTypeReferenceProvider.computeTypeRefRegions(rootNode);
      Assert.assertEquals(0, regions.size());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testComputation_5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/**");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("* @param string - a fancy string");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("* @param anotherString-even more fancy");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("* @param zonk");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar(String string, String anotherString, Integer zonk){}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String input = _builder.toString();
      Resource _eResource = this.clazz(input).eResource();
      final XtextResource resource = ((XtextResource) _eResource);
      final ICompositeNode rootNode = resource.getParseResult().getRootNode();
      final List<ReplaceRegion> regions = this.javaDocTypeReferenceProvider.computeParameterTypeRefRegions(rootNode);
      Assert.assertEquals(3, regions.size());
      Assert.assertEquals("string", IterableExtensions.<ReplaceRegion>head(regions).getText());
      Assert.assertEquals(input.indexOf("string"), IterableExtensions.<ReplaceRegion>head(regions).getOffset());
      Assert.assertEquals("string".length(), IterableExtensions.<ReplaceRegion>head(regions).getLength());
      Assert.assertEquals("anotherString", regions.get(1).getText());
      Assert.assertEquals(input.indexOf("anotherString"), regions.get(1).getOffset());
      Assert.assertEquals("anotherString".length(), regions.get(1).getLength());
      Assert.assertEquals("zonk", regions.get(2).getText());
      Assert.assertEquals(input.indexOf("zonk"), regions.get(2).getOffset());
      Assert.assertEquals("zonk".length(), regions.get(2).getLength());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testComputation_6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo");
      _builder.newLine();
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append("* {@link }");
      _builder.newLine();
      _builder.append("* @see");
      _builder.newLine();
      _builder.append("* @see");
      _builder.newLine();
      _builder.append("* {@link}");
      _builder.newLine();
      _builder.append("*/");
      _builder.newLine();
      _builder.append("class Foo{}");
      _builder.newLine();
      final String input = _builder.toString();
      Resource _eResource = this.clazz(input).eResource();
      final XtextResource resource = ((XtextResource) _eResource);
      final ICompositeNode rootNode = resource.getParseResult().getRootNode();
      final List<ReplaceRegion> regions = this.javaDocTypeReferenceProvider.computeTypeRefRegions(rootNode);
      Assert.assertEquals(0, regions.size());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testComputation_7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo");
      _builder.newLine();
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append("* {@link    String}");
      _builder.newLine();
      _builder.append("*/");
      _builder.newLine();
      _builder.append("class Foo{}");
      _builder.newLine();
      final String input = _builder.toString();
      Resource _eResource = this.clazz(input).eResource();
      final XtextResource resource = ((XtextResource) _eResource);
      final ICompositeNode rootNode = resource.getParseResult().getRootNode();
      final List<ReplaceRegion> regions = this.javaDocTypeReferenceProvider.computeTypeRefRegions(rootNode);
      Assert.assertEquals(1, regions.size());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testComputation_8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo");
      _builder.newLine();
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append("* @see    String");
      _builder.newLine();
      _builder.append("*/");
      _builder.newLine();
      _builder.append("class Foo{}");
      _builder.newLine();
      final String input = _builder.toString();
      Resource _eResource = this.clazz(input).eResource();
      final XtextResource resource = ((XtextResource) _eResource);
      final ICompositeNode rootNode = resource.getParseResult().getRootNode();
      final List<ReplaceRegion> regions = this.javaDocTypeReferenceProvider.computeTypeRefRegions(rootNode);
      Assert.assertEquals(1, regions.size());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testComputation_9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo");
      _builder.newLine();
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append("* {@link    String #length()  }");
      _builder.newLine();
      _builder.append("*/");
      _builder.newLine();
      _builder.append("class Foo{}");
      _builder.newLine();
      final String input = _builder.toString();
      Resource _eResource = this.clazz(input).eResource();
      final XtextResource resource = ((XtextResource) _eResource);
      final ICompositeNode rootNode = resource.getParseResult().getRootNode();
      final List<ReplaceRegion> regions = this.javaDocTypeReferenceProvider.computeTypeRefRegions(rootNode);
      Assert.assertEquals(1, regions.size());
      Assert.assertEquals("String", IterableExtensions.<ReplaceRegion>head(regions).getText());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
