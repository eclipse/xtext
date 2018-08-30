package org.eclipse.xtext.java.resource

import com.google.common.io.CharStreams
import com.google.inject.Inject
import com.google.inject.Provider
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.util.Map
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.resource.impl.ResourceImpl
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.jdt.internal.compiler.batch.CompilationUnit
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.common.types.access.IJavaSchemeUriResolver
import org.eclipse.xtext.common.types.access.TypeResource
import org.eclipse.xtext.common.types.access.impl.AbstractClassMirror
import org.eclipse.xtext.common.types.access.impl.AbstractJvmTypeProvider
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess.UnknownNestedTypeException
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants
import org.eclipse.xtext.parser.IEncodingProvider
import org.eclipse.xtext.resource.IFragmentProvider
import org.eclipse.xtext.resource.IFragmentProvider.Fallback
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
	String contentsAsString 
	
	override protected doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
		val encoding = getEncoding(getURI, options)
		val contentsAsString = CharStreams.toString(new InputStreamReader(inputStream, encoding))
		this.contentsAsString = contentsAsString
		compilationUnit = new CompilationUnit(contentsAsString.toCharArray, URI.lastSegment, encoding, null)
	}
	
	protected def getEncoding(URI uri, Map<?, ?> options) {
		if (options !== null) {
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
	boolean initialized = false
	
	@Accessors(PUBLIC_GETTER)
	boolean initializing = false;
	
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
	
    override protected getUnloadingContents() {
        super.getContents();
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
			this.compilationUnit = null
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
	
	override resolveJavaObjectURIProxy(InternalEObject proxy, EObject sender) {
	    val URI proxyURI = proxy.eProxyURI();
        if (proxyURI !== null && URIHelperConstants.PROTOCOL == proxyURI.scheme()) {
            if ("Objects".equals(proxyURI.segment(0))) {
        		val access = getIndexJvmTypeAccess();
        		if (access !== null) {
        			try {
        			    val frag = new JavaElementFragment(proxy.eProxyURI)
        				var result = access.getIndexedJvmType(frag.typeURI, getResourceSet());
        				if (result instanceof JvmDeclaredType && frag.isMethodFragment) {
        				    result = new JavaFragmentProvider().getEObject(result.eResource, proxy.eProxyURI.fragment, new Fallback() {
                                override getEObject(String fragment) {
                                    return null;
                                }
                                
                                override getFragment(EObject obj) {
                                    return null;
                                }
                            });
        				}
                        if (result !== null)
    					   return result;
        			} catch(UnknownNestedTypeException e) {
        				return proxy;
        			}
        		}
        		return EcoreUtil.resolve(proxy, sender)
            }
        }
        return null;
	}
	
	static class JavaElementFragment {
	    URI uri
	    int idx 
	    
	    new (URI uri) {
	        this.uri = uri
	        idx = getMethodPartOffset(uri.fragment)
	    }
	    
	    /**
	     * @return URI pointing to a type, which is the conatiner type in case of a fragment pointing to a method.
	     */
	    def URI getTypeURI() {
	        if (idx === -1) {
	            return uri 
	        } else {
	            val f = uri.fragment
	            return uri.appendFragment(f.substring(0, idx))
	        }
	    }
	    
	    def boolean isMethodFragment() {
	        return idx !== -1
	    }
	    	    
        protected def int getMethodPartOffset(String string) {
            if (string.endsWith("()")) {
                return string.lastIndexOf('.')
            }
            return -1
        }
	}
    
	
	static class JavaFragmentProvider extends AbstractClassMirror {
	    
        override protected getTypeName() {
            throw new UnsupportedOperationException("not supported")
        }
        
        override protected getTypeName(JvmType type) {
            return type.getQualifiedName("$")
        }
        
        override initialize(TypeResource typeResource) {
            throw new UnsupportedOperationException("not supported")
        }
        
        override isSealed() {
            return true
        }
	    
	}
	
	IndexedJvmTypeAccess _access
	def IndexedJvmTypeAccess getIndexJvmTypeAccess() {
		if (_access === null) {
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
	
	val fallback = new IFragmentProvider.Fallback() {
		
		override getEObject(String fragment) {
			JavaResource.super.getEObjectByID(fragment)
		}
		
		override getFragment(EObject obj) {
			JavaResource.super.getURIFragment(obj)
		}
		
	}
	
	val m = new AbstractClassMirror() {
		
		override protected getTypeName() {
			throw new UnsupportedOperationException("TODO: auto-generated method stub")
		}
		
		override protected getTypeName(JvmType type) {
			type.identifier
		}
		
		override initialize(TypeResource typeResource) {
			throw new UnsupportedOperationException("TODO: auto-generated method stub")
		}
		
		override isSealed() {
			throw new UnsupportedOperationException("TODO: auto-generated method stub")
		}
	}
	
	override protected getEObjectByID(String id) {
		m.getEObject(this, id, fallback)
	}
	
	override getURIFragment(EObject eObject) {
		m.getFragment(eObject, fallback)
	}
    
    def getOriginalSource() {
        return contentsAsString;
    }
	
}