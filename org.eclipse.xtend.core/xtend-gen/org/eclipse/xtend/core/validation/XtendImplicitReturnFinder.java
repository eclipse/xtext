/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.validation;

import java.util.Arrays;
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
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.validation.ImplicitReturnFinder;
import org.eclipse.xtext.xbase.validation.XbaseImplicitReturnFinder;

/**
 * @author Stefan Oehme - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendImplicitReturnFinder extends XbaseImplicitReturnFinder {
  protected void _findImplicitReturns(final AnonymousClass expression, final ImplicitReturnFinder.Acceptor acceptor) {
    acceptor.accept(expression);
  }

  protected void _findImplicitReturns(final RichString expression, final ImplicitReturnFinder.Acceptor acceptor) {
    acceptor.accept(expression);
  }

  public void findImplicitReturns(final XExpression expression, final ImplicitReturnFinder.Acceptor acceptor) {
    if (expression instanceof AnonymousClass) {
      _findImplicitReturns((AnonymousClass)expression, acceptor);
      return;
    } else if (expression instanceof RichString) {
      _findImplicitReturns((RichString)expression, acceptor);
      return;
    } else if (expression instanceof XAbstractFeatureCall) {
      _findImplicitReturns((XAbstractFeatureCall)expression, acceptor);
      return;
    } else if (expression instanceof XBlockExpression) {
      _findImplicitReturns((XBlockExpression)expression, acceptor);
      return;
    } else if (expression instanceof XBooleanLiteral) {
      _findImplicitReturns((XBooleanLiteral)expression, acceptor);
      return;
    } else if (expression instanceof XCastedExpression) {
      _findImplicitReturns((XCastedExpression)expression, acceptor);
      return;
    } else if (expression instanceof XClosure) {
      _findImplicitReturns((XClosure)expression, acceptor);
      return;
    } else if (expression instanceof XCollectionLiteral) {
      _findImplicitReturns((XCollectionLiteral)expression, acceptor);
      return;
    } else if (expression instanceof XConstructorCall) {
      _findImplicitReturns((XConstructorCall)expression, acceptor);
      return;
    } else if (expression instanceof XIfExpression) {
      _findImplicitReturns((XIfExpression)expression, acceptor);
      return;
    } else if (expression instanceof XInstanceOfExpression) {
      _findImplicitReturns((XInstanceOfExpression)expression, acceptor);
      return;
    } else if (expression instanceof XNullLiteral) {
      _findImplicitReturns((XNullLiteral)expression, acceptor);
      return;
    } else if (expression instanceof XNumberLiteral) {
      _findImplicitReturns((XNumberLiteral)expression, acceptor);
      return;
    } else if (expression instanceof XStringLiteral) {
      _findImplicitReturns((XStringLiteral)expression, acceptor);
      return;
    } else if (expression instanceof XSwitchExpression) {
      _findImplicitReturns((XSwitchExpression)expression, acceptor);
      return;
    } else if (expression instanceof XSynchronizedExpression) {
      _findImplicitReturns((XSynchronizedExpression)expression, acceptor);
      return;
    } else if (expression instanceof XTryCatchFinallyExpression) {
      _findImplicitReturns((XTryCatchFinallyExpression)expression, acceptor);
      return;
    } else if (expression instanceof XTypeLiteral) {
      _findImplicitReturns((XTypeLiteral)expression, acceptor);
      return;
    } else if (expression != null) {
      _findImplicitReturns(expression, acceptor);
      return;
    } else if (expression == null) {
      _findImplicitReturns((Void)null, acceptor);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(expression, acceptor).toString());
    }
  }
}
