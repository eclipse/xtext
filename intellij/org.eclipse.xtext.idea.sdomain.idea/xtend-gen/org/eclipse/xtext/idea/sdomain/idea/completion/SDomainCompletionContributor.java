/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.sdomain.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.idea.sdomain.idea.completion.AbstractSDomainCompletionContributor;
import org.eclipse.xtext.idea.sdomain.idea.lang.SDomainLanguage;

@SuppressWarnings("all")
public class SDomainCompletionContributor extends AbstractSDomainCompletionContributor {
  public SDomainCompletionContributor() {
    this(SDomainLanguage.INSTANCE);
  }
  
  public SDomainCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
