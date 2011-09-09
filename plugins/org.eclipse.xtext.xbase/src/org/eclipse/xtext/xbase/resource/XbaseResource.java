/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.resource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.LateInitializingLazyLinkingResource;
import org.eclipse.xtext.util.OnChangeEvictingCache;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XbaseResource extends LateInitializingLazyLinkingResource {
	
	@Inject
	private OnChangeEvictingCache onChangeEvictingCache;
	
	@Override
	public synchronized EObject getEObject(final String uriFragment) {
		return onChangeEvictingCache.execWithoutCacheClear(this, new IUnitOfWork<EObject, XbaseResource>(){
			public EObject exec(XbaseResource state) throws Exception {
				return XbaseResource.super.getEObject(uriFragment);
			}
		});
	}
	
	@Override
	protected EObject handleCyclicResolution(Triple<EObject, EReference, INode> triple) throws AssertionError {
		return null;
	}
}
