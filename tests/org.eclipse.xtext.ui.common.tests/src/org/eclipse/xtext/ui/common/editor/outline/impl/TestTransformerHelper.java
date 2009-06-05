/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.outline.impl;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.xtext.ui.common.editor.outline.ContentOutlineNode;
import org.eclipse.xtext.ui.common.editor.outline.CreateNode;
import org.eclipse.xtext.ui.common.editor.outline.GetChildren;
import org.eclipse.xtext.ui.common.editor.outline.impl.simplestructure.A;
import org.eclipse.xtext.ui.common.editor.outline.impl.simplestructure.B;
import org.eclipse.xtext.ui.common.editor.outline.impl.simplestructure.root;
import org.eclipse.xtext.ui.common.editor.outline.transformer.AbstractDeclarativeSemanticModelTransformer;
import org.eclipse.xtext.ui.core.ILocationInFileProvider;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class TestTransformerHelper {
	
	private static ILocationInFileProvider myLocationProvider = new ILocationInFileProvider() {
		public Region getLocation(EObject obj) {
			return new Region(0, 0);
		}
	};
	
	private static ILabelProvider myLabelProvider = new LabelProvider() {
		public String getText(Object element) {
			if (element instanceof root) {
				return "root";
			}
			if (element instanceof A) {
				A a = (A) element;
				return a.getName();
			}
			else if (element instanceof B) {
				B b = (B) element;
				return b.getName();
			}
			return super.getText(element);
		}
	};
	
	public static class TestTransformerWithNamingConvention extends AbstractDeclarativeSemanticModelTransformer {
		
		{
			setLocationProvider(myLocationProvider);
			setLabelProvider(myLabelProvider);
		}
		
		/**
		 * This method will be called by naming convention:
		 * - method name must be createNode
		 * - first param: subclass of EObject
		 * - second param: ContentOutlineNode 
		 */
		public ContentOutlineNode createNode(A semanticNode, ContentOutlineNode parentNode) {
			ContentOutlineNode node = super.newOutlineNode(semanticNode, parentNode);
			node.setLabel("special " + node.getLabel());
			return node;
		}
		
		public ContentOutlineNode createNode(B semanticNode, ContentOutlineNode parentNode) {
			ContentOutlineNode node = super.newOutlineNode(semanticNode, parentNode);
			node.setLabel("pimped " + node.getLabel());
			return node;
		}
		
		/**
		 * This method will be called by naming convention:
		 * - method name must be getChildren
		 * - first param: subclass of EObject
		 */
		public List<EObject> getChildren(A a) {
			return a.eContents();
		}
		
		public List<EObject> getChildren(B b) {
			return NO_CHILDREN;
		}
		
	}
	
	public static class TestTransformerWithAnnotations extends AbstractDeclarativeSemanticModelTransformer {
		{
			setLocationProvider(myLocationProvider);
			setLabelProvider(myLabelProvider);
		}
		
		/**
		 * This method will be called by annotation mark-up:
		 * - method name does not matter
		 * - @CreateNode annotation must be present
		 * - first param: subclass of EObject
		 * - second param: ContentOutlineNode 
		 */
		@CreateNode
		public ContentOutlineNode makeNode(A semanticNode, ContentOutlineNode parentNode) {
			ContentOutlineNode node = super.newOutlineNode(semanticNode, parentNode);
			node.setLabel("special " + node.getLabel());
			return node;
		}
		
		@CreateNode
		public ContentOutlineNode makeNode(B semanticNode, ContentOutlineNode parentNode) {
			ContentOutlineNode node = super.newOutlineNode(semanticNode, parentNode);
			node.setLabel("pimped " + node.getLabel());
			return node;
		}
		
		/**
		 * This method will be called by annotation mark-up:
		 * - method name does not matter
		 * - @GetChildren annotation must be present
		 * - first param: subclass of EObject
		 */
		@GetChildren
		public List<EObject> whatAboutTheKids(A a) {
			return a.eContents();
		}
		
		@GetChildren
		public List<EObject> whatAboutTheKids(B b) {
			return NO_CHILDREN;
		}
		
	}
	
}