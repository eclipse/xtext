/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.tests.editor.model;

import com.google.inject.Provider;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.parser.antlr.internal.InternalXtextLexer;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.model.DocumentTokenSource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.ITextEditComposer;
import org.eclipse.xtext.ui.tests.editor.model.AbstractXtextDocumentTest;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Jan Koehnlein
 */
@SuppressWarnings("all")
public class DocumentLockerTest extends AbstractXtextDocumentTest {
  @Test
  public void testNoUpdateContentProcessOnReentrant() {
    final ArrayList<String> s = CollectionLiterals.<String>newArrayList();
    DocumentTokenSource _createTokenSource = this.createTokenSource();
    ITextEditComposer _createTextEditComposer = this.createTextEditComposer();
    final XtextDocument document = new XtextDocument(_createTokenSource, _createTextEditComposer, this.outdatedStateManager, this.operationCanceledManager) {
      @Override
      protected boolean updateContentBeforeRead() {
        return s.add("x");
      }
    };
    XtextResource _xtextResource = new XtextResource();
    final Procedure1<XtextResource> _function = (XtextResource it) -> {
      EList<Resource> _resources = new XtextResourceSet().getResources();
      _resources.add(it);
    };
    XtextResource _doubleArrow = ObjectExtensions.<XtextResource>operator_doubleArrow(_xtextResource, _function);
    document.setInput(_doubleArrow);
    Assert.assertEquals(0, s.size());
    final IUnitOfWork<Object, XtextResource> _function_1 = (XtextResource it) -> {
      Assert.assertEquals(1, s.size());
      final IUnitOfWork<Object, XtextResource> _function_2 = (XtextResource it_1) -> {
        Assert.assertEquals(1, s.size());
        final IUnitOfWork<Object, XtextResource> _function_3 = (XtextResource it_2) -> {
          Assert.assertEquals(1, s.size());
          return null;
        };
        document.<Object>readOnly(_function_3);
        return null;
      };
      document.<Object>readOnly(_function_2);
      return null;
    };
    document.<Object>readOnly(_function_1);
    Assert.assertEquals(1, s.size());
  }
  
  @Test
  public void testModifySetsOutdatedFalse() {
    DocumentTokenSource _createTokenSource = this.createTokenSource();
    ITextEditComposer _createTextEditComposer = this.createTextEditComposer();
    final XtextDocument document = new XtextDocument(_createTokenSource, _createTextEditComposer, this.outdatedStateManager, this.operationCanceledManager);
    XtextResource _xtextResource = new XtextResource();
    final Procedure1<XtextResource> _function = (XtextResource it) -> {
      EList<Resource> _resources = new XtextResourceSet().getResources();
      _resources.add(it);
    };
    final XtextResource resource = ObjectExtensions.<XtextResource>operator_doubleArrow(_xtextResource, _function);
    document.setInput(resource);
    final IUnitOfWork<Object, XtextResource> _function_1 = (XtextResource it) -> {
      Object _xblockexpression = null;
      {
        Assert.assertFalse(document.getCancelIndicator().isCanceled());
        _xblockexpression = null;
      }
      return _xblockexpression;
    };
    document.<Object>internalModify(_function_1);
    final CancelIndicator indicator = document.getCancelIndicator();
    Assert.assertFalse(indicator.isCanceled());
    document.set("fupp");
    Assert.assertTrue(indicator.isCanceled());
    final IUnitOfWork<Object, XtextResource> _function_2 = (XtextResource it) -> {
      Object _xblockexpression = null;
      {
        Assert.assertFalse(document.getCancelIndicator().isCanceled());
        _xblockexpression = null;
      }
      return _xblockexpression;
    };
    document.<Object>internalModify(_function_2);
  }
  
