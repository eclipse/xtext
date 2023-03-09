/**
 * Copyright (c) 2011, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.controlflow;

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
    return ((exitPoints != null) && (!exitPoints.isEmpty()));
  }

  @Override
  public Collection<IEarlyExitComputer.ExitPoint> getExitPoints(final XExpression expression) {
    if ((expression == null)) {
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
    if (((predicate == null) || this.isBooleanConstant(predicate, true))) {
      exitPoints = this.getExitPoints(expression.getEachExpression());
      boolean _isNotEmpty_1 = this.isNotEmpty(exitPoints);
      if (_isNotEmpty_1) {
        return exitPoints;
      }
      EList<XExpression> _updateExpressions = expression.getUpdateExpressions();
      for (final XExpression child : _updateExpressions) {
        {
          exitPoints = this.getExitPoints(child);
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
    Collection<IEarlyExitComputer.ExitPoint> exitPoints = this.getExitPoints(expression.getForExpression());
    boolean _isNotEmpty = this.isNotEmpty(exitPoints);
    if (_isNotEmpty) {
      return exitPoints;
    }
    return Collections.<IEarlyExitComputer.ExitPoint>emptyList();
  }

  protected Collection<IEarlyExitComputer.ExitPoint> _exitPoints(final XWhileExpression expression) {
    Collection<IEarlyExitComputer.ExitPoint> exitPoints = this.getExitPoints(expression.getPredicate());
    boolean _isNotEmpty = this.isNotEmpty(exitPoints);
    if (_isNotEmpty) {
      return exitPoints;
    }
    boolean _isBooleanConstant = this.isBooleanConstant(expression.getPredicate(), true);
    if (_isBooleanConstant) {
      exitPoints = this.getExitPoints(expression.getBody());
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
    Collection<IEarlyExitComputer.ExitPoint> exitPoints = this.getExitPoints(expression.getBody());
    boolean _isNotEmpty = this.isNotEmpty(exitPoints);
    if (_isNotEmpty) {
      return exitPoints;
    }
    exitPoints = this.getExitPoints(expression.getPredicate());
    boolean _isNotEmpty_1 = this.isNotEmpty(exitPoints);
    if (_isNotEmpty_1) {
      return exitPoints;
    }
    boolean _isBooleanConstant = this.isBooleanConstant(expression.getPredicate(), true);
    if (_isBooleanConstant) {
      IEarlyExitComputer.ExitPoint _exitPoint = new IEarlyExitComputer.ExitPoint(expression, false);
      return Collections.<IEarlyExitComputer.ExitPoint>singletonList(_exitPoint);
    }
    return Collections.<IEarlyExitComputer.ExitPoint>emptyList();
  }

  protected Collection<IEarlyExitComputer.ExitPoint> _exitPoints(final XVariableDeclaration expression) {
    return this.getExitPoints(expression.getRight());
  }

  protected Collection<IEarlyExitComputer.ExitPoint> _exitPoints(final XIfExpression expression) {
    Collection<IEarlyExitComputer.ExitPoint> ifExitPoints = this.getExitPoints(expression.getIf());
    boolean _isNotEmpty = this.isNotEmpty(ifExitPoints);
    if (_isNotEmpty) {
      return ifExitPoints;
    }
    Collection<IEarlyExitComputer.ExitPoint> thenExitPoints = this.getExitPoints(expression.getThen());
    Collection<IEarlyExitComputer.ExitPoint> elseExitPoints = this.getExitPoints(expression.getElse());
    if ((this.isNotEmpty(thenExitPoints) && this.isNotEmpty(elseExitPoints))) {
      Collection<IEarlyExitComputer.ExitPoint> result = Lists.<IEarlyExitComputer.ExitPoint>newArrayList(thenExitPoints);
      result.addAll(elseExitPoints);
      return result;
    }
    return Collections.<IEarlyExitComputer.ExitPoint>emptyList();
  }

  protected Collection<IEarlyExitComputer.ExitPoint> _exitPoints(final XSwitchExpression expression) {
    Collection<IEarlyExitComputer.ExitPoint> switchExitPoints = this.getExitPoints(expression.getSwitch());
    boolean _isNotEmpty = this.isNotEmpty(switchExitPoints);
    if (_isNotEmpty) {
      return switchExitPoints;
    }
    Collection<IEarlyExitComputer.ExitPoint> result = Lists.<IEarlyExitComputer.ExitPoint>newArrayList();
    EList<XCasePart> _cases = expression.getCases();
    for (final XCasePart casePart : _cases) {
      {
        XExpression then = casePart.getThen();
        if ((then != null)) {
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
    Collection<IEarlyExitComputer.ExitPoint> defaultExit = this.getExitPoints(expression.getDefault());
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
    Collection<IEarlyExitComputer.ExitPoint> tryExitPoints = this.getExitPoints(expression.getExpression());
    boolean _isNotEmpty = this.isNotEmpty(tryExitPoints);
    if (_isNotEmpty) {
      Collection<IEarlyExitComputer.ExitPoint> result = Lists.<IEarlyExitComputer.ExitPoint>newArrayList(tryExitPoints);
      EList<XCatchClause> _catchClauses = expression.getCatchClauses();
      for (final XCatchClause catchClause : _catchClauses) {
        {
          Collection<IEarlyExitComputer.ExitPoint> catchExitPoints = this.getExitPoints(catchClause.getExpression());
          boolean _isNotEmpty_1 = this.isNotEmpty(catchExitPoints);
          if (_isNotEmpty_1) {
            result.addAll(catchExitPoints);
          } else {
            return this.getExitPoints(expression.getFinallyExpression());
          }
        }
      }
      return result;
    }
    return this.getExitPoints(expression.getFinallyExpression());
  }

  protected Collection<IEarlyExitComputer.ExitPoint> _exitPoints(final XSynchronizedExpression expression) {
    Collection<IEarlyExitComputer.ExitPoint> paramExitPoints = this.getExitPoints(expression.getParam());
    boolean _isNotEmpty = this.isNotEmpty(paramExitPoints);
    if (_isNotEmpty) {
      return paramExitPoints;
    }
    return this.getExitPoints(expression.getExpression());
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
