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
import org.eclipse.xtext.xbase.jvmmodel.JvmVisibilityExtension;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class DomainmodelJvmModelInferrer implements IJvmModelInferrer {
  @Inject private TypesFactory typesFactory;
  @Inject private IJvmModelAssociator iJvmModelAssociator;
  @Inject private JvmVisibilityExtension jvmVisibilityExtension;
  @Inject private DomainmodelExtensions domainmodelExtensions;
  
  public List<JvmDeclaredType> inferJvmModel(final EObject sourceObject) {
    List<JvmDeclaredType> _xblockexpression = null;
    {
      iJvmModelAssociator.disassociate(sourceObject);
      final EObject typeConverted_sourceObject = (EObject)sourceObject;
      Iterable<JvmDeclaredType> _transform = DomainmodelJvmModelInferrer.this.transform(typeConverted_sourceObject);
      List<JvmDeclaredType> _list = IterableExtensions.<JvmDeclaredType>toList(_transform);
      _xblockexpression = (_list);
    }
    return _xblockexpression;
  }
  
  public Iterable<JvmDeclaredType> _transform(final DomainModel model) {
    EList<AbstractElement> _elements = model.getElements();
    final Function1<AbstractElement,Iterable<JvmDeclaredType>> function = new Function1<AbstractElement,Iterable<JvmDeclaredType>>() {
        public Iterable<JvmDeclaredType> apply(AbstractElement e) {
          final AbstractElement typeConverted_e = (AbstractElement)e;
          Iterable<JvmDeclaredType> _transform = DomainmodelJvmModelInferrer.this.transform(typeConverted_e);
          return _transform;
        }
      };
    List<Iterable<JvmDeclaredType>> _map = ListExtensions.<AbstractElement, Iterable<JvmDeclaredType>>map(_elements, function);
    Iterable<JvmDeclaredType> _flatten = IterableExtensions.<JvmDeclaredType>flatten(_map);
    return _flatten;
  }
  
  public Iterable<JvmDeclaredType> _transform(final PackageDeclaration packageDecl) {
    EList<AbstractElement> _elements = packageDecl.getElements();
    final Function1<AbstractElement,Iterable<JvmDeclaredType>> function = new Function1<AbstractElement,Iterable<JvmDeclaredType>>() {
        public Iterable<JvmDeclaredType> apply(AbstractElement e) {
          final AbstractElement typeConverted_e = (AbstractElement)e;
          Iterable<JvmDeclaredType> _transform = DomainmodelJvmModelInferrer.this.transform(typeConverted_e);
          return _transform;
        }
      };
    List<Iterable<JvmDeclaredType>> _map = ListExtensions.<AbstractElement, Iterable<JvmDeclaredType>>map(_elements, function);
    Iterable<JvmDeclaredType> _flatten = IterableExtensions.<JvmDeclaredType>flatten(_map);
    return _flatten;
  }
  
  public Iterable<JvmDeclaredType> _transform(final Entity entity) {
    ArrayList<JvmDeclaredType> _xblockexpression = null;
    {
      JvmGenericType _createJvmGenericType = DomainmodelJvmModelInferrer.this.typesFactory.createJvmGenericType();
      final JvmGenericType jvmClass = _createJvmGenericType;
      String _name = entity.getName();
      jvmClass.setSimpleName(_name);
      final Entity typeConverted_entity = (Entity)entity;
      String _packageName = domainmodelExtensions.packageName(typeConverted_entity);
      jvmClass.setPackageName(_packageName);
      final Entity typeConverted_entity_1 = (Entity)entity;
      final JvmGenericType typeConverted_jvmClass = (JvmGenericType)jvmClass;
      iJvmModelAssociator.associatePrimary(typeConverted_entity_1, typeConverted_jvmClass);
      final JvmGenericType typeConverted_jvmClass_1 = (JvmGenericType)jvmClass;
      jvmVisibilityExtension.setPublic(typeConverted_jvmClass_1);
      EList<Feature> _features = entity.getFeatures();
      for (Feature f : _features) {
        DomainmodelJvmModelInferrer.this.transform(f, jvmClass);
      }
      ArrayList<JvmDeclaredType> _newArrayList = CollectionLiterals.<JvmDeclaredType>newArrayList(((org.eclipse.xtext.common.types.JvmDeclaredType) jvmClass));
      _xblockexpression = (_newArrayList);
    }
    return _xblockexpression;
  }
  
  public Iterable<JvmDeclaredType> _transform(final Import importDecl) {
    ArrayList<JvmDeclaredType> _newArrayList = CollectionLiterals.<JvmDeclaredType>newArrayList();
    return _newArrayList;
  }
  
  public Iterable<JvmDeclaredType> _transform(final Void nothing) {
    ArrayList<JvmDeclaredType> _newArrayList = CollectionLiterals.<JvmDeclaredType>newArrayList();
    return _newArrayList;
  }
  
  public void _transform(final Property property, final JvmGenericType type) {
    {
      JvmField _createJvmField = DomainmodelJvmModelInferrer.this.typesFactory.createJvmField();
      final JvmField jvmField = _createJvmField;
      final Property typeConverted_property = (Property)property;
      String _name = typeConverted_property.getName();
      jvmField.setSimpleName(_name);
      final Property typeConverted_property_1 = (Property)property;
      JvmParameterizedTypeReference _type = typeConverted_property_1.getType();
      JvmParameterizedTypeReference _cloneWithProxies = EcoreUtil2.<JvmParameterizedTypeReference>cloneWithProxies(_type);
      jvmField.setType(_cloneWithProxies);
      final JvmField typeConverted_jvmField = (JvmField)jvmField;
      jvmVisibilityExtension.setPrivate(typeConverted_jvmField);
      final JvmGenericType typeConverted_type = (JvmGenericType)type;
      EList<JvmMember> _members = typeConverted_type.getMembers();
      CollectionExtensions.<JvmField>operator_add(_members, jvmField);
      final Property typeConverted_property_2 = (Property)property;
      final JvmField typeConverted_jvmField_1 = (JvmField)jvmField;
      iJvmModelAssociator.associatePrimary(typeConverted_property_2, typeConverted_jvmField_1);
      JvmOperation _createJvmOperation = DomainmodelJvmModelInferrer.this.typesFactory.createJvmOperation();
      final JvmOperation jvmGetter = _createJvmOperation;
      final Property typeConverted_property_3 = (Property)property;
      String _name_1 = typeConverted_property_3.getName();
      String _firstUpper = StringExtensions.toFirstUpper(_name_1);
      String _operator_plus = StringExtensions.operator_plus("get", _firstUpper);
      jvmGetter.setSimpleName(_operator_plus);
      final Property typeConverted_property_4 = (Property)property;
      JvmParameterizedTypeReference _type_1 = typeConverted_property_4.getType();
      JvmParameterizedTypeReference _cloneWithProxies_1 = EcoreUtil2.<JvmParameterizedTypeReference>cloneWithProxies(_type_1);
      jvmGetter.setReturnType(_cloneWithProxies_1);
      final JvmOperation typeConverted_jvmGetter = (JvmOperation)jvmGetter;
      jvmVisibilityExtension.setPublic(typeConverted_jvmGetter);
      final JvmGenericType typeConverted_type_1 = (JvmGenericType)type;
      EList<JvmMember> _members_1 = typeConverted_type_1.getMembers();
      CollectionExtensions.<JvmOperation>operator_add(_members_1, jvmGetter);
      final Property typeConverted_property_5 = (Property)property;
      final JvmOperation typeConverted_jvmGetter_1 = (JvmOperation)jvmGetter;
      iJvmModelAssociator.associatePrimary(typeConverted_property_5, typeConverted_jvmGetter_1);
      JvmOperation _createJvmOperation_1 = DomainmodelJvmModelInferrer.this.typesFactory.createJvmOperation();
      final JvmOperation jvmSetter = _createJvmOperation_1;
      final Property typeConverted_property_6 = (Property)property;
      String _name_2 = typeConverted_property_6.getName();
      String _firstUpper_1 = StringExtensions.toFirstUpper(_name_2);
      String _operator_plus_1 = StringExtensions.operator_plus("set", _firstUpper_1);
      jvmSetter.setSimpleName(_operator_plus_1);
      JvmFormalParameter _createJvmFormalParameter = DomainmodelJvmModelInferrer.this.typesFactory.createJvmFormalParameter();
      final JvmFormalParameter parameter = _createJvmFormalParameter;
      final Property typeConverted_property_7 = (Property)property;
      String _name_3 = typeConverted_property_7.getName();
      String _firstUpper_2 = StringExtensions.toFirstUpper(_name_3);
      parameter.setName(_firstUpper_2);
      final Property typeConverted_property_8 = (Property)property;
      JvmParameterizedTypeReference _type_2 = typeConverted_property_8.getType();
      JvmParameterizedTypeReference _cloneWithProxies_2 = EcoreUtil2.<JvmParameterizedTypeReference>cloneWithProxies(_type_2);
      parameter.setParameterType(_cloneWithProxies_2);
      final JvmOperation typeConverted_jvmSetter = (JvmOperation)jvmSetter;
      jvmVisibilityExtension.setPublic(typeConverted_jvmSetter);
      final JvmOperation typeConverted_jvmSetter_1 = (JvmOperation)jvmSetter;
      EList<JvmFormalParameter> _parameters = typeConverted_jvmSetter_1.getParameters();
      CollectionExtensions.<JvmFormalParameter>operator_add(_parameters, parameter);
      final JvmGenericType typeConverted_type_2 = (JvmGenericType)type;
      EList<JvmMember> _members_2 = typeConverted_type_2.getMembers();
      CollectionExtensions.<JvmOperation>operator_add(_members_2, jvmSetter);
      final Property typeConverted_property_9 = (Property)property;
      final JvmOperation typeConverted_jvmSetter_2 = (JvmOperation)jvmSetter;
      iJvmModelAssociator.associatePrimary(typeConverted_property_9, typeConverted_jvmSetter_2);
    }
  }
  
  public void _transform(final Operation operation, final JvmGenericType type) {
    {
      JvmOperation _createJvmOperation = DomainmodelJvmModelInferrer.this.typesFactory.createJvmOperation();
      final JvmOperation jvmOperation = _createJvmOperation;
      final Operation typeConverted_operation = (Operation)operation;
      String _name = typeConverted_operation.getName();
      jvmOperation.setSimpleName(_name);
      final Operation typeConverted_operation_1 = (Operation)operation;
      JvmParameterizedTypeReference _type = typeConverted_operation_1.getType();
      JvmParameterizedTypeReference _cloneWithProxies = EcoreUtil2.<JvmParameterizedTypeReference>cloneWithProxies(_type);
      jvmOperation.setReturnType(_cloneWithProxies);
      final JvmOperation typeConverted_jvmOperation = (JvmOperation)jvmOperation;
      EList<JvmFormalParameter> _parameters = typeConverted_jvmOperation.getParameters();
      EList<JvmFormalParameter> _params = operation.getParams();
      final Function1<JvmFormalParameter,JvmFormalParameter> function = new Function1<JvmFormalParameter,JvmFormalParameter>() {
          public JvmFormalParameter apply(JvmFormalParameter p) {
            JvmFormalParameter _cloneWithProxies_1 = EcoreUtil2.<JvmFormalParameter>cloneWithProxies(p);
            return _cloneWithProxies_1;
          }
        };
      List<JvmFormalParameter> _map = ListExtensions.<JvmFormalParameter, JvmFormalParameter>map(_params, function);
      _parameters.addAll(_map);
      final JvmOperation typeConverted_jvmOperation_1 = (JvmOperation)jvmOperation;
      jvmVisibilityExtension.setPublic(typeConverted_jvmOperation_1);
      final JvmGenericType typeConverted_type = (JvmGenericType)type;
      EList<JvmMember> _members = typeConverted_type.getMembers();
      CollectionExtensions.<JvmOperation>operator_add(_members, jvmOperation);
      final Operation typeConverted_operation_2 = (Operation)operation;
      final JvmOperation typeConverted_jvmOperation_2 = (JvmOperation)jvmOperation;
      iJvmModelAssociator.associatePrimary(typeConverted_operation_2, typeConverted_jvmOperation_2);
    }
  }
  
  public Iterable<JvmDeclaredType> transform(final Object entity) {
    if ((entity instanceof Entity)) {
      return _transform((Entity)entity);
    } else if ((entity instanceof Import)) {
      return _transform((Import)entity);
    } else if ((entity instanceof PackageDeclaration)) {
      return _transform((PackageDeclaration)entity);
    } else if ((entity instanceof DomainModel)) {
      return _transform((DomainModel)entity);
    } else if ((entity == null)) {
      return _transform((Void)null);
    } else {
      throw new IllegalArgumentException();
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
      throw new IllegalArgumentException();
    }
  }
}