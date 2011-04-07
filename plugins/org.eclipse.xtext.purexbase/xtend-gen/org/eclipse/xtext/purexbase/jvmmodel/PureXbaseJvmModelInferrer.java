package org.eclipse.xtext.purexbase.jvmmodel;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociator;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class PureXbaseJvmModelInferrer implements IJvmModelInferrer {
  private final PureXbaseJvmModelInferrer _this = this;
  @com.google.inject.Inject private IJvmModelAssociator iJvmModelAssociator;
  
  public List<? extends JvmDeclaredType> inferJvmModel(final EObject sourceObject) {
    ArrayList<? extends JvmDeclaredType> _newArrayList = CollectionLiterals.<JvmDeclaredType>newArrayList();
    return _newArrayList;
  }
}