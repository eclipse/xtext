package org.eclipse.xtend.core.macro.declaration;

import com.google.common.base.Objects;
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
    return this.compilationUnit.toTypeReference(_createAnyTypeReference);
  }
  
  public TypeReference getList(final TypeReference param) {
    return this.newTypeReference("java.util.List", param);
  }
  
  public TypeReference getObject() {
    TypeReferences _typeReferences = this.compilationUnit.getTypeReferences();
    XtendFile _xtendFile = this.compilationUnit.getXtendFile();
    JvmType _findDeclaredType = _typeReferences.findDeclaredType(Object.class, _xtendFile);
    JvmParameterizedTypeReference _createTypeRef = this.createTypeRef(_findDeclaredType);
    return this.compilationUnit.toTypeReference(_createTypeRef);
  }
  
  public TypeReference getPrimitiveBoolean() {
    return this.newTypeReference("boolean");
  }
  
  public TypeReference getPrimitiveByte() {
    return this.newTypeReference("byte");
  }
  
  public TypeReference getPrimitiveChar() {
    return this.newTypeReference("char");
  }
  
  public TypeReference getPrimitiveDouble() {
    return this.newTypeReference("double");
  }
  
  public TypeReference getPrimitiveFloat() {
    return this.newTypeReference("float");
  }
  
  public TypeReference getPrimitiveInt() {
    return this.newTypeReference("int");
  }
  
  public TypeReference getPrimitiveLong() {
    return this.newTypeReference("long");
  }
  
  public TypeReference getPrimitiveShort() {
    return this.newTypeReference("short");
  }
  
  public TypeReference getPrimitiveVoid() {
    return this.newTypeReference("void");
  }
  
  public TypeReference getSet(final TypeReference param) {
    return this.newTypeReference("java.util.Set", param);
  }
  
  public TypeReference getString() {
    return this.newTypeReference("java.lang.String");
  }
  
  public TypeReference newArrayTypeReference(final TypeReference componentType) {
    TypeReference _xblockexpression = null;
    {
      this.compilationUnit.checkCanceled();
      TypeReferences _typeReferences = this.compilationUnit.getTypeReferences();
      JvmTypeReference _jvmTypeReference = this.compilationUnit.toJvmTypeReference(componentType);
      JvmGenericArrayTypeReference _createArrayType = _typeReferences.createArrayType(_jvmTypeReference);
      _xblockexpression = (this.compilationUnit.toTypeReference(_createArrayType));
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
      final Function1<TypeReference,JvmTypeReference> _function = new Function1<TypeReference,JvmTypeReference>() {
        public JvmTypeReference apply(final TypeReference it) {
          return TypeReferenceProviderImpl.this.compilationUnit.toJvmTypeReference(it);
        }
      };
      List<JvmTypeReference> _map = ListExtensions.<TypeReference, JvmTypeReference>map(((List<TypeReference>)Conversions.doWrapArray(typeArguments)), _function);
      JvmParameterizedTypeReference _createTypeRef = this.createTypeRef(type, ((JvmTypeReference[]) ((JvmTypeReference[])Conversions.unwrapArray(_map, JvmTypeReference.class))));
      _xblockexpression = (this.compilationUnit.toTypeReference(_createTypeRef));
    }
    return _xblockexpression;
  }
  
  public JvmParameterizedTypeReference createTypeRef(final JvmType type, final JvmTypeReference... typeArgs) {
    boolean _equals = Objects.equal(type, null);
    if (_equals) {
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
  
  public TypeReference newTypeReference(final Type typeDeclaration, final TypeReference... typeArguments) {
    TypeReference _xblockexpression = null;
    {
      this.compilationUnit.checkCanceled();
      JvmComponentType _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        if (typeDeclaration instanceof JvmTypeDeclarationImpl) {
          _matched=true;
          _switchResult = ((JvmTypeDeclarationImpl<? extends JvmDeclaredType>)typeDeclaration).getDelegate();
        }
      }
      if (!_matched) {
        if (typeDeclaration instanceof XtendTypeDeclarationImpl) {
          _matched=true;
          IXtendJvmAssociations _jvmAssociations = this.compilationUnit.getJvmAssociations();
          XtendTypeDeclaration _delegate = ((XtendTypeDeclarationImpl<? extends XtendTypeDeclaration>)typeDeclaration).getDelegate();
          _switchResult = _jvmAssociations.getInferredType(_delegate);
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
          final PrimitiveType.Kind _switchValue = _kind;
          boolean _matched_1 = false;
          if (!_matched_1) {
            if (Objects.equal(_switchValue,PrimitiveType.Kind.BOOLEAN)) {
              _matched_1=true;
              _switchResult_1 = this.getPrimitiveBoolean();
            }
          }
          if (!_matched_1) {
            if (Objects.equal(_switchValue,PrimitiveType.Kind.BYTE)) {
              _matched_1=true;
              _switchResult_1 = this.getPrimitiveByte();
            }
          }
          if (!_matched_1) {
            if (Objects.equal(_switchValue,PrimitiveType.Kind.CHAR)) {
              _matched_1=true;
              _switchResult_1 = this.getPrimitiveChar();
            }
          }
          if (!_matched_1) {
            if (Objects.equal(_switchValue,PrimitiveType.Kind.DOUBLE)) {
              _matched_1=true;
              _switchResult_1 = this.getPrimitiveDouble();
            }
          }
          if (!_matched_1) {
            if (Objects.equal(_switchValue,PrimitiveType.Kind.FLOAT)) {
              _matched_1=true;
              _switchResult_1 = this.getPrimitiveFloat();
            }
          }
          if (!_matched_1) {
            if (Objects.equal(_switchValue,PrimitiveType.Kind.INT)) {
              _matched_1=true;
              _switchResult_1 = this.getPrimitiveInt();
            }
          }
          if (!_matched_1) {
            if (Objects.equal(_switchValue,PrimitiveType.Kind.LONG)) {
              _matched_1=true;
              _switchResult_1 = this.getPrimitiveLong();
            }
          }
          if (!_matched_1) {
            if (Objects.equal(_switchValue,PrimitiveType.Kind.SHORT)) {
              _matched_1=true;
              _switchResult_1 = this.getPrimitiveShort();
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
      boolean _equals = Objects.equal(type, null);
      if (_equals) {
        return null;
      }
      final Function1<TypeReference,JvmTypeReference> _function = new Function1<TypeReference,JvmTypeReference>() {
        public JvmTypeReference apply(final TypeReference it) {
          return TypeReferenceProviderImpl.this.compilationUnit.toJvmTypeReference(it);
        }
      };
      List<JvmTypeReference> _map = ListExtensions.<TypeReference, JvmTypeReference>map(((List<TypeReference>)Conversions.doWrapArray(typeArguments)), _function);
      JvmParameterizedTypeReference _createTypeRef = this.createTypeRef(type, ((JvmTypeReference[]) ((JvmTypeReference[])Conversions.unwrapArray(_map, JvmTypeReference.class))));
      _xblockexpression = (this.compilationUnit.toTypeReference(_createTypeRef));
    }
    return _xblockexpression;
  }
  
  public TypeReference newWildcardTypeReference() {
    return this.newWildcardTypeReference(null);
  }
  
  public TypeReference newWildcardTypeReference(final TypeReference upperBound) {
    TypeReference _xifexpression = null;
    boolean _equals = Objects.equal(upperBound, null);
    if (_equals) {
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
  
  public TypeReference newWildcardTypeReferenceWithLowerBound(final TypeReference lowerBound) {
    TypeReference _xifexpression = null;
    boolean _equals = Objects.equal(lowerBound, null);
    if (_equals) {
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
  
  public TypeReference newTypeReference(final Class<? extends Object> clazz, final TypeReference... typeArguments) {
    String _name = clazz.getName();
    return this.newTypeReference(_name, typeArguments);
  }
}
