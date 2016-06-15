/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.resource;

import java.io.IOException;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Moritz Eysholdt
 */
public class PersistentStateScopeResourceDescriptionsTest extends AbstractScopeResourceDescriptionsTest {

	@Inject
	private XtextResourceSetProvider resourceSetProvider;

	@Test
	public void testDirtyStateAware() throws IOException {
		assertDirtyState(false);
	}

	@Test
	public void testLiveScope() throws Exception {
		assertLiveModelScopeLocal(false);
	}

	@Test
	public void testLiveScope2() throws Exception {
		assertLiveModelScopeExternalFile(false);
	}

	@Override
	protected ResourceSet createResourceSet(IProject project) {
		ResourceSet resourceSet = resourceSetProvider.get(project);
		resourceSet.getLoadOptions().put(ResourceDescriptionsProvider.PERSISTED_DESCRIPTIONS, Boolean.TRUE);
		return resourceSet;
	}
}
