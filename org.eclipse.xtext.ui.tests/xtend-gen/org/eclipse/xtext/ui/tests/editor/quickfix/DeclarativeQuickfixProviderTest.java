/**
 * Copyright (c) 2009, 2017 itemis AG (http://www.itemis.eu) and others.
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
import org.eclipse.xtext.ui.editor.model.edit.IssueModificationContext;
import org.eclipse.xtext.ui.editor.quickfix.AbstractDeclarativeQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.Fixes;
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
  private static final String DUMMY_CODE = "DeclarativeQuickfixProviderTest.DummyCode";
  
  private static final String DUMMY_CODE2 = "DeclarativeQuickfixProviderTest.DummyCode2";
  
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
    Assert.assertFalse(provider.hasResolutionFor((DeclarativeQuickfixProviderTest.DUMMY_CODE + Integer.valueOf(1))));
    Assert.assertTrue(provider.hasResolutionFor(DeclarativeQuickfixProviderTest.DUMMY_CODE));
  }
  
  @Test
  public void testHasResolutions2() throws Exception {
    abstract class __DeclarativeQuickfixProviderTest_2 extends AbstractDeclarativeQuickfixProvider {
      public abstract void signature(final Issue i, final IssueResolutionAcceptor acceptor);
    }
    
    AbstractDeclarativeQuickfixProvider provider = new __DeclarativeQuickfixProviderTest_2() {
      @Fix(DeclarativeQuickfixProviderTest.DUMMY_CODE)
      @Fix(DeclarativeQuickfixProviderTest.DUMMY_CODE2)
      public void signature(final Issue i, final IssueResolutionAcceptor acceptor) {
      }
    };
    Assert.assertFalse(provider.hasResolutionFor((DeclarativeQuickfixProviderTest.DUMMY_CODE + Integer.valueOf(1))));
    Assert.assertTrue(provider.hasResolutionFor(DeclarativeQuickfixProviderTest.DUMMY_CODE));
    Assert.assertTrue(provider.hasResolutionFor(DeclarativeQuickfixProviderTest.DUMMY_CODE2));
  }
  
  @Test
  public void testHasResolutions3() throws Exception {
    abstract class __DeclarativeQuickfixProviderTest_3 extends AbstractDeclarativeQuickfixProvider {
      public abstract void signature(final Issue i, final IssueResolutionAcceptor acceptor);
    }
    
    AbstractDeclarativeQuickfixProvider provider = new __DeclarativeQuickfixProviderTest_3() {
      @Fixes({ @Fix(DeclarativeQuickfixProviderTest.DUMMY_CODE), @Fix(DeclarativeQuickfixProviderTest.DUMMY_CODE2) })
      public void signature(final Issue i, final IssueResolutionAcceptor acceptor) {
      }
    };
    Assert.assertFalse(provider.hasResolutionFor((DeclarativeQuickfixProviderTest.DUMMY_CODE + Integer.valueOf(1))));
    Assert.assertTrue(provider.hasResolutionFor(DeclarativeQuickfixProviderTest.DUMMY_CODE));
    Assert.assertTrue(provider.hasResolutionFor(DeclarativeQuickfixProviderTest.DUMMY_CODE2));
  }
  
  @Test
  public void testGetResolutions() throws Exception {
    abstract class __DeclarativeQuickfixProviderTest_4 extends AbstractDeclarativeQuickfixProvider {
      public abstract void fixError1(final Issue i, final IssueResolutionAcceptor acceptor);
      
      public abstract void fixError2(final Issue i, final IssueResolutionAcceptor acceptor);
    }
    
    AbstractDeclarativeQuickfixProvider provider = new __DeclarativeQuickfixProviderTest_4() {
      @Fix(DeclarativeQuickfixProviderTest.DUMMY_CODE)
      public void fixError1(final Issue i, final IssueResolutionAcceptor acceptor) {
        acceptor.accept(i, "fixError1", "", "", IModification.NULL);
      }
      
      @Fix(DeclarativeQuickfixProviderTest.DUMMY_CODE)
      public void fixError2(final Issue i, final IssueResolutionAcceptor acceptor) {
        acceptor.accept(i, "fixError2", "", "", IModification.NULL);
      }
    };
    final Provider<IssueResolutionAcceptor> _function = () -> {
      final IssueModificationContext.Factory _function_1 = (Issue it) -> {
        return null;
      };
      return new IssueResolutionAcceptor(_function_1);
    };
    provider.setIssueResolutionAcceptorProvider(_function);
    List<IssueResolution> resolutionsIterable = provider.getResolutions(this.createIssue((DeclarativeQuickfixProviderTest.DUMMY_CODE + Integer.valueOf(1))));
    Assert.assertNull(IterableExtensions.<IssueResolution>head(resolutionsIterable));
    List<IssueResolution> resolutions = provider.getResolutions(this.createIssue(DeclarativeQuickfixProviderTest.DUMMY_CODE));
    Assert.assertEquals(2, resolutions.size());
    final Function1<IssueResolution, Boolean> _function_1 = (IssueResolution it) -> {
      String _label = it.getLabel();
      return Boolean.valueOf(Objects.equal(_label, "fixError1"));
    };
    Assert.assertTrue(IterableExtensions.<IssueResolution>exists(resolutions, _function_1));
    final Function1<IssueResolution, Boolean> _function_2 = (IssueResolution it) -> {
      String _label = it.getLabel();
      return Boolean.valueOf(Objects.equal(_label, "fixError2"));
    };
    Assert.assertTrue(IterableExtensions.<IssueResolution>exists(resolutions, _function_2));
  }
  
  @Test
  public void testGetResolutions2() throws Exception {
    abstract class __DeclarativeQuickfixProviderTest_5 extends AbstractDeclarativeQuickfixProvider {
      public abstract void fixError1(final Issue i, final IssueResolutionAcceptor acceptor);
      
      public abstract void fixError2(final Issue i, final IssueResolutionAcceptor acceptor);
      
      public abstract void fixError3(final Issue i, final IssueResolutionAcceptor acceptor);
    }
    
    AbstractDeclarativeQuickfixProvider provider = new __DeclarativeQuickfixProviderTest_5() {
      @Fix(DeclarativeQuickfixProviderTest.DUMMY_CODE)
      @Fix(DeclarativeQuickfixProviderTest.DUMMY_CODE2)
      public void fixError1(final Issue i, final IssueResolutionAcceptor acceptor) {
        acceptor.accept(i, "fixError1", "", "", IModification.NULL);
      }
      
      @Fix(DeclarativeQuickfixProviderTest.DUMMY_CODE)
      public void fixError2(final Issue i, final IssueResolutionAcceptor acceptor) {
        acceptor.accept(i, "fixError2", "", "", IModification.NULL);
      }
      
      @Fixes({ @Fix(DeclarativeQuickfixProviderTest.DUMMY_CODE), @Fix(DeclarativeQuickfixProviderTest.DUMMY_CODE2) })
      public void fixError3(final Issue i, final IssueResolutionAcceptor acceptor) {
        acceptor.accept(i, "fixError3", "", "", IModification.NULL);
      }
    };
    final Provider<IssueResolutionAcceptor> _function = () -> {
      final IssueModificationContext.Factory _function_1 = (Issue it) -> {
        return null;
      };
      return new IssueResolutionAcceptor(_function_1);
    };
    provider.setIssueResolutionAcceptorProvider(_function);
    List<IssueResolution> resolutionsIterable = provider.getResolutions(this.createIssue((DeclarativeQuickfixProviderTest.DUMMY_CODE + Integer.valueOf(1))));
    Assert.assertNull(IterableExtensions.<IssueResolution>head(resolutionsIterable));
    List<IssueResolution> resolutions = provider.getResolutions(this.createIssue(DeclarativeQuickfixProviderTest.DUMMY_CODE));
    Assert.assertEquals(3, resolutions.size());
    final Function1<IssueResolution, Boolean> _function_1 = (IssueResolution it) -> {
      String _label = it.getLabel();
      return Boolean.valueOf(Objects.equal(_label, "fixError1"));
    };
    Assert.assertTrue(IterableExtensions.<IssueResolution>exists(resolutions, _function_1));
    final Function1<IssueResolution, Boolean> _function_2 = (IssueResolution it) -> {
      String _label = it.getLabel();
      return Boolean.valueOf(Objects.equal(_label, "fixError2"));
    };
    Assert.assertTrue(IterableExtensions.<IssueResolution>exists(resolutions, _function_2));
    final Function1<IssueResolution, Boolean> _function_3 = (IssueResolution it) -> {
      String _label = it.getLabel();
      return Boolean.valueOf(Objects.equal(_label, "fixError3"));
    };
    Assert.assertTrue(IterableExtensions.<IssueResolution>exists(resolutions, _function_3));
    List<IssueResolution> resolutions2 = provider.getResolutions(this.createIssue(DeclarativeQuickfixProviderTest.DUMMY_CODE2));
    Assert.assertEquals(2, resolutions2.size());
    final Function1<IssueResolution, Boolean> _function_4 = (IssueResolution it) -> {
      String _label = it.getLabel();
      return Boolean.valueOf(Objects.equal(_label, "fixError2"));
    };
    Assert.assertTrue(IterableExtensions.<IssueResolution>exists(resolutions, _function_4));
    final Function1<IssueResolution, Boolean> _function_5 = (IssueResolution it) -> {
      String _label = it.getLabel();
      return Boolean.valueOf(Objects.equal(_label, "fixError3"));
    };
    Assert.assertTrue(IterableExtensions.<IssueResolution>exists(resolutions, _function_5));
  }
  
  protected Issue createIssue(final String code) {
    Issue.IssueImpl _issueImpl = new Issue.IssueImpl();
    final Procedure1<Issue.IssueImpl> _function = (Issue.IssueImpl it) -> {
      it.setCode(code);
    };
    return ObjectExtensions.<Issue.IssueImpl>operator_doubleArrow(_issueImpl, _function);
  }
}
