/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatter.impl;

import org.eclipse.xtext.formatter.ITextReplacer;
import org.eclipse.xtext.formatter.ITokenAccess;
import org.eclipse.xtext.formatter.ITokenAccess.IComment;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class CommentReplacer implements ITextReplacer {

	private final IComment comment;

	public static class Factory implements ITextReplacer.Factory<ITokenAccess.IComment> {

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

	public Flow createReplacements(Context context) {
		return context.getFlow();
	}

}
