/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.naming;

import java.util.Collections;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;

/**
 * A datatype for dealing with qualified names. Instances are usually provided by a {@link IQualifiedNameProvider}.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Jan Koehnlein
 */
public class QualifiedName implements Comparable<QualifiedName> {

	protected List<String> segments;

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
		return new QualifiedName(segments);
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
			this.segments = Collections.emptyList();
		else
			this.segments = ImmutableList.of(segments);
	}

	public boolean isEmpty() {
		return segments.isEmpty();
	}

	public List<String> getSegments() {
		return segments;
	}

	public int getSegmentCount() {
		return getSegments().size();
	}

	public String getSegment(int index) {
		return getSegments().get(index);
	}

	public String getLastSegment() {
		return getSegments().get(getSegmentCount() - 1);
	}

	public String getFirstSegment() {
		return getSegments().get(0);
	}

	public QualifiedName append(String segment) {
		String[] newSegments = new String[getSegmentCount() + 1];
		for (int i = 0; i < getSegmentCount(); ++i)
			newSegments[i] = getSegment(i);
		newSegments[getSegmentCount()] = segment;
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
		String[] newSegments = new String[getSegmentCount() - skipCount];
		for (int i = skipCount; i < getSegmentCount(); ++i)
			newSegments[i - skipCount] = getSegment(i);
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
		String[] newSegments = new String[getSegmentCount() - skipCount];
		for (int i = 0; i < getSegmentCount() - skipCount; ++i)
			newSegments[i] = getSegment(i);
		return new QualifiedName(newSegments);
	}

	public QualifiedName toLowerCase() {
		String[] newSegments = new String[getSegmentCount()];
		for (int i = 0; i < getSegmentCount(); ++i)
			newSegments[i] = getSegment(i).toLowerCase();
		return new QualifiedName(newSegments);
	}

	public QualifiedName toUpperCase() {
		String[] newSegments = new String[getSegmentCount()];
		for (int i = 0; i < getSegmentCount(); ++i)
			newSegments[i] = getSegment(i).toUpperCase();
		return new QualifiedName(newSegments);
	}

	@Override
	public int hashCode() {
		return getSegments().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof QualifiedName && ((QualifiedName) obj).getSegmentCount() == getSegmentCount()
				&& startsWith((QualifiedName) obj, false);
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
