/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ResourceSetReferencingResourceSetTest extends Assert {
	
	@Test public void testSimple() throws Exception {
		ResourceSetReferencingResourceSetImpl set1 = new ResourceSetReferencingResourceSetImpl();
		Resource resource = getResource("foo1","foo2");
		set1.getResources().add(resource);
		ResourceSetReferencingResourceSetImpl set2 = new ResourceSetReferencingResourceSetImpl();
		Resource resource2 = getResource("foo2","foo3");
		set2.getResources().add(resource2);
		ResourceSetReferencingResourceSetImpl set3 = new ResourceSetReferencingResourceSetImpl();
		Resource resource3 = getResource("foo3",null);
		set3.getResources().add(resource3);
		
		set1.getReferencedResourceSets().add(set2);
		set2.getReferencedResourceSets().add(set3);
		
		assertSame(((EClass)resource.getContents().get(0)).getESuperTypes().get(0),resource2.getContents().get(0));
		assertSame(((EClass)resource2.getContents().get(0)).getESuperTypes().get(0),resource3.getContents().get(0));
		
	}
	
	@Test public void testNotTranitive() throws Exception {
		ResourceSetReferencingResourceSetImpl set1 = new ResourceSetReferencingResourceSetImpl();
		Resource resource = getResource("foo1","foo3");
		set1.getResources().add(resource);
		ResourceSetReferencingResourceSetImpl set2 = new ResourceSetReferencingResourceSetImpl();
		Resource resource2 = getResource("foo2",null);
		set2.getResources().add(resource2);
		ResourceSetReferencingResourceSetImpl set3 = new ResourceSetReferencingResourceSetImpl();
		Resource resource3 = getResource("foo3",null);
		set3.getResources().add(resource3);
		
		set1.getReferencedResourceSets().add(set2);
		set2.getReferencedResourceSets().add(set3);
		
		EClass eClass = ((EClass)resource.getContents().get(0)).getESuperTypes().get(0);
		assertTrue(((InternalEObject)eClass).eIsProxy());
	}
	
	@Test public void testShadowing() throws Exception {
		ResourceSetReferencingResourceSetImpl set1 = new ResourceSetReferencingResourceSetImpl();
		Resource resource = getResource("foo1","foo2");
		set1.getResources().add(resource);
		ResourceSetReferencingResourceSetImpl set2 = new ResourceSetReferencingResourceSetImpl();
		Resource resource2 = getResource("foo2",null);
		set2.getResources().add(resource2);
		ResourceSetReferencingResourceSetImpl set3 = new ResourceSetReferencingResourceSetImpl();
		Resource resource3 = getResource("foo2",null);
		set3.getResources().add(resource3);
		
		set1.getReferencedResourceSets().add(set2);
		set1.getReferencedResourceSets().add(set3);
		
		EClass referencedClass = ((EClass)resource.getContents().get(0)).getESuperTypes().get(0);
		assertNotSame(referencedClass,resource3.getContents().get(0));
		assertSame(referencedClass,resource2.getContents().get(0));
	}

	private Resource getResource(String resourceURI, String references) {
		XMIResourceImpl res = new XMIResourceImpl();
		res.setURI(URI.createURI(resourceURI));
		EcoreFactory f = EcoreFactory.eINSTANCE;
		EClass class1 = f.createEClass();
		res.getContents().add(class1);
		class1.setName("mytype");
		if (references!=null) {
			EClass referencedProxy = f.createEClass();
			String fragment = res.getURIFragment(class1);
			((InternalEObject)referencedProxy).eSetProxyURI(URI.createURI(references).appendFragment(fragment));
			class1.getESuperTypes().add(referencedProxy);
		}
		return res;
	}
}
