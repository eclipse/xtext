/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.contentassist.antlr;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.TokenSource;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.CompoundElement;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.parser.antlr.IUnorderedGroupHelper;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Abstract base type for the {@link AbstractContentAssistParser} and the deprecated
 * equivalent in the xtext.ui bundle.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.13
 */
public abstract class BaseContentAssistParser {
	
	@Inject
	private Provider<IUnorderedGroupHelper> unorderedGroupHelper;
	
	@Inject
	private RequiredRuleNameComputer requiredRuleNameComputer;
	
	/**
	 * Create a token source for the given input based on the bound lexer.
	 */
	protected TokenSource createTokenSource(String input) {
		return createLexer(new ANTLRStringStream(input));
	}
	
	protected abstract TokenSource createLexer(CharStream stream);
	
	/**
	 * Returns the elementToParse or the innermost element if the elementToParse is 
	 * a (parameterized) group that contains only a single element.
	 */
	protected AbstractElement unwrapSingleElementGroups(AbstractElement elementToParse) {
		if (elementToParse instanceof Group) {
			List<AbstractElement> elements = ((Group) elementToParse).getElements();
			if (elements.size() == 1) {
				return unwrapSingleElementGroups(elements.get(0));
			}
		}
		return elementToParse;
	}
	
	/**
	 * Returns the root element or its alternative branches if it is an {@link Alternatives} or an {@link UnorderedGroup}.
	 * In case of an {@link UnorderedGroup} the result contains only the elements that are not yet processed up to the
	 * relevant cursor position.
	 */
	protected Collection<AbstractElement> getElementsToParse(AbstractElement root, List<AbstractElement> handledUnorderedGroupElements) {
		if (root instanceof UnorderedGroup) {
			if (handledUnorderedGroupElements.isEmpty())
				return ((CompoundElement) root).getElements();
			List<AbstractElement> result = Lists.newArrayList(root);
			for(AbstractElement child: ((UnorderedGroup) root).getElements()) {
				if (!handledUnorderedGroupElements.contains(child)) {
					result.add(child);
				}
			}
			return result;
		}
		return getElementsToParse(root);
	}
	
	/**
	 * Factory method for the {@link IgnoreFirstEntranceUnorderedGroupHelper}.
	 */
	protected IUnorderedGroupHelper ignoreFirstEntrance(final IUnorderedGroupHelper helper) {
		return new IgnoreFirstEntranceUnorderedGroupHelper(helper);
	}
	
	/**
	 * Return the element itself or its components if it is an {@link Alternatives}.
	 */
	protected Collection<AbstractElement> getElementsToParse(AbstractElement root) {
		if (root instanceof Alternatives)
			return ((CompoundElement) root).getElements();
		return Collections.singleton(root);
	}
	
	protected String[][] getRequiredRuleNames(String ruleName, List<Integer> paramStack, AbstractElement elementToParse) {
		return requiredRuleNameComputer.getRequiredRuleNames(new RequiredRuleNameComputer.Param(ruleName, paramStack, elementToParse) {
			@Override
			public String getBaseRuleName(AbstractElement element) {
				return getRuleName(element);
			}
		});
	}
	
	protected abstract String getRuleName(AbstractElement element);
	
	/**
	 * Creates a new {@link IUnorderedGroupHelper} that is not yet initialized.
	 */
	protected IUnorderedGroupHelper createUnorderedGroupHelper() {
		return getUnorderedGroupHelper().get();
	}
	
	/**
	 * Public for testing purpose.
	 */
	public void setUnorderedGroupHelper(Provider<IUnorderedGroupHelper> unorderedGroupHelper) {
		this.unorderedGroupHelper = unorderedGroupHelper;
	}

	/**
	 * Public for testing purpose.
	 */
	public Provider<IUnorderedGroupHelper> getUnorderedGroupHelper() {
		return unorderedGroupHelper;
	}
	
	/**
	 * Public for testing purpose.
	 */
	public void setRequiredRuleNameComputer(RequiredRuleNameComputer requiredRuleNameComputer) {
		this.requiredRuleNameComputer = requiredRuleNameComputer;
	}
	
	/**
	 * Public for testing purpose.
	 */
	public RequiredRuleNameComputer getRequiredRuleNameComputer() {
		return requiredRuleNameComputer;
	}
}
