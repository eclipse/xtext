/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.xtext.crossref.IScope;
import org.eclipse.xtext.crossref.IScopedElement;
import org.eclipse.xtext.util.Function;
import org.eclipse.xtext.util.SimpleCache;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * 
 *         Allows subclasses to specify invariants in a declarative manner using
 *         {@link Check} annotation.
 * 
 *         Example:
 * 
 *         <pre>
 * &#064;Check
 * void checkName(ParserRule rule) {
 * 	if (!toFirstUpper(rule.getName()).equals(rule.getName())) {
 * 		warning(&quot;Name should start with a capital.&quot;, XtextPackage.ABSTRACT_RULE__NAME);
 * 	}
 * }
 * </pre>
 */
public abstract class AbstractDeclarativeValidator extends EObjectValidator implements EValidator {

	class MethodWrapper {
		public final Method method;
		private String s;

		public MethodWrapper(Method m) {
			this.method = m;
			this.s = m.getName() + ":" + m.getParameterTypes()[0].getName();
		}

		@Override
		public int hashCode() {
			return s.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			MethodWrapper mw = (MethodWrapper) obj;
			return s.equals(mw.s);
		}
	}

	public AbstractDeclarativeValidator() {
		checkMethods = new HashSet<MethodWrapper>();
		checkMethods.addAll(collectMethods(getClass()));
	}

	private List<MethodWrapper> collectMethods(Class<?> clazz) {
		List<MethodWrapper> checkMethods = clazz.getSuperclass() == AbstractDeclarativeValidator.class ? new ArrayList<MethodWrapper>()
				: new ArrayList<MethodWrapper>(collectMethods(clazz.getSuperclass()));
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			if (method.getAnnotation(Check.class) != null && method.getParameterTypes().length == 1) {
				checkMethods.add(new MethodWrapper(method));
			}
		}
		return checkMethods;
	}

	private HashSet<MethodWrapper> checkMethods = null;

	private SimpleCache<Class<?>, List<Method>> methodsForType = new SimpleCache<Class<?>, List<Method>>(
			new Function<Class<?>, List<Method>>() {

				public List<Method> exec(Class<?> param) {
					List<Method> result = new ArrayList<Method>();
					for (MethodWrapper mw : checkMethods) {
						Method method = mw.method;
						if (method.getParameterTypes()[0].isAssignableFrom(param)) {
							result.add(method);
						}
					}
					return result;
				}
			});

	private DiagnosticChain chain = null;
	private EObject currentObject = null;
	private Method currentMethod = null;
	private Logger log = Logger.getLogger(getClass());

	private boolean hasErrors;

	protected EObject getCurrentObject() {
		return this.currentObject;
	}

	protected Method getCurrentMethod() {
		return this.currentMethod;
	}

	public final boolean validate(EClass class1, EObject object, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		this.hasErrors = false;
		boolean isValid = super.validate(class1,object,diagnostics,context);
		boolean skipExpensive = false;
		if (context != null) {
			Object object2 = context.get(CheckMode.KEY);
			if (object2 instanceof Integer) {
				skipExpensive = CheckMode.FAST == (Integer) object2;
			}
		}

		try {
			this.chain = diagnostics;
			this.currentObject = object;
			List<Method> list = methodsForType.get(object.getClass());
			for (Method method : list) {
				if (skipExpensive) {
					Check annotation = method.getAnnotation(Check.class);
					if (annotation.value() == CheckType.EXPENSIVE)
						continue;
				}
				try {
					this.currentMethod = method;
					method.setAccessible(true);
					method.invoke(this, currentObject);
				}
				catch (GuardException e) {
					// ignore, check is just not evaluated if guard is false
				}
				catch (NullPointerException e) {
					// ignore, as not having to check for NPEs all the time is a convenience feature
				}
				catch (IllegalArgumentException e) {
					log.error(e.getMessage(), e);
				}
				catch (IllegalAccessException e) {
					log.error(e.getMessage(), e);
				}
				catch (InvocationTargetException e) {
					log.error(e.getMessage(), e.getTargetException());
				}
				finally {
					method.setAccessible(false);
				}
			}
			return isValid && !hasErrors;
		}
		finally {
			this.currentObject = null;
			this.chain = null;
		}
	}

	protected void warning(String string, int feature) {
		chain.add(new DiagnosticImpl(Diagnostic.WARNING, string, currentObject, feature));
	}

	protected void error(String string, int feature) {
		this.hasErrors = true;
		chain.add(new DiagnosticImpl(Diagnostic.ERROR, string, currentObject, feature));
	}

	protected void assertTrue(String message, int feature, boolean executedPredicate) {
		if (!executedPredicate)
			error(message, feature);
	}

	protected void assertFalse(String message, int feature, boolean executedPredicate) {
		if (executedPredicate)
			error(message, feature);
	}

	protected void assertNull(String message, int feature, Object object) {
		if (object != null)
			error(message, feature);
	}

	protected void assertNotNull(String message, int feature, Object object) {
		if (object == null)
			error(message, feature);
	}

	protected void assertEquals(String message, int feature, Object expected, Object actual) {
		if (!expected.equals(actual))
			error(message, feature);
	}

	protected void assertNotEquals(String message, int feature, Object expected, Object actual) {
		if (expected.equals(actual))
			error(message, feature);
	}

	protected void assertEmpty(String message, int feature, String string) {
		if (string != null && string.trim().length() > 0)
			error(message, feature);
	}

	protected void assertNotEmpty(String message, int feature, String string) {
		if (string == null || string.trim().length() == 0)
			error(message, feature);
	}

	protected void assertNameIsUniqueInScope(String message, int feature, EObject object, String name, IScope scope) {
		for(Iterator<IScopedElement> i=scope.getContents().iterator(); i.hasNext(); ) {
			IScopedElement scopedElement = i.next();
			if(!object.equals(scopedElement.element()) && !name.equals(scopedElement.name())) {
				error(message, feature);
			}
		}
	}
	
	protected void guard(boolean guardExpression) {
		if(!guardExpression) {
			throw new GuardException();
		}
	}
	
	static class DiagnosticImpl implements Diagnostic {

		private DiagnosticImpl(int severity, String message, EObject source, int feature) {
			super();
			this.severity = severity;
			this.message = message;
			this.source = source;
			this.feature = feature;
		}

		private final String message;
		private final EObject source;
		private final Integer feature;
		private final int severity;

		public List<Diagnostic> getChildren() {
			return null;
		}

		public int getCode() {
			return 0;
		}

		public List<?> getData() {
			List<Object> result = new ArrayList<Object>();
			result.add(source);
			if (feature != null)
				result.add(feature);
			return result;
		}

		public Throwable getException() {
			return null;
		}

		public String getMessage() {
			return message;
		}

		public int getSeverity() {
			return severity;
		}

		public String getSource() {
			return source.toString();
		}

	}
}
