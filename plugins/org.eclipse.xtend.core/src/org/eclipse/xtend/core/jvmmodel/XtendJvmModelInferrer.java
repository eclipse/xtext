/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.jvmmodel;

import static com.google.common.collect.Lists.*;
import static org.eclipse.xtext.xbase.compiler.JavaVersion.*;

import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.macro.ActiveAnnotationContext;
import org.eclipse.xtend.core.macro.ActiveAnnotationContextProvider;
import org.eclipse.xtend.core.macro.ActiveAnnotationContexts;
import org.eclipse.xtend.core.macro.AnnotationProcessor;
import org.eclipse.xtend.core.xtend.AnonymousClass;
import org.eclipse.xtend.core.xtend.CreateExtensionInfo;
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
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationTarget;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.documentation.IFileHeaderProvider;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.CompilerPhases;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.compiler.DisableCodeGenerationAdapter;
import org.eclipse.xtext.xbase.compiler.GeneratorConfig;
import org.eclipse.xtext.xbase.compiler.IGeneratorConfigProvider;
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociator;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeExtensions;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.resource.BatchLinkableResource;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.ListMultimap;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sven Efftinge
 * @author Sebastian Zarnekow - Re-Implemented type system and type inference
 */
public class XtendJvmModelInferrer extends AbstractModelInferrer {

	public static final String CREATE_INITIALIZER_PREFIX = "_init_";

	public static final String CREATE_CHACHE_VARIABLE_PREFIX = "_createCache_";
	
	private final static Logger logger = Logger.getLogger(XtendJvmModelInferrer.class);

	@Inject
	private TypesFactory typesFactory;

	@Inject
	private IJvmModelAssociator associator;

	@Inject
	private IXtendJvmAssociations associations;

	@Inject
	private DispatchHelper dispatchHelper;

	@Inject
	private TypeReferences typeReferences;

	@Inject
	private XtendCompileStrategies compileStrategies;

	@Inject
	private JvmTypesBuilder jvmTypesBuilder;

	@Inject
	private SyntheticNameClashResolver nameClashResolver;
	
	@Inject
	private JvmTypeExtensions typeExtensions;
	
	@Inject
	private IFileHeaderProvider fileHeaderProvider;
	
	@Inject
	private AnnotationProcessor annotationProcessor;
	
	@Inject
	private ActiveAnnotationContextProvider contextProvider;
	
	@Inject
	private CompilerPhases compilerPhases;
	
	@Inject
	private IGeneratorConfigProvider generatorConfigProvider;
	
	@Inject
	private OperationCanceledManager operationCanceledManager;
	
	private GeneratorConfig generatorConfig;
	
