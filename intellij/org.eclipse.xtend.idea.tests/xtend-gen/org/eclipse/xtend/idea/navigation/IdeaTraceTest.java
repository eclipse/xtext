/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.navigation;

import com.google.inject.Inject;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.roots.libraries.Library;
import com.intellij.openapi.roots.ui.configuration.projectRoot.LibrariesContainer;
import com.intellij.openapi.roots.ui.configuration.projectRoot.LibrariesContainerFactory;
import com.intellij.openapi.util.Disposer;
import com.intellij.openapi.vfs.JarFileSystem;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VfsUtilCore;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileManager;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.util.PsiUtil;
import com.intellij.testFramework.UsefulTestCase;
import java.io.ByteArrayInputStream;
import java.net.URL;
import java.util.List;
import junit.framework.TestCase;
import org.eclipse.xtend.idea.LightXtendTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.trace.AbsoluteURI;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;
import org.eclipse.xtext.generator.trace.TraceRegionSerializer;
import org.eclipse.xtext.idea.trace.IIdeaTrace;
import org.eclipse.xtext.idea.trace.ILocationInVirtualFile;
import org.eclipse.xtext.idea.trace.ITraceForVirtualFileProvider;
import org.eclipse.xtext.idea.trace.VirtualFileInProject;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Ignore;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class IdeaTraceTest extends LightXtendTest {
  @Inject
  private TraceRegionSerializer bareTraceReader;
  
  @Inject
  private ITraceForVirtualFileProvider traceProvider;
  
  public void testTraceFileContents() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package com.acme");
      _builder.newLine();
      _builder.append("class MyClass {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.myFixture.addFileToProject("com/acme/MyClass.xtend", _builder.toString());
      final VirtualFile file = this.myFixture.findFileInTempDir("xtend-gen/com/acme/MyClass.java");
      boolean _exists = file.exists();
      TestCase.assertTrue(_exists);
      final String compiledContent = VfsUtil.loadText(file);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package com.acme;");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("@SuppressWarnings(\"all\")");
      _builder_1.newLine();
      _builder_1.append("public class MyClass {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      String _string = _builder_1.toString();
      TestCase.assertEquals(_string, compiledContent);
      final VirtualFile traceFile = this.myFixture.findFileInTempDir("xtend-gen/com/acme/.MyClass.java._trace");
      boolean _exists_1 = file.exists();
      TestCase.assertTrue(_exists_1);
      byte[] _contentsToByteArray = traceFile.contentsToByteArray();
      ByteArrayInputStream _byteArrayInputStream = new ByteArrayInputStream(_contentsToByteArray);
      final AbstractTraceRegion trace = this.bareTraceReader.readTraceRegionFrom(_byteArrayInputStream);
      final SourceRelativeURI associatedPath = trace.getAssociatedSrcRelativePath();
      String _string_1 = associatedPath.toString();
      TestCase.assertEquals("com/acme/MyClass.xtend", _string_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void testNoTraceFile() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package com.acme;");
    _builder.newLine();
    _builder.append("public class MyClass {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final PsiFile file = this.myFixture.addFileToProject("com/acme/MyClass.java", _builder.toString());
    VirtualFile _virtualFile = PsiUtil.getVirtualFile(file);
    Project _project = file.getProject();
    VirtualFileInProject _virtualFileInProject = new VirtualFileInProject(_virtualFile, _project);
    final IIdeaTrace trace = this.traceProvider.getTraceToSource(_virtualFileInProject);
    TestCase.assertNull(trace);
  }
  
  public void testTraceToTarget() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package com.acme");
    _builder.newLine();
    _builder.append("class MyClass {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final PsiFile psiFile = this.myFixture.addFileToProject("com/acme/MyClass.xtend", _builder.toString());
    final VirtualFile virtualFile = psiFile.getVirtualFile();
    Project _project = psiFile.getProject();
    VirtualFileInProject _virtualFileInProject = new VirtualFileInProject(virtualFile, _project);
    final IIdeaTrace traceToTarget = this.traceProvider.getTraceToTarget(_virtualFileInProject);
    TextRegion _textRegion = new TextRegion(0, 1);
    final ILocationInVirtualFile noAssociatedLocation = traceToTarget.getBestAssociatedLocation(_textRegion);
    TestCase.assertNull(noAssociatedLocation);
    TextRegion _textRegion_1 = new TextRegion(18, 1);
    final ILocationInVirtualFile associatedLocation = traceToTarget.getBestAssociatedLocation(_textRegion_1);
    TestCase.assertNotNull(associatedLocation);
    final SourceRelativeURI srcRelativeLocation = associatedLocation.getSrcRelativeResourceURI();
    String _string = srcRelativeLocation.toString();
    TestCase.assertEquals("com/acme/MyClass.java", _string);
    AbsoluteURI _absoluteResourceURI = associatedLocation.getAbsoluteResourceURI();
    String _string_1 = _absoluteResourceURI.toString();
    TestCase.assertEquals("temp:///src/xtend-gen/com/acme/MyClass.java", _string_1);
  }
  
  @Ignore
  public void _testTraceToTargetForPsiFile() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package com.acme");
    _builder.newLine();
    _builder.append("class MyClass {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final PsiFile psiFile = this.myFixture.addFileToProject("com/acme/MyClass.xtend", _builder.toString());
    final List<? extends PsiElement> psiFileTrace = this.traceProvider.getGeneratedElements(psiFile);
    UsefulTestCase.assertNotEmpty(psiFileTrace);
  }
  
  public void testTraceToSource() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package com.acme");
    _builder.newLine();
    _builder.append("class MyClass {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.myFixture.addFileToProject("com/acme/MyClass.xtend", _builder.toString());
    final VirtualFile file = this.myFixture.findFileInTempDir("xtend-gen/com/acme/MyClass.java");
    Project _project = this.getProject();
    VirtualFileInProject _virtualFileInProject = new VirtualFileInProject(file, _project);
    final IIdeaTrace traceToSource = this.traceProvider.getTraceToSource(_virtualFileInProject);
    TextRegion _textRegion = new TextRegion(8, 4);
    final ILocationInVirtualFile associatedLocation = traceToSource.getBestAssociatedLocation(_textRegion);
    TestCase.assertNotNull(associatedLocation);
  }
  
  public void testTraceForJar_01() {
    final VirtualFile bin = this.getVirtualFile("smap-binary.jar");
    final VirtualFile src = this.getVirtualFile("smap-sources.jar");
    Module _module = this.myFixture.getModule();
    this.addLibrary(_module, bin, src);
    JarFileSystem _instance = JarFileSystem.getInstance();
    final VirtualFile jarRoot = _instance.getJarRootForLocalFile(src);
    final VirtualFile generated = jarRoot.findFileByRelativePath("de/itemis/HelloXtend.java");
    Project _project = this.getProject();
    VirtualFileInProject _virtualFileInProject = new VirtualFileInProject(generated, _project);
    final IIdeaTrace traceToSource = this.traceProvider.getTraceToSource(_virtualFileInProject);
    TestCase.assertNotNull(traceToSource);
    Iterable<? extends ILocationInVirtualFile> _allAssociatedLocations = traceToSource.getAllAssociatedLocations();
    final Procedure1<ILocationInVirtualFile> _function = new Procedure1<ILocationInVirtualFile>() {
      @Override
      public void apply(final ILocationInVirtualFile it) {
        AbsoluteURI _absoluteResourceURI = it.getAbsoluteResourceURI();
        String _string = _absoluteResourceURI.toString();
        boolean _endsWith = _string.endsWith("smap-sources.jar!/de/itemis/HelloXtend.xtend");
        TestCase.assertTrue(_endsWith);
      }
    };
    IterableExtensions.forEach(_allAssociatedLocations, _function);
  }
  
  public void testTraceForJar_02() {
    final VirtualFile bin = this.getVirtualFile("smap-binary.jar");
    final VirtualFile src = this.getVirtualFile("smap-sources.jar");
    Module _module = this.myFixture.getModule();
    this.addLibrary(_module, bin, src);
    JarFileSystem _instance = JarFileSystem.getInstance();
    final VirtualFile jarRoot = _instance.getJarRootForLocalFile(src);
    final VirtualFile generated = jarRoot.findFileByRelativePath("de/itemis/HelloXtend.xtend");
    Project _project = this.getProject();
    VirtualFileInProject _virtualFileInProject = new VirtualFileInProject(generated, _project);
    final IIdeaTrace traceToTarget = this.traceProvider.getTraceToTarget(_virtualFileInProject);
    TestCase.assertNull(traceToTarget);
  }
  
  public void addLibrary(final Module module, final VirtualFile bin, final VirtualFile src) {
    Project _project = this.getProject();
    final LibrariesContainer container = LibrariesContainerFactory.createContainer(_project);
    Application _application = ApplicationManager.getApplication();
    final Runnable _function = new Runnable() {
      @Override
      public void run() {
        final Library lib = container.createLibrary("my-lib", LibrariesContainer.LibraryLevel.GLOBAL, new VirtualFile[] { bin }, new VirtualFile[] { src });
        ModuleRootManager _instance = ModuleRootManager.getInstance(module);
        final ModifiableRootModel model = _instance.getModifiableModel();
        model.addLibraryEntry(lib);
        Module _module = IdeaTraceTest.this.myFixture.getModule();
        final Disposable _function = new Disposable() {
          @Override
          public void dispose() {
            model.dispose();
          }
        };
        Disposer.register(_module, _function);
        return;
      }
    };
    _application.runWriteAction(_function);
  }
  
  protected VirtualFile getVirtualFile(final String fileNameInPackage) {
    Class<? extends IdeaTraceTest> _class = this.getClass();
    Package _package = _class.getPackage();
    String _name = _package.getName();
    String _replace = _name.replace(".", "/");
    String _plus = ("/" + _replace);
    String _plus_1 = (_plus + "/");
    final String name = (_plus_1 + fileNameInPackage);
    Class<? extends IdeaTraceTest> _class_1 = this.getClass();
    final URL url = _class_1.getResource(name);
    VirtualFileManager _instance = VirtualFileManager.getInstance();
    String _convertFromUrl = VfsUtilCore.convertFromUrl(url);
    return _instance.findFileByUrl(_convertFromUrl);
  }
}
