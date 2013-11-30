package org.xpect.text;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.eclipse.xtext.util.Strings;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * 
 * @author Moritz Eysholdt
 */
public class Text {

	private String nl;

	private final CharSequence text;

	public Text(CharSequence text) {
		Preconditions.checkNotNull(text);
		this.text = text;
	}

	public char charAt(int c) {
		return text.charAt(c);
	}

	public int currentLineEnd(int offset) {
		int nl = indexOf('\n', offset);
		if (nl > 0)
			return text.charAt(nl - 1) == '\r' ? nl - 1 : nl;
		return nl;
	}

	public int currentLineStart(int offset) {
		return lastIndexOf('\n', offset) + 1;
	}

	protected String determineNL() {
		boolean lastIsR = false;
		for (int i = 0; i < text.length(); i++)
			switch (text.charAt(i)) {
			case '\r':
				lastIsR = true;
				break;
			case '\n':
				return lastIsR ? "\r\n" : "\n";
			default:
				lastIsR = false;
			}
		return "\n";
	}

	public String escapeNewLines() {
		return text.toString().replace("\n", "\\n").replace("\r", "\\r");
	}

	public String findIndentation(int offset) {
		int nl = text.toString().lastIndexOf("\n", offset);
		if (nl < 0)
			nl = 0;
		StringBuilder result = new StringBuilder();
		for (int i = nl + 1; i < text.length() && Character.isWhitespace(text.charAt(i)) && text.charAt(i) != '\n'; i++)
			result.append(text.charAt(i));
		return result.toString();
	}

	public String findIndentation(String prefix, int offset) {
		prefix = trimRight(prefix);
		int nl = text.toString().lastIndexOf("\n", offset);
		if (nl < 0)
			nl = 0;
		StringBuilder result = new StringBuilder();
		if (text.subSequence(nl + 1, nl + 1 + prefix.length()).toString().equals(prefix)) {
			result.append(prefix);
			nl += prefix.length();
		}
		for (int i = nl + 1; i < text.length() && Character.isWhitespace(text.charAt(i)) && text.charAt(i) != '\n'; i++)
			result.append(text.charAt(i));
		return result.toString();
	}

	public String getNL() {
		if (nl == null)
			nl = determineNL();
		return nl;
	}

	public CharSequence getText() {
		return text;
	}

	public String indentWith(String indentation) {
		return text.toString().replace("\n", "\n" + indentation);
	}

	public int indexOf(char c, int fromIndex) {
		return text.toString().indexOf(c, fromIndex);
	}

	public int indexOf(String str, int fromIndex) {
		return text.toString().indexOf(str, fromIndex);
	}

	public boolean isMultiline() {
		return indexOf('\n', 0) >= 0;
	}

	public int lastIndexOf(char c, int fromIndex) {
		return text.toString().lastIndexOf(c, fromIndex);
	}

	public int length() {
		return text.length();
	}

	public int nextLineStart(int offset) {
		return indexOf('\n', offset) + 1;
	}

	public int previousLineEnd(int offset) {
		int nl = lastIndexOf('\n', offset);
		if (nl > 0)
			return text.charAt(nl - 1) == '\r' ? nl - 1 : nl;
		return nl;
	}

	public int previousLineStart(int offset) {
		int prevEnd = previousLineEnd(offset);
		return currentLineStart(prevEnd - 1);
	}

	public IReplacement replacementTo(String other) {
		if (Strings.isEmpty(other))
			return null;
		int prefix = 0;
		while (text.charAt(prefix) == other.charAt(prefix)) {
			prefix++;
			if (prefix >= text.length() || prefix >= other.length())
				return null;
		}
		int suffix = 1;
		while (text.charAt(text.length() - suffix) == other.charAt(other.length() - suffix)) {
			suffix++;
			if (suffix > text.length() || suffix > other.length())
				return null;
		}
		int length = text.length() - prefix - suffix + 1;
		int endIndex = other.length() - suffix + 1;
		String replacement = prefix < endIndex ? other.substring(prefix, endIndex) : "";
		return new Replacement(prefix, length, replacement);
	}

	public List<String> splitIntoLines() {
		// ... because string.split() ignores trailing whitespace (wtf!)
		List<String> result = Lists.newArrayList();
		String document = text.toString();
		int index, lastIndex = 0;
		while ((index = document.indexOf('\n', lastIndex)) >= 0) {
			int end = index > 0 && document.charAt(index - 1) == '\r' ? index - 1 : index;
			result.add(document.substring(lastIndex, end));
			lastIndex = index + 1;
		}
		result.add(document.substring(lastIndex, document.length()));
		return ImmutableList.copyOf(result);
	}

	public String substring(int beginIndex, int endIndex) {
		return text.toString().substring(beginIndex, endIndex);
	}

	@Override
	public String toString() {
		return text.toString();
	}

	protected String trimRight(String str) {
		int i = str.length() - 1;
		while (i >= 0 && Character.isWhitespace(str.charAt(i)))
			i--;
		return str.substring(0, i + 1);
	}

	public String with(Collection<IReplacement> replacements) {
		if (replacements.isEmpty())
			return text.toString();
		Set<IReplacement> sortedReplacements = Sets.newTreeSet(new RegionOffsetComparator());
		for (IReplacement rep : replacements)
			if (!sortedReplacements.add(rep))
				throw new IllegalStateException("Multiple replacements for same offset");
		int last = 0;
		StringBuilder result = new StringBuilder();
		for (IReplacement rep : sortedReplacements) {
			if (rep.getOffset() < last)
				throw new IllegalStateException("Overlapping replacements");
			result.append(text.toString().substring(last, rep.getOffset()));
			result.append(rep.getReplacement());
			last = rep.getOffset() + rep.getLength();
		}
		if (last < text.length())
			result.append(text.toString().substring(last));
		return result.toString();
	}

	public String with(IChange change) {
		if (change instanceof IPatch) {
			List<IReplacement> replacements = Lists.newArrayList();
			Stack<IPatch> patches = new Stack<IPatch>();
			patches.push((IPatch) change);
			while (!patches.isEmpty()) {
				IPatch p = patches.pop();
				for (IChange c : p.getChanges())
					if (c instanceof IPatch)
						patches.push((IPatch) c);
					else if (c instanceof IReplacement)
						replacements.add((IReplacement) c);
			}
			return with(replacements);
		} else if (change instanceof IReplacement) {
			return with(Collections.singleton((IReplacement) change));
		}
		throw new IllegalStateException();
	}

}
