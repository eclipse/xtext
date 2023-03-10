/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.editor.hierarchy;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.xtext.ui.editor.hierarchy.DeferredHierarchyBuilder.DeferredHierarchyNode;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
public class XtextCallHierarchyLabelProvider extends LabelProvider implements IStyledLabelProvider {

	@Inject
	private HierarchyLabelProvider hierarchyLabelProvider;

	@Override
	public Image getImage(Object element) {
		return hierarchyLabelProvider.getImage(element);
	}

	@Override
	public String getText(Object obj) {
		Preconditions.checkNotNull(obj);

		if (obj instanceof XtextCallHierarchyNode) {
			return _getText((XtextCallHierarchyNode) obj);
		} else if (obj instanceof DeferredHierarchyNode) {
			return _getText((DeferredHierarchyNode) obj);
		} else {
			return _getText(obj);
		}
	}

	protected String _getText(Object element) {
		return hierarchyLabelProvider.getText(element);
	}

	protected String _getText(DeferredHierarchyNode hierarchyNode) {
		return getText(hierarchyNode.getDelegate());
	}

	protected String _getText(XtextCallHierarchyNode hierarchyNode) {
		if (hierarchyNode.getElement() == null) {
			return hierarchyLabelProvider.getText(hierarchyNode);
		}

		List<QualifiedName> qualifiedNames = Arrays.asList(hierarchyNode.getElement().getQualifiedName(),
				hierarchyNode.getGrammarDescription() != null ? hierarchyNode.getGrammarDescription().getQualifiedName() : null);
		return Joiner.on(" - ").join(Iterables.filter(qualifiedNames, Objects::nonNull));
	}

	@Override
	public StyledString getStyledText(Object obj) {
		Preconditions.checkNotNull(obj);

		if (obj instanceof XtextCallHierarchyNode) {
			return _getStyledText((XtextCallHierarchyNode) obj);
		} else if (obj instanceof DeferredHierarchyNode) {
			return _getStyledText((DeferredHierarchyNode) obj);
		} else {
			return _getStyledText(obj);
		}
	}

	protected StyledString _getStyledText(Object element) {
		return hierarchyLabelProvider.getStyledText(element);
	}

	protected StyledString _getStyledText(DeferredHierarchyNode hierarchyNode) {
		return getStyledText(hierarchyNode.getDelegate());
	}

	protected StyledString _getStyledText(XtextCallHierarchyNode hierarchyNode) {
		if (hierarchyNode.getElement() == null) {
			return hierarchyLabelProvider.getStyledText(hierarchyNode);
		}

		StyledString styledString = new StyledString("" + hierarchyNode.getElement().getQualifiedName());
		if (hierarchyNode.getGrammarDescription() == null) {
			return styledString;
		}

		return styledString
				.append(new StyledString(" - " + hierarchyNode.getGrammarDescription().getQualifiedName(), StyledString.QUALIFIER_STYLER));

	}

}
