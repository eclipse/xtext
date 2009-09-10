/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.concurrent;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.concurrent.IEObjectHandle.DefaultImpl;
import org.eclipse.xtext.dummy.DummyTestLanguageStandaloneSetup;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResource;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class IEObjectHandleImplTest extends AbstractXtextTests {
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(new DummyTestLanguageStandaloneSetup());
	}
	
	public void testSimple() throws Exception {
		final XtextResource resource = getResourceFromString("element foo; optional element bar;");
		IStateAccess<XtextResource> access = new IStateAccess.AbstractImpl<XtextResource>(){
			@Override
			protected XtextResource getState() {
				return resource;
			}
		};
		
		final EObject eObject = resource.getContents().get(0);
		
		DefaultImpl<EObject> impl = new IEObjectHandle.DefaultImpl<EObject>(eObject,access);
		
		impl.readOnly(new IUnitOfWork.Void<EObject>(){
			@Override
			public void process(EObject state) throws Exception {
				assertNotNull(state);
				assertSame(eObject, state);
			}
		});
		
		resource.getContents().clear();
		resource.getContents().addAll(getResourceFromString("element foo; optional element bar;").getContents());
		impl.readOnly(new IUnitOfWork.Void<EObject>(){
			@Override
			public void process(EObject state) throws Exception {
				assertNotNull(state);
				assertNotSame(eObject, state);
			}
		});
		
		resource.getContents().clear();
		impl.readOnly(new IUnitOfWork.Void<EObject>(){
			@Override
			public void process(EObject state) throws Exception {
				assertNull(state);
			}
		});
		
	}
}
