/**
 * Copyright (c) 2013, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;

import com.google.inject.Inject;

/**
 * This tests ensures that the type calculation does not depend on some lazy evaluation. Therefore all argument types for all overloaded
 * variants are computed eagerly.
 * 
 * @author Sebastian Zarnekow
 */
public class InvariantCheckingIsolationTest extends AbstractBatchTypeResolverTest {
	@Inject
	private InvariantCheckingEagerBatchTypeResolver typeResolver;

	@Override
	public IBatchTypeResolver getTypeResolver() {
		return typeResolver;
	}
}
