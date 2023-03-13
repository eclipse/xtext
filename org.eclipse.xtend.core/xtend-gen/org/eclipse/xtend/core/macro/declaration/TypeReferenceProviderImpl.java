/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.macro.declaration;

import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.PrimitiveType;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclarator;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.services.TypeReferenceProvider;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmComponentType;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class TypeReferenceProviderImpl implements TypeReferenceProvider {
  @Extension
  private CompilationUnitImpl compilationUnit;

  public TypeReferenceProviderImpl(final CompilationUnitImpl compilationUnit) {
    this.compilationUnit = compilationUnit;
  }

  @Override
  public TypeReference getAnyType() {
    return this.compilationUnit.toTypeReference(this.compilationUnit.getTypeReferences().createAnyTypeReference(this.compilationUnit.getXtendFile()));
  }

  @Override
  public TypeReference getList(final TypeReference param) {
    return this.newTypeReference("java.util.List", param);
  }

  @Override
  public TypeReference getObject() {
    return this.compilationUnit.toTypeReference(this.createTypeRef(this.compilationUnit.getTypeReferences().findDeclaredType(Object.class, this.compilationUnit.getXtendFile())));
  }

  @Override
  public TypeReference getPrimitiveBoolean() {
    return this.newTypeReference("boolean");
  }

  @Override
  public TypeReference getPrimitiveByte() {
    return this.newTypeReference("byte");
  }

  @Override
  public TypeReference getPrimitiveChar() {
    return this.newTypeReference("char");
  }

  @Override
  public TypeReference getPrimitiveDouble() {
    return this.newTypeReference("double");
  }

  @Override
  public TypeReference getPrimitiveFloat() {
    return this.newTypeReference("float");
  }

  @Override
  public TypeReference getPrimitiveInt() {
    return this.newTypeReference("int");
  }

  @Override
  public TypeReference getPrimitiveLong() {
    return this.newTypeReference("long");
  }

  @Override
  public TypeReference getPrimitiveShort() {
    return this.newTypeReference("short");
  }

  @Override
  public TypeReference getPrimitiveVoid() {
    return this.newTypeReference("void");
  }

  @Override
  public TypeReference getSet(final TypeReference param) {
    return this.newTypeReference("java.util.Set", param);
  }

  @Override
  public TypeReference getString() {
    return this.newTypeReference("java.lang.String");
  }

  @Override
  public TypeReference newArrayTypeReference(final TypeReference componentType) {
    TypeReference _xblockexpression = null;
    {
      this.compilationUnit.checkCanceled();
      _xblockexpression = this.compilationUnit.toTypeReference(this.compilationUnit.getTypeReferences().createArrayType(this.compilationUnit.toJvmTypeReference(componentType)));
    }
    return _xblockexpression;
  }

  @Override
  public TypeReference newTypeReference(final String typeName, final TypeReference... typeArguments) {
    TypeReference _xblockexpression = null;
    {
      this.compilationUnit.checkCanceled();
      final JvmType type = this.compilationUnit.getTypeReferences().findDeclaredType(typeName, this.compilationUnit.getXtendFile());
      if ((type == null)) {
        return null;
      }
      final Function1<TypeReference, JvmTypeReference> _function = (TypeReference it) -> {
        return this.compilationUnit.toJvmTypeReference(it);
      };
      List<JvmTypeReference> _map = ListExtensions.<TypeReference, JvmTypeReference>map(((List<TypeReference>)Conversions.doWrapArray(typeArguments)), _function);
      _xblockexpression = this.compilationUnit.toTypeReference(this.createTypeRef(type, ((JvmTypeReference[]) ((JvmTypeReference[])Conversions.unwrapArray(_map, JvmTypeReference.class)))));
    }
    return _xblockexpression;
  }

  public JvmParameterizedTypeReference createTypeRef(final JvmType type, final JvmTypeReference... typeArgs) {
    if ((type == null)) {
      throw new NullPointerException("type");
    }
    final JvmParameterizedTypeReference reference = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
    reference.setType(type);
    for (final JvmTypeReference typeArg : typeArgs) {
      reference.getArguments().add(EcoreUtil2.<JvmTypeReference>cloneIfContained(typeArg));
    }
    if ((type instanceof JvmGenericType)) {
      final EList<JvmTypeParameter> list = ((JvmGenericType)type).getTypeParameters();
      if (((!reference.getArguments().isEmpty()) && (list.size() != reference.getArguments().size()))) {
        String _identifier = ((JvmGenericType)type).getIdentifier();
        String _plus = ("The type " + _identifier);
        String _plus_1 = (_plus + " expects ");
        int _size = list.size();
        String _plus_2 = (_plus_1 + Integer.valueOf(_size));
        String _plus_3 = (_plus_2 + " type arguments, but was ");
        int _size_1 = reference.getArguments().size();
        String _plus_4 = (_plus_3 + Integer.valueOf(_size_1));
        String _plus_5 = (_plus_4 + ". Either pass zero arguments (raw type) or the correct number.");
        throw new IllegalArgumentException(_plus_5);
      }
    }
    return reference;
  }

  @Override
  public TypeReference newTypeReference(final Type typeDeclaration, final TypeReference... typeArguments) {
    TypeReference _xblockexpression = null;
    {
      this.compilationUnit.checkCanceled();
      JvmComponentType _switchResult = null;
      boolean _matched = false;
      if (typeDeclaration instanceof JvmTypeDeclarationImpl) {
        _matched=true;
        _switchResult = ((JvmTypeDeclarationImpl<? extends JvmDeclaredType>)typeDeclaration).getDelegate();
      }
      if (!_matched) {
        if (typeDeclaration instanceof XtendTypeDeclarationImpl) {
          _matched=true;
          _switchResult = this.compilationUnit.getJvmModelAssociations().getInferredType(((XtendTypeDeclarationImpl<? extends XtendTypeDeclaration>)typeDeclaration).getDelegate());
        }
      }
      if (!_matched) {
        if (typeDeclaration instanceof JvmTypeParameterDeclarationImpl) {
          _matched=true;
          _switchResult = ((JvmTypeParameterDeclarationImpl)typeDeclaration).getDelegate();
        }
      }
      if (!_matched) {
        if (typeDeclaration instanceof PrimitiveTypeImpl) {
          _matched=true;
          TypeReference _switchResult_1 = null;
          PrimitiveType.Kind _kind = ((PrimitiveTypeImpl)typeDeclaration).getKind();
          if (_kind != null) {
            switch (_kind) {
              case BOOLEAN:
                _switchResult_1 = this.getPrimitiveBoolean();
                break;
              case BYTE:
                _switchResult_1 = this.getPrimitiveByte();
                break;
              case CHAR:
                _switchResult_1 = this.getPrimitiveChar();
                break;
              case DOUBLE:
                _switchResult_1 = this.getPrimitiveDouble();
                break;
              case FLOAT:
                _switchResult_1 = this.getPrimitiveFloat();
                break;
              case INT:
                _switchResult_1 = this.getPrimitiveInt();
                break;
              case LONG:
                _switchResult_1 = this.getPrimitiveLong();
                break;
              case SHORT:
                _switchResult_1 = this.getPrimitiveShort();
                break;
              default:
                break;
            }
          }
          return _switchResult_1;
        }
      }
      if (!_matched) {
        if (typeDeclaration instanceof VoidTypeImpl) {
          _matched=true;
          return this.getPrimitiveVoid();
        }
      }
      if (!_matched) {
        throw new IllegalArgumentException(("couldn\'t construct type reference for type " + typeDeclaration));
      }
      final JvmComponentType type = _switchResult;
      if ((type == null)) {
        return null;
      }
      final Function1<TypeReference, JvmTypeReference> _function = (TypeReference it) -> {
        return this.compilationUnit.toJvmTypeReference(it);
      };
      List<JvmTypeReference> _map = ListExtensions.<TypeReference, JvmTypeReference>map(((List<TypeReference>)Conversions.doWrapArray(typeArguments)), _function);
      _xblockexpression = this.compilationUnit.toTypeReference(this.createTypeRef(type, ((JvmTypeReference[]) ((JvmTypeReference[])Conversions.unwrapArray(_map, JvmTypeReference.class)))));
    }
    return _xblockexpression;
  }

  @Override
  public TypeReference newWildcardTypeReference() {
    return this.newWildcardTypeReference(null);
  }

  @Override
  public TypeReference newWildcardTypeReference(final TypeReference upperBound) {
    TypeReference _xifexpression = null;
    if ((upperBound == null)) {
      _xifexpression = this.compilationUnit.toTypeReference(this.compilationUnit.getTypeReferences().wildCard());
    } else {
      _xifexpression = this.compilationUnit.toTypeReference(this.compilationUnit.getTypeReferences().wildCardExtends(this.compilationUnit.toJvmTypeReference(upperBound)));
    }
    return _xifexpression;
  }

  @Override
  public TypeReference newWildcardTypeReferenceWithLowerBound(final TypeReference lowerBound) {
    TypeReference _xifexpression = null;
    if ((lowerBound == null)) {
      _xifexpression = this.compilationUnit.toTypeReference(this.compilationUnit.getTypeReferences().wildCard());
    } else {
      _xifexpression = this.compilationUnit.toTypeReference(this.compilationUnit.getTypeReferences().wildCardSuper(this.compilationUnit.toJvmTypeReference(lowerBound)));
    }
    return _xifexpression;
  }

  @Override
  public TypeReference newTypeReference(final Class<?> clazz, final TypeReference... typeArguments) {
    return this.newTypeReference(clazz.getName(), typeArguments);
  }

  @Override
  public TypeReference newSelfTypeReference(final Type typeDeclaration) {
    TypeReference _xifexpression = null;
    if ((typeDeclaration instanceof TypeParameterDeclarator)) {
      final Function1<TypeParameterDeclaration, TypeReference> _function = (TypeParameterDeclaration it) -> {
        return this.newTypeReference(it);
      };
      _xifexpression = this.newTypeReference(typeDeclaration, ((TypeReference[])Conversions.unwrapArray(IterableExtensions.map(((TypeParameterDeclarator)typeDeclaration).getTypeParameters(), _function), TypeReference.class)));
    } else {
      _xifexpression = this.newTypeReference(typeDeclaration);
    }
    return _xifexpression;
  }
}
