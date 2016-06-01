package org.eclipse.xtext.idea.example.entities.jvmmodel;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.idea.example.entities.domainmodel.Entity;
import org.eclipse.xtext.idea.example.entities.domainmodel.Feature;
import org.eclipse.xtext.idea.example.entities.domainmodel.Operation;
import org.eclipse.xtext.idea.example.entities.domainmodel.Property;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class EntitiesJvmModelInferrer extends AbstractModelInferrer {
  @Inject
  @Extension
  private JvmTypesBuilder _jvmTypesBuilder;
  
  @Inject
  @Extension
  private IQualifiedNameProvider _iQualifiedNameProvider;
  
  protected void _infer(final Entity entity, @Extension final IJvmDeclaredTypeAcceptor acceptor, final boolean prelinkingPhase) {
    QualifiedName _fullyQualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(entity);
    JvmGenericType _class = this._jvmTypesBuilder.toClass(entity, _fullyQualifiedName);
    final Procedure1<JvmGenericType> _function = (JvmGenericType it) -> {
      String _documentation = this._jvmTypesBuilder.getDocumentation(entity);
      this._jvmTypesBuilder.setDocumentation(it, _documentation);
      JvmParameterizedTypeReference _superType = entity.getSuperType();
      boolean _notEquals = (!Objects.equal(_superType, null));
      if (_notEquals) {
        EList<JvmTypeReference> _superTypes = it.getSuperTypes();
        JvmParameterizedTypeReference _superType_1 = entity.getSuperType();
        JvmTypeReference _cloneWithProxies = this._jvmTypesBuilder.cloneWithProxies(_superType_1);
        this._jvmTypesBuilder.<JvmTypeReference>operator_add(_superTypes, _cloneWithProxies);
      }
      EList<JvmMember> _members = it.getMembers();
      final Procedure1<JvmConstructor> _function_1 = (JvmConstructor it_1) -> {
      };
      JvmConstructor _constructor = this._jvmTypesBuilder.toConstructor(entity, _function_1);
      this._jvmTypesBuilder.<JvmConstructor>operator_add(_members, _constructor);
      JvmTypeReference _typeRef = this._typeReferenceBuilder.typeRef(it);
      final JvmTypeReference procedureType = this._typeReferenceBuilder.typeRef(Procedure1.class, _typeRef);
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
          String _name = ((Property)f).getName();
          JvmTypeReference _type = ((Property)f).getType();
          final JvmField field = this._jvmTypesBuilder.toField(f, _name, _type);
          EList<JvmMember> _members_2 = it.getMembers();
          this._jvmTypesBuilder.<JvmField>operator_add(_members_2, field);
          EList<JvmMember> _members_3 = it.getMembers();
          String _name_1 = ((Property)f).getName();
          JvmTypeReference _type_1 = ((Property)f).getType();
          JvmOperation _getter = this._jvmTypesBuilder.toGetter(f, _name_1, _type_1);
          this._jvmTypesBuilder.<JvmOperation>operator_add(_members_3, _getter);
          EList<JvmMember> _members_4 = it.getMembers();
          String _name_2 = ((Property)f).getName();
          JvmTypeReference _type_2 = ((Property)f).getType();
          JvmOperation _setter = this._jvmTypesBuilder.toSetter(f, _name_2, _type_2);
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
              String _documentation_1 = this._jvmTypesBuilder.getDocumentation(f);
              this._jvmTypesBuilder.setDocumentation(it_1, _documentation_1);
              EList<JvmFormalParameter> _params = ((Operation)f).getParams();
              for (final JvmFormalParameter p : _params) {
                EList<JvmFormalParameter> _parameters = it_1.getParameters();
                String _name_1 = p.getName();
                JvmTypeReference _parameterType = p.getParameterType();
                JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(p, _name_1, _parameterType);
                this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
              }
              XExpression _body = ((Operation)f).getBody();
              this._jvmTypesBuilder.setBody(it_1, _body);
            };
            JvmOperation _method = this._jvmTypesBuilder.toMethod(f, _name, _elvis, _function_3);
            this._jvmTypesBuilder.<JvmOperation>operator_add(_members_2, _method);
          }
        }
      }
      EList<JvmMember> _members_2 = it.getMembers();
      JvmOperation _toStringMethod = this._jvmTypesBuilder.toToStringMethod(entity, it);
      this._jvmTypesBuilder.<JvmOperation>operator_add(_members_2, _toStringMethod);
    };
    acceptor.<JvmGenericType>accept(_class, _function);
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
