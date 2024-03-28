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
import java.lang.ref.SoftReference;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;

/**
 * @since 2.35
 */
public class OffloadedNodeModelReference<Serialized> extends NodeModelReference {
	
	private static final Logger logger = Logger.getLogger(OffloadedNodeModelReference.class);

	protected SoftReference<NodeModelReference> cached;
	protected Serialized serialized;
	protected final AbstractDetachableParseResult<?, Serialized> parseResult;

	public OffloadedNodeModelReference(
			AbstractDetachableParseResult<?, Serialized> parseResult,
			Serialized serialized) {
		this.parseResult = parseResult;
		this.serialized = serialized;
		this.cached = new SoftReference<NodeModelReference>(null);
	}

	@Override
	protected ICompositeNode rootNode() {
		return delegate().rootNode();
	}

	protected NodeModelReference delegate() {
		parseResult.nodeModelRequested();
		NodeModelReference result = cached.get();
		if (result != null) {
			return result;
		}
		try {
			synchronized(this) {
				result = cached.get();
				if (result != null) {
					return result;
				}
				result = parseResult.deserialize(serialized);
				cached = new SoftReference<NodeModelReference>(result);
				parseResult.scheduleRelease();
				return result;
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void release() {
		logger.trace("OffloadedNodeModelReference.release");
		cached = new SoftReference<NodeModelReference>(null);
	}
	
	@Override
	protected ICompositeNode getNode(EObject semanticObject) {
		return delegate().getNode(semanticObject);
	}

	@Override
	protected INode getNode(int id) {
		return delegate().getNode(id);
	}
	
	@Override
	protected int getId(INode node) {
		return delegate().getId(node);
	}

}