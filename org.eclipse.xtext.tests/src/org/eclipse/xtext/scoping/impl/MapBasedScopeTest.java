/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import java.util.Collections;

import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.junit.Test;

import com.google.common.collect.ImmutableList;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class MapBasedScopeTest extends AbstractScopeTest {

	@Override
	protected IScope createScope(IScope parent, Iterable<IEObjectDescription> content) {
		return MapBasedScope.createScope(parent, content);
	}
	
	@Override
	@Test public void testByNameWithDuplicate_01() {
		IScope scope = createScope(IScope.NULLSCOPE, ImmutableList.of(descriptionA, descriptionB_as_A, descriptionB));
		assertEqualElements(ImmutableList.of(descriptionA), scope.getElements(descriptionA.getName()));
		assertEqualElements(Collections.singleton(descriptionB), scope.getElements(descriptionB.getName()));
	}
	
	@Override
	@Test public void testByNameWithDuplicate_02() {
		IScope scope = createScope(IScope.NULLSCOPE, ImmutableList.of(descriptionB_as_A, descriptionA, descriptionB));
		assertEqualElements(ImmutableList.of(descriptionB_as_A), scope.getElements(descriptionA.getName()));
		assertEqualElements(Collections.singleton(descriptionB), scope.getElements(descriptionB.getName()));
	}
	
}
