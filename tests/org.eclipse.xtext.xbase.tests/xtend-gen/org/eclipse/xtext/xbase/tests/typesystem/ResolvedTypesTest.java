package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XbaseFactory;
import org.eclipse.xtext.xbase.junit.typesystem.PublicReentrantTypeResolver;
import org.eclipse.xtext.xbase.junit.typesystem.PublicResolvedTypes;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typesystem.internal.BaseUnboundTypeParameter;
import org.eclipse.xtext.xbase.typesystem.internal.RootUnboundTypeParameter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class ResolvedTypesTest extends AbstractXbaseTestCase {
  @Inject
  private PublicReentrantTypeResolver _resolver;
  
  public PublicReentrantTypeResolver getResolver() {
    return this._resolver;
  }
  
  public void setResolver(final PublicReentrantTypeResolver resolver) {
    this._resolver = resolver;
  }
  
  private TypesFactory typesFactory = TypesFactory.eINSTANCE;
  
  private XbaseFactory xbaseFactory = XbaseFactory.eINSTANCE;
  
  private PublicResolvedTypes _testMe;
  
  public PublicResolvedTypes getTestMe() {
    return this._testMe;
  }
  
  public void setTestMe(final PublicResolvedTypes testMe) {
    this._testMe = testMe;
  }
  
  @Before
  public void initResolvedTypes() {
    PublicReentrantTypeResolver _resolver = this.getResolver();
    PublicResolvedTypes _publicResolvedTypes = new PublicResolvedTypes(_resolver);
    this.setTestMe(_publicResolvedTypes);
  }
  
  @Test(expected = UnsupportedOperationException.class)
  public void testDiagnostics() {
    PublicResolvedTypes _testMe = this.getTestMe();
    _testMe.getQueuedDiagnostics();
  }
  
  @Test(expected = UnsupportedOperationException.class)
  public void testActualTypeArguments() {
    PublicResolvedTypes _testMe = this.getTestMe();
    _testMe.getActualTypeArguments(null);
  }
  
  @Test
  public void testCreateAndGetUnboundTypeParameter() {
    PublicResolvedTypes _testMe = this.getTestMe();
    XFeatureCall _createXFeatureCall = this.xbaseFactory.createXFeatureCall();
    JvmTypeParameter _createJvmTypeParameter = this.typesFactory.createJvmTypeParameter();
    final RootUnboundTypeParameter unbound = _testMe.createUnboundTypeParameter(_createXFeatureCall, _createJvmTypeParameter);
    PublicResolvedTypes _testMe_1 = this.getTestMe();
    Object _handle = unbound.getHandle();
    BaseUnboundTypeParameter _unboundTypeParameter = _testMe_1.getUnboundTypeParameter(_handle);
    Assert.assertSame(unbound, _unboundTypeParameter);
  }
  
  @Test(expected = IllegalStateException.class)
  public void testTryGetUnknownUnboundTypeParameter() {
    PublicResolvedTypes _testMe = this.getTestMe();
    _testMe.getUnboundTypeParameter("unknown handle");
  }
}
