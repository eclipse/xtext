/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.macro.lang.processing;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.macro.ProcessingContext;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmBooleanAnnotationValue;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmIntAnnotationValue;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmStringAnnotationValue;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeAnnotationValue;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.validation.EObjectDiagnosticImpl;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * Basic implementation of processing context.
 * 
 * Some methods might not be implemented here, but in the MacroInterpreter.
 * 
 * @author Sven Efftinge
 */
@SuppressWarnings("all")
public class ProcessingContextImpl implements ProcessingContext {
  private JvmTypesBuilder _typesBuilder;
  
  public JvmTypesBuilder getTypesBuilder() {
    return this._typesBuilder;
  }
  
  public void setTypesBuilder(final JvmTypesBuilder typesBuilder) {
    this._typesBuilder = typesBuilder;
  }
  
  private XtendFile _source;
  
  public XtendFile getSource() {
    return this._source;
  }
  
  public void setSource(final XtendFile source) {
    this._source = source;
  }
  
  private Stack<JvmIdentifiableElement> currentContainer = new Function0<Stack<JvmIdentifiableElement>>() {
    public Stack<JvmIdentifiableElement> apply() {
      Stack<JvmIdentifiableElement> _stack = new Stack<JvmIdentifiableElement>();
      return _stack;
    }
  }.apply();
  
  public JvmDeclaredType with(final String name, final Procedure1<JvmGenericType> initializer) {
    XtendFile _source = this.getSource();
    Resource _eResource = _source.eResource();
    EList<EObject> _contents = _eResource.getContents();
    Iterable<JvmGenericType> _filter = Iterables.<JvmGenericType>filter(_contents, JvmGenericType.class);
    final Function1<JvmGenericType,Boolean> _function = new Function1<JvmGenericType,Boolean>() {
        public Boolean apply(final JvmGenericType it) {
          String _qualifiedName = it.getQualifiedName();
          boolean _equals = Objects.equal(_qualifiedName, name);
          return Boolean.valueOf(_equals);
        }
      };
    final JvmGenericType type = IterableExtensions.<JvmGenericType>findFirst(_filter, _function);
    try {
      this.currentContainer.push(type);
      initializer.apply(type);
    } finally {
      this.currentContainer.pop();
    }
    return type;
  }
  
  public JvmField field(final String name, final JvmTypeReference type) {
    JvmIdentifiableElement _peek = this.currentContainer.peek();
    final JvmGenericType declararator = ((JvmGenericType) _peek);
    JvmTypesBuilder _typesBuilder = this.getTypesBuilder();
    XtendFile _source = this.getSource();
    final JvmField result = _typesBuilder.toField(_source, name, type, null);
    EList<JvmMember> _members = declararator.getMembers();
    _members.add(result);
    return result;
  }
  
  public JvmOperation method(final String name, final JvmTypeReference returnType, final Procedure1<JvmOperation> initializer) {
    JvmIdentifiableElement _peek = this.currentContainer.peek();
    final JvmGenericType declararator = ((JvmGenericType) _peek);
    JvmTypesBuilder _typesBuilder = this.getTypesBuilder();
    XtendFile _source = this.getSource();
    final JvmOperation result = _typesBuilder.toMethod(_source, name, returnType, null);
    EList<JvmMember> _members = declararator.getMembers();
    _members.add(result);
    try {
      this.currentContainer.push(result);
      initializer.apply(result);
    } finally {
      this.currentContainer.pop();
    }
    return result;
  }
  
  public JvmConstructor constructor(final Procedure1<JvmConstructor> initializer) {
    JvmIdentifiableElement _peek = this.currentContainer.peek();
    final JvmGenericType declararator = ((JvmGenericType) _peek);
    JvmTypesBuilder _typesBuilder = this.getTypesBuilder();
    XtendFile _source = this.getSource();
    final JvmConstructor result = _typesBuilder.toConstructor(_source, null);
    EList<JvmMember> _members = declararator.getMembers();
    _members.add(result);
    try {
      this.currentContainer.push(result);
      initializer.apply(result);
    } finally {
      this.currentContainer.pop();
    }
    return result;
  }
  
