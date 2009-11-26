/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.builder.BuilderModule;
import org.eclipse.xtext.builder.builderState.impl.ResourceDescriptionImpl;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class BuilderStateManagerTest extends TestCase {

	private BuilderStateManager mnr;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		Injector injector = Guice.createInjector(new BuilderModule());
		mnr = injector.getInstance(BuilderStateManager.class);
	}
	
	public void testSimple() throws Exception {
		mnr.load();
		mnr.modify(new IUnitOfWork<Void, BuilderState>() {

			public java.lang.Void exec(BuilderState state) throws Exception {
				ResourceDescriptionImpl res = (ResourceDescriptionImpl) BuilderStateFactory.eINSTANCE.createResourceDescription();
				res.setURI(URI.createURI("Foo"));
				state.getResourceDescriptions().add(res);
				return null;
			}});
		
		mnr.readOnly(new IUnitOfWork<Void, BuilderState>() {

			public java.lang.Void exec(BuilderState state) throws Exception {
				assertNotNull(state.getResourceDescription(URI.createURI("Foo")));
				return null;
			}
			
		});
	}
}
