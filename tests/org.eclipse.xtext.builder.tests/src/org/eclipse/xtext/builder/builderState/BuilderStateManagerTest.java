/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState;

import junit.framework.TestCase;

import org.eclipse.xtext.builder.BuilderModule;
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
				Container container = BuilderStateFactory.eINSTANCE.createContainer();
				container.setName("Foo");
				container.setProject("Bar");
				state.getContainers().add(container);
				return null;
			}});
		
		mnr.readOnly(new IUnitOfWork<Void, BuilderState>() {

			public java.lang.Void exec(BuilderState state) throws Exception {
				assertEquals("Foo",state.getContainers().get(0).getName());
				assertEquals("Bar",state.getContainers().get(0).getProject());
				return null;
			}
			
		});
	}
}
