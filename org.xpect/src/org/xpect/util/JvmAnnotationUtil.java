package org.xpect.util;

import java.lang.annotation.Annotation;
import java.util.Set;
import java.util.Stack;

import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationTarget;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmTypeReference;

import com.google.common.collect.Sets;

public class JvmAnnotationUtil {

	public static <A extends JvmAnnotationValue> A getAnnotationValue(JvmDeclaredType type, Class<? extends Annotation> ann, Class<A> c) {
		return getAnnotationValue(type, ann, null, c);
	}

	public static <A extends JvmAnnotationValue> A getAnnotationValue(JvmDeclaredType t, Class<? extends Annotation> a, String n, Class<A> c) {
		return getAnnotationValue(getAnnotation(t, a), n, c);
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

	public static boolean isAnnotatedWith(JvmAnnotationTarget target, Class<? extends Annotation> annotation) {
		for (JvmAnnotationReference ref : target.getAnnotations()) {
			JvmAnnotationType type = ref.getAnnotation();
			if (type != null && !type.eIsProxy() && type.getQualifiedName().equals(annotation.getName()))
				return true;
		}
		return false;
	}
}
