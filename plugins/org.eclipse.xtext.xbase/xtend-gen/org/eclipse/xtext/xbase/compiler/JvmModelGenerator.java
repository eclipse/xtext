/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.compiler;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.notify.Adapter;
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
import org.eclipse.xtext.common.types.JvmTypeConstraint;
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
import org.eclipse.xtext.xbase.compiler.DisableCodeGenerationAdapter;
import org.eclipse.xtext.xbase.compiler.DocumentationAdapter;
import org.eclipse.xtext.xbase.compiler.ErrorSafeExtensions;
import org.eclipse.xtext.xbase.compiler.FileHeaderAdapter;
import org.eclipse.xtext.xbase.compiler.GeneratorConfig;
import org.eclipse.xtext.xbase.compiler.IGeneratorConfigProvider;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.JavaKeywords;
import org.eclipse.xtext.xbase.compiler.LoopExtensions;
import org.eclipse.xtext.xbase.compiler.LoopParams;
import org.eclipse.xtext.xbase.compiler.TreeAppendableUtil;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;
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
    boolean _notEquals = (!Objects.equal(_qualifiedName, null));
    if (_notEquals) {
      String _qualifiedName_1 = type.getQualifiedName();
      String _replace = _qualifiedName_1.replace(".", "/");
      String _plus = (_replace + ".java");
      GeneratorConfig _get = this.generatorConfigProvider.get(type);
      CharSequence _generateType = this.generateType(type, _get);
      fsa.generateFile(_plus, _generateType);
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
    boolean _notEquals = (!Objects.equal(_packageName, null));
    if (_notEquals) {
      ITreeAppendable _append = importAppendable.append("package ");
      String _packageName_1 = type.getPackageName();
      ITreeAppendable _append_1 = _append.append(_packageName_1);
      _append_1.append(";");
      TreeAppendable _newLine = importAppendable.newLine();
      _newLine.newLine();
    }
    List<String> _imports = importManager.getImports();
    for (final String i : _imports) {
      ITreeAppendable _append_2 = importAppendable.append("import ");
      ITreeAppendable _append_3 = _append_2.append(i);
      ITreeAppendable _append_4 = _append_3.append(";");
      _append_4.newLine();
    }
    List<String> _imports_1 = importManager.getImports();
    boolean _isEmpty = _imports_1.isEmpty();
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
      EList<JvmAnnotationReference> _annotations = it.getAnnotations();
      this.generateAnnotations(_annotations, childAppendable, true, config);
      this.generateModifier(it, childAppendable, config);
      boolean _isInterface = it.isInterface();
      if (_isInterface) {
        childAppendable.append("interface ");
      } else {
        childAppendable.append("class ");
      }
      ITreeAppendable _traceSignificant = this._treeAppendableUtil.traceSignificant(childAppendable, it);
      String _simpleName = it.getSimpleName();
      String _makeJavaIdentifier = this.makeJavaIdentifier(_simpleName);
      _traceSignificant.append(_makeJavaIdentifier);
      this.generateTypeParameterDeclaration(it, childAppendable, config);
      EList<JvmTypeParameter> _typeParameters = it.getTypeParameters();
      boolean _isEmpty = _typeParameters.isEmpty();
      if (_isEmpty) {
        childAppendable.append(" ");
      }
      this.generateExtendsClause(it, childAppendable, config);
      this.generateMembersInBody(it, childAppendable, config);
      ITreeAppendable _xifexpression = null;
      boolean _and = false;
      boolean _isAnonymous = it.isAnonymous();
      boolean _not = (!_isAnonymous);
      if (!_not) {
        _and = false;
      } else {
        EObject _eContainer = it.eContainer();
        boolean _not_1 = (!(_eContainer instanceof JvmType));
        _and = _not_1;
      }
      if (_and) {
        _xifexpression = appendable.newLine();
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public ITreeAppendable generateMembersInBody(final JvmDeclaredType it, final ITreeAppendable appendable, final GeneratorConfig config) {
    ITreeAppendable _xblockexpression = null;
    {
      ITreeAppendable _append = appendable.append("{");
      _append.increaseIndentation();
      Iterable<JvmMember> _membersToBeCompiled = this.getMembersToBeCompiled(it);
      final Procedure1<LoopParams> _function = new Procedure1<LoopParams>() {
        @Override
        public void apply(final LoopParams it) {
          final Function1<ITreeAppendable, ITreeAppendable> _function = new Function1<ITreeAppendable, ITreeAppendable>() {
            @Override
            public ITreeAppendable apply(final ITreeAppendable it) {
              return it.newLine();
            }
          };
          it.setSeparator(_function);
        }
      };
      final Procedure1<JvmMember> _function_1 = new Procedure1<JvmMember>() {
        @Override
        public void apply(final JvmMember it) {
          final ITreeAppendable memberAppendable = JvmModelGenerator.this._treeAppendableUtil.traceWithComments(appendable, it);
          memberAppendable.openScope();
          JvmModelGenerator.this.generateMember(it, memberAppendable, config);
          memberAppendable.closeScope();
        }
      };
      this._loopExtensions.<JvmMember>forEach(appendable, _membersToBeCompiled, _function, _function_1);
      ITreeAppendable _decreaseIndentation = appendable.decreaseIndentation();
      ITreeAppendable _newLine = _decreaseIndentation.newLine();
      _xblockexpression = _newLine.append("}");
    }
    return _xblockexpression;
  }
  
  /**
   * @deprecated Additional annotations should be created in the JVM model.
   */
  @Deprecated
  public ITreeAppendable generateAnnotationsWithSyntheticSuppressWarnings(final JvmDeclaredType it, final ITreeAppendable appendable, final GeneratorConfig config) {
    ITreeAppendable _xblockexpression = null;
    {
      final Function1<JvmAnnotationReference, Boolean> _function = new Function1<JvmAnnotationReference, Boolean>() {
        @Override
        public Boolean apply(final JvmAnnotationReference it) {
          JvmAnnotationType _annotation = it.getAnnotation();
          String _identifier = null;
          if (_annotation!=null) {
            _identifier=_annotation.getIdentifier();
          }
          String _name = SuppressWarnings.class.getName();
          return Boolean.valueOf((!Objects.equal(_identifier, _name)));
        }
      };
      final Function1<JvmAnnotationReference, Boolean> noSuppressWarningsFilter = _function;
      EList<JvmAnnotationReference> _annotations = it.getAnnotations();
      Iterable<JvmAnnotationReference> _filter = IterableExtensions.<JvmAnnotationReference>filter(_annotations, noSuppressWarningsFilter);
      this.generateAnnotations(_filter, appendable, true, config);
      ITreeAppendable _xifexpression = null;
      EObject _eContainer = it.eContainer();
      boolean _equals = Objects.equal(_eContainer, null);
      if (_equals) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("@SuppressWarnings(\"all\")");
        ITreeAppendable _append = appendable.append(_builder);
        _xifexpression = _append.newLine();
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
      EList<JvmAnnotationReference> _annotations = it.getAnnotations();
      this.generateAnnotations(_annotations, childAppendable, true, config);
      this.generateModifier(it, childAppendable, config);
      childAppendable.append("enum ");
      ITreeAppendable _traceSignificant = this._treeAppendableUtil.traceSignificant(childAppendable, it);
      String _simpleName = it.getSimpleName();
      String _makeJavaIdentifier = this.makeJavaIdentifier(_simpleName);
      _traceSignificant.append(_makeJavaIdentifier);
      childAppendable.append(" ");
      this.generateExtendsClause(it, childAppendable, config);
      ITreeAppendable _append = childAppendable.append("{");
      _append.increaseIndentation();
      EList<JvmEnumerationLiteral> _literals = it.getLiterals();
      final Procedure1<LoopParams> _function = new Procedure1<LoopParams>() {
        @Override
        public void apply(final LoopParams it) {
          final Function1<ITreeAppendable, ITreeAppendable> _function = new Function1<ITreeAppendable, ITreeAppendable>() {
            @Override
            public ITreeAppendable apply(final ITreeAppendable it) {
              ITreeAppendable _append = it.append(",");
              return _append.newLine();
            }
          };
          it.setSeparator(_function);
          it.setSuffix(";");
        }
      };
      final Procedure1<JvmEnumerationLiteral> _function_1 = new Procedure1<JvmEnumerationLiteral>() {
        @Override
        public void apply(final JvmEnumerationLiteral it) {
          ITreeAppendable _trace = childAppendable.trace(it);
          JvmModelGenerator.this.generateEnumLiteral(it, _trace, config);
        }
      };
      this._loopExtensions.<JvmEnumerationLiteral>forEach(childAppendable, _literals, _function, _function_1);
      Iterable<JvmMember> _membersToBeCompiled = this.getMembersToBeCompiled(it);
      final Function1<JvmMember, Boolean> _function_2 = new Function1<JvmMember, Boolean>() {
        @Override
        public Boolean apply(final JvmMember it) {
          return Boolean.valueOf((!(it instanceof JvmEnumerationLiteral)));
        }
      };
      Iterable<JvmMember> _filter = IterableExtensions.<JvmMember>filter(_membersToBeCompiled, _function_2);
      final Procedure1<LoopParams> _function_3 = new Procedure1<LoopParams>() {
        @Override
        public void apply(final LoopParams it) {
          final Function1<ITreeAppendable, ITreeAppendable> _function = new Function1<ITreeAppendable, ITreeAppendable>() {
            @Override
            public ITreeAppendable apply(final ITreeAppendable it) {
              return it.newLine();
            }
          };
          it.setSeparator(_function);
        }
      };
      final Procedure1<JvmMember> _function_4 = new Procedure1<JvmMember>() {
        @Override
        public void apply(final JvmMember it) {
          ITreeAppendable _trace = childAppendable.trace(it);
          JvmModelGenerator.this.generateMember(it, _trace, config);
        }
      };
      this._loopExtensions.<JvmMember>forEach(childAppendable, _filter, _function_3, _function_4);
      ITreeAppendable _decreaseIndentation = childAppendable.decreaseIndentation();
      ITreeAppendable _newLine = _decreaseIndentation.newLine();
      _newLine.append("}");
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
    EList<JvmAnnotationReference> _annotations = it.getAnnotations();
    this.generateAnnotations(_annotations, appendable, true, config);
    String _simpleName = it.getSimpleName();
    String _makeJavaIdentifier = this.makeJavaIdentifier(_simpleName);
    appendable.append(_makeJavaIdentifier);
  }
  
  protected ITreeAppendable _generateBody(final JvmAnnotationType it, final ITreeAppendable appendable, final GeneratorConfig config) {
    ITreeAppendable _xblockexpression = null;
    {
      this.generateJavaDoc(it, appendable, config);
      final ITreeAppendable childAppendable = appendable.trace(it);
      EList<JvmAnnotationReference> _annotations = it.getAnnotations();
      this.generateAnnotations(_annotations, childAppendable, true, config);
      this.generateModifier(it, childAppendable, config);
      childAppendable.append("@interface ");
      ITreeAppendable _traceSignificant = this._treeAppendableUtil.traceSignificant(childAppendable, it);
      String _simpleName = it.getSimpleName();
      String _makeJavaIdentifier = this.makeJavaIdentifier(_simpleName);
      _traceSignificant.append(_makeJavaIdentifier);
      childAppendable.append(" {");
      Iterable<JvmMember> _membersToBeCompiled = this.getMembersToBeCompiled(it);
      Iterable<JvmDeclaredType> _filter = Iterables.<JvmDeclaredType>filter(_membersToBeCompiled, JvmDeclaredType.class);
      for (final JvmDeclaredType innerType : _filter) {
        {
          final ITreeAppendable innerTypeAppendable = childAppendable.trace(innerType);
          innerTypeAppendable.increaseIndentation();
          this.generateMember(innerType, innerTypeAppendable, config);
          innerTypeAppendable.decreaseIndentation();
        }
      }
      Iterable<JvmMember> _membersToBeCompiled_1 = this.getMembersToBeCompiled(it);
      Iterable<JvmOperation> _filter_1 = Iterables.<JvmOperation>filter(_membersToBeCompiled_1, JvmOperation.class);
      for (final JvmOperation operation : _filter_1) {
        this.generateAnnotationMethod(operation, childAppendable, config);
      }
      ITreeAppendable _newLine = childAppendable.newLine();
      _newLine.append("}");
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
    ITreeAppendable _increaseIndentation = appendable.increaseIndentation();
    _increaseIndentation.newLine();
    appendable.openScope();
    this.generateJavaDoc(it, appendable, config);
    final ITreeAppendable tracedAppendable = appendable.trace(it);
    EList<JvmAnnotationReference> _annotations = it.getAnnotations();
    this.generateAnnotations(_annotations, tracedAppendable, true, config);
    this.generateModifier(it, tracedAppendable, config);
    JvmTypeReference _returnType = it.getReturnType();
    this._errorSafeExtensions.serializeSafely(_returnType, "Object", tracedAppendable);
    tracedAppendable.append(" ");
    ITreeAppendable _traceSignificant = this._treeAppendableUtil.traceSignificant(tracedAppendable, it);
    String _simpleName = it.getSimpleName();
    String _makeJavaIdentifier = this.makeJavaIdentifier(_simpleName);
    _traceSignificant.append(_makeJavaIdentifier);
    tracedAppendable.append("()");
    this.generateDefaultExpression(it, tracedAppendable, config);
    tracedAppendable.append(";");
    appendable.decreaseIndentation();
    appendable.closeScope();
  }
  
  public void generateDefaultExpression(final JvmOperation it, final ITreeAppendable appendable, final GeneratorConfig config) {
    Procedure1<? super ITreeAppendable> _compilationStrategy = this._jvmTypeExtensions.getCompilationStrategy(it);
    boolean _notEquals = (!Objects.equal(_compilationStrategy, null));
    if (_notEquals) {
      appendable.append(" default ");
      appendable.increaseIndentation();
      Procedure1<? super ITreeAppendable> _compilationStrategy_1 = this._jvmTypeExtensions.getCompilationStrategy(it);
      _compilationStrategy_1.apply(appendable);
      appendable.decreaseIndentation();
    } else {
      StringConcatenationClient _compilationTemplate = this._jvmTypeExtensions.getCompilationTemplate(it);
      boolean _notEquals_1 = (!Objects.equal(_compilationTemplate, null));
      if (_notEquals_1) {
        ITreeAppendable _append = appendable.append(" default ");
        _append.increaseIndentation();
        this.appendCompilationTemplate(appendable, it);
        appendable.decreaseIndentation();
      } else {
        boolean _isGenerateExpressions = config.isGenerateExpressions();
        if (_isGenerateExpressions) {
          final XExpression body = this._iLogicalContainerProvider.getAssociatedExpression(it);
          boolean _notEquals_2 = (!Objects.equal(body, null));
          if (_notEquals_2) {
            boolean _hasErrors = this._errorSafeExtensions.hasErrors(body);
            if (_hasErrors) {
              appendable.append("/* skipped default expression with errors */");
            } else {
              appendable.append(" default ");
              JvmTypeReference _returnType = it.getReturnType();
              this.compiler.compileAsJavaExpression(body, appendable, _returnType);
            }
          } else {
            JvmAnnotationValue _defaultValue = it.getDefaultValue();
            boolean _notEquals_3 = (!Objects.equal(_defaultValue, null));
            if (_notEquals_3) {
              JvmAnnotationValue _defaultValue_1 = it.getDefaultValue();
              boolean _hasErrors_1 = this._errorSafeExtensions.hasErrors(_defaultValue_1);
              if (_hasErrors_1) {
                appendable.append("/* skipped default expression with errors */");
              } else {
                appendable.append(" default ");
                JvmAnnotationValue _defaultValue_2 = it.getDefaultValue();
                this.toJavaLiteral(_defaultValue_2, appendable, config);
              }
            }
          }
        }
      }
    }
  }
  
  private void appendCompilationTemplate(final ITreeAppendable appendable, final JvmIdentifiableElement it) {
    boolean _matched = false;
    if (!_matched) {
      if (appendable instanceof TreeAppendable) {
        _matched=true;
        SharedAppendableState _state = ((TreeAppendable)appendable).getState();
        StandardTypeReferenceOwner _standardTypeReferenceOwner = new StandardTypeReferenceOwner(this.commonServices, it);
        final ImportingStringConcatenation target = this.createImportingStringConcatenation(_state, _standardTypeReferenceOwner);
        StringConcatenationClient _compilationTemplate = this._jvmTypeExtensions.getCompilationTemplate(it);
        target.append(_compilationTemplate);
        ((TreeAppendable)appendable).append(target);
      }
    }
    if (!_matched) {
      Class<? extends ITreeAppendable> _class = appendable.getClass();
      String _name = _class.getName();
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
        boolean _isStatic = it.isStatic();
        if (_isStatic) {
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
  
  protected ITreeAppendable _generateModifier(final JvmDeclaredType it, final ITreeAppendable appendable, final GeneratorConfig config) {
    return this.generateVisibilityModifier(it, appendable);
  }
  
  protected ITreeAppendable _generateModifier(final JvmField it, final ITreeAppendable appendable, final GeneratorConfig config) {
    ITreeAppendable _xblockexpression = null;
    {
      this.generateVisibilityModifier(it, appendable);
      boolean _isFinal = it.isFinal();
      if (_isFinal) {
        appendable.append("final ");
      }
      boolean _isStatic = it.isStatic();
      if (_isStatic) {
        appendable.append("static ");
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
      boolean _isAbstract = it.isAbstract();
      if (_isAbstract) {
        appendable.append("abstract ");
      }
      boolean _isStatic = it.isStatic();
      if (_isStatic) {
        appendable.append("static ");
      }
      boolean _and = false;
      boolean _and_1 = false;
      boolean _and_2 = false;
      boolean _and_3 = false;
      boolean _isAbstract_1 = it.isAbstract();
      boolean _not = (!_isAbstract_1);
      if (!_not) {
        _and_3 = false;
      } else {
        boolean _isStatic_1 = it.isStatic();
        boolean _not_1 = (!_isStatic_1);
        _and_3 = _not_1;
      }
      if (!_and_3) {
        _and_2 = false;
      } else {
        JavaVersion _javaSourceVersion = config.getJavaSourceVersion();
        boolean _isAtLeast = _javaSourceVersion.isAtLeast(JavaVersion.JAVA8);
        _and_2 = _isAtLeast;
      }
      if (!_and_2) {
        _and_1 = false;
      } else {
        EObject _eContainer = it.eContainer();
        _and_1 = (_eContainer instanceof JvmGenericType);
      }
      if (!_and_1) {
        _and = false;
      } else {
        EObject _eContainer_1 = it.eContainer();
        boolean _isInterface = ((JvmGenericType) _eContainer_1).isInterface();
        _and = _isInterface;
      }
      if (_and) {
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
    JvmVisibility _visibility = it.getVisibility();
    String _javaName = this.javaName(_visibility);
    return result.append(_javaName);
  }
  
  protected ITreeAppendable _generateModifier(final JvmConstructor it, final ITreeAppendable appendable, final GeneratorConfig config) {
    return this.generateVisibilityModifier(it, appendable);
  }
  
  /**
   * Returns the visibility modifier and a space as suffix if not empty
   */
  public String javaName(final JvmVisibility visibility) {
    boolean _notEquals = (!Objects.equal(visibility, null));
    if (_notEquals) {
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
    if (!_matched) {
      if (it instanceof JvmAnnotationType) {
        _matched=true;
        _switchResult = "java.lang.Annotation";
      }
    }
    if (!_matched) {
      if (it instanceof JvmEnumerationType) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("java.lang.Enum<");
        String _identifier = ((JvmEnumerationType)it).getIdentifier();
        _builder.append(_identifier, "");
        _builder.append(">");
        _switchResult = _builder.toString();
      }
    }
    if (!_matched) {
      _switchResult = "java.lang.Object";
    }
    final String implicitSuperType = _switchResult;
    boolean _or = false;
    if ((it instanceof JvmAnnotationType)) {
      _or = true;
    } else {
      boolean _and = false;
      if (!(it instanceof JvmGenericType)) {
        _and = false;
      } else {
        boolean _isInterface = ((JvmGenericType) it).isInterface();
        _and = _isInterface;
      }
      _or = _and;
    }
    if (_or) {
      EList<JvmTypeReference> _superTypes = it.getSuperTypes();
      final Function1<JvmTypeReference, Boolean> _function = new Function1<JvmTypeReference, Boolean>() {
        @Override
        public Boolean apply(final JvmTypeReference typeRef) {
          String _identifier = typeRef.getIdentifier();
          return Boolean.valueOf((!Objects.equal(_identifier, implicitSuperType)));
        }
      };
      final Iterable<JvmTypeReference> withoutObject = IterableExtensions.<JvmTypeReference>filter(_superTypes, _function);
      final Procedure1<LoopParams> _function_1 = new Procedure1<LoopParams>() {
        @Override
        public void apply(final LoopParams it) {
          it.setPrefix("extends ");
          it.setSeparator(", ");
          it.setSuffix(" ");
        }
      };
      final Procedure2<JvmTypeReference, ITreeAppendable> _function_2 = new Procedure2<JvmTypeReference, ITreeAppendable>() {
        @Override
        public void apply(final JvmTypeReference it, final ITreeAppendable app) {
          JvmModelGenerator.this._errorSafeExtensions.serializeSafely(it, app);
        }
      };
      this._errorSafeExtensions.<JvmTypeReference>forEachSafely(appendable, withoutObject, _function_1, _function_2);
    } else {
      EList<JvmTypeReference> _superTypes_1 = it.getSuperTypes();
      final Function1<JvmTypeReference, Boolean> _function_3 = new Function1<JvmTypeReference, Boolean>() {
        @Override
        public Boolean apply(final JvmTypeReference typeRef) {
          String _identifier = typeRef.getIdentifier();
          return Boolean.valueOf((!Objects.equal(_identifier, implicitSuperType)));
        }
      };
      final Iterable<JvmTypeReference> withoutObject_1 = IterableExtensions.<JvmTypeReference>filter(_superTypes_1, _function_3);
      final Function1<JvmTypeReference, Boolean> _function_4 = new Function1<JvmTypeReference, Boolean>() {
        @Override
        public Boolean apply(final JvmTypeReference typeRef) {
          boolean _and = false;
          JvmType _type = typeRef.getType();
          if (!(_type instanceof JvmGenericType)) {
            _and = false;
          } else {
            JvmType _type_1 = typeRef.getType();
            boolean _isInterface = ((JvmGenericType) _type_1).isInterface();
            boolean _not = (!_isInterface);
            _and = _not;
          }
          return Boolean.valueOf(_and);
        }
      };
      Iterable<JvmTypeReference> _filter = IterableExtensions.<JvmTypeReference>filter(withoutObject_1, _function_4);
      final JvmTypeReference superClazz = IterableExtensions.<JvmTypeReference>head(_filter);
      final Function1<JvmTypeReference, Boolean> _function_5 = new Function1<JvmTypeReference, Boolean>() {
        @Override
        public Boolean apply(final JvmTypeReference typeRef) {
          return Boolean.valueOf((!Objects.equal(typeRef, superClazz)));
        }
      };
      final Iterable<JvmTypeReference> superInterfaces = IterableExtensions.<JvmTypeReference>filter(withoutObject_1, _function_5);
      boolean _notEquals = (!Objects.equal(superClazz, null));
      if (_notEquals) {
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
            final Exception ignoreMe = (Exception)_t;
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
        if (hasErrors) {
          appendable.append(" */");
        }
      }
      final Procedure1<LoopParams> _function_6 = new Procedure1<LoopParams>() {
        @Override
        public void apply(final LoopParams it) {
          it.setPrefix("implements ");
          it.setSeparator(", ");
          it.setSuffix(" ");
        }
      };
      final Procedure2<JvmTypeReference, ITreeAppendable> _function_7 = new Procedure2<JvmTypeReference, ITreeAppendable>() {
        @Override
        public void apply(final JvmTypeReference it, final ITreeAppendable app) {
          JvmModelGenerator.this._errorSafeExtensions.serializeSafely(it, app);
        }
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
      EList<JvmAnnotationReference> _annotations = it.getAnnotations();
      this.generateAnnotations(_annotations, tracedAppendable, true, config);
      this.generateModifier(it, tracedAppendable, config);
      JvmTypeReference _type = it.getType();
      this._errorSafeExtensions.serializeSafely(_type, "Object", tracedAppendable);
      tracedAppendable.append(" ");
      ITreeAppendable _traceSignificant = this._treeAppendableUtil.traceSignificant(tracedAppendable, it);
      String _simpleName = it.getSimpleName();
      String _makeJavaIdentifier = this.makeJavaIdentifier(_simpleName);
      _traceSignificant.append(_makeJavaIdentifier);
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
      EList<JvmAnnotationReference> _annotations = it.getAnnotations();
      this.generateAnnotations(_annotations, tracedAppendable, true, config);
      this.generateModifier(it, tracedAppendable, config);
      this.generateTypeParameterDeclaration(it, tracedAppendable, config);
      JvmTypeReference _returnType = it.getReturnType();
      boolean _equals = Objects.equal(_returnType, null);
      if (_equals) {
        tracedAppendable.append("void");
      } else {
        JvmTypeReference _returnType_1 = it.getReturnType();
        this._errorSafeExtensions.serializeSafely(_returnType_1, "Object", tracedAppendable);
      }
      tracedAppendable.append(" ");
      ITreeAppendable _traceSignificant = this._treeAppendableUtil.traceSignificant(tracedAppendable, it);
      String _simpleName = it.getSimpleName();
      String _makeJavaIdentifier = this.makeJavaIdentifier(_simpleName);
      _traceSignificant.append(_makeJavaIdentifier);
      tracedAppendable.append("(");
      this.generateParameters(it, tracedAppendable, config);
      tracedAppendable.append(")");
      this.generateThrowsClause(it, tracedAppendable, config);
      boolean _or = false;
      boolean _isAbstract = it.isAbstract();
      if (_isAbstract) {
        _or = true;
      } else {
        boolean _hasBody = this.hasBody(it);
        boolean _not = (!_hasBody);
        _or = _not;
      }
      if (_or) {
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
      EList<JvmAnnotationReference> _annotations = it.getAnnotations();
      this.generateAnnotations(_annotations, tracedAppendable, true, config);
      this.generateModifier(it, tracedAppendable, config);
      this.generateTypeParameterDeclaration(it, tracedAppendable, config);
      ITreeAppendable _traceSignificant = this._treeAppendableUtil.traceSignificant(tracedAppendable, it);
      String _simpleName = it.getSimpleName();
      String _makeJavaIdentifier = this.makeJavaIdentifier(_simpleName);
      _traceSignificant.append(_makeJavaIdentifier);
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
    boolean _notEquals = (!Objects.equal(_compilationStrategy, null));
    if (_notEquals) {
      final Iterable<Issue> errors = this.getDirectErrorsOrLogicallyContainedErrors(it);
      boolean _isEmpty = IterableExtensions.isEmpty(errors);
      if (_isEmpty) {
        appendable.append(" = ");
        appendable.increaseIndentation();
        Procedure1<? super ITreeAppendable> _compilationStrategy_1 = this._jvmTypeExtensions.getCompilationStrategy(it);
        _compilationStrategy_1.apply(appendable);
        appendable.decreaseIndentation();
      } else {
        appendable.append(" /* Skipped initializer because of errors */");
      }
    } else {
      StringConcatenationClient _compilationTemplate = this._jvmTypeExtensions.getCompilationTemplate(it);
      boolean _notEquals_1 = (!Objects.equal(_compilationTemplate, null));
      if (_notEquals_1) {
        final Iterable<Issue> errors_1 = this.getDirectErrorsOrLogicallyContainedErrors(it);
        boolean _isEmpty_1 = IterableExtensions.isEmpty(errors_1);
        if (_isEmpty_1) {
          ITreeAppendable _append = appendable.append(" = ");
          _append.increaseIndentation();
          this.appendCompilationTemplate(appendable, it);
          appendable.decreaseIndentation();
        } else {
          appendable.append(" /* Skipped initializer because of errors */");
        }
      } else {
        final XExpression expression = this._iLogicalContainerProvider.getAssociatedExpression(it);
        boolean _and = false;
        boolean _notEquals_2 = (!Objects.equal(expression, null));
        if (!_notEquals_2) {
          _and = false;
        } else {
          boolean _isGenerateExpressions = config.isGenerateExpressions();
          _and = _isGenerateExpressions;
        }
        if (_and) {
          boolean _hasErrors = this._errorSafeExtensions.hasErrors(expression);
          if (_hasErrors) {
            appendable.append(" /* Skipped initializer because of errors */");
          } else {
            appendable.append(" = ");
            JvmTypeReference _type = it.getType();
            this.compiler.compileAsJavaExpression(expression, appendable, _type);
          }
        }
      }
    }
  }
  
  public void generateTypeParameterDeclaration(final JvmTypeParameterDeclarator it, final ITreeAppendable appendable, final GeneratorConfig config) {
    EList<JvmTypeParameter> _typeParameters = it.getTypeParameters();
    final Procedure1<LoopParams> _function = new Procedure1<LoopParams>() {
      @Override
      public void apply(final LoopParams it) {
        it.setPrefix("<");
        it.setSeparator(", ");
        it.setSuffix("> ");
      }
    };
    final Procedure1<JvmTypeParameter> _function_1 = new Procedure1<JvmTypeParameter>() {
      @Override
      public void apply(final JvmTypeParameter it) {
        JvmModelGenerator.this.generateTypeParameterDeclaration(it, appendable, config);
      }
    };
    this._loopExtensions.<JvmTypeParameter>forEach(appendable, _typeParameters, _function, _function_1);
  }
  
  public void generateTypeParameterDeclaration(final JvmTypeParameter it, final ITreeAppendable appendable, final GeneratorConfig config) {
    final ITreeAppendable tracedAppendable = appendable.trace(it);
    ITreeAppendable _traceSignificant = this._treeAppendableUtil.traceSignificant(tracedAppendable, it);
    String _name = it.getName();
    _traceSignificant.append(_name);
    this.generateTypeParameterConstraints(it, tracedAppendable, config);
  }
  
  public void generateTypeParameterConstraints(final JvmTypeParameter it, final ITreeAppendable appendable, final GeneratorConfig config) {
    EList<JvmTypeConstraint> _constraints = it.getConstraints();
    final Iterable<JvmUpperBound> upperBounds = Iterables.<JvmUpperBound>filter(_constraints, JvmUpperBound.class);
    final Procedure1<LoopParams> _function = new Procedure1<LoopParams>() {
      @Override
      public void apply(final LoopParams it) {
        it.setPrefix(" extends ");
        it.setSeparator(" & ");
      }
    };
    final Procedure2<JvmUpperBound, ITreeAppendable> _function_1 = new Procedure2<JvmUpperBound, ITreeAppendable>() {
      @Override
      public void apply(final JvmUpperBound it, final ITreeAppendable app) {
        JvmTypeReference _typeReference = it.getTypeReference();
        JvmModelGenerator.this._errorSafeExtensions.serializeSafely(_typeReference, app);
      }
    };
    this._errorSafeExtensions.<JvmUpperBound>forEachSafely(appendable, upperBounds, _function, _function_1);
  }
  
  public void generateThrowsClause(final JvmExecutable it, final ITreeAppendable appendable, final GeneratorConfig config) {
    final LinkedHashMap<JvmType, JvmTypeReference> toBeGenerated = CollectionLiterals.<JvmType, JvmTypeReference>newLinkedHashMap();
    EList<JvmTypeReference> _exceptions = it.getExceptions();
    final Procedure1<JvmTypeReference> _function = new Procedure1<JvmTypeReference>() {
      @Override
      public void apply(final JvmTypeReference it) {
        JvmType _type = it.getType();
        boolean _containsKey = toBeGenerated.containsKey(_type);
        boolean _not = (!_containsKey);
        if (_not) {
          JvmType _type_1 = it.getType();
          toBeGenerated.put(_type_1, it);
        }
      }
    };
    IterableExtensions.<JvmTypeReference>forEach(_exceptions, _function);
    Collection<JvmTypeReference> _values = toBeGenerated.values();
    final Procedure1<LoopParams> _function_1 = new Procedure1<LoopParams>() {
      @Override
      public void apply(final LoopParams it) {
        it.setPrefix(" throws ");
        it.setSeparator(", ");
      }
    };
    final Procedure2<JvmTypeReference, ITreeAppendable> _function_2 = new Procedure2<JvmTypeReference, ITreeAppendable>() {
      @Override
      public void apply(final JvmTypeReference it, final ITreeAppendable app) {
        ITreeAppendable _trace = app.trace(it);
        JvmType _type = it.getType();
        _trace.append(_type);
      }
    };
    this._errorSafeExtensions.<JvmTypeReference>forEachSafely(appendable, _values, _function_1, _function_2);
  }
  
  public void generateParameters(final JvmExecutable it, final ITreeAppendable appendable, final GeneratorConfig config) {
    EList<JvmFormalParameter> _parameters = it.getParameters();
    boolean _isEmpty = _parameters.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      EList<JvmFormalParameter> _parameters_1 = it.getParameters();
      int _size = _parameters_1.size();
      int _minus = (_size - 1);
      IntegerRange _upTo = new IntegerRange(0, _minus);
      for (final Integer i : _upTo) {
        {
          EList<JvmFormalParameter> _parameters_2 = it.getParameters();
          int _size_1 = _parameters_2.size();
          final boolean last = (((i).intValue() + 1) == _size_1);
          EList<JvmFormalParameter> _parameters_3 = it.getParameters();
          final JvmFormalParameter p = _parameters_3.get((i).intValue());
          boolean _and = false;
          if (!last) {
            _and = false;
          } else {
            boolean _isVarArgs = it.isVarArgs();
            _and = _isVarArgs;
          }
          this.generateParameter(p, appendable, _and, config);
          if ((!last)) {
            appendable.append(", ");
          }
        }
      }
    }
  }
  
  public void generateParameter(final JvmFormalParameter it, final ITreeAppendable appendable, final boolean vararg, final GeneratorConfig config) {
    final ITreeAppendable tracedAppendable = appendable.trace(it);
    EList<JvmAnnotationReference> _annotations = it.getAnnotations();
    this.generateAnnotations(_annotations, tracedAppendable, false, config);
    tracedAppendable.append("final ");
    if (vararg) {
      JvmTypeReference _parameterType = it.getParameterType();
      boolean _not = (!(_parameterType instanceof JvmGenericArrayTypeReference));
      if (_not) {
        tracedAppendable.append("/* Internal Error: Parameter was vararg but not an array type. */");
      } else {
        JvmTypeReference _parameterType_1 = it.getParameterType();
        JvmTypeReference _componentType = ((JvmGenericArrayTypeReference) _parameterType_1).getComponentType();
        this._errorSafeExtensions.serializeSafely(_componentType, "Object", tracedAppendable);
      }
      tracedAppendable.append("...");
    } else {
      JvmTypeReference _parameterType_2 = it.getParameterType();
      this._errorSafeExtensions.serializeSafely(_parameterType_2, "Object", tracedAppendable);
    }
    tracedAppendable.append(" ");
    String _simpleName = it.getSimpleName();
    String _makeJavaIdentifier = this.makeJavaIdentifier(_simpleName);
    final String name = tracedAppendable.declareVariable(it, _makeJavaIdentifier);
    ITreeAppendable _traceSignificant = this._treeAppendableUtil.traceSignificant(tracedAppendable, it);
    _traceSignificant.append(name);
  }
  
  public boolean hasBody(final JvmExecutable it) {
    boolean _or = false;
    boolean _or_1 = false;
    StringConcatenationClient _compilationTemplate = this._jvmTypeExtensions.getCompilationTemplate(it);
    boolean _notEquals = (!Objects.equal(_compilationTemplate, null));
    if (_notEquals) {
      _or_1 = true;
    } else {
      Procedure1<? super ITreeAppendable> _compilationStrategy = this._jvmTypeExtensions.getCompilationStrategy(it);
      boolean _notEquals_1 = (!Objects.equal(_compilationStrategy, null));
      _or_1 = _notEquals_1;
    }
    if (_or_1) {
      _or = true;
    } else {
      XExpression _associatedExpression = this._iLogicalContainerProvider.getAssociatedExpression(it);
      boolean _notEquals_2 = (!Objects.equal(_associatedExpression, null));
      _or = _notEquals_2;
    }
    return _or;
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
      boolean _notEquals = (!Objects.equal(expression, null));
      if (_notEquals) {
        Iterable<Issue> _errors = this._errorSafeExtensions.getErrors(expression);
        errors = _errors;
      }
    }
    return errors;
  }
  
  public void generateExecutableBody(final JvmExecutable op, final ITreeAppendable appendable, final GeneratorConfig config) {
    Procedure1<? super ITreeAppendable> _compilationStrategy = this._jvmTypeExtensions.getCompilationStrategy(op);
    boolean _notEquals = (!Objects.equal(_compilationStrategy, null));
    if (_notEquals) {
      Iterable<Issue> errors = this.getDirectErrorsOrLogicallyContainedErrors(op);
      boolean _isEmpty = IterableExtensions.isEmpty(errors);
      if (_isEmpty) {
        ITreeAppendable _increaseIndentation = appendable.increaseIndentation();
        ITreeAppendable _append = _increaseIndentation.append("{");
        _append.newLine();
        Procedure1<? super ITreeAppendable> _compilationStrategy_1 = this._jvmTypeExtensions.getCompilationStrategy(op);
        _compilationStrategy_1.apply(appendable);
        ITreeAppendable _decreaseIndentation = appendable.decreaseIndentation();
        ITreeAppendable _newLine = _decreaseIndentation.newLine();
        _newLine.append("}");
      } else {
        this.generateBodyWithIssues(appendable, errors);
      }
    } else {
      StringConcatenationClient _compilationTemplate = this._jvmTypeExtensions.getCompilationTemplate(op);
      boolean _notEquals_1 = (!Objects.equal(_compilationTemplate, null));
      if (_notEquals_1) {
        final Iterable<Issue> errors_1 = this.getDirectErrorsOrLogicallyContainedErrors(op);
        boolean _isEmpty_1 = IterableExtensions.isEmpty(errors_1);
        if (_isEmpty_1) {
          ITreeAppendable _increaseIndentation_1 = appendable.increaseIndentation();
          ITreeAppendable _append_1 = _increaseIndentation_1.append("{");
          _append_1.newLine();
          this.appendCompilationTemplate(appendable, op);
          ITreeAppendable _decreaseIndentation_1 = appendable.decreaseIndentation();
          ITreeAppendable _newLine_1 = _decreaseIndentation_1.newLine();
          _newLine_1.append("}");
        } else {
          this.generateBodyWithIssues(appendable, errors_1);
        }
      } else {
        final XExpression expression = this._iLogicalContainerProvider.getAssociatedExpression(op);
        boolean _and = false;
        boolean _notEquals_2 = (!Objects.equal(expression, null));
        if (!_notEquals_2) {
          _and = false;
        } else {
          boolean _isGenerateExpressions = config.isGenerateExpressions();
          _and = _isGenerateExpressions;
        }
        if (_and) {
          final Iterable<Issue> errors_2 = this._errorSafeExtensions.getErrors(expression);
          boolean _isEmpty_2 = IterableExtensions.isEmpty(errors_2);
          if (_isEmpty_2) {
            JvmTypeReference _switchResult = null;
            boolean _matched = false;
            if (!_matched) {
              if (op instanceof JvmOperation) {
                _matched=true;
                _switchResult = ((JvmOperation)op).getReturnType();
              }
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
            ITreeAppendable _append_2 = appendable.append("{");
            _append_2.increaseIndentation();
            this.compile(op, expression, returnType, appendable, config);
            ITreeAppendable _decreaseIndentation_2 = appendable.decreaseIndentation();
            ITreeAppendable _newLine_2 = _decreaseIndentation_2.newLine();
            _newLine_2.append("}");
          } else {
            this.generateBodyWithIssues(appendable, errors_2);
          }
        } else {
          if ((op instanceof JvmOperation)) {
            ITreeAppendable _increaseIndentation_2 = appendable.increaseIndentation();
            ITreeAppendable _append_3 = _increaseIndentation_2.append("{");
            _append_3.newLine();
            appendable.append("throw new UnsupportedOperationException(\"");
            String _simpleName = ((JvmOperation)op).getSimpleName();
            appendable.append(_simpleName);
            appendable.append(" is not implemented\");");
            ITreeAppendable _decreaseIndentation_3 = appendable.decreaseIndentation();
            ITreeAppendable _newLine_3 = _decreaseIndentation_3.newLine();
            _newLine_3.append("}");
          } else {
            if ((op instanceof JvmConstructor)) {
              ITreeAppendable _append_4 = appendable.append("{");
              ITreeAppendable _newLine_4 = _append_4.newLine();
              _newLine_4.append("}");
            }
          }
        }
      }
    }
  }
  
  public ITreeAppendable compile(final JvmExecutable executable, final XExpression expression, final JvmTypeReference returnType, final ITreeAppendable appendable, final GeneratorConfig config) {
    EList<JvmTypeReference> _exceptions = executable.getExceptions();
    Set<JvmTypeReference> _set = IterableExtensions.<JvmTypeReference>toSet(_exceptions);
    return this.compiler.compile(expression, appendable, returnType, _set);
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
      JavaVersion _javaSourceVersion = config.getJavaSourceVersion();
      boolean _isAtLeast = _javaSourceVersion.isAtLeast(JavaVersion.JAVA8);
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
      boolean _notEquals = (!Objects.equal(superType, null));
      if (_notEquals) {
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
      boolean _notEquals = (!Objects.equal(declaredType, null));
      if (_notEquals) {
        _xifexpression = b.declareVariable(declaredType, "this");
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public ITreeAppendable generateBodyWithIssues(final ITreeAppendable appendable, final Iterable<Issue> errors) {
    ITreeAppendable _xblockexpression = null;
    {
      ITreeAppendable _append = appendable.append("{");
      ITreeAppendable _increaseIndentation = _append.increaseIndentation();
      ITreeAppendable _newLine = _increaseIndentation.newLine();
      _newLine.append("throw new Error(\"Unresolved compilation problems:\"");
      appendable.increaseIndentation();
      final Procedure1<Issue> _function = new Procedure1<Issue>() {
        @Override
        public void apply(final Issue it) {
          ITreeAppendable _newLine = appendable.newLine();
          ITreeAppendable _append = _newLine.append("+ \"\\n");
          String _message = it.getMessage();
          String _doConvertToJavaString = JvmModelGenerator.this.doConvertToJavaString(_message);
          ITreeAppendable _append_1 = _append.append(_doConvertToJavaString);
          _append_1.append("\"");
        }
      };
      IterableExtensions.<Issue>forEach(errors, _function);
      ITreeAppendable _append_1 = appendable.append(");");
      ITreeAppendable _decreaseIndentation = _append_1.decreaseIndentation();
      ITreeAppendable _decreaseIndentation_1 = _decreaseIndentation.decreaseIndentation();
      ITreeAppendable _newLine_1 = _decreaseIndentation_1.newLine();
      _xblockexpression = _newLine_1.append("}");
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
    EList<Adapter> _eAdapters = it.eAdapters();
    Iterable<FileHeaderAdapter> _filter = Iterables.<FileHeaderAdapter>filter(_eAdapters, FileHeaderAdapter.class);
    final FileHeaderAdapter fileHeaderAdapter = IterableExtensions.<FileHeaderAdapter>head(_filter);
    String _headerText = null;
    if (fileHeaderAdapter!=null) {
      _headerText=fileHeaderAdapter.getHeaderText();
    }
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_headerText);
    boolean _not = (!_isNullOrEmpty);
    if (_not) {
      String _headerText_1 = fileHeaderAdapter.getHeaderText();
      Resource _eResource = it.eResource();
      List<INode> _fileHeaderNodes = this.fileHeaderProvider.getFileHeaderNodes(_eResource);
      this.generateDocumentation(_headerText_1, _fileHeaderNodes, appendable, config);
    }
  }
  
  public void generateJavaDoc(final EObject it, final ITreeAppendable appendable, final GeneratorConfig config) {
    EList<Adapter> _eAdapters = it.eAdapters();
    Iterable<DocumentationAdapter> _filter = Iterables.<DocumentationAdapter>filter(_eAdapters, DocumentationAdapter.class);
    final DocumentationAdapter adapter = IterableExtensions.<DocumentationAdapter>head(_filter);
    String _documentation = null;
    if (adapter!=null) {
      _documentation=adapter.getDocumentation();
    }
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_documentation);
    boolean _not = (!_isNullOrEmpty);
    if (_not) {
      final Set<EObject> sourceElements = this.getSourceElements(it);
      boolean _and = false;
      int _size = sourceElements.size();
      boolean _equals = (_size == 1);
      if (!_equals) {
        _and = false;
      } else {
        _and = (this.documentationProvider instanceof IEObjectDocumentationProviderExtension);
      }
      if (_and) {
        EObject _head = IterableExtensions.<EObject>head(sourceElements);
        final List<INode> documentationNodes = ((IEObjectDocumentationProviderExtension) this.documentationProvider).getDocumentationNodes(_head);
        this.addJavaDocImports(it, appendable, documentationNodes);
        String _documentation_1 = adapter.getDocumentation();
        this.generateDocumentation(_documentation_1, documentationNodes, appendable, config);
      } else {
        String _documentation_2 = adapter.getDocumentation();
        List<INode> _emptyList = CollectionLiterals.<INode>emptyList();
        this.generateDocumentation(_documentation_2, _emptyList, appendable, config);
      }
    }
  }
  
  public void addJavaDocImports(final EObject it, final ITreeAppendable appendable, final List<INode> documentationNodes) {
    for (final INode node : documentationNodes) {
      List<ReplaceRegion> _computeTypeRefRegions = this.javaDocTypeReferenceProvider.computeTypeRefRegions(node);
      for (final ReplaceRegion region : _computeTypeRefRegions) {
        {
          final String text = region.getText();
          boolean _and = false;
          boolean _notEquals = (!Objects.equal(text, null));
          if (!_notEquals) {
            _and = false;
          } else {
            int _length = text.length();
            boolean _greaterThan = (_length > 0);
            _and = _greaterThan;
          }
          if (_and) {
            final QualifiedName fqn = this.qualifiedNameConverter.toQualifiedName(text);
            final EObject context = NodeModelUtils.findActualSemanticObjectFor(node);
            boolean _and_1 = false;
            int _segmentCount = fqn.getSegmentCount();
            boolean _equals = (_segmentCount == 1);
            if (!_equals) {
              _and_1 = false;
            } else {
              boolean _notEquals_1 = (!Objects.equal(context, null));
              _and_1 = _notEquals_1;
            }
            if (_and_1) {
              final IScope scope = this.scopeProvider.getScope(context, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
              final IEObjectDescription candidate = scope.getSingleElement(fqn);
              boolean _notEquals_2 = (!Objects.equal(candidate, null));
              if (_notEquals_2) {
                EObject _xifexpression = null;
                EObject _eObjectOrProxy = candidate.getEObjectOrProxy();
                boolean _eIsProxy = _eObjectOrProxy.eIsProxy();
                if (_eIsProxy) {
                  EObject _eObjectOrProxy_1 = candidate.getEObjectOrProxy();
                  _xifexpression = EcoreUtil.resolve(_eObjectOrProxy_1, context);
                } else {
                  _xifexpression = candidate.getEObjectOrProxy();
                }
                final JvmType jvmType = ((JvmType) _xifexpression);
                boolean _and_2 = false;
                if (!(jvmType instanceof JvmDeclaredType)) {
                  _and_2 = false;
                } else {
                  boolean _eIsProxy_1 = jvmType.eIsProxy();
                  boolean _not = (!_eIsProxy_1);
                  _and_2 = _not;
                }
                if (_and_2) {
                  final JvmDeclaredType referencedType = ((JvmDeclaredType) jvmType);
                  final JvmDeclaredType contextDeclarator = EcoreUtil2.<JvmDeclaredType>getContainerOfType(it, JvmDeclaredType.class);
                  String _packageName = referencedType.getPackageName();
                  String _packageName_1 = contextDeclarator.getPackageName();
                  boolean _notEquals_3 = (!Objects.equal(_packageName, _packageName_1));
                  if (_notEquals_3) {
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
        Class<? extends ITreeAppendable> _class = appendable.getClass();
        final Field stateField = _class.getDeclaredField("state");
        stateField.setAccessible(true);
        final Object stateValue = stateField.get(appendable);
        Class<?> _class_1 = stateValue.getClass();
        final Field importManagerField = _class_1.getDeclaredField("importManager");
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
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("/**");
      final StringConcatenation doc = ((StringConcatenation) _builder);
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
            ITextRegionWithLineInformation _textRegionWithLineInformation = node.getTextRegionWithLineInformation();
            ITextRegionWithLineInformation _merge = documentationTrace.merge(_textRegionWithLineInformation);
            documentationTrace = _merge;
          }
          LocationData _locationData = new LocationData(documentationTrace, null);
          ITreeAppendable _trace = appendable.trace(_locationData);
          String _string = doc.toString();
          _trace.append(_string);
          _xblockexpression_1 = appendable.newLine();
        }
        _xifexpression = _xblockexpression_1;
      } else {
        String _string = doc.toString();
        ITreeAppendable _append = appendable.append(_string);
        _xifexpression = _append.newLine();
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public void generateAnnotations(final Iterable<JvmAnnotationReference> annotations, final ITreeAppendable appendable, final boolean withLineBreak, final GeneratorConfig config) {
    final Function1<ITreeAppendable, ITreeAppendable> _function = new Function1<ITreeAppendable, ITreeAppendable>() {
      @Override
      public ITreeAppendable apply(final ITreeAppendable it) {
        ITreeAppendable _xifexpression = null;
        if (withLineBreak) {
          _xifexpression = it.newLine();
        } else {
          _xifexpression = it.append(" ");
        }
        return _xifexpression;
      }
    };
    final Function1<ITreeAppendable, ITreeAppendable> sep = _function;
    final Procedure1<LoopParams> _function_1 = new Procedure1<LoopParams>() {
      @Override
      public void apply(final LoopParams it) {
        it.setSeparator(sep);
        it.setSuffix(sep);
      }
    };
    final Procedure2<JvmAnnotationReference, ITreeAppendable> _function_2 = new Procedure2<JvmAnnotationReference, ITreeAppendable>() {
      @Override
      public void apply(final JvmAnnotationReference it, final ITreeAppendable app) {
        JvmModelGenerator.this.generateAnnotation(it, app, config);
      }
    };
    this._errorSafeExtensions.<JvmAnnotationReference>forEachSafely(appendable, annotations, _function_1, _function_2);
  }
  
  public void generateAnnotation(final JvmAnnotationReference it, final ITreeAppendable appendable, final GeneratorConfig config) {
    appendable.append("@");
    JvmAnnotationType _annotation = it.getAnnotation();
    appendable.append(_annotation);
    EList<JvmAnnotationValue> _explicitValues = it.getExplicitValues();
    final Procedure1<LoopParams> _function = new Procedure1<LoopParams>() {
      @Override
      public void apply(final LoopParams it) {
        it.setPrefix("(");
        it.setSeparator(", ");
        it.setSuffix(")");
      }
    };
    final Procedure1<JvmAnnotationValue> _function_1 = new Procedure1<JvmAnnotationValue>() {
      @Override
      public void apply(final JvmAnnotationValue it) {
        JvmModelGenerator.this.toJava(it, appendable, config);
      }
    };
    this._loopExtensions.<JvmAnnotationValue>forEach(appendable, _explicitValues, _function, _function_1);
  }
  
  public void toJava(final JvmAnnotationValue it, final ITreeAppendable appendable, final GeneratorConfig config) {
    JvmOperation _operation = it.getOperation();
    boolean _notEquals = (!Objects.equal(_operation, null));
    if (_notEquals) {
      JvmOperation _operation_1 = it.getOperation();
      String _simpleName = _operation_1.getSimpleName();
      boolean _equals = Objects.equal(_simpleName, null);
      if (_equals) {
        return;
      }
      JvmOperation _operation_2 = it.getOperation();
      String _simpleName_1 = _operation_2.getSimpleName();
      appendable.append(_simpleName_1);
      appendable.append(" = ");
    } else {
      EObject _eContainer = it.eContainer();
      EList<JvmAnnotationValue> _explicitValues = ((JvmAnnotationReference) _eContainer).getExplicitValues();
      int _size = _explicitValues.size();
      boolean _greaterThan = (_size > 1);
      if (_greaterThan) {
        appendable.append("value = ");
      }
    }
    this.toJavaLiteral(it, appendable, config);
  }
  
  protected void _toJavaLiteral(final JvmAnnotationAnnotationValue value, final ITreeAppendable appendable, final GeneratorConfig config) {
    EList<JvmAnnotationReference> _values = value.getValues();
    final Procedure1<JvmAnnotationReference> _function = new Procedure1<JvmAnnotationReference>() {
      @Override
      public void apply(final JvmAnnotationReference it) {
        JvmModelGenerator.this.generateAnnotation(it, appendable, config);
      }
    };
    this._loopExtensions.<JvmAnnotationReference>forEachWithShortcut(appendable, _values, _function);
  }
  
  protected void _toJavaLiteral(final JvmShortAnnotationValue it, final ITreeAppendable appendable, final GeneratorConfig config) {
    EList<Short> _values = it.getValues();
    final Procedure1<Short> _function = new Procedure1<Short>() {
      @Override
      public void apply(final Short it) {
        String _string = it.toString();
        appendable.append(_string);
      }
    };
    this._loopExtensions.<Short>forEachWithShortcut(appendable, _values, _function);
  }
  
  protected void _toJavaLiteral(final JvmIntAnnotationValue it, final ITreeAppendable appendable, final GeneratorConfig config) {
    EList<Integer> _values = it.getValues();
    final Procedure1<Integer> _function = new Procedure1<Integer>() {
      @Override
      public void apply(final Integer it) {
        String _string = it.toString();
        appendable.append(_string);
      }
    };
    this._loopExtensions.<Integer>forEachWithShortcut(appendable, _values, _function);
  }
  
  protected void _toJavaLiteral(final JvmLongAnnotationValue it, final ITreeAppendable appendable, final GeneratorConfig config) {
    EList<Long> _values = it.getValues();
    final Procedure1<Long> _function = new Procedure1<Long>() {
      @Override
      public void apply(final Long it) {
        String _string = it.toString();
        appendable.append(_string);
      }
    };
    this._loopExtensions.<Long>forEachWithShortcut(appendable, _values, _function);
  }
  
  protected void _toJavaLiteral(final JvmByteAnnotationValue it, final ITreeAppendable appendable, final GeneratorConfig config) {
    EList<Byte> _values = it.getValues();
    final Procedure1<Byte> _function = new Procedure1<Byte>() {
      @Override
      public void apply(final Byte it) {
        String _string = it.toString();
        appendable.append(_string);
      }
    };
    this._loopExtensions.<Byte>forEachWithShortcut(appendable, _values, _function);
  }
  
  protected void _toJavaLiteral(final JvmDoubleAnnotationValue it, final ITreeAppendable appendable, final GeneratorConfig config) {
    EList<Double> _values = it.getValues();
    final Procedure1<Double> _function = new Procedure1<Double>() {
      @Override
      public void apply(final Double it) {
        String _switchResult = null;
        boolean _matched = false;
        if (!_matched) {
          boolean _isNaN = Double.isNaN((it).doubleValue());
          if (_isNaN) {
            _matched=true;
            _switchResult = "Double.NaN";
          }
        }
        if (!_matched) {
          if (Objects.equal(it, Double.POSITIVE_INFINITY)) {
            _matched=true;
            _switchResult = "Double.POSITIVE_INFINITY";
          }
        }
        if (!_matched) {
          if (Objects.equal(it, Double.NEGATIVE_INFINITY)) {
            _matched=true;
            _switchResult = "Double.NEGATIVE_INFINITY";
          }
        }
        if (!_matched) {
          String _string = it.toString();
          _switchResult = (_string + "d");
        }
        appendable.append(_switchResult);
      }
    };
    this._loopExtensions.<Double>forEachWithShortcut(appendable, _values, _function);
  }
  
  protected void _toJavaLiteral(final JvmFloatAnnotationValue it, final ITreeAppendable appendable, final GeneratorConfig config) {
    EList<Float> _values = it.getValues();
    final Procedure1<Float> _function = new Procedure1<Float>() {
      @Override
      public void apply(final Float it) {
        String _switchResult = null;
        boolean _matched = false;
        if (!_matched) {
          boolean _isNaN = Float.isNaN((it).floatValue());
          if (_isNaN) {
            _matched=true;
            _switchResult = "Float.NaN";
          }
        }
        if (!_matched) {
          if (Objects.equal(it, Float.POSITIVE_INFINITY)) {
            _matched=true;
            _switchResult = "Float.POSITIVE_INFINITY";
          }
        }
        if (!_matched) {
          if (Objects.equal(it, Float.NEGATIVE_INFINITY)) {
            _matched=true;
            _switchResult = "Float.NEGATIVE_INFINITY";
          }
        }
        if (!_matched) {
          String _string = it.toString();
          _switchResult = (_string + "f");
        }
        appendable.append(_switchResult);
      }
    };
    this._loopExtensions.<Float>forEachWithShortcut(appendable, _values, _function);
  }
  
  protected void _toJavaLiteral(final JvmCharAnnotationValue it, final ITreeAppendable appendable, final GeneratorConfig config) {
    EList<Character> _values = it.getValues();
    final Procedure1<Character> _function = new Procedure1<Character>() {
      @Override
      public void apply(final Character it) {
        String _string = it.toString();
        String _doConvertToJavaString = JvmModelGenerator.this.doConvertToJavaString(_string);
        String _plus = ("\'" + _doConvertToJavaString);
        String _plus_1 = (_plus + "\'");
        appendable.append(_plus_1);
      }
    };
    this._loopExtensions.<Character>forEachWithShortcut(appendable, _values, _function);
  }
  
  protected void _toJavaLiteral(final JvmStringAnnotationValue it, final ITreeAppendable appendable, final GeneratorConfig config) {
    EList<String> _values = it.getValues();
    final Procedure1<String> _function = new Procedure1<String>() {
      @Override
      public void apply(final String it) {
        String _string = it.toString();
        String _doConvertToJavaString = JvmModelGenerator.this.doConvertToJavaString(_string);
        String _plus = ("\"" + _doConvertToJavaString);
        String _plus_1 = (_plus + "\"");
        appendable.append(_plus_1);
      }
    };
    this._loopExtensions.<String>forEachWithShortcut(appendable, _values, _function);
  }
  
  protected void _toJavaLiteral(final JvmTypeAnnotationValue it, final ITreeAppendable appendable, final GeneratorConfig config) {
    EList<JvmTypeReference> _values = it.getValues();
    final Procedure1<JvmTypeReference> _function = new Procedure1<JvmTypeReference>() {
      @Override
      public void apply(final JvmTypeReference it) {
        JvmType _type = it.getType();
        ITreeAppendable _append = appendable.append(_type);
        _append.append(".class");
      }
    };
    this._loopExtensions.<JvmTypeReference>forEachWithShortcut(appendable, _values, _function);
  }
  
  protected void _toJavaLiteral(final JvmEnumAnnotationValue it, final ITreeAppendable appendable, final GeneratorConfig config) {
    EList<JvmEnumerationLiteral> _values = it.getValues();
    final Procedure1<JvmEnumerationLiteral> _function = new Procedure1<JvmEnumerationLiteral>() {
      @Override
      public void apply(final JvmEnumerationLiteral it) {
        JvmDeclaredType _declaringType = it.getDeclaringType();
        appendable.append(_declaringType);
        appendable.append(".");
        String _simpleName = it.getSimpleName();
        String _makeJavaIdentifier = JvmModelGenerator.this.makeJavaIdentifier(_simpleName);
        appendable.append(_makeJavaIdentifier);
      }
    };
    this._loopExtensions.<JvmEnumerationLiteral>forEachWithShortcut(appendable, _values, _function);
  }
  
  protected void _toJavaLiteral(final JvmBooleanAnnotationValue it, final ITreeAppendable appendable, final GeneratorConfig config) {
    EList<Boolean> _values = it.getValues();
    final Procedure1<Boolean> _function = new Procedure1<Boolean>() {
      @Override
      public void apply(final Boolean it) {
        String _string = it.toString();
        appendable.append(_string);
      }
    };
    this._loopExtensions.<Boolean>forEachWithShortcut(appendable, _values, _function);
  }
  
  protected void _toJavaLiteral(final JvmCustomAnnotationValue it, final ITreeAppendable appendable, final GeneratorConfig config) {
    EList<EObject> _values = it.getValues();
    boolean _isEmpty = _values.isEmpty();
    if (_isEmpty) {
      appendable.append("{}");
    } else {
      EList<EObject> _values_1 = it.getValues();
      Iterable<XExpression> _filter = Iterables.<XExpression>filter(_values_1, XExpression.class);
      final Procedure1<XExpression> _function = new Procedure1<XExpression>() {
        @Override
        public void apply(final XExpression it) {
          JvmModelGenerator.this.compiler.toJavaExpression(it, appendable);
        }
      };
      this._loopExtensions.<XExpression>forEachWithShortcut(appendable, _filter, _function);
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
        URI _uRI = uri.getURI();
        boolean _containsKey = this.uriForTraceCache.containsKey(_uRI);
        boolean _not = (!_containsKey);
        if (_not) {
          final SourceRelativeURI result = JvmModelGenerator.this.converter.getURIForTrace(config, uri);
          URI _uRI_1 = uri.getURI();
          this.uriForTraceCache.put(_uRI_1, result);
        }
        URI _uRI_2 = uri.getURI();
        return this.uriForTraceCache.get(_uRI_2);
      }
      
      @Override
      public SourceRelativeURI getURIForTrace(final Resource resource) {
        URI _uRI = resource.getURI();
        boolean _containsKey = this.uriForTraceCache.containsKey(_uRI);
        boolean _not = (!_containsKey);
        if (_not) {
          final SourceRelativeURI result = JvmModelGenerator.this.converter.getURIForTrace(resource);
          URI _uRI_1 = resource.getURI();
          this.uriForTraceCache.put(_uRI_1, result);
        }
        URI _uRI_2 = resource.getURI();
        return this.uriForTraceCache.get(_uRI_2);
      }
    };
    final TreeAppendable appendable = new TreeAppendable(importManager, cachingConverter, this.locationProvider, this.jvmModelAssociations, context, "  ", "\n");
    SharedAppendableState _state = appendable.getState();
    _state.setGeneratorConfig(config);
    return appendable;
  }
  
  public JvmGenericType containerType(final EObject context) {
    JvmGenericType _xifexpression = null;
    boolean _equals = Objects.equal(context, null);
    if (_equals) {
      _xifexpression = null;
    } else {
      JvmGenericType _xifexpression_1 = null;
      if ((context instanceof JvmGenericType)) {
        _xifexpression_1 = ((JvmGenericType)context);
      } else {
        EObject _eContainer = context.eContainer();
        _xifexpression_1 = this.containerType(_eContainer);
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  protected String makeJavaIdentifier(final String name) {
    String _xifexpression = null;
    boolean _equals = Objects.equal(name, null);
    if (_equals) {
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
      EList<JvmMember> _members = type.getMembers();
      final Function1<JvmMember, Boolean> _function = new Function1<JvmMember, Boolean>() {
        @Override
        public Boolean apply(final JvmMember it) {
          boolean _and = false;
          if (!(it instanceof JvmOperation)) {
            _and = false;
          } else {
            String _identifier = it.getIdentifier();
            boolean _contains = syntheticEnumMethods.contains(_identifier);
            _and = _contains;
          }
          return Boolean.valueOf((!_and));
        }
      };
      _xblockexpression = IterableExtensions.<JvmMember>filter(_members, _function);
    }
    return _xblockexpression;
  }
  
  protected Iterable<JvmMember> _getMembersToBeCompiled(final JvmDeclaredType it) {
    EList<JvmMember> _members = it.getMembers();
    final Function1<JvmMember, Boolean> _function = new Function1<JvmMember, Boolean>() {
      @Override
      public Boolean apply(final JvmMember it) {
        boolean _and = false;
        if (!(it instanceof JvmConstructor)) {
          _and = false;
        } else {
          boolean _isSingleSyntheticDefaultConstructor = JvmModelGenerator.this._jvmTypeExtensions.isSingleSyntheticDefaultConstructor(((JvmConstructor) it));
          _and = _isSingleSyntheticDefaultConstructor;
        }
        return Boolean.valueOf((!_and));
      }
    };
    return IterableExtensions.<JvmMember>filter(_members, _function);
  }
  
  protected Iterable<JvmMember> _getMembersToBeCompiled(final JvmGenericType it) {
    Iterable<JvmMember> _xifexpression = null;
    boolean _isAnonymous = it.isAnonymous();
    if (_isAnonymous) {
      EList<JvmMember> _members = it.getMembers();
      final Function1<JvmMember, Boolean> _function = new Function1<JvmMember, Boolean>() {
        @Override
        public Boolean apply(final JvmMember it) {
          return Boolean.valueOf((!(it instanceof JvmConstructor)));
        }
      };
      _xifexpression = IterableExtensions.<JvmMember>filter(_members, _function);
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
