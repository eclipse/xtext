/** 
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.build

import com.intellij.openapi.components.AbstractProjectComponent
import com.intellij.openapi.editor.EditorFactory
import com.intellij.openapi.editor.event.DocumentAdapter
import com.intellij.openapi.editor.event.DocumentEvent
import com.intellij.openapi.fileEditor.FileDocumentManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFileAdapter
import com.intellij.openapi.vfs.VirtualFileEvent
import com.intellij.openapi.vfs.VirtualFileManager
import com.intellij.openapi.vfs.VirtualFileMoveEvent
import org.eclipse.xtext.resource.IResourceDescriptions

class XtextCompilerComponent extends AbstractProjectComponent {
	XtextAutoBuilder autoBuilder
	VirtualFileAdapter virtualFileListener
	DocumentAdapter documentListener

	new(Project project) {
		super(project)
		autoBuilder = new XtextAutoBuilder(project)
		documentListener = new DocumentAdapter() {
			override void documentChanged(DocumentEvent event) {
				var file = FileDocumentManager.getInstance().getFile(event.getDocument())
				autoBuilder.fileModified(file)
			}
		}
		EditorFactory.getInstance().getEventMulticaster().addDocumentListener(documentListener, project)
		virtualFileListener = new VirtualFileAdapter() {
			override void contentsChanged(VirtualFileEvent event) {
				autoBuilder.fileModified(event.getFile())
			}

			override void fileCreated(VirtualFileEvent event) {
				autoBuilder.fileAdded(event.getFile())
			}

			override void fileDeleted(VirtualFileEvent event) {
				autoBuilder.fileDeleted(event.getFile())
			}

			override void fileMoved(VirtualFileMoveEvent event) {
				// TODO deal with that!
			}
		}
		VirtualFileManager.getInstance().addVirtualFileListener(virtualFileListener, project)
	}
	
	override String getComponentName() {
		return "Xtext Compiler Component"
	}
	
	def IResourceDescriptions getResourceDescriptions() {
		autoBuilder.getResourceDescriptions()
	}
	

}
