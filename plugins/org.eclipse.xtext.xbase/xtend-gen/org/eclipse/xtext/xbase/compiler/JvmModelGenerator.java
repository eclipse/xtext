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
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmAnnotationAnnotationValue;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationTarget;
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
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmGenericType;
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
import org.eclipse.xtext.common.types.JvmVoid;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.documentation.IEObjectDocumentationProviderExtension;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.trace.LocationData;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.TextRegionWithLineInformation;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.DisableCodeGenerationAdapter;
import org.eclipse.xtext.xbase.compiler.DocumentationAdapter;
import org.eclipse.xtext.xbase.compiler.ErrorSafeExtensions;
import org.eclipse.xtext.xbase.compiler.FileHeaderAdapter;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.JavaKeywords;
import org.eclipse.xtext.xbase.compiler.LoopExtensions;
import org.eclipse.xtext.xbase.compiler.LoopParams;
import org.eclipse.xtext.xbase.compiler.TreeAppendableUtil;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.compiler.output.TreeAppendable;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * A generator implementation that processes the
 * derived {@link org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer JVM model}
 * and produces the respective java code.
 */
@SuppressWarnings("all")
public class JvmModelGenerator implements IGenerator {
  private final static Logger LOG = new Function0<Logger>() {
    public Logger apply() {
      Logger _logger = Logger.getLogger(JvmModelGenerator.class);
      return _logger;
    }
  }.apply();
  
  @Inject
  private ILogicalContainerProvider _iLogicalContainerProvider;
  
  @Inject
  private TypeReferences _typeReferences;
  
  @Inject
  private TreeAppendableUtil _treeAppendableUtil;
  
  @Inject
  private JvmTypeExtensions _jvmTypeExtensions;
  
  @Inject
  private LoopExtensions _loopExtensions;
  
  @Inject
  private ErrorSafeExtensions _errorSafeExtensions;
  
  @Inject
  private XbaseCompiler compiler;
  
  @Inject
  private ILocationInFileProvider locationProvider;
  
  @Inject
  private IEObjectDocumentationProvider documentationProvider;
  
  @Inject
  private IJvmModelAssociations jvmModelAssociations;
  
