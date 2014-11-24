/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates.ui.partialEditing;

import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;

import com.google.inject.ImplementedBy;

@ImplementedBy(PartialContentAssistContextFactory.class)
public interface IPartialEditingContentAssistContextFactory extends ContentAssistContext.Factory {
	public void initializeFor(AbstractRule rule);
}
