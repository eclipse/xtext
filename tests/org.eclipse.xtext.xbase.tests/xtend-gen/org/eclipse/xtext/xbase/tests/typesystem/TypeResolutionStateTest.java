package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.tests.typesystem.TypeResolutionTestData.NestedList;
import org.eclipse.xtext.xbase.typesystem.internal.LogicalContainerAwareReentrantTypeResolver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class TypeResolutionStateTest extends AbstractXbaseTestCase {
  @Inject
  private LogicalContainerAwareReentrantTypeResolver testMe;
  
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
  
  @Test
  public void testResolve_01() {
    final JvmType type = this.typeReferences.findDeclaredType(NestedList.class, this.resourceSet);
    this.testMe.initializeFrom(type);
    final JvmTypeReference resolveMe = this.typeReferences.getTypeForName(NestedList.class, type);
    final JvmTypeReference resolved = this.testMe.resolve(resolveMe);
    String _simpleName = resolved.getSimpleName();
    Assert.assertEquals("NestedList<T>", _simpleName);
  }
  
  @Test
  public void testResolve_02() {
    final JvmType type = this.typeReferences.findDeclaredType(NestedList.class, this.resourceSet);
    this.testMe.initializeFrom(type);
    final JvmTypeReference resolveMe = this.typeReferences.getTypeForName(List.class, type);
    final JvmTypeReference resolved = this.testMe.resolve(resolveMe);
    String _simpleName = resolved.getSimpleName();
    Assert.assertEquals("List<List<T>>", _simpleName);
  }
  
  @Test
  public void testResolve_03() {
    final JvmType type = this.typeReferences.findDeclaredType(NestedList.class, this.resourceSet);
    this.testMe.initializeFrom(type);
    final JvmTypeReference resolveMe = this.typeReferences.getTypeForName(Iterable.class, type);
    final JvmTypeReference resolved = this.testMe.resolve(resolveMe);
    String _simpleName = resolved.getSimpleName();
    Assert.assertEquals("Iterable<List<T>>", _simpleName);
  }
  
  @Test
  public void testResolve_04() {
    final JvmType type = this.typeReferences.findDeclaredType(NestedList.class, this.resourceSet);
    this.testMe.initializeFrom(type);
    final JvmTypeReference resolveMe = this.typeReferences.getTypeForName(Iterable.class, type);
    final JvmTypeReference resolved = this.testMe.resolve(resolveMe);
    String _simpleName = resolved.getSimpleName();
    Assert.assertEquals("Iterable<List<T>>", _simpleName);
  }
  
  @Test
  public void testResolve_05() {
    final JvmType type = this.typeReferences.findDeclaredType(RetentionPolicy.class, this.resourceSet);
    this.testMe.initializeFrom(type);
    final JvmTypeReference resolveMe = this.typeReferences.getTypeForName(Enum.class, type);
    final JvmTypeReference resolved = this.testMe.resolve(resolveMe);
    String _simpleName = resolved.getSimpleName();
    Assert.assertEquals("Enum<RetentionPolicy>", _simpleName);
  }
}
