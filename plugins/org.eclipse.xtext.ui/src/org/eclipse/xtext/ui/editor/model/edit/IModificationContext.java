/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model.edit;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public interface IModificationContext {

	IXtextDocument getXtextDocument();
	
	IXtextDocument getXtextDocument(URI uri);

}
