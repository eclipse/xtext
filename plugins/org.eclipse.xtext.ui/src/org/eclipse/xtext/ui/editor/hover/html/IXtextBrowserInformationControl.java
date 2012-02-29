/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.hover.html;

import org.eclipse.jface.internal.text.html.BrowserInformationControlInput;
import org.eclipse.jface.text.IInformationControl;
import org.eclipse.jface.text.IInputChangedListener;
import org.eclipse.swt.browser.LocationListener;

/**
 * @author Holger Schill - Initial contribution and API
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 * @since 2.3
 */
public interface IXtextBrowserInformationControl extends IInformationControl {
	
	/**
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public BrowserInformationControlInput getInput();
	
	public void setInput(Object input);

	public void notifyDelayedInputChange(Object object);

	public void dispose();

	public void addLocationListener(LocationListener createLocationListener);

	public boolean hasDelayedInputChangeListener();

	public void addInputChangeListener(IInputChangedListener inputChangeListener);
	
	
}
