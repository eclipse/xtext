/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.Import;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.Node;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.PartialSerializationTestLanguagePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.impl.NodeImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.impl.NodeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.impl.NodeImpl#getRefs <em>Refs</em>}</li>
 *   <li>{@link org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.impl.NodeImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.impl.NodeImpl#getRef <em>Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NodeImpl extends ModelImpl implements Node
{
  /**
   * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImports()
   * @generated
   * @ordered
   */
  protected EList<Import> imports;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getRefs() <em>Refs</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRefs()
   * @generated
   * @ordered
   */
  protected EList<Node> refs;

  /**
   * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getChildren()
   * @generated
   * @ordered
   */
  protected EList<Node> children;

  /**
   * The cached value of the '{@link #getRef() <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRef()
   * @generated
   * @ordered
   */
  protected Node ref;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NodeImpl()
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
    return PartialSerializationTestLanguagePackage.Literals.NODE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Import> getImports()
  {
    if (imports == null)
    {
      imports = new EObjectContainmentEList<Import>(Import.class, this, PartialSerializationTestLanguagePackage.NODE__IMPORTS);
    }
    return imports;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PartialSerializationTestLanguagePackage.NODE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Node> getRefs()
  {
    if (refs == null)
    {
      refs = new EObjectResolvingEList<Node>(Node.class, this, PartialSerializationTestLanguagePackage.NODE__REFS);
    }
    return refs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Node> getChildren()
  {
    if (children == null)
    {
      children = new EObjectContainmentEList<Node>(Node.class, this, PartialSerializationTestLanguagePackage.NODE__CHILDREN);
    }
    return children;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Node getRef()
  {
    if (ref != null && ref.eIsProxy())
    {
      InternalEObject oldRef = (InternalEObject)ref;
      ref = (Node)eResolveProxy(oldRef);
      if (ref != oldRef)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, PartialSerializationTestLanguagePackage.NODE__REF, oldRef, ref));
      }
    }
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Node basicGetRef()
  {
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRef(Node newRef)
  {
    Node oldRef = ref;
    ref = newRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PartialSerializationTestLanguagePackage.NODE__REF, oldRef, ref));
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
      case PartialSerializationTestLanguagePackage.NODE__IMPORTS:
        return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
      case PartialSerializationTestLanguagePackage.NODE__CHILDREN:
        return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
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
      case PartialSerializationTestLanguagePackage.NODE__IMPORTS:
        return getImports();
      case PartialSerializationTestLanguagePackage.NODE__NAME:
        return getName();
      case PartialSerializationTestLanguagePackage.NODE__REFS:
        return getRefs();
      case PartialSerializationTestLanguagePackage.NODE__CHILDREN:
        return getChildren();
      case PartialSerializationTestLanguagePackage.NODE__REF:
        if (resolve) return getRef();
        return basicGetRef();
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
      case PartialSerializationTestLanguagePackage.NODE__IMPORTS:
        getImports().clear();
        getImports().addAll((Collection<? extends Import>)newValue);
        return;
      case PartialSerializationTestLanguagePackage.NODE__NAME:
        setName((String)newValue);
        return;
      case PartialSerializationTestLanguagePackage.NODE__REFS:
        getRefs().clear();
        getRefs().addAll((Collection<? extends Node>)newValue);
        return;
      case PartialSerializationTestLanguagePackage.NODE__CHILDREN:
        getChildren().clear();
        getChildren().addAll((Collection<? extends Node>)newValue);
        return;
      case PartialSerializationTestLanguagePackage.NODE__REF:
        setRef((Node)newValue);
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
      case PartialSerializationTestLanguagePackage.NODE__IMPORTS:
        getImports().clear();
        return;
      case PartialSerializationTestLanguagePackage.NODE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case PartialSerializationTestLanguagePackage.NODE__REFS:
        getRefs().clear();
        return;
      case PartialSerializationTestLanguagePackage.NODE__CHILDREN:
        getChildren().clear();
        return;
      case PartialSerializationTestLanguagePackage.NODE__REF:
        setRef((Node)null);
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
      case PartialSerializationTestLanguagePackage.NODE__IMPORTS:
        return imports != null && !imports.isEmpty();
      case PartialSerializationTestLanguagePackage.NODE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case PartialSerializationTestLanguagePackage.NODE__REFS:
        return refs != null && !refs.isEmpty();
      case PartialSerializationTestLanguagePackage.NODE__CHILDREN:
        return children != null && !children.isEmpty();
      case PartialSerializationTestLanguagePackage.NODE__REF:
        return ref != null;
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

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //NodeImpl
