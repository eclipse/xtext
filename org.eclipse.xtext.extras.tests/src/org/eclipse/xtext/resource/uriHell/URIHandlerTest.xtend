/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource.uriHell

import com.google.inject.Inject
import com.google.inject.Provider
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.util.Collection
import java.util.List
import java.util.Map
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.EcoreFactory
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.After
import org.eclipse.xtext.testing.GlobalRegistries
import org.eclipse.xtext.testing.GlobalRegistries.GlobalStateMemento
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.xml.type.XMLTypePackage
import org.eclipse.emf.ecore.xml.namespace.XMLNamespacePackage

/**
 * Base test case for different places in the workspace where
 * ecore resources may have been put.
 * 
 * The concrete test cases basically illustrate which patterns are bogus
 * and which work nicely in a dev environment and a deployed scenario.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(URIHandlerTestInjectorProvider)
abstract class AbstractURIHandlerTest extends Assert {

	abstract def URI getResourceURI()
	abstract def URI getPackagedResourceURI()
	abstract def URI getReferencedURI()
	abstract def URI getPackagedReferencedURI()
	
	@Inject
	protected Provider<XtextResourceSet> resourceSetProvider
	
	@Inject
	protected ClassLoader classLoader

	protected XtextResourceSet resourceSet
	protected Resource primaryResource
	protected Resource referencedResource
	
	GlobalStateMemento globalState;

	@Before
	def void setUp() {
		globalState = GlobalRegistries.makeCopyOfGlobalState
		EPackage.Registry.INSTANCE.put(XMLTypePackage.eNS_URI, XMLTypePackage.eINSTANCE)
		EPackage.Registry.INSTANCE.put(XMLNamespacePackage.eNS_URI, XMLNamespacePackage.eINSTANCE)
		resourceSet = getNewResourceSet
		primaryResource = resourceSet.createResource(getResourceURI)
		referencedResource = resourceSet.createResource(getReferencedURI)
	}
	
	
	@After
	def void tearDown() {
		globalState.restoreGlobalState
	}

	def getNewResourceSet() {
		val result = resourceSetProvider.get
		result.setClasspathURIContext(classLoader)
		result
	}
	
	protected def getBytes(Resource resource) {
		val out = new ByteArrayOutputStream(1024)
		resource.save(out, null)
		val bytes = out.toByteArray
		bytes
	}
	
	protected def load(Resource resource, byte[] bytes) {
		val in = new ByteArrayInputStream(bytes)
		resource.load(in, resource.resourceSet.loadOptions)
	}

	def void doTest(URI usedPrimaryURI, URI initialReferencedURI, URI usedReferencedURI) {
		referencedResource.URI = initialReferencedURI
		val primaryBytes = primaryResource.bytes
		val referencedBytes = referencedResource.bytes
		
		val otherResourceSet = getNewResourceSet 
		
		val newPrimaryResource = otherResourceSet.createResource(usedPrimaryURI)
		newPrimaryResource.load(primaryBytes)
		val newReferencedResource = otherResourceSet.createResource(usedReferencedURI)
		newReferencedResource.load(referencedBytes)
		
		EcoreUtil.resolveAll(otherResourceSet)
		if (otherResourceSet.resources.size != 2) {
			throw new UnexpectedResourcesException(otherResourceSet)
		}
		val unresolved = EcoreUtil.UnresolvedProxyCrossReferencer.find(otherResourceSet)
		if (!unresolved.isEmpty)
			throw new UnexpectedProxiesException(unresolved)
	}

	@Test
	def void testLoadResourceWithPrimaryURIs() {
		doTest(getResourceURI, getReferencedURI, getReferencedURI)
	}
	
	@Test
	def void testLoadResourceWithPackagedURIs() {
		doTest(getPackagedResourceURI, getReferencedURI, getPackagedReferencedURI)
	}
	
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class UnexpectedResourcesException extends RuntimeException {
	new(ResourceSet resourceSet) {
		super(resourceSet.resources.map [ it.URI.toString ].toString)
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class UnexpectedProxiesException extends RuntimeException {
	new(Map<EObject, Collection<EStructuralFeature.Setting>> unresolved) {
		super(unresolved.values.flatten.map [ it.getURIs ].flatten.toSet.toString)
	}
	
	def static getURIs(EStructuralFeature.Setting setting) {
		switch it: setting.get(false) {
			EObject:
				newImmutableList(EcoreUtil.getURI(it))
			List<EObject>:
				map [ EcoreUtil.getURI(it) ]
		}
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
abstract class AbstractURIHandlerWithEcoreTest extends AbstractURIHandlerTest {

	override setUp() {
		super.setUp()
		val factory = EcoreFactory.eINSTANCE
		val baseClass = factory.createEClass
		baseClass.name = 'Base'
		primaryResource.contents += baseClass
		val superClass = factory.createEClass
		superClass.name = 'SuperClass'
		referencedResource.contents += superClass
		baseClass.getESuperTypes += superClass
	}
	
}

