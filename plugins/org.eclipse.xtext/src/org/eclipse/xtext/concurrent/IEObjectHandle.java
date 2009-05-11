/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.concurrent;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.XtextResource;

import com.google.inject.ImplementedBy;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
@ImplementedBy(IEObjectHandle.DefaultImpl.class)
public interface IEObjectHandle<T extends EObject> extends IStateAccess<T> {
	
	static class DefaultImpl<P extends EObject> implements IEObjectHandle<P> {
		
		private P internal;
		private IStateAccess<XtextResource> resourceAccess;
		private String fragment;
		
		public DefaultImpl(P internal, IStateAccess<XtextResource> resourceAccess) {
			super();
			this.internal = internal;
			this.resourceAccess = resourceAccess;
			this.fragment = internal.eResource().getURIFragment(internal);
		}

		public <T> T modify(IUnitOfWork<T, P> work) {
			return resourceAccess.modify(new ResourceAccess<T>(work));
		}

		public <T> T readOnly(IUnitOfWork<T, P> work) {
			return resourceAccess.readOnly(new ResourceAccess<T>(work));
		}
		
		class ResourceAccess<T> implements IUnitOfWork<T,XtextResource> {
			
			private IUnitOfWork<T, P> work = null;

			public ResourceAccess(IUnitOfWork<T, P> work) {
				super();
				this.work = work;
			}

			@SuppressWarnings("unchecked")
			public T exec(XtextResource resource) throws Exception {
				P obj = internal;
				if (obj.eResource() != resource) {
					obj = (P) resource.getEObject(fragment);
				}
				return work.exec(obj);
			}
		}

	}

}
