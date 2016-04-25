/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.ui.editor.hierarchy;

import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.Collection;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.editor.hierarchy.ICallHierarchyBuilder;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyBuilder;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyNode;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.ide.AbstractHierarchyBuilderTest;
import org.eclipse.xtext.junit4.internal.XtextInjectorProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.editor.hierarchy.XtextCallHierarchyBuilder;
import org.eclipse.xtext.ui.editor.hierarchy.XtextCallHierarchyNode;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author kosyakov - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(XtextInjectorProvider.class)
@SuppressWarnings("all")
public class XtextCallHierarchyBuilderTest extends AbstractHierarchyBuilderTest {
  @Inject
  private Provider<XtextCallHierarchyBuilder> callHierarchyBuilderProvider;
  
  @Override
  protected void testBuildHierarchy(final Procedure1<? super AbstractHierarchyBuilderTest.HierarchyBuilderTestConfiguration> configurator) {
    final Procedure1<AbstractHierarchyBuilderTest.HierarchyBuilderTestConfiguration> _function = new Procedure1<AbstractHierarchyBuilderTest.HierarchyBuilderTestConfiguration>() {
      @Override
      public void apply(final AbstractHierarchyBuilderTest.HierarchyBuilderTestConfiguration it) {
        final Function1<ResourceSet, IHierarchyBuilder> _function = new Function1<ResourceSet, IHierarchyBuilder>() {
          @Override
          public IHierarchyBuilder apply(final ResourceSet resourceSet) {
            XtextCallHierarchyBuilder _get = XtextCallHierarchyBuilderTest.this.callHierarchyBuilderProvider.get();
            final XtextCallHierarchyBuilder callHierarchyBuilder = XtextCallHierarchyBuilderTest.this.<XtextCallHierarchyBuilder>configureBuilderWith(_get, resourceSet);
            callHierarchyBuilder.setHierarchyType(ICallHierarchyBuilder.CallHierarchyType.CALLER);
            return callHierarchyBuilder;
          }
        };
        it.setHierarchyBuilderProvider(_function);
        configurator.apply(it);
      }
    };
    super.testBuildHierarchy(_function);
  }
  
  protected void testBuildCalleeHierarchy(final Procedure1<? super AbstractHierarchyBuilderTest.HierarchyBuilderTestConfiguration> configurator) {
    final Procedure1<AbstractHierarchyBuilderTest.HierarchyBuilderTestConfiguration> _function = new Procedure1<AbstractHierarchyBuilderTest.HierarchyBuilderTestConfiguration>() {
      @Override
      public void apply(final AbstractHierarchyBuilderTest.HierarchyBuilderTestConfiguration it) {
        final Function1<ResourceSet, IHierarchyBuilder> _function = new Function1<ResourceSet, IHierarchyBuilder>() {
          @Override
          public IHierarchyBuilder apply(final ResourceSet resourceSet) {
            XtextCallHierarchyBuilder _get = XtextCallHierarchyBuilderTest.this.callHierarchyBuilderProvider.get();
            final XtextCallHierarchyBuilder callHierarchyBuilder = XtextCallHierarchyBuilderTest.this.<XtextCallHierarchyBuilder>configureBuilderWith(_get, resourceSet);
            callHierarchyBuilder.setHierarchyType(ICallHierarchyBuilder.CallHierarchyType.CALLEE);
            return callHierarchyBuilder;
          }
        };
        it.setHierarchyBuilderProvider(_function);
        configurator.apply(it);
      }
    };
    super.testBuildHierarchy(_function);
  }
  
