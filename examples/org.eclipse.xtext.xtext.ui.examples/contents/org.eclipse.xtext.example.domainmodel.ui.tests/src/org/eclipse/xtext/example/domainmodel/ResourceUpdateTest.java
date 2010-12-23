/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.domainmodel;

import org.eclipse.xtext.example.DomainmodelStandaloneSetup;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.OnChangeEvictingCache;
import org.eclipse.xtext.util.Wrapper;
import org.eclipse.xtext.util.OnChangeEvictingCache.CacheAdapter;
import org.eclipse.xtext.util.OnChangeEvictingCache.Listener;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ResourceUpdateTest extends AbstractXtextTests {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(DomainmodelStandaloneSetup.class);
	}
	
	public void testUpdate() throws Exception {
		String model = "entity A {} entity B extends A {}";
		String onlyB = "entity B extends A {}";
		XtextResource resource = getResource("", "uri");
		// initial model typing
		resource.update(0, 0, model);
		// delete first entity
		resource.update(0, model.length(), onlyB);
		DomainModel domainModel = (DomainModel) resource.getContents().get(0);
		Entity b = (Entity) domainModel.getElements().get(0);
		assertTrue("superType is unresolved", b.getSuperType().eIsProxy());
		// restore removed entity
		resource.update(0, onlyB.length(), model);
		domainModel = (DomainModel) resource.getContents().get(0);
		b = (Entity) domainModel.getElements().get(1);
		assertFalse("superType can be resolved", b.getSuperType().eIsProxy());
	}
	
}
