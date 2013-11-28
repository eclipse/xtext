/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.conversion;

import org.eclipse.emf.common.util.EList;
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
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
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
    EList<Resource.Diagnostic> _errors = resource.getErrors();
    int _size = _errors.size();
    Assert.assertEquals(1, _size);
    EList<Resource.Diagnostic> _errors_1 = resource.getErrors();
    final Resource.Diagnostic error = IterableExtensions.<Resource.Diagnostic>head(_errors_1);
    Assert.assertNotNull(error);
    String _message = error.getMessage();
    Assert.assertEquals("String literal is not closed", _message);
    this.assertLiteral("", resource);
  }
  
  @Test
  public void testUnclosedTerminal_02() throws Exception {
    final Resource resource = this.toResource("class C { def m() \'\'\'abc");
    EList<Resource.Diagnostic> _errors = resource.getErrors();
    int _size = _errors.size();
    Assert.assertEquals(1, _size);
    EList<Resource.Diagnostic> _errors_1 = resource.getErrors();
    final Resource.Diagnostic error = IterableExtensions.<Resource.Diagnostic>head(_errors_1);
    Assert.assertNotNull(error);
    String _message = error.getMessage();
    Assert.assertEquals("String literal is not closed", _message);
    this.assertLiteral("abc", resource);
  }
  
  private void assertLiteral(final String expectation, final Resource resource) {
    EList<EObject> _contents = resource.getContents();
    EObject _head = IterableExtensions.<EObject>head(_contents);
    final XtendFile file = ((XtendFile) _head);
    EList<XtendTypeDeclaration> _xtendTypes = file.getXtendTypes();
    final XtendTypeDeclaration type = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
    EList<XtendMember> _members = type.getMembers();
    XtendMember _head_1 = IterableExtensions.<XtendMember>head(_members);
    final XtendFunction method = ((XtendFunction) _head_1);
    XExpression _expression = method.getExpression();
    final RichString body = ((RichString) _expression);
    EList<XExpression> _expressions = body.getExpressions();
    XExpression _head_2 = IterableExtensions.<XExpression>head(_expressions);
    final RichStringLiteral singleElement = ((RichStringLiteral) _head_2);
    String _value = singleElement.getValue();
    Assert.assertEquals(expectation, _value);
  }
  
  private Resource toResource(final CharSequence input) throws Exception {
    XtextResourceSet _resourceSet = this.getResourceSet();
    URI _createURI = URI.createURI("abcdefg.xtend");
    final Resource resource = _resourceSet.createResource(_createURI);
    String _string = input.toString();
    StringInputStream _stringInputStream = new StringInputStream(_string);
    resource.load(_stringInputStream, null);
    return resource;
  }
}
