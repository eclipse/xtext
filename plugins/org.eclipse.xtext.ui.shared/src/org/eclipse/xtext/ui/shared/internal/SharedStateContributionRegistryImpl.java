/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.shared.internal;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.xtext.ui.shared.contribution.SharedStateContribution;
import org.eclipse.xtext.ui.shared.contribution.ISharedStateContributionRegistry;

import com.google.common.collect.ImmutableList;
import com.google.inject.Binder;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Provider;
import com.google.inject.ProvisionException;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class SharedStateContributionRegistryImpl implements ISharedStateContributionRegistry {

	private static final String EXTENSION_POINT = Activator.PLUGIN_ID + ".sharedStateContributingModule";
	private static final Logger logger = Logger.getLogger(SharedStateContributionRegistryImpl.class);
	
	private ImmutableList<? extends SharedStateContribution> contributions;
	
	private Injector injector;
	
	@Inject
	private IExtensionRegistry extensionRegistry;
	
	/*
	 * Public for testing purpose.
	 */
	@Inject
	public SharedStateContributionRegistryImpl(Injector injector) {
		this.injector = injector;
	}
	
	/*
	 * Public for testing purpose
	 */
	public Injector createInjectorWithoutJITBindings(final Module childModule) {
		Injector childInjector = injector.createChildInjector(new Module() {
			public void configure(Binder binder) {
				binder.requireExplicitBindings();
			}
		}).createChildInjector(getWrappedModule(childModule));
		return childInjector;
	}
	
	public ImmutableList<? extends SharedStateContribution> getContributions() {
		if (contributions == null) {
			return initializeContributions();
		}
		return contributions;
	}
	
	public <T> ImmutableList<? extends T> getContributedInstances(Class<T> type) {
		ImmutableList.Builder<T> listBuilder = ImmutableList.builder();
		for(SharedStateContribution contribution: getContributions()) {
			if (contribution.isContributionSupported(type)) {
				listBuilder.add(contribution.getContribution(type));
			}
		}
		return listBuilder.build();
	}
	
	public <T> Provider<? extends T> getLazySingleContributedInstance(Class<T> type) {
		Provider<? extends T> result = null;
		for(SharedStateContribution contribution: getContributions()) {
			if (contribution.isContributionSupported(type)) {
				if (result == null) {
					result = contribution.getLazyContribution(type);
				} else {
					throw new IllegalStateException("Ambiguously contributed instances for type: " + type.getCanonicalName());
				}
			}
		}
		if (result == null) {
			throw new IllegalStateException("Missing contribution for type: " + type.getCanonicalName());
		}
		return result;
	}
	
	public <T> T getSingleContributedInstance(Class<T> type) {
		return getLazySingleContributedInstance(type).get();
	}
	
	public <T> ImmutableList<? extends Provider<? extends T>> getLazyContributedInstances(Class<T> type) {
		ImmutableList.Builder<Provider<? extends T>> listBuilder = ImmutableList.builder();
		for(SharedStateContribution contribution: getContributions()) {
			if (contribution.isContributionSupported(type)) {
				listBuilder.add(contribution.getLazyContribution(type));
			}
		}
		return listBuilder.build();
	}
	
	private synchronized ImmutableList<? extends SharedStateContribution> initializeContributions() {
		if (contributions == null) {
			final ImmutableList.Builder<SharedStateContribution> listBuilder = ImmutableList.builder();
			IExtensionPoint extensionPoint = extensionRegistry.getExtensionPoint(EXTENSION_POINT);
			IExtension[] extensions = extensionPoint.getExtensions();
			for(IExtension extension: extensions) {
				IConfigurationElement[] configurationElements = extension.getConfigurationElements();
				for(IConfigurationElement configurationElement: configurationElements) {
					try {
						Module childModule = (Module) configurationElement.createExecutableExtension("class");
						SharedStateContribution contribution = createContribution(childModule);
						listBuilder.add(contribution);
					} catch(CoreException e) {
						logger.error(e.getMessage(), e);
					} catch(ProvisionException e) {
						logger.error(e.getMessage(), e);
					}
				}
			}
			contributions = listBuilder.build();
		}
		return contributions;
	}

	/*
	 * Public for testing purpose.
	 */
	public SharedStateContribution createContribution(final Module childModule) {
		Injector childInjector = createInjectorWithoutJITBindings(childModule);
		SharedStateContribution contribution = childInjector.getInstance(SharedStateContribution.class);
		return contribution;
	}

	protected Module getWrappedModule(final Module childModule) {
		return new Module() {
			public void configure(Binder binder) {
				binder.bind(SharedStateContribution.class);
				binder.install(childModule);
			}
		};
	}
	
}
