/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.impl;

import java.util.Collection;

import org.eclipse.xtext.formatting2.ITextReplacerContext;
import org.eclipse.xtext.formatting2.ITextSegmentMerger;
import org.eclipse.xtext.formatting2.ITextReplacer.Mergeable;
import org.eclipse.xtext.formatting2.impl.FormattableDocument.ReplacerContext;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class TextReplacerMerger<T extends ITextReplacerContext> implements ITextSegmentMerger<T> {

	@SuppressWarnings("unchecked")
	public T merge(Collection<? extends T> conflicts) {
		T merged = null;
		for (ITextReplacerContext ctx : conflicts) {
			if (ctx instanceof Mergeable<?>) {
				if (merged == null)
					merged = (T) ctx;
				else {
					merged = (T) (((Mergeable<ReplacerContext>) ctx).mergeWith((ReplacerContext) merged));
					if (merged == null)
						return null;
				}
			} else
				return null;
		}
		return merged;
	}

}
