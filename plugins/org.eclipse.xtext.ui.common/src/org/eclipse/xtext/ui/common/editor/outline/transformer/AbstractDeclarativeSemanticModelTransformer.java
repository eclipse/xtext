/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.outline.transformer;

import java.lang.reflect.Method;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.common.editor.outline.ContentOutlineNode;
import org.eclipse.xtext.ui.common.editor.outline.CreateNode;
import org.eclipse.xtext.ui.common.editor.outline.GetChildren;
import org.eclipse.xtext.util.PolymorphicDispatcher;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class AbstractDeclarativeSemanticModelTransformer extends DefaultSemanticModelTransformer {

	private final PolymorphicDispatcher<ContentOutlineNode> createNode = new PolymorphicDispatcher<ContentOutlineNode>(Lists
			.newArrayList(this), new Predicate<Method>() {
		public boolean apply(Method param) {
			return ((param.getName().equals("createNode")) || (param.getAnnotation(CreateNode.class) != null));
		}
	});

	private final PolymorphicDispatcher<List<EObject>> getChildren = new PolymorphicDispatcher<List<EObject>>(Lists
			.newArrayList(this), new Predicate<Method>() {
		public boolean apply(Method param) {
			return ((param.getName().equals("getChildren")) || (param.getAnnotation(GetChildren.class) != null));
		}
	});

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
