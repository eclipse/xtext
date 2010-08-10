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

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ScopeProviderTest extends AbstractXtextTests {
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(new DomainmodelStandaloneSetup());
	}
	
	public void testReferenceOppositeScope() throws Exception {
		DomainModel model = (DomainModel) getModel("entity Foo { ref foo:Bar} entity Bar { ref bar:Foo opposite foo}");
		Entity foo = (Entity) model.getElements().get(0);
		Entity bar = (Entity) model.getElements().get(1);
		assertSame(foo.getFeatures().get(0), ((Reference)bar.getFeatures().get(0)).getOpposite());
	}
}
