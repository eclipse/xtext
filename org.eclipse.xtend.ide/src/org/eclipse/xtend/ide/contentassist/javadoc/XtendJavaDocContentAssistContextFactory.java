/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.contentassist.javadoc;

import org.eclipse.xtend.ide.common.contentassist.javadoc.FlexerBasedJavaDocContentAssistContextFactory;
import org.eclipse.xtext.ide.editor.contentassist.antlr.ContentAssistContextFactory;
import org.eclipse.xtext.ui.editor.contentassist.antlr.DelegatingContentAssistContextFactory;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class XtendJavaDocContentAssistContextFactory extends DelegatingContentAssistContextFactory {

	@Inject
	private Provider<StatefulFactory> statefulFactoryProvider;

	@Override
	public Provider<? extends org.eclipse.xtext.ui.editor.contentassist.antlr.DelegatingContentAssistContextFactory.StatefulFactory> getStatefulFactoryProvider() {
		return statefulFactoryProvider;
	}
	
	public static class StatefulFactory extends DelegatingContentAssistContextFactory.StatefulFactory {
		@Inject
		private FlexerBasedJavaDocContentAssistContextFactory delegate;
		
		@Override
		public ContentAssistContextFactory getDelegate() {
			return delegate;
		}
	}
}
