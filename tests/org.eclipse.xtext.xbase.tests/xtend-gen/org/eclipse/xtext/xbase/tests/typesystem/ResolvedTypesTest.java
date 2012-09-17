package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import com.google.inject.Injector;
import java.util.List;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XbaseFactory;
import org.eclipse.xtext.xbase.junit.typesystem.PublicReentrantTypeResolver;
import org.eclipse.xtext.xbase.junit.typesystem.PublicResolvedTypes;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.tests.typesystem.AvoidDeprecatedTypeSystemStandaloneSetup;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class ResolvedTypesTest extends AbstractXbaseTestCase {
  private final static Injector batchInjector = new Function0<Injector>() {
    public Injector apply() {
      Injector _setup = AvoidDeprecatedTypeSystemStandaloneSetup.setup();
      return _setup;
    }
  }.apply();
  
  public Injector getInjector() {
    return ResolvedTypesTest.batchInjector;
  }
  
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
  
  @Test
  public void testActualTypeArguments() {
    PublicResolvedTypes _testMe = this.getTestMe();
    List<LightweightTypeReference> _actualTypeArguments = _testMe.getActualTypeArguments(null);
    boolean _isEmpty = _actualTypeArguments.isEmpty();
    Assert.assertTrue(_isEmpty);
  }
  
  @Test
  public void testCreateAndGetUnboundTypeParameter() {
    PublicResolvedTypes _testMe = this.getTestMe();
    XFeatureCall _createXFeatureCall = this.xbaseFactory.createXFeatureCall();
    JvmTypeParameter _createJvmTypeParameter = this.typesFactory.createJvmTypeParameter();
    final UnboundTypeReference unbound = _testMe.createUnboundTypeReference(_createXFeatureCall, _createJvmTypeParameter);
    PublicResolvedTypes _testMe_1 = this.getTestMe();
    Object _handle = unbound.getHandle();
    UnboundTypeReference _unboundTypeReference = _testMe_1.getUnboundTypeReference(_handle);
    Assert.assertSame(unbound, _unboundTypeReference);
  }
  
  @Test(expected = IllegalStateException.class)
  public void testTryGetUnknownUnboundTypeParameter() {
    PublicResolvedTypes _testMe = this.getTestMe();
    _testMe.getUnboundTypeReference("unknown handle");
  }
}
