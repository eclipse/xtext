/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.containers;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.scoping.impl.DefaultGlobalScopeProvider;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.util.StringInputStream;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner.class)
public abstract class AbstractLiveContainerTest {

	@Inject
	private IContainer.Manager containerManager;

	@Inject
	private IResourceDescription.Manager descriptionManager;

	@Inject
	private ResourceDescriptionsProvider descriptionsProvider;

	@Inject
	private ParseHelper<EObject> parser;

	@Inject
	private DefaultGlobalScopeProvider scopeProvider;

	@Inject
	private IGrammarAccess grammarAccess;

	// we need a normalized URI
	protected URI computeUnusedUri(ResourceSet resourceSet) {
		String name = "__synthetic";
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			URI syntheticUri = URI.createURI(name + i + "." + parser.fileExtension);
			syntheticUri = resourceSet.getURIConverter().normalize(syntheticUri);
			if (resourceSet.getResource(syntheticUri, false) == null)
				return syntheticUri;
		}
		throw new IllegalStateException();
	}

	public EObject parse(CharSequence text, ResourceSet resourceSetToUse) throws Exception {
		return parser.parse(text, computeUnusedUri(resourceSetToUse), resourceSetToUse);
	}

	private String format(Iterable<IEObjectDescription> descs) {
		List<String> items = Lists.newArrayList();
		for (IEObjectDescription desc : descs)
			items.add(desc.getName().toString());
		Collections.sort(items);
		return Joiner.on(", ").join(items);
	}

	protected abstract EClass getModelRootType();

	private EReference createRefToRoot() {
		EReference ref = EcoreFactory.eINSTANCE.createEReference();
		EcoreFactory.eINSTANCE.createEClass().getEStructuralFeatures().add(ref);
		ref.setEType(getModelRootType());
		return ref;
	}

	@Test
	public void testContainerAddRemove() throws Exception {
		ResourceSet resourceSet = new XtextResourceSet();
		Resource res = parse("local", resourceSet).eResource();
		parse("other", resourceSet);
		IResourceDescription resourceDescription = descriptionManager.getResourceDescription(res);
		IResourceDescriptions resourceDescriptions = descriptionsProvider.getResourceDescriptions(res);
		List<IContainer> containers = containerManager.getVisibleContainers(resourceDescription, resourceDescriptions);
		assertEquals(1, containers.size());
		IContainer container = containers.get(0);

		assertEquals("local, other", format(container.getExportedObjects()));

		Resource foo = parse("foo", resourceSet).eResource();
		assertEquals("foo, local, other", format(container.getExportedObjects()));

		resourceSet.getResources().remove(foo);
		assertEquals("local, other", format(container.getExportedObjects()));
	}

	@Test
	public void testContainerLoadUnload() throws Exception {
		ResourceSet resourceSet = new XtextResourceSet();
		Resource res = parse("local", resourceSet).eResource();
		Resource foo = resourceSet.createResource(computeUnusedUri(resourceSet));
		IResourceDescription resourceDescription = descriptionManager.getResourceDescription(res);
		IResourceDescriptions resourceDescriptions = descriptionsProvider.getResourceDescriptions(res);
		List<IContainer> containers = containerManager.getVisibleContainers(resourceDescription, resourceDescriptions);
		assertEquals(1, containers.size());
		IContainer container = containers.get(0);

		//		assertEquals("local", format(container.getExportedObjects()));

		foo.load(new StringInputStream("foo"), null);
		assertEquals("foo, local", format(container.getExportedObjects()));

		//		foo.unload();
		//		assertEquals("local", format(container.getExportedObjects()));
	}

	@Test
	public void testGlobalScope() throws Exception {
		EReference ref = createRefToRoot();

		ResourceSet resourceSet = new XtextResourceSet();
		Resource res = parse("local", resourceSet).eResource();
		parse("other", resourceSet);
		assertEquals("other", format(scopeProvider.getScope(res, ref).getAllElements()));

		Resource foo = parse("foo", resourceSet).eResource();
		assertEquals("foo, other", format(scopeProvider.getScope(res, ref).getAllElements()));

		resourceSet.getResources().remove(foo);
		assertEquals("other", format(scopeProvider.getScope(res, ref).getAllElements()));
	}

	@Test
	// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=382555
	public void testNonNormalizedURIs() throws Exception {
		ResourceSet resourceSet = new XtextResourceSet();
		parser.parse("B", URI.createURI("a." + parser.fileExtension), resourceSet);
		parser.parse("B", URI.createURI("b." + parser.fileExtension), resourceSet);
		IResourceDescriptions index = descriptionsProvider.getResourceDescriptions(resourceSet);
		IResourceDescription rd = index.getResourceDescription(URI.createURI("a." + parser.fileExtension));
		List<IContainer> containers = containerManager.getVisibleContainers(rd, index);
		List<IEObjectDescription> objects = Lists.newArrayList();
		EClass type = (EClass) grammarAccess.getGrammar().getRules().get(0).getType().getClassifier();
		for (IContainer container : containers)
			Iterables.addAll(objects, container.getExportedObjects(type, QualifiedName.create("B"), false));
		assertEquals(2, objects.size());
	}

}
