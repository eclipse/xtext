package org.xpect.ui.services;

import org.eclipse.xtext.ui.editor.autoedit.MultiLineTerminalsEditStrategy;

public class XpectMultiLineTerminalsEditStrategyFactory extends MultiLineTerminalsEditStrategy.Factory {
	@Override
	public MultiLineTerminalsEditStrategy newInstance(String leftTerminal, String indentationString, String rightTerminal) {
		if (" * ".equals(indentationString))
			indentationString = "   ";
		return super.newInstance(leftTerminal, indentationString, rightTerminal);
	}

}
