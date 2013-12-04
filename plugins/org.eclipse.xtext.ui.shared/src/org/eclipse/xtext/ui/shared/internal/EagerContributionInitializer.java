/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.shared.internal;

import org.eclipse.xtext.ui.shared.contribution.IEagerContribution;
import org.eclipse.xtext.ui.shared.contribution.ISharedStateContributionRegistry;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class EagerContributionInitializer implements IEagerContribution {

	private ImmutableList<? extends IEagerContribution> contributions;

	@Inject
	private void setContributions(ISharedStateContributionRegistry registry) {
		contributions = registry.getContributedInstances(IEagerContribution.class);
	}
	
	public void initialize() {
		for(int i = 0; i < contributions.size(); i++) {
			contributions.get(i).initialize();
		}
	}

	public void discard() {
		for(int i = contributions.size() - 1; i >= 0; i--) {
			contributions.get(i).discard();
		}
	}

}
