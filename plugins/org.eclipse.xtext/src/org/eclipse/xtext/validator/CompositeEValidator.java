/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.validator;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class CompositeEValidator implements EValidator {

	private final Set<EValidatorEqualitySupport> contents;

	private static class EValidatorEqualitySupport {
		private final EValidator delegate;

		public EValidatorEqualitySupport(EValidator delegate) {
			this.delegate = delegate;
		}

		@Override
		public boolean equals(Object obj) {
			return obj != null
					&& ((EValidatorEqualitySupport) obj).delegate.getClass().getName().equals(
							delegate.getClass().getName());
		}

		@Override
		public int hashCode() {
			return delegate.getClass().getName().hashCode();
		}
	}

	public CompositeEValidator() {
		contents = new LinkedHashSet<EValidatorEqualitySupport>();
		this.contents.add(new EValidatorEqualitySupport(new EObjectValidator(){
			@Override
			public boolean validate_EveryProxyResolves(EObject eObject, DiagnosticChain diagnostics,
					Map<Object, Object> context) {
				// don't check, we have our own implementation, which creates nicer messages
				return true;
			}
		}));
	}

	public CompositeEValidator(EValidator validator) {
		this();
		addValidator(validator);
	}

	public static void register(EPackage pack, EValidator val, EValidator.Registry registry) {
		EValidator validator = registry.getEValidator(pack);
		if (validator == null) {
			validator = new CompositeEValidator();
		}
		else if (!(validator instanceof CompositeEValidator)) {
			validator = new CompositeEValidator(validator);
		}
		((CompositeEValidator) validator).addValidator(val);
		registry.put(pack, validator);
	}

	public void addValidator(EValidator validator) {
		if (validator instanceof CompositeEValidator)
			contents.addAll(((CompositeEValidator) validator).contents);
		else
			this.contents.add(new EValidatorEqualitySupport(validator));
	}

	public boolean validate(EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = true;
		for (EValidatorEqualitySupport val : contents) {
			try {
				result = result && val.delegate.validate(eObject, diagnostics, context);
			}
			catch (Exception e) {
				diagnostics.add(createExceptionDiagnostic("Error executing EValidator", eObject, e));
			}
		}
		return result;
	}

	public boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = true;
		for (EValidatorEqualitySupport val : contents) {
			try {
				result = result && val.delegate.validate(eClass, eObject, diagnostics, context);
			}
			catch (Exception e) {
				diagnostics.add(createExceptionDiagnostic("Error executing EValidator", eClass, e));
			}
		}
		return result;
	}

	public boolean validate(EDataType eDataType, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = true;
		for (EValidatorEqualitySupport val : contents) {
			try {
				result = result && val.delegate.validate(eDataType, value, diagnostics, context);
			}
			catch (Exception e) {
				diagnostics.add(createExceptionDiagnostic("Error executing EValidator", eDataType, e));
			}
		}
		return result;
	}

	private Diagnostic createExceptionDiagnostic(String message, Object source, Throwable t) {
		return new BasicDiagnostic(Diagnostic.ERROR, source.toString(), 0, message, new Object[] { t });

	}
}
