/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import com.google.common.base.Preconditions;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.macro.ConditionUtils;
import org.eclipse.xtend.core.macro.declaration.AnnotationReferenceBuildContextImpl;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.JvmAnnotationReferenceImpl;
import org.eclipse.xtend.core.macro.declaration.JvmAnnotationTypeDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.XtendAnnotationTypeDeclarationImpl;
import org.eclipse.xtend.core.xtend.XtendAnnotationType;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.services.AnnotationReferenceBuildContext;
import org.eclipse.xtend.lib.macro.services.AnnotationReferenceProvider;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class AnnotationReferenceProviderImpl implements AnnotationReferenceProvider {
  @Extension
  private CompilationUnitImpl compilationUnit;
  
  public AnnotationReferenceProviderImpl(final CompilationUnitImpl compilationUnit) {
    this.compilationUnit = compilationUnit;
  }
  
  @Override
  public AnnotationReference newAnnotationReference(final String annotationTypeName) {
    final Procedure1<AnnotationReferenceBuildContext> _function = (AnnotationReferenceBuildContext it) -> {
    };
    return this.newAnnotationReference(annotationTypeName, _function);
  }
  
  @Override
  public AnnotationReference newAnnotationReference(final Type annotationTypeDelcaration) {
    final Procedure1<AnnotationReferenceBuildContext> _function = (AnnotationReferenceBuildContext it) -> {
    };
    return this.newAnnotationReference(annotationTypeDelcaration, _function);
  }
  
  @Override
  public AnnotationReference newAnnotationReference(final Class<?> annotationClass) {
    final Procedure1<AnnotationReferenceBuildContext> _function = (AnnotationReferenceBuildContext it) -> {
    };
    return this.newAnnotationReference(annotationClass, _function);
  }
  
  @Override
  public AnnotationReference newAnnotationReference(final AnnotationReference annotationReference) {
    final Procedure1<AnnotationReferenceBuildContext> _function = (AnnotationReferenceBuildContext it) -> {
    };
    return this.newAnnotationReference(annotationReference, _function);
  }
  
  @Override
  public AnnotationReference newAnnotationReference(final String annotationTypeName, final Procedure1<AnnotationReferenceBuildContext> initializer) {
    AnnotationReference _xblockexpression = null;
    {
      this.compilationUnit.checkCanceled();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("annotationTypeName cannot be null");
      Preconditions.checkArgument((annotationTypeName != null), _builder);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("initializer cannot be null");
      Preconditions.checkArgument((initializer != null), _builder_1);
      TypeReferences _typeReferences = this.compilationUnit.getTypeReferences();
      XtendFile _xtendFile = this.compilationUnit.getXtendFile();
      JvmType _findDeclaredType = _typeReferences.findDeclaredType(annotationTypeName, _xtendFile);
      final JvmAnnotationReference jvmAnnotationReference = this.createJvmAnnotationReference(_findDeclaredType);
      if ((jvmAnnotationReference == null)) {
        return null;
      }
      AnnotationReferenceBuildContextImpl _annotationReferenceBuildContextImpl = new AnnotationReferenceBuildContextImpl();
      final Procedure1<AnnotationReferenceBuildContextImpl> _function = (AnnotationReferenceBuildContextImpl it) -> {
        it.setDelegate(jvmAnnotationReference);
        it.setCompilationUnit(this.compilationUnit);
      };
      final AnnotationReferenceBuildContextImpl buildContext = ObjectExtensions.<AnnotationReferenceBuildContextImpl>operator_doubleArrow(_annotationReferenceBuildContextImpl, _function);
      initializer.apply(buildContext);
      _xblockexpression = this.compilationUnit.toAnnotationReference(jvmAnnotationReference);
    }
    return _xblockexpression;
  }
  
  @Override
  public AnnotationReference newAnnotationReference(final Type annotationTypeDelcaration, final Procedure1<AnnotationReferenceBuildContext> initializer) {
    Object _xblockexpression = null;
    {
      this.compilationUnit.checkCanceled();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("annotationTypeDelcaration cannot be null");
      Preconditions.checkArgument((annotationTypeDelcaration != null), _builder);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("initializer cannot be null");
      Preconditions.checkArgument((initializer != null), _builder_1);
      JvmDeclaredType _switchResult = null;
      boolean _matched = false;
      if (annotationTypeDelcaration instanceof JvmAnnotationTypeDeclarationImpl) {
        _matched=true;
        _switchResult = ((JvmAnnotationTypeDeclarationImpl)annotationTypeDelcaration).getDelegate();
      }
      if (!_matched) {
        if (annotationTypeDelcaration instanceof XtendAnnotationTypeDeclarationImpl) {
          _matched=true;
          IXtendJvmAssociations _jvmModelAssociations = this.compilationUnit.getJvmModelAssociations();
          XtendAnnotationType _delegate = ((XtendAnnotationTypeDeclarationImpl)annotationTypeDelcaration).getDelegate();
          _switchResult = _jvmModelAssociations.getInferredType(_delegate);
        }
      }
      if (!_matched) {
        throw new IllegalArgumentException(("couldn\'t construct type reference for type " + annotationTypeDelcaration));
      }
      final JvmDeclaredType type = _switchResult;
      if ((type instanceof JvmAnnotationType)) {
        final JvmAnnotationReference newJvmAnnotationReference = this.createJvmAnnotationReference(type);
        AnnotationReferenceBuildContextImpl _annotationReferenceBuildContextImpl = new AnnotationReferenceBuildContextImpl();
        final Procedure1<AnnotationReferenceBuildContextImpl> _function = (AnnotationReferenceBuildContextImpl it) -> {
          it.setDelegate(newJvmAnnotationReference);
          it.setCompilationUnit(this.compilationUnit);
        };
        final AnnotationReferenceBuildContextImpl buildContext = ObjectExtensions.<AnnotationReferenceBuildContextImpl>operator_doubleArrow(_annotationReferenceBuildContextImpl, _function);
        initializer.apply(buildContext);
        return this.compilationUnit.toAnnotationReference(newJvmAnnotationReference);
      }
      _xblockexpression = null;
    }
    return ((AnnotationReference)_xblockexpression);
  }
  
  @Override
  public AnnotationReference newAnnotationReference(final Class<?> annotationClass, final Procedure1<AnnotationReferenceBuildContext> initializer) {
    AnnotationReference _xblockexpression = null;
    {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("annotationClass cannot be null");
      Preconditions.checkArgument((annotationClass != null), _builder);
      String _name = annotationClass.getName();
      _xblockexpression = this.newAnnotationReference(_name, initializer);
    }
    return _xblockexpression;
  }
  
  @Override
  public AnnotationReference newAnnotationReference(final AnnotationReference annotationReference, final Procedure1<AnnotationReferenceBuildContext> initializer) {
    Object _xblockexpression = null;
    {
      this.compilationUnit.checkCanceled();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("annotationReference cannot be null");
      Preconditions.checkArgument((annotationReference != null), _builder);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("initializer cannot be null");
      Preconditions.checkArgument((initializer != null), _builder_1);
      if ((annotationReference instanceof JvmAnnotationReferenceImpl)) {
        final JvmAnnotationReference baseJvmAnnotationReference = ((JvmAnnotationReferenceImpl)annotationReference).getDelegate();
        ConditionUtils.notRemoved(baseJvmAnnotationReference, "annotationReference");
        JvmAnnotationType _annotation = baseJvmAnnotationReference.getAnnotation();
        final JvmAnnotationReference newJvmAnnotationReference = this.createJvmAnnotationReference(_annotation);
        AnnotationReferenceBuildContextImpl _annotationReferenceBuildContextImpl = new AnnotationReferenceBuildContextImpl();
        final Procedure1<AnnotationReferenceBuildContextImpl> _function = (AnnotationReferenceBuildContextImpl it) -> {
          it.setDelegate(newJvmAnnotationReference);
          it.setCompilationUnit(this.compilationUnit);
        };
        final AnnotationReferenceBuildContextImpl buildContext = ObjectExtensions.<AnnotationReferenceBuildContextImpl>operator_doubleArrow(_annotationReferenceBuildContextImpl, _function);
        EList<JvmAnnotationValue> _explicitValues = baseJvmAnnotationReference.getExplicitValues();
        final Function1<JvmAnnotationValue, String> _function_1 = (JvmAnnotationValue it) -> {
          String _elvis = null;
          String _valueName = it.getValueName();
          if (_valueName != null) {
            _elvis = _valueName;
          } else {
            _elvis = "value";
          }
          return _elvis;
        };
        List<String> _map = ListExtensions.<JvmAnnotationValue, String>map(_explicitValues, _function_1);
        for (final String valueName : _map) {
          {
            final Object value = ((JvmAnnotationReferenceImpl)annotationReference).getValue(valueName);
            buildContext.set(valueName, value);
          }
        }
        initializer.apply(buildContext);
        return this.compilationUnit.toAnnotationReference(newJvmAnnotationReference);
      }
      _xblockexpression = null;
    }
    return ((AnnotationReference)_xblockexpression);
  }
  
  protected boolean isArrayOfAnnotations(final JvmAnnotationValue annotationValue) {
    JvmOperation _operation = annotationValue.getOperation();
    final JvmTypeReference returnType = _operation.getReturnType();
    if ((returnType instanceof JvmGenericArrayTypeReference)) {
      JvmTypeReference _componentType = ((JvmGenericArrayTypeReference)returnType).getComponentType();
      JvmType _type = _componentType.getType();
      return (_type instanceof JvmAnnotationType);
    }
    return false;
  }
  
  protected JvmAnnotationReference createJvmAnnotationReference(final JvmType type) {
    JvmAnnotationReference _switchResult = null;
    boolean _matched = false;
    if (type instanceof JvmAnnotationType) {
      _matched=true;
      JvmAnnotationReference _createJvmAnnotationReference = TypesFactory.eINSTANCE.createJvmAnnotationReference();
      final Procedure1<JvmAnnotationReference> _function = (JvmAnnotationReference it) -> {
        it.setAnnotation(((JvmAnnotationType)type));
      };
      _switchResult = ObjectExtensions.<JvmAnnotationReference>operator_doubleArrow(_createJvmAnnotationReference, _function);
    }
    if (!_matched) {
      _switchResult = null;
    }
    return _switchResult;
  }
}
