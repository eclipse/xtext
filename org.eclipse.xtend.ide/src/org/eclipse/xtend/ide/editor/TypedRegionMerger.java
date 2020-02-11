/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.editor;

import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.TypedRegion;

/**
 * Simple heuristic that will basically strip rich string partitions
 * from the array and replace them with the default partition if 
 * the first entry in the {@code original} array is not a rich string.
 * Otherwise, all entries will become rich string regions. 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TypedRegionMerger {

	public ITypedRegion[] merge(ITypedRegion[] original) {
		if (original == null || original.length == 0)
			return original;
		ITypedRegion[] result = new ITypedRegion[original.length];
		String contentType = original[0].getType();
		result[0] = original[0];
		for(int i = 1; i < original.length; i++) {
			ITypedRegion copyMe = original[i];
			result[i] = new TypedRegion(copyMe.getOffset(), copyMe.getLength(), contentType);
		}
		return result;
	}
	
}
