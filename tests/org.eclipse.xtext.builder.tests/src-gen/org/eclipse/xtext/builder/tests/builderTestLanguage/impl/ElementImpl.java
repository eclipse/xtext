/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.builder.tests.builderTestLanguage.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.xtext.builder.tests.builderTestLanguage.BuilderTestLanguagePackage;
import org.eclipse.xtext.builder.tests.builderTestLanguage.Element;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.builder.tests.builderTestLanguage.impl.ElementImpl#getReferences <em>References</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.tests.builderTestLanguage.impl.ElementImpl#getOtherRefs <em>Other Refs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ElementImpl extends NamedElementImpl implements Element
{
  /**
   * The cached value of the '{@link #getReferences() <em>References</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReferences()
   * @generated
   * @ordered
   */
  protected Element references;

  /**
   * The cached value of the '{@link #getOtherRefs() <em>Other Refs</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOtherRefs()
   * @generated
   * @ordered
   */
  protected EList<Element> otherRefs;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ElementImpl()
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
    return BuilderTestLanguagePackage.Literals.ELEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Element getReferences()
  {
    if (references != null && references.eIsProxy())
    {
      InternalEObject oldReferences = (InternalEObject)references;
      references = (Element)eResolveProxy(oldReferences);
      if (references != oldReferences)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, BuilderTestLanguagePackage.ELEMENT__REFERENCES, oldReferences, references));
      }
    }
    return references;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Element basicGetReferences()
  {
    return references;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReferences(Element newReferences)
  {
    Element oldReferences = references;
    references = newReferences;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BuilderTestLanguagePackage.ELEMENT__REFERENCES, oldReferences, references));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Element> getOtherRefs()
  {
    if (otherRefs == null)
    {
      otherRefs = new EObjectResolvingEList<Element>(Element.class, this, BuilderTestLanguagePackage.ELEMENT__OTHER_REFS);
    }
    return otherRefs;
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
      case BuilderTestLanguagePackage.ELEMENT__REFERENCES:
        if (resolve) return getReferences();
        return basicGetReferences();
      case BuilderTestLanguagePackage.ELEMENT__OTHER_REFS:
        return getOtherRefs();
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
      case BuilderTestLanguagePackage.ELEMENT__REFERENCES:
        setReferences((Element)newValue);
        return;
      case BuilderTestLanguagePackage.ELEMENT__OTHER_REFS:
        getOtherRefs().clear();
        getOtherRefs().addAll((Collection<? extends Element>)newValue);
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
      case BuilderTestLanguagePackage.ELEMENT__REFERENCES:
        setReferences((Element)null);
        return;
      case BuilderTestLanguagePackage.ELEMENT__OTHER_REFS:
        getOtherRefs().clear();
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
      case BuilderTestLanguagePackage.ELEMENT__REFERENCES:
        return references != null;
      case BuilderTestLanguagePackage.ELEMENT__OTHER_REFS:
        return otherRefs != null && !otherRefs.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ElementImpl
