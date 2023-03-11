/*******************************************************************************
 * Copyright (c) 2013, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.hyperlinking

import com.google.inject.Inject
import org.eclipse.debug.core.ILaunch
import org.eclipse.debug.core.model.IProcess
import org.eclipse.debug.core.sourcelookup.AbstractSourceLookupDirector
import org.eclipse.debug.ui.IDebugUIConstants
import org.eclipse.jface.text.BadLocationException
import org.eclipse.ui.IWorkbench
import org.eclipse.ui.console.IHyperlink
import org.eclipse.ui.console.IPatternMatchListenerDelegate
import org.eclipse.ui.console.PatternMatchEvent
import org.eclipse.ui.console.TextConsole
import org.eclipse.core.resources.IFile
import org.eclipse.ui.ide.IDE
import org.eclipse.xtext.ui.editor.XtextEditor

class ConsoleHyperlinking implements IPatternMatchListenerDelegate {

	TextConsole console
	@Inject(optional=true) IWorkbench workbench;

	override matchFound(PatternMatchEvent event) {
       	try {
            val offset = event.getOffset();
            val length = event.getLength();
            val link = new XtendFileHyperlink(console.document.get(offset, length), workbench, console);
            console.addHyperlink(link, offset, length);   
        } catch (BadLocationException | NumberFormatException e) {
        }
    }


	override connect(TextConsole console) {
		this.console = console
	}
	
	override disconnect() {
		this.console = null
	}
	
}

class XtendFileHyperlink implements IHyperlink {
	
	String fileName
	int lineNumber
	IWorkbench workbench
	TextConsole console
	
	new (String fileName, IWorkbench workbench, TextConsole console) {
		val indexOfColon = fileName.indexOf(":")
		if (indexOfColon != -1) {
			this.fileName = fileName.substring(0, indexOfColon)
			this.lineNumber = Integer.valueOf(fileName.substring(indexOfColon+1))
		} else {
			this.fileName = fileName
		}
		this.workbench = workbench
		this.console = console
	}
	
	override linkActivated() {
		try {
			switch l : launch?.sourceLocator {
				AbstractSourceLookupDirector : {
					val result = l.getSourceElement(fileName)
					switch result {	IFile : {
						val editor = IDE.openEditor(workbench.activeWorkbenchWindow.activePage, result)
						switch editor { XtextEditor : {
							val region = editor.document.getLineInformation(lineNumber - 1)
							editor.selectAndReveal(region.offset, region.length)
						}}
					}}
				}
			}
		} catch (NumberFormatException e) {
			// ignore
		}
	}
	
	override linkEntered() {
	}
	
	override linkExited() {
	}
	
	def private ILaunch getLaunch() {
		val process = console.getAttribute(IDebugUIConstants.ATTR_CONSOLE_PROCESS) as IProcess
		if (process !== null) {
		    return process.getLaunch();
		}
		return null;
	}
}