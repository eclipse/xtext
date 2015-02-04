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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
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
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XCollectionLiteral;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XDoWhileExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
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
    Model _prepend = document.<Model>prepend(model, _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.newLine();
      }
    };
    document.<Model>append(_prepend, _function_1);
    EList<Declaration> _declarations = model.getDeclarations();
    for (final Declaration declaration : _declarations) {
      this.format(declaration, document);
    }
  }
  
  protected void _format(final Device device, @Extension final IFormattableDocument document) {
    EList<State> _states = device.getStates();
    for (final State state : _states) {
      this.format(state, document);
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
        it.newLine();
        it.increaseIndentation();
        it.noSpace();
      }
    };
    document.prepend(begin, _function);
    TerminalRule _eNDRule = this._ruleEngineGrammarAccess.getENDRule();
    final ISemanticRegion end = this.regionAccess.regionForRuleCallTo(expr, _eNDRule);
    final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.newLine();
        it.decreaseIndentation();
        it.noSpace();
      }
    };
    document.append(end, _function_1);
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(begin, null));
    if (!_notEquals) {
      _and = false;
    } else {
      boolean _notEquals_1 = (!Objects.equal(end, null));
      _and = _notEquals_1;
    }
    if (_and) {
      EList<XExpression> _expressions = expr.getExpressions();
      this.formatExpressionsMultiline(_expressions, begin, end, document);
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
    final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.newLine();
        it.decreaseIndentation();
        it.noSpace();
      }
    };
    document.append(end, _function_2);
    EList<XCasePart> _cases = expr.getCases();
    for (final XCasePart c : _cases) {
      XExpression _then = c.getThen();
      if ((_then instanceof XBlockExpression)) {
        XExpression _then_1 = c.getThen();
        final Procedure1<IHiddenRegionFormatter> _function_3 = new Procedure1<IHiddenRegionFormatter>() {
          @Override
          public void apply(final IHiddenRegionFormatter it) {
            it.newLine();
          }
        };
        document.<XExpression>prepend(_then_1, _function_3);
        boolean _or = false;
        XExpression _default = expr.getDefault();
        boolean _notEquals = (!Objects.equal(_default, null));
        if (_notEquals) {
          _or = true;
        } else {
          EList<XCasePart> _cases_1 = expr.getCases();
          XCasePart _last = IterableExtensions.<XCasePart>last(_cases_1);
          boolean _notEquals_1 = (!Objects.equal(c, _last));
          _or = _notEquals_1;
        }
        if (_or) {
          XExpression _then_2 = c.getThen();
          final Procedure1<IHiddenRegionFormatter> _function_4 = new Procedure1<IHiddenRegionFormatter>() {
            @Override
            public void apply(final IHiddenRegionFormatter it) {
              it.newLine();
            }
          };
          document.<XExpression>append(_then_2, _function_4);
        }
      } else {
        boolean _isFallThrough = c.isFallThrough();
        if (_isFallThrough) {
          ISemanticRegion _regionForFeature = this.regionAccess.regionForFeature(c, XbasePackage.Literals.XCASE_PART__FALL_THROUGH);
          final Procedure1<IHiddenRegionFormatter> _function_5 = new Procedure1<IHiddenRegionFormatter>() {
            @Override
            public void apply(final IHiddenRegionFormatter it) {
              it.noSpace();
            }
          };
          ISemanticRegion _prepend = document.prepend(_regionForFeature, _function_5);
          final Procedure1<IHiddenRegionFormatter> _function_6 = new Procedure1<IHiddenRegionFormatter>() {
            @Override
            public void apply(final IHiddenRegionFormatter it) {
              it.newLine();
            }
          };
          document.append(_prepend, _function_6);
        } else {
          XExpression _then_3 = c.getThen();
          final Procedure1<IHiddenRegionFormatter> _function_7 = new Procedure1<IHiddenRegionFormatter>() {
            @Override
            public void apply(final IHiddenRegionFormatter it) {
              it.newLine();
              it.increaseIndentation();
            }
          };
          document.<XExpression>prepend(_then_3, _function_7);
          boolean _or_1 = false;
          XExpression _default_1 = expr.getDefault();
          boolean _notEquals_2 = (!Objects.equal(_default_1, null));
          if (_notEquals_2) {
            _or_1 = true;
          } else {
            EList<XCasePart> _cases_2 = expr.getCases();
            XCasePart _last_1 = IterableExtensions.<XCasePart>last(_cases_2);
            boolean _notEquals_3 = (!Objects.equal(c, _last_1));
            _or_1 = _notEquals_3;
          }
          if (_or_1) {
            XExpression _then_4 = c.getThen();
            final Procedure1<IHiddenRegionFormatter> _function_8 = new Procedure1<IHiddenRegionFormatter>() {
              @Override
              public void apply(final IHiddenRegionFormatter it) {
                it.newLine();
                it.decreaseIndentation();
              }
            };
            document.<XExpression>append(_then_4, _function_8);
          } else {
            XExpression _then_5 = c.getThen();
            final Procedure1<IHiddenRegionFormatter> _function_9 = new Procedure1<IHiddenRegionFormatter>() {
              @Override
              public void apply(final IHiddenRegionFormatter it) {
                it.decreaseIndentation();
              }
            };
            document.<XExpression>append(_then_5, _function_9);
          }
        }
      }
    }
    XExpression _default_2 = expr.getDefault();
    boolean _notEquals_4 = (!Objects.equal(_default_2, null));
    if (_notEquals_4) {
      ISemanticRegion _regionForKeyword_1 = this.regionAccess.regionForKeyword(expr, "default");
      final Procedure1<IHiddenRegionFormatter> _function_10 = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.noSpace();
        }
      };
      document.append(_regionForKeyword_1, _function_10);
      XExpression _default_3 = expr.getDefault();
      if ((_default_3 instanceof XBlockExpression)) {
        XExpression _default_4 = expr.getDefault();
        final Procedure1<IHiddenRegionFormatter> _function_11 = new Procedure1<IHiddenRegionFormatter>() {
          @Override
          public void apply(final IHiddenRegionFormatter it) {
            it.newLine();
          }
        };
        XExpression _prepend_1 = document.<XExpression>prepend(_default_4, _function_11);
        final Procedure1<IHiddenRegionFormatter> _function_12 = new Procedure1<IHiddenRegionFormatter>() {
          @Override
          public void apply(final IHiddenRegionFormatter it) {
            it.newLine();
            it.decreaseIndentation();
          }
        };
        document.<XExpression>append(_prepend_1, _function_12);
      } else {
        XExpression _default_5 = expr.getDefault();
        final Procedure1<IHiddenRegionFormatter> _function_13 = new Procedure1<IHiddenRegionFormatter>() {
          @Override
          public void apply(final IHiddenRegionFormatter it) {
            it.newLine();
            it.increaseIndentation();
          }
        };
        XExpression _prepend_2 = document.<XExpression>prepend(_default_5, _function_13);
        final Procedure1<IHiddenRegionFormatter> _function_14 = new Procedure1<IHiddenRegionFormatter>() {
          @Override
          public void apply(final IHiddenRegionFormatter it) {
            it.decreaseIndentation();
          }
        };
        document.<XExpression>append(_prepend_2, _function_14);
      }
    }
    EList<XCasePart> _cases_3 = expr.getCases();
    for (final XCasePart c_1 : _cases_3) {
      {
        boolean _and = false;
        JvmTypeReference _typeGuard = c_1.getTypeGuard();
        boolean _notEquals_5 = (!Objects.equal(_typeGuard, null));
        if (!_notEquals_5) {
          _and = false;
        } else {
          XExpression _case = c_1.getCase();
          boolean _notEquals_6 = (!Objects.equal(_case, null));
          _and = _notEquals_6;
        }
        if (_and) {
          JvmTypeReference _typeGuard_1 = c_1.getTypeGuard();
          final Procedure1<IHiddenRegionFormatter> _function_15 = new Procedure1<IHiddenRegionFormatter>() {
            @Override
            public void apply(final IHiddenRegionFormatter it) {
              it.oneSpace();
            }
          };
          document.<JvmTypeReference>append(_typeGuard_1, _function_15);
          XExpression _case_1 = c_1.getCase();
          final Procedure1<IHiddenRegionFormatter> _function_16 = new Procedure1<IHiddenRegionFormatter>() {
            @Override
            public void apply(final IHiddenRegionFormatter it) {
              it.oneSpace();
            }
          };
          XExpression _prepend_3 = document.<XExpression>prepend(_case_1, _function_16);
          final Procedure1<IHiddenRegionFormatter> _function_17 = new Procedure1<IHiddenRegionFormatter>() {
            @Override
            public void apply(final IHiddenRegionFormatter it) {
              it.noSpace();
            }
          };
          document.<XExpression>append(_prepend_3, _function_17);
        } else {
          JvmTypeReference _typeGuard_2 = c_1.getTypeGuard();
          boolean _notEquals_7 = (!Objects.equal(_typeGuard_2, null));
          if (_notEquals_7) {
            JvmTypeReference _typeGuard_3 = c_1.getTypeGuard();
            final Procedure1<IHiddenRegionFormatter> _function_18 = new Procedure1<IHiddenRegionFormatter>() {
              @Override
              public void apply(final IHiddenRegionFormatter it) {
                it.noSpace();
              }
            };
            document.<JvmTypeReference>append(_typeGuard_3, _function_18);
          } else {
            XExpression _case_2 = c_1.getCase();
            boolean _notEquals_8 = (!Objects.equal(_case_2, null));
            if (_notEquals_8) {
              XExpression _case_3 = c_1.getCase();
              final Procedure1<IHiddenRegionFormatter> _function_19 = new Procedure1<IHiddenRegionFormatter>() {
                @Override
                public void apply(final IHiddenRegionFormatter it) {
                  it.oneSpace();
                }
              };
              XExpression _prepend_4 = document.<XExpression>prepend(_case_3, _function_19);
              final Procedure1<IHiddenRegionFormatter> _function_20 = new Procedure1<IHiddenRegionFormatter>() {
                @Override
                public void apply(final IHiddenRegionFormatter it) {
                  it.noSpace();
                }
              };
              document.<XExpression>append(_prepend_4, _function_20);
            }
          }
        }
        XExpression _case_4 = c_1.getCase();
        this.format(_case_4, document);
        XExpression _then_6 = c_1.getThen();
        this.format(_then_6, document);
      }
    }
    XExpression _default_6 = expr.getDefault();
    boolean _notEquals_5 = (!Objects.equal(_default_6, null));
    if (_notEquals_5) {
      XExpression _default_7 = expr.getDefault();
      this.format(_default_7, document);
    }
  }
  
  @Override
  protected void _format(final XIfExpression expr, @Extension final IFormattableDocument document) {
    EObject _eContainer = expr.eContainer();
    if ((_eContainer instanceof XVariableDeclaration)) {
      ISemanticRegion _regionForKeyword = this.regionAccess.regionForKeyword(expr, "if");
      final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.increaseIndentation();
        }
      };
      document.append(_regionForKeyword, _function);
      final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.decreaseIndentation();
        }
      };
      document.<XIfExpression>append(expr, _function_1);
    }
    XExpression _if = expr.getIf();
    final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    document.<XExpression>surround(_if, _function_2);
    ISemanticRegion _regionForKeyword_1 = this.regionAccess.regionForKeyword(expr, "if");
    final Procedure1<IHiddenRegionFormatter> _function_3 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    document.append(_regionForKeyword_1, _function_3);
    XExpression _then = expr.getThen();
    if ((!(_then instanceof XBlockExpression))) {
      XExpression _then_1 = expr.getThen();
      final Procedure1<IHiddenRegionFormatter> _function_4 = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.newLine();
          it.increaseIndentation();
        }
      };
      document.<XExpression>prepend(_then_1, _function_4);
      XExpression _then_2 = expr.getThen();
      final Procedure1<IHiddenRegionFormatter> _function_5 = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.newLine();
          it.decreaseIndentation();
        }
      };
      document.<XExpression>append(_then_2, _function_5);
    }
    XExpression _else = expr.getElse();
    if ((!(_else instanceof XBlockExpression))) {
      XExpression _else_1 = expr.getElse();
      final Procedure1<IHiddenRegionFormatter> _function_6 = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.newLine();
          it.increaseIndentation();
        }
      };
      document.<XExpression>prepend(_else_1, _function_6);
      XExpression _else_2 = expr.getElse();
      final Procedure1<IHiddenRegionFormatter> _function_7 = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.newLine();
          it.decreaseIndentation();
        }
      };
      document.<XExpression>append(_else_2, _function_7);
    }
    XExpression _if_1 = expr.getIf();
    this.format(_if_1, document);
    XExpression _then_3 = expr.getThen();
    this.format(_then_3, document);
    XExpression _else_3 = expr.getElse();
    boolean _notEquals = (!Objects.equal(_else_3, null));
    if (_notEquals) {
      XExpression _else_4 = expr.getElse();
      this.format(_else_4, document);
    }
  }
  
  public void format(final Object device, final IFormattableDocument document) {
    if (device instanceof JvmTypeParameter) {
      _format((JvmTypeParameter)device, document);
      return;
    } else if (device instanceof JvmFormalParameter) {
      _format((JvmFormalParameter)device, document);
      return;
    } else if (device instanceof XtextResource) {
      _format((XtextResource)device, document);
      return;
    } else if (device instanceof XAssignment) {
      _format((XAssignment)device, document);
      return;
    } else if (device instanceof XBinaryOperation) {
      _format((XBinaryOperation)device, document);
      return;
    } else if (device instanceof XDoWhileExpression) {
      _format((XDoWhileExpression)device, document);
      return;
    } else if (device instanceof XFeatureCall) {
      _format((XFeatureCall)device, document);
      return;
    } else if (device instanceof XMemberFeatureCall) {
      _format((XMemberFeatureCall)device, document);
      return;
    } else if (device instanceof XWhileExpression) {
      _format((XWhileExpression)device, document);
      return;
    } else if (device instanceof XFunctionTypeRef) {
      _format((XFunctionTypeRef)device, document);
      return;
    } else if (device instanceof JvmGenericArrayTypeReference) {
      _format((JvmGenericArrayTypeReference)device, document);
      return;
    } else if (device instanceof JvmParameterizedTypeReference) {
      _format((JvmParameterizedTypeReference)device, document);
      return;
    } else if (device instanceof JvmWildcardTypeReference) {
      _format((JvmWildcardTypeReference)device, document);
      return;
    } else if (device instanceof Device) {
      _format((Device)device, document);
      return;
    } else if (device instanceof Rule) {
      _format((Rule)device, document);
      return;
    } else if (device instanceof XBasicForLoopExpression) {
      _format((XBasicForLoopExpression)device, document);
      return;
    } else if (device instanceof XBlockExpression) {
      _format((XBlockExpression)device, document);
      return;
    } else if (device instanceof XClosure) {
      _format((XClosure)device, document);
      return;
    } else if (device instanceof XCollectionLiteral) {
      _format((XCollectionLiteral)device, document);
      return;
    } else if (device instanceof XConstructorCall) {
      _format((XConstructorCall)device, document);
      return;
    } else if (device instanceof XForLoopExpression) {
      _format((XForLoopExpression)device, document);
      return;
    } else if (device instanceof XIfExpression) {
      _format((XIfExpression)device, document);
      return;
    } else if (device instanceof XReturnExpression) {
      _format((XReturnExpression)device, document);
      return;
    } else if (device instanceof XSwitchExpression) {
      _format((XSwitchExpression)device, document);
      return;
    } else if (device instanceof XSynchronizedExpression) {
      _format((XSynchronizedExpression)device, document);
      return;
    } else if (device instanceof XThrowExpression) {
      _format((XThrowExpression)device, document);
      return;
    } else if (device instanceof XTryCatchFinallyExpression) {
      _format((XTryCatchFinallyExpression)device, document);
      return;
    } else if (device instanceof XTypeLiteral) {
      _format((XTypeLiteral)device, document);
      return;
    } else if (device instanceof XVariableDeclaration) {
      _format((XVariableDeclaration)device, document);
      return;
    } else if (device instanceof JvmTypeConstraint) {
      _format((JvmTypeConstraint)device, document);
      return;
    } else if (device instanceof Model) {
      _format((Model)device, document);
      return;
    } else if (device instanceof XCatchClause) {
      _format((XCatchClause)device, document);
      return;
    } else if (device instanceof XExpression) {
      _format((XExpression)device, document);
      return;
    } else if (device instanceof XImportDeclaration) {
      _format((XImportDeclaration)device, document);
      return;
    } else if (device instanceof XImportSection) {
      _format((XImportSection)device, document);
      return;
    } else if (device == null) {
      _format((Void)null, document);
      return;
    } else if (device != null) {
      _format(device, document);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(device, document).toString());
    }
  }
}
