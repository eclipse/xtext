/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.core.macro.declaration.ClassDeclarationJavaImpl;
import org.eclipse.xtend.core.macro.declaration.ClassDeclarationXtendImpl;
import org.eclipse.xtend.core.macro.declaration.ConstructorDeclarationJavaImpl;
import org.eclipse.xtend.core.macro.declaration.ConstructorDeclarationXtendImpl;
import org.eclipse.xtend.core.macro.declaration.FieldDeclarationJavaImpl;
import org.eclipse.xtend.core.macro.declaration.FieldDeclarationXtendImpl;
import org.eclipse.xtend.core.macro.declaration.InterfaceDeclarationJavaImpl;
import org.eclipse.xtend.core.macro.declaration.MethodDeclarationJavaImpl;
import org.eclipse.xtend.core.macro.declaration.MethodDeclarationXtendImpl;
import org.eclipse.xtend.core.macro.declaration.ParameterDeclarationJavaImpl;
import org.eclipse.xtend.core.macro.declaration.ParameterDeclarationXtendImpl;
import org.eclipse.xtend.core.macro.declaration.PrimitiveTypeImpl;
import org.eclipse.xtend.core.macro.declaration.TypeDeclarationJavaImpl;
import org.eclipse.xtend.core.macro.declaration.TypeParameterDeclartionImpl;
import org.eclipse.xtend.core.macro.declaration.TypeReferenceImpl;
import org.eclipse.xtend.core.macro.declaration.VoidTypeImpl;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.CompilationUnit;
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Visibility;
import org.eclipse.xtend.lib.macro.type.TypeReference;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.JvmVoid;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.typesystem.legacy.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;

@SuppressWarnings("all")
public class CompilationUnitImpl implements CompilationUnit {
  public String getDocComment() {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-generated function stub");
    throw _unsupportedOperationException;
  }
  
  public String getPackageName() {
    XtendFile _xtendFile = this.getXtendFile();
    String _package = _xtendFile.getPackage();
    return _package;
  }
  
  public List<TypeDeclaration> getSourceTypeDeclarations() {
    XtendFile _xtendFile = this.getXtendFile();
    EList<XtendTypeDeclaration> _xtendTypes = _xtendFile.getXtendTypes();
    final Function1<XtendTypeDeclaration,TypeDeclaration> _function = new Function1<XtendTypeDeclaration,TypeDeclaration>() {
        public TypeDeclaration apply(final XtendTypeDeclaration it) {
          TypeDeclaration _typeDeclaration = CompilationUnitImpl.this.toTypeDeclaration(it);
          return _typeDeclaration;
        }
      };
    List<TypeDeclaration> _map = ListExtensions.<XtendTypeDeclaration, TypeDeclaration>map(_xtendTypes, _function);
    return _map;
  }
  
  public List<TypeDeclaration> getGeneratedTypeDeclarations() {
    XtendFile _xtendFile = this.getXtendFile();
    Resource _eResource = _xtendFile.eResource();
    EList<EObject> _contents = _eResource.getContents();
    Iterable<JvmDeclaredType> _filter = Iterables.<JvmDeclaredType>filter(_contents, JvmDeclaredType.class);
    final Function1<JvmDeclaredType,TypeDeclaration> _function = new Function1<JvmDeclaredType,TypeDeclaration>() {
        public TypeDeclaration apply(final JvmDeclaredType it) {
          TypeDeclaration _typeDeclaration = CompilationUnitImpl.this.toTypeDeclaration(it);
          return _typeDeclaration;
        }
      };
    Iterable<TypeDeclaration> _map = IterableExtensions.<JvmDeclaredType, TypeDeclaration>map(_filter, _function);
    List<TypeDeclaration> _list = IterableExtensions.<TypeDeclaration>toList(_map);
    return _list;
  }
  
  private XtendFile _xtendFile;
  
  public XtendFile getXtendFile() {
    return this._xtendFile;
  }
  
  @Inject
  private CommonTypeComputationServices services;
  
  private Map<EObject,Object> identityCache = new Function0<Map<EObject,Object>>() {
    public Map<EObject,Object> apply() {
      HashMap<EObject,Object> _newHashMap = CollectionLiterals.<EObject, Object>newHashMap();
      return _newHashMap;
    }
  }.apply();
  
  private OwnedConverter typeRefConverter;
  
