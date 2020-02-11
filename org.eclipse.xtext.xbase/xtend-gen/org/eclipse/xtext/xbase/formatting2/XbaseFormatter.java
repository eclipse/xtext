/**
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.formatting2;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IFormattableSubDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.ISubFormatter;
import org.eclipse.xtext.formatting2.regionaccess.IEObjectRegion;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegionsFinder;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.internal.TextSegment;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
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
import org.eclipse.xtext.xbase.formatting2.ArrayBracketsFormattingReplacer;
import org.eclipse.xtext.xbase.formatting2.IndentOnceAutowrapFormatter;
import org.eclipse.xtext.xbase.formatting2.ObjectEntry;
import org.eclipse.xtext.xbase.formatting2.SeparatorEntry;
import org.eclipse.xtext.xbase.formatting2.SeparatorRegions;
import org.eclipse.xtext.xbase.formatting2.XbaseFormatterPreferenceKeys;
import org.eclipse.xtext.xbase.formatting2.XtypeFormatter;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;

/**
 * @author Moritz Eysholdt - Initial implementation and API
 * @author Lorenzo Bettini - https://bugs.eclipse.org/bugs/show_bug.cgi?id=471239
 */
@SuppressWarnings("all")
public class XbaseFormatter extends XtypeFormatter {
  @Inject
  @Accessors(AccessorType.PUBLIC_GETTER)
  @Extension
  private XbaseGrammarAccess grammar;
  
  protected void _format(final XCollectionLiteral literal, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.append(this.textRegionExtensions.regionFor(literal).keyword("#"), _function);
    ISemanticRegion _elvis = null;
    ISemanticRegion _keyword = this.textRegionExtensions.regionFor(literal).keyword("[");
    if (_keyword != null) {
      _elvis = _keyword;
    } else {
      ISemanticRegion _keyword_1 = this.textRegionExtensions.regionFor(literal).keyword("{");
      _elvis = _keyword_1;
    }
    final ISemanticRegion open = _elvis;
    ISemanticRegion _elvis_1 = null;
    ISemanticRegion _keyword_2 = this.textRegionExtensions.regionFor(literal).keyword("]");
    if (_keyword_2 != null) {
      _elvis_1 = _keyword_2;
    } else {
      ISemanticRegion _keyword_3 = this.textRegionExtensions.regionFor(literal).keyword("}");
      _elvis_1 = _keyword_3;
    }
    final ISemanticRegion close = _elvis_1;
    this.formatCommaSeparatedList(literal.getElements(), open, close, document);
  }
  
