/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.jvmmodel;

import static com.google.common.collect.Lists.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtend.core.macro.ActiveAnnotationContext;
import org.eclipse.xtend.core.macro.ActiveAnnotationContextProvider;
import org.eclipse.xtend.core.macro.ActiveAnnotationContexts;
import org.eclipse.xtend.core.macro.AnnotationProcessor;
import org.eclipse.xtend.core.xtend.CreateExtensionInfo;
import org.eclipse.xtend.core.xtend.XtendAnnotationTarget;
import org.eclipse.xtend.core.xtend.XtendAnnotationType;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendConstructorCall;
import org.eclipse.xtend.core.xtend.XtendEnum;
import org.eclipse.xtend.core.xtend.XtendEnumLiteral;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendInterface;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtend.lib.Property;
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
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
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
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.compiler.DisableCodeGenerationAdapter;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociator;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeExtensions;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.resource.BatchLinkableResource;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sven Efftinge
 * @author Sebastian Zarnekow - Re-Implemented type system and type inference
 */
public class XtendJvmModelInferrer implements IJvmModelInferrer {

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

	public void infer(@Nullable EObject object, final @NonNull IJvmDeclaredTypeAcceptor acceptor, boolean preIndexingPhase) {
		if (!(object instanceof XtendFile))
			return;
		XtendFile xtendFile = (XtendFile) object;
		List<Runnable> doLater = newArrayList();
		for (final XtendTypeDeclaration declaration: xtendFile.getXtendTypes()) {
			if (Strings.isEmpty(declaration.getName()))
				continue;
			
			if (declaration instanceof XtendAnnotationType) {
				final JvmAnnotationType annotation = typesFactory.createJvmAnnotationType();
				setNameAndAssociate(xtendFile, declaration, annotation);
				acceptor.accept(annotation);
				if (!preIndexingPhase) {
					doLater.add(new Runnable() {
						public void run() {
							initialize((XtendAnnotationType)declaration, annotation);
						}
					});
				}
			} else if (declaration instanceof XtendClass) {
				XtendClass xtendClass = (XtendClass) declaration;
				final JvmGenericType javaType = typesFactory.createJvmGenericType();
				setNameAndAssociate(xtendFile, declaration, javaType);
				copyTypeParameters(xtendClass.getTypeParameters(), javaType);
				acceptor.accept(javaType);
				if (!preIndexingPhase) {
					doLater.add(new Runnable() {
						public void run() {
							initialize((XtendClass) declaration, javaType);
						}
					});
				}
			} else if (declaration instanceof XtendInterface) {
				XtendInterface xtendInterface = (XtendInterface) declaration;
				final JvmGenericType javaType = typesFactory.createJvmGenericType();
				setNameAndAssociate(xtendFile, declaration, javaType);
				copyTypeParameters(xtendInterface.getTypeParameters(), javaType);
				acceptor.accept(javaType);
				if (!preIndexingPhase) {
					doLater.add(new Runnable() {
						public void run() {
							initialize((XtendInterface) declaration, javaType);
						}
					});
				}
			} else if (declaration instanceof XtendEnum) {
				final JvmEnumerationType javaType = typesFactory.createJvmEnumerationType();
				setNameAndAssociate(xtendFile, declaration, javaType);
				acceptor.accept(javaType);
				if (!preIndexingPhase) {
					doLater.add(new Runnable() {
						public void run() {
							initialize((XtendEnum) declaration, javaType);
						}
					});
				}
			}
		}
		ActiveAnnotationContexts contexts = null;
		BatchLinkableResource resource = (BatchLinkableResource)xtendFile.eResource();
		try {
			compilerPhases.setIndexing(xtendFile, true);
			try {
				contexts = contextProvider.computeContext(xtendFile);
			} catch (Throwable t) {
				logger.error("Couldn't create annotation contexts", t);
				return;
			}
			
			for (ActiveAnnotationContext ctx : contexts.getContexts().values()) {
				try {
					annotationProcessor.indexingPhase(ctx, acceptor, CancelIndicator.NullImpl);
				} catch (Throwable t) {
					ctx.handleProcessingError(xtendFile.eResource(), t);
				}
			}
		} finally {
			compilerPhases.setIndexing(xtendFile, false);
			resource.getCache().clear(resource);
		}
		
		if (!preIndexingPhase) {
			for (Runnable runnable : doLater) {
				runnable.run();
			}
			for (ActiveAnnotationContext ctx : contexts.getContexts().values()) {
				try {
					annotationProcessor.inferencePhase(ctx, CancelIndicator.NullImpl);
				} catch (Throwable t) {
					ctx.handleProcessingError(xtendFile.eResource(), t);
				}
			}
		}
	}
	
