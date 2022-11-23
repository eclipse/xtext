/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.hyperlinking.HyperlinkHelper;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkAcceptor;
import org.eclipse.xtext.ui.editor.hyperlinking.XtextHyperlink;
import org.eclipse.xtext.util.ITextRegion;

import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * Provides hyper links from rule without explicit return type to the
 * classifier and from overriding rules to the base rule.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextHyperlinkHelper extends HyperlinkHelper {

	@Inject
	private ILocationInFileProvider locationInFileProvider;
	
	@Inject 
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;
	
	@Override
	public void createHyperlinksByOffset(XtextResource resource, int offset, IHyperlinkAcceptor acceptor) {
		super.createHyperlinksByOffset(resource, offset, acceptor);
		EObject objectAtOffset = eObjectAtOffsetHelper.resolveElementAt(resource, offset);
		if (objectAtOffset instanceof AbstractRule) {
			ITextRegion nameLocation = locationInFileProvider.getSignificantTextRegion(objectAtOffset, XtextPackage.Literals.ABSTRACT_RULE__NAME, 0);
			if (nameLocation != null && nameLocation.contains(offset)) {
				AbstractRule rule = (AbstractRule) objectAtOffset;
				createLinksToBase(nameLocation, rule, acceptor);
				if (rule.getType() != null && rule.getType().getClassifier() != null && NodeModelUtils.getNode(rule.getType()) == null) {
					createHyperlinksTo(resource, toRegion(nameLocation), rule.getType().getClassifier(), acceptor);
				}
			}
		}
	}

	protected void createLinksToBase(ITextRegion nameLocation,	AbstractRule rule, IHyperlinkAcceptor acceptor) {
		Set<AbstractRule> visited = Sets.newHashSet();
		Grammar grammar = GrammarUtil.getGrammar(rule);
		for(Grammar used: grammar.getUsedGrammars()) {
			String ruleName = rule.getName();
			AbstractRule overwritten = GrammarUtil.findRuleForName(used, ruleName);
			if (overwritten != null && visited.add(overwritten)) {
				URIConverter uriConverter = rule.eResource().getResourceSet().getURIConverter();
				String hyperlinkText = getLabelProvider().getText(rule) + " - " + GrammarUtil.getGrammar(overwritten).getName();
				URI uri = uriConverter.normalize(EcoreUtil.getURI(overwritten));

				XtextHyperlink result = getHyperlinkProvider().get();
				result.setHyperlinkRegion((IRegion)toRegion(nameLocation));
				result.setURI(uri);
				result.setHyperlinkText(hyperlinkText);
				result.setTypeLabel("Go To Base");
				acceptor.accept(result);
			}
		}
	}

	protected Region toRegion(ITextRegion location) {
		return new Region(location.getOffset(), location.getLength());
	}
	
	@Override
	public void createHyperlinksTo(XtextResource from, Region region, EObject to, IHyperlinkAcceptor acceptor) {
		if (acceptHyperLink(from, to)) {
			super.createHyperlinksTo(from, region, to, acceptor);
		}
	}

	protected boolean acceptHyperLink(XtextResource resource, EObject objectAtOffset) {
		if (objectAtOffset instanceof EClass) {
			EClass eClass = (EClass) objectAtOffset;
			Grammar grammar = GrammarUtil.getGrammar(resource.getEObject("/"));
			List<AbstractMetamodelDeclaration> allMetamodelDeclarations = GrammarUtil.allMetamodelDeclarations(grammar);
			for (GeneratedMetamodel generatedMetamodel : Iterables.filter(allMetamodelDeclarations,
					GeneratedMetamodel.class)) {
				if (eClass.getEPackage().equals(generatedMetamodel.getEPackage())) {
					return false;
				}
			}
		}
		return true;
	}

}
