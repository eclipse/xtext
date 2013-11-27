/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.shared.internal;

import org.eclipse.xtext.ui.shared.contribution.SharedStateContribution;
import org.eclipse.xtext.ui.shared.contribution.SharedStateContributionRegistry;
import org.eclipse.xtext.util.IAcceptor;

import com.google.common.collect.ImmutableList;
import com.google.inject.Binder;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class SharedStateContributionRegistryImpl extends AbstractContributedModuleReader implements SharedStateContributionRegistry {

	private static final String EXTENSION_POINT = Activator.PLUGIN_ID + ".sharedStateContributingModule";
	
	private ImmutableList<SharedStateContribution> contributions;
	
	/*
	 * Public for testing purpose.
	 */
	@Inject
	public SharedStateContributionRegistryImpl(Injector injector) {
		super(injector);
	}
	
	public ImmutableList<SharedStateContribution> getContributions() {
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
	
	private synchronized ImmutableList<SharedStateContribution> initializeContributions() {
		if (contributions == null) {
			final ImmutableList.Builder<SharedStateContribution> listBuilder = ImmutableList.builder();
			readModuleContributions(new IAcceptor<Module>() {
				public void accept(Module module) {
					SharedStateContribution contribution = createContribution(module);
					listBuilder.add(contribution);
				}
			});
			contributions = listBuilder.build();
		}
		return contributions;
	}

	public SharedStateContribution createContribution(final Module childModule) {
		Injector childInjector = createInjectorWithoutJITBindings(childModule);
		SharedStateContribution contribution = childInjector.getInstance(SharedStateContribution.class);
		return contribution;
	}

	/*
	 * Public for testing purpose
	 */
	@Override
	public Injector createInjectorWithoutJITBindings(Module childModule) {
		return super.createInjectorWithoutJITBindings(childModule);
	}
	
	@Override
	protected Module getWrappedModule(final Module childModule) {
		return new Module() {
			public void configure(Binder binder) {
				binder.bind(SharedStateContribution.class);
				binder.install(childModule);
			}
		};
	}

	@Override
	protected String getExtensionPointID() {
		return EXTENSION_POINT;
	}
	
}
