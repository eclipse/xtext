/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.typesystem;

import com.google.inject.Inject;
import org.apache.log4j.Level;
import org.eclipse.emf.common.util.EList;
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
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.logging.LoggingTester;
import org.eclipse.xtext.junit4.util.ResourceHelper;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
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
      IParseResult _parseResult = resource.getParseResult();
      EObject _rootASTElement = _parseResult.getRootASTElement();
      final XtendFile xtendFile = ((XtendFile) _rootASTElement);
      EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
      XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
      EList<XtendMember> _members = _head.getMembers();
      XtendMember _get = _members.get(1);
      EList<XtendParameter> _parameters = ((XtendFunction) _get).getParameters();
      XtendParameter _head_1 = IterableExtensions.<XtendParameter>head(_parameters);
      _head_1.setParameterType(null);
      final Runnable _function = new Runnable() {
        @Override
        public void run() {
          EcoreUtil.resolveAll(resource);
        }
      };
      final LoggingTester.LogCapture loggings = LoggingTester.captureLogging(Level.ERROR, BatchLinkableResource.class, _function);
      loggings.assertNoLogEntries();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
