/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.concurrent.IEObjectHandle;
import org.eclipse.xtext.util.concurrent.IStateAccess;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

public class EObjectHandleImpl<P extends EObject> implements IEObjectHandle<P> {

	private P internal;
	private IStateAccess<XtextResource> resourceAccess;
	private URI uri;

	public URI getURI() {
		return uri;
	}

	public EObjectHandleImpl(P internal, IStateAccess<XtextResource> resourceAccess) {
		this.internal = internal;
		this.resourceAccess = resourceAccess;
		this.uri = EcoreUtil.getURI(internal);
	}

	public <T> T modify(IUnitOfWork<T, P> work) {
		return resourceAccess.modify(new ResourceAccess<T>(work));
	}

	public <T> T readOnly(IUnitOfWork<T, P> work) {
		return resourceAccess.readOnly(new ResourceAccess<T>(work));
	}

	class ResourceAccess<T> implements IUnitOfWork<T, XtextResource> {

		private IUnitOfWork<T, P> work = null;

		public ResourceAccess(IUnitOfWork<T, P> work) {
			super();
			this.work = work;
		}

		@SuppressWarnings("unchecked")
		public T exec(XtextResource resource) throws Exception {
			P obj = internal;
			if (obj.eResource() != resource) {
				obj = (P) resource.getEObject(uri.fragment());
			}
			return work.exec(obj);
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof EObjectHandleImpl<?>) {
			return uri.equals(((EObjectHandleImpl<?>) obj).getURI());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return 7 * uri.hashCode();
	}
}