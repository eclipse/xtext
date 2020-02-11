/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.validation;

import java.util.Arrays;
import java.util.function.Consumer;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XCatchClause;
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
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.validation.ImplicitReturnFinder;

/**
 * @author Stefan Oehme - Initial contribution and API
 */
@SuppressWarnings("all")
public class XbaseImplicitReturnFinder implements ImplicitReturnFinder {
  protected void _findImplicitReturns(final Void expression, final ImplicitReturnFinder.Acceptor acceptor) {
  }
  
  protected void _findImplicitReturns(final XExpression expression, final ImplicitReturnFinder.Acceptor acceptor) {
  }
  
  protected void _findImplicitReturns(final XNumberLiteral expression, final ImplicitReturnFinder.Acceptor acceptor) {
    acceptor.accept(expression);
  }
  
  protected void _findImplicitReturns(final XBooleanLiteral expression, final ImplicitReturnFinder.Acceptor acceptor) {
    acceptor.accept(expression);
  }
  
  protected void _findImplicitReturns(final XCollectionLiteral expression, final ImplicitReturnFinder.Acceptor acceptor) {
    acceptor.accept(expression);
  }
  
  protected void _findImplicitReturns(final XStringLiteral expression, final ImplicitReturnFinder.Acceptor acceptor) {
    acceptor.accept(expression);
  }
  
  protected void _findImplicitReturns(final XNullLiteral expression, final ImplicitReturnFinder.Acceptor acceptor) {
    acceptor.accept(expression);
  }
  
  protected void _findImplicitReturns(final XTypeLiteral expression, final ImplicitReturnFinder.Acceptor acceptor) {
    acceptor.accept(expression);
  }
  
  protected void _findImplicitReturns(final XClosure expression, final ImplicitReturnFinder.Acceptor acceptor) {
    acceptor.accept(expression);
  }
  
  protected void _findImplicitReturns(final XConstructorCall expression, final ImplicitReturnFinder.Acceptor acceptor) {
    acceptor.accept(expression);
  }
  
  protected void _findImplicitReturns(final XAbstractFeatureCall expression, final ImplicitReturnFinder.Acceptor acceptor) {
    acceptor.accept(expression);
  }
  
  protected void _findImplicitReturns(final XInstanceOfExpression expression, final ImplicitReturnFinder.Acceptor acceptor) {
    acceptor.accept(expression);
  }
  
  protected void _findImplicitReturns(final XCastedExpression expression, final ImplicitReturnFinder.Acceptor acceptor) {
    acceptor.accept(expression);
  }
  
  protected void _findImplicitReturns(final XBlockExpression expression, final ImplicitReturnFinder.Acceptor acceptor) {
    this.findImplicitReturns(IterableExtensions.<XExpression>last(expression.getExpressions()), acceptor);
  }
  
  protected void _findImplicitReturns(final XSynchronizedExpression expression, final ImplicitReturnFinder.Acceptor acceptor) {
    this.findImplicitReturns(expression.getExpression(), acceptor);
  }
  
  protected void _findImplicitReturns(final XIfExpression expression, final ImplicitReturnFinder.Acceptor acceptor) {
    this.findImplicitReturns(expression.getThen(), acceptor);
    this.findImplicitReturns(expression.getElse(), acceptor);
  }
  
  protected void _findImplicitReturns(final XTryCatchFinallyExpression expression, final ImplicitReturnFinder.Acceptor acceptor) {
    this.findImplicitReturns(expression.getExpression(), acceptor);
    final Consumer<XCatchClause> _function = (XCatchClause it) -> {
      this.findImplicitReturns(it.getExpression(), acceptor);
    };
    expression.getCatchClauses().forEach(_function);
  }
  
  protected void _findImplicitReturns(final XSwitchExpression expression, final ImplicitReturnFinder.Acceptor acceptor) {
    final Consumer<XCasePart> _function = (XCasePart it) -> {
      this.findImplicitReturns(it.getThen(), acceptor);
    };
    expression.getCases().forEach(_function);
    this.findImplicitReturns(expression.getDefault(), acceptor);
  }
  
  public void findImplicitReturns(final XExpression expression, final ImplicitReturnFinder.Acceptor acceptor) {
    if (expression instanceof XAbstractFeatureCall) {
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
