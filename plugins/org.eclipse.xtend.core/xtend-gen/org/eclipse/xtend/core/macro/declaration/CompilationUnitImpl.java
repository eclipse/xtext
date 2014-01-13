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
import com.google.common.primitives.Booleans;
import com.google.common.primitives.Bytes;
import com.google.common.primitives.Chars;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Floats;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import com.google.common.primitives.Shorts;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.macro.CompilationContextImpl;
import org.eclipse.xtend.core.macro.ConstantExpressionsInterpreter;
import org.eclipse.xtend.core.macro.declaration.ExpressionImpl;
import org.eclipse.xtend.core.macro.declaration.JvmAnnotationReferenceImpl;
import org.eclipse.xtend.core.macro.declaration.JvmAnnotationTypeDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.JvmAnnotationTypeElementDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.JvmClassDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.JvmConstructorDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.JvmEnumerationTypeDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.JvmEnumerationValueDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.JvmFieldDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.JvmInterfaceDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.JvmMemberDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.JvmMethodDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.JvmParameterDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.JvmTypeDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.JvmTypeParameterDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.PrimitiveTypeImpl;
import org.eclipse.xtend.core.macro.declaration.ProblemSupportImpl;
import org.eclipse.xtend.core.macro.declaration.TypeLookupImpl;
import org.eclipse.xtend.core.macro.declaration.TypeReferenceImpl;
import org.eclipse.xtend.core.macro.declaration.TypeReferenceProviderImpl;
import org.eclipse.xtend.core.macro.declaration.VoidTypeImpl;
import org.eclipse.xtend.core.macro.declaration.XtendAnnotationReferenceImpl;
import org.eclipse.xtend.core.macro.declaration.XtendAnnotationTypeDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.XtendAnnotationTypeElementDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.XtendClassDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.XtendConstructorDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.XtendEnumerationDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.XtendEnumerationValueDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.XtendFieldDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.XtendInterfaceDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.XtendMemberDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.XtendMethodDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.XtendParameterDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.XtendTypeDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.XtendTypeParameterDeclarationImpl;
import org.eclipse.xtend.core.xtend.XtendAnnotationType;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendEnum;
import org.eclipse.xtend.core.xtend.XtendEnumLiteral;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendInterface;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.CompilationStrategy;
import org.eclipse.xtend.lib.macro.declaration.CompilationUnit;
import org.eclipse.xtend.lib.macro.declaration.EnumerationValueDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableAnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.MutableDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableNamedElement;
import org.eclipse.xtend.lib.macro.declaration.MutableParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.declaration.Visibility;
import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtend.lib.macro.file.FileLocations;
import org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtend.lib.macro.services.ProblemSupport;
import org.eclipse.xtend.lib.macro.services.TypeReferenceProvider;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.common.types.JvmAnnotationAnnotationValue;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmBooleanAnnotationValue;
import org.eclipse.xtext.common.types.JvmByteAnnotationValue;
import org.eclipse.xtext.common.types.JvmCharAnnotationValue;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmCustomAnnotationValue;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmDoubleAnnotationValue;
import org.eclipse.xtext.common.types.JvmEnumAnnotationValue;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFloatAnnotationValue;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmIntAnnotationValue;
import org.eclipse.xtext.common.types.JvmLongAnnotationValue;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmShortAnnotationValue;
import org.eclipse.xtext.common.types.JvmStringAnnotationValue;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeAnnotationValue;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.JvmVoid;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.documentation.IFileHeaderProvider;
import org.eclipse.xtext.formatting.ILineSeparatorInformation;
import org.eclipse.xtext.formatting.IWhitespaceInformationProvider;
import org.eclipse.xtext.resource.CompilerPhases;
import org.eclipse.xtext.validation.EObjectDiagnosticImpl;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.file.AbstractFileSystemSupport;
import org.eclipse.xtext.xbase.file.WorkspaceConfig;
import org.eclipse.xtext.xbase.interpreter.ConstantExpressionEvaluationException;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeExtensions;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.typesystem.legacy.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.IndexingOwnedConverter;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;

@SuppressWarnings("all")
public class CompilationUnitImpl implements CompilationUnit {
  public Iterable<? extends AnnotationReference> getAnnotations() {
    return CollectionLiterals.<AnnotationReference>emptyList();
  }
  
  public AnnotationReference findAnnotation(final Type annotationType) {
    return null;
  }
  
  public String getSimpleName() {
    XtendFile _xtendFile = this.getXtendFile();
    Resource _eResource = _xtendFile.eResource();
    URI _uRI = _eResource.getURI();
    String _lastSegment = _uRI.lastSegment();
    return _lastSegment.toString();
  }
  
  public CompilationUnit getCompilationUnit() {
    return this;
  }
  
  public String getDocComment() {
    throw new UnsupportedOperationException("Auto-generated function stub");
  }
  
  public String getPackageName() {
    XtendFile _xtendFile = this.getXtendFile();
    return _xtendFile.getPackage();
  }
  
  public Iterable<? extends TypeDeclaration> getSourceTypeDeclarations() {
    XtendFile _xtendFile = this.getXtendFile();
    EList<XtendTypeDeclaration> _xtendTypes = _xtendFile.getXtendTypes();
    final Function1<XtendTypeDeclaration,XtendTypeDeclarationImpl<? extends XtendTypeDeclaration>> _function = new Function1<XtendTypeDeclaration,XtendTypeDeclarationImpl<? extends XtendTypeDeclaration>>() {
      public XtendTypeDeclarationImpl<? extends XtendTypeDeclaration> apply(final XtendTypeDeclaration it) {
        return CompilationUnitImpl.this.toXtendTypeDeclaration(it);
      }
    };
    return ListExtensions.<XtendTypeDeclaration, XtendTypeDeclarationImpl<? extends XtendTypeDeclaration>>map(_xtendTypes, _function);
  }
  
  private boolean canceled = false;
  
  public boolean setCanceled(final boolean canceled) {
    return this.canceled = canceled;
  }
  
  public void checkCanceled() {
    if (this.canceled) {
      throw new CancellationException("compilation was canceled.");
    }
  }
  
  @Inject
  private CompilerPhases compilerPhases;
  
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
  private IXtendJvmAssociations associations;
  
  @Inject
  private ConstantExpressionsInterpreter interpreter;
  
  @Inject
  private IEObjectDocumentationProvider documentationProvider;
  
  @Inject
  private IFileHeaderProvider fileHeaderProvider;
  
  @Inject
  private JvmTypeExtensions typeExtensions;
  
  @Inject
  private AbstractFileSystemSupport fileSystemSupport;
  
  @Inject
  private FileLocations fileLocations;
  
  @Inject
  private Provider<WorkspaceConfig> workspaceConfigProvider;
  
  @Inject
  @Extension
  private IWhitespaceInformationProvider _iWhitespaceInformationProvider;
  
