package org.xpect.doc.doclet;

import java.util.Collections;
import java.util.List;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

public abstract class Text {

	public static class Line extends Text {
		private final String line;

		public String getLine() {
			return line;
		}

		public Line(String line) {
			super();
			this.line = line;
		}

		@Override
		public List<String> getLines(int depth) {
			return Collections.singletonList(line);
		}

	}

	public static class Paragraph extends Text {
		protected final List<Text> lines = Lists.newArrayList();

		public void add(Text text) {
			lines.add(text);
		}

		public void add(Iterable<?> text) {
			for (Object s : text)
				if (s instanceof String)
					add((String) s);
				else if (s instanceof Text)
					add((Text) s);
		}

		public void add(String text) {
			add(new Line(text));
		}

		@Override
		public List<String> getLines(int depth) {
			List<String> result = Lists.newArrayList();
			for (Text t : lines)
				result.addAll(t.getLines(depth + 1));
			return result;
		}
	}

	public static class Chapter extends Paragraph {
		private final String title;

		public Chapter(String title) {
			super();
			this.title = title;
		}

		@Override
		public List<String> getLines(int depth) {
			List<String> result = Lists.newArrayList();
			result.add("<h" + depth + ">" + title + "</h" + depth + ">");
			for (Text t : lines)
				result.addAll(t.getLines(depth + 1));
			return result;
		}
	}

	@Override
	public String toString() {
		return Joiner.on('\n').join(getLines(1));
	}

	public abstract List<String> getLines(int depth);
}
