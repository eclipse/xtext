/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2;

import java.util.List;

import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.util.ITextRegion;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.8
 */
public interface ITextSegment extends Comparable<ITextSegment>, ITextRegion {
	int getEndOffset();

	ITextSegment getIndentation();

	int getLineCount();

	String getText();

	ITextRegionAccess getTextRegionAccess();

	boolean isMultiline();

	List<ITextSegment> splitIntoLines();
}
