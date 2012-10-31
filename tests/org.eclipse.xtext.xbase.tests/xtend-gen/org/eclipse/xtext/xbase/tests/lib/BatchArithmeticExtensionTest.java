/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.lib;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage.Literals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.tests.lib.ArithmeticExtensionsTest;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

@SuppressWarnings("all")
public class BatchArithmeticExtensionTest extends ArithmeticExtensionsTest {
  @Inject
  private IBatchTypeResolver _iBatchTypeResolver;
  
  protected XExpression expression(final CharSequence string, final boolean resolve) throws Exception {
    XExpression _xifexpression = null;
    if (resolve) {
      final XExpression result = super.expression(string, false);
      this._iBatchTypeResolver.resolveTypes(result);
      return result;
    } else {
      XExpression _expression = super.expression(string, resolve);
      _xifexpression = _expression;
    }
    return _xifexpression;
  }
  
  protected void assertOnlyPrimitveOperationsBound(final XExpression expression) {
    List<XAbstractFeatureCall> _eAllOfType = EcoreUtil2.<XAbstractFeatureCall>eAllOfType(expression, XAbstractFeatureCall.class);
    final Procedure1<XAbstractFeatureCall> _function = new Procedure1<XAbstractFeatureCall>() {
        public void apply(final XAbstractFeatureCall it) {
          Object _eGet = it.eGet(Literals.XABSTRACT_FEATURE_CALL__FEATURE, false);
          final JvmIdentifiableElement feature = ((JvmIdentifiableElement) _eGet);
          boolean _eIsProxy = feature.eIsProxy();
          Assert.assertFalse(_eIsProxy);
        }
      };
    IterableExtensions.<XAbstractFeatureCall>forEach(_eAllOfType, _function);
    super.assertOnlyPrimitveOperationsBound(expression);
  }
  
  @Ignore
  @Test(timeout = 400)
  public void testManyOperations_01() throws Exception {
    final XExpression expression = this.expression("{-1+2**3*4/5%6<9+-1+2**3*4/5%6<9+-1+2**3*4/5%6<9-1+2**3*4/5%6<9-1+2**3*4/5%6<9-1+2**3*4/5%6<9}", true);
    this.assertOnlyPrimitveOperationsBound(expression);
  }
}
