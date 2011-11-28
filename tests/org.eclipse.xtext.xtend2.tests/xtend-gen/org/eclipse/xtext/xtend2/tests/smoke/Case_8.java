package org.eclipse.xtext.xtend2.tests.smoke;

import com.google.inject.Inject;
import junit.framework.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit.util.ParseHelper;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class Case_8 {
  @Inject
  private ParseHelper<EObject> helper;
  
  @Inject
  private IQualifiedNameProvider qualifiedNameProvider;
  
  public EList<Diagnostic> getErrors(final EObject obj) {
    Resource _eResource = obj.eResource();
    EList<Diagnostic> _errors = _eResource.getErrors();
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
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Inject
  public void explicitName() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("com.acme.SimpleElement as FooBar {}");
      _builder.newLine();
      EObject _parseAcme = this.parseAcme(_builder);
      final EObject element = _parseAcme;
      QualifiedName _fullyQualifiedName = this.qualifiedNameProvider.getFullyQualifiedName(element);
      String _string = _fullyQualifiedName.toString();
      Assert.assertEquals("FooBar", _string);
  }
}
