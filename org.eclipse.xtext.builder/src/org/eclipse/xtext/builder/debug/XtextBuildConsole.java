/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.builder.debug;

import java.io.PrintStream;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleFactory;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.IOConsole;
import org.eclipse.xtext.builder.internal.Activator;

import com.google.common.base.Throwables;
import com.google.inject.Singleton;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Moritz Eysholdt
 */
public class XtextBuildConsole extends IOConsole {

	public static class Factory implements IConsoleFactory {

		@Override
		public void openConsole() {
			IConsoleManager consoleManager = ConsolePlugin.getDefault().getConsoleManager();
			consoleManager.addConsoles(new IConsole[] { new XtextBuildConsole() });
		}
	}

	@Singleton
	public static class Logger implements IBuildLogger {

		private static IBuildLogger delegate;

		@Override
		public void log(Object obj) {
			if (delegate != null) {
				delegate.log(obj);
			}

			ConsolePlugin consolePlugin = ConsolePlugin.getDefault();
			if(consolePlugin == null){
				return;
			}
			IConsoleManager consoleManager = consolePlugin.getConsoleManager();
			XtextBuildConsole console = null;
			for (IConsole c : consoleManager.getConsoles()) {
				if (c instanceof XtextBuildConsole) {
					console = (XtextBuildConsole) c;
					break;
				}
			}
			if (console != null) {
				String str = null;
				if (obj instanceof Throwable) {
					str = Throwables.getStackTraceAsString((Throwable) obj);
				} else {
					str = obj.toString();
				}
				console.println("[" + Thread.currentThread().getName() + "] " + str);
				consoleManager.showConsoleView(console);
			}
		}

		public IBuildLogger registerDelegate(IBuildLogger delegate) {
			Logger.delegate = delegate;
			return delegate;
		}
	}

	private final PrintStream out;

	public XtextBuildConsole() {
		super("Xtext Build", "xtextBuildConsole",
				ImageDescriptor.createFromURL(Activator.getDefault().getBundle().getEntry("icons/console.png")), true);
		out = new PrintStream(newOutputStream(), true);
	}

	public void println(String s) {
		out.println(s);
	}
}
