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
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.resource.impl.ResourceImpl
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.jdt.internal.compiler.batch.CompilationUnit
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.access.IJavaSchemeUriResolver
import org.eclipse.xtext.common.types.access.impl.AbstractJvmTypeProvider
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess.UnknownNestedTypeException
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants
import org.eclipse.xtext.parser.IEncodingProvider
import org.eclipse.xtext.resource.ISynchronizable
import org.eclipse.xtext.util.concurrent.IUnitOfWork

class JavaResource extends ResourceImpl implements IJavaSchemeUriResolver, ISynchronizable<JavaResource> {
	
	public static final String OPTION_ENCODING = JavaResource.name + ".DEFAULT_ENCODING"
	
	static class Factory implements Resource.Factory {
		
		@Inject Provider<JavaResource> resourceProvider
		
		override createResource(URI uri) {
			resourceProvider.get => [
				URI = uri
			]
		}
	}
	
	@Inject IEncodingProvider encodingProvider
	@Inject JavaDerivedStateComputer derivedStateComputer
	
	CompilationUnit compilationUnit
	
	override protected doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
		val encoding = getEncoding(getURI, options)
		val contentsAsString = CharStreams.toString(new InputStreamReader(inputStream, encoding))
		compilationUnit = new CompilationUnit(contentsAsString.toCharArray, URI.lastSegment, encoding)
	}
	
	protected def getEncoding(URI uri, Map<?, ?> options) {
		if (options != null) {
			val encodingOption = options.get(OPTION_ENCODING);
			if (encodingOption instanceof String) {
				return encodingOption;
			}
		}
		return encodingProvider.getEncoding(uri)
	}
	
	protected def getCompilationUnit() {
		return compilationUnit
	}
	
	@Accessors(PUBLIC_GETTER)
	private boolean initialized = false
	
	@Accessors(PUBLIC_GETTER)
	private boolean initializing = false;
	
	override getContents() {
		synchronized (getLock()) {
			if (isLoaded && !isLoading && !initializing && !initialized ) {
				try {
					eSetDeliver(false)
					installFull
				} finally {
					eSetDeliver(true)
				}
			}
			super.getContents()
		}
	}
	
	def installStubs() {
		initializing[
			derivedStateComputer.installStubs(this)
			initialized = true
		]
	}
	
	def installFull() {
		initializing[
			derivedStateComputer.installFull(this)
			initialized = true
		]
	}
	
	private def initializing(() => void init) {
		try {
			initializing = true
			init.apply
		} finally {
			initializing = false
		}
	}
	
	def discardDerivedState() {
		initializing[
			derivedStateComputer.discardDerivedState(this)
			initialized = false
		]
	}
	
	override resolveJavaObjectURIProxy(InternalEObject proxy, JvmTypeReference sender) {
		val access = getIndexJvmTypeAccess();
		if (access != null) {
			try {
				val result = access.getIndexedJvmType(proxy.eProxyURI(), getResourceSet());
				if (result != null) {
					return result;
				}
			} catch(UnknownNestedTypeException e) {
				return proxy;
			}
		}
		return EcoreUtil.resolve(proxy, sender)
	}
	
	IndexedJvmTypeAccess _access
	def IndexedJvmTypeAccess getIndexJvmTypeAccess() {
		if (_access == null) {
			val provider = resourceSet.getResourceFactoryRegistry().getProtocolToFactoryMap().get(URIHelperConstants.PROTOCOL)
			if (provider instanceof AbstractJvmTypeProvider) {
				_access = provider.indexedJvmTypeAccess
			}
		}
		return _access
	}
	
	
	/** 
	 * Returns the lock of the owning {@link ResourceSet}, if it exposes such a lock.
	 * Otherwise this resource itself is used as the lock context.
	 */
	override Object getLock() {
		var resourceSet = getResourceSet() 
		if (resourceSet instanceof ISynchronizable<?>) {
			return (resourceSet as ISynchronizable<?>).getLock() 
		}
		return this 
	}
	
	override <Result>Result execute(/* @NonNull */IUnitOfWork<Result, ? super JavaResource> unit) throws Exception {
		synchronized (getLock()) {
			return unit.exec(this) 
		}
	}
	
}