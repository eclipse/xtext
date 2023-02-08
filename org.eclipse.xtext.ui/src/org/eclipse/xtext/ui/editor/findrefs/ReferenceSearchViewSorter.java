/*******************************************************************************
 * Copyright (c) 2011, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.findrefs;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.util.PolymorphicDispatcher;

/**
 * @author koehnlein - Initial contribution and API
 */
public class ReferenceSearchViewSorter extends ViewerComparator {

	private PolymorphicDispatcher<Integer> comparator = PolymorphicDispatcher.createForSingleTarget("_compare", 2,2,this);
	
	@Override
	public int compare(Viewer viewer, Object e1, Object e2) {
		Integer result = comparator.invoke(e1, e2);
		return result == null ? super.compare(viewer, e1, e2) : result;
	}

	protected Integer _compare(IResourceDescription rd0, IResourceDescription rd1) {
		String[] segments0 = rd0.getURI().segments();
		String[] segments1 = rd1.getURI().segments();
		for(int i=0; i<Math.min(segments0.length, segments1.length); ++i) {
			int compareToIgnoreCase = segments0[i].compareToIgnoreCase(segments1[i]);
			if(compareToIgnoreCase != 0)
				return compareToIgnoreCase;
		}
		return segments0.length - segments1.length;
	}
	
	protected Integer _compare(Object o0, Object o1) {
		return null;
	}
}
