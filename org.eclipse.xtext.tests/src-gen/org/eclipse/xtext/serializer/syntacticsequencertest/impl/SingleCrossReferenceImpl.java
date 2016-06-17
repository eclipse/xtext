/**
 */
package org.eclipse.xtext.serializer.syntacticsequencertest.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.serializer.syntacticsequencertest.SingleCrossReference;
import org.eclipse.xtext.serializer.syntacticsequencertest.SyntacticsequencertestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Single Cross Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.syntacticsequencertest.impl.SingleCrossReferenceImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.syntacticsequencertest.impl.SingleCrossReferenceImpl#getRef1 <em>Ref1</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.syntacticsequencertest.impl.SingleCrossReferenceImpl#getRef2 <em>Ref2</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.syntacticsequencertest.impl.SingleCrossReferenceImpl#getRef3 <em>Ref3</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.syntacticsequencertest.impl.SingleCrossReferenceImpl#getRef4 <em>Ref4</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SingleCrossReferenceImpl extends MinimalEObjectImpl.Container implements SingleCrossReference
{
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
   * The cached value of the '{@link #getRef1() <em>Ref1</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRef1()
   * @generated
   * @ordered
   */
  protected SingleCrossReference ref1;

  /**
   * The cached value of the '{@link #getRef2() <em>Ref2</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRef2()
   * @generated
   * @ordered
   */
  protected SingleCrossReference ref2;

  /**
   * The cached value of the '{@link #getRef3() <em>Ref3</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRef3()
   * @generated
   * @ordered
   */
  protected SingleCrossReference ref3;

  /**
   * The cached value of the '{@link #getRef4() <em>Ref4</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRef4()
   * @generated
   * @ordered
   */
  protected SingleCrossReference ref4;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SingleCrossReferenceImpl()
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
    return SyntacticsequencertestPackage.Literals.SINGLE_CROSS_REFERENCE;
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
      eNotify(new ENotificationImpl(this, Notification.SET, SyntacticsequencertestPackage.SINGLE_CROSS_REFERENCE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SingleCrossReference getRef1()
  {
    if (ref1 != null && ref1.eIsProxy())
    {
      InternalEObject oldRef1 = (InternalEObject)ref1;
      ref1 = (SingleCrossReference)eResolveProxy(oldRef1);
      if (ref1 != oldRef1)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, SyntacticsequencertestPackage.SINGLE_CROSS_REFERENCE__REF1, oldRef1, ref1));
      }
    }
    return ref1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SingleCrossReference basicGetRef1()
  {
    return ref1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRef1(SingleCrossReference newRef1)
  {
    SingleCrossReference oldRef1 = ref1;
    ref1 = newRef1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SyntacticsequencertestPackage.SINGLE_CROSS_REFERENCE__REF1, oldRef1, ref1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SingleCrossReference getRef2()
  {
    if (ref2 != null && ref2.eIsProxy())
    {
      InternalEObject oldRef2 = (InternalEObject)ref2;
      ref2 = (SingleCrossReference)eResolveProxy(oldRef2);
      if (ref2 != oldRef2)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, SyntacticsequencertestPackage.SINGLE_CROSS_REFERENCE__REF2, oldRef2, ref2));
      }
    }
    return ref2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SingleCrossReference basicGetRef2()
  {
    return ref2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRef2(SingleCrossReference newRef2)
  {
    SingleCrossReference oldRef2 = ref2;
    ref2 = newRef2;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SyntacticsequencertestPackage.SINGLE_CROSS_REFERENCE__REF2, oldRef2, ref2));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SingleCrossReference getRef3()
  {
    if (ref3 != null && ref3.eIsProxy())
    {
      InternalEObject oldRef3 = (InternalEObject)ref3;
      ref3 = (SingleCrossReference)eResolveProxy(oldRef3);
      if (ref3 != oldRef3)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, SyntacticsequencertestPackage.SINGLE_CROSS_REFERENCE__REF3, oldRef3, ref3));
      }
    }
    return ref3;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SingleCrossReference basicGetRef3()
  {
    return ref3;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRef3(SingleCrossReference newRef3)
  {
    SingleCrossReference oldRef3 = ref3;
    ref3 = newRef3;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SyntacticsequencertestPackage.SINGLE_CROSS_REFERENCE__REF3, oldRef3, ref3));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SingleCrossReference getRef4()
  {
    if (ref4 != null && ref4.eIsProxy())
    {
      InternalEObject oldRef4 = (InternalEObject)ref4;
      ref4 = (SingleCrossReference)eResolveProxy(oldRef4);
      if (ref4 != oldRef4)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, SyntacticsequencertestPackage.SINGLE_CROSS_REFERENCE__REF4, oldRef4, ref4));
      }
    }
    return ref4;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SingleCrossReference basicGetRef4()
  {
    return ref4;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRef4(SingleCrossReference newRef4)
  {
    SingleCrossReference oldRef4 = ref4;
    ref4 = newRef4;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SyntacticsequencertestPackage.SINGLE_CROSS_REFERENCE__REF4, oldRef4, ref4));
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
      case SyntacticsequencertestPackage.SINGLE_CROSS_REFERENCE__NAME:
        return getName();
      case SyntacticsequencertestPackage.SINGLE_CROSS_REFERENCE__REF1:
        if (resolve) return getRef1();
        return basicGetRef1();
      case SyntacticsequencertestPackage.SINGLE_CROSS_REFERENCE__REF2:
        if (resolve) return getRef2();
        return basicGetRef2();
      case SyntacticsequencertestPackage.SINGLE_CROSS_REFERENCE__REF3:
        if (resolve) return getRef3();
        return basicGetRef3();
      case SyntacticsequencertestPackage.SINGLE_CROSS_REFERENCE__REF4:
        if (resolve) return getRef4();
        return basicGetRef4();
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
      case SyntacticsequencertestPackage.SINGLE_CROSS_REFERENCE__NAME:
        setName((String)newValue);
        return;
      case SyntacticsequencertestPackage.SINGLE_CROSS_REFERENCE__REF1:
        setRef1((SingleCrossReference)newValue);
        return;
      case SyntacticsequencertestPackage.SINGLE_CROSS_REFERENCE__REF2:
        setRef2((SingleCrossReference)newValue);
        return;
      case SyntacticsequencertestPackage.SINGLE_CROSS_REFERENCE__REF3:
        setRef3((SingleCrossReference)newValue);
        return;
      case SyntacticsequencertestPackage.SINGLE_CROSS_REFERENCE__REF4:
        setRef4((SingleCrossReference)newValue);
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
      case SyntacticsequencertestPackage.SINGLE_CROSS_REFERENCE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case SyntacticsequencertestPackage.SINGLE_CROSS_REFERENCE__REF1:
        setRef1((SingleCrossReference)null);
        return;
      case SyntacticsequencertestPackage.SINGLE_CROSS_REFERENCE__REF2:
        setRef2((SingleCrossReference)null);
        return;
      case SyntacticsequencertestPackage.SINGLE_CROSS_REFERENCE__REF3:
        setRef3((SingleCrossReference)null);
        return;
      case SyntacticsequencertestPackage.SINGLE_CROSS_REFERENCE__REF4:
        setRef4((SingleCrossReference)null);
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
      case SyntacticsequencertestPackage.SINGLE_CROSS_REFERENCE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case SyntacticsequencertestPackage.SINGLE_CROSS_REFERENCE__REF1:
        return ref1 != null;
      case SyntacticsequencertestPackage.SINGLE_CROSS_REFERENCE__REF2:
        return ref2 != null;
      case SyntacticsequencertestPackage.SINGLE_CROSS_REFERENCE__REF3:
        return ref3 != null;
      case SyntacticsequencertestPackage.SINGLE_CROSS_REFERENCE__REF4:
        return ref4 != null;
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

} //SingleCrossReferenceImpl
