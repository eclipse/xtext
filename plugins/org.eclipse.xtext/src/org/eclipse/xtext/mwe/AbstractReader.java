/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.mwe;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent2;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Injector;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractReader extends AbstractWorkflowComponent2 {

	private Set<SlotEntry> slotEntries = Sets.newHashSet();

	public void addLoad(SlotEntry outputSlot) {
		slotEntries.add(outputSlot);
	}

	protected Set<SlotEntry> getSlotEntries() {
		return slotEntries;
	}

	private List<Injector> injectors = Lists.newArrayList();

	public void addRegister(ISetup setup) {
		injectors.add(setup.createInjectorAndDoEMFRegistration());
	}

	protected List<Injector> getInjectors() {
		return injectors;
	}

	private Provider<ResourceSet> provider = null;

	public void setResourceSetProvider(Provider<ResourceSet> provider) {
		this.provider = provider;
	}

	protected Provider<ResourceSet> getResourceSetProvider() {
		return provider;
	}

	private Validator validator = new Validator();
	
	private ResourceDescriptionsProvider resourceDescriptionsProvider = new ResourceDescriptionsProvider();

	public void setValidate(Validator validator) {
		this.validator = validator;
	}

	protected Validator getValidator() {
		return validator;
	}

	@Override
	protected void checkConfigurationInternal(Issues issues) {
		super.checkConfigurationInternal(issues);
		if (injectors.isEmpty())
			issues.addError(this,"No setup has been registered (example <register class='foo.bar.MyLanguageStandaloneSetup')");
		if (slotEntries.isEmpty()) {
			issues.addError(this,"No slot entries configured (example <load slot='mySlot' type='Type'/>).");
		}
	}

	protected void addModelElementsToContext(WorkflowContext ctx, ResourceSet resourceSet) {
		IResourceDescriptions descriptions = resourceDescriptionsProvider.get(resourceSet);
		for (SlotEntry entries : this.slotEntries) {
			entries.put(ctx, descriptions, resourceSet);
		}
	}

	protected ResourceSet getResourceSet() {
		if (provider != null)
			return provider.get();
		if (!injectors.isEmpty()) {
			ResourceSet instance = injectors.get(0).getInstance(ResourceSet.class);
			return instance;
		}
		return new ResourceSetImpl();
	}

	public void setResourceDescriptionsProvider(ResourceDescriptionsProvider resourceDescriptionsProvider) {
		this.resourceDescriptionsProvider = resourceDescriptionsProvider;
	}

	protected ResourceDescriptionsProvider getResourceDescriptionsProvider() {
		return resourceDescriptionsProvider;
	}

	protected IResourceServiceProvider.Registry getRegistry() {
		return IResourceServiceProvider.Registry.INSTANCE;
	}

}
