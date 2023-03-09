/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.resource.IFragmentProvider;
import org.eclipse.xtext.util.Strings;

import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class XtextFragmentProvider implements IFragmentProvider {

	@Override
	public EObject getEObject(Resource resource, String fragment, IFragmentProvider.Fallback fallback) {
		if (!fragment.startsWith(PREFIX))
			return fallback.getEObject(fragment);
		String fragmentWithoutPrefix = fragment.substring(PREFIX.length());
		List<String> splitted = Strings.split(fragmentWithoutPrefix, '/');
		if (splitted.isEmpty()) {
			return fallback.getEObject(fragment);
		}
		String firstPart = splitted.get(0);
		Grammar grammar = null;
		for(EObject content: resource.getContents()) {
			if (content instanceof Grammar) {
				Grammar g = (Grammar) content;
				if (firstPart.equals(g.getName())) {
					grammar = g;
					if (splitted.size() == 1)
						return grammar;
					break;
				}
			}
		}
		if (splitted.size() == 2) {
			return GrammarUtil.findRuleForName(grammar, splitted.get(1));
		} else {
			return fallback.getEObject(fragment);
		}
	}

	@Override
	public String getFragment(EObject obj, IFragmentProvider.Fallback fallback) {
		if (obj instanceof Grammar) {
			return caseGrammar((Grammar)obj);
		} else if (obj instanceof AbstractRule && obj.eContainer() != null) {
			return caseAbstractRule((AbstractRule)obj, fallback);
		}
		return fallback.getFragment(obj);
	}

	private static final String PREFIX = "XtextFragmentProvider_";
	
	public String caseGrammar(Grammar obj) {
		return PREFIX + obj.getName();
	}
	
	public String caseAbstractRule(AbstractRule obj, IFragmentProvider.Fallback fallback) {
		return getFragment(obj.eContainer(), fallback) + "/" + obj.getName();
	}

}
