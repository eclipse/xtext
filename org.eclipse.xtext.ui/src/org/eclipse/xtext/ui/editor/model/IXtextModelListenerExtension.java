/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model;

import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.7
 */
public interface IXtextModelListenerExtension {

	/**
	 * Called when the resource model of an XtextDocument has changed.
	 * 
	 * @param resource the model
	 * @param cancelIndicator an indicator that should be asked in order to cancel an operation early in case there are new pending changes.
	 */
	void modelChanged(XtextResource resource, CancelIndicator cancelIndicator);
}
