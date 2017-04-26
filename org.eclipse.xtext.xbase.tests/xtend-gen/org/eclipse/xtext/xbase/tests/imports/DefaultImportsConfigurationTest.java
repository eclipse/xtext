/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.imports;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.imports.DefaultImportsConfiguration;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.testlanguages.tests.XImportSectionTestLangInjectorProvider;
import org.eclipse.xtext.xbase.testlanguages.xImportSectionTestLang.ImportSectionTestLanguageRoot;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(XImportSectionTestLangInjectorProvider.class)
@SuppressWarnings("all")
public class DefaultImportsConfigurationTest {
  @Inject
  @Extension
  private ParseHelper<ImportSectionTestLanguageRoot> _parseHelper;
  
  @Inject
  private DefaultImportsConfiguration importsConfiguration;
  
  @Test
  public void testParseWithComments() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("// hello");
      _builder.newLine();
      _builder.append("some token");
      _builder.newLine();
      _builder.append("import java.util.Set");
      _builder.newLine();
      final ImportSectionTestLanguageRoot root = this._parseHelper.parse(_builder);
      Resource _eResource = root.eResource();
      Assert.assertEquals(19, this.importsConfiguration.getImportSectionOffset(((XtextResource) _eResource)));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
