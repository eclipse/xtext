package org.eclipse.xtend.macro.lang.processing;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.macro.ProcessingContext;
import org.eclipse.xtend.macro.lang.jvmmodel.FunctionAdapter;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.JavaReflectAccess;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.impl.FeatureCallToJavaMapping;
import org.eclipse.xtext.xbase.interpreter.IEvaluationContext;
import org.eclipse.xtext.xbase.interpreter.impl.XbaseInterpreter;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Specialization of the standard Xbase interpreter.
 * Handles some special APIs (e.g. ProcessorContext#type() ) as well as calling dynamic features.
 * 
 * @author Sven Efftinge
 */
@SuppressWarnings("all")
public class MacroInterpreter extends XbaseInterpreter {
  @Inject
  private JavaReflectAccess javaReflectAccess;
  
  @Inject
  private FeatureCallToJavaMapping featureCallToJavaMapping;
  
  /**
   * handles special 'magic' methods from ProcessingContext
   */
  protected Object _invokeFeature(final JvmOperation it, final XAbstractFeatureCall featureCall, final Object receiver, final IEvaluationContext context, final CancelIndicator indicator) {
    Object _xblockexpression = null;
    {
      JvmDeclaredType _declaringType = it.getDeclaringType();
      String _qualifiedName = _declaringType.getQualifiedName();
      String _name = ProcessingContext.class.getName();
      boolean _equals = Objects.equal(_qualifiedName, _name);
      if (_equals) {
        String _simpleName = it.getSimpleName();
        boolean _equals_1 = Objects.equal(_simpleName, "type");
        if (_equals_1) {
          EList<JvmFormalParameter> _parameters = it.getParameters();
          JvmFormalParameter _head = IterableExtensions.<JvmFormalParameter>head(_parameters);
          String _name_1 = _head==null?(String)null:_head.getName();
          boolean _equals_2 = Objects.equal(_name_1, "clazz");
          if (_equals_2) {
            final List<XExpression> arguments = this.featureCallToJavaMapping.getActualArguments(featureCall);
            XExpression _head_1 = IterableExtensions.<XExpression>head(arguments);
            final XExpression clazz = _head_1;
            boolean _matched = false;
            if (!_matched) {
              if (clazz instanceof XTypeLiteral) {
                final XTypeLiteral _xTypeLiteral = (XTypeLiteral)clazz;
                _matched=true;
                Iterable<XExpression> _drop = IterableExtensions.<XExpression>drop(arguments, 1);
                final Function1<XExpression,Object> _function = new Function1<XExpression,Object>() {
                    public Object apply(final XExpression it) {
                      Object _internalEvaluate = MacroInterpreter.this.internalEvaluate(it, context, indicator);
                      return _internalEvaluate;
                    }
                  };
                final Iterable<Object> typerefs = IterableExtensions.<XExpression, Object>map(_drop, _function);
                JvmType _type = _xTypeLiteral.getType();
                return ((ProcessingContext) receiver).type(_type, ((JvmTypeReference[]) ((JvmTypeReference[])Conversions.unwrapArray(typerefs, JvmTypeReference.class))));
              }
            }
          }
          boolean _and = false;
          EList<JvmFormalParameter> _parameters_1 = it.getParameters();
          boolean _isEmpty = _parameters_1.isEmpty();
          if (!_isEmpty) {
            _and = false;
          } else {
            EList<JvmTypeReference> _typeArguments = featureCall.getTypeArguments();
            int _size = _typeArguments.size();
            boolean _equals_3 = (_size == 1);
            _and = (_isEmpty && _equals_3);
          }
          if (_and) {
            EList<JvmTypeReference> _typeArguments_1 = featureCall.getTypeArguments();
            final JvmTypeReference typeArg = IterableExtensions.<JvmTypeReference>head(_typeArguments_1);
            EcoreUtil.resolveAll(typeArg);
            return EcoreUtil2.<JvmTypeReference>clone(typeArg);
          }
        }
      }
      Object __invokeFeature = super._invokeFeature(it, featureCall, receiver, context, indicator);
      _xblockexpression = (__invokeFeature);
    }
    return _xblockexpression;
  }
  
  /**
   * If it's a generic type it is 'this'
   */
  protected Object _invokeFeature(final JvmGenericType identifiable, final XFeatureCall featureCall, final Object receiver, final IEvaluationContext context, final CancelIndicator indicator) {
    QualifiedName _create = QualifiedName.create("this");
    Object _value = context.getValue(_create);
    return _value;
  }
  
  /**
   * handles operations with an attached FunctionAdapter
   */
  protected Object invokeOperation(final JvmOperation operation, final Object receiver, final List<Object> argumentValues) {
    Object _xblockexpression = null;
    {
      Method _method = this.javaReflectAccess.getMethod(operation);
      boolean _equals = Objects.equal(_method, null);
      if (_equals) {
        EList<Adapter> _eAdapters = operation.eAdapters();
        final Adapter adapter = EcoreUtil.getAdapter(_eAdapters, FunctionAdapter.class);
        boolean _matched = false;
        if (!_matched) {
          if (adapter instanceof FunctionAdapter) {
            final FunctionAdapter _functionAdapter = (FunctionAdapter)adapter;
            _matched=true;
            Function1<? super List<Object>,? extends Object> _function = _functionAdapter.getFunction();
            return _function.apply(argumentValues);
          }
        }
      }
      Object _invokeOperation = super.invokeOperation(operation, receiver, argumentValues);
      _xblockexpression = (_invokeOperation);
    }
    return _xblockexpression;
  }
  
  public Object invokeFeature(final JvmIdentifiableElement identifiable, final XAbstractFeatureCall featureCall, final Object receiver, final IEvaluationContext context, final CancelIndicator indicator) {
    if (identifiable instanceof JvmGenericType
         && featureCall instanceof XFeatureCall) {
      return _invokeFeature((JvmGenericType)identifiable, (XFeatureCall)featureCall, receiver, context, indicator);
    } else if (identifiable instanceof JvmOperation
         && featureCall != null) {
      return _invokeFeature((JvmOperation)identifiable, featureCall, receiver, context, indicator);
    } else if (identifiable instanceof JvmField
         && featureCall != null) {
      return _invokeFeature((JvmField)identifiable, featureCall, receiver, context, indicator);
    } else if (identifiable != null
         && featureCall != null) {
      return _invokeFeature(identifiable, featureCall, receiver, context, indicator);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(identifiable, featureCall, receiver, context, indicator).toString());
    }
  }
}
