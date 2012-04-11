/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.jvmmodel;

import static com.google.common.collect.Iterables.*;
import static org.eclipse.xtext.util.Strings.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtend.core.dispatch.DispatchingSupport;
import org.eclipse.xtend.core.resource.XtendResource;
import org.eclipse.xtend.core.xtend.CreateExtensionInfo;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmStringAnnotationValue;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociator;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sven Efftinge
 */
@NonNullByDefault
public class XtendJvmModelInferrer implements IJvmModelInferrer {

	public static final String CREATE_INITIALIZER_PREFIX = "_init_";

	public static final String CREATE_CHACHE_VARIABLE_PREFIX = "_createCache_";

	@Inject
	protected TypesFactory typesFactory;

	@Inject
	private IJvmModelAssociator associator;

	@Inject
	private IJvmModelAssociations associations;

	@Inject
	private DispatchingSupport dispatchingSupport;

	@Inject
	private TypeReferences typeReferences;

	@Inject
	private XtendCompileStrategies compileStrategies;

	@Inject
	private JvmTypesBuilder jvmTypesBuilder;

	@Inject
	private SyntheticNameClashResolver nameClashResolver;

	public void infer(@Nullable EObject xtendFile, IJvmDeclaredTypeAcceptor acceptor, boolean preIndexingPhase) {
		if (!(xtendFile instanceof XtendFile))
			return;
		final XtendFile xtendFile2 = (XtendFile) xtendFile;
		final EList<XtendClass> classes = xtendFile2.getXtendClasses();
		for (final XtendClass xtendClass : classes) {
			if (Strings.isEmpty(xtendClass.getName()))
				continue;
			final JvmGenericType inferredJvmType = typesFactory.createJvmGenericType();
			inferredJvmType.setPackageName(xtendClass.getPackageName());
			inferredJvmType.setSimpleName(xtendClass.getName());
			associator.associatePrimary(xtendClass, inferredJvmType);
			acceptor.accept(inferredJvmType).initializeLater(new Procedure1<JvmGenericType>() {
				public void apply(@Nullable JvmGenericType p) {
					initialize(xtendClass, inferredJvmType);
				}
			});
		}
	}

	protected void initialize(XtendClass source, JvmGenericType inferredJvmType) {
		inferredJvmType.setVisibility(JvmVisibility.PUBLIC);
		inferredJvmType.setAbstract(source.isAbstract());
		JvmAnnotationType annotation = (JvmAnnotationType) typeReferences.findDeclaredType(SuppressWarnings.class,
				source);
		if (annotation != null) {
			JvmAnnotationReference suppressWarnings = typesFactory.createJvmAnnotationReference();
			suppressWarnings.setAnnotation(annotation);
			JvmStringAnnotationValue annotationValue = typesFactory.createJvmStringAnnotationValue();
			annotationValue.getValues().add("all");
			suppressWarnings.getValues().add(annotationValue);
			inferredJvmType.getAnnotations().add(suppressWarnings);
		}
		addDefaultConstructor(source, inferredJvmType);
		if (source.getExtends() == null) {
			JvmTypeReference typeRefToObject = typeReferences.getTypeForName(Object.class, source);
			if (typeRefToObject != null)
				inferredJvmType.getSuperTypes().add(typeRefToObject);
		} else {
			inferredJvmType.getSuperTypes().add(jvmTypesBuilder.cloneWithProxies(source.getExtends()));
		}
		for (JvmTypeReference intf : source.getImplements()) {
			inferredJvmType.getSuperTypes().add(jvmTypesBuilder.cloneWithProxies(intf));
		}
		copyAndFixTypeParameters(source.getTypeParameters(), inferredJvmType);
		for (XtendMember member : source.getMembers()) {
			if (member instanceof XtendField
					|| (member instanceof XtendFunction && ((XtendFunction) member).getName() != null)
					|| member instanceof XtendConstructor) {
				transform(member, inferredJvmType);
			}
		}
		appendSyntheticDispatchMethods(source, inferredJvmType);
		computeInferredReturnTypes(inferredJvmType);
		jvmTypesBuilder.translateAnnotationsTo(source.getAnnotations(), inferredJvmType);
		jvmTypesBuilder.setDocumentation(inferredJvmType, jvmTypesBuilder.getDocumentation(source));

		nameClashResolver.resolveNameClashes(inferredJvmType);
	}

