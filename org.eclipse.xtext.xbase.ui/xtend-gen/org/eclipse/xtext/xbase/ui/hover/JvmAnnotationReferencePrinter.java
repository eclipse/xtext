/**
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.ui.hover;

import com.google.common.base.Objects;
import java.util.Arrays;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
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
  private static final Logger LOG = Logger.getLogger(JvmAnnotationReferencePrinter.class);
  
  public String toHtmlString(final JvmAnnotationReference reference) {
    String _xtrycatchfinallyexpression = null;
    try {
      _xtrycatchfinallyexpression = this.internalToString(reference);
    } catch (final Throwable _t) {
      if (_t instanceof RuntimeException) {
        final RuntimeException e = (RuntimeException)_t;
        JvmAnnotationReferencePrinter.LOG.error(e.getMessage(), e);
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
    final URI uri = EcoreUtil.getURI(reference.getAnnotation());
    buffer.append(this.createLinkWithLabel(XtextElementLinks.XTEXTDOC_SCHEME, uri, reference.getAnnotation().getSimpleName()));
    boolean _or = false;
    int _size = reference.getExplicitValues().size();
    boolean _greaterThan = (_size > 1);
    if (_greaterThan) {
      _or = true;
    } else {
      boolean _and = false;
      JvmAnnotationValue _head = IterableExtensions.<JvmAnnotationValue>head(reference.getExplicitValues());
      JvmOperation _operation = null;
      if (_head!=null) {
        _operation=_head.getOperation();
      }
      boolean _tripleNotEquals = (_operation != null);
      if (!_tripleNotEquals) {
        _and = false;
      } else {
        String _simpleName = IterableExtensions.<JvmAnnotationValue>head(reference.getExplicitValues()).getOperation().getSimpleName();
        boolean _notEquals = (!Objects.equal(_simpleName, "value"));
        _and = _notEquals;
      }
      _or = _and;
    }
    final boolean needsExplicitProperties = _or;
    int _size_1 = reference.getExplicitValues().size();
    boolean _greaterThan_1 = (_size_1 > 0);
    if (_greaterThan_1) {
      buffer.append("(");
      final Function1<JvmAnnotationValue, String> _function = (JvmAnnotationValue it) -> {
        final StringBuilder builder = new StringBuilder();
        if (needsExplicitProperties) {
          JvmOperation _elvis = null;
          JvmOperation _operation_1 = it.getOperation();
          if (_operation_1 != null) {
            _elvis = _operation_1;
          } else {
            final Function1<JvmOperation, Boolean> _function_1 = (JvmOperation it_1) -> {
              String _simpleName_1 = it_1.getSimpleName();
              return Boolean.valueOf(Objects.equal(_simpleName_1, "value"));
            };
            JvmOperation _findFirst = IterableExtensions.<JvmOperation>findFirst(reference.getAnnotation().getDeclaredOperations(), _function_1);
            _elvis = _findFirst;
          }
          final JvmOperation operation = _elvis;
          final URI operationUri = EcoreUtil.getURI(operation);
          builder.append(this.createLinkWithLabel(XtextElementLinks.XTEXTDOC_SCHEME, operationUri, operation.getSimpleName()));
          builder.append("=");
        }
        builder.append(this.internalToString(it));
        return builder.toString();
      };
      buffer.append(
        IterableExtensions.join(ListExtensions.<JvmAnnotationValue, String>map(reference.getExplicitValues(), _function), ", "));
      buffer.append(")");
    }
    return buffer.toString();
  }
  
  protected String _internalToString(final XAnnotation reference) {
    final StringBuilder buffer = new StringBuilder();
    buffer.append("@");
    final URI uri = EcoreUtil.getURI(reference.getAnnotationType());
    buffer.append(this.createLinkWithLabel(XtextElementLinks.XTEXTDOC_SCHEME, uri, reference.getAnnotationType().getSimpleName()));
    XExpression _value = reference.getValue();
    boolean _tripleNotEquals = (_value != null);
    if (_tripleNotEquals) {
      buffer.append("(");
      buffer.append(reference.getValue());
      buffer.append(")");
    } else {
      boolean _isEmpty = reference.getElementValuePairs().isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        buffer.append("(");
        final Function1<XAnnotationElementValuePair, String> _function = (XAnnotationElementValuePair it) -> {
          final StringBuilder builder = new StringBuilder();
          JvmOperation _elvis = null;
          JvmOperation _element = it.getElement();
          if (_element != null) {
            _elvis = _element;
          } else {
            JvmType _annotationType = reference.getAnnotationType();
            final Function1<JvmOperation, Boolean> _function_1 = (JvmOperation it_1) -> {
              String _simpleName = it_1.getSimpleName();
              return Boolean.valueOf(Objects.equal(_simpleName, "value"));
            };
            JvmOperation _findFirst = IterableExtensions.<JvmOperation>findFirst(((JvmAnnotationType) _annotationType).getDeclaredOperations(), _function_1);
            _elvis = _findFirst;
          }
          final JvmOperation operation = _elvis;
          final URI operationUri = EcoreUtil.getURI(operation);
          builder.append(this.createLinkWithLabel(XtextElementLinks.XTEXTDOC_SCHEME, operationUri, operation.getSimpleName()));
          builder.append("=");
          builder.append(this.internalToString(it.getValue()));
          return builder.toString();
        };
        buffer.append(
          IterableExtensions.join(ListExtensions.<XAnnotationElementValuePair, String>map(reference.getElementValuePairs(), _function), ", "));
        buffer.append(")");
      }
    }
    return buffer.toString();
  }
  
  protected String _internalToString(final JvmAnnotationValue it) {
    final EStructuralFeature ref = it.eClass().getEStructuralFeature("values");
    if ((ref == null)) {
      throw new IllegalStateException(("Cannot handle " + it));
    }
    Object _eGet = it.eGet(ref);
    final EList<?> values = ((EList<?>) _eGet);
    int _size = values.size();
    boolean _greaterThan = (_size > 1);
    if (_greaterThan) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("#[");
      final Function1<Object, String> _function = (Object it_1) -> {
        return this.internalToString(it_1);
      };
      String _join = IterableExtensions.join(ListExtensions.map(values, _function), ", ");
      _builder.append(_join);
      _builder.append("]");
      return _builder.toString();
    } else {
      return this.internalToString(IterableExtensions.head(values));
    }
  }
  
  protected String _internalToString(final Object o) {
    return o.toString();
  }
  
  protected String _internalToString(final XTypeLiteral o) {
    final URI uri = EcoreUtil.getURI(o.getType());
    final String text = this.createLinkWithLabel(XtextElementLinks.XTEXTDOC_SCHEME, uri, o.getType().getSimpleName());
    String _join = IterableExtensions.join(o.getArrayDimensions());
    return (text + _join);
  }
  
  protected String _internalToString(final XListLiteral o) {
    final Function1<XExpression, String> _function = (XExpression it) -> {
      return this.internalToString(it);
    };
    String _join = IterableExtensions.join(ListExtensions.<XExpression, String>map(o.getElements(), _function), ", ");
    String _plus = ("#[" + _join);
    return (_plus + "]");
  }
  
  protected String _internalToString(final XBinaryOperation o) {
    String _internalToString = this.internalToString(o.getLeftOperand());
    String _plus = (_internalToString + " ");
    String _concreteSyntaxFeatureName = o.getConcreteSyntaxFeatureName();
    String _plus_1 = (_plus + _concreteSyntaxFeatureName);
    String _plus_2 = (_plus_1 + " ");
    String _internalToString_1 = this.internalToString(o.getRightOperand());
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
    return Boolean.valueOf(o.isIsTrue()).toString();
  }
  
  protected String _internalToString(final XMemberFeatureCall o) {
    boolean _isPackageFragment = o.isPackageFragment();
    if (_isPackageFragment) {
      return null;
    }
    final String prefix = this.internalToString(o.getMemberCallTarget());
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
    if (((o.getFeature() != null) && (!o.getFeature().eIsProxy()))) {
      String _xblockexpression = null;
      {
        final URI uri = EcoreUtil.getURI(o.getFeature());
        _xblockexpression = this.createLinkWithLabel(XtextElementLinks.XTEXTDOC_SCHEME, uri, o.getConcreteSyntaxFeatureName());
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = o.getConcreteSyntaxFeatureName();
    }
    final String postfix = _xifexpression;
    if ((prefix == null)) {
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