  @Inject
  private JavaKeywords keywords;
  
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
    boolean _notEquals = ObjectExtensions.operator_notEquals(_qualifiedName, null);
    if (_notEquals) {
      String _qualifiedName_1 = type.getQualifiedName();
      String _replace = _qualifiedName_1.replace(".", "/");
      String _plus = (_replace + ".java");
      CharSequence _generateType = this.generateType(type);
      fsa.generateFile(_plus, _generateType);
    }
  }
  
  public CharSequence generateType(final JvmDeclaredType type) {
    ImportManager _importManager = new ImportManager(true, type);
    final ImportManager importManager = _importManager;
    final TreeAppendable bodyAppendable = this.createAppendable(type, importManager);
    this.generateBody(type, bodyAppendable);
    final TreeAppendable importAppendable = this.createAppendable(type, importManager);
    String _packageName = type.getPackageName();
    boolean _notEquals = ObjectExtensions.operator_notEquals(_packageName, null);
    if (_notEquals) {
      this.generateFileHeader(type, importAppendable);
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
  
  protected ITreeAppendable _generateBody(final JvmGenericType it, final ITreeAppendable appendable) {
    ITreeAppendable _xblockexpression = null;
    {
      this.generateJavaDoc(it, appendable);
      final ITreeAppendable childAppendable = appendable.trace(it);
      this.generateAnnotations(it, childAppendable, true);
      this.generateModifier(it, childAppendable);
      boolean _isInterface = it.isInterface();
      if (_isInterface) {
        childAppendable.append("interface ");
      } else {
        childAppendable.append("class ");
      }
      ITreeAppendable _traceSignificant = this._treeAppendableUtil.traceSignificant(childAppendable, it);
      String _simpleName = it.getSimpleName();
      _traceSignificant.append(_simpleName);
      this.generateTypeParameterDeclaration(it, childAppendable);
      EList<JvmTypeParameter> _typeParameters = it.getTypeParameters();
      boolean _isEmpty = _typeParameters.isEmpty();
      if (_isEmpty) {
        childAppendable.append(" ");
      }
      this.generateExtendsClause(it, childAppendable);
      ITreeAppendable _append = childAppendable.append("{");
      _append.increaseIndentation();
      Iterable<JvmMember> _membersToBeCompiled = this.getMembersToBeCompiled(it);
      final Procedure1<LoopParams> _function = new Procedure1<LoopParams>() {
          public void apply(final LoopParams it) {
            final Function1<ITreeAppendable,ITreeAppendable> _function = new Function1<ITreeAppendable,ITreeAppendable>() {
                public ITreeAppendable apply(final ITreeAppendable it) {
                  ITreeAppendable _newLine = it.newLine();
                  return _newLine;
                }
              };
            it.setSeparator(_function);
          }
        };
      final Procedure1<JvmMember> _function_1 = new Procedure1<JvmMember>() {
          public void apply(final JvmMember it) {
            final ITreeAppendable memberAppendable = JvmModelGenerator.this._treeAppendableUtil.traceWithComments(childAppendable, it);
            memberAppendable.openScope();
            JvmModelGenerator.this.generateMember(it, memberAppendable);
            memberAppendable.closeScope();
          }
        };
      this._loopExtensions.<JvmMember>forEach(childAppendable, _membersToBeCompiled, _function, _function_1);
      ITreeAppendable _decreaseIndentation = childAppendable.decreaseIndentation();
      ITreeAppendable _newLine = _decreaseIndentation.newLine();
      _newLine.append("}");
      ITreeAppendable _newLine_1 = appendable.newLine();
      _xblockexpression = (_newLine_1);
    }
    return _xblockexpression;
  }
  
  protected ITreeAppendable _generateBody(final JvmEnumerationType it, final ITreeAppendable appendable) {
    ITreeAppendable _xblockexpression = null;
    {
      this.generateJavaDoc(it, appendable);
      final ITreeAppendable childAppendable = appendable.trace(it);
      this.generateAnnotations(it, childAppendable, true);
      this.generateModifier(it, childAppendable);
      childAppendable.append("enum ");
      ITreeAppendable _traceSignificant = this._treeAppendableUtil.traceSignificant(childAppendable, it);
      String _simpleName = it.getSimpleName();
      _traceSignificant.append(_simpleName);
      childAppendable.append(" ");
      this.generateExtendsClause(it, childAppendable);
      ITreeAppendable _append = childAppendable.append("{");
      _append.increaseIndentation();
      EList<JvmEnumerationLiteral> _literals = it.getLiterals();
      final Procedure1<LoopParams> _function = new Procedure1<LoopParams>() {
          public void apply(final LoopParams it) {
            final Function1<ITreeAppendable,ITreeAppendable> _function = new Function1<ITreeAppendable,ITreeAppendable>() {
                public ITreeAppendable apply(final ITreeAppendable it) {
                  ITreeAppendable _append = it.append(",");
                  ITreeAppendable _newLine = _append.newLine();
                  return _newLine;
                }
              };
            it.setSeparator(_function);
            it.setSuffix(";");
          }
        };
      final Procedure1<JvmEnumerationLiteral> _function_1 = new Procedure1<JvmEnumerationLiteral>() {
          public void apply(final JvmEnumerationLiteral it) {
            ITreeAppendable _trace = childAppendable.trace(it);
            JvmModelGenerator.this.generateEnumLiteral(it, _trace);
          }
        };
      this._loopExtensions.<JvmEnumerationLiteral>forEach(childAppendable, _literals, _function, _function_1);
      Iterable<JvmMember> _membersToBeCompiled = this.getMembersToBeCompiled(it);
      final Function1<JvmMember,Boolean> _function_2 = new Function1<JvmMember,Boolean>() {
          public Boolean apply(final JvmMember it) {
            boolean _not = (!(it instanceof JvmEnumerationLiteral));
            return Boolean.valueOf(_not);
          }
        };
      Iterable<JvmMember> _filter = IterableExtensions.<JvmMember>filter(_membersToBeCompiled, _function_2);
      final Procedure1<LoopParams> _function_3 = new Procedure1<LoopParams>() {
          public void apply(final LoopParams it) {
            final Function1<ITreeAppendable,ITreeAppendable> _function = new Function1<ITreeAppendable,ITreeAppendable>() {
                public ITreeAppendable apply(final ITreeAppendable it) {
                  ITreeAppendable _newLine = it.newLine();
                  return _newLine;
                }
              };
            it.setSeparator(_function);
          }
        };
      final Procedure1<JvmMember> _function_4 = new Procedure1<JvmMember>() {
          public void apply(final JvmMember it) {
            ITreeAppendable _trace = childAppendable.trace(it);
            JvmModelGenerator.this.generateMember(it, _trace);
          }
        };
      this._loopExtensions.<JvmMember>forEach(childAppendable, _filter, _function_3, _function_4);
      ITreeAppendable _decreaseIndentation = childAppendable.decreaseIndentation();
      ITreeAppendable _newLine = _decreaseIndentation.newLine();
      _newLine.append("}");
      ITreeAppendable _newLine_1 = appendable.newLine();
      _xblockexpression = (_newLine_1);
    }
    return _xblockexpression;
  }
  
  public void generateEnumLiteral(final JvmEnumerationLiteral it, final ITreeAppendable appendable) {
    ITreeAppendable _increaseIndentation = appendable.increaseIndentation();
    _increaseIndentation.newLine();
    this.generateJavaDoc(it, appendable);
    this.generateAnnotations(it, appendable, true);
    String _simpleName = it.getSimpleName();
    appendable.append(_simpleName);
    appendable.decreaseIndentation();
  }
  
  protected ITreeAppendable _generateBody(final JvmAnnotationType it, final ITreeAppendable appendable) {
    ITreeAppendable _xblockexpression = null;
    {
      this.generateJavaDoc(it, appendable);
      final ITreeAppendable childAppendable = appendable.trace(it);
      this.generateAnnotations(it, childAppendable, true);
      this.generateModifier(it, childAppendable);
      childAppendable.append("@interface ");
      ITreeAppendable _traceSignificant = this._treeAppendableUtil.traceSignificant(childAppendable, it);
      String _simpleName = it.getSimpleName();
      _traceSignificant.append(_simpleName);
      childAppendable.append(" {");
      EList<JvmMember> _members = it.getMembers();
      Iterable<JvmOperation> _filter = Iterables.<JvmOperation>filter(_members, JvmOperation.class);
      for (final JvmOperation operation : _filter) {
        this.generateAnnotationMethod(operation, childAppendable);
      }
      ITreeAppendable _newLine = childAppendable.newLine();
      _newLine.append("}");
      ITreeAppendable _newLine_1 = appendable.newLine();
      _xblockexpression = (_newLine_1);
    }
    return _xblockexpression;
  }
  
  public void generateAnnotationMethod(final JvmOperation it, final ITreeAppendable appendable) {
    ITreeAppendable _increaseIndentation = appendable.increaseIndentation();
    _increaseIndentation.newLine();
    appendable.openScope();
    this.generateJavaDoc(it, appendable);
    final ITreeAppendable tracedAppendable = appendable.trace(it);
    this.generateAnnotations(it, tracedAppendable, true);
    this.generateModifier(it, tracedAppendable);
    JvmTypeReference _returnType = it.getReturnType();
    this._errorSafeExtensions.serializeSafely(_returnType, "Object", tracedAppendable);
    tracedAppendable.append(" ");
    ITreeAppendable _traceSignificant = this._treeAppendableUtil.traceSignificant(tracedAppendable, it);
    String _simpleName = it.getSimpleName();
    _traceSignificant.append(_simpleName);
    tracedAppendable.append("()");
    this.generateDefaultExpression(it, tracedAppendable);
    tracedAppendable.append(";");
    appendable.decreaseIndentation();
    appendable.closeScope();
  }
  
  public void generateDefaultExpression(final JvmOperation it, final ITreeAppendable appendable) {
    Procedure1<? super ITreeAppendable> _compilationStrategy = this._jvmTypeExtensions.getCompilationStrategy(it);
    boolean _notEquals = ObjectExtensions.operator_notEquals(_compilationStrategy, null);
    if (_notEquals) {
      appendable.append(" default ");
      appendable.increaseIndentation();
      Procedure1<? super ITreeAppendable> _compilationStrategy_1 = this._jvmTypeExtensions.getCompilationStrategy(it);
      _compilationStrategy_1.apply(appendable);
      appendable.decreaseIndentation();
    } else {
      final XExpression expression = this._iLogicalContainerProvider.getAssociatedExpression(it);
      boolean _notEquals_1 = ObjectExtensions.operator_notEquals(expression, null);
      if (_notEquals_1) {
        boolean _hasErrors = this._errorSafeExtensions.hasErrors(expression, true);
        if (_hasErrors) {
          appendable.append("/* skipped default expression with errors */");
        } else {
          appendable.append(" default ");
          JvmTypeReference _returnType = it.getReturnType();
          this.compiler.compileAsJavaExpression(expression, appendable, _returnType);
        }
      }
    }
  }
  
  protected ITreeAppendable _generateModifier(final JvmDeclaredType it, final ITreeAppendable appendable) {
    ITreeAppendable _xblockexpression = null;
    {
      JvmVisibility _visibility = it.getVisibility();
      String _javaName = this.javaName(_visibility);
      appendable.append(_javaName);
      boolean _isAbstract = it.isAbstract();
      if (_isAbstract) {
        appendable.append("abstract ");
      }
      boolean _isStatic = it.isStatic();
      if (_isStatic) {
        appendable.append("static ");
      }
      ITreeAppendable _xifexpression = null;
      boolean _isFinal = it.isFinal();
      if (_isFinal) {
        ITreeAppendable _append = appendable.append("final ");
        _xifexpression = _append;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  protected ITreeAppendable _generateModifier(final JvmField it, final ITreeAppendable appendable) {
    ITreeAppendable _xblockexpression = null;
    {
      JvmVisibility _visibility = it.getVisibility();
      String _javaName = this.javaName(_visibility);
      appendable.append(_javaName);
      boolean _isFinal = it.isFinal();
      if (_isFinal) {
        appendable.append("final ");
      }
      ITreeAppendable _xifexpression = null;
      boolean _isStatic = it.isStatic();
      if (_isStatic) {
        ITreeAppendable _append = appendable.append("static ");
        _xifexpression = _append;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  protected ITreeAppendable _generateModifier(final JvmOperation it, final ITreeAppendable appendable) {
    ITreeAppendable _xblockexpression = null;
    {
      JvmVisibility _visibility = it.getVisibility();
      String _javaName = this.javaName(_visibility);
      appendable.append(_javaName);
      boolean _isAbstract = it.isAbstract();
      if (_isAbstract) {
        appendable.append("abstract ");
      }
      boolean _isStatic = it.isStatic();
      if (_isStatic) {
        appendable.append("static ");
      }
      ITreeAppendable _xifexpression = null;
      boolean _isFinal = it.isFinal();
      if (_isFinal) {
        ITreeAppendable _append = appendable.append("final ");
        _xifexpression = _append;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  protected ITreeAppendable _generateModifier(final JvmConstructor it, final ITreeAppendable appendable) {
    JvmVisibility _visibility = it.getVisibility();
    String _javaName = this.javaName(_visibility);
    ITreeAppendable _append = appendable.append(_javaName);
    return _append;
  }
  
  /**
   * Returns the visibility modifier and a space as suffix if not empty
   */
  public String javaName(final JvmVisibility visibility) {
    boolean _notEquals = ObjectExtensions.operator_notEquals(visibility, null);
    if (_notEquals) {
      String _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        if (Objects.equal(visibility,JvmVisibility.PRIVATE)) {
          _matched=true;
          _switchResult = "private ";
        }
      }
      if (!_matched) {
        if (Objects.equal(visibility,JvmVisibility.PUBLIC)) {
          _matched=true;
          _switchResult = "public ";
        }
      }
      if (!_matched) {
        if (Objects.equal(visibility,JvmVisibility.PROTECTED)) {
          _matched=true;
          _switchResult = "protected ";
        }
      }
      if (!_matched) {
        if (Objects.equal(visibility,JvmVisibility.DEFAULT)) {
          _matched=true;
          _switchResult = "";
        }
      }
      return _switchResult;
    } else {
      return "";
    }
  }
  
  public void generateExtendsClause(final JvmDeclaredType it, final ITreeAppendable appendable) {
    boolean _and = false;
    if (!(it instanceof JvmGenericType)) {
      _and = false;
    } else {
      boolean _isInterface = ((JvmGenericType) it).isInterface();
      _and = ((it instanceof JvmGenericType) && _isInterface);
    }
    if (_and) {
      EList<JvmTypeReference> _superTypes = it.getSuperTypes();
      final Procedure1<LoopParams> _function = new Procedure1<LoopParams>() {
          public void apply(final LoopParams it) {
            it.setPrefix("extends ");
            it.setSeparator(", ");
            it.setSuffix(" ");
          }
        };
      final Procedure2<JvmTypeReference,ITreeAppendable> _function_1 = new Procedure2<JvmTypeReference,ITreeAppendable>() {
          public void apply(final JvmTypeReference it, final ITreeAppendable app) {
            JvmModelGenerator.this._errorSafeExtensions.serializeSafely(it, app);
          }
        };
      this._errorSafeExtensions.<JvmTypeReference>forEachSafely(appendable, _superTypes, _function, _function_1);
    } else {
      EList<JvmTypeReference> _superTypes_1 = it.getSuperTypes();
      final Function1<JvmTypeReference,Boolean> _function_2 = new Function1<JvmTypeReference,Boolean>() {
          public Boolean apply(final JvmTypeReference typeRef) {
            String _identifier = typeRef.getIdentifier();
            boolean _notEquals = ObjectExtensions.operator_notEquals(_identifier, "java.lang.Object");
            return Boolean.valueOf(_notEquals);
          }
        };
      final Iterable<JvmTypeReference> withoutObject = IterableExtensions.<JvmTypeReference>filter(_superTypes_1, _function_2);
      final Function1<JvmTypeReference,Boolean> _function_3 = new Function1<JvmTypeReference,Boolean>() {
          public Boolean apply(final JvmTypeReference typeRef) {
            boolean _and = false;
            JvmType _type = typeRef.getType();
            if (!(_type instanceof JvmGenericType)) {
              _and = false;
            } else {
              JvmType _type_1 = typeRef.getType();
              boolean _isInterface = ((JvmGenericType) _type_1).isInterface();
              boolean _not = (!_isInterface);
              _and = ((_type instanceof JvmGenericType) && _not);
            }
            return Boolean.valueOf(_and);
          }
        };
      Iterable<JvmTypeReference> _filter = IterableExtensions.<JvmTypeReference>filter(withoutObject, _function_3);
      final JvmTypeReference superClazz = IterableExtensions.<JvmTypeReference>head(_filter);
      final Function1<JvmTypeReference,Boolean> _function_4 = new Function1<JvmTypeReference,Boolean>() {
          public Boolean apply(final JvmTypeReference typeRef) {
            boolean _notEquals = ObjectExtensions.operator_notEquals(typeRef, superClazz);
            return Boolean.valueOf(_notEquals);
          }
        };
      final Iterable<JvmTypeReference> superInterfaces = IterableExtensions.<JvmTypeReference>filter(withoutObject, _function_4);
      boolean _notEquals = ObjectExtensions.operator_notEquals(superClazz, null);
      if (_notEquals) {
        final boolean hasErrors = this._errorSafeExtensions.hasErrors(superClazz, true);
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
      final Procedure1<LoopParams> _function_5 = new Procedure1<LoopParams>() {
          public void apply(final LoopParams it) {
            it.setPrefix("implements ");
            it.setSeparator(", ");
            it.setSuffix(" ");
          }
        };
      final Procedure2<JvmTypeReference,ITreeAppendable> _function_6 = new Procedure2<JvmTypeReference,ITreeAppendable>() {
          public void apply(final JvmTypeReference it, final ITreeAppendable app) {
            JvmModelGenerator.this._errorSafeExtensions.serializeSafely(it, app);
          }
        };
      this._errorSafeExtensions.<JvmTypeReference>forEachSafely(appendable, superInterfaces, _function_5, _function_6);
    }
  }
  
  protected ITreeAppendable _generateMember(final JvmMember it, final ITreeAppendable appendable) {
    Class<? extends Object> _class = it==null?(Class<? extends Object>)null:it.getClass();
    String _name = _class==null?(String)null:_class.getName();
    String _plus = ("generateMember not implemented for elements of type " + _name);
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException(_plus);
    throw _unsupportedOperationException;
  }
  
  protected ITreeAppendable _generateMember(final JvmGenericType it, final ITreeAppendable appendable) {
    ITreeAppendable _xblockexpression = null;
    {
      appendable.newLine();
      ITreeAppendable _generateBody = this.generateBody(it, appendable);
      _xblockexpression = (_generateBody);
    }
    return _xblockexpression;
  }
  
  protected ITreeAppendable _generateMember(final JvmField it, final ITreeAppendable appendable) {
    ITreeAppendable _xblockexpression = null;
    {
      appendable.newLine();
      this.generateJavaDoc(it, appendable);
      final ITreeAppendable tracedAppendable = appendable.trace(it);
      this.generateAnnotations(it, tracedAppendable, true);
      this.generateModifier(it, tracedAppendable);
      JvmTypeReference _type = it.getType();
      this._errorSafeExtensions.serializeSafely(_type, "Object", tracedAppendable);
      tracedAppendable.append(" ");
      ITreeAppendable _traceSignificant = this._treeAppendableUtil.traceSignificant(tracedAppendable, it);
      String _simpleName = it.getSimpleName();
      _traceSignificant.append(_simpleName);
      this.generateInitialization(it, tracedAppendable);
      ITreeAppendable _append = tracedAppendable.append(";");
      _xblockexpression = (_append);
    }
    return _xblockexpression;
  }
  
  protected ITreeAppendable _generateMember(final JvmOperation it, final ITreeAppendable appendable) {
    ITreeAppendable _xblockexpression = null;
    {
      appendable.newLine();
      appendable.openScope();
      this.generateJavaDoc(it, appendable);
      final ITreeAppendable tracedAppendable = appendable.trace(it);
      this.generateAnnotations(it, tracedAppendable, true);
      this.generateModifier(it, tracedAppendable);
      this.generateTypeParameterDeclaration(it, tracedAppendable);
      JvmTypeReference _returnType = it.getReturnType();
      boolean _equals = ObjectExtensions.operator_equals(_returnType, null);
      if (_equals) {
        tracedAppendable.append("void");
      } else {
        JvmTypeReference _returnType_1 = it.getReturnType();
        this._errorSafeExtensions.serializeSafely(_returnType_1, "Object", tracedAppendable);
      }
      tracedAppendable.append(" ");
      ITreeAppendable _traceSignificant = this._treeAppendableUtil.traceSignificant(tracedAppendable, it);
      String _simpleName = it.getSimpleName();
      _traceSignificant.append(_simpleName);
      tracedAppendable.append("(");
      this.generateParameters(it, tracedAppendable);
      tracedAppendable.append(")");
      this.generateThrowsClause(it, tracedAppendable);
      boolean _or = false;
      boolean _isAbstract = it.isAbstract();
      if (_isAbstract) {
        _or = true;
      } else {
        boolean _hasBody = this.hasBody(it);
        boolean _not = (!_hasBody);
        _or = (_isAbstract || _not);
      }
      if (_or) {
        tracedAppendable.append(";");
      } else {
        tracedAppendable.append(" ");
        this.generateExecutableBody(it, tracedAppendable);
      }
      appendable.closeScope();
      _xblockexpression = (appendable);
    }
    return _xblockexpression;
  }
  
  protected ITreeAppendable _generateMember(final JvmConstructor it, final ITreeAppendable appendable) {
    ITreeAppendable _xblockexpression = null;
    {
      appendable.newLine();
      appendable.openScope();
      this.generateJavaDoc(it, appendable);
      final ITreeAppendable tracedAppendable = appendable.trace(it);
      this.generateAnnotations(it, tracedAppendable, true);
      this.generateModifier(it, tracedAppendable);
      this.generateTypeParameterDeclaration(it, tracedAppendable);
      ITreeAppendable _traceSignificant = this._treeAppendableUtil.traceSignificant(tracedAppendable, it);
      String _simpleName = it.getSimpleName();
      _traceSignificant.append(_simpleName);
      tracedAppendable.append("(");
      this.generateParameters(it, tracedAppendable);
      tracedAppendable.append(")");
      this.generateThrowsClause(it, tracedAppendable);
      tracedAppendable.append(" ");
      this.generateExecutableBody(it, tracedAppendable);
      appendable.closeScope();
      _xblockexpression = (appendable);
    }
    return _xblockexpression;
  }
  
  public void generateInitialization(final JvmField it, final ITreeAppendable appendable) {
    Procedure1<? super ITreeAppendable> _compilationStrategy = this._jvmTypeExtensions.getCompilationStrategy(it);
    boolean _notEquals = ObjectExtensions.operator_notEquals(_compilationStrategy, null);
    if (_notEquals) {
      appendable.append(" = ");
      appendable.increaseIndentation();
      Procedure1<? super ITreeAppendable> _compilationStrategy_1 = this._jvmTypeExtensions.getCompilationStrategy(it);
      _compilationStrategy_1.apply(appendable);
      appendable.decreaseIndentation();
    } else {
      final XExpression expression = this._iLogicalContainerProvider.getAssociatedExpression(it);
      boolean _notEquals_1 = ObjectExtensions.operator_notEquals(expression, null);
      if (_notEquals_1) {
        boolean _hasErrors = this._errorSafeExtensions.hasErrors(expression, true);
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
  
  public void generateTypeParameterDeclaration(final JvmTypeParameterDeclarator it, final ITreeAppendable appendable) {
    EList<JvmTypeParameter> _typeParameters = it.getTypeParameters();
    final Procedure1<LoopParams> _function = new Procedure1<LoopParams>() {
        public void apply(final LoopParams it) {
          it.setPrefix("<");
          it.setSeparator(", ");
          it.setSuffix("> ");
        }
      };
    final Procedure1<JvmTypeParameter> _function_1 = new Procedure1<JvmTypeParameter>() {
        public void apply(final JvmTypeParameter it) {
          JvmModelGenerator.this.generateTypeParameterDeclaration(it, appendable);
        }
      };
    this._loopExtensions.<JvmTypeParameter>forEach(appendable, _typeParameters, _function, _function_1);
  }
  
  public void generateTypeParameterDeclaration(final JvmTypeParameter it, final ITreeAppendable appendable) {
    final ITreeAppendable tracedAppendable = appendable.trace(it);
    ITreeAppendable _traceSignificant = this._treeAppendableUtil.traceSignificant(tracedAppendable, it);
    String _name = it.getName();
    _traceSignificant.append(_name);
    this.generateTypeParameterConstraints(it, tracedAppendable);
  }
  
  public void generateTypeParameterConstraints(final JvmTypeParameter it, final ITreeAppendable appendable) {
    EList<JvmTypeConstraint> _constraints = it.getConstraints();
    final Iterable<JvmUpperBound> upperBounds = Iterables.<JvmUpperBound>filter(_constraints, JvmUpperBound.class);
    final Procedure1<LoopParams> _function = new Procedure1<LoopParams>() {
        public void apply(final LoopParams it) {
          it.setPrefix(" extends ");
          it.setSeparator(" & ");
        }
      };
    final Procedure2<JvmUpperBound,ITreeAppendable> _function_1 = new Procedure2<JvmUpperBound,ITreeAppendable>() {
        public void apply(final JvmUpperBound it, final ITreeAppendable app) {
          JvmTypeReference _typeReference = it.getTypeReference();
          JvmModelGenerator.this._errorSafeExtensions.serializeSafely(_typeReference, app);
        }
      };
    this._errorSafeExtensions.<JvmUpperBound>forEachSafely(appendable, upperBounds, _function, _function_1);
  }
  
  public void generateThrowsClause(final JvmExecutable it, final ITreeAppendable appendable) {
    final LinkedHashMap<JvmType,JvmTypeReference> toBeGenerated = CollectionLiterals.<JvmType, JvmTypeReference>newLinkedHashMap();
    EList<JvmTypeReference> _exceptions = it.getExceptions();
    final Procedure1<JvmTypeReference> _function = new Procedure1<JvmTypeReference>() {
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
        public void apply(final LoopParams it) {
          it.setPrefix(" throws ");
          it.setSeparator(", ");
        }
      };
    final Procedure2<JvmTypeReference,ITreeAppendable> _function_2 = new Procedure2<JvmTypeReference,ITreeAppendable>() {
        public void apply(final JvmTypeReference it, final ITreeAppendable app) {
          ITreeAppendable _trace = app.trace(it);
          JvmType _type = it.getType();
          _trace.append(_type);
        }
      };
    this._errorSafeExtensions.<JvmTypeReference>forEachSafely(appendable, _values, _function_1, _function_2);
  }
  
  public void generateParameters(final JvmExecutable it, final ITreeAppendable appendable) {
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
          int _plus = ((i).intValue() + 1);
          EList<JvmFormalParameter> _parameters_2 = it.getParameters();
          int _size_1 = _parameters_2.size();
          final boolean last = (_plus == _size_1);
          EList<JvmFormalParameter> _parameters_3 = it.getParameters();
          final JvmFormalParameter p = _parameters_3.get((i).intValue());
          boolean _and = false;
          if (!last) {
            _and = false;
          } else {
            boolean _isVarArgs = it.isVarArgs();
            _and = (last && _isVarArgs);
          }
          this.generateParameter(p, appendable, _and);
          boolean _not_1 = (!last);
          if (_not_1) {
            appendable.append(", ");
          }
        }
      }
    }
  }
  
  public void generateParameter(final JvmFormalParameter it, final ITreeAppendable appendable, final boolean vararg) {
    final ITreeAppendable tracedAppendable = appendable.trace(it);
    this.generateAnnotations(it, tracedAppendable, false);
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
  
  public boolean hasBody(final JvmExecutable op) {
    boolean _or = false;
    Procedure1<? super ITreeAppendable> _compilationStrategy = this._jvmTypeExtensions.getCompilationStrategy(op);
    boolean _notEquals = ObjectExtensions.operator_notEquals(_compilationStrategy, null);
    if (_notEquals) {
      _or = true;
    } else {
      XExpression _associatedExpression = this._iLogicalContainerProvider.getAssociatedExpression(op);
      boolean _notEquals_1 = ObjectExtensions.operator_notEquals(_associatedExpression, null);
      _or = (_notEquals || _notEquals_1);
    }
    return _or;
  }
  
  public void generateExecutableBody(final JvmExecutable op, final ITreeAppendable appendable) {
    Procedure1<? super ITreeAppendable> _compilationStrategy = this._jvmTypeExtensions.getCompilationStrategy(op);
    boolean _notEquals = ObjectExtensions.operator_notEquals(_compilationStrategy, null);
    if (_notEquals) {
      final Iterable<Issue> errors = this._errorSafeExtensions.getErrors(op, true);
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
      final XExpression expression = this._iLogicalContainerProvider.getAssociatedExpression(op);
      boolean _notEquals_1 = ObjectExtensions.operator_notEquals(expression, null);
      if (_notEquals_1) {
        final Iterable<Issue> errors_1 = this._errorSafeExtensions.getErrors(expression, true);
        boolean _isEmpty_1 = IterableExtensions.isEmpty(errors_1);
        if (_isEmpty_1) {
          JvmTypeReference _switchResult = null;
          boolean _matched = false;
          if (!_matched) {
            if (op instanceof JvmOperation) {
              final JvmOperation _jvmOperation = (JvmOperation)op;
              _matched=true;
              JvmTypeReference _returnType = _jvmOperation.getReturnType();
              _switchResult = _returnType;
            }
          }
          if (!_matched) {
            if (op instanceof JvmConstructor) {
              final JvmConstructor _jvmConstructor = (JvmConstructor)op;
              _matched=true;
              JvmTypeReference _typeForName = this._typeReferences.getTypeForName(Void.TYPE, _jvmConstructor);
              _switchResult = _typeForName;
            }
          }
          if (!_matched) {
            _switchResult = null;
          }
          final JvmTypeReference returnType = _switchResult;
          boolean _and = false;
          boolean _and_1 = false;
          if (!(expression instanceof XBlockExpression)) {
            _and_1 = false;
          } else {
            EList<XExpression> _expressions = ((XBlockExpression) expression).getExpressions();
            int _size = _expressions.size();
            boolean _notEquals_2 = (_size != 1);
            _and_1 = ((expression instanceof XBlockExpression) && _notEquals_2);
          }
          if (!_and_1) {
            _and = false;
          } else {
            _and = (_and_1 && (returnType instanceof JvmVoid));
          }
          if (_and) {
            final XBlockExpression block = ((XBlockExpression) expression);
            EList<XExpression> _expressions_1 = block.getExpressions();
            boolean _isEmpty_2 = _expressions_1.isEmpty();
            if (_isEmpty_2) {
              appendable.append("{}");
            } else {
              EList<JvmTypeReference> _exceptions = op.getExceptions();
              Set<JvmTypeReference> _set = IterableExtensions.<JvmTypeReference>toSet(_exceptions);
              this.compiler.compile(expression, appendable, returnType, _set);
            }
          } else {
            ITreeAppendable _append_1 = appendable.append("{");
            _append_1.increaseIndentation();
            EList<JvmTypeReference> _exceptions_1 = op.getExceptions();
            Set<JvmTypeReference> _set_1 = IterableExtensions.<JvmTypeReference>toSet(_exceptions_1);
            this.compiler.compile(expression, appendable, returnType, _set_1);
            ITreeAppendable _decreaseIndentation_1 = appendable.decreaseIndentation();
            ITreeAppendable _newLine_1 = _decreaseIndentation_1.newLine();
            _newLine_1.append("}");
          }
        } else {
          this.generateBodyWithIssues(appendable, errors_1);
        }
      } else {
        if ((op instanceof JvmOperation)) {
          ITreeAppendable _increaseIndentation_1 = appendable.increaseIndentation();
          ITreeAppendable _append_2 = _increaseIndentation_1.append("{");
          _append_2.newLine();
          appendable.append("throw new UnsupportedOperationException(\"");
          String _simpleName = op.getSimpleName();
          appendable.append(_simpleName);
          appendable.append(" is not implemented\");");
          ITreeAppendable _decreaseIndentation_2 = appendable.decreaseIndentation();
          ITreeAppendable _newLine_2 = _decreaseIndentation_2.newLine();
          _newLine_2.append("}");
        } else {
          if ((op instanceof JvmConstructor)) {
            ITreeAppendable _append_3 = appendable.append("{");
            ITreeAppendable _newLine_3 = _append_3.newLine();
            _newLine_3.append("}");
          }
        }
      }
    }
  }
  
  public ITreeAppendable generateBodyWithIssues(final ITreeAppendable appendable, final Iterable<Issue> errors) {
    ITreeAppendable _xblockexpression = null;
    {
      ITreeAppendable _append = appendable.append("{");
      ITreeAppendable _increaseIndentation = _append.increaseIndentation();
      ITreeAppendable _newLine = _increaseIndentation.newLine();
      _newLine.append("throw new Error(\"Unresolved compilation problems\"");
      appendable.increaseIndentation();
      final Procedure1<Issue> _function = new Procedure1<Issue>() {
          public void apply(final Issue it) {
            ITreeAppendable _newLine = appendable.newLine();
            ITreeAppendable _append = _newLine.append("+ \"");
            String _message = it.getMessage();
            String _convertToJavaString = Strings.convertToJavaString(_message);
            ITreeAppendable _append_1 = _append.append(_convertToJavaString);
            _append_1.append("\"");
          }
        };
      IterableExtensions.<Issue>forEach(errors, _function);
      ITreeAppendable _append_1 = appendable.append(");");
      ITreeAppendable _decreaseIndentation = _append_1.decreaseIndentation();
      ITreeAppendable _decreaseIndentation_1 = _decreaseIndentation.decreaseIndentation();
      ITreeAppendable _newLine_1 = _decreaseIndentation_1.newLine();
      ITreeAppendable _append_2 = _newLine_1.append("}");
      _xblockexpression = (_append_2);
    }
    return _xblockexpression;
  }
  
  public void generateFileHeader(final JvmDeclaredType it, final ITreeAppendable appendable) {
    EList<Adapter> _eAdapters = it.eAdapters();
    Iterable<FileHeaderAdapter> _filter = Iterables.<FileHeaderAdapter>filter(_eAdapters, FileHeaderAdapter.class);
    final FileHeaderAdapter fileHeaderAdapter = IterableExtensions.<FileHeaderAdapter>head(_filter);
    String _headerText = fileHeaderAdapter==null?(String)null:fileHeaderAdapter.getHeaderText();
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_headerText);
    boolean _not = (!_isNullOrEmpty);
    if (_not) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("/**");
      final StringConcatenation text = ((StringConcatenation) _builder);
      text.newLine();
      text.append(" * ");
      String _headerText_1 = fileHeaderAdapter.getHeaderText();
      text.append(_headerText_1, " * ");
      text.newLine();
      text.append(" */");
      String _string = text.toString();
      ITreeAppendable _append = appendable.append(_string);
      _append.newLine();
    }
  }
  
  public void generateJavaDoc(final EObject it, final ITreeAppendable appendable) {
    EList<Adapter> _eAdapters = it.eAdapters();
    Iterable<DocumentationAdapter> _filter = Iterables.<DocumentationAdapter>filter(_eAdapters, DocumentationAdapter.class);
    final DocumentationAdapter adapter = IterableExtensions.<DocumentationAdapter>head(_filter);
    String _documentation = adapter==null?(String)null:adapter.getDocumentation();
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_documentation);
    boolean _not = (!_isNullOrEmpty);
    if (_not) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("/**");
      final StringConcatenation doc = ((StringConcatenation) _builder);
      doc.newLine();
      doc.append(" * ");
      String _documentation_1 = adapter.getDocumentation();
      doc.append(_documentation_1, " * ");
      doc.newLine();
      doc.append(" */");
      final Set<EObject> sourceElements = this.jvmModelAssociations.getSourceElements(it);
      boolean _and = false;
      int _size = sourceElements.size();
      boolean _equals = (_size == 1);
      if (!_equals) {
        _and = false;
      } else {
        _and = (_equals && (this.documentationProvider instanceof IEObjectDocumentationProviderExtension));
      }
      if (_and) {
        EObject _head = IterableExtensions.<EObject>head(sourceElements);
        final List<INode> documentationNodes = ((IEObjectDocumentationProviderExtension) this.documentationProvider).getDocumentationNodes(_head);
        boolean _isEmpty = documentationNodes.isEmpty();
        boolean _not_1 = (!_isEmpty);
        if (_not_1) {
          ITextRegionWithLineInformation documentationTrace = ITextRegionWithLineInformation.EMPTY_REGION;
          for (final INode node : documentationNodes) {
            int _offset = node.getOffset();
            int _length = node.getLength();
            int _startLine = node.getStartLine();
            int _endLine = node.getEndLine();
            TextRegionWithLineInformation _textRegionWithLineInformation = new TextRegionWithLineInformation(_offset, _length, _startLine, _endLine);
            ITextRegionWithLineInformation _merge = documentationTrace.merge(_textRegionWithLineInformation);
            documentationTrace = _merge;
          }
          LocationData _locationData = new LocationData(documentationTrace, null, null);
          ITreeAppendable _trace = appendable.trace(_locationData);
          String _string = doc.toString();
          _trace.append(_string);
          appendable.newLine();
          return;
        }
      }
      String _string_1 = doc.toString();
      ITreeAppendable _append = appendable.append(_string_1);
      _append.newLine();
    }
  }
  
  public void generateAnnotations(final JvmAnnotationTarget it, final ITreeAppendable appendable, final boolean withLineBreak) {
    final Function1<ITreeAppendable,ITreeAppendable> _function = new Function1<ITreeAppendable,ITreeAppendable>() {
        public ITreeAppendable apply(final ITreeAppendable it) {
          ITreeAppendable _xifexpression = null;
          if (withLineBreak) {
            ITreeAppendable _newLine = it.newLine();
            _xifexpression = _newLine;
          } else {
            ITreeAppendable _append = it.append(" ");
            _xifexpression = _append;
          }
          return _xifexpression;
        }
      };
    final Function1<ITreeAppendable,ITreeAppendable> sep = _function;
    EList<JvmAnnotationReference> _annotations = it.getAnnotations();
    final Procedure1<LoopParams> _function_1 = new Procedure1<LoopParams>() {
        public void apply(final LoopParams it) {
          it.setSeparator(sep);
          it.setSuffix(sep);
        }
      };
    final Procedure2<JvmAnnotationReference,ITreeAppendable> _function_2 = new Procedure2<JvmAnnotationReference,ITreeAppendable>() {
        public void apply(final JvmAnnotationReference it, final ITreeAppendable app) {
          JvmModelGenerator.this.generateAnnotation(it, app);
        }
      };
    this._errorSafeExtensions.<JvmAnnotationReference>forEachSafely(appendable, _annotations, _function_1, _function_2);
  }
  
  public void generateAnnotations(final JvmAnnotationAnnotationValue it, final ITreeAppendable appendable, final boolean withLineBreak) {
    EList<JvmAnnotationReference> _annotations = it.getAnnotations();
    final Procedure1<LoopParams> _function = new Procedure1<LoopParams>() {
        public void apply(final LoopParams it) {
          final Function1<ITreeAppendable,ITreeAppendable> _function = new Function1<ITreeAppendable,ITreeAppendable>() {
              public ITreeAppendable apply(final ITreeAppendable it) {
                ITreeAppendable _xifexpression = null;
                if (withLineBreak) {
                  ITreeAppendable _append = it.append(",");
                  ITreeAppendable _newLine = _append.newLine();
                  _xifexpression = _newLine;
                } else {
                  ITreeAppendable _append_1 = it.append(", ");
                  _xifexpression = _append_1;
                }
                return _xifexpression;
              }
            };
          it.setSeparator(_function);
          final Function1<ITreeAppendable,ITreeAppendable> _function_1 = new Function1<ITreeAppendable,ITreeAppendable>() {
              public ITreeAppendable apply(final ITreeAppendable it) {
                ITreeAppendable _xifexpression = null;
                if (withLineBreak) {
                  ITreeAppendable _newLine = it.newLine();
                  _xifexpression = _newLine;
                }
                return _xifexpression;
              }
            };
          it.setSuffix(_function_1);
        }
      };
    final Procedure2<JvmAnnotationReference,ITreeAppendable> _function_1 = new Procedure2<JvmAnnotationReference,ITreeAppendable>() {
        public void apply(final JvmAnnotationReference it, final ITreeAppendable app) {
          JvmModelGenerator.this.generateAnnotation(it, app);
        }
      };
    this._errorSafeExtensions.<JvmAnnotationReference>forEachSafely(appendable, _annotations, _function, _function_1);
  }
  
  public void generateAnnotation(final JvmAnnotationReference it, final ITreeAppendable appendable) {
    appendable.append("@");
    JvmAnnotationType _annotation = it.getAnnotation();
    appendable.append(_annotation);
    EList<JvmAnnotationValue> _values = it.getValues();
    final Procedure1<LoopParams> _function = new Procedure1<LoopParams>() {
        public void apply(final LoopParams it) {
          it.setPrefix("(");
          it.setSeparator(", ");
          it.setSuffix(")");
        }
      };
    final Procedure1<JvmAnnotationValue> _function_1 = new Procedure1<JvmAnnotationValue>() {
        public void apply(final JvmAnnotationValue it) {
          JvmModelGenerator.this.toJava(it, appendable);
        }
      };
    this._loopExtensions.<JvmAnnotationValue>forEach(appendable, _values, _function, _function_1);
  }
  
  public void toJava(final JvmAnnotationValue it, final ITreeAppendable appendable) {
    JvmOperation _operation = it.getOperation();
    boolean _notEquals = ObjectExtensions.operator_notEquals(_operation, null);
    if (_notEquals) {
      JvmOperation _operation_1 = it.getOperation();
      String _simpleName = _operation_1.getSimpleName();
      appendable.append(_simpleName);
      appendable.append(" = ");
    }
    this.toJavaLiteral(it, appendable);
  }
  
  protected void _toJavaLiteral(final JvmAnnotationAnnotationValue value, final ITreeAppendable appendable) {
    EList<JvmAnnotationReference> _values = value.getValues();
    final Procedure1<JvmAnnotationReference> _function = new Procedure1<JvmAnnotationReference>() {
        public void apply(final JvmAnnotationReference it) {
          JvmModelGenerator.this.generateAnnotations(value, appendable, false);
        }
      };
    this._loopExtensions.<JvmAnnotationReference>forEachWithShortcut(appendable, _values, _function);
  }
  
  protected void _toJavaLiteral(final JvmShortAnnotationValue it, final ITreeAppendable appendable) {
    EList<Short> _values = it.getValues();
    final Procedure1<Short> _function = new Procedure1<Short>() {
        public void apply(final Short it) {
          it.toString();
        }
      };
    this._loopExtensions.<Short>forEachWithShortcut(appendable, _values, _function);
  }
  
  protected void _toJavaLiteral(final JvmIntAnnotationValue it, final ITreeAppendable appendable) {
    EList<Integer> _values = it.getValues();
    final Procedure1<Integer> _function = new Procedure1<Integer>() {
        public void apply(final Integer it) {
          it.toString();
        }
      };
    this._loopExtensions.<Integer>forEachWithShortcut(appendable, _values, _function);
  }
  
  protected void _toJavaLiteral(final JvmLongAnnotationValue it, final ITreeAppendable appendable) {
    EList<Long> _values = it.getValues();
    final Procedure1<Long> _function = new Procedure1<Long>() {
        public void apply(final Long it) {
          it.toString();
        }
      };
    this._loopExtensions.<Long>forEachWithShortcut(appendable, _values, _function);
  }
  
  protected void _toJavaLiteral(final JvmByteAnnotationValue it, final ITreeAppendable appendable) {
    EList<Byte> _values = it.getValues();
    final Procedure1<Byte> _function = new Procedure1<Byte>() {
        public void apply(final Byte it) {
          it.toString();
        }
      };
    this._loopExtensions.<Byte>forEachWithShortcut(appendable, _values, _function);
  }
  
  protected void _toJavaLiteral(final JvmDoubleAnnotationValue it, final ITreeAppendable appendable) {
    EList<Double> _values = it.getValues();
    final Procedure1<Double> _function = new Procedure1<Double>() {
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
            if (Objects.equal(it,Double.POSITIVE_INFINITY)) {
              _matched=true;
              _switchResult = "Double.POSITIVE_INFINITY";
            }
          }
          if (!_matched) {
            if (Objects.equal(it,Double.NEGATIVE_INFINITY)) {
              _matched=true;
              _switchResult = "Double.NEGATIVE_INFINITY";
            }
          }
          if (!_matched) {
            String _string = it.toString();
            String _plus = (_string + "d");
            _switchResult = _plus;
          }
          appendable.append(_switchResult);
        }
      };
    this._loopExtensions.<Double>forEachWithShortcut(appendable, _values, _function);
  }
  
  protected void _toJavaLiteral(final JvmFloatAnnotationValue it, final ITreeAppendable appendable) {
    EList<Float> _values = it.getValues();
    final Procedure1<Float> _function = new Procedure1<Float>() {
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
            if (Objects.equal(it,Float.POSITIVE_INFINITY)) {
              _matched=true;
              _switchResult = "Float.POSITIVE_INFINITY";
            }
          }
          if (!_matched) {
            if (Objects.equal(it,Float.NEGATIVE_INFINITY)) {
              _matched=true;
              _switchResult = "Float.NEGATIVE_INFINITY";
            }
          }
          if (!_matched) {
            String _string = it.toString();
            String _plus = (_string + "f");
            _switchResult = _plus;
          }
          appendable.append(_switchResult);
        }
      };
    this._loopExtensions.<Float>forEachWithShortcut(appendable, _values, _function);
  }
  
  protected void _toJavaLiteral(final JvmCharAnnotationValue it, final ITreeAppendable appendable) {
    EList<Character> _values = it.getValues();
    final Procedure1<Character> _function = new Procedure1<Character>() {
        public void apply(final Character it) {
          String _string = it.toString();
          String _convertToJavaString = Strings.convertToJavaString(_string, true);
          String _plus = ("\'" + _convertToJavaString);
          String _plus_1 = (_plus + "\'");
          appendable.append(_plus_1);
        }
      };
    this._loopExtensions.<Character>forEachWithShortcut(appendable, _values, _function);
  }
  
  protected void _toJavaLiteral(final JvmStringAnnotationValue it, final ITreeAppendable appendable) {
    EList<String> _values = it.getValues();
    final Procedure1<String> _function = new Procedure1<String>() {
        public void apply(final String it) {
          String _string = it.toString();
          String _convertToJavaString = Strings.convertToJavaString(_string, true);
          String _plus = ("\"" + _convertToJavaString);
          String _plus_1 = (_plus + "\"");
          appendable.append(_plus_1);
        }
      };
    this._loopExtensions.<String>forEachWithShortcut(appendable, _values, _function);
  }
  
  protected void _toJavaLiteral(final JvmTypeAnnotationValue it, final ITreeAppendable appendable) {
    EList<JvmTypeReference> _values = it.getValues();
    final Procedure1<JvmTypeReference> _function = new Procedure1<JvmTypeReference>() {
        public void apply(final JvmTypeReference it) {
          JvmType _type = it.getType();
          ITreeAppendable _append = appendable.append(_type);
          _append.append(".class");
        }
      };
    this._loopExtensions.<JvmTypeReference>forEachWithShortcut(appendable, _values, _function);
  }
  
  protected void _toJavaLiteral(final JvmEnumAnnotationValue it, final ITreeAppendable appendable) {
    EList<JvmEnumerationLiteral> _values = it.getValues();
    final Procedure1<JvmEnumerationLiteral> _function = new Procedure1<JvmEnumerationLiteral>() {
        public void apply(final JvmEnumerationLiteral it) {
          JvmDeclaredType _declaringType = it.getDeclaringType();
          appendable.append(_declaringType);
          appendable.append(".");
          String _simpleName = it.getSimpleName();
          appendable.append(_simpleName);
        }
      };
    this._loopExtensions.<JvmEnumerationLiteral>forEachWithShortcut(appendable, _values, _function);
  }
  
  protected void _toJavaLiteral(final JvmBooleanAnnotationValue it, final ITreeAppendable appendable) {
    EList<Boolean> _values = it.getValues();
    final Procedure1<Boolean> _function = new Procedure1<Boolean>() {
        public void apply(final Boolean it) {
          String _string = it.toString();
          appendable.append(_string);
        }
      };
    this._loopExtensions.<Boolean>forEachWithShortcut(appendable, _values, _function);
  }
  
  protected void _toJavaLiteral(final JvmCustomAnnotationValue it, final ITreeAppendable appendable) {
    EList<Object> _values = it.getValues();
    Iterable<XExpression> _filter = Iterables.<XExpression>filter(_values, XExpression.class);
    final Procedure1<XExpression> _function = new Procedure1<XExpression>() {
        public void apply(final XExpression it) {
          JvmModelGenerator.this.compiler.toJavaExpression(it, appendable);
        }
      };
    this._loopExtensions.<XExpression>forEachWithShortcut(appendable, _filter, _function);
  }
  
  public TreeAppendable createAppendable(final EObject context, final ImportManager importManager) {
    TreeAppendable _treeAppendable = new TreeAppendable(importManager, this.locationProvider, this.jvmModelAssociations, context, "  ", "\n");
    final TreeAppendable appendable = _treeAppendable;
    final JvmGenericType type = this.containerType(context);
    boolean _notEquals = ObjectExtensions.operator_notEquals(type, null);
    if (_notEquals) {
      JvmGenericType _containerType = this.containerType(context);
      appendable.declareVariable(_containerType, "this");
      JvmGenericType _containerType_1 = this.containerType(context);
      final JvmTypeReference superType = _containerType_1.getExtendedClass();
      boolean _notEquals_1 = ObjectExtensions.operator_notEquals(superType, null);
      if (_notEquals_1) {
        JvmType _type = superType.getType();
        appendable.declareVariable(_type, "super");
      }
    }
    return appendable;
  }
  
  public JvmGenericType containerType(final EObject context) {
    JvmGenericType _xifexpression = null;
    boolean _equals = ObjectExtensions.operator_equals(context, null);
    if (_equals) {
      _xifexpression = null;
    } else {
      JvmGenericType _xifexpression_1 = null;
      if ((context instanceof JvmGenericType)) {
        _xifexpression_1 = ((JvmGenericType) context);
      } else {
        EObject _eContainer = context.eContainer();
        JvmGenericType _containerType = this.containerType(_eContainer);
        _xifexpression_1 = _containerType;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  protected String makeJavaIdentifier(final String name) {
    String _xifexpression = null;
    boolean _isJavaKeyword = this.keywords.isJavaKeyword(name);
    if (_isJavaKeyword) {
      String _plus = (name + "_");
      _xifexpression = _plus;
    } else {
      _xifexpression = name;
    }
    return _xifexpression;
  }
  
  public Iterable<JvmMember> getMembersToBeCompiled(final JvmDeclaredType it) {
    EList<JvmMember> _members = it.getMembers();
    final Function1<JvmMember,Boolean> _function = new Function1<JvmMember,Boolean>() {
        public Boolean apply(final JvmMember it) {
          boolean _and = false;
          if (!(it instanceof JvmConstructor)) {
            _and = false;
          } else {
            boolean _isSingleSyntheticDefaultConstructor = JvmModelGenerator.this._jvmTypeExtensions.isSingleSyntheticDefaultConstructor(((JvmConstructor) it));
            _and = ((it instanceof JvmConstructor) && _isSingleSyntheticDefaultConstructor);
          }
          boolean _not = (!_and);
          return Boolean.valueOf(_not);
        }
      };
    Iterable<JvmMember> _filter = IterableExtensions.<JvmMember>filter(_members, _function);
    return _filter;
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
  
  public ITreeAppendable generateBody(final JvmDeclaredType it, final ITreeAppendable appendable) {
    if (it instanceof JvmAnnotationType) {
      return _generateBody((JvmAnnotationType)it, appendable);
    } else if (it instanceof JvmEnumerationType) {
      return _generateBody((JvmEnumerationType)it, appendable);
    } else if (it instanceof JvmGenericType) {
      return _generateBody((JvmGenericType)it, appendable);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, appendable).toString());
    }
  }
  
  public ITreeAppendable generateModifier(final JvmMember it, final ITreeAppendable appendable) {
    if (it instanceof JvmConstructor) {
      return _generateModifier((JvmConstructor)it, appendable);
    } else if (it instanceof JvmOperation) {
      return _generateModifier((JvmOperation)it, appendable);
    } else if (it instanceof JvmDeclaredType) {
      return _generateModifier((JvmDeclaredType)it, appendable);
    } else if (it instanceof JvmField) {
      return _generateModifier((JvmField)it, appendable);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, appendable).toString());
    }
  }
  
  public ITreeAppendable generateMember(final JvmMember it, final ITreeAppendable appendable) {
    if (it instanceof JvmConstructor) {
      return _generateMember((JvmConstructor)it, appendable);
    } else if (it instanceof JvmGenericType) {
      return _generateMember((JvmGenericType)it, appendable);
    } else if (it instanceof JvmOperation) {
      return _generateMember((JvmOperation)it, appendable);
    } else if (it instanceof JvmField) {
      return _generateMember((JvmField)it, appendable);
    } else if (it != null) {
      return _generateMember(it, appendable);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, appendable).toString());
    }
  }
  
  public void toJavaLiteral(final JvmAnnotationValue value, final ITreeAppendable appendable) {
    if (value instanceof JvmAnnotationAnnotationValue) {
      _toJavaLiteral((JvmAnnotationAnnotationValue)value, appendable);
      return;
    } else if (value instanceof JvmBooleanAnnotationValue) {
      _toJavaLiteral((JvmBooleanAnnotationValue)value, appendable);
      return;
    } else if (value instanceof JvmByteAnnotationValue) {
      _toJavaLiteral((JvmByteAnnotationValue)value, appendable);
      return;
    } else if (value instanceof JvmCharAnnotationValue) {
      _toJavaLiteral((JvmCharAnnotationValue)value, appendable);
      return;
    } else if (value instanceof JvmCustomAnnotationValue) {
      _toJavaLiteral((JvmCustomAnnotationValue)value, appendable);
      return;
    } else if (value instanceof JvmDoubleAnnotationValue) {
      _toJavaLiteral((JvmDoubleAnnotationValue)value, appendable);
      return;
    } else if (value instanceof JvmEnumAnnotationValue) {
      _toJavaLiteral((JvmEnumAnnotationValue)value, appendable);
      return;
    } else if (value instanceof JvmFloatAnnotationValue) {
      _toJavaLiteral((JvmFloatAnnotationValue)value, appendable);
      return;
    } else if (value instanceof JvmIntAnnotationValue) {
      _toJavaLiteral((JvmIntAnnotationValue)value, appendable);
      return;
    } else if (value instanceof JvmLongAnnotationValue) {
      _toJavaLiteral((JvmLongAnnotationValue)value, appendable);
      return;
    } else if (value instanceof JvmShortAnnotationValue) {
      _toJavaLiteral((JvmShortAnnotationValue)value, appendable);
      return;
    } else if (value instanceof JvmStringAnnotationValue) {
      _toJavaLiteral((JvmStringAnnotationValue)value, appendable);
      return;
    } else if (value instanceof JvmTypeAnnotationValue) {
      _toJavaLiteral((JvmTypeAnnotationValue)value, appendable);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(value, appendable).toString());
    }
  }
}
