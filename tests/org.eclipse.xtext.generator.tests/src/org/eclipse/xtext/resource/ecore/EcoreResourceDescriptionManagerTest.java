/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.ecore;

import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;

import com.google.common.collect.Maps;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class EcoreResourceDescriptionManagerTest extends TestCase {
	
	public void testNaming() throws Exception {
		EcoreResourceDescriptionManager underTest = new EcoreResourceDescriptionManager();
		IResourceDescription description = underTest.getResourceDescription(EcorePackage.eINSTANCE.eResource());
		
		Map<String,IEObjectDescription> index = Maps.newHashMap();
		for (IEObjectDescription ieObjectDescription : description.getExportedObjects()) {
			index.put(ieObjectDescription.getName(), ieObjectDescription);
		}
		
		assertEquals(EcorePackage.eINSTANCE, index.get("ecore").getEObjectOrProxy());
		assertEquals(EcorePackage.Literals.ECLASS, index.get("EClass").getEObjectOrProxy());
	}

}
