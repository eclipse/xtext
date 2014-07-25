package org.eclipse.xtext.formatting2.internal;

import static java.lang.String.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.FormatterPreferenceKeys;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.ITextReplacement;
import org.eclipse.xtext.formatting2.ITextReplacer;
import org.eclipse.xtext.formatting2.ITextReplacerContext;
import org.eclipse.xtext.formatting2.ITextSegment;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.preferences.ITypedPreferenceValues;

import com.google.common.base.Functions;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class TextReplacerContext implements ITextReplacerContext {

	@SuppressWarnings("serial")
	protected static class TextReplacementList extends ArrayList<ITextReplacement> {

		public TextReplacementList() {
			super();
		}

		public TextReplacementList(Collection<? extends ITextReplacement> initial) {
			super(initial);
		}

		@Override
		public String toString() {
			return new RegionsToString<ITextReplacement>().apply(this);
		}
	}

	private boolean autowrap = false;
	private boolean canAutowrap = false;
	private final IFormattableDocument document;
	private final int indentation;
	private final ITextReplacerContext previous;
	private TextSegmentSet<ITextReplacement> replacements = null;
	private final ITextReplacer replacer;
	private boolean nextReplacerIsChild = false;

	public void setNextReplacerIsChild() {
		this.nextReplacerIsChild = true;
	}

	public TextReplacerContext(IFormattableDocument document) {
		this(document, null, 0, null);
	}

	protected TextReplacerContext(IFormattableDocument document, ITextReplacerContext previous, int indentation,
			ITextReplacer replacer) {
		super();
		this.document = document;
		this.indentation = indentation;
		this.previous = previous;
		this.replacer = replacer;
		this.replacements = createTextReplacementsSet();
	}

	public boolean canAutowrap() {
		return canAutowrap;
	}

	protected TextSegmentSet<ITextReplacement> createTextReplacementsSet() {
		return new ArrayListTextSegmentSet<ITextReplacement>(Functions.<ITextReplacement> identity());
	}

	public IFormattableDocument getDocument() {
		return document;
	}

	public AbstractFormatter2 getFormatter() {
		return document.getFormatter();
	}

	public int getIndentation() {
		return this.indentation;
	}

	public int getLeadingCharsInLineCount() {
		ITextRegionAccess access = getDocument().getRequest().getTextRegionAccess();
		int lastOffset = replacer.getRegion().getOffset();
		ITextReplacerContext current = this;
		int count = 0;
		while (current != null) {
			List<ITextReplacement> localReplacements = Lists.newArrayList(current.getLocalReplacements());
			for (int i = localReplacements.size() - 1; i >= 0; i--) {
				ITextReplacement rep = localReplacements.get(i);
				int endOffset = rep.getEndOffset();
				if (endOffset > lastOffset) {
					//					System.out.println("error");
					continue;
				}
				String between = access.getText(endOffset, lastOffset - endOffset);
				int idx = between.lastIndexOf('\n');
				if (idx >= 0)
					return count + logicalLenght(between.substring(idx + 1));
				count += logicalLenght(between);
				String text = rep.getReplacementText();
				int idx2 = text.lastIndexOf('\n');
				if (idx2 >= 0)
					return count + logicalLenght(text.substring(idx2 + 1));
				count += logicalLenght(text);
				lastOffset = rep.getOffset();
			}
			current = current.getPreviousContext();
		}
		String rest = access.getText(0, lastOffset);
		int idx = rest.lastIndexOf('\n');
		if (idx >= 0)
			return count + logicalLenght(rest.substring(idx + 1));
		count += lastOffset;
		return count;
	}

	public Iterable<ITextReplacement> getLocalReplacements() {
		if (replacements != null)
			return replacements;
		else
			return Collections.<ITextReplacement> emptyList();
	}

	public ITypedPreferenceValues getPreferences() {
		return document.getPreferences();
	}

	public ITextReplacerContext getPreviousContext() {
		return previous;
	}

	public List<ITextReplacement> getReplacementsUntil(ITextReplacerContext first) {
		ITextReplacerContext current = this;
		List<Iterable<ITextReplacement>> reversedReplacements = Lists.newArrayList();
		while (current != null) {
			Iterable<ITextReplacement> localReplacements = current.getLocalReplacements();
			if (!Iterables.isEmpty(localReplacements))
				reversedReplacements.add(localReplacements);
			if (current == first)
				break;
			current = current.getPreviousContext();
		}
		Collections.reverse(reversedReplacements);
		List<ITextReplacement> flattenedReplacements = Lists.newArrayListWithCapacity(reversedReplacements.size());
		for (Iterable<ITextReplacement> chunk : reversedReplacements)
			Iterables.addAll(flattenedReplacements, chunk);
		return flattenedReplacements;
	}

	public ITextReplacer getReplacer() {
		return replacer;
	}

	public Throwable getTrace(ITextReplacement replacement) {
		return this.replacements != null ? replacements.getTraces().get(replacement) : null;
	}

	public boolean isAutowrap() {
		return autowrap;
	}

	protected boolean isInRequestedRange(ITextReplacement repl) {
		for (org.eclipse.xtext.util.ITextRegion region : document.getRequest().getRegions())
			if (region.getOffset() <= repl.getOffset() && region.getOffset() + region.getLength() > repl.getEndOffset())
				return true;
		return false;
	}

	public boolean isInsideFormattedRegion() {
		return true; // TODO: implement
	}

	protected int logicalLenght(String text) {
		ITypedPreferenceValues preferences = getDocument().getRequest().getPreferences();
		String indentation = preferences.getPreference(FormatterPreferenceKeys.indentation);
		if (!"\t".equals(indentation))
			return text.length();
		int indentationLength = preferences.getPreference(FormatterPreferenceKeys.indentationLength);
		int length = 0;
		for (int i = 0; i < text.length(); i++)
			if (text.charAt(i) == '\t')
				length += indentationLength;
			else
				length++;
		return length;
	}

	public void replaceText(CharSequence text) {
		Preconditions.checkNotNull(replacer);
		ITextSegment region = replacer.getRegion();
		replaceText(region.getOffset(), region.getLength(), text);
	}

	public void replaceText(int offset, int lenght, CharSequence text) {
		Preconditions.checkNotNull(text);
		ITextReplacement replacement = document.getFormatter().createTextReplacement(offset, lenght, text.toString());
		replaceText(replacement);
	}

	public void replaceText(ITextReplacement replacement) {
		Preconditions.checkNotNull(replacer);
		if (!replacer.getRegion().contains(replacement)) {
			document.getRequest().getProblemHandler().reportOutsideOfRegion(this, replacement);
			return;
		}
		if (!isInRequestedRange(replacement)) {
			return;
		}
		List<ITextReplacement> conflicting = replacements.add(replacement);
		if (!conflicting.isEmpty()) {
			document.getRequest().getProblemHandler().reportMergeConflict(this, conflicting);
			return;
		}
	}

	public void replaceText(ITextSegment region, CharSequence text) {
		replaceText(region.getOffset(), region.getLength(), text);
	}

	public void setAutowrap(boolean value) {
		this.autowrap = value;
		this.replacements = createTextReplacementsSet();
	}

	public void setCanAutowrap(boolean value) {
		this.canAutowrap = value;
	}

	@Override
	public String toString() {
		TextReplacerContext current = this;
		List<String> lines = Lists.newArrayList();
		for (int i = 0; current != null; i++) {
			if (i > 15) {
				lines.add("(...)");
				break;
			}
			lines.add(current.toStringLocal());
			current = (TextReplacerContext) current.getPreviousContext();
		}
		return Joiner.on('\n').join(Lists.reverse(lines));
	}

	protected String toStringLocal() {
		List<String> items = Lists.newArrayList();
		if (autowrap)
			items.add("autowrap");
		if (canAutowrap)
			items.add("canAutowrap");
		if (replacer != null) {
			ITextSegment region = replacer.getRegion();
			items.add(format("replacer=[%d-%d-%s|%s]", region.getOffset(), region.getLength(), replacer.getClass()
					.getSimpleName(), replacer.toString()));
		}
		if (replacements != null)
			for (ITextReplacement r : replacements) {
				String fmt = "replacement=[%d-%d|%s]";
				items.add(format(fmt, r.getOffset(), r.getLength(), r.getText(), r.getReplacementText()));
			}
		return Joiner.on("; ").join(items);
	}

	public ITextReplacerContext withDocument(IFormattableDocument document) {
		TextReplacerContext context = new TextReplacerContext(document, this, indentation, null);
		if (this.nextReplacerIsChild)
			context.setNextReplacerIsChild();
		return context;
	}

	public ITextReplacerContext withIndentation(int indentation) {
		return new TextReplacerContext(document, this, indentation, null);
	}

	public ITextReplacerContext withReplacer(ITextReplacer replacer) {
		ITextReplacerContext current = this;
		while (current != null) {
			ITextReplacer lastReplacer = current.getReplacer();
			if (lastReplacer != null) {
				if (nextReplacerIsChild) {
					Preconditions.checkArgument(lastReplacer.getRegion().contains(replacer.getRegion()));
				} else {
					Preconditions.checkArgument(lastReplacer.getRegion().getEndOffset() <= replacer.getRegion()
							.getOffset());
				}
				break;
			}
			current = current.getPreviousContext();
		}
		return new TextReplacerContext(document, this, indentation, replacer);
	}
}
