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
import com.google.common.base.Throwables;
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
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.macro.AbstractFileSystemSupport;
import org.eclipse.xtend.core.macro.ActiveAnnotationContexts;
import org.eclipse.xtend.core.macro.AnnotationProcessor;
import org.eclipse.xtend.core.macro.CompilationContextImpl;
import org.eclipse.xtend.core.macro.ConstantExpressionsInterpreter;
import org.eclipse.xtend.core.macro.FileLocationsImpl;
import org.eclipse.xtend.core.macro.ParallelFileSystemSupport;
import org.eclipse.xtend.core.validation.IssueCodes;
import org.eclipse.xtend.core.xtend.XtendAnnotationTarget;
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
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.CompilationStrategy;
import org.eclipse.xtend.lib.macro.declaration.CompilationUnit;
import org.eclipse.xtend.lib.macro.declaration.Declaration;
import org.eclipse.xtend.lib.macro.declaration.Element;
import org.eclipse.xtend.lib.macro.declaration.EnumerationValueDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.NamedElement;
import org.eclipse.xtend.lib.macro.declaration.ParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ResolvedConstructor;
import org.eclipse.xtend.lib.macro.declaration.ResolvedMethod;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.declaration.Visibility;
import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtend.lib.macro.services.AnnotationReferenceProvider;
import org.eclipse.xtend.lib.macro.services.TypeReferenceProvider;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.common.types.JvmAnnotationAnnotationValue;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmBooleanAnnotationValue;
import org.eclipse.xtext.common.types.JvmByteAnnotationValue;
import org.eclipse.xtext.common.types.JvmCharAnnotationValue;
import org.eclipse.xtext.common.types.JvmComponentType;
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
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.documentation.IFileHeaderProvider;
import org.eclipse.xtext.generator.FileSystemAccessQueue;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.CompilerPhases;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.validation.EObjectDiagnosticImpl;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XListLiteral;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.interpreter.ConstantExpressionEvaluationException;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociator;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeExtensions;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedConstructor;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedOperation;
import org.eclipse.xtext.xbase.typesystem.override.OverrideHelper;
import org.eclipse.xtext.xbase.typesystem.references.IndexingLightweightTypeReferenceFactory;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReferenceFactory;
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.validation.ReadAndWriteTracking;
import org.eclipse.xtext.xtype.impl.XComputedTypeReferenceImplCustom;

@SuppressWarnings("all")
public class CompilationUnitImpl implements CompilationUnit {
  @Override
  public Iterable<? extends AnnotationReference> getAnnotations() {
    return CollectionLiterals.<AnnotationReference>emptyList();
  }

  @Override
  public AnnotationReference findAnnotation(final Type annotationType) {
    return null;
  }

  @Override
  public String getSimpleName() {
    return this.xtendFile.eResource().getURI().lastSegment().toString();
  }

  @Override
  public CompilationUnit getCompilationUnit() {
    return this;
  }

  @Override
  public String getDocComment() {
    final List<INode> nodes = this.fileHeaderProvider.getFileHeaderNodes(this.xtendFile.eResource());
    boolean _isEmpty = nodes.isEmpty();
    if (_isEmpty) {
      return "";
    } else {
      return nodes.get(0).getText();
    }
  }

  @Override
  public String getPackageName() {
    return this.xtendFile.getPackage();
  }

  @Override
  public Iterable<? extends TypeDeclaration> getSourceTypeDeclarations() {
    final Function1<XtendTypeDeclaration, XtendTypeDeclarationImpl<? extends XtendTypeDeclaration>> _function = (XtendTypeDeclaration it) -> {
      return this.toXtendTypeDeclaration(it);
    };
    return ListExtensions.<XtendTypeDeclaration, XtendTypeDeclarationImpl<? extends XtendTypeDeclaration>>map(this.xtendFile.getXtendTypes(), _function);
  }

  private volatile boolean canceled = false;

  public boolean setCanceled(final boolean canceled) {
    return this.canceled = canceled;
  }

  public void checkCanceled() {
    if (this.canceled) {
      throw new CancellationException("compilation was canceled.");
    }
  }

  @Inject
  private TypesFactory typesFactory;

  @Inject
  private CompilerPhases compilerPhases;

  @Accessors(AccessorType.PUBLIC_GETTER)
  private XtendFile xtendFile;

  @Accessors(AccessorType.PUBLIC_GETTER)
  private ActiveAnnotationContexts.AnnotationCallback lastPhase = ActiveAnnotationContexts.AnnotationCallback.INDEXING;

  @Inject
  private CommonTypeComputationServices services;

  @Accessors(AccessorType.PUBLIC_GETTER)
  @Inject
  private TypeReferences typeReferences;

  @Accessors(AccessorType.PUBLIC_GETTER)
  @Inject
  private JvmTypesBuilder jvmTypesBuilder;

  @Accessors(AccessorType.PUBLIC_GETTER)
  @Inject
  private IXtendJvmAssociations jvmModelAssociations;

  @Accessors(AccessorType.PUBLIC_GETTER)
  @Inject
  private IJvmModelAssociator jvmModelAssociator;

  @Inject
  private ConstantExpressionsInterpreter interpreter;

  @Accessors(AccessorType.PUBLIC_GETTER)
  @Inject
  private IEObjectDocumentationProvider documentationProvider;

  @Accessors(AccessorType.PUBLIC_GETTER)
  @Inject
  private IFileHeaderProvider fileHeaderProvider;

  @Accessors(AccessorType.PUBLIC_GETTER)
  @Inject
  private JvmTypeExtensions typeExtensions;

  @Accessors(AccessorType.PUBLIC_GETTER)
  @Inject
  private OverrideHelper overrideHelper;

  @Accessors(AccessorType.PUBLIC_GETTER)
  @Inject
  private IResourceChangeRegistry resourceChangeRegistry;

  @Inject
  private AbstractFileSystemSupport fileSystemSupport;

  @Accessors(AccessorType.PUBLIC_GETTER)
  @Inject
  private FileLocationsImpl fileLocations;

  @Accessors(AccessorType.PUBLIC_GETTER)
  @Inject
  private ReadAndWriteTracking readAndWriteTracking;

  @Accessors(AccessorType.PUBLIC_GETTER)
  @Inject
  private IScopeProvider scopeProvider;

  @Accessors(AccessorType.PUBLIC_GETTER)
  @Inject
  private IQualifiedNameConverter qualifiedNameConverter;

  @Accessors(AccessorType.PUBLIC_GETTER)
  @Inject
  private IQualifiedNameProvider qualifiedNameProvider;

  @Accessors
  private final ProblemSupportImpl problemSupport = new ProblemSupportImpl(this);

  @Accessors
  private final TypeReferenceProvider typeReferenceProvider = new TypeReferenceProviderImpl(this);

  @Accessors
  private final AnnotationReferenceProvider annotationReferenceProvider = new AnnotationReferenceProviderImpl(this);

  @Accessors
  private final TypeLookupImpl typeLookup = new TypeLookupImpl(this);

  @Accessors
  private final TracabilityImpl tracability = new TracabilityImpl(this);

  @Accessors
  private final AssociatorImpl associator = new AssociatorImpl(this);

  private Map<Object, Object> identityCache = CollectionLiterals.<Object, Object>newHashMap();

  @Accessors(AccessorType.PUBLIC_GETTER)
  private LightweightTypeReferenceFactory typeRefFactory;

  private MutableFileSystemSupport decoratedFileSystemSupport;

  public MutableFileSystemSupport getFileSystemSupport() {
    MutableFileSystemSupport _xblockexpression = null;
    {
      if ((this.decoratedFileSystemSupport == null)) {
        final FileSystemAccessQueue fileSystemAccessQueue = IterableExtensions.<FileSystemAccessQueue>head(Iterables.<FileSystemAccessQueue>filter(this.xtendFile.eResource().getResourceSet().eAdapters(), FileSystemAccessQueue.class));
        if ((fileSystemAccessQueue == null)) {
          return this.createListeningFileSystemSupport();
        }
        URI _uRI = this.xtendFile.eResource().getURI();
        ChangeListenerAddingFileSystemSupport _createListeningFileSystemSupport = this.createListeningFileSystemSupport();
        ParallelFileSystemSupport _parallelFileSystemSupport = new ParallelFileSystemSupport(_uRI, _createListeningFileSystemSupport, fileSystemAccessQueue);
        this.decoratedFileSystemSupport = _parallelFileSystemSupport;
      }
      _xblockexpression = this.decoratedFileSystemSupport;
    }
    return _xblockexpression;
  }

  private ChangeListenerAddingFileSystemSupport createListeningFileSystemSupport() {
    URI _uRI = this.xtendFile.eResource().getURI();
    return new ChangeListenerAddingFileSystemSupport(_uRI, this.fileSystemSupport, this.resourceChangeRegistry);
  }

  @Override
  public Path getFilePath() {
    return this.fileSystemSupport.getPath(this.xtendFile.eResource());
  }

  public void setXtendFile(final XtendFile xtendFile) {
    this.xtendFile = xtendFile;
    StandardTypeReferenceOwner _standardTypeReferenceOwner = new StandardTypeReferenceOwner(this.services, xtendFile);
    LightweightTypeReferenceFactory _lightweightTypeReferenceFactory = new LightweightTypeReferenceFactory(_standardTypeReferenceOwner);
    this.typeRefFactory = _lightweightTypeReferenceFactory;
    this.fileSystemSupport.setContext(xtendFile.eResource().getResourceSet());
    this.fileLocations.setContext(xtendFile.eResource());
  }

