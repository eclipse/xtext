/*******************************************************************************
 * Copyright (c) 2000, 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.xtext.ui.util;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.accessibility.AccessibleAdapter;
import org.eclipse.swt.accessibility.AccessibleEvent;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Caret;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Widget;

/**
 * Utility class to simplify access to some SWT resources.
 */
public class SWTUtil {

	private static final Logger LOG = Logger.getLogger(SWTUtil.class);

	/**
	 * Returns the standard display to use. The method first checks, if the thread, that is calling this method, has an
	 * associated display {@link Display#getCurrent()}. If so, this display is returned. Otherwise the method returns
	 * the {@link Display#getDefault()} display. If any {@link Display}'s are available, {@link Display#getDefault()}
	 * will create a new {@link Display}.
	 * 
	 * @return the standard display to be used or <code>null</code> if any {@link Display}s found and a new one can not
	 *         be created. Creating a new {@link Display} under Mac from within a non-main thread is not allowed.
	 */
	public static Display getStandardDisplay() {
		Display display = Display.getCurrent();
		if (display == null) {
			try {
				display = Display.getDefault();
			} catch (SWTException swtE) {
				// eclipse is probably shutting down. Any Displays are available and can not be created.
				// Creating a new Display under Mac from within a non-main thread, will throw an exception
				// https://bugs.eclipse.org/bugs/show_bug.cgi?id=459286
				LOG.error("Could not get/create a default display.");
			}
		}
		return display;
	}

	/**
	 * Returns the shell for the given widget. If the widget doesn't represent a SWT object that manage a shell,
	 * <code>null</code> is returned.
	 * 
	 * @param widget
	 *            the widget
	 * 
	 * @return the shell for the given widget
	 */
	public static Shell getShell(Widget widget) {
		if (widget instanceof Control)
			return ((Control) widget).getShell();
		if (widget instanceof Caret)
			return ((Caret) widget).getParent().getShell();
		if (widget instanceof DragSource)
			return ((DragSource) widget).getControl().getShell();
		if (widget instanceof DropTarget)
			return ((DropTarget) widget).getControl().getShell();
		if (widget instanceof Menu)
			return ((Menu) widget).getParent().getShell();
		if (widget instanceof ScrollBar)
			return ((ScrollBar) widget).getParent().getShell();

		return null;
	}

	/**
	 * Returns a width hint for a button control.
	 * 
	 * @param button
	 *            the button
	 * @return the width hint
	 */
	public static int getButtonWidthHint(Button button) {
		button.setFont(JFaceResources.getDialogFont());
		PixelConverter converter = new PixelConverter(button);
		int widthHint = converter.convertHorizontalDLUsToPixels(IDialogConstants.BUTTON_WIDTH);
		return Math.max(widthHint, button.computeSize(SWT.DEFAULT, SWT.DEFAULT, true).x);
	}

	/**
	 * Sets width and height hint for the button control.<br>
	 * <b>Note:</b> This is a NOP if the button's layout data is not an instance of <code>GridData</code>.
	 * 
	 * @param button
	 *            the button for which to set the dimension hint
	 */
	public static void setButtonDimensionHint(Button button) {
		Assert.isNotNull(button);
		Object gd = button.getLayoutData();
		if (gd instanceof GridData) {
			((GridData) gd).widthHint = getButtonWidthHint(button);
			((GridData) gd).horizontalAlignment = GridData.FILL;
		}
	}

	public static int getTableHeightHint(Table table, int rows) {
		if (table.getFont().equals(JFaceResources.getDefaultFont()))
			table.setFont(JFaceResources.getDialogFont());
		int result = table.getItemHeight() * rows + table.getHeaderHeight();
		if (table.getLinesVisible())
			result += table.getGridLineWidth() * (rows - 1);
		return result;
	}

	/**
	 * Adds an accessibility listener returning the given fixed name.
	 * 
	 * @param control
	 *            the control to add the accessibility support to
	 * @param text
	 *            the name
	 */
	public static void setAccessibilityText(Control control, final String text) {
		control.getAccessible().addAccessibleListener(new AccessibleAdapter() {
			@Override
			public void getName(AccessibleEvent e) {
				e.result = text;
			}
		});
	}

	public static GridLayout newLayoutNoMargins(int columns) {
		GridLayout layout = new GridLayout(columns, false);
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		return layout;
	}

}
