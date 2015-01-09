package org.eclipse.xtext.idea.structureview

import com.intellij.ide.structureView.StructureView
import com.intellij.ide.structureView.StructureViewFactory
import com.intellij.openapi.Disposable
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.fileEditor.FileEditor
import com.intellij.openapi.fileEditor.TextEditor
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Disposer
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.psi.impl.BaseXtextFile

abstract class AbstractStructureViewBuilder implements XtextFileAwareStructureViewBuilder {

	@Accessors
	BaseXtextFile xtextFile

	override createStructureView(FileEditor fileEditor, Project project) {
		val editor = if(fileEditor instanceof TextEditor) fileEditor.editor else null
		val model = createStructureViewModel(editor)

		val structureViewTreeElementProvider = createStructureViewTreeElementProvider
		model.structureViewTreeElementProvider = structureViewTreeElementProvider

		var view = StructureViewFactory.getInstance(project).createStructureView(fileEditor, model, project, false)
		structureViewTreeElementProvider.configureStructureViewTreeElementProvider(model, view)

		Disposer.register(view, new Disposable() {
			@Override override void dispose() {
				model.dispose()
			}
		})
		return view
	}

	def XtextFileTreeModel createStructureViewModel(Editor editor) {
		new XtextFileTreeModel(xtextFile, editor)
	}

	def IStructureViewTreeElementProvider createStructureViewTreeElementProvider()

	def void configureStructureViewTreeElementProvider(
		IStructureViewTreeElementProvider structureViewTreeElementProvider,
		XtextFileTreeModel model,
		StructureView view
	)

}