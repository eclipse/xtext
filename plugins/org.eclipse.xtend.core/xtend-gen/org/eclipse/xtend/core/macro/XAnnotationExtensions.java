/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
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
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage.Literals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;

@SuppressWarnings("all")
public class XAnnotationExtensions {
  @Inject
  private LazyURIEncoder encoder;
  
  @Inject
  private ILinkingService linkingService;
  
  public XtendAnnotationTarget getAnnotatedTarget(final XAnnotation annotation) {
    XtendAnnotationTarget _switchResult = null;
    EObject _eContainer = annotation.eContainer();
    final EObject container = _eContainer;
    boolean _matched = false;
    if (!_matched) {
      if (container instanceof XtendAnnotationType) {
        final XtendAnnotationType _xtendAnnotationType = (XtendAnnotationType)container;
        _matched=true;
        _switchResult = _xtendAnnotationType;
      }
    }
    if (!_matched) {
      if (container instanceof XtendClass) {
        final XtendClass _xtendClass = (XtendClass)container;
        _matched=true;
        _switchResult = _xtendClass;
      }
    }
    if (!_matched) {
      if (container instanceof XtendInterface) {
        final XtendInterface _xtendInterface = (XtendInterface)container;
        _matched=true;
        _switchResult = _xtendInterface;
      }
    }
    if (!_matched) {
      if (container instanceof XtendEnum) {
        final XtendEnum _xtendEnum = (XtendEnum)container;
        _matched=true;
        _switchResult = _xtendEnum;
      }
    }
    if (!_matched) {
      if (container instanceof XtendField) {
        final XtendField _xtendField = (XtendField)container;
        _matched=true;
        _switchResult = _xtendField;
      }
    }
    if (!_matched) {
      if (container instanceof XtendFunction) {
        final XtendFunction _xtendFunction = (XtendFunction)container;
        _matched=true;
        _switchResult = _xtendFunction;
      }
    }
    if (!_matched) {
      if (container instanceof XtendConstructor) {
        final XtendConstructor _xtendConstructor = (XtendConstructor)container;
        _matched=true;
        _switchResult = _xtendConstructor;
      }
    }
    if (!_matched) {
      if (container instanceof XtendEnumLiteral) {
        final XtendEnumLiteral _xtendEnumLiteral = (XtendEnumLiteral)container;
        _matched=true;
        _switchResult = _xtendEnumLiteral;
      }
    }
    if (!_matched) {
      if (container instanceof XtendParameter) {
        final XtendParameter _xtendParameter = (XtendParameter)container;
        _matched=true;
        _switchResult = _xtendParameter;
      }
    }
    if (!_matched) {
      if (container instanceof XtendAnnotationTarget) {
        final XtendAnnotationTarget _xtendAnnotationTarget = (XtendAnnotationTarget)container;
        _matched=true;
        EObject _eContainer_1 = _xtendAnnotationTarget.eContainer();
        _switchResult = ((XtendAnnotationTarget) _eContainer_1);
      }
    }
    if (!_matched) {
      if (container instanceof XAnnotation) {
        final XAnnotation _xAnnotation = (XAnnotation)container;
        _matched=true;
        XtendAnnotationTarget _annotatedTarget = this.getAnnotatedTarget(_xAnnotation);
        _switchResult = _annotatedTarget;
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
    Object _eGet = it.eGet(Literals.XANNOTATION__ANNOTATION_TYPE, false);
    final Object proxy = _eGet;
    boolean _matched = false;
    if (!_matched) {
      if (proxy instanceof EObject) {
        final EObject _eObject = (EObject)proxy;
        boolean _eIsProxy = _eObject.eIsProxy();
        if (_eIsProxy) {
          _matched=true;
          final URI uri = ((InternalEObject) _eObject).eProxyURI();
          Resource _eResource = it.eResource();
          String _fragment = uri.fragment();
          boolean _isCrossLinkFragment = this.encoder.isCrossLinkFragment(_eResource, _fragment);
          if (_isCrossLinkFragment) {
            Resource _eResource_1 = it.eResource();
            String _fragment_1 = uri.fragment();
            final Triple<EObject,EReference,INode> triple = this.encoder.decode(_eResource_1, _fragment_1);
            EObject _first = triple.getFirst();
            EReference _second = triple.getSecond();
            INode _third = triple.getThird();
            final List<EObject> candidates = this.linkingService.getLinkedObjects(_first, _second, _third);
            boolean _isEmpty = candidates.isEmpty();
            boolean _not = (!_isEmpty);
            if (_not) {
              final EObject head = IterableExtensions.<EObject>head(candidates);
              if ((head instanceof JvmAnnotationType)) {
                return this.isActiveAnnotation(((JvmAnnotationType) head));
              }
            }
          }
        }
      }
    }
    if (!_matched) {
      if (proxy instanceof JvmAnnotationType) {
        final JvmAnnotationType _jvmAnnotationType = (JvmAnnotationType)proxy;
        _matched=true;
        return this.isActiveAnnotation(_jvmAnnotationType);
      }
    }
    return false;
  }
  
  public JvmType getProcessorType(final JvmAnnotationType it) {
    EList<JvmAnnotationReference> _annotations = it.getAnnotations();
    final Function1<JvmAnnotationReference,Boolean> _function = new Function1<JvmAnnotationReference,Boolean>() {
        public Boolean apply(final JvmAnnotationReference it) {
          JvmAnnotationType _annotation = it.getAnnotation();
          String _identifier = _annotation==null?(String)null:_annotation.getIdentifier();
          String _name = Active.class.getName();
          boolean _equals = ObjectExtensions.operator_equals(_identifier, _name);
          return Boolean.valueOf(_equals);
        }
      };
    final JvmAnnotationReference activeAnnotation = IterableExtensions.<JvmAnnotationReference>findFirst(_annotations, _function);
    EList<JvmAnnotationValue> _values = activeAnnotation.getValues();
    final Function1<JvmAnnotationValue,Boolean> _function_1 = new Function1<JvmAnnotationValue,Boolean>() {
        public Boolean apply(final JvmAnnotationValue it) {
          boolean _or = false;
          JvmOperation _operation = it.getOperation();
          boolean _equals = ObjectExtensions.operator_equals(_operation, null);
          if (_equals) {
            _or = true;
          } else {
            JvmOperation _operation_1 = it.getOperation();
            String _simpleName = _operation_1.getSimpleName();
            boolean _equals_1 = ObjectExtensions.operator_equals(_simpleName, "value");
            _or = (_equals || _equals_1);
          }
          return Boolean.valueOf(_or);
        }
      };
    final JvmAnnotationValue annoVal = IterableExtensions.<JvmAnnotationValue>findFirst(_values, _function_1);
    boolean _matched = false;
    if (!_matched) {
      if (annoVal instanceof JvmTypeAnnotationValue) {
        final JvmTypeAnnotationValue _jvmTypeAnnotationValue = (JvmTypeAnnotationValue)annoVal;
        _matched=true;
        EList<JvmTypeReference> _values_1 = _jvmTypeAnnotationValue.getValues();
        JvmTypeReference _head = IterableExtensions.<JvmTypeReference>head(_values_1);
        return _head.getType();
      }
    }
    if (!_matched) {
      if (annoVal instanceof JvmCustomAnnotationValue) {
        final JvmCustomAnnotationValue _jvmCustomAnnotationValue = (JvmCustomAnnotationValue)annoVal;
        _matched=true;
        EList<Object> _values_1 = _jvmCustomAnnotationValue.getValues();
        Object _head = IterableExtensions.<Object>head(_values_1);
        return ((XTypeLiteral) _head).getType();
      }
    }
    return null;
  }
  
  public JvmType getProcessorType(final XAnnotation it) {
    JvmAnnotationType _tryFindAnnotationType = this.tryFindAnnotationType(it);
    return this.getProcessorType(_tryFindAnnotationType);
  }
  
  public JvmAnnotationType tryFindAnnotationType(final XAnnotation it) {
    JvmAnnotationType _switchResult = null;
    Object _eGet = it.eGet(Literals.XANNOTATION__ANNOTATION_TYPE);
    final Object proxy = _eGet;
    boolean _matched = false;
    if (!_matched) {
      if (proxy instanceof EObject) {
        final EObject _eObject = (EObject)proxy;
        boolean _eIsProxy = _eObject.eIsProxy();
        if (_eIsProxy) {
          _matched=true;
          final URI uri = ((InternalEObject) _eObject).eProxyURI();
          Resource _eResource = it.eResource();
          String _fragment = uri.fragment();
          boolean _isCrossLinkFragment = this.encoder.isCrossLinkFragment(_eResource, _fragment);
          if (_isCrossLinkFragment) {
            Resource _eResource_1 = it.eResource();
            String _fragment_1 = uri.fragment();
            final Triple<EObject,EReference,INode> triple = this.encoder.decode(_eResource_1, _fragment_1);
            EObject _first = triple.getFirst();
            EReference _second = triple.getSecond();
            INode _third = triple.getThird();
            final List<EObject> candidates = this.linkingService.getLinkedObjects(_first, _second, _third);
            boolean _isEmpty = candidates.isEmpty();
            boolean _not = (!_isEmpty);
            if (_not) {
              EObject _head = IterableExtensions.<EObject>head(candidates);
              return ((JvmAnnotationType) _head);
            }
          }
          return null;
        }
      }
    }
    if (!_matched) {
      if (proxy instanceof JvmAnnotationType) {
        final JvmAnnotationType _jvmAnnotationType = (JvmAnnotationType)proxy;
        _matched=true;
        return _jvmAnnotationType;
      }
    }
    return _switchResult;
  }
  
  protected boolean isActiveAnnotation(final JvmAnnotationType annotationType) {
    EList<JvmAnnotationReference> _annotations = annotationType.getAnnotations();
    for (final JvmAnnotationReference anno : _annotations) {
      JvmAnnotationType _annotation = anno.getAnnotation();
      String _identifier = _annotation.getIdentifier();
      String _name = Active.class.getName();
      boolean _equals = ObjectExtensions.operator_equals(_identifier, _name);
      if (_equals) {
        return true;
      }
    }
    return false;
  }
}
