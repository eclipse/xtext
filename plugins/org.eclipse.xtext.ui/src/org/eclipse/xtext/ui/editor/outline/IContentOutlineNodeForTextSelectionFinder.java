/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.swt.graphics.Point;

import com.google.inject.ImplementedBy;

/**
 * @author koehnlein - Initial contribution and API
 */
@ImplementedBy(IContentOutlineNodeForTextSelectionFinder.Default.class)
public interface IContentOutlineNodeForTextSelectionFinder {
	void setTextSelection(Point textSelection);
	
	void traverse(IContentOutlineNode node);

	IContentOutlineNode getBestMatch();

	class Default implements IContentOutlineNodeForTextSelectionFinder {
		private IContentOutlineNode currentBestMatch;

		private IRegion textRegion;

		public void setTextSelection(Point textSelection) {
			textRegion = new Region(textSelection.x, textSelection.y - textSelection.x);
		}

		public IContentOutlineNode getBestMatch() {
			return currentBestMatch;
		}

		public void traverse(IContentOutlineNode node) {
			if(textRegion == null) {
				throw new IllegalStateException("region must be set");
			}
			IRegion nodeRegion = node.getRegion();
			if (nodeRegion != null && contains(nodeRegion, textRegion) && (currentBestMatch == null || contains(currentBestMatch.getRegion(), nodeRegion))) {
				currentBestMatch = node;
			}
			for (IContentOutlineNode child : node.getChildrenAsArray())
				traverse(child);
		}

		protected boolean contains(IRegion container, IRegion contained) {
			return container.getOffset() <= contained.getOffset()
					&& container.getOffset() + container.getLength() >= contained.getOffset() + contained.getLength();
		}
	}
}