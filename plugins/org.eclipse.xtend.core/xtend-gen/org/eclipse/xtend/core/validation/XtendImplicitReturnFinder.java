/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.validation;

import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtend.core.xtend.AnonymousClass;
import org.eclipse.xtend.core.xtend.RichString;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XCollectionLiteral;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XInstanceOfExpression;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XSynchronizedExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.validation.XbaseImplicitReturnFinder;

/**
 * @author Stefan Oehme - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendImplicitReturnFinder extends XbaseImplicitReturnFinder {
  protected List<? extends XExpression> _findImplicitReturns(final AnonymousClass expression) {
    return Collections.<AnonymousClass>unmodifiableList(Lists.<AnonymousClass>newArrayList(expression));
  }
  
  protected List<? extends XExpression> _findImplicitReturns(final RichString expression) {
    return Collections.<RichString>unmodifiableList(Lists.<RichString>newArrayList(expression));
  }
  
  public List<? extends XExpression> findImplicitReturns(final XExpression expression) {
    if (expression instanceof AnonymousClass) {
      return _findImplicitReturns((AnonymousClass)expression);
    } else if (expression instanceof RichString) {
      return _findImplicitReturns((RichString)expression);
    } else if (expression instanceof XAbstractFeatureCall) {
      return _findImplicitReturns((XAbstractFeatureCall)expression);
    } else if (expression instanceof XBlockExpression) {
      return _findImplicitReturns((XBlockExpression)expression);
    } else if (expression instanceof XBooleanLiteral) {
      return _findImplicitReturns((XBooleanLiteral)expression);
    } else if (expression instanceof XCastedExpression) {
      return _findImplicitReturns((XCastedExpression)expression);
    } else if (expression instanceof XClosure) {
      return _findImplicitReturns((XClosure)expression);
    } else if (expression instanceof XCollectionLiteral) {
      return _findImplicitReturns((XCollectionLiteral)expression);
    } else if (expression instanceof XConstructorCall) {
      return _findImplicitReturns((XConstructorCall)expression);
    } else if (expression instanceof XIfExpression) {
      return _findImplicitReturns((XIfExpression)expression);
    } else if (expression instanceof XInstanceOfExpression) {
      return _findImplicitReturns((XInstanceOfExpression)expression);
    } else if (expression instanceof XNullLiteral) {
      return _findImplicitReturns((XNullLiteral)expression);
    } else if (expression instanceof XNumberLiteral) {
      return _findImplicitReturns((XNumberLiteral)expression);
    } else if (expression instanceof XStringLiteral) {
      return _findImplicitReturns((XStringLiteral)expression);
    } else if (expression instanceof XSwitchExpression) {
      return _findImplicitReturns((XSwitchExpression)expression);
    } else if (expression instanceof XSynchronizedExpression) {
      return _findImplicitReturns((XSynchronizedExpression)expression);
    } else if (expression instanceof XTryCatchFinallyExpression) {
      return _findImplicitReturns((XTryCatchFinallyExpression)expression);
    } else if (expression != null) {
      return _findImplicitReturns(expression);
    } else if (expression == null) {
      return _findImplicitReturns((Void)null);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(expression).toString());
    }
  }
}
