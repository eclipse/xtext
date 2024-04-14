/**
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.homeautomation.formatting2;

import java.util.Arrays;
import java.util.Objects;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
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
import org.eclipse.xtext.example.homeautomation.ruleEngine.RuleEnginePackage;
import org.eclipse.xtext.example.homeautomation.ruleEngine.State;
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

@SuppressWarnings("all")
public class RuleEngineFormatter extends XbaseFormatter {
  protected void _format(final Model model, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.setNewLines(0, 0, 1);
      it.noSpace();
    };
    document.<Model>prepend(model, _function);
    EList<Declaration> _declarations = model.getDeclarations();
    for (final Declaration declaration : _declarations) {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
        it.setNewLines(1, 1, 2);
      };
      document.<Declaration>append(document.<Declaration>format(declaration), _function_1);
    }
  }

  protected void _format(final Device device, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.regionFor(device).feature(RuleEnginePackage.Literals.DEVICE__NAME), _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.regionFor(device).keyword("be"), _function_1);
    EList<State> _states = device.getStates();
    for (final State state : _states) {
      final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
        it.noSpace();
      };
      final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
        it.oneSpace();
      };
      document.append(document.prepend(this.immediatelyPreceding(document.<State>format(state)).keyword(","), _function_2), _function_3);
    }
  }

  protected void _format(final Rule rule, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.regionFor(rule).feature(RuleEnginePackage.Literals.RULE__DESCRIPTION), _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.regionFor(rule).feature(RuleEnginePackage.Literals.RULE__DEVICE_STATE), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.<XExpression>prepend(document.<XExpression>format(rule.getThenPart()), _function_2);
  }

  @Override
  protected void _format(final XBlockExpression expr, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<XBlockExpression>surround(expr, _function);
    EList<XExpression> _expressions = expr.getExpressions();
    for (final XExpression child : _expressions) {
      {
        final ISemanticRegion sem = this.immediatelyFollowing(child).keyword(";");
        if ((sem != null)) {
          final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
            it.noSpace();
          };
          document.prepend(sem, _function_1);
          XExpression _lastOrNull = IterableExtensions.<XExpression>lastOrNull(expr.getExpressions());
          boolean _notEquals = (!Objects.equals(child, _lastOrNull));
          if (_notEquals) {
            final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
              it.newLine();
            };
            document.append(sem, _function_2);
          }
        } else {
          XExpression _lastOrNull_1 = IterableExtensions.<XExpression>lastOrNull(expr.getExpressions());
          boolean _notEquals_1 = (!Objects.equals(child, _lastOrNull_1));
          if (_notEquals_1) {
            final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
              it.newLine();
            };
            document.<XExpression>append(child, _function_3);
          }
        }
        document.<XExpression>format(child);
      }
    }
  }

  @Override
  protected void _format(final XSwitchExpression expr, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.set(this.previousHiddenRegion(expr.getSwitch()), this.nextHiddenRegion(expr), _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.regionFor(expr).keyword("switch"), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.<XExpression>format(document.<XExpression>append(expr.getSwitch(), _function_2));
    EList<XCasePart> _cases = expr.getCases();
    for (final XCasePart c : _cases) {
      {
        if (((c.getTypeGuard() != null) && (c.getCase() != null))) {
          final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
            it.oneSpace();
          };
          document.<JvmTypeReference>append(c.getTypeGuard(), _function_3);
          final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
            it.noSpace();
          };
          document.<XExpression>append(c.getCase(), _function_4);
        } else {
          JvmTypeReference _typeGuard = c.getTypeGuard();
          boolean _tripleNotEquals = (_typeGuard != null);
          if (_tripleNotEquals) {
            final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
              it.noSpace();
            };
            document.<JvmTypeReference>append(c.getTypeGuard(), _function_5);
          } else {
            XExpression _case = c.getCase();
            boolean _tripleNotEquals_1 = (_case != null);
            if (_tripleNotEquals_1) {
              final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
                it.oneSpace();
              };
              final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
                it.noSpace();
              };
              document.<XExpression>append(document.<XExpression>prepend(c.getCase(), _function_6), _function_7);
            }
          }
        }
        final Procedure1<IHiddenRegionFormatter> _function_8 = (IHiddenRegionFormatter it) -> {
          it.noSpace();
        };
        final Procedure1<IHiddenRegionFormatter> _function_9 = (IHiddenRegionFormatter it) -> {
          it.newLine();
        };
        document.append(document.prepend(this.regionFor(c).feature(XbasePackage.Literals.XCASE_PART__FALL_THROUGH), _function_8), _function_9);
        document.<XExpression>format(c.getCase());
        if ((Objects.equals(c, IterableExtensions.<XCasePart>lastOrNull(expr.getCases())) && (expr.getDefault() == null))) {
          this.formatBody(c.getThen(), true, document);
        } else {
          this.formatBodyParagraph(c.getThen(), document);
        }
      }
    }
    XExpression _default = expr.getDefault();
    boolean _tripleNotEquals = (_default != null);
    if (_tripleNotEquals) {
      final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
        it.noSpace();
      };
      document.append(this.regionFor(expr).keyword("default"), _function_3);
      this.formatBody(expr.getDefault(), true, document);
    }
  }

  @Override
  protected void formatBody(final XExpression expr, final boolean forceMultiline, @Extension final IFormattableDocument doc) {
    if ((expr == null)) {
      return;
    }
    if ((expr instanceof XBlockExpression)) {
      final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
        it.newLine();
      };
      doc.<XBlockExpression>prepend(((XBlockExpression)expr), _function);
    } else {
      if ((forceMultiline || this.previousHiddenRegion(expr).isMultiline())) {
        final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
          it.newLine();
        };
        final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
          it.indent();
        };
        doc.<XExpression>surround(doc.<XExpression>prepend(expr, _function_1), _function_2);
      } else {
        final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
          it.oneSpace();
        };
        doc.<XExpression>prepend(expr, _function_3);
      }
    }
    doc.<XExpression>format(expr);
  }

  @Override
  protected void formatBodyInline(final XExpression expr, final boolean forceMultiline, @Extension final IFormattableDocument doc) {
    if ((expr == null)) {
      return;
    }
    if ((expr instanceof XBlockExpression)) {
      final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
        it.newLine();
      };
      doc.<XBlockExpression>surround(((XBlockExpression)expr), _function);
    } else {
      if ((forceMultiline || this.previousHiddenRegion(expr).isMultiline())) {
        final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
          it.newLine();
        };
        final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
          it.indent();
        };
        final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
          it.newLine();
        };
        doc.<XExpression>append(doc.<XExpression>surround(doc.<XExpression>prepend(expr, _function_1), _function_2), _function_3);
      } else {
        final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
          it.oneSpace();
        };
        doc.<XExpression>surround(expr, _function_4);
      }
    }
    doc.<XExpression>format(expr);
  }

  @Override
  protected void formatBodyParagraph(final XExpression expr, @Extension final IFormattableDocument doc) {
    if ((expr == null)) {
      return;
    }
    if ((expr instanceof XBlockExpression)) {
      final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
        it.newLine();
      };
      doc.<XBlockExpression>surround(((XBlockExpression)expr), _function);
    } else {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
        it.oneSpace();
      };
      doc.<XExpression>surround(expr, _function_1);
    }
    doc.<XExpression>format(expr);
  }

  @Override
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
    } else if (device instanceof XPostfixOperation) {
      _format((XPostfixOperation)device, document);
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
    } else if (device instanceof XCastedExpression) {
      _format((XCastedExpression)device, document);
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
    } else if (device instanceof XInstanceOfExpression) {
      _format((XInstanceOfExpression)device, document);
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
    } else if (device instanceof XExpression) {
      _format((XExpression)device, document);
      return;
    } else if (device instanceof XImportDeclaration) {
      _format((XImportDeclaration)device, document);
      return;
    } else if (device instanceof XImportSection) {
      _format((XImportSection)device, document);
      return;
    } else if (device instanceof EObject) {
      _format((EObject)device, document);
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
