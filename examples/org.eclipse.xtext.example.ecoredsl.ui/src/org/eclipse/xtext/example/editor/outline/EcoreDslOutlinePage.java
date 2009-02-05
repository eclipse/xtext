/*******************************************************************************
 * Copyright (c) 2008 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.example.editor.outline;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ui.common.editor.outline.ContentOutlineNode;
import org.eclipse.xtext.ui.common.editor.outline.XtextContentOutlinePage;
import org.eclipse.xtext.ui.common.editor.outline.impl.DefaultSemanticModelTransformer;

/**
 * Content outline page used to setup and adapt the existing ecore provider implementations for the ecore dsl.
 *  
 * @author Michael Clay - Initial contribution and API
 */
public class EcoreDslOutlinePage extends XtextContentOutlinePage {
	
	
	protected void xconfigureProviders() {
		//getTreeViewer().setContentProvider(provider);
		getTreeViewer().setLabelProvider(new AdapterFactoryLabelProvider(new EcoreItemProviderAdapterFactory() {}) {
			
			@Override
			public String getText(Object object) {
				return super.getText(((ContentOutlineNodeWrapper)object).getEObject());
			}
			@Override
			public Image getImage(Object object) {
				return super.getImage(((ContentOutlineNodeWrapper)object).getEObject());
			}
		});
	}
	
	// todo: clean up hack
	public static class EcoreSemanticModelTransformer extends DefaultSemanticModelTransformer {
		@Override
		public ContentOutlineNode transformSemanticModel(EObject semanticModel) {
			ContentOutlineNode outlineModel = new ContentOutlineNode();
			outlineModel.setLabel("Invisible Root Node");
			ContentOutlineNodeWrapper outlineParentNode = new ContentOutlineNodeWrapper(semanticModel,outlineModel);
			transformSemanticNode(semanticModel, outlineParentNode);
			return outlineParentNode;
		}
		
		@Override
		protected ContentOutlineNode createOutlineNode(EObject semanticNode, ContentOutlineNode outlineParentNode) {
			ContentOutlineNode outlineNode = super.createOutlineNode(semanticNode, outlineParentNode);
			ContentOutlineNodeWrapper contentOutlineNodeWrapper = new ContentOutlineNodeWrapper(semanticNode,outlineNode);
			// // todo: clean up hack!
			if (outlineParentNode != null) {
				outlineParentNode.getChildren().remove(outlineNode);
				outlineParentNode.getChildren().add(contentOutlineNodeWrapper);
			}
			return contentOutlineNodeWrapper;
		}
	}
	
	static class ContentOutlineNodeWrapper extends ContentOutlineNode {
		private ContentOutlineNode contentOutlineNode;
		private EObject eObject;
		/**
		 * @param object
		 * @param contentOutlineNode
		 */
		public ContentOutlineNodeWrapper(EObject object, ContentOutlineNode contentOutlineNode) {
			super();
			eObject = object;
			this.contentOutlineNode = contentOutlineNode;
		}
		/**
		 * @return the contentOutlineNode
		 */
		public ContentOutlineNode getContentOutlineNode() {
			return contentOutlineNode;
		}
		/**
		 * @return the eObject
		 */
		public EObject getEObject() {
			return eObject;
		}
		
		@Override
		public List<ContentOutlineNode> getChildren() {
			return this.contentOutlineNode.getChildren();
		}
		
		@Override
		public ContentOutlineNode getParent() {
			return this.contentOutlineNode.getParent();
		}
		
		public int getSelectionOffset() {
			return this.contentOutlineNode.getSelectionOffset();
		}

		public int getSelectionLength() {
			return this.contentOutlineNode.getSelectionLength();
		}
	}
	
}
