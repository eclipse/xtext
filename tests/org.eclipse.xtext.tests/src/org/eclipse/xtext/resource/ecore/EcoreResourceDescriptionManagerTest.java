/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.ecore;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.ecore.EcoreResourceDescriptionManager;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;

import com.google.common.collect.ImmutableList;
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

	public void testPerformance() throws Exception {
		EcoreResourceDescriptionManager manager = new EcoreResourceDescriptionManager();
		Collection<String> uris = ImmutableList.copyOf(EPackage.Registry.INSTANCE.keySet());
		for(String uri: uris) {
			EPackage pack = EPackage.Registry.INSTANCE.getEPackage(uri);
			IResourceDescription description = manager.getResourceDescription(pack.eResource());
			assertNotNull(description);
			for(int i = 0; i < 10; i++) {
				Iterator<EObject> iter = EcoreUtil.getAllProperContents(pack, true);
				while(iter.hasNext()) {
					EObject next = iter.next();
					if (next instanceof ENamedElement) {
						String name = ((ENamedElement) next).getName();
//						Iterable<IEObjectDescription> objects = 
						description.getExportedObjects(next.eClass(), name);
//						assertFalse(name + " - " + uri + " - " + next, Iterables.isEmpty(objects));
					}
				}
			}
		}
	}
}