	public JvmGenericType inferAnonymousClass(XtendClass anonymousClass, JvmMember container, XtendConstructorCall constructorCall, JvmGenericType superType) {
		final JvmGenericType inferredType = typesFactory.createJvmGenericType();
		inferredType.setFinal(true);
		inferredType.setVisibility(JvmVisibility.DEFAULT);
		inferredType.setPackageName(EcoreUtil2.getContainerOfType(anonymousClass, XtendFile.class).getPackage());
		// TODO type parameters
		inferredType.getSuperTypes().add(typeReferences.createTypeRef(superType));
		associator.associatePrimary(anonymousClass, inferredType);
		container.getMembers().add(inferredType);
		inferredType.setSimpleName("$" + container.getMembers().indexOf(inferredType));
		
		for (XtendMember member : anonymousClass.getMembers()) {
			if (member instanceof XtendField
					|| (member instanceof XtendFunction && ((XtendFunction) member).getName() != null)
					|| member instanceof XtendConstructor) {
				transform(member, inferredType, true);
			}
		}
		appendSyntheticDispatchMethods(anonymousClass, inferredType);
		return inferredType;
	}
	
	public JvmConstructor inferAnonymousClassConstructor(XtendConstructorCall constructorCall, JvmGenericType inferredAnonymousClass, @Nullable JvmConstructor superConstructor) {
		JvmConstructor constructor = typesFactory.createJvmConstructor();
		inferredAnonymousClass.getMembers().add(constructor);
		associator.associatePrimary(constructorCall, constructor);
		constructor.setVisibility(JvmVisibility.DEFAULT);
		constructor.setSimpleName(inferredAnonymousClass.getSimpleName());
		if(superConstructor != null) {
			for(JvmFormalParameter parameter: superConstructor.getParameters()) 
				constructor.getParameters().add(jvmTypesBuilder.cloneWithProxies(parameter));
			copyAndFixTypeParameters(superConstructor.getTypeParameters(), constructor);
			for (JvmTypeReference exception : superConstructor.getExceptions()) 
				constructor.getExceptions().add(jvmTypesBuilder.cloneWithProxies(exception));
		}
		return constructor;
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
					if (field.getType() != null) {
						returnType = jvmTypesBuilder.cloneWithProxies(field.getType());
					} else if (field.getInitialValue() != null) {
						returnType = jvmTypesBuilder.inferredType(field.getInitialValue());
					}
					operation.setReturnType(returnType);
					if (field.getInitialValue() != null) {
						JvmAnnotationValue jvmAnnotationValue = jvmTypesBuilder.toJvmAnnotationValue(field.getInitialValue());
						if (jvmAnnotationValue != null)
							operation.setDefaultValue(jvmAnnotationValue);
						jvmTypesBuilder.setBody(operation, field.getInitialValue());
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
		jvmTypesBuilder.translateAnnotationsTo(Iterables.filter(annotations, annotationTranslationFilter), target);
	}
	
	protected void initialize(XtendClass source, JvmGenericType inferredJvmType) {
		inferredJvmType.setVisibility(source.getVisibility());
		inferredJvmType.setAbstract(source.isAbstract());
		inferredJvmType.setStrictFloatingPoint(source.isStrictFloatingPoint());
		if (!inferredJvmType.isAbstract()) {
			inferredJvmType.setFinal(source.isFinal());
		}
		translateAnnotationsTo(source.getAnnotations(), inferredJvmType);
		boolean isDataObject = hasAnnotation(source, Data.class);
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
		if (!isDataObject)
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
		if (isDataObject) {
			addDataObjectMethods(source, inferredJvmType);
		}
		nameClashResolver.resolveNameClashes(inferredJvmType);
		
	}
	
	protected void initialize(XtendInterface source, JvmGenericType inferredJvmType) {
		inferredJvmType.setVisibility(source.getVisibility());
		inferredJvmType.setInterface(true);
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
		translateAnnotationsTo(source.getAnnotations(), inferredJvmType);
		for (XtendMember member : source.getMembers()) {
			if (member instanceof XtendEnumLiteral) 
				transform((XtendEnumLiteral) member, inferredJvmType);
		}
		jvmTypesBuilder.copyDocumentationTo(source, inferredJvmType);
	}
	

	protected boolean hasAnnotation(XtendAnnotationTarget source, Class<?> class1) {
		for (XAnnotation anno : source.getAnnotations()) {
			if (anno != null && anno.getAnnotationType() != null && class1.getName().equals(anno.getAnnotationType().getIdentifier()))
				return true;
 		}
		return false;
	}

	protected void addDataObjectMethods(final XtendClass source, final JvmGenericType inferredJvmType) {
		final Iterable<XtendField> allFields = Iterables.filter(source.getMembers(), XtendField.class);
		final Iterable<XtendField> fields = Iterables.filter(allFields, new Predicate<XtendField>() {
			public boolean apply(@Nullable XtendField theField) {
				return theField != null && !theField.isStatic();
			}
		});
		final Iterable<JvmField> jvmFields = Iterables.filter(inferredJvmType.getDeclaredFields(),new Predicate<JvmField>() {
			public boolean apply(@Nullable JvmField theField) {
				return theField != null && !theField.isStatic();
			}
		});
		final JvmConstructor superConstructor = getSuperConstructor(source);
		// constructor
		if ( Iterables.isEmpty(Iterables.filter(source.getMembers(), XtendConstructor.class)) ) {
			final JvmConstructor constructor = jvmTypesBuilder.toConstructor(source, new Procedure1<JvmConstructor>() {
				public void apply(final @Nullable JvmConstructor constructor) {
					if (constructor == null)
						return;
					Set<String> names = Sets.newLinkedHashSet();
					if (superConstructor != null) {
						for (JvmFormalParameter f : superConstructor.getParameters()) {
							constructor.getParameters().add( EcoreUtil2.cloneWithProxies(f) );
							names.add(f.getSimpleName());
						}
					}
					final Map<String, JvmField> namesToField = Maps.newHashMap();
					for (XtendField f : fields) {
						if (f.getInitialValue() == null) {
							String name = computeFieldName(f);
							int tries = 1;
							while (!names.add(name)) {
								name = name + (tries++);
							}
							final JvmFormalParameter parameter = jvmTypesBuilder.toParameter(f, name, f.getType());
							if (parameter != null)
								constructor.getParameters().add( parameter );
							namesToField.put(name, associations.getJvmField(f));
						}
					}
					jvmTypesBuilder.setBody(constructor, new Procedure1<ITreeAppendable>() {
						public void apply(@Nullable ITreeAppendable appendable) {
							if (appendable == null) return;
							appendable.append("super(");
							if (superConstructor != null) {
								final EList<JvmFormalParameter> parameters = superConstructor.getParameters();
								for (Iterator<JvmFormalParameter> iterator = parameters.iterator(); iterator.hasNext();) {
									JvmFormalParameter jvmFormalParameter = iterator.next();
									appendable.append(jvmFormalParameter.getName());
									if (iterator.hasNext())
										appendable.append(", ");
								}
							} 
							appendable.append(");");
							for (int i = superConstructor != null ? superConstructor.getParameters().size() : 0; 
									i < constructor.getParameters().size(); i++) {
								JvmFormalParameter p = constructor.getParameters().get(i);
								JvmField jvmField = namesToField.get(p.getSimpleName());
								appendable.newLine().append("this.").append(jvmField.getSimpleName()).append(" = ").append(p.getName()).append(";");
							}
						}
					});
				}

			});
			typeExtensions.setSynthetic(constructor, true);
			inferredJvmType.getMembers().add(constructor);
		}
		
		// hashcode
		final JvmField[] dataFields = Iterables.toArray(jvmFields, JvmField.class);
			
		JvmOperation hashCode = jvmTypesBuilder.toHashCodeMethod(source, superConstructor != null, dataFields);
		typeExtensions.setSynthetic(hashCode, true);
		if (hashCode != null && !hasMethod(source, hashCode.getSimpleName(), hashCode.getParameters()))
			inferredJvmType.getMembers().add(hashCode);
		
		// equals
		JvmOperation equals = jvmTypesBuilder.toEqualsMethod(source, inferredJvmType, superConstructor != null, dataFields);
		typeExtensions.setSynthetic(equals, true);
		if (equals != null && !hasMethod(source, equals.getSimpleName(), equals.getParameters()))
			inferredJvmType.getMembers().add(equals);
		
		// toString
		JvmOperation toString = jvmTypesBuilder.toToStringMethod(source, inferredJvmType);
		typeExtensions.setSynthetic(toString, true);
		if (toString != null && !hasMethod(source, toString.getSimpleName(), toString.getParameters()))
			inferredJvmType.getMembers().add(toString);
	}
	
	protected @Nullable JvmConstructor getSuperConstructor(final XtendClass source) {
		JvmConstructor superConstructor = null;
		if (source.getExtends() != null) {
			JvmType type = source.getExtends().getType();
			if (type instanceof JvmGenericType) {
				Iterable<JvmConstructor> constructors = Iterables.filter(((JvmGenericType) type).getMembers(), JvmConstructor.class);
				if (!Iterables.isEmpty(constructors)) {
					superConstructor = constructors.iterator().next();
				}
			}
		}
		return superConstructor;
	}

	protected void copyAndFixTypeParameters(List<JvmTypeParameter> typeParameters, JvmTypeParameterDeclarator target) {
		copyTypeParameters(typeParameters, target);
		fixTypeParameters(target);
	}
	
	protected void copyTypeParameters(List<JvmTypeParameter> typeParameters, JvmTypeParameterDeclarator target) {
		for (JvmTypeParameter typeParameter : typeParameters) {
			final JvmTypeParameter clonedTypeParameter = jvmTypesBuilder.cloneWithProxies(typeParameter);
			if (clonedTypeParameter != null) {
				target.getTypeParameters().add(clonedTypeParameter);
				associator.associate(typeParameter, clonedTypeParameter);
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

	protected void appendSyntheticDispatchMethods(XtendClass source, JvmGenericType target) {
		ListMultimap<DispatchHelper.DispatchSignature, JvmOperation> methods = dispatchHelper.getDeclaredOrEnhancedDispatchMethods(target);
		for (DispatchHelper.DispatchSignature signature : methods.keySet()) {
			List<JvmOperation> operations = methods.get(signature);
			JvmOperation operation = deriveGenericDispatchOperationSignature(operations, target);
			if (operation != null) {
				operation.setSimpleName(signature.getSimpleName());
				operation.setReturnType(jvmTypesBuilder.inferredType());
			}
		}
	}

	/**
	 * @return a {@link JvmOperation} with common denominator argument types of all given operations
	 */
	@Nullable
	protected JvmOperation deriveGenericDispatchOperationSignature(List<JvmOperation> sortedOperations,
			JvmGenericType target) {
		if (sortedOperations.isEmpty())
			return null;
		final Iterator<JvmOperation> iterator = sortedOperations.iterator();
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
		jvmTypesBuilder.setBody(result, compileStrategies.forDispatcher(result, sortedOperations));
		JvmVisibility commonVisibility = null;
		boolean isFirst = true;
		boolean allStatic = true;
		for (JvmOperation jvmOperation : sortedOperations) {
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
		for (XtendParameter parameter : source.getParameters()) {
			translateParameter(operation, parameter);
		}
		JvmTypeReference returnType = null;
		if (source.getReturnType() != null) {
			returnType = jvmTypesBuilder.cloneWithProxies(source.getReturnType());
		} else {
			returnType = jvmTypesBuilder.inferredType();
		}
		operation.setReturnType(returnType);
		copyAndFixTypeParameters(source.getTypeParameters(), operation);
		for (JvmTypeReference exception : source.getExceptions()) {
			operation.getExceptions().add(jvmTypesBuilder.cloneWithProxies(exception));
		}
		translateAnnotationsTo(source.getAnnotations(), operation);
		CreateExtensionInfo createExtensionInfo = source.getCreateExtensionInfo();
		if (createExtensionInfo != null) {
			transformCreateExtension(source, createExtensionInfo, container, operation, returnType);
		} else {
			associator.associateLogicalContainer(source.getExpression(), operation);
		}
		jvmTypesBuilder.copyDocumentationTo(source, operation);
	}

	protected void transformCreateExtension(XtendFunction source, CreateExtensionInfo createExtensionInfo,
			JvmGenericType container, JvmOperation operation, @Nullable JvmTypeReference returnType) {
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
			associator.associateLogicalContainer(createExtensionInfo.getCreateExpression(), operation);
			associator.associateLogicalContainer(source.getExpression(), initializer);
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
			jvmParam.getAnnotations().add(jvmTypesBuilder.toAnnotation(parameter, Extension.class));
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
		associator.associateLogicalContainer(source.getExpression(), constructor);
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
			final boolean isDataObject = hasAnnotation((XtendAnnotationTarget) source.eContainer(), Data.class);
			if (isDataObject) {
				if (!field.isStatic())
					field.setFinal(true);
			} else {
				field.setFinal(source.isFinal());
			}
			if (source.getType() != null) {
				field.setType(jvmTypesBuilder.cloneWithProxies(source.getType()));
			} else if (source.getInitialValue() != null) {
				field.setType(jvmTypesBuilder.inferredType(source.getInitialValue()));
			}
			boolean isProperty = isDataObject;
			for (XAnnotation anno : source.getAnnotations()) {
				if (!annotationTranslationFilter.apply(anno))
					continue;
				if (Property.class.getName().equals(anno.getAnnotationType().getIdentifier())) {
					isProperty = true;
				} else {
					JvmAnnotationReference annotationReference = jvmTypesBuilder.getJvmAnnotationReference(anno);
					if(annotationReference != null)
						field.getAnnotations().add(annotationReference);
				}
			}
			if (source.isExtension() && typeReferences.findDeclaredType(Extension.class, source) != null) {
				field.getAnnotations().add(jvmTypesBuilder.toAnnotation(source, Extension.class));
			}
			if (isProperty && !field.isStatic()) {
				field.setSimpleName("_"+computeFieldName);
				final JvmOperation getter = jvmTypesBuilder.toGetter(source, computeFieldName, field.getSimpleName(), field.getType());
				typeExtensions.setSynthetic(getter, true);
				jvmTypesBuilder.copyDocumentationTo(source, getter);
				if (getter != null && !hasMethod((XtendClass)source.eContainer(), getter.getSimpleName(), getter.getParameters()))
					container.getMembers().add( getter);
				if (!source.isFinal() && ! isDataObject) {
					final JvmOperation setter = jvmTypesBuilder.toSetter(source, computeFieldName, field.getSimpleName(), field.getType());
					typeExtensions.setSynthetic(setter, true);
					jvmTypesBuilder.copyDocumentationTo(source, setter);
					if (setter != null && !hasMethod((XtendClass)source.eContainer(), setter.getSimpleName(), setter.getParameters()))
						container.getMembers().add( setter);
				}
			}
			jvmTypesBuilder.copyDocumentationTo(source, field);
			jvmTypesBuilder.setInitializer(field, source.getInitialValue());
			
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
		public boolean apply(@Nullable XAnnotation annotation) {
			if (annotation == null || annotation.getAnnotationType() == null)
				return false;
			JvmType annotationType = annotation.getAnnotationType();
			if (annotationType instanceof JvmAnnotationType && DisableCodeGenerationAdapter.isDisabled((JvmDeclaredType) annotationType))
				return false;
			return true;
		}
	};

	protected boolean hasMethod(XtendClass xtendClass, String simpleName, List<? extends JvmFormalParameter> parameters) {
		for (XtendMember member : xtendClass.getMembers()) {
			if (member instanceof XtendFunction) {
				XtendFunction function = (XtendFunction) member;
				String name = function.getName();
				if (name != null && name.equals(simpleName)) {
					boolean allMatched = true;
					if (function.getParameters().size() == parameters.size()) {
						for (int i = 0; i < parameters.size() ; i++) {
							XtendParameter p1 = function.getParameters().get(i);
							JvmFormalParameter p2 = parameters.get(i);
							allMatched = allMatched && p1.getParameterType().getType() == p2.getParameterType().getType(); 
						}
					}
					if (allMatched)
						return true;
				}
			}
		}
		return false;
	}

	@Nullable
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
	
}
