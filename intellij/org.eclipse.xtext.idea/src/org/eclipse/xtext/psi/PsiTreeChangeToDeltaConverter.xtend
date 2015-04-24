package org.eclipse.xtext.psi

import com.intellij.psi.impl.PsiTreeChangeEventImpl
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.idea.resource.impl.PsiFileBasedResourceDescription
import org.eclipse.xtext.psi.impl.BaseXtextFile
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.IResourceDescription.Delta

interface PsiTreeChangeToDeltaConverter {

	def List<Delta> convert(PsiTreeChangeEventImpl event)

}

class PsiTreeChangeToDeltaConverterImpl implements PsiTreeChangeToDeltaConverter {

	val descriptions = <URI, IResourceDescription>newHashMap

	override convert(PsiTreeChangeEventImpl event) {
		if (event == null) {
			return emptyList
		}
		if (!event.genericChange) {
			return emptyList
		}
		switch event.code {
			case BEFORE_CHILD_ADDITION,
			case BEFORE_CHILD_REMOVAL,
			case BEFORE_CHILD_REPLACEMENT,
			case BEFORE_CHILD_MOVEMENT,
			case BEFORE_CHILDREN_CHANGE,
			case BEFORE_PROPERTY_CHANGE: {
				val file = event.file
				if (file instanceof BaseXtextFile) {
					val description = new PsiFileBasedResourceDescription(file)
					descriptions.put(description.URI, description)
				}
				return emptyList
			}
			case CHILD_ADDED,
			case CHILD_REMOVED,
			case CHILD_REPLACED,
			case CHILD_MOVED,
			case CHILDREN_CHANGED,
			case PROPERTY_CHANGED: {
				val file = event.file
				if (file instanceof BaseXtextFile) {
					val newDescription = new PsiFileBasedResourceDescription(file)
					val oldDescription = descriptions.remove(newDescription.URI)
					val manager = file.resource.resourceServiceProvider.resourceDescriptionManager
					#[manager.createDelta(oldDescription, newDescription)]
				} else
					emptyList
			}
		}
	}

}