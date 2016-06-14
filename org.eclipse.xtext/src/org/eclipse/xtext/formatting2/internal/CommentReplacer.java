/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import org.eclipse.xtext.formatting2.ITextReplacer;
import org.eclipse.xtext.formatting2.regionaccess.IComment;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class CommentReplacer implements ITextReplacer {

	private final IComment comment;

	public CommentReplacer(IComment comment) {
		this.comment = comment;
	}

	public abstract void configureWhitespace(WhitespaceReplacer leading, WhitespaceReplacer trailing);

	public IComment getComment() {
		return comment;
	}

	@Override
	public ITextSegment getRegion() {
		return comment;
	}
}
