/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.conversion;

import com.google.common.collect.Iterators;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.RichString;
import org.eclipse.xtend.core.xtend.RichStringLiteral;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class ValueConverterExceptionProducesErrorTest extends AbstractXtendTestCase {
  @Test
  public void testUnclosedTerminal_01() throws Exception {
    final Resource resource = this.toResource("class C { def m() \'\'\'");
    Assert.assertEquals(1, resource.getErrors().size());
    final Resource.Diagnostic error = IterableExtensions.<Resource.Diagnostic>head(resource.getErrors());
    Assert.assertNotNull(error);
    Assert.assertEquals("String literal is not closed", error.getMessage());
    this.assertLiteral("", resource);
  }

  @Test
  public void testUnclosedTerminal_02() throws Exception {
    final Resource resource = this.toResource("class C { def m() \'\'\'abc");
    Assert.assertEquals(1, resource.getErrors().size());
    final Resource.Diagnostic error = IterableExtensions.<Resource.Diagnostic>head(resource.getErrors());
    Assert.assertNotNull(error);
    Assert.assertEquals("String literal is not closed", error.getMessage());
    this.assertLiteral("abc", resource);
  }

  /**
   * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=428525
   */
  @Test
  public void testInvalidUnicode() throws Exception {
    final Resource resource = this.toResource("class C { def m() {\'\\u\'.toString}}");
    EcoreUtil2.resolveAll(resource);
    Assert.assertEquals(1, resource.getErrors().size());
    final Resource.Diagnostic error = IterableExtensions.<Resource.Diagnostic>head(resource.getErrors());
    Assert.assertNotNull(error);
    Assert.assertEquals("Invalid unicode", error.getMessage());
    final XStringLiteral literal = IteratorExtensions.<XStringLiteral>head(Iterators.<XStringLiteral>filter(resource.getAllContents(), XStringLiteral.class));
    Assert.assertEquals("u", literal.getValue());
  }

  private void assertLiteral(final String expectation, final Resource resource) {
    EObject _head = IterableExtensions.<EObject>head(resource.getContents());
    final XtendFile file = ((XtendFile) _head);
    final XtendTypeDeclaration type = IterableExtensions.<XtendTypeDeclaration>head(file.getXtendTypes());
    XtendMember _head_1 = IterableExtensions.<XtendMember>head(type.getMembers());
    final XtendFunction method = ((XtendFunction) _head_1);
    XExpression _expression = method.getExpression();
    final RichString body = ((RichString) _expression);
    XExpression _head_2 = IterableExtensions.<XExpression>head(body.getExpressions());
    final RichStringLiteral singleElement = ((RichStringLiteral) _head_2);
    Assert.assertEquals(expectation, singleElement.getValue());
  }

  private Resource toResource(final CharSequence input) throws Exception {
    final Resource resource = this.getResourceSet().createResource(URI.createURI("abcdefg.xtend"));
    String _string = input.toString();
    StringInputStream _stringInputStream = new StringInputStream(_string);
    resource.load(_stringInputStream, null);
    return resource;
  }
}
