/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.controlflow;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBasicForLoopExpression;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XDoWhileExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XSynchronizedExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XWhileExpression;
import org.eclipse.xtext.xbase.controlflow.EarlyExitInterpreter;
import org.eclipse.xtext.xbase.controlflow.IEarlyExitComputer;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
@SuppressWarnings("all")
public class DefaultEarlyExitComputer implements IEarlyExitComputer {
  @Inject
  private EarlyExitInterpreter earlyExitInterpreter;
  
  @Override
  public boolean isEarlyExit(final XExpression expression) {
    Collection<IEarlyExitComputer.ExitPoint> exitPoints = this.getExitPoints(expression);
    boolean _isNotEmpty = this.isNotEmpty(exitPoints);
    if (_isNotEmpty) {
      return true;
    }
    return false;
  }
  
  protected boolean isNotEmpty(final Collection<IEarlyExitComputer.ExitPoint> exitPoints) {
    return ((!Objects.equal(exitPoints, null)) && (!exitPoints.isEmpty()));
  }
  
  @Override
  public Collection<IEarlyExitComputer.ExitPoint> getExitPoints(final XExpression expression) {
    boolean _equals = Objects.equal(expression, null);
    if (_equals) {
      return Collections.<IEarlyExitComputer.ExitPoint>emptyList();
    }
    return this.exitPoints(expression);
  }
  
  /**
   * @param expression unused in this context but required in dispatch signature
   */
  protected Collection<IEarlyExitComputer.ExitPoint> _exitPoints(final XExpression expression) {
    return Collections.<IEarlyExitComputer.ExitPoint>emptyList();
  }
  
  protected Collection<IEarlyExitComputer.ExitPoint> _exitPoints(final XReturnExpression expression) {
    IEarlyExitComputer.ExitPoint _exitPoint = new IEarlyExitComputer.ExitPoint(expression, false);
    return Collections.<IEarlyExitComputer.ExitPoint>singletonList(_exitPoint);
  }
  
  protected Collection<IEarlyExitComputer.ExitPoint> _exitPoints(final XThrowExpression expression) {
    IEarlyExitComputer.ExitPoint _exitPoint = new IEarlyExitComputer.ExitPoint(expression, true);
    return Collections.<IEarlyExitComputer.ExitPoint>singletonList(_exitPoint);
  }
  
  protected Collection<IEarlyExitComputer.ExitPoint> _exitPoints(final XBlockExpression expression) {
    EList<XExpression> _expressions = expression.getExpressions();
    for (final XExpression child : _expressions) {
      {
        Collection<IEarlyExitComputer.ExitPoint> exitPoints = this.getExitPoints(child);
        boolean _isNotEmpty = this.isNotEmpty(exitPoints);
        if (_isNotEmpty) {
          return exitPoints;
        }
      }
    }
    return Collections.<IEarlyExitComputer.ExitPoint>emptyList();
  }
  
  protected Collection<IEarlyExitComputer.ExitPoint> _exitPoints(final XBasicForLoopExpression expression) {
    EList<XExpression> _initExpressions = expression.getInitExpressions();
    for (final XExpression initExpression : _initExpressions) {
      {
        Collection<IEarlyExitComputer.ExitPoint> exitPoints = this.getExitPoints(initExpression);
        boolean _isNotEmpty = this.isNotEmpty(exitPoints);
        if (_isNotEmpty) {
          return exitPoints;
        }
      }
    }
    XExpression predicate = expression.getExpression();
    Collection<IEarlyExitComputer.ExitPoint> exitPoints = this.getExitPoints(predicate);
    boolean _isNotEmpty = this.isNotEmpty(exitPoints);
    if (_isNotEmpty) {
      return exitPoints;
    }
    if ((Objects.equal(predicate, null) || this.isBooleanConstant(predicate, true))) {
      XExpression _eachExpression = expression.getEachExpression();
      Collection<IEarlyExitComputer.ExitPoint> _exitPoints = this.getExitPoints(_eachExpression);
      exitPoints = _exitPoints;
      boolean _isNotEmpty_1 = this.isNotEmpty(exitPoints);
      if (_isNotEmpty_1) {
        return exitPoints;
      }
      EList<XExpression> _updateExpressions = expression.getUpdateExpressions();
      for (final XExpression child : _updateExpressions) {
        {
          Collection<IEarlyExitComputer.ExitPoint> _exitPoints_1 = this.getExitPoints(child);
          exitPoints = _exitPoints_1;
          boolean _isNotEmpty_2 = this.isNotEmpty(exitPoints);
          if (_isNotEmpty_2) {
            return exitPoints;
          }
        }
      }
      IEarlyExitComputer.ExitPoint _exitPoint = new IEarlyExitComputer.ExitPoint(expression, false);
      return Collections.<IEarlyExitComputer.ExitPoint>singletonList(_exitPoint);
    }
    return Collections.<IEarlyExitComputer.ExitPoint>emptyList();
  }
  
