/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.lib.macro.file;

import static com.google.common.collect.Lists.newArrayList;

import java.io.File;
import java.util.List;

import com.google.common.annotations.Beta;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * @author Sven Efftinge
 */
@Beta
public final class Path {
	
	/**
	 * the segment separator used.
	 */
	public static final char SEGMENT_SEPARATOR = '/';
	private final static Splitter splitter = Splitter.on(SEGMENT_SEPARATOR );
	/**
	 * the root path
	 */
	public static final Path ROOT = new Path("/");
	
	
	private final ImmutableList<String> segments;
	private final boolean absolute;

	
	/**
	 * Constructs a new Path object from a given string.
	 * 
	 * the used file separator is '/' and a leading one indicates an absolute path.
	 * 
	 * @param pathAsString
	 */
	public Path(String pathAsString) {
		if (pathAsString == null)
			throw new NullPointerException();
		if (pathAsString.trim().length() == 0)
			throw new IllegalArgumentException("empty path");
		pathAsString = pathAsString.replace('\\', SEGMENT_SEPARATOR ); //replace windows separators
		Iterable<String> iterable = splitter.split(pathAsString);
		
		// if the first element is empty it has a leading separator;
		this.absolute = iterable.iterator().next().length() == 0 || new File(pathAsString).isAbsolute();
		
		Iterable<String> withoutEmptySegements = Iterables.filter(iterable, new Predicate<String>() {

			public boolean apply(String input) {
				return input != null && input.trim().length() > 0;
			}
		});
		segments = ImmutableList.copyOf(normalize(withoutEmptySegements));
	}
	
	private Path(List<String> segments, boolean isAbsolute) {
		this.segments = ImmutableList.copyOf(normalize(segments));
		this.absolute = isAbsolute;
	}
	
	private Iterable<String> normalize(Iterable<String> segments2) {
		List<String> result = newArrayList();
		boolean canRemoveSegment = false;
		for (String seg : segments2) {
			String string = seg.trim();
			if (canRemoveSegment && string.equals("..")) {
				result.remove(result.size()-1);
				canRemoveSegment = !result.isEmpty() && !result.get(0).equals("..");
			} else if (string.equals(".")) {
				// do nothing
			} else {
				result.add(string);
				canRemoveSegment = !string.equals("..");
			}
		}
		return result;
	}

	/**
	 * @return whether this is an absolute path
	 */
	public boolean isAbsolute() {
		return absolute;
	}
	
	/**
	 * @return the segments
	 */
	public List<String> getSegments() {
		return segments;
	}

	/**
	 * @return the trailing segment, i.e. the simple name of the underlying element.
	 */
	public String getLastSegment() {
		return segments.isEmpty() ? null : segments.get(segments.size()-1);
	}
	
	/**
	 * Appends the given suffix to this path.
	 * 
	 * @param suffix the suffix to append to this path
	 * @return a new Path with the given suffix appended to this path's segments.
	 */
	public Path append(String suffix) {
		return new Path(toString()+SEGMENT_SEPARATOR +suffix);
	}
	
	/**
	 * Returns the parent of this path or null if this path is the root path.
	 * 
	 * @return the parent of this path or null if this path is the root path.
	 */
	public Path getParent() {
		if (!isAbsolute())
			throw new IllegalStateException("path is not absolute");
		if (segments.isEmpty())
			return null;
		return new Path(segments.subList(0, segments.size()-1), true);
	}
	
	/**
	 * @return the file extension or <code>null</code> if this path's last segment doesn't have a file extension.
	 */
	public String getFileExtension() {
		String lastSegment = getLastSegment();
		int idx = lastSegment.lastIndexOf('.');
		if (idx == -1) {
			return null;
		}
		return lastSegment.substring(idx+1);
	}
	
	/**
	 * @param relativePath
	 * @return the absolute path
	 */
	public Path getAbsolutePath(String relativePath) {
		Path other = new Path(relativePath);
		return getAbsolutePath(other);
	}

