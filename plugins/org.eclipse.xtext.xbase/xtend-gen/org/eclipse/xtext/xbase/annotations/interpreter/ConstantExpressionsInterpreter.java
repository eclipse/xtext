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
        final XStringLiteral _xStringLiteral = (XStringLiteral)expression;
        _matched=true;
        String _xblockexpression = null;
        {
          String _simpleName = expectedType==null?(String)null:expectedType.getSimpleName();
          boolean _equals = Objects.equal(_simpleName, "char");
          if (_equals) {
            String _value = _xStringLiteral.getValue();
            _value.charAt(0);
          }
          String _value_1 = _xStringLiteral.getValue();
          _xblockexpression = (_value_1);
        }
        _switchResult = _xblockexpression;
      }
    }
    if (!_matched) {
      if (expression instanceof XBooleanLiteral) {
        final XBooleanLiteral _xBooleanLiteral = (XBooleanLiteral)expression;
        _matched=true;
        boolean _isIsTrue = _xBooleanLiteral.isIsTrue();
        _switchResult = _isIsTrue;
      }
    }
    if (!_matched) {
      if (expression instanceof XNumberLiteral) {
        final XNumberLiteral _xNumberLiteral = (XNumberLiteral)expression;
        _matched=true;
        double _switchResult_1 = (double) 0;
        boolean _matched_1 = false;
        if (!_matched_1) {
          String _simpleName = expectedType==null?(String)null:expectedType.getSimpleName();
          boolean _equals = Objects.equal(_simpleName, "long");
          if (_equals) {
            _matched_1=true;
            String _value = _xNumberLiteral.getValue();
            long _parseLong = Long.parseLong(_value);
            _switchResult_1 = _parseLong;
          }
        }
        if (!_matched_1) {
          String _simpleName_1 = expectedType==null?(String)null:expectedType.getSimpleName();
          boolean _equals_1 = Objects.equal(_simpleName_1, "short");
          if (_equals_1) {
            _matched_1=true;
            String _value_1 = _xNumberLiteral.getValue();
            short _parseShort = Short.parseShort(_value_1);
            _switchResult_1 = _parseShort;
          }
        }
        if (!_matched_1) {
          String _simpleName_2 = expectedType==null?(String)null:expectedType.getSimpleName();
          boolean _equals_2 = Objects.equal(_simpleName_2, "byte");
          if (_equals_2) {
            _matched_1=true;
            String _value_2 = _xNumberLiteral.getValue();
            byte _parseByte = Byte.parseByte(_value_2);
            _switchResult_1 = _parseByte;
          }
        }
        if (!_matched_1) {
          String _simpleName_3 = expectedType==null?(String)null:expectedType.getSimpleName();
          boolean _equals_3 = Objects.equal(_simpleName_3, "float");
          if (_equals_3) {
            _matched_1=true;
            String _value_3 = _xNumberLiteral.getValue();
            long _parseLong_1 = Long.parseLong(_value_3);
            _switchResult_1 = _parseLong_1;
          }
        }
        if (!_matched_1) {
          String _simpleName_4 = expectedType==null?(String)null:expectedType.getSimpleName();
          boolean _equals_4 = Objects.equal(_simpleName_4, "double");
          if (_equals_4) {
            _matched_1=true;
            String _value_4 = _xNumberLiteral.getValue();
            double _parseDouble = Double.parseDouble(_value_4);
            _switchResult_1 = _parseDouble;
          }
        }
        if (!_matched_1) {
          String _value_5 = _xNumberLiteral.getValue();
          int _parseInt = Integer.parseInt(_value_5);
          _switchResult_1 = _parseInt;
        }
        _switchResult = _switchResult_1;
      }
    }
    if (!_matched) {
      if (expression instanceof XTypeLiteral) {
        final XTypeLiteral _xTypeLiteral = (XTypeLiteral)expression;
        _matched=true;
        JvmType _type = _xTypeLiteral.getType();
        _switchResult = _type;
      }
    }
    if (!_matched) {
      if (expression instanceof XAnnotation) {
        final XAnnotation _xAnnotation = (XAnnotation)expression;
        _matched=true;
        _switchResult = _xAnnotation;
      }
    }
    if (!_matched) {
      if (expression instanceof XListLiteral) {
        final XListLiteral _xListLiteral = (XListLiteral)expression;
        _matched=true;
        Object[] _xblockexpression = null;
        {
          EList<XExpression> _elements = _xListLiteral.getElements();
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
              final String _string = (String)_switchValue;
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
              final JvmType _jvmType = (JvmType)_switchValue;
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
              final Integer _integer = (Integer)_switchValue;
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
        final XBinaryOperation _xBinaryOperation = (XBinaryOperation)expression;
        _matched=true;
        XExpression _leftOperand = _xBinaryOperation.getLeftOperand();
        final Object leftVal = this.evaluate(_leftOperand, null);
        XExpression _rightOperand = _xBinaryOperation.getRightOperand();
        final Object rightVal = this.evaluate(_rightOperand, null);
        return this.plus(leftVal, rightVal);
      }
    }
    if (!_matched) {
      if (expression instanceof XAnnotationElementValueBinaryOperation) {
        final XAnnotationElementValueBinaryOperation _xAnnotationElementValueBinaryOperation = (XAnnotationElementValueBinaryOperation)expression;
        _matched=true;
        Object _switchResult_1 = null;
        String _operator = _xAnnotationElementValueBinaryOperation.getOperator();
        final String _switchValue = _operator;
        boolean _matched_1 = false;
        if (!_matched_1) {
          if (Objects.equal(_switchValue,"+")) {
            _matched_1=true;
            XExpression _leftOperand = _xAnnotationElementValueBinaryOperation.getLeftOperand();
            final Object leftVal = this.evaluate(_leftOperand, null);
            XExpression _rightOperand = _xAnnotationElementValueBinaryOperation.getRightOperand();
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
