/** 
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.debug

import java.io.PrintStream
import org.eclipse.ui.console.ConsolePlugin
import org.eclipse.ui.console.IConsoleFactory
import org.eclipse.ui.console.IOConsole

import static extension com.google.common.base.Throwables.*
import com.google.inject.Singleton

/** 
 * @author Jan Koehnlein - Initial contribution and API
 * @author Moritz Eysholdt
 */
class XtextBuildConsole extends IOConsole {

	val PrintStream out

	new() {
		super("Xtext Build", "xtextBuildConsole", null, true)
		this.out = new PrintStream(newOutputStream(), true)
	}

	def println(String it) {
		out.println(it)
	}

	static class Factory implements IConsoleFactory {
		override void openConsole() {
			var consoleManager = ConsolePlugin.^default.consoleManager
			consoleManager.addConsoles(#[new XtextBuildConsole()])
		}
	}
	
	@Singleton
	static class Logger implements IBuildLogger {
		
		static IBuildLogger delegate
		
		override log(Object it) {
			if(delegate != null)
				delegate.log(it)
			val consoleManager = ConsolePlugin.getDefault.consoleManager
			val console = consoleManager.consoles.filter(XtextBuildConsole).head
			console?.println(
				'[' + Thread.currentThread.name + '] ' + switch it {
					Throwable:
						stackTraceAsString
					default:
						it.toString
				}
			)
			consoleManager.showConsoleView(console)
		}
		
		def registerDelegate(IBuildLogger delegate) {
			Logger.delegate = delegate
		}
	}
}

