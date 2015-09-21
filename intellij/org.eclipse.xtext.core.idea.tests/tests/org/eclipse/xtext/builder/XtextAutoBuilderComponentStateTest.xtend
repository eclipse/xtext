package org.eclipse.xtext.builder

import com.google.inject.Inject
import org.eclipse.xtext.build.Source2GeneratedMapping
import org.eclipse.xtext.idea.build.XtextAutoBuilderComponentState.Codec
import org.eclipse.xtext.index.IndexTestLanguageInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData
import org.eclipse.xtext.resource.impl.ResourceServiceProviderRegistryImpl
import org.junit.Test
import org.junit.runner.RunWith

import static extension org.eclipse.emf.common.util.URI.*
import static extension org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(IndexTestLanguageInjectorProvider)
class XtextAutoBuilderComponentStateTest {

	val extension Codec = new Codec

	@Inject extension ParseHelper<?>
	
	@Inject extension IResourceDescription.Manager 
	
	@Test
	def void testSource2GeneratedMap() {
		val s2g0 = new Source2GeneratedMapping
		s2g0.addSource2Generated('foo'.createURI, 'foo_'.createURI)
		s2g0.addSource2Generated('foo'.createURI, 'baz_'.createURI)
		s2g0.addSource2Generated('bar'.createURI, 'bar_'.createURI)
		s2g0.addSource2Generated('bar'.createURI, 'baz_'.createURI)
		val s2g1 = new Source2GeneratedMapping
		s2g1.addSource2Generated('foobar'.createURI, 'foobar_'.createURI)
		s2g1.addSource2Generated('foobar'.createURI, 'foobar2_'.createURI)
		val map = #{'module0' -> s2g0, 'module1' -> s2g1}

		val state = encode(new ResourceServiceProviderRegistryImpl(), new ChunkedResourceDescriptions, map)
		val decodedState = decodeModuleToGenerated(state)

		assertEquals(2, decodedState.keySet.size)
		val _s2g0 = decodedState.get('module0')
		_s2g0.assertNotNull
		#{'foo_'.createURI, 'bar_'.createURI, 'baz_'.createURI}.assertEquals(_s2g0.allGenerated.toSet)
		#{'foo_'.createURI, 'baz_'.createURI}.assertEquals(_s2g0.getGenerated('foo'.createURI).toSet)
		#{'bar_'.createURI, 'baz_'.createURI}.assertEquals(_s2g0.getGenerated('bar'.createURI).toSet)

		#{'foo'.createURI}.assertEquals(_s2g0.getSource('foo_'.createURI).toSet)
		#{'bar'.createURI}.assertEquals(_s2g0.getSource('bar_'.createURI).toSet)
		#{'foo'.createURI, 'bar'.createURI}.assertEquals(_s2g0.getSource('baz_'.createURI).toSet)

		val _s2g1 = decodedState.get('module1')
		_s2g1.assertNotNull
		#{'foobar_'.createURI, 'foobar2_'.createURI}.assertEquals(_s2g1.allGenerated.toSet)
		#{'foobar_'.createURI, 'foobar2_'.createURI}.assertEquals(_s2g1.getGenerated('foobar'.createURI).toSet)
		#{'foobar'.createURI}.assertEquals(_s2g1.getSource('foobar_'.createURI).toSet)
		#{'foobar'.createURI}.assertEquals(_s2g1.getSource('foobar2_'.createURI).toSet)
	}

	@Test
	def testIndex() {
		val map = <String, ResourceDescriptionsData>newHashMap
		for(j:0..1) {
			val rs = new XtextResourceSet
			val descriptions = newArrayList
			for(i:0..1) {
				val r = '''
					entity Foo1{}
				'''.parse(('Foo' + i + '.indextestlanguage').createURI, rs).eResource
				descriptions += r.resourceDescription
			}
			map.put('module'+j, new ResourceDescriptionsData(descriptions))
		}
		val index = new ChunkedResourceDescriptions(map)
		val state = encode(new ResourceServiceProviderRegistryImpl(), index, emptyMap)
		val _index = decodeIndex(state)
		assertEquals(index.allResourceDescriptions.size, _index.allResourceDescriptions.size)
		for(desc: index.allResourceDescriptions) {
			assertFalse(desc.createDelta(_index.getResourceDescription(desc.URI)).haveEObjectDescriptionsChanged)
		}
		val _module0 = _index.getContainer('module1').allResourceDescriptions
		#{'Foo0.indextestlanguage', 'Foo1.indextestlanguage'}.assertEquals(_module0.map[URI.lastSegment.toString].toSet)
		val _module1 = _index.getContainer('module1').allResourceDescriptions
		#{'Foo0.indextestlanguage', 'Foo1.indextestlanguage'}.assertEquals(_module1.map[URI.lastSegment.toString].toSet)
	}

}