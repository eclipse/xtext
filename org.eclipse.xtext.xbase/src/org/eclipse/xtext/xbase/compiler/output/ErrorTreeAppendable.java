/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler.output;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.generator.trace.ILocationData;
import org.eclipse.xtext.generator.trace.ITraceURIConverter;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.linking.lazy.LazyURIEncoder;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;

/**
 * A tree appendable capable of serializing broken type references.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ErrorTreeAppendable extends TreeAppendable {
	
	private LazyURIEncoder encoder;

	public ErrorTreeAppendable(SharedAppendableState state, 
			ITraceURIConverter converter,
			ILocationInFileProvider locationProvider,
			IJvmModelAssociations jvmModelAssociations,
			Set<ILocationData> sourceLocations, 
			boolean useForDebugging) {
		super(state, converter, locationProvider, jvmModelAssociations, sourceLocations, useForDebugging);
		encoder = getOrCreateURIEncoder();
	}
	
	protected LazyURIEncoder getOrCreateURIEncoder() {
		Resource resource = getState().getResource();
		if (resource instanceof LazyLinkingResource) {
			return ((LazyLinkingResource) resource).getEncoder();
		}
		return new LazyURIEncoder();
	}
	
	@Override
	public TreeAppendable append(JvmType type) {
		if(type.eIsProxy()) {
			String fragment = ((InternalEObject)type).eProxyURI().fragment();
			Triple<EObject, EReference, INode> unresolvedLink = encoder.decode(getState().getResource(), fragment);
			if(unresolvedLink != null) {
				INode linkNode = unresolvedLink.getThird();
				if(linkNode != null) {
					append(NodeModelUtils.getTokenText(linkNode));
					return this;
				}
			}
			append("unresolved type");
			return this;
		}
		return super.append(type);
	}
		
	@Override
	protected TreeAppendable createChild(SharedAppendableState state, ILocationInFileProvider locationProvider, 
			IJvmModelAssociations jvmModelAssociations, Set<ILocationData> newData, boolean useForDebugging) {
		return this;
	}
}
