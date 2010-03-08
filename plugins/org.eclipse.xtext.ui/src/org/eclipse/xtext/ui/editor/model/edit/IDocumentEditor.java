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
 * @author Knut Wannheden - Initial contribution and API
 */
@SuppressWarnings("deprecation")
@Deprecated
@ImplementedBy(DefaultDocumentEditor.class)
public interface IDocumentEditor {

	<T> T process(final IUnitOfWork<T, XtextResource> work, final IXtextDocument document);

}
