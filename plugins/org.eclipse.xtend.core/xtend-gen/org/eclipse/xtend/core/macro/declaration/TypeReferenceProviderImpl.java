package org.eclipse.xtend.core.macro.declaration;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.JvmTypeDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.JvmTypeParameterDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.PrimitiveTypeImpl;
import org.eclipse.xtend.core.macro.declaration.VoidTypeImpl;
import org.eclipse.xtend.core.macro.declaration.XtendTypeDeclarationImpl;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.PrimitiveType.Kind;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.services.TypeReferenceProvider;
import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmComponentType;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class TypeReferenceProviderImpl implements TypeReferenceProvider {
  @Extension
  private CompilationUnitImpl compilationUnit;
  
  public TypeReferenceProviderImpl(final CompilationUnitImpl compilationUnit) {
    this.compilationUnit = compilationUnit;
  }
  
  public TypeReference getAnyType() {
    TypeReferences _typeReferences = this.compilationUnit.getTypeReferences();
    XtendFile _xtendFile = this.compilationUnit.getXtendFile();
    JvmAnyTypeReference _createAnyTypeReference = _typeReferences.createAnyTypeReference(_xtendFile);
    TypeReference _typeReference = this.compilationUnit.toTypeReference(_createAnyTypeReference);
    return _typeReference;
  }
  
  public TypeReference getList(final TypeReference param) {
    TypeReference _newTypeReference = this.newTypeReference("java.util.List", param);
    return _newTypeReference;
  }
  
  public TypeReference getObject() {
    TypeReferences _typeReferences = this.compilationUnit.getTypeReferences();
    TypeReferences _typeReferences_1 = this.compilationUnit.getTypeReferences();
    XtendFile _xtendFile = this.compilationUnit.getXtendFile();
    JvmType _findDeclaredType = _typeReferences_1.findDeclaredType(Object.class, _xtendFile);
    JvmParameterizedTypeReference _createTypeRef = _typeReferences.createTypeRef(_findDeclaredType);
    TypeReference _typeReference = this.compilationUnit.toTypeReference(_createTypeRef);
    return _typeReference;
  }
  
  public TypeReference getPrimitiveBoolean() {
    TypeReference _newTypeReference = this.newTypeReference("boolean");
    return _newTypeReference;
  }
  
  public TypeReference getPrimitiveByte() {
    TypeReference _newTypeReference = this.newTypeReference("byte");
    return _newTypeReference;
  }
  
  public TypeReference getPrimitiveChar() {
    TypeReference _newTypeReference = this.newTypeReference("char");
    return _newTypeReference;
  }
  
  public TypeReference getPrimitiveDouble() {
    TypeReference _newTypeReference = this.newTypeReference("double");
    return _newTypeReference;
  }
  
  public TypeReference getPrimitiveFloat() {
    TypeReference _newTypeReference = this.newTypeReference("float");
    return _newTypeReference;
  }
  
  public TypeReference getPrimitiveInt() {
    TypeReference _newTypeReference = this.newTypeReference("int");
    return _newTypeReference;
  }
  
  public TypeReference getPrimitiveLong() {
    TypeReference _newTypeReference = this.newTypeReference("long");
    return _newTypeReference;
  }
  
  public TypeReference getPrimitiveShort() {
    TypeReference _newTypeReference = this.newTypeReference("short");
    return _newTypeReference;
  }
  
  public TypeReference getPrimitiveVoid() {
    TypeReference _newTypeReference = this.newTypeReference("void");
    return _newTypeReference;
  }
  
  public TypeReference getSet(final TypeReference param) {
    TypeReference _newTypeReference = this.newTypeReference("java.util.Set", param);
    return _newTypeReference;
  }
  
  public TypeReference getString() {
    TypeReference _newTypeReference = this.newTypeReference("java.lang.String");
    return _newTypeReference;
  }
  
  public TypeReference newArrayTypeReference(final TypeReference componentType) {
    TypeReference _xblockexpression = null;
    {
      this.compilationUnit.checkCanceled();
      TypeReferences _typeReferences = this.compilationUnit.getTypeReferences();
      JvmTypeReference _jvmTypeReference = this.compilationUnit.toJvmTypeReference(componentType);
      JvmGenericArrayTypeReference _createArrayType = _typeReferences.createArrayType(_jvmTypeReference);
      TypeReference _typeReference = this.compilationUnit.toTypeReference(_createArrayType);
      _xblockexpression = (_typeReference);
    }
    return _xblockexpression;
  }
  
  public TypeReference newTypeReference(final String typeName, final TypeReference... typeArguments) {
    TypeReference _xblockexpression = null;
    {
      this.compilationUnit.checkCanceled();
      TypeReferences _typeReferences = this.compilationUnit.getTypeReferences();
      XtendFile _xtendFile = this.compilationUnit.getXtendFile();
      final JvmType type = _typeReferences.findDeclaredType(typeName, _xtendFile);
      boolean _equals = Objects.equal(type, null);
      if (_equals) {
        return null;
      }
      TypeReferences _typeReferences_1 = this.compilationUnit.getTypeReferences();
      final Function1<TypeReference,JvmTypeReference> _function = new Function1<TypeReference,JvmTypeReference>() {
        public JvmTypeReference apply(final TypeReference it) {
          JvmTypeReference _jvmTypeReference = TypeReferenceProviderImpl.this.compilationUnit.toJvmTypeReference(it);
          return _jvmTypeReference;
        }
      };
      List<JvmTypeReference> _map = ListExtensions.<TypeReference, JvmTypeReference>map(((List<TypeReference>)Conversions.doWrapArray(typeArguments)), _function);
      JvmParameterizedTypeReference _createTypeRef = _typeReferences_1.createTypeRef(type, ((JvmTypeReference[]) ((JvmTypeReference[])Conversions.unwrapArray(_map, JvmTypeReference.class))));
      TypeReference _typeReference = this.compilationUnit.toTypeReference(_createTypeRef);
      _xblockexpression = (_typeReference);
    }
    return _xblockexpression;
  }
  
  public TypeReference newTypeReference(final Type typeDeclaration, final TypeReference... typeArguments) {
    TypeReference _xblockexpression = null;
    {
      this.compilationUnit.checkCanceled();
      JvmComponentType _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        if (typeDeclaration instanceof JvmTypeDeclarationImpl) {
          _matched=true;
          JvmDeclaredType _delegate = ((JvmTypeDeclarationImpl<? extends JvmDeclaredType>)typeDeclaration).getDelegate();
          _switchResult = _delegate;
        }
      }
      if (!_matched) {
        if (typeDeclaration instanceof XtendTypeDeclarationImpl) {
          _matched=true;
          IXtendJvmAssociations _jvmAssociations = this.compilationUnit.getJvmAssociations();
          XtendTypeDeclaration _delegate = ((XtendTypeDeclarationImpl<? extends XtendTypeDeclaration>)typeDeclaration).getDelegate();
          JvmDeclaredType _inferredType = _jvmAssociations.getInferredType(_delegate);
          _switchResult = _inferredType;
        }
      }
      if (!_matched) {
        if (typeDeclaration instanceof JvmTypeParameterDeclarationImpl) {
          _matched=true;
          JvmTypeParameter _delegate = ((JvmTypeParameterDeclarationImpl)typeDeclaration).getDelegate();
          _switchResult = _delegate;
        }
      }
      if (!_matched) {
        if (typeDeclaration instanceof PrimitiveTypeImpl) {
          _matched=true;
          TypeReference _switchResult_1 = null;
          Kind _kind = ((PrimitiveTypeImpl)typeDeclaration).getKind();
          final Kind _switchValue = _kind;
          boolean _matched_1 = false;
          if (!_matched_1) {
            if (Objects.equal(_switchValue,Kind.BOOLEAN)) {
              _matched_1=true;
              TypeReference _primitiveBoolean = this.getPrimitiveBoolean();
              _switchResult_1 = _primitiveBoolean;
            }
          }
          if (!_matched_1) {
            if (Objects.equal(_switchValue,Kind.BYTE)) {
              _matched_1=true;
              TypeReference _primitiveByte = this.getPrimitiveByte();
              _switchResult_1 = _primitiveByte;
            }
          }
          if (!_matched_1) {
            if (Objects.equal(_switchValue,Kind.CHAR)) {
              _matched_1=true;
              TypeReference _primitiveChar = this.getPrimitiveChar();
              _switchResult_1 = _primitiveChar;
            }
          }
          if (!_matched_1) {
            if (Objects.equal(_switchValue,Kind.DOUBLE)) {
              _matched_1=true;
              TypeReference _primitiveDouble = this.getPrimitiveDouble();
              _switchResult_1 = _primitiveDouble;
            }
          }
          if (!_matched_1) {
            if (Objects.equal(_switchValue,Kind.FLOAT)) {
              _matched_1=true;
              TypeReference _primitiveFloat = this.getPrimitiveFloat();
              _switchResult_1 = _primitiveFloat;
            }
          }
          if (!_matched_1) {
            if (Objects.equal(_switchValue,Kind.INT)) {
              _matched_1=true;
              TypeReference _primitiveInt = this.getPrimitiveInt();
              _switchResult_1 = _primitiveInt;
            }
          }
          if (!_matched_1) {
            if (Objects.equal(_switchValue,Kind.LONG)) {
              _matched_1=true;
              TypeReference _primitiveLong = this.getPrimitiveLong();
              _switchResult_1 = _primitiveLong;
            }
          }
          if (!_matched_1) {
            if (Objects.equal(_switchValue,Kind.SHORT)) {
              _matched_1=true;
              TypeReference _primitiveShort = this.getPrimitiveShort();
              _switchResult_1 = _primitiveShort;
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
        IllegalArgumentException _illegalArgumentException = new IllegalArgumentException(("couldn\'t construct type reference for type " + typeDeclaration));
        throw _illegalArgumentException;
      }
      final JvmComponentType type = _switchResult;
      boolean _equals = Objects.equal(type, null);
      if (_equals) {
        return null;
      }
      TypeReferences _typeReferences = this.compilationUnit.getTypeReferences();
      final Function1<TypeReference,JvmTypeReference> _function = new Function1<TypeReference,JvmTypeReference>() {
        public JvmTypeReference apply(final TypeReference it) {
          JvmTypeReference _jvmTypeReference = TypeReferenceProviderImpl.this.compilationUnit.toJvmTypeReference(it);
          return _jvmTypeReference;
        }
      };
      List<JvmTypeReference> _map = ListExtensions.<TypeReference, JvmTypeReference>map(((List<TypeReference>)Conversions.doWrapArray(typeArguments)), _function);
      JvmParameterizedTypeReference _createTypeRef = _typeReferences.createTypeRef(type, ((JvmTypeReference[]) ((JvmTypeReference[])Conversions.unwrapArray(_map, JvmTypeReference.class))));
      TypeReference _typeReference = this.compilationUnit.toTypeReference(_createTypeRef);
      _xblockexpression = (_typeReference);
    }
    return _xblockexpression;
  }
  
  public TypeReference newWildcardTypeReference() {
    TypeReference _newWildcardTypeReference = this.newWildcardTypeReference(null);
    return _newWildcardTypeReference;
  }
  
  public TypeReference newWildcardTypeReference(final TypeReference upperBound) {
    TypeReference _xifexpression = null;
    boolean _equals = Objects.equal(upperBound, null);
    if (_equals) {
      TypeReferences _typeReferences = this.compilationUnit.getTypeReferences();
      JvmWildcardTypeReference _wildCard = _typeReferences.wildCard();
      TypeReference _typeReference = this.compilationUnit.toTypeReference(_wildCard);
      _xifexpression = _typeReference;
    } else {
      TypeReferences _typeReferences_1 = this.compilationUnit.getTypeReferences();
      JvmTypeReference _jvmTypeReference = this.compilationUnit.toJvmTypeReference(upperBound);
      JvmWildcardTypeReference _wildCardExtends = _typeReferences_1.wildCardExtends(_jvmTypeReference);
      TypeReference _typeReference_1 = this.compilationUnit.toTypeReference(_wildCardExtends);
      _xifexpression = _typeReference_1;
    }
    return _xifexpression;
  }
  
  public TypeReference newWildcardTypeReferenceWithLowerBound(final TypeReference lowerBound) {
    TypeReference _xifexpression = null;
    boolean _equals = Objects.equal(lowerBound, null);
    if (_equals) {
      TypeReferences _typeReferences = this.compilationUnit.getTypeReferences();
      JvmWildcardTypeReference _wildCard = _typeReferences.wildCard();
      TypeReference _typeReference = this.compilationUnit.toTypeReference(_wildCard);
      _xifexpression = _typeReference;
    } else {
      TypeReferences _typeReferences_1 = this.compilationUnit.getTypeReferences();
      JvmTypeReference _jvmTypeReference = this.compilationUnit.toJvmTypeReference(lowerBound);
      JvmWildcardTypeReference _wildCardSuper = _typeReferences_1.wildCardSuper(_jvmTypeReference);
      TypeReference _typeReference_1 = this.compilationUnit.toTypeReference(_wildCardSuper);
      _xifexpression = _typeReference_1;
    }
    return _xifexpression;
  }
  
  public TypeReference newTypeReference(final Class<? extends Object> clazz, final TypeReference... typeArguments) {
    String _name = clazz.getName();
    TypeReference _newTypeReference = this.newTypeReference(_name, typeArguments);
    return _newTypeReference;
  }
}
