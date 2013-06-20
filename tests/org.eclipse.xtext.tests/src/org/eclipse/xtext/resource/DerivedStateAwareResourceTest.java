/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DerivedStateAwareResourceTest extends AbstractXtextTests {

	/**
	 * @author Sven Efftinge - Initial contribution and API
	 */
	public static final class TestedResource extends DerivedStateAwareResource {
		public void setIsLoaded() {
			this.isLoaded = true;
		}
	}

	@Test public void testInitialization() throws Exception {
		TestedResource resource = new TestedResource();
		assertTrue(resource.getContents().isEmpty());
		resource.setDerivedStateComputer(new IDerivedStateComputer() {
			public void installDerivedState(DerivedStateAwareResource resource, boolean resolve) {
				fail("shouldn't be called after initialization");
			}

			public void discardDerivedState(DerivedStateAwareResource resource) {
				fail("shouldn't be called after initialization");
			}
		});
		resource.getContents();
		resource.setIsLoaded();
		resource.eAdapters().add(new AdapterImpl(){
			@Override
			public void notifyChanged(Notification msg) {
				fail("notification received");
				super.notifyChanged(msg);
			}
		});
		resource.setDerivedStateComputer(new IDerivedStateComputer() {
			
			public void installDerivedState(DerivedStateAwareResource resource, boolean resolve) {
				resource.getContents().add(EcoreFactory.eINSTANCE.createEObject());
			}

			public void discardDerivedState(DerivedStateAwareResource resource) {
				resource.getContents().clear();
			}
		});
		assertEquals(1, resource.getContents().size());
	}
}
