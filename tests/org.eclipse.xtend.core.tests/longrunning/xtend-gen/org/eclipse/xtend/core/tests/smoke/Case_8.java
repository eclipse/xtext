package org.eclipse.xtend.core.tests.smoke;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;

@SuppressWarnings("all")
public class Case_8 {
  @Inject
  @Extension
  private ParseHelper<EObject> helper;
  
  @Inject
  @Extension
  private IQualifiedNameProvider qualifiedNameProvider;
  
  public EList<Resource.Diagnostic> getErrors(final EObject obj) {
    Resource _eResource = obj.eResource();
    EList<Resource.Diagnostic> _errors = _eResource.getErrors();
    return _errors;
  }
  
  public void resolve(final EObject obj) {
    Resource _eResource = obj.eResource();
    EcoreUtil.resolveAll(_eResource);
  }
  
  public EObject parseAcme(final CharSequence seq) {
    try {
      EObject _parse = this.helper.parse(seq);
      EList<EObject> _eContents = _parse.eContents();
      EObject _head = IterableExtensions.<EObject>head(_eContents);
      return _head;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Inject
  public void explicitName() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("com.acme.SimpleElement as FooBar {}");
    _builder.newLine();
    final EObject element = this.parseAcme(_builder);
    QualifiedName _fullyQualifiedName = this.qualifiedNameProvider.getFullyQualifiedName(element);
    String _string = _fullyQualifiedName.toString();
    Assert.assertEquals("FooBar", _string);
  }
  
  public <T1 extends Object> List<List<T1>> foo(final T1 t) {
    return null;
  }
}
