package org.eclipse.xpect.text;

import java.util.List;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

public abstract class Canvas implements ICanvas {

	protected static class RenderContext implements IRenderContext {
		private int columns;
		private int left;
		private int lines;
		private final Canvas parent;
		private int top;

		protected RenderContext(Canvas parent) {
			super();
			this.parent = parent;
			this.lines = parent.getLineCount();
			this.columns = parent.getColumnCount();
		}

		public IRenderContext at(int line, int column) {
			int parentLines = parent.getLineCount();
			int parentColumns = parent.getColumnCount();
			Preconditions.checkArgument(line >= 0);
			Preconditions.checkArgument(column >= 0);
			Preconditions.checkArgument(line < parentLines);
			Preconditions.checkArgument(column < parentColumns);
			this.top = line;
			this.left = column;
			this.lines = Math.min(parentLines - line, this.lines);
			this.columns = Math.min(parentColumns - column, this.columns);
			return this;
		}

		public void fill(Object value) {
			List<String> block = TextBlock.get(value).getLines();
			char background = parent.getBackground();
			int blockLenght = 0;
			for (String b : block) {
				int l = b.length();
				if (l > blockLenght)
					blockLenght = l;
			}
			List<String> padded = Lists.newArrayList();
			for (String b : block) {
				StringBuilder chunk = new StringBuilder(blockLenght);
				chunk.append(b);
				while (chunk.length() < blockLenght)
					chunk.append(background);
				StringBuilder line = new StringBuilder(this.columns);
				while (line.length() < this.columns)
					line.append(chunk);
				padded.add(line.toString());
			}
			List<String> full = Lists.newArrayList();
			while (full.size() < this.lines)
				full.addAll(padded);
			parent.print(top, left, lines, columns, full);
		}

		public ICanvas newSubCanvas() {
			return new SubCanvas(parent, top, left, columns, lines);
		}

		public void print(Object value) {
			ITextBlock block = TextBlock.get(value);
			parent.print(top, left, lines, columns, block.getLines());
		}

		public IRenderContext withBounds(int maxLines, int maxColumns) {
			Preconditions.checkArgument(maxLines > 0);
			Preconditions.checkArgument(maxColumns > 0);
			Preconditions.checkArgument(maxLines + top <= parent.getLineCount());
			Preconditions.checkArgument(maxColumns + left <= parent.getColumnCount());
			this.lines = maxLines;
			this.columns = maxColumns;
			return this;
		}

	}

	protected static class RootCanvas extends Canvas {
		private final Character background;
		private final List<StringBuilder> document = Lists.newArrayList();
		private final String lineSeparator;

		protected RootCanvas() {
			this(' ');
		}

		protected RootCanvas(Character background) {
			this(background, "\n");
		}

		protected RootCanvas(Character background, String lineSeparator) {
			super();
			this.background = background;
			this.lineSeparator = lineSeparator;
		}

		@Override
		protected char getBackground() {
			return background;
		}

		protected void print(int line, int column, int maxLines, int maxColumns, List<String> strings) {
			int lineCount = Math.min(strings.size(), maxLines);
			for (int i = document.size(); i < line + lineCount; i++)
				document.add(new StringBuilder());
			for (int i = 0; i < lineCount; i++) {
				StringBuilder l = document.get(line + i);
				String s = strings.get(i);
				if (s.length() > maxColumns)
					s = s.substring(0, maxColumns);
				int length = l.length();
				int end = column + s.length();
				if (length < end)
					l.setLength(end);
				for (int j = length; j < column; j++)
					l.setCharAt(j, background);
				l.replace(column, end, s);
			}
		}

		@Override
		public String toString() {
			return Joiner.on(lineSeparator).join(document);
		}

	}

	protected static class SubCanvas extends Canvas {
		private final int columns;
		private final int left;
		private final int lines;
		private final Canvas parent;
		private final int top;

		protected SubCanvas(Canvas parent, int top, int left, int columns, int rows) {
			super();
			this.parent = parent;
			this.top = top;
			this.left = left;
			this.columns = columns;
			this.lines = rows;
		}

		@Override
		protected char getBackground() {
			return parent.getBackground();
		}

		public int getColumnCount() {
			return columns;
		}

		public int getLineCount() {
			return lines;
		}

		public ICanvas newSubCanvas() {
			return new SubCanvas(parent, top, left, columns, lines);
		}

		@Override
		protected void print(int line, int column, int maxLines, int maxColumns, List<String> strings) {
			parent.print(line + top, column + left, maxLines, maxColumns, strings);
		}

	}

	public static ICanvas create() {
		return new RootCanvas();
	}

	public static ICanvas create(char backgroud) {
		return new RootCanvas(backgroud);
	}

	public static ICanvas create(char backgroud, String lineSeparator) {
		return new RootCanvas(backgroud, lineSeparator);
	}

	public IRenderContext at(int line, int column) {
		return new RenderContext(this).at(line, column);
	}

	public void fill(Object value) {
		new RenderContext(this).fill(value);
	}

	protected abstract char getBackground();

	public int getColumnCount() {
		return Integer.MAX_VALUE;
	}

	public int getLineCount() {
		return Integer.MAX_VALUE;
	}

	public ICanvas newSubCanvas() {
		return new SubCanvas(this, 0, 0, Integer.MAX_VALUE, Integer.MAX_VALUE);
	}

	protected abstract void print(int line, int column, int maxLines, int maxColumns, List<String> strings);

	public void print(Object value) {
		new RenderContext(this).print(value);
	}

	public IRenderContext withBounds(int maxLines, int maxColumns) {
		return new RenderContext(this).withBounds(maxLines, maxColumns);
	}

}
