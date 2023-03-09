/**
 * Copyright (c) 2012, 2021, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.compiler;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.EcoreUtil2;
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
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmIntAnnotationValue;
import org.eclipse.xtext.common.types.JvmLongAnnotationValue;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmShortAnnotationValue;
import org.eclipse.xtext.common.types.JvmStringAnnotationValue;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeAnnotationValue;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.documentation.IEObjectDocumentationProviderExtension;
import org.eclipse.xtext.documentation.IFileHeaderProvider;
import org.eclipse.xtext.documentation.IJavaDocTypeReferenceProvider;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.trace.AbsoluteURI;
import org.eclipse.xtext.generator.trace.ITraceURIConverter;
import org.eclipse.xtext.generator.trace.LocationData;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.util.JavaVersion;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.compiler.output.ImportingStringConcatenation;
import org.eclipse.xtext.xbase.compiler.output.SharedAppendableState;
import org.eclipse.xtext.xbase.compiler.output.TreeAppendable;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;

/**
 * A generator implementation that processes the
 * derived {@link IJvmModelInferrer JVM model}
 * and produces the respective java code.
 */
@SuppressWarnings("all")
public class JvmModelGenerator implements IGenerator {
  @Inject
  @Extension
  protected ILogicalContainerProvider _iLogicalContainerProvider;

  @Inject
  @Extension
  protected TypeReferences _typeReferences;

  @Inject
  @Extension
  protected TreeAppendableUtil _treeAppendableUtil;

  @Inject
  @Extension
  protected JvmTypeExtensions _jvmTypeExtensions;

  @Inject
  @Extension
  protected LoopExtensions _loopExtensions;

  @Inject
  @Extension
  protected ErrorSafeExtensions _errorSafeExtensions;

  @Inject
  private CommonTypeComputationServices commonServices;

  @Inject
  private XbaseCompiler compiler;

  @Inject
  private ILocationInFileProvider locationProvider;

  @Inject
  private IEObjectDocumentationProvider documentationProvider;

  @Inject
  private IFileHeaderProvider fileHeaderProvider;

  @Inject
  private IJvmModelAssociations jvmModelAssociations;

  @Inject
  private JavaKeywords keywords;

  @Inject
  private IGeneratorConfigProvider generatorConfigProvider;

  @Inject
  private ITraceURIConverter converter;

  @Inject
  private IJavaDocTypeReferenceProvider javaDocTypeReferenceProvider;

  @Inject
  private IScopeProvider scopeProvider;

  @Inject
  private IQualifiedNameConverter qualifiedNameConverter;

  @Override
  public void doGenerate(final Resource input, final IFileSystemAccess fsa) {
    EList<EObject> _contents = input.getContents();
    for (final EObject obj : _contents) {
      this.internalDoGenerate(obj, fsa);
    }
  }

  protected void _internalDoGenerate(final EObject obj, final IFileSystemAccess fsa) {
  }

  protected void _internalDoGenerate(final JvmDeclaredType type, final IFileSystemAccess fsa) {
    boolean _isDisabled = DisableCodeGenerationAdapter.isDisabled(type);
    if (_isDisabled) {
      return;
    }
    String _qualifiedName = type.getQualifiedName();
    boolean _tripleNotEquals = (_qualifiedName != null);
    if (_tripleNotEquals) {
      String _replace = type.getQualifiedName().replace(".", "/");
      String _plus = (_replace + ".java");
      fsa.generateFile(_plus, this.generateType(type, this.generatorConfigProvider.get(type)));
    }
  }

  protected ImportManager createImportManager(final JvmDeclaredType type) {
    return new ImportManager(true, type);
  }

