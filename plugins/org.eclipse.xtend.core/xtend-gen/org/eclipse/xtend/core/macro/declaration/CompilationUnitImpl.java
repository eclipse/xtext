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
import org.eclipse.xtend.core.macro.declaration.ConstructorDeclarationJavaImpl;
import org.eclipse.xtend.core.macro.declaration.FieldDeclarationJavaImpl;
import org.eclipse.xtend.core.macro.declaration.GeneratedClassDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.GeneratedConstructorDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.GeneratedFieldDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.GeneratedMethodDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.GeneratedParameterDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.GeneratedTypeParameterDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.InterfaceDeclarationJavaImpl;
import org.eclipse.xtend.core.macro.declaration.MethodDeclarationJavaImpl;
import org.eclipse.xtend.core.macro.declaration.ParameterDeclarationJavaImpl;
import org.eclipse.xtend.core.macro.declaration.PrimitiveTypeImpl;
import org.eclipse.xtend.core.macro.declaration.SourceClassDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.SourceConstructorDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.SourceFieldDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.SourceMethodDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.SourceParameterDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.SourceTypeParameterDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.TypeParameterDeclarationImpl;
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
import org.eclipse.xtend.lib.macro.declaration.ConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.GeneratedClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.GeneratedTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.SourceClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.SourceMemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.SourceParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.SourceTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.SourceTypeParameterDeclaration;
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
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
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
  
  public List<SourceTypeDeclaration> getSourceTypeDeclarations() {
    XtendFile _xtendFile = this.getXtendFile();
    EList<XtendTypeDeclaration> _xtendTypes = _xtendFile.getXtendTypes();
    final Function1<XtendTypeDeclaration,SourceTypeDeclaration> _function = new Function1<XtendTypeDeclaration,SourceTypeDeclaration>() {
        public SourceTypeDeclaration apply(final XtendTypeDeclaration it) {
          SourceTypeDeclaration _sourceTypeDeclaration = CompilationUnitImpl.this.toSourceTypeDeclaration(it);
          return _sourceTypeDeclaration;
        }
      };
    List<SourceTypeDeclaration> _map = ListExtensions.<XtendTypeDeclaration, SourceTypeDeclaration>map(_xtendTypes, _function);
    return _map;
  }
  
  public List<SourceClassDeclaration> getSourceClassDeclarations() {
    List<SourceTypeDeclaration> _sourceTypeDeclarations = this.getSourceTypeDeclarations();
    Iterable<SourceClassDeclaration> _filter = Iterables.<SourceClassDeclaration>filter(_sourceTypeDeclarations, SourceClassDeclaration.class);
    List<SourceClassDeclaration> _list = IterableExtensions.<SourceClassDeclaration>toList(_filter);
    return _list;
  }
  
  public List<GeneratedTypeDeclaration> getGeneratedTypeDeclarations() {
    XtendFile _xtendFile = this.getXtendFile();
    Resource _eResource = _xtendFile.eResource();
    EList<EObject> _contents = _eResource.getContents();
    Iterable<JvmDeclaredType> _filter = Iterables.<JvmDeclaredType>filter(_contents, JvmDeclaredType.class);
    final Function1<JvmDeclaredType,GeneratedTypeDeclaration> _function = new Function1<JvmDeclaredType,GeneratedTypeDeclaration>() {
        public GeneratedTypeDeclaration apply(final JvmDeclaredType it) {
          TypeDeclaration _typeDeclaration = CompilationUnitImpl.this.toTypeDeclaration(it);
          return ((GeneratedTypeDeclaration) _typeDeclaration);
        }
      };
    Iterable<GeneratedTypeDeclaration> _map = IterableExtensions.<JvmDeclaredType, GeneratedTypeDeclaration>map(_filter, _function);
    List<GeneratedTypeDeclaration> _list = IterableExtensions.<GeneratedTypeDeclaration>toList(_map);
    return _list;
  }
  
  public List<GeneratedClassDeclaration> getGeneratedClassDeclarations() {
    List<GeneratedTypeDeclaration> _generatedTypeDeclarations = this.getGeneratedTypeDeclarations();
    Iterable<GeneratedClassDeclaration> _filter = Iterables.<GeneratedClassDeclaration>filter(_generatedTypeDeclarations, GeneratedClassDeclaration.class);
    List<GeneratedClassDeclaration> _list = IterableExtensions.<GeneratedClassDeclaration>toList(_filter);
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
  
  private boolean isGenerated(final JvmIdentifiableElement element) {
    Resource _eResource = element.eResource();
    XtendFile _xtendFile = this.getXtendFile();
    Resource _eResource_1 = _xtendFile.eResource();
    boolean _equals = ObjectExtensions.operator_equals(_eResource, _eResource_1);
    return _equals;
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
    final Function1<JvmDeclaredType,Object> _function = new Function1<JvmDeclaredType,Object>() {
        public Object apply(final JvmDeclaredType it) {
          Object _switchResult = null;
          boolean _matched = false;
          if (!_matched) {
            if (delegate instanceof JvmGenericType) {
              final JvmGenericType _jvmGenericType = (JvmGenericType)delegate;
              boolean _isInterface = _jvmGenericType.isInterface();
              if (_isInterface) {
                _matched=true;
                InterfaceDeclarationJavaImpl _xifexpression = null;
                boolean _isGenerated = CompilationUnitImpl.this.isGenerated(_jvmGenericType);
                if (_isGenerated) {
                  _xifexpression = null;
                } else {
                  InterfaceDeclarationJavaImpl _interfaceDeclarationJavaImpl = new InterfaceDeclarationJavaImpl();
                  final Procedure1<InterfaceDeclarationJavaImpl> _function = new Procedure1<InterfaceDeclarationJavaImpl>() {
                      public void apply(final InterfaceDeclarationJavaImpl it) {
                        it.setDelegate(_jvmGenericType);
                        it.setCompilationUnit(CompilationUnitImpl.this);
                      }
                    };
                  InterfaceDeclarationJavaImpl _doubleArrow = ObjectExtensions.<InterfaceDeclarationJavaImpl>operator_doubleArrow(_interfaceDeclarationJavaImpl, _function);
                  _xifexpression = _doubleArrow;
                }
                _switchResult = _xifexpression;
              }
            }
          }
          if (!_matched) {
            if (delegate instanceof JvmGenericType) {
              final JvmGenericType _jvmGenericType = (JvmGenericType)delegate;
              _matched=true;
              Object _xifexpression = null;
              boolean _isGenerated = CompilationUnitImpl.this.isGenerated(_jvmGenericType);
              if (_isGenerated) {
                GeneratedClassDeclarationImpl _generatedClassDeclarationImpl = new GeneratedClassDeclarationImpl();
                final Procedure1<GeneratedClassDeclarationImpl> _function = new Procedure1<GeneratedClassDeclarationImpl>() {
                    public void apply(final GeneratedClassDeclarationImpl it) {
                      it.setDelegate(_jvmGenericType);
                      it.setCompilationUnit(CompilationUnitImpl.this);
                    }
                  };
                GeneratedClassDeclarationImpl _doubleArrow = ObjectExtensions.<GeneratedClassDeclarationImpl>operator_doubleArrow(_generatedClassDeclarationImpl, _function);
                _xifexpression = _doubleArrow;
              } else {
                ClassDeclarationJavaImpl _classDeclarationJavaImpl = new ClassDeclarationJavaImpl();
                final Procedure1<ClassDeclarationJavaImpl> _function_1 = new Procedure1<ClassDeclarationJavaImpl>() {
                    public void apply(final ClassDeclarationJavaImpl it) {
                      it.setDelegate(_jvmGenericType);
                      it.setCompilationUnit(CompilationUnitImpl.this);
                    }
                  };
                ClassDeclarationJavaImpl _doubleArrow_1 = ObjectExtensions.<ClassDeclarationJavaImpl>operator_doubleArrow(_classDeclarationJavaImpl, _function_1);
                _xifexpression = _doubleArrow_1;
              }
              _switchResult = _xifexpression;
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
    Object _get = this.<JvmDeclaredType, Object>get(delegate, _function);
    return ((TypeDeclaration)_get);
  }
  
  public TypeParameterDeclaration toTypeParameterDeclaration(final JvmTypeParameter delegate) {
    final Function1<JvmTypeParameter,TypeParameterDeclarationImpl> _function = new Function1<JvmTypeParameter,TypeParameterDeclarationImpl>() {
        public TypeParameterDeclarationImpl apply(final JvmTypeParameter it) {
          TypeParameterDeclarationImpl _xifexpression = null;
          boolean _isGenerated = CompilationUnitImpl.this.isGenerated(delegate);
          if (_isGenerated) {
            GeneratedTypeParameterDeclarationImpl _generatedTypeParameterDeclarationImpl = new GeneratedTypeParameterDeclarationImpl();
            final Procedure1<GeneratedTypeParameterDeclarationImpl> _function = new Procedure1<GeneratedTypeParameterDeclarationImpl>() {
                public void apply(final GeneratedTypeParameterDeclarationImpl it) {
                  it.setDelegate(delegate);
                  it.setCompilationUnit(CompilationUnitImpl.this);
                }
              };
            GeneratedTypeParameterDeclarationImpl _doubleArrow = ObjectExtensions.<GeneratedTypeParameterDeclarationImpl>operator_doubleArrow(_generatedTypeParameterDeclarationImpl, _function);
            _xifexpression = _doubleArrow;
          } else {
            TypeParameterDeclarationImpl _typeParameterDeclarationImpl = new TypeParameterDeclarationImpl();
            final Procedure1<TypeParameterDeclarationImpl> _function_1 = new Procedure1<TypeParameterDeclarationImpl>() {
                public void apply(final TypeParameterDeclarationImpl it) {
                  it.setDelegate(delegate);
                  it.setCompilationUnit(CompilationUnitImpl.this);
                }
              };
            TypeParameterDeclarationImpl _doubleArrow_1 = ObjectExtensions.<TypeParameterDeclarationImpl>operator_doubleArrow(_typeParameterDeclarationImpl, _function_1);
            _xifexpression = _doubleArrow_1;
          }
          return _xifexpression;
        }
      };
    TypeParameterDeclarationImpl _get = this.<JvmTypeParameter, TypeParameterDeclarationImpl>get(delegate, _function);
    return _get;
  }
  
  public ParameterDeclaration toParameterDeclaration(final JvmFormalParameter delegate) {
    final Function1<JvmFormalParameter,Object> _function = new Function1<JvmFormalParameter,Object>() {
        public Object apply(final JvmFormalParameter it) {
          Object _xifexpression = null;
          boolean _isGenerated = CompilationUnitImpl.this.isGenerated(delegate);
          if (_isGenerated) {
            GeneratedParameterDeclarationImpl _generatedParameterDeclarationImpl = new GeneratedParameterDeclarationImpl();
            final Procedure1<GeneratedParameterDeclarationImpl> _function = new Procedure1<GeneratedParameterDeclarationImpl>() {
                public void apply(final GeneratedParameterDeclarationImpl it) {
                  it.setDelegate(delegate);
                  it.setCompilationUnit(CompilationUnitImpl.this);
                }
              };
            GeneratedParameterDeclarationImpl _doubleArrow = ObjectExtensions.<GeneratedParameterDeclarationImpl>operator_doubleArrow(_generatedParameterDeclarationImpl, _function);
            _xifexpression = _doubleArrow;
          } else {
            ParameterDeclarationJavaImpl _parameterDeclarationJavaImpl = new ParameterDeclarationJavaImpl();
            final Procedure1<ParameterDeclarationJavaImpl> _function_1 = new Procedure1<ParameterDeclarationJavaImpl>() {
                public void apply(final ParameterDeclarationJavaImpl it) {
                  it.setDelegate(delegate);
                  it.setCompilationUnit(CompilationUnitImpl.this);
                }
              };
            ParameterDeclarationJavaImpl _doubleArrow_1 = ObjectExtensions.<ParameterDeclarationJavaImpl>operator_doubleArrow(_parameterDeclarationJavaImpl, _function_1);
            _xifexpression = _doubleArrow_1;
          }
          return _xifexpression;
        }
      };
    Object _get = this.<JvmFormalParameter, Object>get(delegate, _function);
    return ((ParameterDeclaration)_get);
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
              Object _xifexpression = null;
              boolean _isGenerated = CompilationUnitImpl.this.isGenerated(_jvmOperation);
              if (_isGenerated) {
                GeneratedMethodDeclarationImpl _generatedMethodDeclarationImpl = new GeneratedMethodDeclarationImpl();
                final Procedure1<GeneratedMethodDeclarationImpl> _function = new Procedure1<GeneratedMethodDeclarationImpl>() {
                    public void apply(final GeneratedMethodDeclarationImpl it) {
                      it.setDelegate(_jvmOperation);
                      it.setCompilationUnit(CompilationUnitImpl.this);
                    }
                  };
                GeneratedMethodDeclarationImpl _doubleArrow = ObjectExtensions.<GeneratedMethodDeclarationImpl>operator_doubleArrow(_generatedMethodDeclarationImpl, _function);
                _xifexpression = _doubleArrow;
              } else {
                MethodDeclarationJavaImpl _methodDeclarationJavaImpl = new MethodDeclarationJavaImpl();
                final Procedure1<MethodDeclarationJavaImpl> _function_1 = new Procedure1<MethodDeclarationJavaImpl>() {
                    public void apply(final MethodDeclarationJavaImpl it) {
                      it.setDelegate(_jvmOperation);
                      it.setCompilationUnit(CompilationUnitImpl.this);
                    }
                  };
                MethodDeclarationJavaImpl _doubleArrow_1 = ObjectExtensions.<MethodDeclarationJavaImpl>operator_doubleArrow(_methodDeclarationJavaImpl, _function_1);
                _xifexpression = _doubleArrow_1;
              }
              _switchResult = ((MemberDeclaration) ((MethodDeclaration)_xifexpression));
            }
          }
          if (!_matched) {
            if (delegate instanceof JvmConstructor) {
              final JvmConstructor _jvmConstructor = (JvmConstructor)delegate;
              _matched=true;
              Object _xifexpression = null;
              boolean _isGenerated = CompilationUnitImpl.this.isGenerated(_jvmConstructor);
              if (_isGenerated) {
                GeneratedConstructorDeclarationImpl _generatedConstructorDeclarationImpl = new GeneratedConstructorDeclarationImpl();
                final Procedure1<GeneratedConstructorDeclarationImpl> _function = new Procedure1<GeneratedConstructorDeclarationImpl>() {
                    public void apply(final GeneratedConstructorDeclarationImpl it) {
                      it.setDelegate(_jvmConstructor);
                      it.setCompilationUnit(CompilationUnitImpl.this);
                    }
                  };
                GeneratedConstructorDeclarationImpl _doubleArrow = ObjectExtensions.<GeneratedConstructorDeclarationImpl>operator_doubleArrow(_generatedConstructorDeclarationImpl, _function);
                _xifexpression = _doubleArrow;
              } else {
                ConstructorDeclarationJavaImpl _constructorDeclarationJavaImpl = new ConstructorDeclarationJavaImpl();
                final Procedure1<ConstructorDeclarationJavaImpl> _function_1 = new Procedure1<ConstructorDeclarationJavaImpl>() {
                    public void apply(final ConstructorDeclarationJavaImpl it) {
                      it.setDelegate(_jvmConstructor);
                      it.setCompilationUnit(CompilationUnitImpl.this);
                    }
                  };
                ConstructorDeclarationJavaImpl _doubleArrow_1 = ObjectExtensions.<ConstructorDeclarationJavaImpl>operator_doubleArrow(_constructorDeclarationJavaImpl, _function_1);
                _xifexpression = _doubleArrow_1;
              }
              _switchResult = ((MemberDeclaration) ((ConstructorDeclaration)_xifexpression));
            }
          }
          if (!_matched) {
            if (delegate instanceof JvmField) {
              final JvmField _jvmField = (JvmField)delegate;
              _matched=true;
              Object _xifexpression = null;
              boolean _isGenerated = CompilationUnitImpl.this.isGenerated(_jvmField);
              if (_isGenerated) {
                GeneratedFieldDeclarationImpl _generatedFieldDeclarationImpl = new GeneratedFieldDeclarationImpl();
                final Procedure1<GeneratedFieldDeclarationImpl> _function = new Procedure1<GeneratedFieldDeclarationImpl>() {
                    public void apply(final GeneratedFieldDeclarationImpl it) {
                      it.setDelegate(_jvmField);
                      it.setCompilationUnit(CompilationUnitImpl.this);
                    }
                  };
                GeneratedFieldDeclarationImpl _doubleArrow = ObjectExtensions.<GeneratedFieldDeclarationImpl>operator_doubleArrow(_generatedFieldDeclarationImpl, _function);
                _xifexpression = _doubleArrow;
              } else {
                FieldDeclarationJavaImpl _fieldDeclarationJavaImpl = new FieldDeclarationJavaImpl();
                final Procedure1<FieldDeclarationJavaImpl> _function_1 = new Procedure1<FieldDeclarationJavaImpl>() {
                    public void apply(final FieldDeclarationJavaImpl it) {
                      it.setDelegate(_jvmField);
                      it.setCompilationUnit(CompilationUnitImpl.this);
                    }
                  };
                FieldDeclarationJavaImpl _doubleArrow_1 = ObjectExtensions.<FieldDeclarationJavaImpl>operator_doubleArrow(_fieldDeclarationJavaImpl, _function_1);
                _xifexpression = _doubleArrow_1;
              }
              _switchResult = ((MemberDeclaration) ((FieldDeclaration)_xifexpression));
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
  
  public SourceTypeDeclaration toSourceTypeDeclaration(final XtendTypeDeclaration delegate) {
    final Function1<XtendTypeDeclaration,SourceClassDeclarationImpl> _function = new Function1<XtendTypeDeclaration,SourceClassDeclarationImpl>() {
        public SourceClassDeclarationImpl apply(final XtendTypeDeclaration it) {
          SourceClassDeclarationImpl _switchResult = null;
          boolean _matched = false;
          if (!_matched) {
            if (delegate instanceof XtendClass) {
              final XtendClass _xtendClass = (XtendClass)delegate;
              _matched=true;
              SourceClassDeclarationImpl _sourceClassDeclarationImpl = new SourceClassDeclarationImpl();
              final Procedure1<SourceClassDeclarationImpl> _function = new Procedure1<SourceClassDeclarationImpl>() {
                  public void apply(final SourceClassDeclarationImpl it) {
                    it.setDelegate(_xtendClass);
                    it.setCompilationUnit(CompilationUnitImpl.this);
                  }
                };
              SourceClassDeclarationImpl _doubleArrow = ObjectExtensions.<SourceClassDeclarationImpl>operator_doubleArrow(_sourceClassDeclarationImpl, _function);
              _switchResult = _doubleArrow;
            }
          }
          return _switchResult;
        }
      };
    SourceClassDeclarationImpl _get = this.<XtendTypeDeclaration, SourceClassDeclarationImpl>get(delegate, _function);
    return _get;
  }
  
  public SourceMemberDeclaration toSourceMemberDeclaration(final XtendMember delegate) {
    final Function1<XtendMember,SourceMemberDeclaration> _function = new Function1<XtendMember,SourceMemberDeclaration>() {
        public SourceMemberDeclaration apply(final XtendMember it) {
          SourceMemberDeclaration _switchResult = null;
          boolean _matched = false;
          if (!_matched) {
            if (delegate instanceof XtendTypeDeclaration) {
              final XtendTypeDeclaration _xtendTypeDeclaration = (XtendTypeDeclaration)delegate;
              _matched=true;
              SourceTypeDeclaration _sourceTypeDeclaration = CompilationUnitImpl.this.toSourceTypeDeclaration(_xtendTypeDeclaration);
              _switchResult = _sourceTypeDeclaration;
            }
          }
          if (!_matched) {
            if (delegate instanceof XtendFunction) {
              final XtendFunction _xtendFunction = (XtendFunction)delegate;
              _matched=true;
              SourceMethodDeclarationImpl _sourceMethodDeclarationImpl = new SourceMethodDeclarationImpl();
              final Procedure1<SourceMethodDeclarationImpl> _function = new Procedure1<SourceMethodDeclarationImpl>() {
                  public void apply(final SourceMethodDeclarationImpl it) {
                    it.setDelegate(_xtendFunction);
                    it.setCompilationUnit(CompilationUnitImpl.this);
                  }
                };
              SourceMethodDeclarationImpl _doubleArrow = ObjectExtensions.<SourceMethodDeclarationImpl>operator_doubleArrow(_sourceMethodDeclarationImpl, _function);
              _switchResult = _doubleArrow;
            }
          }
          if (!_matched) {
            if (delegate instanceof XtendConstructor) {
              final XtendConstructor _xtendConstructor = (XtendConstructor)delegate;
              _matched=true;
              SourceConstructorDeclarationImpl _sourceConstructorDeclarationImpl = new SourceConstructorDeclarationImpl();
              final Procedure1<SourceConstructorDeclarationImpl> _function = new Procedure1<SourceConstructorDeclarationImpl>() {
                  public void apply(final SourceConstructorDeclarationImpl it) {
                    it.setDelegate(_xtendConstructor);
                    it.setCompilationUnit(CompilationUnitImpl.this);
                  }
                };
              SourceConstructorDeclarationImpl _doubleArrow = ObjectExtensions.<SourceConstructorDeclarationImpl>operator_doubleArrow(_sourceConstructorDeclarationImpl, _function);
              _switchResult = _doubleArrow;
            }
          }
          if (!_matched) {
            if (delegate instanceof XtendField) {
              final XtendField _xtendField = (XtendField)delegate;
              _matched=true;
              SourceFieldDeclarationImpl _sourceFieldDeclarationImpl = new SourceFieldDeclarationImpl();
              final Procedure1<SourceFieldDeclarationImpl> _function = new Procedure1<SourceFieldDeclarationImpl>() {
                  public void apply(final SourceFieldDeclarationImpl it) {
                    it.setDelegate(_xtendField);
                    it.setCompilationUnit(CompilationUnitImpl.this);
                  }
                };
              SourceFieldDeclarationImpl _doubleArrow = ObjectExtensions.<SourceFieldDeclarationImpl>operator_doubleArrow(_sourceFieldDeclarationImpl, _function);
              _switchResult = _doubleArrow;
            }
          }
          return _switchResult;
        }
      };
    SourceMemberDeclaration _get = this.<XtendMember, SourceMemberDeclaration>get(delegate, _function);
    return _get;
  }
  
  public SourceParameterDeclaration toSourceParameterDeclaration(final XtendParameter delegate) {
    final Function1<XtendParameter,SourceParameterDeclarationImpl> _function = new Function1<XtendParameter,SourceParameterDeclarationImpl>() {
        public SourceParameterDeclarationImpl apply(final XtendParameter it) {
          SourceParameterDeclarationImpl _sourceParameterDeclarationImpl = new SourceParameterDeclarationImpl();
          final Procedure1<SourceParameterDeclarationImpl> _function = new Procedure1<SourceParameterDeclarationImpl>() {
              public void apply(final SourceParameterDeclarationImpl it) {
                it.setDelegate(delegate);
                it.setCompilationUnit(CompilationUnitImpl.this);
              }
            };
          SourceParameterDeclarationImpl _doubleArrow = ObjectExtensions.<SourceParameterDeclarationImpl>operator_doubleArrow(_sourceParameterDeclarationImpl, _function);
          return _doubleArrow;
        }
      };
    SourceParameterDeclarationImpl _get = this.<XtendParameter, SourceParameterDeclarationImpl>get(delegate, _function);
    return _get;
  }
  
  public SourceTypeParameterDeclaration toSourceTypeParameterDeclaration(final JvmTypeParameter delegate) {
    final Function1<JvmTypeParameter,SourceTypeParameterDeclarationImpl> _function = new Function1<JvmTypeParameter,SourceTypeParameterDeclarationImpl>() {
        public SourceTypeParameterDeclarationImpl apply(final JvmTypeParameter it) {
          SourceTypeParameterDeclarationImpl _sourceTypeParameterDeclarationImpl = new SourceTypeParameterDeclarationImpl();
          final Procedure1<SourceTypeParameterDeclarationImpl> _function = new Procedure1<SourceTypeParameterDeclarationImpl>() {
              public void apply(final SourceTypeParameterDeclarationImpl it) {
                it.setDelegate(delegate);
                it.setCompilationUnit(CompilationUnitImpl.this);
              }
            };
          SourceTypeParameterDeclarationImpl _doubleArrow = ObjectExtensions.<SourceTypeParameterDeclarationImpl>operator_doubleArrow(_sourceTypeParameterDeclarationImpl, _function);
          return _doubleArrow;
        }
      };
    SourceTypeParameterDeclarationImpl _get = this.<JvmTypeParameter, SourceTypeParameterDeclarationImpl>get(delegate, _function);
    return _get;
  }
}
