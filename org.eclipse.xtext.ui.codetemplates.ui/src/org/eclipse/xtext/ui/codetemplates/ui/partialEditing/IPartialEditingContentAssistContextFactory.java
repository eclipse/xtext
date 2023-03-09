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
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;

import com.google.inject.ImplementedBy;

@ImplementedBy(PartialContentAssistContextFactory.class)
public interface IPartialEditingContentAssistContextFactory extends ContentAssistContext.Factory {
	public void initializeFor(AbstractRule rule);
}
