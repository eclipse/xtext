/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.internal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.parser.packrat.IBacktracker;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IParsedTokenVisitor;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.tokens.AbstractParsedToken;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Marker extends AbstractParsedToken implements IMarkerFactory.IMarker, IParsedTokenAcceptor, IBacktracker {

	private static final int INITIAL_CONTENT_SIZE = 100;

	public interface IMarkerClient extends IMarkerFactory {
		void setActiveMarker(Marker marker);
		Marker getActiveMarker();
		Marker getNextMarker(Marker parent, int offset);
		void releaseMarker(Marker marker);
	}

	public interface IMarkerVisitor extends IParsedTokenVisitor {
		void visitMarker(Marker marker);
	}

	private IMarkerClient client;

	private Marker parent;

	private int danglingChildCount;

	private int lastOffset;

	private final List<AbstractParsedToken> content;

	private ICharSequenceWithOffset input;

	private IBacktracker backtracker;

	public Marker(Marker parent, int offset, ICharSequenceWithOffset input, IMarkerClient client) {
		super(offset, 0);
		this.content = new ArrayList<AbstractParsedToken>(INITIAL_CONTENT_SIZE);
		init(parent, input, client);
	}

	private void init(Marker parent, ICharSequenceWithOffset input, IMarkerClient client) {
		this.lastOffset = -1;
		this.parent = parent;
		if (this.parent != null)
			this.parent.danglingChildCount++;
		this.input = input;
		this.client = client;
		this.client.setActiveMarker(this);
	}

	public Marker reInit(int offset, Marker parent, ICharSequenceWithOffset input, IMarkerClient client) {
		setOffset(offset);
		init(parent, input, client);
		return this;
	}

	@Override
	public void rollback() {
		if (danglingChildCount > 0)
			throw new IllegalStateException("childCount has to be zero before rollback.");
		input.setOffset(getOffset());
		client.setActiveMarker(parent);
		forget();
	}

	@Override
	public void flush() {
		if (danglingChildCount > 0)
			throw new IllegalStateException("childCount has to be zero before flush.");
		if (parent != null) {
			if (parent.danglingChildCount > 1)
				throw new IllegalStateException("cannot flush if there exist any forked children.");
			parent.content.addAll(this.content);
			this.content.clear();
		} else {
			throw new IllegalStateException("Cannot flush root marker.");
		}
		setOffset(input.getOffset());
		lastOffset = input.getOffset();
	}

	@Override
	public void commit() {
		if (danglingChildCount > 0)
			throw new IllegalStateException("childCount has to be zero before commit.");
		if (parent != null) {
			if (parent.danglingChildCount != 1)
				throw new IllegalStateException("cannot commit if there exist any other forked children.");
			if (!content.isEmpty())
				parent.content.addAll(content);
			client.releaseMarker(this);
			content.clear();
			parent.danglingChildCount--;
		}
		client.setActiveMarker(parent);
		this.parent = null; // prevent accidental change
	}

	@Override
	public Marker fork() {
		lastOffset = input.getOffset();
		input.setOffset(getOffset());
		return client.getNextMarker(parent, getOffset());
	}

	public Marker forkAfterSkipped(int before) {
		Marker result = fork();
		if (before >= 1) {
			result.content.addAll(content.subList(0, before));
		}
		return result;
	}

	@Override
	public IMarker join(IMarker forkedMarker) {
		if (!(forkedMarker instanceof Marker))
			throw new IllegalArgumentException("forkedMarker is not supported: " + forkedMarker);
		Marker joinMe = (Marker) forkedMarker;
		if (joinMe.parent != parent)
			throw new IllegalStateException("cannot join with a marker, that has another parent.");
		client.setActiveMarker(this);
		if (lastOffset != -1)
			getInput().setOffset(lastOffset);
		joinMe.forget();
		if (parent != null && parent.danglingChildCount < 1)
			throw new IllegalStateException("parent should have at least one dangling child after join.");
		return this;
	}

	void forget() {
		if (parent != null) {
			parent.danglingChildCount--;
			if (parent.danglingChildCount < 0)
				throw new IllegalStateException("childCount may not be smaller than zero.");
		}
		client.releaseMarker(this);
		backtracker = null;
		this.parent = null;
		// TODO forget content
		content.clear();
	}

	public List<AbstractParsedToken> getContent() {
		return content;
	}

	public Marker getParent() {
		return parent;
	}

	@Override
	public String toString() {
		return super.toString() + " dangling children: '" + danglingChildCount + "' actual content: '" + content.size() + "'";
	}

	@Override
	public void accept(IParsedTokenVisitor visitor) {
		if (danglingChildCount != 0)
			throw new IllegalStateException("cannot accept visitor if there exist any dangling children.");
		if (visitor instanceof IMarkerVisitor)
			((IMarkerVisitor) visitor).visitMarker(this);
		else {
			for(int i = 0; i < content.size(); i++) {
				content.get(i).accept(visitor);
			}
		}
	}

	@Override
	public void accept(AbstractParsedToken token) {
		if (danglingChildCount != 0)
			throw new IllegalStateException("cannot accept tokens if there exist any dangling children.");
		content.add(token);
	}

	public void setClient(IMarkerClient client) {
		this.client = client;
	}

	public IMarkerClient getClient() {
		return client;
	}

	public void setInput(ICharSequenceWithOffset input) {
		this.input = input;
	}

	public ICharSequenceWithOffset getInput() {
		return input;
	}

	@Override
	public IBacktrackingResult skipPreviousToken() {
		if (danglingChildCount > 0)
			throw new IllegalStateException("childCount has to be zero before backtracking.");
		if (backtracker == null)
			backtracker = new MarkerAwareBacktracker(this);
		return backtracker.skipPreviousToken();
	}

	public void discardLastOffset() {
		lastOffset = -1;
	}

	public void replaceContent(List<AbstractParsedToken> tokens) {
		content.clear();
		content.addAll(tokens);
	}

}