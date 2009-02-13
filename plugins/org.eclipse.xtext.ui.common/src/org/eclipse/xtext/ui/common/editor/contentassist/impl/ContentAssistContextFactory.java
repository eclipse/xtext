/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.contentassist.impl;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.parsetree.ParseTreeUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistContext;

public class ContentAssistContextFactory {
	public static IContentAssistContext create(XtextResource resource, int offset, String prefix) {
		IParseResult parseResult = resource.getParseResult();
		Assert.isNotNull(parseResult);

		CompositeNode rootNode = parseResult.getRootNode();

		AbstractNode referenceNode = ParseTreeUtil.getLastCompleteNodeByOffset(rootNode, offset);

		EObject model = NodeUtil.getNearestSemanticObject(referenceNode);

		AbstractNode node = ParseTreeUtil.getCurrentOrFollowingNodeByOffset(rootNode, offset);

		return new ContentAssistContext(model, offset, prefix, node,
				referenceNode, rootNode);
	}

}
