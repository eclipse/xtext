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
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.macro.CompilationContextImpl;
import org.eclipse.xtend.core.macro.declaration.JvmClassDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.JvmConstructorDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.JvmFieldDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.JvmMethodDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.JvmNamedElementImpl;
import org.eclipse.xtend.core.macro.declaration.JvmParameterDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.JvmTypeDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.JvmTypeParameterDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.PrimitiveTypeImpl;
import org.eclipse.xtend.core.macro.declaration.ProblemImpl;
import org.eclipse.xtend.core.macro.declaration.TypeReferenceImpl;
import org.eclipse.xtend.core.macro.declaration.VoidTypeImpl;
import org.eclipse.xtend.core.macro.declaration.XtendClassDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.XtendConstructorDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.XtendFieldDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.XtendMemberDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.XtendMethodDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.XtendNamedElementImpl;
import org.eclipse.xtend.core.macro.declaration.XtendParameterDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.XtendTypeDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.XtendTypeParameterDeclarationImpl;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.lib.macro.CompilationContext;
import org.eclipse.xtend.lib.macro.Problem;
import org.eclipse.xtend.lib.macro.ProblemSupport;
import org.eclipse.xtend.lib.macro.TypeReferenceProvider;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.CompilationUnit;
import org.eclipse.xtend.lib.macro.declaration.Element;
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.PrimitiveType.Kind;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Visibility;
import org.eclipse.xtend.lib.macro.type.TypeReference;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmComponentType;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.JvmVoid;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.validation.EObjectDiagnosticImpl;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer2;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.typesystem.legacy.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;

@SuppressWarnings("all")
public class CompilationUnitImpl implements CompilationUnit, TypeReferenceProvider, ProblemSupport {
  public String getDocComment() {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-generated function stub");
    throw _unsupportedOperationException;
  }
  
  public String getPackageName() {
    XtendFile _xtendFile = this.getXtendFile();
    String _package = _xtendFile.getPackage();
    return _package;
  }
  
  public List<? extends TypeDeclaration> getSourceTypeDeclarations() {
    XtendFile _xtendFile = this.getXtendFile();
    EList<XtendTypeDeclaration> _xtendTypes = _xtendFile.getXtendTypes();
    final Function1<XtendTypeDeclaration,XtendTypeDeclarationImpl<? extends XtendTypeDeclaration>> _function = new Function1<XtendTypeDeclaration,XtendTypeDeclarationImpl<? extends XtendTypeDeclaration>>() {
        public XtendTypeDeclarationImpl<? extends XtendTypeDeclaration> apply(final XtendTypeDeclaration it) {
          XtendTypeDeclarationImpl<? extends XtendTypeDeclaration> _xtendTypeDeclaration = CompilationUnitImpl.this.toXtendTypeDeclaration(it);
          return _xtendTypeDeclaration;
        }
      };
    List<XtendTypeDeclarationImpl<? extends XtendTypeDeclaration>> _map = ListExtensions.<XtendTypeDeclaration, XtendTypeDeclarationImpl<? extends XtendTypeDeclaration>>map(_xtendTypes, _function);
    return _map;
  }
  
  public List<? extends ClassDeclaration> getSourceClassDeclarations() {
    List<? extends TypeDeclaration> _sourceTypeDeclarations = this.getSourceTypeDeclarations();
    Iterable<XtendClassDeclarationImpl> _filter = Iterables.<XtendClassDeclarationImpl>filter(_sourceTypeDeclarations, XtendClassDeclarationImpl.class);
    List<XtendClassDeclarationImpl> _list = IterableExtensions.<XtendClassDeclarationImpl>toList(_filter);
    return _list;
  }
  
  public List<? extends TypeDeclaration> getGeneratedTypeDeclarations() {
    XtendFile _xtendFile = this.getXtendFile();
    Resource _eResource = _xtendFile.eResource();
    EList<EObject> _contents = _eResource.getContents();
    Iterable<JvmDeclaredType> _filter = Iterables.<JvmDeclaredType>filter(_contents, JvmDeclaredType.class);
    final Function1<JvmDeclaredType,MutableTypeDeclaration> _function = new Function1<JvmDeclaredType,MutableTypeDeclaration>() {
        public MutableTypeDeclaration apply(final JvmDeclaredType it) {
          TypeDeclaration _typeDeclaration = CompilationUnitImpl.this.toTypeDeclaration(it);
          return ((MutableTypeDeclaration) _typeDeclaration);
        }
      };
    Iterable<MutableTypeDeclaration> _map = IterableExtensions.<JvmDeclaredType, MutableTypeDeclaration>map(_filter, _function);
    List<MutableTypeDeclaration> _list = IterableExtensions.<MutableTypeDeclaration>toList(_map);
    return _list;
  }
  
