package org.eclipse.xtext.builder.ng.debug

import org.eclipse.ui.console.ConsolePlugin
import org.eclipse.ui.console.IConsoleFactory
import org.eclipse.ui.console.IConsoleManager

/** 
 * @author Jan Koehnlein - Initial contribution and API
 * @author Moritz Eysholdt
 */
class XtextCompilerConsoleFactory implements IConsoleFactory {
	
	override void openConsole() {
		var IConsoleManager consoleManager = ConsolePlugin.^default.consoleManager
		consoleManager.addConsoles(#[new XtextCompilerConsole()])
	}
}
