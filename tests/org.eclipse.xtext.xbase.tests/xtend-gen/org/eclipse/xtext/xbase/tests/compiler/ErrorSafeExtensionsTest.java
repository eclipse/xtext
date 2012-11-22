package org.eclipse.xtext.xbase.tests.compiler;

import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.OnChangeEvictingCache;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.ElementIssueProvider.Factory;
import org.eclipse.xtext.xbase.compiler.ErrorSafeExtensions;
import org.eclipse.xtext.xbase.compiler.IElementIssueProvider;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.LoopParams;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.compiler.output.TreeAppendable;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class ErrorSafeExtensionsTest extends AbstractXbaseTestCase {
  @Inject
  private ILocationInFileProvider locationProvider;
  
  @Inject
  private IJvmModelAssociations jvmModelAssociations;
  
  @Inject
  private IResourceValidator resourceValidator;
  
  @Inject
  private Factory issueProviderFactory;
  
  @Inject
  private OnChangeEvictingCache cache;
  
  @Inject
  private ErrorSafeExtensions _errorSafeExtensions;
  
  @Test
  public void testAppendSafely_NoError() {
    final XExpression e = this.validatedExpression("42");
    final TreeAppendable app = this.createTreeAppendable(e);
    final Procedure1<ITreeAppendable> _function = new Procedure1<ITreeAppendable>() {
        public void apply(final ITreeAppendable it) {
          app.append("fine");
        }
      };
    this._errorSafeExtensions.appendSafely(app, e, _function);
    String _content = app.getContent();
    Assert.assertEquals("fine", _content);
  }
  
  @Test
  public void testAppendSafely_Error() {
    final XExpression e = this.validatedExpression("new Foo()");
    final TreeAppendable app = this.createTreeAppendable(e);
    boolean _hasErrors = this._errorSafeExtensions.hasErrors(e, true);
    Assert.assertTrue(_hasErrors);
    final Procedure1<ITreeAppendable> _function = new Procedure1<ITreeAppendable>() {
        public void apply(final ITreeAppendable it) {
          it.append("error");
        }
      };
    this._errorSafeExtensions.appendSafely(app, e, _function);
    String _content = app.getContent();
    Assert.assertEquals("/* error */", _content);
  }
  
  @Test
  public void testAppendSafely_ErrorWithSurrogate() {
    final XExpression e = this.validatedExpression("new Foo()");
    boolean _hasErrors = this._errorSafeExtensions.hasErrors(e, true);
    Assert.assertTrue(_hasErrors);
    final TreeAppendable app = this.createTreeAppendable(e);
    final Procedure1<ITreeAppendable> _function = new Procedure1<ITreeAppendable>() {
        public void apply(final ITreeAppendable it) {
          it.append("error");
        }
      };
    this._errorSafeExtensions.appendSafely(app, e, "surrogate", _function);
    String _content = app.getContent();
    Assert.assertEquals("/* error */surrogate", _content);
  }
  
  @Test
  public void testAppendForEachSafely() {
    XExpression _validatedExpression = this.validatedExpression("{ val x=42 val y=42 }");
    final XBlockExpression e = ((XBlockExpression) _validatedExpression);
    final TreeAppendable app = this.createTreeAppendable(e);
    EList<XExpression> _expressions = e.getExpressions();
    XExpression _get = _expressions.get(0);
    boolean _hasErrors = this._errorSafeExtensions.hasErrors(_get, true);
    Assert.assertFalse(_hasErrors);
    EList<XExpression> _expressions_1 = e.getExpressions();
    XExpression _get_1 = _expressions_1.get(1);
    boolean _hasErrors_1 = this._errorSafeExtensions.hasErrors(_get_1, true);
    Assert.assertFalse(_hasErrors_1);
    EList<XExpression> _expressions_2 = e.getExpressions();
    Procedure1<? super LoopParams> _loopInitializer = this.getLoopInitializer();
    final Procedure2<XExpression,ITreeAppendable> _function = new Procedure2<XExpression,ITreeAppendable>() {
        public void apply(final XExpression it, final ITreeAppendable app2) {
          String _text = ErrorSafeExtensionsTest.this.getText(it);
          app2.append(_text);
        }
      };
    this._errorSafeExtensions.<XExpression>forEachSafely(app, _expressions_2, _loopInitializer, _function);
    String _content = app.getContent();
    Assert.assertEquals("(val x=42:val y=42)", _content);
  }
  
  @Test
  public void testAppendForEachSafely_0() {
    XExpression _validatedExpression = this.validatedExpression("{ error val x=42 val y=42 }");
    final XBlockExpression e = ((XBlockExpression) _validatedExpression);
    final TreeAppendable app = this.createTreeAppendable(e);
    EList<XExpression> _expressions = e.getExpressions();
    XExpression _get = _expressions.get(0);
    boolean _hasErrors = this._errorSafeExtensions.hasErrors(_get, true);
    Assert.assertTrue(_hasErrors);
    EList<XExpression> _expressions_1 = e.getExpressions();
    XExpression _get_1 = _expressions_1.get(1);
    boolean _hasErrors_1 = this._errorSafeExtensions.hasErrors(_get_1, true);
    Assert.assertFalse(_hasErrors_1);
    EList<XExpression> _expressions_2 = e.getExpressions();
    XExpression _get_2 = _expressions_2.get(2);
    boolean _hasErrors_2 = this._errorSafeExtensions.hasErrors(_get_2, true);
    Assert.assertFalse(_hasErrors_2);
    EList<XExpression> _expressions_3 = e.getExpressions();
    Procedure1<? super LoopParams> _loopInitializer = this.getLoopInitializer();
    final Procedure2<XExpression,ITreeAppendable> _function = new Procedure2<XExpression,ITreeAppendable>() {
        public void apply(final XExpression it, final ITreeAppendable app2) {
          String _text = ErrorSafeExtensionsTest.this.getText(it);
          app2.append(_text);
        }
      };
    this._errorSafeExtensions.<XExpression>forEachSafely(app, _expressions_3, _loopInitializer, _function);
    String _content = app.getContent();
    Assert.assertEquals("(/* error */val x=42:val y=42)", _content);
  }
  
  @Test
  public void testAppendForEachSafely_1() {
    XExpression _validatedExpression = this.validatedExpression("{ val x=42 error val y=42 }");
    final XBlockExpression e = ((XBlockExpression) _validatedExpression);
    final TreeAppendable app = this.createTreeAppendable(e);
    EList<XExpression> _expressions = e.getExpressions();
    XExpression _get = _expressions.get(0);
    boolean _hasErrors = this._errorSafeExtensions.hasErrors(_get, true);
    Assert.assertFalse(_hasErrors);
    EList<XExpression> _expressions_1 = e.getExpressions();
    XExpression _get_1 = _expressions_1.get(1);
    boolean _hasErrors_1 = this._errorSafeExtensions.hasErrors(_get_1, true);
    Assert.assertTrue(_hasErrors_1);
    EList<XExpression> _expressions_2 = e.getExpressions();
    XExpression _get_2 = _expressions_2.get(2);
    boolean _hasErrors_2 = this._errorSafeExtensions.hasErrors(_get_2, true);
    Assert.assertFalse(_hasErrors_2);
    EList<XExpression> _expressions_3 = e.getExpressions();
    Procedure1<? super LoopParams> _loopInitializer = this.getLoopInitializer();
    final Procedure2<XExpression,ITreeAppendable> _function = new Procedure2<XExpression,ITreeAppendable>() {
        public void apply(final XExpression it, final ITreeAppendable app2) {
          String _text = ErrorSafeExtensionsTest.this.getText(it);
          app2.append(_text);
        }
      };
    this._errorSafeExtensions.<XExpression>forEachSafely(app, _expressions_3, _loopInitializer, _function);
    String _content = app.getContent();
    Assert.assertEquals("(val x=42/* :error */:val y=42)", _content);
  }
  
  @Test
  public void testAppendForEachSafely_2() {
    XExpression _validatedExpression = this.validatedExpression("{ val x=42 val y=42 error }");
    final XBlockExpression e = ((XBlockExpression) _validatedExpression);
    final TreeAppendable app = this.createTreeAppendable(e);
    EList<XExpression> _expressions = e.getExpressions();
    XExpression _get = _expressions.get(0);
    boolean _hasErrors = this._errorSafeExtensions.hasErrors(_get, true);
    Assert.assertFalse(_hasErrors);
    EList<XExpression> _expressions_1 = e.getExpressions();
    XExpression _get_1 = _expressions_1.get(1);
    boolean _hasErrors_1 = this._errorSafeExtensions.hasErrors(_get_1, true);
    Assert.assertFalse(_hasErrors_1);
    EList<XExpression> _expressions_2 = e.getExpressions();
    XExpression _get_2 = _expressions_2.get(2);
    boolean _hasErrors_2 = this._errorSafeExtensions.hasErrors(_get_2, true);
    Assert.assertTrue(_hasErrors_2);
    EList<XExpression> _expressions_3 = e.getExpressions();
    Procedure1<? super LoopParams> _loopInitializer = this.getLoopInitializer();
    final Procedure2<XExpression,ITreeAppendable> _function = new Procedure2<XExpression,ITreeAppendable>() {
        public void apply(final XExpression it, final ITreeAppendable app2) {
          String _text = ErrorSafeExtensionsTest.this.getText(it);
          app2.append(_text);
        }
      };
    this._errorSafeExtensions.<XExpression>forEachSafely(app, _expressions_3, _loopInitializer, _function);
    String _content = app.getContent();
    Assert.assertEquals("(val x=42:val y=42/* :error */)", _content);
  }
  
  @Test
  public void testAppendForEachSafely_3() {
    XExpression _validatedExpression = this.validatedExpression("{ error }");
    final XBlockExpression e = ((XBlockExpression) _validatedExpression);
    final TreeAppendable app = this.createTreeAppendable(e);
    EList<XExpression> _expressions = e.getExpressions();
    XExpression _get = _expressions.get(0);
    boolean _hasErrors = this._errorSafeExtensions.hasErrors(_get, true);
    Assert.assertTrue(_hasErrors);
    EList<XExpression> _expressions_1 = e.getExpressions();
    Procedure1<? super LoopParams> _loopInitializer = this.getLoopInitializer();
    final Procedure2<XExpression,ITreeAppendable> _function = new Procedure2<XExpression,ITreeAppendable>() {
        public void apply(final XExpression it, final ITreeAppendable app2) {
          String _text = ErrorSafeExtensionsTest.this.getText(it);
          app2.append(_text);
        }
      };
    this._errorSafeExtensions.<XExpression>forEachSafely(app, _expressions_1, _loopInitializer, _function);
    String _content = app.getContent();
    Assert.assertEquals("/* (error) */", _content);
  }
  
  @Test
  public void testAppendForEachSafely_4() {
    XExpression _validatedExpression = this.validatedExpression("{ error1 error2 }");
    final XBlockExpression e = ((XBlockExpression) _validatedExpression);
    final TreeAppendable app = this.createTreeAppendable(e);
    EList<XExpression> _expressions = e.getExpressions();
    XExpression _get = _expressions.get(0);
    boolean _hasErrors = this._errorSafeExtensions.hasErrors(_get, true);
    Assert.assertTrue(_hasErrors);
    EList<XExpression> _expressions_1 = e.getExpressions();
    XExpression _get_1 = _expressions_1.get(1);
    boolean _hasErrors_1 = this._errorSafeExtensions.hasErrors(_get_1, true);
    Assert.assertTrue(_hasErrors_1);
    EList<XExpression> _expressions_2 = e.getExpressions();
    Procedure1<? super LoopParams> _loopInitializer = this.getLoopInitializer();
    final Procedure2<XExpression,ITreeAppendable> _function = new Procedure2<XExpression,ITreeAppendable>() {
        public void apply(final XExpression it, final ITreeAppendable app2) {
          String _text = ErrorSafeExtensionsTest.this.getText(it);
          app2.append(_text);
        }
      };
    this._errorSafeExtensions.<XExpression>forEachSafely(app, _expressions_2, _loopInitializer, _function);
    String _content = app.getContent();
    Assert.assertEquals("/* (error1:error2) */", _content);
  }
  
  @Test
  public void testSerializeSafely() {
    XExpression _validatedExpression = this.validatedExpression("null as Unresolved");
    final XCastedExpression e = ((XCastedExpression) _validatedExpression);
    final TreeAppendable app = this.createTreeAppendable(e);
    boolean _hasErrors = this._errorSafeExtensions.hasErrors(e, true);
    Assert.assertTrue(_hasErrors);
    JvmTypeReference _type = e.getType();
    this._errorSafeExtensions.serializeSafely(_type, app);
    String _content = app.getContent();
    Assert.assertEquals("/* Unresolved */", _content);
  }
  
  @Test
  public void testSerializeSafely_1() {
    XExpression _validatedExpression = this.validatedExpression("null as Unresolved");
    final XCastedExpression e = ((XCastedExpression) _validatedExpression);
    final TreeAppendable app = this.createTreeAppendable(e);
    boolean _hasErrors = this._errorSafeExtensions.hasErrors(e, true);
    Assert.assertTrue(_hasErrors);
    JvmTypeReference _type = e.getType();
    this._errorSafeExtensions.serializeSafely(_type, "Object", app);
    String _content = app.getContent();
    Assert.assertEquals("/* Unresolved */Object", _content);
  }
  
  @Test
  public void testSerializeSafely_2() {
    XExpression _validatedExpression = this.validatedExpression("null as String");
    final XCastedExpression e = ((XCastedExpression) _validatedExpression);
    final TreeAppendable app = this.createTreeAppendable(e);
    boolean _hasErrors = this._errorSafeExtensions.hasErrors(e, true);
    Assert.assertFalse(_hasErrors);
    JvmTypeReference _type = e.getType();
    this._errorSafeExtensions.serializeSafely(_type, app);
    String _content = app.getContent();
    Assert.assertEquals("String", _content);
  }
  
  protected XExpression validatedExpression(final CharSequence model) {
    try {
      XExpression _xblockexpression = null;
      {
        final XExpression expression = this.expression(model, false);
        String _name = IElementIssueProvider.class.getName();
        Resource _eResource = expression.eResource();
        final Function0<IElementIssueProvider> _function = new Function0<IElementIssueProvider>() {
            public IElementIssueProvider apply() {
              IElementIssueProvider _xblockexpression = null;
              {
                Resource _eResource = expression.eResource();
                final List<Issue> issues = ErrorSafeExtensionsTest.this.resourceValidator.validate(_eResource, CheckMode.ALL, CancelIndicator.NullImpl);
                Resource _eResource_1 = expression.eResource();
                IElementIssueProvider _create = ErrorSafeExtensionsTest.this.issueProviderFactory.create(_eResource_1, issues);
                _xblockexpression = (_create);
              }
              return _xblockexpression;
            }
          };
        this.cache.<IElementIssueProvider>get(_name, _eResource, new Provider<IElementIssueProvider>() {
            public IElementIssueProvider get() {
              return _function.apply();
            }
        });
        _xblockexpression = (expression);
      }
      return _xblockexpression;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected TreeAppendable createTreeAppendable(final EObject source) {
    ImportManager _importManager = new ImportManager(true);
    TreeAppendable _treeAppendable = new TreeAppendable(_importManager, this.locationProvider, this.jvmModelAssociations, source, " ", "<newline>");
    return _treeAppendable;
  }
  
  protected String getText(final EObject object) {
    ICompositeNode _findActualNodeFor = NodeModelUtils.findActualNodeFor(object);
    String _text = _findActualNodeFor.getText();
    String _trim = _text.trim();
    return _trim;
  }
  
  protected Procedure1<? super LoopParams> getLoopInitializer() {
    final Procedure1<LoopParams> _function = new Procedure1<LoopParams>() {
        public void apply(final LoopParams it) {
          it.setPrefix("(");
          it.setSeparator(":");
          it.setSuffix(")");
        }
      };
    return _function;
  }
}
