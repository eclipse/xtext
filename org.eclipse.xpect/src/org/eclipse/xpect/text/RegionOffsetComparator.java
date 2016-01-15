package org.eclipse.xpect.text;

import java.util.Comparator;

/**
 * 
 * @author Moritz Eysholdt
 */
public class RegionOffsetComparator implements Comparator<IRegion> {

	public int compare(IRegion o1, IRegion o2) {
		return o1.getOffset() - o2.getOffset();
	}

}
