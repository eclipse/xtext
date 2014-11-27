/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.ITextReplacer;
import org.eclipse.xtext.formatting2.ITextSegment;

import com.google.common.base.Predicate;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class FilteredSubDocument extends SubDocument {

	private final Predicate<ITextReplacer> filter;

	public FilteredSubDocument(ITextSegment region, IFormattableDocument parent, Predicate<ITextReplacer> filter) {
		super(region, parent);
		this.filter = filter;
	}

	@Override
	public void addReplacer(ITextReplacer replacer) {
		if (filter.apply(replacer))
			super.addReplacer(replacer);
	}

}