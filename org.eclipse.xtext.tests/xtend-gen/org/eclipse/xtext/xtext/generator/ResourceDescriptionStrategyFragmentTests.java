/**
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xtext.generator.AbstractGeneratorFragmentTests;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Holger Schill - Initial contribution and API
 * @since 2.14
 */
@SuppressWarnings("all")
public class ResourceDescriptionStrategyFragmentTests extends AbstractGeneratorFragmentTests {
  @Test
  public void testGenerateNothing() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.xtext.Foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate foo \"http://org.xtext/foo\"");
    _builder.newLine();
    _builder.append("Model: rules+=Rule;");
    _builder.newLine();
    _builder.append("Rule: name=ID;");
    _builder.newLine();
    final AbstractGeneratorFragmentTests.TestableResourceDescriptionStrategyFragment fragment = this.initializeFragmentWithGrammarFromString(_builder.toString());
    final Iterable<AbstractRule> exportedRules = fragment.getExportedRulesFromGrammar();
    Assert.assertTrue(IterableExtensions.isEmpty(exportedRules));
    Assert.assertFalse(fragment.shouldGenerate(exportedRules));
  }
  
  @Test
  public void testGenerate() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.xtext.Foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate foo \"http://org.xtext/foo\"");
    _builder.newLine();
    _builder.append("Model: rules+=Rule;");
    _builder.newLine();
    _builder.append("@Exported");
    _builder.newLine();
    _builder.append("Rule: name=ID;");
    _builder.newLine();
    final AbstractGeneratorFragmentTests.TestableResourceDescriptionStrategyFragment fragment = this.initializeFragmentWithGrammarFromString(_builder.toString());
    final Iterable<AbstractRule> exportedRules = fragment.getExportedRulesFromGrammar();
    Assert.assertFalse(IterableExtensions.isEmpty(exportedRules));
    Assert.assertTrue(fragment.shouldGenerate(exportedRules));
    final StringConcatenationClient result = fragment.generateSuperResourceDescriptionStrategyContent(exportedRules);
    final StringConcatenation stringConcat = new StringConcatenation("\n");
    stringConcat.append(result);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("public class FooDefaultResourceDescriptionStrategy extends org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("public boolean createEObjectDescriptions(interface org.eclipse.emf.ecore.EObject eObject, interface org.eclipse.xtext.util.IAcceptor<interface org.eclipse.xtext.resource.IEObjectDescription> acceptor) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("if(eObject instanceof org.xtext.foo.Rule) {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("return createEObjectDescriptionsForRule(eObject, acceptor);");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("return true;");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("protected boolean createEObjectDescriptionsForRule(EObject eObject, IAcceptor<IEObjectDescription> acceptor) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("return super.createEObjectDescriptions(eObject, acceptor);");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    Assert.assertEquals(_builder_1.toString(), stringConcat.toString());
  }
}
