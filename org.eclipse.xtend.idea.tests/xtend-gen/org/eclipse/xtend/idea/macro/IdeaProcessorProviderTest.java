/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.macro;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import junit.framework.TestCase;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.idea.macro.IdeaProcessorProvider;
import org.eclipse.xtend.core.macro.XAnnotationExtensions;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.idea.LightXtendTest;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures;
import org.junit.Test;

@SuppressWarnings("all")
public class IdeaProcessorProviderTest extends LightXtendTest {
  @Inject
  @Extension
  private XAnnotationExtensions _xAnnotationExtensions;
  
  @Inject
  private IdeaProcessorProvider provider;
  
  public void testData() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.eclipse.xtend.lib.annotations.Data");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Data class Foo {}");
    _builder.newLine();
    this.configureByText(_builder.toString());
    BaseXtextFile _xtextFile = this.getXtextFile();
    XtextResource _resource = _xtextFile.getResource();
    EList<EObject> _contents = _resource.getContents();
    EObject _head = IterableExtensions.<EObject>head(_contents);
    final XtendFile file = ((XtendFile) _head);
    EList<XtendTypeDeclaration> _xtendTypes = file.getXtendTypes();
    XtendTypeDeclaration _head_1 = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
    EList<XAnnotation> _annotations = _head_1.getAnnotations();
    XAnnotation _head_2 = IterableExtensions.<XAnnotation>head(_annotations);
    final JvmType processorType = this._xAnnotationExtensions.getProcessorType(_head_2);
    final Object processor = this.provider.getProcessorInstance(processorType);
    Class<?> _class = processor.getClass();
    String _simpleName = _class.getSimpleName();
    TestCase.assertEquals("DataProcessor", _simpleName);
  }
  
  @Test
  public void testLoadClass() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.Data");
      _builder.newLine();
      _builder.newLine();
      _builder.append("@Data class Foo {}");
      _builder.newLine();
      this.configureByText(_builder.toString());
      BaseXtextFile _xtextFile = this.getXtextFile();
      XtextResource _resource = _xtextFile.getResource();
      EList<EObject> _contents = _resource.getContents();
      EObject _head = IterableExtensions.<EObject>head(_contents);
      final XtendFile file = ((XtendFile) _head);
      EList<XtendTypeDeclaration> _xtendTypes = file.getXtendTypes();
      XtendTypeDeclaration _head_1 = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
      EList<XAnnotation> _annotations = _head_1.getAnnotations();
      XAnnotation _head_2 = IterableExtensions.<XAnnotation>head(_annotations);
      final JvmType processorType = this._xAnnotationExtensions.getProcessorType(_head_2);
      final ClassLoader classLoader = this.provider.getClassLoader(file);
      String _name = String.class.getName();
      Class<?> _loadClass = classLoader.loadClass(_name);
      ClassLoader _classLoader = _loadClass.getClassLoader();
      TestCase.assertNull(_classLoader);
      ClassLoader _classLoader_1 = TransformationContext.class.getClassLoader();
      String _name_1 = TransformationContext.class.getName();
      Class<?> _loadClass_1 = classLoader.loadClass(_name_1);
      ClassLoader _classLoader_2 = _loadClass_1.getClassLoader();
      TestCase.assertEquals(_classLoader_1, _classLoader_2);
      ClassLoader _classLoader_3 = TransformationContext.class.getClassLoader();
      String _name_2 = Procedures.class.getName();
      Class<?> _loadClass_2 = classLoader.loadClass(_name_2);
      ClassLoader _classLoader_4 = _loadClass_2.getClassLoader();
      TestCase.assertEquals(_classLoader_3, _classLoader_4);
      ClassLoader _classLoader_5 = TransformationContext.class.getClassLoader();
      String _name_3 = Iterables.class.getName();
      Class<?> _loadClass_3 = classLoader.loadClass(_name_3);
      ClassLoader _classLoader_6 = _loadClass_3.getClassLoader();
      TestCase.assertEquals(_classLoader_5, _classLoader_6);
      String _identifier = processorType.getIdentifier();
      Class<?> _loadClass_4 = classLoader.loadClass(_identifier);
      ClassLoader _classLoader_7 = _loadClass_4.getClassLoader();
      TestCase.assertEquals(classLoader, _classLoader_7);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
