/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.parser;

import com.google.inject.AbstractModule;
import com.google.inject.binder.AnnotatedBindingBuilder;
import org.eclipse.xtend.core.parser.XtendPsiAntlrGrammarGenerator;
import org.eclipse.xtext.xtext.generator.idea.parser.antlr.PsiAntlrGrammarGenerator;

@SuppressWarnings("all")
public class XtendLanguageGeneratorModule extends AbstractModule {
  @Override
  protected void configure() {
    AnnotatedBindingBuilder<PsiAntlrGrammarGenerator> _bind = this.<PsiAntlrGrammarGenerator>bind(PsiAntlrGrammarGenerator.class);
    _bind.to(XtendPsiAntlrGrammarGenerator.class);
  }
}
