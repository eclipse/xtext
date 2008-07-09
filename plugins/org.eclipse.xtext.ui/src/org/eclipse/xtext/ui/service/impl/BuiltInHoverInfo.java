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
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.ISourceViewerExtension2;
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
public class BuiltInHoverInfo implements IHoverInfo {
	private ILabelProvider labelProvider;

	public void createContents(Object objectInput, IContentContainer contentContainer) {
		if (objectInput instanceof EObject) {
			EObject input = (EObject) objectInput;
			Image icon = labelProvider.getIcon(input);
			contentContainer.appendImage(icon);
			if (input instanceof AbstractNode) {
				AbstractNode node = (AbstractNode) input;
				node.getSyntaxError();
			}
			StyledString ss = labelProvider.getLabel(input);
			String additionalInfo = getAdditionalInfo(input);
			ss.append("\n" + "\t\t\t" + additionalInfo);
			contentContainer.appendText(ss);
		}
		else if (objectInput instanceof StyledString) {
			contentContainer.appendText((StyledString) objectInput);
		}
	}

	public Object getHoverInfo(ITextViewer textViewer, IRegion hoverRegion, IEditorModelProvider editorModelProvider) {
		int offset = hoverRegion.getOffset();
		AbstractNode an = EditorModelUtil.findLeafNodeAtOffset(editorModelProvider.getModel().getParseTreeRootNode(),
				offset);
		StyledString existingInfo = null;
		if (textViewer instanceof ISourceViewerExtension2) {
			IAnnotationModel model = ((ISourceViewerExtension2) textViewer).getVisualAnnotationModel();
			if (model != null) {
				Iterator<?> e = model.getAnnotationIterator();
				while (e.hasNext()) {
					Annotation a = (Annotation) e.next();
					if ("org.eclipse.ui.workbench.texteditor.error".equals(a.getType())
							|| "org.eclipse.ui.workbench.texteditor.warning".equals(a.getType())) {
						Position p = model.getPosition(a);
						if (p != null && p.overlapsWith(offset, hoverRegion.getLength())) {
							String msg = a.getText();
							if (msg != null && msg.trim().length() > 0)
								existingInfo = new StyledString(msg);
						}
					}
				}
			}
		}
		if (existingInfo != null)
			return existingInfo;
		return an;
	}

	public List<IAction> getHoverActions(Object input) {
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
		sb.append(" [" + abstractNode.getOffset() + "," + abstractNode.getLength() + "]");
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
