/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.impl;

import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.INode;

import com.google.common.base.Predicate;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class FindLastQuery {

	private final INode startWith;
	private final Predicate<? super INode> queryPredicate;
	private final boolean basic;

	public FindLastQuery(INode startWith, boolean basic, Predicate<? super INode> queryPredicate) {
		this.startWith = startWith;
		this.basic = basic;
		this.queryPredicate = queryPredicate;
	}

	public INode performQuery() {
		BidiTreeIterator<INode> iterator = createTreeIterator();
		while(iterator.hasPrevious()) {
			INode previous = iterator.previous();
			if (queryPredicate.apply(previous)) {
				return previous;
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	protected BidiTreeIterator<INode> createTreeIterator() {
		if (basic) {
			BidiTreeIterator<? extends INode> result = ((AbstractNode) startWith).basicTreeIterator();
			return (BidiTreeIterator<INode>) result;
		}
		return startWith.treeIterator();
	}
	
}
