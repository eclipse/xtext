/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.resource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.services.XtendGrammarAccess;
import org.eclipse.xtend.core.xtend.RichStringLiteral;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.util.TextRegionWithLineInformation;
import org.eclipse.xtext.xbase.jvmmodel.JvmLocationInFileProvider;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Specialization of the {@link JvmLocationInFileProvider} that configures Xtend specific 
 * location nodes, e.g. the significant region of a constructor declaration is the
 * keyword 'new'.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class XtendLocationInFileProvider extends JvmLocationInFileProvider {

	@Inject
	private XtendGrammarAccess grammarAccess;
	
	/**
	 * Considers the keyword 'new' of a constructor declaration to be the significant part.
	 */
	@Override
	protected boolean useKeyword(Keyword keyword, EObject context) {
		if (keyword == grammarAccess.getMemberAccess().getNewKeyword_2_2_2())
			return true;
		return super.useKeyword(keyword, context);
	}
	
	@Override
	public ITextRegion getSignificantTextRegion(EObject element) {
		if (element instanceof RichStringLiteral) {
			ICompositeNode elementNode = findNodeFor(element);
			if (elementNode == null) {
				return ITextRegion.EMPTY_REGION;
			}
			ITextRegion result = ITextRegion.EMPTY_REGION;
			for (INode node : elementNode.getLeafNodes()) {
				if (isHidden(node)) {
					continue;
				}
				EObject grammarElement = node.getGrammarElement();
				if (!(grammarElement instanceof RuleCall)) {
					continue;
				}
				RuleCall ruleCall = (RuleCall) grammarElement;
				
				ITextRegionWithLineInformation region = node.getTextRegionWithLineInformation();
				int offset = region.getOffset();
				int length = region.getLength();
				if (grammarAccess.getRICH_TEXTRule() == ruleCall.getRule()) {
					offset += 3;
					length -= 6;
				} else if (grammarAccess.getRICH_TEXT_STARTRule() == ruleCall.getRule()) {
					offset += 3;
					length -= 4;
				} else if (grammarAccess.getRICH_TEXT_ENDRule() == ruleCall.getRule()) {
					offset += 1;
					length -= 4;
				} else if (grammarAccess.getRICH_TEXT_INBETWEENRule() == ruleCall.getRule()) {
					offset += 1;
					length -= 2;
				} else if (grammarAccess.getCOMMENT_RICH_TEXT_ENDRule() == ruleCall.getRule()) {
					offset += 2;
					length -= 5;
				} else if (grammarAccess.getCOMMENT_RICH_TEXT_INBETWEENRule() == ruleCall.getRule()) {
					offset += 2;
					length -= 3;
				} else {
					continue;
				}
				result = result.merge(toZeroBasedRegion(new TextRegionWithLineInformation(offset, length, region.getLineNumber(), region.getEndLineNumber())));
			}
			return result;
		}
		return super.getSignificantTextRegion(element);
	}
	
}
