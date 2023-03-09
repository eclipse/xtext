/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource.ecore;

import static com.google.common.collect.Iterables.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.xtext.ecore.EcoreResourceDescriptionStrategy;
import org.eclipse.xtext.ecore.EcoreRuntimeModule;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.generic.GenericResourceDescriptionManager;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Jan Koehnlein
 */
public class EcoreResourceDescriptionManagerTest extends Assert {
	
	private GenericResourceDescriptionManager getEmfResourceDescriptionsManager() {
		Injector injector = Guice.createInjector(new EcoreRuntimeModule());
		return injector.getInstance(GenericResourceDescriptionManager.class);
	}
	
	@Test public void testEcore() throws Exception {
		Map<QualifiedName, IEObjectDescription> index = createIndex(EcorePackage.eINSTANCE.eResource());
		checkEcore(index, "ecore", false);
		checkEcore(index, EcorePackage.eNS_URI, true);
	}
	
	@Test public void testNestedPackage() throws Exception {
		Resource resource = new XMIResourceImpl();
		EPackage parent = EcoreFactory.eINSTANCE.createEPackage();
		parent.setName("parent");
		parent.setNsURI("http://parent");
		EPackage child = EcoreFactory.eINSTANCE.createEPackage();
		child.setName("child");
		child.setNsURI("http://child");
		EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		eClass.setName("Test");
		child.getEClassifiers().add(eClass);
		parent.getESubpackages().add(child);
		resource.getContents().add(parent);
		Map<QualifiedName, IEObjectDescription> index = createIndex(resource);
		checkEntry(index, parent, false, "parent");
		checkEntry(index, child, false, "parent", "child");
		checkEntry(index, eClass, false, "parent", "child", "Test");
		checkEntry(index, parent, true, "http://parent");
		checkEntry(index, child, true, "http://child");
		checkEntry(index, eClass, true, "http://child", "Test");
		assertEquals(6,index.size());
	}

	@Test public void testMissingNsURI() {
		Resource resource = new XMIResourceImpl();
		EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
		ePackage.setName("test");
		EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		eClass.setName("Test");
		ePackage.getEClassifiers().add(eClass);
		resource.getContents().add(ePackage);
		Map<QualifiedName, IEObjectDescription> index = createIndex(resource);
		checkEntry(index, ePackage, false, "test");
		checkEntry(index, eClass, false, "test", "Test");
		assertEquals(2,index.size());
	}
	
	@Test public void testMissingName() {
		Resource resource = new XMIResourceImpl();
		EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
		ePackage.setNsURI("http://test");
		EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		eClass.setName("Test");
		ePackage.getEClassifiers().add(eClass);
		resource.getContents().add(ePackage);
		Map<QualifiedName, IEObjectDescription> index = createIndex(resource);
		checkEntry(index, ePackage, true, "http://test");
		checkEntry(index, eClass, true, "http://test", "Test");
		assertEquals(2,index.size());
	}
	
	@Test public void testMissingMiddleName() {
		Resource resource = new XMIResourceImpl();
		EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
		ePackage.setName("test");
		ePackage.setNsURI("http://test");
		EClass unnamedEClass = EcoreFactory.eINSTANCE.createEClass();
		EAttribute eAttribute = EcoreFactory.eINSTANCE.createEAttribute();
		eAttribute.setName("test");
		unnamedEClass.getEStructuralFeatures().add(eAttribute);
		ePackage.getEClassifiers().add(unnamedEClass);
		resource.getContents().add(ePackage);
		Map<QualifiedName, IEObjectDescription> index = createIndex(resource);
		checkEntry(index, ePackage, false, "test");
		checkEntry(index, ePackage, true, "http://test");
		assertEquals(2,index.size());
		
		unnamedEClass.setName("Test");
		index = createIndex(resource);
		checkEntry(index, ePackage, false, "test");
		checkEntry(index, ePackage, true, "http://test");
		checkEntry(index, unnamedEClass, false, "test", "Test");
		checkEntry(index, unnamedEClass, true, "http://test", "Test");
		checkEntry(index, eAttribute, false, "test", "Test", "test");
		checkEntry(index, eAttribute, true, "http://test", "Test", "test");
		assertEquals(6,index.size());
	}
	
	protected void checkEcore(Map<QualifiedName, IEObjectDescription> index, String ePackageName, boolean isNsURI) {
		checkEntry(index, EcorePackage.eINSTANCE, isNsURI, ePackageName);
		checkEntry(index, EcorePackage.Literals.ECLASS, isNsURI, ePackageName, "EClass");
		checkEntry(index, EcorePackage.Literals.ECLASS__ABSTRACT, isNsURI, ePackageName, "EClass", "abstract");
		checkEntry(index, EcorePackage.Literals.ECLASS__ESUPER_TYPES, isNsURI, ePackageName, "EClass", "eSuperTypes");
		EOperation isSuperTypeOf = find(EcorePackage.Literals.ECLASS.getEOperations(), new Predicate<EOperation>() {
			@Override
			public boolean apply(EOperation input) {
				return input.getName().equals("isSuperTypeOf");
			}
		});
		checkEntry(index, isSuperTypeOf, isNsURI, ePackageName, "EClass", "isSuperTypeOf");
		checkEntry(index, EcorePackage.Literals.ESTRING, isNsURI, ePackageName, "EString");
	}

	protected void checkEntry(Map<QualifiedName, IEObjectDescription> index, EObject expectedElement, boolean expectedIsNsURI, String... names) {
		IEObjectDescription element = index.get(QualifiedName.create(names));
		assertEquals(expectedElement, element.getEObjectOrProxy());
		assertEquals(expectedIsNsURI, Boolean.parseBoolean(element.getUserData(EcoreResourceDescriptionStrategy.NS_URI_INDEX_ENTRY)));
	}

	protected Map<QualifiedName, IEObjectDescription> createIndex(Resource ecoreResoure) {
		GenericResourceDescriptionManager underTest = getEmfResourceDescriptionsManager();
		IResourceDescription description = underTest.getResourceDescription(ecoreResoure);
		
		Map<QualifiedName,IEObjectDescription> index = Maps.newHashMap();
		for (IEObjectDescription ieObjectDescription : description.getExportedObjects()) {
			index.put(ieObjectDescription.getName(), ieObjectDescription);
		}
		return index;
	}

	@Test public void testPerformance() throws Exception {
		GenericResourceDescriptionManager manager = getEmfResourceDescriptionsManager();
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
						description.getExportedObjects(EcorePackage.Literals.EOBJECT, QualifiedName.create(name), false);
//						assertFalse(name + " - " + uri + " - " + next, Iterables.isEmpty(objects));
					}
				}
			}
		}
	}
	

}
