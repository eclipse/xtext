package org.eclipse.xtext.xbase.annotations.interpreter;

import com.google.common.base.Objects;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XListLiteral;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValueBinaryOperation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

@SuppressWarnings("all")
public class ConstantExpressionsInterpreter {
  /**
   * Very limited poor-man's interpreter for annotation values.
   * 
   * for type literals it returns the JvmType
   * for nested annotations it returns the XAnnotation
   * 
   * @param expression the expression to be evaluated
   * @param expectedType the expected type, or <code>null</code> if no type expectation exists.
   */
  public Object evaluate(final XExpression expression, final LightweightTypeReference expectedType) {
    Object _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (expression instanceof XStringLiteral) {
        _matched=true;
        String _xblockexpression = null;
        {
          String _simpleName = null;
          if (expectedType!=null) {
            _simpleName=expectedType.getSimpleName();
          }
          boolean _equals = Objects.equal(_simpleName, "char");
          if (_equals) {
            String _value = ((XStringLiteral)expression).getValue();
            _value.charAt(0);
          }
          String _value_1 = ((XStringLiteral)expression).getValue();
          _xblockexpression = (_value_1);
        }
        _switchResult = _xblockexpression;
      }
    }
    if (!_matched) {
      if (expression instanceof XBooleanLiteral) {
        _matched=true;
        boolean _isIsTrue = ((XBooleanLiteral)expression).isIsTrue();
        _switchResult = Boolean.valueOf(_isIsTrue);
      }
    }
    if (!_matched) {
      if (expression instanceof XNumberLiteral) {
        _matched=true;
        Number _switchResult_1 = null;
        boolean _matched_1 = false;
        if (!_matched_1) {
          String _simpleName = null;
          if (expectedType!=null) {
            _simpleName=expectedType.getSimpleName();
          }
          boolean _equals = Objects.equal(_simpleName, "long");
          if (_equals) {
            _matched_1=true;
            String _value = ((XNumberLiteral)expression).getValue();
            Long _valueOf = Long.valueOf(_value);
            _switchResult_1 = _valueOf;
          }
        }
        if (!_matched_1) {
          String _simpleName_1 = null;
          if (expectedType!=null) {
            _simpleName_1=expectedType.getSimpleName();
          }
          boolean _equals_1 = Objects.equal(_simpleName_1, "short");
          if (_equals_1) {
            _matched_1=true;
            String _value_1 = ((XNumberLiteral)expression).getValue();
            Short _valueOf_1 = Short.valueOf(_value_1);
            _switchResult_1 = _valueOf_1;
          }
        }
        if (!_matched_1) {
          String _simpleName_2 = null;
          if (expectedType!=null) {
            _simpleName_2=expectedType.getSimpleName();
          }
          boolean _equals_2 = Objects.equal(_simpleName_2, "byte");
          if (_equals_2) {
            _matched_1=true;
            String _value_2 = ((XNumberLiteral)expression).getValue();
            Byte _valueOf_2 = Byte.valueOf(_value_2);
            _switchResult_1 = _valueOf_2;
          }
        }
        if (!_matched_1) {
          String _simpleName_3 = null;
          if (expectedType!=null) {
            _simpleName_3=expectedType.getSimpleName();
          }
          boolean _equals_3 = Objects.equal(_simpleName_3, "float");
          if (_equals_3) {
            _matched_1=true;
            String _value_3 = ((XNumberLiteral)expression).getValue();
            Float _valueOf_3 = Float.valueOf(_value_3);
            _switchResult_1 = _valueOf_3;
          }
        }
        if (!_matched_1) {
          String _simpleName_4 = null;
          if (expectedType!=null) {
            _simpleName_4=expectedType.getSimpleName();
          }
          boolean _equals_4 = Objects.equal(_simpleName_4, "double");
          if (_equals_4) {
            _matched_1=true;
            String _value_4 = ((XNumberLiteral)expression).getValue();
            Double _valueOf_4 = Double.valueOf(_value_4);
            _switchResult_1 = _valueOf_4;
          }
        }
        if (!_matched_1) {
          String _value_5 = ((XNumberLiteral)expression).getValue();
          Integer _valueOf_5 = Integer.valueOf(_value_5);
          _switchResult_1 = _valueOf_5;
        }
        _switchResult = ((Number)_switchResult_1);
      }
    }
    if (!_matched) {
      if (expression instanceof XTypeLiteral) {
        _matched=true;
        JvmType _type = ((XTypeLiteral)expression).getType();
        _switchResult = _type;
      }
    }
    if (!_matched) {
      if (expression instanceof XAnnotation) {
        _matched=true;
        _switchResult = expression;
      }
    }
    if (!_matched) {
      if (expression instanceof XListLiteral) {
        _matched=true;
        Object[] _xblockexpression = null;
        {
          EList<XExpression> _elements = ((XListLiteral)expression).getElements();
          final Function1<XExpression,Object> _function = new Function1<XExpression,Object>() {
            public Object apply(final XExpression it) {
              Object _evaluate = ConstantExpressionsInterpreter.this.evaluate(it, null);
              return _evaluate;
            }
          };
          final List<Object> results = ListExtensions.<XExpression, Object>map(_elements, _function);
          Object[] _switchResult_1 = null;
          Object _head = IterableExtensions.<Object>head(results);
          final Object _switchValue = _head;
          boolean _matched_1 = false;
          if (!_matched_1) {
            if (_switchValue instanceof String) {
              _matched_1=true;
              String[] _xblockexpression_1 = null;
              {
                int _size = results.size();
                final String[] array = new String[_size];
                String[] _array = results.<String>toArray(array);
                _xblockexpression_1 = (_array);
              }
              _switchResult_1 = _xblockexpression_1;
            }
          }
          if (!_matched_1) {
            if (_switchValue instanceof JvmType) {
              _matched_1=true;
              JvmType[] _xblockexpression_1 = null;
              {
                int _size = results.size();
                final JvmType[] array = new JvmType[_size];
                JvmType[] _array = results.<JvmType>toArray(array);
                _xblockexpression_1 = (_array);
              }
              _switchResult_1 = _xblockexpression_1;
            }
          }
          if (!_matched_1) {
            if (_switchValue instanceof Integer) {
              _matched_1=true;
              Integer[] _xblockexpression_1 = null;
              {
                int _size = results.size();
                final Integer[] array = new Integer[_size];
                Integer[] _array = results.<Integer>toArray(array);
                _xblockexpression_1 = (_array);
              }
              _switchResult_1 = _xblockexpression_1;
            }
          }
          _xblockexpression = (_switchResult_1);
        }
        _switchResult = _xblockexpression;
      }
    }
    if (!_matched) {
      if (expression instanceof XBinaryOperation) {
        _matched=true;
        XExpression _leftOperand = ((XBinaryOperation)expression).getLeftOperand();
        final Object leftVal = this.evaluate(_leftOperand, null);
        XExpression _rightOperand = ((XBinaryOperation)expression).getRightOperand();
        final Object rightVal = this.evaluate(_rightOperand, null);
        return this.plus(leftVal, rightVal);
      }
    }
    if (!_matched) {
      if (expression instanceof XAnnotationElementValueBinaryOperation) {
        _matched=true;
        Object _switchResult_1 = null;
        String _operator = ((XAnnotationElementValueBinaryOperation)expression).getOperator();
        final String _switchValue = _operator;
        boolean _matched_1 = false;
        if (!_matched_1) {
          if (Objects.equal(_switchValue,"+")) {
            _matched_1=true;
            XExpression _leftOperand = ((XAnnotationElementValueBinaryOperation)expression).getLeftOperand();
            final Object leftVal = this.evaluate(_leftOperand, null);
            XExpression _rightOperand = ((XAnnotationElementValueBinaryOperation)expression).getRightOperand();
            final Object rightVal = this.evaluate(_rightOperand, null);
            return this.plus(leftVal, rightVal);
          }
        }
        _switchResult = _switchResult_1;
      }
    }
    if (!_matched) {
      String _plus = ("Couldn\'t interpret expression : " + expression);
      String _plus_1 = (_plus + ".");
      IllegalArgumentException _illegalArgumentException = new IllegalArgumentException(_plus_1);
      throw _illegalArgumentException;
    }
    return _switchResult;
  }
  
  protected Object _plus(final Object a, final Object b) {
    String _plus = ("was left:" + a);
    String _plus_1 = (_plus + ", right:");
    String _plus_2 = (_plus_1 + b);
    IllegalArgumentException _illegalArgumentException = new IllegalArgumentException(_plus_2);
    throw _illegalArgumentException;
  }
  
  protected int _plus(final Integer a, final Integer b) {
    int _plus = ((a).intValue() + (b).intValue());
    return _plus;
  }
  
  protected Object _plus(final String a, final Object b) {
    String _plus = (a + b);
    return _plus;
  }
  
  public Object plus(final Object a, final Object b) {
    if (a instanceof Integer
         && b instanceof Integer) {
      return _plus((Integer)a, (Integer)b);
    } else if (a instanceof String
         && b != null) {
      return _plus((String)a, b);
    } else if (a != null
         && b != null) {
      return _plus(a, b);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(a, b).toString());
    }
  }
}
