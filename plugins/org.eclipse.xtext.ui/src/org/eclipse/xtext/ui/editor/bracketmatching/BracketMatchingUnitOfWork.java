/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.bracketmatching;

import org.eclipse.jface.text.IRegion;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.concurrent.IStateAccess;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class BracketMatchingUnitOfWork implements IUnitOfWork<IRegion, XtextResource> {

	private IBracketMatcher matcher;
	private int offset;

	BracketMatchingUnitOfWork(IBracketMatcher matcher, int offset) {
		this.matcher = matcher;
		this.offset = offset;
	}

	public IRegion exec(XtextResource state) throws Exception {
		return matcher.computeMatchingRegion(state, offset);
	}

	static IRegion match(IStateAccess<XtextResource> document, IBracketMatcher matcher, int offset) {
		return document.readOnly(new BracketMatchingUnitOfWork(matcher, offset));
	}
}
