/**
 * Copyright (c) 2013, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource.uriHell;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xml.namespace.XMLNamespacePackage;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.testing.GlobalRegistries;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Base test case for different places in the workspace where ecore resources
 * may have been put.
 * 
 * The concrete test cases basically illustrate which patterns are bogus and
 * which work nicely in a dev environment and a deployed scenario.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(URIHandlerTestInjectorProvider.class)
public abstract class AbstractURIHandlerTest extends Assert {
	public abstract URI getResourceURI();

	public abstract URI getPackagedResourceURI();

	public abstract URI getReferencedURI();

	public abstract URI getPackagedReferencedURI();

	@Inject
	protected Provider<XtextResourceSet> resourceSetProvider;

	@Inject
	protected ClassLoader classLoader;

	protected XtextResourceSet resourceSet;

	protected Resource primaryResource;

	protected Resource referencedResource;

	private GlobalRegistries.GlobalStateMemento globalState;

	@Before
	public void setUp() {
		globalState = GlobalRegistries.makeCopyOfGlobalState();
		EPackage.Registry.INSTANCE.put(XMLTypePackage.eNS_URI, XMLTypePackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(XMLNamespacePackage.eNS_URI, XMLNamespacePackage.eINSTANCE);
		resourceSet = getNewResourceSet();
		primaryResource = resourceSet.createResource(getResourceURI());
		referencedResource = resourceSet.createResource(getReferencedURI());
	}

	@After
	public void tearDown() {
		globalState.restoreGlobalState();
	}

	public XtextResourceSet getNewResourceSet() {
		XtextResourceSet result = resourceSetProvider.get();
		result.setClasspathURIContext(classLoader);
		return result;
	}

	protected byte[] getBytes(Resource resource) throws Exception {
		ByteArrayOutputStream out = new ByteArrayOutputStream(1024);
		resource.save(out, null);
		byte[] bytes = out.toByteArray();
		return bytes;
	}

	protected void load(Resource resource, byte[] bytes) throws Exception {
		ByteArrayInputStream in = new ByteArrayInputStream(bytes);
		resource.load(in, resource.getResourceSet().getLoadOptions());
	}

	public void doTest(URI usedPrimaryURI, URI initialReferencedURI, URI usedReferencedURI) throws Exception {
		referencedResource.setURI(initialReferencedURI);
		byte[] primaryBytes = getBytes(primaryResource);
		byte[] referencedBytes = getBytes(referencedResource);
		XtextResourceSet otherResourceSet = getNewResourceSet();
		Resource newPrimaryResource = otherResourceSet.createResource(usedPrimaryURI);
		load(newPrimaryResource, primaryBytes);
		Resource newReferencedResource = otherResourceSet.createResource(usedReferencedURI);
		load(newReferencedResource, referencedBytes);
		EcoreUtil.resolveAll(otherResourceSet);
		if (otherResourceSet.getResources().size() != 2) {
			throw new UnexpectedResourcesException(otherResourceSet);
		}
		Map<EObject, Collection<EStructuralFeature.Setting>> unresolved = EcoreUtil.UnresolvedProxyCrossReferencer
				.find(otherResourceSet);
		if (!unresolved.isEmpty()) {
			throw new UnexpectedProxiesException(unresolved);
		}
	}

	@Test
	public void testLoadResourceWithPrimaryURIs() throws Exception {
		doTest(getResourceURI(), getReferencedURI(), getReferencedURI());
	}

	@Test
	public void testLoadResourceWithPackagedURIs() throws Exception {
		doTest(getPackagedResourceURI(), getReferencedURI(), getPackagedReferencedURI());
	}
}
