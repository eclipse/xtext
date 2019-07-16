package org.eclipse.xtext.java.tests

import com.google.common.base.Stopwatch
import com.google.inject.Inject
import com.google.inject.Provider
import java.util.concurrent.TimeUnit
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.common.types.access.IJvmTypeProvider
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.InMemoryURIHandler
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(XtextRunner)
@InjectWith(JavaInjectorProvider)
class JavaSourceLanguagePerformanceTest {
	
	@Inject Provider<XtextResourceSet> resourceSetProvider
	@Inject IResourceDescription.Manager resourceDesriptionManager
	@Inject IJvmTypeProvider.Factory typeProviderFactory
	
	def void doTestPerformance(int max) {
		val rs = (1..max).map["demo/Demo"+it+".java"->'''package demo; public class Demo«it» {
			private String x;
			«IF it > 1»
			private Demo«it-1» demo;
			«ENDIF»
			«IF it > 2»
			private Demo«it-2» demo;
			«ENDIF»
			«IF it < max-1»
			private Demo«it+1» demo;
			«ENDIF»
		}'''].toList.resourceSet
		val sw = Stopwatch.createStarted
		for (r : rs.resources) {
			r.contents
		}
		println('''«max» file took «sw.elapsed(TimeUnit.MILLISECONDS)» ms''')
	}
	
	@Test(timeout=30000)
	def void testPerf00100() {
		doTestPerformance(100)
	}
	
	@Test(timeout=30000)
	def void testPerf00200() {
		doTestPerformance(200)
	}
	
	@Test(timeout=30000)
	def void testPerf00400() {
		doTestPerformance(400)
	}
	
	@Test(timeout=30000)
	def void testPerf00800() {
		doTestPerformance(800)
	}
	
	@Test(timeout=30000)
	def void testPerf01600() {
		doTestPerformance(1600)
	}
	
	@Test(timeout=30000)
	def void testPerf03200() {
		doTestPerformance(3200)
	}
	
	@Test(timeout=30000)
	def void testPerf06400() {
		doTestPerformance(6400)
	}
	
	@Test(timeout=30000)
	def void testPerf12800() {
		doTestPerformance(12800)
	}
	
	@Test(timeout=30000)
	def void testPerf25600() {
		doTestPerformance(25600)
	}
	
	@Test(timeout=60000)
	def void testPerf51200() {
		doTestPerformance(51200)
	}
	
	def protected resourceSet(Pair<String, String> ... files) {
        val result = resourceSetProvider.get
        typeProviderFactory.createTypeProvider(result)
        result.classpathURIContext = class.classLoader
        result.URIConverter.URIHandlers.clear
        val uriHandler = new InMemoryURIHandler
        val uris = files.map [
            val uri = URI.createURI(InMemoryURIHandler.SCHEME + ":/" + key)
            val out = uriHandler.createOutputStream(uri, emptyMap)
            out.write(value.bytes)
            out.close
            return uri
        ]
        result.URIConverter.URIHandlers.add(uriHandler)
        val descriptions = newArrayList()
        for (uri : uris) {
            val resource = result.getResource(uri, true)
            descriptions += resourceDesriptionManager.getResourceDescription(resource);
        }
        val chunkedResourceDescriptions = new ChunkedResourceDescriptions(#{
            'default' -> new ResourceDescriptionsData(descriptions)
        })
        (chunkedResourceDescriptions).attachToEmfObject(result)
        return result
    }
	
}