/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.hover.html;

import org.eclipse.jface.internal.text.html.BrowserInformationControl;
import org.eclipse.jface.internal.text.html.BrowserInformationControlInput;
import org.eclipse.jface.text.IInputChangedListener;
import org.eclipse.swt.browser.LocationListener;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 * @since 2.3
 */
public class XtextBrowserInformationControlAdapter implements IXtextBrowserInformationControl {
	private final BrowserInformationControl control;

	XtextBrowserInformationControlAdapter(BrowserInformationControl control) {
		this.control = control;
	}

	public void setVisible(boolean visible) {
		control.setVisible(visible);
	}

	public void setSizeConstraints(int maxWidth, int maxHeight) {
		control.setSizeConstraints(maxWidth, maxHeight);
	}

	public void setSize(int width, int height) {
		control.setSize(width, height);
	}

	public void setLocation(Point location) {
		control.setLocation(location);
	}

	@Deprecated
	public void setInformation(String information) {
		control.setInformation(information);
	}

	public void setForegroundColor(Color foreground) {
		control.setForegroundColor(foreground);
	}

	public void setFocus() {
		control.setFocus();
	}

	public void setBackgroundColor(Color background) {
		control.setBackgroundColor(background);
	}

	public void removeFocusListener(FocusListener listener) {
		control.removeFocusListener(listener);
	}

	public void removeDisposeListener(DisposeListener listener) {
		control.removeDisposeListener(listener);
	}

	public boolean isFocusControl() {
		return control.isFocusControl();
	}

	public Point computeSizeHint() {
		return control.computeSizeHint();
	}

	public void addFocusListener(FocusListener listener) {
		control.addFocusListener(listener);
	}

	public void addDisposeListener(DisposeListener listener) {
		control.addDisposeListener(listener);
	}

	public void setInput(Object input) {
		control.setInput(input);
	}

	public void notifyDelayedInputChange(Object object) {
		control.notifyDelayedInputChange(object);
	}

	public boolean hasDelayedInputChangeListener() {
		return control.hasDelayedInputChangeListener();
	}

	/**
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public BrowserInformationControlInput getInput() {
		return control.getInput();
	}

	public void dispose() {
		control.dispose();
	}

	public void addLocationListener(LocationListener createLocationListener) {
		control.addLocationListener(createLocationListener);
	}

	public void addInputChangeListener(IInputChangedListener inputChangeListener) {
		control.addInputChangeListener(inputChangeListener);
	}
}