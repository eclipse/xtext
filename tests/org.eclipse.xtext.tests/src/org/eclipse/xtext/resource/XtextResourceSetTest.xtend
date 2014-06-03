package org.eclipse.xtext.resource

import java.io.IOException
import java.util.Map
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceImpl
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.junit.Test

import static org.junit.Assert.*

abstract class AbstractResourceSetTest {
	
	def protected ResourceSetImpl createEmptyResourceSet()
	
	@Test
	def void testDemandLoadedResourcesAreInMap() {
		val rs = createEmptyResourceSet
		val Resource$Factory nullFactory = [ uri | 
			val result = new NullResource
			result.URI = uri
			result
		]
		rs.resourceFactoryRegistry.extensionToFactoryMap.put('xmi', nullFactory)
		assertEquals(0, rs.URIResourceMap.size)
		val uri = URI::createURI('file:/does/not/exist.xmi')
		val demandLoaded = rs.getResource(uri, true)
		assertNotNull(demandLoaded)
		val second = rs.getResource(uri, true)
		assertSame(demandLoaded, second)
		
		assertEquals(1, rs.URIResourceMap.size)
	}
	
}

abstract class AbstractXtextResourceSetTest extends AbstractResourceSetTest {
	
	override protected XtextResourceSet createEmptyResourceSet()
	
	@Test
	def void testResourcesAreInMap() {
		val rs = createEmptyResourceSet
		
		assertEquals(0, rs.URIResourceMap.size)
		
		val resource = new XtextResource
		resource.URI = URI::createURI('foo')
		
		rs.resources += resource
		
		assertEquals(1, rs.URIResourceMap.size)
		
		rs.resources.remove(resource)
		
		assertTrue(resource.eAdapters.empty)
		assertEquals(0, rs.URIResourceMap.size)
	}
	
	@Test
	def void testResourcesAreInMap_02() {
		val rs = createEmptyResourceSet
		
		assertEquals(0, rs.URIResourceMap.size)
		
		val resource = new XtextResource
		resource.URI = URI::createURI('foo')
		
		rs.resources += newArrayList(resource)
		
		assertEquals(1, rs.URIResourceMap.size)
		
		rs.resources.remove(resource)
		
		assertTrue(resource.eAdapters.empty)
		assertEquals(0, rs.URIResourceMap.size)
	}
	
	@Test
	def void testResourcesAreInMap_03() {
		val rs = createEmptyResourceSet
		
		assertEquals(0, rs.URIResourceMap.size)
		
		val resource = new XtextResource
		
		rs.resources += resource
		assertEquals(1, rs.URIResourceMap.size)
		assertEquals(resource, rs.URIResourceMap.get(null))
		
		// set the URI
		resource.URI = URI::createURI('foo')
		assertEquals(1, rs.URIResourceMap.size)
		assertFalse(rs.URIResourceMap.containsKey(null))
		assertEquals(resource, rs.URIResourceMap.get(resource.URI))
		assertEquals(resource, rs.URIResourceMap.get(rs.URIConverter.normalize(resource.URI)))
		
		// set the URI
		resource.URI = URI::createURI('bar')
		assertEquals(1, rs.URIResourceMap.size)
		assertFalse(rs.URIResourceMap.containsKey(null))
		assertEquals(resource, rs.URIResourceMap.get(resource.URI))
		assertEquals(resource, rs.URIResourceMap.get(rs.URIConverter.normalize(resource.URI)))
		
		// set the URI back to null
		resource.URI = null
		assertEquals(1, rs.URIResourceMap.size)
		assertEquals(resource, rs.URIResourceMap.get(null))
		
		// remove the resource
		rs.resources.remove(resource)
		
		assertTrue(resource.eAdapters.empty)
		assertEquals(0, rs.URIResourceMap.size)
	}
	
	@Test
	def void testResourcesAreCleared_01() {
		val rs = createEmptyResourceSet
		
		assertEquals(0, rs.URIResourceMap.size)
		
		val resource = new XtextResource
		resource.URI = URI::createURI('foo')
		
		rs.resources += newArrayList(resource)
		
		assertEquals(1, rs.URIResourceMap.size)
		
		rs.resources.clear
		
		assertTrue(resource.eAdapters.empty)
		assertEquals(0, rs.URIResourceMap.size)
	}
	
	@Test
	def void testResourcesAreClearedWithDeliverFalse_01() {
		val rs = createEmptyResourceSet
		
		assertEquals(0, rs.URIResourceMap.size)
		
		val resource = new XtextResource
		resource.URI = URI::createURI('foo')
		
		rs.resources += newArrayList(resource)
		
		assertEquals(1, rs.URIResourceMap.size)
		rs.eSetDeliver(false)
		rs.resources.clear
		
		assertTrue(resource.eAdapters.empty)
		assertEquals(0, rs.URIResourceMap.size)
	}
	
