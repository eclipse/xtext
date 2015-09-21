/**
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.tests.editor.quickfix;

import com.google.common.base.Objects;
import com.google.inject.Provider;
import java.util.List;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.model.edit.IssueModificationContext;
import org.eclipse.xtext.ui.editor.quickfix.AbstractDeclarativeQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolution;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Knut Wannheden - Initial contribution and API
 */
@SuppressWarnings("all")
public class DeclarativeQuickfixProviderTest extends Assert {
  private final static String DUMMY_CODE = "DeclarativeQuickfixProviderTest.DummyCode";
  
  @Test
  public void testHasResolutions() throws Exception {
    abstract class __DeclarativeQuickfixProviderTest_1 extends AbstractDeclarativeQuickfixProvider {
      public abstract void signature(final Issue i, final IssueResolutionAcceptor acceptor);
    }
    
    AbstractDeclarativeQuickfixProvider provider = new __DeclarativeQuickfixProviderTest_1() {
      @Fix(DeclarativeQuickfixProviderTest.DUMMY_CODE)
      public void signature(final Issue i, final IssueResolutionAcceptor acceptor) {
      }
    };
    boolean _hasResolutionFor = provider.hasResolutionFor((DeclarativeQuickfixProviderTest.DUMMY_CODE + Integer.valueOf(1)));
    Assert.assertFalse(_hasResolutionFor);
    boolean _hasResolutionFor_1 = provider.hasResolutionFor(DeclarativeQuickfixProviderTest.DUMMY_CODE);
    Assert.assertTrue(_hasResolutionFor_1);
  }
  
  @Test
  public void testGetResolutions() throws Exception {
    abstract class __DeclarativeQuickfixProviderTest_2 extends AbstractDeclarativeQuickfixProvider {
      public abstract void fixError1(final Issue i, final IssueResolutionAcceptor acceptor);
      
      public abstract void fixError2(final Issue i, final IssueResolutionAcceptor acceptor);
    }
    
    AbstractDeclarativeQuickfixProvider provider = new __DeclarativeQuickfixProviderTest_2() {
      @Fix(DeclarativeQuickfixProviderTest.DUMMY_CODE)
      public void fixError1(final Issue i, final IssueResolutionAcceptor acceptor) {
        acceptor.accept(i, "fixError1", "", "", IModification.NULL);
      }
      
      @Fix(DeclarativeQuickfixProviderTest.DUMMY_CODE)
      public void fixError2(final Issue i, final IssueResolutionAcceptor acceptor) {
        acceptor.accept(i, "fixError2", "", "", IModification.NULL);
      }
    };
    final Provider<IssueResolutionAcceptor> _function = new Provider<IssueResolutionAcceptor>() {
      @Override
      public IssueResolutionAcceptor get() {
        final IssueModificationContext.Factory _function = new IssueModificationContext.Factory() {
          @Override
          public IModificationContext createModificationContext(final Issue it) {
            return null;
          }
        };
        return new IssueResolutionAcceptor(_function);
      }
    };
    provider.setIssueResolutionAcceptorProvider(_function);
    Issue _createIssue = this.createIssue((DeclarativeQuickfixProviderTest.DUMMY_CODE + Integer.valueOf(1)));
    List<IssueResolution> resolutionsIterable = provider.getResolutions(_createIssue);
    IssueResolution _head = IterableExtensions.<IssueResolution>head(resolutionsIterable);
    Assert.assertNull(_head);
    Issue _createIssue_1 = this.createIssue(DeclarativeQuickfixProviderTest.DUMMY_CODE);
    List<IssueResolution> resolutions = provider.getResolutions(_createIssue_1);
    int _size = resolutions.size();
    Assert.assertEquals(2, _size);
    final Function1<IssueResolution, Boolean> _function_1 = new Function1<IssueResolution, Boolean>() {
      @Override
      public Boolean apply(final IssueResolution it) {
        String _label = it.getLabel();
        return Boolean.valueOf(Objects.equal(_label, "fixError1"));
      }
    };
    boolean _exists = IterableExtensions.<IssueResolution>exists(resolutions, _function_1);
    Assert.assertTrue(_exists);
    final Function1<IssueResolution, Boolean> _function_2 = new Function1<IssueResolution, Boolean>() {
      @Override
      public Boolean apply(final IssueResolution it) {
        String _label = it.getLabel();
        return Boolean.valueOf(Objects.equal(_label, "fixError2"));
      }
    };
    boolean _exists_1 = IterableExtensions.<IssueResolution>exists(resolutions, _function_2);
    Assert.assertTrue(_exists_1);
  }
  
  protected Issue createIssue(final String code) {
    Issue.IssueImpl _issueImpl = new Issue.IssueImpl();
    final Procedure1<Issue.IssueImpl> _function = new Procedure1<Issue.IssueImpl>() {
      @Override
      public void apply(final Issue.IssueImpl it) {
        it.setCode(code);
      }
    };
    return ObjectExtensions.<Issue.IssueImpl>operator_doubleArrow(_issueImpl, _function);
  }
}