  protected Collection<IEarlyExitComputer.ExitPoint> _exitPoints(final XForLoopExpression expression) {
    XExpression _forExpression = expression.getForExpression();
    Collection<IEarlyExitComputer.ExitPoint> exitPoints = this.getExitPoints(_forExpression);
    boolean _isNotEmpty = this.isNotEmpty(exitPoints);
    if (_isNotEmpty) {
      return exitPoints;
    }
    return Collections.<IEarlyExitComputer.ExitPoint>emptyList();
  }
  
  protected Collection<IEarlyExitComputer.ExitPoint> _exitPoints(final XWhileExpression expression) {
    XExpression _predicate = expression.getPredicate();
    Collection<IEarlyExitComputer.ExitPoint> exitPoints = this.getExitPoints(_predicate);
    boolean _isNotEmpty = this.isNotEmpty(exitPoints);
    if (_isNotEmpty) {
      return exitPoints;
    }
    XExpression _predicate_1 = expression.getPredicate();
    boolean _isBooleanConstant = this.isBooleanConstant(_predicate_1, true);
    if (_isBooleanConstant) {
      XExpression _body = expression.getBody();
      Collection<IEarlyExitComputer.ExitPoint> _exitPoints = this.getExitPoints(_body);
      exitPoints = _exitPoints;
      boolean _isNotEmpty_1 = this.isNotEmpty(exitPoints);
      if (_isNotEmpty_1) {
        return exitPoints;
      }
      IEarlyExitComputer.ExitPoint _exitPoint = new IEarlyExitComputer.ExitPoint(expression, false);
      return Collections.<IEarlyExitComputer.ExitPoint>singletonList(_exitPoint);
    }
    return Collections.<IEarlyExitComputer.ExitPoint>emptyList();
  }
  
  protected boolean isBooleanConstant(final XExpression expression, final boolean value) {
    return this.earlyExitInterpreter.isConstant(expression, Boolean.valueOf(value));
  }
  
  protected Collection<IEarlyExitComputer.ExitPoint> _exitPoints(final XDoWhileExpression expression) {
    XExpression _body = expression.getBody();
    Collection<IEarlyExitComputer.ExitPoint> exitPoints = this.getExitPoints(_body);
    boolean _isNotEmpty = this.isNotEmpty(exitPoints);
    if (_isNotEmpty) {
      return exitPoints;
    }
    XExpression _predicate = expression.getPredicate();
    Collection<IEarlyExitComputer.ExitPoint> _exitPoints = this.getExitPoints(_predicate);
    exitPoints = _exitPoints;
    boolean _isNotEmpty_1 = this.isNotEmpty(exitPoints);
    if (_isNotEmpty_1) {
      return exitPoints;
    }
    XExpression _predicate_1 = expression.getPredicate();
    boolean _isBooleanConstant = this.isBooleanConstant(_predicate_1, true);
    if (_isBooleanConstant) {
      IEarlyExitComputer.ExitPoint _exitPoint = new IEarlyExitComputer.ExitPoint(expression, false);
      return Collections.<IEarlyExitComputer.ExitPoint>singletonList(_exitPoint);
    }
    return Collections.<IEarlyExitComputer.ExitPoint>emptyList();
  }
  
