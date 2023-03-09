/**
 * Copyright (c) 2012, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.junit.typesystem;

import org.eclipse.xtext.xbase.scoping.batch.IBatchScopeProvider;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputer;
import org.eclipse.xtext.xbase.typesystem.internal.DefaultReentrantTypeResolver;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("restriction")
@Deprecated(forRemoval = true)
public class PublicReentrantTypeResolver extends DefaultReentrantTypeResolver {
	@Override
	public void setTypeComputer(ITypeComputer typeComputer) {
		super.setTypeComputer(typeComputer);
	}

	@Override
	public IBatchScopeProvider getBatchScopeProvider() {
		return super.getBatchScopeProvider();
	}
}
