/*******************************************************************************
 * Copyright (c) 2009 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.outline;

import java.lang.reflect.Method;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.PolymorphicDispatcher;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class DefaultContentOutlineNodePostProcessor implements IContentOutlineNodePostProcessor {

	private static final String POST_PROCESS_NODE_METHOD_NAME = "postProcessNode";

	private final PolymorphicDispatcher<ContentOutlineNode> postProcessNode = new PolymorphicDispatcher<ContentOutlineNode>(
			Lists.newArrayList(this), new Predicate<Method>() {
				public boolean apply(Method param) {
					return (POST_PROCESS_NODE_METHOD_NAME.equals(param.getName()));
				}
			});

	public void postProcess(EObject semanticModelObject, ContentOutlineNode contentOutlineNode) {
		postProcessNode.invoke(semanticModelObject, contentOutlineNode);
	}

	public void postProcessNode(EObject semanticModelObject, ContentOutlineNode contentOutlineNode) {
	}

}
