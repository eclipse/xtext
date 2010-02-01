/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase;

import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.antlr.AbstractAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.xbase.ui.autoedit.XbaseAutoEdit;
import org.eclipse.xtext.xbase.ui.syntaxcoloring.XbaseTokenToAttributeIdMapper;

/**
 * Use this class to register components to be used within the IDE.
 */
public class XbaseUiModule extends org.eclipse.xtext.xbase.AbstractXbaseUiModule {
	public Class<? extends IAutoEditStrategy> bindIAutoEditStrategy() {
		return XbaseAutoEdit.class;
	}
	
	public Class<? extends AbstractAntlrTokenToAttributeIdMapper> bindTokenToAttributeIdMapper() {
		return XbaseTokenToAttributeIdMapper.class;
	}
}
