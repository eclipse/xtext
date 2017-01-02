package org.eclipse.xtext.xbase.tests.compiler;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.generator.trace.ITraceURIConverter;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.ElementIssueProvider;
import org.eclipse.xtext.xbase.compiler.ErrorSafeExtensions;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.LoopParams;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.compiler.output.TreeAppendable;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
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
  private ElementIssueProvider.Factory issueProviderFactory;
  
  @Inject
  private ITraceURIConverter converter;
  
  @Inject
  @Extension
  private ErrorSafeExtensions _errorSafeExtensions;
  
  @Test
  public void testAppendForEachSafely() {
    XExpression _validatedExpression = this.validatedExpression("{ val x=42 val y=42 }");
    final XBlockExpression e = ((XBlockExpression) _validatedExpression);
    final TreeAppendable app = this.createTreeAppendable(e);
    Assert.assertFalse(this._errorSafeExtensions.hasErrors(e.getExpressions().get(0)));
    Assert.assertFalse(this._errorSafeExtensions.hasErrors(e.getExpressions().get(1)));
    final Procedure2<XExpression, ITreeAppendable> _function = (XExpression it, ITreeAppendable app2) -> {
      app2.append(this.getText(it));
    };
    this._errorSafeExtensions.<XExpression>forEachSafely(app, e.getExpressions(), this.getLoopInitializer(), _function);
    Assert.assertEquals("(val x=42:val y=42)", app.getContent());
  }
  
  @Test
  public void testAppendForEachSafely_0() {
    XExpression _validatedExpression = this.validatedExpression("{ error val x=42 val y=42 }");
    final XBlockExpression e = ((XBlockExpression) _validatedExpression);
    final TreeAppendable app = this.createTreeAppendable(e);
    Assert.assertTrue(this._errorSafeExtensions.hasErrors(e.getExpressions().get(0)));
    Assert.assertFalse(this._errorSafeExtensions.hasErrors(e.getExpressions().get(1)));
    Assert.assertFalse(this._errorSafeExtensions.hasErrors(e.getExpressions().get(2)));
    final Procedure2<XExpression, ITreeAppendable> _function = (XExpression it, ITreeAppendable app2) -> {
      app2.append(this.getText(it));
    };
    this._errorSafeExtensions.<XExpression>forEachSafely(app, e.getExpressions(), this.getLoopInitializer(), _function);
    Assert.assertEquals("(/* error */val x=42:val y=42)", app.getContent());
  }
  
  @Test
  public void testAppendForEachSafely_1() {
    XExpression _validatedExpression = this.validatedExpression("{ val x=42 error val y=42 }");
    final XBlockExpression e = ((XBlockExpression) _validatedExpression);
    final TreeAppendable app = this.createTreeAppendable(e);
    Assert.assertFalse(this._errorSafeExtensions.hasErrors(e.getExpressions().get(0)));
    Assert.assertTrue(this._errorSafeExtensions.hasErrors(e.getExpressions().get(1)));
    Assert.assertFalse(this._errorSafeExtensions.hasErrors(e.getExpressions().get(2)));
    final Procedure2<XExpression, ITreeAppendable> _function = (XExpression it, ITreeAppendable app2) -> {
      app2.append(this.getText(it));
    };
    this._errorSafeExtensions.<XExpression>forEachSafely(app, e.getExpressions(), this.getLoopInitializer(), _function);
    Assert.assertEquals("(val x=42/* :error */:val y=42)", app.getContent());
  }
  
  @Test
  public void testAppendForEachSafely_2() {
    XExpression _validatedExpression = this.validatedExpression("{ val x=42 val y=42 error }");
    final XBlockExpression e = ((XBlockExpression) _validatedExpression);
    final TreeAppendable app = this.createTreeAppendable(e);
    Assert.assertFalse(this._errorSafeExtensions.hasErrors(e.getExpressions().get(0)));
    Assert.assertFalse(this._errorSafeExtensions.hasErrors(e.getExpressions().get(1)));
    Assert.assertTrue(this._errorSafeExtensions.hasErrors(e.getExpressions().get(2)));
    final Procedure2<XExpression, ITreeAppendable> _function = (XExpression it, ITreeAppendable app2) -> {
      app2.append(this.getText(it));
    };
    this._errorSafeExtensions.<XExpression>forEachSafely(app, e.getExpressions(), this.getLoopInitializer(), _function);
    Assert.assertEquals("(val x=42:val y=42/* :error */)", app.getContent());
  }
  
  @Test
  public void testAppendForEachSafely_3() {
    XExpression _validatedExpression = this.validatedExpression("{ error }");
    final XBlockExpression e = ((XBlockExpression) _validatedExpression);
    final TreeAppendable app = this.createTreeAppendable(e);
    Assert.assertTrue(this._errorSafeExtensions.hasErrors(e.getExpressions().get(0)));
    final Procedure2<XExpression, ITreeAppendable> _function = (XExpression it, ITreeAppendable app2) -> {
      app2.append(this.getText(it));
    };
    this._errorSafeExtensions.<XExpression>forEachSafely(app, e.getExpressions(), this.getLoopInitializer(), _function);
    Assert.assertEquals("/* (error) */", app.getContent());
  }
  
  @Test
  public void testAppendForEachSafely_4() {
    XExpression _validatedExpression = this.validatedExpression("{ error1 error2 }");
    final XBlockExpression e = ((XBlockExpression) _validatedExpression);
    final TreeAppendable app = this.createTreeAppendable(e);
    Assert.assertTrue(this._errorSafeExtensions.hasErrors(e.getExpressions().get(0)));
    Assert.assertTrue(this._errorSafeExtensions.hasErrors(e.getExpressions().get(1)));
    final Procedure2<XExpression, ITreeAppendable> _function = (XExpression it, ITreeAppendable app2) -> {
      app2.append(this.getText(it));
    };
    this._errorSafeExtensions.<XExpression>forEachSafely(app, e.getExpressions(), this.getLoopInitializer(), _function);
    Assert.assertEquals("/* (error1:error2) */", app.getContent());
  }
  
  @Test
  public void testSerializeSafely() {
    XExpression _validatedExpression = this.validatedExpression("null as Unresolved");
    final XCastedExpression e = ((XCastedExpression) _validatedExpression);
    final TreeAppendable app = this.createTreeAppendable(e);
    Assert.assertTrue(this._errorSafeExtensions.hasErrors(e));
    this._errorSafeExtensions.serializeSafely(e.getType(), app);
    Assert.assertEquals("/* Unresolved */", app.getContent());
  }
  
  @Test
  public void testSerializeSafely_1() {
    XExpression _validatedExpression = this.validatedExpression("null as Unresolved");
    final XCastedExpression e = ((XCastedExpression) _validatedExpression);
    final TreeAppendable app = this.createTreeAppendable(e);
    Assert.assertTrue(this._errorSafeExtensions.hasErrors(e));
    this._errorSafeExtensions.serializeSafely(e.getType(), "Object", app);
    Assert.assertEquals("/* Unresolved */Object", app.getContent());
  }
  
  @Test
  public void testSerializeSafely_2() {
    XExpression _validatedExpression = this.validatedExpression("null as String");
    final XCastedExpression e = ((XCastedExpression) _validatedExpression);
    final TreeAppendable app = this.createTreeAppendable(e);
    Assert.assertFalse(this._errorSafeExtensions.hasErrors(e));
    this._errorSafeExtensions.serializeSafely(e.getType(), app);
    Assert.assertEquals("String", app.getContent());
  }
  
  protected XExpression validatedExpression(final CharSequence model) {
    try {
      XExpression _xblockexpression = null;
      {
        final XExpression expression = this.expression(model, false);
        this.issueProviderFactory.attachData(expression.eResource());
        _xblockexpression = expression;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected TreeAppendable createTreeAppendable(final EObject source) {
    ImportManager _importManager = new ImportManager(true);
    return new TreeAppendable(_importManager, this.converter, this.locationProvider, this.jvmModelAssociations, source, " ", "<newline>");
  }
  
  protected String getText(final EObject object) {
    return NodeModelUtils.findActualNodeFor(object).getText().trim();
  }
  
  protected Procedure1<? super LoopParams> getLoopInitializer() {
    final Procedure1<LoopParams> _function = (LoopParams it) -> {
      it.setPrefix("(");
      it.setSeparator(":");
      it.setSuffix(")");
    };
    return _function;
  }
}