  @Test
  public void testBuildHierarchy_01() {
    final Procedure1<AbstractHierarchyBuilderTest.HierarchyBuilderTestConfiguration> _function = new Procedure1<AbstractHierarchyBuilderTest.HierarchyBuilderTestConfiguration>() {
      @Override
      public void apply(final AbstractHierarchyBuilderTest.HierarchyBuilderTestConfiguration it) {
        Collection<Pair<String, String>> _models = it.getModels();
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("grammar org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage with org.eclipse.xtext.common.Terminals");
        _builder.newLine();
        _builder.newLine();
        _builder.append("generate callHierarchyBuilderTestLanguage \"http://www.eclipse.org/2010/tmf/xtext/CallHierarchyBuilderTestLanguage\"");
        _builder.newLine();
        _builder.newLine();
        _builder.append("Model:");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("element+=Element*");
        _builder.newLine();
        _builder.append(";");
        _builder.newLine();
        _builder.newLine();
        _builder.append("Element:");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("name=ID");
        _builder.newLine();
        _builder.append(";");
        _builder.newLine();
        Pair<String, String> _mappedTo = Pair.<String, String>of("callHierarchyBuilderTestLanguage.xtext", _builder.toString());
        _models.add(_mappedTo);
        Collection<Pair<String, String>> _models_1 = it.getModels();
        Pair<String, String> _head = IterableExtensions.<Pair<String, String>>head(_models_1);
        String _value = _head.getValue();
        int _indexOf = _value.indexOf("Element*");
        it.setIndex(_indexOf);
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("Element {");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("Model {");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("\'element+=Element*\' [250, 17]");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        it.setExpectedHierarchy(_builder_1.toString());
      }
    };
    this.testBuildHierarchy(_function);
  }
  
  @Test
  public void testBuildCalleeHierarchy_01() {
    final Procedure1<AbstractHierarchyBuilderTest.HierarchyBuilderTestConfiguration> _function = new Procedure1<AbstractHierarchyBuilderTest.HierarchyBuilderTestConfiguration>() {
      @Override
      public void apply(final AbstractHierarchyBuilderTest.HierarchyBuilderTestConfiguration it) {
        Collection<Pair<String, String>> _models = it.getModels();
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("grammar org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage with org.eclipse.xtext.common.Terminals");
        _builder.newLine();
        _builder.newLine();
        _builder.append("generate callHierarchyBuilderTestLanguage \"http://www.eclipse.org/2010/tmf/xtext/CallHierarchyBuilderTestLanguage\"");
        _builder.newLine();
        _builder.newLine();
        _builder.append("Model:");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("element+=Element*");
        _builder.newLine();
        _builder.append(";");
        _builder.newLine();
        _builder.newLine();
        _builder.append("Element:");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("name=ID");
        _builder.newLine();
        _builder.append(";");
        _builder.newLine();
        Pair<String, String> _mappedTo = Pair.<String, String>of("callHierarchyBuilderTestLanguage.xtext", _builder.toString());
        _models.add(_mappedTo);
        Collection<Pair<String, String>> _models_1 = it.getModels();
        Pair<String, String> _head = IterableExtensions.<Pair<String, String>>head(_models_1);
        String _value = _head.getValue();
        int _indexOf = _value.indexOf("Model");
        it.setIndex(_indexOf);
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("Model {");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("Element {");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("\'element+=Element*\' [250, 17]");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("ID {");
        _builder_1.newLine();
        _builder_1.append("\t\t\t");
        _builder_1.append("grammar: org.eclipse.xtext.common.Terminals");
        _builder_1.newLine();
        _builder_1.append("\t\t\t");
        _builder_1.append("\'name=ID\' [281, 7]");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        it.setExpectedHierarchy(_builder_1.toString());
      }
    };
    this.testBuildCalleeHierarchy(_function);
  }
  
