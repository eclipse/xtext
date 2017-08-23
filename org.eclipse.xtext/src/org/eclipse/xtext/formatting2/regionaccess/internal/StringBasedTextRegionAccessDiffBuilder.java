/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.regionaccess.IEObjectRegion;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISequentialRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionDiffBuilder;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.ISequenceAcceptor;
import org.eclipse.xtext.util.ITextRegion;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class StringBasedTextRegionAccessDiffBuilder implements ITextRegionDiffBuilder {

	protected static class MultiInsertionRewriteAction extends RewriteAction {

		private final List<RewriteAction> delegates = Lists.newArrayList();

		public MultiInsertionRewriteAction(ISequentialRegion originalFirst, ISequentialRegion originalLast) {
			super(originalFirst, originalLast);
		}

		@Override
		public SequentialRegionDiff apply(StringBasedTextRegionAccessDiffAppender appender) {
			ISequentialRegion substituteFirst = null;
			ISequentialRegion substituteLast = null;
			for (int i = 0; i < delegates.size(); i++) {
				SequentialRegionDiff rewrite = delegates.get(i).apply(appender);
				if (i == 0) {
					substituteFirst = rewrite.getModifiedFirstRegion();
				}
				if (i == delegates.size() - 1) {
					substituteLast = rewrite.getModifiedLastRegion();
				}
			}
			return new SequentialRegionDiff(originalFirst, originalLast, substituteFirst, substituteLast);
		}

	}

	protected static class RemoveRewriteAction extends RewriteAction {
		private boolean delete;

		public RemoveRewriteAction(IHiddenRegion originalFirst, IHiddenRegion originalLast, boolean delete) {
			super(originalFirst, originalLast);
			this.delete = delete;
		}

		@Override
		public SequentialRegionDiff apply(StringBasedTextRegionAccessDiffAppender appender) {
			return appender.copySurroundingHidden((IHiddenRegion) originalFirst, (IHiddenRegion) originalLast, delete);
		}

	}

	protected static class ReplaceRewriteAction extends RewriteAction {
		private final IHiddenRegion modifiedFirst;
		private final IHiddenRegion modifiedLast;

		public ReplaceRewriteAction(IHiddenRegion originalFirst, IHiddenRegion originalLast,
				IHiddenRegion modifiedFirst, IHiddenRegion modifiedLast) {
			super(originalFirst, originalLast);
			this.modifiedFirst = modifiedFirst;
			this.modifiedLast = modifiedLast;
		}

		@Override
		public SequentialRegionDiff apply(StringBasedTextRegionAccessDiffAppender appender) {
			SequentialRegionDiff result = appender.copyAndAppend((IHiddenRegion) originalFirst,
					(IHiddenRegion) originalLast, modifiedFirst, modifiedLast);
			return result;
		}
	}

	public abstract static class RewriteAction implements Comparable<RewriteAction> {
		protected ISequentialRegion originalFirst;
		protected ISequentialRegion originalLast;

		public RewriteAction(ISequentialRegion originalFirst, ISequentialRegion originalLast) {
			super();
			this.originalFirst = originalFirst;
			this.originalLast = originalLast;
		}

		public abstract SequentialRegionDiff apply(StringBasedTextRegionAccessDiffAppender appender);

		@Override
		public int compareTo(RewriteAction o) {
			return originalFirst.compareTo(o.originalFirst);
		}
	}

	protected static class SequenceRewriteAction extends RewriteAction {
		private final TextRegionAccessBuildingSequencer sequencer;

		public SequenceRewriteAction(IHiddenRegion originalFirst, IHiddenRegion originalLast,
				TextRegionAccessBuildingSequencer sequencer) {
			super(originalFirst, originalLast);
			this.sequencer = sequencer;
		}

		@Override
		public SequentialRegionDiff apply(StringBasedTextRegionAccessDiffAppender appender) {
			StringBasedRegionAccess textRegionAccess = sequencer.getRegionAccess();
			IEObjectRegion substituteRoot = textRegionAccess.regionForRootEObject();
			IHiddenRegion substituteFirst = substituteRoot.getPreviousHiddenRegion();
			IHiddenRegion substituteLast = substituteRoot.getNextHiddenRegion();
			SequentialRegionDiff result = appender.copyAndAppend((IHiddenRegion) originalFirst,
					(IHiddenRegion) originalLast, substituteFirst, substituteLast);
			return result;
		}
	}

	protected static class TextRewriteAction extends RewriteAction {

		private String text;

		public TextRewriteAction(ISemanticRegion region, String text) {
			super(region, region);
			this.text = text;
		}

		@Override
		public SequentialRegionDiff apply(StringBasedTextRegionAccessDiffAppender appender) {
			ISemanticRegion region = appender.copyAndAppend((ISemanticRegion) originalFirst, text);
			return new SequentialRegionDiff(originalFirst, originalLast, region, region);
		}

	}

	private final ITextRegionAccess original;
	private List<RewriteAction> rewrites = Lists.newArrayList();

	public StringBasedTextRegionAccessDiffBuilder(ITextRegionAccess base) {
		super();
		this.original = base;
	}

	protected void addInsert(RewriteAction action) {
		int i = getActionAt(action.originalFirst, action.originalLast);
		if (i >= 0) {
			RewriteAction existing = rewrites.get(i);
			MultiInsertionRewriteAction comp = null;
			if (existing instanceof MultiInsertionRewriteAction) {
				comp = (MultiInsertionRewriteAction) existing;
			} else {
				comp = new MultiInsertionRewriteAction(action.originalFirst, action.originalFirst);
				comp.delegates.add(existing);
				rewrites.set(i, comp);
			}
			comp.delegates.add(action);
		} else {
			rewrites.add(action);
		}
	}

	protected void addRemoveAction(IHiddenRegion first, IHiddenRegion last, boolean del) {
		for (RewriteAction rw : rewrites) {
			if (rw.originalFirst == last) {
				rw.originalFirst = first;
				return;
			}
			if (rw.originalLast == first) {
				rw.originalLast = last;
				return;
			}
		}
		rewrites.add(new RemoveRewriteAction(first, last, del));
	}

	protected void checkOriginal(ITextSegment segment) {
		Preconditions.checkNotNull(segment);
		Preconditions.checkArgument(original == segment.getTextRegionAccess());
	}

	@Override
	public StringBasedTextRegionAccessDiff create() {
		Collections.sort(rewrites);
		IEObjectRegion root = original.regionForRootEObject();
		ISequentialRegion last = root.getPreviousHiddenRegion();
		StringBasedTextRegionAccessDiff result = new StringBasedTextRegionAccessDiff(original);
		StringBasedTextRegionAccessDiffAppender appender = new StringBasedTextRegionAccessDiffAppender(result);
		for (RewriteAction next : rewrites) {
			if (!next.originalFirst.equals(last) && !next.originalFirst.equals(last.getPreviousSequentialRegion())) {
				appender.copyAndAppend(last, next.originalFirst.getPreviousSequentialRegion());
			}
			SequentialRegionDiff rewrite = next.apply(appender);
			result.append(rewrite);
			last = next.originalLast.getNextSequentialRegion();
		}
		if (last != null) {
			appender.copyAndAppend(last, root.getNextSequentialRegion());
		}
		appender.updateEObjectRegions();
		AbstractEObjectRegion newRoot = result.regionForEObject(root.getSemanticElement());
		result.setRootEObject(newRoot);
		return result;
	}

	protected int getActionAt(ISequentialRegion first, ISequentialRegion last) {
		for (int i = 0; i < rewrites.size(); i++) {
			RewriteAction a = rewrites.get(i);
			if (a.originalFirst == first && a.originalLast == last) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public ITextRegionAccess getOriginalTextRegionAccess() {
		return original;
	}

	@Override
	public boolean isModified(ITextRegion region) {
		int offset = region.getOffset();
		int endOffset = offset + region.getLength();
		for (RewriteAction action : rewrites) {
			int rwOffset = action.originalFirst.getOffset();
			int rwEndOffset = action.originalLast.getEndOffset();
			if (rwOffset <= offset && offset < rwEndOffset) {
				return true;
			}
			if (rwOffset < endOffset && endOffset <= rwEndOffset) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void move(IHiddenRegion insertAt, IHiddenRegion substituteFirst, IHiddenRegion substituteLast) {
		addRemoveAction(substituteFirst, substituteLast, false);
		replace(insertAt, insertAt, substituteFirst, substituteLast);
	}

	@Override
	public void remove(IHiddenRegion first, IHiddenRegion last) {
		checkOriginal(first);
		checkOriginal(last);
		addRemoveAction(first, last, true);
	}

	@Override
	public void remove(ISemanticRegion region) {
		remove(region.getPreviousHiddenRegion(), region.getNextHiddenRegion());
	}

	@Override
	public void replace(IHiddenRegion originalFirst, IHiddenRegion originalLast, IHiddenRegion modifiedFirst,
			IHiddenRegion modifiedLast) {
		checkOriginal(originalFirst);
		checkOriginal(originalLast);
		addInsert(new ReplaceRewriteAction(originalFirst, originalLast, modifiedFirst, modifiedLast));
	}

	@Override
	public void replace(IHiddenRegion originalFirst, IHiddenRegion originalLast, ITextRegionAccess acc) {
		checkOriginal(originalFirst);
		checkOriginal(originalLast);
		IEObjectRegion substituteRoot = acc.regionForRootEObject();
		IHiddenRegion substituteFirst = substituteRoot.getPreviousHiddenRegion();
		IHiddenRegion substituteLast = substituteRoot.getNextHiddenRegion();
		replace(originalFirst, originalLast, substituteFirst, substituteLast);
	}

	@Override
	public void replace(ISemanticRegion region, String newText) {
		Preconditions.checkNotNull(newText);
		checkOriginal(region);
		int i = getActionAt(region, region);
		if (i >= 0) {
			RewriteAction existing = rewrites.get(i);
			if (existing instanceof TextRewriteAction) {
				((TextRewriteAction) existing).text = newText;
				return;
			}
		}
		rewrites.add(new TextRewriteAction(region, newText));
	}

	@Override
	public ISequenceAcceptor replaceSequence(IHiddenRegion originalFirst, IHiddenRegion originalLast,
			ISerializationContext ctx, EObject root) {
		checkOriginal(originalFirst);
		checkOriginal(originalLast);
		TextRegionAccessBuildingSequencer sequenceAcceptor = new TextRegionAccessBuildingSequencer();
		addInsert(new SequenceRewriteAction(originalFirst, originalLast, sequenceAcceptor));
		return sequenceAcceptor.withRoot(ctx, root);
	}

}