package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XbaseFactory;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractTypeResolverTest;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public abstract class AbstractBatchTypeResolverTest extends AbstractTypeResolverTest<LightweightTypeReference> {
  public LightweightTypeReference resolvesTo(final String expression, final String type) {
    try {
      String _replace = expression.replace("$$", "org::eclipse::xtext::xbase::lib::");
      final XExpression xExpression = this.expression(_replace, false);
      IBatchTypeResolver _typeResolver = this.getTypeResolver();
      final IResolvedTypes resolvedTypes = _typeResolver.resolveTypes(xExpression);
      final LightweightResolvedTypes lightweightResolvedTypes = ((LightweightResolvedTypes) resolvedTypes);
      final JvmTypeReference resolvedType = resolvedTypes.getActualType(xExpression);
      String _simpleName = resolvedType.getSimpleName();
      Assert.assertEquals(type, _simpleName);
      final LightweightTypeReference lightweight = lightweightResolvedTypes.internalGetActualType(xExpression);
      String _simpleName_1 = lightweight.getSimpleName();
      Assert.assertEquals(type, _simpleName_1);
      TreeIterator<EObject> _eAllContents = xExpression.eAllContents();
      Iterable<EObject> _iterable = IteratorExtensions.<EObject>toIterable(_eAllContents);
      for (final EObject content : _iterable) {
        boolean _matched = false;
        if (!_matched) {
          if (content instanceof XSwitchExpression) {
            final XSwitchExpression _xSwitchExpression = (XSwitchExpression)content;
            _matched=true;
            this.assertExpressionTypeIsResolved(_xSwitchExpression, lightweightResolvedTypes);
            String _localVarName = _xSwitchExpression.getLocalVarName();
            boolean _notEquals = (!Objects.equal(_localVarName, null));
            if (_notEquals) {
              this.assertIdentifiableTypeIsResolved(_xSwitchExpression, lightweightResolvedTypes);
            }
          }
        }
        if (!_matched) {
          if (content instanceof XExpression) {
            final XExpression _xExpression = (XExpression)content;
            _matched=true;
            this.assertExpressionTypeIsResolved(_xExpression, lightweightResolvedTypes);
          }
        }
        if (!_matched) {
          if (content instanceof XCasePart) {
            final XCasePart _xCasePart = (XCasePart)content;
            _matched=true;
          }
        }
        if (!_matched) {
          if (content instanceof JvmIdentifiableElement) {
            final JvmIdentifiableElement _jvmIdentifiableElement = (JvmIdentifiableElement)content;
            _matched=true;
            this.assertIdentifiableTypeIsResolved(_jvmIdentifiableElement, lightweightResolvedTypes);
          }
        }
      }
      return lightweight;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void isFunctionAndEquivalentTo(final LightweightTypeReference reference, final String type) {
    Assert.assertTrue((reference instanceof FunctionTypeReference));
    String _equivalent = this.getEquivalent(((FunctionTypeReference) reference));
    Assert.assertEquals(type, _equivalent);
  }
  
  public String getEquivalent(final ParameterizedTypeReference type) {
    StringConcatenation _builder = new StringConcatenation();
    JvmType _type = type.getType();
    String _simpleName = _type.getSimpleName();
    _builder.append(_simpleName, "");
    _builder.append("<");
    List<LightweightTypeReference> _typeArguments = type.getTypeArguments();
    final Function1<LightweightTypeReference,String> _function = new Function1<LightweightTypeReference,String>() {
        public String apply(final LightweightTypeReference it) {
          String _simpleName = it.getSimpleName();
          return _simpleName;
        }
      };
    String _join = IterableExtensions.<LightweightTypeReference>join(_typeArguments, ", ", _function);
    _builder.append(_join, "");
    _builder.append(">");
    return _builder.toString();
  }
  
  public void assertExpressionTypeIsResolved(final XExpression expression, final LightweightResolvedTypes types) {
    final LightweightTypeReference type = types.internalGetActualType(expression);
    String _string = expression.toString();
    Assert.assertNotNull(_string, type);
    String _string_1 = expression.toString();
    String _plus = (_string_1 + " / ");
    String _plus_1 = (_plus + type);
    String _identifier = type.getIdentifier();
    Assert.assertNotNull(_plus_1, _identifier);
  }
  
  public void assertIdentifiableTypeIsResolved(final JvmIdentifiableElement identifiable, final LightweightResolvedTypes types) {
    final LightweightTypeReference type = types.internalGetActualType(identifiable);
    String _string = identifiable.toString();
    Assert.assertNotNull(_string, type);
    String _string_1 = identifiable.toString();
    String _plus = (_string_1 + " / ");
    String _plus_1 = (_plus + type);
    String _identifier = type.getIdentifier();
    Assert.assertNotNull(_plus_1, _identifier);
  }
  
  public abstract IBatchTypeResolver getTypeResolver();
  
  @Test
  public void testNull() throws Exception {
    IBatchTypeResolver _typeResolver = this.getTypeResolver();
    final IResolvedTypes typeResolution = _typeResolver.resolveTypes(null);
    Assert.assertNotNull(typeResolution);
    Assert.assertEquals(IResolvedTypes.NULL, typeResolution);
  }
  
  @Test
  public void testProxy() throws Exception {
    final XFeatureCall proxy = XbaseFactory.eINSTANCE.createXFeatureCall();
    URI _createURI = URI.createURI("path#fragment");
    ((InternalEObject) proxy).eSetProxyURI(_createURI);
    IBatchTypeResolver _typeResolver = this.getTypeResolver();
    final IResolvedTypes typeResolution = _typeResolver.resolveTypes(proxy);
    Assert.assertNotNull(typeResolution);
    Assert.assertEquals(IResolvedTypes.NULL, typeResolution);
  }
}