  @Test
  public void testBuildHierarchy_02() {
    final Procedure1<AbstractHierarchyBuilderTest.HierarchyBuilderTestConfiguration> _function = new Procedure1<AbstractHierarchyBuilderTest.HierarchyBuilderTestConfiguration>() {
      @Override
      public void apply(final AbstractHierarchyBuilderTest.HierarchyBuilderTestConfiguration it) {
        Collection<Pair<String, String>> _models = it.getModels();
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("grammar org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage with org.eclipse.xtext.common.Terminals");
        _builder.newLine();
        _builder.newLine();
        _builder.append("generate callHierarchyBuilderTestLanguage \"http://www.eclipse.org/2010/tmf/xtext/CallHierarchyBuilderTestLanguage\"");
        _builder.newLine();
        _builder.newLine();
        _builder.append("Model:");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("element+=AbstractElement*");
        _builder.newLine();
        _builder.append(";");
        _builder.newLine();
        _builder.newLine();
        _builder.append("AbstractElement:");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("Element |");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\'(\' Model \')\'");
        _builder.newLine();
        _builder.append(";");
        _builder.newLine();
        _builder.newLine();
        _builder.append("Element:");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("name=ID");
        _builder.newLine();
        _builder.append(";");
        _builder.newLine();
        Pair<String, String> _mappedTo = Pair.<String, String>of("callHierarchyBuilderTestLanguage.xtext", _builder.toString());
        _models.add(_mappedTo);
        Collection<Pair<String, String>> _models_1 = it.getModels();
        Pair<String, String> _head = IterableExtensions.<Pair<String, String>>head(_models_1);
        String _value = _head.getValue();
        int _indexOf = _value.indexOf("AbstractElement*");
        it.setIndex(_indexOf);
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("AbstractElement {");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("Model {");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("\'element+=AbstractElement*\' [250, 25]");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("AbstractElement {");
        _builder_1.newLine();
        _builder_1.append("\t\t\t");
        _builder_1.append("grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage");
        _builder_1.newLine();
        _builder_1.append("\t\t\t");
        _builder_1.append("\'Model\' [312, 5]");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        it.setExpectedHierarchy(_builder_1.toString());
      }
    };
    this.testBuildHierarchy(_function);
  }
  
  @Test
  public void testBuildHierarchy_03() {
    final Procedure1<AbstractHierarchyBuilderTest.HierarchyBuilderTestConfiguration> _function = new Procedure1<AbstractHierarchyBuilderTest.HierarchyBuilderTestConfiguration>() {
      @Override
      public void apply(final AbstractHierarchyBuilderTest.HierarchyBuilderTestConfiguration it) {
        Collection<Pair<String, String>> _models = it.getModels();
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("grammar org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage with org.eclipse.xtext.common.Terminals");
        _builder.newLine();
        _builder.newLine();
        _builder.append("generate callHierarchyBuilderTestLanguage \"http://www.eclipse.org/2010/tmf/xtext/CallHierarchyBuilderTestLanguage\"");
        _builder.newLine();
        _builder.newLine();
        _builder.append("Model:");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("element+=Element element+=Element element+=Element");
        _builder.newLine();
        _builder.append(";");
        _builder.newLine();
        _builder.newLine();
        _builder.append("Element:");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("name=ID");
        _builder.newLine();
        _builder.append(";");
        _builder.newLine();
        Pair<String, String> _mappedTo = Pair.<String, String>of("callHierarchyBuilderTestLanguage.xtext", _builder.toString());
        _models.add(_mappedTo);
        Collection<Pair<String, String>> _models_1 = it.getModels();
        Pair<String, String> _head = IterableExtensions.<Pair<String, String>>head(_models_1);
        String _value = _head.getValue();
        int _lastIndexOf = _value.lastIndexOf("Element");
        it.setIndex(_lastIndexOf);
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("Element {");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("Model {");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("\'element+=Element\' [250, 16]");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("\'element+=Element\' [267, 16]");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("\'element+=Element\' [284, 16]");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        it.setExpectedHierarchy(_builder_1.toString());
      }
    };
    this.testBuildHierarchy(_function);
  }
  
