package org.eclipse.xtend.core.jvmmodel.annotationprocessing;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.jvmmodel.annotationprocessing.IAnnotationProcessor;
import org.eclipse.xtend.core.xtend.XtendAnnotationType;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtext.common.types.JvmAnnotationTarget;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.interpreter.impl.DefaultEvaluationContext;
import org.eclipse.xtext.xbase.interpreter.impl.XbaseInterpreter;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class AnnotationProcesser implements IAnnotationProcessor {
  @Inject
  private IXtendJvmAssociations associations;
  
  @Inject
  private XbaseInterpreter interpreter;
  
  public void process(final XAnnotation annotation, final Iterable<? extends JvmAnnotationTarget> elements, final CancelIndicator cancelIndicator) {
    boolean _equals = Objects.equal(annotation, null);
    if (_equals) {
      return;
    }
    XtendAnnotationType _xtendAnnotationType = this.getXtendAnnotationType(annotation);
    final Procedure1<XtendAnnotationType> _function = new Procedure1<XtendAnnotationType>() {
        public void apply(final XtendAnnotationType it) {
          boolean _or = false;
          boolean _equals = Objects.equal(it, null);
          if (_equals) {
            _or = true;
          } else {
            XtendFunction _processingFunction = AnnotationProcesser.this.getProcessingFunction(it);
            boolean _equals_1 = Objects.equal(_processingFunction, null);
            _or = (_equals || _equals_1);
          }
          if (_or) {
            return;
          }
          DefaultEvaluationContext _defaultEvaluationContext = new DefaultEvaluationContext();
          final DefaultEvaluationContext ctx = _defaultEvaluationContext;
          try {
            XtendFunction _processingFunction_1 = AnnotationProcesser.this.getProcessingFunction(it);
            XExpression _expression = _processingFunction_1.getExpression();
            AnnotationProcesser.this.interpreter.evaluate(_expression, ctx, cancelIndicator);
          } catch (final Throwable _t) {
            if (_t instanceof Exception) {
              final Exception e = (Exception)_t;
              e.printStackTrace();
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
        }
      };
    ObjectExtensions.<XtendAnnotationType>operator_doubleArrow(_xtendAnnotationType, _function);
  }
  
  protected XtendFunction getProcessingFunction(final XtendAnnotationType annotationType) {
    EList<XtendMember> _members = annotationType==null?(EList<XtendMember>)null:annotationType.getMembers();
    Iterable<XtendFunction> _filter = _members==null?(Iterable<XtendFunction>)null:Iterables.<XtendFunction>filter(_members, XtendFunction.class);
    XtendFunction _head = IterableExtensions.<XtendFunction>head(_filter);
    return _head;
  }
  
  protected XtendAnnotationType getXtendAnnotationType(final XAnnotation annotation) {
    XtendAnnotationType _xblockexpression = null;
    {
      JvmAnnotationType _annotationType = annotation.getAnnotationType();
      boolean _equals = Objects.equal(_annotationType, null);
      if (_equals) {
        return null;
      }
      XtendAnnotationType _switchResult = null;
      JvmAnnotationType _annotationType_1 = annotation.getAnnotationType();
      EObject _primarySourceElement = this.associations.getPrimarySourceElement(_annotationType_1);
      final EObject ele = _primarySourceElement;
      boolean _matched = false;
      if (!_matched) {
        if (ele instanceof XtendAnnotationType) {
          final XtendAnnotationType _xtendAnnotationType = (XtendAnnotationType)ele;
          _matched=true;
          _switchResult = _xtendAnnotationType;
        }
      }
      if (!_matched) {
        _switchResult = null;
      }
      _xblockexpression = (_switchResult);
    }
    return _xblockexpression;
  }
}
