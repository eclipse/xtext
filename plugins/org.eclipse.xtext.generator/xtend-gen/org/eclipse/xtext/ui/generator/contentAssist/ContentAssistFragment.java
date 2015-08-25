/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.generator.contentAssist;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xpand2.XpandExecutionContext;
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
        String _proposalProviderName = this.getProposalProviderName(grammar);
        bindFactory.addTypeToType("org.eclipse.xtext.ui.editor.contentassist.IContentProposalProvider", _proposalProviderName);
      } else {
        String _genProposalProviderName = this.getGenProposalProviderName();
        bindFactory.addTypeToType("org.eclipse.xtext.ui.editor.contentassist.IContentProposalProvider", _genProposalProviderName);
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
    String _proposalProviderName = this.getProposalProviderName(grammar);
    String _packageName = this._naming.packageName(_proposalProviderName);
    return ((String[])Conversions.unwrapArray(Collections.<String>singletonList(_packageName), String.class));
  }
  
  public String getSuperClassName() {
    String _xblockexpression = null;
    {
      EList<Grammar> _usedGrammars = this.grammar.getUsedGrammars();
      final Grammar superGrammar = IterableExtensions.<Grammar>head(_usedGrammars);
      String _xifexpression = null;
      boolean _and = false;
      if (!this.inheritImplementation) {
        _and = false;
      } else {
        boolean _notEquals = (!Objects.equal(superGrammar, null));
        _and = _notEquals;
      }
      if (_and) {
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
      String _proposalProviderName = this.getProposalProviderName(this.grammar);
      String _asPath = this._naming.asPath(_proposalProviderName);
      String _plus = (_asPath + ".xtend");
      StringConcatenation _builder = new StringConcatenation();
      String _fileHeader = this._naming.fileHeader();
      _builder.append(_fileHeader, "");
      _builder.newLineIfNotEmpty();
      _builder.append("package ");
      String _proposalProviderName_1 = this.getProposalProviderName(this.grammar);
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
      _builder.append("* See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#content-assist");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* on how to customize the content assistant.");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("class ");
      String _proposalProviderName_2 = this.getProposalProviderName(this.grammar);
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
    String _superClassName = this.getSuperClassName();
    List<Object> _singletonList = Collections.<Object>singletonList(_superClassName);
    _create.evaluate2(
      "org::eclipse::xtext::ui::generator::contentAssist::JavaBasedContentAssistFragment::GenProposalProvider", 
      this.grammar, _singletonList);
  }
  
  @Pure
  public boolean isInheritImplementation() {
    return this.inheritImplementation;
  }
  
  public void setInheritImplementation(final boolean inheritImplementation) {
    this.inheritImplementation = inheritImplementation;
  }
  
  @Pure
  public boolean isGenerateStub() {
    return this.generateStub;
  }
  
  public void setGenerateStub(final boolean generateStub) {
    this.generateStub = generateStub;
  }
}