	@Test
	def void testResourcesAreInMapWithNormalizedURI_01() {
		val rs = createEmptyResourceSet
		
		assertEquals(0, rs.URIResourceMap.size)
		
		val resource = new XtextResource
		resource.URI = URI::createURI('/a/../foo')
		
		rs.resources += resource
		
		assertEquals(2, rs.URIResourceMap.size)
		
		rs.resources.remove(resource)
		
		assertTrue(resource.eAdapters.empty)
		assertEquals(0, rs.URIResourceMap.size)
	}
	
	@Test
	def void testResourcesAreInMapWithNormalizedURI_02() {
		val rs = createEmptyResourceSet
		
		assertEquals(0, rs.URIResourceMap.size)
		
		val resource = new XtextResource
		resource.URI = URI::createURI('/a/../foo')
		
		rs.resources += newArrayList(resource)
		
		assertEquals(2, rs.URIResourceMap.size)
		
		rs.resources.remove(resource)
		
		assertTrue(resource.eAdapters.empty)
		assertEquals(0, rs.URIResourceMap.size)
	}
	
	@Test
	def void testResourcesAreInMapWithNormalizedURI_03() {
		val rs = createEmptyResourceSet
		
		assertEquals(0, rs.URIResourceMap.size)
		
		val resource = new XtextResource
		
		rs.resources += resource
		assertEquals(1, rs.URIResourceMap.size)
		assertEquals(resource, rs.URIResourceMap.get(null))
		
		assertEquals(0, rs.getNormalizationMap.size)
		
		// set the URI
		resource.URI = URI::createURI('/a/../foo')
		assertEquals(2, rs.URIResourceMap.size)
		assertFalse(rs.URIResourceMap.containsKey(null))
		assertEquals(resource, rs.URIResourceMap.get(resource.URI))
		assertEquals(resource, rs.URIResourceMap.get(rs.URIConverter.normalize(resource.URI)))
		
		assertEquals(1, rs.getNormalizationMap.size)
		assertEquals(rs.URIConverter.normalize(resource.URI), rs.getNormalizationMap.get(resource.URI))
		
		// set the URI
		resource.URI = URI::createURI('/a/../bar')
		assertEquals(2, rs.URIResourceMap.size)
		assertFalse(rs.URIResourceMap.containsKey(null))
		assertEquals(resource, rs.URIResourceMap.get(resource.URI))
		assertEquals(resource, rs.URIResourceMap.get(rs.URIConverter.normalize(resource.URI)))
		
		assertEquals(1, rs.getNormalizationMap.size)
		assertEquals(rs.URIConverter.normalize(resource.URI), rs.getNormalizationMap.get(resource.URI))
		
		// set the URI back to null
		resource.URI = null
		assertEquals(1, rs.URIResourceMap.size)
		assertEquals(resource, rs.URIResourceMap.get(null))
		
		assertEquals(0, rs.getNormalizationMap.size)
		
		// remove the resource
		rs.resources.remove(resource)
		
		assertTrue(resource.eAdapters.empty)
		assertEquals(0, rs.URIResourceMap.size)
		
		assertEquals(0, rs.getNormalizationMap.size)
	}
	
	@Test
	def void testResourcesAreClearedWithNormalizedURI_01() {
		val rs = createEmptyResourceSet
		
		assertEquals(0, rs.URIResourceMap.size)
		
		val resource = new XtextResource
		resource.URI = URI::createURI('/a/../foo')
		
		rs.resources += newArrayList(resource)
		
		assertEquals(2, rs.URIResourceMap.size)
		
		rs.resources.clear
		
		assertTrue(resource.eAdapters.empty)
		assertEquals(0, rs.URIResourceMap.size)
	}
	
	@Test
	def void testResourcesAreClearedWithDeliverFalseWithNormalizedURI_01() {
		val rs = createEmptyResourceSet
		
		assertEquals(0, rs.URIResourceMap.size)
		
		val resource = new XtextResource
		resource.URI = URI::createURI('//a/../foo')
		
		rs.resources += newArrayList(resource)
		
		assertEquals(2, rs.URIResourceMap.size)
		rs.eSetDeliver(false)
		rs.resources.clear
		
		assertTrue(resource.eAdapters.empty)
		assertEquals(0, rs.URIResourceMap.size)
	}
}

class NullResource extends ResourceImpl {
	
	override load(Map<? extends Object,? extends Object> options) throws IOException {
		// don't try to load me
	}
	
}

class ResourceSetTest extends AbstractResourceSetTest {
	
	override protected createEmptyResourceSet() {
		return new ResourceSetImpl => [ URIResourceMap = newHashMap ]
	}
	
}

class XtextResourceSetTest extends AbstractXtextResourceSetTest {
	
	override protected createEmptyResourceSet() {
		new XtextResourceSet
	}
	
}

class SynchronizedXtextResourceSetTest extends AbstractXtextResourceSetTest {
	
	override protected createEmptyResourceSet() {
		new SynchronizedXtextResourceSet
	}
	
}