	@Override
	public void infer(/* @Nullable */ EObject object, final /* @NonNull */ IJvmDeclaredTypeAcceptor acceptor, boolean preIndexingPhase) {
		if (!(object instanceof XtendFile))
			return;
		final Set<JvmDeclaredType> types = new LinkedHashSet<JvmDeclaredType>();
		final IJvmDeclaredTypeAcceptor wrapper = new IJvmDeclaredTypeAcceptor() {

			@SuppressWarnings("deprecation")
			@Override
			public <T extends JvmDeclaredType> IPostIndexingInitializing<T> accept(T type) {
				types.add(type);
				return acceptor.accept(type);
			}

			@Override
			public <T extends JvmDeclaredType> void accept(T type, Procedure1<? super T> lateInitialization) {
				types.add(type);
				acceptor.accept(type, lateInitialization);
			}
			
		};
		final XtendFile xtendFile = (XtendFile) object;
		generatorConfig = generatorConfigProvider.get(xtendFile);
		final List<Runnable> doLater = newArrayList();
		for (final XtendTypeDeclaration declaration: xtendFile.getXtendTypes()) {
			inferTypeSceleton(declaration, wrapper, preIndexingPhase, xtendFile, doLater, null);
		}
		ActiveAnnotationContexts contexts = null;
		BatchLinkableResource resource = (BatchLinkableResource)xtendFile.eResource();
		try {
			compilerPhases.setIndexing(xtendFile, true);
			try {
				contexts = contextProvider.computeContext(xtendFile);
			} catch (Throwable t) {
				operationCanceledManager.propagateAsErrorIfCancelException(t);
				logger.error("Couldn't create annotation contexts", t);
				return;
			}
			try {
				contexts.before(ActiveAnnotationContexts.AnnotationCallback.INDEXING);
				for (ActiveAnnotationContext ctx : contexts.getContexts().values()) {
					try {
						annotationProcessor.indexingPhase(ctx, wrapper, CancelIndicator.NullImpl);
					} catch (Throwable t) {
						operationCanceledManager.propagateAsErrorIfCancelException(t);
						ctx.handleProcessingError(xtendFile.eResource(), t);
					}
				}
			} finally {
				contexts.after(ActiveAnnotationContexts.AnnotationCallback.INDEXING);
			}
		} finally {
			compilerPhases.setIndexing(xtendFile, false);
			resource.getCache().clear(resource);
		}
		
		if (!preIndexingPhase) {
			final ActiveAnnotationContexts finalContexts = contexts;
			Runnable lateInit = new Runnable() {

				@Override
				public void run() {
					for (Runnable runnable : doLater) {
						runnable.run();
					}
					try {
						finalContexts.before(ActiveAnnotationContexts.AnnotationCallback.INFERENCE);
						for (ActiveAnnotationContext ctx : finalContexts.getContexts().values()) {
							try {
								annotationProcessor.inferencePhase(ctx, CancelIndicator.NullImpl);
							} catch (Throwable t) {
								operationCanceledManager.propagateAsErrorIfCancelException(t);
								ctx.handleProcessingError(xtendFile.eResource(), t);
							}
						}
					} finally {
						finalContexts.after(ActiveAnnotationContexts.AnnotationCallback.INFERENCE);
					}
				}
			};
			resource.addJvmMemberInitializer(lateInit);
		}
	}

	protected void inferTypeSceleton(final XtendTypeDeclaration declaration, final IJvmDeclaredTypeAcceptor acceptor, 
			boolean preIndexingPhase, XtendFile xtendFile, List<Runnable> doLater, JvmDeclaredType containerSceleton) { 
		JvmDeclaredType inferredSceleton = doInferTypeSceleton(declaration, acceptor, preIndexingPhase, xtendFile, doLater);
		if(inferredSceleton != null) {
			setNameAndAssociate(xtendFile, declaration, inferredSceleton);
			if(containerSceleton != null)
				containerSceleton.getMembers().add(inferredSceleton);
			acceptor.accept(inferredSceleton);
			for(XtendMember member: declaration.getMembers()) {
				if(member instanceof XtendTypeDeclaration)
					inferTypeSceleton((XtendTypeDeclaration) member, acceptor, preIndexingPhase, xtendFile, doLater, inferredSceleton);
			}
		}
	}
	
	protected JvmDeclaredType doInferTypeSceleton(final XtendTypeDeclaration declaration, final IJvmDeclaredTypeAcceptor acceptor,
			boolean preIndexingPhase, XtendFile xtendFile, List<Runnable> doLater) {
		if (Strings.isEmpty(declaration.getName()))
			return null;
		
		if (declaration instanceof XtendAnnotationType) {
			final JvmAnnotationType annotation = typesFactory.createJvmAnnotationType();
			if (!preIndexingPhase) {
				doLater.add(new Runnable() {
					@Override
					public void run() {
						initialize((XtendAnnotationType)declaration, annotation);
					}
				});
			}
			return annotation;
		} else if (declaration instanceof XtendClass) {
			XtendClass xtendClass = (XtendClass) declaration;
			final JvmGenericType javaType = typesFactory.createJvmGenericType();
			copyTypeParameters(xtendClass.getTypeParameters(), javaType);
			if (!preIndexingPhase) {
				doLater.add(new Runnable() {
					@Override
					public void run() {
						initialize((XtendClass) declaration, javaType);
					}
				});
			}
			return javaType;
		} else if (declaration instanceof XtendInterface) {
			XtendInterface xtendInterface = (XtendInterface) declaration;
			final JvmGenericType javaType = typesFactory.createJvmGenericType();
			javaType.setInterface(true);
			copyTypeParameters(xtendInterface.getTypeParameters(), javaType);
			if (!preIndexingPhase) {
				doLater.add(new Runnable() {
					@Override
					public void run() {
						initialize((XtendInterface) declaration, javaType);
					}
				});
			}
			return javaType;
		} else if (declaration instanceof XtendEnum) {
			final JvmEnumerationType javaType = typesFactory.createJvmEnumerationType();
			if (!preIndexingPhase) {
				doLater.add(new Runnable() {
					@Override
					public void run() {
						initialize((XtendEnum) declaration, javaType);
					}
				});
			}
			return javaType;
		} else {
			return null;
		}
	}

