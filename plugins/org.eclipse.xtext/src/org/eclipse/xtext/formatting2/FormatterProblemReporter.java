/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2;

import java.util.Collection;

import org.eclipse.xtext.formatting2.impl.TextSegmentSet;

public abstract class FormatterProblemReporter {
	public abstract void reportMergeConflict(TextSegmentSet<? extends ITextSegment> set,
			Collection<? extends ITextSegment> conflict);

	public abstract void reportOutsideOfRegion(TextSegmentSet<? extends ITextSegment> set, ITextSegment region);
}