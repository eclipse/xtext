/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public interface ITextRegion {
	int getOffset();

	int getLength();

	ITextRegion merge(ITextRegion region);
	
	boolean contains(ITextRegion other);
	
	boolean contains(int offset);

	static ITextRegion EMPTY_REGION = new ITextRegion() {

		public int getOffset() {
			return 0;
		}

		public int getLength() {
			return 0;
		}

		public ITextRegion merge(ITextRegion region) {
			return region;
		}

		public boolean contains(ITextRegion other) {
			return false;
		}

		public boolean contains(int offset) {
			return false;
		}
		
	};
}