  @Test
  public void testPriorityReadOnlyCancelsReaders() {
    try {
      DocumentTokenSource _createTokenSource = this.createTokenSource();
      final XtextDocument document = new XtextDocument(_createTokenSource, null, this.outdatedStateManager, this.operationCanceledManager);
      XtextResource _xtextResource = new XtextResource();
      final Procedure1<XtextResource> _function = (XtextResource it) -> {
        EList<Resource> _resources = new XtextResourceSet().getResources();
        _resources.add(it);
      };
      XtextResource _doubleArrow = ObjectExtensions.<XtextResource>operator_doubleArrow(_xtextResource, _function);
      document.setInput(_doubleArrow);
      final CountDownLatch check = new CountDownLatch(1);
      final Runnable _function_1 = () -> {
        document.<Object>readOnly(new CancelableUnitOfWork<Object, XtextResource>() {
          @Override
          public Object exec(final XtextResource state, final CancelIndicator cancelIndicator) throws Exception {
            check.countDown();
            final int wait = 4000;
            int i = 0;
            while ((!cancelIndicator.isCanceled())) {
              {
                Thread.sleep(10l);
                if ((i > wait)) {
                  throw new InterruptedException();
                }
                i = (i + 1);
              }
            }
            return null;
          }
        });
      };
      final Thread thread = new Thread(_function_1);
      thread.start();
      check.await();
      final IUnitOfWork<Object, XtextResource> _function_2 = (XtextResource it) -> {
        return null;
      };
      document.<Object>priorityReadOnly(_function_2);
      Assert.assertFalse(thread.isInterrupted());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testReadOnlyDoesntCancelReaders() {
    DocumentTokenSource _createTokenSource = this.createTokenSource();
    final XtextDocument document = new XtextDocument(_createTokenSource, null, this.outdatedStateManager, this.operationCanceledManager);
    XtextResource _xtextResource = new XtextResource();
    final Procedure1<XtextResource> _function = (XtextResource it) -> {
      EList<Resource> _resources = new XtextResourceSet().getResources();
      _resources.add(it);
    };
    XtextResource _doubleArrow = ObjectExtensions.<XtextResource>operator_doubleArrow(_xtextResource, _function);
    document.setInput(_doubleArrow);
    final ArrayList<CancelIndicator> cancelIndicators = CollectionLiterals.<CancelIndicator>newArrayList();
    this.addReaderCancelationListener(document, cancelIndicators);
    Assert.assertTrue(cancelIndicators.isEmpty());
    final IUnitOfWork<Object, XtextResource> _function_1 = (XtextResource it) -> {
      return null;
    };
    document.<Object>readOnly(_function_1);
    Assert.assertTrue(cancelIndicators.isEmpty());
    final IUnitOfWork<Object, XtextResource> _function_2 = (XtextResource it) -> {
      return null;
    };
    document.<Object>readOnly(_function_2);
    Assert.assertTrue(cancelIndicators.isEmpty());
  }
  
  private DocumentTokenSource createTokenSource() {
    DocumentTokenSource _xblockexpression = null;
    {
      final DocumentTokenSource tokenSource = new DocumentTokenSource();
      tokenSource.setLexer(new Provider<Lexer>() {
        @Override
        public Lexer get() {
          return new InternalXtextLexer();
        }
      });
      _xblockexpression = tokenSource;
    }
    return _xblockexpression;
  }
  
  private ITextEditComposer createTextEditComposer() {
    return new ITextEditComposer() {
      @Override
      public void beginRecording(final Resource resource) {
      }
      
      @Override
      public TextEdit endRecording() {
        return null;
      }
      
      @Override
      public TextEdit getTextEdit() {
        return null;
      }
    };
  }
  
  private void addReaderCancelationListener(final IXtextDocument document, final List<CancelIndicator> cancelIndicators) {
    final IXtextModelListener _function = (XtextResource it) -> {
      final CancelableUnitOfWork<Boolean, XtextResource> _function_1 = new CancelableUnitOfWork<Boolean, XtextResource>() {
        @Override
        public Boolean exec(final XtextResource state, final CancelIndicator cancelIndicator) throws Exception {
          boolean _xblockexpression = false;
          {
            Assert.assertFalse(cancelIndicator.isCanceled());
            _xblockexpression = cancelIndicators.add(cancelIndicator);
          }
          return Boolean.valueOf(_xblockexpression);
        }
      };
      final CancelableUnitOfWork<Boolean, XtextResource> work = _function_1;
      document.<Boolean>readOnly(work);
    };
    document.addModelListener(_function);
  }
}
