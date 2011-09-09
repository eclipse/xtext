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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.xtext.junit.AbstractXtextTests;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class LateInitializationLazyLinkingResourceTest extends AbstractXtextTests {

	/**
	 * @author efftinge - Initial contribution and API
	 */
	public static final class TestedResource extends LateInitializingLazyLinkingResource {
		public void setIsLoaded() {
			this.isLoaded = true;
		}
	}

	public void testInitialization() throws Exception {
		TestedResource resource = new TestedResource();
		assertTrue(resource.getContents().isEmpty());
		resource.setLateInitialization(new ILateInitialization() {
			public void doLateInitialization(EList<EObject> resourcesContentsList) {
				fail("shouldn't be called after initialization");
			}

			public void discardLateInitialization(EList<EObject> resourcesContentsList) {
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
		resource.setLateInitialization(new ILateInitialization() {
			public void doLateInitialization(EList<EObject> resourcesContentsList) {
				resourcesContentsList.add(EcoreFactory.eINSTANCE.createEObject());
			}

			public void discardLateInitialization(EList<EObject> resourcesContentsList) {
				resourcesContentsList.clear();
			}
		});
		assertEquals(1, resource.getContents().size());
	}
}
