package org.eclipse.xtext.java.tests

import com.google.inject.Inject
import com.google.inject.Provider
import java.util.List
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
	
	@Test(timeout=30000)
	def void testPerformance() {
		val max = 10000
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
		val start = System.currentTimeMillis
		for (r : rs.resources) {
			r.contents
		}
		val end = System.currentTimeMillis
		println(end-start)
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
        val List<IResourceDescription> descriptions = newArrayList()
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