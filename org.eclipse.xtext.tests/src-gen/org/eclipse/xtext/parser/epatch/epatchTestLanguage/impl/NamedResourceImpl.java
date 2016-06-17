/**
 */
package org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.parser.epatch.epatchTestLanguage.CreatedObject;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.EpatchTestLanguagePackage;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.NamedResource;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Named Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.NamedResourceImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.NamedResourceImpl#getLeftUri <em>Left Uri</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.NamedResourceImpl#getLeftRoot <em>Left Root</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.NamedResourceImpl#getRightUri <em>Right Uri</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.NamedResourceImpl#getRightRoot <em>Right Root</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NamedResourceImpl extends MinimalEObjectImpl.Container implements NamedResource
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
   * The default value of the '{@link #getLeftUri() <em>Left Uri</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLeftUri()
   * @generated
   * @ordered
   */
  protected static final String LEFT_URI_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLeftUri() <em>Left Uri</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLeftUri()
   * @generated
   * @ordered
   */
  protected String leftUri = LEFT_URI_EDEFAULT;

  /**
   * The cached value of the '{@link #getLeftRoot() <em>Left Root</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLeftRoot()
   * @generated
   * @ordered
   */
  protected CreatedObject leftRoot;

  /**
   * The default value of the '{@link #getRightUri() <em>Right Uri</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRightUri()
   * @generated
   * @ordered
   */
  protected static final String RIGHT_URI_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRightUri() <em>Right Uri</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRightUri()
   * @generated
   * @ordered
   */
  protected String rightUri = RIGHT_URI_EDEFAULT;

  /**
   * The cached value of the '{@link #getRightRoot() <em>Right Root</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRightRoot()
   * @generated
   * @ordered
   */
  protected CreatedObject rightRoot;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NamedResourceImpl()
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
    return EpatchTestLanguagePackage.Literals.NAMED_RESOURCE;
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
      eNotify(new ENotificationImpl(this, Notification.SET, EpatchTestLanguagePackage.NAMED_RESOURCE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLeftUri()
  {
    return leftUri;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLeftUri(String newLeftUri)
  {
    String oldLeftUri = leftUri;
    leftUri = newLeftUri;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EpatchTestLanguagePackage.NAMED_RESOURCE__LEFT_URI, oldLeftUri, leftUri));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CreatedObject getLeftRoot()
  {
    return leftRoot;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLeftRoot(CreatedObject newLeftRoot, NotificationChain msgs)
  {
    CreatedObject oldLeftRoot = leftRoot;
    leftRoot = newLeftRoot;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EpatchTestLanguagePackage.NAMED_RESOURCE__LEFT_ROOT, oldLeftRoot, newLeftRoot);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLeftRoot(CreatedObject newLeftRoot)
  {
    if (newLeftRoot != leftRoot)
    {
      NotificationChain msgs = null;
      if (leftRoot != null)
        msgs = ((InternalEObject)leftRoot).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EpatchTestLanguagePackage.NAMED_RESOURCE__LEFT_ROOT, null, msgs);
      if (newLeftRoot != null)
        msgs = ((InternalEObject)newLeftRoot).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EpatchTestLanguagePackage.NAMED_RESOURCE__LEFT_ROOT, null, msgs);
      msgs = basicSetLeftRoot(newLeftRoot, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EpatchTestLanguagePackage.NAMED_RESOURCE__LEFT_ROOT, newLeftRoot, newLeftRoot));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getRightUri()
  {
    return rightUri;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRightUri(String newRightUri)
  {
    String oldRightUri = rightUri;
    rightUri = newRightUri;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EpatchTestLanguagePackage.NAMED_RESOURCE__RIGHT_URI, oldRightUri, rightUri));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CreatedObject getRightRoot()
  {
    return rightRoot;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRightRoot(CreatedObject newRightRoot, NotificationChain msgs)
  {
    CreatedObject oldRightRoot = rightRoot;
    rightRoot = newRightRoot;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EpatchTestLanguagePackage.NAMED_RESOURCE__RIGHT_ROOT, oldRightRoot, newRightRoot);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRightRoot(CreatedObject newRightRoot)
  {
    if (newRightRoot != rightRoot)
    {
      NotificationChain msgs = null;
      if (rightRoot != null)
        msgs = ((InternalEObject)rightRoot).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EpatchTestLanguagePackage.NAMED_RESOURCE__RIGHT_ROOT, null, msgs);
      if (newRightRoot != null)
        msgs = ((InternalEObject)newRightRoot).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EpatchTestLanguagePackage.NAMED_RESOURCE__RIGHT_ROOT, null, msgs);
      msgs = basicSetRightRoot(newRightRoot, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EpatchTestLanguagePackage.NAMED_RESOURCE__RIGHT_ROOT, newRightRoot, newRightRoot));
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
      case EpatchTestLanguagePackage.NAMED_RESOURCE__LEFT_ROOT:
        return basicSetLeftRoot(null, msgs);
      case EpatchTestLanguagePackage.NAMED_RESOURCE__RIGHT_ROOT:
        return basicSetRightRoot(null, msgs);
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
      case EpatchTestLanguagePackage.NAMED_RESOURCE__NAME:
        return getName();
      case EpatchTestLanguagePackage.NAMED_RESOURCE__LEFT_URI:
        return getLeftUri();
      case EpatchTestLanguagePackage.NAMED_RESOURCE__LEFT_ROOT:
        return getLeftRoot();
      case EpatchTestLanguagePackage.NAMED_RESOURCE__RIGHT_URI:
        return getRightUri();
      case EpatchTestLanguagePackage.NAMED_RESOURCE__RIGHT_ROOT:
        return getRightRoot();
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
      case EpatchTestLanguagePackage.NAMED_RESOURCE__NAME:
        setName((String)newValue);
        return;
      case EpatchTestLanguagePackage.NAMED_RESOURCE__LEFT_URI:
        setLeftUri((String)newValue);
        return;
      case EpatchTestLanguagePackage.NAMED_RESOURCE__LEFT_ROOT:
        setLeftRoot((CreatedObject)newValue);
        return;
      case EpatchTestLanguagePackage.NAMED_RESOURCE__RIGHT_URI:
        setRightUri((String)newValue);
        return;
      case EpatchTestLanguagePackage.NAMED_RESOURCE__RIGHT_ROOT:
        setRightRoot((CreatedObject)newValue);
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
      case EpatchTestLanguagePackage.NAMED_RESOURCE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case EpatchTestLanguagePackage.NAMED_RESOURCE__LEFT_URI:
        setLeftUri(LEFT_URI_EDEFAULT);
        return;
      case EpatchTestLanguagePackage.NAMED_RESOURCE__LEFT_ROOT:
        setLeftRoot((CreatedObject)null);
        return;
      case EpatchTestLanguagePackage.NAMED_RESOURCE__RIGHT_URI:
        setRightUri(RIGHT_URI_EDEFAULT);
        return;
      case EpatchTestLanguagePackage.NAMED_RESOURCE__RIGHT_ROOT:
        setRightRoot((CreatedObject)null);
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
      case EpatchTestLanguagePackage.NAMED_RESOURCE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case EpatchTestLanguagePackage.NAMED_RESOURCE__LEFT_URI:
        return LEFT_URI_EDEFAULT == null ? leftUri != null : !LEFT_URI_EDEFAULT.equals(leftUri);
      case EpatchTestLanguagePackage.NAMED_RESOURCE__LEFT_ROOT:
        return leftRoot != null;
      case EpatchTestLanguagePackage.NAMED_RESOURCE__RIGHT_URI:
        return RIGHT_URI_EDEFAULT == null ? rightUri != null : !RIGHT_URI_EDEFAULT.equals(rightUri);
      case EpatchTestLanguagePackage.NAMED_RESOURCE__RIGHT_ROOT:
        return rightRoot != null;
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
    result.append(", leftUri: ");
    result.append(leftUri);
    result.append(", rightUri: ");
    result.append(rightUri);
    result.append(')');
    return result.toString();
  }

} //NamedResourceImpl
