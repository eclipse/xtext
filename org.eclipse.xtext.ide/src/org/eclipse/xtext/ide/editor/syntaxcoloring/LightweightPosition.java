/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.syntaxcoloring;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.9
 */
public class LightweightPosition implements Comparable<LightweightPosition>{

	public static class IntToStringArray implements Comparable<IntToStringArray>{
		private int timestamp;
		private String[] ids;
		
		public IntToStringArray(int timestamp, String... ids) {
			this.timestamp = timestamp;
			this.ids = ids;
		}

		@Override
		public int compareTo(IntToStringArray o) {
			if (timestamp < o.timestamp)
				return -1;
			if (timestamp > o.timestamp)
				return 1;
			return 0;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + timestamp;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			IntToStringArray other = (IntToStringArray) obj;
			if (timestamp != other.timestamp)
				return false;
			return true;
		}
		
		@Override
		public String toString() {
			return Arrays.toString(ids) + "@" + timestamp;
		}
		
	}
	
	private final int offset;
	private int length;
	private IntToStringArray[] ids;
	private final int timestamp;
	
	public LightweightPosition(int offset, int length, int timestamp, String... ids) {
		this(offset, length, timestamp, new IntToStringArray[] { new IntToStringArray(timestamp, ids) });
	}
	
	public LightweightPosition(int offset, int length, int timestamp, IntToStringArray[] ids) {
		this.offset = offset;
		this.length = length;
		this.timestamp = timestamp;
		this.ids = ids;
	}
	
	@Override
	public int compareTo(LightweightPosition pos) {
		if (offset < pos.offset)
			return -1;
		if (offset > pos.offset)
			return 1;
		if (length < pos.length)
			return -1;
		if (length > pos.length)
			return 1;
		if (timestamp < pos.timestamp)
			return -1;
		if (timestamp > pos.timestamp)
			return 1;
		return 0;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + length;
		result = prime * result + offset;
		result = prime * result + timestamp;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LightweightPosition other = (LightweightPosition) obj;
		if (length != other.length)
			return false;
		if (offset != other.offset)
			return false;
		if (timestamp != other.timestamp)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return offset + "(" + length + ")@" + timestamp + ": " + Arrays.toString(ids);
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	public int getLength() {
		return length;
	}
	
	public int getOffset() {
		return offset;
	}
	
	IntToStringArray[] internalGetIds() {
		return ids;
	}
	
	public String[] getIds() {
		if (ids.length == 1)
			return ids[0].ids;
		Arrays.sort(ids);
		Set<String> allIds = new LinkedHashSet<String>(ids.length * ids[0].ids.length);
		for (IntToStringArray intToStringArray: ids) {
			List<String> addUs = Arrays.asList(intToStringArray.ids);
			if (allIds.isEmpty()) {
				allIds.addAll(addUs);
			} else {
				allIds.removeAll(addUs);
				allIds.addAll(addUs);
			}
		}
		return allIds.toArray(new String[allIds.size()]);
	}

	public int getTimestamp() {
		return timestamp;
	}
	
	public void merge(int timestamp, String... other) {
		merge(new IntToStringArray[] { new IntToStringArray(timestamp, other) });
	}

	public void merge(IntToStringArray[] other) {
		IntToStringArray[] oldIds = ids;
		ids = createArray(oldIds.length + other.length);
		System.arraycopy(oldIds, 0, ids, 0, oldIds.length);
		System.arraycopy(other, 0, ids, oldIds.length, other.length);
	}
	
	protected IntToStringArray[] createArray(int len) {
		return new IntToStringArray[len];
	}
}