	/**
	 * @param relativePath
	 * @return the absolute path
	 */
	public Path getAbsolutePath(Path relativePath) {
		if (relativePath.isAbsolute()) {
			throw new IllegalArgumentException("The given path'"+relativePath+"' is not relative.");
		}
		List<String> result = newArrayList(getSegments());
		for (String segment : relativePath.getSegments()) {
			if (segment.equals("..")) {
				// go up
				result.remove(result.size()-1);
			} else if (segment.equals(".")) {
				// stay in current directory
			} else {
				result.add(segment);
			}
		}
		return new Path(result, true);
	}

	/**
	 * See {@link #relativize(Path)}
	 * 
	 * @param other a string representing a path
	 * @return the resulting relative path or null if neither of the given paths is a prefix of the other
	 */
	public Path relativize(String other) {
		return relativize(new Path(other));
	}
	
	/**
    * Constructs a relative path between this path and a given path.
    *
    * <p> Relativization is the inverse of {@link #getAbsolutePath(Path) resolution}.
    * This method attempts to construct a {@link #isAbsolute relative} path
    * that when {@link #getAbsolutePath(Path) resolved} against this path, yields a
    * path that locates the same file as the given path. For example, on UNIX,
    * if this path is {@code "/a/b"} and the given path is {@code "/a/b/c/d"}
    * then the resulting relative path would be {@code "c/d"}. 
 	* Both paths must be absolute and and either this path or the given path must be a
 	* {@link #startsWith(Path) prefix} of the other.
    *
    * @param   other
    *          the path to relativize against this path
    *
    * @return  the resulting relative path or null if neither of the given paths is a prefix of the other
    *
    * @throws  IllegalArgumentException
    *          if this path and {@code other} are not both absolute or relative
    */
	public Path relativize(Path other) {
		if (other.isAbsolute() != isAbsolute())
			throw new IllegalArgumentException("This path and the given path are not both absolute or both relative.");
		if (startsWith(other)) {
			return internalRelativize(this, other);
		} else if (other.startsWith(this)) {
			return internalRelativize(other, this);
		}
		return null;
	}
	
	private Path internalRelativize(Path path, Path prefix) {
		return new Path(path.getSegments().subList(prefix.getSegments().size(), path.getSegments().size()), false);
	}

	/**
	 * Returns whether this path starts with the same segments and
	 * has the same {@link #isAbsolute()} value.
	 * 
	 * @param other the path, which might be a prefix of this path
	 * @return whether the given path is a prefix of this path
	 */
	public boolean startsWith(Path other) {
		if (isAbsolute() != other.isAbsolute())
			return false;
		List<String> otherSegments = other.getSegments();
		List<String> thisSegments = getSegments();
		int otherSegmentSize = otherSegments.size();
		int thisSegmentSize = thisSegments.size();
		if (otherSegmentSize > thisSegmentSize) {
			return false;
		}
		for (int i = 0; i < otherSegmentSize; i++) {
			String otherSeg = otherSegments.get(i);
			String thisSeg = thisSegments.get(i);
			if (!otherSeg.equals(thisSeg))
				return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (absolute ? 1231 : 1237);
		result = prime * result
				+ ((segments == null) ? 0 : segments.hashCode());
		return result;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Path other = (Path) obj;
		if (absolute != other.absolute)
			return false;
		if (segments == null) {
			if (other.segments != null)
				return false;
		} else if (!segments.equals(other.segments))
			return false;
		return true;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		if (isAbsolute()) {
			result.append(SEGMENT_SEPARATOR );
		}
		int size = segments.size();
		for (int i = 0; i < size; i++) {
			String segment = segments.get(i);
			result.append(segment);
			if (i < size-1) {
				result.append(SEGMENT_SEPARATOR );
			}
		}
		return result.toString();
	}
	

}
