/*******************************************************************************
 * Copyright (c) 2018 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal;

import java.util.List;
import java.util.function.BiConsumer;

import org.eclipse.xtext.formatting2.regionaccess.HiddenRegionPartAssociation;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegionPart;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegionPartAssociator;
import org.eclipse.xtext.formatting2.regionaccess.IWhitespace;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class HiddenRegionPartAssociator implements IHiddenRegionPartAssociator {

	@Override
	public void associate(IHiddenRegion region, BiConsumer<IHiddenRegionPart, HiddenRegionPartAssociation> handler) {
		List<IHiddenRegionPart> parts = region.getParts();
		if (!region.isMultiline()) {
			// when there is no line-wrap between two semantic tokens, assume that comments belong to the CONTAINER
			// rather than one of the surrounding semantic tokens.
			for (IHiddenRegionPart p : parts) {
				handler.accept(p, HiddenRegionPartAssociation.CONTAINER);
			}
		} else {
			int i = 0;
			if (region.getPreviousSemanticRegion() != null) {
				// collect whitespace and comments from the same line as belonging to the PREVIOUS semantic token
				while (i < parts.size()) {
					IHiddenRegionPart part = parts.get(i);
					if (part.isMultiline()) {
						if (part.getText().endsWith("\n")) {
							handler.accept(part, HiddenRegionPartAssociation.PREVIOUS);
							i++;
						}
						break;
					} else {
						handler.accept(part, HiddenRegionPartAssociation.PREVIOUS);
						i++;
					}
				}
			}
			int j = parts.size() - 1;
			if (region.getNextSemanticRegion() != null) {
				// iterate backwards until the first whitespace with two or more new-lines; Those are the parts
				// associated with the NEXT semantic token.
				while (j >= i) {
					IHiddenRegionPart part = parts.get(j);
					if (part instanceof IWhitespace && part.getLineCount() > 2) {
						break;
					} else {
						handler.accept(part, HiddenRegionPartAssociation.NEXT);
						j--;
					}
				}
			}
			// Associate the remaining tokens with the CONTAINER
			for (int k = i; k <= j; k++) {
				IHiddenRegionPart part = parts.get(k);
				handler.accept(part, HiddenRegionPartAssociation.CONTAINER);
			}
		}

	}

}
