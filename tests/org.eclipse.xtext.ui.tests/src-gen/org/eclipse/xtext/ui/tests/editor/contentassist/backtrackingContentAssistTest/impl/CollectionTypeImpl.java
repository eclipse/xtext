/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.BacktrackingContentAssistTestPackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.CollectionLiteralExp;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.CollectionLiteralPart;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.CollectionType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.CollectionTypeImpl#getCollectionLiteralParts <em>Collection Literal Parts</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.CollectionTypeImpl#getTypeIdentifier <em>Type Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollectionTypeImpl extends TypeExpImpl implements CollectionType
{
  /**
   * The cached value of the '{@link #getCollectionLiteralParts() <em>Collection Literal Parts</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCollectionLiteralParts()
   * @generated
   * @ordered
   */
  protected EList<CollectionLiteralPart> collectionLiteralParts;

  /**
   * The default value of the '{@link #getTypeIdentifier() <em>Type Identifier</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeIdentifier()
   * @generated
   * @ordered
   */
  protected static final String TYPE_IDENTIFIER_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTypeIdentifier() <em>Type Identifier</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeIdentifier()
   * @generated
   * @ordered
   */
  protected String typeIdentifier = TYPE_IDENTIFIER_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CollectionTypeImpl()
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
    return BacktrackingContentAssistTestPackage.Literals.COLLECTION_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<CollectionLiteralPart> getCollectionLiteralParts()
  {
    if (collectionLiteralParts == null)
    {
      collectionLiteralParts = new EObjectContainmentEList<CollectionLiteralPart>(CollectionLiteralPart.class, this, BacktrackingContentAssistTestPackage.COLLECTION_TYPE__COLLECTION_LITERAL_PARTS);
    }
    return collectionLiteralParts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTypeIdentifier()
  {
    return typeIdentifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTypeIdentifier(String newTypeIdentifier)
  {
    String oldTypeIdentifier = typeIdentifier;
    typeIdentifier = newTypeIdentifier;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BacktrackingContentAssistTestPackage.COLLECTION_TYPE__TYPE_IDENTIFIER, oldTypeIdentifier, typeIdentifier));
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
      case BacktrackingContentAssistTestPackage.COLLECTION_TYPE__COLLECTION_LITERAL_PARTS:
        return ((InternalEList<?>)getCollectionLiteralParts()).basicRemove(otherEnd, msgs);
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
      case BacktrackingContentAssistTestPackage.COLLECTION_TYPE__COLLECTION_LITERAL_PARTS:
        return getCollectionLiteralParts();
      case BacktrackingContentAssistTestPackage.COLLECTION_TYPE__TYPE_IDENTIFIER:
        return getTypeIdentifier();
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
      case BacktrackingContentAssistTestPackage.COLLECTION_TYPE__COLLECTION_LITERAL_PARTS:
        getCollectionLiteralParts().clear();
        getCollectionLiteralParts().addAll((Collection<? extends CollectionLiteralPart>)newValue);
        return;
      case BacktrackingContentAssistTestPackage.COLLECTION_TYPE__TYPE_IDENTIFIER:
        setTypeIdentifier((String)newValue);
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
      case BacktrackingContentAssistTestPackage.COLLECTION_TYPE__COLLECTION_LITERAL_PARTS:
        getCollectionLiteralParts().clear();
        return;
      case BacktrackingContentAssistTestPackage.COLLECTION_TYPE__TYPE_IDENTIFIER:
        setTypeIdentifier(TYPE_IDENTIFIER_EDEFAULT);
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
      case BacktrackingContentAssistTestPackage.COLLECTION_TYPE__COLLECTION_LITERAL_PARTS:
        return collectionLiteralParts != null && !collectionLiteralParts.isEmpty();
      case BacktrackingContentAssistTestPackage.COLLECTION_TYPE__TYPE_IDENTIFIER:
        return TYPE_IDENTIFIER_EDEFAULT == null ? typeIdentifier != null : !TYPE_IDENTIFIER_EDEFAULT.equals(typeIdentifier);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
  {
    if (baseClass == CollectionLiteralExp.class)
    {
      switch (derivedFeatureID)
      {
        case BacktrackingContentAssistTestPackage.COLLECTION_TYPE__COLLECTION_LITERAL_PARTS: return BacktrackingContentAssistTestPackage.COLLECTION_LITERAL_EXP__COLLECTION_LITERAL_PARTS;
        default: return -1;
      }
    }
    return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
  {
    if (baseClass == CollectionLiteralExp.class)
    {
      switch (baseFeatureID)
      {
        case BacktrackingContentAssistTestPackage.COLLECTION_LITERAL_EXP__COLLECTION_LITERAL_PARTS: return BacktrackingContentAssistTestPackage.COLLECTION_TYPE__COLLECTION_LITERAL_PARTS;
        default: return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
    result.append(" (typeIdentifier: ");
    result.append(typeIdentifier);
    result.append(')');
    return result.toString();
  }

} //CollectionTypeImpl