  public void setXtendFile(final XtendFile xtendFile) {
    this._xtendFile = xtendFile;
    Resource _eResource = xtendFile.eResource();
    ResourceSet _resourceSet = _eResource.getResourceSet();
    StandardTypeReferenceOwner _standardTypeReferenceOwner = new StandardTypeReferenceOwner(this.services, _resourceSet);
    OwnedConverter _ownedConverter = new OwnedConverter(_standardTypeReferenceOwner);
    this.typeRefConverter = _ownedConverter;
  }
  
  private <IN extends EObject, OUT extends Object> OUT get(final IN in, final Function1<? super IN,? extends OUT> provider) {
    boolean _containsKey = this.identityCache.containsKey(in);
    if (_containsKey) {
      Object _get = this.identityCache.get(in);
      return ((OUT) _get);
    }
    final OUT result = provider.apply(in);
    this.identityCache.put(in, result);
    return result;
  }
  
  public Visibility toVisibility(final JvmVisibility delegate) {
    Visibility _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(delegate,JvmVisibility.DEFAULT)) {
        _matched=true;
        _switchResult = Visibility.DEFAULT;
      }
    }
    if (!_matched) {
      if (Objects.equal(delegate,JvmVisibility.PRIVATE)) {
        _matched=true;
        _switchResult = Visibility.PRIVATE;
      }
    }
    if (!_matched) {
      if (Objects.equal(delegate,JvmVisibility.PROTECTED)) {
        _matched=true;
        _switchResult = Visibility.PROTECTED;
      }
    }
    if (!_matched) {
      if (Objects.equal(delegate,JvmVisibility.PUBLIC)) {
        _matched=true;
        _switchResult = Visibility.PUBLIC;
      }
    }
    return _switchResult;
  }
  
  public Type toType(final JvmType delegate) {
    final Function1<JvmType,Type> _function = new Function1<JvmType,Type>() {
        public Type apply(final JvmType it) {
          Type _switchResult = null;
          boolean _matched = false;
          if (!_matched) {
            if (delegate instanceof JvmDeclaredType) {
              final JvmDeclaredType _jvmDeclaredType = (JvmDeclaredType)delegate;
              _matched=true;
              TypeDeclaration _typeDeclaration = CompilationUnitImpl.this.toTypeDeclaration(_jvmDeclaredType);
              _switchResult = _typeDeclaration;
            }
          }
          if (!_matched) {
            if (delegate instanceof JvmTypeParameter) {
              final JvmTypeParameter _jvmTypeParameter = (JvmTypeParameter)delegate;
              _matched=true;
              TypeParameterDeclaration _typeParameterDeclaration = CompilationUnitImpl.this.toTypeParameterDeclaration(_jvmTypeParameter);
              _switchResult = _typeParameterDeclaration;
            }
          }
          if (!_matched) {
            if (delegate instanceof JvmVoid) {
              final JvmVoid _jvmVoid = (JvmVoid)delegate;
              _matched=true;
              VoidTypeImpl _voidTypeImpl = new VoidTypeImpl();
              final Procedure1<VoidTypeImpl> _function = new Procedure1<VoidTypeImpl>() {
                  public void apply(final VoidTypeImpl it) {
                    it.setDelegate(_jvmVoid);
                    it.setCompilationUnit(CompilationUnitImpl.this);
                  }
                };
              VoidTypeImpl _doubleArrow = ObjectExtensions.<VoidTypeImpl>operator_doubleArrow(_voidTypeImpl, _function);
              _switchResult = _doubleArrow;
            }
          }
          if (!_matched) {
            if (delegate instanceof JvmPrimitiveType) {
              final JvmPrimitiveType _jvmPrimitiveType = (JvmPrimitiveType)delegate;
              _matched=true;
              PrimitiveTypeImpl _primitiveTypeImpl = new PrimitiveTypeImpl();
              final Procedure1<PrimitiveTypeImpl> _function = new Procedure1<PrimitiveTypeImpl>() {
                  public void apply(final PrimitiveTypeImpl it) {
                    it.setDelegate(_jvmPrimitiveType);
                    it.setCompilationUnit(CompilationUnitImpl.this);
                  }
                };
              PrimitiveTypeImpl _doubleArrow = ObjectExtensions.<PrimitiveTypeImpl>operator_doubleArrow(_primitiveTypeImpl, _function);
              _switchResult = _doubleArrow;
            }
          }
          return _switchResult;
        }
      };
    Type _get = this.<JvmType, Type>get(delegate, _function);
    return _get;
  }
  
  public TypeDeclaration toTypeDeclaration(final JvmDeclaredType delegate) {
    final Function1<JvmDeclaredType,TypeDeclarationJavaImpl<JvmGenericType>> _function = new Function1<JvmDeclaredType,TypeDeclarationJavaImpl<JvmGenericType>>() {
        public TypeDeclarationJavaImpl<JvmGenericType> apply(final JvmDeclaredType it) {
          TypeDeclarationJavaImpl<JvmGenericType> _switchResult = null;
          boolean _matched = false;
          if (!_matched) {
            if (delegate instanceof JvmGenericType) {
              final JvmGenericType _jvmGenericType = (JvmGenericType)delegate;
              boolean _isInterface = _jvmGenericType.isInterface();
              if (_isInterface) {
                _matched=true;
                InterfaceDeclarationJavaImpl _interfaceDeclarationJavaImpl = new InterfaceDeclarationJavaImpl();
                final Procedure1<InterfaceDeclarationJavaImpl> _function = new Procedure1<InterfaceDeclarationJavaImpl>() {
                    public void apply(final InterfaceDeclarationJavaImpl it) {
                      it.setDelegate(_jvmGenericType);
                      it.setCompilationUnit(CompilationUnitImpl.this);
                    }
                  };
                InterfaceDeclarationJavaImpl _doubleArrow = ObjectExtensions.<InterfaceDeclarationJavaImpl>operator_doubleArrow(_interfaceDeclarationJavaImpl, _function);
                _switchResult = _doubleArrow;
              }
            }
          }
          if (!_matched) {
            if (delegate instanceof JvmGenericType) {
              final JvmGenericType _jvmGenericType = (JvmGenericType)delegate;
              _matched=true;
              ClassDeclarationJavaImpl _classDeclarationJavaImpl = new ClassDeclarationJavaImpl();
              final Procedure1<ClassDeclarationJavaImpl> _function = new Procedure1<ClassDeclarationJavaImpl>() {
                  public void apply(final ClassDeclarationJavaImpl it) {
                    it.setDelegate(_jvmGenericType);
                    it.setCompilationUnit(CompilationUnitImpl.this);
                  }
                };
              ClassDeclarationJavaImpl _doubleArrow = ObjectExtensions.<ClassDeclarationJavaImpl>operator_doubleArrow(_classDeclarationJavaImpl, _function);
              _switchResult = _doubleArrow;
            }
          }
          if (!_matched) {
            if (delegate instanceof JvmAnnotationType) {
              final JvmAnnotationType _jvmAnnotationType = (JvmAnnotationType)delegate;
              _matched=true;
              _switchResult = null;
            }
          }
          if (!_matched) {
            if (delegate instanceof JvmEnumerationType) {
              final JvmEnumerationType _jvmEnumerationType = (JvmEnumerationType)delegate;
              _matched=true;
              _switchResult = null;
            }
          }
          return _switchResult;
        }
      };
    TypeDeclarationJavaImpl<JvmGenericType> _get = this.<JvmDeclaredType, TypeDeclarationJavaImpl<JvmGenericType>>get(delegate, _function);
    return _get;
  }
  
  public TypeParameterDeclaration toTypeParameterDeclaration(final JvmTypeParameter delegate) {
    final Function1<JvmTypeParameter,TypeParameterDeclartionImpl> _function = new Function1<JvmTypeParameter,TypeParameterDeclartionImpl>() {
        public TypeParameterDeclartionImpl apply(final JvmTypeParameter it) {
          TypeParameterDeclartionImpl _typeParameterDeclartionImpl = new TypeParameterDeclartionImpl();
          final Procedure1<TypeParameterDeclartionImpl> _function = new Procedure1<TypeParameterDeclartionImpl>() {
              public void apply(final TypeParameterDeclartionImpl it) {
                it.setDelegate(delegate);
                it.setCompilationUnit(CompilationUnitImpl.this);
              }
            };
          TypeParameterDeclartionImpl _doubleArrow = ObjectExtensions.<TypeParameterDeclartionImpl>operator_doubleArrow(_typeParameterDeclartionImpl, _function);
          return _doubleArrow;
        }
      };
    TypeParameterDeclartionImpl _get = this.<JvmTypeParameter, TypeParameterDeclartionImpl>get(delegate, _function);
    return _get;
  }
  
  public ParameterDeclaration toParameterDeclaration(final JvmFormalParameter delegate) {
    final Function1<JvmFormalParameter,ParameterDeclarationJavaImpl> _function = new Function1<JvmFormalParameter,ParameterDeclarationJavaImpl>() {
        public ParameterDeclarationJavaImpl apply(final JvmFormalParameter it) {
          ParameterDeclarationJavaImpl _parameterDeclarationJavaImpl = new ParameterDeclarationJavaImpl();
          final Procedure1<ParameterDeclarationJavaImpl> _function = new Procedure1<ParameterDeclarationJavaImpl>() {
              public void apply(final ParameterDeclarationJavaImpl it) {
                it.setDelegate(delegate);
                it.setCompilationUnit(CompilationUnitImpl.this);
              }
            };
          ParameterDeclarationJavaImpl _doubleArrow = ObjectExtensions.<ParameterDeclarationJavaImpl>operator_doubleArrow(_parameterDeclarationJavaImpl, _function);
          return _doubleArrow;
        }
      };
    ParameterDeclarationJavaImpl _get = this.<JvmFormalParameter, ParameterDeclarationJavaImpl>get(delegate, _function);
    return _get;
  }
  
  public MemberDeclaration toMemberDeclaration(final JvmMember delegate) {
    final Function1<JvmMember,MemberDeclaration> _function = new Function1<JvmMember,MemberDeclaration>() {
        public MemberDeclaration apply(final JvmMember it) {
          MemberDeclaration _switchResult = null;
          boolean _matched = false;
          if (!_matched) {
            if (delegate instanceof JvmDeclaredType) {
              final JvmDeclaredType _jvmDeclaredType = (JvmDeclaredType)delegate;
              _matched=true;
              TypeDeclaration _typeDeclaration = CompilationUnitImpl.this.toTypeDeclaration(_jvmDeclaredType);
              _switchResult = _typeDeclaration;
            }
          }
          if (!_matched) {
            if (delegate instanceof JvmOperation) {
              final JvmOperation _jvmOperation = (JvmOperation)delegate;
              _matched=true;
              MethodDeclarationJavaImpl _methodDeclarationJavaImpl = new MethodDeclarationJavaImpl();
              final Procedure1<MethodDeclarationJavaImpl> _function = new Procedure1<MethodDeclarationJavaImpl>() {
                  public void apply(final MethodDeclarationJavaImpl it) {
                    it.setDelegate(_jvmOperation);
                    it.setCompilationUnit(CompilationUnitImpl.this);
                  }
                };
              MethodDeclarationJavaImpl _doubleArrow = ObjectExtensions.<MethodDeclarationJavaImpl>operator_doubleArrow(_methodDeclarationJavaImpl, _function);
              _switchResult = _doubleArrow;
            }
          }
          if (!_matched) {
            if (delegate instanceof JvmConstructor) {
              final JvmConstructor _jvmConstructor = (JvmConstructor)delegate;
              _matched=true;
              ConstructorDeclarationJavaImpl _constructorDeclarationJavaImpl = new ConstructorDeclarationJavaImpl();
              final Procedure1<ConstructorDeclarationJavaImpl> _function = new Procedure1<ConstructorDeclarationJavaImpl>() {
                  public void apply(final ConstructorDeclarationJavaImpl it) {
                    it.setDelegate(_jvmConstructor);
                    it.setCompilationUnit(CompilationUnitImpl.this);
                  }
                };
              ConstructorDeclarationJavaImpl _doubleArrow = ObjectExtensions.<ConstructorDeclarationJavaImpl>operator_doubleArrow(_constructorDeclarationJavaImpl, _function);
              _switchResult = _doubleArrow;
            }
          }
          if (!_matched) {
            if (delegate instanceof JvmField) {
              final JvmField _jvmField = (JvmField)delegate;
              _matched=true;
              FieldDeclarationJavaImpl _fieldDeclarationJavaImpl = new FieldDeclarationJavaImpl();
              final Procedure1<FieldDeclarationJavaImpl> _function = new Procedure1<FieldDeclarationJavaImpl>() {
                  public void apply(final FieldDeclarationJavaImpl it) {
                    it.setDelegate(_jvmField);
                    it.setCompilationUnit(CompilationUnitImpl.this);
                  }
                };
              FieldDeclarationJavaImpl _doubleArrow = ObjectExtensions.<FieldDeclarationJavaImpl>operator_doubleArrow(_fieldDeclarationJavaImpl, _function);
              _switchResult = _doubleArrow;
            }
          }
          return _switchResult;
        }
      };
    MemberDeclaration _get = this.<JvmMember, MemberDeclaration>get(delegate, _function);
    return _get;
  }
  
  public TypeReference toTypeReference(final JvmTypeReference delegate) {
    TypeReference _xblockexpression = null;
    {
      boolean _equals = ObjectExtensions.operator_equals(delegate, null);
      if (_equals) {
        return null;
      }
      final Function1<JvmTypeReference,TypeReference> _function = new Function1<JvmTypeReference,TypeReference>() {
          public TypeReference apply(final JvmTypeReference it) {
            LightweightTypeReference _lightweightReference = CompilationUnitImpl.this.typeRefConverter.toLightweightReference(delegate);
            TypeReference _typeReference = CompilationUnitImpl.this.toTypeReference(_lightweightReference);
            return _typeReference;
          }
        };
      TypeReference _get = this.<JvmTypeReference, TypeReference>get(delegate, _function);
      _xblockexpression = (_get);
    }
    return _xblockexpression;
  }
  
  public TypeReference toTypeReference(final LightweightTypeReference delegate) {
    TypeReferenceImpl _xblockexpression = null;
    {
      boolean _equals = ObjectExtensions.operator_equals(delegate, null);
      if (_equals) {
        return null;
      }
      TypeReferenceImpl _typeReferenceImpl = new TypeReferenceImpl();
      final Procedure1<TypeReferenceImpl> _function = new Procedure1<TypeReferenceImpl>() {
          public void apply(final TypeReferenceImpl it) {
            it.setDelegate(delegate);
            it.setCompilationUnit(CompilationUnitImpl.this);
          }
        };
      TypeReferenceImpl _doubleArrow = ObjectExtensions.<TypeReferenceImpl>operator_doubleArrow(_typeReferenceImpl, _function);
      _xblockexpression = (_doubleArrow);
    }
    return _xblockexpression;
  }
  
  public TypeDeclaration toTypeDeclaration(final XtendTypeDeclaration delegate) {
    final Function1<XtendTypeDeclaration,ClassDeclarationXtendImpl> _function = new Function1<XtendTypeDeclaration,ClassDeclarationXtendImpl>() {
        public ClassDeclarationXtendImpl apply(final XtendTypeDeclaration it) {
          ClassDeclarationXtendImpl _switchResult = null;
          boolean _matched = false;
          if (!_matched) {
            if (delegate instanceof XtendClass) {
              final XtendClass _xtendClass = (XtendClass)delegate;
              _matched=true;
              ClassDeclarationXtendImpl _classDeclarationXtendImpl = new ClassDeclarationXtendImpl();
              final Procedure1<ClassDeclarationXtendImpl> _function = new Procedure1<ClassDeclarationXtendImpl>() {
                  public void apply(final ClassDeclarationXtendImpl it) {
                    it.setDelegate(_xtendClass);
                    it.setCompilationUnit(CompilationUnitImpl.this);
                  }
                };
              ClassDeclarationXtendImpl _doubleArrow = ObjectExtensions.<ClassDeclarationXtendImpl>operator_doubleArrow(_classDeclarationXtendImpl, _function);
              _switchResult = _doubleArrow;
            }
          }
          return _switchResult;
        }
      };
    ClassDeclarationXtendImpl _get = this.<XtendTypeDeclaration, ClassDeclarationXtendImpl>get(delegate, _function);
    return _get;
  }
  
  public MemberDeclaration toMemberDeclaration(final XtendMember delegate) {
    final Function1<XtendMember,MemberDeclaration> _function = new Function1<XtendMember,MemberDeclaration>() {
        public MemberDeclaration apply(final XtendMember it) {
          MemberDeclaration _switchResult = null;
          boolean _matched = false;
          if (!_matched) {
            if (delegate instanceof XtendTypeDeclaration) {
              final XtendTypeDeclaration _xtendTypeDeclaration = (XtendTypeDeclaration)delegate;
              _matched=true;
              TypeDeclaration _typeDeclaration = CompilationUnitImpl.this.toTypeDeclaration(_xtendTypeDeclaration);
              _switchResult = _typeDeclaration;
            }
          }
          if (!_matched) {
            if (delegate instanceof XtendFunction) {
              final XtendFunction _xtendFunction = (XtendFunction)delegate;
              _matched=true;
              MethodDeclarationXtendImpl _methodDeclarationXtendImpl = new MethodDeclarationXtendImpl();
              final Procedure1<MethodDeclarationXtendImpl> _function = new Procedure1<MethodDeclarationXtendImpl>() {
                  public void apply(final MethodDeclarationXtendImpl it) {
                    it.setDelegate(_xtendFunction);
                    it.setCompilationUnit(CompilationUnitImpl.this);
                  }
                };
              MethodDeclarationXtendImpl _doubleArrow = ObjectExtensions.<MethodDeclarationXtendImpl>operator_doubleArrow(_methodDeclarationXtendImpl, _function);
              _switchResult = _doubleArrow;
            }
          }
          if (!_matched) {
            if (delegate instanceof XtendConstructor) {
              final XtendConstructor _xtendConstructor = (XtendConstructor)delegate;
              _matched=true;
              ConstructorDeclarationXtendImpl _constructorDeclarationXtendImpl = new ConstructorDeclarationXtendImpl();
              final Procedure1<ConstructorDeclarationXtendImpl> _function = new Procedure1<ConstructorDeclarationXtendImpl>() {
                  public void apply(final ConstructorDeclarationXtendImpl it) {
                    it.setDelegate(_xtendConstructor);
                    it.setCompilationUnit(CompilationUnitImpl.this);
                  }
                };
              ConstructorDeclarationXtendImpl _doubleArrow = ObjectExtensions.<ConstructorDeclarationXtendImpl>operator_doubleArrow(_constructorDeclarationXtendImpl, _function);
              _switchResult = _doubleArrow;
            }
          }
          if (!_matched) {
            if (delegate instanceof XtendField) {
              final XtendField _xtendField = (XtendField)delegate;
              _matched=true;
              FieldDeclarationXtendImpl _fieldDeclarationXtendImpl = new FieldDeclarationXtendImpl();
              final Procedure1<FieldDeclarationXtendImpl> _function = new Procedure1<FieldDeclarationXtendImpl>() {
                  public void apply(final FieldDeclarationXtendImpl it) {
                    it.setDelegate(_xtendField);
                    it.setCompilationUnit(CompilationUnitImpl.this);
                  }
                };
              FieldDeclarationXtendImpl _doubleArrow = ObjectExtensions.<FieldDeclarationXtendImpl>operator_doubleArrow(_fieldDeclarationXtendImpl, _function);
              _switchResult = _doubleArrow;
            }
          }
          return _switchResult;
        }
      };
    MemberDeclaration _get = this.<XtendMember, MemberDeclaration>get(delegate, _function);
    return _get;
  }
  
  public ParameterDeclaration toParameterDeclaration(final XtendParameter delegate) {
    final Function1<XtendParameter,ParameterDeclarationXtendImpl> _function = new Function1<XtendParameter,ParameterDeclarationXtendImpl>() {
        public ParameterDeclarationXtendImpl apply(final XtendParameter it) {
          ParameterDeclarationXtendImpl _parameterDeclarationXtendImpl = new ParameterDeclarationXtendImpl();
          final Procedure1<ParameterDeclarationXtendImpl> _function = new Procedure1<ParameterDeclarationXtendImpl>() {
              public void apply(final ParameterDeclarationXtendImpl it) {
                it.setDelegate(delegate);
                it.setCompilationUnit(CompilationUnitImpl.this);
              }
            };
          ParameterDeclarationXtendImpl _doubleArrow = ObjectExtensions.<ParameterDeclarationXtendImpl>operator_doubleArrow(_parameterDeclarationXtendImpl, _function);
          return _doubleArrow;
        }
      };
    ParameterDeclarationXtendImpl _get = this.<XtendParameter, ParameterDeclarationXtendImpl>get(delegate, _function);
    return _get;
  }
}
