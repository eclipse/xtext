/**
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator;

import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.xtext.generator.AbstractGeneratorFragmentTests;
import org.eclipse.xtext.xtext.generator.index.ResourceDescriptionStrategyFragment;
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Holger Schill - Initial contribution and API
 * @since 2.14
 */
@SuppressWarnings("all")
public class ResourceDescriptionStrategyFragmentTests extends AbstractGeneratorFragmentTests {
  public static class TestableResourceDescriptionStrategyFragment extends ResourceDescriptionStrategyFragment {
    @Override
    protected TypeReference getAbstractResourceDescriptionStrategyClass() {
      return super.getAbstractResourceDescriptionStrategyClass();
    }
    
    @Override
    protected TypeReference getDefaultResourceDescriptionStrategyClass() {
      return super.getDefaultResourceDescriptionStrategyClass();
    }
    
    @Override
    public List<AbstractRule> getExportedRulesFromGrammar() {
      return super.getExportedRulesFromGrammar();
    }
    
    @Override
    protected boolean shouldGenerateArtefacts(final Iterable<AbstractRule> exportedRules) {
      return super.shouldGenerateArtefacts(exportedRules);
    }
    
    @Override
    protected JavaFileAccess generateResourceDescriptionStrategy(final Iterable<AbstractRule> exportedRules) {
      return super.generateResourceDescriptionStrategy(exportedRules);
    }
    
    @Override
    protected TypeReference getSuperTypeRef() {
      return super.getSuperTypeRef();
    }
  }
  
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
    final ResourceDescriptionStrategyFragmentTests.TestableResourceDescriptionStrategyFragment fragment = this.<ResourceDescriptionStrategyFragmentTests.TestableResourceDescriptionStrategyFragment>initializeFragmentWithGrammarFromString(ResourceDescriptionStrategyFragmentTests.TestableResourceDescriptionStrategyFragment.class, _builder.toString());
    final List<AbstractRule> exportedRules = fragment.getExportedRulesFromGrammar();
    Assert.assertTrue(exportedRules.isEmpty());
    Assert.assertFalse(fragment.shouldGenerateArtefacts(exportedRules));
  }
  
  @Test
  public void testGenerateNothing_1() {
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
    final ResourceDescriptionStrategyFragmentTests.TestableResourceDescriptionStrategyFragment fragment = this.<ResourceDescriptionStrategyFragmentTests.TestableResourceDescriptionStrategyFragment>initializeFragmentWithGrammarFromString(ResourceDescriptionStrategyFragmentTests.TestableResourceDescriptionStrategyFragment.class, _builder.toString());
    fragment.setGenerate(false);
    final List<AbstractRule> exportedRules = fragment.getExportedRulesFromGrammar();
    Assert.assertFalse(exportedRules.isEmpty());
    Assert.assertFalse(fragment.shouldGenerateArtefacts(exportedRules));
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
    _builder.append("@Exported");
    _builder.newLine();
    _builder.append("Foo returns Rule: name=ID;");
    _builder.newLine();
    final ResourceDescriptionStrategyFragmentTests.TestableResourceDescriptionStrategyFragment fragment = this.<ResourceDescriptionStrategyFragmentTests.TestableResourceDescriptionStrategyFragment>initializeFragmentWithGrammarFromString(ResourceDescriptionStrategyFragmentTests.TestableResourceDescriptionStrategyFragment.class, _builder.toString());
    final List<AbstractRule> exportedRules = fragment.getExportedRulesFromGrammar();
    Assert.assertFalse(exportedRules.isEmpty());
    Assert.assertEquals(1, exportedRules.size());
    Assert.assertTrue(fragment.shouldGenerateArtefacts(exportedRules));
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package org.xtext.resource;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.emf.ecore.EObject;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.resource.IEObjectDescription;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.util.IAcceptor;");
    _builder_1.newLine();
    _builder_1.append("import org.xtext.foo.Rule;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("public class FooAbstractResourceDescriptionStrategy extends DefaultResourceDescriptionStrategy {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("public boolean createEObjectDescriptions(EObject eObject, IAcceptor<IEObjectDescription> acceptor) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("if(eObject instanceof Rule) {");
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
    Assert.assertEquals(_builder_1.toString(), this.concatenationClientToString(fragment.generateResourceDescriptionStrategy(exportedRules)));
  }
  
  @Test
  public void testGenerate_NoStubs() {
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
    _builder.append("@Exported");
    _builder.newLine();
    _builder.append("Foo returns Rule: name=ID;");
    _builder.newLine();
    final ResourceDescriptionStrategyFragmentTests.TestableResourceDescriptionStrategyFragment fragment = this.<ResourceDescriptionStrategyFragmentTests.TestableResourceDescriptionStrategyFragment>initializeFragmentWithGrammarFromString(ResourceDescriptionStrategyFragmentTests.TestableResourceDescriptionStrategyFragment.class, _builder.toString());
    fragment.setGenerateStub(false);
    fragment.setGenerateXtendStub(false);
    final List<AbstractRule> exportedRules = fragment.getExportedRulesFromGrammar();
    Assert.assertFalse(exportedRules.isEmpty());
    Assert.assertEquals(1, exportedRules.size());
    Assert.assertTrue(fragment.shouldGenerateArtefacts(exportedRules));
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package org.xtext.resource;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.emf.ecore.EObject;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.resource.IEObjectDescription;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.util.IAcceptor;");
    _builder_1.newLine();
    _builder_1.append("import org.xtext.foo.Rule;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("public class FooDefaultResourceDescriptionStrategy extends DefaultResourceDescriptionStrategy {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("public boolean createEObjectDescriptions(EObject eObject, IAcceptor<IEObjectDescription> acceptor) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("if(eObject instanceof Rule) {");
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
    Assert.assertEquals(_builder_1.toString(), this.concatenationClientToString(fragment.generateResourceDescriptionStrategy(exportedRules)));
  }
}
