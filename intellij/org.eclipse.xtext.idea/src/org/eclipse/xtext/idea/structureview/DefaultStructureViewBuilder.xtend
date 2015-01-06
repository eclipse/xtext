package org.eclipse.xtext.idea.structureview

import com.google.inject.Inject
import com.intellij.ide.structureView.StructureView

class DefaultStructureViewBuilder extends AbstractStructureViewBuilder {
	
	@Inject
	IStructureViewTreeElementProvider structureViewTreeElementProvider
	
	override createStructureViewTreeElementProvider() {
		structureViewTreeElementProvider
	}
	
	override configureStructureViewTreeElementProvider(IStructureViewTreeElementProvider structureViewTreeElementProvider, XtextFileTreeModel model, StructureView view) {
		
	}
	
}