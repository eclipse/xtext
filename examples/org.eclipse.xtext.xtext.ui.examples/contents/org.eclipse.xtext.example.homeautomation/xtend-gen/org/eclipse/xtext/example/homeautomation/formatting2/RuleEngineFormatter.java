/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.homeautomation.formatting2;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.example.homeautomation.ruleEngine.Declaration;
import org.eclipse.xtext.example.homeautomation.ruleEngine.Device;
import org.eclipse.xtext.example.homeautomation.ruleEngine.Model;
import org.eclipse.xtext.example.homeautomation.ruleEngine.Rule;
import org.eclipse.xtext.example.homeautomation.ruleEngine.State;
import org.eclipse.xtext.example.homeautomation.services.RuleEngineGrammarAccess;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBasicForLoopExpression;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XCollectionLiteral;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XDoWhileExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XInstanceOfExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XPostfixOperation;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XSynchronizedExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XWhileExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.formatting2.XbaseFormatter;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;

/**
 * The formatter is particularly important for languages with semantic whitespace, since it is responsible
 * for producing correct whitespace that reflects the semantic structure. This formatter actually modifies
 * the structure by converting single expressions in control statements to block expressions. For instance,
 * <pre>
 *     if (condition) println
 * </pre>
 * becomes
 * <pre>
 *     if (condition)
 *         println
 * </pre>
 */
@SuppressWarnings("all")
public class RuleEngineFormatter extends XbaseFormatter {
  @Inject
  @Extension
  private RuleEngineGrammarAccess _ruleEngineGrammarAccess;
  
