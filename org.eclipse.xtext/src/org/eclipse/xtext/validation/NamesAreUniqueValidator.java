/*******************************************************************************
 * Copyright (c) 2009, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.validation;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.DefaultUniqueNameContext.BaseContextProvider;
import org.eclipse.xtext.validation.INamesAreUniqueValidationHelper.Context;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

/**
 * <p>
 * An {@link org.eclipse.emf.ecore.EValidator} implementation, that can be used via {@link ComposedChecks} generically
 * to validate for duplicated exported objects.
 * </p>
 * <p>
 * It validates <b>only</b> the objects, that will be publicly available via an {@link IResourceDescription}. Local
 * variables and similar objects have to be validated on their own. The {@link INamesAreUniqueValidationHelper} provides
 * a convenient way to apply this kind of constraints.
 * </p>
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class NamesAreUniqueValidator extends AbstractDeclarativeValidator {

	/**
	 * @deprecated locally unused since 2.22
	 */
	@Deprecated
	@Inject
	private IResourceServiceProvider.Registry resourceServiceProviderRegistry = IResourceServiceProvider.Registry.INSTANCE;
	
	@Inject
	private INamesAreUniqueValidationHelper helper;
	
	@Inject
	private INamesAreUniqueValidationHelper.ContextProvider contextProvider = new DefaultUniqueNameContext.ExportedFromResource();

	@Override
	public void register(EValidatorRegistrar registrar) {
		// library validator is not registered for a specific language
	}

	@Check
	public void checkUniqueNamesInResourceOf(EObject eObject) {
		if (eObject.eContainer() != null) {
			return;
		}
			
		Map<Object, Object> context = getContext();
		Resource resource = eObject.eResource();
		if (resource==null)
			return;
		CancelIndicator cancelIndicator = null;
		if (context != null) {
			if (context.containsKey(resource))
				return; // resource was already validated
			context.put(resource, this);
			cancelIndicator = (CancelIndicator) context.get(CancelableDiagnostician.CANCEL_INDICATOR);
		}
		doCheckUniqueNames(resource, cancelIndicator);
	}

	public void doCheckUniqueNames(Resource resource, CancelIndicator cancelIndicator) {
		Context validationContext = getValidationContext(resource, cancelIndicator);
		if (validationContext != null) {
			helper.checkUniqueNames(validationContext, this);
		}
	}
	
	/**
	 * @since 2.22
	 */
	protected INamesAreUniqueValidationHelper.Context getValidationContext(Resource resource, CancelIndicator cancelIndicator) {
		return contextProvider.tryGetContext(resource, cancelIndicator);
	}

	public void setHelper(INamesAreUniqueValidationHelper helper) {
		this.helper = helper;
	}

	public INamesAreUniqueValidationHelper getHelper() {
		return helper;
	}

	/**
	 * @deprecated locally unused since 2.22
	 */
	@Deprecated
	public void setResourceServiceProviderRegistry(IResourceServiceProvider.Registry resourceDescriptionManagerRegistry) {
		this.resourceServiceProviderRegistry = resourceDescriptionManagerRegistry;
		if (contextProvider instanceof BaseContextProvider) {
			((BaseContextProvider) contextProvider).setResourceServiceProviderRegistry(resourceDescriptionManagerRegistry);
		}
	}

	/**
	 * @deprecated locally unused since 2.22
	 */
	@Deprecated
	public IResourceServiceProvider.Registry getResourceServiceProviderRegistry() {
		return resourceServiceProviderRegistry;
	}
	
	/**
	 * @since 2.22
	 */
	public INamesAreUniqueValidationHelper.ContextProvider getContextProvider() {
		return contextProvider;
	}
	
	/**
	 * @since 2.22
	 */
	public void setContextProvider(INamesAreUniqueValidationHelper.ContextProvider contextProvider) {
		this.contextProvider = Preconditions.checkNotNull(contextProvider);
	}

}
