/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.outline;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ui.common.editor.outline.ContentOutlineNode;
import org.eclipse.xtext.ui.common.editor.outline.impl.DefaultSemanticModelTransformer;
import org.eclipse.xtext.util.XtextSwitch;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class XtextSemanticModelTransformer extends
		DefaultSemanticModelTransformer {
	
	@Override
	public boolean consumeSemanticChildNodes(EObject semanticNode) {
		return new XtextSwitch<Boolean>() {
			@Override
			public Boolean caseGrammar(Grammar object) {
				return true;
			}
			@Override
			public Boolean caseParserRule(org.eclipse.xtext.ParserRule object) {
				return false;
			};
			public Boolean defaultCase(EObject object) {
				return false;
			};
		}.doSwitch(semanticNode);

	}
	
	@Override
	protected ContentOutlineNode createOutlineNode(EObject semanticNode,
			ContentOutlineNode outlineParentNode) {
		final ContentOutlineNode outlineNode = super.createOutlineNode(semanticNode, outlineParentNode);
		
		return new XtextSwitch<ContentOutlineNode>() {
			@Override
			public ContentOutlineNode caseGrammar(Grammar object) {
				outlineNode.setLabel("Grammar " + object.getIdElements());
				return outlineNode;
			}
			@Override
			public ContentOutlineNode caseGeneratedMetamodel(org.eclipse.xtext.GeneratedMetamodel object) {
				outlineNode.setLabel("GeneratedMM: " + object.getName());
				return outlineNode;
			};
			@Override
			public ContentOutlineNode caseReferencedMetamodel(org.eclipse.xtext.ReferencedMetamodel object) {
				outlineNode.setLabel("ReferencedMM " + object.getAlias());
				return outlineNode;
			};
			@Override
			public ContentOutlineNode caseParserRule(org.eclipse.xtext.ParserRule object) {
				outlineNode.setLabel(object.getName());
				return outlineNode;
			};
		}.doSwitch(semanticNode);
	}
	
}
