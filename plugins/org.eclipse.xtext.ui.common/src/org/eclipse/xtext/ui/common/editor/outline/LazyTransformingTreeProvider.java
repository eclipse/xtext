/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.outline;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILazyTreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.core.editor.model.UnitOfWork;
import org.eclipse.xtext.ui.core.editor.model.XtextDocument;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class LazyTransformingTreeProvider extends LabelProvider implements ILazyTreeContentProvider, ILabelProvider {

	private final static Logger logger = Logger.getLogger(LazyTransformingTreeProvider.class);

	private TreeViewer viewer;
	private ContentOutlineNode outlineModel;

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		Assert.isTrue(viewer instanceof TreeViewer);
		this.viewer = (TreeViewer) viewer;
		
		if (newInput instanceof XtextDocument) {
			XtextDocument document = (XtextDocument) newInput;
			outlineModel = document.readOnly(new UnitOfWork<ContentOutlineNode>() {
				public ContentOutlineNode exec(XtextResource resource) throws Exception {
					EObject semanticModelRoot = resource.getParseResult().getRootASTElement();
					return transformSemanticModelToOutlineModel(semanticModelRoot);
				}
			});
		}
	}

	public abstract class AbstractSemanticModelTransformer {

		public ContentOutlineNode transformSemanticModel(EObject semanticModel) {
			ContentOutlineNode outlineModel = new ContentOutlineNode();
			outlineModel.setLabel("Invisible Root Node");
			
//			OutlineNodeAdapter adapter = (OutlineNodeAdapter) OutlineNodeAdapterFactory.INSTANCE.adapt(semanticModel, ContentOutlineNode.class);
//			adapter.setOutlineNode(outlineModel);
//			adapter.setTransformer(this);

			transformSemanticNode(semanticModel, outlineModel);
			return outlineModel;
		}

		public void transformSemanticNode(EObject semanticNode, ContentOutlineNode outlineParentNode) {
			if (consumeSemanticNode(semanticNode)) {
				ContentOutlineNode outlineNode = createOutlineNode(semanticNode, outlineParentNode);

//				OutlineNodeAdapter adapter = (OutlineNodeAdapter) OutlineNodeAdapterFactory.INSTANCE.adapt(semanticNode, ContentOutlineNode.class);
//				adapter.setOutlineNode(outlineNode);
//				adapter.setTransformer(this);
				
				transformSemanticChildNodes(semanticNode, outlineNode);
			}
		}
		
		private void transformSemanticChildNodes(EObject semanticNode, ContentOutlineNode outlineNode) {
			if (consumeSemanticChildNodes(semanticNode)) {
				for (Iterator<EObject> iterator = semanticNode.eContents().iterator(); iterator.hasNext();) {
					EObject semanticChildNode = iterator.next();
					transformSemanticNode(semanticChildNode, outlineNode);
				}
			}
		}

		protected abstract ContentOutlineNode createOutlineNode(EObject semanticNode,
				ContentOutlineNode outlineParentNode);

		protected abstract boolean consumeSemanticChildNodes(EObject semanticNode);

		protected abstract boolean consumeSemanticNode(EObject semanticNode);

		protected String getText(Object object) {
			EObject eObject = (EObject) object;
			EClass eClass = eObject.eClass();

			EStructuralFeature feature = getLabelFeature(eClass);
			if (feature != null) {
				Object value = eObject.eGet(feature);
				if (value != null) {
					return value.toString();
				}
			}
			return "<unknown>";
		}

		protected EStructuralFeature getLabelFeature(EClass eClass) {
			EAttribute result = null;
			for (EAttribute eAttribute : eClass.getEAllAttributes()) {
				if (!eAttribute.isMany() && eAttribute.getEType().getInstanceClass() != FeatureMap.Entry.class) {
					if ("name".equalsIgnoreCase(eAttribute.getName())) {
						result = eAttribute;
						break;
					}
					else if (result == null) {
						result = eAttribute;
					}
					else if (eAttribute.getEAttributeType().getInstanceClass() == String.class
							&& result.getEAttributeType().getInstanceClass() != String.class) {
						result = eAttribute;
					}
				}
			}
			return result;
		}

		public void updateOutlineNode(EObject semanticNode, ContentOutlineNode outlineNode) {
			outlineNode.setLabel(getText(semanticNode));
		}

	}

	public class DefaultSemanticModelTransformer extends AbstractSemanticModelTransformer {
		public boolean consumeSemanticNode(EObject semanticNode) {
			String name = semanticNode.eClass().getName();
			if (logger.isDebugEnabled()) {
				logger.debug("Consume semantic node type [" + name + "]?");
			}
			return true;
		}

		public boolean consumeSemanticChildNodes(EObject semanticNode) {
			String name = semanticNode.eClass().getName();
			if (logger.isDebugEnabled()) {
				logger.debug("Consume semantic chidlren of node type [" + name + "]?");
			}
			return true;
		}

		@Override
		protected ContentOutlineNode createOutlineNode(EObject semanticNode, ContentOutlineNode outlineParentNode) {
			ContentOutlineNode outlineNode = new ContentOutlineNode();

			outlineNode.setLabel(getText(semanticNode));
			outlineNode.setImage("DefaultOutlineNode");
			outlineNode.setSemanticNode(semanticNode);
			outlineParentNode.getChildren().add(outlineNode);
			outlineNode.setParent(outlineParentNode);

			return outlineNode;
		}
	}

	private ContentOutlineNode transformSemanticModelToOutlineModel(EObject semanticModel) {
		return new DefaultSemanticModelTransformer().transformSemanticModel(semanticModel);
	}

	public void dispose() {
	}

	public Object getParent(Object element) {
		if (element instanceof ContentOutlineNode) {
			return ((ContentOutlineNode) element).getParent();
		}
		return outlineModel;
	}

	public void updateChildCount(Object element, int currentChildCount) {
		int length = 0;
		if (element instanceof IXtextDocument) {
			length = outlineModel.getChildren().size();
		}
		else if (element instanceof ContentOutlineNode) {
			ContentOutlineNode node = (ContentOutlineNode) element;
			length = node.getChildren().size();
		}
		viewer.setChildCount(element, length);
	}

	public void updateElement(Object parent, int index) {
		if (logger.isDebugEnabled()) {
			logger.debug("Updating tree element at index [" + index + "]");
		}
		Object element = null;
		if (parent instanceof IXtextDocument) {
			element = outlineModel.getChildren().get(index);
		}
		else if (parent instanceof ContentOutlineNode) {
			element = ((ContentOutlineNode) parent).getChildren().get(index);
		}
		viewer.replace(parent, index, element);
		updateChildCount(element, -1);
	}
	
	@Override
	public String getText(Object element) {
		if (element instanceof ContentOutlineNode) {
			ContentOutlineNode contentOutlineNode = (ContentOutlineNode) element;
			return contentOutlineNode.getLabel();
		}
		return super.getText(element);
	}
	
	@Override
	public Image getImage(Object element) {
		if (element instanceof ContentOutlineNode) {
			ContentOutlineNode contentOutlineNode = (ContentOutlineNode) element;
			// TODO load image
		}
		return super.getImage(element);
	}

}
