/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.java.resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.internal.compiler.batch.CompilationUnit;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.access.IJavaSchemeUriResolver;
import org.eclipse.xtext.common.types.access.TypeResource;
import org.eclipse.xtext.common.types.access.impl.AbstractClassMirror;
import org.eclipse.xtext.common.types.access.impl.AbstractJvmTypeProvider;
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess;
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.IFragmentProvider;
import org.eclipse.xtext.resource.ISynchronizable;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;

import com.google.common.io.CharStreams;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class JavaResource extends ResourceImpl implements IJavaSchemeUriResolver, ISynchronizable<JavaResource> {
	public static class Factory implements Resource.Factory {
		@Inject
		private Provider<JavaResource> resourceProvider;

		@Override
		public Resource createResource(URI uri) {
			JavaResource resource = resourceProvider.get();
			resource.setURI(uri);
			return resource;
		}
	}

	public static class JavaElementFragment {
		private URI uri;

		private int idx;

		public JavaElementFragment(URI uri) {
			this.uri = uri;
			this.idx = getMethodPartOffset(uri.fragment());
		}

		/**
		 * @return URI pointing to a type, which is the conatiner type in case of a fragment pointing to a method.
		 */
		public URI getTypeURI() {
			if (idx == -1) {
				return uri;
			} else {
				String f = uri.fragment();
				return uri.appendFragment(f.substring(0, idx));
			}
		}

		public boolean isMethodFragment() {
			return idx != -1;
		}

		protected int getMethodPartOffset(String string) {
			if (string.endsWith("()")) {
				return string.lastIndexOf('.');
			}
			return -1;
		}
	}

	public static class JavaFragmentProvider extends AbstractClassMirror {
		@Override
		protected String getTypeName() {
			throw new UnsupportedOperationException("not supported");
		}

		@Override
		protected String getTypeName(JvmType type) {
			return type.getQualifiedName('$');
		}

		@Override
		public void initialize(TypeResource typeResource) {
			throw new UnsupportedOperationException("not supported");
		}

		@Override
		public boolean isSealed() {
			return true;
		}
	}

	public static final String OPTION_ENCODING = JavaResource.class.getName() + ".DEFAULT_ENCODING";

	@Inject
	private IEncodingProvider encodingProvider;

	@Inject
	private JavaDerivedStateComputer derivedStateComputer;

	private CompilationUnit compilationUnit;

	private String contentsAsString;

	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
		String encoding = getEncoding(getURI(), options);
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream, encoding);
		contentsAsString = CharStreams.toString(inputStreamReader);
		compilationUnit = new CompilationUnit(contentsAsString.toCharArray(), getURI().lastSegment(), encoding, null);
	}

	protected String getEncoding(URI uri, Map<?, ?> options) {
		if (options != null) {
			Object encodingOption = options.get(JavaResource.OPTION_ENCODING);
			if (encodingOption instanceof String) {
				return ((String) encodingOption);
			}
		}
		return encodingProvider.getEncoding(uri);
	}

	protected CompilationUnit getCompilationUnit() {
		return compilationUnit;
	}

	private boolean initialized = false;

	private boolean initializing = false;

	@Override
	public EList<EObject> getContents() {
		synchronized (getLock()) {
			if (isLoaded && !isLoading && !initializing && !initialized) {
				try {
					eSetDeliver(false);
					installFull();
				} finally {
					eSetDeliver(true);
				}
			}
			return super.getContents();
		}
	}

	@Override
	protected List<EObject> getUnloadingContents() {
		return super.getContents();
	}

	public void installStubs() {
		initializing(() -> {
			derivedStateComputer.installStubs(this);
			initialized = true;
		});
	}

	public void installFull() {
		initializing(() -> {
			derivedStateComputer.installFull(this);
			compilationUnit = null;
			initialized = true;
		});
	}

	private void initializing(Procedure0 init) {
		try {
			initializing = true;
			init.apply();
		} finally {
			initializing = false;
		}
	}

	public void discardDerivedState() {
		initializing(() -> {
			derivedStateComputer.discardDerivedState(this);
			initialized = false;
		});
	}

	@Override
	public EObject resolveJavaObjectURIProxy(InternalEObject proxy, EObject sender) {
		URI proxyURI = proxy.eProxyURI();
		if (proxyURI != null && URIHelperConstants.PROTOCOL.equals(proxyURI.scheme())) {
			if ("Objects".equals(proxyURI.segment(0))) {
				IndexedJvmTypeAccess access = getIndexJvmTypeAccess();
				if (access != null) {
					try {
						final JavaResource.JavaElementFragment frag = new JavaResource.JavaElementFragment(
								proxy.eProxyURI());
						EObject result = access.getIndexedJvmType(frag.getTypeURI(), this.getResourceSet());
						if (result instanceof JvmDeclaredType && frag.isMethodFragment()) {
							JavaResource.JavaFragmentProvider javaFragmentProvider = new JavaResource.JavaFragmentProvider();
							Resource res = result.eResource();
							result = javaFragmentProvider.getEObject(res, proxy.eProxyURI().fragment(),
									new IFragmentProvider.Fallback() {
										@Override
										public EObject getEObject(String fragment) {
											return null;
										}

										@Override
										public String getFragment(EObject obj) {
											return null;
										}
									});
						}
						if (result != null) {
							return result;
						}
					} catch (Throwable t) {
						if (t instanceof IndexedJvmTypeAccess.UnknownNestedTypeException) {
							return proxy;
						}
						throw Exceptions.sneakyThrow(t);
					}
				}
				return EcoreUtil.resolve(proxy, sender);
			}
		}
		return null;
	}

	private IndexedJvmTypeAccess indexedJvmTypeAccess;

	public IndexedJvmTypeAccess getIndexJvmTypeAccess() {
		if (indexedJvmTypeAccess == null) {
			Object provider = resourceSet.getResourceFactoryRegistry().getProtocolToFactoryMap()
					.get(URIHelperConstants.PROTOCOL);
			if (provider instanceof AbstractJvmTypeProvider) {
				indexedJvmTypeAccess = ((AbstractJvmTypeProvider) provider).getIndexedJvmTypeAccess();
			}
		}
		return indexedJvmTypeAccess;
	}

	/**
	 * Returns the lock of the owning {@link ResourceSet}, if it exposes such a lock. Otherwise this resource itself is
	 * used as the lock context.
	 */
	@Override
	public Object getLock() {
		ResourceSet resourceSet = getResourceSet();
		if (resourceSet instanceof ISynchronizable<?>) {
			return ((ISynchronizable<?>) resourceSet).getLock();
		}
		return this;
	}

	@Override
	public <Result extends Object> Result execute(IUnitOfWork<Result, ? super JavaResource> unit) throws Exception {
		synchronized (getLock()) {
			return unit.exec(this);
		}
	}

	private final IFragmentProvider.Fallback fallback = new IFragmentProvider.Fallback() {
		@Override
		public EObject getEObject(String fragment) {
			return JavaResource.super.getEObjectByID(fragment);
		}

		@Override
		public String getFragment(EObject obj) {
			return JavaResource.super.getURIFragment(obj);
		}
	};

	private final AbstractClassMirror m = new AbstractClassMirror() {
		@Override
		protected String getTypeName() {
			throw new UnsupportedOperationException("TODO: auto-generated method stub");
		}

		@Override
		protected String getTypeName(JvmType type) {
			return type.getIdentifier();
		}

		@Override
		public void initialize(TypeResource typeResource) {
			throw new UnsupportedOperationException("TODO: auto-generated method stub");
		}

		@Override
		public boolean isSealed() {
			throw new UnsupportedOperationException("TODO: auto-generated method stub");
		}
	};

	@Override
	protected EObject getEObjectByID(String id) {
		return m.getEObject(this, id, fallback);
	}

	@Override
	public String getURIFragment(EObject eObject) {
		return m.getFragment(eObject, fallback);
	}

	public String getOriginalSource() {
		return contentsAsString;
	}

	public boolean isInitialized() {
		return initialized;
	}

	public boolean isInitializing() {
		return initializing;
	}
}
