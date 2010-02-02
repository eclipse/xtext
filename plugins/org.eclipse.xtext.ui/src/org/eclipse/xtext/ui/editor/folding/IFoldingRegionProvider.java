/*******************************************************************************
 * Copyright (c) 2010 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.folding;

import java.util.List;

import org.eclipse.xtext.ui.editor.model.IXtextDocument;

import com.google.inject.ImplementedBy;

/**
 * @author Michael Clay - Initial contribution and API
 */
@ImplementedBy(DefaultFoldingRegionProvider.class)
public interface IFoldingRegionProvider {

	/**
	 * @return the list of <code>IFoldingRegion</code> for the given document
	 */
	List<IFoldingRegion> getFoldingRegions(IXtextDocument xtextDocument);

}
