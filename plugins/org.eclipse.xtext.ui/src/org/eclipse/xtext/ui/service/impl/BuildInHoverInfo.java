/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.service.Inject;
import org.eclipse.xtext.ui.editor.model.IEditorModelProvider;
import org.eclipse.xtext.ui.editor.utils.EditorModelUtil;
import org.eclipse.xtext.ui.service.IHoverInfo;
import org.eclipse.xtext.ui.service.ILabelProvider;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class BuildInHoverInfo implements IHoverInfo {
	private ILabelProvider labelProvider;

	public void createContents(EObject input, IContentContainer contentContainer) {
		Image icon = labelProvider.getIcon(input);
		contentContainer.appendImage(icon);

		StyledString ss = labelProvider.getLabel(input);
		String additionalInfo = getAdditionalInfo(input);
		System.out.println("BuildInHoverInfo.createContents()" + additionalInfo);
		ss.append("\n" + "\t\t\t" + additionalInfo);
		contentContainer.appendText(ss);

	}

	public EObject getHoverInfo(ITextViewer textViewer, int offset, IEditorModelProvider editorModelProvider) {
		AbstractNode an = EditorModelUtil.findLeafNodeAtOffset(editorModelProvider.getModel().getParseTreeRootNode(),
				offset);
		return an;
	}

	public List<IAction> getHoverActions(EObject input) {
		List<IAction> retVal = new ArrayList<IAction>();
		Action action = new Action("Coole Action") {
			@Override
			public void run() {
				System.out.println("XtextTextHover.run(): Coole action macht gerade was ganz cooles!");
			}
		};
		action.setEnabled(true);
		action.setImageDescriptor(ImageDescriptor.createFromImage(PlatformUI.getWorkbench().getSharedImages().getImage(
				ISharedImages.IMG_OBJ_FILE)));
		Action action2 = new Action("Das ist ein Drucker") {
		};
		action2.setEnabled(true);
		action2.setImageDescriptor(ImageDescriptor.createFromImage(PlatformUI.getWorkbench().getSharedImages()
				.getImage(ISharedImages.IMG_ETOOL_PRINT_EDIT)));
		retVal.add(action);
		retVal.add(action2);
		return retVal;
	}

	/*
	 * TODO following is just fake stuff, replace with something like
	 * ILabelProivider.additionalInfo(EObject eo)
	 */

	private String getAdditionalInfo(EObject eObject) {
		StringBuilder sb = new StringBuilder();
		if (eObject instanceof LeafNode) {
			LeafNode leaf = (LeafNode) eObject;
			if (!leaf.isHidden()) {
				grammarEleToString(leaf.getGrammarElement(), sb);
				sb.append(" ");
				handleFeatured(leaf, sb);
				sb.append(leaf.getText());
				handleCoordinaten(leaf, sb);
				handleParent(leaf.getParent(), sb);
			}
		}
		return sb.toString();

	}

	private void handleCoordinaten(AbstractNode abstractNode, StringBuilder sb) {
		sb.append(" [" + abstractNode.offset() + "," + abstractNode.length() + "]");
	}

	private void handleParent(CompositeNode parent, StringBuilder sb) {
		sb.append("\n" + "\t\t\t" + "Parent: ");
		grammarEleToString(parent.getGrammarElement(), sb);
		handleCoordinaten(parent, sb);
	}

	private void grammarEleToString(EObject grammarElement, StringBuilder sb) {
		if (grammarElement instanceof RuleCall)
			sb.append("Rule call '" + ((RuleCall) grammarElement).getName() + "'");
		if (grammarElement instanceof ParserRule)
			sb.append("Parser rule '" + ((ParserRule) grammarElement).getName() + "'");
		if (grammarElement instanceof Keyword)
			sb.append("Keyword '" + ((Keyword) grammarElement).getValue() + "'");

	}

	private void handleFeatured(LeafNode leaf, StringBuilder sb) {
		if (leaf.getFeature() != null) {
			sb.append(" - ");
			grammarEleToString(leaf.getParent().getGrammarElement(), sb);
			sb.append(".");
			sb.append(leaf.getFeature());
			sb.append("\n" + "\t\t\t");
		}
	}

	@Inject
	public void setLabelProvider(ILabelProvider labelProvider) {
		this.labelProvider = labelProvider;
	}
}
