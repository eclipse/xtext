/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.config

import com.google.common.collect.Lists
import com.intellij.openapi.roots.OrderRootType
import com.intellij.openapi.roots.libraries.LibraryPresentationProvider
import com.intellij.openapi.roots.libraries.NewLibraryConfiguration
import com.intellij.openapi.roots.ui.configuration.libraries.CustomLibraryDescription
import com.intellij.openapi.roots.ui.configuration.libraryEditor.LibraryEditor
import com.intellij.openapi.roots.ui.configuration.projectRoot.LibrariesContainer
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.util.containers.ContainerUtil
import java.io.File
import javax.swing.JComponent
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder

import static extension com.intellij.openapi.vfs.VfsUtil.*
import static extension com.intellij.util.PathUtil.*

/**
 * @author kosyakov - Initial contribution and API
 */
class XtendLibraryDescription extends CustomLibraryDescription {

	public static val LIBRARY_KINDS = providers.map[kind].toSet
	public static val XTEND_LIBRARY_NAME = 'Xtend Library'

	override createNewLibrary(JComponent parentComponent, VirtualFile contextDirectory) {
		val provider = providers.head
		if (provider == null) {
			return null
		}
		new NewLibraryConfiguration(XTEND_LIBRARY_NAME) {

			override addRoots(LibraryEditor editor) {
				editor.addRoot(Lists.urlForLibraryRoot, OrderRootType.CLASSES)
				editor.addRoot(ToStringBuilder.urlForLibraryRoot, OrderRootType.CLASSES)
				editor.addRoot(Active.urlForLibraryRoot, OrderRootType.CLASSES)
				editor.addRoot(Data.urlForLibraryRoot, OrderRootType.CLASSES)
			}

		}
	}

	override getSuitableLibraryKinds() {
		LIBRARY_KINDS
	}

	override getDefaultLevel() {
		LibrariesContainer.LibraryLevel.GLOBAL
	}

	protected def getUrlForLibraryRoot(Class<?> clazz) {
		val libraryRoot = new File(clazz.jarPathForClass)
		LocalFileSystem.instance.refreshAndFindFileByIoFile(libraryRoot)
		libraryRoot.urlForLibraryRoot
	}

	protected static def getProviders() {
		ContainerUtil.findAll(LibraryPresentationProvider.EP_NAME.extensions, XtendLibraryPresentationProvider)
	}

}