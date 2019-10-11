/**
 * Copyright (c) 2016, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.domainmodel.validation;

import com.google.common.base.Objects;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.example.domainmodel.domainmodel.DomainmodelPackage;
import org.eclipse.xtext.example.domainmodel.domainmodel.Entity;
import org.eclipse.xtext.example.domainmodel.domainmodel.Feature;
import org.eclipse.xtext.example.domainmodel.domainmodel.Operation;
import org.eclipse.xtext.example.domainmodel.domainmodel.PackageDeclaration;
import org.eclipse.xtext.example.domainmodel.domainmodel.Property;
import org.eclipse.xtext.example.domainmodel.validation.AbstractDomainmodelValidator;
import org.eclipse.xtext.example.domainmodel.validation.IssueCodes;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedOperation;
import org.eclipse.xtext.xbase.typesystem.override.OverrideHelper;

/**
 * This class contains custom validation rules.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
@SuppressWarnings("all")
public class DomainmodelValidator extends AbstractDomainmodelValidator {
  @Inject
  @Extension
  private IJvmModelAssociations _iJvmModelAssociations;
  
  @Inject
  @Extension
  private OverrideHelper _overrideHelper;
  
  @Check
  public void checkTypeNameStartsWithCapital(final Entity entity) {
    boolean _isUpperCase = Character.isUpperCase(entity.getName().charAt(0));
    boolean _not = (!_isUpperCase);
    if (_not) {
      this.warning("Name should start with a capital", DomainmodelPackage.Literals.ABSTRACT_ELEMENT__NAME, 
        ValidationMessageAcceptor.INSIGNIFICANT_INDEX, IssueCodes.INVALID_TYPE_NAME, entity.getName());
    }
  }
  
  @Check
  public void checkFeatureNameStartsWithLowercase(final Feature feature) {
    boolean _isLowerCase = Character.isLowerCase(feature.getName().charAt(0));
    boolean _not = (!_isLowerCase);
    if (_not) {
      this.warning("Name should start with a lowercase", DomainmodelPackage.Literals.FEATURE__NAME, 
        ValidationMessageAcceptor.INSIGNIFICANT_INDEX, IssueCodes.INVALID_FEATURE_NAME, feature.getName());
    }
  }
  
  @Check
  public void checkPackage(final PackageDeclaration packages) {
    boolean _isEmpty = Strings.isEmpty(packages.getName());
    if (_isEmpty) {
      this.error("Name cannot be empty", DomainmodelPackage.Literals.ABSTRACT_ELEMENT__NAME);
    }
    String _name = packages.getName();
    boolean _equals = Objects.equal(_name, "java");
    if (_equals) {
      this.error("Invalid package name", DomainmodelPackage.Literals.ABSTRACT_ELEMENT__NAME);
    }
  }
  
  @Check
  public void checkPropertyNamesAreUnique(final Entity entity) {
    final Multimap<String, Property> name2properties = HashMultimap.<String, Property>create();
    final Function1<Property, Boolean> _function = (Property it) -> {
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(it.getName());
      return Boolean.valueOf((!_isNullOrEmpty));
    };
    final Consumer<Property> _function_1 = (Property it) -> {
      name2properties.put(it.getName(), it);
    };
    IterableExtensions.<Property>filter(Iterables.<Property>filter(entity.getFeatures(), Property.class), _function).forEach(_function_1);
    final Consumer<Collection<Property>> _function_2 = (Collection<Property> properties) -> {
      int _size = properties.size();
      boolean _greaterThan = (_size > 1);
      if (_greaterThan) {
        final Consumer<Property> _function_3 = (Property it) -> {
          String _name = it.getName();
          String _plus = ("Duplicate property " + _name);
          this.error(_plus, it, DomainmodelPackage.Literals.FEATURE__NAME, IssueCodes.DUPLICATE_PROPERTY);
        };
        properties.forEach(_function_3);
      }
    };
    name2properties.asMap().values().forEach(_function_2);
  }
  
  @Check
  public void checkOperationNamesAreUnique(final Entity entity) {
    final JvmGenericType inferredJavaClass = IterableExtensions.<JvmGenericType>head(Iterables.<JvmGenericType>filter(this._iJvmModelAssociations.getJvmElements(entity), JvmGenericType.class));
    final List<IResolvedOperation> methods = this._overrideHelper.getResolvedFeatures(inferredJavaClass).getDeclaredOperations();
    final Multimap<String, JvmOperation> signature2Declarations = HashMultimap.<String, JvmOperation>create();
    final Consumer<IResolvedOperation> _function = (IResolvedOperation it) -> {
      signature2Declarations.put(it.getResolvedErasureSignature(), it.getDeclaration());
    };
    methods.forEach(_function);
    final Consumer<Collection<JvmOperation>> _function_1 = (Collection<JvmOperation> jvmOperations) -> {
      int _size = jvmOperations.size();
      boolean _greaterThan = (_size > 1);
      if (_greaterThan) {
        final Function1<JvmOperation, EObject> _function_2 = (JvmOperation it) -> {
          return this._iJvmModelAssociations.getPrimarySourceElement(it);
        };
        final Iterable<Operation> operations = Iterables.<Operation>filter(IterableExtensions.<JvmOperation, EObject>map(jvmOperations, _function_2), Operation.class);
        final Consumer<Operation> _function_3 = (Operation it) -> {
          String _name = it.getName();
          String _plus = ("Duplicate operation " + _name);
          this.error(_plus, it, DomainmodelPackage.Literals.FEATURE__NAME, IssueCodes.DUPLICATE_OPERATION);
        };
        operations.forEach(_function_3);
      }
    };
    signature2Declarations.asMap().values().forEach(_function_1);
  }
}
