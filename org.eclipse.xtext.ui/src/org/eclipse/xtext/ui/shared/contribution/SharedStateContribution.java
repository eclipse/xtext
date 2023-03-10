/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.shared.contribution;

import org.eclipse.xtext.ui.resource.IResourceSetInitializer;
import org.eclipse.xtext.ui.resource.IStorage2UriMapperContribution;

import com.google.inject.ConfigurationException;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Provider;
import com.google.inject.ProvisionException;

/**
 * A shared state contribution is used to obtain instances from a contributed injector. The injector is created as a
 * {@link Injector#createChildInjector(com.google.inject.Module...) child} of the shared master injector. It does not
 * allow JIT bindings since they would be contributed to the shared master.
 * 
 * The framework uses the following contribution types internally:
 * <ul>
 * <li>org.eclipse.xtext.builder.impl.QueuedBuildDataContribution</li>
 * <li>org.eclipse.xtext.builder.impl.ToBeBuiltComputerContribution</li>
 * <li>org.eclipse.xtext.builder.trace.StorageAwareTraceContribution</li>
 * <li>{@link IStorage2UriMapperContribution}</li>
 * <li>{@link IResourceSetInitializer}</li>
 * <li>{@link IEagerContribution}</li>
 * </ul>
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.5
 */
public final class SharedStateContribution {

	@Inject
	private Injector injector;

	/**
	 * Returns <code>true</code> if a contribution for the given type was registered.
	 */
	public boolean isContributionSupported(Class<?> type) {
		return injector.getExistingBinding(Key.get(type)) != null;
	}

	/**
	 * Returns an instance of the given type if such a contribution is supported.
	 * 
	 * @see #isContributionSupported(Class)
	 * @see Injector#getInstance(Class)
	 */
	public <T> T getContribution(Class<T> type) throws ProvisionException, ConfigurationException {
		return injector.getInstance(type);
	}

	/**
	 * Returns a provider for an instance of the given type if such a contribution is supported.
	 * 
	 * @see #isContributionSupported(Class)
	 * @see Injector#getProvider(Class)
	 */
	public <T> Provider<? extends T> getLazyContribution(Class<T> type) throws ConfigurationException {
		return injector.getProvider(type);
	}

}