	protected void setNameAndAssociate(XtendFile file, XtendTypeDeclaration xtendType, JvmDeclaredType javaType) {
		javaType.setPackageName(file.getPackage());
		javaType.setSimpleName(xtendType.getName());
		javaType.setVisibility(JvmVisibility.PUBLIC);
		setFileHeader(file, javaType);
		associator.associatePrimary(xtendType, javaType);
	}

	protected void setFileHeader(final XtendFile xtendFile, final JvmDeclaredType jvmDeclaredType) {
		String headerText = fileHeaderProvider.getFileHeader(xtendFile.eResource());
		jvmTypesBuilder.setFileHeader(jvmDeclaredType, headerText);
	}
	
	protected void initialize(XtendAnnotationType source, JvmAnnotationType inferredJvmType) {
		inferredJvmType.setVisibility(source.getVisibility());
		inferredJvmType.setStatic(source.isStatic() && !isTopLevel(source));
		inferredJvmType.setAbstract(true);
		translateAnnotationsTo(source.getAnnotations(), inferredJvmType);
		jvmTypesBuilder.copyDocumentationTo(source, inferredJvmType);
		for (XtendMember member : source.getMembers()) {
			if (member instanceof XtendField) {
				XtendField field = (XtendField) member;
				if (!Strings.isEmpty(field.getName())) {
					JvmOperation operation = typesFactory.createJvmOperation();
					associator.associatePrimary(member, operation);
					operation.setSimpleName(field.getName());
					JvmTypeReference returnType = null;
					XExpression initialValue = field.getInitialValue();
					if (field.getType() != null) {
						returnType = jvmTypesBuilder.cloneWithProxies(field.getType());
					} else if (initialValue != null) {
						returnType = jvmTypesBuilder.inferredType(initialValue);
					}
					operation.setReturnType(returnType);
					if (initialValue != null) {
						JvmAnnotationValue jvmAnnotationValue = jvmTypesBuilder.toJvmAnnotationValue(initialValue);
						if (jvmAnnotationValue != null) {
							operation.setDefaultValue(jvmAnnotationValue);
							jvmAnnotationValue.setOperation(operation);
						}
						jvmTypesBuilder.setBody(operation, initialValue);
					}
					operation.setVisibility(JvmVisibility.PUBLIC);
					translateAnnotationsTo(member.getAnnotations(), operation);
					jvmTypesBuilder.copyDocumentationTo(member, operation);
					inferredJvmType.getMembers().add(operation);
				}
			}
		}
	}

	protected void translateAnnotationsTo(List<XAnnotation> annotations, JvmAnnotationTarget target) {
		jvmTypesBuilder.addAnnotations(target, Iterables.filter(annotations, annotationTranslationFilter));
	}
	
	protected void initialize(XtendClass source, JvmGenericType inferredJvmType) {
		inferredJvmType.setVisibility(source.getVisibility());
		boolean isStatic = source.isStatic() && !isTopLevel(source);
		if (!isStatic) {
			JvmDeclaredType declaringType = inferredJvmType.getDeclaringType();
			if (declaringType instanceof JvmGenericType) {
				if (((JvmGenericType) declaringType).isInterface())
					isStatic = true;
			} else if (declaringType instanceof JvmAnnotationType) {
				isStatic = true;
			}
		}
		inferredJvmType.setStatic(isStatic);
		inferredJvmType.setAbstract(source.isAbstract());
		inferredJvmType.setStrictFloatingPoint(source.isStrictFloatingPoint());
		if (!inferredJvmType.isAbstract()) {
			inferredJvmType.setFinal(source.isFinal());
		}
		translateAnnotationsTo(source.getAnnotations(), inferredJvmType);
		JvmTypeReference extendsClause = source.getExtends();
		if (extendsClause == null || extendsClause.getType() == null) {
			JvmTypeReference typeRefToObject = typeReferences.getTypeForName(Object.class, source);
			if (typeRefToObject != null)
				inferredJvmType.getSuperTypes().add(typeRefToObject);
		} else {
			inferredJvmType.getSuperTypes().add(jvmTypesBuilder.cloneWithProxies(extendsClause));
		}
		for (JvmTypeReference intf : source.getImplements()) {
			inferredJvmType.getSuperTypes().add(jvmTypesBuilder.cloneWithProxies(intf));
		}
		fixTypeParameters(inferredJvmType);
		addDefaultConstructor(source, inferredJvmType);
		for (XtendMember member : source.getMembers()) {
			if (member instanceof XtendField
					|| (member instanceof XtendFunction && ((XtendFunction) member).getName() != null)
					|| member instanceof XtendConstructor) {
				transform(member, inferredJvmType, true);
			}
		}
		
		appendSyntheticDispatchMethods(source, inferredJvmType);
		jvmTypesBuilder.copyDocumentationTo(source, inferredJvmType);
		nameClashResolver.resolveNameClashes(inferredJvmType);
		
	}
	
