/**
 * Copyright (c) 2011, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.domainmodel.jvmmodel;

import com.google.inject.Inject;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.example.domainmodel.domainmodel.Entity;
import org.eclipse.xtext.example.domainmodel.domainmodel.Feature;
import org.eclipse.xtext.example.domainmodel.domainmodel.Operation;
import org.eclipse.xtext.example.domainmodel.domainmodel.Property;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociator;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class DomainmodelJvmModelInferrer extends AbstractModelInferrer {
  @Inject
  @Extension
  private JvmTypesBuilder _jvmTypesBuilder;

  @Inject
  @Extension
  private IQualifiedNameProvider _iQualifiedNameProvider;

  @Inject
  @Extension
  private DomainmodelJvmModelHelper _domainmodelJvmModelHelper;

  @Inject
  @Extension
  private IJvmModelAssociations _iJvmModelAssociations;

  @Inject
  @Extension
  private IJvmModelAssociator _iJvmModelAssociator;

  protected void _infer(final Entity entity, @Extension final IJvmDeclaredTypeAcceptor acceptor, final boolean prelinkingPhase) {
    final Procedure1<JvmGenericType> _function = (JvmGenericType it) -> {
      this._jvmTypesBuilder.setDocumentation(it, this._jvmTypesBuilder.getDocumentation(entity));
      this._jvmTypesBuilder.setSuperClass(it, entity.getSuperType());
      EList<JvmMember> _members = it.getMembers();
      final Procedure1<JvmConstructor> _function_1 = (JvmConstructor it_1) -> {
      };
      JvmConstructor _constructor = this._jvmTypesBuilder.toConstructor(entity, _function_1);
      this._jvmTypesBuilder.<JvmConstructor>operator_add(_members, _constructor);
      final JvmTypeReference procedureType = this._typeReferenceBuilder.typeRef(Procedure1.class, this._typeReferenceBuilder.typeRef(it));
      EList<JvmMember> _members_1 = it.getMembers();
      final Procedure1<JvmConstructor> _function_2 = (JvmConstructor it_1) -> {
        EList<JvmFormalParameter> _parameters = it_1.getParameters();
        JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(entity, "initializer", procedureType);
        this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            _builder.append("initializer.apply(this);");
            _builder.newLine();
          }
        };
        this._jvmTypesBuilder.setBody(it_1, _client);
      };
      JvmConstructor _constructor_1 = this._jvmTypesBuilder.toConstructor(entity, _function_2);
      this._jvmTypesBuilder.<JvmConstructor>operator_add(_members_1, _constructor_1);
      EList<Feature> _features = entity.getFeatures();
      for (final Feature f : _features) {
        boolean _matched = false;
        if (f instanceof Property) {
          _matched=true;
          final JvmField field = this._jvmTypesBuilder.toField(f, ((Property)f).getName(), ((Property)f).getType());
          EList<JvmMember> _members_2 = it.getMembers();
          this._jvmTypesBuilder.<JvmField>operator_add(_members_2, field);
          EList<JvmMember> _members_3 = it.getMembers();
          JvmOperation _getter = this._jvmTypesBuilder.toGetter(f, ((Property)f).getName(), ((Property)f).getType());
          this._jvmTypesBuilder.<JvmOperation>operator_add(_members_3, _getter);
          EList<JvmMember> _members_4 = it.getMembers();
          JvmOperation _setter = this._jvmTypesBuilder.toSetter(f, ((Property)f).getName(), ((Property)f).getType());
          this._jvmTypesBuilder.<JvmOperation>operator_add(_members_4, _setter);
        }
        if (!_matched) {
          if (f instanceof Operation) {
            _matched=true;
            EList<JvmMember> _members_2 = it.getMembers();
            String _name = ((Operation)f).getName();
            JvmTypeReference _elvis = null;
            JvmTypeReference _type = ((Operation)f).getType();
            if (_type != null) {
              _elvis = _type;
            } else {
              JvmTypeReference _inferredType = this._jvmTypesBuilder.inferredType();
              _elvis = _inferredType;
            }
            final Procedure1<JvmOperation> _function_3 = (JvmOperation it_1) -> {
              this._jvmTypesBuilder.setDocumentation(it_1, this._jvmTypesBuilder.getDocumentation(f));
              EList<JvmFormalParameter> _params = ((Operation)f).getParams();
              for (final JvmFormalParameter p : _params) {
                EList<JvmFormalParameter> _parameters = it_1.getParameters();
                JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(p, p.getName(), p.getParameterType());
                this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
              }
              this._jvmTypesBuilder.setBody(it_1, ((Operation)f).getBody());
            };
            JvmOperation _method = this._jvmTypesBuilder.toMethod(f, _name, _elvis, _function_3);
            this._jvmTypesBuilder.<JvmOperation>operator_add(_members_2, _method);
          }
        }
      }
      this.removeDuplicateGettersSetters(it);
      EList<JvmMember> _members_2 = it.getMembers();
      JvmOperation _toStringMethod = this._jvmTypesBuilder.toToStringMethod(entity, it);
      this._jvmTypesBuilder.<JvmOperation>operator_add(_members_2, _toStringMethod);
    };
    acceptor.<JvmGenericType>accept(this._jvmTypesBuilder.toClass(entity, this._iQualifiedNameProvider.getFullyQualifiedName(entity)), _function);
  }

  private void removeDuplicateGettersSetters(final JvmDeclaredType inferredType) {
    final Consumer<Collection<JvmOperation>> _function = (Collection<JvmOperation> jvmOperations) -> {
      final Function1<JvmOperation, Boolean> _function_1 = (JvmOperation it) -> {
        EObject _primarySourceElement = this._iJvmModelAssociations.getPrimarySourceElement(it);
        return Boolean.valueOf((_primarySourceElement instanceof Property));
      };
      final JvmOperation getterOrSetter = IterableExtensions.<JvmOperation>head(IterableExtensions.<JvmOperation>filter(jvmOperations, _function_1));
      if ((getterOrSetter != null)) {
        this._iJvmModelAssociator.removeAllAssociation(getterOrSetter.getReturnType());
        EList<JvmFormalParameter> _parameters = getterOrSetter.getParameters();
        for (final JvmFormalParameter p : _parameters) {
          {
            this._iJvmModelAssociator.removeAllAssociation(p.getParameterType());
            this._iJvmModelAssociator.removeAllAssociation(p);
          }
        }
        this._iJvmModelAssociator.removeAllAssociation(getterOrSetter);
        inferredType.getMembers().remove(getterOrSetter);
      }
    };
    this._domainmodelJvmModelHelper.handleDuplicateJvmOperations(inferredType, _function);
  }

  public void infer(final EObject entity, final IJvmDeclaredTypeAcceptor acceptor, final boolean prelinkingPhase) {
    if (entity instanceof Entity) {
      _infer((Entity)entity, acceptor, prelinkingPhase);
      return;
    } else if (entity != null) {
      _infer(entity, acceptor, prelinkingPhase);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(entity, acceptor, prelinkingPhase).toString());
    }
  }
}
