/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests.hover;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.ui.hover.JvmAnnotationReferencePrinter;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class JvmAnnotationReferencePrinterTest extends AbstractXtendUITestCase {
  public static class TestingJvmAnnotationValuePrinter extends JvmAnnotationReferencePrinter {
    @Override
    protected String createLinkWithLabel(final String scheme, final URI uri, final String label) {
      return (("!" + label) + "!");
    }
  }
  
  @Inject
  private JvmAnnotationReferencePrinterTest.TestingJvmAnnotationValuePrinter printer;
  
  @Test
  public void testPrintedAnnotationValue() {
    this.assertPrinted("@!SuppressWarnings!(\"all\")", "@SuppressWarnings(\"all\")");
  }
  
  @Test
  public void testPrintedAnnotationValue_01() {
    this.assertPrinted("@!SuppressWarnings!(\"all\")", "@SuppressWarnings(\'all\')");
  }
  
  @Test
  public void testPrintedAnnotationValue_02() {
    this.assertPrinted("@!SuppressWarnings!(42)", "@SuppressWarnings(42)");
  }
  
  @Test
  public void testPrintedAnnotationValue_03() {
    this.assertPrinted("@!SuppressWarnings!(true)", "@SuppressWarnings(true)");
  }
  
  @Test
  public void testPrintedAnnotationValue_04() {
    this.assertPrinted("@!SuppressWarnings!(false)", "@SuppressWarnings(false)");
  }
  
  @Test
  public void testPrintedAnnotationValue_05() {
    this.assertPrinted("@!SuppressWarnings!(#[true, false])", "@SuppressWarnings(#[true,false])");
  }
  
  @Test
  public void testPrintedAnnotationValue_06() {
    this.assertPrinted("@!SuppressWarnings!(#[!String!, !Integer!])", "@SuppressWarnings(#[String,Integer])");
  }
  
  @Test
  public void testPrintedAnnotationValue_07() {
    this.assertPrinted("@!Retention!(!RetentionPolicy!.!SOURCE!)", "@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)");
  }
  
  @Test
  public void testPrintedAnnotationValue_08() {
    this.assertPrinted("@!Generated!(!value!=\"foo\", !date!=\"bar\", !comments!=\"baz\")", "@javax.annotation.Generated(value=\"foo\", date=\"bar\", comments=\"baz\")");
  }
  
  @Test
  public void testPrintedAnnotationValue_09() {
    this.assertPrinted("@!XmlElements!(#[@!XmlElement!])", "@javax.xml.bind.annotation.XmlElements(#[@javax.xml.bind.annotation.XmlElement()])");
  }
  
  @Test
  public void testPrintedAnnotationValue_10() {
    this.assertPrinted("@!XmlElements!(@!XmlElement!)", "@javax.xml.bind.annotation.XmlElements(@javax.xml.bind.annotation.XmlElement())");
  }
  
  @Test
  public void testPrintedAnnotationValue_11() {
    this.assertPrinted("@!XmlElements!(#[@!XmlElement!(!nillable!=true), @!XmlElement!(!type!=!String![][])])", "@javax.xml.bind.annotation.XmlElements(@javax.xml.bind.annotation.XmlElement(nillable=true), @javax.xml.bind.annotation.XmlElement(type=typeof(String[][])))");
  }
  
  @Inject
  private WorkbenchTestHelper testHelper;
  
  @Inject
  private IResourceSetProvider resourceSetProvider;
  
  @Inject
  private ParseHelper<XtendFile> parseHelper;
  
  private void assertPrinted(final String expected, final String xtendCode) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(xtendCode);
      _builder.append(" class Foo {}");
      _builder.newLineIfNotEmpty();
      final XtendFile file = this.parseHelper.parse(_builder, this.resourceSetProvider.get(this.testHelper.getProject()));
      final JvmAnnotationReference annoVal = IterableExtensions.<JvmAnnotationReference>head(IterableExtensions.<JvmGenericType>head(Iterables.<JvmGenericType>filter(file.eResource().getContents(), JvmGenericType.class)).getAnnotations());
      Assert.assertEquals(expected, this.printer.toHtmlString(annoVal));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
