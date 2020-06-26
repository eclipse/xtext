/**
 * Copyright (c) 2012, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.generator.contentAssist;

import com.google.inject.Inject;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.eclipse.xpand2.XpandFacade;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.Generator;
import org.eclipse.xtext.generator.IInheriting;
import org.eclipse.xtext.generator.IStubGenerating;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.generator.Xtend2ExecutionContext;
import org.eclipse.xtext.generator.Xtend2GeneratorFragment;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.4
 */
@Deprecated
@SuppressWarnings("all")
public class ContentAssistFragment extends Xtend2GeneratorFragment implements IInheriting, IStubGenerating {
  @Inject
  @Extension
  private Naming _naming;
  
  @Inject
  private Grammar grammar;
  
  @Accessors
  private boolean inheritImplementation = true;
  
  @Accessors
  private boolean generateStub = true;
  
  public String getProposalProviderName(final Grammar grammar) {
    String _basePackageUi = this._naming.basePackageUi(grammar);
    String _plus = (_basePackageUi + ".contentassist.");
    String _simpleName = GrammarUtil.getSimpleName(grammar);
    String _plus_1 = (_plus + _simpleName);
    return (_plus_1 + "ProposalProvider");
  }
  
  public String getGenProposalProviderName() {
    String _basePackageUi = this._naming.basePackageUi(this.grammar);
    String _plus = (_basePackageUi + ".contentassist.Abstract");
    String _simpleName = GrammarUtil.getSimpleName(this.grammar);
    String _plus_1 = (_plus + _simpleName);
    return (_plus_1 + "ProposalProvider");
  }
  
  @Override
  public Set<Binding> getGuiceBindingsUi(final Grammar grammar) {
    Set<Binding> _xblockexpression = null;
    {
      final BindFactory bindFactory = new BindFactory();
      if (this.generateStub) {
        bindFactory.addTypeToType("org.eclipse.xtext.ui.editor.contentassist.IContentProposalProvider", 
          this.getProposalProviderName(grammar));
      } else {
        bindFactory.addTypeToType("org.eclipse.xtext.ui.editor.contentassist.IContentProposalProvider", 
          this.getGenProposalProviderName());
      }
      _xblockexpression = bindFactory.getBindings();
    }
    return _xblockexpression;
  }
  
  @Override
  public String[] getRequiredBundlesUi(final Grammar grammar) {
    List<String> _xifexpression = null;
    if (this.generateStub) {
      _xifexpression = CollectionLiterals.<String>newArrayList("org.eclipse.xtext.ui", "org.eclipse.xtext.xbase.lib");
    } else {
      _xifexpression = Collections.<String>singletonList("org.eclipse.xtext.ui");
    }
    return ((String[])Conversions.unwrapArray(_xifexpression, String.class));
  }
  
  @Override
  public String[] getImportedPackagesUi(final Grammar grammar) {
    return ((String[])Conversions.unwrapArray(Collections.<String>singleton("org.apache.log4j"), String.class));
  }
  
  @Override
  public String[] getExportedPackagesUi(final Grammar grammar) {
    return ((String[])Conversions.unwrapArray(Collections.<String>singletonList(this._naming.packageName(this.getProposalProviderName(grammar))), String.class));
  }
  
  public String getSuperClassName() {
    String _xblockexpression = null;
    {
      final Grammar superGrammar = IterableExtensions.<Grammar>head(this.grammar.getUsedGrammars());
      String _xifexpression = null;
      if ((this.inheritImplementation && (superGrammar != null))) {
        _xifexpression = this.getProposalProviderName(superGrammar);
      } else {
        _xifexpression = "org.eclipse.xtext.ui.editor.contentassist.AbstractJavaBasedContentProposalProvider";
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  @Override
  public void generate(final Xtend2ExecutionContext ctx) {
    if (this.generateStub) {
      String _asPath = this._naming.asPath(this.getProposalProviderName(this.grammar));
      String _plus = (_asPath + ".xtend");
      StringConcatenation _builder = new StringConcatenation();
      String _fileHeader = this._naming.fileHeader();
      _builder.append(_fileHeader);
      _builder.newLineIfNotEmpty();
      _builder.append("package ");
      String _packageName = this._naming.packageName(this.getProposalProviderName(this.grammar));
      _builder.append(_packageName);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import ");
      String _genProposalProviderName = this.getGenProposalProviderName();
      _builder.append(_genProposalProviderName);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#content-assist");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* on how to customize the content assistant.");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("class ");
      String _simpleName = this._naming.toSimpleName(this.getProposalProviderName(this.grammar));
      _builder.append(_simpleName);
      _builder.append(" extends ");
      String _simpleName_1 = this._naming.toSimpleName(this.getGenProposalProviderName());
      _builder.append(_simpleName_1);
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      ctx.writeFile(Generator.SRC_UI, _plus, _builder);
    }
    XpandFacade.create(ctx.getXpandExecutionContext()).evaluate2(
      "org::eclipse::xtext::ui::generator::contentAssist::JavaBasedContentAssistFragment::GenProposalProvider", 
      this.grammar, 
      Collections.<Object>singletonList(this.getSuperClassName()));
  }
  
  @Pure
  @Override
  public boolean isInheritImplementation() {
    return this.inheritImplementation;
  }
  
  public void setInheritImplementation(final boolean inheritImplementation) {
    this.inheritImplementation = inheritImplementation;
  }
  
  @Pure
  @Override
  public boolean isGenerateStub() {
    return this.generateStub;
  }
  
  public void setGenerateStub(final boolean generateStub) {
    this.generateStub = generateStub;
  }
}
