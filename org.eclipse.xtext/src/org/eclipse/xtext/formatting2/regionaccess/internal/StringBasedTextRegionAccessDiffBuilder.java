/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal;

import static org.eclipse.xtext.formatting2.regionaccess.HiddenRegionPartAssociation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.debug.TextRegionAccessToString;
import org.eclipse.xtext.formatting2.regionaccess.IEObjectRegion;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionDiffBuilder;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.ISequenceAcceptor;
import org.eclipse.xtext.util.ITextRegion;

import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class StringBasedTextRegionAccessDiffBuilder implements ITextRegionDiffBuilder {

	private final static Logger LOG = Logger.getLogger(StringBasedTextRegionAccessDiffBuilder.class);

	protected interface Insert {
		public IHiddenRegion getInsertFirst();

		public IHiddenRegion getInsertLast();
	}

	protected static class MoveSource extends Rewrite {
		private MoveTarget target = null;

		public MoveSource(IHiddenRegion first, IHiddenRegion last) {
			super(first, last);
		}

		public MoveTarget getTarget() {
			return target;
		}

	}

	protected static class MoveTarget extends Rewrite implements Insert {
		private final MoveSource source;

		public MoveTarget(IHiddenRegion insertAt, MoveSource source) {
			super(insertAt, insertAt);
			this.source = source;
			this.source.target = this;
		}

		@Override
		public IHiddenRegion getInsertFirst() {
			return this.source.originalFirst;
		}

		@Override
		public IHiddenRegion getInsertLast() {
			return this.source.originalLast;
		}

	}

	protected static class Remove extends Rewrite {

		public Remove(IHiddenRegion originalFirst, IHiddenRegion originalLast) {
			super(originalFirst, originalLast);
		}

	}

	protected static class Replace1 extends Rewrite implements Insert {
		private final IHiddenRegion modifiedFirst;
		private final IHiddenRegion modifiedLast;

		public Replace1(IHiddenRegion originalFirst, IHiddenRegion originalLast, IHiddenRegion modifiedFirst,
				IHiddenRegion modifiedLast) {
			super(originalFirst, originalLast);
			this.modifiedFirst = modifiedFirst;
			this.modifiedLast = modifiedLast;
		}

		@Override
		public IHiddenRegion getInsertFirst() {
			return this.modifiedFirst;
		}

		@Override
		public IHiddenRegion getInsertLast() {
			return this.modifiedLast;
		}

	}

	protected static class Preserve extends Rewrite implements Insert {
		public Preserve(IHiddenRegion first, IHiddenRegion last) {
			super(first, last);
		}

		@Override
		public IHiddenRegion getInsertFirst() {
			return this.originalFirst;
		}

		@Override
		public IHiddenRegion getInsertLast() {
			return this.originalLast;
		}

		@Override
		public boolean isDiff() {
			return false;
		}

	}

	public abstract static class Rewrite implements Comparable<Rewrite> {
		protected IHiddenRegion originalFirst;
		protected IHiddenRegion originalLast;

		public Rewrite(IHiddenRegion originalFirst, IHiddenRegion originalLast) {
			super();
			this.originalFirst = originalFirst;
			this.originalLast = originalLast;
		}

		public boolean isDiff() {
			return true;
		}

		@Override
		public int compareTo(Rewrite o) {
			return Integer.compare(originalFirst.getOffset(), o.originalFirst.getOffset());
		}
	}

	protected static class Replace2 extends Rewrite implements Insert {
		private final TextRegionAccessBuildingSequencer sequencer;

		public Replace2(IHiddenRegion originalFirst, IHiddenRegion originalLast,
				TextRegionAccessBuildingSequencer sequencer) {
			super(originalFirst, originalLast);
			this.sequencer = sequencer;
		}

		@Override
		public IHiddenRegion getInsertFirst() {
			return sequencer.getRegionAccess().regionForRootEObject().getPreviousHiddenRegion();
		}

		@Override
		public IHiddenRegion getInsertLast() {
			return sequencer.getRegionAccess().regionForRootEObject().getNextHiddenRegion();
		}
	}

	private final ITextRegionAccess original;
	private List<Rewrite> rewrites = Lists.newArrayList();
	private Map<ITextSegment, String> changes = Maps.newHashMap();

	public StringBasedTextRegionAccessDiffBuilder(ITextRegionAccess base) {
		super();
		this.original = base;
	}

	protected void checkOriginal(ITextSegment segment) {
		Preconditions.checkNotNull(segment);
		Preconditions.checkArgument(original == segment.getTextRegionAccess());
	}

	protected List<Rewrite> createList() {
		List<Rewrite> sorted = Lists.newArrayList(rewrites);
		Collections.sort(sorted);
		List<Rewrite> result = Lists.newArrayListWithExpectedSize(sorted.size() * 2);
		IHiddenRegion last = original.regionForRootEObject().getPreviousHiddenRegion();
		for (Rewrite rw : sorted) {
			int lastOffset = last.getOffset();
			int rwOffset = rw.originalFirst.getOffset();
			if (rwOffset == lastOffset) {
				result.add(rw);
				last = rw.originalLast;
			} else if (rwOffset > lastOffset) {
				result.add(new Preserve(last, rw.originalFirst));
				result.add(rw);
				last = rw.originalLast;
			} else {
				LOG.error("Error, conflicting document modifications.");
			}
		}
		IHiddenRegion end = original.regionForRootEObject().getNextHiddenRegion();
		if (last.getOffset() < end.getOffset()) {
			result.add(new Preserve(last, end));
		}
		return result;
	}

	@Override
	public StringBasedTextRegionAccessDiff create() {
		StringBasedTextRegionAccessDiffAppender appender = createAppender();
		IEObjectRegion root = original.regionForRootEObject();
		appender.copyAndAppend(root.getPreviousHiddenRegion(), PREVIOUS);
		appender.copyAndAppend(root.getPreviousHiddenRegion(), CONTAINER);
		List<Rewrite> rws = createList();
		IHiddenRegion last = null;
		for (Rewrite rw : rws) {
			boolean diff = rw.isDiff();
			if (diff) {
				appender.beginDiff();
			}
			if (rw instanceof Insert) {
				Insert ins = (Insert) rw;
				IHiddenRegion f = ins.getInsertFirst();
				IHiddenRegion l = ins.getInsertLast();
				appender.copyAndAppend(f, NEXT);
				if (f != l) {
					appender.copyAndAppend(f.getNextSemanticRegion(), l.getPreviousSemanticRegion());
				}
				appender.copyAndAppend(l, PREVIOUS);
			}
			if (diff) {
				appender.endDiff();
			}
			if (rw.originalLast != last) {
				appender.copyAndAppend(rw.originalLast, CONTAINER);
			}
			last = rw.originalLast;
		}
		appender.copyAndAppend(root.getNextHiddenRegion(), NEXT);
		StringBasedTextRegionAccessDiff result = appender.finish();
		AbstractEObjectRegion newRoot = result.regionForEObject(root.getSemanticElement());
		result.setRootEObject(newRoot);
		return result;
	}

	protected StringBasedTextRegionAccessDiffAppender createAppender() {
		return new StringBasedTextRegionAccessDiffAppender(original, changes);
	}

	@Override
	public ITextRegionAccess getOriginalTextRegionAccess() {
		return original;
	}

	@Override
	public boolean isModified(ITextRegion region) {
		int offset = region.getOffset();
		int endOffset = offset + region.getLength();
		for (Rewrite action : rewrites) {
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
		checkOriginal(insertAt);
		checkOriginal(substituteFirst);
		checkOriginal(substituteLast);
		MoveSource source = new MoveSource(substituteFirst, substituteLast);
		MoveTarget target = new MoveTarget(insertAt, source);
		rewrites.add(source);
		rewrites.add(target);
	}

	@Override
	public void remove(IHiddenRegion first, IHiddenRegion last) {
		checkOriginal(first);
		checkOriginal(last);
		rewrites.add(new Remove(first, last));
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
		rewrites.add(new Replace1(originalFirst, originalLast, modifiedFirst, modifiedLast));
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
		changes.put(region, newText);
	}

	@Override
	public ISequenceAcceptor replaceSequence(IHiddenRegion originalFirst, IHiddenRegion originalLast,
			ISerializationContext ctx, EObject root) {
		checkOriginal(originalFirst);
		checkOriginal(originalLast);
		TextRegionAccessBuildingSequencer sequenceAcceptor = new TextRegionAccessBuildingSequencer();
		rewrites.add(new Replace2(originalFirst, originalLast, sequenceAcceptor));
		return sequenceAcceptor.withRoot(ctx, root);
	}

	@Override
	public String toString() {
		try {
			StringBasedTextRegionAccessDiff regions = create();
			return new TextRegionAccessToString().withRegionAccess(regions).toString();
		} catch (Throwable t) {
			return t.getMessage() + "\n" + Throwables.getStackTraceAsString(t);
		}
	}

}