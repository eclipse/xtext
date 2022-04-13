/**
 * Copyright (c) 2012, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.formatting;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
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
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair;
import org.eclipse.xtext.xbase.formatting2.XbaseFormatter;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess;
import org.eclipse.xtext.xtype.XFunctionTypeRef;

/**
 * @deprecated use {@link XbaseFormatter}
 */
@Deprecated
@SuppressWarnings("all")
public class XbaseFormatter2 extends AbstractFormatter {
  @Inject
  @Extension
  private NodeModelAccess _nodeModelAccess;

  @Inject
  @Extension
  private HiddenLeafAccess _hiddenLeafAccess;

  @Inject
  @Extension
  private FormattingDataFactory _formattingDataFactory;

  @Inject
  @Extension
  private XbaseGrammarAccess _xbaseGrammarAccess;

  protected void _format(final XCollectionLiteral literal, final FormattableDocument document) {
    final Procedure1<FormattingDataInit> _function = (FormattingDataInit it) -> {
      it.noSpace();
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(this._nodeModelAccess.nodeForKeyword(literal, "#"), _function);
    document.operator_add(_append);
    ILeafNode _elvis = null;
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(literal, "[");
    if (_nodeForKeyword != null) {
      _elvis = _nodeForKeyword;
    } else {
      ILeafNode _nodeForKeyword_1 = this._nodeModelAccess.nodeForKeyword(literal, "{");
      _elvis = _nodeForKeyword_1;
    }
    final ILeafNode open = _elvis;
    ILeafNode _elvis_1 = null;
    ILeafNode _nodeForKeyword_2 = this._nodeModelAccess.nodeForKeyword(literal, "]");
    if (_nodeForKeyword_2 != null) {
      _elvis_1 = _nodeForKeyword_2;
    } else {
      ILeafNode _nodeForKeyword_3 = this._nodeModelAccess.nodeForKeyword(literal, "}");
      _elvis_1 = _nodeForKeyword_3;
    }
    final ILeafNode close = _elvis_1;
    this.formatCommaSeparatedList(literal.getElements(), open, close, document);
  }

  protected void formatCommaSeparatedList(final Collection<? extends EObject> elements, final INode open, final INode close, final FormattableDocument format) {
    HiddenLeafs _hiddenLeafsBefore = null;
    if (close!=null) {
      _hiddenLeafsBefore=this._hiddenLeafAccess.getHiddenLeafsBefore(close);
    }
    int _newLines = 0;
    if (_hiddenLeafsBefore!=null) {
      _newLines=_hiddenLeafsBefore.getNewLines();
    }
    boolean _greaterThan = (_newLines > 0);
    if (_greaterThan) {
      INode comma = null;
      boolean _isEmpty = elements.isEmpty();
      if (_isEmpty) {
        final Procedure1<FormattingDataInit> _function = (FormattingDataInit it) -> {
          it.noSpace();
        };
        Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(open, _function);
        format.operator_add(_append);
      } else {
        for (final EObject elem : elements) {
          {
            EObject _head = IterableExtensions.head(elements);
            boolean _equals = Objects.equal(elem, _head);
            if (_equals) {
              final Procedure1<FormattingDataInit> _function_1 = (FormattingDataInit it) -> {
                it.newLine();
                it.increaseIndentation();
              };
              Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(open, _function_1);
              format.operator_add(_append_1);
            } else {
              if ((comma != null)) {
                final Procedure1<FormattingDataInit> _function_2 = (FormattingDataInit it) -> {
                  it.newLine();
                };
                Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_2 = this._formattingDataFactory.append(comma, _function_2);
                format.operator_add(_append_2);
              }
            }
            EObject _last = IterableExtensions.last(elements);
            boolean _equals_1 = Objects.equal(elem, _last);
            if (_equals_1) {
              final Procedure1<FormattingDataInit> _function_3 = (FormattingDataInit it) -> {
                it.newLine();
                it.decreaseIndentation();
              };
              Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_3 = this._formattingDataFactory.append(this._nodeModelAccess.nodeForEObject(elem), _function_3);
              format.operator_add(_append_3);
            }
            this.format(elem, format);
            comma = this._nodeModelAccess.immediatelyFollowingKeyword(this._nodeModelAccess.nodeForEObject(elem), ",");
            final Procedure1<FormattingDataInit> _function_4 = (FormattingDataInit it) -> {
              it.noSpace();
            };
            Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(comma, _function_4);
            format.operator_add(_prepend);
          }
        }
      }
    } else {
      INode comma_1 = null;
      boolean indented = false;
      for (final EObject elem_1 : elements) {
        {
          boolean _fitsIntoLine = this.fitsIntoLine(format, elem_1);
          if (_fitsIntoLine) {
            if ((comma_1 == null)) {
              final Procedure1<FormattingDataInit> _function_1 = (FormattingDataInit it) -> {
                it.noSpace();
              };
              Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(open, _function_1);
              format.operator_add(_append_1);
            } else {
              final Procedure1<FormattingDataInit> _function_2 = (FormattingDataInit it) -> {
                it.oneSpace();
              };
              Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_2 = this._formattingDataFactory.append(comma_1, _function_2);
              format.operator_add(_append_2);
            }
          } else {
            INode _xifexpression = null;
            if ((comma_1 == null)) {
              _xifexpression = open;
            } else {
              _xifexpression = comma_1;
            }
            final INode n = _xifexpression;
            final Procedure1<FormattingDataInit> _function_3 = (FormattingDataInit it) -> {
              it.newLine();
            };
            Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_3 = this._formattingDataFactory.append(n, _function_3);
            format.operator_add(_append_3);
            if ((!indented)) {
              final Procedure1<FormattingDataInit> _function_4 = (FormattingDataInit it) -> {
                it.increaseIndentation();
              };
              Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_4 = this._formattingDataFactory.append(n, _function_4);
              format.operator_add(_append_4);
            }
            indented = true;
          }
          this.format(elem_1, format);
          comma_1 = this._nodeModelAccess.immediatelyFollowingKeyword(this._nodeModelAccess.nodeForEObject(elem_1), ",");
          final Procedure1<FormattingDataInit> _function_5 = (FormattingDataInit it) -> {
            it.noSpace();
          };
          Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(comma_1, _function_5);
          format.operator_add(_prepend);
        }
      }
      int _size = elements.size();
      boolean _greaterThan_1 = (_size > 0);
      if (_greaterThan_1) {
        final INode last = this._nodeModelAccess.nodeForEObject(IterableExtensions.last(elements));
        final Procedure1<FormattingDataInit> _function_1 = (FormattingDataInit it) -> {
          it.noSpace();
        };
        Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(last, _function_1);
        format.operator_add(_append_1);
        if (indented) {
          final Procedure1<FormattingDataInit> _function_2 = (FormattingDataInit it) -> {
            it.decreaseIndentation();
          };
          Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_2 = this._formattingDataFactory.append(last, _function_2);
          format.operator_add(_append_2);
        }
      } else {
        final Procedure1<FormattingDataInit> _function_3 = (FormattingDataInit it) -> {
          it.noSpace();
        };
        Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_3 = this._formattingDataFactory.append(open, _function_3);
        format.operator_add(_append_3);
      }
    }
  }

  protected void _format(final XAnnotation ann, final FormattableDocument document) {
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(ann, "@");
    final Procedure1<ILeafNode> _function = (ILeafNode it) -> {
      final Procedure1<FormattingDataInit> _function_1 = (FormattingDataInit it_1) -> {
        it_1.noSpace();
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(it, _function_1);
      document.operator_add(_append);
    };
    ObjectExtensions.<ILeafNode>operator_doubleArrow(_nodeForKeyword, _function);
    ILeafNode _nodeForKeyword_1 = this._nodeModelAccess.nodeForKeyword(ann, "(");
    final Procedure1<ILeafNode> _function_1 = (ILeafNode it) -> {
      final Procedure1<FormattingDataInit> _function_2 = (FormattingDataInit it_1) -> {
        it_1.noSpace();
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(it, _function_2);
      document.operator_add(_prepend);
      final Procedure1<FormattingDataInit> _function_3 = (FormattingDataInit it_1) -> {
        it_1.noSpace();
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(it, _function_3);
      document.operator_add(_append);
    };
    ObjectExtensions.<ILeafNode>operator_doubleArrow(_nodeForKeyword_1, _function_1);
    XExpression _value = ann.getValue();
    boolean _tripleNotEquals = (_value != null);
    if (_tripleNotEquals) {
      this.format(ann.getValue(), document);
      ILeafNode _nodeForKeyword_2 = this._nodeModelAccess.nodeForKeyword(ann, ")");
      final Procedure1<ILeafNode> _function_2 = (ILeafNode it) -> {
        final Procedure1<FormattingDataInit> _function_3 = (FormattingDataInit it_1) -> {
          it_1.noSpace();
        };
        Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(it, _function_3);
        document.operator_add(_prepend);
      };
      ObjectExtensions.<ILeafNode>operator_doubleArrow(_nodeForKeyword_2, _function_2);
    } else {
      boolean _isEmpty = ann.getElementValuePairs().isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        EList<XAnnotationElementValuePair> _elementValuePairs = ann.getElementValuePairs();
        for (final XAnnotationElementValuePair pair : _elementValuePairs) {
          {
            ILeafNode _nodeForKeyword_3 = this._nodeModelAccess.nodeForKeyword(pair, "=");
            final Procedure1<ILeafNode> _function_3 = (ILeafNode it) -> {
              final Procedure1<FormattingDataInit> _function_4 = (FormattingDataInit it_1) -> {
                it_1.noSpace();
              };
              Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(it, _function_4);
              document.operator_add(_prepend);
              final Procedure1<FormattingDataInit> _function_5 = (FormattingDataInit it_1) -> {
                it_1.noSpace();
              };
              Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(it, _function_5);
              document.operator_add(_append);
            };
            ObjectExtensions.<ILeafNode>operator_doubleArrow(_nodeForKeyword_3, _function_3);
            this.format(pair.getValue(), document);
            final ILeafNode separator = this._nodeModelAccess.immediatelyFollowingKeyword(this._nodeModelAccess.nodeForEObject(pair), ",");
            final Procedure1<FormattingDataInit> _function_4 = (FormattingDataInit it) -> {
              it.noSpace();
            };
            Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(separator, _function_4);
            document.operator_add(_prepend);
            final Procedure1<FormattingDataInit> _function_5 = (FormattingDataInit it) -> {
              it.oneSpace();
            };
            Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(separator, _function_5);
            document.operator_add(_append);
          }
        }
        ILeafNode _nodeForKeyword_3 = this._nodeModelAccess.nodeForKeyword(ann, ")");
        final Procedure1<ILeafNode> _function_3 = (ILeafNode it) -> {
          final Procedure1<FormattingDataInit> _function_4 = (FormattingDataInit it_1) -> {
            it_1.noSpace();
          };
          Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(it, _function_4);
          document.operator_add(_prepend);
        };
        ObjectExtensions.<ILeafNode>operator_doubleArrow(_nodeForKeyword_3, _function_3);
      }
    }
  }

  protected void _format(final JvmGenericArrayTypeReference array, final FormattableDocument document) {
    final Procedure1<FormattingDataInit> _function = (FormattingDataInit it) -> {
      it.noSpace();
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(this._nodeModelAccess.nodeForKeyword(array, "["), _function);
    document.operator_add(_prepend);
    final Procedure1<FormattingDataInit> _function_1 = (FormattingDataInit it) -> {
      it.noSpace();
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend_1 = this._formattingDataFactory.prepend(this._nodeModelAccess.nodeForKeyword(array, "]"), _function_1);
    document.operator_add(_prepend_1);
    this.format(array.getComponentType(), document);
  }

  protected void _format(final XFunctionTypeRef func, final FormattableDocument document) {
    final Procedure1<FormattingDataInit> _function = (FormattingDataInit it) -> {
      it.noSpace();
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(this._nodeModelAccess.nodeForKeyword(func, "("), _function);
    document.operator_add(_append);
    EList<JvmTypeReference> _paramTypes = func.getParamTypes();
    for (final JvmTypeReference param : _paramTypes) {
      {
        this.format(param, document);
        final Procedure1<FormattingDataInit> _function_1 = (FormattingDataInit it) -> {
          it.noSpace();
        };
        final Procedure1<FormattingDataInit> _function_2 = (FormattingDataInit it) -> {
          it.oneSpace();
        };
        Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _surround = this._formattingDataFactory.surround(this._nodeModelAccess.immediatelyFollowingKeyword(this._nodeModelAccess.nodeForEObject(param), ","), _function_1, _function_2);
        document.operator_add(_surround);
      }
    }
    final Procedure1<FormattingDataInit> _function_1 = (FormattingDataInit it) -> {
      boolean _isEmpty = func.getParamTypes().isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        it.noSpace();
      }
    };
    final Procedure1<FormattingDataInit> _function_2 = (FormattingDataInit it) -> {
      it.noSpace();
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _surround = this._formattingDataFactory.surround(this._nodeModelAccess.nodeForKeyword(func, ")"), _function_1, _function_2);
    document.operator_add(_surround);
    final Procedure1<FormattingDataInit> _function_3 = (FormattingDataInit it) -> {
      it.noSpace();
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(this._nodeModelAccess.nodeForKeyword(func, "=>"), _function_3);
    document.operator_add(_append_1);
    this.format(func.getReturnType(), document);
  }

  protected void _format(final JvmTypeParameter ref, final FormattableDocument document) {
    EList<JvmTypeConstraint> _constraints = ref.getConstraints();
    for (final JvmTypeConstraint c : _constraints) {
      {
        final Procedure1<FormattingDataInit> _function = (FormattingDataInit it) -> {
          it.oneSpace();
        };
        Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(this._nodeModelAccess.nodeForEObject(c), _function);
        document.operator_add(_prepend);
        this.format(c, document);
      }
    }
  }

  protected void _format(final JvmParameterizedTypeReference ref, final FormattableDocument document) {
    final Procedure1<FormattingDataInit> _function = (FormattingDataInit it) -> {
      it.noSpace();
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _surround = this._formattingDataFactory.surround(this._nodeModelAccess.nodeForKeyword(ref, "<"), _function);
    document.operator_add(_surround);
    EList<JvmTypeReference> _arguments = ref.getArguments();
    for (final JvmTypeReference arg : _arguments) {
      {
        this.format(arg, document);
        final Procedure1<FormattingDataInit> _function_1 = (FormattingDataInit it) -> {
          it.noSpace();
        };
        final Procedure1<FormattingDataInit> _function_2 = (FormattingDataInit it) -> {
          it.oneSpace();
        };
        Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _surround_1 = this._formattingDataFactory.surround(this._nodeModelAccess.immediatelyFollowingKeyword(this._nodeModelAccess.nodeForEObject(arg), ","), _function_1, _function_2);
        document.operator_add(_surround_1);
      }
    }
    boolean _isEmpty = ref.getArguments().isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      final Procedure1<FormattingDataInit> _function_1 = (FormattingDataInit it) -> {
        it.noSpace();
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(this._nodeModelAccess.nodeForKeyword(ref, ">"), _function_1);
      document.operator_add(_prepend);
    }
  }

  protected void _format(final JvmWildcardTypeReference ref, final FormattableDocument document) {
    boolean _isEmpty = ref.getConstraints().isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      final Procedure1<FormattingDataInit> _function = (FormattingDataInit it) -> {
        it.oneSpace();
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(this._nodeModelAccess.nodeForKeyword(ref, "?"), _function);
      document.operator_add(_append);
    }
    EList<JvmTypeConstraint> _constraints = ref.getConstraints();
    for (final JvmTypeConstraint c : _constraints) {
      this.format(c, document);
    }
  }

  protected void _format(final JvmTypeConstraint constraint, final FormattableDocument document) {
    final Procedure1<FormattingDataInit> _function = (FormattingDataInit it) -> {
      it.oneSpace();
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(this._nodeModelAccess.nodeForFeature(constraint, TypesPackage.Literals.JVM_TYPE_CONSTRAINT__TYPE_REFERENCE), _function);
    document.operator_add(_prepend);
    this.format(constraint.getTypeReference(), document);
  }

  protected void _format(final XVariableDeclaration expr, final FormattableDocument format) {
    final Procedure1<FormattingDataInit> _function = (FormattingDataInit it) -> {
      it.oneSpace();
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(this._nodeModelAccess.nodeForKeyword(expr, "val"), _function);
    format.operator_add(_append);
    final Procedure1<FormattingDataInit> _function_1 = (FormattingDataInit it) -> {
      it.oneSpace();
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(this._nodeModelAccess.nodeForKeyword(expr, "var"), _function_1);
    format.operator_add(_append_1);
    final Procedure1<FormattingDataInit> _function_2 = (FormattingDataInit it) -> {
      it.oneSpace();
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_2 = this._formattingDataFactory.append(this._nodeModelAccess.nodeForFeature(expr, XbasePackage.Literals.XVARIABLE_DECLARATION__TYPE), _function_2);
    format.operator_add(_append_2);
    final Procedure1<FormattingDataInit> _function_3 = (FormattingDataInit it) -> {
      it.oneSpace();
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _surround = this._formattingDataFactory.surround(this._nodeModelAccess.nodeForKeyword(expr, "="), _function_3);
    format.operator_add(_surround);
    this.format(expr.getType(), format);
    this.format(expr.getRight(), format);
  }

  protected void _format(final XAssignment expr, final FormattableDocument format) {
    final Procedure1<FormattingDataInit> _function = (FormattingDataInit it) -> {
      it.oneSpace();
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _surround = this._formattingDataFactory.surround(this._nodeModelAccess.nodeForKeyword(expr, "="), _function);
    format.operator_add(_surround);
    String _xifexpression = null;
    boolean _isExplicitStatic = expr.isExplicitStatic();
    if (_isExplicitStatic) {
      _xifexpression = "::";
    } else {
      _xifexpression = ".";
    }
    final Procedure1<FormattingDataInit> _function_1 = (FormattingDataInit it) -> {
      it.noSpace();
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _surround_1 = this._formattingDataFactory.surround(this._nodeModelAccess.nodeForKeyword(expr, _xifexpression), _function_1);
    format.operator_add(_surround_1);
    this.format(expr.getAssignable(), format);
    this.format(expr.getValue(), format);
  }

  protected void formatStaticQualifier(final INode node, final FormattableDocument document) {
    if ((node instanceof ICompositeNode)) {
      final Iterable<ILeafNode> leafs = ((ICompositeNode)node).getLeafNodes();
      for (final ILeafNode n : leafs) {
        if (((n.getGrammarElement() instanceof Keyword) && Objects.equal(n.getText(), "::"))) {
          final Procedure1<FormattingDataInit> _function = (FormattingDataInit it) -> {
            it.noSpace();
          };
          Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(n, _function);
          document.operator_add(_prepend);
          ILeafNode _last = IterableExtensions.<ILeafNode>last(leafs);
          boolean _notEquals = (!Objects.equal(n, _last));
          if (_notEquals) {
            final Procedure1<FormattingDataInit> _function_1 = (FormattingDataInit it) -> {
              it.noSpace();
            };
            Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(n, _function_1);
            document.operator_add(_append);
          }
        }
      }
    }
  }

  protected boolean fitsIntoLine(final FormattableDocument fmt, final EObject expression) {
    final INode node = this._nodeModelAccess.nodeForEObject(expression);
    final String lookahead = this.lookahead(fmt, expression);
    if (((node == null) || lookahead.contains("\n"))) {
      return false;
    } else {
      int _lineLengthBefore = fmt.lineLengthBefore(node.getOffset());
      int _length = lookahead.length();
      final int length = (_lineLengthBefore + _length);
      int _get = fmt.getCfg().get(BasicFormatterPreferenceKeys.maxLineWidth);
      return (length <= _get);
    }
  }

  protected String lookahead(final FormattableDocument fmt, final EObject expression) {
    String _xblockexpression = null;
    {
      final FormattableDocument lookahead = new FormattableDocument(fmt);
      this.format(expression, lookahead);
      final INode node = this._nodeModelAccess.nodeForEObject(expression);
      String _xifexpression = null;
      if ((node != null)) {
        String _xblockexpression_1 = null;
        {
          final ITextRegion textRegion = node.getTextRegion();
          _xblockexpression_1 = lookahead.renderToString(textRegion.getOffset(), textRegion.getLength());
        }
        _xifexpression = _xblockexpression_1;
      } else {
        _xifexpression = "";
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  protected void formatFeatureCallParamsWrapIfNeeded(final INode open, final List<XExpression> params, final FormattableDocument format) {
    final XClosure builder = this.builder(params);
    final Iterable<XExpression> explicitParams = this.explicitParams(params);
    INode node = null;
    boolean indented = false;
    boolean _isEmpty = IterableExtensions.isEmpty(explicitParams);
    if (_isEmpty) {
      final Procedure1<FormattingDataInit> _function = (FormattingDataInit it) -> {
        it.noSpace();
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(open, _function);
      format.operator_add(_append);
    } else {
      for (final XExpression arg : explicitParams) {
        {
          XExpression _head = IterableExtensions.<XExpression>head(explicitParams);
          boolean _equals = Objects.equal(arg, _head);
          if (_equals) {
            final INode head = this._nodeModelAccess.nodeForEObject(arg);
            boolean _fitsIntoLine = this.fitsIntoLine(format, arg);
            if (_fitsIntoLine) {
              final Procedure1<FormattingDataInit> _function_1 = (FormattingDataInit it) -> {
                it.noSpace();
              };
              Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(head, _function_1);
              format.operator_add(_prepend);
            } else {
              final Procedure1<FormattingDataInit> _function_2 = (FormattingDataInit it) -> {
                it.newLine();
              };
              Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend_1 = this._formattingDataFactory.prepend(head, _function_2);
              format.operator_add(_prepend_1);
              if ((!indented)) {
                final Procedure1<FormattingDataInit> _function_3 = (FormattingDataInit it) -> {
                  it.increaseIndentation();
                };
                Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend_2 = this._formattingDataFactory.prepend(head, _function_3);
                format.operator_add(_prepend_2);
              }
              indented = true;
            }
          } else {
            if ((node != null)) {
              boolean _fitsIntoLine_1 = this.fitsIntoLine(format, arg);
              if (_fitsIntoLine_1) {
                final Procedure1<FormattingDataInit> _function_4 = (FormattingDataInit it) -> {
                  it.oneSpace();
                };
                Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(node, _function_4);
                format.operator_add(_append_1);
              } else {
                final Procedure1<FormattingDataInit> _function_5 = (FormattingDataInit it) -> {
                  it.newLine();
                };
                Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_2 = this._formattingDataFactory.append(node, _function_5);
                format.operator_add(_append_2);
                if ((!indented)) {
                  final Procedure1<FormattingDataInit> _function_6 = (FormattingDataInit it) -> {
                    it.increaseIndentation();
                  };
                  Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_3 = this._formattingDataFactory.append(node, _function_6);
                  format.operator_add(_append_3);
                }
                indented = true;
              }
            }
          }
          XExpression _last = IterableExtensions.<XExpression>last(explicitParams);
          boolean _equals_1 = Objects.equal(arg, _last);
          if (_equals_1) {
            final Procedure1<FormattingDataInit> _function_7 = (FormattingDataInit it) -> {
              it.noSpace();
            };
            Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_4 = this._formattingDataFactory.append(this._nodeModelAccess.nodeForEObject(arg), _function_7);
            format.operator_add(_append_4);
          }
          this.format(arg, format);
          node = this._nodeModelAccess.immediatelyFollowingKeyword(this._nodeModelAccess.nodeForEObject(arg), ",");
          final Procedure1<FormattingDataInit> _function_8 = (FormattingDataInit it) -> {
            it.noSpace();
          };
          Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend_3 = this._formattingDataFactory.prepend(node, _function_8);
          format.operator_add(_prepend_3);
        }
      }
    }
    if (indented) {
      final Procedure1<FormattingDataInit> _function_1 = (FormattingDataInit it) -> {
        it.decreaseIndentation();
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(this._nodeModelAccess.nodeForEObject(IterableExtensions.<XExpression>last(explicitParams)), _function_1);
      format.operator_add(_append_1);
    }
    if ((builder != null)) {
      final Procedure1<FormattingDataInit> _function_2 = (FormattingDataInit it) -> {
        boolean _isMultilineLambda = this.isMultilineLambda(builder);
        if (_isMultilineLambda) {
          it.oneSpace();
        } else {
          it.noSpace();
        }
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(this._nodeModelAccess.nodeForEObject(builder), _function_2);
      format.operator_add(_prepend);
      this.format(builder, format);
    }
  }

  protected XClosure builder(final List<XExpression> params) {
    XClosure _xifexpression = null;
    XExpression _last = IterableExtensions.<XExpression>last(params);
    boolean _tripleNotEquals = (_last != null);
    if (_tripleNotEquals) {
      XClosure _xblockexpression = null;
      {
        INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(IterableExtensions.<XExpression>last(params));
        final EObject grammarElement = ((ICompositeNode) _nodeForEObject).getFirstChild().getGrammarElement();
        XClosure _xifexpression_1 = null;
        if (((Objects.equal(grammarElement, this._xbaseGrammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXClosureParserRuleCall_1_1_4_0()) || 
          Objects.equal(grammarElement, this._xbaseGrammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXClosureParserRuleCall_4_0())) || 
          Objects.equal(grammarElement, this._xbaseGrammarAccess.getXConstructorCallAccess().getArgumentsXClosureParserRuleCall_5_0()))) {
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

  protected void formatFeatureCallParamsMultiline(final INode open, final List<XExpression> params, final FormattableDocument format) {
    final XClosure builder = this.builder(params);
    final Iterable<XExpression> explicitParams = this.explicitParams(params);
    INode node = null;
    boolean _isEmpty = IterableExtensions.isEmpty(explicitParams);
    if (_isEmpty) {
      final Procedure1<FormattingDataInit> _function = (FormattingDataInit it) -> {
        it.noSpace();
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(open, _function);
      format.operator_add(_append);
    } else {
      for (final XExpression arg : explicitParams) {
        {
          XExpression _head = IterableExtensions.<XExpression>head(explicitParams);
          boolean _equals = Objects.equal(arg, _head);
          if (_equals) {
            final INode head = this._nodeModelAccess.nodeForEObject(arg);
            final Procedure1<FormattingDataInit> _function_1 = (FormattingDataInit it) -> {
              it.newLine();
              it.increaseIndentation();
            };
            Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(head, _function_1);
            format.operator_add(_prepend);
          } else {
            if ((node != null)) {
              final Procedure1<FormattingDataInit> _function_2 = (FormattingDataInit it) -> {
                it.newLine();
              };
              Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(node, _function_2);
              format.operator_add(_append_1);
            }
          }
          XExpression _last = IterableExtensions.<XExpression>last(explicitParams);
          boolean _equals_1 = Objects.equal(arg, _last);
          if (_equals_1) {
            final Procedure1<FormattingDataInit> _function_3 = (FormattingDataInit it) -> {
              it.newLine();
              it.decreaseIndentation();
            };
            Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_2 = this._formattingDataFactory.append(this._nodeModelAccess.nodeForEObject(arg), _function_3);
            format.operator_add(_append_2);
          }
          this.format(arg, format);
          node = this._nodeModelAccess.immediatelyFollowingKeyword(this._nodeModelAccess.nodeForEObject(arg), ",");
          final Procedure1<FormattingDataInit> _function_4 = (FormattingDataInit it) -> {
            it.noSpace();
          };
          Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend_1 = this._formattingDataFactory.prepend(node, _function_4);
          format.operator_add(_prepend_1);
        }
      }
    }
    if ((builder != null)) {
      final Procedure1<FormattingDataInit> _function_1 = (FormattingDataInit it) -> {
        boolean _isMultilineLambda = this.isMultilineLambda(builder);
        if (_isMultilineLambda) {
          it.oneSpace();
        } else {
          it.noSpace();
        }
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(this._nodeModelAccess.nodeForEObject(builder), _function_1);
      format.operator_add(_prepend);
      this.format(builder, format);
    }
  }

  /**
   * checks whether the given lambda should be formatted as a block.
   * That includes newlines after and before the brackets, and a fresh line for each expression.
   */
  protected boolean isMultilineLambda(final XClosure closure) {
    final ILeafNode closingBracket = this._nodeModelAccess.nodeForKeyword(closure, "]");
    HiddenLeafs _hiddenLeafsBefore = null;
    if (closingBracket!=null) {
      _hiddenLeafsBefore=this._hiddenLeafAccess.getHiddenLeafsBefore(closingBracket);
    }
    boolean _tripleNotEquals = (_hiddenLeafsBefore != null);
    if (_tripleNotEquals) {
      int _newLines = this._hiddenLeafAccess.getHiddenLeafsBefore(closingBracket).getNewLines();
      return (_newLines > 0);
    }
    boolean _switchResult = false;
    XExpression _expression = closure.getExpression();
    final XExpression block = _expression;
    boolean _matched = false;
    if (block instanceof XBlockExpression) {
      _matched=true;
      _switchResult = ((((XBlockExpression)block).getExpressions().size() > 1) && this.isEachExpressionInOwnLine(((XBlockExpression)block).getExpressions()));
    }
    if (!_matched) {
      _switchResult = false;
    }
    return _switchResult;
  }

  protected boolean isEachExpressionInOwnLine(final Iterable<? extends XExpression> expressions) {
    int lastLine = (-1);
    for (final XExpression e : expressions) {
      {
        final INode node = this._nodeModelAccess.nodeForEObject(e);
        int _startLine = node.getStartLine();
        boolean _equals = (lastLine == _startLine);
        if (_equals) {
          return false;
        }
        lastLine = node.getEndLine();
      }
    }
    return true;
  }

  protected void _format(final XConstructorCall expr, final FormattableDocument format) {
    final Procedure1<FormattingDataInit> _function = (FormattingDataInit it) -> {
      it.oneSpace();
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(this._nodeModelAccess.nodeForFeature(expr, XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR), _function);
    format.operator_add(_prepend);
    boolean _isEmpty = expr.getTypeArguments().isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      final Procedure1<FormattingDataInit> _function_1 = (FormattingDataInit it) -> {
        it.noSpace();
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _surround = this._formattingDataFactory.surround(this._nodeModelAccess.nodeForKeyword(expr, "<"), _function_1);
      format.operator_add(_surround);
      EList<JvmTypeReference> _typeArguments = expr.getTypeArguments();
      for (final JvmTypeReference arg : _typeArguments) {
        {
          this.format(arg, format);
          final Procedure1<FormattingDataInit> _function_2 = (FormattingDataInit it) -> {
            it.noSpace();
          };
          final Procedure1<FormattingDataInit> _function_3 = (FormattingDataInit it) -> {
            it.oneSpace();
          };
          Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _surround_1 = this._formattingDataFactory.surround(this._nodeModelAccess.immediatelyFollowingKeyword(arg, ","), _function_2, _function_3);
          format.operator_add(_surround_1);
        }
      }
      final Procedure1<FormattingDataInit> _function_2 = (FormattingDataInit it) -> {
        it.noSpace();
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend_1 = this._formattingDataFactory.prepend(this._nodeModelAccess.nodeForKeyword(expr, ">"), _function_2);
      format.operator_add(_prepend_1);
    }
    final ILeafNode open = this._nodeModelAccess.nodeForKeyword(expr, "(");
    final Procedure1<FormattingDataInit> _function_3 = (FormattingDataInit it) -> {
      it.noSpace();
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend_2 = this._formattingDataFactory.prepend(open, _function_3);
    format.operator_add(_prepend_2);
    boolean _isMultiParamInOwnLine = this.isMultiParamInOwnLine(expr, format);
    if (_isMultiParamInOwnLine) {
      this.formatFeatureCallParamsMultiline(open, expr.getArguments(), format);
    } else {
      this.formatFeatureCallParamsWrapIfNeeded(open, expr.getArguments(), format);
    }
  }

  protected void formatFeatureCallTypeParameters(final XAbstractFeatureCall expr, final FormattableDocument format) {
    boolean _isEmpty = expr.getTypeArguments().isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      final Procedure1<FormattingDataInit> _function = (FormattingDataInit it) -> {
        it.noSpace();
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(this._nodeModelAccess.nodeForKeyword(expr, "<"), _function);
      format.operator_add(_append);
      EList<JvmTypeReference> _typeArguments = expr.getTypeArguments();
      for (final JvmTypeReference arg : _typeArguments) {
        {
          this.format(arg, format);
          final Procedure1<FormattingDataInit> _function_1 = (FormattingDataInit it) -> {
            it.noSpace();
          };
          final Procedure1<FormattingDataInit> _function_2 = (FormattingDataInit it) -> {
            it.oneSpace();
          };
          Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _surround = this._formattingDataFactory.surround(this._nodeModelAccess.immediatelyFollowingKeyword(arg, ","), _function_1, _function_2);
          format.operator_add(_surround);
        }
      }
      final Procedure1<FormattingDataInit> _function_1 = (FormattingDataInit it) -> {
        it.noSpace();
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _surround = this._formattingDataFactory.surround(this._nodeModelAccess.nodeForKeyword(expr, ">"), _function_1);
      format.operator_add(_surround);
    }
  }

  protected void _format(final XFeatureCall expr, final FormattableDocument format) {
    this.formatFeatureCallTypeParameters(expr, format);
    boolean _isExplicitOperationCall = expr.isExplicitOperationCall();
    if (_isExplicitOperationCall) {
      final ILeafNode open = this._nodeModelAccess.nodeForKeyword(expr, "(");
      final Procedure1<FormattingDataInit> _function = (FormattingDataInit it) -> {
        it.noSpace();
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(open, _function);
      format.operator_add(_prepend);
      boolean _isMultiParamInOwnLine = this.isMultiParamInOwnLine(expr, format);
      if (_isMultiParamInOwnLine) {
        this.formatFeatureCallParamsMultiline(open, expr.getFeatureCallArguments(), format);
      } else {
        this.formatFeatureCallParamsWrapIfNeeded(open, expr.getFeatureCallArguments(), format);
      }
    } else {
      EList<XExpression> _featureCallArguments = expr.getFeatureCallArguments();
      for (final XExpression arg : _featureCallArguments) {
        this.format(arg, format);
      }
    }
  }

  protected boolean _isMultiParamInOwnLine(final XMemberFeatureCall fc, final FormattableDocument doc) {
    final ILeafNode closingBracket = this._nodeModelAccess.nodeForKeyword(fc, ")");
    HiddenLeafs _hiddenLeafsBefore = null;
    if (closingBracket!=null) {
      _hiddenLeafsBefore=this._hiddenLeafAccess.getHiddenLeafsBefore(closingBracket);
    }
    boolean _tripleNotEquals = (_hiddenLeafsBefore != null);
    if (_tripleNotEquals) {
      int _newLines = this._hiddenLeafAccess.getHiddenLeafsBefore(closingBracket).getNewLines();
      return (_newLines > 0);
    }
    final Iterable<XExpression> params = this.explicitParams(fc.getMemberCallArguments());
    return ((IterableExtensions.size(params) > 1) && this.isEachExpressionInOwnLine(params));
  }

  protected boolean _isMultiParamInOwnLine(final XFeatureCall fc, final FormattableDocument doc) {
    final ILeafNode closingBracket = this._nodeModelAccess.nodeForKeyword(fc, ")");
    HiddenLeafs _hiddenLeafsBefore = null;
    if (closingBracket!=null) {
      _hiddenLeafsBefore=this._hiddenLeafAccess.getHiddenLeafsBefore(closingBracket);
    }
    boolean _tripleNotEquals = (_hiddenLeafsBefore != null);
    if (_tripleNotEquals) {
      int _newLines = this._hiddenLeafAccess.getHiddenLeafsBefore(closingBracket).getNewLines();
      return (_newLines > 0);
    }
    final Iterable<XExpression> params = this.explicitParams(fc.getFeatureCallArguments());
    return ((IterableExtensions.size(params) > 1) && this.isEachExpressionInOwnLine(params));
  }

  protected boolean _isMultiParamInOwnLine(final XConstructorCall fc, final FormattableDocument doc) {
    final ILeafNode closingBracket = this._nodeModelAccess.nodeForKeyword(fc, ")");
    HiddenLeafs _hiddenLeafsBefore = null;
    if (closingBracket!=null) {
      _hiddenLeafsBefore=this._hiddenLeafAccess.getHiddenLeafsBefore(closingBracket);
    }
    boolean _tripleNotEquals = (_hiddenLeafsBefore != null);
    if (_tripleNotEquals) {
      int _newLines = this._hiddenLeafAccess.getHiddenLeafsBefore(closingBracket).getNewLines();
      return (_newLines > 0);
    }
    final Iterable<XExpression> params = this.explicitParams(fc.getArguments());
    return ((IterableExtensions.size(params) > 1) && this.isEachExpressionInOwnLine(params));
  }

  protected void _format(final XMemberFeatureCall expr, final FormattableDocument format) {
    EObject top = expr;
    ArrayList<XMemberFeatureCall> calls = CollectionLiterals.<XMemberFeatureCall>newArrayList();
    while ((top instanceof XMemberFeatureCall)) {
      {
        calls.add(((XMemberFeatureCall)top));
        top = ((XMemberFeatureCall)top).getMemberCallTarget();
      }
    }
    this.format(top, format);
    boolean indented = false;
    List<XMemberFeatureCall> _reverse = ListExtensions.<XMemberFeatureCall>reverse(calls);
    for (final XMemberFeatureCall call : _reverse) {
      {
        this.formatFeatureCallTypeParameters(call, format);
        final INode featureNode = this._nodeModelAccess.nodeForFeature(call, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE);
        final INode targetNode = this._nodeModelAccess.nodeForEObject(call.getMemberCallTarget());
        if ((targetNode != null)) {
          final int callOffset = targetNode.getEndOffset();
          String _switchResult = null;
          final XMemberFeatureCall it = call;
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
          final ILeafNode op = this._nodeModelAccess.nodeForKeyword(call, _switchResult);
          final Procedure1<FormattingDataInit> _function = (FormattingDataInit it_1) -> {
            it_1.noSpace();
          };
          Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(op, _function);
          format.operator_add(_prepend);
          boolean _isExplicitOperationCall = call.isExplicitOperationCall();
          if (_isExplicitOperationCall) {
            final INode callNode = this._nodeModelAccess.nodeForEObject(call);
            int _endOffset = callNode.getEndOffset();
            final int callLength = (_endOffset - callOffset);
            final ILeafNode open = this._nodeModelAccess.nodeForKeyword(call, "(");
            final Procedure1<FormattingDataInit> _function_1 = (FormattingDataInit it_1) -> {
              it_1.noSpace();
            };
            Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(featureNode, _function_1);
            format.operator_add(_append);
            final int lineLength = format.lineLengthBefore(callOffset);
            boolean _isMultiParamInOwnLine = this.isMultiParamInOwnLine(call, format);
            if (_isMultiParamInOwnLine) {
              int _length = featureNode.getLength();
              int _plus = (lineLength + _length);
              int _get = format.getCfg().get(BasicFormatterPreferenceKeys.maxLineWidth);
              boolean _lessThan = (_plus < _get);
              if (_lessThan) {
                final Procedure1<FormattingDataInit> _function_2 = (FormattingDataInit it_1) -> {
                  it_1.noSpace();
                };
                Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(op, _function_2);
                format.operator_add(_append_1);
              } else {
                final Procedure1<FormattingDataInit> _function_3 = (FormattingDataInit it_1) -> {
                  it_1.newLine();
                };
                Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_2 = this._formattingDataFactory.append(op, _function_3);
                format.operator_add(_append_2);
              }
              this.formatFeatureCallParamsMultiline(open, call.getMemberCallArguments(), format);
            } else {
              if ((((lineLength + (featureNode.getLength() * 2)) < format.getCfg().get(BasicFormatterPreferenceKeys.maxLineWidth)) || format.fitsIntoLine(callOffset, callLength, 
                ((Procedure1<FormattableDocument>) (FormattableDocument f) -> {
                  final Procedure1<FormattingDataInit> _function_4 = (FormattingDataInit it_1) -> {
                    it_1.noSpace();
                  };
                  Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_3 = this._formattingDataFactory.append(op, _function_4);
                  f.operator_add(_append_3);
                  this.formatFeatureCallParamsWrapIfNeeded(open, call.getMemberCallArguments(), f);
                })))) {
                final Procedure1<FormattingDataInit> _function_4 = (FormattingDataInit it_1) -> {
                  it_1.noSpace();
                };
                Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_3 = this._formattingDataFactory.append(op, _function_4);
                format.operator_add(_append_3);
              } else {
                final Procedure1<FormattingDataInit> _function_5 = (FormattingDataInit it_1) -> {
                  it_1.newLine();
                };
                Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_4 = this._formattingDataFactory.append(op, _function_5);
                format.operator_add(_append_4);
                if ((!indented)) {
                  indented = true;
                  final Procedure1<FormattingDataInit> _function_6 = (FormattingDataInit it_1) -> {
                    it_1.increaseIndentation();
                  };
                  Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_5 = this._formattingDataFactory.append(op, _function_6);
                  format.operator_add(_append_5);
                }
              }
              this.formatFeatureCallParamsWrapIfNeeded(open, call.getMemberCallArguments(), format);
            }
          } else {
            int _lineLengthBefore = format.lineLengthBefore(callOffset);
            int _length_1 = featureNode.getLength();
            final int shortLenght = (_lineLengthBefore + _length_1);
            int _get_1 = format.getCfg().get(BasicFormatterPreferenceKeys.maxLineWidth);
            boolean _lessThan_1 = (shortLenght < _get_1);
            if (_lessThan_1) {
              final Procedure1<FormattingDataInit> _function_7 = (FormattingDataInit it_1) -> {
                it_1.noSpace();
              };
              Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_6 = this._formattingDataFactory.append(op, _function_7);
              format.operator_add(_append_6);
            } else {
              final Procedure1<FormattingDataInit> _function_8 = (FormattingDataInit it_1) -> {
                it_1.newLine();
              };
              Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_7 = this._formattingDataFactory.append(op, _function_8);
              format.operator_add(_append_7);
              if ((!indented)) {
                indented = true;
                final Procedure1<FormattingDataInit> _function_9 = (FormattingDataInit it_1) -> {
                  it_1.increaseIndentation();
                };
                Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_8 = this._formattingDataFactory.append(op, _function_9);
                format.operator_add(_append_8);
              }
            }
            boolean _isEmpty = call.getMemberCallArguments().isEmpty();
            boolean _not = (!_isEmpty);
            if (_not) {
              final XClosure builder = this.builder(call.getMemberCallArguments());
              final Procedure1<FormattingDataInit> _function_10 = (FormattingDataInit it_1) -> {
                boolean _isMultilineLambda = this.isMultilineLambda(builder);
                if (_isMultilineLambda) {
                  it_1.oneSpace();
                } else {
                  it_1.noSpace();
                }
              };
              Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend_1 = this._formattingDataFactory.prepend(this._nodeModelAccess.nodeForEObject(builder), _function_10);
              format.operator_add(_prepend_1);
              this.format(builder, format);
            }
          }
        }
      }
    }
    if (indented) {
      final Procedure1<FormattingDataInit> _function = (FormattingDataInit it) -> {
        it.decreaseIndentation();
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(this._nodeModelAccess.nodeForEObject(IterableExtensions.<XMemberFeatureCall>last(calls)), _function);
      format.operator_add(_append);
    }
  }

  protected AbstractRule binaryOperationPrecedence(final EObject op) {
    final INode node = this._nodeModelAccess.nodeForFeature(op, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE);
    if (((node != null) && (node.getGrammarElement() instanceof CrossReference))) {
      EObject _grammarElement = node.getGrammarElement();
      final AbstractElement terminal = ((CrossReference) _grammarElement).getTerminal();
      if ((terminal instanceof RuleCall)) {
        return ((RuleCall)terminal).getRule();
      }
    }
    return null;
  }

  protected boolean isMultiline(final XExpression expression, final FormattableDocument doc) {
    final INode node = this._nodeModelAccess.nodeForEObject(expression);
    boolean _and = false;
    if (!(node != null)) {
      _and = false;
    } else {
      boolean _xblockexpression = false;
      {
        final ITextRegionWithLineInformation textRegion = node.getTextRegionWithLineInformation();
        int _lineNumber = textRegion.getLineNumber();
        int _endLineNumber = textRegion.getEndLineNumber();
        _xblockexpression = (_lineNumber != _endLineNumber);
      }
      _and = _xblockexpression;
    }
    return _and;
  }

  protected void _format(final XBinaryOperation expr, final FormattableDocument format) {
    AbstractRule precendece = this.binaryOperationPrecedence(expr);
    EObject top = expr;
    ArrayList<XBinaryOperation> calls = CollectionLiterals.<XBinaryOperation>newArrayList();
    while (Objects.equal(this.binaryOperationPrecedence(top), precendece)) {
      {
        calls.add(((XBinaryOperation) top));
        top = ((XBinaryOperation) top).getLeftOperand();
      }
    }
    this.format(top, format);
    boolean indented = false;
    List<XBinaryOperation> _reverse = ListExtensions.<XBinaryOperation>reverse(calls);
    for (final XBinaryOperation call : _reverse) {
      {
        final INode op = this._nodeModelAccess.nodeForFeature(call, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE);
        final Procedure1<FormattingDataInit> _function = (FormattingDataInit it) -> {
          it.oneSpace();
        };
        Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(op, _function);
        format.operator_add(_prepend);
        if ((this.isMultiline(call.getRightOperand(), format) || this.fitsIntoLine(format, call.getRightOperand()))) {
          final Procedure1<FormattingDataInit> _function_1 = (FormattingDataInit it) -> {
            it.oneSpace();
          };
          Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(op, _function_1);
          format.operator_add(_append);
        } else {
          final Procedure1<FormattingDataInit> _function_2 = (FormattingDataInit it) -> {
            it.newLine();
          };
          Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(op, _function_2);
          format.operator_add(_append_1);
          if ((!indented)) {
            indented = true;
            final Procedure1<FormattingDataInit> _function_3 = (FormattingDataInit it) -> {
              it.increaseIndentation();
            };
            Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_2 = this._formattingDataFactory.append(op, _function_3);
            format.operator_add(_append_2);
          }
        }
        this.format(call.getRightOperand(), format);
      }
    }
    if (indented) {
      final Procedure1<FormattingDataInit> _function = (FormattingDataInit it) -> {
        it.decreaseIndentation();
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(this._nodeModelAccess.nodeForEObject(IterableExtensions.<XBinaryOperation>last(calls)), _function);
      format.operator_add(_append);
    }
  }

  protected void _format(final XSynchronizedExpression expr, final FormattableDocument format) {
    EObject _eContainer = expr.eContainer();
    if ((_eContainer instanceof XVariableDeclaration)) {
      final Procedure1<FormattingDataInit> _function = (FormattingDataInit it) -> {
        it.increaseIndentation();
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(this._nodeModelAccess.nodeForKeyword(expr, "synchronized"), _function);
      format.operator_add(_append);
      final Procedure1<FormattingDataInit> _function_1 = (FormattingDataInit it) -> {
        it.decreaseIndentation();
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(this._nodeModelAccess.nodeForEObject(expr), _function_1);
      format.operator_add(_append_1);
    }
    final INode expressionnode = this._nodeModelAccess.nodeForEObject(expr.getExpression());
    boolean _or = false;
    String _text = null;
    if (expressionnode!=null) {
      _text=expressionnode.getText();
    }
    String _trim = null;
    if (_text!=null) {
      _trim=_text.trim();
    }
    boolean _contains = false;
    if (_trim!=null) {
      _contains=_trim.contains("\n");
    }
    if (_contains) {
      _or = true;
    } else {
      HiddenLeafs _hiddenLeafsBefore = null;
      if (expressionnode!=null) {
        _hiddenLeafsBefore=this._hiddenLeafAccess.getHiddenLeafsBefore(expressionnode);
      }
      int _newLines = 0;
      if (_hiddenLeafsBefore!=null) {
        _newLines=_hiddenLeafsBefore.getNewLines();
      }
      boolean _greaterThan = (_newLines > 0);
      _or = _greaterThan;
    }
    final boolean multiline = _or;
    final Procedure1<FormattingDataInit> _function_2 = (FormattingDataInit it) -> {
      it.noSpace();
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _surround = this._formattingDataFactory.surround(this._nodeModelAccess.nodeForFeature(expr, XbasePackage.Literals.XSYNCHRONIZED_EXPRESSION__PARAM), _function_2);
    format.operator_add(_surround);
    if (((expr.getExpression() instanceof XBlockExpression) || multiline)) {
      final Procedure1<FormattingDataInit> _function_3 = (FormattingDataInit it) -> {
        it.cfg(XbaseFormatterPreferenceKeys.whitespaceBetweenKeywordAndParenthesisML);
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_2 = this._formattingDataFactory.append(this._nodeModelAccess.nodeForKeyword(expr, "synchronized"), _function_3);
      format.operator_add(_append_2);
    } else {
      final Procedure1<FormattingDataInit> _function_4 = (FormattingDataInit it) -> {
        it.cfg(XbaseFormatterPreferenceKeys.whitespaceBetweenKeywordAndParenthesisSL);
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_3 = this._formattingDataFactory.append(this._nodeModelAccess.nodeForKeyword(expr, "synchronized"), _function_4);
      format.operator_add(_append_3);
    }
    XExpression _expression = expr.getExpression();
    if ((_expression instanceof XBlockExpression)) {
      final Procedure1<FormattingDataInit> _function_5 = (FormattingDataInit it) -> {
        it.cfg(XbaseFormatterPreferenceKeys.bracesInNewLine);
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(expressionnode, _function_5);
      format.operator_add(_prepend);
    } else {
      if ((!multiline)) {
        final Procedure1<FormattingDataInit> _function_6 = (FormattingDataInit it) -> {
          it.oneSpace();
        };
        Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend_1 = this._formattingDataFactory.prepend(expressionnode, _function_6);
        format.operator_add(_prepend_1);
      } else {
        final Procedure1<FormattingDataInit> _function_7 = (FormattingDataInit it) -> {
          it.newLine();
          it.increaseIndentation();
        };
        Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend_2 = this._formattingDataFactory.prepend(expressionnode, _function_7);
        format.operator_add(_prepend_2);
        final Procedure1<FormattingDataInit> _function_8 = (FormattingDataInit it) -> {
          it.decreaseIndentation();
        };
        Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_4 = this._formattingDataFactory.append(expressionnode, _function_8);
        format.operator_add(_append_4);
      }
    }
    this.format(expr.getParam(), format);
    this.format(expr.getExpression(), format);
  }

  protected void _format(final XIfExpression expr, final FormattableDocument format) {
    EObject _eContainer = expr.eContainer();
    if ((_eContainer instanceof XVariableDeclaration)) {
      final Procedure1<FormattingDataInit> _function = (FormattingDataInit it) -> {
        it.increaseIndentation();
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(this._nodeModelAccess.nodeForKeyword(expr, "if"), _function);
      format.operator_add(_append);
      final Procedure1<FormattingDataInit> _function_1 = (FormattingDataInit it) -> {
        it.decreaseIndentation();
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(this._nodeModelAccess.nodeForEObject(expr), _function_1);
      format.operator_add(_append_1);
    }
    final INode thennode = this._nodeModelAccess.nodeForEObject(expr.getThen());
    XExpression _else = expr.getElse();
    INode _nodeForEObject = null;
    if (_else!=null) {
      _nodeForEObject=this._nodeModelAccess.nodeForEObject(_else);
    }
    final INode elsenode = _nodeForEObject;
    boolean _or = false;
    boolean _or_1 = false;
    String _text = null;
    if (thennode!=null) {
      _text=thennode.getText();
    }
    String _trim = null;
    if (_text!=null) {
      _trim=_text.trim();
    }
    boolean _contains = false;
    if (_trim!=null) {
      _contains=_trim.contains("\n");
    }
    if (_contains) {
      _or_1 = true;
    } else {
      HiddenLeafs _hiddenLeafsBefore = null;
      if (thennode!=null) {
        _hiddenLeafsBefore=this._hiddenLeafAccess.getHiddenLeafsBefore(thennode);
      }
      int _newLines = 0;
      if (_hiddenLeafsBefore!=null) {
        _newLines=_hiddenLeafsBefore.getNewLines();
      }
      boolean _greaterThan = (_newLines > 0);
      _or_1 = _greaterThan;
    }
    if (_or_1) {
      _or = true;
    } else {
      String _text_1 = null;
      if (elsenode!=null) {
        _text_1=elsenode.getText();
      }
      String _trim_1 = null;
      if (_text_1!=null) {
        _trim_1=_text_1.trim();
      }
      boolean _contains_1 = false;
      if (_trim_1!=null) {
        _contains_1=_trim_1.contains("\n");
      }
      _or = _contains_1;
    }
    final boolean multiline = _or;
    final Procedure1<FormattingDataInit> _function_2 = (FormattingDataInit it) -> {
      it.noSpace();
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _surround = this._formattingDataFactory.surround(this._nodeModelAccess.nodeForFeature(expr, XbasePackage.Literals.XIF_EXPRESSION__IF), _function_2);
    format.operator_add(_surround);
    if (((expr.getThen() instanceof XBlockExpression) || multiline)) {
      final Procedure1<FormattingDataInit> _function_3 = (FormattingDataInit it) -> {
        it.cfg(XbaseFormatterPreferenceKeys.whitespaceBetweenKeywordAndParenthesisML);
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_2 = this._formattingDataFactory.append(this._nodeModelAccess.nodeForKeyword(expr, "if"), _function_3);
      format.operator_add(_append_2);
    } else {
      final Procedure1<FormattingDataInit> _function_4 = (FormattingDataInit it) -> {
        it.cfg(XbaseFormatterPreferenceKeys.whitespaceBetweenKeywordAndParenthesisSL);
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_3 = this._formattingDataFactory.append(this._nodeModelAccess.nodeForKeyword(expr, "if"), _function_4);
      format.operator_add(_append_3);
    }
    XExpression _then = expr.getThen();
    if ((_then instanceof XBlockExpression)) {
      final Procedure1<FormattingDataInit> _function_5 = (FormattingDataInit it) -> {
        it.cfg(XbaseFormatterPreferenceKeys.bracesInNewLine);
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(thennode, _function_5);
      format.operator_add(_prepend);
      XExpression _else_1 = expr.getElse();
      boolean _tripleNotEquals = (_else_1 != null);
      if (_tripleNotEquals) {
        final Procedure1<FormattingDataInit> _function_6 = (FormattingDataInit it) -> {
          it.cfg(XbaseFormatterPreferenceKeys.bracesInNewLine);
        };
        Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_4 = this._formattingDataFactory.append(thennode, _function_6);
        format.operator_add(_append_4);
      }
    } else {
      if ((!multiline)) {
        final Procedure1<FormattingDataInit> _function_7 = (FormattingDataInit it) -> {
          it.oneSpace();
        };
        Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend_1 = this._formattingDataFactory.prepend(thennode, _function_7);
        format.operator_add(_prepend_1);
        XExpression _else_2 = expr.getElse();
        boolean _tripleNotEquals_1 = (_else_2 != null);
        if (_tripleNotEquals_1) {
          final Procedure1<FormattingDataInit> _function_8 = (FormattingDataInit it) -> {
            it.oneSpace();
          };
          Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_5 = this._formattingDataFactory.append(thennode, _function_8);
          format.operator_add(_append_5);
        }
      } else {
        final Procedure1<FormattingDataInit> _function_9 = (FormattingDataInit it) -> {
          it.newLine();
          it.increaseIndentation();
        };
        Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend_2 = this._formattingDataFactory.prepend(thennode, _function_9);
        format.operator_add(_prepend_2);
        XExpression _else_3 = expr.getElse();
        boolean _tripleNotEquals_2 = (_else_3 != null);
        if (_tripleNotEquals_2) {
          final Procedure1<FormattingDataInit> _function_10 = (FormattingDataInit it) -> {
            it.newLine();
            it.decreaseIndentation();
          };
          Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_6 = this._formattingDataFactory.append(thennode, _function_10);
          format.operator_add(_append_6);
        } else {
          final Procedure1<FormattingDataInit> _function_11 = (FormattingDataInit it) -> {
            it.decreaseIndentation();
          };
          Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_7 = this._formattingDataFactory.append(thennode, _function_11);
          format.operator_add(_append_7);
        }
      }
    }
    XExpression _else_4 = expr.getElse();
    if ((_else_4 instanceof XBlockExpression)) {
      final Procedure1<FormattingDataInit> _function_12 = (FormattingDataInit it) -> {
        it.cfg(XbaseFormatterPreferenceKeys.bracesInNewLine);
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend_3 = this._formattingDataFactory.prepend(elsenode, _function_12);
      format.operator_add(_prepend_3);
    } else {
      if (((expr.getElse() instanceof XIfExpression) || (!multiline))) {
        final Procedure1<FormattingDataInit> _function_13 = (FormattingDataInit it) -> {
          it.oneSpace();
        };
        Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend_4 = this._formattingDataFactory.prepend(elsenode, _function_13);
        format.operator_add(_prepend_4);
      } else {
        final Procedure1<FormattingDataInit> _function_14 = (FormattingDataInit it) -> {
          it.newLine();
          it.increaseIndentation();
        };
        Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend_5 = this._formattingDataFactory.prepend(elsenode, _function_14);
        format.operator_add(_prepend_5);
        final Procedure1<FormattingDataInit> _function_15 = (FormattingDataInit it) -> {
          it.decreaseIndentation();
        };
        Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_8 = this._formattingDataFactory.append(elsenode, _function_15);
        format.operator_add(_append_8);
      }
    }
    this.format(expr.getIf(), format);
    this.format(expr.getThen(), format);
    XExpression _else_5 = expr.getElse();
    boolean _tripleNotEquals_3 = (_else_5 != null);
    if (_tripleNotEquals_3) {
      this.format(expr.getElse(), format);
    }
  }

  protected void _format(final XForLoopExpression expr, final FormattableDocument format) {
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(expr, "for");
    final Procedure1<ILeafNode> _function = (ILeafNode it) -> {
      final Procedure1<FormattingDataInit> _function_1 = (FormattingDataInit it_1) -> {
        it_1.oneSpace();
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(it, _function_1);
      format.operator_add(_append);
    };
    ObjectExtensions.<ILeafNode>operator_doubleArrow(_nodeForKeyword, _function);
    INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(expr.getDeclaredParam());
    final Procedure1<INode> _function_1 = (INode it) -> {
      final Procedure1<FormattingDataInit> _function_2 = (FormattingDataInit it_1) -> {
        it_1.noSpace();
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(it, _function_2);
      format.operator_add(_prepend);
      final Procedure1<FormattingDataInit> _function_3 = (FormattingDataInit it_1) -> {
        it_1.oneSpace();
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(it, _function_3);
      format.operator_add(_append);
    };
    ObjectExtensions.<INode>operator_doubleArrow(_nodeForEObject, _function_1);
    INode _nodeForEObject_1 = this._nodeModelAccess.nodeForEObject(expr.getForExpression());
    final Procedure1<INode> _function_2 = (INode it) -> {
      final Procedure1<FormattingDataInit> _function_3 = (FormattingDataInit it_1) -> {
        it_1.oneSpace();
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(it, _function_3);
      format.operator_add(_prepend);
      final Procedure1<FormattingDataInit> _function_4 = (FormattingDataInit it_1) -> {
        it_1.noSpace();
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(it, _function_4);
      format.operator_add(_append);
    };
    ObjectExtensions.<INode>operator_doubleArrow(_nodeForEObject_1, _function_2);
    final INode each = this._nodeModelAccess.nodeForEObject(expr.getEachExpression());
    XExpression _eachExpression = expr.getEachExpression();
    if ((_eachExpression instanceof XBlockExpression)) {
      final Procedure1<FormattingDataInit> _function_3 = (FormattingDataInit it) -> {
        it.cfg(XbaseFormatterPreferenceKeys.bracesInNewLine);
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(each, _function_3);
      format.operator_add(_prepend);
    } else {
      final Procedure1<FormattingDataInit> _function_4 = (FormattingDataInit it) -> {
        it.newLine();
        it.increaseIndentation();
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend_1 = this._formattingDataFactory.prepend(each, _function_4);
      format.operator_add(_prepend_1);
      final Procedure1<FormattingDataInit> _function_5 = (FormattingDataInit it) -> {
        it.decreaseIndentation();
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(each, _function_5);
      format.operator_add(_append);
    }
    this.format(expr.getForExpression(), format);
    this.format(expr.getEachExpression(), format);
  }

  protected void _format(final XBasicForLoopExpression expr, final FormattableDocument format) {
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(expr, "for");
    final Procedure1<ILeafNode> _function = (ILeafNode it) -> {
      final Procedure1<FormattingDataInit> _function_1 = (FormattingDataInit it_1) -> {
        it_1.oneSpace();
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(it, _function_1);
      format.operator_add(_append);
    };
    INode previousFormattedNode = ObjectExtensions.<ILeafNode>operator_doubleArrow(_nodeForKeyword, _function);
    final EList<XExpression> initExpressions = expr.getInitExpressions();
    boolean _isEmpty = initExpressions.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      for (final XExpression initExpression : initExpressions) {
        {
          XExpression _head = IterableExtensions.<XExpression>head(expr.getInitExpressions());
          boolean _equals = Objects.equal(initExpression, _head);
          if (_equals) {
            INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(initExpression);
            final Procedure1<INode> _function_1 = (INode it) -> {
              final Procedure1<FormattingDataInit> _function_2 = (FormattingDataInit it_1) -> {
                it_1.noSpace();
              };
              Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(it, _function_2);
              format.operator_add(_prepend);
              final Procedure1<FormattingDataInit> _function_3 = (FormattingDataInit it_1) -> {
                it_1.noSpace();
              };
              Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(it, _function_3);
              format.operator_add(_append);
            };
            INode _doubleArrow = ObjectExtensions.<INode>operator_doubleArrow(_nodeForEObject, _function_1);
            previousFormattedNode = _doubleArrow;
          } else {
            INode _nodeForEObject_1 = this._nodeModelAccess.nodeForEObject(initExpression);
            final Procedure1<INode> _function_2 = (INode it) -> {
              final Procedure1<FormattingDataInit> _function_3 = (FormattingDataInit it_1) -> {
                it_1.oneSpace();
              };
              Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(it, _function_3);
              format.operator_add(_prepend);
              final Procedure1<FormattingDataInit> _function_4 = (FormattingDataInit it_1) -> {
                it_1.noSpace();
              };
              Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(it, _function_4);
              format.operator_add(_append);
            };
            INode _doubleArrow_1 = ObjectExtensions.<INode>operator_doubleArrow(_nodeForEObject_1, _function_2);
            previousFormattedNode = _doubleArrow_1;
          }
          this.format(initExpression, format);
        }
      }
    } else {
      ILeafNode _immediatelyFollowingKeyword = this._nodeModelAccess.immediatelyFollowingKeyword(previousFormattedNode, "(");
      final Procedure1<ILeafNode> _function_1 = (ILeafNode it) -> {
        final Procedure1<FormattingDataInit> _function_2 = (FormattingDataInit it_1) -> {
          it_1.noSpace();
        };
        Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(it, _function_2);
        format.operator_add(_append);
      };
      ILeafNode _doubleArrow = ObjectExtensions.<ILeafNode>operator_doubleArrow(_immediatelyFollowingKeyword, _function_1);
      previousFormattedNode = _doubleArrow;
    }
    final XExpression expression = expr.getExpression();
    if ((expression != null)) {
      INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(expression);
      final Procedure1<INode> _function_2 = (INode it) -> {
        final Procedure1<FormattingDataInit> _function_3 = (FormattingDataInit it_1) -> {
          it_1.oneSpace();
        };
        Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(it, _function_3);
        format.operator_add(_prepend);
        final Procedure1<FormattingDataInit> _function_4 = (FormattingDataInit it_1) -> {
          it_1.noSpace();
        };
        Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(it, _function_4);
        format.operator_add(_append);
      };
      INode _doubleArrow_1 = ObjectExtensions.<INode>operator_doubleArrow(_nodeForEObject, _function_2);
      previousFormattedNode = _doubleArrow_1;
      this.format(expression, format);
    } else {
      ILeafNode _immediatelyFollowingKeyword_1 = this._nodeModelAccess.immediatelyFollowingKeyword(previousFormattedNode, ";");
      final Procedure1<ILeafNode> _function_3 = (ILeafNode it) -> {
        final Procedure1<FormattingDataInit> _function_4 = (FormattingDataInit it_1) -> {
          it_1.noSpace();
        };
        Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(it, _function_4);
        format.operator_add(_append);
      };
      ILeafNode _doubleArrow_2 = ObjectExtensions.<ILeafNode>operator_doubleArrow(_immediatelyFollowingKeyword_1, _function_3);
      previousFormattedNode = _doubleArrow_2;
    }
    final EList<XExpression> updateExpressions = expr.getUpdateExpressions();
    boolean _isEmpty_1 = updateExpressions.isEmpty();
    boolean _not_1 = (!_isEmpty_1);
    if (_not_1) {
      for (final XExpression updateExpression : updateExpressions) {
        {
          INode _nodeForEObject_1 = this._nodeModelAccess.nodeForEObject(updateExpression);
          final Procedure1<INode> _function_4 = (INode it) -> {
            final Procedure1<FormattingDataInit> _function_5 = (FormattingDataInit it_1) -> {
              it_1.oneSpace();
            };
            Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(it, _function_5);
            format.operator_add(_prepend);
            final Procedure1<FormattingDataInit> _function_6 = (FormattingDataInit it_1) -> {
              it_1.noSpace();
            };
            Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(it, _function_6);
            format.operator_add(_append);
          };
          INode _doubleArrow_3 = ObjectExtensions.<INode>operator_doubleArrow(_nodeForEObject_1, _function_4);
          previousFormattedNode = _doubleArrow_3;
          this.format(updateExpression, format);
        }
      }
    } else {
      ILeafNode _immediatelyFollowingKeyword_2 = this._nodeModelAccess.immediatelyFollowingKeyword(previousFormattedNode, ";");
      final Procedure1<ILeafNode> _function_4 = (ILeafNode it) -> {
        final Procedure1<FormattingDataInit> _function_5 = (FormattingDataInit it_1) -> {
          it_1.noSpace();
        };
        Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(it, _function_5);
        format.operator_add(_append);
      };
      ILeafNode _doubleArrow_3 = ObjectExtensions.<ILeafNode>operator_doubleArrow(_immediatelyFollowingKeyword_2, _function_4);
      previousFormattedNode = _doubleArrow_3;
    }
    final INode each = this._nodeModelAccess.nodeForEObject(expr.getEachExpression());
    XExpression _eachExpression = expr.getEachExpression();
    if ((_eachExpression instanceof XBlockExpression)) {
      final Procedure1<FormattingDataInit> _function_5 = (FormattingDataInit it) -> {
        it.cfg(XbaseFormatterPreferenceKeys.bracesInNewLine);
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(each, _function_5);
      format.operator_add(_prepend);
    } else {
      final Procedure1<FormattingDataInit> _function_6 = (FormattingDataInit it) -> {
        it.newLine();
        it.increaseIndentation();
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend_1 = this._formattingDataFactory.prepend(each, _function_6);
      format.operator_add(_prepend_1);
      final Procedure1<FormattingDataInit> _function_7 = (FormattingDataInit it) -> {
        it.decreaseIndentation();
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(each, _function_7);
      format.operator_add(_append);
    }
    this.format(expr.getEachExpression(), format);
  }

  protected void _format(final XWhileExpression expr, final FormattableDocument format) {
    final Procedure1<FormattingDataInit> _function = (FormattingDataInit it) -> {
      it.cfg(XbaseFormatterPreferenceKeys.whitespaceBetweenKeywordAndParenthesisML);
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(this._nodeModelAccess.nodeForKeyword(expr, "while"), _function);
    format.operator_add(_append);
    final Procedure1<FormattingDataInit> _function_1 = (FormattingDataInit it) -> {
      it.noSpace();
    };
    final Procedure1<FormattingDataInit> _function_2 = (FormattingDataInit it) -> {
      it.noSpace();
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _surround = this._formattingDataFactory.surround(this._nodeModelAccess.nodeForEObject(expr.getPredicate()), _function_1, _function_2);
    format.operator_add(_surround);
    final INode body = this._nodeModelAccess.nodeForEObject(expr.getBody());
    XExpression _body = expr.getBody();
    if ((_body instanceof XBlockExpression)) {
      final Procedure1<FormattingDataInit> _function_3 = (FormattingDataInit it) -> {
        it.cfg(XbaseFormatterPreferenceKeys.bracesInNewLine);
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(body, _function_3);
      format.operator_add(_prepend);
    } else {
      final Procedure1<FormattingDataInit> _function_4 = (FormattingDataInit it) -> {
        it.newLine();
        it.increaseIndentation();
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend_1 = this._formattingDataFactory.prepend(body, _function_4);
      format.operator_add(_prepend_1);
      final Procedure1<FormattingDataInit> _function_5 = (FormattingDataInit it) -> {
        it.decreaseIndentation();
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(body, _function_5);
      format.operator_add(_append_1);
    }
    this.format(expr.getPredicate(), format);
    this.format(expr.getBody(), format);
  }

  protected void _format(final XDoWhileExpression expr, final FormattableDocument format) {
    final Procedure1<FormattingDataInit> _function = (FormattingDataInit it) -> {
      it.cfg(XbaseFormatterPreferenceKeys.whitespaceBetweenKeywordAndParenthesisML);
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(this._nodeModelAccess.nodeForKeyword(expr, "while"), _function);
    format.operator_add(_append);
    final Procedure1<FormattingDataInit> _function_1 = (FormattingDataInit it) -> {
      it.noSpace();
    };
    final Procedure1<FormattingDataInit> _function_2 = (FormattingDataInit it) -> {
      it.noSpace();
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _surround = this._formattingDataFactory.surround(this._nodeModelAccess.nodeForEObject(expr.getPredicate()), _function_1, _function_2);
    format.operator_add(_surround);
    final INode body = this._nodeModelAccess.nodeForEObject(expr.getBody());
    XExpression _body = expr.getBody();
    if ((_body instanceof XBlockExpression)) {
      final Procedure1<FormattingDataInit> _function_3 = (FormattingDataInit it) -> {
        it.cfg(XbaseFormatterPreferenceKeys.bracesInNewLine);
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(body, _function_3);
      format.operator_add(_prepend);
      final Procedure1<FormattingDataInit> _function_4 = (FormattingDataInit it) -> {
        it.cfg(XbaseFormatterPreferenceKeys.bracesInNewLine);
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(body, _function_4);
      format.operator_add(_append_1);
    } else {
      final Procedure1<FormattingDataInit> _function_5 = (FormattingDataInit it) -> {
        it.newLine();
        it.increaseIndentation();
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend_1 = this._formattingDataFactory.prepend(body, _function_5);
      format.operator_add(_prepend_1);
      final Procedure1<FormattingDataInit> _function_6 = (FormattingDataInit it) -> {
        it.newLine();
        it.decreaseIndentation();
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_2 = this._formattingDataFactory.append(body, _function_6);
      format.operator_add(_append_2);
    }
    this.format(expr.getPredicate(), format);
    this.format(expr.getBody(), format);
  }

  protected void _format(final XBlockExpression expr, final FormattableDocument format) {
    final ILeafNode open = this._nodeModelAccess.nodeForKeyword(expr, "{");
    EObject _eContainer = expr.eContainer();
    boolean _tripleEquals = (_eContainer == null);
    if (_tripleEquals) {
      final Procedure1<FormattingDataInit> _function = (FormattingDataInit it) -> {
        it.noSpace();
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(open, _function);
      format.operator_add(_prepend);
    }
    final ILeafNode close = this._nodeModelAccess.nodeForKeyword(expr, "}");
    if (((open != null) && (close != null))) {
      boolean _isSingleLineBlock = this.isSingleLineBlock(expr, format);
      final boolean multiLine = (!_isSingleLineBlock);
      boolean _isEmpty = expr.getExpressions().isEmpty();
      if (_isEmpty) {
        boolean _containsComment = this._hiddenLeafAccess.getHiddenLeafsAfter(open).containsComment();
        if (_containsComment) {
          if (multiLine) {
            final Procedure1<FormattingDataInit> _function_1 = (FormattingDataInit it) -> {
              it.newLine();
              it.increaseIndentation();
              it.decreaseIndentation();
            };
            Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(open, _function_1);
            format.operator_add(_append);
          } else {
            final Procedure1<FormattingDataInit> _function_2 = (FormattingDataInit it) -> {
              it.oneSpace();
            };
            Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(open, _function_2);
            format.operator_add(_append_1);
          }
        } else {
          final Procedure1<FormattingDataInit> _function_3 = (FormattingDataInit it) -> {
            if (multiLine) {
              it.newLine();
            } else {
              it.noSpace();
            }
          };
          Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_2 = this._formattingDataFactory.append(open, _function_3);
          format.operator_add(_append_2);
        }
      } else {
        if (multiLine) {
          final Procedure1<FormattingDataInit> _function_4 = (FormattingDataInit it) -> {
            it.cfg(XbaseFormatterPreferenceKeys.blankLinesAroundExpression);
            it.increaseIndentation();
          };
          Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_3 = this._formattingDataFactory.append(open, _function_4);
          format.operator_add(_append_3);
        } else {
          final Procedure1<FormattingDataInit> _function_5 = (FormattingDataInit it) -> {
            it.oneSpace();
          };
          Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_4 = this._formattingDataFactory.append(open, _function_5);
          format.operator_add(_append_4);
        }
        EList<XExpression> _expressions = expr.getExpressions();
        for (final XExpression child : _expressions) {
          {
            this.format(child, format);
            if (((!Objects.equal(child, IterableExtensions.<XExpression>last(expr.getExpressions()))) || (close != null))) {
              final INode childNode = this._nodeModelAccess.nodeForEObject(child);
              final ILeafNode sem = this._nodeModelAccess.immediatelyFollowingKeyword(childNode, ";");
              if ((sem != null)) {
                final Procedure1<FormattingDataInit> _function_6 = (FormattingDataInit it) -> {
                  it.noSpace();
                };
                Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend_1 = this._formattingDataFactory.prepend(sem, _function_6);
                format.operator_add(_prepend_1);
                final Procedure1<FormattingDataInit> _function_7 = (FormattingDataInit it) -> {
                  if (multiLine) {
                    it.cfg(XbaseFormatterPreferenceKeys.blankLinesAroundExpression);
                  } else {
                    it.oneSpace();
                  }
                };
                Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_5 = this._formattingDataFactory.append(sem, _function_7);
                format.operator_add(_append_5);
              } else {
                final Procedure1<FormattingDataInit> _function_8 = (FormattingDataInit it) -> {
                  if (multiLine) {
                    it.cfg(XbaseFormatterPreferenceKeys.blankLinesAroundExpression);
                  } else {
                    it.oneSpace();
                  }
                };
                Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_6 = this._formattingDataFactory.append(childNode, _function_8);
                format.operator_add(_append_6);
              }
            }
          }
        }
        if (multiLine) {
          final Procedure1<FormattingDataInit> _function_6 = (FormattingDataInit it) -> {
            it.decreaseIndentation();
          };
          Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend_1 = this._formattingDataFactory.prepend(close, _function_6);
          format.operator_add(_prepend_1);
        }
      }
    }
  }

  protected boolean isSingleLineBlock(final XBlockExpression expr, final FormattableDocument format) {
    return false;
  }

  protected void _format(final XTypeLiteral expr, final FormattableDocument format) {
    final INode typeNode = this._nodeModelAccess.nodeForFeature(expr, XbasePackage.Literals.XTYPE_LITERAL__TYPE);
    final Procedure1<FormattingDataInit> _function = (FormattingDataInit it) -> {
      it.noSpace();
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(this._nodeModelAccess.nodeForKeyword(expr, "typeof"), _function);
    format.operator_add(_append);
    final Procedure1<FormattingDataInit> _function_1 = (FormattingDataInit it) -> {
      it.noSpace();
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(typeNode, _function_1);
    format.operator_add(_prepend);
    final Procedure1<FormattingDataInit> _function_2 = (FormattingDataInit it) -> {
      it.noSpace();
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(typeNode, _function_2);
    format.operator_add(_append_1);
    INode node = typeNode;
    while ((node != null)) {
      {
        node = this._nodeModelAccess.immediatelyFollowingKeyword(node, "[");
        if ((node != null)) {
          final Procedure1<FormattingDataInit> _function_3 = (FormattingDataInit it) -> {
            it.noSpace();
          };
          Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_2 = this._formattingDataFactory.append(node, _function_3);
          format.operator_add(_append_2);
          node = this._nodeModelAccess.immediatelyFollowingKeyword(node, "]");
          if ((node != null)) {
            final Procedure1<FormattingDataInit> _function_4 = (FormattingDataInit it) -> {
              it.noSpace();
            };
            Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_3 = this._formattingDataFactory.append(node, _function_4);
            format.operator_add(_append_3);
          }
        }
      }
    }
  }

  protected void _format(final XThrowExpression expr, final FormattableDocument format) {
    final Procedure1<FormattingDataInit> _function = (FormattingDataInit it) -> {
      it.oneSpace();
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(this._nodeModelAccess.nodeForEObject(expr.getExpression()), _function);
    format.operator_add(_prepend);
    this.format(expr.getExpression(), format);
  }

  protected void _format(final XReturnExpression expr, final FormattableDocument format) {
    final Procedure1<FormattingDataInit> _function = (FormattingDataInit it) -> {
      it.oneSpace();
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(this._nodeModelAccess.nodeForEObject(expr.getExpression()), _function);
    format.operator_add(_prepend);
    this.format(expr.getExpression(), format);
  }

  protected void _format(final XTryCatchFinallyExpression expr, final FormattableDocument format) {
    final INode body = this._nodeModelAccess.nodeForEObject(expr.getExpression());
    XExpression _expression = expr.getExpression();
    if ((_expression instanceof XBlockExpression)) {
      final Procedure1<FormattingDataInit> _function = (FormattingDataInit it) -> {
        it.cfg(XbaseFormatterPreferenceKeys.bracesInNewLine);
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(body, _function);
      format.operator_add(_prepend);
      final Procedure1<FormattingDataInit> _function_1 = (FormattingDataInit it) -> {
        it.cfg(XbaseFormatterPreferenceKeys.bracesInNewLine);
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(body, _function_1);
      format.operator_add(_append);
    } else {
      final Procedure1<FormattingDataInit> _function_2 = (FormattingDataInit it) -> {
        it.newLine();
        it.increaseIndentation();
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend_1 = this._formattingDataFactory.prepend(body, _function_2);
      format.operator_add(_prepend_1);
      final Procedure1<FormattingDataInit> _function_3 = (FormattingDataInit it) -> {
        it.newLine();
        it.decreaseIndentation();
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(body, _function_3);
      format.operator_add(_append_1);
    }
    this.format(expr.getExpression(), format);
    EList<XCatchClause> _catchClauses = expr.getCatchClauses();
    for (final XCatchClause cc : _catchClauses) {
      {
        this.format(cc, format);
        if (((!Objects.equal(cc, IterableExtensions.<XCatchClause>last(expr.getCatchClauses()))) || (expr.getFinallyExpression() != null))) {
          XExpression _expression_1 = cc.getExpression();
          if ((_expression_1 instanceof XBlockExpression)) {
            final Procedure1<FormattingDataInit> _function_4 = (FormattingDataInit it) -> {
              it.cfg(XbaseFormatterPreferenceKeys.bracesInNewLine);
            };
            Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_2 = this._formattingDataFactory.append(this._nodeModelAccess.nodeForEObject(cc), _function_4);
            format.operator_add(_append_2);
          } else {
            final Procedure1<FormattingDataInit> _function_5 = (FormattingDataInit it) -> {
              it.newLine();
            };
            Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_3 = this._formattingDataFactory.append(this._nodeModelAccess.nodeForEObject(cc), _function_5);
            format.operator_add(_append_3);
          }
        }
      }
    }
    XExpression _finallyExpression = expr.getFinallyExpression();
    boolean _tripleNotEquals = (_finallyExpression != null);
    if (_tripleNotEquals) {
      final INode fin = this._nodeModelAccess.nodeForEObject(expr.getFinallyExpression());
      XExpression _finallyExpression_1 = expr.getFinallyExpression();
      if ((_finallyExpression_1 instanceof XBlockExpression)) {
        final Procedure1<FormattingDataInit> _function_4 = (FormattingDataInit it) -> {
          it.cfg(XbaseFormatterPreferenceKeys.bracesInNewLine);
        };
        Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend_2 = this._formattingDataFactory.prepend(fin, _function_4);
        format.operator_add(_prepend_2);
      } else {
        final Procedure1<FormattingDataInit> _function_5 = (FormattingDataInit it) -> {
          it.newLine();
          it.increaseIndentation();
        };
        Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend_3 = this._formattingDataFactory.prepend(fin, _function_5);
        format.operator_add(_prepend_3);
        final Procedure1<FormattingDataInit> _function_6 = (FormattingDataInit it) -> {
          it.decreaseIndentation();
        };
        Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_2 = this._formattingDataFactory.append(fin, _function_6);
        format.operator_add(_append_2);
      }
      this.format(expr.getFinallyExpression(), format);
    }
  }

  protected void _format(final XCatchClause expr, final FormattableDocument format) {
    final Procedure1<FormattingDataInit> _function = (FormattingDataInit it) -> {
      it.cfg(XbaseFormatterPreferenceKeys.whitespaceBetweenKeywordAndParenthesisML);
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(this._nodeModelAccess.nodeForKeyword(expr, "catch"), _function);
    format.operator_add(_append);
    INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(expr.getDeclaredParam());
    final Procedure1<INode> _function_1 = (INode it) -> {
      final Procedure1<FormattingDataInit> _function_2 = (FormattingDataInit it_1) -> {
        it_1.noSpace();
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(it, _function_2);
      format.operator_add(_prepend);
      final Procedure1<FormattingDataInit> _function_3 = (FormattingDataInit it_1) -> {
        it_1.noSpace();
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(it, _function_3);
      format.operator_add(_append_1);
    };
    ObjectExtensions.<INode>operator_doubleArrow(_nodeForEObject, _function_1);
    final INode body = this._nodeModelAccess.nodeForEObject(expr.getExpression());
    XExpression _expression = expr.getExpression();
    if ((_expression instanceof XBlockExpression)) {
      final Procedure1<FormattingDataInit> _function_2 = (FormattingDataInit it) -> {
        it.cfg(XbaseFormatterPreferenceKeys.bracesInNewLine);
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(body, _function_2);
      format.operator_add(_prepend);
    } else {
      final Procedure1<FormattingDataInit> _function_3 = (FormattingDataInit it) -> {
        it.newLine();
        it.increaseIndentation();
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend_1 = this._formattingDataFactory.prepend(body, _function_3);
      format.operator_add(_prepend_1);
      final Procedure1<FormattingDataInit> _function_4 = (FormattingDataInit it) -> {
        it.decreaseIndentation();
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(body, _function_4);
      format.operator_add(_append_1);
    }
    this.format(expr.getDeclaredParam(), format);
    this.format(expr.getExpression(), format);
  }

  protected void _format(final JvmFormalParameter expr, final FormattableDocument format) {
    JvmTypeReference _parameterType = expr.getParameterType();
    boolean _tripleNotEquals = (_parameterType != null);
    if (_tripleNotEquals) {
      final Procedure1<FormattingDataInit> _function = (FormattingDataInit it) -> {
        it.oneSpace();
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(this._nodeModelAccess.nodeForEObject(expr.getParameterType()), _function);
      format.operator_add(_append);
    }
    this.format(expr.getParameterType(), format);
  }

  protected void _format(final XExpression expr, final FormattableDocument format) {
    EList<EObject> _eContents = expr.eContents();
    for (final EObject obj : _eContents) {
      boolean _matched = false;
      if (obj instanceof XExpression) {
        _matched=true;
        this.format(obj, format);
      }
    }
  }

  protected void _format(final XSwitchExpression expr, final FormattableDocument format) {
    final Function1<XCasePart, Boolean> _function = (XCasePart it) -> {
      XExpression _then = it.getThen();
      return Boolean.valueOf((_then instanceof XBlockExpression));
    };
    final boolean containsBlockExpr = IterableExtensions.<XCasePart>exists(expr.getCases(), _function);
    final boolean switchSL = ((!containsBlockExpr) && (!this._nodeModelAccess.nodeForEObject(expr).getText().trim().contains("\n")));
    boolean _and = false;
    if (!(((!containsBlockExpr) && ((!expr.getCases().isEmpty()) || (expr.getDefault() != null))) && (!IterableExtensions.<XCasePart>exists(expr.getCases(), ((Function1<XCasePart, Boolean>) (XCasePart it) -> {
      return Boolean.valueOf(this._nodeModelAccess.nodeForEObject(it).getText().trim().contains("\n"));
    }))))) {
      _and = false;
    } else {
      XExpression _default = expr.getDefault();
      INode _nodeForEObject = null;
      if (_default!=null) {
        _nodeForEObject=this._nodeModelAccess.nodeForEObject(_default);
      }
      String _text = null;
      if (_nodeForEObject!=null) {
        _text=_nodeForEObject.getText();
      }
      boolean _contains = false;
      if (_text!=null) {
        _contains=_text.contains("\n");
      }
      boolean _not = (!_contains);
      _and = _not;
    }
    final boolean caseSL = _and;
    final ILeafNode open = this._nodeModelAccess.nodeForKeyword(expr, "{");
    final ILeafNode close = this._nodeModelAccess.nodeForKeyword(expr, "}");
    final Procedure1<FormattingDataInit> _function_1 = (FormattingDataInit it) -> {
      it.oneSpace();
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(this._nodeModelAccess.nodeForKeyword(expr, "switch"), _function_1);
    format.operator_add(_append);
    if (switchSL) {
      final Procedure1<FormattingDataInit> _function_2 = (FormattingDataInit it) -> {
        it.oneSpace();
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(open, _function_2);
      format.operator_add(_prepend);
      final Procedure1<FormattingDataInit> _function_3 = (FormattingDataInit it) -> {
        it.oneSpace();
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(open, _function_3);
      format.operator_add(_append_1);
      EList<XCasePart> _cases = expr.getCases();
      for (final XCasePart c : _cases) {
        XExpression _then = c.getThen();
        boolean _tripleEquals = (_then == null);
        if (_tripleEquals) {
          final Procedure1<FormattingDataInit> _function_4 = (FormattingDataInit it) -> {
            it.oneSpace();
          };
          Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_2 = this._formattingDataFactory.append(this._nodeModelAccess.nodeForEObject(c), _function_4);
          format.operator_add(_append_2);
        } else {
          final INode cnode = this._nodeModelAccess.nodeForEObject(c.getThen());
          final Procedure1<FormattingDataInit> _function_5 = (FormattingDataInit it) -> {
            it.oneSpace();
          };
          Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend_1 = this._formattingDataFactory.prepend(cnode, _function_5);
          format.operator_add(_prepend_1);
          final Procedure1<FormattingDataInit> _function_6 = (FormattingDataInit it) -> {
            it.oneSpace();
          };
          Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_3 = this._formattingDataFactory.append(cnode, _function_6);
          format.operator_add(_append_3);
        }
      }
      XExpression _default_1 = expr.getDefault();
      boolean _tripleNotEquals = (_default_1 != null);
      if (_tripleNotEquals) {
        final Procedure1<FormattingDataInit> _function_7 = (FormattingDataInit it) -> {
          it.noSpace();
        };
        Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_4 = this._formattingDataFactory.append(this._nodeModelAccess.nodeForKeyword(expr, "default"), _function_7);
        format.operator_add(_append_4);
        final Procedure1<FormattingDataInit> _function_8 = (FormattingDataInit it) -> {
          it.oneSpace();
        };
        Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _surround = this._formattingDataFactory.surround(this._nodeModelAccess.nodeForEObject(expr.getDefault()), _function_8);
        format.operator_add(_surround);
      }
    } else {
      if (caseSL) {
        final Procedure1<FormattingDataInit> _function_9 = (FormattingDataInit it) -> {
          it.cfg(XbaseFormatterPreferenceKeys.bracesInNewLine);
        };
        Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend_2 = this._formattingDataFactory.prepend(open, _function_9);
        format.operator_add(_prepend_2);
        boolean _isEmpty = expr.getCases().isEmpty();
        boolean _not_1 = (!_isEmpty);
        if (_not_1) {
          final Procedure1<FormattingDataInit> _function_10 = (FormattingDataInit it) -> {
            it.newLine();
          };
          Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_5 = this._formattingDataFactory.append(open, _function_10);
          format.operator_add(_append_5);
        }
        final Procedure1<FormattingDataInit> _function_11 = (FormattingDataInit it) -> {
          it.increaseIndentation();
        };
        Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_6 = this._formattingDataFactory.append(open, _function_11);
        format.operator_add(_append_6);
        EList<XCasePart> _cases_1 = expr.getCases();
        for (final XCasePart c_1 : _cases_1) {
          {
            final Procedure1<FormattingDataInit> _function_12 = (FormattingDataInit it) -> {
              it.oneSpace();
            };
            Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend_3 = this._formattingDataFactory.prepend(this._nodeModelAccess.nodeForEObject(c_1.getThen()), _function_12);
            format.operator_add(_prepend_3);
            XCasePart _last = IterableExtensions.<XCasePart>last(expr.getCases());
            boolean _notEquals = (!Objects.equal(c_1, _last));
            if (_notEquals) {
              final Procedure1<FormattingDataInit> _function_13 = (FormattingDataInit it) -> {
                it.newLine();
              };
              Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_7 = this._formattingDataFactory.append(this._nodeModelAccess.nodeForEObject(c_1), _function_13);
              format.operator_add(_append_7);
            }
          }
        }
        XExpression _default_2 = expr.getDefault();
        boolean _tripleNotEquals_1 = (_default_2 != null);
        if (_tripleNotEquals_1) {
          final Procedure1<FormattingDataInit> _function_12 = (FormattingDataInit it) -> {
            it.newLine();
          };
          final Procedure1<FormattingDataInit> _function_13 = (FormattingDataInit it) -> {
            it.noSpace();
          };
          Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _surround_1 = this._formattingDataFactory.surround(this._nodeModelAccess.nodeForKeyword(expr, "default"), _function_12, _function_13);
          format.operator_add(_surround_1);
          final Procedure1<FormattingDataInit> _function_14 = (FormattingDataInit it) -> {
            it.oneSpace();
          };
          Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend_3 = this._formattingDataFactory.prepend(this._nodeModelAccess.nodeForEObject(expr.getDefault()), _function_14);
          format.operator_add(_prepend_3);
        }
        final Procedure1<FormattingDataInit> _function_15 = (FormattingDataInit it) -> {
          it.newLine();
          it.decreaseIndentation();
        };
        Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend_4 = this._formattingDataFactory.prepend(close, _function_15);
        format.operator_add(_prepend_4);
      } else {
        final Procedure1<FormattingDataInit> _function_16 = (FormattingDataInit it) -> {
          it.cfg(XbaseFormatterPreferenceKeys.bracesInNewLine);
        };
        Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend_5 = this._formattingDataFactory.prepend(open, _function_16);
        format.operator_add(_prepend_5);
        final Procedure1<FormattingDataInit> _function_17 = (FormattingDataInit it) -> {
          it.newLine();
        };
        Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_7 = this._formattingDataFactory.append(open, _function_17);
        format.operator_add(_append_7);
        if (((!expr.getCases().isEmpty()) || (expr.getDefault() != null))) {
          final Procedure1<FormattingDataInit> _function_18 = (FormattingDataInit it) -> {
            it.increaseIndentation();
          };
          Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_8 = this._formattingDataFactory.append(open, _function_18);
          format.operator_add(_append_8);
        }
        EList<XCasePart> _cases_2 = expr.getCases();
        for (final XCasePart c_2 : _cases_2) {
          {
            INode _elvis = null;
            INode _nodeForEObject_1 = this._nodeModelAccess.nodeForEObject(c_2.getThen());
            if (_nodeForEObject_1 != null) {
              _elvis = _nodeForEObject_1;
            } else {
              INode _nodeForFeature = this._nodeModelAccess.nodeForFeature(c_2, XbasePackage.Literals.XCASE_PART__FALL_THROUGH);
              _elvis = _nodeForFeature;
            }
            final INode cnode_1 = _elvis;
            XExpression _then_1 = c_2.getThen();
            if ((_then_1 instanceof XBlockExpression)) {
              final Procedure1<FormattingDataInit> _function_19 = (FormattingDataInit it) -> {
                it.cfg(XbaseFormatterPreferenceKeys.bracesInNewLine);
              };
              Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend_6 = this._formattingDataFactory.prepend(cnode_1, _function_19);
              format.operator_add(_prepend_6);
              if (((expr.getDefault() != null) || (!Objects.equal(c_2, IterableExtensions.<XCasePart>last(expr.getCases()))))) {
                final Procedure1<FormattingDataInit> _function_20 = (FormattingDataInit it) -> {
                  it.newLine();
                };
                Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_9 = this._formattingDataFactory.append(cnode_1, _function_20);
                format.operator_add(_append_9);
              } else {
                final Procedure1<FormattingDataInit> _function_21 = (FormattingDataInit it) -> {
                  it.newLine();
                  it.decreaseIndentation();
                };
                Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_10 = this._formattingDataFactory.append(cnode_1, _function_21);
                format.operator_add(_append_10);
              }
            } else {
              boolean _isFallThrough = c_2.isFallThrough();
              if (_isFallThrough) {
                final Procedure1<FormattingDataInit> _function_22 = (FormattingDataInit it) -> {
                  it.increaseIndentation();
                };
                Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_11 = this._formattingDataFactory.append(cnode_1, _function_22);
                format.operator_add(_append_11);
              } else {
                final Procedure1<FormattingDataInit> _function_23 = (FormattingDataInit it) -> {
                  it.newLine();
                  it.increaseIndentation();
                };
                Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend_7 = this._formattingDataFactory.prepend(cnode_1, _function_23);
                format.operator_add(_prepend_7);
              }
              if (((expr.getDefault() != null) || (!Objects.equal(c_2, IterableExtensions.<XCasePart>last(expr.getCases()))))) {
                final Procedure1<FormattingDataInit> _function_24 = (FormattingDataInit it) -> {
                  it.newLine();
                  it.decreaseIndentation();
                };
                Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_12 = this._formattingDataFactory.append(cnode_1, _function_24);
                format.operator_add(_append_12);
              } else {
                final Procedure1<FormattingDataInit> _function_25 = (FormattingDataInit it) -> {
                  it.newLine();
                  it.decreaseIndentationChange = (-2);
                };
                Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_13 = this._formattingDataFactory.append(cnode_1, _function_25);
                format.operator_add(_append_13);
              }
            }
          }
        }
        XExpression _default_3 = expr.getDefault();
        boolean _tripleNotEquals_2 = (_default_3 != null);
        if (_tripleNotEquals_2) {
          final Procedure1<FormattingDataInit> _function_19 = (FormattingDataInit it) -> {
            it.noSpace();
          };
          Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_9 = this._formattingDataFactory.append(this._nodeModelAccess.nodeForKeyword(expr, "default"), _function_19);
          format.operator_add(_append_9);
          XExpression _default_4 = expr.getDefault();
          if ((_default_4 instanceof XBlockExpression)) {
            final Procedure1<FormattingDataInit> _function_20 = (FormattingDataInit it) -> {
              it.cfg(XbaseFormatterPreferenceKeys.bracesInNewLine);
            };
            final Procedure1<FormattingDataInit> _function_21 = (FormattingDataInit it) -> {
              it.newLine();
              it.decreaseIndentation();
            };
            Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _surround_2 = this._formattingDataFactory.surround(this._nodeModelAccess.nodeForEObject(expr.getDefault()), _function_20, _function_21);
            format.operator_add(_surround_2);
          } else {
            final Procedure1<FormattingDataInit> _function_22 = (FormattingDataInit it) -> {
              it.newLine();
              it.increaseIndentation();
            };
            final Procedure1<FormattingDataInit> _function_23 = (FormattingDataInit it) -> {
              it.newLine();
              it.decreaseIndentationChange = (-2);
            };
            Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _surround_3 = this._formattingDataFactory.surround(this._nodeModelAccess.nodeForEObject(expr.getDefault()), _function_22, _function_23);
            format.operator_add(_surround_3);
          }
        }
      }
    }
    EList<XCasePart> _cases_3 = expr.getCases();
    for (final XCasePart c_3 : _cases_3) {
      {
        if (((c_3.getTypeGuard() != null) && (c_3.getCase() != null))) {
          final INode typenode = this._nodeModelAccess.nodeForFeature(c_3, XbasePackage.Literals.XCASE_PART__TYPE_GUARD);
          final INode casenode = this._nodeModelAccess.nodeForFeature(c_3, XbasePackage.Literals.XCASE_PART__CASE);
          final Procedure1<FormattingDataInit> _function_24 = (FormattingDataInit it) -> {
            it.oneSpace();
          };
          Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_10 = this._formattingDataFactory.append(typenode, _function_24);
          format.operator_add(_append_10);
          final Procedure1<FormattingDataInit> _function_25 = (FormattingDataInit it) -> {
            it.oneSpace();
          };
          Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend_6 = this._formattingDataFactory.prepend(casenode, _function_25);
          format.operator_add(_prepend_6);
          final Procedure1<FormattingDataInit> _function_26 = (FormattingDataInit it) -> {
            it.noSpace();
          };
          Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_11 = this._formattingDataFactory.append(casenode, _function_26);
          format.operator_add(_append_11);
        } else {
          JvmTypeReference _typeGuard = c_3.getTypeGuard();
          boolean _tripleNotEquals_3 = (_typeGuard != null);
          if (_tripleNotEquals_3) {
            final INode typenode_1 = this._nodeModelAccess.nodeForFeature(c_3, XbasePackage.Literals.XCASE_PART__TYPE_GUARD);
            final Procedure1<FormattingDataInit> _function_27 = (FormattingDataInit it) -> {
              it.noSpace();
            };
            Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_12 = this._formattingDataFactory.append(typenode_1, _function_27);
            format.operator_add(_append_12);
          } else {
            XExpression _case = c_3.getCase();
            boolean _tripleNotEquals_4 = (_case != null);
            if (_tripleNotEquals_4) {
              final INode casenode_1 = this._nodeModelAccess.nodeForFeature(c_3, XbasePackage.Literals.XCASE_PART__CASE);
              final Procedure1<FormattingDataInit> _function_28 = (FormattingDataInit it) -> {
                it.oneSpace();
              };
              Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend_7 = this._formattingDataFactory.prepend(casenode_1, _function_28);
              format.operator_add(_prepend_7);
              final Procedure1<FormattingDataInit> _function_29 = (FormattingDataInit it) -> {
                it.noSpace();
              };
              Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_13 = this._formattingDataFactory.append(casenode_1, _function_29);
              format.operator_add(_append_13);
            }
          }
        }
        this.format(c_3.getCase(), format);
        this.format(c_3.getThen(), format);
      }
    }
    XExpression _default_5 = expr.getDefault();
    boolean _tripleNotEquals_3 = (_default_5 != null);
    if (_tripleNotEquals_3) {
      this.format(expr.getDefault(), format);
    }
  }

  protected void _format(final XClosure expr, final FormattableDocument format) {
    final ILeafNode open = this._nodeModelAccess.nodeForKeyword(expr, "[");
    final ILeafNode close = this._nodeModelAccess.nodeForKeyword(expr, "]");
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
    if ((expr.getDeclaredFormalParameters().isEmpty() && children.isEmpty())) {
      boolean _containsComment = this._hiddenLeafAccess.getHiddenLeafsAfter(open).containsComment();
      if (_containsComment) {
        final Procedure1<FormattingDataInit> _function = (FormattingDataInit it) -> {
          it.newLine();
          it.increaseIndentation();
          it.decreaseIndentation();
        };
        Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(open, _function);
        format.operator_add(_append);
      } else {
        final Procedure1<FormattingDataInit> _function_1 = (FormattingDataInit it) -> {
          it.noSpace();
        };
        Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(open, _function_1);
        format.operator_add(_append_1);
      }
    } else {
      boolean _isMultilineLambda = this.isMultilineLambda(expr);
      if (_isMultilineLambda) {
        this.formatClosureMultiLine(expr, open, children, close, format);
      } else {
        this.formatClosureWrapIfNeeded(expr, open, children, close, format);
      }
    }
  }

  protected void formatClosureMultiLine(final XClosure expr, final INode open, final Collection<XExpression> children, final INode close, final FormattableDocument format) {
    this.formatClosureParameters(expr, format);
    final INode explicit = this._nodeModelAccess.nodeForFeature(expr, XbasePackage.Literals.XCLOSURE__EXPLICIT_SYNTAX);
    if ((explicit != null)) {
      boolean _isEmpty = expr.getDeclaredFormalParameters().isEmpty();
      if (_isEmpty) {
        final Procedure1<FormattingDataInit> _function = (FormattingDataInit it) -> {
          it.noSpace();
        };
        Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(explicit, _function);
        format.operator_add(_prepend);
      } else {
        final Procedure1<FormattingDataInit> _function_1 = (FormattingDataInit it) -> {
          it.oneSpace();
        };
        Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(open, _function_1);
        format.operator_add(_append);
        final Procedure1<FormattingDataInit> _function_2 = (FormattingDataInit it) -> {
          it.oneSpace();
        };
        Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend_1 = this._formattingDataFactory.prepend(explicit, _function_2);
        format.operator_add(_prepend_1);
      }
      final Procedure1<FormattingDataInit> _function_3 = (FormattingDataInit it) -> {
        it.newLine();
        it.increaseIndentation();
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(explicit, _function_3);
      format.operator_add(_append_1);
    } else {
      final Procedure1<FormattingDataInit> _function_4 = (FormattingDataInit it) -> {
        it.newLine();
        it.increaseIndentation();
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_2 = this._formattingDataFactory.append(open, _function_4);
      format.operator_add(_append_2);
    }
    for (final XExpression c : children) {
      {
        this.format(c, format);
        final INode node = this._nodeModelAccess.nodeForEObject(c);
        final ILeafNode semicolon = this._nodeModelAccess.immediatelyFollowingKeyword(node, ";");
        final Procedure1<FormattingDataInit> _function_5 = (FormattingDataInit it) -> {
          it.noSpace();
        };
        Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend_2 = this._formattingDataFactory.prepend(semicolon, _function_5);
        format.operator_add(_prepend_2);
        XExpression _last = IterableExtensions.<XExpression>last(children);
        boolean _notEquals = (!Objects.equal(c, _last));
        if (_notEquals) {
          INode _elvis = null;
          if (semicolon != null) {
            _elvis = semicolon;
          } else {
            _elvis = node;
          }
          final Procedure1<FormattingDataInit> _function_6 = (FormattingDataInit it) -> {
            it.newLine();
          };
          Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_3 = this._formattingDataFactory.append(_elvis, _function_6);
          format.operator_add(_append_3);
        }
      }
    }
    final Procedure1<FormattingDataInit> _function_5 = (FormattingDataInit it) -> {
      it.newLine();
      it.decreaseIndentation();
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend_2 = this._formattingDataFactory.prepend(close, _function_5);
    format.operator_add(_prepend_2);
  }

  protected void formatClosureParameters(final XClosure expr, final FormattableDocument format) {
    boolean _isExplicitSyntax = expr.isExplicitSyntax();
    if (_isExplicitSyntax) {
      EList<JvmFormalParameter> _declaredFormalParameters = expr.getDeclaredFormalParameters();
      for (final JvmFormalParameter param : _declaredFormalParameters) {
        {
          this.format(param, format);
          final Procedure1<FormattingDataInit> _function = (FormattingDataInit it) -> {
            it.noSpace();
          };
          final Procedure1<FormattingDataInit> _function_1 = (FormattingDataInit it) -> {
            it.oneSpace();
          };
          Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _surround = this._formattingDataFactory.surround(this._nodeModelAccess.immediatelyFollowingKeyword(param, ","), _function, _function_1);
          format.operator_add(_surround);
        }
      }
    }
  }

  protected void formatClosureWrapIfNeeded(final XClosure expr, final INode open, final Collection<XExpression> children, final INode close, final FormattableDocument format) {
    this.formatClosureParameters(expr, format);
    INode last = open;
    boolean _isExplicitSyntax = expr.isExplicitSyntax();
    if (_isExplicitSyntax) {
      final Procedure1<FormattingDataInit> _function = (FormattingDataInit it) -> {
        it.noSpace();
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(open, _function);
      format.operator_add(_append);
      last = this._nodeModelAccess.nodeForFeature(expr, XbasePackage.Literals.XCLOSURE__EXPLICIT_SYNTAX);
      boolean _isEmpty = expr.getDeclaredFormalParameters().isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final Procedure1<FormattingDataInit> _function_1 = (FormattingDataInit it) -> {
          it.noSpace();
        };
        Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(last, _function_1);
        format.operator_add(_prepend);
      }
    }
    boolean indented = false;
    for (final XExpression c : children) {
      {
        boolean _fitsIntoLine = this.fitsIntoLine(format, c);
        if (_fitsIntoLine) {
          final Procedure1<FormattingDataInit> _function_2 = (FormattingDataInit it) -> {
            XExpression _head = IterableExtensions.<XExpression>head(children);
            boolean _equals = Objects.equal(_head, c);
            if (_equals) {
              it.noSpace();
            } else {
              it.oneSpace();
            }
          };
          Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(last, _function_2);
          format.operator_add(_append_1);
        } else {
          if ((!indented)) {
            indented = true;
            final Procedure1<FormattingDataInit> _function_3 = (FormattingDataInit it) -> {
              it.increaseIndentation();
            };
            Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_2 = this._formattingDataFactory.append(last, _function_3);
            format.operator_add(_append_2);
          }
          final Procedure1<FormattingDataInit> _function_4 = (FormattingDataInit it) -> {
            it.newLine();
          };
          Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_3 = this._formattingDataFactory.append(last, _function_4);
          format.operator_add(_append_3);
        }
        this.format(c, format);
        last = this._nodeModelAccess.nodeForEObject(c);
        final ILeafNode semicolon = this._nodeModelAccess.immediatelyFollowingKeyword(last, ";");
        if ((semicolon != null)) {
          final Procedure1<FormattingDataInit> _function_5 = (FormattingDataInit it) -> {
            it.noSpace();
          };
          Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend_1 = this._formattingDataFactory.prepend(semicolon, _function_5);
          format.operator_add(_prepend_1);
          last = semicolon;
        }
      }
    }
    if (indented) {
      final Procedure1<FormattingDataInit> _function_2 = (FormattingDataInit it) -> {
        it.decreaseIndentation();
      };
      Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(this._nodeModelAccess.nodeForEObject(IterableExtensions.<XExpression>last(children)), _function_2);
      format.operator_add(_append_1);
    }
    final Procedure1<FormattingDataInit> _function_3 = (FormattingDataInit it) -> {
      it.noSpace();
    };
    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _prepend_1 = this._formattingDataFactory.prepend(close, _function_3);
    format.operator_add(_prepend_1);
  }

  protected void format(final EObject ref, final FormattableDocument document) {
    if (ref instanceof JvmTypeParameter) {
      _format((JvmTypeParameter)ref, document);
      return;
    } else if (ref instanceof JvmFormalParameter) {
      _format((JvmFormalParameter)ref, document);
      return;
    } else if (ref instanceof XAssignment) {
      _format((XAssignment)ref, document);
      return;
    } else if (ref instanceof XBinaryOperation) {
      _format((XBinaryOperation)ref, document);
      return;
    } else if (ref instanceof XDoWhileExpression) {
      _format((XDoWhileExpression)ref, document);
      return;
    } else if (ref instanceof XFeatureCall) {
      _format((XFeatureCall)ref, document);
      return;
    } else if (ref instanceof XMemberFeatureCall) {
      _format((XMemberFeatureCall)ref, document);
      return;
    } else if (ref instanceof XWhileExpression) {
      _format((XWhileExpression)ref, document);
      return;
    } else if (ref instanceof XFunctionTypeRef) {
      _format((XFunctionTypeRef)ref, document);
      return;
    } else if (ref instanceof JvmGenericArrayTypeReference) {
      _format((JvmGenericArrayTypeReference)ref, document);
      return;
    } else if (ref instanceof JvmParameterizedTypeReference) {
      _format((JvmParameterizedTypeReference)ref, document);
      return;
    } else if (ref instanceof JvmWildcardTypeReference) {
      _format((JvmWildcardTypeReference)ref, document);
      return;
    } else if (ref instanceof XBasicForLoopExpression) {
      _format((XBasicForLoopExpression)ref, document);
      return;
    } else if (ref instanceof XBlockExpression) {
      _format((XBlockExpression)ref, document);
      return;
    } else if (ref instanceof XClosure) {
      _format((XClosure)ref, document);
      return;
    } else if (ref instanceof XCollectionLiteral) {
      _format((XCollectionLiteral)ref, document);
      return;
    } else if (ref instanceof XConstructorCall) {
      _format((XConstructorCall)ref, document);
      return;
    } else if (ref instanceof XForLoopExpression) {
      _format((XForLoopExpression)ref, document);
      return;
    } else if (ref instanceof XIfExpression) {
      _format((XIfExpression)ref, document);
      return;
    } else if (ref instanceof XReturnExpression) {
      _format((XReturnExpression)ref, document);
      return;
    } else if (ref instanceof XSwitchExpression) {
      _format((XSwitchExpression)ref, document);
      return;
    } else if (ref instanceof XSynchronizedExpression) {
      _format((XSynchronizedExpression)ref, document);
      return;
    } else if (ref instanceof XThrowExpression) {
      _format((XThrowExpression)ref, document);
      return;
    } else if (ref instanceof XTryCatchFinallyExpression) {
      _format((XTryCatchFinallyExpression)ref, document);
      return;
    } else if (ref instanceof XTypeLiteral) {
      _format((XTypeLiteral)ref, document);
      return;
    } else if (ref instanceof XVariableDeclaration) {
      _format((XVariableDeclaration)ref, document);
      return;
    } else if (ref instanceof XAnnotation) {
      _format((XAnnotation)ref, document);
      return;
    } else if (ref instanceof JvmTypeConstraint) {
      _format((JvmTypeConstraint)ref, document);
      return;
    } else if (ref instanceof XCatchClause) {
      _format((XCatchClause)ref, document);
      return;
    } else if (ref instanceof XExpression) {
      _format((XExpression)ref, document);
      return;
    } else if (ref != null) {
      _format(ref, document);
      return;
    } else if (ref == null) {
      _format((Void)null, document);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(ref, document).toString());
    }
  }

  protected boolean isMultiParamInOwnLine(final XExpression fc, final FormattableDocument doc) {
    if (fc instanceof XFeatureCall) {
      return _isMultiParamInOwnLine((XFeatureCall)fc, doc);
    } else if (fc instanceof XMemberFeatureCall) {
      return _isMultiParamInOwnLine((XMemberFeatureCall)fc, doc);
    } else if (fc instanceof XConstructorCall) {
      return _isMultiParamInOwnLine((XConstructorCall)fc, doc);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(fc, doc).toString());
    }
  }
}
