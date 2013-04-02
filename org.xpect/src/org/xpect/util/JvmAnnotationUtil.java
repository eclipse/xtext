package org.xpect.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.apache.log4j.Logger;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationTarget;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmBooleanAnnotationValue;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmStringAnnotationValue;
import org.eclipse.xtext.common.types.JvmTypeAnnotationValue;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.xpect.XpectConstants;
import org.xpect.registry.ILanguageInfo;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Injector;

public class JvmAnnotationUtil {

	private static Logger logger = Logger.getLogger(JvmAnnotationUtil.class);

	public static JvmAnnotationReference getAnnotation(JvmAnnotationTarget target, Class<? extends Annotation> ann) {
		if (target instanceof JvmDeclaredType)
			return getAnnotation((JvmDeclaredType) target, ann);
		for (JvmAnnotationReference ref : target.getAnnotations()) {
			JvmAnnotationType annotation = ref.getAnnotation();
			if (annotation != null && !annotation.eIsProxy() && annotation.getQualifiedName().equals(ann.getName()))
				return ref;
		}
		return null;
	}

	public static JvmAnnotationReference getAnnotation(JvmDeclaredType type, Class<? extends Annotation> ann) {
		if (type == null || type.eIsProxy())
			return null;
		Set<JvmDeclaredType> visited = Sets.newHashSet(type);
		Stack<JvmDeclaredType> unvisited = new Stack<JvmDeclaredType>();
		unvisited.push(type);
		while (!unvisited.isEmpty()) {
			JvmDeclaredType current = unvisited.pop();
			for (JvmAnnotationReference ref : current.getAnnotations()) {
				JvmAnnotationType annotation = ref.getAnnotation();
				if (annotation != null && !annotation.eIsProxy() && annotation.getQualifiedName().equals(ann.getName()))
					return ref;
			}
			for (JvmTypeReference ref : current.getSuperTypes())
				if (ref.getType() instanceof JvmDeclaredType && !ref.getType().eIsProxy()) {
					JvmDeclaredType t = (JvmDeclaredType) ref.getType();
					if (!visited.add(t))
						continue;
					unvisited.push(t);
				}
		}
		return null;
	}

	public static <A extends JvmAnnotationValue> A getAnnotationValue(JvmAnnotationReference reference, Class<A> c) {
		return getAnnotationValue(reference, null, c);
	}

	@SuppressWarnings("unchecked")
	public static <A extends JvmAnnotationValue> A getAnnotationValue(JvmAnnotationReference reference, String n, Class<A> c) {
		if (reference != null && !reference.eIsProxy())
			for (JvmAnnotationValue value : reference.getValues())
				if ((n == null || n.equals(value.getValueName())) && c.isInstance(value))
					return (A) value;
		return null;
	}

	public static <A extends JvmAnnotationValue> A getAnnotationValue(JvmAnnotationTarget type, Class<? extends Annotation> ann, Class<A> c) {
		return getAnnotationValue(type, ann, null, c);
	}

	public static <A extends JvmAnnotationValue> A getAnnotationValue(JvmAnnotationTarget t, Class<? extends Annotation> a, String n,
			Class<A> c) {
		return getAnnotationValue(getAnnotation(t, a), n, c);
	}

	public static boolean isAnnotatedWith(JvmAnnotationTarget target, Class<? extends Annotation> annotation) {
		for (JvmAnnotationReference ref : target.getAnnotations()) {
			JvmAnnotationType type = ref.getAnnotation();
			if (type != null && !type.eIsProxy() && type.getQualifiedName().equals(annotation.getName()))
				return true;
		}
		return false;
	}

