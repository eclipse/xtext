/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.parser.indentation;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.parser.indentation.IndentationAwareTestLanguageInjectorProvider;
import org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.Tree;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(IndentationAwareTestLanguageInjectorProvider.class)
@SuppressWarnings("all")
public class IndentationAwarePartialParsingErrorTest {
  @Inject
  @Extension
  private ParseHelper<Tree> parseHelper;
  
  @Test
  public void testResourceUpdate() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("a");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("b // single tab");
      _builder.newLine();
      _builder.append("         ");
      _builder.append("// 8 spaces eq 1 tab");
      _builder.newLine();
      _builder.append("d");
      _builder.newLine();
      final String model = _builder.toString();
      final Tree tree = this.parseHelper.parse(model);
      Resource _eResource = tree.eResource();
      final XtextResource resource = ((XtextResource) _eResource);
      final int idx = model.indexOf(" // 8");
      resource.update(idx, 0, "c");
      EList<EObject> _contents = resource.getContents();
      EObject _head = IterableExtensions.<EObject>head(_contents);
      final Tree reparsed = ((Tree) _head);
      Assert.assertNotSame(tree, reparsed);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testResourceUpdate_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("a");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("x");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("b // two tabs");
      _builder.newLine();
      _builder.append("\t         ");
      _builder.append("// tab and 8 spaces (eq 2 tabs)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("y");
      _builder.newLine();
      final String model = _builder.toString();
      final Tree tree = this.parseHelper.parse(model);
      Resource _eResource = tree.eResource();
      final XtextResource resource = ((XtextResource) _eResource);
      final int idx = model.indexOf(" // tab");
      resource.update(idx, 0, "c");
      EList<EObject> _contents = resource.getContents();
      EObject _head = IterableExtensions.<EObject>head(_contents);
      final Tree reparsed = ((Tree) _head);
      Assert.assertNotSame(tree, reparsed);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
