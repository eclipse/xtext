package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.Map;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.tests.typesystem.TypeResolutionTestData.NestedList;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.typesystem.util.DeclaratorTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.MergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class TypeParameterSubstitutorTest extends AbstractXbaseTestCase {
  @Inject
  private CommonTypeComputationServices services;
  
  @Inject
  private TypeReferences typeReferences;
  
  private XtextResourceSet resourceSet;
  
  public void setUp() {
    try {
      super.setUp();
      XtextResourceSet _get = this.<XtextResourceSet>get(XtextResourceSet.class);
      this.resourceSet = _get;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @After
  public void tearDown() {
    this.resourceSet = null;
  }
  
  public JvmTypeReference resolve(final JvmTypeReference declaration, final JvmTypeReference reference) {
    DeclaratorTypeArgumentCollector _declaratorTypeArgumentCollector = new DeclaratorTypeArgumentCollector();
    final Map<JvmTypeParameter,MergedBoundTypeArgument> mapping = _declaratorTypeArgumentCollector.getTypeParameterMapping(declaration);
    TypeParameterSubstitutor _typeParameterSubstitutor = new TypeParameterSubstitutor(mapping, this.services);
    return _typeParameterSubstitutor.substitute(reference);
  }
  
  @Test
  public void testResolve_01() {
    final JvmTypeReference declaration = this.typeReferences.getTypeForName(NestedList.class, this.resourceSet);
    final JvmTypeReference resolveMe = declaration;
    final JvmTypeReference resolved = this.resolve(declaration, resolveMe);
    String _simpleName = resolved.getSimpleName();
    Assert.assertEquals("NestedList<T>", _simpleName);
  }
  
  @Test
  public void testResolve_02() {
    final JvmTypeReference declaration = this.typeReferences.getTypeForName(NestedList.class, this.resourceSet);
    final JvmTypeReference resolveMe = this.typeReferences.getTypeForName(List.class, this.resourceSet);
    final JvmTypeReference resolved = this.resolve(declaration, resolveMe);
    String _simpleName = resolved.getSimpleName();
    Assert.assertEquals("List<List<T>>", _simpleName);
  }
  
  @Test
  public void testResolve_03() {
    final JvmTypeReference declaration = this.typeReferences.getTypeForName(NestedList.class, this.resourceSet);
    final JvmTypeReference resolveMe = this.typeReferences.getTypeForName(Iterable.class, this.resourceSet);
    final JvmTypeReference resolved = this.resolve(declaration, resolveMe);
    String _simpleName = resolved.getSimpleName();
    Assert.assertEquals("Iterable<List<T>>", _simpleName);
  }
  
  @Test
  public void testResolve_04() {
    final JvmTypeReference declaration = this.typeReferences.getTypeForName(NestedList.class, this.resourceSet);
    final JvmTypeReference resolveMe = this.typeReferences.getTypeForName(Iterable.class, this.resourceSet);
    final JvmTypeReference resolved = this.resolve(declaration, resolveMe);
    String _simpleName = resolved.getSimpleName();
    Assert.assertEquals("Iterable<List<T>>", _simpleName);
  }
  
  @Test
  public void testResolve_05() {
    final JvmTypeReference declaration = this.typeReferences.getTypeForName(RetentionPolicy.class, this.resourceSet);
    final JvmTypeReference resolveMe = this.typeReferences.getTypeForName(Enum.class, this.resourceSet);
    final JvmTypeReference resolved = this.resolve(declaration, resolveMe);
    String _simpleName = resolved.getSimpleName();
    Assert.assertEquals("Enum<RetentionPolicy>", _simpleName);
  }
}