	protected void initialize(XtendInterface source, JvmGenericType inferredJvmType) {
		inferredJvmType.setVisibility(source.getVisibility());
		inferredJvmType.setStatic(source.isStatic() && !isTopLevel(source));
		inferredJvmType.setAbstract(true);
		inferredJvmType.setStrictFloatingPoint(source.isStrictFloatingPoint());
		translateAnnotationsTo(source.getAnnotations(), inferredJvmType);
		for (JvmTypeReference intf : source.getExtends()) {
			inferredJvmType.getSuperTypes().add(jvmTypesBuilder.cloneWithProxies(intf));
		}
		fixTypeParameters(inferredJvmType);
		for (XtendMember member : source.getMembers()) {
			if (member instanceof XtendField
					|| (member instanceof XtendFunction && ((XtendFunction) member).getName() != null)) {
				transform(member, inferredJvmType, false);
			}
		}
		jvmTypesBuilder.copyDocumentationTo(source, inferredJvmType);
		nameClashResolver.resolveNameClashes(inferredJvmType);
	}
	
	protected void initialize(XtendEnum source, JvmEnumerationType inferredJvmType) {
		inferredJvmType.setVisibility(source.getVisibility());
		inferredJvmType.setStatic(source.isStatic() && !isTopLevel(source));
		translateAnnotationsTo(source.getAnnotations(), inferredJvmType);
		for (XtendMember member : source.getMembers()) {
			if (member instanceof XtendEnumLiteral) 
				transform((XtendEnumLiteral) member, inferredJvmType);
		}
		jvmTypesBuilder.copyDocumentationTo(source, inferredJvmType);
	}
	
	protected boolean isTopLevel(XtendTypeDeclaration declaration) {
		return declaration.eContainingFeature() == XtendPackage.Literals.XTEND_FILE__XTEND_TYPES;
	}
	
	protected void copyAndFixTypeParameters(List<JvmTypeParameter> typeParameters, JvmTypeParameterDeclarator target) {
		copyTypeParameters(typeParameters, target);
		fixTypeParameters(target);
	}
	
	protected void copyTypeParameters(List<JvmTypeParameter> typeParameters, JvmTypeParameterDeclarator target) {
		for (JvmTypeParameter typeParameter : typeParameters) {
			if (!Strings.isEmpty(typeParameter.getName())) {
				final JvmTypeParameter clonedTypeParameter = jvmTypesBuilder.cloneWithProxies(typeParameter);
				if (clonedTypeParameter != null) {
					target.getTypeParameters().add(clonedTypeParameter);
					associator.associate(typeParameter, clonedTypeParameter);
				}
			}
		}
	}
	
	protected void fixTypeParameters(JvmTypeParameterDeclarator target) {
		for (JvmTypeParameter typeParameter : target.getTypeParameters()) {
			boolean upperBoundSeen = false;
			for (JvmTypeConstraint constraint : typeParameter.getConstraints()) {
				if (constraint instanceof JvmUpperBound) {
					upperBoundSeen = true;
					break;
				}
			}
			if (!upperBoundSeen) {
				JvmUpperBound upperBound = typesFactory.createJvmUpperBound();
				upperBound.setTypeReference(typeReferences.getTypeForName(Object.class, target));
				typeParameter.getConstraints().add(upperBound);
			}
		}
	}

