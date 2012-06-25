package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import java.util.Map;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractTypeParameterSubstitutorTest;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.typesystem.util.DeclaratorTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.MergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.util.StandardTypeParameterSubstitutor;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class TypeParameterSubstitutorTest extends AbstractTypeParameterSubstitutorTest {
  @Inject
  private CommonTypeComputationServices services;
  
  public String resolve(final JvmTypeReference declaration, final JvmTypeReference reference) {
    DeclaratorTypeArgumentCollector _declaratorTypeArgumentCollector = new DeclaratorTypeArgumentCollector();
    final Map<JvmTypeParameter,MergedBoundTypeArgument> mapping = _declaratorTypeArgumentCollector.getTypeParameterMapping(declaration);
    StandardTypeParameterSubstitutor _standardTypeParameterSubstitutor = new StandardTypeParameterSubstitutor(mapping, this.services);
    JvmTypeReference _substitute = _standardTypeParameterSubstitutor.substitute(reference);
    return _substitute.getSimpleName();
  }
}
