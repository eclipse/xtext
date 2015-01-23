/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.annotations.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.xbase.annotations.idea.completion.AbstractXbaseWithAnnotationsCompletionContributor;
import org.eclipse.xtext.xbase.annotations.idea.lang.XbaseWithAnnotationsLanguage;

@SuppressWarnings("all")
public class XbaseWithAnnotationsCompletionContributor extends AbstractXbaseWithAnnotationsCompletionContributor {
  public XbaseWithAnnotationsCompletionContributor() {
    this(XbaseWithAnnotationsLanguage.INSTANCE);
  }
  
  public XbaseWithAnnotationsCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
