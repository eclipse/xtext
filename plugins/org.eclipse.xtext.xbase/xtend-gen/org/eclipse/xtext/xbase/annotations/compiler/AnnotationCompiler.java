package org.eclipse.xtext.xbase.annotations.compiler;

import java.util.Iterator;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XIntLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValueBinaryOperation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationValueArray;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;

@SuppressWarnings("all")
public class AnnotationCompiler {
  
  protected void _generate(final XAnnotation annotation, final IAppendable a) {
    {
      IAppendable _append = a.append("@");
      JvmAnnotationType _annotationType = annotation.getAnnotationType();
      _append.append(_annotationType);
      XExpression _value = annotation.getValue();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_value, null);
      if (_operator_notEquals) {
        {
          a.append("(");
          XExpression _value_1 = annotation.getValue();
          this.generate(_value_1, a);
          a.append(")");
        }
      } else {
        EList<XAnnotationElementValuePair> _elementValuePairs = annotation.getElementValuePairs();
        boolean _isEmpty = _elementValuePairs.isEmpty();
        boolean _operator_not = BooleanExtensions.operator_not(_isEmpty);
        if (_operator_not) {
          {
            a.append("(");
            EList<XAnnotationElementValuePair> _elementValuePairs_1 = annotation.getElementValuePairs();
            Iterator<XAnnotationElementValuePair> _iterator = _elementValuePairs_1.iterator();
            final Iterator<XAnnotationElementValuePair> iter = _iterator;
            boolean _hasNext = iter.hasNext();
            Boolean _xwhileexpression = _hasNext;
            while (_xwhileexpression) {
              {
                XAnnotationElementValuePair _next = iter.next();
                this.generate(_next, a);
                boolean _hasNext_1 = iter.hasNext();
                if (_hasNext_1) {
                  a.append(",");
                }
              }
              boolean _hasNext_2 = iter.hasNext();
              _xwhileexpression = _hasNext_2;
            }
            a.append(")");
          }
        }
      }
    }
  }
  
  protected void _generate(final XAnnotationElementValuePair binaryOp, final IAppendable a) {
    {
      JvmOperation _element = binaryOp.getElement();
      String _simpleName = _element.getSimpleName();
      IAppendable _append = a.append(_simpleName);
      _append.append(" = ");
      XExpression _value = binaryOp.getValue();
      this.generate(_value, a);
    }
  }
  
  protected void _generate(final XAnnotationElementValueBinaryOperation binaryOp, final IAppendable a) {
    {
      XExpression _leftOperand = binaryOp.getLeftOperand();
      this.generate(_leftOperand, a);
      a.append(" + ");
      XExpression _rightOperand = binaryOp.getRightOperand();
      this.generate(_rightOperand, a);
    }
  }
  
  protected void _generate(final XAnnotationValueArray array, final IAppendable a) {
    {
      a.append("{");
      EList<XExpression> _values = array.getValues();
      Iterator<XExpression> _iterator = _values.iterator();
      final Iterator<XExpression> iter = _iterator;
      boolean _hasNext = iter.hasNext();
      Boolean _xwhileexpression = _hasNext;
      while (_xwhileexpression) {
        {
          XExpression _next = iter.next();
          this.generate(_next, a);
          boolean _hasNext_1 = iter.hasNext();
          if (_hasNext_1) {
            a.append(", ");
          }
        }
        boolean _hasNext_2 = iter.hasNext();
        _xwhileexpression = _hasNext_2;
      }
      a.append("}");
    }
  }
  
  protected void _generate(final XFeatureCall featureCall, final IAppendable a) {
    {
      JvmDeclaredType _declaringType = featureCall.getDeclaringType();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_declaringType, null);
      if (_operator_notEquals) {
        {
          JvmDeclaredType _declaringType_1 = featureCall.getDeclaringType();
          a.append(_declaringType_1);
          a.append(".");
        }
      }
      JvmIdentifiableElement _feature = featureCall.getFeature();
      String _simpleName = _feature.getSimpleName();
      a.append(_simpleName);
    }
  }
  
  protected void _generate(final XStringLiteral stringLiteral, final IAppendable a) {
    IAppendable _append = a.append("\"");
    String _value = stringLiteral.getValue();
    String _convertToJavaString = Strings.convertToJavaString(_value);
    IAppendable _append_1 = _append.append(_convertToJavaString);
    _append_1.append("\"");
  }
  
  protected void _generate(final XBooleanLiteral booleanLiteral, final IAppendable a) {
    boolean _isIsTrue = booleanLiteral.isIsTrue();
    a.append(((Boolean)_isIsTrue));
  }
  
  protected void _generate(final XIntLiteral intLiteral, final IAppendable a) {
    int _value = intLiteral.getValue();
    a.append(((Integer)_value));
  }
  
  protected void _generate(final XTypeLiteral typeLiteral, final IAppendable a) {
    JvmType _type = typeLiteral.getType();
    IAppendable _append = a.append(_type);
    _append.append(".class");
  }
  
  public void generate(final EObject featureCall, final IAppendable a) {
    if ((featureCall instanceof XFeatureCall)
         && (a instanceof IAppendable)) {
      _generate((XFeatureCall)featureCall, (IAppendable)a);
    } else if ((featureCall instanceof XBooleanLiteral)
         && (a instanceof IAppendable)) {
      _generate((XBooleanLiteral)featureCall, (IAppendable)a);
    } else if ((featureCall instanceof XIntLiteral)
         && (a instanceof IAppendable)) {
      _generate((XIntLiteral)featureCall, (IAppendable)a);
    } else if ((featureCall instanceof XStringLiteral)
         && (a instanceof IAppendable)) {
      _generate((XStringLiteral)featureCall, (IAppendable)a);
    } else if ((featureCall instanceof XTypeLiteral)
         && (a instanceof IAppendable)) {
      _generate((XTypeLiteral)featureCall, (IAppendable)a);
    } else if ((featureCall instanceof XAnnotation)
         && (a instanceof IAppendable)) {
      _generate((XAnnotation)featureCall, (IAppendable)a);
    } else if ((featureCall instanceof XAnnotationElementValueBinaryOperation)
         && (a instanceof IAppendable)) {
      _generate((XAnnotationElementValueBinaryOperation)featureCall, (IAppendable)a);
    } else if ((featureCall instanceof XAnnotationValueArray)
         && (a instanceof IAppendable)) {
      _generate((XAnnotationValueArray)featureCall, (IAppendable)a);
    } else if ((featureCall instanceof XAnnotationElementValuePair)
         && (a instanceof IAppendable)) {
      _generate((XAnnotationElementValuePair)featureCall, (IAppendable)a);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(featureCall, a).toString());
    }
  }
}