/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model;

import org.eclipse.xtext.resource.XtextResource;

/**
 * @author Peter Friese - Initial contribution and API
 */
public interface IXtextModelListener {
	
	/**
	 * Run when the {@link XtextResource} is modified. This code will be executed on the UI thread to guarantee that the corresponding
	 * IDocument is not being changed during the run. It's therefore important to keep the code executed light weight and offload any heavy
	 * computation to a background job.
	 */
	void modelChanged(XtextResource resource);

}