	protected void copyAndFixTypeParameters(List<JvmTypeParameter> typeParameters, JvmTypeParameterDeclarator target) {
		for (JvmTypeParameter typeParameter : typeParameters) {
			final JvmTypeParameter clonedTypeParameter = jvmTypesBuilder.cloneWithProxies(typeParameter);
			if (clonedTypeParameter != null) {
				target.getTypeParameters().add(clonedTypeParameter);
				boolean upperBoundSeen = false;
				for (JvmTypeConstraint constraint : clonedTypeParameter.getConstraints()) {
					if (constraint instanceof JvmUpperBound) {
						upperBoundSeen = true;
						break;
					}
				}
				if (!upperBoundSeen) {
					JvmUpperBound upperBound = typesFactory.createJvmUpperBound();
					upperBound.setTypeReference(typeReferences.getTypeForName(Object.class, typeParameter));
					clonedTypeParameter.getConstraints().add(upperBound);
				}
				associator.associate(typeParameter, clonedTypeParameter);
			}
		}
	}

	protected void appendSyntheticDispatchMethods(XtendClass source, JvmGenericType target) {
		Multimap<Pair<String, Integer>, JvmOperation> methods = dispatchingSupport.getDispatchMethods(target);
		for (Pair<String, Integer> key : methods.keySet()) {
			Collection<JvmOperation> operations = methods.get(key);
			JvmOperation operation = deriveGenericDispatchOperationSignature(dispatchingSupport.sort(operations),
					target);
			if (operation != null)
				operation.setSimpleName(key.getFirst());
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
			parameter.setParameterType(getTypeProxy(parameter));
			JvmFormalParameter parameter2 = first.getParameters().get(i);
			parameter.setName(parameter2.getName());
		}
		jvmTypesBuilder.setBody(result, compileStrategies.forDispatcher(result, sortedOperations));
		JvmVisibility commonVisibility = null;
		boolean isFirst = true;
		boolean allStatic = true;
		for (JvmOperation jvmOperation : sortedOperations) {
			Iterable<XtendFunction> xtendFunctions = filter(associations.getSourceElements(jvmOperation),
					XtendFunction.class);
			for (XtendFunction func : xtendFunctions) {
				JvmVisibility xtendVisibility = func.eIsSet(XtendPackage.Literals.XTEND_FUNCTION__VISIBILITY) ? func
						.getVisibility() : null;
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
		boolean declaredConstructor = false;
		for (XtendMember member : source.getMembers()) {
			if (member instanceof XtendConstructor) {
				declaredConstructor = true;
				break;
			}
		}
		if (!declaredConstructor) {
			JvmConstructor constructor = typesFactory.createJvmConstructor();
			target.getMembers().add(constructor);
			associator.associatePrimary(source, constructor);
			constructor.setSimpleName(source.getName());
			constructor.setVisibility(JvmVisibility.PUBLIC);
		}
	}

	protected void transform(XtendMember sourceMember, JvmGenericType container) {
		if (sourceMember instanceof XtendFunction) {
			transform((XtendFunction) sourceMember, container);
		} else if (sourceMember instanceof XtendField) {
			transform((XtendField) sourceMember, container);
		} else if (sourceMember instanceof XtendConstructor) {
			transform((XtendConstructor) sourceMember, container);
		} else {
			throw new IllegalArgumentException("Cannot transform " + notNull(sourceMember) + " to a JvmMember");
		}
	}

	protected void transform(XtendFunction source, JvmGenericType container) {
		JvmOperation operation = typesFactory.createJvmOperation();
		operation.setAbstract(source.getExpression()==null);
		container.getMembers().add(operation);
		associator.associatePrimary(source, operation);
		String sourceName = source.getName();
		JvmVisibility visibility = source.getVisibility();
		if (source.isDispatch()) {
			if (!source.eIsSet(XtendPackage.Literals.XTEND_FUNCTION__VISIBILITY))
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
			returnType = getTypeProxy(operation);
		}
		operation.setReturnType(returnType);
		copyAndFixTypeParameters(source.getTypeParameters(), operation);
		for (JvmTypeReference exception : source.getExceptions()) {
			operation.getExceptions().add(jvmTypesBuilder.cloneWithProxies(exception));
		}
		jvmTypesBuilder.translateAnnotationsTo(source.getAnnotationInfo().getAnnotations(), operation);
		CreateExtensionInfo createExtensionInfo = source.getCreateExtensionInfo();
		if (createExtensionInfo != null) {
			transformCreateExtension(source, createExtensionInfo, container, operation, returnType);
		} else {
			associator.associateLogicalContainer(source.getExpression(), operation);
		}
		jvmTypesBuilder.setDocumentation(operation, jvmTypesBuilder.getDocumentation(source));
	}

	protected void transformCreateExtension(XtendFunction source, CreateExtensionInfo createExtensionInfo,
			JvmGenericType container, JvmOperation operation, @Nullable JvmTypeReference returnType) {
		JvmTypeReference arrayList = typeReferences.getTypeForName(ArrayList.class, container,
				typeReferences.wildCard());
		JvmTypeReference hashMap = typeReferences.getTypeForName(HashMap.class, container, arrayList,
				jvmTypesBuilder.cloneWithProxies(returnType));

		JvmField cacheVar = jvmTypesBuilder.toField(source, CREATE_CHACHE_VARIABLE_PREFIX + source.getName(),
				hashMap);
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
			jvmParam.setParameterType(getTypeProxy(createExtensionInfo.getCreateExpression()));
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
		jvmTypesBuilder.translateAnnotationsTo(parameter.getAnnotations(), jvmParam);
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
		jvmTypesBuilder.translateAnnotationsTo(source.getAnnotationInfo().getAnnotations(), constructor);
		associator.associateLogicalContainer(source.getExpression(), constructor);
		jvmTypesBuilder.setDocumentation(constructor, jvmTypesBuilder.getDocumentation(source));
	}

	protected void transform(XtendField source, JvmGenericType container) {
		if (source.isExtension() || source.getName() != null) {
			JvmField field = typesFactory.createJvmField();
			field.setSimpleName(computeFieldName(source, container));
			container.getMembers().add(field);
			associator.associatePrimary(source, field);
			field.setVisibility(source.getVisibility());
			field.setStatic(source.isStatic());
			field.setFinal(source.isFinal());
			if (source.getType() != null) {
				field.setType(jvmTypesBuilder.cloneWithProxies(source.getType()));
			} else if (source.getInitialValue() != null) {
				field.setType(getTypeProxy(source.getInitialValue()));
			}
			jvmTypesBuilder.translateAnnotationsTo(source.getAnnotationInfo().getAnnotations(), field);
			jvmTypesBuilder.setDocumentation(field, jvmTypesBuilder.getDocumentation(source));
			jvmTypesBuilder.setInitializer(field, source.getInitialValue());
		}
	}

	@Nullable
	protected String computeFieldName(XtendField field, JvmGenericType declaringType) {
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

	protected void computeInferredReturnTypes(JvmGenericType inferredJvmType) {
		Iterable<JvmOperation> operations = inferredJvmType.getDeclaredOperations();
		for (JvmOperation jvmOperation : operations) {
			if (!jvmOperation.eIsSet(TypesPackage.Literals.JVM_OPERATION__RETURN_TYPE))
				jvmOperation.setReturnType(getTypeProxy(jvmOperation));
		}
	}

	protected JvmTypeReference getTypeProxy(EObject pointer) {
		JvmParameterizedTypeReference typeReference = typesFactory.createJvmParameterizedTypeReference();
		final Resource eResource = pointer.eResource();
		String fragment = eResource.getURIFragment(pointer);
		URI uri = eResource.getURI();
		uri = uri.appendFragment(XtendResource.FRAGMENT_PREFIX + fragment);
		((InternalEObject) typeReference).eSetProxyURI(uri);
		return typeReference;
	}

}
