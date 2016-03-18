/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.hierarchy

import com.google.inject.Inject
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider
import org.eclipse.jface.viewers.LabelProvider
import org.eclipse.jface.viewers.StyledString
import org.eclipse.xtext.ui.editor.hierarchy.DeferredHierarchyBuilder.DeferredHierarchyNode

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
class XtextCallHierarchyLabelProvider extends LabelProvider implements IStyledLabelProvider {

	@Inject
	HierarchyLabelProvider hierarchyLabelProvider

	override getImage(Object element) {
		return hierarchyLabelProvider.getImage(element)
	}

	def dispatch String getText(Object element) {
		return hierarchyLabelProvider.getText(element)
	}

	def dispatch String getText(DeferredHierarchyNode it) {
		return delegate.text
	}

	def dispatch String getText(XtextCallHierarchyNode it) {
		if (element === null)
			return hierarchyLabelProvider.getText(it)

		return #[element.qualifiedName, grammarDescription?.qualifiedName].filterNull.join(' - ')
	}

	def dispatch StyledString getStyledText(Object element) {
		return hierarchyLabelProvider.getStyledText(element)
	}

	def dispatch StyledString getStyledText(DeferredHierarchyNode it) {
		return delegate.styledText
	}

	def dispatch StyledString getStyledText(XtextCallHierarchyNode it) {
		if (element === null)
			return hierarchyLabelProvider.getStyledText(it)

		val styledString = new StyledString('' + element.qualifiedName)
		if (grammarDescription === null)
			return styledString

		return styledString.append(
			new StyledString(' - ' + grammarDescription.qualifiedName, StyledString.QUALIFIER_STYLER)
		)
	}

}