	protected void appendSyntheticDispatchMethods(XtendTypeDeclaration source, final JvmGenericType target) {
		ListMultimap<DispatchHelper.DispatchSignature, JvmOperation> methods = dispatchHelper.getDeclaredOrEnhancedDispatchMethods(target);
		for (DispatchHelper.DispatchSignature signature : methods.keySet()) {
			List<JvmOperation> operations = methods.get(signature);
			Iterable<JvmOperation> localOperations = Iterables.filter(operations, new Predicate<JvmOperation>() {
				@Override
				public boolean apply(JvmOperation input) {
					return target == input.eContainer();
				}
			});
			JvmOperation operation = deriveGenericDispatchOperationSignature(localOperations, target);
			if (operation != null) {
				dispatchHelper.markAsDispatcherFunction(operation);
				operation.setSimpleName(signature.getSimpleName());
				operation.setReturnType(jvmTypesBuilder.inferredType());
			}
		}
	}

	/**
	 * @return a {@link JvmOperation} with common denominator argument types of all given operations
	 */
	/* @Nullable */
	protected JvmOperation deriveGenericDispatchOperationSignature(Iterable<JvmOperation> localOperations,
			JvmGenericType target) {
		final Iterator<JvmOperation> iterator = localOperations.iterator();
		if (!iterator.hasNext())
			return null;
		JvmOperation first = iterator.next();
		JvmOperation result = typesFactory.createJvmOperation();
		target.getMembers().add(result);
		for (int i = 0; i < first.getParameters().size(); i++) {
			JvmFormalParameter parameter = typesFactory.createJvmFormalParameter();
			result.getParameters().add(parameter);
			parameter.setParameterType(jvmTypesBuilder.inferredType());
			JvmFormalParameter parameter2 = first.getParameters().get(i);
			parameter.setName(parameter2.getName());
		}
		jvmTypesBuilder.setBody(result, compileStrategies.forDispatcher(result));
		JvmVisibility commonVisibility = null;
		boolean isFirst = true;
		boolean allStatic = true;
		for (JvmOperation jvmOperation : localOperations) {
			Iterable<XtendFunction> xtendFunctions = Iterables.filter(associations.getSourceElements(jvmOperation),
					XtendFunction.class);
			for (XtendFunction func : xtendFunctions) {
				JvmVisibility xtendVisibility = func.getDeclaredVisibility();
				if (isFirst) {
					commonVisibility = xtendVisibility;
					isFirst = false;
				} else if (commonVisibility != xtendVisibility) {
					commonVisibility = null;
				}
				associator.associate(func, result);
				if (!func.isStatic())
					allStatic = false;
			}
			for (JvmTypeReference declaredException : jvmOperation.getExceptions())
				result.getExceptions().add(jvmTypesBuilder.cloneWithProxies(declaredException));
		}
		if (commonVisibility == null)
			result.setVisibility(JvmVisibility.PUBLIC);
		else
			result.setVisibility(commonVisibility);
		result.setStatic(allStatic);
		return result;
	}

	protected void addDefaultConstructor(XtendClass source, JvmGenericType target) {
		for (XtendMember member : source.getMembers()) {
			if (member instanceof XtendConstructor)
				return;
		}
		JvmConstructor constructor = typesFactory.createJvmConstructor();
		target.getMembers().add(constructor);
		associator.associate(source, constructor);
		constructor.setSimpleName(source.getName());
		constructor.setVisibility(JvmVisibility.PUBLIC);
		typeExtensions.setSynthetic(constructor, true);
	}

	protected void transform(XtendMember sourceMember, JvmGenericType container, boolean allowDispatch) {
		if (sourceMember instanceof XtendFunction) {
			transform((XtendFunction) sourceMember, container, allowDispatch);
		} else if (sourceMember instanceof XtendField) {
			transform((XtendField) sourceMember, container);
		} else if (sourceMember instanceof XtendConstructor) {
			transform((XtendConstructor) sourceMember, container);
		} else if (sourceMember instanceof XtendEnumLiteral && container instanceof JvmEnumerationType) {
			transform((XtendEnumLiteral) sourceMember, (JvmEnumerationType) container);
		} else {
			throw new IllegalArgumentException("Cannot transform " + String.valueOf(sourceMember) + " to a JvmMember");
		}
	}

