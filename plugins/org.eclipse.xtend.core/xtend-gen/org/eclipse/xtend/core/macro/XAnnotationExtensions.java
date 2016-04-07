/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.core.macro.ConstantExpressionsInterpreter;
import org.eclipse.xtend.core.xtend.XtendAnnotationTarget;
import org.eclipse.xtend.core.xtend.XtendAnnotationType;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendEnum;
import org.eclipse.xtend.core.xtend.XtendEnumLiteral;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendInterface;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtend.lib.macro.Active;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmCustomAnnotationValue;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeAnnotationValue;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.linking.lazy.LazyURIEncoder;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class XAnnotationExtensions {
  @Inject
  private LazyURIEncoder encoder;
  
  @Inject
  private ILinkingService linkingService;
  
  @Inject
  private ConstantExpressionsInterpreter constantExpressionsInterpreter;
  
  public XtendAnnotationTarget getAnnotatedTarget(final XAnnotation annotation) {
    XtendAnnotationTarget _switchResult = null;
    EObject _eContainer = annotation.eContainer();
    final EObject container = _eContainer;
    boolean _matched = false;
    if (container instanceof XtendAnnotationType) {
      _matched=true;
    }
    if (!_matched) {
      if (container instanceof XtendClass) {
        _matched=true;
      }
    }
    if (!_matched) {
      if (container instanceof XtendInterface) {
        _matched=true;
      }
    }
    if (!_matched) {
      if (container instanceof XtendEnum) {
        _matched=true;
      }
    }
    if (!_matched) {
      if (container instanceof XtendField) {
        _matched=true;
      }
    }
    if (!_matched) {
      if (container instanceof XtendFunction) {
        _matched=true;
      }
    }
    if (!_matched) {
      if (container instanceof XtendConstructor) {
        _matched=true;
      }
    }
    if (!_matched) {
      if (container instanceof XtendEnumLiteral) {
        _matched=true;
      }
    }
    if (!_matched) {
      if (container instanceof XtendParameter) {
        _matched=true;
      }
    }
    if (_matched) {
      _switchResult = ((XtendAnnotationTarget)container);
    }
    if (!_matched) {
      if (container instanceof XtendAnnotationTarget) {
        _matched=true;
        XtendAnnotationTarget _xblockexpression = null;
        {
          final EObject containerContainer = ((XtendAnnotationTarget)container).eContainer();
          XtendAnnotationTarget _xifexpression = null;
          if ((containerContainer instanceof XtendAnnotationTarget)) {
            _xifexpression = ((XtendAnnotationTarget)containerContainer);
          } else {
            _xifexpression = ((XtendAnnotationTarget)container);
          }
          _xblockexpression = _xifexpression;
        }
        _switchResult = _xblockexpression;
      }
    }
    if (!_matched) {
      if (container instanceof XAnnotation) {
        _matched=true;
        _switchResult = this.getAnnotatedTarget(((XAnnotation)container));
      }
    }
    if (!_matched) {
      _switchResult = null;
    }
    return _switchResult;
  }
  
  /**
   * Checks whether this annotation is pointing to a processed annotation, without resolving the proxy
   */
  public boolean isProcessed(final XAnnotation it) {
    Object _eGet = it.eGet(XAnnotationsPackage.Literals.XANNOTATION__ANNOTATION_TYPE, false);
    final Object proxy = _eGet;
    boolean _matched = false;
    if (proxy instanceof EObject) {
      boolean _eIsProxy = ((EObject)proxy).eIsProxy();
      if (_eIsProxy) {
        _matched=true;
        final URI uri = ((InternalEObject) proxy).eProxyURI();
        Resource _eResource = it.eResource();
        String _fragment = uri.fragment();
        boolean _isCrossLinkFragment = this.encoder.isCrossLinkFragment(_eResource, _fragment);
        if (_isCrossLinkFragment) {
          Resource _eResource_1 = it.eResource();
          String _fragment_1 = uri.fragment();
          final Triple<EObject, EReference, INode> triple = this.encoder.decode(_eResource_1, _fragment_1);
          EObject _first = triple.getFirst();
          EReference _second = triple.getSecond();
          INode _third = triple.getThird();
          final List<EObject> candidates = this.linkingService.getLinkedObjects(_first, _second, _third);
          boolean _isEmpty = candidates.isEmpty();
          boolean _not = (!_isEmpty);
          if (_not) {
            final EObject head = IterableExtensions.<EObject>head(candidates);
            if ((head instanceof JvmAnnotationType)) {
              return this.isActiveAnnotation(((JvmAnnotationType)head));
            }
          }
        }
      }
    }
    if (!_matched) {
      if (proxy instanceof JvmAnnotationType) {
        _matched=true;
        return this.isActiveAnnotation(((JvmAnnotationType)proxy));
      }
    }
    return false;
  }
  
  public JvmType getProcessorType(final JvmAnnotationType it) {
    EList<JvmAnnotationReference> _annotations = it.getAnnotations();
    final Function1<JvmAnnotationReference, Boolean> _function = new Function1<JvmAnnotationReference, Boolean>() {
      @Override
      public Boolean apply(final JvmAnnotationReference it) {
        JvmAnnotationType _annotation = it.getAnnotation();
        String _identifier = null;
        if (_annotation!=null) {
          _identifier=_annotation.getIdentifier();
        }
        String _name = Active.class.getName();
        return Boolean.valueOf(Objects.equal(_identifier, _name));
      }
    };
    final JvmAnnotationReference activeAnnotation = IterableExtensions.<JvmAnnotationReference>findFirst(_annotations, _function);
    EList<JvmAnnotationValue> _values = activeAnnotation.getValues();
    final Function1<JvmAnnotationValue, Boolean> _function_1 = new Function1<JvmAnnotationValue, Boolean>() {
      @Override
      public Boolean apply(final JvmAnnotationValue it) {
        boolean _or = false;
        JvmOperation _operation = it.getOperation();
        boolean _equals = Objects.equal(_operation, null);
        if (_equals) {
          _or = true;
        } else {
          JvmOperation _operation_1 = it.getOperation();
          String _simpleName = _operation_1.getSimpleName();
          boolean _equals_1 = Objects.equal(_simpleName, "value");
          _or = _equals_1;
        }
        return Boolean.valueOf(_or);
      }
    };
    final JvmAnnotationValue annoVal = IterableExtensions.<JvmAnnotationValue>findFirst(_values, _function_1);
    boolean _matched = false;
    if (annoVal instanceof JvmTypeAnnotationValue) {
      _matched=true;
      EList<JvmTypeReference> _values_1 = ((JvmTypeAnnotationValue)annoVal).getValues();
      JvmTypeReference _head = IterableExtensions.<JvmTypeReference>head(_values_1);
      JvmType _type = null;
      if (_head!=null) {
        _type=_head.getType();
      }
      return _type;
    }
    if (!_matched) {
      if (annoVal instanceof JvmCustomAnnotationValue) {
        _matched=true;
        EList<EObject> _values_1 = ((JvmCustomAnnotationValue)annoVal).getValues();
        EObject _head = IterableExtensions.<EObject>head(_values_1);
        JvmOperation _operation = ((JvmCustomAnnotationValue)annoVal).getOperation();
        JvmTypeReference _returnType = null;
        if (_operation!=null) {
          _returnType=_operation.getReturnType();
        }
        final Object type = this.constantExpressionsInterpreter.evaluate(((XExpression) _head), _returnType);
        if ((type instanceof JvmTypeReference)) {
          return ((JvmTypeReference)type).getType();
        }
      }
    }
    return null;
  }
  
  public JvmType getProcessorType(final XAnnotation it) {
    JvmAnnotationType _tryFindAnnotationType = this.tryFindAnnotationType(it);
    return this.getProcessorType(_tryFindAnnotationType);
  }
  
  public JvmAnnotationType tryFindAnnotationType(final XAnnotation it) {
    Object _eGet = it.eGet(XAnnotationsPackage.Literals.XANNOTATION__ANNOTATION_TYPE, false);
    final Object proxy = _eGet;
    boolean _matched = false;
    if (proxy instanceof EObject) {
      boolean _eIsProxy = ((EObject)proxy).eIsProxy();
      if (_eIsProxy) {
        _matched=true;
        final URI uri = ((InternalEObject) proxy).eProxyURI();
        Resource _eResource = it.eResource();
        ResourceSet _resourceSet = _eResource.getResourceSet();
        EObject _eObject = _resourceSet.getEObject(uri, true);
        return ((JvmAnnotationType) _eObject);
      }
    }
    if (!_matched) {
      if (proxy instanceof JvmAnnotationType) {
        _matched=true;
        return ((JvmAnnotationType)proxy);
      }
    }
    return null;
  }
  
  protected boolean isActiveAnnotation(final JvmAnnotationType annotationType) {
    EList<JvmAnnotationReference> _annotations = annotationType.getAnnotations();
    for (final JvmAnnotationReference anno : _annotations) {
      JvmAnnotationType _annotation = anno.getAnnotation();
      String _identifier = _annotation.getIdentifier();
      String _name = Active.class.getName();
      boolean _equals = Objects.equal(_identifier, _name);
      if (_equals) {
        return true;
      }
    }
    return false;
  }
}
