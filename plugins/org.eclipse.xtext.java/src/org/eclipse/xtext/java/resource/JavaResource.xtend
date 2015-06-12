package org.eclipse.xtext.java.resource

import com.google.common.io.CharStreams
import com.google.inject.Inject
import com.google.inject.Provider
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.util.Map
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceImpl
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.jdt.internal.compiler.batch.CompilationUnit
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.access.IJavaSchemeUriResolver
import org.eclipse.xtext.common.types.access.impl.AbstractJvmTypeProvider
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants
import org.eclipse.xtext.parser.IEncodingProvider
import org.eclipse.xtext.resource.CompilerPhases

class JavaResource extends ResourceImpl implements IJavaSchemeUriResolver {
	
	static class Factory implements Resource.Factory {
		
		@Inject Provider<JavaResource> resourceProvider
		
		override createResource(URI uri) {
			resourceProvider.get => [
				URI = uri
			]
		}
	}
	
	@Inject IEncodingProvider encodingProvider
	@Inject CompilerPhases compilerPhases
	@Inject JavaDerivedStateComputer derivedStateComputer
	
	CompilationUnit compilationUnit
	
	override protected doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
		// add a dummy eobject as root
		val encoding = encodingProvider.getEncoding(getURI)
		val contentsAsString = CharStreams.toString(new InputStreamReader(inputStream, encoding))
		compilationUnit = new CompilationUnit(contentsAsString.toCharArray, URI.lastSegment, encoding)
	}
	
	protected def getCompilationUnit() {
		return compilationUnit
	}
	
	private boolean isInitialized = false
	private boolean isFullyInitialized = false
	
	private boolean isInitializing = false;
	
	override getContents() {
		if (isInitializing)
			return super.getContents();
		try {
			isInitializing = true
			// already in the correct state
			val isIndexing = compilerPhases.isIndexing(this)
			if (!isIndexing && !isFullyInitialized) {
				derivedStateComputer.discardDerivedState(this);
				derivedStateComputer.installFull(this);
				isFullyInitialized = true
				isInitialized = true
			} else if (isIndexing && !isInitialized) {
				derivedStateComputer.installStubs(this)
				isFullyInitialized = false
				isInitialized = true
			}
		} finally {
			isInitializing = false;
		}
		return super.getContents();
	}
	
	override resolveJavaObjectURIProxy(InternalEObject proxy, JvmTypeReference sender) {
		val access = getIndexJvmTypeAccess();
		if (access != null) {
			val result = access.getIndexedJvmType(proxy.eProxyURI(), getResourceSet());
			if (result != null) {
				return result;
			}
		}
		return EcoreUtil.resolve(proxy, sender)
	}
	
	IndexedJvmTypeAccess _access
	def IndexedJvmTypeAccess getIndexJvmTypeAccess() {
		if (_access == null) {
			val provider = resourceSet.getResourceFactoryRegistry().getProtocolToFactoryMap().get(URIHelperConstants.PROTOCOL)
			val field = AbstractJvmTypeProvider.getDeclaredField('indexedJvmTypeAccess') => [accessible=true]
			_access = field.get(provider) as IndexedJvmTypeAccess 
		}
		return _access
	}
	
}