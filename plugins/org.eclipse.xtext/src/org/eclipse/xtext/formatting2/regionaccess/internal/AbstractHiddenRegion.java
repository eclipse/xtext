/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal;

import java.util.List;

import org.eclipse.xtext.formatting2.debug.TokenAccessToString;
import org.eclipse.xtext.formatting2.internal.AbstractTextSegment;
import org.eclipse.xtext.formatting2.regionaccess.IComment;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegionPart;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractHiddenRegion extends AbstractTextSegment implements IHiddenRegion {

	List<IHiddenRegionPart> hiddens = Lists.newArrayList();
	private ISemanticRegion next;
	private ISemanticRegion previous;
	private final ITextRegionAccess tokenAccess;

	protected AbstractHiddenRegion(ITextRegionAccess tokenAccess) {
		super();
		this.tokenAccess = tokenAccess;
	}

	@Override
	public boolean containsComment() {
		for (IHiddenRegionPart hidden : hiddens)
			if (hidden instanceof IComment)
				return true;
		return false;
	}

	@Override
	public int getLength() {
		if (hiddens.isEmpty())
			return 0;
		int start = hiddens.get(0).getOffset();
		int end = hiddens.get(hiddens.size() - 1).getEndOffset();
		return end - start;
	}

	@Override
	public IHiddenRegion getNextHiddenRegion() {
		return next == null ? null : next.getNextHiddenRegion();
	}

	@Override
	public ISemanticRegion getNextSemanticRegion() {
		return next;
	}

	@Override
	public int getOffset() {
		if (hiddens.isEmpty()) {
			if (previous != null)
				return previous.getOffset() + previous.getLength();
			return 0;
		} else {
			return hiddens.get(0).getOffset();
		}
	}

	@Override
	public List<IHiddenRegionPart> getParts() {
		return ImmutableList.<IHiddenRegionPart> copyOf(hiddens);
	}

	@Override
	public IHiddenRegion getPreviousHiddenRegion() {
		return previous == null ? null : previous.getPreviousHiddenRegion();
	}

	@Override
	public ISemanticRegion getPreviousSemanticRegion() {
		return previous;
	}

	@Override
	public ITextRegionAccess getTextRegionAccess() {
		return tokenAccess;
	}

	protected void setNext(ISemanticRegion next) {
		this.next = next;
	}

	protected void setPrevious(ISemanticRegion previous) {
		this.previous = previous;
	}

	@Override
	public String toString() {
		return new TokenAccessToString().withOrigin(this).hightlightOrigin().toString();
	}

}