  private final ProblemSupport _problemSupport = new ProblemSupportImpl(this);
  
  public ProblemSupport getProblemSupport() {
    return this._problemSupport;
  }
  
  private final TypeReferenceProvider _typeReferenceProvider = new TypeReferenceProviderImpl(this);
  
  public TypeReferenceProvider getTypeReferenceProvider() {
    return this._typeReferenceProvider;
  }
  
  private final TypeLookupImpl _typeLookup = new TypeLookupImpl(this);
  
  public TypeLookupImpl getTypeLookup() {
    return this._typeLookup;
  }
  
  private Map<EObject,Object> identityCache = CollectionLiterals.<EObject, Object>newHashMap();
  
  private OwnedConverter typeRefConverter;
  
  public IXtendJvmAssociations getJvmAssociations() {
    return this.associations;
  }
  
  public TypeReferences getTypeReferences() {
    return this.typeReferences;
  }
  
  public IEObjectDocumentationProvider getDocumentationProvider() {
    return this.documentationProvider;
  }
  
  public IFileHeaderProvider getFileHeaderProvider() {
    return this.fileHeaderProvider;
  }
  
  public JvmTypesBuilder getJvmTypesBuilder() {
    return this.typesBuilder;
  }
  
  public JvmTypeExtensions getTypeExtensions() {
    return this.typeExtensions;
  }
  
  public MutableFileSystemSupport getFileSystemSupport() {
    return this.fileSystemSupport;
  }
  
  public FileLocations getFileLocations() {
    return this.fileLocations;
  }
  
  public Path getFilePath() {
    XtendFile _xtendFile = this.getXtendFile();
    Resource _eResource = _xtendFile.eResource();
    return this.fileSystemSupport.getPath(_eResource);
  }
  
  public void setXtendFile(final XtendFile xtendFile) {
    this._xtendFile = xtendFile;
    Resource _eResource = xtendFile.eResource();
    ResourceSet _resourceSet = _eResource.getResourceSet();
    final StandardTypeReferenceOwner standardTypeReferenceOwner = new StandardTypeReferenceOwner(this.services, _resourceSet);
    boolean _isIndexing = this.isIndexing();
    if (_isIndexing) {
      IndexingOwnedConverter _indexingOwnedConverter = new IndexingOwnedConverter(standardTypeReferenceOwner);
      this.typeRefConverter = _indexingOwnedConverter;
    } else {
      OwnedConverter _ownedConverter = new OwnedConverter(standardTypeReferenceOwner);
      this.typeRefConverter = _ownedConverter;
    }
  }
  
  public boolean isIndexing() {
    XtendFile _xtendFile = this.getXtendFile();
    return this.compilerPhases.isIndexing(_xtendFile);
  }
  
