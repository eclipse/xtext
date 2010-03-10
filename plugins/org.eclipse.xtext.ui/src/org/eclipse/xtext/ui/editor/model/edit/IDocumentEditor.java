/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model.edit;

import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.ImplementedBy;

/**
 * Allows modifications of the semantic model of an {@link IXtextDocument} which will be automatically serialized back
 * into the document. 
 * 
 * @author Knut Wannheden - Initial contribution and API
 */
@ImplementedBy(DefaultDocumentEditor.class)
public interface IDocumentEditor {

	<T> T process(final IUnitOfWork<T, XtextResource> work, final IXtextDocument document);

}
