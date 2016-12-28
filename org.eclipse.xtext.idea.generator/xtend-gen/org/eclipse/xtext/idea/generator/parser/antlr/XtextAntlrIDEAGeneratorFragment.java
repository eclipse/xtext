/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.generator.parser.antlr;

import com.google.inject.Inject;
import java.nio.charset.Charset;
import java.util.List;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.generator.Xtend2ExecutionContext;
import org.eclipse.xtext.generator.parser.antlr.AbstractAntlrXtendGeneratorFragment;
import org.eclipse.xtext.generator.parser.antlr.AntlrOptions;
import org.eclipse.xtext.idea.generator.parser.antlr.PsiAntlrGrammarGenerator;
import org.eclipse.xtext.idea.generator.parser.antlr.XtextIDEAGeneratorExtensions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

@Deprecated
@SuppressWarnings("all")
public class XtextAntlrIDEAGeneratorFragment extends AbstractAntlrXtendGeneratorFragment {
  private String encoding;
  
  @Accessors
  private String ideaProjectPath;
  
  @Inject
  @Extension
  private Naming _naming;
  
  @Inject
  @Extension
  private PsiAntlrGrammarGenerator _psiAntlrGrammarGenerator;
  
  @Inject
  @Extension
  private XtextIDEAGeneratorExtensions _xtextIDEAGeneratorExtensions;
  
  public void setEncoding(final String encoding) {
    this.encoding = encoding;
  }
  
  @Override
  protected void generate(final Grammar grammar, final List<Object> parameters, final Xtend2ExecutionContext ctx) {
    this._xtextIDEAGeneratorExtensions.installOutlets(ctx, this.ideaProjectPath, this.encoding, this.getNaming().getLineDelimiter());
    final Object options = IterableExtensions.<Object>head(parameters);
    if ((options instanceof AntlrOptions)) {
      this._psiAntlrGrammarGenerator.generate(grammar, ((AntlrOptions)options), ctx);
      final Outlet srcGenOutlet = this._xtextIDEAGeneratorExtensions.getSrcGenOutlet(ctx);
      final String srcGenPath = srcGenOutlet.getPath();
      final String encoding = srcGenOutlet.getFileEncoding();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(srcGenPath);
      _builder.append("/");
      String _asPath = this._naming.asPath(this._psiAntlrGrammarGenerator.getGrammarFileName(grammar));
      _builder.append(_asPath);
      _builder.append(".g");
      final String absoluteGrammarFileName = _builder.toString();
      this.addAntlrParam("-fo");
      this.addAntlrParam(absoluteGrammarFileName.substring(0, absoluteGrammarFileName.lastIndexOf("/")));
      this.getAntlrTool().runWithEncodingAndParams(absoluteGrammarFileName, encoding, this.getAntlrParams());
      final Charset charset = Charset.forName(encoding);
      this.simplifyUnorderedGroupPredicatesIfRequired(grammar, absoluteGrammarFileName, charset);
      this.splitParserAndLexerIfEnabled(absoluteGrammarFileName, charset);
      this.suppressWarnings(absoluteGrammarFileName, charset);
      this.normalizeLineDelimiters(absoluteGrammarFileName, charset);
      this.normalizeTokens(absoluteGrammarFileName, charset);
    }
  }
  
  @Override
  protected void addToPluginXmlRt(final Grammar grammar, final List<Object> parameters, final Xtend2ExecutionContext ctx) {
  }
  
  @Override
  protected void addToPluginXmlUi(final Grammar grammar, final List<Object> parameters, final Xtend2ExecutionContext ctx) {
  }
  
  @Override
  protected void addToPluginXmlTests(final Grammar grammar, final List<Object> parameters, final Xtend2ExecutionContext ctx) {
  }
  
  @Override
  protected void addToStandaloneSetup(final Grammar grammar, final List<Object> parameters, final Xtend2ExecutionContext ctx) {
  }
  
  @Pure
  public String getIdeaProjectPath() {
    return this.ideaProjectPath;
  }
  
  public void setIdeaProjectPath(final String ideaProjectPath) {
    this.ideaProjectPath = ideaProjectPath;
  }
}
