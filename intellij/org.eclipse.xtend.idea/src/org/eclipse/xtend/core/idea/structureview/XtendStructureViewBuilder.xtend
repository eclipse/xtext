/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.structureview

import com.google.inject.Inject
import com.google.inject.Provider
import com.intellij.ide.structureView.impl.StructureViewComposite
import com.intellij.ide.structureView.impl.StructureViewComposite.StructureViewDescriptor
import com.intellij.openapi.fileEditor.FileEditor
import com.intellij.openapi.project.Project
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.idea.structureview.XtextFileAwareStructureViewBuilder
import org.eclipse.xtext.psi.impl.BaseXtextFile

/**
 * @author kosyakov - Initial contribution and API
 */
class XtendStructureViewBuilder implements XtextFileAwareStructureViewBuilder {

	@Accessors
	BaseXtextFile xtextFile

	@Inject
	Provider<XtendJvmStructureViewBuilder> xtendJvmStructureViewBuilderProvider

	@Inject
	Provider<XtendSourceStructureViewBuilder> xtendSourceStructureViewBuilderProvider

	override createStructureView(FileEditor fileEditor, Project project) {
		val xtendSourceStructureViewBuilder = xtendSourceStructureViewBuilderProvider.get => [ builder |
			builder.xtextFile = xtextFile
		]
		val xtendJvmStructureViewBuilder = xtendJvmStructureViewBuilderProvider.get => [ builder |
			builder.xtextFile = xtextFile
		]
		new StructureViewComposite(
			new StructureViewDescriptor(
				'Xtend View',
				xtendSourceStructureViewBuilder.createStructureView(fileEditor, project),
				null
			),
			new StructureViewDescriptor(
				'JVM View',
				xtendJvmStructureViewBuilder.createStructureView(fileEditor, project),
				null
			)
		)
	}

}