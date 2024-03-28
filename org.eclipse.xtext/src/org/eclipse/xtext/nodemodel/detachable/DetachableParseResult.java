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
import java.time.Duration;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.impl.CompositeNodeWithSemanticElement;
import org.eclipse.xtext.nodemodel.impl.RootNode;

import com.google.common.base.Preconditions;

/**
 * @since 2.35
 */
public class DetachableParseResult extends AbstractDetachableParseResult<StandardNodeModelReference, NodeModelData> {
	
	private static final Logger logger = Logger.getLogger(DetachableParseResult.class);
	
	public DetachableParseResult(GrammarElementLookup grammarElementLookup) {
		super(grammarElementLookup);
	}
	
	public DetachableParseResult(GrammarElementLookup grammarElementLookup, Duration timeout) {
		super(grammarElementLookup, timeout);
	}
	
	@Override
	protected StandardNodeModelReference toNodeModelReference(ICompositeNode rootNode,
			Map<EObject, CompositeNodeWithSemanticElement> associations) {
		return new StandardNodeModelReference(this, (RootNode) Preconditions.checkNotNull(rootNode), associations);
	}

	@Override
	protected NodeModelData serialize(StandardNodeModelReference nodeModel) throws IOException {
		DetachedNodeModelWriter writer = new DetachedNodeModelWriter(grammarElementLookup);
		NodeModelData result = writer.serialize((StandardNodeModelReference) nodeModel);
		if (logger.isTraceEnabled()) {
			logger.trace("DetachableParseResult.serialize:" + result);
		}
		return result;
	}
	
	@Override
	protected StandardNodeModelReference deserialize(NodeModelData serialized) throws IOException {
		DetachedNodeModelReader reader = new DetachedNodeModelReader((NodeModelData) serialized);
		StandardNodeModelReference result = reader.deserialize(this);
		if (logger.isTraceEnabled()) {
			logger.trace("DetachableParseResult.deserialize:" + result);
		}
		return result;
	}
	
}
