/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.io.File;
import java.util.HashMap;
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
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.documentation.IFileHeaderProvider;
import org.eclipse.xtext.formatting.IWhitespaceInformationProvider;
import org.eclipse.xtext.resource.CompilerPhases;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.annotations.interpreter.ConstantExpressionsInterpreter;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.file.WorkspaceConfig;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeExtensions;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.typesystem.legacy.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.IndexingOwnedConverter;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;

@SuppressWarnings("all")
public class CompilationUnitImpl implements CompilationUnit {
  public Iterable<? extends AnnotationReference> getAnnotations() {
    List<AnnotationReference> _emptyList = CollectionLiterals.<AnnotationReference>emptyList();
    return _emptyList;
  }
  
  public AnnotationReference findAnnotation(final Type annotationType) {
    return null;
  }
  
  public String getSimpleName() {
    XtendFile _xtendFile = this.getXtendFile();
    Resource _eResource = _xtendFile.eResource();
    URI _uRI = _eResource.getURI();
    String _lastSegment = _uRI.lastSegment();
    String _string = _lastSegment.toString();
    return _string;
  }
  
  public CompilationUnit getCompilationUnit() {
    return this;
  }
  
  public String getDocComment() {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-generated function stub");
    throw _unsupportedOperationException;
  }
  
  public String getPackageName() {
    XtendFile _xtendFile = this.getXtendFile();
    String _package = _xtendFile.getPackage();
    return _package;
  }
  
