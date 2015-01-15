/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.parser;

import com.google.inject.Binder;
import com.google.inject.binder.AnnotatedBindingBuilder;
import org.eclipse.xtend.core.parser.XtendPsiAntlrGrammarGenerator;
import org.eclipse.xtext.idea.generator.parser.antlr.PsiAntlrGrammarGenerator;
import org.eclipse.xtext.idea.generator.parser.antlr.XtextAntlrIDEAGeneratorFragment;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendAntlrIDEAGeneratorFragment extends XtextAntlrIDEAGeneratorFragment {
  @Override
  protected void addLocalBindings(final Binder binder) {
    super.addLocalBindings(binder);
    AnnotatedBindingBuilder<PsiAntlrGrammarGenerator> _bind = binder.<PsiAntlrGrammarGenerator>bind(PsiAntlrGrammarGenerator.class);
    _bind.to(XtendPsiAntlrGrammarGenerator.class);
  }
}
