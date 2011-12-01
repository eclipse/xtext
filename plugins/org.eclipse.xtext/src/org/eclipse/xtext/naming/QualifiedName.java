/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.naming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.util.Strings;

import com.google.common.base.Function;

/**
 * A datatype for dealing with qualified names. 
 * Instances are usually provided by a {@link IQualifiedNameProvider}.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class QualifiedName implements Comparable<QualifiedName> {

	private final int hash;
	
	private final String[] segments;
	
	private QualifiedName lowerCase;

	public static final QualifiedName EMPTY = new QualifiedName();

	/**
	 * Low-level factory method. Consider using a {@link IQualifiedNameConverter} instead.
	 * 
	 * @exception IllegalArgumentException
	 *                if any of the segments is null
	 */
	public static QualifiedName create(String... segments) {
		if (segments != null) {
			for (String segment : segments)
				if (segment == null) {
					throw new IllegalArgumentException("Segment cannot be null");
				}
		}
		return new QualifiedName(segments != null ? segments.clone() : Strings.EMPTY_ARRAY);
	}

	/**
	 * Wrapps a name function to return a qualified name. Returns null if the name function returns null. 
	 */
	public static <F> Function<F, QualifiedName> wrapper(final Function<F, String> nameFunction) {
		return new Function<F, QualifiedName>() {
			public QualifiedName apply(F from) {
				String name = nameFunction.apply(from);
				if (name == null)
					return null;
				return QualifiedName.create(name);
			}
		};
	}

	protected QualifiedName(String... segments) {
		if (segments == null || segments.length == 0)
			this.segments = Strings.EMPTY_ARRAY;
		else
			this.segments = segments;
		hash = Arrays.hashCode(this.segments);
	}

	public boolean isEmpty() {
		return segments.length == 0;
	}

	public List<String> getSegments() {
		return Collections.unmodifiableList(Arrays.asList(segments));
	}

	public int getSegmentCount() {
		return segments.length;
	}

	public String getSegment(int index) {
		return segments[index];
	}

	public String getLastSegment() {
		return segments[segments.length - 1];
	}

	public String getFirstSegment() {
		return segments[0];
	}

	public QualifiedName append(String segment) {
		String[] newSegments = new String[getSegmentCount() + 1];
		System.arraycopy(segments, 0, newSegments, 0, segments.length);
		newSegments[segments.length] = segment;
		return new QualifiedName(newSegments);
	}

	public QualifiedName append(QualifiedName relativeQualifiedName) {
		String[] newSegments = new String[getSegmentCount() + relativeQualifiedName.getSegmentCount()];
		for (int i = 0; i < getSegmentCount(); ++i)
			newSegments[i] = getSegment(i);
		for (int i = 0; i < relativeQualifiedName.getSegmentCount(); ++i)
			newSegments[i + getSegmentCount()] = relativeQualifiedName.getSegment(i);
		return new QualifiedName(newSegments);
	}

	public QualifiedName skipFirst(int skipCount) {
		if (skipCount == getSegmentCount()) {
			return EMPTY;
		}
		if (skipCount > getSegmentCount() || skipCount < 0) {
			throw new IllegalArgumentException("Cannot skip " + skipCount + " fragments from QualifiedName with "
					+ getSegmentCount() + " segments");
		}
		String[] newSegments = new String[segments.length - skipCount];
		System.arraycopy(segments, skipCount, newSegments, 0, newSegments.length);
		return new QualifiedName(newSegments);
	}

	public QualifiedName skipLast(int skipCount) {
		if (skipCount == getSegmentCount()) {
			return EMPTY;
		}
		if (skipCount > getSegmentCount() || skipCount < 0) {
			throw new IllegalArgumentException("Cannot skip " + skipCount + " fragments from QualifiedName with "
					+ getSegmentCount() + " segments");
		}
		String[] newSegments = new String[segments.length - skipCount];
		System.arraycopy(segments, 0, newSegments, 0, newSegments.length);
		return new QualifiedName(newSegments);
	}

	public QualifiedName toLowerCase() {
		if (lowerCase != null)
			return lowerCase;
		String[] newSegments = new String[segments.length];
		for (int i = 0; i < getSegmentCount(); ++i)
			newSegments[i] = segments[i].toLowerCase();
		lowerCase = new QualifiedName(newSegments) {
			@Override
			public QualifiedName toLowerCase() {
				return this;
			}
		};
		return lowerCase;
	}

	public QualifiedName toUpperCase() {
		String[] newSegments = new String[getSegmentCount()];
		for (int i = 0; i < getSegmentCount(); ++i)
			newSegments[i] = segments[i].toUpperCase();
		return new QualifiedName(newSegments);
	}

	@Override
	public int hashCode() {
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj==this)
			return true;
		if (obj instanceof QualifiedName) {
			QualifiedName other = (QualifiedName) obj;
			if (hash != other.hash)
				return false;
			return Arrays.equals(segments, other.segments);
		}
		return false;
	}

	public boolean equalsIgnoreCase(Object obj) {
		return obj instanceof QualifiedName && ((QualifiedName) obj).getSegmentCount() == getSegmentCount()
				&& startsWith((QualifiedName) obj, true);
	}

	public int compareTo(QualifiedName qualifiedName) {
		return compareTo(qualifiedName, false);
	}

	public int compareToIgnoreCase(QualifiedName qualifiedName) {
		return compareTo(qualifiedName, true);
	}

	protected int compareTo(QualifiedName qualifiedName, boolean ignoreCase) {
		for (int i = 0; i < Math.min(getSegmentCount(), qualifiedName.getSegmentCount()); ++i) {
			int result = (ignoreCase) ? getSegment(i).compareToIgnoreCase(qualifiedName.getSegment(i)) : getSegment(i)
					.compareTo(qualifiedName.getSegment(i));
			if (result != 0)
				return result;
		}
		return getSegmentCount() - qualifiedName.getSegmentCount();
	}

	public boolean startsWith(QualifiedName prefix) {
		return startsWith(prefix, false);
	}

	public boolean startsWithIgnoreCase(QualifiedName prefix) {
		return startsWith(prefix, true);
	}

	protected boolean startsWith(QualifiedName prefix, boolean ignoreCase) {
		if (prefix.getSegmentCount() > getSegmentCount())
			return false;
		for (int i = 0; i < prefix.getSegmentCount(); ++i) {
			if ((ignoreCase && !this.getSegment(i).equalsIgnoreCase(prefix.getSegment(i)))
					|| (!ignoreCase && !this.getSegment(i).equals(prefix.getSegment(i))))
				return false;
		}
		return true;
	}

	/**
	 * Returns a canonical String representation of this using '.' as namespace delimiter. For language specific
	 * conversion taking the concrete syntax into account see {@link IQualifiedNameConverter#toString(QualifiedName)}.
	 */
	@Override
	public String toString() {
		if (getSegmentCount() == 0)
			return "";
		if (getSegmentCount() == 1)
			return getFirstSegment();
		StringBuilder builder = new StringBuilder();
		boolean isFirst = true;
		for (String segment : getSegments()) {
			if (!isFirst)
				builder.append(".");
			isFirst = false;
			builder.append(segment);
		}
		return builder.toString();
	}
}