  @Test
  public void testBuildHierarchy_04() {
    final Procedure1<AbstractHierarchyBuilderTest.HierarchyBuilderTestConfiguration> _function = new Procedure1<AbstractHierarchyBuilderTest.HierarchyBuilderTestConfiguration>() {
      @Override
      public void apply(final AbstractHierarchyBuilderTest.HierarchyBuilderTestConfiguration it) {
        Collection<Pair<String, String>> _models = it.getModels();
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("grammar org.eclipse.xtext.ui.tests.editor.hierarchy.BaseCallHierarchyBuilderTestLanguage with org.eclipse.xtext.common.Terminals hidden(ID)");
        _builder.newLine();
        _builder.newLine();
        _builder.append("generate baseCallHierarchyBuilderTestLanguage \"http://www.eclipse.org/2010/tmf/xtext/BaseCallHierarchyBuilderTestLanguage\"");
        _builder.newLine();
        _builder.newLine();
        _builder.append("Model: name=ID;");
        _builder.newLine();
        Pair<String, String> _mappedTo = Pair.<String, String>of("baseCallHierarchyBuilderTestLanguage.xtext", _builder.toString());
        _models.add(_mappedTo);
        Collection<Pair<String, String>> _models_1 = it.getModels();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("grammar org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage with org.eclipse.xtext.ui.tests.editor.hierarchy.BaseCallHierarchyBuilderTestLanguage");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("generate callHierarchyBuilderTestLanguage \"http://www.eclipse.org/2010/tmf/xtext/CallHierarchyBuilderTestLanguage\"");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("Model: name=ID;");
        _builder_1.newLine();
        Pair<String, String> _mappedTo_1 = Pair.<String, String>of("callHierarchyBuilderTestLanguage.xtext", _builder_1.toString());
        _models_1.add(_mappedTo_1);
        Collection<Pair<String, String>> _models_2 = it.getModels();
        Pair<String, String> _head = IterableExtensions.<Pair<String, String>>head(_models_2);
        String _key = _head.getKey();
        it.setResourceURI(_key);
        Collection<Pair<String, String>> _models_3 = it.getModels();
        Pair<String, String> _head_1 = IterableExtensions.<Pair<String, String>>head(_models_3);
        String _value = _head_1.getValue();
        int _indexOf = _value.indexOf("ID");
        it.setIndex(_indexOf);
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("ID {");
        _builder_2.newLine();
        _builder_2.append("\t");
        _builder_2.append("grammar: org.eclipse.xtext.common.Terminals");
        _builder_2.newLine();
        _builder_2.append("\t");
        _builder_2.append("org.eclipse.xtext.ui.tests.editor.hierarchy.BaseCallHierarchyBuilderTestLanguage {");
        _builder_2.newLine();
        _builder_2.append("\t\t");
        _builder_2.append("grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.BaseCallHierarchyBuilderTestLanguage");
        _builder_2.newLine();
        _builder_2.append("\t\t");
        _builder_2.append("\'ID\' [136, 2]");
        _builder_2.newLine();
        _builder_2.append("\t");
        _builder_2.append("}");
        _builder_2.newLine();
        _builder_2.append("\t");
        _builder_2.append("Model {");
        _builder_2.newLine();
        _builder_2.append("\t\t");
        _builder_2.append("grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.BaseCallHierarchyBuilderTestLanguage");
        _builder_2.newLine();
        _builder_2.append("\t\t");
        _builder_2.append("\'name=ID\' [272, 7]");
        _builder_2.newLine();
        _builder_2.append("\t");
        _builder_2.append("}");
        _builder_2.newLine();
        _builder_2.append("\t");
        _builder_2.append("Model {");
        _builder_2.newLine();
        _builder_2.append("\t\t");
        _builder_2.append("grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage");
        _builder_2.newLine();
        _builder_2.append("\t\t");
        _builder_2.append("\'name=ID\' [295, 7]");
        _builder_2.newLine();
        _builder_2.append("\t");
        _builder_2.append("}");
        _builder_2.newLine();
        _builder_2.append("}");
        _builder_2.newLine();
        it.setExpectedHierarchy(_builder_2.toString());
      }
    };
    this.testBuildHierarchy(_function);
  }
  
