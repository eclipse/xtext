/*******************************************************************************
 * Copyright (c) 2024 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.detachable;

import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.CompositeNodeWithSemanticElement;
import org.eclipse.xtext.nodemodel.impl.RootNode;

import com.google.common.collect.Iterators;

/**
 * @since 2.35
 */
public class StandardNodeModelReference extends NodeModelReference {
	
	private static final Logger logger = Logger.getLogger(StandardNodeModelReference.class);

	protected final RootNode rootNode;

	protected final Map<EObject, CompositeNodeWithSemanticElement> associations;

	protected final Tabulated<INode> externalReferences;

	protected final AbstractDetachableParseResult<StandardNodeModelReference, ?> parseResult;

	public StandardNodeModelReference(AbstractDetachableParseResult<StandardNodeModelReference, ?> parseResult, RootNode rootNode, Map<EObject, CompositeNodeWithSemanticElement> associations) {
		this(parseResult, rootNode, associations, new Tabulated<>());
	}

	public StandardNodeModelReference(AbstractDetachableParseResult<StandardNodeModelReference, ?> parseResult, RootNode rootNode, Map<EObject, CompositeNodeWithSemanticElement> associations,
			Tabulated<INode> externalReferences) {
		this.rootNode = rootNode;
		this.associations = associations;
		this.externalReferences = externalReferences;
		this.parseResult = parseResult;
	}

	@Override
	protected RootNode rootNode() {
		return rootNode;
	}

	@Override
	protected void release() {
		serializeAndDetachFrom(parseResult);
	}
	
	protected <Serialized> void serializeAndDetachFrom(AbstractDetachableParseResult<StandardNodeModelReference, Serialized> parseResult) {
		try {
			Serialized serialized = parseResult.serialize(this);
			parseResult.reference = new OffloadedNodeModelReference<Serialized>(parseResult, serialized);;
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
	}

	@Override
	protected ICompositeNode getNode(EObject semanticObject) {
		return associations.get(semanticObject);
	}

	@Override
	protected INode getNode(int id) {
		return externalReferences.getObject(id);
	}

	@Override
	protected int getId(INode node) {
		return externalReferences.getId(node);
	}
	
	@Override
	public String toString() {
		String rootNodeStats = "[content=" + rootNode.getCompleteContent().length() + ", nodes=" + Iterators.size(rootNode.basicIterator()) + "]";
		return "StandardNodeModelReference [rootNode=" + rootNodeStats + ", associations=" + associations.size()
				+ ", externalReferences=" + externalReferences.size() + "]";
	}
}