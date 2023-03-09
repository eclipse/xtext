/*******************************************************************************
 * Copyright (c) 2009, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.GenericSignatureFormatError;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
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
import org.eclipse.xtext.common.types.JvmInnerTypeReference;
import org.eclipse.xtext.common.types.JvmLowerBound;
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
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.access.impl.ITypeFactory;
import org.eclipse.xtext.common.types.impl.JvmTypeConstraintImplCustom;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.internal.Stopwatches;
import org.eclipse.xtext.util.internal.Stopwatches.StoppedTask;

import com.google.inject.Inject;

/**
 * Internal implementation that allows to convert Java top-level classes to {@link JvmType types}.
 * 
 * Clients are not supposed to use this class directly but the {@link IJvmTypeProvider} or {@link TypeReferences}
 * instead. Those will take care of types that are requested more than once and therefore should return the very same
 * {@link JvmType type} on subsequent queries.
 * 
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ReflectionTypeFactory implements ITypeFactory<Class<?>, JvmDeclaredType> {

	private final static Logger log = Logger.getLogger(ReflectionTypeFactory.class);
	private final ReflectURIHelper uriHelper;

	private final StoppedTask createTypeTask = Stopwatches.forTask("ReflectionTypeFactory.createType");

	
	/**
	 * A cache mapping each type to its corresponding type proxy.
	 * It's demand populated when {@link #createProxy(Type) creating} a type proxy.
	 */
	private final Map<Type, JvmType> typeProxies = new HashMap<Type, JvmType>();

	/**
	 * A cache mapping each method to its corresponding operation proxy.
	 * It's demand populated when {@link #createMethodProxy(Method) creating} a method proxy.
	 */
	private final Map<Method, JvmOperation> operationProxies = new HashMap<Method, JvmOperation>();

	/**
	 * A cache mapping each annotation class to its corresponding annotation type proxy.
	 * It's demand populated when {@link #createAnnotationProxy(Class) creating} an annotation type proxy.
	 */
	private final Map<Class<? extends Annotation>, JvmAnnotationType> annotationProxies = new HashMap<Class<? extends Annotation>, JvmAnnotationType>();

	@Inject
	public ReflectionTypeFactory(ReflectURIHelper uriHelper) {
		this.uriHelper = uriHelper;
	}

	/**
	 * Creates a new {@link JvmDeclaredType type} from the given class.
	 * 
	 * @noreference This method is not intended to be referenced by clients.
	 */
	@Override
	public JvmDeclaredType createType(final Class<?> clazz) {
		try {
			createTypeTask.start();
			if (clazz.isAnonymousClass() || clazz.isSynthetic())
				throw new IllegalStateException("Cannot create type for anonymous or synthetic classes");
			if (clazz.isAnnotation())
				return createAnnotationType(clazz);
			if (clazz.isEnum())
				return createEnumerationType(clazz);

			final JvmGenericType result = TypesFactory.eINSTANCE.createJvmGenericType();
			result.setInterface(clazz.isInterface());
			result.setStrictFloatingPoint(Modifier.isStrict(clazz.getModifiers()));
			setTypeModifiers(clazz, result);
			setVisibility(clazz, result);
			result.internalSetIdentifier(clazz.getName());
			result.setSimpleName(clazz.getSimpleName());
			if (clazz.getDeclaringClass() == null && clazz.getPackage() != null) {
				String pack = clazz.getPackage().getName();
				if (!Strings.isEmpty(pack)) {
					result.setPackageName(pack);
				}
			}

			createNestedTypes(clazz, result);
			createMethods(clazz, result);
			createConstructors(clazz, result);
			createFields(clazz, result);

			setSuperTypes(clazz, result);
			try {
				TypeVariable<?>[] typeParameters = clazz.getTypeParameters();
				if (typeParameters.length != 0) {
					InternalEList<JvmTypeParameter> jvmTypeParameters = (InternalEList<JvmTypeParameter>)result.getTypeParameters();
					for (TypeVariable<?> variable : typeParameters) {
						jvmTypeParameters.addUnique(createTypeParameter(variable, result));
					}
				}
			} catch (GenericSignatureFormatError error) {
				logSignatureFormatError(clazz);
			} catch (MalformedParameterizedTypeException error) {
				logSignatureFormatError(clazz);
			}
			createAnnotationValues(clazz, result);
			return result;
		} finally {
			createTypeTask.stop();
		}
	}

	protected void logSignatureFormatError(final Class<?> clazz) {
		if (log.isDebugEnabled())
			log.debug("Invalid class file for: " + clazz.getCanonicalName());
	}
	
	private void logNoClassDefFoundError(NoClassDefFoundError error, Class<?> clazz, String description) {
		log.error("Incomplete " + description + " for " + clazz.getCanonicalName() + ": " + error);
		if (log.isDebugEnabled()) {
			log.debug(error.getMessage(), error);
		}
	}

	private static final Object[] EMPTY_ARRAY = new Object[0];

	protected void createAnnotationValues(final AnnotatedElement annotated, final JvmAnnotationTarget result) {
		Annotation[] declaredAnnotations = annotated.getDeclaredAnnotations();
		if (declaredAnnotations.length != 0) {
			InternalEList<JvmAnnotationReference> annotations = (InternalEList<JvmAnnotationReference>)result.getAnnotations();
			for (Annotation annotation : declaredAnnotations) {
				annotations.addUnique(createAnnotationReference(annotation));
			}
		}
	}

	protected JvmAnnotationReference createAnnotationReference(Annotation annotation) {
		JvmAnnotationReference annotationReference = TypesFactory.eINSTANCE.createJvmAnnotationReference();
		Class<? extends Annotation> type = annotation.annotationType();
		annotationReference.setAnnotation(createAnnotationProxy(type));
		Method[] declaredMethods = type.getDeclaredMethods();
		if (declaredMethods.length > 0) {
			InternalEList<JvmAnnotationValue> values = (InternalEList<JvmAnnotationValue>)annotationReference.getExplicitValues();
			for (Method method : declaredMethods) {
				try {
					Object value = method.invoke(annotation, EMPTY_ARRAY);
					Class<?> returnType = method.getReturnType();
					if (returnType.isArray()) {
						JvmAnnotationValue annotationValue = createArrayAnnotationValue(value, returnType);
						values.addUnique(annotationValue);
						annotationValue.setOperation(createMethodProxy(method));
					} else {
						JvmAnnotationValue annotationValue = createAnnotationValue(value, returnType);
						values.addUnique(annotationValue);
						annotationValue.setOperation(createMethodProxy(method));
					}
				} catch (IllegalAccessException e) {
					log.debug(e.getMessage(), e);
				} catch (Exception e) {
					log.error(e.getMessage(), e);
				}
			}
		}
		return annotationReference;
	}

	protected JvmEnumerationLiteral createEnumLiteralProxy(Enum<?> e) {
		JvmEnumerationLiteral enumLiteralProxy = TypesFactory.eINSTANCE.createJvmEnumerationLiteral();
		InternalEObject internalEObject = (InternalEObject) enumLiteralProxy;
		Class<?> type = e.getDeclaringClass();
		try {
			Field field = type.getDeclaredField(e.name());
			internalEObject.eSetProxyURI(uriHelper.getFullURI(field));
		} catch (Exception exception) {
			log.error(exception.getMessage(), exception);
			return null;
		}
		return enumLiteralProxy;
	}

	protected JvmAnnotationValue createArrayAnnotationValue(Object value, Class<?> type) {
		if (!type.isArray())
			throw new IllegalArgumentException("type is not an array type: " + type.getCanonicalName());
		Class<?> componentType = type.getComponentType();
		EStructuralFeature.Setting result = createAnnotationValue(componentType);
		int length = Array.getLength(value);
		if (length > 0) {
			@SuppressWarnings("unchecked")
			InternalEList<Object> values = (InternalEList<Object>)result;
			if (componentType.isPrimitive() || String.class == componentType) {
				for (int i = 0; i < length; i++) {
					values.addUnique(Array.get(value, i));
				}
			} else if (componentType == Class.class) {
				for (int i = 0; i < length; i++) {
					Class<?> referencedClass = (Class<?>) Array.get(value, i);
					values.addUnique(createTypeReference(referencedClass));
				}
			} else if (componentType.isAnnotation()) {
				for (int i = 0; i < length; i++) {
					Annotation nestedAnnotation = (Annotation) Array.get(value, i);
					values.addUnique(createAnnotationReference(nestedAnnotation));
				}
			} else if (componentType.isEnum()) {
				for (int i = 0; i < length; i++) {
					Enum<?> e = (Enum<?>) Array.get(value, i);
					values.addUnique(createEnumLiteralProxy(e));
				}
			}
		}
		return (JvmAnnotationValue)result.getEObject();
	}

	protected JvmAnnotationValue createAnnotationValue(Object value, Class<?> type) {
		EStructuralFeature.Setting result = createAnnotationValue(type);
		@SuppressWarnings("unchecked")
		InternalEList<Object> values = (InternalEList<Object>)result;
		if (type.isPrimitive() || String.class == type) {
			values.addUnique(value);
		} else if (type == Class.class) {
			Class<?> referencedClass = (Class<?>) value;
			JvmTypeReference reference = createTypeReference(referencedClass);
			values.addUnique(reference);
		} else if (type.isAnnotation()) {
			Annotation nestedAnnotation = (Annotation) value;
			values.addUnique(createAnnotationReference(nestedAnnotation));
		} else if (type.isEnum()) {
			Enum<?> e = (Enum<?>) value;
			JvmEnumerationLiteral proxy = createEnumLiteralProxy(e);
			values.addUnique(proxy);
		}
		return (JvmAnnotationValue)result.getEObject();
	}

	protected EStructuralFeature.Setting createAnnotationValue(Class<?> type) {
		if (String.class == type) {
			return (EStructuralFeature.Setting)TypesFactory.eINSTANCE.createJvmStringAnnotationValue().getValues();
		} else if (Class.class == type) {
			return (EStructuralFeature.Setting)TypesFactory.eINSTANCE.createJvmTypeAnnotationValue().getValues();
		} else if (boolean.class == type) {
			return (EStructuralFeature.Setting)TypesFactory.eINSTANCE.createJvmBooleanAnnotationValue().getValues();
		} else if (int.class == type) {
			return (EStructuralFeature.Setting)TypesFactory.eINSTANCE.createJvmIntAnnotationValue().getValues();
		} else if (type.isAnnotation()) {
			return (EStructuralFeature.Setting)TypesFactory.eINSTANCE.createJvmAnnotationAnnotationValue().getValues();
		} else if (type.isEnum()) {
			return (EStructuralFeature.Setting)TypesFactory.eINSTANCE.createJvmEnumAnnotationValue().getValues();
		} else if (long.class == type) {
			return (EStructuralFeature.Setting)TypesFactory.eINSTANCE.createJvmLongAnnotationValue().getValues();
		} else if (short.class == type) {
			return (EStructuralFeature.Setting)TypesFactory.eINSTANCE.createJvmShortAnnotationValue().getValues();
		} else if (float.class == type) {
			return (EStructuralFeature.Setting)TypesFactory.eINSTANCE.createJvmFloatAnnotationValue().getValues();
		} else if (double.class == type) {
			return (EStructuralFeature.Setting)TypesFactory.eINSTANCE.createJvmDoubleAnnotationValue().getValues();
		} else if (char.class == type) {
			return (EStructuralFeature.Setting)TypesFactory.eINSTANCE.createJvmCharAnnotationValue().getValues();
		} else if (byte.class == type) {
			return (EStructuralFeature.Setting)TypesFactory.eINSTANCE.createJvmByteAnnotationValue().getValues();
		} else
			throw new IllegalArgumentException("Unexpected type: " + type.getCanonicalName());
	}

	protected JvmAnnotationType createAnnotationProxy(Class<? extends Annotation> type) {
		JvmAnnotationType proxy = annotationProxies.get(type);
		if (proxy == null)  {
			proxy = TypesFactory.eINSTANCE.createJvmAnnotationType();
			URI uri = uriHelper.getFullURI(type);
			((InternalEObject)proxy).eSetProxyURI(uri);
			annotationProxies.put(type, proxy);
		}
		return proxy;
	}

	protected JvmOperation createMethodProxy(Method method) {
		JvmOperation proxy = operationProxies.get(method);
		if (proxy == null) {
			proxy = TypesFactory.eINSTANCE.createJvmOperation();
			URI uri = uriHelper.getFullURI(method);
			((InternalEObject)proxy).eSetProxyURI(uri);
			operationProxies.put(method, proxy);
		}
		return  proxy;
	}

	protected void setTypeModifiers(Class<?> clazz, JvmDeclaredType result) {
		int modifiers = clazz.getModifiers();
		result.setAbstract(Modifier.isAbstract(modifiers));
		result.setStatic(Modifier.isStatic(modifiers));
		if (!(result instanceof JvmEnumerationType))
			result.setFinal(Modifier.isFinal(modifiers));
	}

	protected void createNestedTypes(Class<?> clazz, JvmDeclaredType result) {
		try {
			Class<?>[] declaredClasses = clazz.getDeclaredClasses();
			if (declaredClasses.length != 0) {
				InternalEList<JvmMember> members = (InternalEList<JvmMember>)result.getMembers();
				for (Class<?> declaredClass : declaredClasses) {
					if (!declaredClass.isAnonymousClass() && !declaredClass.isSynthetic()) {
						members.addUnique(createType(declaredClass));
					}
				}
			}
		} catch(NoClassDefFoundError e) {
			logNoClassDefFoundError(e, clazz, "nested types");
		}
	}

	protected JvmAnnotationType createAnnotationType(Class<?> clazz) {
		JvmAnnotationType result = TypesFactory.eINSTANCE.createJvmAnnotationType();
		result.internalSetIdentifier(clazz.getName());
		result.setSimpleName(clazz.getSimpleName());
		if (clazz.getDeclaringClass() == null && clazz.getPackage() != null)
			result.setPackageName(clazz.getPackage().getName());
		setVisibility(clazz, result);
		setTypeModifiers(clazz, result);
		createNestedTypes(clazz, result);
		createMethods(clazz, result);
		createFields(clazz, result);
		setSuperTypes(clazz, result);
		createAnnotationValues(clazz, result);
		return result;
	}

	protected void setSuperTypes(Class<?> clazz, JvmDeclaredType result) {
		InternalEList<JvmTypeReference> superTypes = (InternalEList<JvmTypeReference>)result.getSuperTypes();
		Type superclass = null;
		try {
			superclass = clazz.getGenericSuperclass();
		} catch (GenericSignatureFormatError error) {
			logSignatureFormatError(clazz);
			superclass = clazz.getSuperclass();
		} catch (MalformedParameterizedTypeException error) {
			logSignatureFormatError(clazz);
			superclass = clazz.getSuperclass();
		}
		if (superclass != null) {
			superTypes.addUnique(createTypeReference(superclass));
		}

		Type[] interfaces = null;
		try {
			interfaces = clazz.getGenericInterfaces();
		} catch (GenericSignatureFormatError error) {
			logSignatureFormatError(clazz);
			interfaces = clazz.getInterfaces();
		} catch (MalformedParameterizedTypeException error) {
			logSignatureFormatError(clazz);
			interfaces = clazz.getInterfaces();
		}
		for (Type type : interfaces) {
			superTypes.addUnique(createTypeReference(type));
		}

		if (superTypes.isEmpty() && Object.class != clazz) {
			superTypes.addUnique(createTypeReference(Object.class));
		}
	}

	protected void createFields(Class<?> clazz, JvmDeclaredType result) {
		try {
			Field[] declaredFields = clazz.getDeclaredFields();
			if (declaredFields.length != 0) {
				InternalEList<JvmMember> members = (InternalEList<JvmMember>)result.getMembers();
				for (Field field : declaredFields) {
					if (!field.isSynthetic()) {
						members.addUnique(createField(field));
					}
				}
			}
		} catch (NoClassDefFoundError e) {
			logNoClassDefFoundError(e, clazz, "fields");
		}
	}

	protected void createConstructors(Class<?> clazz, JvmDeclaredType result) {
		try {
			Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
			if (declaredConstructors.length != 0) {
				InternalEList<JvmMember> members = (InternalEList<JvmMember>)result.getMembers();
				for (Constructor<?> constructor : declaredConstructors) {
					if (!constructor.isSynthetic()) {
						members.addUnique(createConstructor(constructor));
					}
				}
			}
		} catch (NoClassDefFoundError e) {
			logNoClassDefFoundError(e, clazz, "constructors");
		}
	}

	protected void createMethods(Class<?> clazz, JvmDeclaredType result) {
		try {
			Method[] declaredMethods = clazz.getDeclaredMethods();
			if (declaredMethods.length != 0) {
				boolean intf = clazz.isInterface() && !clazz.isAnnotation();
				InternalEList<JvmMember> members = (InternalEList<JvmMember>)result.getMembers();
				for (Method method : declaredMethods) {
					if (!method.isSynthetic()) {
						JvmOperation operation = createOperation(method);
						if (clazz.isAnnotation()) {
							setDefaultValue(operation, method);
						} else if (intf && !operation.isAbstract() && !operation.isStatic()) {
							operation.setDefault(true);
						}
						members.addUnique(operation);
					}
				}
			}
		} catch (NoClassDefFoundError e) {
			logNoClassDefFoundError(e, clazz, "methods");
		}
	}

	private void setDefaultValue(JvmOperation operation, Method method) {
		Object defaultValue = method.getDefaultValue();
		if (defaultValue != null) {
			Class<?> returnType = method.getReturnType();
			if (returnType.isArray()) {
				JvmAnnotationValue annotationValue = createArrayAnnotationValue(defaultValue, returnType);
				operation.setDefaultValue(annotationValue);
				annotationValue.setOperation(operation);
			} else {
				JvmAnnotationValue annotationValue = createAnnotationValue(defaultValue, returnType);
				operation.setDefaultValue(annotationValue);
				annotationValue.setOperation(operation);
			}
		}
	}

	protected JvmEnumerationType createEnumerationType(Class<?> clazz) {
		JvmEnumerationType result = TypesFactory.eINSTANCE.createJvmEnumerationType();
		result.internalSetIdentifier(clazz.getName());
		result.setSimpleName(clazz.getSimpleName());
		if (clazz.getDeclaringClass() == null && clazz.getPackage() != null)
			result.setPackageName(clazz.getPackage().getName());
		setVisibility(clazz, result);
		setTypeModifiers(clazz, result);
		createNestedTypes(clazz, result);
		createMethods(clazz, result);
		createFields(clazz, result);
		createConstructors(clazz, result);
		setSuperTypes(clazz, result);
		createAnnotationValues(clazz, result);
		return result;
	}

	protected void setVisibility(Class<?> clazz, JvmMember result) {
		if (Modifier.isPrivate(clazz.getModifiers()))
			result.setVisibility(JvmVisibility.PRIVATE);
		else if (Modifier.isProtected(clazz.getModifiers()))
			result.setVisibility(JvmVisibility.PROTECTED);
		else if (Modifier.isPublic(clazz.getModifiers()))
			result.setVisibility(JvmVisibility.PUBLIC);
	}

	protected JvmTypeParameter createTypeParameter(TypeVariable<?> variable, JvmMember container) {
		JvmTypeParameter result = TypesFactory.eINSTANCE.createJvmTypeParameter();
		result.setName(variable.getName());
		Type[] bounds = variable.getBounds();
		if (bounds.length != 0) {
			InternalEList<JvmTypeConstraint> constraints = (InternalEList<JvmTypeConstraint>)result.getConstraints();
			for (Type bound : variable.getBounds()) {
				JvmUpperBound upperBound = TypesFactory.eINSTANCE.createJvmUpperBound();
				((JvmTypeConstraintImplCustom) upperBound).internalSetTypeReference(createTypeReference(bound));
				constraints.addUnique(upperBound);
			}
		}
		return result;
	}

	protected JvmTypeReference createTypeReference(Type type) {
		if (type instanceof GenericArrayType) {
			GenericArrayType arrayType = (GenericArrayType) type;
			Type componentType = arrayType.getGenericComponentType();
			return createArrayTypeReference(componentType);
		} else if (type instanceof ParameterizedType) {
			ParameterizedType parameterizedType = (ParameterizedType) type;
			Type ownerType = parameterizedType.getOwnerType();
			if (ownerType instanceof ParameterizedType) {
				JvmTypeReference ownerTypeReference = createTypeReference(ownerType);
				if (ownerTypeReference instanceof JvmParameterizedTypeReference) {
					JvmInnerTypeReference result = TypesFactory.eINSTANCE.createJvmInnerTypeReference();
					result.setOuter((JvmParameterizedTypeReference) ownerTypeReference);
					return enhanceTypeReference(parameterizedType, result);
				} else {
					JvmParameterizedTypeReference result = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
					return enhanceTypeReference(parameterizedType, result);
				}
			} else {
				JvmParameterizedTypeReference result = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
				return enhanceTypeReference(parameterizedType, result);
			}
		} else if (type instanceof Class<?> && ((Class<?>) type).isArray()) {
			Class<?> arrayType = (Class<?>) type;
			Type componentType = arrayType.getComponentType();
			return createArrayTypeReference(componentType);
		} else {
			JvmParameterizedTypeReference result = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
			result.setType(createProxy(type));
			return result;
		}
	}

	private JvmTypeReference enhanceTypeReference(ParameterizedType parameterizedType,
			JvmParameterizedTypeReference result) {
		result.setType(createProxy(parameterizedType.getRawType()));
		Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
		if (actualTypeArguments.length != 0) {
			InternalEList<JvmTypeReference> arguments = (InternalEList<JvmTypeReference>)result.getArguments();
			for (Type actualTypeArgument : actualTypeArguments) {
				JvmTypeReference argument = createTypeArgument(actualTypeArgument);
				arguments.addUnique(argument);
			}
		}
		return result;
	}

	protected JvmTypeReference createArrayTypeReference(Type componentType) {
		JvmTypeReference componentTypeReference = createTypeReference(componentType);
		JvmGenericArrayTypeReference result = TypesFactory.eINSTANCE.createJvmGenericArrayTypeReference();
		result.setComponentType(componentTypeReference);
		return result;
	}

	protected JvmTypeReference createTypeArgument(Type actualTypeArgument) {
		if (actualTypeArgument instanceof WildcardType) {
			WildcardType wildcardType = (WildcardType) actualTypeArgument;
			JvmWildcardTypeReference result = TypesFactory.eINSTANCE.createJvmWildcardTypeReference();
			InternalEList<JvmTypeConstraint> constraints = (InternalEList<JvmTypeConstraint>)result.getConstraints();
			Type[] upperBounds = wildcardType.getUpperBounds();
			if (upperBounds.length != 0) {
				for (Type boundType : upperBounds) {
					JvmUpperBound upperBound = TypesFactory.eINSTANCE.createJvmUpperBound();
					JvmTypeReference upperBoundType = createTypeReference(boundType);
					((JvmTypeConstraintImplCustom) upperBound).internalSetTypeReference(upperBoundType);
					constraints.addUnique(upperBound);
				}
			}
			Type[] lowerBounds = wildcardType.getLowerBounds();
			if (lowerBounds.length != 0) {
				for (Type boundType : lowerBounds) {
					JvmLowerBound lowerBound = TypesFactory.eINSTANCE.createJvmLowerBound();
					JvmTypeReference lowerBoundType = createTypeReference(boundType);
					((JvmTypeConstraintImplCustom) lowerBound).internalSetTypeReference(lowerBoundType);
					constraints.addUnique(lowerBound);
				}
			}
			return result;
		} else {
			JvmTypeReference result = createTypeReference(actualTypeArgument);
			return result;
		}
	}

	protected JvmType createProxy(Type type) {
		JvmType proxy = typeProxies.get(type);
		if (proxy == null) {
			proxy = TypesFactory.eINSTANCE.createJvmVoid();
			URI uri = uriHelper.getFullURI(type);
			((InternalEObject)proxy).eSetProxyURI(uri);
			typeProxies.put(type, proxy);
		}
		return proxy;
	}

	protected JvmField createField(Field field) {
		JvmField result;
		int modifiers = field.getModifiers();
		if (!field.isEnumConstant()) {
			result = TypesFactory.eINSTANCE.createJvmField();
		} else
			result = TypesFactory.eINSTANCE.createJvmEnumerationLiteral();
		String fieldName = field.getName();
		result.internalSetIdentifier(field.getDeclaringClass().getName() + "." + fieldName);
		result.setSimpleName(fieldName);
		result.setFinal(Modifier.isFinal(modifiers));
		result.setStatic(Modifier.isStatic(modifiers));
		result.setTransient(Modifier.isTransient(modifiers));
		result.setVolatile(Modifier.isVolatile(modifiers));
		setVisibility(result, modifiers);
		Type fieldType = null;
		try {
			fieldType = field.getGenericType();
		} catch (GenericSignatureFormatError error) {
			logSignatureFormatError(field.getDeclaringClass());
			fieldType = field.getType();
		} catch (MalformedParameterizedTypeException error) {
			logSignatureFormatError(field.getDeclaringClass());
			fieldType = field.getType();
		}
		result.setType(createTypeReference(fieldType));
		createAnnotationValues(field, result);
		return result;
	}

	protected JvmConstructor createConstructor(Constructor<?> constructor) {
		JvmConstructor result = TypesFactory.eINSTANCE.createJvmConstructor();
		Class<?> declaringClass = constructor.getDeclaringClass();
		int offset = 0;
		if (declaringClass.isEnum()) {
			offset = 2;
		} else if (declaringClass.isMemberClass() && !Modifier.isStatic(declaringClass.getModifiers())) {
			offset = 1;
		}
		Type[] genericParameterTypes = null;
		try {
			genericParameterTypes = constructor.getGenericParameterTypes();
		} catch (GenericSignatureFormatError error) {
			logSignatureFormatError(declaringClass);
			genericParameterTypes = constructor.getParameterTypes();
		} catch (MalformedParameterizedTypeException error) {
			logSignatureFormatError(declaringClass);
			genericParameterTypes = constructor.getParameterTypes();
		}
		if (offset != 0) {
			/*
			 * #getGenericParameterTypes may return a different number of parameters
			 * for inner classes then #getParameterTypes does. This happens for
			 * signatures that are parameterized, e.g.
			 * 
			 * <pre>
			 * 
			 * class WrappedCollection<V> .. {
			 *   class WrappedIterator implements Iterator<V> {
			 *     WrappedIterator(Iterator<V> iterator) { .. }
			 *   }
			 * }
			 * 
			 * </pre>
			 * 
			 * Therefore we adjust the offset here
			 */
			if (constructor.getParameterTypes().length != genericParameterTypes.length) {
				offset = 0;
			}
		}
		enhanceGenericDeclaration(result, constructor);
		enhanceExecutable(result, constructor, declaringClass.getSimpleName(), genericParameterTypes,
				constructor.getParameterAnnotations(), offset);
		result.setVarArgs(constructor.isVarArgs());
		Type[] exceptionTypes;
		try {
			exceptionTypes = constructor.getGenericExceptionTypes();
		} catch (GenericSignatureFormatError error) {
			logSignatureFormatError(declaringClass);
			exceptionTypes = constructor.getExceptionTypes();
		} catch (MalformedParameterizedTypeException error) {
			logSignatureFormatError(declaringClass);
			exceptionTypes = constructor.getExceptionTypes();
		}
		if (exceptionTypes.length != 0) {
			InternalEList<JvmTypeReference> exceptions = (InternalEList<JvmTypeReference>)result.getExceptions();
			for (Type exceptionType : exceptionTypes) {
				exceptions.addUnique(createTypeReference(exceptionType));
			}
		}
		createAnnotationValues(constructor, result);
		return result;
	}

	protected void setVisibility(org.eclipse.xtext.common.types.JvmMember result, int modifiers) {
		if (Modifier.isPrivate(modifiers))
			result.setVisibility(JvmVisibility.PRIVATE);
		else if (Modifier.isProtected(modifiers))
			result.setVisibility(JvmVisibility.PROTECTED);
		else if (Modifier.isPublic(modifiers))
			result.setVisibility(JvmVisibility.PUBLIC);
		else
			result.setVisibility(JvmVisibility.DEFAULT);
	}

	protected <T extends Member & GenericDeclaration> void enhanceExecutable(JvmExecutable result, T member,
			String simpleName, Type[] parameterTypes, Annotation[][] annotations, int offset) {
		StringBuilder fqName = new StringBuilder(48);
		fqName.append(member.getDeclaringClass().getName());
		fqName.append('.');
		fqName.append(simpleName);
		fqName.append('(');
		InternalEList<JvmFormalParameter> parameters = (InternalEList<JvmFormalParameter>)result.getParameters();
		for (int typeIdx = offset, annotationIdx = annotations.length - parameterTypes.length + offset; typeIdx < parameterTypes.length; typeIdx++, annotationIdx++) {
			if (typeIdx != offset)
				fqName.append(',');
			Type parameterType = parameterTypes[typeIdx];
			uriHelper.computeTypeName(parameterType, fqName);
			parameters.addUnique(
					createFormalParameter(parameterType, "arg" + (typeIdx - offset), result, member,
							annotations[annotationIdx]));
		}
		fqName.append(')');
		result.internalSetIdentifier(fqName.toString());
		result.setSimpleName(simpleName);
		setVisibility(result, member.getModifiers());
	}

	protected void enhanceGenericDeclaration(JvmExecutable result, GenericDeclaration declaration) {
		TypeVariable<?>[] typeParameters = declaration.getTypeParameters();
		if (typeParameters.length != 0) {
			InternalEList<JvmTypeParameter> jvmTypeParameters = (InternalEList<JvmTypeParameter>)result.getTypeParameters();
			for (TypeVariable<?> variable : typeParameters) {
				jvmTypeParameters.addUnique(createTypeParameter(variable, result));
			}
		}
	}

	protected JvmOperation createOperation(Method method) {
		JvmOperation result = TypesFactory.eINSTANCE.createJvmOperation();
		Type[] genericParameterTypes = null;
		try {
			genericParameterTypes = method.getGenericParameterTypes();
		} catch (GenericSignatureFormatError error) {
			logSignatureFormatError(method.getDeclaringClass());
			genericParameterTypes = method.getParameterTypes();
		} catch (MalformedParameterizedTypeException error) {
			logSignatureFormatError(method.getDeclaringClass());
			genericParameterTypes = method.getParameterTypes();
		}
		enhanceGenericDeclaration(result, method);
		enhanceExecutable(result, method, method.getName(), genericParameterTypes, method.getParameterAnnotations(), 0);
		result.setVarArgs(method.isVarArgs());
		int modifiers = method.getModifiers();
		result.setAbstract(Modifier.isAbstract(modifiers));
		result.setFinal(Modifier.isFinal(modifiers));
		result.setStatic(Modifier.isStatic(modifiers));
		result.setSynchronized(Modifier.isSynchronized(modifiers));
		result.setStrictFloatingPoint(Modifier.isStrict(modifiers));
		result.setNative(Modifier.isNative(modifiers));
		Type returnType = null;
		try {
			returnType = method.getGenericReturnType();
		} catch (GenericSignatureFormatError error) {
			logSignatureFormatError(method.getDeclaringClass());
			returnType = method.getReturnType();
		} catch (MalformedParameterizedTypeException error) {
			logSignatureFormatError(method.getDeclaringClass());
			returnType = method.getReturnType();
		}
		result.setReturnType(createTypeReference(returnType));
		Type[] exceptionTypes;
		try {
			exceptionTypes = method.getGenericExceptionTypes();
		} catch (GenericSignatureFormatError error) {
			logSignatureFormatError(method.getDeclaringClass());
			exceptionTypes = method.getExceptionTypes();
		} catch (MalformedParameterizedTypeException error) {
			logSignatureFormatError(method.getDeclaringClass());
			exceptionTypes = method.getExceptionTypes();
		}
		if (exceptionTypes.length != 0) {
			InternalEList<JvmTypeReference> exceptions = (InternalEList<JvmTypeReference>)result.getExceptions();
			for (Type exceptionType : exceptionTypes) {
				exceptions.addUnique(createTypeReference(exceptionType));
			}
		}
		createAnnotationValues(method, result);
		return result;
	}

	protected JvmFormalParameter createFormalParameter(Type parameterType, String paramName,
			JvmMember container, GenericDeclaration member, Annotation[] annotations) {
		JvmFormalParameter result = TypesFactory.eINSTANCE.createJvmFormalParameter();
		result.setName(paramName);
		if (isLocal(parameterType, member)) {
			result.setParameterType(createLocalTypeReference(parameterType, (JvmTypeParameterDeclarator) container,
					member));
		} else {
			result.setParameterType(createTypeReference(parameterType));
		}
		if (annotations.length != 0) {
			InternalEList<JvmAnnotationReference> annotationsReferences = (InternalEList<JvmAnnotationReference>)result.getAnnotations();
			for (Annotation annotation : annotations) {
				annotationsReferences.addUnique(createAnnotationReference(annotation));
			}
		}
		return result;
	}

	protected JvmTypeReference createLocalTypeReference(Type type, JvmTypeParameterDeclarator container,
			GenericDeclaration member) {
		if (type instanceof GenericArrayType) {
			GenericArrayType arrayType = (GenericArrayType) type;
			Type componentType = arrayType.getGenericComponentType();
			return createLocalArrayTypeReference(componentType, container, member);
		} else if (type instanceof TypeVariable<?>) {
			TypeVariable<?> typeVariable = (TypeVariable<?>) type;
			JvmParameterizedTypeReference result = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
			int idx = Arrays.asList(member.getTypeParameters()).indexOf(typeVariable);
			result.setType(container.getTypeParameters().get(idx));
			return result;
		}
		throw new IllegalArgumentException(type.toString());
	}

	protected JvmTypeReference createLocalArrayTypeReference(Type componentType, JvmTypeParameterDeclarator container,
			GenericDeclaration member) {
		JvmTypeReference componentTypeReference = createLocalTypeReference(componentType, container, member);
		JvmGenericArrayTypeReference result = TypesFactory.eINSTANCE.createJvmGenericArrayTypeReference();
		result.setComponentType(componentTypeReference);
		return result;
	}

	protected boolean isLocal(Type parameterType, GenericDeclaration member) {
		if (parameterType instanceof TypeVariable<?>) {
			return member.equals(((TypeVariable<?>) parameterType).getGenericDeclaration());
		} else if (parameterType instanceof GenericArrayType) {
			return isLocal(((GenericArrayType) parameterType).getGenericComponentType(), member);
		}
		return false;
	}

	protected ReflectURIHelper getUriHelper() {
		return uriHelper;
	}

}
