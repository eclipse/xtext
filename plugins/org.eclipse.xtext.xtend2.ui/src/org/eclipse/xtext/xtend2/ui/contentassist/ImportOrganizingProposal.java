/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.contentassist;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.util.ITextRegion;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ImportOrganizingProposal extends ConfigurableCompletionProposal {

	protected ITextRegion importRegion;

	protected String organizedImportSection;

	public ImportOrganizingProposal(String replacementString, int replacementOffset, int replacementLength,
			int cursorPosition, Image image, StyledString displayString) {
		super(replacementString, replacementOffset, replacementLength, cursorPosition, image, displayString, null, null);
	}

	public void setImportRegion(ITextRegion importRegion) {
		this.importRegion = importRegion;
	}

	public void setOrganizedImportSection(String organizedImportSection) {
		this.organizedImportSection = organizedImportSection;
	}

	@Override
	public void apply(IDocument document) {
		try {
			super.apply(document);
			if (importRegion != null)
				document.replace(importRegion.getOffset(), importRegion.getLength(),
						organizedImportSection == null ? "" : organizedImportSection);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}

}
