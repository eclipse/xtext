/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.transformer;

import java.lang.reflect.Method;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.xtext.ui.editor.outline.ContentOutlineNode;
import org.eclipse.xtext.ui.editor.outline.CreateNode;
import org.eclipse.xtext.ui.editor.outline.GetChildren;
import org.eclipse.xtext.ui.editor.outline.OutlineLabelProvider;
import org.eclipse.xtext.util.PolymorphicDispatcher;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Peter Friese - Initial contribution and API
 * @author Michael Clay
 */
public class AbstractDeclarativeSemanticModelTransformer extends DefaultSemanticModelTransformer {
	private static final String GET_CHILDREN_METHOD_NAME = "getChildren";
	private static final String CREATE_NODE_METHOD_NAME = "createNode";
	private static final String CONSUME_NODE_METHOD_NAME = "consumeNode";
	@Inject
	@OutlineLabelProvider
	private ILabelProvider labelProvider;

	public void setLabelProvider(ILabelProvider labelProvider) {
		this.labelProvider = labelProvider;
	}

	private final PolymorphicDispatcher<Boolean> consumeNode = new PolymorphicDispatcher<Boolean>(Lists
			.newArrayList(this), new Predicate<Method>() {
		public boolean apply(Method param) {
			return CONSUME_NODE_METHOD_NAME.equals(param.getName());
		}
	});

	private final PolymorphicDispatcher<ContentOutlineNode> createNode = new PolymorphicDispatcher<ContentOutlineNode>(
			Lists.newArrayList(this), new Predicate<Method>() {
				public boolean apply(Method param) {
					return ((CREATE_NODE_METHOD_NAME.equals(param.getName())) || (param.getAnnotation(CreateNode.class) != null));
				}
			});

	private final PolymorphicDispatcher<List<EObject>> getChildren = new PolymorphicDispatcher<List<EObject>>(Lists
			.newArrayList(this), new Predicate<Method>() {
		public boolean apply(Method param) {
			return ((GET_CHILDREN_METHOD_NAME.equals(param.getName())) || (param.getAnnotation(GetChildren.class) != null));
		}
	});

	@Override
	public boolean consumeSemanticNode(EObject semanticModelObject) {
		return consumeNode.invoke(semanticModelObject);
	}

	public boolean consumeNode(EObject semanticModelObject) {
		if (labelProvider.getText(semanticModelObject)==null) {
			return false;
		}
		return super.consumeSemanticNode(semanticModelObject);
	}

	@Override
	protected ContentOutlineNode createOutlineNode(EObject semanticNode, ContentOutlineNode outlineParentNode) {
		return createNode.invoke(semanticNode, outlineParentNode);
	}

	public ContentOutlineNode createNode(EObject semanticNode, ContentOutlineNode outlineParentNode) {
		return newOutlineNode(semanticNode, outlineParentNode);
	}

	@Override
	protected List<EObject> getChildNodes(EObject semanticNode) {
		return getChildren.invoke(semanticNode);
	}

	@Override
	protected List<EObject> getChildren(EObject semanticNode) {
		return semanticNode.eContents();
	}
}
