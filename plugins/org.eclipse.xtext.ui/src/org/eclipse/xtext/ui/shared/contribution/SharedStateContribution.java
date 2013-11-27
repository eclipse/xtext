/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.shared.contribution;

import org.eclipse.xtext.ui.resource.IResourceSetInitializer;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Key;

/**
 * TODO Javadoc
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 * @since 2.5
 */
public final class SharedStateContribution {

	@Inject
	private Injector injector;
	
	public boolean isContributionSupported(Class<?> contribution) {
		return injector.getExistingBinding(Key.get(contribution)) != null;
	}
	
	public <T> T getContribution(Class<T> contribution) {
		return injector.getInstance(contribution);
	}
	
	public IResourceSetInitializer getResourceSetInitializer() {
		if (isContributionSupported(IResourceSetInitializer.class)) {
			return getContribution(IResourceSetInitializer.class);
		}
		return null;
	}
	
}
