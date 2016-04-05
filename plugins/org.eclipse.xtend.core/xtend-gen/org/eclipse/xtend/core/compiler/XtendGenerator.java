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
import com.google.common.collect.Lists;
import com.google.inject.Inject;
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
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGenerator2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.ElementIssueProvider;
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
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendGenerator extends JvmModelGenerator implements IGenerator2 {
  private static class StopCollecting extends Exception {
  }
  
  @Inject
  private IBatchTypeResolver typeResolver;
  
  @Inject
  private OperationCanceledManager operationCanceledManager;
  
  @Inject
  private ElementIssueProvider.Factory issueProviderFactory;
  
  @Override
  public void doGenerate(final Resource input, final IFileSystemAccess fsa) {
    super.doGenerate(input, fsa);
    this.callMacroProcessors(input);
  }
  
  @Override
  public void beforeGenerate(final Resource input, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    this.issueProviderFactory.attachData(input);
  }
  
  @Override
  public void afterGenerate(final Resource input, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    this.issueProviderFactory.detachData(input);
  }
  
  @Override
  public void doGenerate(final Resource input, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    this.doGenerate(input, ((IFileSystemAccess) fsa));
  }
  
  public void callMacroProcessors(final Resource input) {
    final ActiveAnnotationContexts ctxs = ActiveAnnotationContexts.find(input);
    if ((ctxs == null)) {
      return;
    }
    try {
      ctxs.before(ActiveAnnotationContexts.AnnotationCallback.GENERATION);
      Map<JvmAnnotationType, ActiveAnnotationContext> _contexts = ctxs.getContexts();
      Collection<ActiveAnnotationContext> _values = _contexts.values();
      for (final ActiveAnnotationContext context : _values) {
        try {
          Object _processorInstance = context.getProcessorInstance();
          final Object processor = _processorInstance;
          boolean _matched = false;
          if (!_matched) {
            if (processor instanceof CodeGenerationParticipant) {
              _matched=true;
              CodeGenerationContextImpl _codeGenerationContextImpl = new CodeGenerationContextImpl();
              final Procedure1<CodeGenerationContextImpl> _function = new Procedure1<CodeGenerationContextImpl>() {
                @Override
                public void apply(final CodeGenerationContextImpl it) {
                  CompilationUnitImpl _compilationUnit = context.getCompilationUnit();
                  it.setUnit(_compilationUnit);
                }
              };
              final CodeGenerationContextImpl codeGenServices = ObjectExtensions.<CodeGenerationContextImpl>operator_doubleArrow(_codeGenerationContextImpl, _function);
              List<XtendAnnotationTarget> _annotatedSourceElements = context.getAnnotatedSourceElements();
              final Function1<XtendAnnotationTarget, MemberDeclaration> _function_1 = new Function1<XtendAnnotationTarget, MemberDeclaration>() {
                @Override
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
            this.operationCanceledManager.propagateAsErrorIfCancelException(t);
            context.handleProcessingError(input, t);
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
    } finally {
      ctxs.after(ActiveAnnotationContexts.AnnotationCallback.GENERATION);
    }
  }
  
  @Override
  protected ImportingStringConcatenation createImportingStringConcatenation(final SharedAppendableState state, final ITypeReferenceOwner owner) {
    return new MacroAwareStringConcatenation(state, owner);
  }
  
  /**
   * Convert a given input string to a Java string.
   * 
   * Unicode escaping is handled by the {@link UnicodeAwarePostProcessor}.
   */
  @Override
  public String doConvertToJavaString(final String input) {
    return Strings.convertToJavaString(input, false);
  }
  
  @Override
  protected Iterable<JvmMember> _getMembersToBeCompiled(final JvmGenericType it) {
    Iterable<JvmMember> _xifexpression = null;
    boolean _isLocal = it.isLocal();
    if (_isLocal) {
      EList<JvmMember> _members = it.getMembers();
      final Function1<JvmMember, Boolean> _function = new Function1<JvmMember, Boolean>() {
        @Override
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
      @Override
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
  
  @Override
  public ITreeAppendable compile(final JvmExecutable executable, final XExpression expression, final JvmTypeReference returnType, final ITreeAppendable appendable, final GeneratorConfig config) {
    ITreeAppendable _xblockexpression = null;
    {
      this.compileLocalTypeStubs(executable, appendable, config);
      _xblockexpression = super.compile(executable, expression, returnType, appendable, config);
    }
    return _xblockexpression;
  }
  
  @Override
  public String reassignThisType(final ITreeAppendable b, final JvmDeclaredType declaredType) {
    String _xblockexpression = null;
    {
      boolean _hasObject = b.hasObject("this");
      if (_hasObject) {
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
      }
      String _xifexpression = null;
      if ((declaredType != null)) {
        _xifexpression = b.declareVariable(declaredType, "this");
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public void compileLocalTypeStubs(final JvmFeature feature, final ITreeAppendable appendable, final GeneratorConfig config) {
    EList<JvmGenericType> _localClasses = feature.getLocalClasses();
    final Function1<JvmGenericType, Boolean> _function = new Function1<JvmGenericType, Boolean>() {
      @Override
      public Boolean apply(final JvmGenericType it) {
        boolean _isAnonymous = it.isAnonymous();
        return Boolean.valueOf((!_isAnonymous));
      }
    };
    Iterable<JvmGenericType> _filter = IterableExtensions.<JvmGenericType>filter(_localClasses, _function);
    for (final JvmGenericType it : _filter) {
      {
        appendable.newLine();
        Set<EObject> _sourceElements = this.getSourceElements(it);
        EObject _head = IterableExtensions.<EObject>head(_sourceElements);
        final AnonymousClass anonymousClass = ((AnonymousClass) _head);
        final ITreeAppendable childAppendable = appendable.trace(anonymousClass);
        childAppendable.append("abstract class ");
        ITreeAppendable _traceSignificant = this._treeAppendableUtil.traceSignificant(childAppendable, anonymousClass);
        String _simpleName = it.getSimpleName();
        _traceSignificant.append(_simpleName);
        EList<JvmTypeParameter> _typeParameters = it.getTypeParameters();
        boolean _isEmpty = _typeParameters.isEmpty();
        if (_isEmpty) {
          childAppendable.append(" ");
        }
        this.generateExtendsClause(it, childAppendable, null);
        ITreeAppendable _append = childAppendable.append("{");
        _append.increaseIndentation();
        boolean _needSyntheticThisVariable = this.needSyntheticThisVariable(anonymousClass, it);
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
        ArrayList<JvmMember> _addedDeclarations = this.getAddedDeclarations(it, anonymousClass);
        final Procedure1<LoopParams> _function_1 = new Procedure1<LoopParams>() {
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
        final Procedure1<JvmMember> _function_2 = new Procedure1<JvmMember>() {
          @Override
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
              boolean _tripleEquals = (_returnType == null);
              if (_tripleEquals) {
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
                boolean _and = false;
                boolean _isFinal = ((JvmField)it).isFinal();
                if (!_isFinal) {
                  _and = false;
                } else {
                  boolean _isStatic = ((JvmField)it).isStatic();
                  _and = _isStatic;
                }
                if (_and) {
                  tracedAppendable_1.append("final ");
                }
                boolean _isStatic_1 = ((JvmField)it).isStatic();
                if (_isStatic_1) {
                  tracedAppendable_1.append("static ");
                }
                boolean _isTransient = ((JvmField)it).isTransient();
                if (_isTransient) {
                  tracedAppendable_1.append("transient ");
                }
                boolean _isVolatile = ((JvmField)it).isVolatile();
                if (_isVolatile) {
                  tracedAppendable_1.append("volatile ");
                }
                JvmTypeReference _type = ((JvmField)it).getType();
                XtendGenerator.this._errorSafeExtensions.serializeSafely(_type, "Object", tracedAppendable_1);
                tracedAppendable_1.append(" ");
                ITreeAppendable _traceSignificant_1 = XtendGenerator.this._treeAppendableUtil.traceSignificant(tracedAppendable_1, it);
                String _simpleName_1 = ((JvmField)it).getSimpleName();
                _traceSignificant_1.append(_simpleName_1);
                boolean _and_1 = false;
                boolean _isFinal_1 = ((JvmField)it).isFinal();
                if (!_isFinal_1) {
                  _and_1 = false;
                } else {
                  boolean _isStatic_2 = ((JvmField)it).isStatic();
                  _and_1 = _isStatic_2;
                }
                if (_and_1) {
                  Object _constantValue = ((JvmField)it).getConstantValue();
                  boolean _notEquals = (!Objects.equal(_constantValue, null));
                  if (_notEquals) {
                    tracedAppendable_1.append(" = ");
                    Object _constantValue_1 = ((JvmField)it).getConstantValue();
                    XtendGenerator.this.generateJavaConstant(_constantValue_1, tracedAppendable_1);
                  } else {
                    XtendGenerator.this.generateInitialization(((JvmField)it), tracedAppendable_1, config);
                  }
                }
                tracedAppendable_1.append(";");
              } else {
                XtendGenerator.this.generateMember(it, memberAppendable, config);
              }
            }
            memberAppendable.closeScope();
          }
        };
        this._loopExtensions.<JvmMember>forEach(childAppendable, _addedDeclarations, _function_1, _function_2);
        ITreeAppendable _decreaseIndentation = childAppendable.decreaseIndentation();
        ITreeAppendable _newLine_1 = _decreaseIndentation.newLine();
        _newLine_1.append("}");
        appendable.newLine();
      }
    }
  }
  
  private ITreeAppendable generateJavaConstant(final Object value, final ITreeAppendable appendable) {
    ITreeAppendable _xifexpression = null;
    if ((value instanceof Float)) {
      String _string = ((Float)value).toString();
      ITreeAppendable _append = appendable.append(_string);
      _xifexpression = _append.append("f");
    } else {
      ITreeAppendable _xifexpression_1 = null;
      if ((value instanceof Long)) {
        String _string_1 = ((Long)value).toString();
        ITreeAppendable _append_1 = appendable.append(_string_1);
        _xifexpression_1 = _append_1.append("l");
      } else {
        ITreeAppendable _xifexpression_2 = null;
        if ((value instanceof Character)) {
          char _charValue = ((Character)value).charValue();
          String _string_2 = Integer.toString(_charValue);
          _xifexpression_2 = appendable.append(_string_2);
        } else {
          ITreeAppendable _xifexpression_3 = null;
          if ((value instanceof CharSequence)) {
            ITreeAppendable _append_2 = appendable.append("\"");
            String _string_3 = ((CharSequence)value).toString();
            String _doConvertToJavaString = this.doConvertToJavaString(_string_3);
            ITreeAppendable _append_3 = _append_2.append(_doConvertToJavaString);
            _xifexpression_3 = _append_3.append("\"");
          } else {
            ITreeAppendable _xifexpression_4 = null;
            boolean _or = false;
            if ((value instanceof Number)) {
              _or = true;
            } else {
              _or = (value instanceof Boolean);
            }
            if (_or) {
              String _string_4 = value.toString();
              _xifexpression_4 = appendable.append(_string_4);
            } else {
              _xifexpression_4 = appendable.append("null /* ERROR: illegal constant value */");
            }
            _xifexpression_3 = _xifexpression_4;
          }
          _xifexpression_2 = _xifexpression_3;
        }
        _xifexpression_1 = _xifexpression_2;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  private boolean needSyntheticThisVariable(final AnonymousClass anonymousClass, final JvmDeclaredType localType) {
    final ArrayList<EObject> references = Lists.<EObject>newArrayListWithCapacity(1);
    try {
      Set<JvmDeclaredType> _newImmutableSet = CollectionLiterals.<JvmDeclaredType>newImmutableSet(localType);
      final EcoreUtil2.ElementReferenceAcceptor _function = new EcoreUtil2.ElementReferenceAcceptor() {
        @Override
        public void accept(final EObject referrer, final EObject referenced, final EReference reference, final int index) {
          try {
            EObject _eContainer = referrer.eContainer();
            if ((_eContainer instanceof XAbstractFeatureCall)) {
              EObject _eContainer_1 = referrer.eContainer();
              final XAbstractFeatureCall containingFeature = ((XAbstractFeatureCall) _eContainer_1);
              boolean _and = false;
              boolean _and_1 = false;
              XExpression _actualReceiver = containingFeature.getActualReceiver();
              boolean _equals = Objects.equal(_actualReceiver, referrer);
              if (!_equals) {
                _and_1 = false;
              } else {
                JvmIdentifiableElement _feature = containingFeature.getFeature();
                _and_1 = (_feature instanceof JvmMember);
              }
              if (!_and_1) {
                _and = false;
              } else {
                JvmIdentifiableElement _feature_1 = containingFeature.getFeature();
                boolean _isVisible = XtendGenerator.this.isVisible(((JvmMember) _feature_1), localType);
                boolean _not = (!_isVisible);
                _and = _not;
              }
              if (_and) {
                references.clear();
                throw new XtendGenerator.StopCollecting();
              }
            }
            final XtendTypeDeclaration enclosingType = EcoreUtil2.<XtendTypeDeclaration>getContainerOfType(referrer, XtendTypeDeclaration.class);
            boolean _and_2 = false;
            if (!(enclosingType != null)) {
              _and_2 = false;
            } else {
              boolean _notEquals = (!Objects.equal(enclosingType, anonymousClass));
              _and_2 = _notEquals;
            }
            if (_and_2) {
              boolean _isEmpty = references.isEmpty();
              if (_isEmpty) {
                references.add(referrer);
              }
              return;
            }
            final XClosure enclosingLambda = EcoreUtil2.<XClosure>getContainerOfType(referrer, XClosure.class);
            boolean _and_3 = false;
            if (!(enclosingLambda != null)) {
              _and_3 = false;
            } else {
              boolean _isAncestor = EcoreUtil.isAncestor(anonymousClass, enclosingLambda);
              _and_3 = _isAncestor;
            }
            if (_and_3) {
              boolean _isEmpty_1 = references.isEmpty();
              if (_isEmpty_1) {
                references.add(referrer);
              }
            }
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      EcoreUtil2.findCrossReferences(anonymousClass, _newImmutableSet, _function);
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
  
  /**
   * Determine whether the given member is visible without considering the class hierarchy.
   */
  private boolean isVisible(final JvmMember member, final JvmDeclaredType context) {
    final JvmVisibility visibility = member.getVisibility();
    boolean _equals = Objects.equal(visibility, JvmVisibility.PUBLIC);
    if (_equals) {
      return true;
    }
    JvmDeclaredType _xifexpression = null;
    if ((member instanceof JvmDeclaredType)) {
      _xifexpression = ((JvmDeclaredType)member);
    } else {
      _xifexpression = member.getDeclaringType();
    }
    final JvmDeclaredType type = _xifexpression;
    boolean _or = false;
    boolean _equals_1 = Objects.equal(type, context);
    if (_equals_1) {
      _or = true;
    } else {
      boolean _isAncestor = EcoreUtil.isAncestor(context, type);
      _or = _isAncestor;
    }
    if (_or) {
      return true;
    }
    boolean _and = false;
    if (!(type != null)) {
      _and = false;
    } else {
      boolean _or_1 = false;
      boolean _equals_2 = Objects.equal(visibility, JvmVisibility.DEFAULT);
      if (_equals_2) {
        _or_1 = true;
      } else {
        boolean _equals_3 = Objects.equal(visibility, JvmVisibility.PROTECTED);
        _or_1 = _equals_3;
      }
      _and = _or_1;
    }
    if (_and) {
      boolean _or_2 = false;
      boolean _and_1 = false;
      String _packageName = context.getPackageName();
      boolean _isEmpty = Strings.isEmpty(_packageName);
      if (!_isEmpty) {
        _and_1 = false;
      } else {
        String _packageName_1 = type.getPackageName();
        boolean _isEmpty_1 = Strings.isEmpty(_packageName_1);
        _and_1 = _isEmpty_1;
      }
      if (_and_1) {
        _or_2 = true;
      } else {
        String _packageName_2 = context.getPackageName();
        String _packageName_3 = type.getPackageName();
        boolean _equals_4 = Objects.equal(_packageName_2, _packageName_3);
        _or_2 = _equals_4;
      }
      if (_or_2) {
        return true;
      }
    }
    return false;
  }
  
  @Override
  public ITreeAppendable generateVisibilityModifier(final JvmMember it, final ITreeAppendable result) {
    ITreeAppendable _xblockexpression = null;
    {
      JvmVisibility _visibility = it.getVisibility();
      boolean _equals = Objects.equal(_visibility, JvmVisibility.PRIVATE);
      if (_equals) {
        JvmDeclaredType _declaringType = it.getDeclaringType();
        boolean _tripleEquals = (_declaringType == null);
        if (_tripleEquals) {
          return result;
        }
        boolean _and = false;
        JvmDeclaredType _declaringType_1 = it.getDeclaringType();
        boolean _isLocal = _declaringType_1.isLocal();
        if (!_isLocal) {
          _and = false;
        } else {
          _and = (it instanceof JvmOperation);
        }
        if (_and) {
          JvmDeclaredType _declaringType_2 = it.getDeclaringType();
          final JvmGenericType declarator = ((JvmGenericType) _declaringType_2);
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
  
  @Override
  public ITreeAppendable generateMembersInBody(final JvmDeclaredType it, final ITreeAppendable appendable, final GeneratorConfig config) {
    ITreeAppendable _xifexpression = null;
    boolean _isLocal = it.isLocal();
    if (_isLocal) {
      ITreeAppendable _xblockexpression = null;
      {
        ITreeAppendable _append = appendable.append("{");
        _append.increaseIndentation();
        Set<EObject> _sourceElements = this.getSourceElements(it);
        EObject _head = IterableExtensions.<EObject>head(_sourceElements);
        final AnonymousClass anonymousClass = ((AnonymousClass) _head);
        boolean _and = false;
        Pair<String, JvmDeclaredType> _mappedTo = Pair.<String, JvmDeclaredType>of("this", it);
        boolean _hasName = appendable.hasName(_mappedTo);
        boolean _not = (!_hasName);
        if (!_not) {
          _and = false;
        } else {
          boolean _needSyntheticThisVariable = this.needSyntheticThisVariable(anonymousClass, it);
          _and = _needSyntheticThisVariable;
        }
        if (_and) {
          final IResolvedTypes resolvedTypes = this.typeResolver.resolveTypes(anonymousClass);
          final LightweightTypeReference actualType = resolvedTypes.getActualType(anonymousClass);
          Pair<String, JvmDeclaredType> _mappedTo_1 = Pair.<String, JvmDeclaredType>of("this", it);
          final String thisName = appendable.declareSyntheticVariable(_mappedTo_1, "_this");
          ITreeAppendable _newLine = appendable.newLine();
          ITreeAppendable _append_1 = _newLine.append("final ");
          ITreeAppendable _append_2 = _append_1.append(actualType);
          ITreeAppendable _append_3 = _append_2.append(" ");
          ITreeAppendable _append_4 = _append_3.append(thisName);
          _append_4.append(" = this;");
        }
        Iterable<JvmField> _declaredFields = it.getDeclaredFields();
        final Function1<JvmField, Boolean> _function = new Function1<JvmField, Boolean>() {
          @Override
          public Boolean apply(final JvmField it) {
            boolean _xblockexpression = false;
            {
              Procedure1<? super ITreeAppendable> _compilationStrategy = XtendGenerator.this._jvmTypeExtensions.getCompilationStrategy(it);
              boolean _tripleNotEquals = (_compilationStrategy != null);
              if (_tripleNotEquals) {
                return Boolean.valueOf(true);
              } else {
                StringConcatenationClient _compilationTemplate = XtendGenerator.this._jvmTypeExtensions.getCompilationTemplate(it);
                boolean _tripleNotEquals_1 = (_compilationTemplate != null);
                if (_tripleNotEquals_1) {
                  return Boolean.valueOf(true);
                } else {
                  boolean _and = false;
                  boolean _isFinal = it.isFinal();
                  if (!_isFinal) {
                    _and = false;
                  } else {
                    boolean _isStatic = it.isStatic();
                    _and = _isStatic;
                  }
                  boolean _not = (!_and);
                  if (_not) {
                    final XExpression expression = XtendGenerator.this._iLogicalContainerProvider.getAssociatedExpression(it);
                    boolean _and_1 = false;
                    if (!(expression != null)) {
                      _and_1 = false;
                    } else {
                      boolean _isGenerateExpressions = config.isGenerateExpressions();
                      _and_1 = _isGenerateExpressions;
                    }
                    if (_and_1) {
                      return Boolean.valueOf(true);
                    }
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
        boolean _not_1 = (!_isEmpty);
        if (_not_1) {
          ITreeAppendable _newLine_1 = appendable.newLine();
          ITreeAppendable _append_5 = _newLine_1.append("{");
          _append_5.increaseIndentation();
          final Procedure1<LoopParams> _function_1 = new Procedure1<LoopParams>() {
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
          final Procedure1<JvmField> _function_2 = new Procedure1<JvmField>() {
            @Override
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
          ITreeAppendable _newLine_2 = _decreaseIndentation.newLine();
          _newLine_2.append("}");
        }
        Iterable<JvmMember> _membersToBeCompiled = this.getMembersToBeCompiled(it);
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
            final ITreeAppendable memberAppendable = XtendGenerator.this._treeAppendableUtil.traceWithComments(appendable, it);
            memberAppendable.openScope();
            XtendGenerator.this.generateMember(it, memberAppendable, config);
            memberAppendable.closeScope();
          }
        };
        this._loopExtensions.<JvmMember>forEach(appendable, _membersToBeCompiled, _function_3, _function_4);
        ITreeAppendable _decreaseIndentation_1 = appendable.decreaseIndentation();
        ITreeAppendable _newLine_3 = _decreaseIndentation_1.newLine();
        _xblockexpression = _newLine_3.append("}");
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = super.generateMembersInBody(it, appendable, config);
    }
    return _xifexpression;
  }
}
