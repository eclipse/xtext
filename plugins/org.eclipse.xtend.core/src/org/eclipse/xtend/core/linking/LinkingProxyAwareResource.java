/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.linking;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.resource.BatchLinkableResource;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LinkingProxyAwareResource extends BatchLinkableResource {

	private List<Triple<EObject, EReference, INode>> uris = Lists.newArrayList();
	
	int registerEncodedURI(EObject object, EReference reference, INode node) {
		uris.add(Tuples.create(object, reference, node));
		return uris.size() - 1;
	}
	
	Triple<EObject, EReference, INode> getEncodedURI(int idx) {
		return uris.get(idx);
	}
	
	void clearEncodeURIs() {
		uris = Lists.newArrayListWithCapacity(uris.size());
	}
	
}
