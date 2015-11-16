/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea;

import com.google.common.base.Objects;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ContentEntry;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.tree.IElementType;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.core.idea.highlighting.XtendHighlightingLexer;
import org.eclipse.xtend.core.idea.lang.XtendFileType;
import org.eclipse.xtend.ide.common.highlighting.XtendHighlightingStyles;
import org.eclipse.xtext.idea.build.XtextAutoBuilderComponent;
import org.eclipse.xtext.idea.resource.VirtualFileURIUtil;
import org.eclipse.xtext.idea.tests.LibraryUtil;
import org.eclipse.xtext.idea.tests.LightToolingTest;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public abstract class LightXtendTest extends LightToolingTest {
  public LightXtendTest() {
    super(XtendFileType.INSTANCE);
  }
  
  @Override
  protected void configureModule(final Module module, final ModifiableRootModel model, final ContentEntry contentEntry) {
    try {
      LibraryUtil.addXtendLibrary(model);
      VirtualFile _file = contentEntry.getFile();
      final VirtualFile xtendGenFolder = VfsUtil.createDirectoryIfMissing(_file, "xtend-gen");
      contentEntry.addSourceFolder(xtendGenFolder, false);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  protected String getXtextStyle(final IElementType tokenType) {
    String _xifexpression = null;
    boolean _equals = Objects.equal(tokenType, XtendHighlightingLexer.GUILLEMET_ELEMENT_TYPE);
    if (_equals) {
      _xifexpression = XtendHighlightingStyles.RICH_TEXT_DELIMITER_ID;
    } else {
      _xifexpression = super.getXtextStyle(tokenType);
    }
    return _xifexpression;
  }
  
  protected Iterable<PsiFile> getGeneratedSources(final PsiFile sourceFile, final Function1<? super VirtualFile, ? extends Boolean> filter) {
    VirtualFile _virtualFile = sourceFile.getVirtualFile();
    Iterable<VirtualFile> _generatedSources = this.getGeneratedSources(_virtualFile, filter);
    final Function1<VirtualFile, PsiFile> _function = new Function1<VirtualFile, PsiFile>() {
      @Override
      public PsiFile apply(final VirtualFile it) {
        PsiManager _psiManager = LightXtendTest.this.getPsiManager();
        return _psiManager.findFile(it);
      }
    };
    Iterable<PsiFile> _map = IterableExtensions.<VirtualFile, PsiFile>map(_generatedSources, _function);
    return IterableExtensions.<PsiFile>filterNull(_map);
  }
  
  protected Iterable<VirtualFile> getGeneratedSources(final VirtualFile sourceFile, final Function1<? super VirtualFile, ? extends Boolean> filter) {
    Iterable<VirtualFile> _generatedSources = this.getGeneratedSources(sourceFile);
    final Function1<VirtualFile, Boolean> _function = new Function1<VirtualFile, Boolean>() {
      @Override
      public Boolean apply(final VirtualFile it) {
        return filter.apply(it);
      }
    };
    return IterableExtensions.<VirtualFile>filter(_generatedSources, _function);
  }
  
  protected Iterable<VirtualFile> getGeneratedSources(final VirtualFile sourceFile) {
    XtextAutoBuilderComponent _builder = this.getBuilder();
    URI _uRI = VirtualFileURIUtil.getURI(sourceFile);
    Iterable<URI> _generatedSources = _builder.getGeneratedSources(_uRI);
    final Function1<URI, VirtualFile> _function = new Function1<URI, VirtualFile>() {
      @Override
      public VirtualFile apply(final URI it) {
        return VirtualFileURIUtil.getVirtualFile(it);
      }
    };
    Iterable<VirtualFile> _map = IterableExtensions.<URI, VirtualFile>map(_generatedSources, _function);
    return IterableExtensions.<VirtualFile>filterNull(_map);
  }
  
  protected ChunkedResourceDescriptions getIndex() {
    final XtextResourceSet rs = new XtextResourceSet();
    XtextAutoBuilderComponent _builder = this.getBuilder();
    _builder.installCopyOfResourceDescriptions(rs);
    final ChunkedResourceDescriptions index = ChunkedResourceDescriptions.findInEmfObject(rs);
    return index;
  }
  
  protected XtextAutoBuilderComponent getBuilder() {
    Project _project = this.getProject();
    return _project.<XtextAutoBuilderComponent>getComponent(XtextAutoBuilderComponent.class);
  }
}
