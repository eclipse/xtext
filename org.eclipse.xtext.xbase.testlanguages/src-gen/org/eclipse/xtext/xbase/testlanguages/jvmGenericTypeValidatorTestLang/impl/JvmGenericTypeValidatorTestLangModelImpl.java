/**
 * Copyright (c) 2011, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.JvmGenericTypeValidatorTestLangModel;
import org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.JvmGenericTypeValidatorTestLangPackage;
import org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyType;

import org.eclipse.xtext.xtype.XImportSection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.JvmGenericTypeValidatorTestLangModelImpl#getPackage <em>Package</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.JvmGenericTypeValidatorTestLangModelImpl#getImportSection <em>Import Section</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.JvmGenericTypeValidatorTestLangModelImpl#getModelTypes <em>Model Types</em>}</li>
 * </ul>
 *
 * @generated
 */
public class JvmGenericTypeValidatorTestLangModelImpl extends MinimalEObjectImpl.Container implements JvmGenericTypeValidatorTestLangModel
{
  /**
   * The default value of the '{@link #getPackage() <em>Package</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPackage()
   * @generated
   * @ordered
   */
  protected static final String PACKAGE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPackage() <em>Package</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPackage()
   * @generated
   * @ordered
   */
  protected String package_ = PACKAGE_EDEFAULT;

  /**
   * The cached value of the '{@link #getImportSection() <em>Import Section</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImportSection()
   * @generated
   * @ordered
   */
  protected XImportSection importSection;

  /**
   * The cached value of the '{@link #getModelTypes() <em>Model Types</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModelTypes()
   * @generated
   * @ordered
   */
  protected EList<MyType> modelTypes;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected JvmGenericTypeValidatorTestLangModelImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return JvmGenericTypeValidatorTestLangPackage.Literals.JVM_GENERIC_TYPE_VALIDATOR_TEST_LANG_MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getPackage()
  {
    return package_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setPackage(String newPackage)
  {
    String oldPackage = package_;
    package_ = newPackage;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, JvmGenericTypeValidatorTestLangPackage.JVM_GENERIC_TYPE_VALIDATOR_TEST_LANG_MODEL__PACKAGE, oldPackage, package_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public XImportSection getImportSection()
  {
    return importSection;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetImportSection(XImportSection newImportSection, NotificationChain msgs)
  {
    XImportSection oldImportSection = importSection;
    importSection = newImportSection;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JvmGenericTypeValidatorTestLangPackage.JVM_GENERIC_TYPE_VALIDATOR_TEST_LANG_MODEL__IMPORT_SECTION, oldImportSection, newImportSection);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setImportSection(XImportSection newImportSection)
  {
    if (newImportSection != importSection)
    {
      NotificationChain msgs = null;
      if (importSection != null)
        msgs = ((InternalEObject)importSection).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JvmGenericTypeValidatorTestLangPackage.JVM_GENERIC_TYPE_VALIDATOR_TEST_LANG_MODEL__IMPORT_SECTION, null, msgs);
      if (newImportSection != null)
        msgs = ((InternalEObject)newImportSection).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JvmGenericTypeValidatorTestLangPackage.JVM_GENERIC_TYPE_VALIDATOR_TEST_LANG_MODEL__IMPORT_SECTION, null, msgs);
      msgs = basicSetImportSection(newImportSection, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, JvmGenericTypeValidatorTestLangPackage.JVM_GENERIC_TYPE_VALIDATOR_TEST_LANG_MODEL__IMPORT_SECTION, newImportSection, newImportSection));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<MyType> getModelTypes()
  {
    if (modelTypes == null)
    {
      modelTypes = new EObjectContainmentEList<MyType>(MyType.class, this, JvmGenericTypeValidatorTestLangPackage.JVM_GENERIC_TYPE_VALIDATOR_TEST_LANG_MODEL__MODEL_TYPES);
    }
    return modelTypes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case JvmGenericTypeValidatorTestLangPackage.JVM_GENERIC_TYPE_VALIDATOR_TEST_LANG_MODEL__IMPORT_SECTION:
        return basicSetImportSection(null, msgs);
      case JvmGenericTypeValidatorTestLangPackage.JVM_GENERIC_TYPE_VALIDATOR_TEST_LANG_MODEL__MODEL_TYPES:
        return ((InternalEList<?>)getModelTypes()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case JvmGenericTypeValidatorTestLangPackage.JVM_GENERIC_TYPE_VALIDATOR_TEST_LANG_MODEL__PACKAGE:
        return getPackage();
      case JvmGenericTypeValidatorTestLangPackage.JVM_GENERIC_TYPE_VALIDATOR_TEST_LANG_MODEL__IMPORT_SECTION:
        return getImportSection();
      case JvmGenericTypeValidatorTestLangPackage.JVM_GENERIC_TYPE_VALIDATOR_TEST_LANG_MODEL__MODEL_TYPES:
        return getModelTypes();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case JvmGenericTypeValidatorTestLangPackage.JVM_GENERIC_TYPE_VALIDATOR_TEST_LANG_MODEL__PACKAGE:
        setPackage((String)newValue);
        return;
      case JvmGenericTypeValidatorTestLangPackage.JVM_GENERIC_TYPE_VALIDATOR_TEST_LANG_MODEL__IMPORT_SECTION:
        setImportSection((XImportSection)newValue);
        return;
      case JvmGenericTypeValidatorTestLangPackage.JVM_GENERIC_TYPE_VALIDATOR_TEST_LANG_MODEL__MODEL_TYPES:
        getModelTypes().clear();
        getModelTypes().addAll((Collection<? extends MyType>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case JvmGenericTypeValidatorTestLangPackage.JVM_GENERIC_TYPE_VALIDATOR_TEST_LANG_MODEL__PACKAGE:
        setPackage(PACKAGE_EDEFAULT);
        return;
      case JvmGenericTypeValidatorTestLangPackage.JVM_GENERIC_TYPE_VALIDATOR_TEST_LANG_MODEL__IMPORT_SECTION:
        setImportSection((XImportSection)null);
        return;
      case JvmGenericTypeValidatorTestLangPackage.JVM_GENERIC_TYPE_VALIDATOR_TEST_LANG_MODEL__MODEL_TYPES:
        getModelTypes().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case JvmGenericTypeValidatorTestLangPackage.JVM_GENERIC_TYPE_VALIDATOR_TEST_LANG_MODEL__PACKAGE:
        return PACKAGE_EDEFAULT == null ? package_ != null : !PACKAGE_EDEFAULT.equals(package_);
      case JvmGenericTypeValidatorTestLangPackage.JVM_GENERIC_TYPE_VALIDATOR_TEST_LANG_MODEL__IMPORT_SECTION:
        return importSection != null;
      case JvmGenericTypeValidatorTestLangPackage.JVM_GENERIC_TYPE_VALIDATOR_TEST_LANG_MODEL__MODEL_TYPES:
        return modelTypes != null && !modelTypes.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (package: ");
    result.append(package_);
    result.append(')');
    return result.toString();
  }

} //JvmGenericTypeValidatorTestLangModelImpl
