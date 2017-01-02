/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests.validation;

import com.google.inject.Inject;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Collections;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.util.MergeableManifest;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.validation.IssueCodes;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class AccessRestrictionInWorkspaceTest extends AbstractXtendUITestCase {
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  @Inject
  @Extension
  private IResourceSetProvider _iResourceSetProvider;
  
  @Test
  public void testForbiddenReferenceInOtherProject() {
    try {
      final XtendFile xtendFile = this.parse(IResourcesSetupUtil.createFile("secondProject/src/Dummy.xtend", "class D { restricted.A a }"));
      XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(xtendFile.getXtendTypes());
      final XtendClass c = ((XtendClass) _head);
      this._validationTestHelper.assertError(c, TypesPackage.Literals.JVM_TYPE_REFERENCE, IssueCodes.FORBIDDEN_REFERENCE, "Access restriction: The type A is not accessible", "on required project firstProject");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDiscouragedReferenceInOtherProject() {
    try {
      final XtendFile xtendFile = this.parse(IResourcesSetupUtil.createFile("secondProject/src/Dummy.xtend", "class D { discouraged.B b }"));
      XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(xtendFile.getXtendTypes());
      final XtendClass c = ((XtendClass) _head);
      this._validationTestHelper.assertWarning(c, TypesPackage.Literals.JVM_TYPE_REFERENCE, IssueCodes.DISCOURAGED_REFERENCE, "Discouraged access: The type B is not accessible", "on required project firstProject");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testForbiddenReferenceInSameProject() {
    try {
      final XtendFile xtendFile = this.parse(IResourcesSetupUtil.createFile("firstProject/src/Dummy.xtend", "class D { restricted.A a }"));
      XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(xtendFile.getXtendTypes());
      final XtendClass c = ((XtendClass) _head);
      this._validationTestHelper.assertNoError(c, IssueCodes.DISCOURAGED_REFERENCE);
      this._validationTestHelper.assertNoError(c, IssueCodes.FORBIDDEN_REFERENCE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDiscouragedReferenceInSameProject() {
    try {
      final XtendFile xtendFile = this.parse(IResourcesSetupUtil.createFile("firstProject/src/Dummy.xtend", "class D { discouraged.B b }"));
      XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(xtendFile.getXtendTypes());
      final XtendClass c = ((XtendClass) _head);
      this._validationTestHelper.assertNoError(c, IssueCodes.DISCOURAGED_REFERENCE);
      this._validationTestHelper.assertNoError(c, IssueCodes.FORBIDDEN_REFERENCE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testExportedByOtherProject() {
    try {
      final XtendFile xtendFile = this.parse(IResourcesSetupUtil.createFile("secondProject/src/Dummy.xtend", "class D { allowed.C c }"));
      XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(xtendFile.getXtendTypes());
      final XtendClass c = ((XtendClass) _head);
      this._validationTestHelper.assertNoError(c, IssueCodes.DISCOURAGED_REFERENCE);
      this._validationTestHelper.assertNoError(c, IssueCodes.FORBIDDEN_REFERENCE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testForbiddenReferenceInReexportedProject() {
    try {
      final XtendFile xtendFile = this.parse(IResourcesSetupUtil.createFile("thirdProject/src/Dummy.xtend", "class D { restricted.A a }"));
      XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(xtendFile.getXtendTypes());
      final XtendClass c = ((XtendClass) _head);
      this._validationTestHelper.assertError(c, TypesPackage.Literals.JVM_TYPE_REFERENCE, IssueCodes.FORBIDDEN_REFERENCE, "Access restriction: The type A is not accessible", "on required project firstProject");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDiscouragedReferenceInReexportedProject() {
    try {
      final XtendFile xtendFile = this.parse(IResourcesSetupUtil.createFile("thirdProject/src/Dummy.xtend", "class D { discouraged.B b }"));
      XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(xtendFile.getXtendTypes());
      final XtendClass c = ((XtendClass) _head);
      this._validationTestHelper.assertWarning(c, TypesPackage.Literals.JVM_TYPE_REFERENCE, IssueCodes.DISCOURAGED_REFERENCE, "Discouraged access: The type B is not accessible", "on required project firstProject");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testReexported() {
    try {
      final XtendFile xtendFile = this.parse(IResourcesSetupUtil.createFile("thirdProject/src/Dummy.xtend", "class D { allowed.C c }"));
      XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(xtendFile.getXtendTypes());
      final XtendClass c = ((XtendClass) _head);
      this._validationTestHelper.assertNoError(c, IssueCodes.DISCOURAGED_REFERENCE);
      this._validationTestHelper.assertNoError(c, IssueCodes.FORBIDDEN_REFERENCE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testForbiddenReferenceInImplicitLambdaParameter() {
    try {
      final XtendFile xtendFile = this.parse(IResourcesSetupUtil.createFile("secondProject/src/Dummy.xtend", "class D { new () { new discouraged.B().accept[] } }"));
      XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(xtendFile.getXtendTypes());
      final XtendClass c = ((XtendClass) _head);
      this._validationTestHelper.assertError(c, TypesPackage.Literals.JVM_TYPE_REFERENCE, IssueCodes.FORBIDDEN_REFERENCE, "Access restriction: The type A is not accessible", "on required project firstProject");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public XtendFile parse(final IFile file) {
    final ResourceSet resourceSet = this._iResourceSetProvider.get(file.getProject());
    final URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
    final Resource resource = resourceSet.getResource(uri, true);
    EObject _head = IterableExtensions.<EObject>head(resource.getContents());
    return ((XtendFile) _head);
  }
  
  @Before
  @Override
  public void setUp() throws Exception {
    super.setUp();
    this.configureExportedPackages(JavaCore.create(WorkbenchTestHelper.createPluginProject("firstProject")));
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package restricted; public class A {}");
    IResourcesSetupUtil.createFile("firstProject/src/restricted/A.java", _builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package discouraged;");
    _builder_1.newLine();
    _builder_1.append("public class B {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("public interface I {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("void accept(Iterable<restricted.A> a);");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("public void accept(I i) {}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    IResourcesSetupUtil.createFile("firstProject/src/discouraged/B.java", _builder_1.toString());
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("package allowed; public class C {}");
    IResourcesSetupUtil.createFile("firstProject/src/allowed/C.java", _builder_2.toString());
    JavaCore.create(WorkbenchTestHelper.createPluginProject("secondProject", "firstProject;visibility:=reexport"));
    JavaCore.create(WorkbenchTestHelper.createPluginProject("thirdProject", "secondProject"));
    IResourcesSetupUtil.waitForBuild();
  }
  
  @After
  @Override
  public void tearDown() throws Exception {
    IResourcesSetupUtil.cleanWorkspace();
  }
  
  private IJavaProject configureExportedPackages(final IJavaProject pluginProject) {
    try {
      final IFile manifestFile = pluginProject.getProject().getFile("META-INF/MANIFEST.MF");
      final InputStream contents = manifestFile.getContents();
      MergeableManifest _xtrycatchfinallyexpression = null;
      try {
        _xtrycatchfinallyexpression = new MergeableManifest(contents);
      } finally {
        contents.close();
      }
      final MergeableManifest manifest = _xtrycatchfinallyexpression;
      manifest.addExportedPackages(Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet("allowed", "discouraged;x-internal:=true")));
      final ByteArrayOutputStream out = new ByteArrayOutputStream();
      manifest.write(out);
      byte[] _byteArray = out.toByteArray();
      final ByteArrayInputStream in = new ByteArrayInputStream(_byteArray);
      manifestFile.setContents(in, true, true, null);
      return pluginProject;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
