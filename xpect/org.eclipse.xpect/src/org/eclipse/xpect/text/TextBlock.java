package org.eclipse.xpect.text;

import java.util.Arrays;
import java.util.List;

import org.eclipse.xtext.util.Strings;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

public class TextBlock implements ITextBlock {

	private static void collectLines(Object obj, List<String> lines) {
		if (obj == null) {
			lines.add("(null)");
		} else if (obj instanceof Iterable<?>) {
			for (Object o : ((Iterable<?>) obj))
				collectLines(o, lines);
		} else {
			lines.addAll(new Text(obj.toString()).splitIntoLines());
		}
	}

	public static ITextBlock get(Object obj) {
		if (obj instanceof ITextBlock)
			return (ITextBlock) obj;
		List<String> lines = Lists.newArrayList();
		collectLines(obj, lines);
		if (lines.isEmpty())
			return ITextBlock.EMPTY;
		for (String line : lines)
			if (!Strings.isEmpty(line))
				return new TextBlock(lines.toArray(new String[lines.size()]));
		return ITextBlock.EMPTY;
	}

	private final String[] lines;

	private TextBlock(String[] lines) {
		super();
		this.lines = lines;
	}

	public List<String> getLines() {
		return Arrays.asList(lines);
	}

	@Override
	public String toString() {
		return Joiner.on('\n').join(lines);
	}

}
