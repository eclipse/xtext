/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.formatting2;

import org.eclipse.xtext.formatting2.ITextReplacer;
import org.eclipse.xtext.formatting2.ITextReplacerContext;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;

/**
 * @author Moritz Eysholdt - Initial implementation and API
 */
public class ArrayBracketsFormattingReplacer implements ITextReplacer {
	private final ISemanticRegion region;

	@Override
	public ITextReplacerContext createReplacements(ITextReplacerContext it) {
		String t = region.getText();
		int offset = region.getOffset();
		for (int i = 0; i < t.length(); i++) {
			if (Character.isWhitespace(t.charAt(i))) {
				it.addReplacement(region.getTextRegionAccess().getRewriter().createReplacement(offset + i, 1, ""));
			}
		}
		return it;
	}

	@Override
	public ISemanticRegion getRegion() {
		return region;
	}

	public ArrayBracketsFormattingReplacer(ISemanticRegion region) {
		this.region = region;
	}
}
