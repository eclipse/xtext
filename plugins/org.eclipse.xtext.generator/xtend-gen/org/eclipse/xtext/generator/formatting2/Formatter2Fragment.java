/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator.formatting2;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.formatting2.FormatterPreferenceValuesProvider;
import org.eclipse.xtext.formatting2.FormatterPreferences;
import org.eclipse.xtext.formatting2.IFormatter2;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.Generator;
import org.eclipse.xtext.generator.Xtend2ExecutionContext;
import org.eclipse.xtext.generator.Xtend2GeneratorFragment;
import org.eclipse.xtext.generator.formatting2.FormatterStubGenerator;
import org.eclipse.xtext.preferences.IPreferenceValuesProvider;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("all")
public class Formatter2Fragment extends Xtend2GeneratorFragment {
  private FormatterStubGenerator stubGenerator;
  
  @Inject
  public void init(final FormatterStubGenerator.Service stubGeneratorService, final Grammar grammar) {
    FormatterStubGenerator _createGenerator = stubGeneratorService.createGenerator(grammar);
    this.stubGenerator = _createGenerator;
  }
  
  public String cls(final Class<?> clazz) {
    String _name = clazz.getName();
    return (_name + ".class");
  }
  
  @Override
  public Set<Binding> getGuiceBindingsRt(final Grammar grammar) {
    final StringBuilder cfg = new StringBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("binder.bind(");
    String _name = IPreferenceValuesProvider.class.getName();
    _builder.append(_name, "");
    _builder.append(".class)");
    cfg.append(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(".annotatedWith(");
    String _name_1 = FormatterPreferences.class.getName();
    _builder_1.append(_name_1, "");
    _builder_1.append(".class)");
    cfg.append(_builder_1);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append(".to(");
    String _name_2 = FormatterPreferenceValuesProvider.class.getName();
    _builder_2.append(_name_2, "");
    _builder_2.append(".class);");
    cfg.append(_builder_2);
    final BindFactory bf = new BindFactory();
    String _name_3 = IFormatter2.class.getName();
    String _stubQualifiedName = this.stubGenerator.getStubQualifiedName();
    bf.addTypeToType(_name_3, _stubQualifiedName);
    String _name_4 = FormatterPreferences.class.getName();
    String _string = cfg.toString();
    bf.addConfiguredBinding(_name_4, _string);
    return bf.getBindings();
  }
  
  @Override
  public Set<Binding> getGuiceBindingsUi(final Grammar grammar) {
    final BindFactory bf = new BindFactory();
    bf.addTypeToType(
      "org.eclipse.xtext.ui.editor.formatting.IContentFormatterFactory", 
      "org.eclipse.xtext.ui.editor.formatting2.ContentFormatterFactory");
    return bf.getBindings();
  }
  
  @Override
  public void generate(final Xtend2ExecutionContext ctx) {
    String _stubFileName = this.stubGenerator.getStubFileName();
    String _generateStubFileContents = this.stubGenerator.generateStubFileContents();
    ctx.writeFile(Generator.SRC, _stubFileName, _generateStubFileContents);
  }
}
