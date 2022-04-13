/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.macro.declaration;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.AnnotationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.EnumerationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.InterfaceDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableAnnotationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableEnumerationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableInterfaceDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.services.SourceTypeLookup;
import org.eclipse.xtend.lib.macro.services.TypeLookup;
import org.eclipse.xtend.lib.macro.services.UpstreamTypeLookup;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xtype.XtypePackage;

@SuppressWarnings("all")
public class TypeLookupImpl implements TypeLookup, SourceTypeLookup, UpstreamTypeLookup {
  @Extension
  private CompilationUnitImpl compilationUnit;

  public TypeLookupImpl(final CompilationUnitImpl compilationUnit) {
    this.compilationUnit = compilationUnit;
  }

  @Override
  public MutableAnnotationTypeDeclaration findAnnotationType(final String qualifiedName) {
    final Type type = this.findType(qualifiedName);
    MutableAnnotationTypeDeclaration _switchResult = null;
    boolean _matched = false;
    if (type instanceof MutableAnnotationTypeDeclaration) {
      _matched=true;
      _switchResult = ((MutableAnnotationTypeDeclaration)type);
    }
    return _switchResult;
  }

  @Override
  public MutableClassDeclaration findClass(final String qualifiedName) {
    final Type type = this.findType(qualifiedName);
    MutableClassDeclaration _switchResult = null;
    boolean _matched = false;
    if (type instanceof MutableClassDeclaration) {
      _matched=true;
      _switchResult = ((MutableClassDeclaration)type);
    }
    return _switchResult;
  }

  @Override
  public MutableEnumerationTypeDeclaration findEnumerationType(final String qualifiedName) {
    final Type type = this.findType(qualifiedName);
    MutableEnumerationTypeDeclaration _switchResult = null;
    boolean _matched = false;
    if (type instanceof MutableEnumerationTypeDeclaration) {
      _matched=true;
      _switchResult = ((MutableEnumerationTypeDeclaration)type);
    }
    return _switchResult;
  }

  @Override
  public MutableInterfaceDeclaration findInterface(final String qualifiedName) {
    final Type type = this.findType(qualifiedName);
    MutableInterfaceDeclaration _switchResult = null;
    boolean _matched = false;
    if (type instanceof MutableInterfaceDeclaration) {
      _matched=true;
      _switchResult = ((MutableInterfaceDeclaration)type);
    }
    return _switchResult;
  }

  private Type findType(final String qualifiedName) {
    final Function1<JvmDeclaredType, String> _function = (JvmDeclaredType type) -> {
      return type.getQualifiedName('.');
    };
    final Function1<JvmDeclaredType, Iterable<? extends JvmDeclaredType>> _function_1 = (JvmDeclaredType type) -> {
      return Iterables.<JvmDeclaredType>filter(type.getMembers(), JvmDeclaredType.class);
    };
    final JvmDeclaredType result = this.<JvmDeclaredType>recursiveFindType(qualifiedName, 
      Iterables.<JvmDeclaredType>filter(this.compilationUnit.getXtendFile().eResource().getContents(), JvmDeclaredType.class), _function, _function_1);
    Type _xifexpression = null;
    if ((result != null)) {
      _xifexpression = this.compilationUnit.toType(result);
    }
    return _xifexpression;
  }

  @Override
  public ClassDeclaration findSourceClass(final String qualifiedName) {
    final XtendTypeDeclarationImpl<? extends XtendTypeDeclaration> type = this.findSourceType(qualifiedName);
    XtendTypeDeclarationImpl<? extends XtendTypeDeclaration> _switchResult = null;
    boolean _matched = false;
    if (type instanceof ClassDeclaration) {
      _matched=true;
      _switchResult = ((XtendTypeDeclarationImpl<? extends XtendTypeDeclaration>)type);
    }
    return ((ClassDeclaration)_switchResult);
  }

  @Override
  public InterfaceDeclaration findSourceInterface(final String qualifiedName) {
    final XtendTypeDeclarationImpl<? extends XtendTypeDeclaration> type = this.findSourceType(qualifiedName);
    XtendTypeDeclarationImpl<? extends XtendTypeDeclaration> _switchResult = null;
    boolean _matched = false;
    if (type instanceof InterfaceDeclaration) {
      _matched=true;
      _switchResult = ((XtendTypeDeclarationImpl<? extends XtendTypeDeclaration>)type);
    }
    return ((InterfaceDeclaration)_switchResult);
  }

  @Override
  public EnumerationTypeDeclaration findSourceEnumerationType(final String qualifiedName) {
    final XtendTypeDeclarationImpl<? extends XtendTypeDeclaration> type = this.findSourceType(qualifiedName);
    XtendTypeDeclarationImpl<? extends XtendTypeDeclaration> _switchResult = null;
    boolean _matched = false;
    if (type instanceof EnumerationTypeDeclaration) {
      _matched=true;
      _switchResult = ((XtendTypeDeclarationImpl<? extends XtendTypeDeclaration>)type);
    }
    return ((EnumerationTypeDeclaration)_switchResult);
  }

