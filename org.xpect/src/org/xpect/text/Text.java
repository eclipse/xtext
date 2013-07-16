package org.xpect.text;

import java.util.Collection;
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

	private final String text;

	public Text(String text) {
		super();
		if (Strings.isEmpty(text))
			throw new NullPointerException();
		this.text = text;
	}

	public String with(IPatch patch) {
		List<IReplacement> replacements = Lists.newArrayList();
		Stack<IPatch> patches = new Stack<IPatch>();
		patches.push(patch);
		while (!patches.isEmpty()) {
			IPatch p = patches.pop();
			for (IChange c : p.getChanges())
				if (c instanceof IPatch)
					patches.push((IPatch) c);
				else if (c instanceof IReplacement)
					replacements.add((IReplacement) c);
		}
		return with(replacements);
	}

	public String with(Collection<IReplacement> replacements) {
		if (replacements.isEmpty())
			return text;
		Set<IReplacement> sortedReplacements = Sets.newTreeSet(new RegionOffsetComparator());
		for (IReplacement rep : replacements)
			if (!sortedReplacements.add(rep))
				throw new IllegalStateException("Multiple replacements for same offset");
		int last = 0;
		StringBuilder result = new StringBuilder();
		for (IReplacement rep : sortedReplacements) {
			if (rep.getOffset() < last)
				throw new IllegalStateException("Overlapping replacements");
			result.append(text.substring(last, rep.getOffset()));
			result.append(rep.getReplacement());
			last = rep.getOffset() + rep.getLength();
		}
		if (last < text.length())
			result.append(text.substring(last));
		return result.toString();
	}

	public String getText() {
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

}