	protected void transform(XtendFunction source, JvmGenericType container, boolean allowDispatch) {
		JvmOperation operation = typesFactory.createJvmOperation();
		operation.setAbstract(source.isAbstract());
		operation.setNative(source.isNative());
		operation.setSynchronized(source.isSynchonized());
		operation.setStrictFloatingPoint(source.isStrictFloatingPoint());
		if (!source.isAbstract())
			operation.setFinal(source.isFinal());
		container.getMembers().add(operation);
		associator.associatePrimary(source, operation);
		String sourceName = source.getName();
		JvmVisibility visibility = source.getVisibility();
		if (allowDispatch && source.isDispatch()) {
			if (source.getDeclaredVisibility() == null)
				visibility = JvmVisibility.PROTECTED;
			sourceName = "_" + sourceName;
		}
		operation.setSimpleName(sourceName);
		operation.setVisibility(visibility);
		operation.setStatic(source.isStatic());
		if (!operation.isAbstract() && !operation.isStatic() && container.isInterface())
			operation.setDefault(true);
		for (XtendParameter parameter : source.getParameters()) {
			translateParameter(operation, parameter);
		}
		XExpression expression = source.getExpression();
		CreateExtensionInfo createExtensionInfo = source.getCreateExtensionInfo();
		
		JvmTypeReference returnType = null;
		if (source.getReturnType() != null) {
			returnType = jvmTypesBuilder.cloneWithProxies(source.getReturnType());
		} else if (createExtensionInfo != null) {
			returnType = jvmTypesBuilder.inferredType(createExtensionInfo.getCreateExpression());
		} else if (expression != null) {
			returnType = jvmTypesBuilder.inferredType(expression);
		} else {
			returnType = jvmTypesBuilder.inferredType();
		}
		
		operation.setReturnType(returnType);
		copyAndFixTypeParameters(source.getTypeParameters(), operation);
		for (JvmTypeReference exception : source.getExceptions()) {
			operation.getExceptions().add(jvmTypesBuilder.cloneWithProxies(exception));
		}
		translateAnnotationsTo(source.getAnnotations(), operation);
		if (source.isOverride() && generatorConfig.getJavaSourceVersion().isAtLeast(JAVA6)
				&& !containsAnnotation(operation, Override.class)
				&& typeReferences.findDeclaredType(Override.class, source) != null) {
			operation.getAnnotations().add(_annotationTypesBuilder.annotationRef(Override.class));
		}
		if (createExtensionInfo != null) {
			transformCreateExtension(source, createExtensionInfo, container, operation, returnType);
		} else {
			setBody(operation, expression);
		}
		jvmTypesBuilder.copyDocumentationTo(source, operation);
	}
	
	private boolean containsAnnotation(JvmAnnotationTarget annotationTarget, Class<? extends Annotation> annotationClass) {
		for (JvmAnnotationReference annotationRef : annotationTarget.getAnnotations()) {
			if (annotationClass.getName().equals(annotationRef.getAnnotation().getIdentifier())) {
				return true;
			}
		}
		return false;
	}

	protected void setBody(JvmExecutable executable, XExpression expression) {
		associator.associateLogicalContainer(expression, executable);
		initializeLocalTypes(executable, expression);
	}
	
