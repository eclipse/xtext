/**
 */
package org.eclipse.xtext.linking.bug313089.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.linking.bug313089.Bar;
import org.eclipse.xtext.linking.bug313089.Baz;
import org.eclipse.xtext.linking.bug313089.Bug313089Package;
import org.eclipse.xtext.linking.bug313089.Foo;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Foo</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.linking.bug313089.impl.FooImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.linking.bug313089.impl.FooImpl#getBar <em>Bar</em>}</li>
 *   <li>{@link org.eclipse.xtext.linking.bug313089.impl.FooImpl#getBaz <em>Baz</em>}</li>
 *   <li>{@link org.eclipse.xtext.linking.bug313089.impl.FooImpl#getRef <em>Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FooImpl extends MinimalEObjectImpl.Container implements Foo
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
   * The cached value of the '{@link #getBar() <em>Bar</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBar()
   * @generated
   * @ordered
   */
  protected Bar bar;

  /**
   * The cached value of the '{@link #getBaz() <em>Baz</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBaz()
   * @generated
   * @ordered
   */
  protected Baz baz;

  /**
   * The cached value of the '{@link #getRef() <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRef()
   * @generated
   * @ordered
   */
  protected Foo ref;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FooImpl()
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
    return Bug313089Package.Literals.FOO;
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
      eNotify(new ENotificationImpl(this, Notification.SET, Bug313089Package.FOO__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bar getBar()
  {
    return bar;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBar(Bar newBar, NotificationChain msgs)
  {
    Bar oldBar = bar;
    bar = newBar;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Bug313089Package.FOO__BAR, oldBar, newBar);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBar(Bar newBar)
  {
    if (newBar != bar)
    {
      NotificationChain msgs = null;
      if (bar != null)
        msgs = ((InternalEObject)bar).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Bug313089Package.FOO__BAR, null, msgs);
      if (newBar != null)
        msgs = ((InternalEObject)newBar).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Bug313089Package.FOO__BAR, null, msgs);
      msgs = basicSetBar(newBar, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug313089Package.FOO__BAR, newBar, newBar));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Baz getBaz()
  {
    return baz;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBaz(Baz newBaz, NotificationChain msgs)
  {
    Baz oldBaz = baz;
    baz = newBaz;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Bug313089Package.FOO__BAZ, oldBaz, newBaz);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBaz(Baz newBaz)
  {
    if (newBaz != baz)
    {
      NotificationChain msgs = null;
      if (baz != null)
        msgs = ((InternalEObject)baz).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Bug313089Package.FOO__BAZ, null, msgs);
      if (newBaz != null)
        msgs = ((InternalEObject)newBaz).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Bug313089Package.FOO__BAZ, null, msgs);
      msgs = basicSetBaz(newBaz, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug313089Package.FOO__BAZ, newBaz, newBaz));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Foo getRef()
  {
    if (ref != null && ref.eIsProxy())
    {
      InternalEObject oldRef = (InternalEObject)ref;
      ref = (Foo)eResolveProxy(oldRef);
      if (ref != oldRef)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, Bug313089Package.FOO__REF, oldRef, ref));
      }
    }
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Foo basicGetRef()
  {
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRef(Foo newRef)
  {
    Foo oldRef = ref;
    ref = newRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug313089Package.FOO__REF, oldRef, ref));
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
      case Bug313089Package.FOO__BAR:
        return basicSetBar(null, msgs);
      case Bug313089Package.FOO__BAZ:
        return basicSetBaz(null, msgs);
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
      case Bug313089Package.FOO__NAME:
        return getName();
      case Bug313089Package.FOO__BAR:
        return getBar();
      case Bug313089Package.FOO__BAZ:
        return getBaz();
      case Bug313089Package.FOO__REF:
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
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case Bug313089Package.FOO__NAME:
        setName((String)newValue);
        return;
      case Bug313089Package.FOO__BAR:
        setBar((Bar)newValue);
        return;
      case Bug313089Package.FOO__BAZ:
        setBaz((Baz)newValue);
        return;
      case Bug313089Package.FOO__REF:
        setRef((Foo)newValue);
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
      case Bug313089Package.FOO__NAME:
        setName(NAME_EDEFAULT);
        return;
      case Bug313089Package.FOO__BAR:
        setBar((Bar)null);
        return;
      case Bug313089Package.FOO__BAZ:
        setBaz((Baz)null);
        return;
      case Bug313089Package.FOO__REF:
        setRef((Foo)null);
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
      case Bug313089Package.FOO__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case Bug313089Package.FOO__BAR:
        return bar != null;
      case Bug313089Package.FOO__BAZ:
        return baz != null;
      case Bug313089Package.FOO__REF:
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

} //FooImpl
