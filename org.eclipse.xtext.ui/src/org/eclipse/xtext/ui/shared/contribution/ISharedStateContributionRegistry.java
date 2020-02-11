/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.shared.contribution;

import com.google.common.annotations.Beta;
import com.google.common.collect.ImmutableList;
import com.google.inject.Provider;

/**
 * <p>
 * A registry for shared contributions. Each contribution is loaded only once. That is, it is effectively a singleton.
 * </p>
 * 
 * <p>
 * The contributions are registered by the extension point
 * <code>org.eclipse.xtext.ui.shared.sharedStateContributingModule</code>.
 * </p>
 * 
 * <p>
 * See {@link SharedStateContribution} for a list of contribution types that are used by the framework.
 * </p>
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.5
 */
@Beta
public interface ISharedStateContributionRegistry {

	/**
	 * Returns all contribution handles. The result is never <code>null</code> but possibly empty.
	 */
	ImmutableList<? extends SharedStateContribution> getContributions();

	/**
	 * Initialize and return all known contributions. The result is never <code>null</code> but possibly empty.
	 */
	<T> ImmutableList<? extends T> getContributedInstances(Class<T> type);

	/**
	 * Initialize and return the single known contribution for the given type. Throws an {@link IllegalStateException}
	 * if there is no such contribution or more than one contribution for that type.
	 */
	<T> T getSingleContributedInstance(Class<T> type) throws IllegalStateException;

	/**
	 * Returns providers for all known contribution for the given type. The result is never <code>null</code> but
	 * possibly empty.
	 */
	<T> ImmutableList<? extends Provider<? extends T>> getLazyContributedInstances(Class<T> type);

	/**
	 * Return a provider the single known contribution for the given type. Throws an {@link IllegalStateException} if
	 * there is no such contribution or more than one contribution for that type.
	 */
	<T> Provider<? extends T> getLazySingleContributedInstance(Class<T> type) throws IllegalStateException;

}