  @Test
  public void testBuildHierarchy_05() {
    final Procedure1<AbstractHierarchyBuilderTest.HierarchyBuilderTestConfiguration> _function = new Procedure1<AbstractHierarchyBuilderTest.HierarchyBuilderTestConfiguration>() {
      @Override
      public void apply(final AbstractHierarchyBuilderTest.HierarchyBuilderTestConfiguration it) {
        Collection<Pair<String, String>> _models = it.getModels();
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("grammar org.eclipse.xtext.ui.tests.editor.hierarchy.BaseCallHierarchyBuilderTestLanguage with org.eclipse.xtext.common.Terminals");
        _builder.newLine();
        _builder.newLine();
        _builder.append("generate baseCallHierarchyBuilderTestLanguage \"http://www.eclipse.org/2010/tmf/xtext/BaseCallHierarchyBuilderTestLanguage\"");
        _builder.newLine();
        _builder.newLine();
        _builder.append("Model: name=ID;");
        _builder.newLine();
        Pair<String, String> _mappedTo = Pair.<String, String>of("baseCallHierarchyBuilderTestLanguage.xtext", _builder.toString());
        _models.add(_mappedTo);
        Collection<Pair<String, String>> _models_1 = it.getModels();
        Pair<String, String> _head = IterableExtensions.<Pair<String, String>>head(_models_1);
        String _value = _head.getValue();
        int _indexOf = _value.indexOf("BaseCallHierarchyBuilderTestLanguage");
        it.setIndex(_indexOf);
        it.setExpectedHierarchy("");
      }
    };
    this.testBuildHierarchy(_function);
  }
  
  @Test
  public void testBuildHierarchy_06() {
    final Procedure1<AbstractHierarchyBuilderTest.HierarchyBuilderTestConfiguration> _function = new Procedure1<AbstractHierarchyBuilderTest.HierarchyBuilderTestConfiguration>() {
      @Override
      public void apply(final AbstractHierarchyBuilderTest.HierarchyBuilderTestConfiguration it) {
        Collection<Pair<String, String>> _models = it.getModels();
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("grammar org.eclipse.xtext.ui.tests.editor.hierarchy.BaseCallHierarchyBuilderTestLanguage with org.eclipse.xtext.common.Terminals");
        _builder.newLine();
        _builder.newLine();
        _builder.append("generate baseCallHierarchyBuilderTestLanguage \"http://www.eclipse.org/2010/tmf/xtext/BaseCallHierarchyBuilderTestLanguage\"");
        _builder.newLine();
        _builder.newLine();
        _builder.append("Model: ");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("elements+=Element*");
        _builder.newLine();
        _builder.append(";");
        _builder.newLine();
        _builder.newLine();
        _builder.append("Element:");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("name=ID");
        _builder.newLine();
        _builder.append(";");
        _builder.newLine();
        Pair<String, String> _mappedTo = Pair.<String, String>of("baseCallHierarchyBuilderTestLanguage.xtext", _builder.toString());
        _models.add(_mappedTo);
        Collection<Pair<String, String>> _models_1 = it.getModels();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("grammar org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage with org.eclipse.xtext.ui.tests.editor.hierarchy.BaseCallHierarchyBuilderTestLanguage");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("generate callHierarchyBuilderTestLanguage \"http://www.eclipse.org/2010/tmf/xtext/CallHierarchyBuilderTestLanguage\"");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("Model2:");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("elements+=Element*");
        _builder_1.newLine();
        _builder_1.append(";");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("Element:");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("name=ID");
        _builder_1.newLine();
        _builder_1.append(";");
        _builder_1.newLine();
        Pair<String, String> _mappedTo_1 = Pair.<String, String>of("callHierarchyBuilderTestLanguage.xtext", _builder_1.toString());
        _models_1.add(_mappedTo_1);
        Collection<Pair<String, String>> _models_2 = it.getModels();
        Pair<String, String> _head = IterableExtensions.<Pair<String, String>>head(_models_2);
        String _key = _head.getKey();
        it.setResourceURI(_key);
        Collection<Pair<String, String>> _models_3 = it.getModels();
        Pair<String, String> _head_1 = IterableExtensions.<Pair<String, String>>head(_models_3);
        String _value = _head_1.getValue();
        int _indexOf = _value.indexOf("Element");
        it.setIndex(_indexOf);
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("Element {");
        _builder_2.newLine();
        _builder_2.append("\t");
        _builder_2.append("grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage");
        _builder_2.newLine();
        _builder_2.append("\t");
        _builder_2.append("Model {");
        _builder_2.newLine();
        _builder_2.append("\t\t");
        _builder_2.append("grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.BaseCallHierarchyBuilderTestLanguage");
        _builder_2.newLine();
        _builder_2.append("\t\t");
        _builder_2.append("\'elements+=Element*\' [263, 18]");
        _builder_2.newLine();
        _builder_2.append("\t");
        _builder_2.append("}");
        _builder_2.newLine();
        _builder_2.append("\t");
        _builder_2.append("Model2 {");
        _builder_2.newLine();
        _builder_2.append("\t\t");
        _builder_2.append("grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage");
        _builder_2.newLine();
        _builder_2.append("\t\t");
        _builder_2.append("\'elements+=Element*\' [297, 18]");
        _builder_2.newLine();
        _builder_2.append("\t");
        _builder_2.append("}");
        _builder_2.newLine();
        _builder_2.append("}");
        _builder_2.newLine();
        it.setExpectedHierarchy(_builder_2.toString());
      }
    };
    this.testBuildHierarchy(_function);
  }
  