  private <IN extends EObject, OUT extends Object> OUT getOrCreate(final IN in, final Function1<? super IN,? extends OUT> provider) {
    this.checkCanceled();
    boolean _equals = Objects.equal(in, null);
    if (_equals) {
      return null;
    }
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
    switch (delegate) {
      case DEFAULT:
        _switchResult = Visibility.DEFAULT;
        break;
      case PRIVATE:
        _switchResult = Visibility.PRIVATE;
        break;
      case PROTECTED:
        _switchResult = Visibility.PROTECTED;
        break;
      case PUBLIC:
        _switchResult = Visibility.PUBLIC;
        break;
      default:
        break;
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
            _matched=true;
            _switchResult = CompilationUnitImpl.this.toTypeDeclaration(((JvmDeclaredType)delegate));
          }
        }
        if (!_matched) {
          if (delegate instanceof JvmTypeParameter) {
            _matched=true;
            _switchResult = CompilationUnitImpl.this.toTypeParameterDeclaration(((JvmTypeParameter)delegate));
          }
        }
        if (!_matched) {
          if (delegate instanceof JvmVoid) {
            _matched=true;
            VoidTypeImpl _voidTypeImpl = new VoidTypeImpl();
            final Procedure1<VoidTypeImpl> _function = new Procedure1<VoidTypeImpl>() {
              public void apply(final VoidTypeImpl it) {
                it.setDelegate(((JvmVoid)delegate));
                it.setCompilationUnit(CompilationUnitImpl.this);
              }
            };
            _switchResult = ObjectExtensions.<VoidTypeImpl>operator_doubleArrow(_voidTypeImpl, _function);
          }
        }
        if (!_matched) {
          if (delegate instanceof JvmPrimitiveType) {
            _matched=true;
            PrimitiveTypeImpl _primitiveTypeImpl = new PrimitiveTypeImpl();
            final Procedure1<PrimitiveTypeImpl> _function = new Procedure1<PrimitiveTypeImpl>() {
              public void apply(final PrimitiveTypeImpl it) {
                it.setDelegate(((JvmPrimitiveType)delegate));
                it.setCompilationUnit(CompilationUnitImpl.this);
              }
            };
            _switchResult = ObjectExtensions.<PrimitiveTypeImpl>operator_doubleArrow(_primitiveTypeImpl, _function);
          }
        }
        return _switchResult;
      }
    };
    return this.<JvmType, Type>getOrCreate(delegate, _function);
  }
  
  public MutableTypeDeclaration toTypeDeclaration(final JvmDeclaredType delegate) {
    final Function1<JvmDeclaredType,JvmTypeDeclarationImpl<? extends JvmDeclaredType>> _function = new Function1<JvmDeclaredType,JvmTypeDeclarationImpl<? extends JvmDeclaredType>>() {
      public JvmTypeDeclarationImpl<? extends JvmDeclaredType> apply(final JvmDeclaredType it) {
        JvmTypeDeclarationImpl<? extends JvmDeclaredType> _switchResult = null;
        boolean _matched = false;
        if (!_matched) {
          if (delegate instanceof JvmGenericType) {
            boolean _isInterface = ((JvmGenericType)delegate).isInterface();
            if (_isInterface) {
              _matched=true;
              JvmInterfaceDeclarationImpl _jvmInterfaceDeclarationImpl = new JvmInterfaceDeclarationImpl();
              final Procedure1<JvmInterfaceDeclarationImpl> _function = new Procedure1<JvmInterfaceDeclarationImpl>() {
                public void apply(final JvmInterfaceDeclarationImpl it) {
                  it.setDelegate(((JvmGenericType)delegate));
                  it.setCompilationUnit(CompilationUnitImpl.this);
                }
              };
              _switchResult = ObjectExtensions.<JvmInterfaceDeclarationImpl>operator_doubleArrow(_jvmInterfaceDeclarationImpl, _function);
            }
          }
        }
        if (!_matched) {
          if (delegate instanceof JvmGenericType) {
            _matched=true;
            JvmClassDeclarationImpl _jvmClassDeclarationImpl = new JvmClassDeclarationImpl();
            final Procedure1<JvmClassDeclarationImpl> _function = new Procedure1<JvmClassDeclarationImpl>() {
              public void apply(final JvmClassDeclarationImpl it) {
                it.setDelegate(((JvmGenericType)delegate));
                it.setCompilationUnit(CompilationUnitImpl.this);
              }
            };
            _switchResult = ObjectExtensions.<JvmClassDeclarationImpl>operator_doubleArrow(_jvmClassDeclarationImpl, _function);
          }
        }
        if (!_matched) {
          if (delegate instanceof JvmAnnotationType) {
            _matched=true;
            JvmAnnotationTypeDeclarationImpl _jvmAnnotationTypeDeclarationImpl = new JvmAnnotationTypeDeclarationImpl();
            final Procedure1<JvmAnnotationTypeDeclarationImpl> _function = new Procedure1<JvmAnnotationTypeDeclarationImpl>() {
              public void apply(final JvmAnnotationTypeDeclarationImpl it) {
                it.setDelegate(((JvmAnnotationType)delegate));
                it.setCompilationUnit(CompilationUnitImpl.this);
              }
            };
            _switchResult = ObjectExtensions.<JvmAnnotationTypeDeclarationImpl>operator_doubleArrow(_jvmAnnotationTypeDeclarationImpl, _function);
          }
        }
        if (!_matched) {
          if (delegate instanceof JvmEnumerationType) {
            _matched=true;
            JvmEnumerationTypeDeclarationImpl _jvmEnumerationTypeDeclarationImpl = new JvmEnumerationTypeDeclarationImpl();
            final Procedure1<JvmEnumerationTypeDeclarationImpl> _function = new Procedure1<JvmEnumerationTypeDeclarationImpl>() {
              public void apply(final JvmEnumerationTypeDeclarationImpl it) {
                it.setDelegate(((JvmEnumerationType)delegate));
                it.setCompilationUnit(CompilationUnitImpl.this);
              }
            };
            _switchResult = ObjectExtensions.<JvmEnumerationTypeDeclarationImpl>operator_doubleArrow(_jvmEnumerationTypeDeclarationImpl, _function);
          }
        }
        return _switchResult;
      }
    };
    return this.<JvmDeclaredType, JvmTypeDeclarationImpl<? extends JvmDeclaredType>>getOrCreate(delegate, _function);
  }
  
  public MutableTypeParameterDeclaration toTypeParameterDeclaration(final JvmTypeParameter delegate) {
    final Function1<JvmTypeParameter,JvmTypeParameterDeclarationImpl> _function = new Function1<JvmTypeParameter,JvmTypeParameterDeclarationImpl>() {
      public JvmTypeParameterDeclarationImpl apply(final JvmTypeParameter it) {
        JvmTypeParameterDeclarationImpl _jvmTypeParameterDeclarationImpl = new JvmTypeParameterDeclarationImpl();
        final Procedure1<JvmTypeParameterDeclarationImpl> _function = new Procedure1<JvmTypeParameterDeclarationImpl>() {
          public void apply(final JvmTypeParameterDeclarationImpl it) {
            it.setDelegate(delegate);
            it.setCompilationUnit(CompilationUnitImpl.this);
          }
        };
        return ObjectExtensions.<JvmTypeParameterDeclarationImpl>operator_doubleArrow(_jvmTypeParameterDeclarationImpl, _function);
      }
    };
    return this.<JvmTypeParameter, JvmTypeParameterDeclarationImpl>getOrCreate(delegate, _function);
  }
  
  public MutableParameterDeclaration toParameterDeclaration(final JvmFormalParameter delegate) {
    final Function1<JvmFormalParameter,JvmParameterDeclarationImpl> _function = new Function1<JvmFormalParameter,JvmParameterDeclarationImpl>() {
      public JvmParameterDeclarationImpl apply(final JvmFormalParameter it) {
        JvmParameterDeclarationImpl _jvmParameterDeclarationImpl = new JvmParameterDeclarationImpl();
        final Procedure1<JvmParameterDeclarationImpl> _function = new Procedure1<JvmParameterDeclarationImpl>() {
          public void apply(final JvmParameterDeclarationImpl it) {
            it.setDelegate(delegate);
            it.setCompilationUnit(CompilationUnitImpl.this);
          }
        };
        return ObjectExtensions.<JvmParameterDeclarationImpl>operator_doubleArrow(_jvmParameterDeclarationImpl, _function);
      }
    };
    return this.<JvmFormalParameter, JvmParameterDeclarationImpl>getOrCreate(delegate, _function);
  }
  
  public MutableMemberDeclaration toMemberDeclaration(final JvmMember delegate) {
    final Function1<JvmMember,MutableMemberDeclaration> _function = new Function1<JvmMember,MutableMemberDeclaration>() {
      public MutableMemberDeclaration apply(final JvmMember it) {
        MutableMemberDeclaration _switchResult = null;
        boolean _matched = false;
        if (!_matched) {
          if (delegate instanceof JvmDeclaredType) {
            _matched=true;
            _switchResult = CompilationUnitImpl.this.toTypeDeclaration(((JvmDeclaredType)delegate));
          }
        }
        if (!_matched) {
          if (delegate instanceof JvmOperation) {
            _matched=true;
            JvmMemberDeclarationImpl<JvmOperation> _xifexpression = null;
            JvmDeclaredType _declaringType = ((JvmOperation)delegate).getDeclaringType();
            if ((_declaringType instanceof JvmAnnotationType)) {
              JvmAnnotationTypeElementDeclarationImpl _jvmAnnotationTypeElementDeclarationImpl = new JvmAnnotationTypeElementDeclarationImpl();
              final Procedure1<JvmAnnotationTypeElementDeclarationImpl> _function = new Procedure1<JvmAnnotationTypeElementDeclarationImpl>() {
                public void apply(final JvmAnnotationTypeElementDeclarationImpl it) {
                  it.setDelegate(((JvmOperation)delegate));
                  it.setCompilationUnit(CompilationUnitImpl.this);
                }
              };
              _xifexpression = ObjectExtensions.<JvmAnnotationTypeElementDeclarationImpl>operator_doubleArrow(_jvmAnnotationTypeElementDeclarationImpl, _function);
            } else {
              JvmMethodDeclarationImpl _jvmMethodDeclarationImpl = new JvmMethodDeclarationImpl();
              final Procedure1<JvmMethodDeclarationImpl> _function_1 = new Procedure1<JvmMethodDeclarationImpl>() {
                public void apply(final JvmMethodDeclarationImpl it) {
                  it.setDelegate(((JvmOperation)delegate));
                  it.setCompilationUnit(CompilationUnitImpl.this);
                }
              };
              _xifexpression = ObjectExtensions.<JvmMethodDeclarationImpl>operator_doubleArrow(_jvmMethodDeclarationImpl, _function_1);
            }
            _switchResult = _xifexpression;
          }
        }
        if (!_matched) {
          if (delegate instanceof JvmConstructor) {
            _matched=true;
            JvmConstructorDeclarationImpl _jvmConstructorDeclarationImpl = new JvmConstructorDeclarationImpl();
            final Procedure1<JvmConstructorDeclarationImpl> _function = new Procedure1<JvmConstructorDeclarationImpl>() {
              public void apply(final JvmConstructorDeclarationImpl it) {
                it.setDelegate(((JvmConstructor)delegate));
                it.setCompilationUnit(CompilationUnitImpl.this);
              }
            };
            _switchResult = ObjectExtensions.<JvmConstructorDeclarationImpl>operator_doubleArrow(_jvmConstructorDeclarationImpl, _function);
          }
        }
        if (!_matched) {
          if (delegate instanceof JvmEnumerationLiteral) {
            _matched=true;
            JvmEnumerationValueDeclarationImpl _jvmEnumerationValueDeclarationImpl = new JvmEnumerationValueDeclarationImpl();
            final Procedure1<JvmEnumerationValueDeclarationImpl> _function = new Procedure1<JvmEnumerationValueDeclarationImpl>() {
              public void apply(final JvmEnumerationValueDeclarationImpl it) {
                it.setDelegate(((JvmEnumerationLiteral)delegate));
                it.setCompilationUnit(CompilationUnitImpl.this);
              }
            };
            _switchResult = ObjectExtensions.<JvmEnumerationValueDeclarationImpl>operator_doubleArrow(_jvmEnumerationValueDeclarationImpl, _function);
          }
        }
        if (!_matched) {
          if (delegate instanceof JvmField) {
            _matched=true;
            JvmFieldDeclarationImpl _jvmFieldDeclarationImpl = new JvmFieldDeclarationImpl();
            final Procedure1<JvmFieldDeclarationImpl> _function = new Procedure1<JvmFieldDeclarationImpl>() {
              public void apply(final JvmFieldDeclarationImpl it) {
                it.setDelegate(((JvmField)delegate));
                it.setCompilationUnit(CompilationUnitImpl.this);
              }
            };
            _switchResult = ObjectExtensions.<JvmFieldDeclarationImpl>operator_doubleArrow(_jvmFieldDeclarationImpl, _function);
          }
        }
        return _switchResult;
      }
    };
    return this.<JvmMember, MutableMemberDeclaration>getOrCreate(delegate, _function);
  }
  
  public MutableNamedElement toNamedElement(final JvmIdentifiableElement delegate) {
    final Function1<JvmIdentifiableElement,MutableDeclaration> _function = new Function1<JvmIdentifiableElement,MutableDeclaration>() {
      public MutableDeclaration apply(final JvmIdentifiableElement it) {
        MutableDeclaration _switchResult = null;
        boolean _matched = false;
        if (!_matched) {
          if (delegate instanceof JvmMember) {
            _matched=true;
            _switchResult = CompilationUnitImpl.this.toMemberDeclaration(((JvmMember)delegate));
          }
        }
        if (!_matched) {
          if (delegate instanceof JvmTypeParameter) {
            _matched=true;
            _switchResult = CompilationUnitImpl.this.toTypeParameterDeclaration(((JvmTypeParameter)delegate));
          }
        }
        if (!_matched) {
          if (delegate instanceof JvmFormalParameter) {
            _matched=true;
            _switchResult = CompilationUnitImpl.this.toParameterDeclaration(((JvmFormalParameter)delegate));
          }
        }
        if (!_matched) {
          throw new UnsupportedOperationException(("Couldn\'t translate \'" + delegate));
        }
        return _switchResult;
      }
    };
    return this.<JvmIdentifiableElement, MutableDeclaration>getOrCreate(delegate, _function);
  }
  
  public TypeReference toTypeReference(final JvmTypeReference delegate) {
    TypeReference _xblockexpression = null;
    {
      boolean _equals = Objects.equal(delegate, null);
      if (_equals) {
        return null;
      }
      final Function1<JvmTypeReference,TypeReference> _function = new Function1<JvmTypeReference,TypeReference>() {
        public TypeReference apply(final JvmTypeReference it) {
          LightweightTypeReference _lightweightReference = CompilationUnitImpl.this.typeRefConverter.toLightweightReference(delegate);
          return CompilationUnitImpl.this.toTypeReference(_lightweightReference);
        }
      };
      _xblockexpression = (this.<JvmTypeReference, TypeReference>getOrCreate(delegate, _function));
    }
    return _xblockexpression;
  }
  
  public TypeReference toTypeReference(final LightweightTypeReference delegate) {
    TypeReferenceImpl _xblockexpression = null;
    {
      this.checkCanceled();
      boolean _equals = Objects.equal(delegate, null);
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
      _xblockexpression = (ObjectExtensions.<TypeReferenceImpl>operator_doubleArrow(_typeReferenceImpl, _function));
    }
    return _xblockexpression;
  }
  
  public XtendTypeDeclarationImpl<? extends XtendTypeDeclaration> toXtendTypeDeclaration(final XtendTypeDeclaration delegate) {
    final Function1<XtendTypeDeclaration,XtendTypeDeclarationImpl<? extends XtendTypeDeclaration>> _function = new Function1<XtendTypeDeclaration,XtendTypeDeclarationImpl<? extends XtendTypeDeclaration>>() {
      public XtendTypeDeclarationImpl<? extends XtendTypeDeclaration> apply(final XtendTypeDeclaration it) {
        XtendTypeDeclarationImpl<? extends XtendTypeDeclaration> _switchResult = null;
        boolean _matched = false;
        if (!_matched) {
          if (delegate instanceof XtendClass) {
            _matched=true;
            XtendClassDeclarationImpl _xtendClassDeclarationImpl = new XtendClassDeclarationImpl();
            final Procedure1<XtendClassDeclarationImpl> _function = new Procedure1<XtendClassDeclarationImpl>() {
              public void apply(final XtendClassDeclarationImpl it) {
                it.setDelegate(((XtendClass)delegate));
                it.setCompilationUnit(CompilationUnitImpl.this);
              }
            };
            _switchResult = ObjectExtensions.<XtendClassDeclarationImpl>operator_doubleArrow(_xtendClassDeclarationImpl, _function);
          }
        }
        if (!_matched) {
          if (delegate instanceof XtendInterface) {
            _matched=true;
            XtendInterfaceDeclarationImpl _xtendInterfaceDeclarationImpl = new XtendInterfaceDeclarationImpl();
            final Procedure1<XtendInterfaceDeclarationImpl> _function = new Procedure1<XtendInterfaceDeclarationImpl>() {
              public void apply(final XtendInterfaceDeclarationImpl it) {
                it.setDelegate(((XtendInterface)delegate));
                it.setCompilationUnit(CompilationUnitImpl.this);
              }
            };
            _switchResult = ObjectExtensions.<XtendInterfaceDeclarationImpl>operator_doubleArrow(_xtendInterfaceDeclarationImpl, _function);
          }
        }
        if (!_matched) {
          if (delegate instanceof XtendAnnotationType) {
            _matched=true;
            XtendAnnotationTypeDeclarationImpl _xtendAnnotationTypeDeclarationImpl = new XtendAnnotationTypeDeclarationImpl();
            final Procedure1<XtendAnnotationTypeDeclarationImpl> _function = new Procedure1<XtendAnnotationTypeDeclarationImpl>() {
              public void apply(final XtendAnnotationTypeDeclarationImpl it) {
                it.setDelegate(((XtendAnnotationType)delegate));
                it.setCompilationUnit(CompilationUnitImpl.this);
              }
            };
            _switchResult = ObjectExtensions.<XtendAnnotationTypeDeclarationImpl>operator_doubleArrow(_xtendAnnotationTypeDeclarationImpl, _function);
          }
        }
        if (!_matched) {
          if (delegate instanceof XtendEnum) {
            _matched=true;
            XtendEnumerationDeclarationImpl _xtendEnumerationDeclarationImpl = new XtendEnumerationDeclarationImpl();
            final Procedure1<XtendEnumerationDeclarationImpl> _function = new Procedure1<XtendEnumerationDeclarationImpl>() {
              public void apply(final XtendEnumerationDeclarationImpl it) {
                it.setDelegate(((XtendEnum)delegate));
                it.setCompilationUnit(CompilationUnitImpl.this);
              }
            };
            _switchResult = ObjectExtensions.<XtendEnumerationDeclarationImpl>operator_doubleArrow(_xtendEnumerationDeclarationImpl, _function);
          }
        }
        return _switchResult;
      }
    };
    return this.<XtendTypeDeclaration, XtendTypeDeclarationImpl<? extends XtendTypeDeclaration>>getOrCreate(delegate, _function);
  }
  
  public MemberDeclaration toXtendMemberDeclaration(final XtendMember delegate) {
    final Function1<XtendMember,XtendMemberDeclarationImpl<? extends XtendMember>> _function = new Function1<XtendMember,XtendMemberDeclarationImpl<? extends XtendMember>>() {
      public XtendMemberDeclarationImpl<? extends XtendMember> apply(final XtendMember it) {
        XtendMemberDeclarationImpl<? extends XtendMember> _switchResult = null;
        boolean _matched = false;
        if (!_matched) {
          if (delegate instanceof XtendTypeDeclaration) {
            _matched=true;
            _switchResult = CompilationUnitImpl.this.toXtendTypeDeclaration(((XtendTypeDeclaration)delegate));
          }
        }
        if (!_matched) {
          if (delegate instanceof XtendFunction) {
            _matched=true;
            XtendMethodDeclarationImpl _xtendMethodDeclarationImpl = new XtendMethodDeclarationImpl();
            final Procedure1<XtendMethodDeclarationImpl> _function = new Procedure1<XtendMethodDeclarationImpl>() {
              public void apply(final XtendMethodDeclarationImpl it) {
                it.setDelegate(((XtendFunction)delegate));
                it.setCompilationUnit(CompilationUnitImpl.this);
              }
            };
            _switchResult = ObjectExtensions.<XtendMethodDeclarationImpl>operator_doubleArrow(_xtendMethodDeclarationImpl, _function);
          }
        }
        if (!_matched) {
          if (delegate instanceof XtendConstructor) {
            _matched=true;
            XtendConstructorDeclarationImpl _xtendConstructorDeclarationImpl = new XtendConstructorDeclarationImpl();
            final Procedure1<XtendConstructorDeclarationImpl> _function = new Procedure1<XtendConstructorDeclarationImpl>() {
              public void apply(final XtendConstructorDeclarationImpl it) {
                it.setDelegate(((XtendConstructor)delegate));
                it.setCompilationUnit(CompilationUnitImpl.this);
              }
            };
            _switchResult = ObjectExtensions.<XtendConstructorDeclarationImpl>operator_doubleArrow(_xtendConstructorDeclarationImpl, _function);
          }
        }
        if (!_matched) {
          if (delegate instanceof XtendField) {
            _matched=true;
            XtendMemberDeclarationImpl<XtendField> _xifexpression = null;
            EObject _eContainer = ((XtendField)delegate).eContainer();
            if ((_eContainer instanceof XtendAnnotationType)) {
              XtendAnnotationTypeElementDeclarationImpl _xtendAnnotationTypeElementDeclarationImpl = new XtendAnnotationTypeElementDeclarationImpl();
              final Procedure1<XtendAnnotationTypeElementDeclarationImpl> _function = new Procedure1<XtendAnnotationTypeElementDeclarationImpl>() {
                public void apply(final XtendAnnotationTypeElementDeclarationImpl it) {
                  it.setDelegate(((XtendField)delegate));
                  it.setCompilationUnit(CompilationUnitImpl.this);
                }
              };
              _xifexpression = ObjectExtensions.<XtendAnnotationTypeElementDeclarationImpl>operator_doubleArrow(_xtendAnnotationTypeElementDeclarationImpl, _function);
            } else {
              XtendFieldDeclarationImpl _xtendFieldDeclarationImpl = new XtendFieldDeclarationImpl();
              final Procedure1<XtendFieldDeclarationImpl> _function_1 = new Procedure1<XtendFieldDeclarationImpl>() {
                public void apply(final XtendFieldDeclarationImpl it) {
                  it.setDelegate(((XtendField)delegate));
                  it.setCompilationUnit(CompilationUnitImpl.this);
                }
              };
              _xifexpression = ObjectExtensions.<XtendFieldDeclarationImpl>operator_doubleArrow(_xtendFieldDeclarationImpl, _function_1);
            }
            _switchResult = _xifexpression;
          }
        }
        if (!_matched) {
          if (delegate instanceof XtendEnumLiteral) {
            _matched=true;
            XtendEnumerationValueDeclarationImpl _xtendEnumerationValueDeclarationImpl = new XtendEnumerationValueDeclarationImpl();
            final Procedure1<XtendEnumerationValueDeclarationImpl> _function = new Procedure1<XtendEnumerationValueDeclarationImpl>() {
              public void apply(final XtendEnumerationValueDeclarationImpl it) {
                it.setDelegate(((XtendEnumLiteral)delegate));
                it.setCompilationUnit(CompilationUnitImpl.this);
              }
            };
            _switchResult = ObjectExtensions.<XtendEnumerationValueDeclarationImpl>operator_doubleArrow(_xtendEnumerationValueDeclarationImpl, _function);
          }
        }
        return _switchResult;
      }
    };
    return this.<XtendMember, XtendMemberDeclarationImpl<? extends XtendMember>>getOrCreate(delegate, _function);
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
        return ObjectExtensions.<XtendParameterDeclarationImpl>operator_doubleArrow(_xtendParameterDeclarationImpl, _function);
      }
    };
    return this.<XtendParameter, XtendParameterDeclarationImpl>getOrCreate(delegate, _function);
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
        return ObjectExtensions.<XtendTypeParameterDeclarationImpl>operator_doubleArrow(_xtendTypeParameterDeclarationImpl, _function);
      }
    };
    return this.<JvmTypeParameter, XtendTypeParameterDeclarationImpl>getOrCreate(delegate, _function);
  }
  
  public JvmTypeReference toJvmTypeReference(final TypeReference typeRef) {
    this.checkCanceled();
    LightweightTypeReference _lightWeightTypeReference = ((TypeReferenceImpl) typeRef).getLightWeightTypeReference();
    return _lightWeightTypeReference.toJavaCompliantTypeReference();
  }
  
  public LightweightTypeReference toLightweightTypeReference(final TypeReference typeRef) {
    this.checkCanceled();
    return ((TypeReferenceImpl) typeRef).getLightWeightTypeReference();
  }
  
  public Expression toExpression(final XExpression delegate) {
    final Function1<XExpression,ExpressionImpl> _function = new Function1<XExpression,ExpressionImpl>() {
      public ExpressionImpl apply(final XExpression it) {
        ExpressionImpl _expressionImpl = new ExpressionImpl();
        final Procedure1<ExpressionImpl> _function = new Procedure1<ExpressionImpl>() {
          public void apply(final ExpressionImpl it) {
            it.setDelegate(delegate);
            it.setCompilationUnit(CompilationUnitImpl.this);
          }
        };
        return ObjectExtensions.<ExpressionImpl>operator_doubleArrow(_expressionImpl, _function);
      }
    };
    return this.<XExpression, ExpressionImpl>getOrCreate(delegate, _function);
  }
  
  public void setCompilationStrategy(final JvmExecutable executable, final CompilationStrategy compilationStrategy) {
    this.checkCanceled();
    final Procedure1<ITreeAppendable> _function = new Procedure1<ITreeAppendable>() {
      public void apply(final ITreeAppendable it) {
        final CompilationContextImpl context = new CompilationContextImpl(it, CompilationUnitImpl.this);
        CharSequence _compile = compilationStrategy.compile(context);
        CharSequence _trimTrailingLinebreak = CompilationUnitImpl.this.trimTrailingLinebreak(_compile, executable);
        it.append(_trimTrailingLinebreak);
      }
    };
    this.typesBuilder.setBody(executable, _function);
  }
  
  public void setCompilationTemplate(final JvmExecutable executable, final StringConcatenationClient compilationTemplate) {
    this.checkCanceled();
    this.typesBuilder.setBody(executable, compilationTemplate);
  }
  
  protected CharSequence trimTrailingLinebreak(final CharSequence sequence, final EObject context) {
    CharSequence _xblockexpression = null;
    {
      Resource _eResource = null;
      if (context!=null) {
        _eResource=context.eResource();
      }
      URI _uRI = null;
      if (_eResource!=null) {
        _uRI=_eResource.getURI();
      }
      ILineSeparatorInformation _lineSeparatorInformation = null;
      if (_uRI!=null) {
        _lineSeparatorInformation=this._iWhitespaceInformationProvider.getLineSeparatorInformation(_uRI);
      }
      String _lineSeparator = null;
      if (_lineSeparatorInformation!=null) {
        _lineSeparator=_lineSeparatorInformation.getLineSeparator();
      }
      final String lineBreak = _lineSeparator;
      CharSequence _xifexpression = null;
      boolean _and = false;
      boolean _and_1 = false;
      boolean _and_2 = false;
      boolean _notEquals = (!Objects.equal(sequence, null));
      if (!_notEquals) {
        _and_2 = false;
      } else {
        boolean _notEquals_1 = (!Objects.equal(lineBreak, null));
        _and_2 = _notEquals_1;
      }
      if (!_and_2) {
        _and_1 = false;
      } else {
        int _length = sequence.length();
        int _length_1 = lineBreak.length();
        boolean _greaterEqualsThan = (_length >= _length_1);
        _and_1 = _greaterEqualsThan;
      }
      if (!_and_1) {
        _and = false;
      } else {
        int _length_2 = sequence.length();
        int _length_3 = lineBreak.length();
        int _minus = (_length_2 - _length_3);
        int _length_4 = sequence.length();
        CharSequence _subSequence = sequence.subSequence(_minus, _length_4);
        boolean _equals = lineBreak.equals(_subSequence);
        _and = _equals;
      }
      if (_and) {
        int _length_5 = sequence.length();
        int _length_6 = lineBreak.length();
        int _minus_1 = (_length_5 - _length_6);
        _xifexpression = sequence.subSequence(0, _minus_1);
      } else {
        _xifexpression = sequence;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public void setCompilationStrategy(final JvmField field, final CompilationStrategy compilationStrategy) {
    this.checkCanceled();
    final Procedure1<ITreeAppendable> _function = new Procedure1<ITreeAppendable>() {
      public void apply(final ITreeAppendable it) {
        final CompilationContextImpl context = new CompilationContextImpl(it, CompilationUnitImpl.this);
        CharSequence _compile = compilationStrategy.compile(context);
        it.append(_compile);
      }
    };
    this.typesBuilder.setInitializer(field, _function);
  }
  
  public void setCompilationTemplate(final JvmField field, final StringConcatenationClient compilationTemplate) {
    this.checkCanceled();
    this.typesBuilder.setInitializer(field, compilationTemplate);
  }
  
  public AnnotationReference toAnnotationReference(final XAnnotation delegate) {
    final Function1<XAnnotation,XtendAnnotationReferenceImpl> _function = new Function1<XAnnotation,XtendAnnotationReferenceImpl>() {
      public XtendAnnotationReferenceImpl apply(final XAnnotation it) {
        XtendAnnotationReferenceImpl _xtendAnnotationReferenceImpl = new XtendAnnotationReferenceImpl();
        final Procedure1<XtendAnnotationReferenceImpl> _function = new Procedure1<XtendAnnotationReferenceImpl>() {
          public void apply(final XtendAnnotationReferenceImpl it) {
            it.setDelegate(delegate);
            it.setCompilationUnit(CompilationUnitImpl.this);
          }
        };
        return ObjectExtensions.<XtendAnnotationReferenceImpl>operator_doubleArrow(_xtendAnnotationReferenceImpl, _function);
      }
    };
    return this.<XAnnotation, XtendAnnotationReferenceImpl>getOrCreate(delegate, _function);
  }
  
  public MutableAnnotationReference toAnnotationReference(final JvmAnnotationReference delegate) {
    final Function1<JvmAnnotationReference,JvmAnnotationReferenceImpl> _function = new Function1<JvmAnnotationReference,JvmAnnotationReferenceImpl>() {
      public JvmAnnotationReferenceImpl apply(final JvmAnnotationReference it) {
        JvmAnnotationReferenceImpl _jvmAnnotationReferenceImpl = new JvmAnnotationReferenceImpl();
        final Procedure1<JvmAnnotationReferenceImpl> _function = new Procedure1<JvmAnnotationReferenceImpl>() {
          public void apply(final JvmAnnotationReferenceImpl it) {
            it.setDelegate(delegate);
            it.setCompilationUnit(CompilationUnitImpl.this);
          }
        };
        return ObjectExtensions.<JvmAnnotationReferenceImpl>operator_doubleArrow(_jvmAnnotationReferenceImpl, _function);
      }
    };
    return this.<JvmAnnotationReference, JvmAnnotationReferenceImpl>getOrCreate(delegate, _function);
  }
  
  public Object translateAnnotationValue(final JvmAnnotationValue value, final boolean isArray) {
    Pair<List<? extends Object>,Class<? extends Object>> _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (value instanceof JvmCustomAnnotationValue) {
        _matched=true;
        final JvmTypeReference expectedType = this.findExpectedType(value);
        EList<Object> _values = ((JvmCustomAnnotationValue)value).getValues();
        Iterable<XExpression> _filter = Iterables.<XExpression>filter(_values, XExpression.class);
        final Function1<XExpression,Object> _function = new Function1<XExpression,Object>() {
          public Object apply(final XExpression it) {
            return CompilationUnitImpl.this.evaluate(it, expectedType);
          }
        };
        Iterable<Object> _map = IterableExtensions.<XExpression, Object>map(_filter, _function);
        return IterableExtensions.<Object>head(_map);
      }
    }
    if (!_matched) {
      if (value instanceof JvmTypeAnnotationValue) {
        _matched=true;
        EList<JvmTypeReference> _values = ((JvmTypeAnnotationValue)value).getValues();
        final Function1<JvmTypeReference,TypeReference> _function = new Function1<JvmTypeReference,TypeReference>() {
          public TypeReference apply(final JvmTypeReference it) {
            return CompilationUnitImpl.this.toTypeReference(it);
          }
        };
        List<TypeReference> _map = ListExtensions.<JvmTypeReference, TypeReference>map(_values, _function);
        _switchResult = Pair.<List<? extends Object>, Class<? extends Object>>of(_map, TypeReference.class);
      }
    }
    if (!_matched) {
      if (value instanceof JvmAnnotationAnnotationValue) {
        _matched=true;
        EList<JvmAnnotationReference> _values = ((JvmAnnotationAnnotationValue)value).getValues();
        final Function1<JvmAnnotationReference,MutableAnnotationReference> _function = new Function1<JvmAnnotationReference,MutableAnnotationReference>() {
          public MutableAnnotationReference apply(final JvmAnnotationReference it) {
            return CompilationUnitImpl.this.toAnnotationReference(it);
          }
        };
        List<MutableAnnotationReference> _map = ListExtensions.<JvmAnnotationReference, MutableAnnotationReference>map(_values, _function);
        _switchResult = Pair.<List<? extends Object>, Class<? extends Object>>of(_map, AnnotationReference.class);
      }
    }
    if (!_matched) {
      if (value instanceof JvmStringAnnotationValue) {
        _matched=true;
        EList<String> _values = ((JvmStringAnnotationValue)value).getValues();
        _switchResult = Pair.<List<? extends Object>, Class<? extends Object>>of(_values, String.class);
      }
    }
    if (!_matched) {
      if (value instanceof JvmBooleanAnnotationValue) {
        _matched=true;
        EList<Boolean> _values = ((JvmBooleanAnnotationValue)value).getValues();
        _switchResult = Pair.<List<? extends Object>, Class<? extends Object>>of(_values, boolean.class);
      }
    }
    if (!_matched) {
      if (value instanceof JvmIntAnnotationValue) {
        _matched=true;
        EList<Integer> _values = ((JvmIntAnnotationValue)value).getValues();
        _switchResult = Pair.<List<? extends Object>, Class<? extends Object>>of(_values, int.class);
      }
    }
    if (!_matched) {
      if (value instanceof JvmByteAnnotationValue) {
        _matched=true;
        EList<Byte> _values = ((JvmByteAnnotationValue)value).getValues();
        _switchResult = Pair.<List<? extends Object>, Class<? extends Object>>of(_values, byte.class);
      }
    }
    if (!_matched) {
      if (value instanceof JvmCharAnnotationValue) {
        _matched=true;
        EList<Character> _values = ((JvmCharAnnotationValue)value).getValues();
        _switchResult = Pair.<List<? extends Object>, Class<? extends Object>>of(_values, char.class);
      }
    }
    if (!_matched) {
      if (value instanceof JvmDoubleAnnotationValue) {
        _matched=true;
        EList<Double> _values = ((JvmDoubleAnnotationValue)value).getValues();
        _switchResult = Pair.<List<? extends Object>, Class<? extends Object>>of(_values, double.class);
      }
    }
    if (!_matched) {
      if (value instanceof JvmEnumAnnotationValue) {
        _matched=true;
        EList<JvmEnumerationLiteral> _values = ((JvmEnumAnnotationValue)value).getValues();
        final Function1<JvmEnumerationLiteral,MutableNamedElement> _function = new Function1<JvmEnumerationLiteral,MutableNamedElement>() {
          public MutableNamedElement apply(final JvmEnumerationLiteral it) {
            return CompilationUnitImpl.this.toNamedElement(it);
          }
        };
        List<MutableNamedElement> _map = ListExtensions.<JvmEnumerationLiteral, MutableNamedElement>map(_values, _function);
        _switchResult = Pair.<List<? extends Object>, Class<? extends Object>>of(_map, EnumerationValueDeclaration.class);
      }
    }
    if (!_matched) {
      if (value instanceof JvmFloatAnnotationValue) {
        _matched=true;
        EList<Float> _values = ((JvmFloatAnnotationValue)value).getValues();
        _switchResult = Pair.<List<? extends Object>, Class<? extends Object>>of(_values, float.class);
      }
    }
    if (!_matched) {
      if (value instanceof JvmLongAnnotationValue) {
        _matched=true;
        EList<Long> _values = ((JvmLongAnnotationValue)value).getValues();
        _switchResult = Pair.<List<? extends Object>, Class<? extends Object>>of(_values, long.class);
      }
    }
    if (!_matched) {
      if (value instanceof JvmShortAnnotationValue) {
        _matched=true;
        EList<Short> _values = ((JvmShortAnnotationValue)value).getValues();
        _switchResult = Pair.<List<? extends Object>, Class<? extends Object>>of(_values, short.class);
      }
    }
    if (!_matched) {
      List<Object> _emptyList = CollectionLiterals.<Object>emptyList();
      _switchResult = Pair.<List<? extends Object>, Class<? extends Object>>of(_emptyList, Object.class);
    }
    final Pair<List<?>,Class<?>> result = _switchResult;
    if (isArray) {
      List<? extends Object> _key = result.getKey();
      Class<? extends Object> _value = result.getValue();
      return this.toArrayOfType(_key, _value);
    } else {
      List<? extends Object> _key_1 = result.getKey();
      return IterableExtensions.head(_key_1);
    }
  }
  
  protected JvmTypeReference findExpectedType(final JvmAnnotationValue value) {
    JvmOperation _operation = value.getOperation();
    boolean _notEquals = (!Objects.equal(_operation, null));
    if (_notEquals) {
      JvmOperation _operation_1 = value.getOperation();
      return _operation_1.getReturnType();
    }
    JvmTypeReference _switchResult = null;
    EObject _eContainer = value.eContainer();
    final EObject container = _eContainer;
    boolean _matched = false;
    if (!_matched) {
      if (container instanceof JvmOperation) {
        _matched=true;
        _switchResult = ((JvmOperation)container).getReturnType();
      }
    }
    if (!_matched) {
      if (container instanceof JvmAnnotationReference) {
        _matched=true;
        JvmTypeReference _xblockexpression = null;
        {
          JvmAnnotationType _annotation = ((JvmAnnotationReference)container).getAnnotation();
          Iterable<JvmFeature> _findAllFeaturesByName = _annotation.findAllFeaturesByName("value");
          Iterable<JvmOperation> _filter = Iterables.<JvmOperation>filter(_findAllFeaturesByName, JvmOperation.class);
          final JvmOperation defaultOp = IterableExtensions.<JvmOperation>head(_filter);
          JvmTypeReference _xifexpression = null;
          boolean _notEquals_1 = (!Objects.equal(defaultOp, null));
          if (_notEquals_1) {
            _xifexpression = defaultOp.getReturnType();
          }
          _xblockexpression = (_xifexpression);
        }
        _switchResult = _xblockexpression;
      }
    }
    return _switchResult;
  }
  
  private Object toArrayOfType(final Iterable<? extends Object> iterable, final Class<? extends Object> componentType) {
    Collection<? extends Object> _xifexpression = null;
    if ((iterable instanceof Collection<?>)) {
      _xifexpression = ((Collection<? extends Object>)iterable);
    } else {
      _xifexpression = IterableExtensions.toList(iterable);
    }
    final Collection<?> collection = _xifexpression;
    Object _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(componentType,int.class)) {
        _matched=true;
        _switchResult = Ints.toArray(((List<Integer>) collection));
      }
    }
    if (!_matched) {
      if (Objects.equal(componentType,long.class)) {
        _matched=true;
        _switchResult = Longs.toArray(((List<Long>) collection));
      }
    }
    if (!_matched) {
      if (Objects.equal(componentType,char.class)) {
        _matched=true;
        _switchResult = Chars.toArray(((List<Character>) collection));
      }
    }
    if (!_matched) {
      if (Objects.equal(componentType,boolean.class)) {
        _matched=true;
        _switchResult = Booleans.toArray(((List<Boolean>) collection));
      }
    }
    if (!_matched) {
      if (Objects.equal(componentType,byte.class)) {
        _matched=true;
        _switchResult = Bytes.toArray(((List<Byte>) collection));
      }
    }
    if (!_matched) {
      if (Objects.equal(componentType,short.class)) {
        _matched=true;
        _switchResult = Shorts.toArray(((List<Short>) collection));
      }
    }
    if (!_matched) {
      if (Objects.equal(componentType,float.class)) {
        _matched=true;
        _switchResult = Floats.toArray(((List<Float>) collection));
      }
    }
    if (!_matched) {
      if (Objects.equal(componentType,double.class)) {
        _matched=true;
        _switchResult = Doubles.toArray(((List<Double>) collection));
      }
    }
    if (!_matched) {
      _switchResult = Iterables.<Object>toArray(collection, ((Class<Object>) componentType));
    }
    return ((Serializable)_switchResult);
  }
  
  public Object evaluate(final XExpression expression, final JvmTypeReference expectedType) {
    try {
      final Object result = this.interpreter.evaluate(expression, expectedType);
      return this.translate(result);
    } catch (final Throwable _t) {
      if (_t instanceof ConstantExpressionEvaluationException) {
        final ConstantExpressionEvaluationException e = (ConstantExpressionEvaluationException)_t;
        String _message = e.getMessage();
        final EObjectDiagnosticImpl error = new EObjectDiagnosticImpl(Severity.ERROR, "constant_expression_evaluation_problem", _message, expression, null, (-1), null);
        Resource _eResource = expression.eResource();
        EList<Resource.Diagnostic> _errors = _eResource.getErrors();
        _errors.add(error);
        return null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  protected Object translate(final Object object) {
    if ((object instanceof XAnnotation[])) {
      int _length = ((Object[])object).length;
      final AnnotationReference[] result = new AnnotationReference[_length];
      int _length_1 = ((Object[])object).length;
      ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _length_1, true);
      for (final Integer i : _doubleDotLessThan) {
        Object _get = ((Object[])object)[(i).intValue()];
        Object _translate = this.translate(_get);
        result[(i).intValue()] = ((AnnotationReference) _translate);
      }
      return result;
    }
    if ((object instanceof XAnnotation)) {
      return this.toAnnotationReference(((XAnnotation)object));
    }
    if ((object instanceof JvmTypeReference[])) {
      int _length_2 = ((Object[])object).length;
      final TypeReference[] result_1 = new TypeReference[_length_2];
      int _length_3 = ((Object[])object).length;
      ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, _length_3, true);
      for (final Integer i_1 : _doubleDotLessThan_1) {
        Object _get_1 = ((Object[])object)[(i_1).intValue()];
        Object _translate_1 = this.translate(_get_1);
        result_1[(i_1).intValue()] = ((TypeReference) _translate_1);
      }
      return result_1;
    }
    if ((object instanceof JvmTypeReference)) {
      return this.toTypeReference(((JvmTypeReference)object));
    }
    if ((object instanceof JvmEnumerationLiteral[])) {
      int _length_4 = ((Object[])object).length;
      final EnumerationValueDeclaration[] result_2 = new EnumerationValueDeclaration[_length_4];
      int _length_5 = ((Object[])object).length;
      ExclusiveRange _doubleDotLessThan_2 = new ExclusiveRange(0, _length_5, true);
      for (final Integer i_2 : _doubleDotLessThan_2) {
        Object _get_2 = ((Object[])object)[(i_2).intValue()];
        Object _translate_2 = this.translate(_get_2);
        result_2[(i_2).intValue()] = ((EnumerationValueDeclaration) _translate_2);
      }
      return result_2;
    }
    if ((object instanceof JvmEnumerationLiteral)) {
      return this.toMemberDeclaration(((JvmMember)object));
    }
    return object;
  }
}