  public Iterable<? extends TypeDeclaration> getSourceTypeDeclarations() {
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
  
  private boolean canceled = false;
  
  public boolean setCanceled(final boolean canceled) {
    boolean _canceled = this.canceled = canceled;
    return _canceled;
  }
  
  public void checkCanceled() {
    if (this.canceled) {
      CancellationException _cancellationException = new CancellationException("compilation was canceled.");
      throw _cancellationException;
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
  private MutableFileSystemSupport fileSystemSupport;
  
  @Inject
  private FileLocations fileLocations;
  
  @Inject
  private Provider<WorkspaceConfig> workspaceConfigProvider;
  
  @Inject
  @Extension
  private IWhitespaceInformationProvider _iWhitespaceInformationProvider;
  
  private final ProblemSupport _problemSupport = new Function0<ProblemSupport>() {
    public ProblemSupport apply() {
      ProblemSupportImpl _problemSupportImpl = new ProblemSupportImpl(CompilationUnitImpl.this);
      return _problemSupportImpl;
    }
  }.apply();
  
  public ProblemSupport getProblemSupport() {
    return this._problemSupport;
  }
  
  private final TypeReferenceProvider _typeReferenceProvider = new Function0<TypeReferenceProvider>() {
    public TypeReferenceProvider apply() {
      TypeReferenceProviderImpl _typeReferenceProviderImpl = new TypeReferenceProviderImpl(CompilationUnitImpl.this);
      return _typeReferenceProviderImpl;
    }
  }.apply();
  
  public TypeReferenceProvider getTypeReferenceProvider() {
    return this._typeReferenceProvider;
  }
  
  private final TypeLookupImpl _typeLookup = new Function0<TypeLookupImpl>() {
    public TypeLookupImpl apply() {
      TypeLookupImpl _typeLookupImpl = new TypeLookupImpl(CompilationUnitImpl.this);
      return _typeLookupImpl;
    }
  }.apply();
  
  public TypeLookupImpl getTypeLookup() {
    return this._typeLookup;
  }
  
  private Map<EObject,Object> identityCache = new Function0<Map<EObject,Object>>() {
    public Map<EObject,Object> apply() {
      HashMap<EObject,Object> _newHashMap = CollectionLiterals.<EObject, Object>newHashMap();
      return _newHashMap;
    }
  }.apply();
  
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
    final URI uri = _eResource.getURI();
    boolean _isPlatform = uri.isPlatform();
    if (_isPlatform) {
      String _platformString = uri.toPlatformString(false);
      Path _path = new Path(_platformString);
      return _path;
    }
    boolean _isFile = uri.isFile();
    if (_isFile) {
      WorkspaceConfig _get = this.workspaceConfigProvider.get();
      String _absoluteFileSystemPath = _get.getAbsoluteFileSystemPath();
      File _file = new File(_absoluteFileSystemPath);
      java.net.URI _uRI = _file.toURI();
      final String workspacePath = _uRI.getPath();
      String _fileString = uri.toFileString();
      File _file_1 = new File(_fileString);
      java.net.URI _uRI_1 = _file_1.toURI();
      final String absolutefilePath = _uRI_1.getPath();
      boolean _startsWith = absolutefilePath.startsWith(workspacePath);
      boolean _not = (!_startsWith);
      if (_not) {
        String _plus = ("Couldn\'t determine file path. The file (\'" + absolutefilePath);
        String _plus_1 = (_plus + "\') doesn\'t seem to be contained in the workspace (\'");
        String _plus_2 = (_plus_1 + workspacePath);
        String _plus_3 = (_plus_2 + "\')");
        IllegalStateException _illegalStateException = new IllegalStateException(_plus_3);
        throw _illegalStateException;
      }
      int _length = workspacePath.length();
      final String filePath = absolutefilePath.substring(_length);
      String _string = filePath.toString();
      String _plus_4 = ("/" + _string);
      Path _path_1 = new Path(_plus_4);
      return _path_1;
    }
    String _path_2 = uri.path();
    Path _path_3 = new Path(_path_2);
    return _path_3;
  }
  
  public void setXtendFile(final XtendFile xtendFile) {
    this._xtendFile = xtendFile;
    Resource _eResource = xtendFile.eResource();
    ResourceSet _resourceSet = _eResource.getResourceSet();
    StandardTypeReferenceOwner _standardTypeReferenceOwner = new StandardTypeReferenceOwner(this.services, _resourceSet);
    final StandardTypeReferenceOwner standardTypeReferenceOwner = _standardTypeReferenceOwner;
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
    boolean _isIndexing = this.compilerPhases.isIndexing(_xtendFile);
    return _isIndexing;
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
            _matched=true;
            MutableTypeDeclaration _typeDeclaration = CompilationUnitImpl.this.toTypeDeclaration(((JvmDeclaredType)delegate));
            _switchResult = _typeDeclaration;
          }
        }
        if (!_matched) {
          if (delegate instanceof JvmTypeParameter) {
            _matched=true;
            MutableTypeParameterDeclaration _typeParameterDeclaration = CompilationUnitImpl.this.toTypeParameterDeclaration(((JvmTypeParameter)delegate));
            _switchResult = _typeParameterDeclaration;
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
            VoidTypeImpl _doubleArrow = ObjectExtensions.<VoidTypeImpl>operator_doubleArrow(_voidTypeImpl, _function);
            _switchResult = _doubleArrow;
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
            PrimitiveTypeImpl _doubleArrow = ObjectExtensions.<PrimitiveTypeImpl>operator_doubleArrow(_primitiveTypeImpl, _function);
            _switchResult = _doubleArrow;
          }
        }
        return _switchResult;
      }
    };
    Type _orCreate = this.<JvmType, Type>getOrCreate(delegate, _function);
    return _orCreate;
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
              JvmInterfaceDeclarationImpl _doubleArrow = ObjectExtensions.<JvmInterfaceDeclarationImpl>operator_doubleArrow(_jvmInterfaceDeclarationImpl, _function);
              _switchResult = _doubleArrow;
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
            JvmClassDeclarationImpl _doubleArrow = ObjectExtensions.<JvmClassDeclarationImpl>operator_doubleArrow(_jvmClassDeclarationImpl, _function);
            _switchResult = _doubleArrow;
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
            JvmAnnotationTypeDeclarationImpl _doubleArrow = ObjectExtensions.<JvmAnnotationTypeDeclarationImpl>operator_doubleArrow(_jvmAnnotationTypeDeclarationImpl, _function);
            _switchResult = _doubleArrow;
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
            JvmEnumerationTypeDeclarationImpl _doubleArrow = ObjectExtensions.<JvmEnumerationTypeDeclarationImpl>operator_doubleArrow(_jvmEnumerationTypeDeclarationImpl, _function);
            _switchResult = _doubleArrow;
          }
        }
        return _switchResult;
      }
    };
    JvmTypeDeclarationImpl<? extends JvmDeclaredType> _orCreate = this.<JvmDeclaredType, JvmTypeDeclarationImpl<? extends JvmDeclaredType>>getOrCreate(delegate, _function);
    return _orCreate;
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
        JvmTypeParameterDeclarationImpl _doubleArrow = ObjectExtensions.<JvmTypeParameterDeclarationImpl>operator_doubleArrow(_jvmTypeParameterDeclarationImpl, _function);
        return _doubleArrow;
      }
    };
    JvmTypeParameterDeclarationImpl _orCreate = this.<JvmTypeParameter, JvmTypeParameterDeclarationImpl>getOrCreate(delegate, _function);
    return _orCreate;
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
        JvmParameterDeclarationImpl _doubleArrow = ObjectExtensions.<JvmParameterDeclarationImpl>operator_doubleArrow(_jvmParameterDeclarationImpl, _function);
        return _doubleArrow;
      }
    };
    JvmParameterDeclarationImpl _orCreate = this.<JvmFormalParameter, JvmParameterDeclarationImpl>getOrCreate(delegate, _function);
    return _orCreate;
  }
  
  public MutableMemberDeclaration toMemberDeclaration(final JvmMember delegate) {
    final Function1<JvmMember,MutableMemberDeclaration> _function = new Function1<JvmMember,MutableMemberDeclaration>() {
      public MutableMemberDeclaration apply(final JvmMember it) {
        MutableMemberDeclaration _switchResult = null;
        boolean _matched = false;
        if (!_matched) {
          if (delegate instanceof JvmDeclaredType) {
            _matched=true;
            MutableTypeDeclaration _typeDeclaration = CompilationUnitImpl.this.toTypeDeclaration(((JvmDeclaredType)delegate));
            _switchResult = _typeDeclaration;
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
              JvmAnnotationTypeElementDeclarationImpl _doubleArrow = ObjectExtensions.<JvmAnnotationTypeElementDeclarationImpl>operator_doubleArrow(_jvmAnnotationTypeElementDeclarationImpl, _function);
              _xifexpression = _doubleArrow;
            } else {
              JvmMethodDeclarationImpl _jvmMethodDeclarationImpl = new JvmMethodDeclarationImpl();
              final Procedure1<JvmMethodDeclarationImpl> _function_1 = new Procedure1<JvmMethodDeclarationImpl>() {
                public void apply(final JvmMethodDeclarationImpl it) {
                  it.setDelegate(((JvmOperation)delegate));
                  it.setCompilationUnit(CompilationUnitImpl.this);
                }
              };
              JvmMethodDeclarationImpl _doubleArrow_1 = ObjectExtensions.<JvmMethodDeclarationImpl>operator_doubleArrow(_jvmMethodDeclarationImpl, _function_1);
              _xifexpression = _doubleArrow_1;
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
            JvmConstructorDeclarationImpl _doubleArrow = ObjectExtensions.<JvmConstructorDeclarationImpl>operator_doubleArrow(_jvmConstructorDeclarationImpl, _function);
            _switchResult = _doubleArrow;
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
            JvmEnumerationValueDeclarationImpl _doubleArrow = ObjectExtensions.<JvmEnumerationValueDeclarationImpl>operator_doubleArrow(_jvmEnumerationValueDeclarationImpl, _function);
            _switchResult = _doubleArrow;
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
            JvmFieldDeclarationImpl _doubleArrow = ObjectExtensions.<JvmFieldDeclarationImpl>operator_doubleArrow(_jvmFieldDeclarationImpl, _function);
            _switchResult = _doubleArrow;
          }
        }
        return _switchResult;
      }
    };
    MutableMemberDeclaration _orCreate = this.<JvmMember, MutableMemberDeclaration>getOrCreate(delegate, _function);
    return _orCreate;
  }
  
  public MutableNamedElement toNamedElement(final JvmIdentifiableElement delegate) {
    final Function1<JvmIdentifiableElement,MutableDeclaration> _function = new Function1<JvmIdentifiableElement,MutableDeclaration>() {
      public MutableDeclaration apply(final JvmIdentifiableElement it) {
        MutableDeclaration _switchResult = null;
        boolean _matched = false;
        if (!_matched) {
          if (delegate instanceof JvmMember) {
            _matched=true;
            MutableMemberDeclaration _memberDeclaration = CompilationUnitImpl.this.toMemberDeclaration(((JvmMember)delegate));
            _switchResult = _memberDeclaration;
          }
        }
        if (!_matched) {
          if (delegate instanceof JvmTypeParameter) {
            _matched=true;
            MutableTypeParameterDeclaration _typeParameterDeclaration = CompilationUnitImpl.this.toTypeParameterDeclaration(((JvmTypeParameter)delegate));
            _switchResult = _typeParameterDeclaration;
          }
        }
        if (!_matched) {
          if (delegate instanceof JvmFormalParameter) {
            _matched=true;
            MutableParameterDeclaration _parameterDeclaration = CompilationUnitImpl.this.toParameterDeclaration(((JvmFormalParameter)delegate));
            _switchResult = _parameterDeclaration;
          }
        }
        if (!_matched) {
          String _plus = ("Couldn\'t translate \'" + delegate);
          UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException(_plus);
          throw _unsupportedOperationException;
        }
        return _switchResult;
      }
    };
    MutableDeclaration _orCreate = this.<JvmIdentifiableElement, MutableDeclaration>getOrCreate(delegate, _function);
    return _orCreate;
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
          TypeReference _typeReference = CompilationUnitImpl.this.toTypeReference(_lightweightReference);
          return _typeReference;
        }
      };
      TypeReference _orCreate = this.<JvmTypeReference, TypeReference>getOrCreate(delegate, _function);
      _xblockexpression = (_orCreate);
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
      TypeReferenceImpl _doubleArrow = ObjectExtensions.<TypeReferenceImpl>operator_doubleArrow(_typeReferenceImpl, _function);
      _xblockexpression = (_doubleArrow);
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
            XtendClassDeclarationImpl _doubleArrow = ObjectExtensions.<XtendClassDeclarationImpl>operator_doubleArrow(_xtendClassDeclarationImpl, _function);
            _switchResult = _doubleArrow;
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
            XtendInterfaceDeclarationImpl _doubleArrow = ObjectExtensions.<XtendInterfaceDeclarationImpl>operator_doubleArrow(_xtendInterfaceDeclarationImpl, _function);
            _switchResult = _doubleArrow;
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
            XtendAnnotationTypeDeclarationImpl _doubleArrow = ObjectExtensions.<XtendAnnotationTypeDeclarationImpl>operator_doubleArrow(_xtendAnnotationTypeDeclarationImpl, _function);
            _switchResult = _doubleArrow;
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
            XtendEnumerationDeclarationImpl _doubleArrow = ObjectExtensions.<XtendEnumerationDeclarationImpl>operator_doubleArrow(_xtendEnumerationDeclarationImpl, _function);
            _switchResult = _doubleArrow;
          }
        }
        return _switchResult;
      }
    };
    XtendTypeDeclarationImpl<? extends XtendTypeDeclaration> _orCreate = this.<XtendTypeDeclaration, XtendTypeDeclarationImpl<? extends XtendTypeDeclaration>>getOrCreate(delegate, _function);
    return _orCreate;
  }
  
  public MemberDeclaration toXtendMemberDeclaration(final XtendMember delegate) {
    final Function1<XtendMember,XtendMemberDeclarationImpl<? extends XtendMember>> _function = new Function1<XtendMember,XtendMemberDeclarationImpl<? extends XtendMember>>() {
      public XtendMemberDeclarationImpl<? extends XtendMember> apply(final XtendMember it) {
        XtendMemberDeclarationImpl<? extends XtendMember> _switchResult = null;
        boolean _matched = false;
        if (!_matched) {
          if (delegate instanceof XtendTypeDeclaration) {
            _matched=true;
            XtendTypeDeclarationImpl<? extends XtendTypeDeclaration> _xtendTypeDeclaration = CompilationUnitImpl.this.toXtendTypeDeclaration(((XtendTypeDeclaration)delegate));
            _switchResult = _xtendTypeDeclaration;
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
            XtendMethodDeclarationImpl _doubleArrow = ObjectExtensions.<XtendMethodDeclarationImpl>operator_doubleArrow(_xtendMethodDeclarationImpl, _function);
            _switchResult = _doubleArrow;
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
            XtendConstructorDeclarationImpl _doubleArrow = ObjectExtensions.<XtendConstructorDeclarationImpl>operator_doubleArrow(_xtendConstructorDeclarationImpl, _function);
            _switchResult = _doubleArrow;
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
              XtendAnnotationTypeElementDeclarationImpl _doubleArrow = ObjectExtensions.<XtendAnnotationTypeElementDeclarationImpl>operator_doubleArrow(_xtendAnnotationTypeElementDeclarationImpl, _function);
              _xifexpression = _doubleArrow;
            } else {
              XtendFieldDeclarationImpl _xtendFieldDeclarationImpl = new XtendFieldDeclarationImpl();
              final Procedure1<XtendFieldDeclarationImpl> _function_1 = new Procedure1<XtendFieldDeclarationImpl>() {
                public void apply(final XtendFieldDeclarationImpl it) {
                  it.setDelegate(((XtendField)delegate));
                  it.setCompilationUnit(CompilationUnitImpl.this);
                }
              };
              XtendFieldDeclarationImpl _doubleArrow_1 = ObjectExtensions.<XtendFieldDeclarationImpl>operator_doubleArrow(_xtendFieldDeclarationImpl, _function_1);
              _xifexpression = _doubleArrow_1;
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
            XtendEnumerationValueDeclarationImpl _doubleArrow = ObjectExtensions.<XtendEnumerationValueDeclarationImpl>operator_doubleArrow(_xtendEnumerationValueDeclarationImpl, _function);
            _switchResult = _doubleArrow;
          }
        }
        return _switchResult;
      }
    };
    XtendMemberDeclarationImpl<? extends XtendMember> _orCreate = this.<XtendMember, XtendMemberDeclarationImpl<? extends XtendMember>>getOrCreate(delegate, _function);
    return _orCreate;
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
    XtendParameterDeclarationImpl _orCreate = this.<XtendParameter, XtendParameterDeclarationImpl>getOrCreate(delegate, _function);
    return _orCreate;
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
    XtendTypeParameterDeclarationImpl _orCreate = this.<JvmTypeParameter, XtendTypeParameterDeclarationImpl>getOrCreate(delegate, _function);
    return _orCreate;
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
        ExpressionImpl _doubleArrow = ObjectExtensions.<ExpressionImpl>operator_doubleArrow(_expressionImpl, _function);
        return _doubleArrow;
      }
    };
    ExpressionImpl _orCreate = this.<XExpression, ExpressionImpl>getOrCreate(delegate, _function);
    return _orCreate;
  }
  
  public void setCompilationStrategy(final JvmExecutable executable, final CompilationStrategy compilationStrategy) {
    this.checkCanceled();
    final Procedure1<ITreeAppendable> _function = new Procedure1<ITreeAppendable>() {
      public void apply(final ITreeAppendable it) {
        CompilationContextImpl _compilationContextImpl = new CompilationContextImpl(it, CompilationUnitImpl.this);
        final CompilationContextImpl context = _compilationContextImpl;
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
      CharSequence result = sequence;
      boolean _and = false;
      int _length = result.length();
      boolean _greaterThan = (_length > 0);
      if (!_greaterThan) {
        _and = false;
      } else {
        int _length_1 = result.length();
        int _minus = (_length_1 - 1);
        int _length_2 = result.length();
        CharSequence _subSequence = result.subSequence(_minus, _length_2);
        boolean _equals = "\n".equals(_subSequence);
        _and = (_greaterThan && _equals);
      }
      if (_and) {
        int _length_3 = result.length();
        int _minus_1 = (_length_3 - 1);
        CharSequence _subSequence_1 = result.subSequence(0, _minus_1);
        result = _subSequence_1;
      }
      boolean _and_1 = false;
      int _length_4 = result.length();
      boolean _greaterThan_1 = (_length_4 > 0);
      if (!_greaterThan_1) {
        _and_1 = false;
      } else {
        int _length_5 = result.length();
        int _minus_2 = (_length_5 - 1);
        int _length_6 = result.length();
        CharSequence _subSequence_2 = result.subSequence(_minus_2, _length_6);
        boolean _equals_1 = "\r".equals(_subSequence_2);
        _and_1 = (_greaterThan_1 && _equals_1);
      }
      if (_and_1) {
        int _length_7 = result.length();
        int _minus_3 = (_length_7 - 1);
        CharSequence _subSequence_3 = result.subSequence(0, _minus_3);
        result = _subSequence_3;
      }
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
  
  public void setCompilationStrategy(final JvmField field, final CompilationStrategy compilationStrategy) {
    this.checkCanceled();
    final Procedure1<ITreeAppendable> _function = new Procedure1<ITreeAppendable>() {
      public void apply(final ITreeAppendable it) {
        CompilationContextImpl _compilationContextImpl = new CompilationContextImpl(it, CompilationUnitImpl.this);
        final CompilationContextImpl context = _compilationContextImpl;
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
        XtendAnnotationReferenceImpl _doubleArrow = ObjectExtensions.<XtendAnnotationReferenceImpl>operator_doubleArrow(_xtendAnnotationReferenceImpl, _function);
        return _doubleArrow;
      }
    };
    XtendAnnotationReferenceImpl _orCreate = this.<XAnnotation, XtendAnnotationReferenceImpl>getOrCreate(delegate, _function);
    return _orCreate;
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
        JvmAnnotationReferenceImpl _doubleArrow = ObjectExtensions.<JvmAnnotationReferenceImpl>operator_doubleArrow(_jvmAnnotationReferenceImpl, _function);
        return _doubleArrow;
      }
    };
    JvmAnnotationReferenceImpl _orCreate = this.<JvmAnnotationReference, JvmAnnotationReferenceImpl>getOrCreate(delegate, _function);
    return _orCreate;
  }
  
  public Object translateAnnotationValue(final JvmAnnotationValue value) {
    List<? extends Object> _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (value instanceof JvmCustomAnnotationValue) {
        _matched=true;
        EList<Object> _values = ((JvmCustomAnnotationValue)value).getValues();
        Iterable<XExpression> _filter = Iterables.<XExpression>filter(_values, XExpression.class);
        final Function1<XExpression,Object> _function = new Function1<XExpression,Object>() {
          public Object apply(final XExpression it) {
            Object _evaluate = CompilationUnitImpl.this.evaluate(it);
            return _evaluate;
          }
        };
        Iterable<Object> _map = IterableExtensions.<XExpression, Object>map(_filter, _function);
        List<Object> _list = IterableExtensions.<Object>toList(_map);
        _switchResult = _list;
      }
    }
    if (!_matched) {
      if (value instanceof JvmTypeAnnotationValue) {
        _matched=true;
        EList<JvmTypeReference> _values = ((JvmTypeAnnotationValue)value).getValues();
        final Function1<JvmTypeReference,TypeReference> _function = new Function1<JvmTypeReference,TypeReference>() {
          public TypeReference apply(final JvmTypeReference it) {
            TypeReference _typeReference = CompilationUnitImpl.this.toTypeReference(it);
            return _typeReference;
          }
        };
        List<TypeReference> _map = ListExtensions.<JvmTypeReference, TypeReference>map(_values, _function);
        _switchResult = _map;
      }
    }
    if (!_matched) {
      if (value instanceof JvmAnnotationAnnotationValue) {
        _matched=true;
        EList<JvmAnnotationReference> _values = ((JvmAnnotationAnnotationValue)value).getValues();
        final Function1<JvmAnnotationReference,MutableAnnotationReference> _function = new Function1<JvmAnnotationReference,MutableAnnotationReference>() {
          public MutableAnnotationReference apply(final JvmAnnotationReference it) {
            MutableAnnotationReference _annotationReference = CompilationUnitImpl.this.toAnnotationReference(it);
            return _annotationReference;
          }
        };
        List<MutableAnnotationReference> _map = ListExtensions.<JvmAnnotationReference, MutableAnnotationReference>map(_values, _function);
        _switchResult = _map;
      }
    }
    if (!_matched) {
      if (value instanceof JvmStringAnnotationValue) {
        _matched=true;
        EList<String> _values = ((JvmStringAnnotationValue)value).getValues();
        _switchResult = _values;
      }
    }
    if (!_matched) {
      if (value instanceof JvmBooleanAnnotationValue) {
        _matched=true;
        EList<Boolean> _values = ((JvmBooleanAnnotationValue)value).getValues();
        _switchResult = _values;
      }
    }
    if (!_matched) {
      if (value instanceof JvmIntAnnotationValue) {
        _matched=true;
        EList<Integer> _values = ((JvmIntAnnotationValue)value).getValues();
        _switchResult = _values;
      }
    }
    if (!_matched) {
      if (value instanceof JvmByteAnnotationValue) {
        _matched=true;
        EList<Byte> _values = ((JvmByteAnnotationValue)value).getValues();
        _switchResult = _values;
      }
    }
    if (!_matched) {
      if (value instanceof JvmCharAnnotationValue) {
        _matched=true;
        EList<Character> _values = ((JvmCharAnnotationValue)value).getValues();
        _switchResult = _values;
      }
    }
    if (!_matched) {
      if (value instanceof JvmDoubleAnnotationValue) {
        _matched=true;
        EList<Double> _values = ((JvmDoubleAnnotationValue)value).getValues();
        _switchResult = _values;
      }
    }
    if (!_matched) {
      if (value instanceof JvmEnumAnnotationValue) {
        _matched=true;
        EList<JvmEnumerationLiteral> _values = ((JvmEnumAnnotationValue)value).getValues();
        _switchResult = _values;
      }
    }
    if (!_matched) {
      if (value instanceof JvmFloatAnnotationValue) {
        _matched=true;
        EList<Float> _values = ((JvmFloatAnnotationValue)value).getValues();
        _switchResult = _values;
      }
    }
    if (!_matched) {
      if (value instanceof JvmLongAnnotationValue) {
        _matched=true;
        EList<Long> _values = ((JvmLongAnnotationValue)value).getValues();
        _switchResult = _values;
      }
    }
    if (!_matched) {
      if (value instanceof JvmShortAnnotationValue) {
        _matched=true;
        EList<Short> _values = ((JvmShortAnnotationValue)value).getValues();
        _switchResult = _values;
      }
    }
    if (!_matched) {
      List<Object> _emptyList = CollectionLiterals.<Object>emptyList();
      _switchResult = _emptyList;
    }
    final List<?> result = _switchResult;
    int _size = result.size();
    boolean _greaterThan = (_size > 1);
    if (_greaterThan) {
      return ImmutableList.<Object>copyOf(result);
    }
    return IterableExtensions.head(result);
  }
  
  public Object evaluate(final XExpression expression) {
    return this.interpreter.evaluate(expression, null);
  }
}
