/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.idea.parser.antlr;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.parser.antlr.GrammarNaming;

@Singleton
@SuppressWarnings("all")
public class PsiGrammarNaming extends GrammarNaming {
  @Inject
  @Extension
  private XtextGeneratorNaming _xtextGeneratorNaming;
  
  @Override
  public String getParserPackage(final Grammar it) {
    StringConcatenation _builder = new StringConcatenation();
    String _ideaBasePackage = this._xtextGeneratorNaming.getIdeaBasePackage(it);
    _builder.append(_ideaBasePackage, "");
    _builder.append(".parser.antlr");
    return _builder.toString();
  }
  
  @Override
  public TypeReference getInternalParserSuperClass(final Grammar it) {
    return new TypeReference("org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser");
  }
  
  @Override
  protected String getGrammarNamePrefix(final Grammar it) {
    return "Psi";
  }
}
