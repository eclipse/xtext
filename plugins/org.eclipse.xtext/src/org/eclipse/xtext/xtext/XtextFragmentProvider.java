/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.resource.IFragmentProvider;

import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class XtextFragmentProvider implements IFragmentProvider {

	public EObject getEObject(Resource resource, String fragment, IFragmentProvider.Fallback fallback) {
		if (!fragment.startsWith(PREFIX))
			return fallback.getEObject(fragment);
		String fragmentWithoutPrefix = fragment.substring(PREFIX.length());
		String[] splitted = fragmentWithoutPrefix.split("/");
		if (splitted.length == 0) {
			return fallback.getEObject(fragment);
		}
		String firstPart = splitted[0];
		Grammar grammar = null;
		for(EObject content: resource.getContents()) {
			if (content instanceof Grammar) {
				Grammar g = (Grammar) content;
				if (firstPart.equals(g.getName())) {
					grammar = g;
					if (splitted.length == 1)
						return grammar;
					break;
				}
			}
		}
		if (splitted.length == 2) {
			return GrammarUtil.findRuleForName(grammar, splitted[1]);
		} else {
			return fallback.getEObject(fragment);
		}
	}

	public String getFragment(EObject obj, IFragmentProvider.Fallback fallback) {
		if (obj instanceof Grammar) {
			return caseGrammar((Grammar)obj);
		} else if (obj instanceof AbstractRule) {
			return caseAbstractRule((AbstractRule)obj, fallback);
		}
		return fallback.getFragment(obj);
	}

	private static final String PREFIX = "XtextFragmentProvider::";
	
	public String caseGrammar(Grammar obj) {
		return PREFIX + obj.getName();
	}
	
	public String caseAbstractRule(AbstractRule obj, IFragmentProvider.Fallback fallback) {
		return getFragment(obj.eContainer(), fallback) + "/" + obj.getName();
	}

}