  @Test
  public void testBuildHierarchy_07() {
    final Procedure1<AbstractHierarchyBuilderTest.HierarchyBuilderTestConfiguration> _function = new Procedure1<AbstractHierarchyBuilderTest.HierarchyBuilderTestConfiguration>() {
      @Override
      public void apply(final AbstractHierarchyBuilderTest.HierarchyBuilderTestConfiguration it) {
        Collection<Pair<String, String>> _models = it.getModels();
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("grammar org.eclipse.xtext.ui.tests.editor.hierarchy.BaseCallHierarchyBuilderTestLanguage with org.eclipse.xtext.common.Terminals");
        _builder.newLine();
        _builder.newLine();
        _builder.append("generate baseCallHierarchyBuilderTestLanguage \"http://www.eclipse.org/2010/tmf/xtext/BaseCallHierarchyBuilderTestLanguage\"");
        _builder.newLine();
        _builder.newLine();
        _builder.append("Model: ");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("elements+=Element*");
        _builder.newLine();
        _builder.append(";");
        _builder.newLine();
        _builder.newLine();
        _builder.append("Element:");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("name=ID");
        _builder.newLine();
        _builder.append(";");
        _builder.newLine();
        Pair<String, String> _mappedTo = Pair.<String, String>of("baseCallHierarchyBuilderTestLanguage.xtext", _builder.toString());
        _models.add(_mappedTo);
        Collection<Pair<String, String>> _models_1 = it.getModels();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("grammar org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage with org.eclipse.xtext.ui.tests.editor.hierarchy.BaseCallHierarchyBuilderTestLanguage");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("generate callHierarchyBuilderTestLanguage \"http://www.eclipse.org/2010/tmf/xtext/CallHierarchyBuilderTestLanguage\"");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("Model2:");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("elements+=Element*");
        _builder_1.newLine();
        _builder_1.append(";");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("Element:");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("name=ID");
        _builder_1.newLine();
        _builder_1.append(";");
        _builder_1.newLine();
        Pair<String, String> _mappedTo_1 = Pair.<String, String>of("callHierarchyBuilderTestLanguage.xtext", _builder_1.toString());
        _models_1.add(_mappedTo_1);
        Collection<Pair<String, String>> _models_2 = it.getModels();
        Pair<String, String> _last = IterableExtensions.<Pair<String, String>>last(_models_2);
        String _key = _last.getKey();
        it.setResourceURI(_key);
        Collection<Pair<String, String>> _models_3 = it.getModels();
        Pair<String, String> _last_1 = IterableExtensions.<Pair<String, String>>last(_models_3);
        String _value = _last_1.getValue();
        int _indexOf = _value.indexOf("Element");
        it.setIndex(_indexOf);
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("Element {");
        _builder_2.newLine();
        _builder_2.append("\t");
        _builder_2.append("grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage");
        _builder_2.newLine();
        _builder_2.append("\t");
        _builder_2.append("Model {");
        _builder_2.newLine();
        _builder_2.append("\t\t");
        _builder_2.append("grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.BaseCallHierarchyBuilderTestLanguage");
        _builder_2.newLine();
        _builder_2.append("\t\t");
        _builder_2.append("\'elements+=Element*\' [263, 18]");
        _builder_2.newLine();
        _builder_2.append("\t");
        _builder_2.append("}");
        _builder_2.newLine();
        _builder_2.append("\t");
        _builder_2.append("Model2 {");
        _builder_2.newLine();
        _builder_2.append("\t\t");
        _builder_2.append("grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage");
        _builder_2.newLine();
        _builder_2.append("\t\t");
        _builder_2.append("\'elements+=Element*\' [297, 18]");
        _builder_2.newLine();
        _builder_2.append("\t");
        _builder_2.append("}");
        _builder_2.newLine();
        _builder_2.append("}");
        _builder_2.newLine();
        it.setExpectedHierarchy(_builder_2.toString());
      }
    };
    this.testBuildHierarchy(_function);
  }
  
