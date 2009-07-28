/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.util.EObjectValidator;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class CompositeEValidator implements EValidator {

	public static final String USE_EOBJECT_VALIDATOR = "org.eclipse.xtext.validation.CompositeEValidator.USE_EOBJECT_VALIDATOR";
	
	private List<EValidatorEqualitySupport> contents;
	
	@Inject(optional=true)
	@Named(value=USE_EOBJECT_VALIDATOR)
	private boolean useEObjectValidator = true;

	@Inject
	private Provider<EValidatorEqualitySupport> equalitySupportProvider;
	
	public static class EValidatorEqualitySupport {
		private EValidator delegate;

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof EValidatorEqualitySupport))
				return false;
			return obj != null
					&& ((EValidatorEqualitySupport) obj).getDelegate().getClass().equals(
							getDelegate().getClass());
		}

		@Override
		public int hashCode() {
			return getDelegate().getClass().getName().hashCode();
		}

		public void setDelegate(EValidator delegate) {
			this.delegate = delegate;
		}

		public EValidator getDelegate() {
			return delegate;
		}
	}

	protected void initDefaults() {
		if (isUseEObjectValidator()) {
	 		this.addValidator(new EObjectValidator(){
				@Override
				public boolean validate_EveryProxyResolves(EObject eObject, DiagnosticChain diagnostics,
						Map<Object, Object> context) {
					// don't check, we have our own implementation, which creates nicer messages
					return true;
				}
			});
		}
	}

	public void addValidator(EValidator validator) {
		if (this == validator)
			return;
		if (validator instanceof CompositeEValidator) {
			CompositeEValidator other = (CompositeEValidator) validator;
			for(int i = 0; i < other.getContents().size(); i++)
				addValidator(other.getContents().get(i).delegate);
		} else {
			EValidatorEqualitySupport equalitySupport = equalitySupportProvider.get();
			equalitySupport.setDelegate(validator);
			if (!getContents().contains(equalitySupport))
				this.getContents().add(equalitySupport);
		}
	}

	public boolean validate(EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = true;
		for (int i = 0; i < getContents().size(); i++) {
			EValidatorEqualitySupport val = getContents().get(i);
			try {
				result = result && val.getDelegate().validate(eObject, diagnostics, context);
			}
			catch (Exception e) {
				diagnostics.add(createExceptionDiagnostic("Error executing EValidator", eObject, e));
			}
		}
		return result;
	}

	public boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = true;
		for (int i = 0; i < getContents().size(); i++) {
			EValidatorEqualitySupport val = getContents().get(i);
			try {
				result = result && val.getDelegate().validate(eClass, eObject, diagnostics, context);
			}
			catch (Exception e) {
				diagnostics.add(createExceptionDiagnostic("Error executing EValidator", eClass, e));
			}
		}
		return result;
	}

	public boolean validate(EDataType eDataType, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = true;
		for (int i = 0; i < getContents().size(); i++) {
			EValidatorEqualitySupport val = getContents().get(i);
			try {
				result = result && val.getDelegate().validate(eDataType, value, diagnostics, context);
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

	public boolean isUseEObjectValidator() {
		return useEObjectValidator;
	}
	
	public void setUseEObjectValidator(boolean useEObjectValidator) {
		this.useEObjectValidator = useEObjectValidator;
	}

	public List<EValidatorEqualitySupport> getContents() {
		if (contents == null) {
			contents = new ArrayList<EValidatorEqualitySupport>(4);
			initDefaults();
		}
		return contents;
	}

	public void setEqualitySupportProvider(Provider<EValidatorEqualitySupport> equalitySupportProvider) {
		this.equalitySupportProvider = equalitySupportProvider;
	}

	public Provider<EValidatorEqualitySupport> getEqualitySupportProvider() {
		return equalitySupportProvider;
	}

}
