/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.selection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IAction;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;

import com.google.inject.Inject;

/**
 * @author Michael Clay - Initial contribution and API
 */
public abstract class AbstractNodeSelectionProvider implements INodeSelectionProvider {
	@Inject
	private ILocationInFileProvider locationProvider;

	public ILocationInFileProvider getLocationProvider() {
		return locationProvider;
	}

	public ITextRegion select(String selectionType, ICompositeNode rootNode, ITextRegion currentTextRegion) {
		return ITextRegion.EMPTY_REGION;
	}

	public void initialize(XtextEditor xtextEditor) {
		SelectionHistory selectionHistory = (SelectionHistory) xtextEditor.getAdapter(SelectionHistory.class);
		initialize(xtextEditor, selectionHistory);
	}

	protected abstract void initialize(XtextEditor xtextEditor, SelectionHistory selectionHistory);

	protected void setAction(XtextEditor xtextEditor, IAction action, String actionDefinitionId) {
		action.setActionDefinitionId(actionDefinitionId);
		xtextEditor.setAction(actionDefinitionId, action);
	}

	protected ITextRegion getTextRegion(EObject eObject) {
		return locationProvider.getFullTextRegion(eObject);
	}

	protected ITextRegion getTextRegion(INode node) {
		return new TextRegion(node.getOffset(), node.getLength());
	}

	/**
	 * @return true if eObject <i>starts</i> at an offset less than that of the given region
	 */
	protected boolean lessThanOffset(EObject eObject, ITextRegion region) {
		return locationProvider.getFullTextRegion(eObject).getOffset() < region.getOffset();
	}

	/**
	 * @return true if eObject <i>starts</i> at the same offset as the one of the given region
	 */
	protected boolean equalsOffset(EObject eObject, ITextRegion region) {
		return locationProvider.getFullTextRegion(eObject).getOffset() == region.getOffset();
	}

	/**
	 * @return true if eObject <i>ends</i> at an offset less than that of the given region
	 */
	protected boolean lessThanEndOffset(EObject eObject, ITextRegion region) {
		return getEndOffset(locationProvider.getFullTextRegion(eObject)) < getEndOffset(region);
	}

	/**
	 * @return true if eObject <i>end</i> at the same endOffset as the one of the given region
	 */
	protected boolean equalsEndOffset(EObject eObject, ITextRegion region) {
		return getEndOffset(locationProvider.getFullTextRegion(eObject)) == getEndOffset(region);
	}

	protected boolean isEmptyOrNull(ITextRegion textRegion) {
		return textRegion == null || ITextRegion.EMPTY_REGION == textRegion;
	}

	protected int getEndOffset(ITextRegion region) {
		return region.getOffset() + region.getLength();
	}
}
