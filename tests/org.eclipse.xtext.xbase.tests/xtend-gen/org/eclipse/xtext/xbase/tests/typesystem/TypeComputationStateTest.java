package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.junit.typesystem.PublicReentrantTypeResolver;
import org.eclipse.xtext.xbase.junit.typesystem.PublicResolvedTypes;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions;
import org.eclipse.xtext.xbase.scoping.batch.IBatchScopeProvider;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputer;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;
import org.eclipse.xtext.xbase.typesystem.internal.ChildExpressionTypeComputationState;
import org.eclipse.xtext.xbase.typesystem.internal.ExpressionTypeComputationState;
import org.eclipse.xtext.xbase.typesystem.internal.ResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.internal.RootExpressionComputationState;
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class TypeComputationStateTest extends AbstractXbaseTestCase implements ITypeComputer {
  @Inject
  private PublicReentrantTypeResolver resolver;
  
  @Inject
  private ReflectExtensions _reflectExtensions;
  
  @Test
  public void testChildrenAddEntryForParent() {
    try {
      this.resolver.setTypeComputer(this);
      final XExpression expression = this.expression("{ null }");
      PublicResolvedTypes _publicResolvedTypes = new PublicResolvedTypes(this.resolver);
      final PublicResolvedTypes resolution = _publicResolvedTypes;
      AnyTypeReference _anyTypeReference = new AnyTypeReference(resolution);
      final AnyTypeReference any = _anyTypeReference;
      IBatchScopeProvider _batchScopeProvider = this.resolver.getBatchScopeProvider();
      Resource _eResource = expression.eResource();
      IFeatureScopeSession _newSession = _batchScopeProvider.newSession(_eResource);
      RootExpressionComputationState _rootExpressionComputationState = new RootExpressionComputationState(resolution, _newSession, expression, this.resolver, any);
      _rootExpressionComputationState.computeTypes();
      String _string = any.toString();
      JvmTypeReference _actualType = resolution.getActualType(expression);
      String _identifier = _actualType.getIdentifier();
      Assert.assertEquals(_string, _identifier);
      String _string_1 = any.toString();
      LightweightTypeReference _internalGetActualType = resolution.internalGetActualType(expression);
      String _string_2 = _internalGetActualType.toString();
      Assert.assertEquals(_string_1, _string_2);
      String _string_3 = any.toString();
      EList<EObject> _eContents = expression.eContents();
      EObject _head = IterableExtensions.<EObject>head(_eContents);
      JvmTypeReference _actualType_1 = resolution.getActualType(((XNullLiteral) _head));
      String _identifier_1 = _actualType_1.getIdentifier();
      Assert.assertEquals(_string_3, _identifier_1);
      String _string_4 = any.toString();
      EList<EObject> _eContents_1 = expression.eContents();
      EObject _head_1 = IterableExtensions.<EObject>head(_eContents_1);
      LightweightTypeReference _internalGetActualType_1 = resolution.internalGetActualType(((XNullLiteral) _head_1));
      String _string_5 = _internalGetActualType_1.toString();
      Assert.assertEquals(_string_4, _string_5);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void computeTypes(final XExpression expression, final ITypeComputationState state) {
    try {
      Assert.assertTrue("state is instanceof ExpressionTypeComputationState", (state instanceof ExpressionTypeComputationState));
      List<? extends ITypeExpectation> _immediateExpectations = state.getImmediateExpectations();
      ITypeExpectation _head = IterableExtensions.head(_immediateExpectations);
      final JvmTypeReference expectedType = _head.getExpectedType();
      if ((state instanceof ChildExpressionTypeComputationState)) {
        final ChildExpressionTypeComputationState casted = ((ChildExpressionTypeComputationState) state);
        final ResolvedTypes resolution = this._reflectExtensions.<ResolvedTypes>get(casted, "resolvedTypes");
        ExpressionTypeComputationState _get = this._reflectExtensions.<ExpressionTypeComputationState>get(casted, "parent");
        final ResolvedTypes parentResolution = this._reflectExtensions.<ResolvedTypes>get(_get, "resolvedTypes");
        EObject _eContainer = expression.eContainer();
        JvmTypeReference _actualType = parentResolution.getActualType(((XExpression) _eContainer));
        Assert.assertNull(_actualType);
        EObject _eContainer_1 = expression.eContainer();
        JvmTypeReference _actualType_1 = parentResolution.getActualType(((XExpression) _eContainer_1));
        Assert.assertNull(_actualType_1);
        state.acceptActualType(expectedType);
        JvmTypeReference _actualType_2 = parentResolution.getActualType(expression);
        Assert.assertNull(_actualType_2);
        String _identifier = expectedType.getIdentifier();
        JvmTypeReference _actualType_3 = resolution.getActualType(expression);
        String _identifier_1 = _actualType_3.getIdentifier();
        Assert.assertEquals(_identifier, _identifier_1);
        EObject _eContainer_2 = expression.eContainer();
        JvmTypeReference _actualType_4 = parentResolution.getActualType(((XExpression) _eContainer_2));
        Assert.assertNull(_actualType_4);
      } else {
        Assert.assertTrue((expression instanceof XBlockExpression));
        EList<EObject> _eContents = expression.eContents();
        EObject _head_1 = IterableExtensions.<EObject>head(_eContents);
        final XNullLiteral nullLiteral = ((XNullLiteral) _head_1);
        state.computeTypes(nullLiteral);
        final ResolvedTypes resolution_1 = this._reflectExtensions.<ResolvedTypes>get(state, "resolvedTypes");
        String _identifier_2 = expectedType.getIdentifier();
        JvmTypeReference _actualType_5 = resolution_1.getActualType(nullLiteral);
        String _identifier_3 = _actualType_5.getIdentifier();
        Assert.assertEquals(_identifier_2, _identifier_3);
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public JvmIdentifiableElement getRefinableCandidate(final XExpression expression, final ITypeComputationState state) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Unexpected!");
    throw _unsupportedOperationException;
  }
}
