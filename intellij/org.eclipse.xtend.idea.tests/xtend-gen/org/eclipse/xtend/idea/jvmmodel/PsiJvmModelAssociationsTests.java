/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.jvmmodel;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.intellij.psi.PsiElement;
import junit.framework.TestCase;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.idea.LightXtendTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.idea.jvmmodel.IPsiJvmModelAssociations;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class PsiJvmModelAssociationsTests extends LightXtendTest {
  @Inject
  @Extension
  private IPsiJvmModelAssociations _iPsiJvmModelAssociations;
  
  public void testAssociations() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String name");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def getName() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("name");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void setName(String name) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.name = name");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("class Bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.configureByText(_builder.toString());
    BaseXtextFile _xtextFile = this.getXtextFile();
    XtextResource _resource = _xtextFile.getResource();
    EList<EObject> _contents = _resource.getContents();
    Iterable<JvmDeclaredType> _filter = Iterables.<JvmDeclaredType>filter(_contents, JvmDeclaredType.class);
    final JvmDeclaredType jvmClass = IterableExtensions.<JvmDeclaredType>head(_filter);
    final PsiElement sourceElement = this._iPsiJvmModelAssociations.getPrimarySourceElement(jvmClass);
    String _string = sourceElement.toString();
    TestCase.assertNotNull(_string, sourceElement);
  }
}
