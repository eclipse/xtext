package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import java.util.Map;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractTypeParameterSubstitutorTest;
import org.eclipse.xtext.xbase.typesystem.references.DeclaratorTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeParameterSubstitutor;
import org.eclipse.xtext.xbase.typesystem.references.TypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class LightweightTypeParameterSubstitutorTest extends AbstractTypeParameterSubstitutorTest implements TypeReferenceOwner {
  @Inject
  private CommonTypeComputationServices services;
  
  private OwnedConverter _ownedConverter = new Function0<OwnedConverter>() {
    public OwnedConverter apply() {
      OwnedConverter _ownedConverter = new OwnedConverter(LightweightTypeParameterSubstitutorTest.this);
      return _ownedConverter;
    }
  }.apply();
  
  public String resolve(final JvmTypeReference declaration, final JvmTypeReference reference) {
    DeclaratorTypeArgumentCollector _declaratorTypeArgumentCollector = new DeclaratorTypeArgumentCollector();
    LightweightTypeReference _lightweightReference = this._ownedConverter.toLightweightReference(declaration);
    final Map<JvmTypeParameter,LightweightMergedBoundTypeArgument> mapping = _declaratorTypeArgumentCollector.getTypeParameterMapping(_lightweightReference);
    StandardTypeParameterSubstitutor _standardTypeParameterSubstitutor = new StandardTypeParameterSubstitutor(mapping, this);
    LightweightTypeReference _lightweightReference_1 = this._ownedConverter.toLightweightReference(reference);
    LightweightTypeReference _substitute = _standardTypeParameterSubstitutor.substitute(_lightweightReference_1);
    return _substitute.toString();
  }
  
  public CommonTypeComputationServices getServices() {
    return this.services;
  }
}
