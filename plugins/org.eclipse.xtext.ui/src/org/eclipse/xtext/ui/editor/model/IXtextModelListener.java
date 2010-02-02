/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model;

import org.eclipse.xtext.resource.XtextResource;

/**
 * @author Peter Friese - Initial contribution and API
 */
public interface IXtextModelListener {
	
	void modelChanged(XtextResource resource);

}