  public JvmFormalParameter param(final String name, final JvmTypeReference type) {
    JvmIdentifiableElement _peek = this.currentContainer.peek();
    final JvmExecutable declarator = ((JvmExecutable) _peek);
    JvmTypesBuilder _typesBuilder = this.getTypesBuilder();
    XtendFile _source = this.getSource();
    final JvmFormalParameter result = _typesBuilder.toParameter(_source, name, type);
    EList<JvmFormalParameter> _parameters = declarator.getParameters();
    _parameters.add(result);
    return result;
  }
  
  public <T extends Object, RETURN_TYPE extends Object> XExpression reify(final Function1<T,RETURN_TYPE> expression) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("implemented in interpreter");
    throw _unsupportedOperationException;
  }
  
  public <T extends Object> T result(final XExpression expression) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("implemented in interpreter");
    throw _unsupportedOperationException;
  }
  
  public <T extends Object> JvmTypeReference type() {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("implemented in interpreter");
    throw _unsupportedOperationException;
  }
  
  public JvmTypeReference type(final JvmType typeDeclaration, final JvmTypeReference... typeRef) {
    JvmTypesBuilder _typesBuilder = this.getTypesBuilder();
    JvmTypeReference _newTypeRef = _typesBuilder.newTypeRef(typeDeclaration, typeRef);
    return _newTypeRef;
  }
  
  public JvmTypeReference type(final Class<? extends Object> clazz, final JvmTypeReference... typeRef) {
    JvmTypesBuilder _typesBuilder = this.getTypesBuilder();
    XtendFile _source = this.getSource();
    JvmTypeReference _newTypeRef = _typesBuilder.newTypeRef(_source, clazz, typeRef);
    return _newTypeRef;
  }
  
  public JvmTypeReference type(final String name, final JvmTypeReference... typeRef) {
    XtendFile _source = this.getSource();
    Resource _eResource = _source.eResource();
    EList<EObject> _contents = _eResource.getContents();
    Iterable<JvmDeclaredType> _filter = Iterables.<JvmDeclaredType>filter(_contents, JvmDeclaredType.class);
    final Function1<JvmDeclaredType,Boolean> _function = new Function1<JvmDeclaredType,Boolean>() {
        public Boolean apply(final JvmDeclaredType type) {
          String _identifier = type.getIdentifier();
          boolean _equals = Objects.equal(name, _identifier);
          return Boolean.valueOf(_equals);
        }
      };
    final JvmDeclaredType local = IterableExtensions.<JvmDeclaredType>findFirst(_filter, _function);
    boolean _notEquals = (!Objects.equal(local, null));
    if (_notEquals) {
      JvmTypesBuilder _typesBuilder = this.getTypesBuilder();
      return _typesBuilder.newTypeRef(local, typeRef);
    }
    JvmTypesBuilder _typesBuilder_1 = this.getTypesBuilder();
    XtendFile _source_1 = this.getSource();
    return _typesBuilder_1.newTypeRef(_source_1, name, typeRef);
  }
  
  public void error(final Object target, final String message) {
    boolean _matched = false;
    if (!_matched) {
      if (target instanceof EObject) {
        final EObject _eObject = (EObject)target;
        _matched=true;
        Resource _eResource = _eObject.eResource();
        EList<Diagnostic> _errors = _eResource.getErrors();
        int _minus = (-1);
        EObjectDiagnosticImpl _eObjectDiagnosticImpl = new EObjectDiagnosticImpl(Severity.ERROR, "macro_error", message, _eObject, null, _minus, null);
        _errors.add(_eObjectDiagnosticImpl);
      }
    }
    if (!_matched) {
      IllegalArgumentException _illegalArgumentException = new IllegalArgumentException("Only EObjects are supported atm.");
      throw _illegalArgumentException;
    }
  }
  
  public void warning(final Object target, final String message) {
    boolean _matched = false;
    if (!_matched) {
      if (target instanceof EObject) {
        final EObject _eObject = (EObject)target;
        _matched=true;
        Resource _eResource = _eObject.eResource();
        EList<Diagnostic> _errors = _eResource.getErrors();
        int _minus = (-1);
        EObjectDiagnosticImpl _eObjectDiagnosticImpl = new EObjectDiagnosticImpl(Severity.ERROR, "macro_error", message, _eObject, null, _minus, null);
        _errors.add(_eObjectDiagnosticImpl);
      }
    }
    if (!_matched) {
      IllegalArgumentException _illegalArgumentException = new IllegalArgumentException("Only EObjects are supported atm.");
      throw _illegalArgumentException;
    }
  }
  
  public JvmAnnotationReference annotate(final JvmTypeReference reference, final Map<String,Object> values) {
    JvmType _type = reference==null?(JvmType)null:reference.getType();
    boolean _not = (!(_type instanceof JvmAnnotationType));
    if (_not) {
      JvmType _type_1 = reference==null?(JvmType)null:reference.getType();
      String _identifier = _type_1==null?(String)null:_type_1.getIdentifier();
      String _plus = ("Reference must point to an annotation type but was " + _identifier);
      IllegalArgumentException _illegalArgumentException = new IllegalArgumentException(_plus);
      throw _illegalArgumentException;
    }
    JvmType _type_2 = reference.getType();
    final JvmAnnotationType annotationType = ((JvmAnnotationType) _type_2);
    final JvmAnnotationReference result = TypesFactory.eINSTANCE.createJvmAnnotationReference();
    result.setAnnotation(annotationType);
    boolean _notEquals = (!Objects.equal(values, null));
    if (_notEquals) {
      Set<Entry<String,Object>> _entrySet = values.entrySet();
      for (final Entry<String,Object> entry : _entrySet) {
        {
          Iterable<JvmFeature> _allFeatures = annotationType.getAllFeatures();
          Iterable<JvmOperation> _filter = Iterables.<JvmOperation>filter(_allFeatures, JvmOperation.class);
          final Function1<JvmOperation,Boolean> _function = new Function1<JvmOperation,Boolean>() {
              public Boolean apply(final JvmOperation it) {
                String _simpleName = it.getSimpleName();
                String _key = entry.getKey();
                boolean _equals = Objects.equal(_simpleName, _key);
                return Boolean.valueOf(_equals);
              }
            };
          final JvmOperation feature = IterableExtensions.<JvmOperation>findFirst(_filter, _function);
          Object _value = entry.getValue();
          final Object value = _value;
          boolean _matched = false;
          if (!_matched) {
            if (value instanceof String) {
              final String _string = (String)value;
              _matched=true;
              final JvmStringAnnotationValue annotationValue = TypesFactory.eINSTANCE.createJvmStringAnnotationValue();
              EList<String> _values = annotationValue.getValues();
              _values.add(_string);
              annotationValue.setOperation(feature);
            }
          }
          if (!_matched) {
            if (value instanceof Boolean) {
              final Boolean _boolean = (Boolean)value;
              _matched=true;
              final JvmBooleanAnnotationValue annotationValue = TypesFactory.eINSTANCE.createJvmBooleanAnnotationValue();
              EList<Boolean> _values = annotationValue.getValues();
              _values.add(_boolean);
              annotationValue.setOperation(feature);
            }
          }
          if (!_matched) {
            if (value instanceof Integer) {
              final Integer _integer = (Integer)value;
              _matched=true;
              final JvmIntAnnotationValue annotationValue = TypesFactory.eINSTANCE.createJvmIntAnnotationValue();
              EList<Integer> _values = annotationValue.getValues();
              _values.add(_integer);
              annotationValue.setOperation(feature);
            }
          }
          if (!_matched) {
            if (value instanceof JvmTypeReference) {
              final JvmTypeReference _jvmTypeReference = (JvmTypeReference)value;
              _matched=true;
              final JvmTypeAnnotationValue annotationValue = TypesFactory.eINSTANCE.createJvmTypeAnnotationValue();
              EList<JvmTypeReference> _values = annotationValue.getValues();
              _values.add(_jvmTypeReference);
              annotationValue.setOperation(feature);
            }
          }
          if (!_matched) {
            String _key = entry.getKey();
            String _plus_1 = ("Annotation value must either be a String, Boolean, Integer, or JvmTypeReference (Class). Was " + _key);
            String _plus_2 = (_plus_1 + " -> ");
            Object _value_1 = entry.getValue();
            String _plus_3 = (_plus_2 + _value_1);
            String _plus_4 = (_plus_3 + ".");
            IllegalArgumentException _illegalArgumentException_1 = new IllegalArgumentException(_plus_4);
            throw _illegalArgumentException_1;
          }
        }
      }
    }
    return result;
  }
}
