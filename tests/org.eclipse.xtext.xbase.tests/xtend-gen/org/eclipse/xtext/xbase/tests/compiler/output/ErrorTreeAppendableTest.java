package org.eclipse.xtext.xbase.tests.compiler.output;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.generator.trace.ITraceURIConverter;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.output.ErrorTreeAppendable;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.compiler.output.TreeAppendable;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class ErrorTreeAppendableTest extends AbstractXbaseTestCase {
  @Inject
  private ILocationInFileProvider locationProvider;
  
  @Inject
  private IJvmModelAssociations jvmModelAssociations;
  
  @Inject
  private ITraceURIConverter converter;
  
  @Test
  public void testTraceChildIsSelf() {
    try {
      final XExpression e = this.expression("42");
      final ErrorTreeAppendable app = this.createErrorTreeAppendable(e);
      TreeAppendable _trace = app.trace(e);
      Assert.assertEquals(app, _trace);
      TreeAppendable _trace_1 = app.trace(e, true);
      Assert.assertEquals(app, _trace_1);
      ITreeAppendable _trace_2 = app.trace(e, XbasePackage.Literals.XNUMBER_LITERAL__VALUE, (-1));
      Assert.assertEquals(app, _trace_2);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAppendUnresolvedType() {
    try {
      XExpression _expression = this.expression("typeof(  \tUnresolved\n)");
      final XTypeLiteral e = ((XTypeLiteral) _expression);
      final ErrorTreeAppendable app = this.createErrorTreeAppendable(e);
      JvmType _type = e.getType();
      app.append(_type);
      String _content = app.getContent();
      Assert.assertEquals("Unresolved", _content);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public ErrorTreeAppendable createErrorTreeAppendable(final EObject source) {
    ImportManager _importManager = new ImportManager(true);
    TreeAppendable _treeAppendable = new TreeAppendable(_importManager, this.converter, this.locationProvider, this.jvmModelAssociations, source, " ", "<newline>");
    return _treeAppendable.errorChild();
  }
}
