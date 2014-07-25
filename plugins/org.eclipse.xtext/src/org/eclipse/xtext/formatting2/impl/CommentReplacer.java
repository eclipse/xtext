/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.impl;

import org.eclipse.xtext.formatting2.IComment;
import org.eclipse.xtext.formatting2.ITextReplacer;
import org.eclipse.xtext.formatting2.ITextReplacerContext;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class CommentReplacer implements ITextReplacer {

	private final IComment comment;

	public static class Factory implements ITextReplacer.Factory<IComment> {

		public ITextReplacer create(IComment comment) {
			return new CommentReplacer(comment);
		}
	}

	public CommentReplacer(IComment comment) {
		this.comment = comment;
	}

	public IComment getComment() {
		return comment;
	}

	public Flow createReplacements(ITextReplacerContext context) {
		return context.getFlow();
	}

}
