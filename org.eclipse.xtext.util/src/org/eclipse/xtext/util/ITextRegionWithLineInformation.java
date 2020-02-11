/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.3
 */
public interface ITextRegionWithLineInformation extends ITextRegion {

	/**
	 * The zero-based line number where the region starts.
	 * @return the start line (zero based)
	 */
	int getLineNumber();
	
	/**
	 * The zero-based line number where the region ends.
	 * @return the end line (zero based)
	 */
	int getEndLineNumber();
	
	ITextRegionWithLineInformation merge(ITextRegionWithLineInformation other);
	
	static ITextRegionWithLineInformation EMPTY_REGION = new ITextRegionWithLineInformation() {

		@Override
		public int getOffset() {
			return 0;
		}

		@Override
		public int getLength() {
			return 0;
		}

		@Override
		public ITextRegion merge(ITextRegion region) {
			return region;
		}

		@Override
		public boolean contains(ITextRegion other) {
			return false;
		}

		@Override
		public boolean contains(int offset) {
			return false;
		}

		@Override
		public int getLineNumber() {
			return 0;
		}

		@Override
		public int getEndLineNumber() {
			return 0;
		}

		@Override
		public ITextRegionWithLineInformation merge(ITextRegionWithLineInformation other) {
			return other;
		}
		
	};
	
}