	protected void transformCreateExtension(XtendFunction source, CreateExtensionInfo createExtensionInfo,
			JvmGenericType container, JvmOperation operation, /* @Nullable */ JvmTypeReference returnType) {
		JvmField cacheVar = jvmTypesBuilder.toField(
				source, CREATE_CHACHE_VARIABLE_PREFIX + source.getName(), jvmTypesBuilder.inferredType());
		if (cacheVar != null) {
			cacheVar.setFinal(true);
			jvmTypesBuilder.setInitializer(cacheVar, compileStrategies.forCacheVariable(source));
			container.getMembers().add(cacheVar);

			JvmOperation initializer = typesFactory.createJvmOperation();
			container.getMembers().add(initializer);
			initializer.setSimpleName(CREATE_INITIALIZER_PREFIX + source.getName());
			initializer.setVisibility(JvmVisibility.PRIVATE);
			initializer.setReturnType(typeReferences.getTypeForName(Void.TYPE, source));
			for (JvmTypeReference exception : source.getExceptions()) {
				initializer.getExceptions().add(jvmTypesBuilder.cloneWithProxies(exception));
			}

			jvmTypesBuilder.setBody(operation,
					compileStrategies.forCacheMethod(createExtensionInfo, cacheVar, initializer));

			// the first parameter is the created object
			JvmFormalParameter jvmParam = typesFactory.createJvmFormalParameter();
			jvmParam.setName(createExtensionInfo.getName());
			// TODO consider type parameters
			jvmParam.setParameterType(jvmTypesBuilder.inferredType());
			
			initializer.getParameters().add(jvmParam);
			associator.associate(createExtensionInfo, jvmParam);

			// add all others
			for (XtendParameter parameter : source.getParameters()) {
				jvmParam = typesFactory.createJvmFormalParameter();
				jvmParam.setName(parameter.getName());
				jvmParam.setParameterType(jvmTypesBuilder.cloneWithProxies(parameter.getParameterType()));
				initializer.getParameters().add(jvmParam);
				associator.associate(parameter, jvmParam);
			}
			associator.associate(source, initializer);
			setBody(operation, createExtensionInfo.getCreateExpression());
			setBody(initializer, source.getExpression());
		}
	}

	protected void translateParameter(JvmExecutable executable, XtendParameter parameter) {
		JvmFormalParameter jvmParam = typesFactory.createJvmFormalParameter();
		jvmParam.setName(parameter.getName());
		if (parameter.isVarArg()) {
			executable.setVarArgs(true);
			JvmGenericArrayTypeReference arrayType = typeReferences.createArrayType(jvmTypesBuilder
					.cloneWithProxies(parameter.getParameterType()));
			jvmParam.setParameterType(arrayType);
		} else {
			jvmParam.setParameterType(jvmTypesBuilder.cloneWithProxies(parameter.getParameterType()));
		}
		associator.associate(parameter, jvmParam);
		translateAnnotationsTo(parameter.getAnnotations(), jvmParam);
		if (parameter.isExtension() && typeReferences.findDeclaredType(Extension.class, parameter) != null) {
			jvmParam.getAnnotations().add(_annotationTypesBuilder.annotationRef(Extension.class));
		}
		executable.getParameters().add(jvmParam);
	}

	protected void transform(XtendConstructor source, JvmGenericType container) {
		JvmConstructor constructor = typesFactory.createJvmConstructor();
		container.getMembers().add(constructor);
		associator.associatePrimary(source, constructor);
		JvmVisibility visibility = source.getVisibility();
		constructor.setSimpleName(container.getSimpleName());
		constructor.setVisibility(visibility);
		for (XtendParameter parameter : source.getParameters()) {
			translateParameter(constructor, parameter);
		}
		copyAndFixTypeParameters(source.getTypeParameters(), constructor);
		for (JvmTypeReference exception : source.getExceptions()) {
			constructor.getExceptions().add(jvmTypesBuilder.cloneWithProxies(exception));
		}
		translateAnnotationsTo(source.getAnnotations(), constructor);
		setBody(constructor, source.getExpression());
		jvmTypesBuilder.copyDocumentationTo(source, constructor);
	}
	
	protected void transform(XtendField source, JvmGenericType container) {
		if ((source.isExtension() && source.getType() != null) || source.getName() != null) {
			JvmField field = typesFactory.createJvmField();
			final String computeFieldName = computeFieldName(source);
			field.setSimpleName(computeFieldName);
			container.getMembers().add(field);
			associator.associatePrimary(source, field);
			field.setVisibility(source.getVisibility());
			field.setStatic(source.isStatic());
			field.setTransient(source.isTransient());
			field.setVolatile(source.isVolatile());
			field.setFinal(source.isFinal());
			if (source.getType() != null) {
				field.setType(jvmTypesBuilder.cloneWithProxies(source.getType()));
			} else if (source.getInitialValue() != null) {
				field.setType(jvmTypesBuilder.inferredType(source.getInitialValue()));
			}
			for (XAnnotation anno : source.getAnnotations()) {
				if (!annotationTranslationFilter.apply(anno))
					continue;
				JvmAnnotationReference annotationReference = jvmTypesBuilder.getJvmAnnotationReference(anno);
				if(annotationReference != null)
					field.getAnnotations().add(annotationReference);
			}
			if (source.isExtension() && typeReferences.findDeclaredType(Extension.class, source) != null) {
				field.getAnnotations().add(_annotationTypesBuilder.annotationRef(Extension.class));
			}
			jvmTypesBuilder.copyDocumentationTo(source, field);
			jvmTypesBuilder.setInitializer(field, source.getInitialValue());
			initializeLocalTypes(field, source.getInitialValue());
		}
	}