  @Override
  public AnnotationTypeDeclaration findSourceAnnotationType(final String qualifiedName) {
    final XtendTypeDeclarationImpl<? extends XtendTypeDeclaration> type = this.findSourceType(qualifiedName);
    XtendTypeDeclarationImpl<? extends XtendTypeDeclaration> _switchResult = null;
    boolean _matched = false;
    if (type instanceof AnnotationTypeDeclaration) {
      _matched=true;
      _switchResult = ((XtendTypeDeclarationImpl<? extends XtendTypeDeclaration>)type);
    }
    return ((AnnotationTypeDeclaration)_switchResult);
  }

  private XtendTypeDeclarationImpl<? extends XtendTypeDeclaration> findSourceType(final String qualifiedName) {
    EObject _head = IterableExtensions.<EObject>head(this.compilationUnit.getXtendFile().eResource().getContents());
    final Function1<XtendTypeDeclaration, String> _function = (XtendTypeDeclaration type) -> {
      return this.compilationUnit.getQualifiedNameConverter().toString(this.compilationUnit.getQualifiedNameProvider().getFullyQualifiedName(type));
    };
    final Function1<XtendTypeDeclaration, Iterable<? extends XtendTypeDeclaration>> _function_1 = (XtendTypeDeclaration type) -> {
      return Iterables.<XtendTypeDeclaration>filter(type.getMembers(), XtendTypeDeclaration.class);
    };
    final XtendTypeDeclaration result = this.<XtendTypeDeclaration>recursiveFindType(qualifiedName, 
      ((XtendFile) _head).getXtendTypes(), _function, _function_1);
    XtendTypeDeclarationImpl<? extends XtendTypeDeclaration> _xifexpression = null;
    if ((result != null)) {
      _xifexpression = this.compilationUnit.toXtendTypeDeclaration(result);
    }
    return _xifexpression;
  }

  private <T extends Object> T recursiveFindType(final String qualifiedName, final Iterable<? extends T> typeDeclarations, final Function1<? super T, ? extends String> qualifiedNameProvider, final Function1<? super T, ? extends Iterable<? extends T>> subTypeProvider) {
    final char dot = '.';
    for (final T type : typeDeclarations) {
      {
        final String name = qualifiedNameProvider.apply(type);
        boolean _equals = Objects.equal(qualifiedName, name);
        if (_equals) {
          return type;
        }
        if ((qualifiedName.startsWith(name) && (qualifiedName.charAt(name.length()) == dot))) {
          return this.<T>recursiveFindType(qualifiedName, subTypeProvider.apply(type), qualifiedNameProvider, subTypeProvider);
        }
      }
    }
    return null;
  }

  @Override
  public Type findTypeGlobally(final Class<?> clazz) {
    return this.findTypeGlobally(clazz.getCanonicalName());
  }

  @Override
  public Type findTypeGlobally(final String typeName) {
    Type _elvis = null;
    Type _findType = this.findType(typeName);
    if (_findType != null) {
      _elvis = _findType;
    } else {
      final Function1<IEObjectDescription, Boolean> _function = (IEObjectDescription it) -> {
        return Boolean.valueOf(true);
      };
      Type _findTypeOnScope = this.findTypeOnScope(typeName, _function);
      _elvis = _findTypeOnScope;
    }
    return _elvis;
  }

  @Override
  public Type findUpstreamType(final Class<?> clazz) {
    return this.findUpstreamType(clazz.getCanonicalName());
  }

  @Override
  public Type findUpstreamType(final String typeName) {
    final Function1<IEObjectDescription, Boolean> _function = (IEObjectDescription it) -> {
      Resource _eResource = it.getEObjectOrProxy().eResource();
      Resource _eResource_1 = this.compilationUnit.getXtendFile().eResource();
      return Boolean.valueOf((!Objects.equal(_eResource, _eResource_1)));
    };
    return this.findTypeOnScope(typeName, _function);
  }

  private Type findTypeOnScope(final String typeName, final Function1<? super IEObjectDescription, ? extends Boolean> filter) {
    final QualifiedName qualifiedName = this.compilationUnit.getQualifiedNameConverter().toQualifiedName(typeName);
    final IEObjectDescription result = this.compilationUnit.getScopeProvider().getScope(this.compilationUnit.getXtendFile(), XtypePackage.Literals.XIMPORT_DECLARATION__IMPORTED_TYPE).getSingleElement(qualifiedName);
    if ((((result != null) && TypesPackage.Literals.JVM_TYPE.isSuperTypeOf(result.getEClass())) && (filter.apply(result)).booleanValue())) {
      EObject _eObjectOrProxy = result.getEObjectOrProxy();
      return this.compilationUnit.toType(((JvmType) _eObjectOrProxy));
    }
    return null;
  }
}
