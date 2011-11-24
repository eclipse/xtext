package org.eclipse.xtext.example.domainmodel.jvmmodel;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.example.domainmodel.domainmodel.Entity;
import org.eclipse.xtext.example.domainmodel.domainmodel.Feature;
import org.eclipse.xtext.example.domainmodel.domainmodel.Operation;
import org.eclipse.xtext.example.domainmodel.domainmodel.Property;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class DomainmodelJvmModelInferrer extends AbstractModelInferrer {
  @Inject
  private JvmTypesBuilder _jvmTypesBuilder;
  
  @Inject
  private IQualifiedNameProvider _iQualifiedNameProvider;
  
  protected void _infer(final Entity e, final IAcceptor<JvmDeclaredType> acceptor, final boolean prelinkingPhase) {
    QualifiedName _fullyQualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(e);
    final Procedure1<JvmGenericType> _function = new Procedure1<JvmGenericType>() {
        public void apply(final JvmGenericType it) {
          {
            String _documentation = DomainmodelJvmModelInferrer.this._jvmTypesBuilder.getDocumentation(e);
            DomainmodelJvmModelInferrer.this._jvmTypesBuilder.setDocumentation(it, _documentation);
            JvmParameterizedTypeReference _superType = e.getSuperType();
            boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_superType, null);
            if (_operator_notEquals) {
              EList<JvmTypeReference> _superTypes = it.getSuperTypes();
              JvmParameterizedTypeReference _superType_1 = e.getSuperType();
              JvmTypeReference _cloneWithProxies = DomainmodelJvmModelInferrer.this._jvmTypesBuilder.cloneWithProxies(_superType_1);
              CollectionExtensions.<JvmTypeReference>operator_add(_superTypes, _cloneWithProxies);
            }
            EList<Feature> _features = e.getFeatures();
            for (final Feature f : _features) {
              boolean matched = false;
              if (!matched) {
                if (f instanceof Property) {
                  matched=true;
                  {
                    EList<JvmMember> _members = it.getMembers();
                    String _name = ((Property)f).getName();
                    JvmTypeReference _type = ((Property)f).getType();
                    JvmField _field = DomainmodelJvmModelInferrer.this._jvmTypesBuilder.toField(((Property)f), _name, _type);
                    CollectionExtensions.<JvmField>operator_add(_members, _field);
                    EList<JvmMember> _members_1 = it.getMembers();
                    String _name_1 = ((Property)f).getName();
                    JvmTypeReference _type_1 = ((Property)f).getType();
                    JvmOperation _getter = DomainmodelJvmModelInferrer.this._jvmTypesBuilder.toGetter(((Property)f), _name_1, _type_1);
                    CollectionExtensions.<JvmOperation>operator_add(_members_1, _getter);
                    EList<JvmMember> _members_2 = it.getMembers();
                    String _name_2 = ((Property)f).getName();
                    JvmTypeReference _type_2 = ((Property)f).getType();
                    JvmOperation _setter = DomainmodelJvmModelInferrer.this._jvmTypesBuilder.toSetter(((Property)f), _name_2, _type_2);
                    CollectionExtensions.<JvmOperation>operator_add(_members_2, _setter);
                  }
                }
              }
              if (!matched) {
                if (f instanceof Operation) {
                  matched=true;
                  EList<JvmMember> _members_3 = it.getMembers();
                  String _name_3 = ((Operation)f).getName();
                  JvmTypeReference _type_3 = ((Operation)f).getType();
                  final Procedure1<JvmOperation> _function = new Procedure1<JvmOperation>() {
                      public void apply(final JvmOperation it) {
                        {
                          String _documentation_1 = DomainmodelJvmModelInferrer.this._jvmTypesBuilder.getDocumentation(((Operation)f));
                          DomainmodelJvmModelInferrer.this._jvmTypesBuilder.setDocumentation(it, _documentation_1);
                          EList<JvmFormalParameter> _params = ((Operation)f).getParams();
                          for (final JvmFormalParameter p : _params) {
                            EList<JvmFormalParameter> _parameters = it.getParameters();
                            String _name_4 = p.getName();
                            JvmTypeReference _parameterType = p.getParameterType();
                            JvmFormalParameter _parameter = DomainmodelJvmModelInferrer.this._jvmTypesBuilder.toParameter(p, _name_4, _parameterType);
                            CollectionExtensions.<JvmFormalParameter>operator_add(_parameters, _parameter);
                          }
                          XExpression _body = ((Operation)f).getBody();
                          DomainmodelJvmModelInferrer.this._jvmTypesBuilder.setBody(it, _body);
                        }
                      }
                    };
                  JvmOperation _method = DomainmodelJvmModelInferrer.this._jvmTypesBuilder.toMethod(((Operation)f), _name_3, _type_3, _function);
                  CollectionExtensions.<JvmOperation>operator_add(_members_3, _method);
                }
              }
            }
          }
        }
      };
    JvmGenericType _class = this._jvmTypesBuilder.toClass(e, _fullyQualifiedName, _function);
    acceptor.accept(_class);
  }
  
  public void infer(final EObject e, final IAcceptor<JvmDeclaredType> acceptor, final boolean prelinkingPhase) {
    if (e instanceof Entity) {
      _infer((Entity)e, acceptor, prelinkingPhase);
    } else {
      _infer(e, acceptor, prelinkingPhase);
    }
  }
}
