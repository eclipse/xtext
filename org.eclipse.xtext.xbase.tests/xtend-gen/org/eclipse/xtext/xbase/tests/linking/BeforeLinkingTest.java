/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.linking;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmFormalParameter;
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
      XExpression _head = IterableExtensions.<XExpression>head(block.getExpressions());
      final XVariableDeclaration assignment = ((XVariableDeclaration) _head);
      XExpression _right = assignment.getRight();
      final XClosure lambda = ((XClosure) _right);
      final JvmFormalParameter implicitParameter = IterableExtensions.<JvmFormalParameter>head(lambda.getImplicitFormalParameters());
      Assert.assertEquals("String", implicitParameter.getParameterType().getSimpleName());
      resource.update(0, 0, "");
      Assert.assertNull(implicitParameter.eResource());
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
      XExpression _last = IterableExtensions.<XExpression>last(block.getExpressions());
      final XFeatureCall toString = ((XFeatureCall) _last);
      XExpression _implicitReceiver = toString.getImplicitReceiver();
      final XFeatureCall implicitReceiver = ((XFeatureCall) _implicitReceiver);
      Assert.assertEquals("it", implicitReceiver.getFeature().getSimpleName());
      resource.update(0, 0, "");
      Assert.assertNull(this._reflectExtensions.<Object>get(toString, "implicitReceiver"));
      Assert.assertNotNull(toString.getImplicitReceiver());
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
      XExpression _last = IterableExtensions.<XExpression>last(block.getExpressions());
      final XFeatureCall unmodifiableView = ((XFeatureCall) _last);
      XExpression _implicitFirstArgument = unmodifiableView.getImplicitFirstArgument();
      final XFeatureCall implicitFirstArgument = ((XFeatureCall) _implicitFirstArgument);
      Assert.assertEquals("it", implicitFirstArgument.getFeature().getSimpleName());
      resource.update(0, 0, "");
      Assert.assertNull(this._reflectExtensions.<Object>get(unmodifiableView, "implicitFirstArgument"));
      Assert.assertNotNull(unmodifiableView.getImplicitFirstArgument());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
