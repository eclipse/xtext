/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.linking;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions;
import org.eclipse.xtext.xbase.resource.BatchLinkableResource;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class BeforeLinkingTest extends AbstractXbaseTestCase {
  @Inject
  @Extension
  private ParseHelper<XExpression> _parseHelper;
  
  @Inject
  @Extension
  private ReflectExtensions _reflectExtensions;
  
  @Test
  public void testImplicitLambdaParameter() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val Comparable<String> c = [ length ]");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("c.toString");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XExpression _parse = this._parseHelper.parse(_builder);
      final XBlockExpression block = ((XBlockExpression) _parse);
      Resource _eResource = block.eResource();
      final BatchLinkableResource resource = ((BatchLinkableResource) _eResource);
      resource.resolveLazyCrossReferences(null);
      EList<XExpression> _expressions = block.getExpressions();
      XExpression _head = IterableExtensions.<XExpression>head(_expressions);
      final XVariableDeclaration assignment = ((XVariableDeclaration) _head);
      XExpression _right = assignment.getRight();
      final XClosure lambda = ((XClosure) _right);
      EList<JvmFormalParameter> _implicitFormalParameters = lambda.getImplicitFormalParameters();
      final JvmFormalParameter implicitParameter = IterableExtensions.<JvmFormalParameter>head(_implicitFormalParameters);
      JvmTypeReference _parameterType = implicitParameter.getParameterType();
      String _simpleName = _parameterType.getSimpleName();
      Assert.assertEquals("String", _simpleName);
      resource.update(0, 0, "");
      Resource _eResource_1 = implicitParameter.eResource();
      Assert.assertNull(_eResource_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testImplicitReceiver() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val it = \'\'");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("toString");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XExpression _parse = this._parseHelper.parse(_builder);
      final XBlockExpression block = ((XBlockExpression) _parse);
      Resource _eResource = block.eResource();
      final BatchLinkableResource resource = ((BatchLinkableResource) _eResource);
      EList<XExpression> _expressions = block.getExpressions();
      XExpression _last = IterableExtensions.<XExpression>last(_expressions);
      final XFeatureCall toString = ((XFeatureCall) _last);
      XExpression _implicitReceiver = toString.getImplicitReceiver();
      final XFeatureCall implicitReceiver = ((XFeatureCall) _implicitReceiver);
      JvmIdentifiableElement _feature = implicitReceiver.getFeature();
      String _simpleName = _feature.getSimpleName();
      Assert.assertEquals("it", _simpleName);
      resource.update(0, 0, "");
      Object _get = this._reflectExtensions.<Object>get(toString, "implicitReceiver");
      Assert.assertNull(_get);
      XExpression _implicitReceiver_1 = toString.getImplicitReceiver();
      Assert.assertNotNull(_implicitReceiver_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testImplicitFirstArgument() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val it = newArrayList");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("unmodifiableView");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XExpression _parse = this._parseHelper.parse(_builder);
      final XBlockExpression block = ((XBlockExpression) _parse);
      Resource _eResource = block.eResource();
      final BatchLinkableResource resource = ((BatchLinkableResource) _eResource);
      EList<XExpression> _expressions = block.getExpressions();
      XExpression _last = IterableExtensions.<XExpression>last(_expressions);
      final XFeatureCall unmodifiableView = ((XFeatureCall) _last);
      XExpression _implicitFirstArgument = unmodifiableView.getImplicitFirstArgument();
      final XFeatureCall implicitFirstArgument = ((XFeatureCall) _implicitFirstArgument);
      JvmIdentifiableElement _feature = implicitFirstArgument.getFeature();
      String _simpleName = _feature.getSimpleName();
      Assert.assertEquals("it", _simpleName);
      resource.update(0, 0, "");
      Object _get = this._reflectExtensions.<Object>get(unmodifiableView, "implicitFirstArgument");
      Assert.assertNull(_get);
      XExpression _implicitFirstArgument_1 = unmodifiableView.getImplicitFirstArgument();
      Assert.assertNotNull(_implicitFirstArgument_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
