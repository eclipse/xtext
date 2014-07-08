/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.compiler;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.core.compiler.MacroAwareStringConcatenation;
import org.eclipse.xtend.core.macro.ActiveAnnotationContext;
import org.eclipse.xtend.core.macro.ActiveAnnotationContexts;
import org.eclipse.xtend.core.macro.CodeGenerationContextImpl;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.xtend.AnonymousClass;
import org.eclipse.xtend.core.xtend.XtendAnnotationTarget;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.lib.macro.CodeGenerationParticipant;
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.NamedElement;
import org.eclipse.xtend.lib.macro.file.FileLocations;
import org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.GeneratorConfig;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.eclipse.xtext.xbase.compiler.LoopParams;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.compiler.output.ImportingStringConcatenation;
import org.eclipse.xtext.xbase.compiler.output.SharedAppendableState;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendGenerator extends JvmModelGenerator {
  private static class StopCollecting extends Exception {
  }
  
  public void doGenerate(final Resource input, final IFileSystemAccess fsa) {
    super.doGenerate(input, fsa);
    this.callMacroProcessors(input);
  }
  
  public void callMacroProcessors(final Resource input) {
    final ActiveAnnotationContexts ctxs = ActiveAnnotationContexts.find(input);
    boolean _equals = Objects.equal(ctxs, null);
    if (_equals) {
      return;
    }
    Map<JvmAnnotationType, ActiveAnnotationContext> _contexts = ctxs.getContexts();
    Collection<ActiveAnnotationContext> _values = _contexts.values();
    for (final ActiveAnnotationContext context : _values) {
      {
        CompilationUnitImpl _compilationUnit = context.getCompilationUnit();
        _compilationUnit.setModifyAllowed(false);
        try {
          Object _processorInstance = context.getProcessorInstance();
          final Object processor = _processorInstance;
          boolean _matched = false;
          if (!_matched) {
            if (processor instanceof CodeGenerationParticipant) {
              _matched=true;
              CodeGenerationContextImpl _codeGenerationContextImpl = new CodeGenerationContextImpl();
              final Procedure1<CodeGenerationContextImpl> _function = new Procedure1<CodeGenerationContextImpl>() {
                public void apply(final CodeGenerationContextImpl it) {
                  CompilationUnitImpl _compilationUnit = context.getCompilationUnit();
                  MutableFileSystemSupport _fileSystemSupport = _compilationUnit.getFileSystemSupport();
                  it.setFileSystemSupport(_fileSystemSupport);
                  CompilationUnitImpl _compilationUnit_1 = context.getCompilationUnit();
                  FileLocations _fileLocations = _compilationUnit_1.getFileLocations();
                  it.setFileLocations(_fileLocations);
                }
              };
              final CodeGenerationContextImpl codeGenServices = ObjectExtensions.<CodeGenerationContextImpl>operator_doubleArrow(_codeGenerationContextImpl, _function);
              List<XtendAnnotationTarget> _annotatedSourceElements = context.getAnnotatedSourceElements();
              final Function1<XtendAnnotationTarget, MemberDeclaration> _function_1 = new Function1<XtendAnnotationTarget, MemberDeclaration>() {
                public MemberDeclaration apply(final XtendAnnotationTarget it) {
                  CompilationUnitImpl _compilationUnit = context.getCompilationUnit();
                  return _compilationUnit.toXtendMemberDeclaration(((XtendMember) it));
                }
              };
              final List<MemberDeclaration> elements = ListExtensions.<XtendAnnotationTarget, MemberDeclaration>map(_annotatedSourceElements, _function_1);
              ((CodeGenerationParticipant<NamedElement>)processor).doGenerateCode(elements, codeGenServices);
            }
          }
        } catch (final Throwable _t) {
          if (_t instanceof Throwable) {
            final Throwable t = (Throwable)_t;
            context.handleProcessingError(input, t);
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
    }
  }
  
  protected ImportingStringConcatenation createImportingStringConcatenation(final SharedAppendableState state, final ITypeReferenceOwner owner) {
    return new MacroAwareStringConcatenation(state, owner);
  }
  
  /**
   * Convert a given input string to a Java string.
   * 
   * Unicode escaping is handled by the {@link UnicodeAwarePostProcessor}.
   */
  public String doConvertToJavaString(final String input) {
    return Strings.convertToJavaString(input, false);
  }
  
  protected Iterable<JvmMember> _getMembersToBeCompiled(final JvmGenericType it) {
    Iterable<JvmMember> _xifexpression = null;
    boolean _isLocal = it.isLocal();
    if (_isLocal) {
      EList<JvmMember> _members = it.getMembers();
      final Function1<JvmMember, Boolean> _function = new Function1<JvmMember, Boolean>() {
        public Boolean apply(final JvmMember it) {
          return Boolean.valueOf((it instanceof JvmOperation));
        }
      };
      _xifexpression = IterableExtensions.<JvmMember>filter(_members, _function);
    } else {
      _xifexpression = this._getMembersToBeCompiled(((JvmDeclaredType) it));
    }
    return _xifexpression;
  }
  
  protected ArrayList<JvmMember> getAddedDeclarations(final JvmGenericType it, final AnonymousClass anonymousClass) {
    final ArrayList<JvmMember> result = CollectionLiterals.<JvmMember>newArrayList();
    XConstructorCall _constructorCall = anonymousClass.getConstructorCall();
    final JvmConstructor constructor = _constructorCall.getConstructor();
    EList<JvmFormalParameter> _parameters = constructor.getParameters();
    int _size = _parameters.size();
    boolean _greaterEqualsThan = (_size >= 1);
    if (_greaterEqualsThan) {
      result.add(0, constructor);
    }
    Iterable<JvmField> _declaredFields = it.getDeclaredFields();
    Iterables.<JvmMember>addAll(result, _declaredFields);
    Iterable<JvmOperation> _declaredOperations = it.getDeclaredOperations();
    final Function1<JvmOperation, Boolean> _function = new Function1<JvmOperation, Boolean>() {
      public Boolean apply(final JvmOperation it) {
        Set<EObject> _sourceElements = XtendGenerator.this.getSourceElements(it);
        EObject _head = IterableExtensions.<EObject>head(_sourceElements);
        final XtendFunction function = ((XtendFunction) _head);
        boolean _isOverride = function.isOverride();
        return Boolean.valueOf((!_isOverride));
      }
    };
    Iterable<JvmOperation> _filter = IterableExtensions.<JvmOperation>filter(_declaredOperations, _function);
    Iterables.<JvmMember>addAll(result, _filter);
    EList<JvmMember> _members = it.getMembers();
    Iterable<JvmDeclaredType> _filter_1 = Iterables.<JvmDeclaredType>filter(_members, JvmDeclaredType.class);
    Iterables.<JvmMember>addAll(result, _filter_1);
    return result;
  }
  
  public ITreeAppendable compile(final JvmExecutable executable, final XExpression expression, final JvmTypeReference returnType, final ITreeAppendable appendable, final GeneratorConfig config) {
    ITreeAppendable _xblockexpression = null;
    {
      this.compileLocalTypeStubs(executable, appendable, config);
      _xblockexpression = super.compile(executable, expression, returnType, appendable, config);
    }
    return _xblockexpression;
  }
  
  public String reassignThisType(final ITreeAppendable b, final JvmDeclaredType declaredType) {
    String _xifexpression = null;
    boolean _hasObject = b.hasObject("this");
    if (_hasObject) {
      String _xblockexpression = null;
      {
        final Object element = b.getObject("this");
        if ((element instanceof JvmDeclaredType)) {
          boolean _isLocal = ((JvmDeclaredType)element).isLocal();
          if (_isLocal) {
            Pair<String, JvmDeclaredType> _mappedTo = Pair.<String, JvmDeclaredType>of("this", ((JvmDeclaredType)element));
            boolean _hasName = b.hasName(_mappedTo);
            if (_hasName) {
              Pair<String, JvmDeclaredType> _mappedTo_1 = Pair.<String, JvmDeclaredType>of("this", ((JvmDeclaredType)element));
              String _name = b.getName(_mappedTo_1);
              b.declareVariable(element, _name);
            } else {
              b.declareVariable(element, "");
            }
          } else {
            String _simpleName = ((JvmDeclaredType)element).getSimpleName();
            final String proposedName = (_simpleName + ".this");
            b.declareVariable(element, proposedName);
          }
        }
        String _xifexpression_1 = null;
        boolean _notEquals = (!Objects.equal(declaredType, null));
        if (_notEquals) {
          _xifexpression_1 = b.declareVariable(declaredType, "this");
        }
        _xblockexpression = _xifexpression_1;
      }
      _xifexpression = _xblockexpression;
    } else {
      String _xifexpression_1 = null;
      boolean _notEquals = (!Objects.equal(declaredType, null));
      if (_notEquals) {
        _xifexpression_1 = b.declareVariable(declaredType, "this");
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  public void compileLocalTypeStubs(final JvmFeature feature, final ITreeAppendable appendable, final GeneratorConfig config) {
    EList<JvmGenericType> _localClasses = feature.getLocalClasses();
    final Function1<JvmGenericType, Boolean> _function = new Function1<JvmGenericType, Boolean>() {
      public Boolean apply(final JvmGenericType it) {
        boolean _isAnonymous = it.isAnonymous();
        return Boolean.valueOf((!_isAnonymous));
      }
    };
    Iterable<JvmGenericType> _filter = IterableExtensions.<JvmGenericType>filter(_localClasses, _function);
    final Procedure1<JvmGenericType> _function_1 = new Procedure1<JvmGenericType>() {
      public void apply(final JvmGenericType it) {
        appendable.newLine();
        Set<EObject> _sourceElements = XtendGenerator.this.getSourceElements(it);
        EObject _head = IterableExtensions.<EObject>head(_sourceElements);
        final AnonymousClass anonymousClass = ((AnonymousClass) _head);
        final ITreeAppendable childAppendable = appendable.trace(anonymousClass);
        childAppendable.append("abstract class ");
        ITreeAppendable _traceSignificant = XtendGenerator.this._treeAppendableUtil.traceSignificant(childAppendable, anonymousClass);
        String _simpleName = it.getSimpleName();
        _traceSignificant.append(_simpleName);
        EList<JvmTypeParameter> _typeParameters = it.getTypeParameters();
        boolean _isEmpty = _typeParameters.isEmpty();
        if (_isEmpty) {
          childAppendable.append(" ");
        }
        XtendGenerator.this.generateExtendsClause(it, childAppendable, null);
        ITreeAppendable _append = childAppendable.append("{");
        _append.increaseIndentation();
        boolean _needSyntheticThisVariable = XtendGenerator.this.needSyntheticThisVariable(anonymousClass, it);
        if (_needSyntheticThisVariable) {
          Pair<String, JvmGenericType> _mappedTo = Pair.<String, JvmGenericType>of("this", it);
          String _simpleName_1 = it.getSimpleName();
          String _plus = ("_this" + _simpleName_1);
          final String thisName = childAppendable.declareSyntheticVariable(_mappedTo, _plus);
          ITreeAppendable _newLine = childAppendable.newLine();
          ITreeAppendable _append_1 = _newLine.append("final ");
          String _simpleName_2 = it.getSimpleName();
          ITreeAppendable _append_2 = _append_1.append(_simpleName_2);
          ITreeAppendable _append_3 = _append_2.append(" ");
          ITreeAppendable _append_4 = _append_3.append(thisName);
          ITreeAppendable _append_5 = _append_4.append(" = this;");
          _append_5.newLine();
        }
        ArrayList<JvmMember> _addedDeclarations = XtendGenerator.this.getAddedDeclarations(it, anonymousClass);
        final Procedure1<LoopParams> _function = new Procedure1<LoopParams>() {
          public void apply(final LoopParams it) {
            final Function1<ITreeAppendable, ITreeAppendable> _function = new Function1<ITreeAppendable, ITreeAppendable>() {
              public ITreeAppendable apply(final ITreeAppendable it) {
                return it.newLine();
              }
            };
            it.setSeparator(_function);
          }
        };
        final Procedure1<JvmMember> _function_1 = new Procedure1<JvmMember>() {
          public void apply(final JvmMember it) {
            final ITreeAppendable memberAppendable = XtendGenerator.this._treeAppendableUtil.traceWithComments(childAppendable, it);
            memberAppendable.openScope();
            if ((it instanceof JvmOperation)) {
              final ITreeAppendable tracedAppendable = childAppendable.trace(it);
              tracedAppendable.newLine();
              XtendGenerator.this.generateJavaDoc(it, tracedAppendable, config);
              XtendGenerator.this.generateVisibilityModifier(it, tracedAppendable);
              tracedAppendable.append("abstract ");
              XtendGenerator.this.generateTypeParameterDeclaration(((JvmTypeParameterDeclarator)it), tracedAppendable, null);
              JvmTypeReference _returnType = ((JvmOperation)it).getReturnType();
              boolean _equals = Objects.equal(_returnType, null);
              if (_equals) {
                tracedAppendable.append("void");
              } else {
                JvmTypeReference _returnType_1 = ((JvmOperation)it).getReturnType();
                XtendGenerator.this._errorSafeExtensions.serializeSafely(_returnType_1, "Object", tracedAppendable);
              }
              tracedAppendable.append(" ");
              ITreeAppendable _traceSignificant = XtendGenerator.this._treeAppendableUtil.traceSignificant(tracedAppendable, it);
              String _simpleName = ((JvmOperation)it).getSimpleName();
              _traceSignificant.append(_simpleName);
              tracedAppendable.append("(");
              XtendGenerator.this.generateParameters(((JvmExecutable)it), tracedAppendable, null);
              tracedAppendable.append(")");
              XtendGenerator.this.generateThrowsClause(((JvmExecutable)it), tracedAppendable, null);
              tracedAppendable.append(";");
            } else {
              if ((it instanceof JvmField)) {
                final ITreeAppendable tracedAppendable_1 = childAppendable.trace(it);
                tracedAppendable_1.newLine();
                XtendGenerator.this.generateJavaDoc(it, tracedAppendable_1, config);
                EList<JvmAnnotationReference> _annotations = ((JvmField)it).getAnnotations();
                XtendGenerator.this.generateAnnotations(_annotations, tracedAppendable_1, true, config);
                JvmTypeReference _type = ((JvmField)it).getType();
                XtendGenerator.this._errorSafeExtensions.serializeSafely(_type, "Object", tracedAppendable_1);
                tracedAppendable_1.append(" ");
                ITreeAppendable _traceSignificant_1 = XtendGenerator.this._treeAppendableUtil.traceSignificant(tracedAppendable_1, it);
                String _simpleName_1 = ((JvmField)it).getSimpleName();
                _traceSignificant_1.append(_simpleName_1);
                tracedAppendable_1.append(";");
              } else {
                XtendGenerator.this.generateMember(it, memberAppendable, config);
              }
            }
            memberAppendable.closeScope();
          }
        };
        XtendGenerator.this._loopExtensions.<JvmMember>forEach(childAppendable, _addedDeclarations, _function, _function_1);
        ITreeAppendable _decreaseIndentation = childAppendable.decreaseIndentation();
        ITreeAppendable _newLine_1 = _decreaseIndentation.newLine();
        _newLine_1.append("}");
        appendable.newLine();
      }
    };
    IterableExtensions.<JvmGenericType>forEach(_filter, _function_1);
  }
  
  private boolean needSyntheticThisVariable(final AnonymousClass anonymousClass, final JvmDeclaredType localType) {
    final ArrayList<EObject> references = CollectionLiterals.<EObject>newArrayList();
    try {
      final EcoreUtil2.ElementReferenceAcceptor acceptor = new EcoreUtil2.ElementReferenceAcceptor() {
        public void accept(final EObject referrer, final EObject referenced, final EReference reference, final int index) {
          try {
            final XtendTypeDeclaration enclosingType = EcoreUtil2.<XtendTypeDeclaration>getContainerOfType(referrer, XtendTypeDeclaration.class);
            boolean _and = false;
            boolean _notEquals = (!Objects.equal(enclosingType, null));
            if (!_notEquals) {
              _and = false;
            } else {
              boolean _notEquals_1 = (!Objects.equal(enclosingType, anonymousClass));
              _and = _notEquals_1;
            }
            if (_and) {
              references.add(referrer);
              throw new XtendGenerator.StopCollecting();
            } else {
              final XClosure enclosingLambda = EcoreUtil2.<XClosure>getContainerOfType(referrer, XClosure.class);
              boolean _and_1 = false;
              boolean _notEquals_2 = (!Objects.equal(enclosingLambda, null));
              if (!_notEquals_2) {
                _and_1 = false;
              } else {
                boolean _isAncestor = EcoreUtil.isAncestor(anonymousClass, enclosingLambda);
                _and_1 = _isAncestor;
              }
              if (_and_1) {
                references.add(referrer);
                throw new XtendGenerator.StopCollecting();
              }
            }
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      Set<JvmDeclaredType> _newImmutableSet = CollectionLiterals.<JvmDeclaredType>newImmutableSet(localType);
      EcoreUtil2.findCrossReferences(anonymousClass, _newImmutableSet, acceptor);
    } catch (final Throwable _t) {
      if (_t instanceof XtendGenerator.StopCollecting) {
        final XtendGenerator.StopCollecting e = (XtendGenerator.StopCollecting)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    boolean _isEmpty = references.isEmpty();
    return (!_isEmpty);
  }
  
  public ITreeAppendable generateVisibilityModifier(final JvmMember it, final ITreeAppendable result) {
    ITreeAppendable _xblockexpression = null;
    {
      boolean _and = false;
      JvmVisibility _visibility = it.getVisibility();
      boolean _equals = Objects.equal(_visibility, JvmVisibility.PRIVATE);
      if (!_equals) {
        _and = false;
      } else {
        JvmDeclaredType _declaringType = it.getDeclaringType();
        boolean _isLocal = _declaringType.isLocal();
        _and = _isLocal;
      }
      if (_and) {
        if ((it instanceof JvmOperation)) {
          JvmDeclaredType _declaringType_1 = ((JvmOperation)it).getDeclaringType();
          final JvmGenericType declarator = ((JvmGenericType) _declaringType_1);
          boolean _isAnonymous = declarator.isAnonymous();
          boolean _not = (!_isAnonymous);
          if (_not) {
            return result;
          }
        }
      }
      _xblockexpression = super.generateVisibilityModifier(it, result);
    }
    return _xblockexpression;
  }
  
  public ITreeAppendable generateMembersInBody(final JvmDeclaredType it, final ITreeAppendable appendable, final GeneratorConfig config) {
    ITreeAppendable _xifexpression = null;
    boolean _isLocal = it.isLocal();
    if (_isLocal) {
      ITreeAppendable _xblockexpression = null;
      {
        ITreeAppendable _append = appendable.append("{");
        _append.increaseIndentation();
        Iterable<JvmField> _declaredFields = it.getDeclaredFields();
        final Function1<JvmField, Boolean> _function = new Function1<JvmField, Boolean>() {
          public Boolean apply(final JvmField it) {
            boolean _xblockexpression = false;
            {
              Procedure1<? super ITreeAppendable> _compilationStrategy = XtendGenerator.this._jvmTypeExtensions.getCompilationStrategy(it);
              boolean _notEquals = (!Objects.equal(_compilationStrategy, null));
              if (_notEquals) {
                return Boolean.valueOf(true);
              } else {
                StringConcatenationClient _compilationTemplate = XtendGenerator.this._jvmTypeExtensions.getCompilationTemplate(it);
                boolean _notEquals_1 = (!Objects.equal(_compilationTemplate, null));
                if (_notEquals_1) {
                  return Boolean.valueOf(true);
                } else {
                  final XExpression expression = XtendGenerator.this._iLogicalContainerProvider.getAssociatedExpression(it);
                  boolean _and = false;
                  boolean _notEquals_2 = (!Objects.equal(expression, null));
                  if (!_notEquals_2) {
                    _and = false;
                  } else {
                    boolean _isGenerateExpressions = config.isGenerateExpressions();
                    _and = _isGenerateExpressions;
                  }
                  if (_and) {
                    return Boolean.valueOf(true);
                  }
                }
              }
              _xblockexpression = false;
            }
            return Boolean.valueOf(_xblockexpression);
          }
        };
        final Iterable<JvmField> fieldsWithInitializer = IterableExtensions.<JvmField>filter(_declaredFields, _function);
        boolean _isEmpty = IterableExtensions.isEmpty(fieldsWithInitializer);
        boolean _not = (!_isEmpty);
        if (_not) {
          ITreeAppendable _newLine = appendable.newLine();
          ITreeAppendable _append_1 = _newLine.append("{");
          _append_1.increaseIndentation();
          final Procedure1<LoopParams> _function_1 = new Procedure1<LoopParams>() {
            public void apply(final LoopParams it) {
              final Function1<ITreeAppendable, ITreeAppendable> _function = new Function1<ITreeAppendable, ITreeAppendable>() {
                public ITreeAppendable apply(final ITreeAppendable it) {
                  return it.newLine();
                }
              };
              it.setSeparator(_function);
            }
          };
          final Procedure1<JvmField> _function_2 = new Procedure1<JvmField>() {
            public void apply(final JvmField it) {
              final ITreeAppendable memberAppendable = XtendGenerator.this._treeAppendableUtil.traceWithComments(appendable, it);
              memberAppendable.openScope();
              appendable.newLine();
              final ITreeAppendable tracedAppendable = appendable.trace(it);
              ITreeAppendable _traceSignificant = XtendGenerator.this._treeAppendableUtil.traceSignificant(tracedAppendable, it);
              String _simpleName = it.getSimpleName();
              _traceSignificant.append(_simpleName);
              XtendGenerator.this.generateInitialization(it, tracedAppendable, config);
              tracedAppendable.append(";");
              memberAppendable.closeScope();
            }
          };
          this._loopExtensions.<JvmField>forEach(appendable, fieldsWithInitializer, _function_1, _function_2);
          ITreeAppendable _decreaseIndentation = appendable.decreaseIndentation();
          ITreeAppendable _newLine_1 = _decreaseIndentation.newLine();
          _newLine_1.append("}");
        }
        Iterable<JvmMember> _membersToBeCompiled = this.getMembersToBeCompiled(it);
        final Procedure1<LoopParams> _function_3 = new Procedure1<LoopParams>() {
          public void apply(final LoopParams it) {
            final Function1<ITreeAppendable, ITreeAppendable> _function = new Function1<ITreeAppendable, ITreeAppendable>() {
              public ITreeAppendable apply(final ITreeAppendable it) {
                return it.newLine();
              }
            };
            it.setSeparator(_function);
          }
        };
        final Procedure1<JvmMember> _function_4 = new Procedure1<JvmMember>() {
          public void apply(final JvmMember it) {
            final ITreeAppendable memberAppendable = XtendGenerator.this._treeAppendableUtil.traceWithComments(appendable, it);
            memberAppendable.openScope();
            XtendGenerator.this.generateMember(it, memberAppendable, config);
            memberAppendable.closeScope();
          }
        };
        this._loopExtensions.<JvmMember>forEach(appendable, _membersToBeCompiled, _function_3, _function_4);
        ITreeAppendable _decreaseIndentation_1 = appendable.decreaseIndentation();
        ITreeAppendable _newLine_2 = _decreaseIndentation_1.newLine();
        _xblockexpression = _newLine_2.append("}");
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = super.generateMembersInBody(it, appendable, config);
    }
    return _xifexpression;
  }
}
