/** 
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.ng.debug

import org.eclipse.jface.text.rules.FastPartitioner
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner
import org.eclipse.ui.console.IConsoleDocumentPartitioner
import org.eclipse.ui.console.TextConsole
import static extension com.google.common.base.Throwables.*
import org.eclipse.ui.console.ConsolePlugin

/** 
 * @author Jan Koehnlein - Initial contribution and API
 */
class XtextCompilerConsole extends TextConsole {

	Partitioner partitioner

	new() {
		super("Xtext Compiler", "xtextCompilerConsole", null, true)
		partitioner = new Partitioner(this)
		partitioner.connect(document)
	}

	override protected getPartitioner() {
		return partitioner
	}

	static class Partitioner extends FastPartitioner implements IConsoleDocumentPartitioner {
		new(XtextCompilerConsole console) {
			super(new RuleBasedPartitionScanner, null)
			console.document.documentPartitioner = this
		}

		override isReadOnly(int offset) {
			true
		}

		override getStyleRanges(int offset, int length) {
			null
		}
	}
	
	def println(String it) {
		document.replace(document.length, 0, it)
	}
	
	static def log(Object it) {
		val console = ConsolePlugin.getDefault.consoleManager.consoles.filter(XtextCompilerConsole).head
		console?.println(
			switch it {
				Throwable: 
					stackTraceAsString
				default:
					it.toString
			}
		)
	}
}