  public CharSequence generateType(final JvmDeclaredType type, final GeneratorConfig config) {
    final ImportManager importManager = this.createImportManager(type);
    final TreeAppendable bodyAppendable = this.createAppendable(type, importManager, config);
    bodyAppendable.openScope();
    this.assignThisAndSuper(bodyAppendable, type, config);
    this.generateBody(type, bodyAppendable, config);
    bodyAppendable.closeScope();
    final TreeAppendable importAppendable = this.createAppendable(type, importManager, config);
    this.generateFileHeader(type, importAppendable, config);
    String _packageName = type.getPackageName();
    boolean _tripleNotEquals = (_packageName != null);
    if (_tripleNotEquals) {
      importAppendable.append("package ").append(type.getPackageName()).append(";");
      importAppendable.newLine().newLine();
    }
    List<String> _imports = importManager.getImports();
    for (final String i : _imports) {
      importAppendable.append("import ").append(i).append(";").newLine();
    }
    boolean _isEmpty = importManager.getImports().isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      importAppendable.newLine();
    }
    importAppendable.append(bodyAppendable);
    return importAppendable;
  }

  protected ITreeAppendable _generateBody(final JvmGenericType it, final ITreeAppendable appendable, final GeneratorConfig config) {
    ITreeAppendable _xblockexpression = null;
    {
      this.generateJavaDoc(it, appendable, config);
      final ITreeAppendable childAppendable = appendable.trace(it);
      this.generateAnnotations(it.getAnnotations(), childAppendable, true, config);
      this.generateModifier(it, childAppendable, config);
      boolean _isInterface = it.isInterface();
      if (_isInterface) {
        childAppendable.append("interface ");
      } else {
        childAppendable.append("class ");
      }
      this._treeAppendableUtil.traceSignificant(childAppendable, it).append(this.makeJavaIdentifier(it.getSimpleName()));
      this.generateTypeParameterDeclaration(it, childAppendable, config);
      boolean _isEmpty = it.getTypeParameters().isEmpty();
      if (_isEmpty) {
        childAppendable.append(" ");
      }
      this.generateExtendsClause(it, childAppendable, config);
      this.generateMembersInBody(it, childAppendable, config);
      ITreeAppendable _xifexpression = null;
      if (((!it.isAnonymous()) && (!(it.eContainer() instanceof JvmType)))) {
        _xifexpression = appendable.newLine();
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  public ITreeAppendable generateMembersInBody(final JvmDeclaredType it, final ITreeAppendable appendable, final GeneratorConfig config) {
    ITreeAppendable _xblockexpression = null;
    {
      appendable.append("{").increaseIndentation();
      final Procedure1<LoopParams> _function = (LoopParams it_1) -> {
        it_1.setSeparator(this.memberSeparator());
      };
      final Procedure1<JvmMember> _function_1 = (JvmMember it_1) -> {
        final ITreeAppendable memberAppendable = this._treeAppendableUtil.traceWithComments(appendable, it_1);
        memberAppendable.openScope();
        this.generateMember(it_1, memberAppendable, config);
        memberAppendable.closeScope();
      };
      this._loopExtensions.<JvmMember>forEach(appendable, this.getMembersToBeCompiled(it), _function, _function_1);
      _xblockexpression = appendable.decreaseIndentation().newLine().append("}");
    }
    return _xblockexpression;
  }

  /**
   * @since 2.27
   */
  protected Function1<? super ITreeAppendable, ? extends ITreeAppendable> memberSeparator() {
    final Function1<ITreeAppendable, ITreeAppendable> _function = (ITreeAppendable it) -> {
      return it.blankLine();
    };
    return _function;
  }

  /**
   * @deprecated Additional annotations should be created in the JVM model.
   */
  @Deprecated
  public ITreeAppendable generateAnnotationsWithSyntheticSuppressWarnings(final JvmDeclaredType it, final ITreeAppendable appendable, final GeneratorConfig config) {
    ITreeAppendable _xblockexpression = null;
    {
      final Function1<JvmAnnotationReference, Boolean> _function = (JvmAnnotationReference it_1) -> {
        JvmAnnotationType _annotation = it_1.getAnnotation();
        String _identifier = null;
        if (_annotation!=null) {
          _identifier=_annotation.getIdentifier();
        }
        String _name = SuppressWarnings.class.getName();
        return Boolean.valueOf((!Objects.equal(_identifier, _name)));
      };
      final Function1<JvmAnnotationReference, Boolean> noSuppressWarningsFilter = _function;
      this.generateAnnotations(IterableExtensions.<JvmAnnotationReference>filter(it.getAnnotations(), noSuppressWarningsFilter), appendable, true, config);
      ITreeAppendable _xifexpression = null;
      EObject _eContainer = it.eContainer();
      boolean _tripleEquals = (_eContainer == null);
      if (_tripleEquals) {
        _xifexpression = appendable.append("@SuppressWarnings(\"all\")").newLine();
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  protected ITreeAppendable _generateBody(final JvmEnumerationType it, final ITreeAppendable appendable, final GeneratorConfig config) {
    ITreeAppendable _xblockexpression = null;
    {
      this.generateJavaDoc(it, appendable, config);
      final ITreeAppendable childAppendable = appendable.trace(it);
      this.generateAnnotations(it.getAnnotations(), childAppendable, true, config);
      this.generateModifier(it, childAppendable, config);
      childAppendable.append("enum ");
      this._treeAppendableUtil.traceSignificant(childAppendable, it).append(this.makeJavaIdentifier(it.getSimpleName()));
      childAppendable.append(" ");
      this.generateExtendsClause(it, childAppendable, config);
      childAppendable.append("{").increaseIndentation();
      final Procedure1<LoopParams> _function = (LoopParams it_1) -> {
        final Function1<ITreeAppendable, ITreeAppendable> _function_1 = (ITreeAppendable it_2) -> {
          return it_2.append(",").blankLine();
        };
        it_1.setSeparator(_function_1);
        it_1.setSuffix(";");
      };
      final Procedure1<JvmEnumerationLiteral> _function_1 = (JvmEnumerationLiteral it_1) -> {
        this.generateEnumLiteral(it_1, childAppendable.trace(it_1), config);
      };
      this._loopExtensions.<JvmEnumerationLiteral>forEach(childAppendable, it.getLiterals(), _function, _function_1);
      final Function1<JvmMember, Boolean> _function_2 = (JvmMember it_1) -> {
        return Boolean.valueOf((!(it_1 instanceof JvmEnumerationLiteral)));
      };
      final Procedure1<LoopParams> _function_3 = (LoopParams it_1) -> {
        it_1.setSeparator(this.memberSeparator());
      };
      final Procedure1<JvmMember> _function_4 = (JvmMember it_1) -> {
        this.generateMember(it_1, childAppendable.trace(it_1), config);
      };
      this._loopExtensions.<JvmMember>forEach(childAppendable, IterableExtensions.<JvmMember>filter(this.getMembersToBeCompiled(it), _function_2), _function_3, _function_4);
      childAppendable.decreaseIndentation().newLine().append("}");
      ITreeAppendable _xifexpression = null;
      EObject _eContainer = it.eContainer();
      boolean _not = (!(_eContainer instanceof JvmType));
      if (_not) {
        _xifexpression = appendable.newLine();
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  public void generateEnumLiteral(final JvmEnumerationLiteral it, final ITreeAppendable appendable, final GeneratorConfig config) {
    appendable.newLine();
    this.generateJavaDoc(it, appendable, config);
    this.generateAnnotations(it.getAnnotations(), appendable, true, config);
    appendable.append(this.makeJavaIdentifier(it.getSimpleName()));
  }

  protected ITreeAppendable _generateBody(final JvmAnnotationType it, final ITreeAppendable appendable, final GeneratorConfig config) {
    ITreeAppendable _xblockexpression = null;
    {
      this.generateJavaDoc(it, appendable, config);
      final ITreeAppendable childAppendable = appendable.trace(it);
      this.generateAnnotations(it.getAnnotations(), childAppendable, true, config);
      this.generateModifier(it, childAppendable, config);
      childAppendable.append("@interface ");
      this._treeAppendableUtil.traceSignificant(childAppendable, it).append(this.makeJavaIdentifier(it.getSimpleName()));
      childAppendable.append(" {");
      Iterable<JvmDeclaredType> _filter = Iterables.<JvmDeclaredType>filter(this.getMembersToBeCompiled(it), JvmDeclaredType.class);
      for (final JvmDeclaredType innerType : _filter) {
        {
          final ITreeAppendable innerTypeAppendable = childAppendable.trace(innerType);
          innerTypeAppendable.increaseIndentation();
          this.generateMember(innerType, innerTypeAppendable, config);
          innerTypeAppendable.decreaseIndentation();
        }
      }
      Iterable<JvmOperation> _filter_1 = Iterables.<JvmOperation>filter(this.getMembersToBeCompiled(it), JvmOperation.class);
      for (final JvmOperation operation : _filter_1) {
        this.generateAnnotationMethod(operation, childAppendable, config);
      }
      childAppendable.newLine().append("}");
      ITreeAppendable _xifexpression = null;
      EObject _eContainer = it.eContainer();
      boolean _not = (!(_eContainer instanceof JvmType));
      if (_not) {
        _xifexpression = appendable.newLine();
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  public void generateAnnotationMethod(final JvmOperation it, final ITreeAppendable appendable, final GeneratorConfig config) {
    appendable.increaseIndentation().newLine();
    appendable.openScope();
    this.generateJavaDoc(it, appendable, config);
    final ITreeAppendable tracedAppendable = appendable.trace(it);
    this.generateAnnotations(it.getAnnotations(), tracedAppendable, true, config);
    this.generateModifier(it, tracedAppendable, config);
    this._errorSafeExtensions.serializeSafely(it.getReturnType(), "Object", tracedAppendable);
    tracedAppendable.append(" ");
    this._treeAppendableUtil.traceSignificant(tracedAppendable, it).append(this.makeJavaIdentifier(it.getSimpleName()));
    tracedAppendable.append("()");
    this.generateDefaultExpression(it, tracedAppendable, config);
    tracedAppendable.append(";");
    appendable.decreaseIndentation();
    appendable.closeScope();
  }

  public void generateDefaultExpression(final JvmOperation it, final ITreeAppendable appendable, final GeneratorConfig config) {
    Procedure1<? super ITreeAppendable> _compilationStrategy = this._jvmTypeExtensions.getCompilationStrategy(it);
    boolean _tripleNotEquals = (_compilationStrategy != null);
    if (_tripleNotEquals) {
      appendable.append(" default ");
      appendable.increaseIndentation();
      this._jvmTypeExtensions.getCompilationStrategy(it).apply(appendable);
      appendable.decreaseIndentation();
    } else {
      StringConcatenationClient _compilationTemplate = this._jvmTypeExtensions.getCompilationTemplate(it);
      boolean _tripleNotEquals_1 = (_compilationTemplate != null);
      if (_tripleNotEquals_1) {
        appendable.append(" default ").increaseIndentation();
        this.appendCompilationTemplate(appendable, it);
        appendable.decreaseIndentation();
      } else {
        boolean _isGenerateExpressions = config.isGenerateExpressions();
        if (_isGenerateExpressions) {
          final XExpression body = this._iLogicalContainerProvider.getAssociatedExpression(it);
          if ((body != null)) {
            boolean _hasErrors = this._errorSafeExtensions.hasErrors(body);
            if (_hasErrors) {
              appendable.append("/* skipped default expression with errors */");
            } else {
              appendable.append(" default ");
              this.compiler.compileAsJavaExpression(body, appendable, it.getReturnType());
            }
          } else {
            JvmAnnotationValue _defaultValue = it.getDefaultValue();
            boolean _tripleNotEquals_2 = (_defaultValue != null);
            if (_tripleNotEquals_2) {
              boolean _hasErrors_1 = this._errorSafeExtensions.hasErrors(it.getDefaultValue());
              if (_hasErrors_1) {
                appendable.append("/* skipped default expression with errors */");
              } else {
                appendable.append(" default ");
                this.toJavaLiteral(it.getDefaultValue(), appendable, config);
              }
            }
          }
        }
      }
    }
  }

  /**
   * @since 2.16
   */
  protected void appendCompilationTemplate(final ITreeAppendable appendable, final JvmIdentifiableElement it) {
    boolean _matched = false;
    if (appendable instanceof TreeAppendable) {
      _matched=true;
      SharedAppendableState _state = ((TreeAppendable)appendable).getState();
      StandardTypeReferenceOwner _standardTypeReferenceOwner = new StandardTypeReferenceOwner(this.commonServices, it);
      final ImportingStringConcatenation target = this.createImportingStringConcatenation(_state, _standardTypeReferenceOwner);
      target.append(this._jvmTypeExtensions.getCompilationTemplate(it));
      ((TreeAppendable)appendable).append(target);
    }
    if (!_matched) {
      String _name = appendable.getClass().getName();
      String _plus = ("unexpected appendable: " + _name);
      throw new IllegalStateException(_plus);
    }
  }

  protected ImportingStringConcatenation createImportingStringConcatenation(final SharedAppendableState state, final ITypeReferenceOwner owner) {
    return new ImportingStringConcatenation(state, owner);
  }

  protected ITreeAppendable _generateModifier(final JvmGenericType it, final ITreeAppendable appendable, final GeneratorConfig config) {
    ITreeAppendable _xblockexpression = null;
    {
      this.generateVisibilityModifier(it, appendable);
      boolean _isInterface = it.isInterface();
      boolean _not = (!_isInterface);
      if (_not) {
        if ((it.isStatic() && (!this.isDeclaredWithinInterface(it)))) {
          appendable.append("static ");
        }
        boolean _isAbstract = it.isAbstract();
        if (_isAbstract) {
          appendable.append("abstract ");
        }
      }
      boolean _isFinal = it.isFinal();
      if (_isFinal) {
        appendable.append("final ");
      }
      ITreeAppendable _xifexpression = null;
      boolean _isStrictFloatingPoint = it.isStrictFloatingPoint();
      if (_isStrictFloatingPoint) {
        _xifexpression = appendable.append("strictfp ");
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  private boolean isDeclaredWithinInterface(final JvmMember it) {
    return ((it.getDeclaringType() instanceof JvmGenericType) && ((JvmGenericType) it.getDeclaringType()).isInterface());
  }

  protected ITreeAppendable _generateModifier(final JvmDeclaredType it, final ITreeAppendable appendable, final GeneratorConfig config) {
    return this.generateVisibilityModifier(it, appendable);
  }

  protected ITreeAppendable _generateModifier(final JvmField it, final ITreeAppendable appendable, final GeneratorConfig config) {
    ITreeAppendable _xblockexpression = null;
    {
      this.generateVisibilityModifier(it, appendable);
      boolean _isStatic = it.isStatic();
      if (_isStatic) {
        appendable.append("static ");
      }
      boolean _isFinal = it.isFinal();
      if (_isFinal) {
        appendable.append("final ");
      }
      boolean _isTransient = it.isTransient();
      if (_isTransient) {
        appendable.append("transient ");
      }
      ITreeAppendable _xifexpression = null;
      boolean _isVolatile = it.isVolatile();
      if (_isVolatile) {
        _xifexpression = appendable.append("volatile ");
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  protected ITreeAppendable _generateModifier(final JvmOperation it, final ITreeAppendable appendable, final GeneratorConfig config) {
    ITreeAppendable _xblockexpression = null;
    {
      this.generateVisibilityModifier(it, appendable);
      if ((it.isAbstract() && (!this.isDeclaredWithinInterface(it)))) {
        appendable.append("abstract ");
      }
      boolean _isStatic = it.isStatic();
      if (_isStatic) {
        appendable.append("static ");
      }
      if (((((!it.isAbstract()) && (!it.isStatic())) && config.getJavaSourceVersion().isAtLeast(JavaVersion.JAVA8)) && this.isDeclaredWithinInterface(it))) {
        appendable.append("default ");
      }
      boolean _isFinal = it.isFinal();
      if (_isFinal) {
        appendable.append("final ");
      }
      boolean _isSynchronized = it.isSynchronized();
      if (_isSynchronized) {
        appendable.append("synchronized ");
      }
      boolean _isStrictFloatingPoint = it.isStrictFloatingPoint();
      if (_isStrictFloatingPoint) {
        appendable.append("strictfp ");
      }
      ITreeAppendable _xifexpression = null;
      boolean _isNative = it.isNative();
      if (_isNative) {
        _xifexpression = appendable.append("native ");
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  public ITreeAppendable generateVisibilityModifier(final JvmMember it, final ITreeAppendable result) {
    return result.append(this.javaName(it.getVisibility()));
  }

  protected ITreeAppendable _generateModifier(final JvmConstructor it, final ITreeAppendable appendable, final GeneratorConfig config) {
    return this.generateVisibilityModifier(it, appendable);
  }

  /**
   * Returns the visibility modifier and a space as suffix if not empty
   */
  public String javaName(final JvmVisibility visibility) {
    if ((visibility != null)) {
      String _switchResult = null;
      if (visibility != null) {
        switch (visibility) {
          case PRIVATE:
            _switchResult = "private ";
            break;
          case PUBLIC:
            _switchResult = "public ";
            break;
          case PROTECTED:
            _switchResult = "protected ";
            break;
          case DEFAULT:
            _switchResult = "";
            break;
          default:
            break;
        }
      }
      return _switchResult;
    } else {
      return "";
    }
  }

  public void generateExtendsClause(final JvmDeclaredType it, final ITreeAppendable appendable, final GeneratorConfig config) {
    String _switchResult = null;
    boolean _matched = false;
    if (it instanceof JvmAnnotationType) {
      _matched=true;
      _switchResult = "java.lang.Annotation";
    }
    if (!_matched) {
      if (it instanceof JvmEnumerationType) {
        _matched=true;
        String _identifier = ((JvmEnumerationType)it).getIdentifier();
        String _plus = ("java.lang.Enum<" + _identifier);
        _switchResult = (_plus + ">");
      }
    }
    if (!_matched) {
      _switchResult = "java.lang.Object";
    }
    final String implicitSuperType = _switchResult;
    if (((it instanceof JvmAnnotationType) || ((it instanceof JvmGenericType) && ((JvmGenericType) it).isInterface()))) {
      final Function1<JvmTypeReference, Boolean> _function = (JvmTypeReference typeRef) -> {
        String _identifier = typeRef.getIdentifier();
        return Boolean.valueOf((!Objects.equal(_identifier, implicitSuperType)));
      };
      final Iterable<JvmTypeReference> withoutObject = IterableExtensions.<JvmTypeReference>filter(it.getSuperTypes(), _function);
      final Procedure1<LoopParams> _function_1 = (LoopParams it_1) -> {
        it_1.setPrefix("extends ");
        it_1.setSeparator(", ");
        it_1.setSuffix(" ");
      };
      final Procedure2<JvmTypeReference, ITreeAppendable> _function_2 = (JvmTypeReference it_1, ITreeAppendable app) -> {
        this._errorSafeExtensions.serializeSafely(it_1, app);
      };
      this._errorSafeExtensions.<JvmTypeReference>forEachSafely(appendable, withoutObject, _function_1, _function_2);
    } else {
      final Function1<JvmTypeReference, Boolean> _function_3 = (JvmTypeReference typeRef) -> {
        String _identifier = typeRef.getIdentifier();
        return Boolean.valueOf((!Objects.equal(_identifier, implicitSuperType)));
      };
      final Iterable<JvmTypeReference> withoutObject_1 = IterableExtensions.<JvmTypeReference>filter(it.getSuperTypes(), _function_3);
      final Function1<JvmTypeReference, Boolean> _function_4 = (JvmTypeReference typeRef) -> {
        return Boolean.valueOf(((typeRef.getType() instanceof JvmGenericType) && (!((JvmGenericType) typeRef.getType()).isInterface())));
      };
      final JvmTypeReference superClazz = IterableExtensions.<JvmTypeReference>head(IterableExtensions.<JvmTypeReference>filter(withoutObject_1, _function_4));
      final Function1<JvmTypeReference, Boolean> _function_5 = (JvmTypeReference typeRef) -> {
        return Boolean.valueOf((!Objects.equal(typeRef, superClazz)));
      };
      final Iterable<JvmTypeReference> superInterfaces = IterableExtensions.<JvmTypeReference>filter(withoutObject_1, _function_5);
      if ((superClazz != null)) {
        final boolean hasErrors = this._errorSafeExtensions.hasErrors(superClazz);
        if (hasErrors) {
          appendable.append("/* ");
        }
        try {
          appendable.append("extends ");
          this._errorSafeExtensions.serializeSafely(superClazz, appendable);
          appendable.append(" ");
        } catch (final Throwable _t) {
          if (_t instanceof Exception) {
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
        if (hasErrors) {
          appendable.append(" */");
        }
      }
      final Procedure1<LoopParams> _function_6 = (LoopParams it_1) -> {
        it_1.setPrefix("implements ");
        it_1.setSeparator(", ");
        it_1.setSuffix(" ");
      };
      final Procedure2<JvmTypeReference, ITreeAppendable> _function_7 = (JvmTypeReference it_1, ITreeAppendable app) -> {
        this._errorSafeExtensions.serializeSafely(it_1, app);
      };
      this._errorSafeExtensions.<JvmTypeReference>forEachSafely(appendable, superInterfaces, _function_6, _function_7);
    }
  }

  protected ITreeAppendable _generateMember(final JvmMember it, final ITreeAppendable appendable, final GeneratorConfig config) {
    Class<? extends JvmMember> _class = null;
    if (it!=null) {
      _class=it.getClass();
    }
    String _name = null;
    if (_class!=null) {
      _name=_class.getName();
    }
    String _plus = ("generateMember not implemented for elements of type " + _name);
    throw new UnsupportedOperationException(_plus);
  }

  protected ITreeAppendable _generateMember(final JvmDeclaredType it, final ITreeAppendable appendable, final GeneratorConfig config) {
    ITreeAppendable _xblockexpression = null;
    {
      appendable.newLine();
      appendable.openScope();
      this.assignThisAndSuper(appendable, it, config);
      ITreeAppendable _xtrycatchfinallyexpression = null;
      try {
        _xtrycatchfinallyexpression = this.generateBody(it, appendable, config);
      } finally {
        appendable.closeScope();
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return _xblockexpression;
  }

  protected ITreeAppendable _generateMember(final JvmField it, final ITreeAppendable appendable, final GeneratorConfig config) {
    ITreeAppendable _xblockexpression = null;
    {
      appendable.newLine();
      this.generateJavaDoc(it, appendable, config);
      final ITreeAppendable tracedAppendable = appendable.trace(it);
      this.generateAnnotations(it.getAnnotations(), tracedAppendable, true, config);
      this.generateModifier(it, tracedAppendable, config);
      this._errorSafeExtensions.serializeSafely(it.getType(), "Object", tracedAppendable);
      tracedAppendable.append(" ");
      final String name = tracedAppendable.declareVariable(it, this.makeJavaIdentifier(it.getSimpleName()));
      this._treeAppendableUtil.traceSignificant(tracedAppendable, it).append(name);
      this.generateInitialization(it, tracedAppendable, config);
      _xblockexpression = tracedAppendable.append(";");
    }
    return _xblockexpression;
  }

  protected ITreeAppendable _generateMember(final JvmOperation it, final ITreeAppendable appendable, final GeneratorConfig config) {
    ITreeAppendable _xblockexpression = null;
    {
      appendable.newLine();
      appendable.openScope();
      this.generateJavaDoc(it, appendable, config);
      final ITreeAppendable tracedAppendable = appendable.trace(it);
      this.generateAnnotations(it.getAnnotations(), tracedAppendable, true, config);
      this.generateModifier(it, tracedAppendable, config);
      this.generateTypeParameterDeclaration(it, tracedAppendable, config);
      JvmTypeReference _returnType = it.getReturnType();
      boolean _tripleEquals = (_returnType == null);
      if (_tripleEquals) {
        tracedAppendable.append("void");
      } else {
        this._errorSafeExtensions.serializeSafely(it.getReturnType(), "Object", tracedAppendable);
      }
      tracedAppendable.append(" ");
      this._treeAppendableUtil.traceSignificant(tracedAppendable, it).append(this.makeJavaIdentifier(it.getSimpleName()));
      tracedAppendable.append("(");
      this.generateParameters(it, tracedAppendable, config);
      tracedAppendable.append(")");
      this.generateThrowsClause(it, tracedAppendable, config);
      if ((it.isAbstract() || (!this.hasBody(it)))) {
        tracedAppendable.append(";");
      } else {
        tracedAppendable.append(" ");
        this.generateExecutableBody(it, tracedAppendable, config);
      }
      appendable.closeScope();
      _xblockexpression = appendable;
    }
    return _xblockexpression;
  }

  protected ITreeAppendable _generateMember(final JvmConstructor it, final ITreeAppendable appendable, final GeneratorConfig config) {
    ITreeAppendable _xblockexpression = null;
    {
      appendable.newLine();
      appendable.openScope();
      this.generateJavaDoc(it, appendable, config);
      final ITreeAppendable tracedAppendable = appendable.trace(it);
      this.generateAnnotations(it.getAnnotations(), tracedAppendable, true, config);
      this.generateModifier(it, tracedAppendable, config);
      this.generateTypeParameterDeclaration(it, tracedAppendable, config);
      this._treeAppendableUtil.traceSignificant(tracedAppendable, it).append(this.makeJavaIdentifier(it.getSimpleName()));
      tracedAppendable.append("(");
      this.generateParameters(it, tracedAppendable, config);
      tracedAppendable.append(")");
      this.generateThrowsClause(it, tracedAppendable, config);
      tracedAppendable.append(" ");
      this.generateExecutableBody(it, tracedAppendable, config);
      appendable.closeScope();
      _xblockexpression = appendable;
    }
    return _xblockexpression;
  }

  public void generateInitialization(final JvmField it, final ITreeAppendable appendable, final GeneratorConfig config) {
    Procedure1<? super ITreeAppendable> _compilationStrategy = this._jvmTypeExtensions.getCompilationStrategy(it);
    boolean _tripleNotEquals = (_compilationStrategy != null);
    if (_tripleNotEquals) {
      final Iterable<Issue> errors = this.getDirectErrorsOrLogicallyContainedErrors(it);
      boolean _isEmpty = IterableExtensions.isEmpty(errors);
      if (_isEmpty) {
        appendable.append(" = ");
        appendable.increaseIndentation();
        this._jvmTypeExtensions.getCompilationStrategy(it).apply(appendable);
        appendable.decreaseIndentation();
      } else {
        appendable.append(" /* Skipped initializer because of errors */");
      }
    } else {
      StringConcatenationClient _compilationTemplate = this._jvmTypeExtensions.getCompilationTemplate(it);
      boolean _tripleNotEquals_1 = (_compilationTemplate != null);
      if (_tripleNotEquals_1) {
        final Iterable<Issue> errors_1 = this.getDirectErrorsOrLogicallyContainedErrors(it);
        boolean _isEmpty_1 = IterableExtensions.isEmpty(errors_1);
        if (_isEmpty_1) {
          appendable.append(" = ").increaseIndentation();
          this.appendCompilationTemplate(appendable, it);
          appendable.decreaseIndentation();
        } else {
          appendable.append(" /* Skipped initializer because of errors */");
        }
      } else {
        final XExpression expression = this._iLogicalContainerProvider.getAssociatedExpression(it);
        if (((expression != null) && config.isGenerateExpressions())) {
          boolean _hasErrors = this._errorSafeExtensions.hasErrors(expression);
          if (_hasErrors) {
            appendable.append(" /* Skipped initializer because of errors */");
          } else {
            appendable.append(" = ");
            this.compiler.compileAsJavaExpression(expression, appendable, it.getType());
          }
        }
      }
    }
  }

  public void generateTypeParameterDeclaration(final JvmTypeParameterDeclarator it, final ITreeAppendable appendable, final GeneratorConfig config) {
    final Procedure1<LoopParams> _function = (LoopParams it_1) -> {
      it_1.setPrefix("<");
      it_1.setSeparator(", ");
      it_1.setSuffix("> ");
    };
    final Procedure1<JvmTypeParameter> _function_1 = (JvmTypeParameter it_1) -> {
      this.generateTypeParameterDeclaration(it_1, appendable, config);
    };
    this._loopExtensions.<JvmTypeParameter>forEach(appendable, it.getTypeParameters(), _function, _function_1);
  }

  public void generateTypeParameterDeclaration(final JvmTypeParameter it, final ITreeAppendable appendable, final GeneratorConfig config) {
    final ITreeAppendable tracedAppendable = appendable.trace(it);
    this._treeAppendableUtil.traceSignificant(tracedAppendable, it).append(it.getName());
    this.generateTypeParameterConstraints(it, tracedAppendable, config);
  }

  public void generateTypeParameterConstraints(final JvmTypeParameter it, final ITreeAppendable appendable, final GeneratorConfig config) {
    final Iterable<JvmUpperBound> upperBounds = Iterables.<JvmUpperBound>filter(it.getConstraints(), JvmUpperBound.class);
    final Procedure1<LoopParams> _function = (LoopParams it_1) -> {
      it_1.setPrefix(" extends ");
      it_1.setSeparator(" & ");
    };
    final Procedure2<JvmUpperBound, ITreeAppendable> _function_1 = (JvmUpperBound it_1, ITreeAppendable app) -> {
      this._errorSafeExtensions.serializeSafely(it_1.getTypeReference(), app);
    };
    this._errorSafeExtensions.<JvmUpperBound>forEachSafely(appendable, upperBounds, _function, _function_1);
  }

  public void generateThrowsClause(final JvmExecutable it, final ITreeAppendable appendable, final GeneratorConfig config) {
    final LinkedHashMap<JvmType, JvmTypeReference> toBeGenerated = CollectionLiterals.<JvmType, JvmTypeReference>newLinkedHashMap();
    final Consumer<JvmTypeReference> _function = (JvmTypeReference it_1) -> {
      boolean _containsKey = toBeGenerated.containsKey(it_1.getType());
      boolean _not = (!_containsKey);
      if (_not) {
        toBeGenerated.put(it_1.getType(), it_1);
      }
    };
    it.getExceptions().forEach(_function);
    final Procedure1<LoopParams> _function_1 = (LoopParams it_1) -> {
      it_1.setPrefix(" throws ");
      it_1.setSeparator(", ");
    };
    final Procedure2<JvmTypeReference, ITreeAppendable> _function_2 = (JvmTypeReference it_1, ITreeAppendable app) -> {
      app.trace(it_1).append(it_1.getType());
    };
    this._errorSafeExtensions.<JvmTypeReference>forEachSafely(appendable, toBeGenerated.values(), _function_1, _function_2);
  }

  public void generateParameters(final JvmExecutable it, final ITreeAppendable appendable, final GeneratorConfig config) {
    boolean _isEmpty = it.getParameters().isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      int _size = it.getParameters().size();
      int _minus = (_size - 1);
      IntegerRange _upTo = new IntegerRange(0, _minus);
      for (final Integer i : _upTo) {
        {
          int _size_1 = it.getParameters().size();
          final boolean last = (((i).intValue() + 1) == _size_1);
          final JvmFormalParameter p = it.getParameters().get((i).intValue());
          this.generateParameter(p, appendable, (last && it.isVarArgs()), config);
          if ((!last)) {
            appendable.append(", ");
          }
        }
      }
    }
  }

  public void generateParameter(final JvmFormalParameter it, final ITreeAppendable appendable, final boolean vararg, final GeneratorConfig config) {
    final ITreeAppendable tracedAppendable = appendable.trace(it);
    this.generateAnnotations(it.getAnnotations(), tracedAppendable, false, config);
    tracedAppendable.append("final ");
    if (vararg) {
      JvmTypeReference _parameterType = it.getParameterType();
      boolean _not = (!(_parameterType instanceof JvmGenericArrayTypeReference));
      if (_not) {
        tracedAppendable.append("/* Internal Error: Parameter was vararg but not an array type. */");
      } else {
        JvmTypeReference _parameterType_1 = it.getParameterType();
        this._errorSafeExtensions.serializeSafely(((JvmGenericArrayTypeReference) _parameterType_1).getComponentType(), "Object", tracedAppendable);
      }
      tracedAppendable.append("...");
    } else {
      this._errorSafeExtensions.serializeSafely(it.getParameterType(), "Object", tracedAppendable);
    }
    tracedAppendable.append(" ");
    final String name = tracedAppendable.declareVariable(it, this.makeJavaIdentifier(it.getSimpleName()));
    this._treeAppendableUtil.traceSignificant(tracedAppendable, it).append(name);
  }

  public boolean hasBody(final JvmExecutable it) {
    return (((this._jvmTypeExtensions.getCompilationTemplate(it) != null) || (this._jvmTypeExtensions.getCompilationStrategy(it) != null)) || (this._iLogicalContainerProvider.getAssociatedExpression(it) != null));
  }

  /**
   * Returns the errors that are produced for elements that are directly contained
   * in this feature (e.g. unresolved type proxies) or that are associated with
   * the expression that may be logically contained in the given feature.
   */
  private Iterable<Issue> getDirectErrorsOrLogicallyContainedErrors(final JvmFeature feature) {
    Iterable<Issue> errors = this._errorSafeExtensions.getErrors(feature);
    boolean _isEmpty = IterableExtensions.isEmpty(errors);
    if (_isEmpty) {
      final XExpression expression = this._iLogicalContainerProvider.getAssociatedExpression(feature);
      if ((expression != null)) {
        errors = this._errorSafeExtensions.getErrors(expression);
      }
    }
    return errors;
  }

  public void generateExecutableBody(final JvmExecutable op, final ITreeAppendable appendable, final GeneratorConfig config) {
    Procedure1<? super ITreeAppendable> _compilationStrategy = this._jvmTypeExtensions.getCompilationStrategy(op);
    boolean _tripleNotEquals = (_compilationStrategy != null);
    if (_tripleNotEquals) {
      Iterable<Issue> errors = this.getDirectErrorsOrLogicallyContainedErrors(op);
      boolean _isEmpty = IterableExtensions.isEmpty(errors);
      if (_isEmpty) {
        appendable.increaseIndentation().append("{").newLine();
        this._jvmTypeExtensions.getCompilationStrategy(op).apply(appendable);
        appendable.decreaseIndentation().newLine().append("}");
      } else {
        this.generateBodyWithIssues(op, appendable, errors);
      }
    } else {
      StringConcatenationClient _compilationTemplate = this._jvmTypeExtensions.getCompilationTemplate(op);
      boolean _tripleNotEquals_1 = (_compilationTemplate != null);
      if (_tripleNotEquals_1) {
        final Iterable<Issue> errors_1 = this.getDirectErrorsOrLogicallyContainedErrors(op);
        boolean _isEmpty_1 = IterableExtensions.isEmpty(errors_1);
        if (_isEmpty_1) {
          appendable.increaseIndentation().append("{").newLine();
          this.appendCompilationTemplate(appendable, op);
          appendable.decreaseIndentation().newLine().append("}");
        } else {
          this.generateBodyWithIssues(op, appendable, errors_1);
        }
      } else {
        final XExpression expression = this._iLogicalContainerProvider.getAssociatedExpression(op);
        if (((expression != null) && config.isGenerateExpressions())) {
          final Iterable<Issue> errors_2 = this._errorSafeExtensions.getErrors(expression);
          boolean _isEmpty_2 = IterableExtensions.isEmpty(errors_2);
          if (_isEmpty_2) {
            JvmTypeReference _switchResult = null;
            boolean _matched = false;
            if (op instanceof JvmOperation) {
              _matched=true;
              _switchResult = ((JvmOperation)op).getReturnType();
            }
            if (!_matched) {
              if (op instanceof JvmConstructor) {
                _matched=true;
                _switchResult = this._typeReferences.getTypeForName(Void.TYPE, op);
              }
            }
            if (!_matched) {
              _switchResult = null;
            }
            final JvmTypeReference returnType = _switchResult;
            appendable.append("{").increaseIndentation();
            this.compile(op, expression, returnType, appendable, config);
            appendable.decreaseIndentation().newLine().append("}");
          } else {
            this.generateBodyWithIssues(op, appendable, errors_2);
          }
        } else {
          if ((op instanceof JvmOperation)) {
            appendable.increaseIndentation().append("{").newLine();
            appendable.append("throw new UnsupportedOperationException(\"");
            appendable.append(((JvmOperation)op).getSimpleName());
            appendable.append(" is not implemented\");");
            appendable.decreaseIndentation().newLine().append("}");
          } else {
            if ((op instanceof JvmConstructor)) {
              appendable.append("{").newLine().append("}");
            }
          }
        }
      }
    }
  }

  public ITreeAppendable compile(final JvmExecutable executable, final XExpression expression, final JvmTypeReference returnType, final ITreeAppendable appendable, final GeneratorConfig config) {
    return this.compiler.compile(expression, appendable, returnType, IterableExtensions.<JvmTypeReference>toSet(executable.getExceptions()));
  }

  public void assignThisAndSuper(final ITreeAppendable b, final JvmDeclaredType declaredType, final GeneratorConfig config) {
    this.reassignSuperType(b, declaredType, config);
    this.reassignThisType(b, declaredType);
  }

  private String reassignSuperType(final ITreeAppendable b, final JvmDeclaredType declaredType, final GeneratorConfig config) {
    String _xblockexpression = null;
    {
      JvmTypeReference _extendedClass = declaredType.getExtendedClass();
      JvmType _type = null;
      if (_extendedClass!=null) {
        _type=_extendedClass.getType();
      }
      final JvmType superType = _type;
      boolean _hasObject = b.hasObject("super");
      if (_hasObject) {
        final Object element = b.getObject("this");
        if ((element instanceof JvmDeclaredType)) {
          final Object superElement = b.getObject("super");
          final String superVariable = b.getName(superElement);
          boolean _equals = "super".equals(superVariable);
          if (_equals) {
            String _simpleName = ((JvmDeclaredType)element).getSimpleName();
            final String proposedName = (_simpleName + ".super");
            b.declareVariable(superElement, proposedName);
          }
        }
      }
      boolean _isAtLeast = config.getJavaSourceVersion().isAtLeast(JavaVersion.JAVA8);
      if (_isAtLeast) {
        Iterable<JvmTypeReference> _extendedInterfaces = declaredType.getExtendedInterfaces();
        for (final JvmTypeReference interfaceRef : _extendedInterfaces) {
          {
            final JvmType interfaze = interfaceRef.getType();
            String _simpleName_1 = interfaze.getSimpleName();
            final String simpleVarName = (_simpleName_1 + ".super");
            boolean _hasObject_1 = b.hasObject(simpleVarName);
            if (_hasObject_1) {
              final Object element_1 = b.getObject(simpleVarName);
              boolean _notEquals = (!Objects.equal(element_1, interfaceRef));
              if (_notEquals) {
                String _qualifiedName = interfaze.getQualifiedName();
                final String qualifiedVarName = (_qualifiedName + ".super");
                b.declareVariable(interfaze, qualifiedVarName);
              }
            } else {
              b.declareVariable(interfaze, simpleVarName);
            }
          }
        }
      }
      String _xifexpression = null;
      if ((superType != null)) {
        _xifexpression = b.declareVariable(superType, "super");
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  protected String reassignThisType(final ITreeAppendable b, final JvmDeclaredType declaredType) {
    String _xblockexpression = null;
    {
      boolean _hasObject = b.hasObject("this");
      if (_hasObject) {
        final Object element = b.getObject("this");
        if ((element instanceof JvmDeclaredType)) {
          boolean _isLocal = ((JvmDeclaredType)element).isLocal();
          if (_isLocal) {
            b.declareVariable(element, "");
          } else {
            String _simpleName = ((JvmDeclaredType)element).getSimpleName();
            final String proposedName = (_simpleName + ".this");
            b.declareVariable(element, proposedName);
          }
        }
      }
      String _xifexpression = null;
      if ((declaredType != null)) {
        _xifexpression = b.declareVariable(declaredType, "this");
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  /**
   * @since 2.16
   */
  public ITreeAppendable generateBodyWithIssues(final JvmExecutable op, final ITreeAppendable appendable, final Iterable<Issue> errors) {
    return this.generateBodyWithIssues(appendable, errors);
  }

  public ITreeAppendable generateBodyWithIssues(final ITreeAppendable appendable, final Iterable<Issue> errors) {
    ITreeAppendable _xblockexpression = null;
    {
      appendable.append("{").increaseIndentation().newLine().append("throw new Error(\"Unresolved compilation problems:\"");
      appendable.increaseIndentation();
      final Consumer<Issue> _function = (Issue it) -> {
        appendable.newLine().append("+ \"\\n").append(this.doConvertToJavaString(it.getMessage())).append("\"");
      };
      errors.forEach(_function);
      _xblockexpression = appendable.append(");").decreaseIndentation().decreaseIndentation().newLine().append("}");
    }
    return _xblockexpression;
  }

  /**
   * Convert a given input string to a Java string. Non-ascii characters will
   * be replaced by a unicode escape sequence by default.
   */
  protected String doConvertToJavaString(final String input) {
    return Strings.convertToJavaString(input, true);
  }

  public void generateFileHeader(final JvmDeclaredType it, final ITreeAppendable appendable, final GeneratorConfig config) {
    final FileHeaderAdapter fileHeaderAdapter = IterableExtensions.<FileHeaderAdapter>head(Iterables.<FileHeaderAdapter>filter(it.eAdapters(), FileHeaderAdapter.class));
    if (((fileHeaderAdapter != null) && (!StringExtensions.isNullOrEmpty(fileHeaderAdapter.getHeaderText())))) {
      this.generateDocumentation(fileHeaderAdapter.getHeaderText(), this.fileHeaderProvider.getFileHeaderNodes(it.eResource()), appendable, config);
    }
  }

  public void generateJavaDoc(final EObject it, final ITreeAppendable appendable, final GeneratorConfig config) {
    final DocumentationAdapter adapter = IterableExtensions.<DocumentationAdapter>head(Iterables.<DocumentationAdapter>filter(it.eAdapters(), DocumentationAdapter.class));
    if (((adapter != null) && (!StringExtensions.isNullOrEmpty(adapter.getDocumentation())))) {
      final Set<EObject> sourceElements = this.getSourceElements(it);
      if (((sourceElements.size() == 1) && (this.documentationProvider instanceof IEObjectDocumentationProviderExtension))) {
        final List<INode> documentationNodes = ((IEObjectDocumentationProviderExtension) this.documentationProvider).getDocumentationNodes(IterableExtensions.<EObject>head(sourceElements));
        this.addJavaDocImports(it, appendable, documentationNodes);
        this.generateDocumentation(adapter.getDocumentation(), documentationNodes, appendable, config);
      } else {
        this.generateDocumentation(adapter.getDocumentation(), CollectionLiterals.<INode>emptyList(), appendable, config);
      }
    }
  }

  public void addJavaDocImports(final EObject it, final ITreeAppendable appendable, final List<INode> documentationNodes) {
    for (final INode node : documentationNodes) {
      List<ReplaceRegion> _computeTypeRefRegions = this.javaDocTypeReferenceProvider.computeTypeRefRegions(node);
      for (final ReplaceRegion region : _computeTypeRefRegions) {
        {
          final String text = region.getText();
          if (((text != null) && (text.length() > 0))) {
            final QualifiedName fqn = this.qualifiedNameConverter.toQualifiedName(text);
            final EObject context = NodeModelUtils.findActualSemanticObjectFor(node);
            if (((fqn.getSegmentCount() == 1) && (context != null))) {
              final IScope scope = this.scopeProvider.getScope(context, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
              final IEObjectDescription candidate = scope.getSingleElement(fqn);
              if ((candidate != null)) {
                EObject _xifexpression = null;
                boolean _eIsProxy = candidate.getEObjectOrProxy().eIsProxy();
                if (_eIsProxy) {
                  _xifexpression = EcoreUtil.resolve(candidate.getEObjectOrProxy(), context);
                } else {
                  _xifexpression = candidate.getEObjectOrProxy();
                }
                final JvmType jvmType = ((JvmType) _xifexpression);
                if (((jvmType instanceof JvmDeclaredType) && (!jvmType.eIsProxy()))) {
                  final JvmDeclaredType referencedType = ((JvmDeclaredType) jvmType);
                  final JvmDeclaredType contextDeclarator = EcoreUtil2.<JvmDeclaredType>getContainerOfType(it, JvmDeclaredType.class);
                  String _packageName = referencedType.getPackageName();
                  String _packageName_1 = contextDeclarator.getPackageName();
                  boolean _notEquals = (!Objects.equal(_packageName, _packageName_1));
                  if (_notEquals) {
                    final ImportManager importManager = this.getImportManager(appendable);
                    importManager.addImportFor(jvmType);
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  public ImportManager getImportManager(final ITreeAppendable appendable) {
    try {
      ImportManager _xblockexpression = null;
      {
        final Field stateField = appendable.getClass().getDeclaredField("state");
        stateField.setAccessible(true);
        final Object stateValue = stateField.get(appendable);
        final Field importManagerField = stateValue.getClass().getDeclaredField("importManager");
        importManagerField.setAccessible(true);
        Object _get = importManagerField.get(stateValue);
        _xblockexpression = ((ImportManager) _get);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  protected ITreeAppendable generateDocumentation(final String text, final List<INode> documentationNodes, final ITreeAppendable appendable, final GeneratorConfig config) {
    ITreeAppendable _xblockexpression = null;
    {
      final StringConcatenation doc = new StringConcatenation();
      doc.append("/**");
      doc.newLine();
      doc.append(" * ");
      doc.append(text, " * ");
      doc.newLine();
      doc.append(" */");
      ITreeAppendable _xifexpression = null;
      boolean _isEmpty = documentationNodes.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        ITreeAppendable _xblockexpression_1 = null;
        {
          ITextRegionWithLineInformation documentationTrace = ITextRegionWithLineInformation.EMPTY_REGION;
          for (final INode node : documentationNodes) {
            documentationTrace = documentationTrace.merge(node.getTextRegionWithLineInformation());
          }
          LocationData _locationData = new LocationData(documentationTrace, null);
          appendable.trace(_locationData).append(doc.toString());
          _xblockexpression_1 = appendable.newLine();
        }
        _xifexpression = _xblockexpression_1;
      } else {
        _xifexpression = appendable.append(doc.toString()).newLine();
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  public void generateAnnotations(final Iterable<JvmAnnotationReference> annotations, final ITreeAppendable appendable, final boolean withLineBreak, final GeneratorConfig config) {
    final Function1<ITreeAppendable, ITreeAppendable> _function = (ITreeAppendable it) -> {
      ITreeAppendable _xifexpression = null;
      if (withLineBreak) {
        _xifexpression = it.newLine();
      } else {
        _xifexpression = it.append(" ");
      }
      return _xifexpression;
    };
    final Function1<ITreeAppendable, ITreeAppendable> sep = _function;
    final Procedure1<LoopParams> _function_1 = (LoopParams it) -> {
      it.setSeparator(sep);
      it.setSuffix(sep);
    };
    final Procedure2<JvmAnnotationReference, ITreeAppendable> _function_2 = (JvmAnnotationReference it, ITreeAppendable app) -> {
      this.generateAnnotation(it, app, config);
    };
    this._errorSafeExtensions.<JvmAnnotationReference>forEachSafely(appendable, annotations, _function_1, _function_2);
  }

  public void generateAnnotation(final JvmAnnotationReference it, final ITreeAppendable appendable, final GeneratorConfig config) {
    appendable.append("@");
    appendable.append(it.getAnnotation());
    final Procedure1<LoopParams> _function = (LoopParams it_1) -> {
      it_1.setPrefix("(");
      it_1.setSeparator(", ");
      it_1.setSuffix(")");
    };
    final Procedure1<JvmAnnotationValue> _function_1 = (JvmAnnotationValue it_1) -> {
      this.toJava(it_1, appendable, config);
    };
    this._loopExtensions.<JvmAnnotationValue>forEach(appendable, it.getExplicitValues(), _function, _function_1);
  }

  public void toJava(final JvmAnnotationValue it, final ITreeAppendable appendable, final GeneratorConfig config) {
    JvmOperation _operation = it.getOperation();
    boolean _tripleNotEquals = (_operation != null);
    if (_tripleNotEquals) {
      String _simpleName = it.getOperation().getSimpleName();
      boolean _tripleEquals = (_simpleName == null);
      if (_tripleEquals) {
        return;
      }
      appendable.append(it.getOperation().getSimpleName());
      appendable.append(" = ");
    } else {
      EObject _eContainer = it.eContainer();
      int _size = ((JvmAnnotationReference) _eContainer).getExplicitValues().size();
      boolean _greaterThan = (_size > 1);
      if (_greaterThan) {
        appendable.append("value = ");
      }
    }
    this.toJavaLiteral(it, appendable, config);
  }

  protected void _toJavaLiteral(final JvmAnnotationAnnotationValue value, final ITreeAppendable appendable, final GeneratorConfig config) {
    final Procedure1<JvmAnnotationReference> _function = (JvmAnnotationReference it) -> {
      this.generateAnnotation(it, appendable, config);
    };
    this._loopExtensions.<JvmAnnotationReference>forEachWithShortcut(appendable, value.getValues(), _function);
  }

  protected void _toJavaLiteral(final JvmShortAnnotationValue it, final ITreeAppendable appendable, final GeneratorConfig config) {
    final Procedure1<Short> _function = (Short it_1) -> {
      appendable.append(it_1.toString());
    };
    this._loopExtensions.<Short>forEachWithShortcut(appendable, it.getValues(), _function);
  }

  protected void _toJavaLiteral(final JvmIntAnnotationValue it, final ITreeAppendable appendable, final GeneratorConfig config) {
    final Procedure1<Integer> _function = (Integer it_1) -> {
      appendable.append(it_1.toString());
    };
    this._loopExtensions.<Integer>forEachWithShortcut(appendable, it.getValues(), _function);
  }

  protected void _toJavaLiteral(final JvmLongAnnotationValue it, final ITreeAppendable appendable, final GeneratorConfig config) {
    final Procedure1<Long> _function = (Long it_1) -> {
      appendable.append(it_1.toString());
    };
    this._loopExtensions.<Long>forEachWithShortcut(appendable, it.getValues(), _function);
  }

  protected void _toJavaLiteral(final JvmByteAnnotationValue it, final ITreeAppendable appendable, final GeneratorConfig config) {
    final Procedure1<Byte> _function = (Byte it_1) -> {
      appendable.append(it_1.toString());
    };
    this._loopExtensions.<Byte>forEachWithShortcut(appendable, it.getValues(), _function);
  }

  protected void _toJavaLiteral(final JvmDoubleAnnotationValue it, final ITreeAppendable appendable, final GeneratorConfig config) {
    final Procedure1<Double> _function = (Double it_1) -> {
      String _switchResult = null;
      boolean _matched = false;
      boolean _isNaN = Double.isNaN((it_1).doubleValue());
      if (_isNaN) {
        _matched=true;
        _switchResult = "Double.NaN";
      }
      if (!_matched) {
        if (Objects.equal(it_1, Double.POSITIVE_INFINITY)) {
          _matched=true;
          _switchResult = "Double.POSITIVE_INFINITY";
        }
      }
      if (!_matched) {
        if (Objects.equal(it_1, Double.NEGATIVE_INFINITY)) {
          _matched=true;
          _switchResult = "Double.NEGATIVE_INFINITY";
        }
      }
      if (!_matched) {
        String _string = it_1.toString();
        _switchResult = (_string + "d");
      }
      appendable.append(_switchResult);
    };
    this._loopExtensions.<Double>forEachWithShortcut(appendable, it.getValues(), _function);
  }

  protected void _toJavaLiteral(final JvmFloatAnnotationValue it, final ITreeAppendable appendable, final GeneratorConfig config) {
    final Procedure1<Float> _function = (Float it_1) -> {
      String _switchResult = null;
      boolean _matched = false;
      boolean _isNaN = Float.isNaN((it_1).floatValue());
      if (_isNaN) {
        _matched=true;
        _switchResult = "Float.NaN";
      }
      if (!_matched) {
        if (Objects.equal(it_1, Float.POSITIVE_INFINITY)) {
          _matched=true;
          _switchResult = "Float.POSITIVE_INFINITY";
        }
      }
      if (!_matched) {
        if (Objects.equal(it_1, Float.NEGATIVE_INFINITY)) {
          _matched=true;
          _switchResult = "Float.NEGATIVE_INFINITY";
        }
      }
      if (!_matched) {
        String _string = it_1.toString();
        _switchResult = (_string + "f");
      }
      appendable.append(_switchResult);
    };
    this._loopExtensions.<Float>forEachWithShortcut(appendable, it.getValues(), _function);
  }

  protected void _toJavaLiteral(final JvmCharAnnotationValue it, final ITreeAppendable appendable, final GeneratorConfig config) {
    final Procedure1<Character> _function = (Character it_1) -> {
      String _doConvertToJavaString = this.doConvertToJavaString(it_1.toString());
      String _plus = ("\'" + _doConvertToJavaString);
      String _plus_1 = (_plus + "\'");
      appendable.append(_plus_1);
    };
    this._loopExtensions.<Character>forEachWithShortcut(appendable, it.getValues(), _function);
  }

  protected void _toJavaLiteral(final JvmStringAnnotationValue it, final ITreeAppendable appendable, final GeneratorConfig config) {
    final Procedure1<String> _function = (String it_1) -> {
      String _doConvertToJavaString = this.doConvertToJavaString(it_1.toString());
      String _plus = ("\"" + _doConvertToJavaString);
      String _plus_1 = (_plus + "\"");
      appendable.append(_plus_1);
    };
    this._loopExtensions.<String>forEachWithShortcut(appendable, it.getValues(), _function);
  }

  protected void _toJavaLiteral(final JvmTypeAnnotationValue it, final ITreeAppendable appendable, final GeneratorConfig config) {
    final Procedure1<JvmTypeReference> _function = (JvmTypeReference it_1) -> {
      appendable.append(it_1.getType()).append(".class");
    };
    this._loopExtensions.<JvmTypeReference>forEachWithShortcut(appendable, it.getValues(), _function);
  }

  protected void _toJavaLiteral(final JvmEnumAnnotationValue it, final ITreeAppendable appendable, final GeneratorConfig config) {
    final Procedure1<JvmEnumerationLiteral> _function = (JvmEnumerationLiteral it_1) -> {
      appendable.append(it_1.getDeclaringType());
      appendable.append(".");
      appendable.append(this.makeJavaIdentifier(it_1.getSimpleName()));
    };
    this._loopExtensions.<JvmEnumerationLiteral>forEachWithShortcut(appendable, it.getValues(), _function);
  }

  protected void _toJavaLiteral(final JvmBooleanAnnotationValue it, final ITreeAppendable appendable, final GeneratorConfig config) {
    final Procedure1<Boolean> _function = (Boolean it_1) -> {
      appendable.append(it_1.toString());
    };
    this._loopExtensions.<Boolean>forEachWithShortcut(appendable, it.getValues(), _function);
  }

  protected void _toJavaLiteral(final JvmCustomAnnotationValue it, final ITreeAppendable appendable, final GeneratorConfig config) {
    boolean _isEmpty = it.getValues().isEmpty();
    if (_isEmpty) {
      appendable.append("{}");
    } else {
      final Procedure1<XExpression> _function = (XExpression it_1) -> {
        this.compiler.toJavaExpression(it_1, appendable);
      };
      this._loopExtensions.<XExpression>forEachWithShortcut(appendable, Iterables.<XExpression>filter(it.getValues(), XExpression.class), _function);
    }
  }

  public TreeAppendable createAppendable(final EObject context, final ImportManager importManager, final GeneratorConfig config) {
    abstract class __JvmModelGenerator_1 implements ITraceURIConverter {
      Map<URI, SourceRelativeURI> uriForTraceCache;
    }

    final __JvmModelGenerator_1 cachingConverter = new __JvmModelGenerator_1() {
      {
        uriForTraceCache = Maps.<URI, SourceRelativeURI>newHashMap();
      }
      @Override
      public SourceRelativeURI getURIForTrace(final IProjectConfig config, final AbsoluteURI uri) {
        boolean _containsKey = this.uriForTraceCache.containsKey(uri.getURI());
        boolean _not = (!_containsKey);
        if (_not) {
          final SourceRelativeURI result = JvmModelGenerator.this.converter.getURIForTrace(config, uri);
          this.uriForTraceCache.put(uri.getURI(), result);
        }
        return this.uriForTraceCache.get(uri.getURI());
      }

      @Override
      public SourceRelativeURI getURIForTrace(final Resource resource) {
        boolean _containsKey = this.uriForTraceCache.containsKey(resource.getURI());
        boolean _not = (!_containsKey);
        if (_not) {
          final SourceRelativeURI result = JvmModelGenerator.this.converter.getURIForTrace(resource);
          this.uriForTraceCache.put(resource.getURI(), result);
        }
        return this.uriForTraceCache.get(resource.getURI());
      }
    };
    final TreeAppendable appendable = new TreeAppendable(importManager, cachingConverter, this.locationProvider, this.jvmModelAssociations, context, "  ", "\n");
    SharedAppendableState _state = appendable.getState();
    _state.setGeneratorConfig(config);
    return appendable;
  }

  public JvmGenericType containerType(final EObject context) {
    JvmGenericType _xifexpression = null;
    if ((context == null)) {
      _xifexpression = null;
    } else {
      JvmGenericType _xifexpression_1 = null;
      if ((context instanceof JvmGenericType)) {
        _xifexpression_1 = ((JvmGenericType)context);
      } else {
        _xifexpression_1 = this.containerType(context.eContainer());
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }

  protected String makeJavaIdentifier(final String name) {
    String _xifexpression = null;
    if ((name == null)) {
      return "__unknown__";
    } else {
      String _xifexpression_1 = null;
      boolean _isJavaKeyword = this.keywords.isJavaKeyword(name);
      if (_isJavaKeyword) {
        _xifexpression_1 = (name + "_");
      } else {
        _xifexpression_1 = name;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }

  protected Iterable<JvmMember> _getMembersToBeCompiled(final JvmEnumerationType type) {
    Iterable<JvmMember> _xblockexpression = null;
    {
      String _identifier = type.getIdentifier();
      String _plus = (_identifier + ".");
      String _plus_1 = (_plus + "valueOf(java.lang.String)");
      String _identifier_1 = type.getIdentifier();
      String _plus_2 = (_identifier_1 + ".");
      String _plus_3 = (_plus_2 + "values()");
      final Set<String> syntheticEnumMethods = Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet(_plus_1, _plus_3));
      final Function1<JvmMember, Boolean> _function = (JvmMember it) -> {
        return Boolean.valueOf((!((it instanceof JvmOperation) && syntheticEnumMethods.contains(it.getIdentifier()))));
      };
      _xblockexpression = IterableExtensions.<JvmMember>filter(type.getMembers(), _function);
    }
    return _xblockexpression;
  }

  protected Iterable<JvmMember> _getMembersToBeCompiled(final JvmDeclaredType it) {
    final Function1<JvmMember, Boolean> _function = (JvmMember it_1) -> {
      return Boolean.valueOf((!((it_1 instanceof JvmConstructor) && this._jvmTypeExtensions.isSingleSyntheticDefaultConstructor(((JvmConstructor) it_1)))));
    };
    return IterableExtensions.<JvmMember>filter(it.getMembers(), _function);
  }

  protected Iterable<JvmMember> _getMembersToBeCompiled(final JvmGenericType it) {
    Iterable<JvmMember> _xifexpression = null;
    boolean _isAnonymous = it.isAnonymous();
    if (_isAnonymous) {
      final Function1<JvmMember, Boolean> _function = (JvmMember it_1) -> {
        return Boolean.valueOf((!(it_1 instanceof JvmConstructor)));
      };
      _xifexpression = IterableExtensions.<JvmMember>filter(it.getMembers(), _function);
    } else {
      _xifexpression = this._getMembersToBeCompiled(((JvmDeclaredType) it));
    }
    return _xifexpression;
  }

  protected Set<EObject> getSourceElements(final EObject jvmElement) {
    return this.jvmModelAssociations.getSourceElements(jvmElement);
  }

  public void internalDoGenerate(final EObject type, final IFileSystemAccess fsa) {
    if (type instanceof JvmDeclaredType) {
      _internalDoGenerate((JvmDeclaredType)type, fsa);
      return;
    } else if (type != null) {
      _internalDoGenerate(type, fsa);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(type, fsa).toString());
    }
  }

  public ITreeAppendable generateBody(final JvmDeclaredType it, final ITreeAppendable appendable, final GeneratorConfig config) {
    if (it instanceof JvmAnnotationType) {
      return _generateBody((JvmAnnotationType)it, appendable, config);
    } else if (it instanceof JvmEnumerationType) {
      return _generateBody((JvmEnumerationType)it, appendable, config);
    } else if (it instanceof JvmGenericType) {
      return _generateBody((JvmGenericType)it, appendable, config);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, appendable, config).toString());
    }
  }

  public ITreeAppendable generateModifier(final JvmMember it, final ITreeAppendable appendable, final GeneratorConfig config) {
    if (it instanceof JvmConstructor) {
      return _generateModifier((JvmConstructor)it, appendable, config);
    } else if (it instanceof JvmOperation) {
      return _generateModifier((JvmOperation)it, appendable, config);
    } else if (it instanceof JvmField) {
      return _generateModifier((JvmField)it, appendable, config);
    } else if (it instanceof JvmGenericType) {
      return _generateModifier((JvmGenericType)it, appendable, config);
    } else if (it instanceof JvmDeclaredType) {
      return _generateModifier((JvmDeclaredType)it, appendable, config);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, appendable, config).toString());
    }
  }

  public ITreeAppendable generateMember(final JvmMember it, final ITreeAppendable appendable, final GeneratorConfig config) {
    if (it instanceof JvmConstructor) {
      return _generateMember((JvmConstructor)it, appendable, config);
    } else if (it instanceof JvmOperation) {
      return _generateMember((JvmOperation)it, appendable, config);
    } else if (it instanceof JvmField) {
      return _generateMember((JvmField)it, appendable, config);
    } else if (it instanceof JvmDeclaredType) {
      return _generateMember((JvmDeclaredType)it, appendable, config);
    } else if (it != null) {
      return _generateMember(it, appendable, config);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, appendable, config).toString());
    }
  }

  public void toJavaLiteral(final JvmAnnotationValue value, final ITreeAppendable appendable, final GeneratorConfig config) {
    if (value instanceof JvmAnnotationAnnotationValue) {
      _toJavaLiteral((JvmAnnotationAnnotationValue)value, appendable, config);
      return;
    } else if (value instanceof JvmBooleanAnnotationValue) {
      _toJavaLiteral((JvmBooleanAnnotationValue)value, appendable, config);
      return;
    } else if (value instanceof JvmByteAnnotationValue) {
      _toJavaLiteral((JvmByteAnnotationValue)value, appendable, config);
      return;
    } else if (value instanceof JvmCharAnnotationValue) {
      _toJavaLiteral((JvmCharAnnotationValue)value, appendable, config);
      return;
    } else if (value instanceof JvmCustomAnnotationValue) {
      _toJavaLiteral((JvmCustomAnnotationValue)value, appendable, config);
      return;
    } else if (value instanceof JvmDoubleAnnotationValue) {
      _toJavaLiteral((JvmDoubleAnnotationValue)value, appendable, config);
      return;
    } else if (value instanceof JvmEnumAnnotationValue) {
      _toJavaLiteral((JvmEnumAnnotationValue)value, appendable, config);
      return;
    } else if (value instanceof JvmFloatAnnotationValue) {
      _toJavaLiteral((JvmFloatAnnotationValue)value, appendable, config);
      return;
    } else if (value instanceof JvmIntAnnotationValue) {
      _toJavaLiteral((JvmIntAnnotationValue)value, appendable, config);
      return;
    } else if (value instanceof JvmLongAnnotationValue) {
      _toJavaLiteral((JvmLongAnnotationValue)value, appendable, config);
      return;
    } else if (value instanceof JvmShortAnnotationValue) {
      _toJavaLiteral((JvmShortAnnotationValue)value, appendable, config);
      return;
    } else if (value instanceof JvmStringAnnotationValue) {
      _toJavaLiteral((JvmStringAnnotationValue)value, appendable, config);
      return;
    } else if (value instanceof JvmTypeAnnotationValue) {
      _toJavaLiteral((JvmTypeAnnotationValue)value, appendable, config);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(value, appendable, config).toString());
    }
  }

  public Iterable<JvmMember> getMembersToBeCompiled(final JvmDeclaredType type) {
    if (type instanceof JvmEnumerationType) {
      return _getMembersToBeCompiled((JvmEnumerationType)type);
    } else if (type instanceof JvmGenericType) {
      return _getMembersToBeCompiled((JvmGenericType)type);
    } else if (type != null) {
      return _getMembersToBeCompiled(type);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(type).toString());
    }
  }
}
