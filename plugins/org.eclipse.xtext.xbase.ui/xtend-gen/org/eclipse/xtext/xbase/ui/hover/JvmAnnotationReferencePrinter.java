/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.ui.hover;

import com.google.common.base.Objects;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.ui.editor.hover.html.XtextElementLinks;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XListLiteral;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.ui.hover.HoverLinkHelper;

/**
 * Provides a html representation for JvmAnnotationReferences to be used in hovers.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class JvmAnnotationReferencePrinter {
  private final static Logger LOG = Logger.getLogger(JvmAnnotationReferencePrinter.class);
  
  public String toHtmlString(final JvmAnnotationReference reference) {
    String _xtrycatchfinallyexpression = null;
    try {
      _xtrycatchfinallyexpression = this.internalToString(reference);
    } catch (final Throwable _t) {
      if (_t instanceof RuntimeException) {
        final RuntimeException e = (RuntimeException)_t;
        String _message = e.getMessage();
        JvmAnnotationReferencePrinter.LOG.error(_message, e);
        JvmAnnotationType _annotation = null;
        if (reference!=null) {
          _annotation=reference.getAnnotation();
        }
        String _simpleName = null;
        if (_annotation!=null) {
          _simpleName=_annotation.getSimpleName();
        }
        return _simpleName;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
  
  protected String _internalToString(final JvmAnnotationReference reference) {
    final StringBuilder buffer = new StringBuilder();
    buffer.append("@");
    JvmAnnotationType _annotation = reference.getAnnotation();
    final URI uri = EcoreUtil.getURI(_annotation);
    JvmAnnotationType _annotation_1 = reference.getAnnotation();
    String _simpleName = _annotation_1.getSimpleName();
    String _createLinkWithLabel = this.createLinkWithLabel(XtextElementLinks.XTEXTDOC_SCHEME, uri, _simpleName);
    buffer.append(_createLinkWithLabel);
    boolean _or = false;
    EList<JvmAnnotationValue> _explicitValues = reference.getExplicitValues();
    int _size = _explicitValues.size();
    boolean _greaterThan = (_size > 1);
    if (_greaterThan) {
      _or = true;
    } else {
      boolean _and = false;
      EList<JvmAnnotationValue> _explicitValues_1 = reference.getExplicitValues();
      JvmAnnotationValue _head = IterableExtensions.<JvmAnnotationValue>head(_explicitValues_1);
      JvmOperation _operation = null;
      if (_head!=null) {
        _operation=_head.getOperation();
      }
      boolean _notEquals = (!Objects.equal(_operation, null));
      if (!_notEquals) {
        _and = false;
      } else {
        EList<JvmAnnotationValue> _explicitValues_2 = reference.getExplicitValues();
        JvmAnnotationValue _head_1 = IterableExtensions.<JvmAnnotationValue>head(_explicitValues_2);
        JvmOperation _operation_1 = _head_1.getOperation();
        String _simpleName_1 = _operation_1.getSimpleName();
        boolean _notEquals_1 = (!Objects.equal(_simpleName_1, "value"));
        _and = _notEquals_1;
      }
      _or = _and;
    }
    final boolean needsExplicitProperties = _or;
    EList<JvmAnnotationValue> _explicitValues_3 = reference.getExplicitValues();
    int _size_1 = _explicitValues_3.size();
    boolean _greaterThan_1 = (_size_1 > 0);
    if (_greaterThan_1) {
      buffer.append("(");
      EList<JvmAnnotationValue> _explicitValues_4 = reference.getExplicitValues();
      final Function1<JvmAnnotationValue, String> _function = new Function1<JvmAnnotationValue, String>() {
        @Override
        public String apply(final JvmAnnotationValue it) {
          final StringBuilder builder = new StringBuilder();
          if (needsExplicitProperties) {
            JvmOperation _elvis = null;
            JvmOperation _operation = it.getOperation();
            if (_operation != null) {
              _elvis = _operation;
            } else {
              JvmAnnotationType _annotation = reference.getAnnotation();
              Iterable<JvmOperation> _declaredOperations = _annotation.getDeclaredOperations();
              final Function1<JvmOperation, Boolean> _function = new Function1<JvmOperation, Boolean>() {
                @Override
                public Boolean apply(final JvmOperation it) {
                  String _simpleName = it.getSimpleName();
                  return Boolean.valueOf(Objects.equal(_simpleName, "value"));
                }
              };
              JvmOperation _findFirst = IterableExtensions.<JvmOperation>findFirst(_declaredOperations, _function);
              _elvis = _findFirst;
            }
            final JvmOperation operation = _elvis;
            final URI operationUri = EcoreUtil.getURI(operation);
            String _simpleName = operation.getSimpleName();
            String _createLinkWithLabel = JvmAnnotationReferencePrinter.this.createLinkWithLabel(XtextElementLinks.XTEXTDOC_SCHEME, operationUri, _simpleName);
            builder.append(_createLinkWithLabel);
            builder.append("=");
          }
          String _internalToString = JvmAnnotationReferencePrinter.this.internalToString(it);
          builder.append(_internalToString);
          return builder.toString();
        }
      };
      List<String> _map = ListExtensions.<JvmAnnotationValue, String>map(_explicitValues_4, _function);
      String _join = IterableExtensions.join(_map, ", ");
      buffer.append(_join);
      buffer.append(")");
    }
    return buffer.toString();
  }
  
  protected String _internalToString(final XAnnotation reference) {
    final StringBuilder buffer = new StringBuilder();
    buffer.append("@");
    JvmType _annotationType = reference.getAnnotationType();
    final URI uri = EcoreUtil.getURI(_annotationType);
    JvmType _annotationType_1 = reference.getAnnotationType();
    String _simpleName = _annotationType_1.getSimpleName();
    String _createLinkWithLabel = this.createLinkWithLabel(XtextElementLinks.XTEXTDOC_SCHEME, uri, _simpleName);
    buffer.append(_createLinkWithLabel);
    XExpression _value = reference.getValue();
    boolean _notEquals = (!Objects.equal(_value, null));
    if (_notEquals) {
      buffer.append("(");
      XExpression _value_1 = reference.getValue();
      buffer.append(_value_1);
      buffer.append(")");
    } else {
      EList<XAnnotationElementValuePair> _elementValuePairs = reference.getElementValuePairs();
      boolean _isEmpty = _elementValuePairs.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        buffer.append("(");
        EList<XAnnotationElementValuePair> _elementValuePairs_1 = reference.getElementValuePairs();
        final Function1<XAnnotationElementValuePair, String> _function = new Function1<XAnnotationElementValuePair, String>() {
          @Override
          public String apply(final XAnnotationElementValuePair it) {
            final StringBuilder builder = new StringBuilder();
            JvmOperation _elvis = null;
            JvmOperation _element = it.getElement();
            if (_element != null) {
              _elvis = _element;
            } else {
              JvmType _annotationType = reference.getAnnotationType();
              Iterable<JvmOperation> _declaredOperations = ((JvmAnnotationType) _annotationType).getDeclaredOperations();
              final Function1<JvmOperation, Boolean> _function = new Function1<JvmOperation, Boolean>() {
                @Override
                public Boolean apply(final JvmOperation it) {
                  String _simpleName = it.getSimpleName();
                  return Boolean.valueOf(Objects.equal(_simpleName, "value"));
                }
              };
              JvmOperation _findFirst = IterableExtensions.<JvmOperation>findFirst(_declaredOperations, _function);
              _elvis = _findFirst;
            }
            final JvmOperation operation = _elvis;
            final URI operationUri = EcoreUtil.getURI(operation);
            String _simpleName = operation.getSimpleName();
            String _createLinkWithLabel = JvmAnnotationReferencePrinter.this.createLinkWithLabel(XtextElementLinks.XTEXTDOC_SCHEME, operationUri, _simpleName);
            builder.append(_createLinkWithLabel);
            builder.append("=");
            XExpression _value = it.getValue();
            String _internalToString = JvmAnnotationReferencePrinter.this.internalToString(_value);
            builder.append(_internalToString);
            return builder.toString();
          }
        };
        List<String> _map = ListExtensions.<XAnnotationElementValuePair, String>map(_elementValuePairs_1, _function);
        String _join = IterableExtensions.join(_map, ", ");
        buffer.append(_join);
        buffer.append(")");
      }
    }
    return buffer.toString();
  }
  
  protected String _internalToString(final JvmAnnotationValue it) {
    EClass _eClass = it.eClass();
    final EStructuralFeature ref = _eClass.getEStructuralFeature("values");
    boolean _equals = Objects.equal(ref, null);
    if (_equals) {
      throw new IllegalStateException(("Cannot handle " + it));
    }
    Object _eGet = it.eGet(ref);
    final EList<?> values = ((EList<?>) _eGet);
    int _size = values.size();
    boolean _greaterThan = (_size > 1);
    if (_greaterThan) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("#[");
      final Function1<Object, String> _function = new Function1<Object, String>() {
        @Override
        public String apply(final Object it) {
          return JvmAnnotationReferencePrinter.this.internalToString(it);
        }
      };
      List<String> _map = ListExtensions.map(values, _function);
      String _join = IterableExtensions.join(_map, ", ");
      _builder.append(_join, "");
      _builder.append("]");
      return _builder.toString();
    } else {
      Object _head = IterableExtensions.head(values);
      return this.internalToString(_head);
    }
  }
  
  protected String _internalToString(final Object o) {
    return o.toString();
  }
  
  protected String _internalToString(final XTypeLiteral o) {
    JvmType _type = o.getType();
    final URI uri = EcoreUtil.getURI(_type);
    JvmType _type_1 = o.getType();
    String _simpleName = _type_1.getSimpleName();
    final String text = this.createLinkWithLabel(XtextElementLinks.XTEXTDOC_SCHEME, uri, _simpleName);
    EList<String> _arrayDimensions = o.getArrayDimensions();
    String _join = IterableExtensions.join(_arrayDimensions);
    return (text + _join);
  }
  
  protected String _internalToString(final XListLiteral o) {
    EList<XExpression> _elements = o.getElements();
    final Function1<XExpression, String> _function = new Function1<XExpression, String>() {
      @Override
      public String apply(final XExpression it) {
        return JvmAnnotationReferencePrinter.this.internalToString(it);
      }
    };
    List<String> _map = ListExtensions.<XExpression, String>map(_elements, _function);
    String _join = IterableExtensions.join(_map, ", ");
    String _plus = ("#[" + _join);
    return (_plus + "]");
  }
  
  protected String _internalToString(final XBinaryOperation o) {
    XExpression _leftOperand = o.getLeftOperand();
    String _internalToString = this.internalToString(_leftOperand);
    String _plus = (_internalToString + " ");
    String _concreteSyntaxFeatureName = o.getConcreteSyntaxFeatureName();
    String _plus_1 = (_plus + _concreteSyntaxFeatureName);
    String _plus_2 = (_plus_1 + " ");
    XExpression _rightOperand = o.getRightOperand();
    String _internalToString_1 = this.internalToString(_rightOperand);
    return (_plus_2 + _internalToString_1);
  }
  
  protected String _internalToString(final XStringLiteral o) {
    String _value = o.getValue();
    String _plus = ("\"" + _value);
    return (_plus + "\"");
  }
  
  protected String _internalToString(final XNumberLiteral o) {
    return o.getValue();
  }
  
  protected String _internalToString(final XBooleanLiteral o) {
    boolean _isIsTrue = o.isIsTrue();
    return Boolean.valueOf(_isIsTrue).toString();
  }
  
  protected String _internalToString(final XMemberFeatureCall o) {
    boolean _isPackageFragment = o.isPackageFragment();
    if (_isPackageFragment) {
      return null;
    }
    XExpression _memberCallTarget = o.getMemberCallTarget();
    final String prefix = this.internalToString(_memberCallTarget);
    return this.internalHandleAbstractFeatureCall(prefix, o);
  }
  
  protected String _internalToString(final XFeatureCall o) {
    boolean _isPackageFragment = o.isPackageFragment();
    if (_isPackageFragment) {
      return null;
    }
    return this.internalHandleAbstractFeatureCall(null, o);
  }
  
  protected String internalHandleAbstractFeatureCall(final String prefix, final XAbstractFeatureCall o) {
    String _xifexpression = null;
    if (((!Objects.equal(o.getFeature(), null)) && (!o.getFeature().eIsProxy()))) {
      String _xblockexpression = null;
      {
        JvmIdentifiableElement _feature = o.getFeature();
        final URI uri = EcoreUtil.getURI(_feature);
        String _concreteSyntaxFeatureName = o.getConcreteSyntaxFeatureName();
        _xblockexpression = this.createLinkWithLabel(XtextElementLinks.XTEXTDOC_SCHEME, uri, _concreteSyntaxFeatureName);
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = o.getConcreteSyntaxFeatureName();
    }
    final String postfix = _xifexpression;
    boolean _equals = Objects.equal(prefix, null);
    if (_equals) {
      return postfix;
    } else {
      return ((prefix + ".") + postfix);
    }
  }
  
  protected String createLinkWithLabel(final String scheme, final URI uri, final String label) {
    return HoverLinkHelper.createLinkWithLabel(scheme, uri, label);
  }
  
  protected String internalToString(final Object o) {
    if (o instanceof XBinaryOperation) {
      return _internalToString((XBinaryOperation)o);
    } else if (o instanceof XFeatureCall) {
      return _internalToString((XFeatureCall)o);
    } else if (o instanceof XListLiteral) {
      return _internalToString((XListLiteral)o);
    } else if (o instanceof XMemberFeatureCall) {
      return _internalToString((XMemberFeatureCall)o);
    } else if (o instanceof XBooleanLiteral) {
      return _internalToString((XBooleanLiteral)o);
    } else if (o instanceof XNumberLiteral) {
      return _internalToString((XNumberLiteral)o);
    } else if (o instanceof XStringLiteral) {
      return _internalToString((XStringLiteral)o);
    } else if (o instanceof XTypeLiteral) {
      return _internalToString((XTypeLiteral)o);
    } else if (o instanceof XAnnotation) {
      return _internalToString((XAnnotation)o);
    } else if (o instanceof JvmAnnotationReference) {
      return _internalToString((JvmAnnotationReference)o);
    } else if (o instanceof JvmAnnotationValue) {
      return _internalToString((JvmAnnotationValue)o);
    } else if (o != null) {
      return _internalToString(o);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(o).toString());
    }
  }
}
