/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.lib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class StringConcatenation implements CharSequence {

	public static final String DEFAULT_LINE_DELIMITER = System.getProperty("line.separator");
	
	private final List<String> segments;
	
	private int length;

	private final String lineDelimiter;
	
	public StringConcatenation() {
		this(DEFAULT_LINE_DELIMITER);
	}
	
	public StringConcatenation(String lineDelimiter) {
		this.lineDelimiter = lineDelimiter;
		segments = new ArrayList<String>(50);
		length = 0;
	}
	
	public void append(Object object) {
		if (object == null)
			return;
		if (object instanceof StringConcatenation) {
			segments.addAll(((StringConcatenation) object).segments);
			length += ((StringConcatenation) object).length;
			return;
		}
		String value = object.toString();
		List<String> newSegments = splitLinesAndNewLines(value);
		for(String newSegment: newSegments) {
			segments.add(newSegment);
			length += newSegment.length();
		}
	}
	
	public void append(Object object, String indentation) {
		if (indentation.length() == 0) {
			append(object);
			return;
		}
		if (object == null)
			return;
		if (object instanceof StringConcatenation) {
			List<String> otherSegments = ((StringConcatenation) object).segments;
			appendSegments(indentation, otherSegments);
			return;
		}
		String value = object.toString();
		List<String> newSegments = splitLinesAndNewLines(value);
		appendSegments(indentation, newSegments);
	}

	protected void appendSegments(String indentation, List<String> otherSegments) {
		for(String otherSegment: otherSegments) {
			segments.add(otherSegment);
			if (lineDelimiter.equals(otherSegment))
				segments.add(indentation);
		}
	}
	
	public void newLine() {
		segments.add(lineDelimiter);
	}
	
	public void newLineIfNotEmpty() {
		for(int i = segments.size() - 1; i >= 0; i--) {
			String segment = segments.get(i);
			if (lineDelimiter.equals(segment)) {
				segments.subList(i + 1, segments.size()).clear();
				return;
			}
			for(int j = 0; j < segment.length(); j++) {
				if (!Character.isWhitespace(segment.charAt(j))) {
					newLine();
					return;
				}
			}
		}
		
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(length);
		for(String segment: segments)
			builder.append(segment);
		return builder.toString();
	}

	public int length() {
		return length;
	}

	public char charAt(int index) {
		throw new UnsupportedOperationException();
	}

	public CharSequence subSequence(int start, int end) {
		throw new UnsupportedOperationException();
	}

	public List<String> splitLinesAndNewLines(String text) {
		if (text == null)
			return Collections.emptyList();
		List<String> result = new ArrayList<String>(5);
		int length= text.length();
		int nextLineOffset = 0;
		int idx = 0;
		while(idx < length) {
			char currentChar = text.charAt(idx);
			// check for \r or \r\n
			if (currentChar == '\r') {
				int delimiterLength = 1;
				if (idx + 1 < length && text.charAt(idx + 1) == '\n') {
					delimiterLength++;
					idx++;
				}
				int lineLength = idx - delimiterLength - nextLineOffset + 1;
				result.add(text.substring(nextLineOffset, nextLineOffset+ lineLength));
				result.add(lineDelimiter);
				nextLineOffset = idx + 1;
			} else if (currentChar == '\n') {
				int lineLength = idx - nextLineOffset;
				result.add(text.substring(nextLineOffset, nextLineOffset+ lineLength));
				result.add(lineDelimiter);
				nextLineOffset = idx + 1;
			}
			idx++;
		}
		if (nextLineOffset != length) {
			int lineLength = length - nextLineOffset;
			result.add(text.substring(nextLineOffset, nextLineOffset+ lineLength));
		}
		return result;
	}
}
