package org.eclipse.xtext.example.domainmodel.jvmmodel;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.example.domainmodel.DomainmodelExtensions;
import org.eclipse.xtext.example.domainmodel.domainmodel.AbstractElement;
import org.eclipse.xtext.example.domainmodel.domainmodel.DomainModel;
import org.eclipse.xtext.example.domainmodel.domainmodel.Entity;
import org.eclipse.xtext.example.domainmodel.domainmodel.Feature;
import org.eclipse.xtext.example.domainmodel.domainmodel.Import;
import org.eclipse.xtext.example.domainmodel.domainmodel.Operation;
import org.eclipse.xtext.example.domainmodel.domainmodel.PackageDeclaration;
import org.eclipse.xtext.example.domainmodel.domainmodel.Property;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociator;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class DomainmodelJvmModelInferrer implements IJvmModelInferrer {
  
  @Inject
  private TypesFactory typesFactory;
  
  @Inject
  private IJvmModelAssociator jvmModelAssociator;
  
  @Inject
  private DomainmodelExtensions domainmodelExtensions;
  
  public List<JvmDeclaredType> inferJvmModel(final EObject sourceObject) {
    List<JvmDeclaredType> _xblockexpression = null;
    {
      this.jvmModelAssociator.disassociate(sourceObject);
      Iterable<JvmDeclaredType> _transform = this.transform(sourceObject);
      List<JvmDeclaredType> _list = IterableExtensions.<JvmDeclaredType>toList(_transform);
      _xblockexpression = (_list);
    }
    return _xblockexpression;
  }
  
  protected Iterable<JvmDeclaredType> _transform(final DomainModel model) {
    EList<AbstractElement> _elements = model.getElements();
    final Function1<AbstractElement,Iterable<JvmDeclaredType>> _function = new Function1<AbstractElement,Iterable<JvmDeclaredType>>() {
        public Iterable<JvmDeclaredType> apply(final AbstractElement e) {
          Iterable<JvmDeclaredType> _transform = DomainmodelJvmModelInferrer.this.transform(e);
          return _transform;
        }
      };
    List<Iterable<JvmDeclaredType>> _map = ListExtensions.<AbstractElement, Iterable<JvmDeclaredType>>map(_elements, _function);
    Iterable<JvmDeclaredType> _flatten = IterableExtensions.<JvmDeclaredType>flatten(_map);
    return _flatten;
  }
  
  protected Iterable<JvmDeclaredType> _transform(final PackageDeclaration packageDecl) {
    EList<AbstractElement> _elements = packageDecl.getElements();
    final Function1<AbstractElement,Iterable<JvmDeclaredType>> _function = new Function1<AbstractElement,Iterable<JvmDeclaredType>>() {
        public Iterable<JvmDeclaredType> apply(final AbstractElement e) {
          Iterable<JvmDeclaredType> _transform = DomainmodelJvmModelInferrer.this.transform(e);
          return _transform;
        }
      };
    List<Iterable<JvmDeclaredType>> _map = ListExtensions.<AbstractElement, Iterable<JvmDeclaredType>>map(_elements, _function);
    Iterable<JvmDeclaredType> _flatten = IterableExtensions.<JvmDeclaredType>flatten(_map);
    return _flatten;
  }
  
  protected Iterable<JvmDeclaredType> _transform(final Entity entity) {
    ArrayList<JvmDeclaredType> _xblockexpression = null;
    {
      JvmGenericType _createJvmGenericType = this.typesFactory.createJvmGenericType();
      final JvmGenericType jvmClass = _createJvmGenericType;
      String _name = entity.getName();
      jvmClass.setSimpleName(_name);
      String _packageName = this.domainmodelExtensions.packageName(entity);
      jvmClass.setPackageName(_packageName);
      this.jvmModelAssociator.associatePrimary(entity, jvmClass);
      jvmClass.setVisibility(JvmVisibility.PUBLIC);
      JvmParameterizedTypeReference _superType = entity.getSuperType();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_superType, null);
      if (_operator_notEquals) {
        EList<JvmTypeReference> _superTypes = jvmClass.getSuperTypes();
        JvmParameterizedTypeReference _superType_1 = entity.getSuperType();
        JvmParameterizedTypeReference _cloneWithProxies = EcoreUtil2.<JvmParameterizedTypeReference>cloneWithProxies(_superType_1);
        CollectionExtensions.<JvmParameterizedTypeReference>operator_add(_superTypes, _cloneWithProxies);
      }
      EList<Feature> _features = entity.getFeatures();
      for (Feature f : _features) {
        this.transform(f, jvmClass);
      }
      ArrayList<JvmDeclaredType> _newArrayList = CollectionLiterals.<JvmDeclaredType>newArrayList(((JvmDeclaredType) jvmClass));
      _xblockexpression = (_newArrayList);
    }
    return _xblockexpression;
  }
  
  protected Iterable<JvmDeclaredType> _transform(final Import importDecl) {
    List<JvmDeclaredType> _emptyList = CollectionLiterals.<JvmDeclaredType>emptyList();
    return _emptyList;
  }
  
  protected void _transform(final Property property, final JvmGenericType type) {
    {
      JvmField _createJvmField = this.typesFactory.createJvmField();
      final JvmField jvmField = _createJvmField;
      String _name = property.getName();
      jvmField.setSimpleName(_name);
      JvmParameterizedTypeReference _type = property.getType();
      JvmParameterizedTypeReference _cloneWithProxies = EcoreUtil2.<JvmParameterizedTypeReference>cloneWithProxies(_type);
      jvmField.setType(_cloneWithProxies);
      jvmField.setVisibility(JvmVisibility.PRIVATE);
      EList<JvmMember> _members = type.getMembers();
      CollectionExtensions.<JvmField>operator_add(_members, jvmField);
      this.jvmModelAssociator.associatePrimary(property, jvmField);
      JvmOperation _createJvmOperation = this.typesFactory.createJvmOperation();
      final JvmOperation jvmGetter = _createJvmOperation;
      String _name_1 = property.getName();
      String _firstUpper = StringExtensions.toFirstUpper(_name_1);
      String _operator_plus = StringExtensions.operator_plus("get", _firstUpper);
      jvmGetter.setSimpleName(_operator_plus);
      JvmParameterizedTypeReference _type_1 = property.getType();
      JvmParameterizedTypeReference _cloneWithProxies_1 = EcoreUtil2.<JvmParameterizedTypeReference>cloneWithProxies(_type_1);
      jvmGetter.setReturnType(_cloneWithProxies_1);
      jvmGetter.setVisibility(JvmVisibility.PUBLIC);
      EList<JvmMember> _members_1 = type.getMembers();
      CollectionExtensions.<JvmOperation>operator_add(_members_1, jvmGetter);
      this.jvmModelAssociator.associatePrimary(property, jvmGetter);
      JvmOperation _createJvmOperation_1 = this.typesFactory.createJvmOperation();
      final JvmOperation jvmSetter = _createJvmOperation_1;
      String _name_2 = property.getName();
      String _firstUpper_1 = StringExtensions.toFirstUpper(_name_2);
      String _operator_plus_1 = StringExtensions.operator_plus("set", _firstUpper_1);
      jvmSetter.setSimpleName(_operator_plus_1);
      JvmFormalParameter _createJvmFormalParameter = this.typesFactory.createJvmFormalParameter();
      final JvmFormalParameter parameter = _createJvmFormalParameter;
      String _name_3 = property.getName();
      String _firstUpper_2 = StringExtensions.toFirstUpper(_name_3);
      parameter.setName(_firstUpper_2);
      JvmParameterizedTypeReference _type_2 = property.getType();
      JvmParameterizedTypeReference _cloneWithProxies_2 = EcoreUtil2.<JvmParameterizedTypeReference>cloneWithProxies(_type_2);
      parameter.setParameterType(_cloneWithProxies_2);
      jvmSetter.setVisibility(JvmVisibility.PUBLIC);
      EList<JvmFormalParameter> _parameters = jvmSetter.getParameters();
      CollectionExtensions.<JvmFormalParameter>operator_add(_parameters, parameter);
      EList<JvmMember> _members_2 = type.getMembers();
      CollectionExtensions.<JvmOperation>operator_add(_members_2, jvmSetter);
      this.jvmModelAssociator.associatePrimary(property, jvmSetter);
    }
  }
  
  protected void _transform(final Operation operation, final JvmGenericType type) {
    {
      JvmOperation _createJvmOperation = this.typesFactory.createJvmOperation();
      final JvmOperation jvmOperation = _createJvmOperation;
      String _name = operation.getName();
      jvmOperation.setSimpleName(_name);
      JvmParameterizedTypeReference _type = operation.getType();
      JvmParameterizedTypeReference _cloneWithProxies = EcoreUtil2.<JvmParameterizedTypeReference>cloneWithProxies(_type);
      jvmOperation.setReturnType(_cloneWithProxies);
      EList<JvmFormalParameter> _parameters = jvmOperation.getParameters();
      EList<JvmFormalParameter> _params = operation.getParams();
      final Function1<JvmFormalParameter,JvmFormalParameter> _function = new Function1<JvmFormalParameter,JvmFormalParameter>() {
          public JvmFormalParameter apply(final JvmFormalParameter p) {
            JvmFormalParameter _cloneWithProxies_1 = EcoreUtil2.<JvmFormalParameter>cloneWithProxies(p);
            return _cloneWithProxies_1;
          }
        };
      List<JvmFormalParameter> _map = ListExtensions.<JvmFormalParameter, JvmFormalParameter>map(_params, _function);
      _parameters.addAll(_map);
      jvmOperation.setVisibility(JvmVisibility.PUBLIC);
      EList<JvmMember> _members = type.getMembers();
      CollectionExtensions.<JvmOperation>operator_add(_members, jvmOperation);
      this.jvmModelAssociator.associatePrimary(operation, jvmOperation);
    }
  }
  
  public Iterable<JvmDeclaredType> transform(final EObject entity) {
    if ((entity instanceof Entity)) {
      return _transform((Entity)entity);
    } else if ((entity instanceof Import)) {
      return _transform((Import)entity);
    } else if ((entity instanceof PackageDeclaration)) {
      return _transform((PackageDeclaration)entity);
    } else if ((entity instanceof DomainModel)) {
      return _transform((DomainModel)entity);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(entity).toString());
    }
  }
  
  public void transform(final Feature operation, final JvmGenericType type) {
    if ((operation instanceof Operation)
         && (type instanceof JvmGenericType)) {
      _transform((Operation)operation, (JvmGenericType)type);
    } else if ((operation instanceof Property)
         && (type instanceof JvmGenericType)) {
      _transform((Property)operation, (JvmGenericType)type);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(operation, type).toString());
    }
  }
}