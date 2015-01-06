/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.macro;

import com.google.inject.Inject;
import junit.framework.TestCase;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.macro.ProcessorInstanceForJvmTypeProvider;
import org.eclipse.xtend.core.macro.XAnnotationExtensions;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.idea.completion.LightXtendTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class IdeaProcessorProviderTest extends LightXtendTest {
  @Inject
  private ProcessorInstanceForJvmTypeProvider provider;
  
  @Inject
  @Extension
  private XAnnotationExtensions _xAnnotationExtensions;
  
  public void testData() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.eclipse.xtend.lib.annotations.Data");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Data class Foo {}");
    _builder.newLine();
    this.configureByText(_builder.toString());
    BaseXtextFile _xtextFile = this.getXtextFile();
    Resource _resource = _xtextFile.getResource();
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
}
