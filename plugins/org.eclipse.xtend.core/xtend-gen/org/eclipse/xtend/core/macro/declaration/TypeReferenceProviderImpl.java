package org.eclipse.xtend.core.macro.declaration;

import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.JvmTypeDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.JvmTypeParameterDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.PrimitiveTypeImpl;
import org.eclipse.xtend.core.macro.declaration.VoidTypeImpl;
import org.eclipse.xtend.core.macro.declaration.XtendTypeDeclarationImpl;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.PrimitiveType;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclarator;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.services.TypeReferenceProvider;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmComponentType;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.TypeReferences;
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
    TypeReferences _typeReferences = this.compilationUnit.getTypeReferences();
    XtendFile _xtendFile = this.compilationUnit.getXtendFile();
    JvmAnyTypeReference _createAnyTypeReference = _typeReferences.createAnyTypeReference(_xtendFile);
    return this.compilationUnit.toTypeReference(_createAnyTypeReference);
  }
  
  @Override
  public TypeReference getList(final TypeReference param) {
    return this.newTypeReference("java.util.List", param);
  }
  
  @Override
  public TypeReference getObject() {
    TypeReferences _typeReferences = this.compilationUnit.getTypeReferences();
    XtendFile _xtendFile = this.compilationUnit.getXtendFile();
    JvmType _findDeclaredType = _typeReferences.findDeclaredType(Object.class, _xtendFile);
    JvmParameterizedTypeReference _createTypeRef = this.createTypeRef(_findDeclaredType);
    return this.compilationUnit.toTypeReference(_createTypeRef);
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
      TypeReferences _typeReferences = this.compilationUnit.getTypeReferences();
      JvmTypeReference _jvmTypeReference = this.compilationUnit.toJvmTypeReference(componentType);
      JvmGenericArrayTypeReference _createArrayType = _typeReferences.createArrayType(_jvmTypeReference);
      _xblockexpression = this.compilationUnit.toTypeReference(_createArrayType);
    }
    return _xblockexpression;
  }
  
  @Override
  public TypeReference newTypeReference(final String typeName, final TypeReference... typeArguments) {
    TypeReference _xblockexpression = null;
    {
      this.compilationUnit.checkCanceled();
      TypeReferences _typeReferences = this.compilationUnit.getTypeReferences();
      XtendFile _xtendFile = this.compilationUnit.getXtendFile();
      final JvmType type = _typeReferences.findDeclaredType(typeName, _xtendFile);
      if ((type == null)) {
        return null;
      }
      final Function1<TypeReference, JvmTypeReference> _function = new Function1<TypeReference, JvmTypeReference>() {
        @Override
        public JvmTypeReference apply(final TypeReference it) {
          return TypeReferenceProviderImpl.this.compilationUnit.toJvmTypeReference(it);
        }
      };
      List<JvmTypeReference> _map = ListExtensions.<TypeReference, JvmTypeReference>map(((List<TypeReference>)Conversions.doWrapArray(typeArguments)), _function);
      JvmParameterizedTypeReference _createTypeRef = this.createTypeRef(type, ((JvmTypeReference[]) ((JvmTypeReference[])Conversions.unwrapArray(_map, JvmTypeReference.class))));
      _xblockexpression = this.compilationUnit.toTypeReference(_createTypeRef);
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
      EList<JvmTypeReference> _arguments = reference.getArguments();
      JvmTypeReference _cloneIfContained = EcoreUtil2.<JvmTypeReference>cloneIfContained(typeArg);
      _arguments.add(_cloneIfContained);
    }
    if ((type instanceof JvmGenericType)) {
      final EList<JvmTypeParameter> list = ((JvmGenericType)type).getTypeParameters();
      boolean _and = false;
      EList<JvmTypeReference> _arguments_1 = reference.getArguments();
      boolean _isEmpty = _arguments_1.isEmpty();
      boolean _not = (!_isEmpty);
      if (!_not) {
        _and = false;
      } else {
        int _size = list.size();
        EList<JvmTypeReference> _arguments_2 = reference.getArguments();
        int _size_1 = _arguments_2.size();
        boolean _notEquals = (_size != _size_1);
        _and = _notEquals;
      }
      if (_and) {
        String _identifier = ((JvmGenericType)type).getIdentifier();
        String _plus = ("The type " + _identifier);
        String _plus_1 = (_plus + " expects ");
        int _size_2 = list.size();
        String _plus_2 = (_plus_1 + Integer.valueOf(_size_2));
        String _plus_3 = (_plus_2 + " type arguments, but was ");
        EList<JvmTypeReference> _arguments_3 = reference.getArguments();
        int _size_3 = _arguments_3.size();
        String _plus_4 = (_plus_3 + Integer.valueOf(_size_3));
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
          IXtendJvmAssociations _jvmModelAssociations = this.compilationUnit.getJvmModelAssociations();
          XtendTypeDeclaration _delegate = ((XtendTypeDeclarationImpl<? extends XtendTypeDeclaration>)typeDeclaration).getDelegate();
          _switchResult = _jvmModelAssociations.getInferredType(_delegate);
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
      final Function1<TypeReference, JvmTypeReference> _function = new Function1<TypeReference, JvmTypeReference>() {
        @Override
        public JvmTypeReference apply(final TypeReference it) {
          return TypeReferenceProviderImpl.this.compilationUnit.toJvmTypeReference(it);
        }
      };
      List<JvmTypeReference> _map = ListExtensions.<TypeReference, JvmTypeReference>map(((List<TypeReference>)Conversions.doWrapArray(typeArguments)), _function);
      JvmParameterizedTypeReference _createTypeRef = this.createTypeRef(type, ((JvmTypeReference[]) ((JvmTypeReference[])Conversions.unwrapArray(_map, JvmTypeReference.class))));
      _xblockexpression = this.compilationUnit.toTypeReference(_createTypeRef);
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
      TypeReferences _typeReferences = this.compilationUnit.getTypeReferences();
      JvmWildcardTypeReference _wildCard = _typeReferences.wildCard();
      _xifexpression = this.compilationUnit.toTypeReference(_wildCard);
    } else {
      TypeReferences _typeReferences_1 = this.compilationUnit.getTypeReferences();
      JvmTypeReference _jvmTypeReference = this.compilationUnit.toJvmTypeReference(upperBound);
      JvmWildcardTypeReference _wildCardExtends = _typeReferences_1.wildCardExtends(_jvmTypeReference);
      _xifexpression = this.compilationUnit.toTypeReference(_wildCardExtends);
    }
    return _xifexpression;
  }
  
  @Override
  public TypeReference newWildcardTypeReferenceWithLowerBound(final TypeReference lowerBound) {
    TypeReference _xifexpression = null;
    if ((lowerBound == null)) {
      TypeReferences _typeReferences = this.compilationUnit.getTypeReferences();
      JvmWildcardTypeReference _wildCard = _typeReferences.wildCard();
      _xifexpression = this.compilationUnit.toTypeReference(_wildCard);
    } else {
      TypeReferences _typeReferences_1 = this.compilationUnit.getTypeReferences();
      JvmTypeReference _jvmTypeReference = this.compilationUnit.toJvmTypeReference(lowerBound);
      JvmWildcardTypeReference _wildCardSuper = _typeReferences_1.wildCardSuper(_jvmTypeReference);
      _xifexpression = this.compilationUnit.toTypeReference(_wildCardSuper);
    }
    return _xifexpression;
  }
  
  @Override
  public TypeReference newTypeReference(final Class<?> clazz, final TypeReference... typeArguments) {
    String _name = clazz.getName();
    return this.newTypeReference(_name, typeArguments);
  }
  
  @Override
  public TypeReference newSelfTypeReference(final Type typeDeclaration) {
    TypeReference _xifexpression = null;
    if ((typeDeclaration instanceof TypeParameterDeclarator)) {
      Iterable<? extends TypeParameterDeclaration> _typeParameters = ((TypeParameterDeclarator)typeDeclaration).getTypeParameters();
      final Function1<TypeParameterDeclaration, TypeReference> _function = new Function1<TypeParameterDeclaration, TypeReference>() {
        @Override
        public TypeReference apply(final TypeParameterDeclaration it) {
          return TypeReferenceProviderImpl.this.newTypeReference(it);
        }
      };
      Iterable<TypeReference> _map = IterableExtensions.map(_typeParameters, _function);
      _xifexpression = this.newTypeReference(typeDeclaration, ((TypeReference[])Conversions.unwrapArray(_map, TypeReference.class)));
    } else {
      _xifexpression = this.newTypeReference(typeDeclaration);
    }
    return _xifexpression;
  }
}
