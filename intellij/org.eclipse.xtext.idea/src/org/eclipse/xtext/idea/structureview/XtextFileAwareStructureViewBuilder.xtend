package org.eclipse.xtext.idea.structureview

import com.google.inject.ImplementedBy
import com.intellij.ide.structureView.StructureViewBuilder
import org.eclipse.xtext.psi.impl.BaseXtextFile

@ImplementedBy(DefaultStructureViewBuilder)
interface XtextFileAwareStructureViewBuilder extends StructureViewBuilder {
	def void setXtextFile(BaseXtextFile file)
}