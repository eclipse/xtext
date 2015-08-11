/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.config

import com.intellij.openapi.roots.libraries.LibraryKind
import com.intellij.openapi.roots.libraries.LibraryPresentationProvider
import com.intellij.openapi.roots.libraries.LibraryUtil
import com.intellij.openapi.vfs.VirtualFile
import java.util.List
import org.eclipse.xtend.core.idea.icons.XtendIcons
import org.eclipse.xtend.core.idea.lang.XtendLanguage

/**
 * @author kosyakov - Initial contribution and API
 */
class XtendLibraryPresentationProvider extends LibraryPresentationProvider<XtendLibraryProperties> {

	public static val LIBRARY_KIND = LibraryKind.create(XtendLanguage.INSTANCE.ID)

	new() {
		super(LIBRARY_KIND)
	}

	override detect(List<VirtualFile> classesRoots) {
		val detectorClasses = XtendLibraryDescription.detectorClasses
		if (detectorClasses.size === classesRoots.size && detectorClasses.forall [
			LibraryUtil.isClassAvailableInLibrary(classesRoots, it.name)
		]) {
			return new XtendLibraryProperties
		}
	}

	override getIcon() {
		XtendIcons.Xtend_ICON
	}

}