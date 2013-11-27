/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.shared.contribution;

import com.google.common.collect.ImmutableList;
import com.google.inject.Provider;

/**
 * TODO Javadoc
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.5
 */
public interface SharedStateContributionRegistry {

	ImmutableList<SharedStateContribution> getContributions();
	
	<T> ImmutableList<? extends T> getContributedInstances(Class<T> type);
	
	<T> T getSingleContributedInstances(Class<T> type);
	
	<T> ImmutableList<? extends Provider<? extends T>> getLazyContributedInstances(Class<T> type);
	
	<T> Provider<? extends T> getLazySingleContributedInstances(Class<T> type);
	
}
