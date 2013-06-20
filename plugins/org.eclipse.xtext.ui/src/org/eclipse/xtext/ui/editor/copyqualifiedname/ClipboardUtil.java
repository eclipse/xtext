/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.copyqualifiedname;

import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.ui.util.SWTUtil;

/**
 * @author Anton Kosyakov - Initial contribution and API
 * @since 2.4
 */
public class ClipboardUtil {

	public static Object copy(String data) {
		if (data == null) {
			return null;
		}
		Clipboard clipboard = null;
		try {
			Display display = SWTUtil.getStandardDisplay();
			clipboard = new Clipboard(display);
			clipboard.setContents(new Object[] { data }, new Transfer[] { TextTransfer.getInstance() });
		} finally {
			if (clipboard != null) {
				clipboard.dispose();
			}
		}
		return null;
	}

}
