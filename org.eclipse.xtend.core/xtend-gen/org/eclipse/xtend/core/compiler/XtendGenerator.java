/**
 * Copyright (c) 2013, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.compiler;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.core.macro.ActiveAnnotationContext;
import org.eclipse.xtend.core.macro.ActiveAnnotationContexts;
import org.eclipse.xtend.core.macro.CodeGenerationContextImpl;
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
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
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
    private static final long serialVersionUID = (-6188090786919774877L);
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
      Collection<ActiveAnnotationContext> _values = ctxs.getContexts().values();
      for (final ActiveAnnotationContext context : _values) {
        try {
          Object _processorInstance = context.getProcessorInstance();
          final Object processor = _processorInstance;
          boolean _matched = false;
          if (processor instanceof CodeGenerationParticipant) {
            _matched=true;
            CodeGenerationContextImpl _codeGenerationContextImpl = new CodeGenerationContextImpl();
            final Procedure1<CodeGenerationContextImpl> _function = (CodeGenerationContextImpl it) -> {
              it.setUnit(context.getCompilationUnit());
            };
            final CodeGenerationContextImpl codeGenServices = ObjectExtensions.<CodeGenerationContextImpl>operator_doubleArrow(_codeGenerationContextImpl, _function);
            final Function1<XtendAnnotationTarget, MemberDeclaration> _function_1 = (XtendAnnotationTarget it) -> {
              return context.getCompilationUnit().toXtendMemberDeclaration(((XtendMember) it));
            };
            final List<MemberDeclaration> elements = ListExtensions.<XtendAnnotationTarget, MemberDeclaration>map(context.getAnnotatedSourceElements(), _function_1);
            ((CodeGenerationParticipant<NamedElement>)processor).doGenerateCode(elements, codeGenServices);
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
      final Function1<JvmMember, Boolean> _function = (JvmMember it_1) -> {
        return Boolean.valueOf((it_1 instanceof JvmOperation));
      };
      _xifexpression = IterableExtensions.<JvmMember>filter(it.getMembers(), _function);
    } else {
      _xifexpression = this._getMembersToBeCompiled(((JvmDeclaredType) it));
    }
    return _xifexpression;
  }

  protected ArrayList<JvmMember> getAddedDeclarations(final JvmGenericType it, final AnonymousClass anonymousClass) {
    final ArrayList<JvmMember> result = CollectionLiterals.<JvmMember>newArrayList();
    final JvmConstructor constructor = anonymousClass.getConstructorCall().getConstructor();
    int _size = constructor.getParameters().size();
    boolean _greaterEqualsThan = (_size >= 1);
    if (_greaterEqualsThan) {
      result.add(0, constructor);
    }
    Iterable<JvmField> _declaredFields = it.getDeclaredFields();
    Iterables.<JvmMember>addAll(result, _declaredFields);
    final Function1<JvmOperation, Boolean> _function = (JvmOperation it_1) -> {
      EObject _head = IterableExtensions.<EObject>head(this.getSourceElements(it_1));
      final XtendFunction function = ((XtendFunction) _head);
      boolean _isOverride = function.isOverride();
      return Boolean.valueOf((!_isOverride));
    };
    Iterable<JvmOperation> _filter = IterableExtensions.<JvmOperation>filter(it.getDeclaredOperations(), _function);
    Iterables.<JvmMember>addAll(result, _filter);
    Iterable<JvmDeclaredType> _filter_1 = Iterables.<JvmDeclaredType>filter(it.getMembers(), JvmDeclaredType.class);
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
              b.declareVariable(element, b.getName(_mappedTo_1));
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
    final Function1<JvmGenericType, Boolean> _function = (JvmGenericType it) -> {
      boolean _isAnonymous = it.isAnonymous();
      return Boolean.valueOf((!_isAnonymous));
    };
    final Consumer<JvmGenericType> _function_1 = (JvmGenericType it) -> {
      appendable.newLine();
      EObject _head = IterableExtensions.<EObject>head(this.getSourceElements(it));
      final AnonymousClass anonymousClass = ((AnonymousClass) _head);
      final ITreeAppendable childAppendable = appendable.trace(anonymousClass);
      childAppendable.append("abstract class ");
      this._treeAppendableUtil.traceSignificant(childAppendable, anonymousClass).append(it.getSimpleName());
      boolean _isEmpty = it.getTypeParameters().isEmpty();
      if (_isEmpty) {
        childAppendable.append(" ");
      }
      this.generateExtendsClause(it, childAppendable, null);
      childAppendable.append("{").increaseIndentation();
      boolean _needSyntheticThisVariable = this.needSyntheticThisVariable(anonymousClass, it);
      if (_needSyntheticThisVariable) {
        Pair<String, JvmGenericType> _mappedTo = Pair.<String, JvmGenericType>of("this", it);
        String _simpleName = it.getSimpleName();
        String _plus = ("_this" + _simpleName);
        final String thisName = childAppendable.declareSyntheticVariable(_mappedTo, _plus);
        childAppendable.newLine().append("final ").append(it.getSimpleName()).append(" ").append(thisName).append(" = this;");
        childAppendable.blankLine();
      }
      final Procedure1<LoopParams> _function_2 = (LoopParams it_1) -> {
        it_1.setSeparator(this.memberSeparator());
      };
      final Procedure1<JvmMember> _function_3 = (JvmMember it_1) -> {
        final ITreeAppendable memberAppendable = this._treeAppendableUtil.traceWithComments(childAppendable, it_1);
        memberAppendable.openScope();
        if ((it_1 instanceof JvmOperation)) {
          final ITreeAppendable tracedAppendable = childAppendable.trace(it_1);
          tracedAppendable.newLine();
          this.generateJavaDoc(it_1, tracedAppendable, config);
          this.generateVisibilityModifier(it_1, tracedAppendable);
          tracedAppendable.append("abstract ");
          this.generateTypeParameterDeclaration(((JvmTypeParameterDeclarator)it_1), tracedAppendable, null);
          JvmTypeReference _returnType = ((JvmOperation)it_1).getReturnType();
          boolean _tripleEquals = (_returnType == null);
          if (_tripleEquals) {
            tracedAppendable.append("void");
          } else {
            this._errorSafeExtensions.serializeSafely(((JvmOperation)it_1).getReturnType(), "Object", tracedAppendable);
          }
          tracedAppendable.append(" ");
          this._treeAppendableUtil.traceSignificant(tracedAppendable, it_1).append(((JvmOperation)it_1).getSimpleName());
          tracedAppendable.append("(");
          this.generateParameters(((JvmExecutable)it_1), tracedAppendable, null);
          tracedAppendable.append(")");
          this.generateThrowsClause(((JvmExecutable)it_1), tracedAppendable, null);
          tracedAppendable.append(";");
        } else {
          if ((it_1 instanceof JvmField)) {
            final ITreeAppendable tracedAppendable_1 = childAppendable.trace(it_1);
            tracedAppendable_1.newLine();
            this.generateJavaDoc(it_1, tracedAppendable_1, config);
            this.generateAnnotations(((JvmField)it_1).getAnnotations(), tracedAppendable_1, true, config);
            boolean _isStatic = ((JvmField)it_1).isStatic();
            if (_isStatic) {
              tracedAppendable_1.append("static ");
            }
            if ((((JvmField)it_1).isFinal() && ((JvmField)it_1).isStatic())) {
              tracedAppendable_1.append("final ");
            }
            boolean _isTransient = ((JvmField)it_1).isTransient();
            if (_isTransient) {
              tracedAppendable_1.append("transient ");
            }
            boolean _isVolatile = ((JvmField)it_1).isVolatile();
            if (_isVolatile) {
              tracedAppendable_1.append("volatile ");
            }
            this._errorSafeExtensions.serializeSafely(((JvmField)it_1).getType(), "Object", tracedAppendable_1);
            tracedAppendable_1.append(" ");
            this._treeAppendableUtil.traceSignificant(tracedAppendable_1, it_1).append(((JvmField)it_1).getSimpleName());
            if ((((JvmField)it_1).isFinal() && ((JvmField)it_1).isStatic())) {
              Object _constantValue = ((JvmField)it_1).getConstantValue();
              boolean _tripleNotEquals = (_constantValue != null);
              if (_tripleNotEquals) {
                tracedAppendable_1.append(" = ");
                this.generateJavaConstant(((JvmField)it_1).getConstantValue(), tracedAppendable_1);
              } else {
                this.generateInitialization(((JvmField)it_1), tracedAppendable_1, config);
              }
            }
            tracedAppendable_1.append(";");
          } else {
            this.generateMember(it_1, memberAppendable, config);
          }
        }
        memberAppendable.closeScope();
      };
      this._loopExtensions.<JvmMember>forEach(childAppendable, this.getAddedDeclarations(it, anonymousClass), _function_2, _function_3);
      childAppendable.decreaseIndentation().newLine().append("}");
      appendable.blankLine();
    };
    IterableExtensions.<JvmGenericType>filter(feature.getLocalClasses(), _function).forEach(_function_1);
  }

  private ITreeAppendable generateJavaConstant(final Object value, final ITreeAppendable appendable) {
    ITreeAppendable _xifexpression = null;
    if ((value instanceof Float)) {
      _xifexpression = appendable.append(((Float)value).toString()).append("f");
    } else {
      ITreeAppendable _xifexpression_1 = null;
      if ((value instanceof Long)) {
        _xifexpression_1 = appendable.append(((Long)value).toString()).append("l");
      } else {
        ITreeAppendable _xifexpression_2 = null;
        if ((value instanceof Character)) {
          _xifexpression_2 = appendable.append(Integer.toString(((Character)value).charValue()));
        } else {
          ITreeAppendable _xifexpression_3 = null;
          if ((value instanceof CharSequence)) {
            _xifexpression_3 = appendable.append("\"").append(this.doConvertToJavaString(((CharSequence)value).toString())).append("\"");
          } else {
            ITreeAppendable _xifexpression_4 = null;
            if (((value instanceof Number) || (value instanceof Boolean))) {
              _xifexpression_4 = appendable.append(value.toString());
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
      final EcoreUtil2.ElementReferenceAcceptor _function = (EObject referrer, EObject referenced, EReference reference, int index) -> {
        try {
          EObject _eContainer = referrer.eContainer();
          if ((_eContainer instanceof XAbstractFeatureCall)) {
            EObject _eContainer_1 = referrer.eContainer();
            final XAbstractFeatureCall containingFeature = ((XAbstractFeatureCall) _eContainer_1);
            if (((Objects.equal(containingFeature.getActualReceiver(), referrer) && (containingFeature.getFeature() instanceof JvmMember)) && (!this.isVisible(((JvmMember) containingFeature.getFeature()), localType)))) {
              references.clear();
              throw new XtendGenerator.StopCollecting();
            }
          }
          final XtendTypeDeclaration enclosingType = EcoreUtil2.<XtendTypeDeclaration>getContainerOfType(referrer, XtendTypeDeclaration.class);
          if (((enclosingType != null) && (!Objects.equal(enclosingType, anonymousClass)))) {
            boolean _isEmpty = references.isEmpty();
            if (_isEmpty) {
              references.add(referrer);
            }
            return;
          }
          final XClosure enclosingLambda = EcoreUtil2.<XClosure>getContainerOfType(referrer, XClosure.class);
          if (((enclosingLambda != null) && EcoreUtil.isAncestor(anonymousClass, enclosingLambda))) {
            boolean _isEmpty_1 = references.isEmpty();
            if (_isEmpty_1) {
              references.add(referrer);
            }
          }
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      EcoreUtil2.findCrossReferences(anonymousClass, CollectionLiterals.<JvmDeclaredType>newImmutableSet(localType), _function);
    } catch (final Throwable _t) {
      if (_t instanceof XtendGenerator.StopCollecting) {
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
    if ((Objects.equal(type, context) || EcoreUtil.isAncestor(context, type))) {
      return true;
    }
    if (((type != null) && (Objects.equal(visibility, JvmVisibility.DEFAULT) || Objects.equal(visibility, JvmVisibility.PROTECTED)))) {
      if (((Strings.isEmpty(context.getPackageName()) && Strings.isEmpty(type.getPackageName())) || Objects.equal(context.getPackageName(), type.getPackageName()))) {
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
        if ((it.getDeclaringType().isLocal() && (it instanceof JvmOperation))) {
          JvmDeclaredType _declaringType_1 = it.getDeclaringType();
          final JvmGenericType declarator = ((JvmGenericType) _declaringType_1);
          boolean _isAnonymous = declarator.isAnonymous();
          boolean _not = (!_isAnonymous);
          if (_not) {
            return result;
          }
        }
      } else {
        JvmVisibility _visibility_1 = it.getVisibility();
        boolean _equals_1 = Objects.equal(_visibility_1, JvmVisibility.PUBLIC);
        if (_equals_1) {
          if (((it.getDeclaringType() instanceof JvmGenericType) && ((JvmGenericType) it.getDeclaringType()).isInterface())) {
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
        appendable.append("{").increaseIndentation();
        EObject _head = IterableExtensions.<EObject>head(this.getSourceElements(it));
        final AnonymousClass anonymousClass = ((AnonymousClass) _head);
        if (((!appendable.hasName(Pair.<String, JvmDeclaredType>of("this", it))) && this.needSyntheticThisVariable(anonymousClass, it))) {
          final IResolvedTypes resolvedTypes = this.typeResolver.resolveTypes(anonymousClass);
          final LightweightTypeReference actualType = resolvedTypes.getActualType(anonymousClass);
          Pair<String, JvmDeclaredType> _mappedTo = Pair.<String, JvmDeclaredType>of("this", it);
          final String thisName = appendable.declareSyntheticVariable(_mappedTo, "_this");
          appendable.newLine().append("final ").append(actualType).append(" ").append(thisName).append(" = this;");
        }
        final Function1<JvmField, Boolean> _function = (JvmField it_1) -> {
          boolean _xblockexpression_1 = false;
          {
            Procedure1<? super ITreeAppendable> _compilationStrategy = this._jvmTypeExtensions.getCompilationStrategy(it_1);
            boolean _tripleNotEquals = (_compilationStrategy != null);
            if (_tripleNotEquals) {
              return Boolean.valueOf(true);
            } else {
              StringConcatenationClient _compilationTemplate = this._jvmTypeExtensions.getCompilationTemplate(it_1);
              boolean _tripleNotEquals_1 = (_compilationTemplate != null);
              if (_tripleNotEquals_1) {
                return Boolean.valueOf(true);
              } else {
                boolean _not = (!(it_1.isFinal() && it_1.isStatic()));
                if (_not) {
                  final XExpression expression = this._iLogicalContainerProvider.getAssociatedExpression(it_1);
                  if (((expression != null) && config.isGenerateExpressions())) {
                    return Boolean.valueOf(true);
                  }
                }
              }
            }
            _xblockexpression_1 = false;
          }
          return Boolean.valueOf(_xblockexpression_1);
        };
        final Iterable<JvmField> fieldsWithInitializer = IterableExtensions.<JvmField>filter(it.getDeclaredFields(), _function);
        boolean _isEmpty = IterableExtensions.isEmpty(fieldsWithInitializer);
        boolean _not = (!_isEmpty);
        if (_not) {
          appendable.newLine().append("{").increaseIndentation();
          final Procedure1<LoopParams> _function_1 = (LoopParams it_1) -> {
            it_1.setSeparator(this.memberSeparator());
          };
          final Procedure1<JvmField> _function_2 = (JvmField it_1) -> {
            final ITreeAppendable memberAppendable = this._treeAppendableUtil.traceWithComments(appendable, it_1);
            memberAppendable.openScope();
            appendable.newLine();
            final ITreeAppendable tracedAppendable = appendable.trace(it_1);
            this._treeAppendableUtil.traceSignificant(tracedAppendable, it_1).append(it_1.getSimpleName());
            this.generateInitialization(it_1, tracedAppendable, config);
            tracedAppendable.append(";");
            memberAppendable.closeScope();
          };
          this._loopExtensions.<JvmField>forEach(appendable, fieldsWithInitializer, _function_1, _function_2);
          appendable.decreaseIndentation().newLine().append("}");
        }
        final Procedure1<LoopParams> _function_3 = (LoopParams it_1) -> {
          it_1.setSeparator(this.memberSeparator());
        };
        final Procedure1<JvmMember> _function_4 = (JvmMember it_1) -> {
          final ITreeAppendable memberAppendable = this._treeAppendableUtil.traceWithComments(appendable, it_1);
          memberAppendable.openScope();
          this.generateMember(it_1, memberAppendable, config);
          memberAppendable.closeScope();
        };
        this._loopExtensions.<JvmMember>forEach(appendable, this.getMembersToBeCompiled(it), _function_3, _function_4);
        _xblockexpression = appendable.decreaseIndentation().newLine().append("}");
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = super.generateMembersInBody(it, appendable, config);
    }
    return _xifexpression;
  }
}