	public static <T> T newInstanceFromAnnotation(JvmAnnotationTarget type, Class<T> expected, Class<? extends Annotation> ann) {
		List<T> list = newInstancesViaAnnotation(type, expected, ann);
		if (list.size() == 1)
			return list.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	public static <T> List<T> newInstancesViaAnnotation(JvmAnnotationTarget type, Class<T> expected, Class<? extends Annotation> ann) {
		if (type == null || type.eIsProxy())
			return Collections.emptyList();
		JvmTypeAnnotationValue value = getAnnotationValue(type, ann, JvmTypeAnnotationValue.class);
		if (value == null || value.getValues().isEmpty())
			return Collections.emptyList();
		List<T> result = Lists.newArrayList();
		Injector injector = ILanguageInfo.Registry.INSTANCE.getLanguageByFileExtension(XpectConstants.XPECT_FILE_EXT).getInjector();
		IJavaReflectAccess reflectAccess = injector.getInstance(IJavaReflectAccess.class);
		for (JvmTypeReference ref : value.getValues())
			if (ref != null && !ref.eIsProxy() && ref.getType() != null && !ref.getType().eIsProxy()) {
				Class<?> adapter = reflectAccess.getRawType(ref.getType());
				if (adapter != null) {
					try {
						Object instance = adapter.newInstance();
						if (expected.isInstance(instance))
							result.add((T) instance);
					} catch (InstantiationException e) {
						logger.error(e);
					} catch (IllegalAccessException e) {
						logger.error(e);
					}
				}
			}
		return result;
	}

	@SuppressWarnings("unchecked")
	public static <T> List<T> newInstancesViaMetaAnnotation(JvmAnnotationTarget type, Class<T> expected, Class<? extends Annotation> ann) {
		if (type == null || type.eIsProxy())
			return Collections.emptyList();
		List<T> result = Lists.newArrayList();
		Injector injector = ILanguageInfo.Registry.INSTANCE.getLanguageByFileExtension(XpectConstants.XPECT_FILE_EXT).getInjector();
		IJavaReflectAccess reflectAccess = injector.getInstance(IJavaReflectAccess.class);
		for (JvmAnnotationReference ref : type.getAnnotations()) {
			if (ref.getAnnotation() == null || ref.getAnnotation().eIsProxy())
				continue;
			JvmTypeAnnotationValue value = getAnnotationValue(ref.getAnnotation(), ann, JvmTypeAnnotationValue.class);
			if (value == null || value.getValues().isEmpty())
				continue;
			for (JvmTypeReference val : value.getValues())
				if (val != null && !val.eIsProxy() && val.getType() != null && !val.getType().eIsProxy()) {
					Class<?> adapter = reflectAccess.getRawType(val.getType());
					if (adapter != null) {
						try {
							Annotation param = newInstance(ref);
							for (Constructor<?> cons : adapter.getConstructors()) {
								Class<?>[] parameterTypes = cons.getParameterTypes();
								if (parameterTypes.length == 1 && parameterTypes[0].isInstance(param)) {
									Object instance = cons.newInstance(param);
									if (expected.isInstance(instance))
										result.add((T) instance);
									break;
								}
							}
						} catch (InstantiationException e) {
							logger.error(e);
						} catch (IllegalAccessException e) {
							logger.error(e);
						} catch (SecurityException e) {
							logger.error(e);
						} catch (IllegalArgumentException e) {
							logger.error(e);
						} catch (InvocationTargetException e) {
							logger.error(e);
						}
					}
				}
		}
		return result;
	}

	public static Annotation newInstance(final JvmAnnotationReference ref) {
		Injector injector = ILanguageInfo.Registry.INSTANCE.getLanguageByFileExtension(XpectConstants.XPECT_FILE_EXT).getInjector();
		final IJavaReflectAccess reflectAccess = injector.getInstance(IJavaReflectAccess.class);
		Class<?> annotation = reflectAccess.getRawType(ref.getAnnotation());
		return (Annotation) Proxy.newProxyInstance(annotation.getClassLoader(), new Class<?>[] { annotation }, new InvocationHandler() {
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				for (JvmAnnotationValue value : ref.getValues())
					if (value.getValueName().equals(method.getName()))
						return getValue(value);
				if ("toString".equals(method.getName()))
					return ref.toString();
				if ("hashCode".equals(method.getName()))
					return ref.hashCode();
				if ("equals".equals(method.getName()))
					return ref.equals(args[0]);
				throw new RuntimeException("method '" + method.getName() + "' not found in " + ref.getAnnotation().getIdentifier());
			}

			protected Object getValue(JvmAnnotationValue value) {
				if (value instanceof JvmStringAnnotationValue)
					return ((JvmStringAnnotationValue) value).getValues().get(0);
				if (value instanceof JvmBooleanAnnotationValue)
					return ((JvmBooleanAnnotationValue) value).getValues().get(0);
				if (value instanceof JvmTypeAnnotationValue)
					return reflectAccess.getRawType(((JvmTypeAnnotationValue) value).getValues().get(0).getType());

				throw new RuntimeException("Unhandled annotation value type: " + value.eClass().getName());
			}
		});
	}
}
