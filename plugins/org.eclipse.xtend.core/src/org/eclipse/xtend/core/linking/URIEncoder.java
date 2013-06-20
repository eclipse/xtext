/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.linking;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.linking.lazy.LazyURIEncoder;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Triple;

import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class URIEncoder extends LazyURIEncoder {

	@Override
	public boolean isCrossLinkFragment(Resource res, String s) {
		if (res instanceof LinkingProxyAwareResource) {
			return s.charAt(0) == '|';
		}
		return false;
	}
	
	@Override
	public String encode(EObject obj, EReference ref, INode node) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public Triple<EObject, EReference, INode> decode(Resource res, String uriFragment) {
		LinkingProxyAwareResource castedResource = (LinkingProxyAwareResource) res;
		return castedResource.getEncodedURI(Integer.parseInt(uriFragment.substring(1)));
	}
	
	@Override
	public INode getNode(EObject object, String fragment) {
		LinkingProxyAwareResource resource = (LinkingProxyAwareResource) object.eResource();
		return decode(resource, fragment).getThird();
	}
}
