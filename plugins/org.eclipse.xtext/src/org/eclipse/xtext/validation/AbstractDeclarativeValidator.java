/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.util.EmfFormatter;
import org.eclipse.xtext.util.SimpleCache;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * Allows subclasses to specify invariants in a declarative manner using
 * {@link Check} annotation.
 *
 * Example:
 * <pre>
 * &#064;Check
 * void checkName(ParserRule rule) {
 * 	if (!toFirstUpper(rule.getName()).equals(rule.getName())) {
 * 		warning(&quot;Name should start with a capital.&quot;, XtextPackage.ABSTRACT_RULE__NAME);
 * 	}
 * }
 * </pre>
 * @author Sven Efftinge - Initial contribution and API
 * @author Michael Clay
 */
public abstract class AbstractDeclarativeValidator extends AbstractInjectableValidator implements ValidationMessageAcceptor {

	public static final Logger log = Logger.getLogger(AbstractDeclarativeValidator.class);
	
	public static class StateAccess {
		
		private AbstractDeclarativeValidator validator;
		
		private StateAccess(AbstractDeclarativeValidator validator) {
			this.validator = validator;
		}

		public State getState() {
			State result = validator.state.get();
			if (result == null) {
				result = new State();
				validator.state.set(result);
			}
			return result;
		}
		
	}

	static class MethodWrapper {
		public final Method method;
		private final String s;
		private final AbstractDeclarativeValidator instance;

		public MethodWrapper(AbstractDeclarativeValidator instance, Method m) {
			this.instance = instance;
			this.method = m;
			this.s = m.getName() + ":" + m.getParameterTypes()[0].getName();
		}

		@Override
		public int hashCode() {
			return s.hashCode() ^ instance.hashCode();
		}

		public boolean isMatching(Class<?> param) {
			return method.getParameterTypes()[0].isAssignableFrom(param);
		}

