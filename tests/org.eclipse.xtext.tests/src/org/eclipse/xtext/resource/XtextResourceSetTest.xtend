package org.eclipse.xtext.resource

import org.eclipse.emf.common.util.URI
import org.junit.Test
import static org.junit.Assert.*

class XtextResourceSetTest {
	
	@Test
	def void testResourcesAreInMap() {
		val rs = new XtextResourceSet
		
		assertEquals(0, rs.URIResourceMap.size)
		
		val resource = new XtextResource
		resource.URI = URI::createURI('foo')
		
		rs.resources += resource
		
		assertEquals(2, rs.URIResourceMap.size)
		
		rs.resources.remove(resource)
		
		assertEquals(0, rs.URIResourceMap.size)
	}
	
	@Test
	def void testResourcesAreInMap_02() {
		val rs = new XtextResourceSet
		
		assertEquals(0, rs.URIResourceMap.size)
		
		val resource = new XtextResource
		resource.URI = URI::createURI('foo')
		
		rs.resources += newArrayList(resource)
		
		assertEquals(2, rs.URIResourceMap.size)
		
		rs.resources.remove(resource)
		
		assertEquals(0, rs.URIResourceMap.size)
	}
	
	@Test
	def void testResourcesAreInMap_03() {
		val rs = new XtextResourceSet
		
		assertEquals(0, rs.URIResourceMap.size)
		
		val resource = new XtextResource
		
		rs.resources += resource
		assertEquals(1, rs.URIResourceMap.size)
		assertEquals(resource, rs.URIResourceMap.get(null))
		
		// set the URI
		resource.URI = URI::createURI('foo')
		assertEquals(2, rs.URIResourceMap.size)
		assertFalse(rs.URIResourceMap.containsKey(null))
		assertEquals(resource, rs.URIResourceMap.get(resource.URI))
		assertEquals(resource, rs.URIResourceMap.get(rs.URIConverter.normalize(resource.URI)))
		
		// set the URI
		resource.URI = URI::createURI('bar')
		assertEquals(2, rs.URIResourceMap.size)
		assertFalse(rs.URIResourceMap.containsKey(null))
		assertEquals(resource, rs.URIResourceMap.get(resource.URI))
		assertEquals(resource, rs.URIResourceMap.get(rs.URIConverter.normalize(resource.URI)))
		
		// set the URI back to null
		resource.URI = null
		assertEquals(1, rs.URIResourceMap.size)
		assertEquals(resource, rs.URIResourceMap.get(null))
		
		// remove the resource
		rs.resources.remove(resource)
		
		assertEquals(0, rs.URIResourceMap.size)
	}
}