  protected void _format(final Model model, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.setNewLines(0, 0, 1);
        it.noSpace();
      }
    };
    document.<Model>prepend(model, _function);
    EList<Declaration> _declarations = model.getDeclarations();
    for (final Declaration declaration : _declarations) {
      this.format(declaration, document);
    }
  }
  
  protected void _format(final Device device, @Extension final IFormattableDocument document) {
    EList<State> _states = device.getStates();
    for (final State state : _states) {
      {
        EList<State> _states_1 = device.getStates();
        State _last = IterableExtensions.<State>last(_states_1);
        boolean _equals = Objects.equal(state, _last);
        if (_equals) {
          final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
            @Override
            public void apply(final IHiddenRegionFormatter it) {
              it.setNewLines(1, 1, 2);
            }
          };
          document.<State>append(state, _function);
        } else {
          final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
            @Override
            public void apply(final IHiddenRegionFormatter it) {
              it.noSpace();
            }
          };
          document.<State>append(state, _function_1);
        }
        this.format(state, document);
      }
    }
  }
  
  protected void _format(final Rule rule, @Extension final IFormattableDocument document) {
    XExpression _thenPart = rule.getThenPart();
    this.format(_thenPart, document);
  }
  
  @Override
  protected void _format(final XBlockExpression expr, @Extension final IFormattableDocument document) {
    TerminalRule _bEGINRule = this._ruleEngineGrammarAccess.getBEGINRule();
    final ISemanticRegion begin = this.regionAccess.regionForRuleCallTo(expr, _bEGINRule);
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.setNewLines(1, 1, 2);
        it.increaseIndentation();
        it.noSpace();
      }
    };
    document.prepend(begin, _function);
    TerminalRule _eNDRule = this._ruleEngineGrammarAccess.getENDRule();
    final ISemanticRegion end = this.regionAccess.regionForRuleCallTo(expr, _eNDRule);
    boolean _isLastInBlock = this.isLastInBlock(expr);
    if (_isLastInBlock) {
      final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.decreaseIndentation();
        }
      };
      document.append(end, _function_1);
    } else {
      final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.setNewLines(1, 1, 2);
          it.decreaseIndentation();
          it.noSpace();
        }
      };
      document.append(end, _function_2);
    }
    EList<XExpression> _expressions = expr.getExpressions();
    for (final XExpression child : _expressions) {
      {
        final ISemanticRegion sem = this.regionAccess.immediatelyFollowingKeyword(child, ";");
        boolean _notEquals = (!Objects.equal(sem, null));
        if (_notEquals) {
          final Procedure1<IHiddenRegionFormatter> _function_3 = new Procedure1<IHiddenRegionFormatter>() {
            @Override
            public void apply(final IHiddenRegionFormatter it) {
              it.noSpace();
            }
          };
          document.prepend(sem, _function_3);
          EList<XExpression> _expressions_1 = expr.getExpressions();
          XExpression _last = IterableExtensions.<XExpression>last(_expressions_1);
          boolean _notEquals_1 = (!Objects.equal(child, _last));
          if (_notEquals_1) {
            final Procedure1<IHiddenRegionFormatter> _function_4 = new Procedure1<IHiddenRegionFormatter>() {
              @Override
              public void apply(final IHiddenRegionFormatter it) {
                it.setNewLines(1, 1, 2);
              }
            };
            document.append(sem, _function_4);
          }
        } else {
          EList<XExpression> _expressions_2 = expr.getExpressions();
          XExpression _last_1 = IterableExtensions.<XExpression>last(_expressions_2);
          boolean _notEquals_2 = (!Objects.equal(child, _last_1));
          if (_notEquals_2) {
            final Procedure1<IHiddenRegionFormatter> _function_5 = new Procedure1<IHiddenRegionFormatter>() {
              @Override
              public void apply(final IHiddenRegionFormatter it) {
                it.setNewLines(1, 1, 2);
              }
            };
            document.<XExpression>append(child, _function_5);
          }
        }
        this.format(child, document);
      }
    }
  }
  
  @Override
  protected void _format(final XSwitchExpression expr, @Extension final IFormattableDocument document) {
    ISemanticRegion _regionForKeyword = this.regionAccess.regionForKeyword(expr, "switch");
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    document.append(_regionForKeyword, _function);
    TerminalRule _bEGINRule = this._ruleEngineGrammarAccess.getBEGINRule();
    final ISemanticRegion begin = this.regionAccess.regionForRuleCallTo(expr, _bEGINRule);
    final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.newLine();
        it.increaseIndentation();
        it.noSpace();
      }
    };
    document.prepend(begin, _function_1);
    TerminalRule _eNDRule = this._ruleEngineGrammarAccess.getENDRule();
    final ISemanticRegion end = this.regionAccess.regionForRuleCallTo(expr, _eNDRule);
    boolean _isLastInBlock = this.isLastInBlock(expr);
    if (_isLastInBlock) {
      final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.decreaseIndentation();
        }
      };
      document.append(end, _function_2);
    } else {
      final Procedure1<IHiddenRegionFormatter> _function_3 = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.setNewLines(1, 1, 2);
          it.decreaseIndentation();
          it.noSpace();
        }
      };
      document.append(end, _function_3);
    }
    EList<XCasePart> _cases = expr.getCases();
    for (final XCasePart c : _cases) {
      {
        boolean _and = false;
        JvmTypeReference _typeGuard = c.getTypeGuard();
        boolean _notEquals = (!Objects.equal(_typeGuard, null));
        if (!_notEquals) {
          _and = false;
        } else {
          XExpression _case = c.getCase();
          boolean _notEquals_1 = (!Objects.equal(_case, null));
          _and = _notEquals_1;
        }
        if (_and) {
          JvmTypeReference _typeGuard_1 = c.getTypeGuard();
          final Procedure1<IHiddenRegionFormatter> _function_4 = new Procedure1<IHiddenRegionFormatter>() {
            @Override
            public void apply(final IHiddenRegionFormatter it) {
              it.oneSpace();
            }
          };
          document.<JvmTypeReference>append(_typeGuard_1, _function_4);
          XExpression _case_1 = c.getCase();
          final Procedure1<IHiddenRegionFormatter> _function_5 = new Procedure1<IHiddenRegionFormatter>() {
            @Override
            public void apply(final IHiddenRegionFormatter it) {
              it.noSpace();
            }
          };
          document.<XExpression>append(_case_1, _function_5);
        } else {
          JvmTypeReference _typeGuard_2 = c.getTypeGuard();
          boolean _notEquals_2 = (!Objects.equal(_typeGuard_2, null));
          if (_notEquals_2) {
            JvmTypeReference _typeGuard_3 = c.getTypeGuard();
            final Procedure1<IHiddenRegionFormatter> _function_6 = new Procedure1<IHiddenRegionFormatter>() {
              @Override
              public void apply(final IHiddenRegionFormatter it) {
                it.noSpace();
              }
            };
            document.<JvmTypeReference>append(_typeGuard_3, _function_6);
          } else {
            XExpression _case_2 = c.getCase();
            boolean _notEquals_3 = (!Objects.equal(_case_2, null));
            if (_notEquals_3) {
              XExpression _case_3 = c.getCase();
              final Procedure1<IHiddenRegionFormatter> _function_7 = new Procedure1<IHiddenRegionFormatter>() {
                @Override
                public void apply(final IHiddenRegionFormatter it) {
                  it.oneSpace();
                }
              };
              XExpression _prepend = document.<XExpression>prepend(_case_3, _function_7);
              final Procedure1<IHiddenRegionFormatter> _function_8 = new Procedure1<IHiddenRegionFormatter>() {
                @Override
                public void apply(final IHiddenRegionFormatter it) {
                  it.noSpace();
                }
              };
              document.<XExpression>append(_prepend, _function_8);
            }
          }
        }
        boolean _isFallThrough = c.isFallThrough();
        if (_isFallThrough) {
          ISemanticRegion _regionForFeature = this.regionAccess.regionForFeature(c, XbasePackage.Literals.XCASE_PART__FALL_THROUGH);
          final Procedure1<IHiddenRegionFormatter> _function_9 = new Procedure1<IHiddenRegionFormatter>() {
            @Override
            public void apply(final IHiddenRegionFormatter it) {
              it.noSpace();
            }
          };
          ISemanticRegion _prepend_1 = document.prepend(_regionForFeature, _function_9);
          final Procedure1<IHiddenRegionFormatter> _function_10 = new Procedure1<IHiddenRegionFormatter>() {
            @Override
            public void apply(final IHiddenRegionFormatter it) {
              it.newLine();
            }
          };
          document.append(_prepend_1, _function_10);
        } else {
          XExpression _then = c.getThen();
          boolean _not = (!(_then instanceof XBlockExpression));
          if (_not) {
            XExpression _then_1 = c.getThen();
            final Procedure1<IHiddenRegionFormatter> _function_11 = new Procedure1<IHiddenRegionFormatter>() {
              @Override
              public void apply(final IHiddenRegionFormatter it) {
                it.newLine();
                it.increaseIndentation();
              }
            };
            document.<XExpression>prepend(_then_1, _function_11);
            boolean _or = false;
            XExpression _default = expr.getDefault();
            boolean _notEquals_4 = (!Objects.equal(_default, null));
            if (_notEquals_4) {
              _or = true;
            } else {
              EList<XCasePart> _cases_1 = expr.getCases();
              XCasePart _last = IterableExtensions.<XCasePart>last(_cases_1);
              boolean _notEquals_5 = (!Objects.equal(c, _last));
              _or = _notEquals_5;
            }
            if (_or) {
              XExpression _then_2 = c.getThen();
              final Procedure1<IHiddenRegionFormatter> _function_12 = new Procedure1<IHiddenRegionFormatter>() {
                @Override
                public void apply(final IHiddenRegionFormatter it) {
                  it.newLine();
                  it.decreaseIndentation();
                }
              };
              document.<XExpression>append(_then_2, _function_12);
            } else {
              XExpression _then_3 = c.getThen();
              final Procedure1<IHiddenRegionFormatter> _function_13 = new Procedure1<IHiddenRegionFormatter>() {
                @Override
                public void apply(final IHiddenRegionFormatter it) {
                  it.decreaseIndentation();
                }
              };
              document.<XExpression>append(_then_3, _function_13);
            }
          }
        }
        XExpression _case_4 = c.getCase();
        this.format(_case_4, document);
        XExpression _then_4 = c.getThen();
        this.format(_then_4, document);
      }
    }
    XExpression _default = expr.getDefault();
    boolean _notEquals = (!Objects.equal(_default, null));
    if (_notEquals) {
      ISemanticRegion _regionForKeyword_1 = this.regionAccess.regionForKeyword(expr, "default");
      final Procedure1<IHiddenRegionFormatter> _function_4 = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.noSpace();
        }
      };
      document.append(_regionForKeyword_1, _function_4);
      XExpression _default_1 = expr.getDefault();
      boolean _not = (!(_default_1 instanceof XBlockExpression));
      if (_not) {
        XExpression _default_2 = expr.getDefault();
        final Procedure1<IHiddenRegionFormatter> _function_5 = new Procedure1<IHiddenRegionFormatter>() {
          @Override
          public void apply(final IHiddenRegionFormatter it) {
            it.newLine();
            it.increaseIndentation();
          }
        };
        XExpression _prepend = document.<XExpression>prepend(_default_2, _function_5);
        final Procedure1<IHiddenRegionFormatter> _function_6 = new Procedure1<IHiddenRegionFormatter>() {
          @Override
          public void apply(final IHiddenRegionFormatter it) {
            it.decreaseIndentation();
          }
        };
        document.<XExpression>append(_prepend, _function_6);
      }
      XExpression _default_3 = expr.getDefault();
      this.format(_default_3, document);
    }
  }
  
  private boolean isLastInBlock(final XExpression expr) {
    EObject _eContainer = expr.eContainer();
    EClass _eClass = _eContainer.eClass();
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_eClass, XbasePackage.Literals.XBLOCK_EXPRESSION)) {
        _matched=true;
        EObject _eContainer_1 = expr.eContainer();
        final XBlockExpression blockExpr = ((XBlockExpression) _eContainer_1);
        EList<XExpression> _expressions = blockExpr.getExpressions();
        XExpression _last = IterableExtensions.<XExpression>last(_expressions);
        return Objects.equal(expr, _last);
      }
    }
    if (!_matched) {
      if (Objects.equal(_eClass, XbasePackage.Literals.XSWITCH_EXPRESSION)) {
        _matched=true;
        EStructuralFeature _eContainingFeature = expr.eContainingFeature();
        return Objects.equal(_eContainingFeature, XbasePackage.Literals.XSWITCH_EXPRESSION__DEFAULT);
      }
    }
    if (!_matched) {
      if (Objects.equal(_eClass, XbasePackage.Literals.XCASE_PART)) {
        _matched=true;
        EObject _eContainer_2 = expr.eContainer();
        final XCasePart casePart = ((XCasePart) _eContainer_2);
        EObject _eContainer_3 = casePart.eContainer();
        final XSwitchExpression switchExpr = ((XSwitchExpression) _eContainer_3);
        boolean _and = false;
        boolean _and_1 = false;
        EStructuralFeature _eContainingFeature_1 = expr.eContainingFeature();
        boolean _equals = Objects.equal(_eContainingFeature_1, XbasePackage.Literals.XCASE_PART__THEN);
        if (!_equals) {
          _and_1 = false;
        } else {
          XExpression _default = switchExpr.getDefault();
          boolean _equals_1 = Objects.equal(_default, null);
          _and_1 = _equals_1;
        }
        if (!_and_1) {
          _and = false;
        } else {
          EList<XCasePart> _cases = switchExpr.getCases();
          XCasePart _last_1 = IterableExtensions.<XCasePart>last(_cases);
          boolean _equals_2 = Objects.equal(casePart, _last_1);
          _and = _equals_2;
        }
        return _and;
      }
    }
    if (!_matched) {
      if (Objects.equal(_eClass, XbasePackage.Literals.XIF_EXPRESSION)) {
        _matched=true;
        EObject _eContainer_4 = expr.eContainer();
        final XIfExpression ifExpr = ((XIfExpression) _eContainer_4);
        boolean _or = false;
        EStructuralFeature _eContainingFeature_2 = expr.eContainingFeature();
        boolean _equals_3 = Objects.equal(_eContainingFeature_2, XbasePackage.Literals.XIF_EXPRESSION__ELSE);
        if (_equals_3) {
          _or = true;
        } else {
          boolean _and_2 = false;
          EStructuralFeature _eContainingFeature_3 = expr.eContainingFeature();
          boolean _equals_4 = Objects.equal(_eContainingFeature_3, XbasePackage.Literals.XIF_EXPRESSION__THEN);
          if (!_equals_4) {
            _and_2 = false;
          } else {
            XExpression _else = ifExpr.getElse();
            boolean _equals_5 = Objects.equal(_else, null);
            _and_2 = _equals_5;
          }
          _or = _and_2;
        }
        return _or;
      }
    }
    if (!_matched) {
      if (Objects.equal(_eClass, XbasePackage.Literals.XWHILE_EXPRESSION)) {
        _matched=true;
        EStructuralFeature _eContainingFeature_4 = expr.eContainingFeature();
        return Objects.equal(_eContainingFeature_4, XbasePackage.Literals.XABSTRACT_WHILE_EXPRESSION__BODY);
      }
    }
    if (!_matched) {
      if (Objects.equal(_eClass, XbasePackage.Literals.XFOR_LOOP_EXPRESSION)) {
        _matched=true;
        EStructuralFeature _eContainingFeature_5 = expr.eContainingFeature();
        return Objects.equal(_eContainingFeature_5, XbasePackage.Literals.XFOR_LOOP_EXPRESSION__EACH_EXPRESSION);
      }
    }
    if (!_matched) {
      if (Objects.equal(_eClass, XbasePackage.Literals.XBASIC_FOR_LOOP_EXPRESSION)) {
        _matched=true;
        EStructuralFeature _eContainingFeature_6 = expr.eContainingFeature();
        return Objects.equal(_eContainingFeature_6, XbasePackage.Literals.XBASIC_FOR_LOOP_EXPRESSION__EACH_EXPRESSION);
      }
    }
    if (!_matched) {
      if (Objects.equal(_eClass, XbasePackage.Literals.XSYNCHRONIZED_EXPRESSION)) {
        _matched=true;
        EStructuralFeature _eContainingFeature_7 = expr.eContainingFeature();
        return Objects.equal(_eContainingFeature_7, XbasePackage.Literals.XSYNCHRONIZED_EXPRESSION__EXPRESSION);
      }
    }
    if (!_matched) {
      if (Objects.equal(_eClass, XbasePackage.Literals.XTRY_CATCH_FINALLY_EXPRESSION)) {
        _matched=true;
        EStructuralFeature _eContainingFeature_8 = expr.eContainingFeature();
        return Objects.equal(_eContainingFeature_8, XbasePackage.Literals.XTRY_CATCH_FINALLY_EXPRESSION__FINALLY_EXPRESSION);
      }
    }
    if (!_matched) {
      if (Objects.equal(_eClass, XbasePackage.Literals.XCATCH_CLAUSE)) {
        _matched=true;
        EObject _eContainer_5 = expr.eContainer();
        final XCatchClause catchClause = ((XCatchClause) _eContainer_5);
        EObject _eContainer_6 = catchClause.eContainer();
        final XTryCatchFinallyExpression tryCatchExpr = ((XTryCatchFinallyExpression) _eContainer_6);
        boolean _and_3 = false;
        XExpression _finallyExpression = tryCatchExpr.getFinallyExpression();
        boolean _equals_6 = Objects.equal(_finallyExpression, null);
        if (!_equals_6) {
          _and_3 = false;
        } else {
          EList<XCatchClause> _catchClauses = tryCatchExpr.getCatchClauses();
          XCatchClause _last_2 = IterableExtensions.<XCatchClause>last(_catchClauses);
          boolean _equals_7 = Objects.equal(catchClause, _last_2);
          _and_3 = _equals_7;
        }
        return _and_3;
      }
    }
    return false;
  }
  
  @Override
  protected void _format(final XIfExpression expr, @Extension final IFormattableDocument document) {
    ISemanticRegion _regionForKeyword = this.regionAccess.regionForKeyword(expr, "if");
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    document.append(_regionForKeyword, _function);
    XExpression _if = expr.getIf();
    final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    document.<XExpression>surround(_if, _function_1);
    XExpression _if_1 = expr.getIf();
    this.format(_if_1, document);
    XExpression _then = expr.getThen();
    boolean _not = (!(_then instanceof XBlockExpression));
    if (_not) {
      XExpression _then_1 = expr.getThen();
      final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.newLine();
          it.increaseIndentation();
        }
      };
      document.<XExpression>prepend(_then_1, _function_2);
      XExpression _else = expr.getElse();
      boolean _notEquals = (!Objects.equal(_else, null));
      if (_notEquals) {
        XExpression _then_2 = expr.getThen();
        final Procedure1<IHiddenRegionFormatter> _function_3 = new Procedure1<IHiddenRegionFormatter>() {
          @Override
          public void apply(final IHiddenRegionFormatter it) {
            it.newLine();
            it.decreaseIndentation();
          }
        };
        document.<XExpression>append(_then_2, _function_3);
      } else {
        XExpression _then_3 = expr.getThen();
        final Procedure1<IHiddenRegionFormatter> _function_4 = new Procedure1<IHiddenRegionFormatter>() {
          @Override
          public void apply(final IHiddenRegionFormatter it) {
            it.decreaseIndentation();
          }
        };
        document.<XExpression>append(_then_3, _function_4);
      }
    }
    XExpression _then_4 = expr.getThen();
    this.format(_then_4, document);
    XExpression _else_1 = expr.getElse();
    boolean _notEquals_1 = (!Objects.equal(_else_1, null));
    if (_notEquals_1) {
      XExpression _else_2 = expr.getElse();
      boolean _not_1 = (!(_else_2 instanceof XBlockExpression));
      if (_not_1) {
        XExpression _else_3 = expr.getElse();
        final Procedure1<IHiddenRegionFormatter> _function_5 = new Procedure1<IHiddenRegionFormatter>() {
          @Override
          public void apply(final IHiddenRegionFormatter it) {
            it.newLine();
            it.increaseIndentation();
          }
        };
        document.<XExpression>prepend(_else_3, _function_5);
        XExpression _else_4 = expr.getElse();
        final Procedure1<IHiddenRegionFormatter> _function_6 = new Procedure1<IHiddenRegionFormatter>() {
          @Override
          public void apply(final IHiddenRegionFormatter it) {
            it.decreaseIndentation();
          }
        };
        document.<XExpression>append(_else_4, _function_6);
      }
      XExpression _else_5 = expr.getElse();
      this.format(_else_5, document);
    }
  }
  
  @Override
  protected void _format(final XWhileExpression expr, @Extension final IFormattableDocument format) {
    ISemanticRegion _regionForKeyword = this.regionAccess.regionForKeyword(expr, "while");
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    format.append(_regionForKeyword, _function);
    XExpression _predicate = expr.getPredicate();
    final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    format.<XExpression>surround(_predicate, _function_1);
    XExpression _predicate_1 = expr.getPredicate();
    this.format(_predicate_1, format);
    XExpression _body = expr.getBody();
    boolean _not = (!(_body instanceof XBlockExpression));
    if (_not) {
      XExpression _body_1 = expr.getBody();
      final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.newLine();
          it.increaseIndentation();
        }
      };
      XExpression _prepend = format.<XExpression>prepend(_body_1, _function_2);
      final Procedure1<IHiddenRegionFormatter> _function_3 = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.decreaseIndentation();
        }
      };
      format.<XExpression>append(_prepend, _function_3);
    }
    XExpression _body_2 = expr.getBody();
    this.format(_body_2, format);
  }
  
  @Override
  protected void _format(final XDoWhileExpression expr, @Extension final IFormattableDocument format) {
    ISemanticRegion _regionForKeyword = this.regionAccess.regionForKeyword(expr, "while");
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    format.append(_regionForKeyword, _function);
    XExpression _predicate = expr.getPredicate();
    final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    format.<XExpression>surround(_predicate, _function_1);
    XExpression _predicate_1 = expr.getPredicate();
    this.format(_predicate_1, format);
    XExpression _body = expr.getBody();
    boolean _not = (!(_body instanceof XBlockExpression));
    if (_not) {
      XExpression _body_1 = expr.getBody();
      final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.newLine();
          it.increaseIndentation();
        }
      };
      XExpression _prepend = format.<XExpression>prepend(_body_1, _function_2);
      final Procedure1<IHiddenRegionFormatter> _function_3 = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.newLine();
          it.decreaseIndentation();
        }
      };
      format.<XExpression>append(_prepend, _function_3);
    }
    XExpression _body_2 = expr.getBody();
    this.format(_body_2, format);
  }
  
  @Override
  protected void _format(final XForLoopExpression expr, @Extension final IFormattableDocument format) {
    ISemanticRegion _regionForKeyword = this.regionAccess.regionForKeyword(expr, "for");
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    format.append(_regionForKeyword, _function);
    JvmFormalParameter _declaredParam = expr.getDeclaredParam();
    final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    JvmFormalParameter _prepend = format.<JvmFormalParameter>prepend(_declaredParam, _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    format.<JvmFormalParameter>append(_prepend, _function_2);
    XExpression _forExpression = expr.getForExpression();
    final Procedure1<IHiddenRegionFormatter> _function_3 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    XExpression _prepend_1 = format.<XExpression>prepend(_forExpression, _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    format.<XExpression>append(_prepend_1, _function_4);
    XExpression _forExpression_1 = expr.getForExpression();
    this.format(_forExpression_1, format);
    XExpression _eachExpression = expr.getEachExpression();
    boolean _not = (!(_eachExpression instanceof XBlockExpression));
    if (_not) {
      XExpression _eachExpression_1 = expr.getEachExpression();
      final Procedure1<IHiddenRegionFormatter> _function_5 = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.newLine();
          it.increaseIndentation();
        }
      };
      XExpression _prepend_2 = format.<XExpression>prepend(_eachExpression_1, _function_5);
      final Procedure1<IHiddenRegionFormatter> _function_6 = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.decreaseIndentation();
        }
      };
      format.<XExpression>append(_prepend_2, _function_6);
    }
    XExpression _eachExpression_2 = expr.getEachExpression();
    this.format(_eachExpression_2, format);
  }
  
  @Override
  protected void _format(final XBasicForLoopExpression expr, @Extension final IFormattableDocument format) {
    ISemanticRegion _regionForKeyword = this.regionAccess.regionForKeyword(expr, "for");
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    format.append(_regionForKeyword, _function);
    ISemanticRegion _regionForKeyword_1 = this.regionAccess.regionForKeyword(expr, "(");
    final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    format.append(_regionForKeyword_1, _function_1);
    List<ISemanticRegion> _regionsForKeywords = this.regionAccess.regionsForKeywords(expr, ";");
    final Procedure1<ISemanticRegion> _function_2 = new Procedure1<ISemanticRegion>() {
      @Override
      public void apply(final ISemanticRegion it) {
        final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
          @Override
          public void apply(final IHiddenRegionFormatter it) {
            it.noSpace();
          }
        };
        ISemanticRegion _prepend = format.prepend(it, _function);
        final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
          @Override
          public void apply(final IHiddenRegionFormatter it) {
            it.noSpace();
            it.lowPriority();
          }
        };
        format.append(_prepend, _function_1);
      }
    };
    IterableExtensions.<ISemanticRegion>forEach(_regionsForKeywords, _function_2);
    List<ISemanticRegion> _regionsForKeywords_1 = this.regionAccess.regionsForKeywords(expr, ",");
    final Procedure1<ISemanticRegion> _function_3 = new Procedure1<ISemanticRegion>() {
      @Override
      public void apply(final ISemanticRegion it) {
        final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
          @Override
          public void apply(final IHiddenRegionFormatter it) {
            it.noSpace();
          }
        };
        ISemanticRegion _prepend = format.prepend(it, _function);
        final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
          @Override
          public void apply(final IHiddenRegionFormatter it) {
            it.oneSpace();
          }
        };
        format.append(_prepend, _function_1);
      }
    };
    IterableExtensions.<ISemanticRegion>forEach(_regionsForKeywords_1, _function_3);
    ISemanticRegion _regionForKeyword_2 = this.regionAccess.regionForKeyword(expr, ")");
    final Procedure1<IHiddenRegionFormatter> _function_4 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    format.prepend(_regionForKeyword_2, _function_4);
    EList<XExpression> _initExpressions = expr.getInitExpressions();
    final Procedure1<XExpression> _function_5 = new Procedure1<XExpression>() {
      @Override
      public void apply(final XExpression it) {
        RuleEngineFormatter.this.format(it, format);
      }
    };
    IterableExtensions.<XExpression>forEach(_initExpressions, _function_5);
    XExpression _expression = expr.getExpression();
    final Procedure1<IHiddenRegionFormatter> _function_6 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    format.<XExpression>prepend(_expression, _function_6);
    XExpression _expression_1 = expr.getExpression();
    this.format(_expression_1, format);
    EList<XExpression> _updateExpressions = expr.getUpdateExpressions();
    XExpression _head = IterableExtensions.<XExpression>head(_updateExpressions);
    final Procedure1<IHiddenRegionFormatter> _function_7 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    format.<XExpression>prepend(_head, _function_7);
    EList<XExpression> _updateExpressions_1 = expr.getUpdateExpressions();
    final Procedure1<XExpression> _function_8 = new Procedure1<XExpression>() {
      @Override
      public void apply(final XExpression it) {
        RuleEngineFormatter.this.format(it, format);
      }
    };
    IterableExtensions.<XExpression>forEach(_updateExpressions_1, _function_8);
    XExpression _eachExpression = expr.getEachExpression();
    boolean _not = (!(_eachExpression instanceof XBlockExpression));
    if (_not) {
      XExpression _eachExpression_1 = expr.getEachExpression();
      final Procedure1<IHiddenRegionFormatter> _function_9 = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.newLine();
          it.increaseIndentation();
        }
      };
      XExpression _prepend = format.<XExpression>prepend(_eachExpression_1, _function_9);
      final Procedure1<IHiddenRegionFormatter> _function_10 = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.decreaseIndentation();
        }
      };
      format.<XExpression>append(_prepend, _function_10);
    }
    XExpression _eachExpression_2 = expr.getEachExpression();
    this.format(_eachExpression_2, format);
  }
  
  @Override
  protected void _format(final XSynchronizedExpression expr, @Extension final IFormattableDocument format) {
    XExpression _param = expr.getParam();
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    format.<XExpression>surround(_param, _function);
    XExpression _param_1 = expr.getParam();
    this.format(_param_1, format);
    XExpression _expression = expr.getExpression();
    boolean _not = (!(_expression instanceof XBlockExpression));
    if (_not) {
      XExpression _expression_1 = expr.getExpression();
      final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.newLine();
          it.increaseIndentation();
        }
      };
      XExpression _prepend = format.<XExpression>prepend(_expression_1, _function_1);
      final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.decreaseIndentation();
        }
      };
      format.<XExpression>append(_prepend, _function_2);
    }
    XExpression _expression_2 = expr.getExpression();
    this.format(_expression_2, format);
  }
  
  @Override
  protected void _format(final XTryCatchFinallyExpression expr, @Extension final IFormattableDocument format) {
    XExpression _expression = expr.getExpression();
    boolean _not = (!(_expression instanceof XBlockExpression));
    if (_not) {
      XExpression _expression_1 = expr.getExpression();
      final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.newLine();
          it.increaseIndentation();
        }
      };
      XExpression _prepend = format.<XExpression>prepend(_expression_1, _function);
      final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.decreaseIndentation();
        }
      };
      format.<XExpression>append(_prepend, _function_1);
    }
    XExpression _expression_2 = expr.getExpression();
    this.format(_expression_2, format);
    EList<XCatchClause> _catchClauses = expr.getCatchClauses();
    for (final XCatchClause cc : _catchClauses) {
      {
        XExpression _expression_3 = cc.getExpression();
        boolean _not_1 = (!(_expression_3 instanceof XBlockExpression));
        if (_not_1) {
          XExpression _expression_4 = cc.getExpression();
          final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
            @Override
            public void apply(final IHiddenRegionFormatter it) {
              it.newLine();
              it.increaseIndentation();
            }
          };
          format.<XExpression>prepend(_expression_4, _function_2);
          boolean _or = false;
          EList<XCatchClause> _catchClauses_1 = expr.getCatchClauses();
          XCatchClause _last = IterableExtensions.<XCatchClause>last(_catchClauses_1);
          boolean _notEquals = (!Objects.equal(cc, _last));
          if (_notEquals) {
            _or = true;
          } else {
            XExpression _finallyExpression = expr.getFinallyExpression();
            boolean _notEquals_1 = (!Objects.equal(_finallyExpression, null));
            _or = _notEquals_1;
          }
          if (_or) {
            XExpression _expression_5 = cc.getExpression();
            final Procedure1<IHiddenRegionFormatter> _function_3 = new Procedure1<IHiddenRegionFormatter>() {
              @Override
              public void apply(final IHiddenRegionFormatter it) {
                it.newLine();
                it.decreaseIndentation();
              }
            };
            format.<XExpression>append(_expression_5, _function_3);
          } else {
            XExpression _expression_6 = cc.getExpression();
            final Procedure1<IHiddenRegionFormatter> _function_4 = new Procedure1<IHiddenRegionFormatter>() {
              @Override
              public void apply(final IHiddenRegionFormatter it) {
                it.decreaseIndentation();
              }
            };
            format.<XExpression>append(_expression_6, _function_4);
          }
        }
        this.format(cc, format);
      }
    }
    XExpression _finallyExpression = expr.getFinallyExpression();
    boolean _notEquals = (!Objects.equal(_finallyExpression, null));
    if (_notEquals) {
      XExpression _finallyExpression_1 = expr.getFinallyExpression();
      boolean _not_1 = (!(_finallyExpression_1 instanceof XBlockExpression));
      if (_not_1) {
        XExpression _finallyExpression_2 = expr.getFinallyExpression();
        final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
          @Override
          public void apply(final IHiddenRegionFormatter it) {
            it.newLine();
            it.increaseIndentation();
          }
        };
        XExpression _prepend_1 = format.<XExpression>prepend(_finallyExpression_2, _function_2);
        final Procedure1<IHiddenRegionFormatter> _function_3 = new Procedure1<IHiddenRegionFormatter>() {
          @Override
          public void apply(final IHiddenRegionFormatter it) {
            it.decreaseIndentation();
          }
        };
        format.<XExpression>append(_prepend_1, _function_3);
      }
      XExpression _finallyExpression_3 = expr.getFinallyExpression();
      this.format(_finallyExpression_3, format);
    }
  }
  
  @Override
  protected void _format(final XCatchClause expr, @Extension final IFormattableDocument format) {
    ISemanticRegion _regionForKeyword = this.regionAccess.regionForKeyword(expr, "catch");
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    format.append(_regionForKeyword, _function);
    JvmFormalParameter _declaredParam = expr.getDeclaredParam();
    final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    format.<JvmFormalParameter>surround(_declaredParam, _function_1);
    JvmFormalParameter _declaredParam_1 = expr.getDeclaredParam();
    this.format(_declaredParam_1, format);
    XExpression _expression = expr.getExpression();
    this.format(_expression, format);
  }
  
  public void format(final Object expr, final IFormattableDocument format) {
    if (expr instanceof JvmTypeParameter) {
      _format((JvmTypeParameter)expr, format);
      return;
    } else if (expr instanceof JvmFormalParameter) {
      _format((JvmFormalParameter)expr, format);
      return;
    } else if (expr instanceof XtextResource) {
      _format((XtextResource)expr, format);
      return;
    } else if (expr instanceof XAssignment) {
      _format((XAssignment)expr, format);
      return;
    } else if (expr instanceof XBinaryOperation) {
      _format((XBinaryOperation)expr, format);
      return;
    } else if (expr instanceof XDoWhileExpression) {
      _format((XDoWhileExpression)expr, format);
      return;
    } else if (expr instanceof XFeatureCall) {
      _format((XFeatureCall)expr, format);
      return;
    } else if (expr instanceof XMemberFeatureCall) {
      _format((XMemberFeatureCall)expr, format);
      return;
    } else if (expr instanceof XPostfixOperation) {
      _format((XPostfixOperation)expr, format);
      return;
    } else if (expr instanceof XWhileExpression) {
      _format((XWhileExpression)expr, format);
      return;
    } else if (expr instanceof XFunctionTypeRef) {
      _format((XFunctionTypeRef)expr, format);
      return;
    } else if (expr instanceof JvmGenericArrayTypeReference) {
      _format((JvmGenericArrayTypeReference)expr, format);
      return;
    } else if (expr instanceof JvmParameterizedTypeReference) {
      _format((JvmParameterizedTypeReference)expr, format);
      return;
    } else if (expr instanceof JvmWildcardTypeReference) {
      _format((JvmWildcardTypeReference)expr, format);
      return;
    } else if (expr instanceof Device) {
      _format((Device)expr, format);
      return;
    } else if (expr instanceof Rule) {
      _format((Rule)expr, format);
      return;
    } else if (expr instanceof XBasicForLoopExpression) {
      _format((XBasicForLoopExpression)expr, format);
      return;
    } else if (expr instanceof XBlockExpression) {
      _format((XBlockExpression)expr, format);
      return;
    } else if (expr instanceof XCastedExpression) {
      _format((XCastedExpression)expr, format);
      return;
    } else if (expr instanceof XClosure) {
      _format((XClosure)expr, format);
      return;
    } else if (expr instanceof XCollectionLiteral) {
      _format((XCollectionLiteral)expr, format);
      return;
    } else if (expr instanceof XConstructorCall) {
      _format((XConstructorCall)expr, format);
      return;
    } else if (expr instanceof XForLoopExpression) {
      _format((XForLoopExpression)expr, format);
      return;
    } else if (expr instanceof XIfExpression) {
      _format((XIfExpression)expr, format);
      return;
    } else if (expr instanceof XInstanceOfExpression) {
      _format((XInstanceOfExpression)expr, format);
      return;
    } else if (expr instanceof XReturnExpression) {
      _format((XReturnExpression)expr, format);
      return;
    } else if (expr instanceof XSwitchExpression) {
      _format((XSwitchExpression)expr, format);
      return;
    } else if (expr instanceof XSynchronizedExpression) {
      _format((XSynchronizedExpression)expr, format);
      return;
    } else if (expr instanceof XThrowExpression) {
      _format((XThrowExpression)expr, format);
      return;
    } else if (expr instanceof XTryCatchFinallyExpression) {
      _format((XTryCatchFinallyExpression)expr, format);
      return;
    } else if (expr instanceof XTypeLiteral) {
      _format((XTypeLiteral)expr, format);
      return;
    } else if (expr instanceof XVariableDeclaration) {
      _format((XVariableDeclaration)expr, format);
      return;
    } else if (expr instanceof JvmTypeConstraint) {
      _format((JvmTypeConstraint)expr, format);
      return;
    } else if (expr instanceof Model) {
      _format((Model)expr, format);
      return;
    } else if (expr instanceof XCatchClause) {
      _format((XCatchClause)expr, format);
      return;
    } else if (expr instanceof XExpression) {
      _format((XExpression)expr, format);
      return;
    } else if (expr instanceof XImportDeclaration) {
      _format((XImportDeclaration)expr, format);
      return;
    } else if (expr instanceof XImportSection) {
      _format((XImportSection)expr, format);
      return;
    } else if (expr == null) {
      _format((Void)null, format);
      return;
    } else if (expr != null) {
      _format(expr, format);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(expr, format).toString());
    }
  }
}
