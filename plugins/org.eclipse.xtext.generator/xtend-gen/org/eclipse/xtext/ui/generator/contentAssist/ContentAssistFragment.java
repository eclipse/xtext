/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.generator.contentAssist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Named;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xpand2.XpandFacade;
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

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.4
 */
@SuppressWarnings("all")
public class ContentAssistFragment extends Xtend2GeneratorFragment implements IInheriting, IStubGenerating {
  @Inject
  private Naming _naming;
  
  @Inject
  private Grammar grammar;
  
  private boolean _inheritImplementation;
  
  public boolean isInheritImplementation() {
    return this._inheritImplementation;
  }
  
  public void setInheritImplementation(final boolean inheritImplementation) {
    this._inheritImplementation = inheritImplementation;
  }
  
  private boolean _generateStub = true;
  
  public boolean isGenerateStub() {
    return this._generateStub;
  }
  
  public void setGenerateStub(final boolean generateStub) {
    this._generateStub = generateStub;
  }
  
  @Inject
  @Named(value = "fileHeader")
  private String fileHeader;
  
  public String getProposalProviderName() {
    String _basePackageUi = this._naming.basePackageUi(this.grammar);
    String _plus = (_basePackageUi + ".contentassist.");
    String _name = GrammarUtil.getName(this.grammar);
    String _plus_1 = (_plus + _name);
    return (_plus_1 + "ProposalProvider");
  }
  
  public String getGenProposalProviderName() {
    String _basePackageUi = this._naming.basePackageUi(this.grammar);
    String _plus = (_basePackageUi + ".contentassist.Abstract");
    String _name = GrammarUtil.getName(this.grammar);
    String _plus_1 = (_plus + _name);
    return (_plus_1 + "ProposalProvider");
  }
  
  public Set<Binding> getGuiceBindingsUi(final Grammar grammar) {
    Set<Binding> _xblockexpression = null;
    {
      BindFactory _bindFactory = new BindFactory();
      final BindFactory bindFactory = _bindFactory;
      boolean _isGenerateStub = this.isGenerateStub();
      if (_isGenerateStub) {
        String _proposalProviderName = this.getProposalProviderName();
        bindFactory.addTypeToType("org.eclipse.xtext.ui.editor.contentassist.IContentProposalProvider", _proposalProviderName);
      } else {
        String _genProposalProviderName = this.getGenProposalProviderName();
        bindFactory.addTypeToType("org.eclipse.xtext.ui.editor.contentassist.IContentProposalProvider", _genProposalProviderName);
      }
      Set<Binding> _bindings = bindFactory.getBindings();
      _xblockexpression = (_bindings);
    }
    return _xblockexpression;
  }
  
  public String[] getRequiredBundlesUi(final Grammar grammar) {
    List<String> _singletonList = Collections.<String>singletonList("org.eclipse.xtext.ui");
    return ((String[])Conversions.unwrapArray(_singletonList, String.class));
  }
  
  public String[] getImportedPackagesUi(final Grammar grammar) {
    Collection<String> _xifexpression = null;
    boolean _isGenerateStub = this.isGenerateStub();
    if (_isGenerateStub) {
      ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("org.apache.log4j", "org.eclipse.xtext.xbase.lib");
      _xifexpression = _newArrayList;
    } else {
      Set<String> _singleton = Collections.<String>singleton("org.apache.log4j");
      _xifexpression = _singleton;
    }
    return ((String[])Conversions.unwrapArray(_xifexpression, String.class));
  }
  
  public String[] getExportedPackagesUi(final Grammar grammar) {
    String _proposalProviderName = this.getProposalProviderName();
    String _packageName = this._naming.packageName(_proposalProviderName);
    List<String> _singletonList = Collections.<String>singletonList(_packageName);
    return ((String[])Conversions.unwrapArray(_singletonList, String.class));
  }
  
  public void generate(final Xtend2ExecutionContext ctx) {
    boolean _isGenerateStub = this.isGenerateStub();
    if (_isGenerateStub) {
      String _proposalProviderName = this.getProposalProviderName();
      String _asPath = this._naming.asPath(_proposalProviderName);
      String _plus = (_asPath + ".xtend");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("/*");
      _builder.newLine();
      _builder.append(" ");
      _builder.append(this.fileHeader, " ");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("package ");
      String _proposalProviderName_1 = this.getProposalProviderName();
      String _packageName = this._naming.packageName(_proposalProviderName_1);
      _builder.append(_packageName, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import ");
      String _genProposalProviderName = this.getGenProposalProviderName();
      _builder.append(_genProposalProviderName, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on how to customize content assistant");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("class ");
      String _proposalProviderName_2 = this.getProposalProviderName();
      String _simpleName = this._naming.toSimpleName(_proposalProviderName_2);
      _builder.append(_simpleName, "");
      _builder.append(" extends ");
      String _genProposalProviderName_1 = this.getGenProposalProviderName();
      String _simpleName_1 = this._naming.toSimpleName(_genProposalProviderName_1);
      _builder.append(_simpleName_1, "");
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      ctx.writeFile(Generator.SRC_UI, _plus, _builder);
    }
    XpandExecutionContext _xpandExecutionContext = ctx.getXpandExecutionContext();
    XpandFacade _create = XpandFacade.create(_xpandExecutionContext);
    boolean _isInheritImplementation = this.isInheritImplementation();
    List<Object> _singletonList = Collections.<Object>singletonList(Boolean.valueOf(_isInheritImplementation));
    _create.evaluate2(
      "org::eclipse::xtext::ui::generator::contentAssist::JavaBasedContentAssistFragment::GenProposalProvider", 
      this.grammar, _singletonList);
  }
}