  public void before(final ActiveAnnotationContexts.AnnotationCallback phase) {
    this.lastPhase = phase;
    final StandardTypeReferenceOwner standardTypeReferenceOwner = new StandardTypeReferenceOwner(this.services, this.xtendFile);
    boolean _equals = Objects.equal(ActiveAnnotationContexts.AnnotationCallback.INDEXING, phase);
    if (_equals) {
      IndexingLightweightTypeReferenceFactory _indexingLightweightTypeReferenceFactory = new IndexingLightweightTypeReferenceFactory(standardTypeReferenceOwner);
      this.typeRefFactory = _indexingLightweightTypeReferenceFactory;
    } else {
      LightweightTypeReferenceFactory _lightweightTypeReferenceFactory = new LightweightTypeReferenceFactory(standardTypeReferenceOwner);
      this.typeRefFactory = _lightweightTypeReferenceFactory;
    }
    boolean _equals_1 = Objects.equal(ActiveAnnotationContexts.AnnotationCallback.VALIDATION, phase);
    if (_equals_1) {
      this.problemSupport.validationPhaseStarted();
    }
  }

  public void after(final ActiveAnnotationContexts.AnnotationCallback phase) {
    boolean _equals = Objects.equal(phase, ActiveAnnotationContexts.AnnotationCallback.INDEXING);
    if (_equals) {
      this.identityCache.clear();
    }
    boolean _equals_1 = Objects.equal(phase, ActiveAnnotationContexts.AnnotationCallback.GENERATION);
    if (_equals_1) {
      this.resourceChangeRegistry.discardCreateOrModifyInformation(this.xtendFile.eResource().getURI());
    }
  }

  public boolean isIndexing() {
    return this.compilerPhases.isIndexing(this.xtendFile);
  }

