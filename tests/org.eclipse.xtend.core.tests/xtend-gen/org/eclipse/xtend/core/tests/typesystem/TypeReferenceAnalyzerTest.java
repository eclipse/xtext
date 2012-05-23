package org.eclipse.xtend.core.tests.typesystem;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmDelegateTypeReference;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmMultiTypeReference;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmSynonymTypeReference;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.typesystem.util.TypeReferenceAnalyzer;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class TypeReferenceAnalyzerTest extends AbstractXtendTestCase {
  @Inject
  private TypeReferenceAnalyzer analyzer;
  
  @Inject
  private IXtendJvmAssociations _iXtendJvmAssociations;
  
  @Inject
  private TypesFactory typesFactory;
  
  public void refersTypeParameter(final String typeReference, final boolean expectation) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("def <T> void method(");
      _builder.append(typeReference, "");
      _builder.append(" p) {}");
      final CharSequence signature = _builder;
      String _string = signature.toString();
      final XtendFunction function = this.function(_string);
      final JvmOperation operation = this._iXtendJvmAssociations.getDirectlyInferredOperation(function);
      EList<JvmFormalParameter> _parameters = operation.getParameters();
      JvmFormalParameter _head = IterableExtensions.<JvmFormalParameter>head(_parameters);
      final JvmTypeReference reference = _head.getParameterType();
      EList<JvmTypeParameter> _typeParameters = operation.getTypeParameters();
      final JvmTypeParameter typeParam = IterableExtensions.<JvmTypeParameter>head(_typeParameters);
      boolean _isReferencedBy = this.analyzer.isReferencedBy(typeParam, reference);
      Assert.assertEquals(Boolean.valueOf(expectation), Boolean.valueOf(_isReferencedBy));
      final JvmDelegateTypeReference delegate = this.typesFactory.createJvmDelegateTypeReference();
      delegate.setDelegate(reference);
      boolean _isReferencedBy_1 = this.analyzer.isReferencedBy(typeParam, delegate);
      Assert.assertEquals(Boolean.valueOf(expectation), Boolean.valueOf(_isReferencedBy_1));
      final JvmMultiTypeReference multiType = this.typesFactory.createJvmMultiTypeReference();
      EList<JvmTypeReference> _references = multiType.getReferences();
      _references.add(reference);
      boolean _isReferencedBy_2 = this.analyzer.isReferencedBy(typeParam, multiType);
      Assert.assertEquals(Boolean.valueOf(expectation), Boolean.valueOf(_isReferencedBy_2));
      final JvmSynonymTypeReference synonym = this.typesFactory.createJvmSynonymTypeReference();
      EList<JvmTypeReference> _references_1 = synonym.getReferences();
      _references_1.add(reference);
      boolean _isReferencedBy_3 = this.analyzer.isReferencedBy(typeParam, synonym);
      Assert.assertEquals(Boolean.valueOf(expectation), Boolean.valueOf(_isReferencedBy_3));
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDirectReference() {
    this.refersTypeParameter("T", true);
  }
  
  @Test
  public void testNoReference() {
    this.refersTypeParameter("String", false);
  }
  
  @Test
  public void testReferencedInTypeArgument() {
    this.refersTypeParameter("java.util.List<T>", true);
  }
  
  @Test
  public void testReferencedInNestedTypeArgument() {
    this.refersTypeParameter("java.util.List<Iterable<T>>", true);
  }
  
  @Test
  public void testReferencedInTypeArgumentOfProxy() {
    this.refersTypeParameter("DoesNotExist<T>", true);
  }
  
  @Test
  public void testReferencedInWildcardExtends() {
    this.refersTypeParameter("java.util.List<? extends T>", true);
  }
  
  @Test
  public void testReferencedInWildcardSuper() {
    this.refersTypeParameter("java.util.List<? super T>", true);
  }
  
  @Test
  public void testReferencedInFunctionType_01() {
    this.refersTypeParameter("()=>T", true);
  }
  
  @Test
  public void testReferencedInFunctionType_02() {
    this.refersTypeParameter("(java.util.List<T>)=>String", true);
  }
}
