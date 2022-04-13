/**
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.typesystem;

import com.google.inject.Inject;
import org.apache.log4j.Level;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.core.tests.RuntimeInjectorProvider;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.logging.LoggingTester;
import org.eclipse.xtext.testing.util.ResourceHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.resource.BatchLinkableResource;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(RuntimeInjectorProvider.class)
@SuppressWarnings("all")
public class Bug464760Test {
  @Inject
  private ResourceHelper resourceHelper;

  @Test
  public void testBug464760() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void myMethod() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("\"foo\".myExtension");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void myExtension(/*will be deleted programmatically*/Object notype) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      Resource _resource = this.resourceHelper.resource(_builder);
      final XtextResource resource = ((XtextResource) _resource);
      EObject _rootASTElement = resource.getParseResult().getRootASTElement();
      final XtendFile xtendFile = ((XtendFile) _rootASTElement);
      XtendMember _get = IterableExtensions.<XtendTypeDeclaration>head(xtendFile.getXtendTypes()).getMembers().get(1);
      XtendParameter _head = IterableExtensions.<XtendParameter>head(((XtendFunction) _get).getParameters());
      _head.setParameterType(null);
      final Runnable _function = () -> {
        EcoreUtil.resolveAll(resource);
      };
      final LoggingTester.LogCapture loggings = LoggingTester.captureLogging(Level.ERROR, BatchLinkableResource.class, _function);
      loggings.assertNoLogEntries();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
