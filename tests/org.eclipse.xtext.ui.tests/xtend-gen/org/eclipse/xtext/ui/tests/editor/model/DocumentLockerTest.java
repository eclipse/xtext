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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.parser.antlr.internal.InternalXtextLexer;
import org.eclipse.xtext.resource.XtextResource;
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
    final XtextDocument document = new XtextDocument(_createTokenSource, _createTextEditComposer) {
      protected boolean updateContentBeforeRead() {
        return s.add("x");
      }
    };
    XtextResource _xtextResource = new XtextResource();
    document.setInput(_xtextResource);
    int _size = s.size();
    Assert.assertEquals(0, _size);
    final IUnitOfWork<Object, XtextResource> _function = new IUnitOfWork<Object, XtextResource>() {
      public Object exec(final XtextResource it) throws Exception {
        int _size = s.size();
        Assert.assertEquals(1, _size);
        final IUnitOfWork<Object, XtextResource> _function = new IUnitOfWork<Object, XtextResource>() {
          public Object exec(final XtextResource it) throws Exception {
            int _size = s.size();
            Assert.assertEquals(1, _size);
            final IUnitOfWork<Object, XtextResource> _function = new IUnitOfWork<Object, XtextResource>() {
              public Object exec(final XtextResource it) throws Exception {
                int _size = s.size();
                Assert.assertEquals(1, _size);
                return null;
              }
            };
            document.<Object>readOnly(_function);
            return null;
          }
        };
        document.<Object>readOnly(_function);
        return null;
      }
    };
    document.<Object>readOnly(_function);
    int _size_1 = s.size();
    Assert.assertEquals(1, _size_1);
  }
  
  @Test
  public void testModifySetsOutdatedFalse() {
    DocumentTokenSource _createTokenSource = this.createTokenSource();
    ITextEditComposer _createTextEditComposer = this.createTextEditComposer();
    final XtextDocument document = new XtextDocument(_createTokenSource, _createTextEditComposer);
    final XtextResource resource = new XtextResource();
    document.setInput(resource);
    final IUnitOfWork<Object, XtextResource> _function = new IUnitOfWork<Object, XtextResource>() {
      public Object exec(final XtextResource it) throws Exception {
        Object _xblockexpression = null;
        {
          boolean _isOutdated = XtextDocument.isOutdated(it);
          Assert.assertFalse(_isOutdated);
          _xblockexpression = null;
        }
        return _xblockexpression;
      }
    };
    document.<Object>internalModify(_function);
    boolean _isOutdated = XtextDocument.isOutdated(resource);
    Assert.assertFalse(_isOutdated);
    document.set("fupp");
    boolean _isOutdated_1 = XtextDocument.isOutdated(resource);
    Assert.assertTrue(_isOutdated_1);
    final IUnitOfWork<Object, XtextResource> _function_1 = new IUnitOfWork<Object, XtextResource>() {
      public Object exec(final XtextResource it) throws Exception {
        Object _xblockexpression = null;
        {
          boolean _isOutdated = XtextDocument.isOutdated(it);
          Assert.assertFalse(_isOutdated);
          _xblockexpression = null;
        }
        return _xblockexpression;
      }
    };
    document.<Object>internalModify(_function_1);
  }
  
  @Test
  public void testPriorityReadOnlyCancelsReaders() {
    try {
      DocumentTokenSource _createTokenSource = this.createTokenSource();
      final XtextDocument document = new XtextDocument(_createTokenSource, null);
      XtextResource _xtextResource = new XtextResource();
      document.setInput(_xtextResource);
      final boolean[] check = new boolean[1];
      final Runnable _function = new Runnable() {
        public void run() {
          document.<Object>readOnly(new CancelableUnitOfWork<Object, XtextResource>() {
            public Object exec(final XtextResource state, final CancelIndicator cancelIndicator) throws Exception {
              check[0] = true;
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
        }
      };
      final Thread thread = new Thread(_function);
      thread.start();
      while ((!check[0])) {
        Thread.sleep(1);
      }
      final IUnitOfWork<Object, XtextResource> _function_1 = new IUnitOfWork<Object, XtextResource>() {
        public Object exec(final XtextResource it) throws Exception {
          return null;
        }
      };
      document.<Object>priorityReadOnly(_function_1);
      boolean _isInterrupted = thread.isInterrupted();
      Assert.assertFalse(_isInterrupted);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testReadOnlyDoesntCancelReaders() {
    DocumentTokenSource _createTokenSource = this.createTokenSource();
    final XtextDocument document = new XtextDocument(_createTokenSource, null);
    XtextResource _xtextResource = new XtextResource();
    document.setInput(_xtextResource);
    final ArrayList<CancelIndicator> cancelIndicators = CollectionLiterals.<CancelIndicator>newArrayList();
    this.addReaderCancelationListener(document, cancelIndicators);
    boolean _isEmpty = cancelIndicators.isEmpty();
    Assert.assertTrue(_isEmpty);
    final IUnitOfWork<Object, XtextResource> _function = new IUnitOfWork<Object, XtextResource>() {
      public Object exec(final XtextResource it) throws Exception {
        return null;
      }
    };
    document.<Object>readOnly(_function);
    boolean _isEmpty_1 = cancelIndicators.isEmpty();
    Assert.assertTrue(_isEmpty_1);
    final IUnitOfWork<Object, XtextResource> _function_1 = new IUnitOfWork<Object, XtextResource>() {
      public Object exec(final XtextResource it) throws Exception {
        return null;
      }
    };
    document.<Object>readOnly(_function_1);
    boolean _isEmpty_2 = cancelIndicators.isEmpty();
    Assert.assertTrue(_isEmpty_2);
  }
  
  private DocumentTokenSource createTokenSource() {
    DocumentTokenSource _xblockexpression = null;
    {
      final DocumentTokenSource tokenSource = new DocumentTokenSource();
      tokenSource.setLexer(new Provider<Lexer>() {
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
      public void beginRecording(final Resource resource) {
      }
      
      public TextEdit endRecording() {
        return null;
      }
      
      public TextEdit getTextEdit() {
        return null;
      }
    };
  }
  
  private void addReaderCancelationListener(final IXtextDocument document, final List<CancelIndicator> cancelIndicators) {
    final IXtextModelListener _function = new IXtextModelListener() {
      public void modelChanged(final XtextResource it) {
        final CancelableUnitOfWork<Boolean, XtextResource> _function = new CancelableUnitOfWork<Boolean, XtextResource>() {
          @Override
          public Boolean exec(final XtextResource state, final CancelIndicator cancelIndicator) throws Exception {
            boolean _xblockexpression = false;
            {
              boolean _isCanceled = cancelIndicator.isCanceled();
              Assert.assertFalse(_isCanceled);
              _xblockexpression = cancelIndicators.add(cancelIndicator);
            }
            return Boolean.valueOf(_xblockexpression);
          }
        };
        final CancelableUnitOfWork<Boolean, XtextResource> work = _function;
        document.<Boolean>readOnly(work);
      }
    };
    document.addModelListener(_function);
  }
}
