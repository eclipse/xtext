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
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;

@SuppressWarnings("all")
public class DomainmodelJvmModelInferrer extends AbstractModelInferrer {
  
  @Inject
  private JvmTypesBuilder _jvmTypesBuilder0;
  
  protected void _infer(final Entity e, final IAcceptor<JvmDeclaredType> acceptor) {
    String _name = e.getName();
    final Function1<JvmGenericType,Void> _function = new Function1<JvmGenericType,Void>() {
        public Void apply(final JvmGenericType it) {
          {
            JvmParameterizedTypeReference _superType = e.getSuperType();
            boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_superType, null);
            if (_operator_notEquals) {
              EList<JvmTypeReference> _superTypes = it.getSuperTypes();
              JvmParameterizedTypeReference _superType_1 = e.getSuperType();
              JvmTypeReference _cloneWithProxies = DomainmodelJvmModelInferrer.this._jvmTypesBuilder0.cloneWithProxies(_superType_1);
              CollectionExtensions.<JvmTypeReference>operator_add(_superTypes, _cloneWithProxies);
            }
            EList<Feature> _features = e.getFeatures();
            for (final Feature f : _features) {
              final Feature f_1 = f;
              boolean matched = false;
              if (!matched) {
                if (f_1 instanceof Property) {
                  final Property f_2 = (Property) f_1;
                  matched=true;
                  {
                    EList<JvmMember> _members = it.getMembers();
                    String _name_1 = f_2.getName();
                    JvmTypeReference _type = f_2.getType();
                    JvmField _field = DomainmodelJvmModelInferrer.this._jvmTypesBuilder0.toField(f_2, _name_1, _type);
                    CollectionExtensions.<JvmMember>operator_add(_members, _field);
                    EList<JvmMember> _members_1 = it.getMembers();
                    String _name_2 = f_2.getName();
                    JvmTypeReference _type_1 = f_2.getType();
                    JvmOperation _getter = DomainmodelJvmModelInferrer.this._jvmTypesBuilder0.toGetter(f_2, _name_2, _type_1);
                    CollectionExtensions.<JvmMember>operator_add(_members_1, _getter);
                    EList<JvmMember> _members_2 = it.getMembers();
                    String _name_3 = f_2.getName();
                    JvmTypeReference _type_2 = f_2.getType();
                    JvmOperation _setter = DomainmodelJvmModelInferrer.this._jvmTypesBuilder0.toSetter(f_2, _name_3, _type_2);
                    CollectionExtensions.<JvmMember>operator_add(_members_2, _setter);
                  }
                }
              }
              if (!matched) {
                if (f_1 instanceof Operation) {
                  final Operation f_3 = (Operation) f_1;
                  matched=true;
                  EList<JvmMember> _members_3 = it.getMembers();
                  String _name_4 = f_3.getName();
                  JvmTypeReference _type_3 = f_3.getType();
                  final Function1<JvmOperation,Void> _function_1 = new Function1<JvmOperation,Void>() {
                      public Void apply(final JvmOperation it_1) {
                        EList<JvmFormalParameter> _params = f_3.getParams();
                        for (final JvmFormalParameter p : _params) {
                          EList<JvmFormalParameter> _parameters = it_1.getParameters();
                          String _name_5 = p.getName();
                          JvmTypeReference _parameterType = p.getParameterType();
                          JvmFormalParameter _parameter = DomainmodelJvmModelInferrer.this._jvmTypesBuilder0.toParameter(p, _name_5, _parameterType);
                          _parameters.add(_parameter);
                        }
                        return null;
                      }
                    };
                  JvmOperation _method = DomainmodelJvmModelInferrer.this._jvmTypesBuilder0.toMethod(f_3, _name_4, _type_3, _function_1);
                  CollectionExtensions.<JvmMember>operator_add(_members_3, _method);
                }
              }
            }
          }
          return null;
        }
      };
    JvmGenericType _clazz = this._jvmTypesBuilder0.toClazz(e, _name, _function);
    acceptor.accept(_clazz);
  }
  
  public void infer(final EObject e, final IAcceptor<JvmDeclaredType> acceptor) {
    if ((e instanceof Entity)
         && (acceptor instanceof IAcceptor)) {
      _infer((Entity)e, (IAcceptor<JvmDeclaredType>)acceptor);
    } else if ((e instanceof EObject)
         && (acceptor instanceof IAcceptor)) {
      _infer((EObject)e, (IAcceptor<JvmDeclaredType>)acceptor);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(e, acceptor).toString());
    }
  }
}