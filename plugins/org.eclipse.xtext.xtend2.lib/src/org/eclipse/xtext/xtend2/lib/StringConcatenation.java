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
 * <p>
 * A {@link StringConcatenation} allows for efficient, indentation aware concatenation of character sequences.
 * </p>
 * <p>
 * In addition to the methods that are specified by the implemented interface {@link CharSequence}, there are some other
 * public operations that allow to modify the contents of this sequence. The string representation of arbitrary objects
 * can be appended to an instance of {@link StringConcatenation}. There are overloaded variants of
 * {@link #append(Object, String)} that allow to pass an indentation that should be applied to each line of the appended
 * content. Each line break that is part of the new content will be replaced by the line delimiter that was configured
 * for this {@link StringConcatenation}.
 * </p>
 * <p>
 * The {@link #append(Object) append}-operation ignores <code>null</code> arguments. This is different to what
 * {@link StringBuffer} or {@link StringBuilder} do and that's the reason why the {@link Appendable} interface is not
 * fulfilled by a {@link StringConcatenation}.
 * <p>
 * <p>
 * The object uses an internal {@link List} of {@link String Strings} that is concatenated on demand to a complete
 * sequence. Use {@link #toString()} to get the joined version of a {@link StringConcatenation}.
 * </p>
 * <p>
 * {@link #equals(Object)} and {@link #hashCode()} are not specialized for a {@link StringConcatenation}, that is, the
 * semantics are based on identity similar to what {@link StringBuffer} and {@link StringBuilder} do.
 * </p>
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
/**
 * @deprecated use org.eclipse.xtend2.lib.StringConcatenation from bundle org.eclipse.xtend2.lib
 */
@Deprecated
public class StringConcatenation implements CharSequence {

	/**
	 * The default line delimiter that is used by instances of {@link StringConcatenation}. It uses
	 * <code>System.getProperty("line.separator")</code>.
	 */
	public static final String DEFAULT_LINE_DELIMITER = System.getProperty("line.separator");

	/**
	 * The complete content of this sequence. It may content insignificant trailing parts that are not part of the final
	 * string representation that can be obtained by {@link #toString()}. Insignificant parts will not be considered by
	 * {@link #length()}, {@link #charAt(int)} or {@link #subSequence(int, int)}.
	 */
	private final List<String> segments;

	/**
	 * A cached string representation.
	 */
	private String cachedToString;

	/**
	 * The configured delimiter. It will be used to replace possibly existing delimiters of to-be-appended content.
	 */
	private final String lineDelimiter;

	/**
	 * Create a new concatenation that uses the system line delimiter.
	 * 
	 * @see System#getProperties()
	 * @see System#getProperty(String)
	 */
	public StringConcatenation() {
		this(DEFAULT_LINE_DELIMITER);
	}

	/**
	 * Create a new concatenation with the specified delimiter.
	 * 
	 * @param lineDelimiter
	 *            the used delimiter.
	 * @throws IllegalArgumentException
	 *             if the lineDelimiter is <code>null</code> or the empty String.
	 */
	public StringConcatenation(String lineDelimiter) {
		if (lineDelimiter == null || lineDelimiter.length() == 0)
			throw new IllegalArgumentException("lineDelimiter must not be null or empty");
		this.lineDelimiter = lineDelimiter;
		segments = new ArrayList<String>(50);
	}

	/**
	 * Append the string representation of the given object to this sequence. Does nothing if the object is
	 * <code>null</code>.
	 * 
	 * @param object
	 *            the to-be-appended object.
	 */
	public void append(Object object) {
		append(object, segments.size());
	}

	/**
	 * Add the string representation of the given object to this sequence at the given index. Does nothing if the object
	 * is <code>null</code>.
	 * 
	 * @param object
	 *            the to-be-appended object.
	 * @param index
	 *            the index in the list of segments.
	 */
	protected void append(Object object, int index) {
		if (object == null)
			return;
		if (object instanceof StringConcatenation) {
			segments.addAll(index, ((StringConcatenation) object).getSignificantContent());
			cachedToString = null;
			return;
		}
		String value = object.toString();
		List<String> newSegments = splitLinesAndNewLines(value);
		for (String newSegment : newSegments) {
			segments.add(index++, newSegment);
		}
		if (!newSegments.isEmpty())
			cachedToString = null;
	}

	/**
	 * Add the string representation of the given object to this sequence. The given indentation will be prepended to
	 * each line except the first one if the object has a multi-line string representation.
	 * 
	 * @param object
	 *            the appended object.
	 * @param indentation
	 *            the indentation string that should be prepended. May not be <code>null</code>.
	 */
	public void append(Object object, String indentation) {
		append(object, indentation, segments.size());
	}

	/**
	 * Add the string representation of the given object to this sequence at the given index. The given indentation will
	 * be prepended to each line except the first one if the object has a multi-line string representation.
	 * 
	 * @param object
	 *            the to-be-appended object.
	 * @param indentation
	 *            the indentation string that should be prepended. May not be <code>null</code>.
	 * @param index
	 *            the index in the list of segments.
	 */
	protected void append(Object object, String indentation, int index) {
		if (indentation.length() == 0) {
			append(object, index);
			return;
		}
		if (object == null)
			return;
		if (object instanceof StringConcatenation) {
			StringConcatenation other = (StringConcatenation) object;
			List<String> otherSegments = other.getSignificantContent();
			appendSegments(indentation, index, otherSegments, other.lineDelimiter);
			return;
		}
		String value = object.toString();
		List<String> newSegments = splitLinesAndNewLines(value);
		appendSegments(indentation, index, newSegments, lineDelimiter);
	}

	/**
	 * Add the string representation of the given object to this sequence immediately. That is, all the trailing
	 * whitespace of this sequence will be ignored and the string is appended directly after the last segment that
	 * contains something besides whitespace. The given indentation will be prepended to each line except the first one
	 * if the object has a multi-line string representation.
	 * 
	 * @param object
	 *            the to-be-appended object.
	 * @param indentation
	 *            the indentation string that should be prepended. May not be <code>null</code>.
	 */
	public void appendImmediate(Object object, String indentation) {
		for (int i = segments.size() - 1; i >= 0; i--) {
			String segment = segments.get(i);
			for (int j = 0; j < segment.length(); j++) {
				if (!Character.isWhitespace(segment.charAt(j))) {
					append(object, indentation, i + 1);
					return;
				}
			}
		}
		append(object, indentation, 0);
	}

	/**
	 * Add the list of segments to this sequence at the given index. The given indentation will be prepended to each
	 * line except the first one if the object has a multi-line string representation.
	 * 
	 * @param indentation
	 *            the indentation string that should be prepended. May not be <code>null</code>.
	 * @param index
	 *            the index in this instance's list of segments.
	 * @param otherSegments
	 *            the to-be-appended segments. May not be <code>null</code>.
	 * @param otherDelimiter
	 *            the line delimiter that was used in the otherSegments list.
	 */
	protected void appendSegments(String indentation, int index, List<String> otherSegments, String otherDelimiter) {
		for (String otherSegment : otherSegments) {
			if (otherDelimiter.equals(otherSegment)) {
				segments.add(index++, lineDelimiter);
				segments.add(index++, indentation);
			} else {
				segments.add(index++, otherSegment);
			}
		}
		if (!otherSegments.isEmpty())
			cachedToString = null;
	}

	/**
	 * Add a newline to this sequence according to the configured {@link #lineDelimiter}.
	 */
	public void newLine() {
		segments.add(lineDelimiter);
		cachedToString = null;
	}

	/**
	 * Add a newline to this sequence according to the configured {@link #lineDelimiter} if the last line contains
	 * something besides whitespace.
	 */
	public void newLineIfNotEmpty() {
		for (int i = segments.size() - 1; i >= 0; i--) {
			String segment = segments.get(i);
			if (lineDelimiter.equals(segment)) {
				segments.subList(i + 1, segments.size()).clear();
				cachedToString = null;
				return;
			}
			for (int j = 0; j < segment.length(); j++) {
				if (!Character.isWhitespace(segment.charAt(j))) {
					newLine();
					return;
				}
			}
		}
		segments.clear();
		cachedToString = null;
	}

	@Override
	public String toString() {
		if (cachedToString != null) {
			return cachedToString;
		}
		List<String> significantContent = getSignificantContent();
		StringBuilder builder = new StringBuilder(significantContent.size() * 4);
		for (String segment : significantContent)
			builder.append(segment);
		cachedToString = builder.toString();
		return cachedToString;
	}

	/**
	 * Compute the significant content of this sequence. That is, trailing whitespace after the last line-break will be
	 * ignored if the last line contains only whitespace. The return value is unsafe, that is modification to this
	 * {@link StringConcatenation} will cause changes in a previously obtained result and vice versa.
	 * 
	 * @return the significant content of this instance. Never <code>null</code>.
	 */
	protected List<String> getSignificantContent() {
		for (int i = segments.size() - 1; i >= 0; i--) {
			String segment = segments.get(i);
			if (lineDelimiter.equals(segment)) {
				return segments.subList(0, i + 1);
			}
			for (int j = 0; j < segment.length(); j++) {
				if (!Character.isWhitespace(segment.charAt(j))) {
					return segments;
				}
			}
		}
		return segments;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * <p>
	 * Only the significant content of this sequence is considered.
	 * </p>
	 */
	public int length() {
		return toString().length();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * <p>
	 * Only the significant content of this sequence is considered.
	 * </p>
	 */
	public char charAt(int index) {
		return toString().charAt(index);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * <p>
	 * Only the significant content of this sequence is considered.
	 * </p>
	 */
	public CharSequence subSequence(int start, int end) {
		return toString().subSequence(start, end);
	}

	/**
	 * Return a list of segments where each segment is either the content of a line in the given text or a line-break
	 * according to the configured {@link #lineDelimiter}. Existing line-breaks in the text will be replaced by this's
	 * instances delimiter.
	 * 
	 * @param text
	 *            the to-be-splitted text. May be <code>null</code>.
	 * @return a list of segments. Is never <code>null</code>.
	 */
	protected List<String> splitLinesAndNewLines(String text) {
		if (text == null)
			return Collections.emptyList();
		List<String> result = new ArrayList<String>(5);
		int length = text.length();
		int nextLineOffset = 0;
		int idx = 0;
		while (idx < length) {
			char currentChar = text.charAt(idx);
			// check for \r or \r\n
			if (currentChar == '\r') {
				int delimiterLength = 1;
				if (idx + 1 < length && text.charAt(idx + 1) == '\n') {
					delimiterLength++;
					idx++;
				}
				int lineLength = idx - delimiterLength - nextLineOffset + 1;
				result.add(text.substring(nextLineOffset, nextLineOffset + lineLength));
				result.add(lineDelimiter);
				nextLineOffset = idx + 1;
			} else if (currentChar == '\n') {
				int lineLength = idx - nextLineOffset;
				result.add(text.substring(nextLineOffset, nextLineOffset + lineLength));
				result.add(lineDelimiter);
				nextLineOffset = idx + 1;
			}
			idx++;
		}
		if (nextLineOffset != length) {
			int lineLength = length - nextLineOffset;
			result.add(text.substring(nextLineOffset, nextLineOffset + lineLength));
		}
		return result;
	}

}