  protected Collection<IEarlyExitComputer.ExitPoint> _exitPoints(final XVariableDeclaration expression) {
    XExpression _right = expression.getRight();
    return this.getExitPoints(_right);
  }
  
  protected Collection<IEarlyExitComputer.ExitPoint> _exitPoints(final XIfExpression expression) {
    XExpression _if = expression.getIf();
    Collection<IEarlyExitComputer.ExitPoint> ifExitPoints = this.getExitPoints(_if);
    boolean _isNotEmpty = this.isNotEmpty(ifExitPoints);
    if (_isNotEmpty) {
      return ifExitPoints;
    }
    XExpression _then = expression.getThen();
    Collection<IEarlyExitComputer.ExitPoint> thenExitPoints = this.getExitPoints(_then);
    XExpression _else = expression.getElse();
    Collection<IEarlyExitComputer.ExitPoint> elseExitPoints = this.getExitPoints(_else);
    if ((this.isNotEmpty(thenExitPoints) && this.isNotEmpty(elseExitPoints))) {
      Collection<IEarlyExitComputer.ExitPoint> result = Lists.<IEarlyExitComputer.ExitPoint>newArrayList(thenExitPoints);
      result.addAll(elseExitPoints);
      return result;
    }
    return Collections.<IEarlyExitComputer.ExitPoint>emptyList();
  }
  
  protected Collection<IEarlyExitComputer.ExitPoint> _exitPoints(final XSwitchExpression expression) {
    XExpression _switch = expression.getSwitch();
    Collection<IEarlyExitComputer.ExitPoint> switchExitPoints = this.getExitPoints(_switch);
    boolean _isNotEmpty = this.isNotEmpty(switchExitPoints);
    if (_isNotEmpty) {
      return switchExitPoints;
    }
    Collection<IEarlyExitComputer.ExitPoint> result = Lists.<IEarlyExitComputer.ExitPoint>newArrayList();
    EList<XCasePart> _cases = expression.getCases();
    for (final XCasePart casePart : _cases) {
      {
        XExpression then = casePart.getThen();
        boolean _notEquals = (!Objects.equal(then, null));
        if (_notEquals) {
          Collection<IEarlyExitComputer.ExitPoint> caseExit = this.getExitPoints(then);
          boolean _isNotEmpty_1 = this.isNotEmpty(caseExit);
          boolean _not = (!_isNotEmpty_1);
          if (_not) {
            return Collections.<IEarlyExitComputer.ExitPoint>emptyList();
          } else {
            result.addAll(caseExit);
          }
        }
      }
    }
    XExpression _default = expression.getDefault();
    Collection<IEarlyExitComputer.ExitPoint> defaultExit = this.getExitPoints(_default);
    boolean _isNotEmpty_1 = this.isNotEmpty(defaultExit);
    boolean _not = (!_isNotEmpty_1);
    if (_not) {
      return Collections.<IEarlyExitComputer.ExitPoint>emptyList();
    } else {
      result.addAll(defaultExit);
    }
    return result;
  }
  
  protected Collection<IEarlyExitComputer.ExitPoint> _exitPoints(final XAbstractFeatureCall expression) {
    EList<XExpression> _actualArguments = expression.getActualArguments();
    for (final XExpression argument : _actualArguments) {
      {
        Collection<IEarlyExitComputer.ExitPoint> argumentExitPoints = this.getExitPoints(argument);
        boolean _isNotEmpty = this.isNotEmpty(argumentExitPoints);
        if (_isNotEmpty) {
          return argumentExitPoints;
        }
      }
    }
    return Collections.<IEarlyExitComputer.ExitPoint>emptyList();
  }
  