  protected void formatCommaSeparatedList(final Collection<? extends EObject> elements, final ISemanticRegion open, final ISemanticRegion close, @Extension final IFormattableDocument format) {
    if (((close == null) || (open == null))) {
    } else {
      boolean _isEmpty = elements.isEmpty();
      if (_isEmpty) {
        final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
          it.noSpace();
        };
        format.append(open, _function);
      } else {
        boolean _isMultiline = close.getPreviousHiddenRegion().isMultiline();
        if (_isMultiline) {
          final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
            it.newLine();
          };
          format.append(open, _function_1);
          for (final EObject elem : elements) {
            {
              format.<EObject>format(elem);
              final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
                it.noSpace();
              };
              final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
                it.newLine();
              };
              format.append(format.prepend(this.textRegionExtensions.immediatelyFollowing(elem).keyword(","), _function_2), _function_3);
            }
          }
          final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
            it.newLine();
          };
          format.<EObject>append(IterableExtensions.last(elements), _function_2);
          final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
            it.indent();
          };
          format.<ISemanticRegion, ISemanticRegion>interior(open, close, _function_3);
        } else {
          IHiddenRegion _previousHiddenRegion = close.getPreviousHiddenRegion();
          final IndentOnceAutowrapFormatter indent = new IndentOnceAutowrapFormatter(_previousHiddenRegion);
          ITextRegionAccess _textRegionAccess = this.getTextRegionAccess();
          int _endOffset = open.getEndOffset();
          int _offset = close.getOffset();
          int _endOffset_1 = open.getEndOffset();
          int _minus = (_offset - _endOffset_1);
          final TextSegment region = new TextSegment(_textRegionAccess, _endOffset, _minus);
          final SeparatorRegions<EObject, ISemanticRegion> items = new SeparatorRegions<EObject, ISemanticRegion>(region);
          for (final EObject ele : elements) {
            items.appendWithTrailingSeparator(ele, this.textRegionExtensions.immediatelyFollowing(ele).keyword(","));
          }
          for (final ObjectEntry<EObject, ISemanticRegion> ele_1 : items) {
            {
              SeparatorEntry<EObject, ISemanticRegion> _leadingSeparator = ele_1.getLeadingSeparator();
              ISemanticRegion _separator = null;
              if (_leadingSeparator!=null) {
                _separator=_leadingSeparator.getSeparator();
              }
              final ISemanticRegion sep = _separator;
              boolean _prependNewLineIfMultiline = this.prependNewLineIfMultiline(ele_1.getObject());
              if (_prependNewLineIfMultiline) {
                if ((sep == null)) {
                  final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
                    it.noSpace();
                    it.autowrap(ele_1.getRegion().getLength());
                    it.setOnAutowrap(indent);
                  };
                  format.append(open, _function_4);
                } else {
                  final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
                    it.oneSpace();
                    it.autowrap(ele_1.getRegion().getLength());
                    it.setOnAutowrap(indent);
                  };
                  format.append(sep, _function_5);
                }
              } else {
                final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
                  it.oneSpace();
                };
                format.append(sep, _function_6);
              }
              final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
                it.noSpace();
              };
              format.prepend(sep, _function_7);
              format.<EObject>format(ele_1.getObject());
            }
          }
          final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
            it.noSpace();
          };
          format.prepend(close, _function_4);
        }
      }
    }
  }
  
  protected void _format(final JvmGenericArrayTypeReference array, @Extension final IFormattableDocument document) {
    List<ISemanticRegion> _ruleCallsTo = this.textRegionExtensions.regionFor(array).ruleCallsTo(this.grammar.getArrayBracketsRule());
    for (final ISemanticRegion region : _ruleCallsTo) {
      ArrayBracketsFormattingReplacer _arrayBracketsFormattingReplacer = new ArrayBracketsFormattingReplacer(region);
      document.addReplacer(_arrayBracketsFormattingReplacer);
    }
    document.<JvmTypeReference>format(array.getComponentType());
  }
  
  protected void _format(final JvmTypeConstraint constraint, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.<JvmTypeReference>format(document.<JvmTypeReference>prepend(constraint.getTypeReference(), _function));
  }
  
  protected void _format(final XVariableDeclaration expr, @Extension final IFormattableDocument format) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    format.append(this.textRegionExtensions.regionFor(expr).keyword("val"), _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    format.append(this.textRegionExtensions.regionFor(expr).keyword("var"), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    format.<JvmTypeReference>append(expr.getType(), _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    format.surround(this.textRegionExtensions.regionFor(expr).keyword("="), _function_3);
    format.<JvmTypeReference>format(expr.getType());
    format.<XExpression>format(expr.getRight());
  }
  
  protected void _format(final XAssignment expr, @Extension final IFormattableDocument format) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    format.surround(this.textRegionExtensions.regionFor(expr).ruleCallTo(this.grammar.getOpSingleAssignRule()), _function);
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(expr);
    String _xifexpression = null;
    boolean _isExplicitStatic = expr.isExplicitStatic();
    if (_isExplicitStatic) {
      _xifexpression = "::";
    } else {
      _xifexpression = ".";
    }
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    format.surround(_regionFor.keyword(_xifexpression), _function_1);
    format.<XExpression>format(expr.getAssignable());
    format.<XExpression>format(expr.getValue());
  }
  
  protected void formatFeatureCallParams(final List<XExpression> params, final ISemanticRegion open, final ISemanticRegion close, @Extension final IFormattableDocument format) {
    final XClosure builder = this.builder(params);
    final Iterable<XExpression> explicitParams = this.explicitParams(params);
    this.formatCommaSeparatedList(IterableExtensions.<XExpression>toList(explicitParams), open, close, format);
    this.formatBuilderWithLeadingGap(builder, format);
  }
  
  protected void formatBuilderWithLeadingGap(final XClosure closure, @Extension final IFormattableDocument format) {
    if ((closure != null)) {
      final int offset = this.textRegionExtensions.previousHiddenRegion(closure).getOffset();
      int _offset = this.textRegionExtensions.nextHiddenRegion(closure).getOffset();
      final int length = (_offset - offset);
      final ISubFormatter _function = (IFormattableSubDocument doc) -> {
        @Extension
        final IFormattableSubDocument it = doc.requireFitsInLine();
        final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
          it_1.noSpace();
        };
        it.<XClosure>prepend(closure, _function_1);
        it.<XClosure>format(closure);
      };
      final ISubFormatter _function_1 = (IFormattableSubDocument it) -> {
        final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it_1) -> {
          it_1.oneSpace();
        };
        it.<XClosure>prepend(closure, _function_2);
        it.<XClosure>format(closure);
      };
      format.formatConditionally(offset, length, _function, _function_1);
    }
  }
  
  protected XClosure builder(final List<XExpression> params) {
    XClosure _xifexpression = null;
    XExpression _last = IterableExtensions.<XExpression>last(params);
    boolean _tripleNotEquals = (_last != null);
    if (_tripleNotEquals) {
      XClosure _xblockexpression = null;
      {
        final EObject grammarElement = this.textRegionExtensions.grammarElement(IterableExtensions.<XExpression>last(params));
        XClosure _xifexpression_1 = null;
        if (((Objects.equal(grammarElement, this.grammar.getXMemberFeatureCallAccess().getMemberCallArgumentsXClosureParserRuleCall_1_1_4_0()) || 
          Objects.equal(grammarElement, this.grammar.getXFeatureCallAccess().getFeatureCallArgumentsXClosureParserRuleCall_4_0())) || 
          Objects.equal(grammarElement, this.grammar.getXConstructorCallAccess().getArgumentsXClosureParserRuleCall_5_0()))) {
          XExpression _last_1 = IterableExtensions.<XExpression>last(params);
          _xifexpression_1 = ((XClosure) _last_1);
        }
        _xblockexpression = _xifexpression_1;
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  protected Iterable<XExpression> explicitParams(final List<XExpression> params) {
    Iterable<XExpression> _xblockexpression = null;
    {
      final XClosure builder = this.builder(params);
      Iterable<XExpression> _xifexpression = null;
      if ((builder != null)) {
        int _size = params.size();
        int _minus = (_size - 1);
        _xifexpression = IterableExtensions.<XExpression>take(params, _minus);
      } else {
        _xifexpression = params;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected void _format(final XConstructorCall expr, @Extension final IFormattableDocument format) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    format.prepend(this.textRegionExtensions.regionFor(expr).feature(XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR), _function);
    boolean _isEmpty = expr.getTypeArguments().isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
        it.noSpace();
      };
      format.surround(this.textRegionExtensions.regionFor(expr).keyword("<"), _function_1);
      EList<JvmTypeReference> _typeArguments = expr.getTypeArguments();
      for (final JvmTypeReference arg : _typeArguments) {
        {
          format.<JvmTypeReference>format(arg);
          final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
            it.noSpace();
          };
          final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
            it.oneSpace();
          };
          format.append(format.prepend(this.textRegionExtensions.immediatelyFollowing(arg).keyword(","), _function_2), _function_3);
        }
      }
      final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
        it.noSpace();
      };
      format.prepend(this.textRegionExtensions.regionFor(expr).keyword(">"), _function_2);
    }
    final ISemanticRegion open = this.textRegionExtensions.regionFor(expr).keyword("(");
    final ISemanticRegion close = this.textRegionExtensions.regionFor(expr).keyword(")");
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    format.prepend(open, _function_3);
    this.formatFeatureCallParams(expr.getArguments(), open, close, format);
  }
  
  protected void formatFeatureCallTypeParameters(final XAbstractFeatureCall expr, @Extension final IFormattableDocument format) {
    boolean _isEmpty = expr.getTypeArguments().isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
        it.noSpace();
      };
      format.append(this.textRegionExtensions.regionFor(expr).keyword("<"), _function);
      EList<JvmTypeReference> _typeArguments = expr.getTypeArguments();
      for (final JvmTypeReference arg : _typeArguments) {
        {
          format.<JvmTypeReference>format(arg);
          final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
            it.noSpace();
          };
          final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
            it.oneSpace();
          };
          format.append(format.prepend(this.textRegionExtensions.immediatelyFollowing(arg).keyword(","), _function_1), _function_2);
        }
      }
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
        it.noSpace();
      };
      format.surround(this.textRegionExtensions.regionFor(expr).keyword(">"), _function_1);
    }
  }
  
  protected void _format(final XFeatureCall expr, @Extension final IFormattableDocument format) {
    this.formatFeatureCallTypeParameters(expr, format);
    boolean _isExplicitOperationCall = expr.isExplicitOperationCall();
    if (_isExplicitOperationCall) {
      final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
        it.noSpace();
      };
      final ISemanticRegion open = format.prepend(this.textRegionExtensions.regionFor(expr).keyword(this.grammar.getXFeatureCallAccess().getExplicitOperationCallLeftParenthesisKeyword_3_0_0()), _function);
      final ISemanticRegion close = this.textRegionExtensions.regionFor(expr).keyword(this.grammar.getXFeatureCallAccess().getRightParenthesisKeyword_3_2());
      this.formatFeatureCallParams(expr.getFeatureCallArguments(), open, close, format);
    } else {
      EList<XExpression> _featureCallArguments = expr.getFeatureCallArguments();
      for (final XExpression arg : _featureCallArguments) {
        this.format(arg, format);
      }
    }
  }
  
  protected void _format(final XMemberFeatureCall expr, @Extension final IFormattableDocument format) {
    EObject top = expr;
    IEObjectRegion _regionForEObject = this.textRegionExtensions.regionForEObject(expr);
    SeparatorRegions<XMemberFeatureCall, ISemanticRegion> calls = new SeparatorRegions<XMemberFeatureCall, ISemanticRegion>(_regionForEObject);
    while ((top instanceof XMemberFeatureCall)) {
      {
        String _switchResult = null;
        final XMemberFeatureCall it = ((XMemberFeatureCall)top);
        boolean _matched = false;
        boolean _isNullSafe = it.isNullSafe();
        if (_isNullSafe) {
          _matched=true;
          _switchResult = "?.";
        }
        if (!_matched) {
          boolean _isExplicitStatic = it.isExplicitStatic();
          if (_isExplicitStatic) {
            _matched=true;
            _switchResult = "::";
          }
        }
        if (!_matched) {
          _switchResult = ".";
        }
        final String op = _switchResult;
        final ISemanticRegion separator = this.textRegionExtensions.regionFor(top).keyword(op);
        calls.prependWithLeadingSeparator(((XMemberFeatureCall)top), separator);
        top = ((XMemberFeatureCall)top).getMemberCallTarget();
      }
    }
    format.<EObject>format(top);
    IHiddenRegion _nextHiddenRegion = this.textRegionExtensions.nextHiddenRegion(expr);
    final IndentOnceAutowrapFormatter indentOnce = new IndentOnceAutowrapFormatter(_nextHiddenRegion);
    for (final ObjectEntry<XMemberFeatureCall, ISemanticRegion> entry : calls) {
      {
        final XMemberFeatureCall call = entry.getObject();
        final ISemanticRegion operator = entry.getLeadingSeparator().getSeparator();
        this.formatFeatureCallTypeParameters(call, format);
        final ISemanticRegion feature = this.textRegionExtensions.regionFor(call).feature(XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE);
        if ((feature != null)) {
          int _length = entry.getRegion().getLength();
          int _length_1 = feature.getLength();
          int _multiply = (_length_1 * 2);
          final int autowrapLength = Math.min(_length, _multiply);
          final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
            it.noSpace();
          };
          final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
            it.noSpace();
            it.autowrap(autowrapLength);
            it.setOnAutowrap(indentOnce);
          };
          format.append(format.prepend(operator, _function), _function_1);
          boolean _isExplicitOperationCall = call.isExplicitOperationCall();
          if (_isExplicitOperationCall) {
            final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
              it.noSpace();
            };
            final ISemanticRegion open = format.prepend(this.textRegionExtensions.regionFor(call).keyword(this.grammar.getXMemberFeatureCallAccess().getExplicitOperationCallLeftParenthesisKeyword_1_1_3_0_0()), _function_2);
            final ISemanticRegion close = this.textRegionExtensions.regionFor(call).keyword(this.grammar.getXMemberFeatureCallAccess().getRightParenthesisKeyword_1_1_3_2());
            this.formatFeatureCallParams(call.getMemberCallArguments(), open, close, format);
          } else {
            boolean _isEmpty = call.getMemberCallArguments().isEmpty();
            boolean _not = (!_isEmpty);
            if (_not) {
              this.formatBuilderWithLeadingGap(this.builder(call.getMemberCallArguments()), format);
            }
          }
        }
      }
    }
  }
  
  protected AbstractRule binaryOperationPrecedence(final EObject op) {
    final ISemanticRegion node = this.textRegionExtensions.regionFor(op).feature(XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE);
    if (((node != null) && (node.getGrammarElement() instanceof RuleCall))) {
      EObject _grammarElement = node.getGrammarElement();
      return ((RuleCall) _grammarElement).getRule();
    }
    return null;
  }
  
  protected void _format(final XBinaryOperation expr, @Extension final IFormattableDocument format) {
    final AbstractRule precendece = this.binaryOperationPrecedence(expr);
    IEObjectRegion _regionForEObject = this.textRegionExtensions.regionForEObject(expr);
    final SeparatorRegions<XBinaryOperation, ISemanticRegion> calls = new SeparatorRegions<XBinaryOperation, ISemanticRegion>(_regionForEObject);
    EObject top = expr;
    while (Objects.equal(this.binaryOperationPrecedence(top), precendece)) {
      {
        calls.prependWithLeadingSeparator(((XBinaryOperation) top), 
          this.textRegionExtensions.regionFor(top).feature(XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE));
        top = ((XBinaryOperation) top).getLeftOperand();
      }
    }
    this.format(top, format);
    IHiddenRegion _nextHiddenRegion = this.textRegionExtensions.nextHiddenRegion(expr);
    final IndentOnceAutowrapFormatter indent = new IndentOnceAutowrapFormatter(_nextHiddenRegion);
    for (final ObjectEntry<XBinaryOperation, ISemanticRegion> ele : calls) {
      {
        SeparatorEntry<XBinaryOperation, ISemanticRegion> _leadingSeparator = ele.getLeadingSeparator();
        ISemanticRegion _separator = null;
        if (_leadingSeparator!=null) {
          _separator=_leadingSeparator.getSeparator();
        }
        final ISemanticRegion sep = _separator;
        boolean _prependNewLineIfMultiline = this.prependNewLineIfMultiline(ele.getObject());
        if (_prependNewLineIfMultiline) {
          final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
            it.oneSpace();
            it.autowrap(ele.getRegion().getLength());
            it.setOnAutowrap(indent);
          };
          format.append(sep, _function);
        } else {
          final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
            it.oneSpace();
          };
          format.append(sep, _function_1);
        }
        final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
          it.oneSpace();
        };
        format.prepend(sep, _function_2);
        format.<XExpression>format(ele.getObject().getRightOperand());
      }
    }
  }
  
  protected boolean prependNewLineIfMultiline(final EObject obj) {
    boolean _switchResult = false;
    boolean _matched = false;
    if (obj instanceof XMemberFeatureCall) {
      _matched=true;
      _switchResult = this.prependNewLineIfMultiline(this.builder(((XMemberFeatureCall)obj).getMemberCallArguments()));
    }
    if (!_matched) {
      if (obj instanceof XClosure) {
        _matched=true;
        _switchResult = false;
      }
    }
    if (!_matched) {
      if (obj instanceof XBlockExpression) {
        _matched=true;
        _switchResult = false;
      }
    }
    if (!_matched) {
      _switchResult = true;
    }
    return _switchResult;
  }
  
  protected void _format(final XSynchronizedExpression expr, @Extension final IFormattableDocument format) {
    EObject _eContainer = expr.eContainer();
    if ((_eContainer instanceof XVariableDeclaration)) {
      final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
        it.indent();
      };
      format.<XSynchronizedExpression>surround(expr, _function);
    }
    final boolean multiline = (this.textRegionExtensions.isMultiline(expr.getExpression()) || this.textRegionExtensions.previousHiddenRegion(expr.getExpression()).isMultiline());
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    format.<XExpression>surround(expr.getParam(), _function_1);
    if (((expr.getExpression() instanceof XBlockExpression) || multiline)) {
      format.append(this.textRegionExtensions.regionFor(expr).keyword("synchronized"), XbaseFormatterPreferenceKeys.whitespaceBetweenKeywordAndParenthesisML);
    } else {
      format.append(this.textRegionExtensions.regionFor(expr).keyword("synchronized"), XbaseFormatterPreferenceKeys.whitespaceBetweenKeywordAndParenthesisSL);
    }
    format.<XExpression>format(expr.getParam());
    this.formatBody(expr.getExpression(), false, format);
  }
  
  protected void _format(final XIfExpression expr, @Extension final IFormattableDocument format) {
    EObject _eContainer = expr.eContainer();
    if ((_eContainer instanceof XVariableDeclaration)) {
      final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
        it.indent();
      };
      format.<XIfExpression>surround(expr, _function);
    }
    final boolean multiline = (this.isMultilineOrInNewLine(expr.getThen()) || this.isMultilineOrInNewLine(expr.getElse()));
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    format.<XExpression>surround(expr.getIf(), _function_1);
    if (((expr.getThen() instanceof XBlockExpression) || multiline)) {
      format.append(this.textRegionExtensions.regionFor(expr).keyword("if"), XbaseFormatterPreferenceKeys.whitespaceBetweenKeywordAndParenthesisML);
    } else {
      format.append(this.textRegionExtensions.regionFor(expr).keyword("if"), XbaseFormatterPreferenceKeys.whitespaceBetweenKeywordAndParenthesisSL);
    }
    format.<XExpression>format(expr.getIf());
    XExpression _else = expr.getElse();
    boolean _tripleEquals = (_else == null);
    if (_tripleEquals) {
      this.formatBody(expr.getThen(), multiline, format);
    } else {
      this.formatBodyInline(expr.getThen(), multiline, format);
      if (((expr.getElse() instanceof XIfExpression) || (!multiline))) {
        final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
          it.oneSpace();
        };
        format.<XExpression>prepend(expr.getElse(), _function_2);
        format.<XExpression>format(expr.getElse());
      } else {
        this.formatBody(expr.getElse(), multiline, format);
      }
    }
  }
  
  protected void _format(final XForLoopExpression expr, @Extension final IFormattableDocument format) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    format.append(this.textRegionExtensions.regionFor(expr).keyword("for"), _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    format.<JvmFormalParameter>append(format.<JvmFormalParameter>prepend(expr.getDeclaredParam(), _function_1), _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    format.<XExpression>format(format.<XExpression>append(format.<XExpression>prepend(expr.getForExpression(), _function_3), _function_4));
    this.formatBody(expr.getEachExpression(), true, format);
  }
  
  protected void _format(final XBasicForLoopExpression expr, @Extension final IFormattableDocument format) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    format.append(this.textRegionExtensions.regionFor(expr).keyword("for"), _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    format.append(this.textRegionExtensions.regionFor(expr).keyword("("), _function_1);
    final Consumer<ISemanticRegion> _function_2 = (ISemanticRegion it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it_1) -> {
        it_1.noSpace();
      };
      final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it_1) -> {
        it_1.noSpace();
        it_1.lowPriority();
      };
      format.append(format.prepend(it, _function_3), _function_4);
    };
    this.textRegionExtensions.regionFor(expr).keywords(";").forEach(_function_2);
    final Consumer<ISemanticRegion> _function_3 = (ISemanticRegion it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it_1) -> {
        it_1.noSpace();
      };
      final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it_1) -> {
        it_1.oneSpace();
      };
      format.append(format.prepend(it, _function_4), _function_5);
    };
    this.textRegionExtensions.regionFor(expr).keywords(",").forEach(_function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    format.prepend(this.textRegionExtensions.regionFor(expr).keyword(")"), _function_4);
    final Consumer<XExpression> _function_5 = (XExpression it) -> {
      format.<XExpression>format(it);
    };
    expr.getInitExpressions().forEach(_function_5);
    final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    format.<XExpression>prepend(expr.getExpression(), _function_6);
    format.<XExpression>format(expr.getExpression());
    final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    format.<XExpression>prepend(IterableExtensions.<XExpression>head(expr.getUpdateExpressions()), _function_7);
    final Consumer<XExpression> _function_8 = (XExpression it) -> {
      format.<XExpression>format(it);
    };
    expr.getUpdateExpressions().forEach(_function_8);
    this.formatBody(expr.getEachExpression(), true, format);
  }
  
  protected void _format(final XWhileExpression expr, @Extension final IFormattableDocument format) {
    format.append(this.textRegionExtensions.regionFor(expr).keyword("while"), XbaseFormatterPreferenceKeys.whitespaceBetweenKeywordAndParenthesisML);
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    format.<XExpression>format(format.<XExpression>append(format.<XExpression>prepend(expr.getPredicate(), _function), _function_1));
    this.formatBody(expr.getBody(), true, format);
  }
  
  protected void _format(final XDoWhileExpression expr, @Extension final IFormattableDocument format) {
    format.append(this.textRegionExtensions.regionFor(expr).keyword("while"), XbaseFormatterPreferenceKeys.whitespaceBetweenKeywordAndParenthesisML);
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    format.<XExpression>format(format.<XExpression>append(format.<XExpression>prepend(expr.getPredicate(), _function), _function_1));
    this.formatBodyInline(expr.getBody(), true, format);
  }
  
  protected void _format(final XBlockExpression expr, @Extension final IFormattableDocument format) {
    final ISemanticRegion open = this.textRegionExtensions.regionFor(expr).keyword("{");
    final ISemanticRegion close = this.textRegionExtensions.regionFor(expr).keyword("}");
    EObject _eContainer = expr.eContainer();
    boolean _tripleEquals = (_eContainer == null);
    if (_tripleEquals) {
      final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
        it.noSpace();
      };
      format.<XBlockExpression>surround(expr, _function);
    }
    if (((open != null) && (close != null))) {
      boolean _isSingleLineBlock = this.isSingleLineBlock(expr);
      if (_isSingleLineBlock) {
        final ISubFormatter _function_1 = (IFormattableSubDocument f) -> {
          this.formatExpressionsSingleline(expr.getExpressions(), open, close, f.requireFitsInLine());
        };
        final ISubFormatter _function_2 = (IFormattableSubDocument f) -> {
          this.formatExpressionsMultiline(expr.getExpressions(), open, close, f);
        };
        format.formatConditionally(expr, _function_1, _function_2);
      } else {
        this.formatExpressionsMultiline(expr.getExpressions(), open, close, format);
      }
    }
  }
  
  protected boolean isSingleLineBlock(final XBlockExpression expr) {
    return false;
  }
  
  protected void _format(final XTypeLiteral expr, @Extension final IFormattableDocument format) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    format.append(this.textRegionExtensions.regionFor(expr).keyword("typeof"), _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    format.append(format.prepend(this.textRegionExtensions.regionFor(expr).feature(XbasePackage.Literals.XTYPE_LITERAL__TYPE), _function_1), _function_2);
    List<ISemanticRegion> _ruleCallsTo = this.textRegionExtensions.regionFor(expr).ruleCallsTo(this.grammar.getArrayBracketsRule());
    for (final ISemanticRegion region : _ruleCallsTo) {
      {
        final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
          it.noSpace();
        };
        format.append(region, _function_3);
        ArrayBracketsFormattingReplacer _arrayBracketsFormattingReplacer = new ArrayBracketsFormattingReplacer(region);
        format.addReplacer(_arrayBracketsFormattingReplacer);
      }
    }
  }
  
  protected void _format(final XThrowExpression expr, @Extension final IFormattableDocument format) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    format.<XExpression>prepend(expr.getExpression(), _function);
    format.<XExpression>format(expr.getExpression());
  }
  
  protected void _format(final XReturnExpression expr, @Extension final IFormattableDocument format) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    format.<XExpression>prepend(expr.getExpression(), _function);
    format.<XExpression>format(expr.getExpression());
  }
  
  protected void _format(final XTryCatchFinallyExpression expr, @Extension final IFormattableDocument format) {
    EObject _eContainer = expr.eContainer();
    if ((_eContainer instanceof XVariableDeclaration)) {
      final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
        it.indent();
      };
      format.<XTryCatchFinallyExpression>surround(expr, _function);
    }
    this.formatBodyInline(expr.getExpression(), true, format);
    EList<XCatchClause> _catchClauses = expr.getCatchClauses();
    for (final XCatchClause cc : _catchClauses) {
      {
        format.append(this.textRegionExtensions.regionFor(cc).keyword("catch"), XbaseFormatterPreferenceKeys.whitespaceBetweenKeywordAndParenthesisML);
        final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
          it.noSpace();
        };
        final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
          it.noSpace();
        };
        format.<JvmFormalParameter>format(format.<JvmFormalParameter>append(format.<JvmFormalParameter>prepend(cc.getDeclaredParam(), _function_1), _function_2));
        if (((!Objects.equal(cc, IterableExtensions.<XCatchClause>last(expr.getCatchClauses()))) || (expr.getFinallyExpression() != null))) {
          this.formatBodyInline(cc.getExpression(), true, format);
        } else {
          this.formatBody(cc.getExpression(), true, format);
        }
      }
    }
    this.formatBody(expr.getFinallyExpression(), true, format);
  }
  
  protected void _format(final JvmFormalParameter expr, @Extension final IFormattableDocument format) {
    JvmTypeReference _parameterType = expr.getParameterType();
    if (_parameterType!=null) {
      final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
        it.oneSpace();
      };
      format.<JvmTypeReference>append(_parameterType, _function);
    }
    format.<JvmTypeReference>format(expr.getParameterType());
  }
  
  protected void _format(final XExpression expr, @Extension final IFormattableDocument format) {
    EList<EObject> _eContents = expr.eContents();
    for (final EObject obj : _eContents) {
      boolean _matched = false;
      if (obj instanceof XExpression) {
        _matched=true;
        format.<XExpression>format(((XExpression)obj));
      }
    }
  }
  
  protected void _format(final XSwitchExpression expr, @Extension final IFormattableDocument format) {
    final Function1<XCasePart, Boolean> _function = (XCasePart it) -> {
      XExpression _then = it.getThen();
      return Boolean.valueOf((_then instanceof XBlockExpression));
    };
    final boolean containsBlockExpr = IterableExtensions.<XCasePart>exists(expr.getCases(), _function);
    final boolean switchSL = ((!containsBlockExpr) && (!this.textRegionExtensions.isMultiline(expr)));
    final boolean caseSL = ((((!containsBlockExpr) && ((!expr.getCases().isEmpty()) || (expr.getDefault() != null))) && 
      (!IterableExtensions.<XCasePart>exists(expr.getCases(), ((Function1<XCasePart, Boolean>) (XCasePart it) -> {
        return Boolean.valueOf(this.textRegionExtensions.isMultiline(it));
      })))) && (!this.isMultilineOrInNewLine(expr.getDefault())));
    final ISemanticRegion open = this.textRegionExtensions.regionFor(expr).keyword("{");
    final ISemanticRegion close = this.textRegionExtensions.regionFor(expr).keyword("}");
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    format.append(this.textRegionExtensions.regionFor(expr).keyword("switch"), _function_1);
    if (switchSL) {
      final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
        it.oneSpace();
      };
      format.prepend(open, _function_2);
      final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
        it.oneSpace();
      };
      format.append(open, _function_3);
      EList<XCasePart> _cases = expr.getCases();
      for (final XCasePart c : _cases) {
        {
          format.<XExpression>format(c.getCase());
          format.<XExpression>format(c.getThen());
          XExpression _then = c.getThen();
          boolean _tripleEquals = (_then == null);
          if (_tripleEquals) {
            final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
              it.oneSpace();
            };
            format.<XCasePart>append(c, _function_4);
          } else {
            final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
              it.oneSpace();
            };
            final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
              it.oneSpace();
            };
            format.<XExpression>append(format.<XExpression>prepend(c.getThen(), _function_5), _function_6);
          }
        }
      }
      XExpression _default = expr.getDefault();
      boolean _tripleNotEquals = (_default != null);
      if (_tripleNotEquals) {
        final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
          it.noSpace();
        };
        format.append(this.textRegionExtensions.regionFor(expr).keyword("default"), _function_4);
        final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
          it.oneSpace();
        };
        format.<XExpression>format(format.<XExpression>surround(expr.getDefault(), _function_5));
      }
    } else {
      if (caseSL) {
        format.prepend(open, XbaseFormatterPreferenceKeys.bracesInNewLine);
        boolean _isEmpty = expr.getCases().isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
            it.newLine();
          };
          format.append(open, _function_6);
        }
        final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
          it.indent();
        };
        format.<ISemanticRegion, ISemanticRegion>interior(open, close, _function_7);
        EList<XCasePart> _cases_1 = expr.getCases();
        for (final XCasePart c_1 : _cases_1) {
          {
            format.<XExpression>format(c_1.getCase());
            format.<XExpression>format(c_1.getThen());
            final Procedure1<IHiddenRegionFormatter> _function_8 = (IHiddenRegionFormatter it) -> {
              it.oneSpace();
            };
            format.<XExpression>prepend(c_1.getThen(), _function_8);
            XCasePart _last = IterableExtensions.<XCasePart>last(expr.getCases());
            boolean _notEquals = (!Objects.equal(c_1, _last));
            if (_notEquals) {
              final Procedure1<IHiddenRegionFormatter> _function_9 = (IHiddenRegionFormatter it) -> {
                it.newLine();
              };
              format.<XCasePart>append(c_1, _function_9);
            }
          }
        }
        XExpression _default_1 = expr.getDefault();
        boolean _tripleNotEquals_1 = (_default_1 != null);
        if (_tripleNotEquals_1) {
          final Procedure1<IHiddenRegionFormatter> _function_8 = (IHiddenRegionFormatter it) -> {
            it.newLine();
          };
          final Procedure1<IHiddenRegionFormatter> _function_9 = (IHiddenRegionFormatter it) -> {
            it.noSpace();
          };
          format.append(format.prepend(this.textRegionExtensions.regionFor(expr).keyword("default"), _function_8), _function_9);
          final Procedure1<IHiddenRegionFormatter> _function_10 = (IHiddenRegionFormatter it) -> {
            it.oneSpace();
          };
          format.<XExpression>format(format.<XExpression>prepend(expr.getDefault(), _function_10));
        }
        final Procedure1<IHiddenRegionFormatter> _function_11 = (IHiddenRegionFormatter it) -> {
          it.newLine();
        };
        format.prepend(close, _function_11);
      } else {
        final Procedure1<IHiddenRegionFormatter> _function_12 = (IHiddenRegionFormatter it) -> {
          it.newLine();
        };
        format.append(format.prepend(open, XbaseFormatterPreferenceKeys.bracesInNewLine), _function_12);
        if (((!expr.getCases().isEmpty()) || (expr.getDefault() != null))) {
          final Procedure1<IHiddenRegionFormatter> _function_13 = (IHiddenRegionFormatter it) -> {
            it.indent();
          };
          format.<ISemanticRegion, ISemanticRegion>interior(open, close, _function_13);
        }
        EList<XCasePart> _cases_2 = expr.getCases();
        for (final XCasePart c_2 : _cases_2) {
          {
            format.<XExpression>format(c_2.getCase());
            this.formatBodyParagraph(c_2.getThen(), format);
            final Procedure1<IHiddenRegionFormatter> _function_14 = (IHiddenRegionFormatter it) -> {
              it.noSpace();
            };
            final Procedure1<IHiddenRegionFormatter> _function_15 = (IHiddenRegionFormatter it) -> {
              it.newLine();
            };
            format.append(format.prepend(this.textRegionExtensions.regionFor(c_2).feature(XbasePackage.Literals.XCASE_PART__FALL_THROUGH), _function_14), _function_15);
          }
        }
        XExpression _default_2 = expr.getDefault();
        boolean _tripleNotEquals_2 = (_default_2 != null);
        if (_tripleNotEquals_2) {
          final Procedure1<IHiddenRegionFormatter> _function_14 = (IHiddenRegionFormatter it) -> {
            it.noSpace();
          };
          format.append(this.textRegionExtensions.regionFor(expr).keyword("default"), _function_14);
          this.formatBodyParagraph(expr.getDefault(), format);
        }
      }
    }
    EList<XCasePart> _cases_3 = expr.getCases();
    for (final XCasePart c_3 : _cases_3) {
      if (((c_3.getTypeGuard() != null) && (c_3.getCase() != null))) {
        final Procedure1<IHiddenRegionFormatter> _function_15 = (IHiddenRegionFormatter it) -> {
          it.oneSpace();
        };
        format.<JvmTypeReference>append(c_3.getTypeGuard(), _function_15);
        final Procedure1<IHiddenRegionFormatter> _function_16 = (IHiddenRegionFormatter it) -> {
          it.oneSpace();
        };
        final Procedure1<IHiddenRegionFormatter> _function_17 = (IHiddenRegionFormatter it) -> {
          it.noSpace();
        };
        format.<XExpression>append(format.<XExpression>prepend(c_3.getCase(), _function_16), _function_17);
      } else {
        JvmTypeReference _typeGuard = c_3.getTypeGuard();
        boolean _tripleNotEquals_3 = (_typeGuard != null);
        if (_tripleNotEquals_3) {
          final Procedure1<IHiddenRegionFormatter> _function_18 = (IHiddenRegionFormatter it) -> {
            it.noSpace();
          };
          format.<JvmTypeReference>append(c_3.getTypeGuard(), _function_18);
        } else {
          XExpression _case = c_3.getCase();
          boolean _tripleNotEquals_4 = (_case != null);
          if (_tripleNotEquals_4) {
            final Procedure1<IHiddenRegionFormatter> _function_19 = (IHiddenRegionFormatter it) -> {
              it.oneSpace();
            };
            final Procedure1<IHiddenRegionFormatter> _function_20 = (IHiddenRegionFormatter it) -> {
              it.noSpace();
            };
            format.<XExpression>append(format.<XExpression>prepend(c_3.getCase(), _function_19), _function_20);
          }
        }
      }
    }
  }
  
  protected ISemanticRegion formatClosureParams(final XClosure expr, final ISemanticRegion open, @Extension final IFormattableDocument format, final Procedure1<? super IHiddenRegionFormatter> init) {
    boolean _isExplicitSyntax = expr.isExplicitSyntax();
    if (_isExplicitSyntax) {
      final ISemanticRegion last = this.textRegionExtensions.regionFor(expr).feature(XbasePackage.Literals.XCLOSURE__EXPLICIT_SYNTAX);
      boolean _isEmpty = expr.getDeclaredFormalParameters().isEmpty();
      if (_isEmpty) {
        final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
          it.noSpace();
        };
        format.append(open, _function);
      } else {
        EList<JvmFormalParameter> _declaredFormalParameters = expr.getDeclaredFormalParameters();
        for (final JvmFormalParameter param : _declaredFormalParameters) {
          {
            format.<JvmFormalParameter>format(param);
            final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
              it.noSpace();
            };
            final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
              it.oneSpace();
            };
            format.append(format.prepend(this.textRegionExtensions.immediatelyFollowing(param).keyword(","), _function_1), _function_2);
          }
        }
        format.append(open, init);
        boolean _isEmpty_1 = expr.getDeclaredFormalParameters().isEmpty();
        boolean _not = (!_isEmpty_1);
        if (_not) {
          format.prepend(last, init);
        }
      }
      return last;
    }
    return open;
  }
  
  protected void _format(final XClosure expr, @Extension final IFormattableDocument format) {
    ISemanticRegion _elvis = null;
    ISemanticRegion _keyword = this.textRegionExtensions.regionFor(expr).keyword("[");
    if (_keyword != null) {
      _elvis = _keyword;
    } else {
      ISemanticRegion _keyword_1 = this.textRegionExtensions.immediatelyPreceding(expr).keyword("(");
      _elvis = _keyword_1;
    }
    final ISemanticRegion open = _elvis;
    ISemanticRegion _elvis_1 = null;
    ISemanticRegion _keyword_2 = this.textRegionExtensions.regionFor(expr).keyword("]");
    if (_keyword_2 != null) {
      _elvis_1 = _keyword_2;
    } else {
      ISemanticRegion _keyword_3 = this.textRegionExtensions.immediatelyFollowing(expr).keyword(")");
      _elvis_1 = _keyword_3;
    }
    final ISemanticRegion close = _elvis_1;
    List<XExpression> _switchResult = null;
    XExpression _expression = expr.getExpression();
    final XExpression x = _expression;
    boolean _matched = false;
    if (x instanceof XBlockExpression) {
      _matched=true;
      _switchResult = ((XBlockExpression)x).getExpressions();
    }
    if (!_matched) {
      _switchResult = CollectionLiterals.<XExpression>newArrayList(x);
    }
    final List<XExpression> children = _switchResult;
    if (((open == null) || (close == null))) {
    } else {
      boolean _isEmpty = children.isEmpty();
      if (_isEmpty) {
        boolean _containsComment = open.getNextHiddenRegion().containsComment();
        if (_containsComment) {
          final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
            it.newLine();
            it.indent();
          };
          format.append(open, _function);
        } else {
          final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
            it.noSpace();
          };
          format.append(open, _function_1);
        }
      } else {
        boolean _isMultiline = close.getPreviousHiddenRegion().isMultiline();
        if (_isMultiline) {
          final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
            it.oneSpace();
          };
          final ISemanticRegion last = this.formatClosureParams(expr, open, format, _function_2);
          this.formatExpressionsMultiline(children, last, close, format);
        } else {
          final int offset = open.getPreviousHiddenRegion().getNextSemanticRegion().getEndOffset();
          int _offset = close.getOffset();
          final int length = (_offset - offset);
          final ISubFormatter _function_3 = (IFormattableSubDocument doc) -> {
            @Extension
            final IFormattableSubDocument it = doc.requireFitsInLine();
            final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it_1) -> {
              it_1.noSpace();
            };
            final ISemanticRegion last_1 = this.formatClosureParams(expr, open, it, _function_4);
            final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it_1) -> {
              it_1.noSpace();
            };
            it.append(last_1, _function_5);
            for (final XExpression c : children) {
              {
                it.<XExpression>format(c);
                final ISemanticRegion semicolon = this.textRegionExtensions.immediatelyFollowing(c).keyword(";");
                if ((semicolon != null)) {
                  final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it_1) -> {
                    it_1.noSpace();
                  };
                  final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it_1) -> {
                    XExpression _last = IterableExtensions.<XExpression>last(children);
                    boolean _equals = Objects.equal(c, _last);
                    if (_equals) {
                      it_1.noSpace();
                    } else {
                      it_1.oneSpace();
                    }
                  };
                  it.append(it.prepend(semicolon, _function_6), _function_7);
                } else {
                  final Procedure1<IHiddenRegionFormatter> _function_8 = (IHiddenRegionFormatter it_1) -> {
                    XExpression _last = IterableExtensions.<XExpression>last(children);
                    boolean _equals = Objects.equal(c, _last);
                    if (_equals) {
                      it_1.noSpace();
                    } else {
                      it_1.oneSpace();
                    }
                  };
                  it.<XExpression>append(c, _function_8);
                }
              }
            }
          };
          final ISubFormatter _function_4 = (IFormattableSubDocument doc) -> {
            final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
              it.oneSpace();
            };
            final ISemanticRegion last_1 = this.formatClosureParams(expr, open, doc, _function_5);
            this.formatExpressionsMultiline(children, last_1, close, doc);
          };
          format.formatConditionally(offset, length, _function_3, _function_4);
        }
      }
    }
  }
  
  protected void formatBody(final XExpression expr, final boolean forceMultiline, @Extension final IFormattableDocument doc) {
    if ((expr == null)) {
      return;
    }
    if ((expr instanceof XBlockExpression)) {
      doc.<XBlockExpression>prepend(((XBlockExpression)expr), XbaseFormatterPreferenceKeys.bracesInNewLine);
    } else {
      if ((forceMultiline || this.textRegionExtensions.previousHiddenRegion(expr).isMultiline())) {
        final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
          it.newLine();
        };
        final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
          it.indent();
        };
        doc.<XExpression>surround(doc.<XExpression>prepend(expr, _function), _function_1);
      } else {
        final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
          it.oneSpace();
        };
        doc.<XExpression>prepend(expr, _function_2);
      }
    }
    doc.<XExpression>format(expr);
  }
  
  protected void formatBodyInline(final XExpression expr, final boolean forceMultiline, @Extension final IFormattableDocument doc) {
    if ((expr == null)) {
      return;
    }
    if ((expr instanceof XBlockExpression)) {
      doc.<XBlockExpression>append(doc.<XBlockExpression>prepend(((XBlockExpression)expr), XbaseFormatterPreferenceKeys.bracesInNewLine), XbaseFormatterPreferenceKeys.bracesInNewLine);
    } else {
      if ((forceMultiline || this.textRegionExtensions.previousHiddenRegion(expr).isMultiline())) {
        final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
          it.newLine();
        };
        final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
          it.indent();
        };
        final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
          it.newLine();
        };
        doc.<XExpression>append(doc.<XExpression>surround(doc.<XExpression>prepend(expr, _function), _function_1), _function_2);
      } else {
        final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
          it.oneSpace();
        };
        doc.<XExpression>surround(expr, _function_3);
      }
    }
    doc.<XExpression>format(expr);
  }
  
  protected void formatBodyParagraph(final XExpression expr, @Extension final IFormattableDocument doc) {
    if ((expr == null)) {
      return;
    }
    if ((expr instanceof XBlockExpression)) {
      final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
        it.newLine();
      };
      doc.<XBlockExpression>append(doc.<XBlockExpression>prepend(((XBlockExpression)expr), XbaseFormatterPreferenceKeys.bracesInNewLine), _function);
    } else {
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
    }
    doc.<XExpression>format(expr);
  }
  
  protected void _format(final XInstanceOfExpression expr, @Extension final IFormattableDocument doc) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    doc.surround(this.textRegionExtensions.regionFor(expr).keyword("instanceof"), _function);
    doc.<XExpression>format(expr.getExpression());
    doc.<JvmTypeReference>format(expr.getType());
  }
  
  protected void _format(final XCastedExpression expr, @Extension final IFormattableDocument doc) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    doc.surround(this.textRegionExtensions.regionFor(expr).keyword("as"), _function);
    doc.<XExpression>format(expr.getTarget());
    doc.<JvmTypeReference>format(expr.getType());
  }
  
  protected void _format(final XPostfixOperation expr, @Extension final IFormattableDocument doc) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    doc.prepend(this.textRegionExtensions.regionFor(expr).feature(XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE), _function);
    doc.<XExpression>format(expr.getOperand());
  }
  
  protected void formatExpressionsMultiline(final Collection<? extends XExpression> expressions, final ISemanticRegion open, final ISemanticRegion close, @Extension final IFormattableDocument format) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    format.<ISemanticRegion, ISemanticRegion>interior(open, close, _function);
    boolean _isEmpty = expressions.isEmpty();
    if (_isEmpty) {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
        it.newLine();
      };
      format.append(open, _function_1);
    } else {
      format.append(open, XbaseFormatterPreferenceKeys.blankLinesAroundExpression);
      for (final XExpression child : expressions) {
        {
          format.<XExpression>format(child);
          final ISemanticRegion sem = this.textRegionExtensions.immediatelyFollowing(child).keyword(";");
          if ((sem != null)) {
            final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
              it.noSpace();
            };
            format.append(format.prepend(sem, _function_2), XbaseFormatterPreferenceKeys.blankLinesAroundExpression);
          } else {
            format.<XExpression>append(child, XbaseFormatterPreferenceKeys.blankLinesAroundExpression);
          }
        }
      }
    }
  }
  
  protected void formatExpressionsSingleline(final Collection<? extends XExpression> expressions, final ISemanticRegion open, final ISemanticRegion close, @Extension final IFormattableDocument format) {
    boolean _isEmpty = expressions.isEmpty();
    if (_isEmpty) {
      final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
        it.noSpace();
      };
      format.append(open, _function);
    } else {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
        it.oneSpace();
      };
      format.append(open, _function_1);
      for (final XExpression child : expressions) {
        {
          format.<XExpression>format(child);
          final ISemanticRegion sem = this.textRegionExtensions.immediatelyFollowing(child).keyword(";");
          if ((sem != null)) {
            final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
              it.noSpace();
            };
            final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
              it.oneSpace();
            };
            format.append(format.prepend(sem, _function_2), _function_3);
          } else {
            final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
              it.oneSpace();
            };
            format.<XExpression>append(child, _function_4);
          }
        }
      }
    }
  }
  
  protected boolean isMultilineOrInNewLine(final EObject obj) {
    return ((obj != null) && (this.textRegionExtensions.isMultiline(obj) || this.textRegionExtensions.previousHiddenRegion(obj).isMultiline()));
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
    } else if (expr instanceof XExpression) {
      _format((XExpression)expr, format);
      return;
    } else if (expr instanceof XImportDeclaration) {
      _format((XImportDeclaration)expr, format);
      return;
    } else if (expr instanceof XImportSection) {
      _format((XImportSection)expr, format);
      return;
    } else if (expr instanceof EObject) {
      _format((EObject)expr, format);
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
  
  @Pure
  public XbaseGrammarAccess getGrammar() {
    return this.grammar;
  }
}