  @Test
  public void testBuildHierarchy_08() {
    final Procedure1<AbstractHierarchyBuilderTest.HierarchyBuilderTestConfiguration> _function = new Procedure1<AbstractHierarchyBuilderTest.HierarchyBuilderTestConfiguration>() {
      @Override
      public void apply(final AbstractHierarchyBuilderTest.HierarchyBuilderTestConfiguration it) {
        Collection<Pair<String, String>> _models = it.getModels();
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("grammar org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage with org.eclipse.xtext.common.Terminals");
        _builder.newLine();
        _builder.newLine();
        _builder.append("generate callHierarchyBuilderTestLanguage \"http://www.eclipse.org/2010/tmf/xtext/CallHierarchyBuilderTestLanguage\"");
        _builder.newLine();
        _builder.newLine();
        _builder.append("Model:");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("elements+=[Element]");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("elements+=[Element|ID]");
        _builder.newLine();
        _builder.append(";");
        _builder.newLine();
        _builder.newLine();
        _builder.append("Element:");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("name=ID");
        _builder.newLine();
        _builder.append(";");
        _builder.newLine();
        Pair<String, String> _mappedTo = Pair.<String, String>of("callHierarchyBuilderTestLanguage.xtext", _builder.toString());
        _models.add(_mappedTo);
        Collection<Pair<String, String>> _models_1 = it.getModels();
        Pair<String, String> _head = IterableExtensions.<Pair<String, String>>head(_models_1);
        String _value = _head.getValue();
        int _lastIndexOf = _value.lastIndexOf("ID");
        it.setIndex(_lastIndexOf);
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("ID {");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("grammar: org.eclipse.xtext.common.Terminals");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("Model {");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("\'elements+=[Element]\' [250, 19]");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("\'elements+=[Element|ID]\' [271, 22]");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("Element {");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("\'name=ID\' [307, 7]");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        it.setExpectedHierarchy(_builder_1.toString());
      }
    };
    this.testBuildHierarchy(_function);
  }
  
  @Override
  protected String internalToExpectation(final IHierarchyNode node, final IHierarchyBuilder builder) {
    final String superExpectation = super.internalToExpectation(node, builder);
    if ((node instanceof XtextCallHierarchyNode)) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("grammar: ");
      IEObjectDescription _grammarDescription = ((XtextCallHierarchyNode)node).getGrammarDescription();
      _builder.append(_grammarDescription, "");
      _builder.newLineIfNotEmpty();
      _builder.append(superExpectation, "");
      _builder.newLineIfNotEmpty();
      return _builder.toString();
    }
    return superExpectation;
  }
}