  protected Collection<IEarlyExitComputer.ExitPoint> _exitPoints(final XConstructorCall expression) {
    EList<XExpression> _arguments = expression.getArguments();
    for (final XExpression argument : _arguments) {
      {
        Collection<IEarlyExitComputer.ExitPoint> argumentExitPoints = this.getExitPoints(argument);
        boolean _isNotEmpty = this.isNotEmpty(argumentExitPoints);
        if (_isNotEmpty) {
          return argumentExitPoints;
        }
      }
    }
    return Collections.<IEarlyExitComputer.ExitPoint>emptyList();
  }
  
  protected Collection<IEarlyExitComputer.ExitPoint> _exitPoints(final XTryCatchFinallyExpression expression) {
    XExpression _expression = expression.getExpression();
    Collection<IEarlyExitComputer.ExitPoint> tryExitPoints = this.getExitPoints(_expression);
    boolean _isNotEmpty = this.isNotEmpty(tryExitPoints);
    if (_isNotEmpty) {
      Collection<IEarlyExitComputer.ExitPoint> result = Lists.<IEarlyExitComputer.ExitPoint>newArrayList(tryExitPoints);
      EList<XCatchClause> _catchClauses = expression.getCatchClauses();
      for (final XCatchClause catchClause : _catchClauses) {
        {
          XExpression _expression_1 = catchClause.getExpression();
          Collection<IEarlyExitComputer.ExitPoint> catchExitPoints = this.getExitPoints(_expression_1);
          boolean _isNotEmpty_1 = this.isNotEmpty(catchExitPoints);
          if (_isNotEmpty_1) {
            result.addAll(catchExitPoints);
          } else {
            XExpression _finallyExpression = expression.getFinallyExpression();
            return this.getExitPoints(_finallyExpression);
          }
        }
      }
      return result;
    }
    XExpression _finallyExpression = expression.getFinallyExpression();
    return this.getExitPoints(_finallyExpression);
  }
  
  protected Collection<IEarlyExitComputer.ExitPoint> _exitPoints(final XSynchronizedExpression expression) {
    XExpression _param = expression.getParam();
    Collection<IEarlyExitComputer.ExitPoint> paramExitPoints = this.getExitPoints(_param);
    boolean _isNotEmpty = this.isNotEmpty(paramExitPoints);
    if (_isNotEmpty) {
      return paramExitPoints;
    }
    XExpression _expression = expression.getExpression();
    return this.getExitPoints(_expression);
  }
  
  protected Collection<IEarlyExitComputer.ExitPoint> exitPoints(final XExpression expression) {
    if (expression instanceof XDoWhileExpression) {
      return _exitPoints((XDoWhileExpression)expression);
    } else if (expression instanceof XWhileExpression) {
      return _exitPoints((XWhileExpression)expression);
    } else if (expression instanceof XAbstractFeatureCall) {
      return _exitPoints((XAbstractFeatureCall)expression);
    } else if (expression instanceof XBasicForLoopExpression) {
      return _exitPoints((XBasicForLoopExpression)expression);
    } else if (expression instanceof XBlockExpression) {
      return _exitPoints((XBlockExpression)expression);
    } else if (expression instanceof XConstructorCall) {
      return _exitPoints((XConstructorCall)expression);
    } else if (expression instanceof XForLoopExpression) {
      return _exitPoints((XForLoopExpression)expression);
    } else if (expression instanceof XIfExpression) {
      return _exitPoints((XIfExpression)expression);
    } else if (expression instanceof XReturnExpression) {
      return _exitPoints((XReturnExpression)expression);
    } else if (expression instanceof XSwitchExpression) {
      return _exitPoints((XSwitchExpression)expression);
    } else if (expression instanceof XSynchronizedExpression) {
      return _exitPoints((XSynchronizedExpression)expression);
    } else if (expression instanceof XThrowExpression) {
      return _exitPoints((XThrowExpression)expression);
    } else if (expression instanceof XTryCatchFinallyExpression) {
      return _exitPoints((XTryCatchFinallyExpression)expression);
    } else if (expression instanceof XVariableDeclaration) {
      return _exitPoints((XVariableDeclaration)expression);
    } else if (expression != null) {
      return _exitPoints(expression);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(expression).toString());
    }
  }
}
