package org.eclipse.xtext.purexbase.jvmmodel;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;

@SuppressWarnings("all")
public class PureXbaseJvmModelInferrer implements IJvmModelInferrer {
  
  @Inject
  private JvmTypesBuilder _jvmTypesBuilder0;
  
  public void infer(final EObject e, final IAcceptor<JvmDeclaredType> acceptor) {
  }
}