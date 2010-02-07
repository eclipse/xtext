/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Model;
import org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.UnorderedGroupsTestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.ModelImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.ModelImpl#isStatic <em>Static</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.ModelImpl#isSynchronized <em>Synchronized</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.ModelImpl#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.ModelImpl#isFinal <em>Final</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.ModelImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelImpl extends MinimalEObjectImpl.Container implements Model
{
  /**
   * The default value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVisibility()
   * @generated
   * @ordered
   */
  protected static final String VISIBILITY_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVisibility()
   * @generated
   * @ordered
   */
  protected String visibility = VISIBILITY_EDEFAULT;

  /**
   * The default value of the '{@link #isStatic() <em>Static</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isStatic()
   * @generated
   * @ordered
   */
  protected static final boolean STATIC_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isStatic() <em>Static</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isStatic()
   * @generated
   * @ordered
   */
  protected boolean static_ = STATIC_EDEFAULT;

  /**
   * The default value of the '{@link #isSynchronized() <em>Synchronized</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSynchronized()
   * @generated
   * @ordered
   */
  protected static final boolean SYNCHRONIZED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isSynchronized() <em>Synchronized</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSynchronized()
   * @generated
   * @ordered
   */
  protected boolean synchronized_ = SYNCHRONIZED_EDEFAULT;

  /**
   * The default value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAbstract()
   * @generated
   * @ordered
   */
  protected static final boolean ABSTRACT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAbstract()
   * @generated
   * @ordered
   */
  protected boolean abstract_ = ABSTRACT_EDEFAULT;

  /**
   * The default value of the '{@link #isFinal() <em>Final</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isFinal()
   * @generated
   * @ordered
   */
  protected static final boolean FINAL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isFinal() <em>Final</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isFinal()
   * @generated
   * @ordered
   */
  protected boolean final_ = FINAL_EDEFAULT;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ModelImpl()
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
    return UnorderedGroupsTestPackage.Literals.MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getVisibility()
  {
    return visibility;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVisibility(String newVisibility)
  {
    String oldVisibility = visibility;
    visibility = newVisibility;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UnorderedGroupsTestPackage.MODEL__VISIBILITY, oldVisibility, visibility));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isStatic()
  {
    return static_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStatic(boolean newStatic)
  {
    boolean oldStatic = static_;
    static_ = newStatic;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UnorderedGroupsTestPackage.MODEL__STATIC, oldStatic, static_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSynchronized()
  {
    return synchronized_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSynchronized(boolean newSynchronized)
  {
    boolean oldSynchronized = synchronized_;
    synchronized_ = newSynchronized;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UnorderedGroupsTestPackage.MODEL__SYNCHRONIZED, oldSynchronized, synchronized_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAbstract()
  {
    return abstract_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAbstract(boolean newAbstract)
  {
    boolean oldAbstract = abstract_;
    abstract_ = newAbstract;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UnorderedGroupsTestPackage.MODEL__ABSTRACT, oldAbstract, abstract_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isFinal()
  {
    return final_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFinal(boolean newFinal)
  {
    boolean oldFinal = final_;
    final_ = newFinal;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UnorderedGroupsTestPackage.MODEL__FINAL, oldFinal, final_));
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
      eNotify(new ENotificationImpl(this, Notification.SET, UnorderedGroupsTestPackage.MODEL__NAME, oldName, name));
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
      case UnorderedGroupsTestPackage.MODEL__VISIBILITY:
        return getVisibility();
      case UnorderedGroupsTestPackage.MODEL__STATIC:
        return isStatic();
      case UnorderedGroupsTestPackage.MODEL__SYNCHRONIZED:
        return isSynchronized();
      case UnorderedGroupsTestPackage.MODEL__ABSTRACT:
        return isAbstract();
      case UnorderedGroupsTestPackage.MODEL__FINAL:
        return isFinal();
      case UnorderedGroupsTestPackage.MODEL__NAME:
        return getName();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case UnorderedGroupsTestPackage.MODEL__VISIBILITY:
        setVisibility((String)newValue);
        return;
      case UnorderedGroupsTestPackage.MODEL__STATIC:
        setStatic((Boolean)newValue);
        return;
      case UnorderedGroupsTestPackage.MODEL__SYNCHRONIZED:
        setSynchronized((Boolean)newValue);
        return;
      case UnorderedGroupsTestPackage.MODEL__ABSTRACT:
        setAbstract((Boolean)newValue);
        return;
      case UnorderedGroupsTestPackage.MODEL__FINAL:
        setFinal((Boolean)newValue);
        return;
      case UnorderedGroupsTestPackage.MODEL__NAME:
        setName((String)newValue);
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
      case UnorderedGroupsTestPackage.MODEL__VISIBILITY:
        setVisibility(VISIBILITY_EDEFAULT);
        return;
      case UnorderedGroupsTestPackage.MODEL__STATIC:
        setStatic(STATIC_EDEFAULT);
        return;
      case UnorderedGroupsTestPackage.MODEL__SYNCHRONIZED:
        setSynchronized(SYNCHRONIZED_EDEFAULT);
        return;
      case UnorderedGroupsTestPackage.MODEL__ABSTRACT:
        setAbstract(ABSTRACT_EDEFAULT);
        return;
      case UnorderedGroupsTestPackage.MODEL__FINAL:
        setFinal(FINAL_EDEFAULT);
        return;
      case UnorderedGroupsTestPackage.MODEL__NAME:
        setName(NAME_EDEFAULT);
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
      case UnorderedGroupsTestPackage.MODEL__VISIBILITY:
        return VISIBILITY_EDEFAULT == null ? visibility != null : !VISIBILITY_EDEFAULT.equals(visibility);
      case UnorderedGroupsTestPackage.MODEL__STATIC:
        return static_ != STATIC_EDEFAULT;
      case UnorderedGroupsTestPackage.MODEL__SYNCHRONIZED:
        return synchronized_ != SYNCHRONIZED_EDEFAULT;
      case UnorderedGroupsTestPackage.MODEL__ABSTRACT:
        return abstract_ != ABSTRACT_EDEFAULT;
      case UnorderedGroupsTestPackage.MODEL__FINAL:
        return final_ != FINAL_EDEFAULT;
      case UnorderedGroupsTestPackage.MODEL__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
    result.append(" (visibility: ");
    result.append(visibility);
    result.append(", static: ");
    result.append(static_);
    result.append(", synchronized: ");
    result.append(synchronized_);
    result.append(", abstract: ");
    result.append(abstract_);
    result.append(", final: ");
    result.append(final_);
    result.append(", name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //ModelImpl
