/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Sets.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Moritz Eysholdt
 */
public class LineMappingProvider {

	/**
	 * @author Sven Efftinge - Initial contribution and API
	 */
	public static class LineMapping {

		public int sourceStartLine, targetStartLine, targetEndLine;
		public SourceRelativeURI source;

		public LineMapping(int sourceStartLine, int targetStartLine, int targetEndLine, SourceRelativeURI source) {
			this.sourceStartLine = sourceStartLine;
			this.targetStartLine = targetStartLine;
			this.targetEndLine = targetEndLine;
			this.source = source;
			if (sourceStartLine < 0 || targetStartLine < 0 || targetEndLine < 0 || targetStartLine > targetEndLine
					|| source == null)
				throw new IllegalArgumentException(toString());
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((source == null) ? 0 : source.hashCode());
			result = prime * result + sourceStartLine;
			result = prime * result + targetEndLine;
			result = prime * result + targetStartLine;
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
			LineMapping other = (LineMapping) obj;
			if (source == null) {
				if (other.source != null)
					return false;
			} else if (!source.equals(other.source))
				return false;
			if (sourceStartLine != other.sourceStartLine)
				return false;
			if (targetEndLine != other.targetEndLine)
				return false;
			if (targetStartLine != other.targetStartLine)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "LineMapping [sourceStartLine=" + sourceStartLine + ", targetStartLine=" + targetStartLine
					+ ", targetEndLine=" + targetEndLine + ", source=" + source + "]";
		}

	}

	public List<LineMapping> getLineMapping(AbstractTraceRegion rootTraceRegion) {
		final Set<LineMapping> lineData = newLinkedHashSet();
		createSmapInfo(rootTraceRegion, lineData);
		if (lineData.isEmpty())
			return null;
		List<LineMapping> lineInfo = normalizeLineInfo(lineData);
		if (lineInfo.isEmpty())
			return null;
		return lineInfo;
	}

	protected Set<Integer> createSmapInfo(AbstractTraceRegion targetRegion, Set<LineMapping> lineMappings) {
		Set<Integer> mapped = newHashSet();
		for (AbstractTraceRegion nested : targetRegion.getNestedRegions()) {
			mapped.addAll(createSmapInfo(nested, lineMappings));
		}
		if (targetRegion.isUseForDebugging()) {
			ILocationData location = targetRegion.getMergedAssociatedLocation();
			if (location != null) {
				final SourceRelativeURI path = targetRegion.getAssociatedSrcRelativePath();
				if (path != null) {
					int myLineNumber = targetRegion.getMyLineNumber();
					int myEndLineNumber = targetRegion.getMyEndLineNumber();
					for (int i = myLineNumber; i <= myEndLineNumber; i++) {
						if (!mapped.contains(i)) {
							final LineMapping e = new LineMapping(location.getLineNumber() + 1, i, i, path);
							lineMappings.add(e);
							mapped.add(i);
						}
					}
				}
			}
		}
		return mapped;
	}

	protected List<LineMapping> normalizeLineInfo(Set<LineMapping> lineData) {
		ArrayList<LineMapping> list = newArrayList(lineData);
		Collections.sort(list, new Comparator<LineMapping>() {
			@Override
			public int compare(LineMapping o1, LineMapping o2) {
				int compareResult = o2.targetStartLine - o1.targetStartLine;
				if (compareResult == 0) {
					return o2.targetEndLine - o1.targetEndLine;
				}
				return compareResult;
			}
		});
		List<LineMapping> result = newLinkedList();
		LineMapping current = null;
		for (LineMapping mapping : list) {
			if (current != null && current.sourceStartLine == mapping.sourceStartLine
					&& current.source.equals(mapping.source)) {

				current.targetStartLine = Math.min(current.targetStartLine, mapping.targetStartLine);
				current.targetEndLine = Math.max(current.targetEndLine, mapping.targetEndLine);
			} else {
				if (current != null) {
					result.add(0, current);
				}
				current = new LineMapping(mapping.sourceStartLine, mapping.targetStartLine, mapping.targetEndLine,
						mapping.source);
			}
		}
		if (current != null)
			result.add(0, current);
		return result;
	}

}
