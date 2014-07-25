/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2;

import java.util.List;

public abstract class FormatterProblemReporter {
	public abstract void reportMergeConflict(IFormattableDocument document, List<ITextReplacer> conflicting);

	public abstract void reportMergeConflict(ITextReplacerContext context, List<ITextReplacement> conflicting);

	public abstract void reportOutsideOfRegion(IFormattableDocument document, ITextReplacer region);

	public abstract void reportOutsideOfRegion(ITextReplacerContext context, ITextReplacement region);
}