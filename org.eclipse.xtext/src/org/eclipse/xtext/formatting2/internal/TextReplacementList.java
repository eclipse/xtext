/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import java.util.ArrayList;

import org.eclipse.xtext.formatting2.debug.TextRegionsToString;
import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;

import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class TextReplacementList<T extends ITextReplacement> extends ArrayList<T> {

	private static final long serialVersionUID = -3733935036194734459L;

	public TextReplacementList() {
		super();
	}

	public TextReplacementList(Iterable<? extends T> c) {
		super(Lists.newArrayList(c));
	}

	public TextReplacementList(int initialCapacity) {
		super(initialCapacity);
	}

	@Override
	public String toString() {
		return new TextRegionsToString().setTitle(getClass().getSimpleName()).addAllReplacements(this).toString();
	}
}
