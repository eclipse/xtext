/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator.serializer;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.generator.serializer.GeneratedFile;
import org.eclipse.xtext.generator.serializer.JavaFile;
import org.eclipse.xtext.generator.serializer.SerializerGenFileNames;
import org.eclipse.xtext.generator.terminals.SyntheticTerminalDetector;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Moritz Eyshold - Initial contribution and API
 */
@SuppressWarnings("all")
public class SyntacticSequencer extends GeneratedFile {
  @Inject
  private Grammar grammar;
  
  @Inject
  private SerializerGenFileNames names;
  
  /**
   * @since 2.8
   */
  @Accessors
  private boolean detectSyntheticTerminals = true;
  
  /**
   * @since 2.8
   */
  @Accessors
  @Extension
  private SyntheticTerminalDetector syntheticTerminalDetector;
  
  @Inject
  @Named("generateXtendStub")
  private Boolean generateXtendStub;
  
  @Inject
  @Named("fileHeader")
  private String fileHeader;
  
  private CharSequence unassignedCalledTokenRuleName(final AbstractRule rule) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("get");
    String _name = rule.getName();
    _builder.append(_name, "");
    _builder.append("Token");
    return _builder;
  }
  
  @Override
  public CharSequence getFileContents(final SerializerGenFileNames.GenFileName filename) {
    String _packageName = filename.getPackageName();
    final JavaFile file = new JavaFile(_packageName);
    String _xifexpression = null;
    if ((this.generateXtendStub).booleanValue()) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class ");
      String _simpleName = filename.getSimpleName();
      _builder.append(_simpleName, "");
      _builder.append(" extends ");
      SerializerGenFileNames.GenFileName _abstractSyntacticSequencer = this.names.getAbstractSyntacticSequencer();
      String _simpleName_1 = _abstractSyntacticSequencer.getSimpleName();
      _builder.append(_simpleName_1, "");
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      {
        if (this.detectSyntheticTerminals) {
          {
            List<TerminalRule> _allTerminalRules = GrammarUtil.allTerminalRules(this.grammar);
            final Function1<TerminalRule, Boolean> _function = new Function1<TerminalRule, Boolean>() {
              @Override
              public Boolean apply(final TerminalRule it) {
                return Boolean.valueOf(SyntacticSequencer.this.syntheticTerminalDetector.isSyntheticTerminalRule(it));
              }
            };
            Iterable<TerminalRule> _filter = IterableExtensions.<TerminalRule>filter(_allTerminalRules, _function);
            for(final TerminalRule rule : _filter) {
              _builder.append("\t");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("/**");
              _builder.newLine();
              _builder.append("\t");
              _builder.append(" ");
              _builder.append("* Stub implementation for a synthetic terminal rule. Defaults to the empty string.");
              _builder.newLine();
              _builder.append("\t");
              _builder.append(" ");
              _builder.append("*/");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("// TODO review the concrete syntax for the terminal");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("override ");
              CharSequence _unassignedCalledTokenRuleName = this.unassignedCalledTokenRuleName(rule);
              _builder.append(_unassignedCalledTokenRuleName, "\t");
              _builder.append("(");
              String _imported = file.imported(EObject.class);
              _builder.append(_imported, "\t");
              _builder.append(" semanticObject, ");
              String _imported_1 = file.imported(RuleCall.class);
              _builder.append(_imported_1, "\t");
              _builder.append(" ruleCall, ");
              String _imported_2 = file.imported(INode.class);
              _builder.append(_imported_2, "\t");
              _builder.append(" node) {");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("return \'\'");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("}");
              _builder.newLine();
            }
          }
        }
      }
      _builder.append("}");
      _builder.newLine();
      _xifexpression = _builder.toString();
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("public class ");
      String _simpleName_2 = filename.getSimpleName();
      _builder_1.append(_simpleName_2, "");
      _builder_1.append(" extends ");
      SerializerGenFileNames.GenFileName _abstractSyntacticSequencer_1 = this.names.getAbstractSyntacticSequencer();
      String _simpleName_3 = _abstractSyntacticSequencer_1.getSimpleName();
      _builder_1.append(_simpleName_3, "");
      _builder_1.append(" {");
      _builder_1.newLineIfNotEmpty();
      {
        if (this.detectSyntheticTerminals) {
          {
            List<TerminalRule> _allTerminalRules_1 = GrammarUtil.allTerminalRules(this.grammar);
            final Function1<TerminalRule, Boolean> _function_1 = new Function1<TerminalRule, Boolean>() {
              @Override
              public Boolean apply(final TerminalRule it) {
                return Boolean.valueOf(SyntacticSequencer.this.syntheticTerminalDetector.isSyntheticTerminalRule(it));
              }
            };
            Iterable<TerminalRule> _filter_1 = IterableExtensions.<TerminalRule>filter(_allTerminalRules_1, _function_1);
            for(final TerminalRule rule_1 : _filter_1) {
              _builder_1.append("\t");
              _builder_1.newLine();
              _builder_1.append("\t");
              _builder_1.append("/**");
              _builder_1.newLine();
              _builder_1.append("\t");
              _builder_1.append(" ");
              _builder_1.append("* Stub implementation for a synthetic terminal rule. Defaults to the empty string.");
              _builder_1.newLine();
              _builder_1.append("\t");
              _builder_1.append(" ");
              _builder_1.append("*/");
              _builder_1.newLine();
              _builder_1.append("\t");
              _builder_1.append("// TODO review the concrete syntax for the terminal");
              _builder_1.newLine();
              _builder_1.append("\t");
              _builder_1.append("@Override");
              _builder_1.newLine();
              _builder_1.append("\t");
              _builder_1.append("public String ");
              CharSequence _unassignedCalledTokenRuleName_1 = this.unassignedCalledTokenRuleName(rule_1);
              _builder_1.append(_unassignedCalledTokenRuleName_1, "\t");
              _builder_1.append("(");
              String _imported_3 = file.imported(EObject.class);
              _builder_1.append(_imported_3, "\t");
              _builder_1.append(" semanticObject, ");
              String _imported_4 = file.imported(RuleCall.class);
              _builder_1.append(_imported_4, "\t");
              _builder_1.append(" ruleCall, ");
              String _imported_5 = file.imported(INode.class);
              _builder_1.append(_imported_5, "\t");
              _builder_1.append(" node) {");
              _builder_1.newLineIfNotEmpty();
              _builder_1.append("\t");
              _builder_1.append("\t");
              _builder_1.append("return \"\";");
              _builder_1.newLine();
              _builder_1.append("\t");
              _builder_1.append("}");
              _builder_1.newLine();
            }
          }
        }
      }
      _builder_1.append("}");
      _builder_1.newLine();
      _xifexpression = _builder_1.toString();
    }
    file.body = _xifexpression;
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("/*");
    _builder_2.newLine();
    _builder_2.append(" ");
    _builder_2.append(this.fileHeader, " ");
    _builder_2.newLineIfNotEmpty();
    _builder_2.append(" ");
    _builder_2.append("*/");
    _builder_2.newLine();
    String _string = file.toString();
    _builder_2.append(_string, "");
    _builder_2.newLineIfNotEmpty();
    return _builder_2;
  }
  
  @Pure
  public boolean isDetectSyntheticTerminals() {
    return this.detectSyntheticTerminals;
  }
  
  public void setDetectSyntheticTerminals(final boolean detectSyntheticTerminals) {
    this.detectSyntheticTerminals = detectSyntheticTerminals;
  }
  
  @Pure
  public SyntheticTerminalDetector getSyntheticTerminalDetector() {
    return this.syntheticTerminalDetector;
  }
  
  public void setSyntheticTerminalDetector(final SyntheticTerminalDetector syntheticTerminalDetector) {
    this.syntheticTerminalDetector = syntheticTerminalDetector;
  }
}
