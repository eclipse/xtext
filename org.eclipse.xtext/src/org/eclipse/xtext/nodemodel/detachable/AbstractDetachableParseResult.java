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
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.CompositeNode;
import org.eclipse.xtext.nodemodel.impl.CompositeNodeWithSemanticElement;
import org.eclipse.xtext.nodemodel.impl.InternalNodeModelUtils;
import org.eclipse.xtext.nodemodel.impl.SyntheticCompositeNode;
import org.eclipse.xtext.parser.AbstractParseResult;

import com.google.common.collect.Iterables;

/**
 * @since 2.35
 */
public abstract class AbstractDetachableParseResult<NMR extends NodeModelReference, Serialized> extends AbstractParseResult {
	
	private static final Logger logger = Logger.getLogger(AbstractDetachableParseResult.class);
	
	protected NodeModelReference reference;
	protected final GrammarElementLookup grammarElementLookup;
	protected final Duration timeout;
	protected final Executor releaser;
	protected final AtomicLong lastUsed;
	protected CompletableFuture<Void> scheduled;

	protected AbstractDetachableParseResult(GrammarElementLookup grammarElementLookup) {
		this(grammarElementLookup, Duration.ofSeconds(5));
	}
	
	protected AbstractDetachableParseResult(GrammarElementLookup grammarElementLookup, Duration timeout) {
		super(null, false);
		this.grammarElementLookup = grammarElementLookup;
		this.lastUsed = new AtomicLong(-1);
		this.timeout = timeout;
		this.releaser = CompletableFuture.delayedExecutor(timeout.toNanos(), TimeUnit.NANOSECONDS);
		this.scheduled = CompletableFuture.completedFuture(null);
	}

	@Override
	public ICompositeNode getRootNode() {
		return reference.rootNode();
	}
	
	@Override
	public void setRootNode(/* @NonNull */ ICompositeNode rootNode) {
		throw new UnsupportedOperationException("Partial parsing is not supported");
	}
	
	public void releaseNodeModel(boolean now) {
		lastUsed.compareAndSet(-1, System.nanoTime());
		if (now) {
			releaseReference(reference);
		} else {
			scheduleRelease();
		}
	}

	protected void releaseReference(NodeModelReference reference) {
		reference.release();
	}
	
	protected void discard() {
		if (logger.isTraceEnabled()) {
			logger.trace("DetachableParseResultBase.discard");
		}
		lastUsed.set(-1);
	}
	
	protected void nodeModelRequested() {
		if (logger.isTraceEnabled()) {
			logger.trace("DetachableParseResultBase.nodeModelRequested");
		}
		lastUsed.set(System.nanoTime());
	}
	
	protected synchronized void scheduleRelease() {
		if (scheduled.isDone()) {
			if (logger.isTraceEnabled()) {
				logger.trace("DetachableParseResultBase.scheduleRelease");
			}
			scheduled = CompletableFuture.runAsync(()->{
				NodeModelReference reference = this.reference;
				long lastUsedNanos = lastUsed.get();
				if (lastUsedNanos != -1) {
					if (Duration.ofNanos(System.nanoTime() - lastUsedNanos).compareTo(timeout) > 0) {
						releaseReference(reference);
					} else {
						scheduled.cancel(false); // ensure it's marked as done
						scheduleRelease();
					}
				}
			}, releaser);		
		}
	}

	public ICompositeNode getNode(EObject semanticObject) {
		return reference.getNode(semanticObject);
	}

	protected void setRootNodeAndAssociations(ICompositeNode rootNode,
			Map<EObject, CompositeNodeWithSemanticElement> associations) {
		this.reference = toNodeModelReference(rootNode, associations);
	}

	protected abstract NMR toNodeModelReference(ICompositeNode rootNode,
			Map<EObject, CompositeNodeWithSemanticElement> associations);
	
	protected abstract Serialized serialize(NMR nodeModel) throws IOException;
	
	protected abstract NMR deserialize(Serialized serialized) throws IOException;
	
	@Override
	public Iterable<INode> getSyntaxErrors() {
		return Iterables.transform(super.getSyntaxErrors(), this::toExternalReference);
	}
	
	protected ILeafNode getLeafNode(int id) {
		return (ILeafNode) reference.getNode(id);
	}
	
	protected ICompositeNode getCompositeNode(int id) {
		return (ICompositeNode) reference.getNode(id);
	}
	
	protected GrammarElementLookup getGrammarElementLookup() {
		return grammarElementLookup;
	}
	
	private static class SyntheticCompositeNodeAccess extends InternalNodeModelUtils {
		protected static CompositeNode basicGetDelegate(SyntheticCompositeNode node) {
			return InternalNodeModelUtils.basicGetDelegate(node);
		}
		
		protected static int basicGetGrammarElementIndex(SyntheticCompositeNode node) {
			return InternalNodeModelUtils.basicGetGrammarElementIndex(node);
		}
	}
	
	protected INode toExternalReference(INode node) {
		if (node == null) {
			return null;
		}
		// If a code path still has a reference to a node, the node model reference must be a standard reference
		if (node instanceof SyntheticCompositeNode) {
			SyntheticCompositeNode synthetic = (SyntheticCompositeNode) node;
			CompositeNode delegate = SyntheticCompositeNodeAccess.basicGetDelegate(synthetic);
			int delegateId = reference.getId(delegate);
			return new DetachedSyntheticCompositeNode(this, delegateId, SyntheticCompositeNodeAccess.basicGetGrammarElementIndex(synthetic));
		} else if (node instanceof ILeafNode) {
			return new DetachedLeafNode(this, reference.getId(node));
		} else {
			return new DetachedCompositeNode(this, reference.getId(node));
		}
		
	}
	
}
