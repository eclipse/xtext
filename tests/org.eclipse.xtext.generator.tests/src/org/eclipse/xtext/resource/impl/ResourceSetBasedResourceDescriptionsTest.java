/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.IResourceDescription.Manager;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ResourceSetBasedResourceDescriptionsTest extends TestCase implements IResourceServiceProvider.Registry, Function<IEObjectDescription, EObject> {

	private ResourceSet resourceSet;
	private DefaultResourceDescriptionManager resourceDescriptionManager;
	private IContainer container;
	private int nameCount;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		resourceSet = new ResourceSetImpl();
		IQualifiedNameProvider qualifiedNameProvider = new IQualifiedNameProvider() {

			public String getQualifiedName(EObject obj) {
				return ((ENamedElement) obj).getName();
			}

			public String apply(EObject from) {
				return ((ENamedElement) from).getName();
			}
			
		};
		resourceDescriptionManager = new DefaultResourceDescriptionManager();
		resourceDescriptionManager.setNameProvider(qualifiedNameProvider);
		ResourceSetBasedResourceDescriptions resDescs = new ResourceSetBasedResourceDescriptions();
		resDescs.setContext(resourceSet);
		resDescs.setRegistry(this);
		container = new ResourceDescriptionsBasedContainer(resDescs);
	}

	public IResourceServiceProvider getResourceServiceProvider(URI uri, String contentType) {
		return new DefaultResourceServiceProvider() {
			@Override
			public Manager getResourceDescriptionManager() {
				return resourceDescriptionManager;
			}
		};
	}
	
	public void testEmptyResourceSet() {
		Iterable<IEObjectDescription> iterable = container.findAllEObjects(EcorePackage.Literals.EOBJECT);
		assertTrue(Iterables.isEmpty(iterable));
		iterable = container.findAllEObjects(EcorePackage.Literals.EOBJECT, "Zonk");
		assertTrue(Iterables.isEmpty(iterable));
	}
	
	public void testOneElement_Mismatch() {
		String name = "SomeName";
		EClass type = EcorePackage.Literals.EPACKAGE;
		Resource resource = createResource();
		createNamedElement(name, type, resource);
		Iterable<IEObjectDescription> iterable = container.findAllEObjects(EcorePackage.Literals.ECLASS);
		assertTrue(Iterables.isEmpty(iterable));
		iterable = container.findAllEObjects(EcorePackage.Literals.ECLASS, name);
		assertTrue(Iterables.isEmpty(iterable));
		iterable = container.findAllEObjects(EcorePackage.Literals.EPACKAGE, "AnotherName");
		assertTrue(Iterables.isEmpty(iterable));
	}
	
	public void testOneElement_Match() {
		String name = "SomeName";
		EClass type = EcorePackage.Literals.EPACKAGE;
		Resource resource = createResource();
		ENamedElement element = createNamedElement(name, type, resource);
		Iterable<IEObjectDescription> iterable = container.findAllEObjects(EcorePackage.Literals.EPACKAGE);
		assertSame(element, Iterables.getOnlyElement(iterable).getEObjectOrProxy());
		iterable = container.findAllEObjects(EcorePackage.Literals.EOBJECT);
		assertSame(element, Iterables.getOnlyElement(iterable).getEObjectOrProxy());
		iterable = container.findAllEObjects(EcorePackage.Literals.EPACKAGE, name);
		assertSame(element, Iterables.getOnlyElement(iterable).getEObjectOrProxy());
		iterable = container.findAllEObjects(EcorePackage.Literals.ENAMED_ELEMENT, name);
		assertSame(element, Iterables.getOnlyElement(iterable).getEObjectOrProxy());
		iterable = container.findAllEObjects(EcorePackage.Literals.EOBJECT, name);
		assertSame(element, Iterables.getOnlyElement(iterable).getEObjectOrProxy());
	}
	
	public void testTwoElements_OneMatch() {
		String name = "SomeName";
		EClass type = EcorePackage.Literals.EPACKAGE;
		Resource resource = createResource();
		ENamedElement element = createNamedElement(name, type, resource);
		ENamedElement other = createNamedElement(null, EcorePackage.Literals.ECLASS, resource);
		Iterable<IEObjectDescription> iterable = container.findAllEObjects(EcorePackage.Literals.EPACKAGE);
		assertSame(element, Iterables.getOnlyElement(iterable).getEObjectOrProxy());
		iterable = container.findAllEObjects(EcorePackage.Literals.ECLASSIFIER);
		assertSame(other, Iterables.getOnlyElement(iterable).getEObjectOrProxy());
		iterable = container.findAllEObjects(EcorePackage.Literals.EPACKAGE, name);
		assertSame(element, Iterables.getOnlyElement(iterable).getEObjectOrProxy());
		iterable = container.findAllEObjects(EcorePackage.Literals.ENAMED_ELEMENT, name);
		assertSame(element, Iterables.getOnlyElement(iterable).getEObjectOrProxy());
		iterable = container.findAllEObjects(EcorePackage.Literals.EOBJECT, name);
		assertSame(element, Iterables.getOnlyElement(iterable).getEObjectOrProxy());
	}
	
	public void testTwoResources_TwoMatches() {
		String name = "SomeName";
		EClass type = EcorePackage.Literals.EPACKAGE;
		Resource resource = createResource();
		ENamedElement first = createNamedElement(name, type, resource);
		resource = createResource();
		ENamedElement second = createNamedElement(name, type, resource);
		List<ENamedElement> expected = Lists.newArrayList(first, second);
		Iterable<IEObjectDescription> iterable = container.findAllEObjects(EcorePackage.Literals.EPACKAGE);
		checkFindAllEObjectsResult(expected, iterable);
		iterable = container.findAllEObjects(EcorePackage.Literals.EPACKAGE, name);
		checkFindAllEObjectsResult(expected, iterable);
		iterable = container.findAllEObjects(EcorePackage.Literals.ENAMED_ELEMENT, name);
		checkFindAllEObjectsResult(expected, iterable);
		iterable = container.findAllEObjects(EcorePackage.Literals.EOBJECT, name);
		checkFindAllEObjectsResult(expected, iterable);
	}

	private void checkFindAllEObjectsResult(List<ENamedElement> expected, Iterable<IEObjectDescription> iterable) {
		Iterable<EObject> transformed = Iterables.transform(iterable, this);
		Set<EObject> transformedSet = Sets.newHashSet(transformed);
		Set<ENamedElement> expectedSet = Sets.newHashSet(expected);
		assertEquals(expected.size(), expectedSet.size());
		assertEquals(expectedSet, transformedSet);
	}
	
	public void testPerformance10Resources100EClassesEach() {
		int resourceCount = 10;
		int eClassCount = 100;
		for(int i = 0; i < resourceCount; i++) {
			Resource resource = createResource();
			for(int j = 0; j < eClassCount; j++) {
				createNamedElement(null, EcorePackage.Literals.ECLASS, resource);
			}
		}
		Iterable<IEObjectDescription> iterable = container.findAllEObjects(EcorePackage.Literals.EDATA_TYPE);
		assertTrue(Iterables.isEmpty(iterable));
		iterable = container.findAllEObjects(EcorePackage.Literals.ECLASS);
		assertEquals(resourceCount*eClassCount, Iterables.size(iterable));
	}

	private ENamedElement createNamedElement(String name, EClass type, Resource resource) {
		ENamedElement result = (ENamedElement) EcoreUtil.create(type);
		if (name != null)
			result.setName(name);
		else
			result.setName("" + nameCount++);
		if (resource != null)
			resource.getContents().add(result);
		return result;
	}

	private Resource createResource() {
		Resource resource = new EcoreResourceFactoryImpl().createResource(URI.createURI("test://uri" + nameCount++ + ".ecore"));
		resourceSet.getResources().add(resource);
		return resource;
	}

	public EObject apply(IEObjectDescription from) {
		return from.getEObjectOrProxy();
	}

	public Map<String, Object> getContentTypeToFactoryMap() {
		return null;
	}

	public Map<String, Object> getExtensionToFactoryMap() {
		return null;
	}

	public Map<String, Object> getProtocolToFactoryMap() {
		return null;
	}

	public IResourceServiceProvider getResourceServiceProvider(URI uri) {
		return getResourceServiceProvider(uri, ContentHandler.UNSPECIFIED_CONTENT_TYPE);
	}
	
}
