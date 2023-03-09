/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.formatting2;

import org.eclipse.xtext.formatting2.IAutowrapFormatter;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatting;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegionPart;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class IndentOnceAutowrapFormatter implements IAutowrapFormatter {
	private final IHiddenRegion last;

	private boolean hasWrapped = false;

	public IndentOnceAutowrapFormatter(IHiddenRegion last) {
		this.last = last;
	}

	@Override
	public void format(ITextSegment region, IHiddenRegionFormatting wrapped, @Extension IFormattableDocument document) {
		if (!hasWrapped) {
			IHiddenRegion hiddenRegion = null;
			if (region instanceof IHiddenRegion) {
				hiddenRegion = (IHiddenRegion) region;
			} else if (region instanceof IHiddenRegionPart) {
				hiddenRegion = ((IHiddenRegionPart) region).getHiddenRegion();
			}
			document.set(hiddenRegion, last, (IHiddenRegionFormatter it) -> it.indent());
			hasWrapped = true;
		}
	}

}