  private <IN extends Object, OUT extends Object> OUT getOrCreate(final IN in, final Function1<? super IN, ? extends OUT> provider) {
    this.checkCanceled();
    if ((in == null)) {
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
    if (delegate != null) {
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
    }
    return _switchResult;
  }

  public ResolvedMethod toResolvedMethod(final IResolvedOperation delegate) {
    final Function1<IResolvedOperation, ResolvedMethodImpl> _function = (IResolvedOperation it) -> {
      ResolvedMethodImpl _resolvedMethodImpl = new ResolvedMethodImpl();
      final Procedure1<ResolvedMethodImpl> _function_1 = (ResolvedMethodImpl it_1) -> {
        it_1.setDelegate(delegate);
        it_1.setCompilationUnit(this);
      };
      return ObjectExtensions.<ResolvedMethodImpl>operator_doubleArrow(_resolvedMethodImpl, _function_1);
    };
    return this.<IResolvedOperation, ResolvedMethodImpl>getOrCreate(delegate, _function);
  }

  public ResolvedConstructor toResolvedConstructor(final IResolvedConstructor delegate) {
    final Function1<IResolvedConstructor, ResolvedConstructorImpl> _function = (IResolvedConstructor it) -> {
      ResolvedConstructorImpl _resolvedConstructorImpl = new ResolvedConstructorImpl();
      final Procedure1<ResolvedConstructorImpl> _function_1 = (ResolvedConstructorImpl it_1) -> {
        it_1.setDelegate(delegate);
        it_1.setCompilationUnit(this);
      };
      return ObjectExtensions.<ResolvedConstructorImpl>operator_doubleArrow(_resolvedConstructorImpl, _function_1);
    };
    return this.<IResolvedConstructor, ResolvedConstructorImpl>getOrCreate(delegate, _function);
  }

  public Type toType(final JvmType delegate) {
    final Function1<JvmType, Type> _function = (JvmType it) -> {
      Type _switchResult = null;
      boolean _matched = false;
      if (delegate instanceof JvmDeclaredType) {
        _matched=true;
        _switchResult = this.toTypeDeclaration(((JvmDeclaredType)delegate));
      }
      if (!_matched) {
        if (delegate instanceof JvmTypeParameter) {
          _matched=true;
          _switchResult = this.toTypeParameterDeclaration(((JvmTypeParameter)delegate));
        }
      }
      if (!_matched) {
        if (delegate instanceof JvmVoid) {
          _matched=true;
          VoidTypeImpl _voidTypeImpl = new VoidTypeImpl();
          final Procedure1<VoidTypeImpl> _function_1 = (VoidTypeImpl it_1) -> {
            it_1.setDelegate(((JvmVoid)delegate));
            it_1.setCompilationUnit(this);
          };
          _switchResult = ObjectExtensions.<VoidTypeImpl>operator_doubleArrow(_voidTypeImpl, _function_1);
        }
      }
      if (!_matched) {
        if (delegate instanceof JvmPrimitiveType) {
          _matched=true;
          PrimitiveTypeImpl _primitiveTypeImpl = new PrimitiveTypeImpl();
          final Procedure1<PrimitiveTypeImpl> _function_1 = (PrimitiveTypeImpl it_1) -> {
            it_1.setDelegate(((JvmPrimitiveType)delegate));
            it_1.setCompilationUnit(this);
          };
          _switchResult = ObjectExtensions.<PrimitiveTypeImpl>operator_doubleArrow(_primitiveTypeImpl, _function_1);
        }
      }
      return _switchResult;
    };
    return this.<JvmType, Type>getOrCreate(delegate, _function);
  }

  public TypeDeclaration toTypeDeclaration(final JvmDeclaredType delegate) {
    final Function1<JvmDeclaredType, TypeDeclaration> _function = (JvmDeclaredType it) -> {
      JvmTypeDeclarationImpl<? extends JvmDeclaredType> _switchResult = null;
      boolean _matched = false;
      if (delegate instanceof JvmGenericType) {
        boolean _isInterface = ((JvmGenericType)delegate).isInterface();
        if (_isInterface) {
          _matched=true;
          JvmInterfaceDeclarationImpl _xifexpression = null;
          boolean _isBelongedToCompilationUnit = this.isBelongedToCompilationUnit(delegate);
          if (_isBelongedToCompilationUnit) {
            MutableJvmInterfaceDeclarationImpl _mutableJvmInterfaceDeclarationImpl = new MutableJvmInterfaceDeclarationImpl();
            final Procedure1<MutableJvmInterfaceDeclarationImpl> _function_1 = (MutableJvmInterfaceDeclarationImpl it_1) -> {
              it_1.setDelegate(((JvmGenericType)delegate));
              it_1.setCompilationUnit(this);
            };
            _xifexpression = ObjectExtensions.<MutableJvmInterfaceDeclarationImpl>operator_doubleArrow(_mutableJvmInterfaceDeclarationImpl, _function_1);
          } else {
            JvmInterfaceDeclarationImpl _jvmInterfaceDeclarationImpl = new JvmInterfaceDeclarationImpl();
            final Procedure1<JvmInterfaceDeclarationImpl> _function_2 = (JvmInterfaceDeclarationImpl it_1) -> {
              it_1.setDelegate(((JvmGenericType)delegate));
              it_1.setCompilationUnit(this);
            };
            _xifexpression = ObjectExtensions.<JvmInterfaceDeclarationImpl>operator_doubleArrow(_jvmInterfaceDeclarationImpl, _function_2);
          }
          _switchResult = _xifexpression;
        }
      }
      if (!_matched) {
        if (delegate instanceof JvmGenericType) {
          _matched=true;
          JvmClassDeclarationImpl _xifexpression = null;
          boolean _isBelongedToCompilationUnit = this.isBelongedToCompilationUnit(delegate);
          if (_isBelongedToCompilationUnit) {
            MutableJvmClassDeclarationImpl _mutableJvmClassDeclarationImpl = new MutableJvmClassDeclarationImpl();
            final Procedure1<MutableJvmClassDeclarationImpl> _function_1 = (MutableJvmClassDeclarationImpl it_1) -> {
              it_1.setDelegate(((JvmGenericType)delegate));
              it_1.setCompilationUnit(this);
            };
            _xifexpression = ObjectExtensions.<MutableJvmClassDeclarationImpl>operator_doubleArrow(_mutableJvmClassDeclarationImpl, _function_1);
          } else {
            JvmClassDeclarationImpl _jvmClassDeclarationImpl = new JvmClassDeclarationImpl();
            final Procedure1<JvmClassDeclarationImpl> _function_2 = (JvmClassDeclarationImpl it_1) -> {
              it_1.setDelegate(((JvmGenericType)delegate));
              it_1.setCompilationUnit(this);
            };
            _xifexpression = ObjectExtensions.<JvmClassDeclarationImpl>operator_doubleArrow(_jvmClassDeclarationImpl, _function_2);
          }
          _switchResult = _xifexpression;
        }
      }
      if (!_matched) {
        if (delegate instanceof JvmAnnotationType) {
          _matched=true;
          JvmAnnotationTypeDeclarationImpl _xifexpression = null;
          boolean _isBelongedToCompilationUnit = this.isBelongedToCompilationUnit(delegate);
          if (_isBelongedToCompilationUnit) {
            MutableJvmAnnotationTypeDeclarationImpl _mutableJvmAnnotationTypeDeclarationImpl = new MutableJvmAnnotationTypeDeclarationImpl();
            final Procedure1<MutableJvmAnnotationTypeDeclarationImpl> _function_1 = (MutableJvmAnnotationTypeDeclarationImpl it_1) -> {
              it_1.setDelegate(((JvmAnnotationType)delegate));
              it_1.setCompilationUnit(this);
            };
            _xifexpression = ObjectExtensions.<MutableJvmAnnotationTypeDeclarationImpl>operator_doubleArrow(_mutableJvmAnnotationTypeDeclarationImpl, _function_1);
          } else {
            JvmAnnotationTypeDeclarationImpl _jvmAnnotationTypeDeclarationImpl = new JvmAnnotationTypeDeclarationImpl();
            final Procedure1<JvmAnnotationTypeDeclarationImpl> _function_2 = (JvmAnnotationTypeDeclarationImpl it_1) -> {
              it_1.setDelegate(((JvmAnnotationType)delegate));
              it_1.setCompilationUnit(this);
            };
            _xifexpression = ObjectExtensions.<JvmAnnotationTypeDeclarationImpl>operator_doubleArrow(_jvmAnnotationTypeDeclarationImpl, _function_2);
          }
          _switchResult = _xifexpression;
        }
      }
      if (!_matched) {
        if (delegate instanceof JvmEnumerationType) {
          _matched=true;
          JvmEnumerationTypeDeclarationImpl _xifexpression = null;
          boolean _isBelongedToCompilationUnit = this.isBelongedToCompilationUnit(delegate);
          if (_isBelongedToCompilationUnit) {
            MutableJvmEnumerationTypeDeclarationImpl _mutableJvmEnumerationTypeDeclarationImpl = new MutableJvmEnumerationTypeDeclarationImpl();
            final Procedure1<MutableJvmEnumerationTypeDeclarationImpl> _function_1 = (MutableJvmEnumerationTypeDeclarationImpl it_1) -> {
              it_1.setDelegate(((JvmEnumerationType)delegate));
              it_1.setCompilationUnit(this);
            };
            _xifexpression = ObjectExtensions.<MutableJvmEnumerationTypeDeclarationImpl>operator_doubleArrow(_mutableJvmEnumerationTypeDeclarationImpl, _function_1);
          } else {
            JvmEnumerationTypeDeclarationImpl _jvmEnumerationTypeDeclarationImpl = new JvmEnumerationTypeDeclarationImpl();
            final Procedure1<JvmEnumerationTypeDeclarationImpl> _function_2 = (JvmEnumerationTypeDeclarationImpl it_1) -> {
              it_1.setDelegate(((JvmEnumerationType)delegate));
              it_1.setCompilationUnit(this);
            };
            _xifexpression = ObjectExtensions.<JvmEnumerationTypeDeclarationImpl>operator_doubleArrow(_jvmEnumerationTypeDeclarationImpl, _function_2);
          }
          _switchResult = _xifexpression;
        }
      }
      return ((TypeDeclaration) _switchResult);
    };
    return this.<JvmDeclaredType, TypeDeclaration>getOrCreate(delegate, _function);
  }

  public TypeParameterDeclaration toTypeParameterDeclaration(final JvmTypeParameter delegate) {
    final Function1<JvmTypeParameter, JvmTypeParameterDeclarationImpl> _function = (JvmTypeParameter it) -> {
      JvmTypeParameterDeclarationImpl _xifexpression = null;
      boolean _isBelongedToCompilationUnit = this.isBelongedToCompilationUnit(delegate);
      if (_isBelongedToCompilationUnit) {
        MutableJvmTypeParameterDeclarationImpl _mutableJvmTypeParameterDeclarationImpl = new MutableJvmTypeParameterDeclarationImpl();
        final Procedure1<MutableJvmTypeParameterDeclarationImpl> _function_1 = (MutableJvmTypeParameterDeclarationImpl it_1) -> {
          it_1.setDelegate(delegate);
          it_1.setCompilationUnit(this);
        };
        _xifexpression = ObjectExtensions.<MutableJvmTypeParameterDeclarationImpl>operator_doubleArrow(_mutableJvmTypeParameterDeclarationImpl, _function_1);
      } else {
        JvmTypeParameterDeclarationImpl _jvmTypeParameterDeclarationImpl = new JvmTypeParameterDeclarationImpl();
        final Procedure1<JvmTypeParameterDeclarationImpl> _function_2 = (JvmTypeParameterDeclarationImpl it_1) -> {
          it_1.setDelegate(delegate);
          it_1.setCompilationUnit(this);
        };
        _xifexpression = ObjectExtensions.<JvmTypeParameterDeclarationImpl>operator_doubleArrow(_jvmTypeParameterDeclarationImpl, _function_2);
      }
      return _xifexpression;
    };
    return this.<JvmTypeParameter, JvmTypeParameterDeclarationImpl>getOrCreate(delegate, _function);
  }

  public ParameterDeclaration toParameterDeclaration(final JvmFormalParameter delegate) {
    final Function1<JvmFormalParameter, JvmParameterDeclarationImpl> _function = (JvmFormalParameter it) -> {
      JvmParameterDeclarationImpl _xifexpression = null;
      boolean _isBelongedToCompilationUnit = this.isBelongedToCompilationUnit(delegate);
      if (_isBelongedToCompilationUnit) {
        MutableJvmParameterDeclarationImpl _mutableJvmParameterDeclarationImpl = new MutableJvmParameterDeclarationImpl();
        final Procedure1<MutableJvmParameterDeclarationImpl> _function_1 = (MutableJvmParameterDeclarationImpl it_1) -> {
          it_1.setDelegate(delegate);
          it_1.setCompilationUnit(this);
        };
        _xifexpression = ObjectExtensions.<MutableJvmParameterDeclarationImpl>operator_doubleArrow(_mutableJvmParameterDeclarationImpl, _function_1);
      } else {
        JvmParameterDeclarationImpl _jvmParameterDeclarationImpl = new JvmParameterDeclarationImpl();
        final Procedure1<JvmParameterDeclarationImpl> _function_2 = (JvmParameterDeclarationImpl it_1) -> {
          it_1.setDelegate(delegate);
          it_1.setCompilationUnit(this);
        };
        _xifexpression = ObjectExtensions.<JvmParameterDeclarationImpl>operator_doubleArrow(_jvmParameterDeclarationImpl, _function_2);
      }
      return _xifexpression;
    };
    return this.<JvmFormalParameter, JvmParameterDeclarationImpl>getOrCreate(delegate, _function);
  }

  public MemberDeclaration toMemberDeclaration(final JvmMember delegate) {
    final Function1<JvmMember, MemberDeclaration> _function = (JvmMember it) -> {
      MemberDeclaration _switchResult = null;
      boolean _matched = false;
      if (delegate instanceof JvmDeclaredType) {
        _matched=true;
        _switchResult = this.toTypeDeclaration(((JvmDeclaredType)delegate));
      }
      if (!_matched) {
        if (delegate instanceof JvmOperation) {
          _matched=true;
          MemberDeclaration _xifexpression = null;
          JvmDeclaredType _declaringType = ((JvmOperation)delegate).getDeclaringType();
          if ((_declaringType instanceof JvmAnnotationType)) {
            JvmAnnotationTypeElementDeclarationImpl _xifexpression_1 = null;
            boolean _isBelongedToCompilationUnit = this.isBelongedToCompilationUnit(delegate);
            if (_isBelongedToCompilationUnit) {
              MutableJvmAnnotationTypeElementDeclarationImpl _mutableJvmAnnotationTypeElementDeclarationImpl = new MutableJvmAnnotationTypeElementDeclarationImpl();
              final Procedure1<MutableJvmAnnotationTypeElementDeclarationImpl> _function_1 = (MutableJvmAnnotationTypeElementDeclarationImpl it_1) -> {
                it_1.setDelegate(((JvmOperation)delegate));
                it_1.setCompilationUnit(this);
              };
              _xifexpression_1 = ObjectExtensions.<MutableJvmAnnotationTypeElementDeclarationImpl>operator_doubleArrow(_mutableJvmAnnotationTypeElementDeclarationImpl, _function_1);
            } else {
              JvmAnnotationTypeElementDeclarationImpl _jvmAnnotationTypeElementDeclarationImpl = new JvmAnnotationTypeElementDeclarationImpl();
              final Procedure1<JvmAnnotationTypeElementDeclarationImpl> _function_2 = (JvmAnnotationTypeElementDeclarationImpl it_1) -> {
                it_1.setDelegate(((JvmOperation)delegate));
                it_1.setCompilationUnit(this);
              };
              _xifexpression_1 = ObjectExtensions.<JvmAnnotationTypeElementDeclarationImpl>operator_doubleArrow(_jvmAnnotationTypeElementDeclarationImpl, _function_2);
            }
            _xifexpression = _xifexpression_1;
          } else {
            JvmMethodDeclarationImpl _xifexpression_2 = null;
            boolean _isBelongedToCompilationUnit_1 = this.isBelongedToCompilationUnit(delegate);
            if (_isBelongedToCompilationUnit_1) {
              MutableJvmMethodDeclarationImpl _mutableJvmMethodDeclarationImpl = new MutableJvmMethodDeclarationImpl();
              final Procedure1<MutableJvmMethodDeclarationImpl> _function_3 = (MutableJvmMethodDeclarationImpl it_1) -> {
                it_1.setDelegate(((JvmOperation)delegate));
                it_1.setCompilationUnit(this);
              };
              _xifexpression_2 = ObjectExtensions.<MutableJvmMethodDeclarationImpl>operator_doubleArrow(_mutableJvmMethodDeclarationImpl, _function_3);
            } else {
              JvmMethodDeclarationImpl _jvmMethodDeclarationImpl = new JvmMethodDeclarationImpl();
              final Procedure1<JvmMethodDeclarationImpl> _function_4 = (JvmMethodDeclarationImpl it_1) -> {
                it_1.setDelegate(((JvmOperation)delegate));
                it_1.setCompilationUnit(this);
              };
              _xifexpression_2 = ObjectExtensions.<JvmMethodDeclarationImpl>operator_doubleArrow(_jvmMethodDeclarationImpl, _function_4);
            }
            _xifexpression = ((MemberDeclaration) _xifexpression_2);
          }
          _switchResult = _xifexpression;
        }
      }
      if (!_matched) {
        if (delegate instanceof JvmConstructor) {
          _matched=true;
          JvmConstructorDeclarationImpl _xifexpression = null;
          boolean _isBelongedToCompilationUnit = this.isBelongedToCompilationUnit(delegate);
          if (_isBelongedToCompilationUnit) {
            MutableJvmConstructorDeclarationImpl _mutableJvmConstructorDeclarationImpl = new MutableJvmConstructorDeclarationImpl();
            final Procedure1<MutableJvmConstructorDeclarationImpl> _function_1 = (MutableJvmConstructorDeclarationImpl it_1) -> {
              it_1.setDelegate(((JvmConstructor)delegate));
              it_1.setCompilationUnit(this);
            };
            _xifexpression = ObjectExtensions.<MutableJvmConstructorDeclarationImpl>operator_doubleArrow(_mutableJvmConstructorDeclarationImpl, _function_1);
          } else {
            JvmConstructorDeclarationImpl _jvmConstructorDeclarationImpl = new JvmConstructorDeclarationImpl();
            final Procedure1<JvmConstructorDeclarationImpl> _function_2 = (JvmConstructorDeclarationImpl it_1) -> {
              it_1.setDelegate(((JvmConstructor)delegate));
              it_1.setCompilationUnit(this);
            };
            _xifexpression = ObjectExtensions.<JvmConstructorDeclarationImpl>operator_doubleArrow(_jvmConstructorDeclarationImpl, _function_2);
          }
          _switchResult = _xifexpression;
        }
      }
      if (!_matched) {
        if (delegate instanceof JvmEnumerationLiteral) {
          _matched=true;
          JvmEnumerationValueDeclarationImpl _xifexpression = null;
          boolean _isBelongedToCompilationUnit = this.isBelongedToCompilationUnit(delegate);
          if (_isBelongedToCompilationUnit) {
            MutableJvmEnumerationValueDeclarationImpl _mutableJvmEnumerationValueDeclarationImpl = new MutableJvmEnumerationValueDeclarationImpl();
            final Procedure1<MutableJvmEnumerationValueDeclarationImpl> _function_1 = (MutableJvmEnumerationValueDeclarationImpl it_1) -> {
              it_1.setDelegate(((JvmEnumerationLiteral)delegate));
              it_1.setCompilationUnit(this);
            };
            _xifexpression = ObjectExtensions.<MutableJvmEnumerationValueDeclarationImpl>operator_doubleArrow(_mutableJvmEnumerationValueDeclarationImpl, _function_1);
          } else {
            JvmEnumerationValueDeclarationImpl _jvmEnumerationValueDeclarationImpl = new JvmEnumerationValueDeclarationImpl();
            final Procedure1<JvmEnumerationValueDeclarationImpl> _function_2 = (JvmEnumerationValueDeclarationImpl it_1) -> {
              it_1.setDelegate(((JvmEnumerationLiteral)delegate));
              it_1.setCompilationUnit(this);
            };
            _xifexpression = ObjectExtensions.<JvmEnumerationValueDeclarationImpl>operator_doubleArrow(_jvmEnumerationValueDeclarationImpl, _function_2);
          }
          _switchResult = _xifexpression;
        }
      }
      if (!_matched) {
        if (delegate instanceof JvmField) {
          _matched=true;
          JvmFieldDeclarationImpl _xifexpression = null;
          boolean _isBelongedToCompilationUnit = this.isBelongedToCompilationUnit(delegate);
          if (_isBelongedToCompilationUnit) {
            MutableJvmFieldDeclarationImpl _mutableJvmFieldDeclarationImpl = new MutableJvmFieldDeclarationImpl();
            final Procedure1<MutableJvmFieldDeclarationImpl> _function_1 = (MutableJvmFieldDeclarationImpl it_1) -> {
              it_1.setDelegate(((JvmField)delegate));
              it_1.setCompilationUnit(this);
            };
            _xifexpression = ObjectExtensions.<MutableJvmFieldDeclarationImpl>operator_doubleArrow(_mutableJvmFieldDeclarationImpl, _function_1);
          } else {
            JvmFieldDeclarationImpl _jvmFieldDeclarationImpl = new JvmFieldDeclarationImpl();
            final Procedure1<JvmFieldDeclarationImpl> _function_2 = (JvmFieldDeclarationImpl it_1) -> {
              it_1.setDelegate(((JvmField)delegate));
              it_1.setCompilationUnit(this);
            };
            _xifexpression = ObjectExtensions.<JvmFieldDeclarationImpl>operator_doubleArrow(_jvmFieldDeclarationImpl, _function_2);
          }
          _switchResult = _xifexpression;
        }
      }
      return _switchResult;
    };
    return this.<JvmMember, MemberDeclaration>getOrCreate(delegate, _function);
  }

  public boolean isBelongedToCompilationUnit(final EObject element) {
    Resource _eResource = element.eResource();
    Resource _eResource_1 = this.xtendFile.eResource();
    return Objects.equal(_eResource, _eResource_1);
  }

  public NamedElement toNamedElement(final JvmIdentifiableElement delegate) {
    final Function1<JvmIdentifiableElement, Declaration> _function = (JvmIdentifiableElement it) -> {
      Declaration _switchResult = null;
      boolean _matched = false;
      if (delegate instanceof JvmMember) {
        _matched=true;
        _switchResult = this.toMemberDeclaration(((JvmMember)delegate));
      }
      if (!_matched) {
        if (delegate instanceof JvmTypeParameter) {
          _matched=true;
          _switchResult = this.toTypeParameterDeclaration(((JvmTypeParameter)delegate));
        }
      }
      if (!_matched) {
        if (delegate instanceof JvmFormalParameter) {
          _matched=true;
          _switchResult = this.toParameterDeclaration(((JvmFormalParameter)delegate));
        }
      }
      if (!_matched) {
        throw new UnsupportedOperationException((("Couldn\'t translate \'" + delegate) + "\'"));
      }
      return _switchResult;
    };
    return this.<JvmIdentifiableElement, Declaration>getOrCreate(delegate, _function);
  }

  public Element toJvmElement(final EObject delegate) {
    final Function1<EObject, Element> _function = (EObject it) -> {
      Element _switchResult = null;
      boolean _matched = false;
      if (delegate instanceof JvmIdentifiableElement) {
        _matched=true;
        _switchResult = this.toNamedElement(((JvmIdentifiableElement)delegate));
      }
      if (!_matched) {
        if (delegate instanceof JvmTypeReference) {
          _matched=true;
          _switchResult = this.toTypeReference(((JvmTypeReference)delegate));
        }
      }
      if (!_matched) {
        if (delegate instanceof XExpression) {
          _matched=true;
          _switchResult = this.toExpression(((XExpression)delegate));
        }
      }
      if (!_matched) {
        if (delegate instanceof JvmAnnotationReference) {
          _matched=true;
          _switchResult = this.toAnnotationReference(((JvmAnnotationReference)delegate));
        }
      }
      if (!_matched) {
        throw new UnsupportedOperationException((("Couldn\'t translate \'" + delegate) + "\'"));
      }
      return _switchResult;
    };
    return this.<EObject, Element>getOrCreate(delegate, _function);
  }

  public TypeReference toTypeReference(final JvmTypeReference delegate) {
    TypeReference _xblockexpression = null;
    {
      if ((delegate == null)) {
        return null;
      }
      TypeReference _switchResult = null;
      boolean _matched = false;
      if (delegate instanceof XComputedTypeReferenceImplCustom) {
        boolean _isEquivalentComputed = ((XComputedTypeReferenceImplCustom)delegate).isEquivalentComputed();
        boolean _not = (!_isEquivalentComputed);
        if (_not) {
          _matched=true;
          InferredTypeReferenceImpl _inferredTypeReferenceImpl = new InferredTypeReferenceImpl();
          final Procedure1<InferredTypeReferenceImpl> _function = (InferredTypeReferenceImpl it) -> {
            it.setDelegate(((XComputedTypeReferenceImplCustom)delegate));
            it.setCompilationUnit(this);
          };
          _switchResult = ObjectExtensions.<InferredTypeReferenceImpl>operator_doubleArrow(_inferredTypeReferenceImpl, _function);
        }
      }
      if (!_matched) {
        _switchResult = this.toTypeReference(this.typeRefFactory.toLightweightReference(delegate), delegate);
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }

  public TypeReference toTypeReference(final LightweightTypeReference delegate) {
    return this.toTypeReference(delegate, null);
  }

  public TypeReference toTypeReference(final LightweightTypeReference delegate, final JvmTypeReference source) {
    TypeReferenceImpl _xblockexpression = null;
    {
      this.checkCanceled();
      if ((delegate == null)) {
        return null;
      }
      TypeReferenceImpl _typeReferenceImpl = new TypeReferenceImpl();
      final Procedure1<TypeReferenceImpl> _function = (TypeReferenceImpl it) -> {
        it.setDelegate(delegate);
        it.setCompilationUnit(this);
        it.setSource(source);
      };
      _xblockexpression = ObjectExtensions.<TypeReferenceImpl>operator_doubleArrow(_typeReferenceImpl, _function);
    }
    return _xblockexpression;
  }

  public XtendTypeDeclarationImpl<? extends XtendTypeDeclaration> toXtendTypeDeclaration(final XtendTypeDeclaration delegate) {
    final Function1<XtendTypeDeclaration, XtendTypeDeclarationImpl<? extends XtendTypeDeclaration>> _function = (XtendTypeDeclaration it) -> {
      XtendTypeDeclarationImpl<? extends XtendTypeDeclaration> _switchResult = null;
      boolean _matched = false;
      if (delegate instanceof XtendClass) {
        _matched=true;
        XtendClassDeclarationImpl _xtendClassDeclarationImpl = new XtendClassDeclarationImpl();
        final Procedure1<XtendClassDeclarationImpl> _function_1 = (XtendClassDeclarationImpl it_1) -> {
          it_1.setDelegate(((XtendClass)delegate));
          it_1.setCompilationUnit(this);
        };
        _switchResult = ObjectExtensions.<XtendClassDeclarationImpl>operator_doubleArrow(_xtendClassDeclarationImpl, _function_1);
      }
      if (!_matched) {
        if (delegate instanceof XtendInterface) {
          _matched=true;
          XtendInterfaceDeclarationImpl _xtendInterfaceDeclarationImpl = new XtendInterfaceDeclarationImpl();
          final Procedure1<XtendInterfaceDeclarationImpl> _function_1 = (XtendInterfaceDeclarationImpl it_1) -> {
            it_1.setDelegate(((XtendInterface)delegate));
            it_1.setCompilationUnit(this);
          };
          _switchResult = ObjectExtensions.<XtendInterfaceDeclarationImpl>operator_doubleArrow(_xtendInterfaceDeclarationImpl, _function_1);
        }
      }
      if (!_matched) {
        if (delegate instanceof XtendAnnotationType) {
          _matched=true;
          XtendAnnotationTypeDeclarationImpl _xtendAnnotationTypeDeclarationImpl = new XtendAnnotationTypeDeclarationImpl();
          final Procedure1<XtendAnnotationTypeDeclarationImpl> _function_1 = (XtendAnnotationTypeDeclarationImpl it_1) -> {
            it_1.setDelegate(((XtendAnnotationType)delegate));
            it_1.setCompilationUnit(this);
          };
          _switchResult = ObjectExtensions.<XtendAnnotationTypeDeclarationImpl>operator_doubleArrow(_xtendAnnotationTypeDeclarationImpl, _function_1);
        }
      }
      if (!_matched) {
        if (delegate instanceof XtendEnum) {
          _matched=true;
          XtendEnumerationDeclarationImpl _xtendEnumerationDeclarationImpl = new XtendEnumerationDeclarationImpl();
          final Procedure1<XtendEnumerationDeclarationImpl> _function_1 = (XtendEnumerationDeclarationImpl it_1) -> {
            it_1.setDelegate(((XtendEnum)delegate));
            it_1.setCompilationUnit(this);
          };
          _switchResult = ObjectExtensions.<XtendEnumerationDeclarationImpl>operator_doubleArrow(_xtendEnumerationDeclarationImpl, _function_1);
        }
      }
      return _switchResult;
    };
    return this.<XtendTypeDeclaration, XtendTypeDeclarationImpl<? extends XtendTypeDeclaration>>getOrCreate(delegate, _function);
  }

  public MemberDeclaration toXtendMemberDeclaration(final XtendMember delegate) {
    final Function1<XtendMember, XtendMemberDeclarationImpl<? extends XtendMember>> _function = (XtendMember it) -> {
      XtendMemberDeclarationImpl<? extends XtendMember> _switchResult = null;
      boolean _matched = false;
      if (delegate instanceof XtendTypeDeclaration) {
        _matched=true;
        _switchResult = this.toXtendTypeDeclaration(((XtendTypeDeclaration)delegate));
      }
      if (!_matched) {
        if (delegate instanceof XtendFunction) {
          _matched=true;
          XtendMethodDeclarationImpl _xtendMethodDeclarationImpl = new XtendMethodDeclarationImpl();
          final Procedure1<XtendMethodDeclarationImpl> _function_1 = (XtendMethodDeclarationImpl it_1) -> {
            it_1.setDelegate(((XtendFunction)delegate));
            it_1.setCompilationUnit(this);
          };
          _switchResult = ObjectExtensions.<XtendMethodDeclarationImpl>operator_doubleArrow(_xtendMethodDeclarationImpl, _function_1);
        }
      }
      if (!_matched) {
        if (delegate instanceof XtendConstructor) {
          _matched=true;
          XtendConstructorDeclarationImpl _xtendConstructorDeclarationImpl = new XtendConstructorDeclarationImpl();
          final Procedure1<XtendConstructorDeclarationImpl> _function_1 = (XtendConstructorDeclarationImpl it_1) -> {
            it_1.setDelegate(((XtendConstructor)delegate));
            it_1.setCompilationUnit(this);
          };
          _switchResult = ObjectExtensions.<XtendConstructorDeclarationImpl>operator_doubleArrow(_xtendConstructorDeclarationImpl, _function_1);
        }
      }
      if (!_matched) {
        if (delegate instanceof XtendField) {
          _matched=true;
          XtendMemberDeclarationImpl<XtendField> _xifexpression = null;
          EObject _eContainer = ((XtendField)delegate).eContainer();
          if ((_eContainer instanceof XtendAnnotationType)) {
            XtendAnnotationTypeElementDeclarationImpl _xtendAnnotationTypeElementDeclarationImpl = new XtendAnnotationTypeElementDeclarationImpl();
            final Procedure1<XtendAnnotationTypeElementDeclarationImpl> _function_1 = (XtendAnnotationTypeElementDeclarationImpl it_1) -> {
              it_1.setDelegate(((XtendField)delegate));
              it_1.setCompilationUnit(this);
            };
            _xifexpression = ObjectExtensions.<XtendAnnotationTypeElementDeclarationImpl>operator_doubleArrow(_xtendAnnotationTypeElementDeclarationImpl, _function_1);
          } else {
            XtendFieldDeclarationImpl _xtendFieldDeclarationImpl = new XtendFieldDeclarationImpl();
            final Procedure1<XtendFieldDeclarationImpl> _function_2 = (XtendFieldDeclarationImpl it_1) -> {
              it_1.setDelegate(((XtendField)delegate));
              it_1.setCompilationUnit(this);
            };
            _xifexpression = ObjectExtensions.<XtendFieldDeclarationImpl>operator_doubleArrow(_xtendFieldDeclarationImpl, _function_2);
          }
          _switchResult = _xifexpression;
        }
      }
      if (!_matched) {
        if (delegate instanceof XtendEnumLiteral) {
          _matched=true;
          XtendEnumerationValueDeclarationImpl _xtendEnumerationValueDeclarationImpl = new XtendEnumerationValueDeclarationImpl();
          final Procedure1<XtendEnumerationValueDeclarationImpl> _function_1 = (XtendEnumerationValueDeclarationImpl it_1) -> {
            it_1.setDelegate(((XtendEnumLiteral)delegate));
            it_1.setCompilationUnit(this);
          };
          _switchResult = ObjectExtensions.<XtendEnumerationValueDeclarationImpl>operator_doubleArrow(_xtendEnumerationValueDeclarationImpl, _function_1);
        }
      }
      return _switchResult;
    };
    return this.<XtendMember, XtendMemberDeclarationImpl<? extends XtendMember>>getOrCreate(delegate, _function);
  }

  public XtendParameterDeclarationImpl toXtendParameterDeclaration(final XtendParameter delegate) {
    final Function1<XtendParameter, XtendParameterDeclarationImpl> _function = (XtendParameter it) -> {
      XtendParameterDeclarationImpl _xtendParameterDeclarationImpl = new XtendParameterDeclarationImpl();
      final Procedure1<XtendParameterDeclarationImpl> _function_1 = (XtendParameterDeclarationImpl it_1) -> {
        it_1.setDelegate(delegate);
        it_1.setCompilationUnit(this);
      };
      return ObjectExtensions.<XtendParameterDeclarationImpl>operator_doubleArrow(_xtendParameterDeclarationImpl, _function_1);
    };
    return this.<XtendParameter, XtendParameterDeclarationImpl>getOrCreate(delegate, _function);
  }

  public XtendTypeParameterDeclarationImpl toXtendTypeParameterDeclaration(final JvmTypeParameter delegate) {
    final Function1<JvmTypeParameter, XtendTypeParameterDeclarationImpl> _function = (JvmTypeParameter it) -> {
      XtendTypeParameterDeclarationImpl _xtendTypeParameterDeclarationImpl = new XtendTypeParameterDeclarationImpl();
      final Procedure1<XtendTypeParameterDeclarationImpl> _function_1 = (XtendTypeParameterDeclarationImpl it_1) -> {
        it_1.setDelegate(delegate);
        it_1.setCompilationUnit(this);
      };
      return ObjectExtensions.<XtendTypeParameterDeclarationImpl>operator_doubleArrow(_xtendTypeParameterDeclarationImpl, _function_1);
    };
    return this.<JvmTypeParameter, XtendTypeParameterDeclarationImpl>getOrCreate(delegate, _function);
  }

  public Element toXtendElement(final EObject delegate) {
    final Function1<EObject, Element> _function = (EObject it) -> {
      Element _switchResult = null;
      boolean _matched = false;
      if (delegate instanceof XtendMember) {
        _matched=true;
        _switchResult = this.toXtendMemberDeclaration(((XtendMember)delegate));
      }
      if (!_matched) {
        if (delegate instanceof XtendParameter) {
          _matched=true;
          _switchResult = this.toXtendParameterDeclaration(((XtendParameter)delegate));
        }
      }
      if (!_matched) {
        if (delegate instanceof JvmTypeParameter) {
          _matched=true;
          _switchResult = this.toXtendTypeParameterDeclaration(((JvmTypeParameter)delegate));
        }
      }
      if (!_matched) {
        if (delegate instanceof JvmTypeReference) {
          _matched=true;
          _switchResult = this.toTypeReference(((JvmTypeReference)delegate));
        }
      }
      if (!_matched) {
        if (delegate instanceof XAnnotation) {
          _matched=true;
          _switchResult = this.toAnnotationReference(((XAnnotation)delegate));
        }
      }
      if (!_matched) {
        if (delegate instanceof XExpression) {
          _matched=true;
          _switchResult = this.toExpression(((XExpression)delegate));
        }
      }
      if (!_matched) {
        throw new UnsupportedOperationException((("Couldn\'t translate \'" + delegate) + "\'"));
      }
      return _switchResult;
    };
    return this.<EObject, Element>getOrCreate(delegate, _function);
  }

  public JvmTypeReference toJvmTypeReference(final TypeReference typeRef) {
    this.checkCanceled();
    JvmTypeReference _switchResult = null;
    boolean _matched = false;
    if (typeRef instanceof TypeReferenceImpl) {
      _matched=true;
      _switchResult = ((TypeReferenceImpl)typeRef).getLightweightTypeReference().toJavaCompliantTypeReference();
    }
    if (!_matched) {
      if (typeRef instanceof InferredTypeReferenceImpl) {
        _matched=true;
        _switchResult = EcoreUtil.<XComputedTypeReferenceImplCustom>copy(((InferredTypeReferenceImpl)typeRef).getDelegate());
      }
    }
    return _switchResult;
  }

  public LightweightTypeReference toLightweightTypeReference(final TypeReference typeRef) {
    this.checkCanceled();
    LightweightTypeReference _switchResult = null;
    boolean _matched = false;
    if (typeRef instanceof TypeReferenceImpl) {
      _matched=true;
      _switchResult = ((TypeReferenceImpl)typeRef).getLightweightTypeReference();
    }
    if (!_matched) {
      if (typeRef instanceof InferredTypeReferenceImpl) {
        _matched=true;
        _switchResult = ((InferredTypeReferenceImpl)typeRef).getLightweightTypeReference();
      }
    }
    return _switchResult;
  }

  public Expression toExpression(final XExpression delegate) {
    final Function1<XExpression, ExpressionImpl> _function = (XExpression it) -> {
      ExpressionImpl _expressionImpl = new ExpressionImpl();
      final Procedure1<ExpressionImpl> _function_1 = (ExpressionImpl it_1) -> {
        it_1.setDelegate(delegate);
        it_1.setCompilationUnit(this);
      };
      return ObjectExtensions.<ExpressionImpl>operator_doubleArrow(_expressionImpl, _function_1);
    };
    return this.<XExpression, ExpressionImpl>getOrCreate(delegate, _function);
  }

  public void setCompilationStrategy(final JvmExecutable executable, final CompilationStrategy compilationStrategy) {
    this.checkCanceled();
    final Procedure1<ITreeAppendable> _function = (ITreeAppendable it) -> {
      final CompilationContextImpl context = new CompilationContextImpl(it, this);
      it.append(this.trimTrailingLinebreak(compilationStrategy.compile(context), executable));
    };
    this.jvmTypesBuilder.setBody(executable, _function);
  }

  public void setCompilationTemplate(final JvmExecutable executable, final StringConcatenationClient compilationTemplate) {
    this.checkCanceled();
    this.jvmTypesBuilder.setBody(executable, compilationTemplate);
  }

  protected CharSequence trimTrailingLinebreak(final CharSequence sequence, final EObject context) {
    return Strings.trimTrailingLineBreak(sequence);
  }

  public void setCompilationStrategy(final JvmField field, final CompilationStrategy compilationStrategy) {
    this.checkCanceled();
    final Procedure1<ITreeAppendable> _function = (ITreeAppendable it) -> {
      final CompilationContextImpl context = new CompilationContextImpl(it, this);
      it.append(compilationStrategy.compile(context));
    };
    this.jvmTypesBuilder.setInitializer(field, _function);
  }

  public void setCompilationTemplate(final JvmField field, final StringConcatenationClient compilationTemplate) {
    this.checkCanceled();
    this.jvmTypesBuilder.setInitializer(field, compilationTemplate);
  }

  public AnnotationReference toAnnotationReference(final XAnnotation delegate) {
    final Function1<XAnnotation, XtendAnnotationReferenceImpl> _function = (XAnnotation it) -> {
      XtendAnnotationReferenceImpl _xtendAnnotationReferenceImpl = new XtendAnnotationReferenceImpl();
      final Procedure1<XtendAnnotationReferenceImpl> _function_1 = (XtendAnnotationReferenceImpl it_1) -> {
        it_1.setDelegate(delegate);
        it_1.setCompilationUnit(this);
      };
      return ObjectExtensions.<XtendAnnotationReferenceImpl>operator_doubleArrow(_xtendAnnotationReferenceImpl, _function_1);
    };
    return this.<XAnnotation, XtendAnnotationReferenceImpl>getOrCreate(delegate, _function);
  }

  public AnnotationReference toAnnotationReference(final JvmAnnotationReference delegate) {
    final Function1<JvmAnnotationReference, JvmAnnotationReferenceImpl> _function = (JvmAnnotationReference it) -> {
      JvmAnnotationReferenceImpl _jvmAnnotationReferenceImpl = new JvmAnnotationReferenceImpl();
      final Procedure1<JvmAnnotationReferenceImpl> _function_1 = (JvmAnnotationReferenceImpl it_1) -> {
        it_1.setDelegate(delegate);
        it_1.setCompilationUnit(this);
      };
      return ObjectExtensions.<JvmAnnotationReferenceImpl>operator_doubleArrow(_jvmAnnotationReferenceImpl, _function_1);
    };
    return this.<JvmAnnotationReference, JvmAnnotationReferenceImpl>getOrCreate(delegate, _function);
  }

  public Object translateAnnotationValue(final XExpression expression, final JvmTypeReference expectedType, final boolean isArray) {
    Object _xblockexpression = null;
    {
      final Object value = this.evaluate(expression, expectedType);
      _xblockexpression = this.translateAnnotationValue(value, expectedType, isArray);
    }
    return _xblockexpression;
  }

  public Object translateAnnotationValue(final JvmAnnotationValue value, final boolean isArray) {
    Pair<List<?>, Class<?>> _switchResult = null;
    boolean _matched = false;
    if (value instanceof JvmCustomAnnotationValue) {
      if ((((JvmCustomAnnotationValue)value).getValues().isEmpty() && isArray)) {
        _matched=true;
        List<Object> _emptyList = CollectionLiterals.<Object>emptyList();
        Class<?> _arrayComponentType = this.toArrayComponentType(this.findExpectedType(value));
        _switchResult = Pair.<List<?>, Class<?>>of(_emptyList, _arrayComponentType);
      }
    }
    if (!_matched) {
      if (value instanceof JvmCustomAnnotationValue) {
        _matched=true;
        final JvmTypeReference expectedType = this.findExpectedType(value);
        final Function1<XExpression, Object> _function = (XExpression it) -> {
          return this.evaluate(it, expectedType);
        };
        final Object result = IterableExtensions.<Object>head(IterableExtensions.<XExpression, Object>map(Iterables.<XExpression>filter(((JvmCustomAnnotationValue)value).getValues(), XExpression.class), _function));
        return this.translateAnnotationValue(result, expectedType, isArray);
      }
    }
    if (!_matched) {
      if (value instanceof JvmTypeAnnotationValue) {
        _matched=true;
        final Function1<JvmTypeReference, TypeReference> _function = (JvmTypeReference it) -> {
          return this.toTypeReference(it);
        };
        List<TypeReference> _map = ListExtensions.<JvmTypeReference, TypeReference>map(((JvmTypeAnnotationValue)value).getValues(), _function);
        _switchResult = Pair.<List<?>, Class<?>>of(_map, TypeReference.class);
      }
    }
    if (!_matched) {
      if (value instanceof JvmAnnotationAnnotationValue) {
        _matched=true;
        final Function1<JvmAnnotationReference, AnnotationReference> _function = (JvmAnnotationReference it) -> {
          return this.toAnnotationReference(it);
        };
        List<AnnotationReference> _map = ListExtensions.<JvmAnnotationReference, AnnotationReference>map(((JvmAnnotationAnnotationValue)value).getValues(), _function);
        _switchResult = Pair.<List<?>, Class<?>>of(_map, AnnotationReference.class);
      }
    }
    if (!_matched) {
      if (value instanceof JvmStringAnnotationValue) {
        _matched=true;
        EList<String> _values = ((JvmStringAnnotationValue)value).getValues();
        _switchResult = Pair.<List<?>, Class<?>>of(_values, String.class);
      }
    }
    if (!_matched) {
      if (value instanceof JvmBooleanAnnotationValue) {
        _matched=true;
        EList<Boolean> _values = ((JvmBooleanAnnotationValue)value).getValues();
        _switchResult = Pair.<List<?>, Class<?>>of(_values, boolean.class);
      }
    }
    if (!_matched) {
      if (value instanceof JvmIntAnnotationValue) {
        _matched=true;
        EList<Integer> _values = ((JvmIntAnnotationValue)value).getValues();
        _switchResult = Pair.<List<?>, Class<?>>of(_values, int.class);
      }
    }
    if (!_matched) {
      if (value instanceof JvmByteAnnotationValue) {
        _matched=true;
        EList<Byte> _values = ((JvmByteAnnotationValue)value).getValues();
        _switchResult = Pair.<List<?>, Class<?>>of(_values, byte.class);
      }
    }
    if (!_matched) {
      if (value instanceof JvmCharAnnotationValue) {
        _matched=true;
        EList<Character> _values = ((JvmCharAnnotationValue)value).getValues();
        _switchResult = Pair.<List<?>, Class<?>>of(_values, char.class);
      }
    }
    if (!_matched) {
      if (value instanceof JvmDoubleAnnotationValue) {
        _matched=true;
        EList<Double> _values = ((JvmDoubleAnnotationValue)value).getValues();
        _switchResult = Pair.<List<?>, Class<?>>of(_values, double.class);
      }
    }
    if (!_matched) {
      if (value instanceof JvmEnumAnnotationValue) {
        _matched=true;
        final Function1<JvmEnumerationLiteral, NamedElement> _function = (JvmEnumerationLiteral it) -> {
          return this.toNamedElement(it);
        };
        List<NamedElement> _map = ListExtensions.<JvmEnumerationLiteral, NamedElement>map(((JvmEnumAnnotationValue)value).getValues(), _function);
        _switchResult = Pair.<List<?>, Class<?>>of(_map, EnumerationValueDeclaration.class);
      }
    }
    if (!_matched) {
      if (value instanceof JvmFloatAnnotationValue) {
        _matched=true;
        EList<Float> _values = ((JvmFloatAnnotationValue)value).getValues();
        _switchResult = Pair.<List<?>, Class<?>>of(_values, float.class);
      }
    }
    if (!_matched) {
      if (value instanceof JvmLongAnnotationValue) {
        _matched=true;
        EList<Long> _values = ((JvmLongAnnotationValue)value).getValues();
        _switchResult = Pair.<List<?>, Class<?>>of(_values, long.class);
      }
    }
    if (!_matched) {
      if (value instanceof JvmShortAnnotationValue) {
        _matched=true;
        EList<Short> _values = ((JvmShortAnnotationValue)value).getValues();
        _switchResult = Pair.<List<?>, Class<?>>of(_values, short.class);
      }
    }
    if (!_matched) {
      List<Object> _emptyList = CollectionLiterals.<Object>emptyList();
      _switchResult = Pair.<List<?>, Class<?>>of(_emptyList, Object.class);
    }
    final Pair<List<?>, Class<?>> result = _switchResult;
    if (isArray) {
      return this.toArrayOfType(result.getKey(), result.getValue());
    } else {
      return IterableExtensions.head(result.getKey());
    }
  }

  protected Object translateAnnotationValue(final Object value, final JvmTypeReference expectedType, final boolean isArray) {
    Object _xblockexpression = null;
    {
      if ((value == null)) {
        return null;
      }
      if (((!isArray) || value.getClass().isArray())) {
        return value;
      }
      _xblockexpression = this.toArrayOfType(CollectionLiterals.<Object>newArrayList(value), this.toArrayComponentType(expectedType));
    }
    return _xblockexpression;
  }

  protected Class<?> toArrayComponentType(final JvmTypeReference valueExpectedType) {
    Class<?> _xblockexpression = null;
    {
      JvmType _type = valueExpectedType.getType();
      final JvmArrayType expectedType = ((JvmArrayType) _type);
      final JvmComponentType componentType = expectedType.getComponentType();
      final String componentTypeName = componentType.getIdentifier();
      Class<?> _switchResult = null;
      if (componentTypeName != null) {
        switch (componentTypeName) {
          case "java.lang.Class":
            _switchResult = TypeReference.class;
            break;
          case "java.lang.String":
            _switchResult = String.class;
            break;
          case "boolean":
            _switchResult = boolean.class;
            break;
          case "int":
            _switchResult = int.class;
            break;
          case "byte":
            _switchResult = byte.class;
            break;
          case "char":
            _switchResult = char.class;
            break;
          case "double":
            _switchResult = double.class;
            break;
          case "float":
            _switchResult = float.class;
            break;
          case "long":
            _switchResult = long.class;
            break;
          case "short":
            _switchResult = short.class;
            break;
          default:
            Class<?> _switchResult_1 = null;
            boolean _matched = false;
            if (componentType instanceof JvmEnumerationType) {
              _matched=true;
              _switchResult_1 = EnumerationValueDeclaration.class;
            }
            if (!_matched) {
              if (componentType instanceof JvmAnnotationType) {
                _matched=true;
                _switchResult_1 = AnnotationReference.class;
              }
            }
            if (!_matched) {
              _switchResult_1 = Object.class;
            }
            _switchResult = _switchResult_1;
            break;
        }
      } else {
        Class<?> _switchResult_1 = null;
        boolean _matched = false;
        if (componentType instanceof JvmEnumerationType) {
          _matched=true;
          _switchResult_1 = EnumerationValueDeclaration.class;
        }
        if (!_matched) {
          if (componentType instanceof JvmAnnotationType) {
            _matched=true;
            _switchResult_1 = AnnotationReference.class;
          }
        }
        if (!_matched) {
          _switchResult_1 = Object.class;
        }
        _switchResult = _switchResult_1;
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }

  protected JvmTypeReference findExpectedType(final JvmAnnotationValue value) {
    JvmOperation _operation = value.getOperation();
    boolean _tripleNotEquals = (_operation != null);
    if (_tripleNotEquals) {
      return value.getOperation().getReturnType();
    }
    JvmTypeReference _switchResult = null;
    EObject _eContainer = value.eContainer();
    final EObject container = _eContainer;
    boolean _matched = false;
    if (container instanceof JvmOperation) {
      _matched=true;
      _switchResult = ((JvmOperation)container).getReturnType();
    }
    if (!_matched) {
      if (container instanceof JvmAnnotationReference) {
        _matched=true;
        JvmTypeReference _xblockexpression = null;
        {
          final JvmOperation defaultOp = IterableExtensions.<JvmOperation>head(Iterables.<JvmOperation>filter(((JvmAnnotationReference)container).getAnnotation().findAllFeaturesByName("value"), JvmOperation.class));
          JvmTypeReference _xifexpression = null;
          if ((defaultOp != null)) {
            _xifexpression = defaultOp.getReturnType();
          }
          _xblockexpression = _xifexpression;
        }
        _switchResult = _xblockexpression;
      }
    }
    return _switchResult;
  }

  private Object toArrayOfType(final Iterable<?> iterable, final Class<?> componentType) {
    Collection<?> _xifexpression = null;
    if ((iterable instanceof Collection<?>)) {
      _xifexpression = ((Collection<?>)iterable);
    } else {
      _xifexpression = IterableExtensions.toList(iterable);
    }
    final Collection<?> collection = _xifexpression;
    Object _switchResult = null;
    boolean _matched = false;
    if (Objects.equal(componentType, int.class)) {
      _matched=true;
      _switchResult = Ints.toArray(((List<Integer>) collection));
    }
    if (!_matched) {
      if (Objects.equal(componentType, long.class)) {
        _matched=true;
        _switchResult = Longs.toArray(((List<Long>) collection));
      }
    }
    if (!_matched) {
      if (Objects.equal(componentType, char.class)) {
        _matched=true;
        _switchResult = Chars.toArray(((List<Character>) collection));
      }
    }
    if (!_matched) {
      if (Objects.equal(componentType, boolean.class)) {
        _matched=true;
        _switchResult = Booleans.toArray(((List<Boolean>) collection));
      }
    }
    if (!_matched) {
      if (Objects.equal(componentType, byte.class)) {
        _matched=true;
        _switchResult = Bytes.toArray(((List<Byte>) collection));
      }
    }
    if (!_matched) {
      if (Objects.equal(componentType, short.class)) {
        _matched=true;
        _switchResult = Shorts.toArray(((List<Short>) collection));
      }
    }
    if (!_matched) {
      if (Objects.equal(componentType, float.class)) {
        _matched=true;
        _switchResult = Floats.toArray(((List<Float>) collection));
      }
    }
    if (!_matched) {
      if (Objects.equal(componentType, double.class)) {
        _matched=true;
        _switchResult = Doubles.toArray(((List<Double>) collection));
      }
    }
    if (!_matched) {
      _switchResult = Iterables.<Object>toArray(collection, ((Class<Object>) componentType));
    }
    return _switchResult;
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
        expression.eResource().getErrors().add(error);
        return null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }

  protected Object translate(final Object object) {
    if ((object instanceof XAnnotation[])) {
      final AnnotationReference[] result = new AnnotationReference[((Object[])object).length];
      int _length = ((Object[])object).length;
      ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _length, true);
      for (final Integer i : _doubleDotLessThan) {
        result[(i).intValue()] = this.translateAnnotation(((XAnnotation[])object)[(i).intValue()]);
      }
      return result;
    }
    if ((object instanceof XAnnotation)) {
      return this.translateAnnotation(((XAnnotation)object));
    }
    if ((object instanceof JvmTypeReference[])) {
      final TypeReference[] result_1 = new TypeReference[((Object[])object).length];
      int _length_1 = ((Object[])object).length;
      ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, _length_1, true);
      for (final Integer i_1 : _doubleDotLessThan_1) {
        Object _translate = this.translate(((Object[])object)[(i_1).intValue()]);
        result_1[(i_1).intValue()] = ((TypeReference) _translate);
      }
      return result_1;
    }
    if ((object instanceof JvmTypeReference)) {
      return this.toTypeReference(((JvmTypeReference)object));
    }
    if ((object instanceof JvmEnumerationLiteral[])) {
      final EnumerationValueDeclaration[] result_2 = new EnumerationValueDeclaration[((Object[])object).length];
      int _length_2 = ((Object[])object).length;
      ExclusiveRange _doubleDotLessThan_2 = new ExclusiveRange(0, _length_2, true);
      for (final Integer i_2 : _doubleDotLessThan_2) {
        Object _translate_1 = this.translate(((Object[])object)[(i_2).intValue()]);
        result_2[(i_2).intValue()] = ((EnumerationValueDeclaration) _translate_1);
      }
      return result_2;
    }
    if ((object instanceof JvmEnumerationLiteral)) {
      return this.toMemberDeclaration(((JvmMember)object));
    }
    return object;
  }

  protected AnnotationReference translateAnnotation(final XAnnotation annotation) {
    AnnotationReference _xblockexpression = null;
    {
      AnnotationReferenceBuildContextImpl _annotationReferenceBuildContextImpl = new AnnotationReferenceBuildContextImpl();
      final Procedure1<AnnotationReferenceBuildContextImpl> _function = (AnnotationReferenceBuildContextImpl it) -> {
        it.setCompilationUnit(this);
        JvmAnnotationReference _createJvmAnnotationReference = this.typesFactory.createJvmAnnotationReference();
        final Procedure1<JvmAnnotationReference> _function_1 = (JvmAnnotationReference reference) -> {
          JvmType _annotationType = annotation.getAnnotationType();
          reference.setAnnotation(((JvmAnnotationType) _annotationType));
        };
        JvmAnnotationReference _doubleArrow = ObjectExtensions.<JvmAnnotationReference>operator_doubleArrow(_createJvmAnnotationReference, _function_1);
        it.setDelegate(_doubleArrow);
      };
      final AnnotationReferenceBuildContextImpl buildContext = ObjectExtensions.<AnnotationReferenceBuildContextImpl>operator_doubleArrow(_annotationReferenceBuildContextImpl, _function);
      EList<XAnnotationElementValuePair> _elementValuePairs = annotation.getElementValuePairs();
      for (final XAnnotationElementValuePair valuePair : _elementValuePairs) {
        {
          final XExpression value = valuePair.getValue();
          if ((value != null)) {
            final JvmOperation operation = valuePair.getElement();
            final Object annotationValue = this.translateAnnotationValue(value, operation.getReturnType());
            buildContext.set(operation.getSimpleName(), annotationValue);
          }
        }
      }
      XExpression _value = annotation.getValue();
      boolean _tripleNotEquals = (_value != null);
      if (_tripleNotEquals) {
        final Object annotationValue = this.translateAnnotationValue(annotation.getValue(), null);
        buildContext.set("value", annotationValue);
      }
      _xblockexpression = this.toAnnotationReference(buildContext.getDelegate());
    }
    return _xblockexpression;
  }

  protected Object translateAnnotationValue(final XExpression value, final JvmTypeReference expectedType) {
    Object _xblockexpression = null;
    {
      if ((value instanceof XAnnotation)) {
        return this.translateAnnotation(((XAnnotation)value));
      }
      if ((value instanceof XListLiteral)) {
        final Iterable<XAnnotation> annotations = Iterables.<XAnnotation>filter(((XListLiteral)value).getElements(), XAnnotation.class);
        int _size = ((XListLiteral)value).getElements().size();
        int _size_1 = IterableExtensions.size(annotations);
        boolean _equals = (_size == _size_1);
        if (_equals) {
          final ArrayList<AnnotationReference> annotationReferences = CollectionLiterals.<AnnotationReference>newArrayList();
          for (final XAnnotation annotation : annotations) {
            AnnotationReference _translateAnnotation = this.translateAnnotation(annotation);
            annotationReferences.add(_translateAnnotation);
          }
          final AnnotationReference[] result = ((AnnotationReference[])Conversions.unwrapArray(annotationReferences, AnnotationReference.class));
          return result;
        }
      }
      _xblockexpression = this.translate(this.evaluate(value, expectedType));
    }
    return _xblockexpression;
  }

  public void handleProcessingError(final Iterable<? extends EObject> sourceElements, final Resource resource, final Throwable t) {
    if ((t instanceof VirtualMachineError)) {
      throw ((VirtualMachineError)t);
    }
    boolean _equals = Objects.equal(this.lastPhase, ActiveAnnotationContexts.AnnotationCallback.GENERATION);
    if (_equals) {
      Throwables.throwIfUnchecked(t);
      String _messageWithoutStackTrace = this.getMessageWithoutStackTrace(t);
      throw new RuntimeException(_messageWithoutStackTrace, t);
    }
    final String msg = this.getMessageWithStackTrace(t);
    final EList<Resource.Diagnostic> errors = resource.getErrors();
    for (final EObject target : sourceElements) {
      boolean _matched = false;
      if (target instanceof XtendAnnotationTarget) {
        _matched=true;
        final EList<XAnnotation> annotations = ((XtendAnnotationTarget)target).getAnnotations();
        EObject _xifexpression = null;
        boolean _isEmpty = annotations.isEmpty();
        if (_isEmpty) {
          _xifexpression = target;
        } else {
          _xifexpression = IterableExtensions.<XAnnotation>head(annotations);
        }
        EObjectDiagnosticImpl _eObjectDiagnosticImpl = new EObjectDiagnosticImpl(Severity.ERROR, IssueCodes.PROCESSING_ERROR, msg, _xifexpression, null, (-1), null);
        errors.add(_eObjectDiagnosticImpl);
      }
      if (!_matched) {
        EObjectDiagnosticImpl _eObjectDiagnosticImpl = new EObjectDiagnosticImpl(Severity.ERROR, IssueCodes.PROCESSING_ERROR, msg, target, null, (-1), null);
        errors.add(_eObjectDiagnosticImpl);
      }
    }
  }

  protected String getMessageWithStackTrace(final Throwable t) {
    final Function1<Throwable, String> _function = (Throwable it) -> {
      String _xblockexpression = null;
      {
        StringWriter _stringWriter = new StringWriter();
        final Procedure1<StringWriter> _function_1 = (StringWriter it_1) -> {
          PrintWriter _printWriter = new PrintWriter(it_1);
          final Procedure1<PrintWriter> _function_2 = (PrintWriter it_2) -> {
            it_2.println(this.getMessageWithoutStackTrace(t));
            t.printStackTrace(it_2);
            it_2.flush();
          };
          ObjectExtensions.<PrintWriter>operator_doubleArrow(_printWriter, _function_2);
        };
        final StringWriter writer = ObjectExtensions.<StringWriter>operator_doubleArrow(_stringWriter, _function_1);
        _xblockexpression = writer.toString();
      }
      return _xblockexpression;
    };
    return this.getMessageWithReducedStackTrace(t, _function);
  }

  protected String getMessageWithoutStackTrace(final Throwable t) {
    String _xifexpression = null;
    if (((t instanceof IncompatibleClassChangeError) && t.getMessage().contains("org.eclipse.xtend.lib.macro"))) {
      _xifexpression = "An active annotation used in this file was compiled against a different version of Xtend than the one that is currently installed.";
    } else {
      _xifexpression = "Error during annotation processing:";
    }
    return _xifexpression;
  }

  protected String getMessageWithReducedStackTrace(final Throwable t, final Function1<? super Throwable, ? extends String> getMessage) {
    final StackTraceElement[] stackTrace = t.getStackTrace();
    final ArrayList<StackTraceElement> reducedStackTrace = CollectionLiterals.<StackTraceElement>newArrayList();
    for (final StackTraceElement it : stackTrace) {
      {
        if ((it.getClassName().contains(AnnotationProcessor.class.getName()) || 
          it.getClassName().contains(ProblemSupportImpl.class.getName()))) {
          try {
            t.setStackTrace(((StackTraceElement[])Conversions.unwrapArray(reducedStackTrace, StackTraceElement.class)));
            return getMessage.apply(t);
          } finally {
            t.setStackTrace(stackTrace);
          }
        }
        reducedStackTrace.add(it);
      }
    }
    return getMessage.apply(t);
  }

  public String getFileHeader() {
    return this.fileHeaderProvider.getFileHeader(this.xtendFile.eResource());
  }

  @Pure
  public XtendFile getXtendFile() {
    return this.xtendFile;
  }

  @Pure
  public ActiveAnnotationContexts.AnnotationCallback getLastPhase() {
    return this.lastPhase;
  }

  @Pure
  public TypeReferences getTypeReferences() {
    return this.typeReferences;
  }

  @Pure
  public JvmTypesBuilder getJvmTypesBuilder() {
    return this.jvmTypesBuilder;
  }

  @Pure
  public IXtendJvmAssociations getJvmModelAssociations() {
    return this.jvmModelAssociations;
  }

  @Pure
  public IJvmModelAssociator getJvmModelAssociator() {
    return this.jvmModelAssociator;
  }

  @Pure
  public IEObjectDocumentationProvider getDocumentationProvider() {
    return this.documentationProvider;
  }

  @Pure
  public IFileHeaderProvider getFileHeaderProvider() {
    return this.fileHeaderProvider;
  }

  @Pure
  public JvmTypeExtensions getTypeExtensions() {
    return this.typeExtensions;
  }

  @Pure
  public OverrideHelper getOverrideHelper() {
    return this.overrideHelper;
  }

  @Pure
  public IResourceChangeRegistry getResourceChangeRegistry() {
    return this.resourceChangeRegistry;
  }

  @Pure
  public FileLocationsImpl getFileLocations() {
    return this.fileLocations;
  }

  @Pure
  public ReadAndWriteTracking getReadAndWriteTracking() {
    return this.readAndWriteTracking;
  }

  @Pure
  public IScopeProvider getScopeProvider() {
    return this.scopeProvider;
  }

  @Pure
  public IQualifiedNameConverter getQualifiedNameConverter() {
    return this.qualifiedNameConverter;
  }

  @Pure
  public IQualifiedNameProvider getQualifiedNameProvider() {
    return this.qualifiedNameProvider;
  }

  @Pure
  public ProblemSupportImpl getProblemSupport() {
    return this.problemSupport;
  }

  @Pure
  public TypeReferenceProvider getTypeReferenceProvider() {
    return this.typeReferenceProvider;
  }

  @Pure
  public AnnotationReferenceProvider getAnnotationReferenceProvider() {
    return this.annotationReferenceProvider;
  }

  @Pure
  public TypeLookupImpl getTypeLookup() {
    return this.typeLookup;
  }

  @Pure
  public TracabilityImpl getTracability() {
    return this.tracability;
  }

  @Pure
  public AssociatorImpl getAssociator() {
    return this.associator;
  }

  @Pure
  public LightweightTypeReferenceFactory getTypeRefFactory() {
    return this.typeRefFactory;
  }
}
