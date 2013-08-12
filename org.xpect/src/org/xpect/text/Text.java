package org.xpect.text;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.eclipse.xtext.util.Strings;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * 
 * @author Moritz Eysholdt
 */
public class Text {

	private final CharSequence text;

	public Text(CharSequence text) {
		super();
		if (text == null || text.length() == 0)
			throw new NullPointerException();
		this.text = text;
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

	public CharSequence getText() {
		return text;
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