  public List<? extends ClassDeclaration> getGeneratedClassDeclarations() {
    List<? extends TypeDeclaration> _generatedTypeDeclarations = this.getGeneratedTypeDeclarations();
    Iterable<MutableClassDeclaration> _filter = Iterables.<MutableClassDeclaration>filter(_generatedTypeDeclarations, MutableClassDeclaration.class);
    List<MutableClassDeclaration> _list = IterableExtensions.<MutableClassDeclaration>toList(_filter);
    return _list;
  }
  
  private XtendFile _xtendFile;
  
  public XtendFile getXtendFile() {
    return this._xtendFile;
  }
  
  @Inject
  private CommonTypeComputationServices services;
  
  @Inject
  private TypeReferences typeReferences;
  
  @Inject
  private JvmTypesBuilder typesBuilder;
  
  @Inject
  private TypeReferenceSerializer2 typeRefSerializer;
  
  @Inject
  private IXtendJvmAssociations associations;
  
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
    final Function1<JvmDeclaredType,JvmClassDeclarationImpl> _function = new Function1<JvmDeclaredType,JvmClassDeclarationImpl>() {
        public JvmClassDeclarationImpl apply(final JvmDeclaredType it) {
          JvmClassDeclarationImpl _switchResult = null;
          boolean _matched = false;
          if (!_matched) {
            if (delegate instanceof JvmGenericType) {
              final JvmGenericType _jvmGenericType = (JvmGenericType)delegate;
              boolean _isInterface = _jvmGenericType.isInterface();
              if (_isInterface) {
                _matched=true;
                _switchResult = null;
              }
            }
          }
          if (!_matched) {
            if (delegate instanceof JvmGenericType) {
              final JvmGenericType _jvmGenericType = (JvmGenericType)delegate;
              _matched=true;
              JvmClassDeclarationImpl _jvmClassDeclarationImpl = new JvmClassDeclarationImpl();
              final Procedure1<JvmClassDeclarationImpl> _function = new Procedure1<JvmClassDeclarationImpl>() {
                  public void apply(final JvmClassDeclarationImpl it) {
                    it.setDelegate(_jvmGenericType);
                    it.setCompilationUnit(CompilationUnitImpl.this);
                  }
                };
              JvmClassDeclarationImpl _doubleArrow = ObjectExtensions.<JvmClassDeclarationImpl>operator_doubleArrow(_jvmClassDeclarationImpl, _function);
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
    JvmClassDeclarationImpl _get = this.<JvmDeclaredType, JvmClassDeclarationImpl>get(delegate, _function);
    return _get;
  }
  
  public TypeParameterDeclaration toTypeParameterDeclaration(final JvmTypeParameter delegate) {
    final Function1<JvmTypeParameter,JvmTypeParameterDeclarationImpl> _function = new Function1<JvmTypeParameter,JvmTypeParameterDeclarationImpl>() {
        public JvmTypeParameterDeclarationImpl apply(final JvmTypeParameter it) {
          JvmTypeParameterDeclarationImpl _jvmTypeParameterDeclarationImpl = new JvmTypeParameterDeclarationImpl();
          final Procedure1<JvmTypeParameterDeclarationImpl> _function = new Procedure1<JvmTypeParameterDeclarationImpl>() {
              public void apply(final JvmTypeParameterDeclarationImpl it) {
                it.setDelegate(delegate);
                it.setCompilationUnit(CompilationUnitImpl.this);
              }
            };
          JvmTypeParameterDeclarationImpl _doubleArrow = ObjectExtensions.<JvmTypeParameterDeclarationImpl>operator_doubleArrow(_jvmTypeParameterDeclarationImpl, _function);
          return _doubleArrow;
        }
      };
    JvmTypeParameterDeclarationImpl _get = this.<JvmTypeParameter, JvmTypeParameterDeclarationImpl>get(delegate, _function);
    return _get;
  }
  
  public ParameterDeclaration toParameterDeclaration(final JvmFormalParameter delegate) {
    final Function1<JvmFormalParameter,JvmParameterDeclarationImpl> _function = new Function1<JvmFormalParameter,JvmParameterDeclarationImpl>() {
        public JvmParameterDeclarationImpl apply(final JvmFormalParameter it) {
          JvmParameterDeclarationImpl _jvmParameterDeclarationImpl = new JvmParameterDeclarationImpl();
          final Procedure1<JvmParameterDeclarationImpl> _function = new Procedure1<JvmParameterDeclarationImpl>() {
              public void apply(final JvmParameterDeclarationImpl it) {
                it.setDelegate(delegate);
                it.setCompilationUnit(CompilationUnitImpl.this);
              }
            };
          JvmParameterDeclarationImpl _doubleArrow = ObjectExtensions.<JvmParameterDeclarationImpl>operator_doubleArrow(_jvmParameterDeclarationImpl, _function);
          return _doubleArrow;
        }
      };
    JvmParameterDeclarationImpl _get = this.<JvmFormalParameter, JvmParameterDeclarationImpl>get(delegate, _function);
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
              JvmMethodDeclarationImpl _jvmMethodDeclarationImpl = new JvmMethodDeclarationImpl();
              final Procedure1<JvmMethodDeclarationImpl> _function = new Procedure1<JvmMethodDeclarationImpl>() {
                  public void apply(final JvmMethodDeclarationImpl it) {
                    it.setDelegate(_jvmOperation);
                    it.setCompilationUnit(CompilationUnitImpl.this);
                  }
                };
              JvmMethodDeclarationImpl _doubleArrow = ObjectExtensions.<JvmMethodDeclarationImpl>operator_doubleArrow(_jvmMethodDeclarationImpl, _function);
              _switchResult = _doubleArrow;
            }
          }
          if (!_matched) {
            if (delegate instanceof JvmConstructor) {
              final JvmConstructor _jvmConstructor = (JvmConstructor)delegate;
              _matched=true;
              JvmConstructorDeclarationImpl _jvmConstructorDeclarationImpl = new JvmConstructorDeclarationImpl();
              final Procedure1<JvmConstructorDeclarationImpl> _function = new Procedure1<JvmConstructorDeclarationImpl>() {
                  public void apply(final JvmConstructorDeclarationImpl it) {
                    it.setDelegate(_jvmConstructor);
                    it.setCompilationUnit(CompilationUnitImpl.this);
                  }
                };
              JvmConstructorDeclarationImpl _doubleArrow = ObjectExtensions.<JvmConstructorDeclarationImpl>operator_doubleArrow(_jvmConstructorDeclarationImpl, _function);
              _switchResult = _doubleArrow;
            }
          }
          if (!_matched) {
            if (delegate instanceof JvmField) {
              final JvmField _jvmField = (JvmField)delegate;
              _matched=true;
              JvmFieldDeclarationImpl _jvmFieldDeclarationImpl = new JvmFieldDeclarationImpl();
              final Procedure1<JvmFieldDeclarationImpl> _function = new Procedure1<JvmFieldDeclarationImpl>() {
                  public void apply(final JvmFieldDeclarationImpl it) {
                    it.setDelegate(_jvmField);
                    it.setCompilationUnit(CompilationUnitImpl.this);
                  }
                };
              JvmFieldDeclarationImpl _doubleArrow = ObjectExtensions.<JvmFieldDeclarationImpl>operator_doubleArrow(_jvmFieldDeclarationImpl, _function);
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
  
  public XtendTypeDeclarationImpl<? extends XtendTypeDeclaration> toXtendTypeDeclaration(final XtendTypeDeclaration delegate) {
    final Function1<XtendTypeDeclaration,XtendClassDeclarationImpl> _function = new Function1<XtendTypeDeclaration,XtendClassDeclarationImpl>() {
        public XtendClassDeclarationImpl apply(final XtendTypeDeclaration it) {
          XtendClassDeclarationImpl _switchResult = null;
          boolean _matched = false;
          if (!_matched) {
            if (delegate instanceof XtendClass) {
              final XtendClass _xtendClass = (XtendClass)delegate;
              _matched=true;
              XtendClassDeclarationImpl _xtendClassDeclarationImpl = new XtendClassDeclarationImpl();
              final Procedure1<XtendClassDeclarationImpl> _function = new Procedure1<XtendClassDeclarationImpl>() {
                  public void apply(final XtendClassDeclarationImpl it) {
                    it.setDelegate(_xtendClass);
                    it.setCompilationUnit(CompilationUnitImpl.this);
                  }
                };
              XtendClassDeclarationImpl _doubleArrow = ObjectExtensions.<XtendClassDeclarationImpl>operator_doubleArrow(_xtendClassDeclarationImpl, _function);
              _switchResult = _doubleArrow;
            }
          }
          return _switchResult;
        }
      };
    XtendClassDeclarationImpl _get = this.<XtendTypeDeclaration, XtendClassDeclarationImpl>get(delegate, _function);
    return _get;
  }
  
  public XtendMemberDeclarationImpl toXtendMemberDeclaration(final XtendMember delegate) {
    final Function1<XtendMember,XtendMemberDeclarationImpl<?>> _function = new Function1<XtendMember,XtendMemberDeclarationImpl<?>>() {
        public XtendMemberDeclarationImpl<?> apply(final XtendMember it) {
          XtendMemberDeclarationImpl<?> _switchResult = null;
          boolean _matched = false;
          if (!_matched) {
            if (delegate instanceof XtendTypeDeclaration) {
              final XtendTypeDeclaration _xtendTypeDeclaration = (XtendTypeDeclaration)delegate;
              _matched=true;
              XtendTypeDeclarationImpl<? extends XtendTypeDeclaration> _xtendTypeDeclaration_1 = CompilationUnitImpl.this.toXtendTypeDeclaration(_xtendTypeDeclaration);
              _switchResult = _xtendTypeDeclaration_1;
            }
          }
          if (!_matched) {
            if (delegate instanceof XtendFunction) {
              final XtendFunction _xtendFunction = (XtendFunction)delegate;
              _matched=true;
              XtendMethodDeclarationImpl _xtendMethodDeclarationImpl = new XtendMethodDeclarationImpl();
              final Procedure1<XtendMethodDeclarationImpl> _function = new Procedure1<XtendMethodDeclarationImpl>() {
                  public void apply(final XtendMethodDeclarationImpl it) {
                    it.setDelegate(_xtendFunction);
                    it.setCompilationUnit(CompilationUnitImpl.this);
                  }
                };
              XtendMethodDeclarationImpl _doubleArrow = ObjectExtensions.<XtendMethodDeclarationImpl>operator_doubleArrow(_xtendMethodDeclarationImpl, _function);
              _switchResult = _doubleArrow;
            }
          }
          if (!_matched) {
            if (delegate instanceof XtendConstructor) {
              final XtendConstructor _xtendConstructor = (XtendConstructor)delegate;
              _matched=true;
              XtendConstructorDeclarationImpl _xtendConstructorDeclarationImpl = new XtendConstructorDeclarationImpl();
              final Procedure1<XtendConstructorDeclarationImpl> _function = new Procedure1<XtendConstructorDeclarationImpl>() {
                  public void apply(final XtendConstructorDeclarationImpl it) {
                    it.setDelegate(_xtendConstructor);
                    it.setCompilationUnit(CompilationUnitImpl.this);
                  }
                };
              XtendConstructorDeclarationImpl _doubleArrow = ObjectExtensions.<XtendConstructorDeclarationImpl>operator_doubleArrow(_xtendConstructorDeclarationImpl, _function);
              _switchResult = _doubleArrow;
            }
          }
          if (!_matched) {
            if (delegate instanceof XtendField) {
              final XtendField _xtendField = (XtendField)delegate;
              _matched=true;
              XtendFieldDeclarationImpl _xtendFieldDeclarationImpl = new XtendFieldDeclarationImpl();
              final Procedure1<XtendFieldDeclarationImpl> _function = new Procedure1<XtendFieldDeclarationImpl>() {
                  public void apply(final XtendFieldDeclarationImpl it) {
                    it.setDelegate(_xtendField);
                    it.setCompilationUnit(CompilationUnitImpl.this);
                  }
                };
              XtendFieldDeclarationImpl _doubleArrow = ObjectExtensions.<XtendFieldDeclarationImpl>operator_doubleArrow(_xtendFieldDeclarationImpl, _function);
              _switchResult = _doubleArrow;
            }
          }
          return _switchResult;
        }
      };
    XtendMemberDeclarationImpl<?> _get = this.<XtendMember, XtendMemberDeclarationImpl<?>>get(delegate, _function);
    return _get;
  }
  
  public XtendParameterDeclarationImpl toXtendParameterDeclaration(final XtendParameter delegate) {
    final Function1<XtendParameter,XtendParameterDeclarationImpl> _function = new Function1<XtendParameter,XtendParameterDeclarationImpl>() {
        public XtendParameterDeclarationImpl apply(final XtendParameter it) {
          XtendParameterDeclarationImpl _xtendParameterDeclarationImpl = new XtendParameterDeclarationImpl();
          final Procedure1<XtendParameterDeclarationImpl> _function = new Procedure1<XtendParameterDeclarationImpl>() {
              public void apply(final XtendParameterDeclarationImpl it) {
                it.setDelegate(delegate);
                it.setCompilationUnit(CompilationUnitImpl.this);
              }
            };
          XtendParameterDeclarationImpl _doubleArrow = ObjectExtensions.<XtendParameterDeclarationImpl>operator_doubleArrow(_xtendParameterDeclarationImpl, _function);
          return _doubleArrow;
        }
      };
    XtendParameterDeclarationImpl _get = this.<XtendParameter, XtendParameterDeclarationImpl>get(delegate, _function);
    return _get;
  }
  
  public XtendTypeParameterDeclarationImpl toXtendTypeParameterDeclaration(final JvmTypeParameter delegate) {
    final Function1<JvmTypeParameter,XtendTypeParameterDeclarationImpl> _function = new Function1<JvmTypeParameter,XtendTypeParameterDeclarationImpl>() {
        public XtendTypeParameterDeclarationImpl apply(final JvmTypeParameter it) {
          XtendTypeParameterDeclarationImpl _xtendTypeParameterDeclarationImpl = new XtendTypeParameterDeclarationImpl();
          final Procedure1<XtendTypeParameterDeclarationImpl> _function = new Procedure1<XtendTypeParameterDeclarationImpl>() {
              public void apply(final XtendTypeParameterDeclarationImpl it) {
                it.setDelegate(delegate);
                it.setCompilationUnit(CompilationUnitImpl.this);
              }
            };
          XtendTypeParameterDeclarationImpl _doubleArrow = ObjectExtensions.<XtendTypeParameterDeclarationImpl>operator_doubleArrow(_xtendTypeParameterDeclarationImpl, _function);
          return _doubleArrow;
        }
      };
    XtendTypeParameterDeclarationImpl _get = this.<JvmTypeParameter, XtendTypeParameterDeclarationImpl>get(delegate, _function);
    return _get;
  }
  
  public TypeReference getAnyType() {
    XtendFile _xtendFile = this.getXtendFile();
    JvmAnyTypeReference _createAnyTypeReference = this.typeReferences.createAnyTypeReference(_xtendFile);
    TypeReference _typeReference = this.toTypeReference(_createAnyTypeReference);
    return _typeReference;
  }
  
  public TypeReference getList(final TypeReference param) {
    TypeReference _newTypeReference = this.newTypeReference("java.util.List", param);
    return _newTypeReference;
  }
  
  public TypeReference getObject() {
    XtendFile _xtendFile = this.getXtendFile();
    JvmType _findDeclaredType = this.typeReferences.findDeclaredType(Object.class, _xtendFile);
    JvmParameterizedTypeReference _createTypeRef = this.typeReferences.createTypeRef(_findDeclaredType);
    TypeReference _typeReference = this.toTypeReference(_createTypeRef);
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
    JvmTypeReference _jvmTypeReference = this.toJvmTypeReference(componentType);
    JvmGenericArrayTypeReference _createArrayType = this.typeReferences.createArrayType(_jvmTypeReference);
    TypeReference _typeReference = this.toTypeReference(_createArrayType);
    return _typeReference;
  }
  
  public TypeReference newTypeReference(final String typeName, final TypeReference... typeArguments) {
    TypeReference _xblockexpression = null;
    {
      XtendFile _xtendFile = this.getXtendFile();
      final JvmType type = this.typeReferences.findDeclaredType(typeName, _xtendFile);
      boolean _equals = ObjectExtensions.operator_equals(type, null);
      if (_equals) {
        return null;
      }
      final Function1<TypeReference,JvmTypeReference> _function = new Function1<TypeReference,JvmTypeReference>() {
          public JvmTypeReference apply(final TypeReference it) {
            JvmTypeReference _jvmTypeReference = CompilationUnitImpl.this.toJvmTypeReference(it);
            return _jvmTypeReference;
          }
        };
      List<JvmTypeReference> _map = ListExtensions.<TypeReference, JvmTypeReference>map(((List<TypeReference>)Conversions.doWrapArray(typeArguments)), _function);
      JvmParameterizedTypeReference _createTypeRef = this.typeReferences.createTypeRef(type, ((JvmTypeReference[]) ((JvmTypeReference[])Conversions.unwrapArray(_map, JvmTypeReference.class))));
      TypeReference _typeReference = this.toTypeReference(_createTypeRef);
      _xblockexpression = (_typeReference);
    }
    return _xblockexpression;
  }
  
  public TypeReference newTypeReference(final Type typeDeclaration, final TypeReference... typeArguments) {
    TypeReference _xblockexpression = null;
    {
      JvmComponentType _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        if (typeDeclaration instanceof JvmTypeDeclarationImpl) {
          final JvmTypeDeclarationImpl<? extends JvmDeclaredType> _jvmTypeDeclarationImpl = (JvmTypeDeclarationImpl<? extends JvmDeclaredType>)typeDeclaration;
          _matched=true;
          JvmDeclaredType _delegate = _jvmTypeDeclarationImpl.getDelegate();
          _switchResult = _delegate;
        }
      }
      if (!_matched) {
        if (typeDeclaration instanceof XtendTypeDeclarationImpl) {
          final XtendTypeDeclarationImpl<? extends XtendTypeDeclaration> _xtendTypeDeclarationImpl = (XtendTypeDeclarationImpl<? extends XtendTypeDeclaration>)typeDeclaration;
          _matched=true;
          XtendTypeDeclaration _delegate = _xtendTypeDeclarationImpl.getDelegate();
          JvmDeclaredType _inferredType = this.associations.getInferredType(_delegate);
          _switchResult = _inferredType;
        }
      }
      if (!_matched) {
        if (typeDeclaration instanceof JvmTypeParameterDeclarationImpl) {
          final JvmTypeParameterDeclarationImpl _jvmTypeParameterDeclarationImpl = (JvmTypeParameterDeclarationImpl)typeDeclaration;
          _matched=true;
          JvmTypeParameter _delegate = _jvmTypeParameterDeclarationImpl.getDelegate();
          _switchResult = _delegate;
        }
      }
      if (!_matched) {
        if (typeDeclaration instanceof PrimitiveTypeImpl) {
          final PrimitiveTypeImpl _primitiveTypeImpl = (PrimitiveTypeImpl)typeDeclaration;
          _matched=true;
          TypeReference _switchResult_1 = null;
          Kind _kind = _primitiveTypeImpl.getKind();
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
          final VoidTypeImpl _voidTypeImpl = (VoidTypeImpl)typeDeclaration;
          _matched=true;
          return this.getPrimitiveVoid();
        }
      }
      if (!_matched) {
        String _plus = ("couln\'t construct type refernce for type " + typeDeclaration);
        IllegalArgumentException _illegalArgumentException = new IllegalArgumentException(_plus);
        throw _illegalArgumentException;
      }
      final JvmComponentType type = _switchResult;
      boolean _equals = ObjectExtensions.operator_equals(type, null);
      if (_equals) {
        return null;
      }
      final Function1<TypeReference,JvmTypeReference> _function = new Function1<TypeReference,JvmTypeReference>() {
          public JvmTypeReference apply(final TypeReference it) {
            JvmTypeReference _jvmTypeReference = CompilationUnitImpl.this.toJvmTypeReference(it);
            return _jvmTypeReference;
          }
        };
      List<JvmTypeReference> _map = ListExtensions.<TypeReference, JvmTypeReference>map(((List<TypeReference>)Conversions.doWrapArray(typeArguments)), _function);
      JvmParameterizedTypeReference _createTypeRef = this.typeReferences.createTypeRef(type, ((JvmTypeReference[]) ((JvmTypeReference[])Conversions.unwrapArray(_map, JvmTypeReference.class))));
      TypeReference _typeReference = this.toTypeReference(_createTypeRef);
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
    boolean _equals = ObjectExtensions.operator_equals(upperBound, null);
    if (_equals) {
      JvmWildcardTypeReference _wildCard = this.typeReferences.wildCard();
      TypeReference _typeReference = this.toTypeReference(_wildCard);
      _xifexpression = _typeReference;
    } else {
      JvmTypeReference _jvmTypeReference = this.toJvmTypeReference(upperBound);
      JvmWildcardTypeReference _wildCardExtends = this.typeReferences.wildCardExtends(_jvmTypeReference);
      TypeReference _typeReference_1 = this.toTypeReference(_wildCardExtends);
      _xifexpression = _typeReference_1;
    }
    return _xifexpression;
  }
  
  public JvmTypeReference toJvmTypeReference(final TypeReference typeRef) {
    LightweightTypeReference _lightWeightTypeReference = ((TypeReferenceImpl) typeRef).getLightWeightTypeReference();
    return _lightWeightTypeReference.toJavaCompliantTypeReference();
  }
  
  public void setCompilationStrategy(final JvmExecutable executable, final Function1<? super CompilationContext,? extends CharSequence> compilationStrategy) {
    final Procedure1<ITreeAppendable> _function = new Procedure1<ITreeAppendable>() {
        public void apply(final ITreeAppendable it) {
          CompilationContextImpl _compilationContextImpl = new CompilationContextImpl(it, CompilationUnitImpl.this, CompilationUnitImpl.this.typeRefSerializer);
          final CompilationContextImpl context = _compilationContextImpl;
          CharSequence _apply = compilationStrategy.apply(context);
          it.append(_apply);
        }
      };
    this.typesBuilder.setBody(executable, _function);
  }
  
  public void addError(final Element element, final String message) {
    final Pair<Resource,EObject> resAndObj = this.getResourceAndEObject(element);
    Resource _key = resAndObj.getKey();
    EList<Diagnostic> _errors = _key.getErrors();
    EObject _value = resAndObj.getValue();
    EObject _value_1 = resAndObj.getValue();
    EStructuralFeature _significantFeature = this.getSignificantFeature(_value_1);
    int _minus = (-1);
    EObjectDiagnosticImpl _eObjectDiagnosticImpl = new EObjectDiagnosticImpl(Severity.ERROR, "user.issue", message, _value, _significantFeature, _minus, null);
    _errors.add(_eObjectDiagnosticImpl);
  }
  
  public void addInfo(final Element element, final String message) {
  }
  
  public void addWarning(final Element element, final String message) {
    final Pair<Resource,EObject> resAndObj = this.getResourceAndEObject(element);
    Resource _key = resAndObj.getKey();
    EList<Diagnostic> _warnings = _key.getWarnings();
    EObject _value = resAndObj.getValue();
    EObject _value_1 = resAndObj.getValue();
    EStructuralFeature _significantFeature = this.getSignificantFeature(_value_1);
    int _minus = (-1);
    EObjectDiagnosticImpl _eObjectDiagnosticImpl = new EObjectDiagnosticImpl(Severity.WARNING, "user.issue", message, _value, _significantFeature, _minus, null);
    _warnings.add(_eObjectDiagnosticImpl);
  }
  
  public List<Problem> getProblems(final Element element) {
    final Pair<Resource,EObject> resAndObj = this.getResourceAndEObject(element);
    final Resource resource = resAndObj.getKey();
    EList<Diagnostic> _errors = resource.getErrors();
    EList<Diagnostic> _warnings = resource.getWarnings();
    Iterable<Diagnostic> _plus = Iterables.<Diagnostic>concat(_errors, _warnings);
    final Iterable<EObjectDiagnosticImpl> issues = Iterables.<EObjectDiagnosticImpl>filter(_plus, EObjectDiagnosticImpl.class);
    final Function1<EObjectDiagnosticImpl,Boolean> _function = new Function1<EObjectDiagnosticImpl,Boolean>() {
        public Boolean apply(final EObjectDiagnosticImpl diag) {
          EObject _problematicObject = diag.getProblematicObject();
          EObject _value = resAndObj.getValue();
          boolean _equals = ObjectExtensions.operator_equals(_problematicObject, _value);
          return Boolean.valueOf(_equals);
        }
      };
    Iterable<EObjectDiagnosticImpl> _filter = IterableExtensions.<EObjectDiagnosticImpl>filter(issues, _function);
    final Function1<EObjectDiagnosticImpl,Problem> _function_1 = new Function1<EObjectDiagnosticImpl,Problem>() {
        public Problem apply(final EObjectDiagnosticImpl diag) {
          String _code = diag.getCode();
          String _message = diag.getMessage();
          Severity _severity = diag.getSeverity();
          org.eclipse.xtend.lib.macro.Problem.Severity _translateSeverity = CompilationUnitImpl.this.translateSeverity(_severity);
          ProblemImpl _problemImpl = new ProblemImpl(_code, _message, _translateSeverity);
          return ((Problem) _problemImpl);
        }
      };
    final Iterable<Problem> result = IterableExtensions.<EObjectDiagnosticImpl, Problem>map(_filter, _function_1);
    return IterableExtensions.<Problem>toList(result);
  }
  
  public EStructuralFeature getSignificantFeature(final EObject obj) {
    EAttribute _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (obj instanceof XtendTypeDeclaration) {
        final XtendTypeDeclaration _xtendTypeDeclaration = (XtendTypeDeclaration)obj;
        _matched=true;
        EAttribute _xtendTypeDeclaration_Name = XtendPackage.eINSTANCE.getXtendTypeDeclaration_Name();
        _switchResult = _xtendTypeDeclaration_Name;
      }
    }
    if (!_matched) {
      if (obj instanceof XtendField) {
        final XtendField _xtendField = (XtendField)obj;
        _matched=true;
        EAttribute _xtendField_Name = XtendPackage.eINSTANCE.getXtendField_Name();
        _switchResult = _xtendField_Name;
      }
    }
    if (!_matched) {
      if (obj instanceof XtendFunction) {
        final XtendFunction _xtendFunction = (XtendFunction)obj;
        _matched=true;
        EAttribute _xtendFunction_Name = XtendPackage.eINSTANCE.getXtendFunction_Name();
        _switchResult = _xtendFunction_Name;
      }
    }
    if (!_matched) {
      if (obj instanceof XtendConstructor) {
        final XtendConstructor _xtendConstructor = (XtendConstructor)obj;
        _matched=true;
        EAttribute _xtendConstructor_Name = XtendPackage.eINSTANCE.getXtendConstructor_Name();
        _switchResult = _xtendConstructor_Name;
      }
    }
    if (!_matched) {
      if (obj instanceof JvmFormalParameter) {
        final JvmFormalParameter _jvmFormalParameter = (JvmFormalParameter)obj;
        _matched=true;
        EAttribute _jvmFormalParameter_Name = TypesPackage.eINSTANCE.getJvmFormalParameter_Name();
        _switchResult = _jvmFormalParameter_Name;
      }
    }
    return _switchResult;
  }
  
  private Pair<Resource,EObject> getResourceAndEObject(final Element element) {
    boolean _matched = false;
    if (!_matched) {
      if (element instanceof XtendNamedElementImpl) {
        final XtendNamedElementImpl<? extends EObject> _xtendNamedElementImpl = (XtendNamedElementImpl<? extends EObject>)element;
        _matched=true;
        EObject _delegate = _xtendNamedElementImpl.getDelegate();
        final Resource resource = _delegate.eResource();
        final EObject eobject = _xtendNamedElementImpl.getDelegate();
        return Pair.<Resource, EObject>of(resource, eobject);
      }
    }
    if (!_matched) {
      if (element instanceof JvmNamedElementImpl) {
        final JvmNamedElementImpl<JvmIdentifiableElement> _jvmNamedElementImpl = (JvmNamedElementImpl<JvmIdentifiableElement>)element;
        _matched=true;
        JvmIdentifiableElement _delegate = _jvmNamedElementImpl.getDelegate();
        final Resource resource = _delegate.eResource();
        XtendFile _xtendFile = this.getXtendFile();
        Resource _eResource = _xtendFile.eResource();
        boolean _equals = ObjectExtensions.operator_equals(resource, _eResource);
        if (_equals) {
          JvmIdentifiableElement _delegate_1 = _jvmNamedElementImpl.getDelegate();
          final EObject eobject = this.associations.getPrimarySourceElement(_delegate_1);
          return Pair.<Resource, EObject>of(resource, eobject);
        }
      }
    }
    IllegalArgumentException _illegalArgumentException = new IllegalArgumentException("You can only add issues on locally declared elements.");
    throw _illegalArgumentException;
  }
  
  private org.eclipse.xtend.lib.macro.Problem.Severity translateSeverity(final Severity severity) {
    org.eclipse.xtend.lib.macro.Problem.Severity _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(severity,Severity.ERROR)) {
        _matched=true;
        _switchResult = org.eclipse.xtend.lib.macro.Problem.Severity.ERROR;
      }
    }
    if (!_matched) {
      if (Objects.equal(severity,Severity.WARNING)) {
        _matched=true;
        _switchResult = org.eclipse.xtend.lib.macro.Problem.Severity.WARNING;
      }
    }
    if (!_matched) {
      if (Objects.equal(severity,Severity.INFO)) {
        _matched=true;
        _switchResult = org.eclipse.xtend.lib.macro.Problem.Severity.INFO;
      }
    }
    if (!_matched) {
      if (Objects.equal(severity,Severity.IGNORE)) {
        _matched=true;
        _switchResult = org.eclipse.xtend.lib.macro.Problem.Severity.IGNORE;
      }
    }
    return _switchResult;
  }
}
