/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal;

import java.util.List;

import org.eclipse.xtext.formatting2.regionaccess.IComment;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegionPart;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegionPartMerger;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.IWhitespace;

import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class HiddenRegionPartMerger implements IHiddenRegionPartMerger {

	protected int getIndex(List<IHiddenRegionPart> parts) {
		for (int i = 0; i < parts.size(); i++) {
			IHiddenRegionPart part = parts.get(i);
			if (part.isMultiline()) {
				return i + 1;
			}
		}
		return parts.size();
	}

	protected int getIndexFirstInFile(List<IHiddenRegionPart> parts) {
		for (int i = parts.size() - 1; i >= 0; i--) {
			IHiddenRegionPart part = parts.get(i);
			if (part instanceof IWhitespace && part.getLineCount() > 2) {
				return i + 1;
			}
		}
		for (int i = parts.size() - 1; i >= 0; i--) {
			IHiddenRegionPart part = parts.get(i);
			if (part instanceof IComment) {
				return i;
			}
		}
		return parts.size();
	}

	@Override
	public List<IHiddenRegionPart> merge(ITextRegionAccess b, IHiddenRegion first, IHiddenRegion last, boolean del) {
		List<IHiddenRegionPart> parts1 = first.getParts();
		List<IHiddenRegionPart> parts2 = last.getParts();
		boolean firstInFile1 = first.getPreviousSemanticRegion() == null;
		boolean firstInFile2 = last.getPreviousSemanticRegion() == null;
		int index1 = firstInFile1 ? getIndexFirstInFile(parts1) : getIndex(parts1);
		int index2 = firstInFile2 ? getIndexFirstInFile(parts2) : getIndex(parts2);
		List<IHiddenRegionPart> result = Lists.newArrayList();
		if (del && !first.isMultiline()) {
			result.addAll(parts1);
		} else {
			for (int i = 0; i < index1; i++) {
				result.add(parts1.get(i));
			}
		}
		if (del && !last.isMultiline()) {
			result.addAll(parts2);
		} else {
			for (int i = index2; i < parts2.size(); i++) {
				result.add(parts2.get(i));
			}
		}
		return result;
	}

}
