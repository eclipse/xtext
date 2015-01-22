/**
 */
package org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.AbstractBar;
import org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.EObjectAtOffsetTestLanguagePackage;
import org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.Foo;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Bar</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.impl.AbstractBarImpl#getFoo <em>Foo</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AbstractBarImpl extends MinimalEObjectImpl.Container implements AbstractBar
{
  /**
   * The cached value of the '{@link #getFoo() <em>Foo</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFoo()
   * @generated
   * @ordered
   */
  protected EList<Foo> foo;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AbstractBarImpl()
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
    return EObjectAtOffsetTestLanguagePackage.Literals.ABSTRACT_BAR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Foo> getFoo()
  {
    if (foo == null)
    {
      foo = new EObjectResolvingEList<Foo>(Foo.class, this, EObjectAtOffsetTestLanguagePackage.ABSTRACT_BAR__FOO);
    }
    return foo;
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
      case EObjectAtOffsetTestLanguagePackage.ABSTRACT_BAR__FOO:
        return getFoo();
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
      case EObjectAtOffsetTestLanguagePackage.ABSTRACT_BAR__FOO:
        getFoo().clear();
        getFoo().addAll((Collection<? extends Foo>)newValue);
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
      case EObjectAtOffsetTestLanguagePackage.ABSTRACT_BAR__FOO:
        getFoo().clear();
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
      case EObjectAtOffsetTestLanguagePackage.ABSTRACT_BAR__FOO:
        return foo != null && !foo.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //AbstractBarImpl
