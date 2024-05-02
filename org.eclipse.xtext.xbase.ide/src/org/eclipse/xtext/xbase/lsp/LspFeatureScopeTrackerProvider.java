/*******************************************************************************
 * Copyright (c) 2024 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.lsp;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.typesystem.internal.FeatureScopeTracker;
import org.eclipse.xtext.xbase.typesystem.internal.IFeatureScopeTracker;
import org.eclipse.xtext.xbase.typesystem.internal.OptimizingFeatureScopeTrackerProvider;

/**
 * @since 2.35
 */
public class LspFeatureScopeTrackerProvider extends OptimizingFeatureScopeTrackerProvider {
	
	@Override
	public IFeatureScopeTracker track(EObject root) {
		// Always track the feature scopes since we don't distinguish between open documents and regular files
		return new FeatureScopeTracker();
	}
	
}