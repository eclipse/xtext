/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;

/**
 * @author Sebastian Zarnekow
 */
public class BatchTypeResolverTest extends AbstractBatchTypeResolverTest {
	@Inject
	private IBatchTypeResolver typeResolver;

	@Override
	public IBatchTypeResolver getTypeResolver() {
		return typeResolver;
	}
}
