package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractTypeArgumentTest;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.After;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class BatchTypeArgumentTest extends AbstractTypeArgumentTest {
  @Inject
  private IBatchTypeResolver typeResolver;
  
  private IResolvedTypes resolvedTypes;
  
  protected void resolveTypes(final XExpression expression) {
    IResolvedTypes _resolveTypes = this.typeResolver.resolveTypes(expression);
    this.resolvedTypes = _resolveTypes;
  }
  
  @After
  public void discardResolvedTypes() {
    this.resolvedTypes = null;
  }
  
  protected void hasTypeArguments(final XExpression expression, final String... typeArguments) {
    final List<LightweightTypeReference> actualTypeArguments = this.resolvedTypes.getActualTypeArguments(expression);
    int _size = ((List<String>)Conversions.doWrapArray(typeArguments)).size();
    int _size_1 = actualTypeArguments.size();
    Assert.assertEquals(_size, _size_1);
    final Procedure2<String,Integer> _function = new Procedure2<String,Integer>() {
        public void apply(final String typeArgument, final Integer i) {
          StringConcatenation _builder = new StringConcatenation();
          String _join = IterableExtensions.join(((Iterable<? extends Object>)Conversions.doWrapArray(typeArguments)), ", ");
          _builder.append(_join, "");
          _builder.append(" vs ");
          final Function1<LightweightTypeReference,String> _function = new Function1<LightweightTypeReference,String>() {
              public String apply(final LightweightTypeReference it) {
                String _simpleName = it.getSimpleName();
                return _simpleName;
              }
            };
          List<String> _map = ListExtensions.<LightweightTypeReference, String>map(actualTypeArguments, _function);
          String _join_1 = IterableExtensions.join(_map, ", ");
          _builder.append(_join_1, "");
          LightweightTypeReference _get = actualTypeArguments.get((i).intValue());
          String _simpleName = _get.getSimpleName();
          Assert.assertEquals(_builder.toString(), typeArgument, _simpleName);
        }
      };
    IterableExtensions.<String>forEach(((Iterable<String>)Conversions.doWrapArray(typeArguments)), _function);
  }
  
  @Test
  @Ignore(value = "Somebody uses the uses bound but should not")
  public void testMethodTypeParamInference_06() throws Exception {
    Assert.fail("Somebody uses the uper bound but should not");
  }
  
  @Test
  @Ignore(value = "Somebody uses the uses bound but should not")
  public void testMethodTypeParamInference_07() throws Exception {
    Assert.fail("Somebody uses the uper bound but should not");
  }
  
  @Test
  @Ignore(value = "Somebody uses the uses bound but should not")
  public void testMethodTypeParamInference_08() throws Exception {
    Assert.fail("Somebody uses the uper bound but should not");
  }
  
  @Test
  @Ignore(value = "Somebody uses the uses bound but should not")
  public void testMethodTypeParamInference_09() throws Exception {
    Assert.fail("Somebody uses the uses bound but should not");
  }
  
  @Test
  @Ignore(value = "Somebody uses the uses bound but should not")
  public void testClosure_03() throws Exception {
    Assert.fail("Somebody uses the uses bound but should not");
  }
  
  @Test
  @Ignore(value = "Somebody uses the uses bound but should not")
  public void testClosure_04() throws Exception {
    Assert.fail("Somebody uses the uses bound but should not");
  }
  
  @Test
  @Ignore(value = "Somebody uses the uses bound but should not")
  public void testFeatureCall_35() throws Exception {
    Assert.fail("Somebody uses the uses bound but should not");
  }
  
  @Test
  @Ignore(value = "Somebody uses the uses bound but should not")
  public void testFeatureCall_36() throws Exception {
    Assert.fail("Somebody uses the uses bound but should not");
  }
  
  @Test
  @Ignore(value = "Gosh this one is strange")
  public void testDeferredTypeArgumentResolution_065() throws Exception {
    Assert.fail("Gosh this one is strange");
  }
  
  @Test
  @Ignore(value = "Gosh this one is strange")
  public void testDeferredTypeArgumentResolution_131() throws Exception {
    Assert.fail("Gosh this one is strange");
  }
}
