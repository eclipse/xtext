/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model.edit;

import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

/**
 * @author koehnlein - Initial contribution and API
 */
public abstract class AbstractSemanticModification implements IModification {

	private ITextEditComposer textEditComposer;
	
	public AbstractSemanticModification(ITextEditComposer textEditComposer) {
		this.textEditComposer = textEditComposer;
	}

	final public void apply(final IModificationContext context) {
		context.getXtextDocument().modify(new IUnitOfWork.Void<XtextResource>() {
			@Override
			public void process(XtextResource state) throws Exception {
				textEditComposer.beginRecording(state);
				IXtextDocument document = context.getXtextDocument();
				apply(state);
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

	public abstract void apply(XtextResource resource);
}
