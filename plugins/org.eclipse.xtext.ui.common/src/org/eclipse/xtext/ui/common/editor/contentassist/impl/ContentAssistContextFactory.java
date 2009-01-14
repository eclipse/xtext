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
		
		EObject model = (referenceNode instanceof AbstractNode ? NodeUtil
				.getNearestSemanticObject((AbstractNode) referenceNode) : referenceNode);
		
		AbstractNode node = ParseTreeUtil.getCurrentOrFollowingNodeByOffset(rootNode, offset);
		
		return new ContentAssistContext(model, offset, prefix, node,
				referenceNode, rootNode);
	}
	
}
