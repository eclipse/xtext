/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;

import com.google.inject.Inject;

/**
 * <p>An {@link org.eclipse.emf.ecore.EValidator} implementation, that can be
 * used via {@link ComposedChecks} generically to validate for duplicated 
 * exported objects.</p>
 * <p>
 * It validates <b>only</b> the objects, that will be publicly available via
 * an {@link IExportedEObjectsProvider}. Local variables and similar objects 
 * have to be validated on their own. The {@link INamesAreUniqueValidationHelper} provides
 * a convenient way to apply this kind of constraints.
 * </p>
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class NamesAreUniqueValidator extends AbstractDeclarativeValidator {

	@Inject
	private IResourceDescription.Manager.Registry resourceDescriptionProviderRegistry;
	
	@Inject
	private INamesAreUniqueValidationHelper helper;
	
	@Override
	protected List<EPackage> getEPackages() {
		return Collections.emptyList();
	}

	@Check
	public void checkUniqueNamesInResourceOf(EObject eObject) {
		Map<Object, Object> context = getContext();
		Resource resource = eObject.eResource();
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
		IResourceDescription.Manager manager = resourceDescriptionProviderRegistry.getResourceDescriptionManager(resource.getURI(),null);
		if (manager != null) {
			IResourceDescription description = manager.getResourceDescription(resource);
			if (description != null) {
				Iterable<IEObjectDescription> descriptions = description.getExportedObjects();
				helper.checkUniqueNames(descriptions, cancelIndicator, this);
			}
		}
	}

	public void setHelper(INamesAreUniqueValidationHelper helper) {
		this.helper = helper;
	}

	public INamesAreUniqueValidationHelper getHelper() {
		return helper;
	}

	public void setResourceDescriptionProviderRegistry(IResourceDescription.Manager.Registry resourceDescriptionProviderRegistry) {
		this.resourceDescriptionProviderRegistry = resourceDescriptionProviderRegistry;
	}

	public IResourceDescription.Manager.Registry getResourceDescriptionProviderRegistry() {
		return resourceDescriptionProviderRegistry;
	}
	
}
