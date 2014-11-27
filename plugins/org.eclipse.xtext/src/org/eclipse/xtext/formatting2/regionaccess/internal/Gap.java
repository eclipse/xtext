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
public class Gap extends AbstractTextSegment implements IHiddenRegion {

	List<NodeHidden> hiddens = Lists.newArrayList();
	private ISemanticRegion next;
	private ISemanticRegion previous;
	private final ITextRegionAccess tokenAccess;

	protected Gap(ITextRegionAccess tokenAccess) {
		super();
		this.tokenAccess = tokenAccess;
	}

	public boolean containsComment() {
		for (IHiddenRegionPart hidden : hiddens)
			if (hidden instanceof IComment)
				return true;
		return false;
	}

	public int getLength() {
		if (hiddens.isEmpty())
			return 0;
		int start = hiddens.get(0).getNode().getOffset();
		int end = hiddens.get(hiddens.size() - 1).getNode().getEndOffset();
		return end - start;
	}

	public IHiddenRegion getNextHiddenRegion() {
		return next == null ? null : next.getNextHiddenRegion();
	}

	public ISemanticRegion getNextSemanticRegion() {
		return next;
	}

	public int getOffset() {
		if (hiddens.isEmpty()) {
			if (previous != null)
				return previous.getOffset() + previous.getLength();
			return 0;
		} else {
			return hiddens.get(0).getOffset();
		}
	}

	public List<IHiddenRegionPart> getParts() {
		return ImmutableList.<IHiddenRegionPart> copyOf(hiddens);
	}

	public IHiddenRegion getPreviousHiddenRegion() {
		return previous == null ? null : previous.getPreviousHiddenRegion();
	}

	public ISemanticRegion getPreviousSemanticRegion() {
		return previous;
	}

	public ITextRegionAccess getTextRegionAccess() {
		return tokenAccess;
	}

	public boolean isUndefined() {
		return false;
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