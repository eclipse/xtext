/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Bug332217TestLanguagePackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Cell;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.CellAccessory;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.CellType;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.ScalarExpression;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.ViewAction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cell</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.CellImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.CellImpl#getText <em>Text</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.CellImpl#getDetails <em>Details</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.CellImpl#getImage <em>Image</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.CellImpl#getAction <em>Action</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.impl.CellImpl#getAccessory <em>Accessory</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CellImpl extends ViewContentElementImpl implements Cell
{
  /**
   * The default value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected static final CellType TYPE_EDEFAULT = CellType.DEFAULT;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected CellType type = TYPE_EDEFAULT;

  /**
   * The cached value of the '{@link #getText() <em>Text</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getText()
   * @generated
   * @ordered
   */
  protected ScalarExpression text;

  /**
   * The cached value of the '{@link #getDetails() <em>Details</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDetails()
   * @generated
   * @ordered
   */
  protected ScalarExpression details;

  /**
   * The cached value of the '{@link #getImage() <em>Image</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImage()
   * @generated
   * @ordered
   */
  protected ScalarExpression image;

  /**
   * The cached value of the '{@link #getAction() <em>Action</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAction()
   * @generated
   * @ordered
   */
  protected ViewAction action;

  /**
   * The default value of the '{@link #getAccessory() <em>Accessory</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAccessory()
   * @generated
   * @ordered
   */
  protected static final CellAccessory ACCESSORY_EDEFAULT = CellAccessory.NONE;

  /**
   * The cached value of the '{@link #getAccessory() <em>Accessory</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAccessory()
   * @generated
   * @ordered
   */
  protected CellAccessory accessory = ACCESSORY_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CellImpl()
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
    return Bug332217TestLanguagePackage.Literals.CELL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CellType getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(CellType newType)
  {
    CellType oldType = type;
    type = newType == null ? TYPE_EDEFAULT : newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug332217TestLanguagePackage.CELL__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ScalarExpression getText()
  {
    return text;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetText(ScalarExpression newText, NotificationChain msgs)
  {
    ScalarExpression oldText = text;
    text = newText;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Bug332217TestLanguagePackage.CELL__TEXT, oldText, newText);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setText(ScalarExpression newText)
  {
    if (newText != text)
    {
      NotificationChain msgs = null;
      if (text != null)
        msgs = ((InternalEObject)text).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Bug332217TestLanguagePackage.CELL__TEXT, null, msgs);
      if (newText != null)
        msgs = ((InternalEObject)newText).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Bug332217TestLanguagePackage.CELL__TEXT, null, msgs);
      msgs = basicSetText(newText, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug332217TestLanguagePackage.CELL__TEXT, newText, newText));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ScalarExpression getDetails()
  {
    return details;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDetails(ScalarExpression newDetails, NotificationChain msgs)
  {
    ScalarExpression oldDetails = details;
    details = newDetails;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Bug332217TestLanguagePackage.CELL__DETAILS, oldDetails, newDetails);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDetails(ScalarExpression newDetails)
  {
    if (newDetails != details)
    {
      NotificationChain msgs = null;
      if (details != null)
        msgs = ((InternalEObject)details).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Bug332217TestLanguagePackage.CELL__DETAILS, null, msgs);
      if (newDetails != null)
        msgs = ((InternalEObject)newDetails).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Bug332217TestLanguagePackage.CELL__DETAILS, null, msgs);
      msgs = basicSetDetails(newDetails, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug332217TestLanguagePackage.CELL__DETAILS, newDetails, newDetails));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ScalarExpression getImage()
  {
    return image;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetImage(ScalarExpression newImage, NotificationChain msgs)
  {
    ScalarExpression oldImage = image;
    image = newImage;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Bug332217TestLanguagePackage.CELL__IMAGE, oldImage, newImage);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setImage(ScalarExpression newImage)
  {
    if (newImage != image)
    {
      NotificationChain msgs = null;
      if (image != null)
        msgs = ((InternalEObject)image).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Bug332217TestLanguagePackage.CELL__IMAGE, null, msgs);
      if (newImage != null)
        msgs = ((InternalEObject)newImage).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Bug332217TestLanguagePackage.CELL__IMAGE, null, msgs);
      msgs = basicSetImage(newImage, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug332217TestLanguagePackage.CELL__IMAGE, newImage, newImage));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ViewAction getAction()
  {
    return action;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAction(ViewAction newAction, NotificationChain msgs)
  {
    ViewAction oldAction = action;
    action = newAction;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Bug332217TestLanguagePackage.CELL__ACTION, oldAction, newAction);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAction(ViewAction newAction)
  {
    if (newAction != action)
    {
      NotificationChain msgs = null;
      if (action != null)
        msgs = ((InternalEObject)action).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Bug332217TestLanguagePackage.CELL__ACTION, null, msgs);
      if (newAction != null)
        msgs = ((InternalEObject)newAction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Bug332217TestLanguagePackage.CELL__ACTION, null, msgs);
      msgs = basicSetAction(newAction, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug332217TestLanguagePackage.CELL__ACTION, newAction, newAction));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CellAccessory getAccessory()
  {
    return accessory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAccessory(CellAccessory newAccessory)
  {
    CellAccessory oldAccessory = accessory;
    accessory = newAccessory == null ? ACCESSORY_EDEFAULT : newAccessory;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug332217TestLanguagePackage.CELL__ACCESSORY, oldAccessory, accessory));
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
      case Bug332217TestLanguagePackage.CELL__TEXT:
        return basicSetText(null, msgs);
      case Bug332217TestLanguagePackage.CELL__DETAILS:
        return basicSetDetails(null, msgs);
      case Bug332217TestLanguagePackage.CELL__IMAGE:
        return basicSetImage(null, msgs);
      case Bug332217TestLanguagePackage.CELL__ACTION:
        return basicSetAction(null, msgs);
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
      case Bug332217TestLanguagePackage.CELL__TYPE:
        return getType();
      case Bug332217TestLanguagePackage.CELL__TEXT:
        return getText();
      case Bug332217TestLanguagePackage.CELL__DETAILS:
        return getDetails();
      case Bug332217TestLanguagePackage.CELL__IMAGE:
        return getImage();
      case Bug332217TestLanguagePackage.CELL__ACTION:
        return getAction();
      case Bug332217TestLanguagePackage.CELL__ACCESSORY:
        return getAccessory();
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
      case Bug332217TestLanguagePackage.CELL__TYPE:
        setType((CellType)newValue);
        return;
      case Bug332217TestLanguagePackage.CELL__TEXT:
        setText((ScalarExpression)newValue);
        return;
      case Bug332217TestLanguagePackage.CELL__DETAILS:
        setDetails((ScalarExpression)newValue);
        return;
      case Bug332217TestLanguagePackage.CELL__IMAGE:
        setImage((ScalarExpression)newValue);
        return;
      case Bug332217TestLanguagePackage.CELL__ACTION:
        setAction((ViewAction)newValue);
        return;
      case Bug332217TestLanguagePackage.CELL__ACCESSORY:
        setAccessory((CellAccessory)newValue);
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
      case Bug332217TestLanguagePackage.CELL__TYPE:
        setType(TYPE_EDEFAULT);
        return;
      case Bug332217TestLanguagePackage.CELL__TEXT:
        setText((ScalarExpression)null);
        return;
      case Bug332217TestLanguagePackage.CELL__DETAILS:
        setDetails((ScalarExpression)null);
        return;
      case Bug332217TestLanguagePackage.CELL__IMAGE:
        setImage((ScalarExpression)null);
        return;
      case Bug332217TestLanguagePackage.CELL__ACTION:
        setAction((ViewAction)null);
        return;
      case Bug332217TestLanguagePackage.CELL__ACCESSORY:
        setAccessory(ACCESSORY_EDEFAULT);
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
      case Bug332217TestLanguagePackage.CELL__TYPE:
        return type != TYPE_EDEFAULT;
      case Bug332217TestLanguagePackage.CELL__TEXT:
        return text != null;
      case Bug332217TestLanguagePackage.CELL__DETAILS:
        return details != null;
      case Bug332217TestLanguagePackage.CELL__IMAGE:
        return image != null;
      case Bug332217TestLanguagePackage.CELL__ACTION:
        return action != null;
      case Bug332217TestLanguagePackage.CELL__ACCESSORY:
        return accessory != ACCESSORY_EDEFAULT;
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
    result.append(" (type: ");
    result.append(type);
    result.append(", accessory: ");
    result.append(accessory);
    result.append(')');
    return result.toString();
  }

} //CellImpl