	protected void transform(XtendEnumLiteral literal, JvmEnumerationType container) {
		JvmEnumerationLiteral jvmLiteral = typesFactory.createJvmEnumerationLiteral();
		associator.associatePrimary(literal, jvmLiteral);
		jvmLiteral.setSimpleName(literal.getName());
		jvmLiteral.setVisibility(JvmVisibility.PUBLIC);
		jvmLiteral.setStatic(true);
		jvmLiteral.setFinal(true);
		container.getMembers().add(jvmLiteral);
	}
	
	private Predicate<XAnnotation> annotationTranslationFilter = new Predicate<XAnnotation>() {
		@Override
		public boolean apply(/* @Nullable */ XAnnotation annotation) {
			if (annotation == null || annotation.getAnnotationType() == null)
				return false;
			JvmType annotationType = annotation.getAnnotationType();
			if (annotationType instanceof JvmAnnotationType && DisableCodeGenerationAdapter.isDisabled((JvmDeclaredType) annotationType))
				return false;
			return true;
		}
	};

	/* @Nullable */
	protected String computeFieldName(XtendField field) {
		if (field.getName() != null)
			return field.getName();
		JvmTypeReference type = field.getType();
		String name = null;
		if (type != null) {
			while (type instanceof JvmGenericArrayTypeReference) {
				type = ((JvmGenericArrayTypeReference) type).getComponentType();
			}
			if (type instanceof JvmParameterizedTypeReference) {
				List<INode> nodes = NodeModelUtils.findNodesForFeature(type,
						TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
				if (!nodes.isEmpty()) {
					String typeName = nodes.get(0).getText().trim();
					int lastDot = typeName.lastIndexOf('.');
					if (lastDot != -1) {
						typeName = typeName.substring(lastDot + 1);
					}
					name = "_" + Strings.toFirstLower(typeName);
				}
			}
		}
		return name;
	}
	
	private void initializeLocalTypes(JvmFeature feature, XExpression expression) {
		if (expression != null) {
			TreeIterator<EObject> iterator = EcoreUtil2.getAllNonDerivedContents(expression, true);
			String nameStub = "__" + feature.getDeclaringType().getSimpleName();
			while(iterator.hasNext()) {
				EObject next = iterator.next();
				if (next.eClass() == XtendPackage.Literals.ANONYMOUS_CLASS) {
					inferLocalClass((AnonymousClass) next, nameStub, feature);
					iterator.prune();
				}
			}
		}
	}
	
	/**
	 * Anonymous classes are not inferred in the type inference phase, but later during type resolution. 
	 */
	public void inferLocalClass(
			AnonymousClass anonymousClass,
			String localClassName,
			JvmFeature container) {
		final JvmGenericType inferredType = typesFactory.createJvmGenericType();
		inferredType.setSimpleName(localClassName);
		inferredType.setAnonymous(!hasAdditionalMembers(anonymousClass));
		inferredType.setFinal(true);
		inferredType.setVisibility(JvmVisibility.DEFAULT);
		inferredType.getSuperTypes().add(jvmTypesBuilder.inferredType(anonymousClass));
		container.getLocalClasses().add(inferredType);
		associator.associatePrimary(anonymousClass, inferredType);
		for (XtendMember member : anonymousClass.getMembers()) {
			if (member instanceof XtendField
					|| (member instanceof XtendFunction && ((XtendFunction) member).getName() != null)
					|| member instanceof XtendConstructor) {
				transform(member, inferredType, true);
			}
		}
		
		appendSyntheticDispatchMethods(anonymousClass, inferredType);
		nameClashResolver.resolveNameClashes(inferredType);
	}
	
	protected boolean hasAdditionalMembers(AnonymousClass anonymousClass) {
		for(XtendMember member: anonymousClass.getMembers()) {
			if(member instanceof XtendField ||	
				(member instanceof XtendFunction && !((XtendFunction) member).isOverride())) 
				return true;
		}
		return false;
	}
	
}
