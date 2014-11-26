/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.contentassist.javadoc;

import org.eclipse.xtend.ide.contentassist.antlr.FlexerBasedContentAssistContextFactory;
import org.eclipse.xtext.ide.editor.contentassist.antlr.ContentAssistContextFactory;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.ui.editor.contentassist.antlr2.ParserBasedContentAssistContextFactory;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class XtendJavaDocContentAssistContextFactory extends ParserBasedContentAssistContextFactory {

	@Inject
	private Provider<XtendJavaDocStatefulFactory> statefulFactoryProvider;

	@Override
	public Provider<? extends org.eclipse.xtext.ui.editor.contentassist.antlr2.ParserBasedContentAssistContextFactory.StatefulFactory> getStatefulFactoryProvider() {
		return statefulFactoryProvider;
	}
	
	public static class XtendJavaDocStatefulFactory extends ParserBasedContentAssistContextFactory.StatefulFactory {
		@Inject
		private FlexerBasedJavaDocContentAssistContextFactory delegate;
		
		@Override
		public ContentAssistContextFactory getDelegate() {
			return delegate;
		}
	}

	public static class FlexerBasedJavaDocContentAssistContextFactory extends FlexerBasedContentAssistContextFactory {

		@Override
		public String getPrefix(INode node) {
			if(node != null) {
				int offsetInNode = getCompletionOffset() - node.getOffset();
				String textInFront = node.getText().substring(0, offsetInNode);
				for (int i = offsetInNode - 1; i > 0; i--) {
					char c = textInFront.charAt(i);
					if (Character.isWhitespace(c)) {
						return textInFront.substring(i + 1);
					}
				}
			}
			return "";
		}
	}
}
