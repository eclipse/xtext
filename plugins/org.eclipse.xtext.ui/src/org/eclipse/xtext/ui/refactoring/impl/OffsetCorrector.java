/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import org.eclipse.xtext.ui.refactoring.IRefactoringDocument;
import org.eclipse.xtext.util.ReplaceRegion;

/**
 * Corrects offsets with regard to an applied/not yet applied declaration edit.
 * 
 * @author koehnlein - Initial contribution and API
 */
public class OffsetCorrector {

	private final IRefactoringDocument declarationDocument;

	private final int newDeclarationEnd;

	private final int oldDeclarationEnd;

	private final int declarationDelta;

	public OffsetCorrector(IRefactoringDocument declarationDocument, ReplaceRegion declarationEdit) {
		this.declarationDocument = declarationDocument;
		this.oldDeclarationEnd = declarationEdit.getOffset() + declarationEdit.getLength();
		this.newDeclarationEnd = declarationEdit.getOffset() + declarationEdit.getText().length();
		this.declarationDelta = declarationEdit.getText().length() - declarationEdit.getLength();
	}

	public int newToOld(IRefactoringDocument document, int offset) {
		if (document.equals(declarationDocument)) {
			if(offset >= newDeclarationEnd) {
				return offset - declarationDelta;
			}
		}
		return offset;
	}

	public int oldToNew(IRefactoringDocument document, int offset) {
		if (document.equals(declarationDocument)) {
			if(offset >= oldDeclarationEnd) {
				return offset + declarationDelta;
			}
		}
		return offset;
	}
}
