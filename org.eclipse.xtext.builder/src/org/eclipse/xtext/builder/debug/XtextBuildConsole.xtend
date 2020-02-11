/** 
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.builder.debug

import com.google.inject.Singleton
import java.io.PrintStream
import org.eclipse.jface.resource.ImageDescriptor
import org.eclipse.ui.console.ConsolePlugin
import org.eclipse.ui.console.IConsoleFactory
import org.eclipse.ui.console.IOConsole
import org.eclipse.xtext.builder.internal.Activator

import static extension com.google.common.base.Throwables.*

/** 
 * @author Jan Koehnlein - Initial contribution and API
 * @author Moritz Eysholdt
 */
class XtextBuildConsole extends IOConsole {

	val PrintStream out

	new() {
		super("Xtext Build", "xtextBuildConsole",
			ImageDescriptor.createFromURL(Activator.^default.bundle.getEntry("icons/console.png")), true)
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
			if(delegate !== null)
				delegate.log(it)
			val consoleManager = ConsolePlugin.getDefault.consoleManager
			val console = consoleManager.consoles.filter(XtextBuildConsole).head
			if (console !== null) {
				console.println(
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
		
		def registerDelegate(IBuildLogger delegate) {
			Logger.delegate = delegate
		}
	}
}

