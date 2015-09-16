/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.autobuild;

import com.google.common.base.Objects;
import com.google.common.io.CharStreams;
import com.google.common.io.Files;
import com.intellij.facet.Facet;
import com.intellij.facet.FacetManager;
import com.intellij.facet.FacetTypeId;
import com.intellij.facet.ModifiableFacetModel;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ContentEntry;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.roots.SourceFolder;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.newvfs.events.VFileDeleteEvent;
import com.intellij.openapi.vfs.newvfs.events.VFileEvent;
import com.intellij.openapi.vfs.newvfs.persistent.PersistentFS;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiFile;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Collections;
import junit.framework.TestCase;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.core.idea.facet.XtendFacetType;
import org.eclipse.xtend.core.idea.lang.XtendLanguage;
import org.eclipse.xtend.idea.LightXtendTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.idea.build.XtextAutoBuilderComponent;
import org.eclipse.xtext.idea.resource.VirtualFileURIUtil;
import org.eclipse.xtext.idea.tests.LightToolingTest;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.junit.ComparisonFailure;

@SuppressWarnings("all")
public class IdeaIntegrationTest extends LightXtendTest {
  public void testManualDeletionOfGeneratedSourcesTriggersRebuild() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package otherPackage");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.myFixture.addFileToProject("otherPackage/Foo.xtend", _builder.toString());
    final VirtualFile file = this.myFixture.findFileInTempDir("xtend-gen/otherPackage/Foo.java");
    boolean _exists = file.exists();
    TestCase.assertTrue(_exists);
    Application _application = ApplicationManager.getApplication();
    final Runnable _function = new Runnable() {
      @Override
      public void run() {
        try {
          file.delete(null);
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    _application.runWriteAction(_function);
    final VirtualFile regenerated = this.myFixture.findFileInTempDir("xtend-gen/otherPackage/Foo.java");
    boolean _exists_1 = regenerated.exists();
    TestCase.assertTrue(_exists_1);
  }
  
  public void testNoChangeDoesntTouch() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package otherPackage");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final PsiFile xtendFile = this.myFixture.addFileToProject("otherPackage/Foo.xtend", _builder.toString());
    final VirtualFile file = this.myFixture.findFileInTempDir("xtend-gen/otherPackage/Foo.java");
    boolean _exists = file.exists();
    TestCase.assertTrue(_exists);
    final long stamp = file.getModificationStamp();
    Project _project = this.getProject();
    PsiDocumentManager _instance = PsiDocumentManager.getInstance(_project);
    final Document document = _instance.getDocument(xtendFile);
    Application _application = ApplicationManager.getApplication();
    final Runnable _function = new Runnable() {
      @Override
      public void run() {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("package otherPackage");
        _builder.newLine();
        _builder.append("class Foo {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("// doesn\'t go into target");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        document.setText(_builder);
      }
    };
    _application.runWriteAction(_function);
    final VirtualFile regenerated = this.myFixture.findFileInTempDir("xtend-gen/otherPackage/Foo.java");
    long _modificationStamp = regenerated.getModificationStamp();
    TestCase.assertEquals(stamp, _modificationStamp);
  }
  
  public void testRemoveAndAddFacet() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package otherPackage");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final PsiFile source = this.myFixture.addFileToProject("otherPackage/Foo.xtend", _builder.toString());
    VirtualFile file = this.myFixture.findFileInTempDir("xtend-gen/otherPackage/Foo.java");
    boolean _exists = file.exists();
    TestCase.assertTrue(_exists);
    Application _application = ApplicationManager.getApplication();
    final Runnable _function = new Runnable() {
      @Override
      public void run() {
        final FacetManager mnr = FacetManager.getInstance(IdeaIntegrationTest.this.myModule);
        final ModifiableFacetModel model = mnr.createModifiableModel();
        Facet[] _allFacets = mnr.getAllFacets();
        final Function1<Facet<?>, Boolean> _function = new Function1<Facet<?>, Boolean>() {
          @Override
          public Boolean apply(final Facet<?> it) {
            FacetTypeId _typeId = it.getTypeId();
            return Boolean.valueOf(Objects.equal(_typeId, XtendFacetType.TYPEID));
          }
        };
        final Facet<?> facet = IterableExtensions.<Facet<?>>findFirst(((Iterable<Facet<?>>)Conversions.doWrapArray(_allFacets)), _function);
        model.removeFacet(facet);
        model.commit();
        return;
      }
    };
    _application.runWriteAction(_function);
    Project _project = this.getProject();
    final XtextAutoBuilderComponent autoBuilder = _project.<XtextAutoBuilderComponent>getComponent(XtextAutoBuilderComponent.class);
    VirtualFile _virtualFile = source.getVirtualFile();
    URI _uRI = VirtualFileURIUtil.getURI(_virtualFile);
    Iterable<URI> _generatedSources = autoBuilder.getGeneratedSources(_uRI);
    boolean _isEmpty = IterableExtensions.isEmpty(_generatedSources);
    TestCase.assertTrue(_isEmpty);
    ChunkedResourceDescriptions _indexState = autoBuilder.getIndexState();
    Iterable<IResourceDescription> _allResourceDescriptions = _indexState.getAllResourceDescriptions();
    boolean _isEmpty_1 = IterableExtensions.isEmpty(_allResourceDescriptions);
    TestCase.assertTrue(_isEmpty_1);
    VirtualFile _findFileInTempDir = this.myFixture.findFileInTempDir("xtend-gen/otherPackage/Foo.java");
    file = _findFileInTempDir;
    TestCase.assertNull(file);
    String _iD = XtendLanguage.INSTANCE.getID();
    LightToolingTest.addFacetToModule(this.myModule, _iD);
    VirtualFile _virtualFile_1 = source.getVirtualFile();
    URI _uRI_1 = VirtualFileURIUtil.getURI(_virtualFile_1);
    ChunkedResourceDescriptions _indexState_1 = autoBuilder.getIndexState();
    Iterable<IResourceDescription> _allResourceDescriptions_1 = _indexState_1.getAllResourceDescriptions();
    IResourceDescription _head = IterableExtensions.<IResourceDescription>head(_allResourceDescriptions_1);
    URI _uRI_2 = _head.getURI();
    TestCase.assertEquals(_uRI_1, _uRI_2);
    VirtualFile _virtualFile_2 = source.getVirtualFile();
    URI _uRI_3 = VirtualFileURIUtil.getURI(_virtualFile_2);
    Iterable<URI> _generatedSources_1 = autoBuilder.getGeneratedSources(_uRI_3);
    final Function1<URI, Boolean> _function_1 = new Function1<URI, Boolean>() {
      @Override
      public Boolean apply(final URI it) {
        String _string = it.toString();
        return Boolean.valueOf(_string.endsWith("xtend-gen/otherPackage/Foo.java"));
      }
    };
    boolean _exists_1 = IterableExtensions.<URI>exists(_generatedSources_1, _function_1);
    TestCase.assertTrue(_exists_1);
    VirtualFile _findFileInTempDir_1 = this.myFixture.findFileInTempDir("xtend-gen/otherPackage/Foo.java");
    file = _findFileInTempDir_1;
    boolean _exists_2 = file.exists();
    TestCase.assertTrue(_exists_2);
  }
  
  public void testJavaDeletionTriggersError() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package otherPackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import mypackage.Bar");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void callToBar(Bar bar) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("bar.doStuff()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final PsiFile xtendFile = this.myFixture.addFileToProject("otherPackage/Foo.xtend", _builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package mypackage;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("public class Bar {");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("public void doStuff() {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.myFixture.addFileToProject("myPackage/Bar.java", _builder_1.toString());
    VirtualFile _virtualFile = xtendFile.getVirtualFile();
    this.myFixture.testHighlighting(true, true, true, _virtualFile);
    Application _application = ApplicationManager.getApplication();
    final Runnable _function = new Runnable() {
      @Override
      public void run() {
        try {
          final VirtualFile javaFile = IdeaIntegrationTest.this.myFixture.findFileInTempDir("myPackage/Bar.java");
          javaFile.delete(null);
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    _application.runWriteAction(_function);
    try {
      VirtualFile _virtualFile_1 = xtendFile.getVirtualFile();
      this.myFixture.testHighlighting(true, true, true, _virtualFile_1);
      TestCase.fail("expecting errors");
    } catch (final Throwable _t) {
      if (_t instanceof ComparisonFailure) {
        final ComparisonFailure e = (ComparisonFailure)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public void testJavaChangeTriggersError() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package otherPackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import mypackage.Bar");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void callToBar(Bar bar) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("bar.doStuff()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final PsiFile xtendFile = this.myFixture.addFileToProject("otherPackage/Foo.xtend", _builder.toString());
    try {
      VirtualFile _virtualFile = xtendFile.getVirtualFile();
      this.myFixture.testHighlighting(true, true, true, _virtualFile);
      TestCase.fail("expecting errors");
    } catch (final Throwable _t) {
      if (_t instanceof ComparisonFailure) {
        final ComparisonFailure e = (ComparisonFailure)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package mypackage;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("public class Bar {");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("public void doStuff() {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.myFixture.addFileToProject("myPackage/Bar.java", _builder_1.toString());
    VirtualFile _virtualFile_1 = xtendFile.getVirtualFile();
    this.myFixture.testHighlighting(true, true, true, _virtualFile_1);
  }
  
  public void testCyclicResolution() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class Bar {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void callToFoo(Foo foo) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("foo.callToBar(this);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.myFixture.addClass(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package mypackage");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def void callToBar(Bar bar) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("bar.callToFoo(this)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final PsiFile xtendFile = this.myFixture.addFileToProject("mypackage/Foo.xtend", _builder_1.toString());
    VirtualFile _virtualFile = xtendFile.getVirtualFile();
    this.myFixture.testHighlighting(true, true, true, _virtualFile);
  }
  
  public void testCyclicResolution2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class Bar extends Foo {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void someMethod() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.myFixture.addClass(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package mypackage");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def void callToBar(Bar bar) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("bar.someMethod");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final PsiFile xtendFile = this.myFixture.addFileToProject("mypackage/Foo.xtend", _builder_1.toString());
    VirtualFile _virtualFile = xtendFile.getVirtualFile();
    this.myFixture.testHighlighting(true, true, true, _virtualFile);
  }
  
  public void testCyclicResolution3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class Bar extends Foo<? extends Bar> {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void someMethod() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.myFixture.addClass(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package mypackage");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class Foo<T extends Bar> {");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def void callToBar(T bar) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("bar.someMethod");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final PsiFile xtendFile = this.myFixture.addFileToProject("mypackage/Foo.xtend", _builder_1.toString());
    VirtualFile _virtualFile = xtendFile.getVirtualFile();
    this.myFixture.testHighlighting(true, true, true, _virtualFile);
  }
  
  public void testCyclicResolution4() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class Bar extends Foo<Bar> {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void someMethod(Bar b) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.myFixture.addClass(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package mypackage");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class Foo<T extends Bar> {");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def void callToBar(T bar) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("bar.someMethod(bar)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final PsiFile xtendFile = this.myFixture.addFileToProject("mypackage/Foo.xtend", _builder_1.toString());
    VirtualFile _virtualFile = xtendFile.getVirtualFile();
    this.myFixture.testHighlighting(true, true, true, _virtualFile);
  }
  
  public void testDeleteGeneratedFolder() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package otherPackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val list = OtherClass.getIt(\"foo\")");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.myFixture.addFileToProject("otherPackage/Foo.xtend", _builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package otherPackage");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import java.util.List");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class OtherClass {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def static List<String> getIt(String x) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("return #[x]");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.myFixture.addFileToProject("otherPackage/Bar.xtend", _builder_1.toString());
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("package otherPackage;");
    _builder_2.newLine();
    _builder_2.newLine();
    _builder_2.append("import java.util.List;");
    _builder_2.newLine();
    _builder_2.append("import otherPackage.OtherClass;");
    _builder_2.newLine();
    _builder_2.newLine();
    _builder_2.append("@SuppressWarnings(\"all\")");
    _builder_2.newLine();
    _builder_2.append("public class Foo {");
    _builder_2.newLine();
    _builder_2.append("  ");
    _builder_2.append("private final List<String> list = OtherClass.getIt(\"foo\");");
    _builder_2.newLine();
    _builder_2.append("}");
    _builder_2.newLine();
    this.assertFileContents("xtend-gen/otherPackage/Foo.java", _builder_2);
    final VirtualFile dir = this.myFixture.findFileInTempDir("xtend-gen");
    Application _application = ApplicationManager.getApplication();
    final Runnable _function = new Runnable() {
      @Override
      public void run() {
        try {
          dir.delete(null);
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    _application.runWriteAction(_function);
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append("package otherPackage;");
    _builder_3.newLine();
    _builder_3.newLine();
    _builder_3.append("import java.util.List;");
    _builder_3.newLine();
    _builder_3.append("import otherPackage.OtherClass;");
    _builder_3.newLine();
    _builder_3.newLine();
    _builder_3.append("@SuppressWarnings(\"all\")");
    _builder_3.newLine();
    _builder_3.append("public class Foo {");
    _builder_3.newLine();
    _builder_3.append("  ");
    _builder_3.append("private final List<String> list = OtherClass.getIt(\"foo\");");
    _builder_3.newLine();
    _builder_3.append("}");
    _builder_3.newLine();
    this.assertFileContents("xtend-gen/otherPackage/Foo.java", _builder_3);
  }
  
  /**
   * https://bugs.eclipse.org/bugs/show_bug.cgi?id=476412
   */
  public void testDeleteNonProjectFolderFromDisk() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package otherPackage");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.myFixture.addFileToProject("otherPackage/Foo.xtend", _builder.toString());
    final File tmpDir = Files.createTempDir();
    final File f = new File(tmpDir, "dirToDelete");
    f.mkdirs();
    final VirtualFile vFile = VfsUtil.findFileByIoFile(f, false);
    Application _application = ApplicationManager.getApplication();
    final Runnable _function = new Runnable() {
      @Override
      public void run() {
        try {
          PersistentFS _instance = PersistentFS.getInstance();
          VirtualFile _parent = vFile.getParent();
          VFileDeleteEvent _vFileDeleteEvent = new VFileDeleteEvent(IdeaIntegrationTest.this, _parent, true);
          _instance.processEvents(Collections.<VFileEvent>unmodifiableList(CollectionLiterals.<VFileEvent>newArrayList(_vFileDeleteEvent)));
          File _parentFile = f.getParentFile();
          boolean _sweepFolder = org.eclipse.xtext.util.Files.sweepFolder(_parentFile);
          TestCase.assertTrue(_sweepFolder);
          File _parentFile_1 = f.getParentFile();
          boolean _delete = _parentFile_1.delete();
          TestCase.assertTrue(_delete);
          return;
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    _application.runWriteAction(_function);
    boolean _exists = vFile.exists();
    TestCase.assertFalse(_exists);
  }
  
  public void testAffectedUpdated() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package otherPackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val list = OtherClass.getIt(\"foo\")");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.myFixture.addFileToProject("otherPackage/Foo.xtend", _builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package otherPackage;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Foo {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private final Object list /* Skipped initializer because of errors */;");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertFileContents("xtend-gen/otherPackage/Foo.java", _builder_1);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("package otherPackage;");
    _builder_2.newLine();
    _builder_2.newLine();
    _builder_2.append("class OtherClass {");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("public static java.util.List<String> getIt(CharSequence value) {");
    _builder_2.newLine();
    _builder_2.append("\t\t");
    _builder_2.append("return null");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("}");
    _builder_2.newLine();
    _builder_2.append("}");
    _builder_2.newLine();
    this.myFixture.addFileToProject("otherPackage/OtherClass.java", _builder_2.toString());
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append("package otherPackage;");
    _builder_3.newLine();
    _builder_3.newLine();
    _builder_3.append("import java.util.List;");
    _builder_3.newLine();
    _builder_3.append("import otherPackage.OtherClass;");
    _builder_3.newLine();
    _builder_3.newLine();
    _builder_3.append("@SuppressWarnings(\"all\")");
    _builder_3.newLine();
    _builder_3.append("public class Foo {");
    _builder_3.newLine();
    _builder_3.append("  ");
    _builder_3.append("private final List<String> list = OtherClass.getIt(\"foo\");");
    _builder_3.newLine();
    _builder_3.append("}");
    _builder_3.newLine();
    this.assertFileContents("xtend-gen/otherPackage/Foo.java", _builder_3);
    VirtualFile _findFileInTempDir = this.myFixture.findFileInTempDir("otherPackage/OtherClass.java");
    StringConcatenation _builder_4 = new StringConcatenation();
    _builder_4.append("package otherPackage;");
    _builder_4.newLine();
    _builder_4.newLine();
    _builder_4.append("class OtherClass {");
    _builder_4.newLine();
    _builder_4.append("\t");
    _builder_4.append("public static java.util.List<String> getIt(CharSequence value) {");
    _builder_4.newLine();
    _builder_4.append("\t\t");
    _builder_4.append("return null");
    _builder_4.newLine();
    _builder_4.append("\t");
    _builder_4.append("}");
    _builder_4.newLine();
    _builder_4.append("\t");
    _builder_4.append("public static String[] getIt(String value) {");
    _builder_4.newLine();
    _builder_4.append("\t\t");
    _builder_4.append("return null");
    _builder_4.newLine();
    _builder_4.append("\t");
    _builder_4.append("}");
    _builder_4.newLine();
    _builder_4.append("}");
    _builder_4.newLine();
    this.myFixture.saveText(_findFileInTempDir, _builder_4.toString());
    StringConcatenation _builder_5 = new StringConcatenation();
    _builder_5.append("package otherPackage;");
    _builder_5.newLine();
    _builder_5.newLine();
    _builder_5.append("import otherPackage.OtherClass;");
    _builder_5.newLine();
    _builder_5.newLine();
    _builder_5.append("@SuppressWarnings(\"all\")");
    _builder_5.newLine();
    _builder_5.append("public class Foo {");
    _builder_5.newLine();
    _builder_5.append("  ");
    _builder_5.append("private final String[] list = OtherClass.getIt(\"foo\");");
    _builder_5.newLine();
    _builder_5.append("}");
    _builder_5.newLine();
    this.assertFileContents("xtend-gen/otherPackage/Foo.java", _builder_5);
  }
  
  public void testTraceFilesGeneratedAndDeleted() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package otherPackage");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.myFixture.addFileToProject("otherPackage/Foo.xtend", _builder.toString());
    VirtualFile _findFileInTempDir = this.myFixture.findFileInTempDir("xtend-gen/otherPackage/Foo.java");
    boolean _exists = _findFileInTempDir.exists();
    TestCase.assertTrue(_exists);
    VirtualFile _findFileInTempDir_1 = this.myFixture.findFileInTempDir("xtend-gen/otherPackage/.Foo.java._trace");
    boolean _exists_1 = _findFileInTempDir_1.exists();
    TestCase.assertTrue(_exists_1);
    VirtualFile _findFileInTempDir_2 = this.myFixture.findFileInTempDir("otherPackage/Foo.xtend");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package otherPackage;");
    _builder_1.newLine();
    _builder_1.append("class OtherClass {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.myFixture.saveText(_findFileInTempDir_2, _builder_1.toString());
    VirtualFile _findFileInTempDir_3 = this.myFixture.findFileInTempDir("xtend-gen/otherPackage/Foo.java");
    TestCase.assertNull(_findFileInTempDir_3);
    VirtualFile _findFileInTempDir_4 = this.myFixture.findFileInTempDir("xtend-gen/otherPackage/.Foo.java._trace");
    TestCase.assertNull(_findFileInTempDir_4);
    VirtualFile _findFileInTempDir_5 = this.myFixture.findFileInTempDir("xtend-gen/otherPackage/OtherClass.java");
    boolean _exists_2 = _findFileInTempDir_5.exists();
    TestCase.assertTrue(_exists_2);
    VirtualFile _findFileInTempDir_6 = this.myFixture.findFileInTempDir("xtend-gen/otherPackage/.OtherClass.java._trace");
    boolean _exists_3 = _findFileInTempDir_6.exists();
    TestCase.assertTrue(_exists_3);
  }
  
  public void testActiveAnnotation() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package otherPackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import mypackage.Bar");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.macro.Data");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Data class Foo {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String myField");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.myFixture.addFileToProject("otherPackage/Foo.xtend", _builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package otherPackage;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtend.lib.Data;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.Pure;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.util.ToStringHelper;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@Data");
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Foo {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private final String _myField;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Foo(final String myField) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("super();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("this._myField = myField;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Override");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Pure");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public int hashCode() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final int prime = 31;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("int result = 1;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("result = prime * result + ((this._myField== null) ? 0 : this._myField.hashCode());");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return result;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Override");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Pure");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public boolean equals(final Object obj) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("if (this == obj)");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return true;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("if (obj == null)");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return false;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("if (getClass() != obj.getClass())");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return false;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Foo other = (Foo) obj;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("if (this._myField == null) {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("if (other._myField != null)");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("return false;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("} else if (!this._myField.equals(other._myField))");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return false;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return true;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Override");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Pure");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public String toString() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("String result = new ToStringHelper().toString(this);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return result;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Pure");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public String getMyField() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return this._myField;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertFileContents("xtend-gen/otherPackage/Foo.java", _builder_1);
  }
  
  public void testMoveFile() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package otherPackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import mypackage.Bar");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void callToBar(Bar bar) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("bar.doStuff()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final PsiFile xtendFile = this.myFixture.addFileToProject("otherPackage/Foo.xtend", _builder.toString());
    final VirtualFile vf = xtendFile.getVirtualFile();
    final URI before = URI.createURI("temp:///src/otherPackage/Foo.xtend");
    final URI after = URI.createURI("temp:///src/Foo.xtend");
    ChunkedResourceDescriptions _index = this.getIndex();
    IResourceDescription _resourceDescription = _index.getResourceDescription(after);
    TestCase.assertNull(_resourceDescription);
    ChunkedResourceDescriptions _index_1 = this.getIndex();
    IResourceDescription _resourceDescription_1 = _index_1.getResourceDescription(before);
    TestCase.assertNotNull(_resourceDescription_1);
    XtextAutoBuilderComponent _builder_1 = this.getBuilder();
    final Procedure0 _function = new Procedure0() {
      @Override
      public void apply() {
        Application _application = ApplicationManager.getApplication();
        final Runnable _function = new Runnable() {
          @Override
          public void run() {
            try {
              VirtualFile _parent = vf.getParent();
              VirtualFile _parent_1 = _parent.getParent();
              vf.move(null, _parent_1);
            } catch (Throwable _e) {
              throw Exceptions.sneakyThrow(_e);
            }
          }
        };
        _application.runWriteAction(_function);
      }
    };
    _builder_1.runOperation(_function);
    ChunkedResourceDescriptions _index_2 = this.getIndex();
    IResourceDescription _resourceDescription_2 = _index_2.getResourceDescription(after);
    TestCase.assertNotNull(_resourceDescription_2);
    ChunkedResourceDescriptions _index_3 = this.getIndex();
    IResourceDescription _resourceDescription_3 = _index_3.getResourceDescription(before);
    TestCase.assertNull(_resourceDescription_3);
  }
  
  public void testRenameFile() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final PsiFile xtendFile = this.myFixture.addFileToProject("mypackage/Foo.xtend", _builder.toString());
    final URI before = URI.createURI("temp:///src/mypackage/Foo.xtend");
    final URI after = URI.createURI("temp:///src/mypackage/Bar.xtend");
    ChunkedResourceDescriptions _index = this.getIndex();
    IResourceDescription _resourceDescription = _index.getResourceDescription(after);
    TestCase.assertNull(_resourceDescription);
    ChunkedResourceDescriptions _index_1 = this.getIndex();
    IResourceDescription _resourceDescription_1 = _index_1.getResourceDescription(before);
    TestCase.assertNotNull(_resourceDescription_1);
    XtextAutoBuilderComponent _builder_1 = this.getBuilder();
    final Procedure0 _function = new Procedure0() {
      @Override
      public void apply() {
        IdeaIntegrationTest.this.myFixture.renameElement(xtendFile, "Bar.xtend");
      }
    };
    _builder_1.runOperation(_function);
    ChunkedResourceDescriptions _index_2 = this.getIndex();
    IResourceDescription _resourceDescription_2 = _index_2.getResourceDescription(after);
    TestCase.assertNotNull(_resourceDescription_2);
    ChunkedResourceDescriptions _index_3 = this.getIndex();
    IResourceDescription _resourceDescription_3 = _index_3.getResourceDescription(before);
    TestCase.assertNull(_resourceDescription_3);
  }
  
  public void testRenameReference() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {}");
    _builder.newLine();
    this.myFixture.addFileToProject("mypackage/Foo.xtend", _builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package mypackage");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class Bar extends Foo {}");
    _builder_1.newLine();
    final String model = _builder_1.toString();
    final PsiFile xtendFile = this.myFixture.addFileToProject("mypackage/Bar.xtend", model);
    VirtualFile _virtualFile = xtendFile.getVirtualFile();
    this.myFixture.testHighlighting(true, true, true, _virtualFile);
    final int referenceOffset = model.indexOf("Foo");
    VirtualFile _virtualFile_1 = xtendFile.getVirtualFile();
    this.myFixture.openFileInEditor(_virtualFile_1);
    Editor _editor = this.myFixture.getEditor();
    CaretModel _caretModel = _editor.getCaretModel();
    _caretModel.moveToOffset(referenceOffset);
    XtextAutoBuilderComponent _builder_2 = this.getBuilder();
    final Procedure0 _function = new Procedure0() {
      @Override
      public void apply() {
        IdeaIntegrationTest.this.myFixture.renameElementAtCaret("Zonk");
      }
    };
    _builder_2.runOperation(_function);
    VirtualFile _virtualFile_2 = xtendFile.getVirtualFile();
    this.myFixture.testHighlighting(true, true, true, _virtualFile_2);
  }
  
  public void testNonSourceFile() {
    Application _application = ApplicationManager.getApplication();
    final Runnable _function = new Runnable() {
      @Override
      public void run() {
        Module _module = IdeaIntegrationTest.this.myFixture.getModule();
        ModuleRootManager _instance = ModuleRootManager.getInstance(_module);
        final ModifiableRootModel model = _instance.getModifiableModel();
        ContentEntry[] _contentEntries = model.getContentEntries();
        final ContentEntry contentEntry = IterableExtensions.<ContentEntry>head(((Iterable<ContentEntry>)Conversions.doWrapArray(_contentEntries)));
        SourceFolder[] _sourceFolders = contentEntry.getSourceFolders();
        final SourceFolder sourceFolder = IterableExtensions.<SourceFolder>head(((Iterable<SourceFolder>)Conversions.doWrapArray(_sourceFolders)));
        contentEntry.removeSourceFolder(sourceFolder);
        model.commit();
      }
    };
    _application.runWriteAction(_function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package otherPackage");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.myFixture.addFileToProject("otherPackage/Foo.xtend", _builder.toString());
    ChunkedResourceDescriptions _index = this.getIndex();
    URI _createURI = URI.createURI("temp:///src/otherPackage/Foo.xtend");
    IResourceDescription _resourceDescription = _index.getResourceDescription(_createURI);
    TestCase.assertNull(_resourceDescription);
  }
  
  public void testExcludedFile() {
    Application _application = ApplicationManager.getApplication();
    final Runnable _function = new Runnable() {
      @Override
      public void run() {
        try {
          Module _module = IdeaIntegrationTest.this.myFixture.getModule();
          ModuleRootManager _instance = ModuleRootManager.getInstance(_module);
          final ModifiableRootModel model = _instance.getModifiableModel();
          ContentEntry[] _contentEntries = model.getContentEntries();
          final ContentEntry contentEntry = IterableExtensions.<ContentEntry>head(((Iterable<ContentEntry>)Conversions.doWrapArray(_contentEntries)));
          VirtualFile _file = contentEntry.getFile();
          final VirtualFile excludedDir = _file.createChildDirectory(null, "excluded");
          contentEntry.addExcludeFolder(excludedDir);
          model.commit();
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    _application.runWriteAction(_function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package excluded");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.myFixture.addFileToProject("excluded/Foo.xtend", _builder.toString());
    ChunkedResourceDescriptions _index = this.getIndex();
    URI _createURI = URI.createURI("temp:///src/excluded/Foo.xtend");
    IResourceDescription _resourceDescription = _index.getResourceDescription(_createURI);
    TestCase.assertNull(_resourceDescription);
  }
  
  public void assertFileContents(final String path, final CharSequence sequence) {
    try {
      final VirtualFile file = this.myFixture.findFileInTempDir(path);
      String _string = sequence.toString();
      InputStream _inputStream = file.getInputStream();
      Charset _charset = file.getCharset();
      InputStreamReader _inputStreamReader = new InputStreamReader(_inputStream, _charset);
      String _string_1 = CharStreams.toString(_inputStreamReader);
      TestCase.assertEquals(_string, _string_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
