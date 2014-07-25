/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2;

import org.eclipse.xtext.formatting2.impl.RegionSet;

public abstract class FormatterProblemReporter {
	public abstract void handleMergeConflict(RegionSet<? extends ITextRegion2> set, ITextRegion2 existing, ITextRegion2 add);

	public abstract void handleOutsideOfRegion(RegionSet<? extends ITextRegion2> set, ITextRegion2 region);
}