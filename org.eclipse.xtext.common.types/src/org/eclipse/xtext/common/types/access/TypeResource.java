/*******************************************************************************
 * Copyright (c) 2009, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess;
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess.UnknownNestedTypeException;
import org.eclipse.xtext.common.types.access.impl.TypeResourceServices;
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants;
import org.eclipse.xtext.resource.IFragmentProvider;
import org.eclipse.xtext.resource.ISynchronizable;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TypeResource extends ResourceImpl implements ISynchronizable<TypeResource>, IJavaSchemeUriResolver {

	/**
	 * @since 2.7
	 */
	public static final String OPTION_CLASSPATH_CONTEXT = "OPTION_CLASSPATH_CONTEXT";
	
	private IMirror mirror;
	
	private IndexedJvmTypeAccess indexedJvmTypeAccess;
	
	private TypeResourceServices typeResourceServices;
	
	public void setTypeResourceServices(TypeResourceServices typeResourceServices) {
		this.typeResourceServices = typeResourceServices;
	}
	
	private IFragmentProvider.Fallback fragmentProviderFallback = new IFragmentProvider.Fallback() {
		
		@Override
		public String getFragment(EObject obj) {
			return TypeResource.super.getURIFragment(obj);
		}
		
		@Override
		public EObject getEObject(String fragment) {
			return TypeResource.super.getEObject(fragment);
		}
	};
	
	public TypeResource() {
		super();
	}

	public TypeResource(URI uri) {
		super(uri);
	}
	
	@Override
	public NotificationChain basicSetResourceSet(ResourceSet resourceSet, NotificationChain notifications) {
		if (resourceSet == null) {
			ResourceSet oldResourceSet = this.resourceSet;
			if (oldResourceSet != null && !oldResourceSet.eDeliver()) {
				if (mirror instanceof Adapter) {
					Adapter adapter = (Adapter) mirror;
					oldResourceSet.eAdapters().remove(adapter);
				}
				mirror = null;
				eSetDeliver(false);
				if (contents != null)
					contents.clear();
				unload();
			}
		}
		return super.basicSetResourceSet(resourceSet, notifications);
	}
	
	@Override
	public EObject getEObject(String uriFragment) {
		if (mirror != null) {
			EObject result = mirror.getEObject(this, uriFragment, fragmentProviderFallback);
			return result;
		}
		return super.getEObject(uriFragment);
	}
	
	@Override
	public String getURIFragment(EObject eObject) {
		if (mirror != null) {
			String result = mirror.getFragment(eObject, fragmentProviderFallback);
			return result;
		}
		return super.getURIFragment(eObject);
	}

	public void setMirror(IMirror mirror) {
		this.mirror = mirror;
	}

	public IMirror getMirror() {
		return mirror;
	}
	
	@Override
	public void load(Map<?, ?> options) throws IOException {
		if (!isLoaded) {
			load(null, options);
		}
	}
	
	@Override
	public void save(Map<?, ?> options) throws IOException {
		throw new UnsupportedOperationException();
	}
	
	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
		try {
			if (getURI() != null && mirror != null) {
				if (mirror instanceof IMirrorOptionsAware) {
					((IMirrorOptionsAware)mirror).initialize(this, options);
				} else {
					mirror.initialize(this);
				}
			}
		} catch(Exception e) {
			if (typeResourceServices != null) {
				OperationCanceledManager operationCanceledManager = typeResourceServices.getOperationCanceledManager();
				if (operationCanceledManager.isOperationCanceledException(e)) {
					unload();
				}
				operationCanceledManager.propagateAsErrorIfCancelException(e);
			}	
			throw new CannotLoadTypeResourceException(e);
		}
	}
	
	protected static class CannotLoadTypeResourceException extends IOException {

		private static final long serialVersionUID = 1L;

		public CannotLoadTypeResourceException(Exception e) {
			super(e.getMessage());
			initCause(e);
		}
	}
	
	@Override
	public EObject resolveJavaObjectURIProxy(InternalEObject proxy, EObject sender) {
		final URI proxyURI = proxy.eProxyURI();
        if (proxyURI != null && URIHelperConstants.PROTOCOL.equals(proxyURI.scheme())) {
            if ("Objects".equals(proxyURI.segment(0))) {
				if (indexedJvmTypeAccess != null) {
					try {
						EObject result = indexedJvmTypeAccess.getIndexedJvmType(proxy.eProxyURI(), getResourceSet());
						if (result != null) {
							return result;
						}
					} catch(UnknownNestedTypeException e) {
						return proxy;
					}
				}
				return EcoreUtil.resolve(proxy, sender);
            }
        }
        return null;
	}

	public IndexedJvmTypeAccess getIndexedJvmTypeAccess() {
		return indexedJvmTypeAccess;
	}

	public void setIndexedJvmTypeAccess(IndexedJvmTypeAccess indexedJvmTypeAccess) {
		this.indexedJvmTypeAccess = indexedJvmTypeAccess;
	}

	/**
	 * Returns the lock of the owning {@link ResourceSet}, if it exposes such a lock.
	 * Otherwise this resource itself is used as the lock context.
	 */
	/* @NonNull */
	@Override
	public Object getLock() {
		ResourceSet resourceSet = getResourceSet();
		if (resourceSet instanceof ISynchronizable<?>) {
			return ((ISynchronizable<?>) resourceSet).getLock();
		}
		return this;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @since 2.4
	 */
	/* @Nullable */
	@Override
	public <Result> Result execute(/* @NonNull */ IUnitOfWork<Result, ? super TypeResource> unit) throws Exception {
		synchronized (getLock()) {
			return unit.exec(this);
		}
	}
	
}
