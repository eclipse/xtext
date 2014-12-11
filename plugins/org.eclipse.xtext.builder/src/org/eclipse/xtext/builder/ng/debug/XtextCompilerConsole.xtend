/** 
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.ng.debug

import java.io.PrintStream
import org.eclipse.ui.console.ConsolePlugin
import org.eclipse.ui.console.IOConsole

import static extension com.google.common.base.Throwables.*

/** 
 * @author Jan Koehnlein - Initial contribution and API
 * @author Moritz Eysholdt
 */
class XtextCompilerConsole extends IOConsole {

	val PrintStream out

	new() {
		super("Xtext Compiler", "xtextCompilerConsole", null, true)
		new JobConsoleLogger
		this.out = new PrintStream(newOutputStream(), true)
	}

	def println(String it) {
		out.println(it)
	}

	static def log(Object it) {
		val consoleManager = ConsolePlugin.getDefault.consoleManager
		val console = consoleManager.consoles.filter(XtextCompilerConsole).head
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
}