		public void invoke(State state) {
			if (instance.state.get() != null && instance.state.get() != state)
				throw new IllegalStateException("State is already assigned.");
			boolean wasNull = instance.state.get() == null;
			if (wasNull)
				instance.state.set(state);
			try {
				Check annotation = method.getAnnotation(Check.class);
				if (!state.checkMode.shouldCheck(annotation.value()))
					return;
				try {
					state.currentMethod = method;
					state.currentCheckType = annotation.value();
					method.setAccessible(true);
					method.invoke(instance, state.currentObject);
				}
				catch (IllegalArgumentException e) {
					log.error(e.getMessage(), e);
				}
				catch (IllegalAccessException e) {
					log.error(e.getMessage(), e);
				}
				catch (InvocationTargetException e) {
					// ignore GuardException, check is just not evaluated if
					// guard is false
					// ignore NullPointerException, as not having to check for
					// NPEs all the time is a convenience feature
					Throwable targetException = e.getTargetException();
					if (!(targetException instanceof GuardException)
							&& !(targetException instanceof NullPointerException))
						throw new RuntimeException(targetException);
				}
			}
			finally {
				if (wasNull)
					instance.state.set(null);
			}
		}

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof MethodWrapper))
				return false;
			MethodWrapper mw = (MethodWrapper) obj;
			return s.equals(mw.s) && instance == mw.instance;
		}
	}

	private volatile HashSet<MethodWrapper> checkMethods = null;
	
	private ValidationMessageAcceptor messageAcceptor;

	@Inject
	private Injector injector;
	
	public AbstractDeclarativeValidator() {
		this.state = new ThreadLocal<State>();
		this.messageAcceptor = this;
	}

	private List<MethodWrapper> collectMethods(Class<? extends AbstractDeclarativeValidator> clazz) {
		List<MethodWrapper> checkMethods = new ArrayList<MethodWrapper>();
		Set<Class<?>> visitedClasses = new HashSet<Class<?>>(4);
		collectMethods(this, clazz, visitedClasses, checkMethods);
		return checkMethods;
	}

	private void collectMethods(AbstractDeclarativeValidator instance,
			Class<? extends AbstractDeclarativeValidator> clazz, Collection<Class<?>> visitedClasses,
			Collection<MethodWrapper> result) {
		if (visitedClasses.contains(clazz))
			return;
		collectMethodsImpl(instance, clazz, visitedClasses, result);
		Class<? extends AbstractDeclarativeValidator> k = clazz;
		while (k != null) {
			ComposedChecks checks = k.getAnnotation(ComposedChecks.class);
			if (checks != null) {
				for (Class<? extends AbstractDeclarativeValidator> external : checks.validators())
					collectMethods(null, external, visitedClasses, result);
			}
			k = getSuperClass(k);
		}
	}

	private Class<? extends AbstractDeclarativeValidator> getSuperClass(
			Class<? extends AbstractDeclarativeValidator> clazz) {
		try {
			Class<? extends AbstractDeclarativeValidator> superClass = clazz.getSuperclass().asSubclass(
					AbstractDeclarativeValidator.class);
			if (AbstractDeclarativeValidator.class.equals(superClass))
				return null;
			return superClass;
		}
		catch (ClassCastException e) {
			return null;
		}
	}

	private void collectMethodsImpl(AbstractDeclarativeValidator instance,
			Class<? extends AbstractDeclarativeValidator> clazz, Collection<Class<?>> visitedClasses,
			Collection<MethodWrapper> result) {
		if (!visitedClasses.add(clazz))
			return;
		AbstractDeclarativeValidator instanceToUse;
		try {
			instanceToUse = instance;
			if (instanceToUse == null) {
				if (injector == null)
					instanceToUse = clazz.newInstance();
				else
					instanceToUse = injector.getInstance(clazz);
			}
		}
		catch (Exception e) {
			try {
				Constructor<? extends AbstractDeclarativeValidator> constr = null;
				constr = clazz.getDeclaredConstructor();
				constr.setAccessible(true);
				instanceToUse = constr.newInstance();
			}
			catch (Exception ex) {
				return;
			}
		}
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			if (method.getAnnotation(Check.class) != null && method.getParameterTypes().length == 1) {
				result.add(new MethodWrapper(instanceToUse, method));
			}
		}
		Class<? extends AbstractDeclarativeValidator> superClass = getSuperClass(clazz);
		if (superClass != null)
			collectMethodsImpl(instanceToUse, superClass, visitedClasses, result);
	}

	private final SimpleCache<Class<?>, List<MethodWrapper>> methodsForType = new SimpleCache<Class<?>, List<MethodWrapper>>(
			new Function<Class<?>, List<MethodWrapper>>() {
				public List<MethodWrapper> apply(Class<?> param) {
					List<MethodWrapper> result = new ArrayList<MethodWrapper>();
					for (MethodWrapper mw : checkMethods) {
						if (mw.isMatching(param))
							result.add(mw);
					}
					return result;
				}
			});

	public static class State {
		public DiagnosticChain chain = null;
		public EObject currentObject = null;
		public Method currentMethod = null;
		public CheckMode checkMode = null;
		public CheckType currentCheckType = null;
		public boolean hasErrors = false;
		public Map<Object, Object> context;
	}

	private final ThreadLocal<State> state;

	protected EObject getCurrentObject() {
		return state.get().currentObject;
	}

	protected Method getCurrentMethod() {
		return state.get().currentMethod;
	}

	protected DiagnosticChain getChain() {
		return state.get().chain;
	}

	protected CheckMode getCheckMode() {
		return state.get().checkMode;
	}
	
	protected Map<Object, Object> getContext() {
		return state.get().context;
	}

	public final boolean validate(EClass class1, EObject object, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (checkMethods == null) {
			synchronized(this) {
				if (checkMethods == null) {
					HashSet<MethodWrapper> checkMethods = new HashSet<MethodWrapper>();
					checkMethods.addAll(collectMethods(getClass()));
					this.checkMethods = checkMethods;
				}
			}
		}
		CheckMode checkMode = CheckMode.getCheckMode(context);

		State state = new State();
		state.chain = diagnostics;
		state.currentObject = object;
		state.checkMode = checkMode;
		state.context=context;

		for (MethodWrapper method : methodsForType.get(object.getClass())) {
			method.invoke(state);
		}

		return !state.hasErrors;
	}

	protected void warning(String string, Integer feature) {
		warning(string, feature, null);
	}

	protected void warning(String string, Integer feature, String code, String... issueData) {
		warning(string, state.get().currentObject, feature, code, issueData);
	}

	protected void warning(String string, EObject source, Integer feature) {
		warning(string, source, feature, null);
	}

	protected void warning(String string, EObject source, Integer feature, String code, String... issueData) {
		getMessageAcceptor().acceptWarning(string, source, feature, code, issueData);
	}
	
	public void acceptWarning(String message, EObject object, Integer feature, String code, String... issueData) {
		state.get().chain.add(new DiagnosticImpl(Diagnostic.WARNING, message, object, feature, state.get().currentCheckType, code, issueData));
	}

	protected void error(String string, Integer feature) {
		error(string, feature, null);
	}

	protected void error(String string, Integer feature, String code, String... issueData) {
		error(string, state.get().currentObject, feature, code, issueData);
	}

	protected void error(String string, EObject source, Integer feature) {
		error(string, source, feature, null);
	}

	protected void error(String string, EObject source, Integer feature, String code, String... issueData) {
		getMessageAcceptor().acceptError(string, source, feature, code, issueData);
	}
	
	public void acceptError(String message, EObject object, Integer feature, String code, String... issueData) {
		this.state.get().hasErrors = true;
		state.get().chain.add(new DiagnosticImpl(Diagnostic.ERROR, message, object, feature, state.get().currentCheckType, code, issueData));
	}

	protected void assertTrue(String message, Integer feature, boolean executedPredicate) {
		assertTrue(message, state.get().currentObject, feature, executedPredicate);
	}

	protected void assertTrue(String message, EObject source, Integer feature, boolean executedPredicate) {
		if (!executedPredicate)
			error(message, source, feature);
	}

	protected void assertFalse(String message, Integer feature, boolean executedPredicate) {
		assertFalse(message, state.get().currentObject, feature, executedPredicate);
	}

	protected void assertFalse(String message, EObject source, Integer feature, boolean executedPredicate) {
		if (executedPredicate)
			error(message, source, feature);
	}

	protected void assertNull(String message, int feature, Object object) {
		assertNull(message, state.get().currentObject, feature, object);
	}

	protected void assertNull(String message, EObject source, int feature, Object object) {
		if (object != null)
			error(message, source, feature);
	}

	protected void assertNotNull(String message, int feature, Object object) {
		assertNotNull(message, state.get().currentObject, feature, object);
	}

	protected void assertNotNull(String message, EObject source, int feature, Object object) {
		if (object == null)
			error(message, source, feature);
	}

	protected void assertEquals(String message, int feature, Object expected, Object actual) {
		assertEquals(message, state.get().currentObject, feature, expected, actual);
	}

	protected void assertEquals(String message, EObject source, int feature, Object expected, Object actual) {
		if (!expected.equals(actual))
			error(message, source, feature);
	}

	protected void assertNotEquals(String message, int feature, Object expected, Object actual) {
		assertNotEquals(message, state.get().currentObject, feature, expected, actual);
	}

	protected void assertNotEquals(String message, EObject source, int feature, Object expected, Object actual) {
		if (expected.equals(actual))
			error(message, source, feature);
	}

	protected void assertEmpty(String message, int feature, String string) {
		assertEmpty(message, state.get().currentObject, feature, string);
	}

	protected void assertEmpty(String message, EObject source, int feature, String string) {
		if (string != null && string.trim().length() > 0)
			error(message, source, feature);
	}

	protected void assertNotEmpty(String message, int feature, String string) {
		assertNotEmpty(message, state.get().currentObject, feature, string);
	}

	protected void assertNotEmpty(String message, EObject source, int feature, String string) {
		if (string == null || string.trim().length() == 0)
			error(message, source, feature);
	}

	protected void guard(boolean guardExpression) {
		if (!guardExpression) {
			throw new GuardException();
		}
	}

	protected void checkDone() {
		throw new GuardException();
	}

	public void setInjector(Injector injector) {
		this.injector = injector;
	}

	public Injector getInjector() {
		return injector;
	}

	public StateAccess setMessageAcceptor(ValidationMessageAcceptor messageAcceptor) {
		this.messageAcceptor = messageAcceptor;
		return new StateAccess(this);
	}

	public ValidationMessageAcceptor getMessageAcceptor() {
		return messageAcceptor;
	}

	public static class DiagnosticImpl implements Diagnostic {

		private DiagnosticImpl(int severity, String message, EObject source, Integer feature, CheckType checkType, String issueCode, String... issueData) {
			super();
			this.severity = severity;
			this.message = message;
			this.source = source;
			this.feature = feature;
			this.issueCode = issueCode;
			this.checkType = checkType;
			this.issueData = issueData;
		}

		private final String message;
		private final EObject source;
		private final Integer feature;
		private final int severity;
		private final CheckType checkType;
		private final String issueCode;
		private final String[] issueData;

		public List<Diagnostic> getChildren() {
			return Collections.emptyList();
		}

		// it turns out, the EMF Diagnostic works well with 0,
		// look at getIssueCode() to retrieve the string-based
		// code
		public int getCode() {
			return 0;
		}

		public List<?> getData() {
			List<Object> result = Lists.newArrayList();
			result.add(source);
			if (feature != null)
				result.add(feature);
			if(issueData != null) {
				result.add(issueData);
			}
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
			return source == null ? "" : source.toString();
		}
		
		public int getFeature() {
			return feature;
		}
		
		public String getIssueCode() {
			return issueCode;
		}
		
		public String[] getIssueData() {
			return issueData;
		}
		
		public CheckType getCheckType() {
			return checkType;
		}
		
		public static String severityToStr(int severity) {
			switch (severity) {
				case OK:
					return "OK";
				case INFO:
					return "INFO";
				case WARNING:
					return "WARNING";
				case ERROR:
					return "ERROR";
				case CANCEL:
					return "CANCEL";
				default:
					return Integer.toHexString(severity);
			}
		}

		@Override
		public String toString() {
			StringBuilder result = new StringBuilder();
			result.append("Diagnostic ");
			result.append(severityToStr(severity));
			if (issueCode != null) {
				result.append(" code=");
				result.append(issueCode);
			}
			result.append(" \"");
			result.append(message);
			result.append("\"");
			if (source != null) {
				result.append(" at ");
				result.append(EmfFormatter.objPath(source));
				if (feature != null && feature >= 0) {
					EStructuralFeature feat = source.eClass().getEStructuralFeature(feature);
					if (feat != null) {
						result.append(".");
						result.append(feat.getName());
						if (!feat.isMany()) { // we don't have the item's index it its a list :/
							if (feat instanceof EAttribute) {
								result.append("==\"");
								result.append(source.eGet(feat));
								result.append("\"");
							}
							else {
								result.append("==(");
								result.append(((EObject) source.eGet(feat)).eClass().getName());
								result.append(")");

							}
						}
					}
				}
			}
			return result.toString();
		}

	}
}
