/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.navigation;

import com.google.inject.Inject;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.testFramework.UsefulTestCase;
import java.io.ByteArrayInputStream;
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
}
