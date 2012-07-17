package org.eclipse.xpect.parameters;

import org.eclipse.xtext.util.Strings;

import com.google.common.base.Joiner;

public class AbstractExpectation {
	private final String document;
	private final int length;
	private final int offset;

	public AbstractExpectation(String document, int offset, int lenght) {
		super();
		this.document = document;
		this.offset = offset;
		this.length = lenght;
	}

	public int getLength() {
		return length;
	}

	public int getOffset() {
		return offset;
	}

	protected String getExpectation(String indentation) {
		String[] lines = document.substring(offset, offset + length).split("\\n");
		if (lines.length == 1)
			return lines[0];
		else {
			String newLines[] = new String[lines.length];
			for (int i = 0; i < lines.length; i++)
				if (lines[i].startsWith(indentation))
					newLines[i] = lines[i].substring(indentation.length());
				else
					newLines[i] = lines[i];
			return Joiner.on("\n").join(newLines);
		}
	}

	protected String replaceInDocument(String indentation, String value) {
		String indented;
		if (!Strings.isEmpty(indentation))
			indented = indentation + value.replace("\n", "\n" + indentation);
		else
			indented = value;
		String before = document.substring(0, offset);
		String after = document.substring(offset + length, document.length());
		return before + indented + after;
	}

	protected String getIndentation() {
		int nl = document.lastIndexOf("\n", offset);
		if (nl < 0)
			nl = 0;
		StringBuilder result = new StringBuilder();
		for (int i = nl + 1; i < document.length() && Character.isWhitespace(document.charAt(i)); i++)
			result.append(document.charAt(i));
		return result.toString();
	}
}