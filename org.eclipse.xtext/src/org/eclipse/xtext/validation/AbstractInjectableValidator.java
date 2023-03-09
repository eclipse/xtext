/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.validation;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.Strings;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Jan Koehnlein 
 */
public abstract class AbstractInjectableValidator implements EValidator {

	public static final String CURRENT_LANGUAGE_NAME = AbstractInjectableValidator.class.getCanonicalName() + ".currentLanguageName";
	/**
	 * @since 2.4
	 */
	public static final String ISSUE_SEVERITIES = AbstractInjectableValidator.class.getCanonicalName() + ".issueSeverities";

	@Inject@Named(Constants.LANGUAGE_NAME) 
	private String languageName;
	
	@Inject
	public void register(EValidatorRegistrar registrar) {
		Collection<EPackage> packages = new LinkedHashSet<EPackage>(getEPackages());
		if (packages.size()==0) {
			throw new IllegalStateException("No EPackages were registered for the validator "+getClass().getName()+" please override and implement getEPackages().");
		}
		for (EPackage ePackage : packages) {
			registrar.register(ePackage, this);
		}
	}

	protected List<EPackage> getEPackages() {
		throw new UnsupportedOperationException("please overwrite");
	}

	@Override
	public boolean validate(EDataType eDataType, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	@Override
	final public boolean validate(EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate(eObject.eClass(), eObject, diagnostics, context);
	}

	@Override
	final public boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return (isResponsible(context, eObject)) ? internalValidate(eObject.eClass(), eObject, diagnostics, context) : true;
	}

	protected abstract boolean internalValidate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context);
	
	/**
	 * If this validator is for an EPackage you want to use in multiple languages, 
	 * this method should return false. Otherwise issues will be reported twice.
	 */
	public boolean isLanguageSpecific() {
		return languageName != null;
	}
	
	String getLanguageName() {
		return languageName;
	}
	
	protected boolean isResponsible(Map<Object, Object> context, EObject eObject) {
		return !isLanguageSpecific() || Strings.equal(languageName, getCurrentLanguage(context, eObject));
	}
	
	protected String getCurrentLanguage(Map<Object, Object> context, EObject eObject) {
		String currentLanguage = (context != null) ? (String) context.get(CURRENT_LANGUAGE_NAME) : null;
		if(currentLanguage == null) {
			Resource resource = eObject.eResource();
			if(resource instanceof XtextResource) 
				currentLanguage = ((XtextResource) resource).getLanguageName();
			else 
				currentLanguage = "";
			if(context != null) 
				context.put(CURRENT_LANGUAGE_NAME, currentLanguage);
		}
		return currentLanguage;
	}
	
}
