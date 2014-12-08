package org.eclipse.xtext.builder.ng.debug;

import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleFactory;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.xtext.builder.ng.debug.XtextCompilerConsole;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Moritz Eysholdt
 */
@SuppressWarnings("all")
public class XtextCompilerConsoleFactory implements IConsoleFactory {
  public void openConsole() {
    ConsolePlugin _default = ConsolePlugin.getDefault();
    IConsoleManager consoleManager = _default.getConsoleManager();
    XtextCompilerConsole _xtextCompilerConsole = new XtextCompilerConsole();
    consoleManager.addConsoles(new IConsole[] { _xtextCompilerConsole });
  }
}
