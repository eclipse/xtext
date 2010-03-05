/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model.edit;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.Issue;

/**
 * @author koehnlein - Initial contribution and API
 */
public class SemanticModificationWrapper implements IModification {

	private URI uriToProblem;

	private final ISemanticModification semanticModification;
	
	private ITextEditComposer textEditComposer;
	
	public SemanticModificationWrapper(Issue issue, ISemanticModification semanticModification, ITextEditComposer textEditComposer) {
		this.semanticModification = semanticModification;
		this.uriToProblem = issue.getUriToProblem();
		this.textEditComposer = textEditComposer;
	}

	public void apply(final IModificationContext context) {
		context.getXtextDocument().modify(new IUnitOfWork.Void<XtextResource>() {
			@Override
			public void process(XtextResource state) throws Exception {
				textEditComposer.beginRecording(state);
				IXtextDocument document = context.getXtextDocument();
				EObject eObject = state.getEObject(uriToProblem.fragment());
				semanticModification.apply(eObject, context);
				final TextEdit edit = textEditComposer.endRecording();
				if (edit != null) {
					String original = document.get();
					try {
						edit.apply(document);
					}
					catch (Exception e) {
						document.set(original);
						throw new RuntimeException(e);
					}
				}
			}
		});
	}

}
