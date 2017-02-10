/*******************************************************************************
 * Copyright (c) 2010-2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.xbase.annotations.idea.completion.XbaseWithAnnotationsCompletionContributor;

public class AbstractXtendCompletionContributor extends XbaseWithAnnotationsCompletionContributor {
	public AbstractXtendCompletionContributor(AbstractXtextLanguage lang) {
		super(lang);
	}
}
