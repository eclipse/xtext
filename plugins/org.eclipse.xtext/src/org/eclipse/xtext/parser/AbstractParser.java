/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parser;

import java.io.Reader;
import java.util.List;

import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Jan Koehnlein
 */
public abstract class AbstractParser implements IParser {

	protected boolean isReparseSupported() {
		return false;
	}

	public final IParseResult parse(Reader reader) {
		return doParse(reader);
	}

	protected abstract IParseResult doParse(Reader reader);

	protected abstract IParseResult doParse(CharSequence sequence);

	public final IParseResult reparse(CompositeNode originalRootNode, int offset, int length, String change) {
		if (!isReparseSupported()) {
			final List<LeafNode> leafNodes = originalRootNode.getLeafNodes();
			final StringBuilder builder = new StringBuilder(originalRootNode.getTotalLength());
			boolean changeAppended = false;
			for (LeafNode leaf : leafNodes) {
				if ((leaf.getTotalOffset() + leaf.getTotalLength() <= offset)
						|| (leaf.getTotalOffset() > offset + length))
					builder.append(leaf.getText());
				else {
					if (leaf.getTotalOffset() < offset) {
						builder.append(leaf.getText().subSequence(0, offset - leaf.getTotalOffset()));
					}
					if (!changeAppended) {
						builder.append(change);
						changeAppended = true;
					}
					if (leaf.getTotalOffset() + leaf.getTotalLength() > offset + length) {
						builder.append(leaf.getText().substring(offset + length - leaf.getTotalOffset()));
					}
				}
			}
			return doParse(builder);
		}
		return doReparse(originalRootNode, offset, length, change);
	}

	protected IParseResult doReparse(CompositeNode originalRootNode, int offset, int length, String change) {
		throw new UnsupportedOperationException();
	}

}
