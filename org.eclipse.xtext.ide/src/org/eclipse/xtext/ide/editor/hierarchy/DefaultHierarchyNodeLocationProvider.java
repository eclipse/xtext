/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.editor.hierarchy;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.util.TextRegionWithLineInformation;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
@Singleton
public class DefaultHierarchyNodeLocationProvider implements IHierarchyNodeLocationProvider {
	@Inject
	protected ILocationInFileProvider locationInFileProvider;

	@Override
	public ITextRegionWithLineInformation getTextRegion(EObject obj) {
		if (obj == null) {
			return ITextRegionWithLineInformation.EMPTY_REGION;
		}
		ITextRegion textRegion = locationInFileProvider.getSignificantTextRegion(obj);
		return toTextRegionWithLineInformation(obj, textRegion);
	}

	@Override
	public ITextRegionWithLineInformation getTextRegion(EObject owner, EStructuralFeature feature, int indexInList) {
		if (owner == null) {
			return ITextRegionWithLineInformation.EMPTY_REGION;
		}
		ITextRegion textRegion = locationInFileProvider.getSignificantTextRegion(owner, feature, indexInList);
		return toTextRegionWithLineInformation(owner, textRegion);
	}

	protected ITextRegionWithLineInformation toTextRegionWithLineInformation(EObject obj, ITextRegion textRegion) {
		if (textRegion == null) {
			return ITextRegionWithLineInformation.EMPTY_REGION;
		}
		if (textRegion instanceof ITextRegionWithLineInformation) {
			return (ITextRegionWithLineInformation) textRegion;
		}
		ICompositeNode node = NodeModelUtils.getNode(obj);
		if (node == null) {
			return new TextRegionWithLineInformation(textRegion.getOffset(), textRegion.getLength(), 0, 0);
		}
		int startLine = NodeModelUtils.getLineAndColumn(node, textRegion.getOffset()).getLine() - 1;
		int endLine = NodeModelUtils.getLineAndColumn(node, textRegion.getOffset() + textRegion.getLength()).getLine()
				- 1;
		return new TextRegionWithLineInformation(textRegion.getOffset(), textRegion.getLength(), startLine, endLine);
	}
}
