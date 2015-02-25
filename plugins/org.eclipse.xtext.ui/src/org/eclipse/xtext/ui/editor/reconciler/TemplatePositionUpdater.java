/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.reconciler;

import org.eclipse.jface.text.DefaultPositionUpdater;

/**
 * Special impl to increase the length if someone types when CA is already invoked
 * Instead of setting the offset to a new position we increase the length
 *
 * @author Holger Schill - Initial contribution and API
 * @since 2.8
 */
final class TemplatePositionUpdater extends DefaultPositionUpdater {
	TemplatePositionUpdater(String category) {
		super(category);
	}

	@Override
	protected void adaptToInsert() {

		int myStart= fPosition.offset;
		int myEnd=   fPosition.offset + fPosition.length - 1;
		myEnd= Math.max(myStart, myEnd);

		int yoursStart= fOffset;
		int yoursEnd=   fOffset + fReplaceLength -1;
		yoursEnd= Math.max(yoursStart, yoursEnd);

		if (myEnd < yoursStart)
			return;

		fPosition.length += fReplaceLength;
	}
}