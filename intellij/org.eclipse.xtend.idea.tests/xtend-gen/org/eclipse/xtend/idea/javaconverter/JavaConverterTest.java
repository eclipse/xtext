/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.javaconverter;

import com.google.inject.Inject;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import junit.framework.TestCase;
import org.eclipse.xtend.core.javaconverter.JavaConverter;
import org.eclipse.xtend.idea.LightXtendTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Test;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class JavaConverterTest extends LightXtendTest {
  @Inject
  private JavaConverter converter;
  
  @Test
  public void testSimpleCase() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package javaconverter;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class JavaConverterTest {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void doStuff() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final PsiFile javaCalzz = this.myFixture.addFileToProject("javaconverter/JavaConverterTest.java", _builder.toString());
    VirtualFile _virtualFile = javaCalzz.getVirtualFile();
    String _nameWithoutExtension = _virtualFile.getNameWithoutExtension();
    String _text = javaCalzz.getText();
    final JavaConverter.ConversionResult result = this.converter.toXtend(_nameWithoutExtension, _text, this.myModule);
    TestCase.assertNotNull(result);
    Iterable<String> _problems = result.getProblems();
    boolean _isEmpty = IterableExtensions.isEmpty(_problems);
    TestCase.assertTrue(_isEmpty);
  }
}
