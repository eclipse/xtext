/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.validation;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.common.util.EList;
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
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.validation.ImplicitReturnFinder;

/**
 * @author Stefan Oehme - Initial contribution and API
 */
@SuppressWarnings("all")
public class XbaseImplicitReturnFinder implements ImplicitReturnFinder {
  protected List<? extends XExpression> _findImplicitReturns(final XExpression expression) {
    return Collections.<XExpression>unmodifiableList(Lists.<XExpression>newArrayList());
  }
  
  protected List<? extends XExpression> _findImplicitReturns(final XNumberLiteral expression) {
    return Collections.<XNumberLiteral>unmodifiableList(Lists.<XNumberLiteral>newArrayList(expression));
  }
  
  protected List<? extends XExpression> _findImplicitReturns(final XBooleanLiteral expression) {
    return Collections.<XBooleanLiteral>unmodifiableList(Lists.<XBooleanLiteral>newArrayList(expression));
  }
  
  protected List<? extends XExpression> _findImplicitReturns(final XCollectionLiteral expression) {
    return Collections.<XCollectionLiteral>unmodifiableList(Lists.<XCollectionLiteral>newArrayList(expression));
  }
  
  protected List<? extends XExpression> _findImplicitReturns(final XStringLiteral expression) {
    return Collections.<XStringLiteral>unmodifiableList(Lists.<XStringLiteral>newArrayList(expression));
  }
  
  protected List<? extends XExpression> _findImplicitReturns(final XNullLiteral expression) {
    return Collections.<XNullLiteral>unmodifiableList(Lists.<XNullLiteral>newArrayList(expression));
  }
  
  protected List<? extends XExpression> _findImplicitReturns(final XClosure expression) {
    return Collections.<XClosure>unmodifiableList(Lists.<XClosure>newArrayList(expression));
  }
  
  protected List<? extends XExpression> _findImplicitReturns(final XConstructorCall expression) {
    return Collections.<XConstructorCall>unmodifiableList(Lists.<XConstructorCall>newArrayList(expression));
  }
  
  protected List<? extends XExpression> _findImplicitReturns(final XAbstractFeatureCall expression) {
    return Collections.<XAbstractFeatureCall>unmodifiableList(Lists.<XAbstractFeatureCall>newArrayList(expression));
  }
  
  protected List<? extends XExpression> _findImplicitReturns(final XInstanceOfExpression expression) {
    return Collections.<XInstanceOfExpression>unmodifiableList(Lists.<XInstanceOfExpression>newArrayList(expression));
  }
  
  protected List<? extends XExpression> _findImplicitReturns(final XCastedExpression expression) {
    return Collections.<XCastedExpression>unmodifiableList(Lists.<XCastedExpression>newArrayList(expression));
  }
  
  protected List<? extends XExpression> _findImplicitReturns(final XBlockExpression expression) {
    EList<XExpression> _expressions = expression.getExpressions();
    XExpression _last = IterableExtensions.<XExpression>last(_expressions);
    return this.findImplicitReturns(_last);
  }
  
  protected List<? extends XExpression> _findImplicitReturns(final XSynchronizedExpression expression) {
    XExpression _expression = expression.getExpression();
    return this.findImplicitReturns(_expression);
  }
  
  protected List<? extends XExpression> _findImplicitReturns(final XIfExpression expression) {
    XExpression _then = expression.getThen();
    List<? extends XExpression> _findImplicitReturns = this.findImplicitReturns(_then);
    XExpression _else = expression.getElse();
    List<? extends XExpression> _findImplicitReturns_1 = this.findImplicitReturns(_else);
    Iterable<XExpression> _plus = Iterables.<XExpression>concat(_findImplicitReturns, _findImplicitReturns_1);
    return IterableExtensions.<XExpression>toList(_plus);
  }
  
  protected List<? extends XExpression> _findImplicitReturns(final XTryCatchFinallyExpression expression) {
    XExpression _expression = expression.getExpression();
    List<? extends XExpression> _findImplicitReturns = this.findImplicitReturns(_expression);
    EList<XCatchClause> _catchClauses = expression.getCatchClauses();
    final Function1<XCatchClause, List<? extends XExpression>> _function = new Function1<XCatchClause, List<? extends XExpression>>() {
      public List<? extends XExpression> apply(final XCatchClause it) {
        XExpression _expression = it.getExpression();
        return XbaseImplicitReturnFinder.this.findImplicitReturns(_expression);
      }
    };
    List<List<? extends XExpression>> _map = ListExtensions.<XCatchClause, List<? extends XExpression>>map(_catchClauses, _function);
    Iterable<XExpression> _flatten = Iterables.<XExpression>concat(_map);
    Iterable<XExpression> _plus = Iterables.<XExpression>concat(_findImplicitReturns, _flatten);
    return IterableExtensions.<XExpression>toList(_plus);
  }
  
  protected List<? extends XExpression> _findImplicitReturns(final XSwitchExpression expression) {
    EList<XCasePart> _cases = expression.getCases();
    final Function1<XCasePart, List<? extends XExpression>> _function = new Function1<XCasePart, List<? extends XExpression>>() {
      public List<? extends XExpression> apply(final XCasePart it) {
        XExpression _then = it.getThen();
        return XbaseImplicitReturnFinder.this.findImplicitReturns(_then);
      }
    };
    List<List<? extends XExpression>> _map = ListExtensions.<XCasePart, List<? extends XExpression>>map(_cases, _function);
    Iterable<XExpression> _flatten = Iterables.<XExpression>concat(_map);
    XExpression _default = expression.getDefault();
    List<? extends XExpression> _findImplicitReturns = this.findImplicitReturns(_default);
    Iterable<XExpression> _plus = Iterables.<XExpression>concat(_flatten, _findImplicitReturns);
    return IterableExtensions.<XExpression>toList(_plus);
  }
  
  public List<? extends XExpression> findImplicitReturns(final XExpression expression) {
    if (expression instanceof XAbstractFeatureCall) {
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
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(expression).toString());
    }
  }
}
