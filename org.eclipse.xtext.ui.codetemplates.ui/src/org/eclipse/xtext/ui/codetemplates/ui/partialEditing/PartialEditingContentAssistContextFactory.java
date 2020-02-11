/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates.ui.partialEditing;

import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.ide.editor.partialEditing.IPartialEditingContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.DelegatingContentAssistContextFactory;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class PartialEditingContentAssistContextFactory extends DelegatingContentAssistContextFactory implements IPartialEditingContentAssistContextFactory {

	private AbstractRule rule;
	private IPartialEditingContentAssistParser partialContentAssistParser;

	@Inject
	public void setPartialEditingParser(final IPartialEditingContentAssistParser partialContentAssistParser) {
		this.partialContentAssistParser = partialContentAssistParser;
	}
	
	@Override
	public Provider<? extends StatefulFactory> getStatefulFactoryProvider() {
		final Provider<? extends StatefulFactory> delegate = super.getStatefulFactoryProvider();
		return new Provider<StatefulFactory>() {
			@Override
			public StatefulFactory get() {
				StatefulFactory result = delegate.get();
				result.getDelegate().setParser(partialContentAssistParser);
				if (rule != null) {
					partialContentAssistParser.initializeFor(rule);
				}
				return result;
			}
		};
	}

	@Override
	public void initializeFor(AbstractRule rule) {
		this.rule = rule;
	}
	
}
