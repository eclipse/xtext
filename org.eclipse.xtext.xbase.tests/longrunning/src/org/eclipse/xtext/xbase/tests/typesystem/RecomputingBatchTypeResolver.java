/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import org.eclipse.xtext.xbase.typesystem.internal.AbstractRootedReentrantTypeResolver;
import org.eclipse.xtext.xbase.typesystem.internal.DefaultBatchTypeResolver;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow
 */
public class RecomputingBatchTypeResolver extends DefaultBatchTypeResolver {
	@Inject
	private Provider<RecomputingReentrantTypeResolver> resolverProvider;

	@Override
	public AbstractRootedReentrantTypeResolver createResolver() {
		return resolverProvider.get();
	}
}
