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
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.example.domainmodel.domainmodel.Entity;
import org.eclipse.xtext.example.domainmodel.domainmodel.Feature;
import org.eclipse.xtext.example.domainmodel.domainmodel.Operation;
import org.eclipse.xtext.example.domainmodel.domainmodel.PackageDeclaration;
import org.eclipse.xtext.example.domainmodel.domainmodel.Property;
import org.eclipse.xtext.example.domainmodel.domainmodel.Visibility;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class DomainmodelJvmModelInferrer extends AbstractModelInferrer {
  @Inject
  private JvmTypesBuilder _jvmTypesBuilder;
  
  protected void _infer(final Entity e, final IAcceptor<JvmDeclaredType> acceptor, final boolean prelinkingPhase) {
    String _fullName = this.fullName(e);
    final Procedure1<JvmGenericType> _function = new Procedure1<JvmGenericType>() {
        public void apply(final JvmGenericType it) {
          {
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
              final Feature f_1 = f;
              boolean matched = false;
              if (!matched) {
                if (f_1 instanceof Property) {
                  final Property f_2 = (Property) f_1;
                  matched=true;
                  {
                    EList<JvmMember> _members = it.getMembers();
                    String _name = f_2.getName();
                    JvmTypeReference _type = f_2.getType();
                    JvmField _field = DomainmodelJvmModelInferrer.this._jvmTypesBuilder.toField(f_2, _name, _type);
                    CollectionExtensions.<JvmField>operator_add(_members, _field);
                    EList<JvmMember> _members_1 = it.getMembers();
                    String _name_1 = f_2.getName();
                    JvmTypeReference _type_1 = f_2.getType();
                    JvmOperation _getter = DomainmodelJvmModelInferrer.this._jvmTypesBuilder.toGetter(f_2, _name_1, _type_1);
                    CollectionExtensions.<JvmOperation>operator_add(_members_1, _getter);
                    EList<JvmMember> _members_2 = it.getMembers();
                    String _name_2 = f_2.getName();
                    JvmTypeReference _type_2 = f_2.getType();
                    JvmOperation _setter = DomainmodelJvmModelInferrer.this._jvmTypesBuilder.toSetter(f_2, _name_2, _type_2);
                    CollectionExtensions.<JvmOperation>operator_add(_members_2, _setter);
                  }
                }
              }
              if (!matched) {
                if (f_1 instanceof Operation) {
                  final Operation f_3 = (Operation) f_1;
                  matched=true;
                  EList<JvmMember> _members_3 = it.getMembers();
                  String _name_3 = f_3.getName();
                  JvmTypeReference _type_3 = f_3.getType();
                  final Procedure1<JvmOperation> _function = new Procedure1<JvmOperation>() {
                      public void apply(final JvmOperation it) {
                        {
                          Visibility _visibility = f_3.getVisibility();
                          JvmVisibility _jvm = DomainmodelJvmModelInferrer.this.toJvm(_visibility);
                          it.setVisibility(_jvm);
                          EList<JvmFormalParameter> _params = f_3.getParams();
                          for (final JvmFormalParameter p : _params) {
                            EList<JvmFormalParameter> _parameters = it.getParameters();
                            String _name = p.getName();
                            JvmTypeReference _parameterType = p.getParameterType();
                            JvmFormalParameter _parameter = DomainmodelJvmModelInferrer.this._jvmTypesBuilder.toParameter(p, _name, _parameterType);
                            _parameters.add(_parameter);
                          }
                          XExpression _body = f_3.getBody();
                          DomainmodelJvmModelInferrer.this._jvmTypesBuilder.setBody(it, _body);
                        }
                      }
                    };
                  JvmOperation _method = DomainmodelJvmModelInferrer.this._jvmTypesBuilder.toMethod(f_3, _name_3, _type_3, _function);
                  CollectionExtensions.<JvmOperation>operator_add(_members_3, _method);
                }
              }
            }
          }
        }
      };
    JvmGenericType _class = this._jvmTypesBuilder.toClass(e, _fullName, _function);
    acceptor.accept(_class);
  }
  
  public String fullName(final EObject x) {
    String _switchResult = null;
    final EObject x_1 = x;
    boolean matched = false;
    if (!matched) {
      if (x_1 instanceof Entity) {
        final Entity x_2 = (Entity) x_1;
        matched=true;
        EObject _eContainer = x_2.eContainer();
        String _fullName = this.fullName(_eContainer);
        String _name = x_2.getName();
        String _operator_plus = StringExtensions.operator_plus(_fullName, _name);
        _switchResult = _operator_plus;
      }
    }
    if (!matched) {
      if (x_1 instanceof PackageDeclaration) {
        final PackageDeclaration x_3 = (PackageDeclaration) x_1;
        matched=true;
        EObject _eContainer_1 = x_3.eContainer();
        String _fullName_1 = this.fullName(_eContainer_1);
        String _name_1 = x_3.getName();
        String _operator_plus_1 = StringExtensions.operator_plus(_fullName_1, _name_1);
        String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, ".");
        _switchResult = _operator_plus_2;
      }
    }
    if (!matched) {
      _switchResult = "";
    }
    return _switchResult;
  }
  
  public JvmVisibility toJvm(final Visibility visibility) {
    JvmVisibility _switchResult = null;
    final Visibility visibility_1 = visibility;
    boolean matched = false;
    if (!matched) {
      if (ObjectExtensions.operator_equals(visibility_1,Visibility.PRIVATE)) {
        matched=true;
        _switchResult = JvmVisibility.PRIVATE;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(visibility_1,Visibility.PROTECTED)) {
        matched=true;
        _switchResult = JvmVisibility.PROTECTED;
      }
    }
    if (!matched) {
      _switchResult = JvmVisibility.PUBLIC;
    }
    return _switchResult;
  }
  
  public void infer(final EObject e, final IAcceptor<JvmDeclaredType> acceptor, final boolean prelinkingPhase) {
    if ((e instanceof Entity)) {
      _infer((Entity)e, (IAcceptor<JvmDeclaredType>)acceptor, (Boolean)prelinkingPhase);
    } else {
      _infer((EObject)e, (IAcceptor<JvmDeclaredType>)acceptor, (Boolean)prelinkingPhase);
    }
  }
}
