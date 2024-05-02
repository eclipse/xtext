/*******************************************************************************
 * Copyright (c) 2024 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.lsp;

import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.xbase.ide.contentassist.ClasspathBasedIdeTypesProposalProvider;

/**
 * @since 2.35
 */
public class LspTypesProposalProvider extends ClasspathBasedIdeTypesProposalProvider {

	@Override
	protected ClassLoader getClassLoader(ContentAssistContext context) {
		ClassLoader result = super.getClassLoader(context);
		if (result instanceof ForwardingClassLoader) {
			result = ((ForwardingClassLoader) result).getDelegate();
		}
		return result;
	}
	
}
