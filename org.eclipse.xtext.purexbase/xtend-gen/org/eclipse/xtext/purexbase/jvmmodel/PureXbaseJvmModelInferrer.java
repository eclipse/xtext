/**
 * Copyright (c) 2011, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.purexbase.jvmmodel;

import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.purexbase.pureXbase.Model;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * <p>Infers a JVM model from the source model.</p>
 * 
 * <p>The JVM model should contain all elements that would appear in the Java code
 * which is generated from the source model.
 * Other Xtend models link against the JVM model rather than the source model. The JVM
 * model elements should be associated with their source element by means of the
 * {@link org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociator}.</p>
 */
@SuppressWarnings("all")
public class PureXbaseJvmModelInferrer extends AbstractModelInferrer {
  @Inject
  @Extension
  private JvmTypesBuilder _jvmTypesBuilder;

  protected void _infer(final Model m, final IJvmDeclaredTypeAcceptor acceptor, final boolean prelinkingPhase) {
    final XBlockExpression e = m.getBlock();
    final Procedure1<JvmGenericType> _function = (JvmGenericType it) -> {
      EList<JvmMember> _members = it.getMembers();
      final Procedure1<JvmOperation> _function_1 = (JvmOperation it_1) -> {
        EList<JvmTypeReference> _exceptions = it_1.getExceptions();
        JvmTypeReference _typeRef = this._typeReferenceBuilder.typeRef(Throwable.class);
        this._jvmTypesBuilder.<JvmTypeReference>operator_add(_exceptions, _typeRef);
        this._jvmTypesBuilder.setBody(it_1, e);
      };
      JvmOperation _method = this._jvmTypesBuilder.toMethod(e, "myMethod", this._jvmTypesBuilder.inferredType(), _function_1);
      this._jvmTypesBuilder.<JvmOperation>operator_add(_members, _method);
    };
    acceptor.<JvmGenericType>accept(this._jvmTypesBuilder.toClass(e, this.name(e.eResource())), _function);
  }

  public String name(final Resource res) {
    final String s = res.getURI().lastSegment();
    int _length = s.length();
    int _length_1 = ".xbase".length();
    int _minus = (_length - _length_1);
    return s.substring(0, _minus);
  }

  public void infer(final EObject m, final IJvmDeclaredTypeAcceptor acceptor, final boolean prelinkingPhase) {
    if (m instanceof Model) {
      _infer((Model)m, acceptor, prelinkingPhase);
      return;
    } else if (m != null) {
      _infer(m, acceptor, prelinkingPhase);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(m, acceptor, prelinkingPhase).toString());
    }
  }
}
