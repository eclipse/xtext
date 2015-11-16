/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.tests.parsing;

import com.google.inject.Inject;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.roots.ContentEntry;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.vfs.VirtualFile;
import java.io.IOException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.idea.lang.BaseXtextASTFactory;
import org.eclipse.xtext.idea.resource.IdeaResourceSetProvider;
import org.eclipse.xtext.idea.tests.LibraryUtil;
import org.eclipse.xtext.idea.tests.LightToolingTest;
import org.eclipse.xtext.idea.tests.parsing.ModelChecker;
import org.eclipse.xtext.idea.tests.parsing.XtextResourceAsserts;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.LazyStringInputStream;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class AbstractModelTestCase extends LightToolingTest implements ModelChecker {
  @Inject
  @Accessors(AccessorType.PROTECTED_GETTER)
  private BaseXtextASTFactory astFactory;
  
  @Inject
  @Accessors(AccessorType.PROTECTED_GETTER)
  private ValidationTestHelper validationHelper;
  
  @Inject
  @Accessors(AccessorType.PROTECTED_GETTER)
  private IdeaResourceSetProvider resourceSetProvider;
  
  @Inject
  @Accessors(AccessorType.PROTECTED_GETTER)
  @Extension
  private XtextResourceAsserts xtextResourceAsserts;
  
  public AbstractModelTestCase(final LanguageFileType fileType) {
    super(fileType);
  }
  
  @Override
  protected void configureModule(final Module module, final ModifiableRootModel model, final ContentEntry contentEntry) {
    LibraryUtil.addXbaseLibrary(model);
  }
  
  @Override
  public XtextResource checkResource(final String code, final boolean validate) {
    XtextResource _xblockexpression = null;
    {
      this.createFile(null, code);
      if (validate) {
        XtextResource _actualResource = this.getActualResource();
        this.validationHelper.assertNoErrors(_actualResource);
      }
      _xblockexpression = this.getActualResource();
    }
    return _xblockexpression;
  }
  
  @Override
  public <T extends EObject> T checkModel(final String code, final boolean validate) {
    return this.<T>checkModel(null, code, validate);
  }
  
  @Override
  public <T extends EObject> T checkModel(final String path, final String code, final boolean validate) {
    T _xblockexpression = null;
    {
      this.createFile(path, code);
      XtextResource _actualResource = this.getActualResource();
      EList<EObject> _contents = _actualResource.getContents();
      EObject _head = IterableExtensions.<EObject>head(_contents);
      final T model = ((T) _head);
      if (validate) {
        this.validationHelper.assertNoErrors(model);
      }
      _xblockexpression = model;
    }
    return _xblockexpression;
  }
  
  protected void createFile(final String path, final String code) {
    if ((path == null)) {
      this.configureByText(code);
    } else {
      this.configureByText(path, code);
    }
    final XtextResource actualResource = this.getActualResource();
    final XtextResource expectedResource = this.createExpectedResource();
    this.xtextResourceAsserts.assertResource(expectedResource, actualResource);
  }
  
  protected XtextResource getActualResource() {
    BaseXtextFile _xtextFile = this.getXtextFile();
    return _xtextFile.getResource();
  }
  
  protected XtextResource createExpectedResource() {
    XtextResourceSet resourceSet = this.resourceSetProvider.get(this.myModule);
    BaseXtextFile _xtextFile = this.getXtextFile();
    VirtualFile _virtualFile = _xtextFile.getVirtualFile();
    String _url = _virtualFile.getUrl();
    URI _createURI = URI.createURI(_url);
    Resource _createResource = resourceSet.createResource(_createURI);
    XtextResource resource = ((XtextResource) _createResource);
    try {
      BaseXtextFile _xtextFile_1 = this.getXtextFile();
      String _text = _xtextFile_1.getText();
      LazyStringInputStream _lazyStringInputStream = new LazyStringInputStream(_text);
      resource.load(_lazyStringInputStream, null);
    } catch (final Throwable _t) {
      if (_t instanceof IOException) {
        final IOException e = (IOException)_t;
        throw new RuntimeException(e);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return resource;
  }
  
  @Pure
  protected BaseXtextASTFactory getAstFactory() {
    return this.astFactory;
  }
  
  @Pure
  protected ValidationTestHelper getValidationHelper() {
    return this.validationHelper;
  }
  
  @Pure
  protected IdeaResourceSetProvider getResourceSetProvider() {
    return this.resourceSetProvider;
  }
  
  @Pure
  protected XtextResourceAsserts getXtextResourceAsserts() {
    return this.xtextResourceAsserts;
  }
}
