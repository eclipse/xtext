/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.autoedit;

import org.eclipse.jface.text.DocumentCommand;

public class CommandInfo {
	public String text = "";
	public int offset = -1;
	public int length = 0;
	public int cursorOffset = -1;
	public boolean isChange = false;

	public void modifyCommand(DocumentCommand command) {
		if (!isChange)
			return;
		if (cursorOffset != -1) {
			command.caretOffset = cursorOffset;
			command.shiftsCaret = false;
		}
		if (offset != -1)
			command.offset = offset;
		command.length = length;
		command.text = text;
	}
}