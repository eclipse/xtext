/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline;

import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider;

import com.google.inject.ImplementedBy;

/**
 * Creates outline nodes. Only called from within {@link org.eclipse.xtext.util.concurrent.IUnitOfWork}s where the
 * {@link Resource} can be read safely.
 * 
 * @author koehnlein - Initial contribution and API
 */
@ImplementedBy(DefaultOutlineTreeProvider.class)
public interface IOutlineTreeProvider {

	IOutlineNode createRoot(IXtextDocument document);
	
}
