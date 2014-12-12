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

	@Override
	public void setVisible(boolean visible) {
		control.setVisible(visible);
	}

	@Override
	public void setSizeConstraints(int maxWidth, int maxHeight) {
		control.setSizeConstraints(maxWidth, maxHeight);
	}

	@Override
	public void setSize(int width, int height) {
		control.setSize(width, height);
	}

	@Override
	public void setLocation(Point location) {
		control.setLocation(location);
	}

	@Override
	@Deprecated
	public void setInformation(String information) {
		control.setInformation(information);
	}

	@Override
	public void setForegroundColor(Color foreground) {
		control.setForegroundColor(foreground);
	}

	@Override
	public void setFocus() {
		control.setFocus();
	}

	@Override
	public void setBackgroundColor(Color background) {
		control.setBackgroundColor(background);
	}

	@Override
	public void removeFocusListener(FocusListener listener) {
		control.removeFocusListener(listener);
	}

	@Override
	public void removeDisposeListener(DisposeListener listener) {
		control.removeDisposeListener(listener);
	}

	@Override
	public boolean isFocusControl() {
		return control.isFocusControl();
	}

	@Override
	public Point computeSizeHint() {
		return control.computeSizeHint();
	}

	@Override
	public void addFocusListener(FocusListener listener) {
		control.addFocusListener(listener);
	}

	@Override
	public void addDisposeListener(DisposeListener listener) {
		control.addDisposeListener(listener);
	}

	@Override
	public void setInput(Object input) {
		control.setInput(input);
	}

	@Override
	public void notifyDelayedInputChange(Object object) {
		control.notifyDelayedInputChange(object);
	}

	@Override
	public boolean hasDelayedInputChangeListener() {
		return control.hasDelayedInputChangeListener();
	}

	/**
	 * @noreference This method is not intended to be referenced by clients.
	 */
	@Override
	public BrowserInformationControlInput getInput() {
		return control.getInput();
	}

	@Override
	public void dispose() {
		control.dispose();
	}

	@Override
	public void addLocationListener(LocationListener createLocationListener) {
		control.addLocationListener(createLocationListener);
	}

	@Override
	public void addInputChangeListener(IInputChangedListener inputChangeListener) {
		control.addInputChangeListener(inputChangeListener);
	}
}