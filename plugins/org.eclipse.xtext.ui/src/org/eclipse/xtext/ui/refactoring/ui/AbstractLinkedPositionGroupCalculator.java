/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.ui;

import static com.google.common.collect.Iterables.*;

import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.link.LinkedPosition;
import org.eclipse.jface.text.link.LinkedPositionGroup;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.refactoring.ILinkedPositionGroupCalculator;

import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Iterables;

/**
 * @author Holger Schill - Initial contribution and API
 * @author Jan Koehnlein
 */
public abstract class AbstractLinkedPositionGroupCalculator implements ILinkedPositionGroupCalculator {

	private static final Logger LOG = Logger.getLogger(AbstractLinkedPositionGroupCalculator.class);

	protected LinkedPositionGroup createLinkedGroupFromReplaceEdits(List<ReplaceEdit> edits, XtextEditor xtextEditor,
			final String originalName, SubMonitor progress) {
		if (edits == null)
			return null;
		final IXtextDocument document = xtextEditor.getDocument();
		LinkedPositionGroup group = new LinkedPositionGroup();
		Iterable<LinkedPosition> linkedPositions = filter(
				Iterables.transform(edits, new Function<ReplaceEdit, LinkedPosition>() {
					public LinkedPosition apply(ReplaceEdit edit) {
						try {
							String textToReplace = document.get(edit.getOffset(), edit.getLength());
							int indexOf = textToReplace.indexOf(originalName);
							if (indexOf != -1) {
								int calculatedOffset = edit.getOffset() + indexOf;
								return new LinkedPosition(document, calculatedOffset, originalName.length());
							}
						} catch (BadLocationException exc) {
							LOG.error(exc.getMessage(), exc);
						}
						return null;
					}
				}), Predicates.notNull());
		progress.worked(10);
		final int invocationOffset = xtextEditor.getInternalSourceViewer().getSelectedRange().x;
		int i = 0;
		for (LinkedPosition position : sortPositions(linkedPositions, invocationOffset)) {
			try {
				position.setSequenceNumber(i);
				i++;
				group.addPosition(position);
			} catch (BadLocationException e) {
				LOG.error(e.getMessage(), e);
				return null;
			}
		}
		return group;
	}

	protected Iterable<LinkedPosition> sortPositions(Iterable<LinkedPosition> linkedPositions,
			final int invocationOffset) {
		Comparator<LinkedPosition> comparator = new Comparator<LinkedPosition>() {

			public int compare(LinkedPosition left, LinkedPosition right) {
				return rank(left) - rank(right);
			}

			private int rank(LinkedPosition o1) {
				int relativeRank = o1.getOffset() + o1.length - invocationOffset;
				if (relativeRank < 0)
					return Integer.MAX_VALUE + relativeRank;
				else
					return relativeRank;
			}
		};
		return ImmutableSortedSet.copyOf(comparator, linkedPositions);
	}
}
