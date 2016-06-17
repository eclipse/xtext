/**
 */
package org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.parser.epatch.epatchTestLanguage.AssignmentValue;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.CreatedObject;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.EpatchTestLanguagePackage;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.Import;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.NamedObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assignment Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.AssignmentValueImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.AssignmentValueImpl#getRefObject <em>Ref Object</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.AssignmentValueImpl#getRefFeature <em>Ref Feature</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.AssignmentValueImpl#getRefIndex <em>Ref Index</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.AssignmentValueImpl#getNewObject <em>New Object</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.AssignmentValueImpl#getImport <em>Import</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.AssignmentValueImpl#getImpFrag <em>Imp Frag</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.AssignmentValueImpl#getIndex <em>Index</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.AssignmentValueImpl#getKeyword <em>Keyword</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AssignmentValueImpl extends MinimalEObjectImpl.Container implements AssignmentValue
{
  /**
   * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected static final String VALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected String value = VALUE_EDEFAULT;

  /**
   * The cached value of the '{@link #getRefObject() <em>Ref Object</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRefObject()
   * @generated
   * @ordered
   */
  protected NamedObject refObject;

  /**
   * The default value of the '{@link #getRefFeature() <em>Ref Feature</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRefFeature()
   * @generated
   * @ordered
   */
  protected static final String REF_FEATURE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRefFeature() <em>Ref Feature</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRefFeature()
   * @generated
   * @ordered
   */
  protected String refFeature = REF_FEATURE_EDEFAULT;

  /**
   * The default value of the '{@link #getRefIndex() <em>Ref Index</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRefIndex()
   * @generated
   * @ordered
   */
  protected static final int REF_INDEX_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getRefIndex() <em>Ref Index</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRefIndex()
   * @generated
   * @ordered
   */
  protected int refIndex = REF_INDEX_EDEFAULT;

  /**
   * The cached value of the '{@link #getNewObject() <em>New Object</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNewObject()
   * @generated
   * @ordered
   */
  protected CreatedObject newObject;

  /**
   * The cached value of the '{@link #getImport() <em>Import</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImport()
   * @generated
   * @ordered
   */
  protected Import import_;

  /**
   * The default value of the '{@link #getImpFrag() <em>Imp Frag</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImpFrag()
   * @generated
   * @ordered
   */
  protected static final String IMP_FRAG_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getImpFrag() <em>Imp Frag</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImpFrag()
   * @generated
   * @ordered
   */
  protected String impFrag = IMP_FRAG_EDEFAULT;

  /**
   * The default value of the '{@link #getIndex() <em>Index</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIndex()
   * @generated
   * @ordered
   */
  protected static final int INDEX_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getIndex() <em>Index</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIndex()
   * @generated
   * @ordered
   */
  protected int index = INDEX_EDEFAULT;

  /**
   * The default value of the '{@link #getKeyword() <em>Keyword</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKeyword()
   * @generated
   * @ordered
   */
  protected static final String KEYWORD_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getKeyword() <em>Keyword</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKeyword()
   * @generated
   * @ordered
   */
  protected String keyword = KEYWORD_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AssignmentValueImpl()
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
    return EpatchTestLanguagePackage.Literals.ASSIGNMENT_VALUE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValue(String newValue)
  {
    String oldValue = value;
    value = newValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EpatchTestLanguagePackage.ASSIGNMENT_VALUE__VALUE, oldValue, value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamedObject getRefObject()
  {
    if (refObject != null && refObject.eIsProxy())
    {
      InternalEObject oldRefObject = (InternalEObject)refObject;
      refObject = (NamedObject)eResolveProxy(oldRefObject);
      if (refObject != oldRefObject)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, EpatchTestLanguagePackage.ASSIGNMENT_VALUE__REF_OBJECT, oldRefObject, refObject));
      }
    }
    return refObject;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamedObject basicGetRefObject()
  {
    return refObject;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRefObject(NamedObject newRefObject)
  {
    NamedObject oldRefObject = refObject;
    refObject = newRefObject;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EpatchTestLanguagePackage.ASSIGNMENT_VALUE__REF_OBJECT, oldRefObject, refObject));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getRefFeature()
  {
    return refFeature;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRefFeature(String newRefFeature)
  {
    String oldRefFeature = refFeature;
    refFeature = newRefFeature;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EpatchTestLanguagePackage.ASSIGNMENT_VALUE__REF_FEATURE, oldRefFeature, refFeature));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getRefIndex()
  {
    return refIndex;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRefIndex(int newRefIndex)
  {
    int oldRefIndex = refIndex;
    refIndex = newRefIndex;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EpatchTestLanguagePackage.ASSIGNMENT_VALUE__REF_INDEX, oldRefIndex, refIndex));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CreatedObject getNewObject()
  {
    return newObject;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetNewObject(CreatedObject newNewObject, NotificationChain msgs)
  {
    CreatedObject oldNewObject = newObject;
    newObject = newNewObject;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EpatchTestLanguagePackage.ASSIGNMENT_VALUE__NEW_OBJECT, oldNewObject, newNewObject);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNewObject(CreatedObject newNewObject)
  {
    if (newNewObject != newObject)
    {
      NotificationChain msgs = null;
      if (newObject != null)
        msgs = ((InternalEObject)newObject).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EpatchTestLanguagePackage.ASSIGNMENT_VALUE__NEW_OBJECT, null, msgs);
      if (newNewObject != null)
        msgs = ((InternalEObject)newNewObject).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EpatchTestLanguagePackage.ASSIGNMENT_VALUE__NEW_OBJECT, null, msgs);
      msgs = basicSetNewObject(newNewObject, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EpatchTestLanguagePackage.ASSIGNMENT_VALUE__NEW_OBJECT, newNewObject, newNewObject));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Import getImport()
  {
    if (import_ != null && import_.eIsProxy())
    {
      InternalEObject oldImport = (InternalEObject)import_;
      import_ = (Import)eResolveProxy(oldImport);
      if (import_ != oldImport)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, EpatchTestLanguagePackage.ASSIGNMENT_VALUE__IMPORT, oldImport, import_));
      }
    }
    return import_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Import basicGetImport()
  {
    return import_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setImport(Import newImport)
  {
    Import oldImport = import_;
    import_ = newImport;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EpatchTestLanguagePackage.ASSIGNMENT_VALUE__IMPORT, oldImport, import_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getImpFrag()
  {
    return impFrag;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setImpFrag(String newImpFrag)
  {
    String oldImpFrag = impFrag;
    impFrag = newImpFrag;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EpatchTestLanguagePackage.ASSIGNMENT_VALUE__IMP_FRAG, oldImpFrag, impFrag));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getIndex()
  {
    return index;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIndex(int newIndex)
  {
    int oldIndex = index;
    index = newIndex;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EpatchTestLanguagePackage.ASSIGNMENT_VALUE__INDEX, oldIndex, index));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getKeyword()
  {
    return keyword;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setKeyword(String newKeyword)
  {
    String oldKeyword = keyword;
    keyword = newKeyword;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EpatchTestLanguagePackage.ASSIGNMENT_VALUE__KEYWORD, oldKeyword, keyword));
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
      case EpatchTestLanguagePackage.ASSIGNMENT_VALUE__NEW_OBJECT:
        return basicSetNewObject(null, msgs);
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
      case EpatchTestLanguagePackage.ASSIGNMENT_VALUE__VALUE:
        return getValue();
      case EpatchTestLanguagePackage.ASSIGNMENT_VALUE__REF_OBJECT:
        if (resolve) return getRefObject();
        return basicGetRefObject();
      case EpatchTestLanguagePackage.ASSIGNMENT_VALUE__REF_FEATURE:
        return getRefFeature();
      case EpatchTestLanguagePackage.ASSIGNMENT_VALUE__REF_INDEX:
        return getRefIndex();
      case EpatchTestLanguagePackage.ASSIGNMENT_VALUE__NEW_OBJECT:
        return getNewObject();
      case EpatchTestLanguagePackage.ASSIGNMENT_VALUE__IMPORT:
        if (resolve) return getImport();
        return basicGetImport();
      case EpatchTestLanguagePackage.ASSIGNMENT_VALUE__IMP_FRAG:
        return getImpFrag();
      case EpatchTestLanguagePackage.ASSIGNMENT_VALUE__INDEX:
        return getIndex();
      case EpatchTestLanguagePackage.ASSIGNMENT_VALUE__KEYWORD:
        return getKeyword();
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
      case EpatchTestLanguagePackage.ASSIGNMENT_VALUE__VALUE:
        setValue((String)newValue);
        return;
      case EpatchTestLanguagePackage.ASSIGNMENT_VALUE__REF_OBJECT:
        setRefObject((NamedObject)newValue);
        return;
      case EpatchTestLanguagePackage.ASSIGNMENT_VALUE__REF_FEATURE:
        setRefFeature((String)newValue);
        return;
      case EpatchTestLanguagePackage.ASSIGNMENT_VALUE__REF_INDEX:
        setRefIndex((Integer)newValue);
        return;
      case EpatchTestLanguagePackage.ASSIGNMENT_VALUE__NEW_OBJECT:
        setNewObject((CreatedObject)newValue);
        return;
      case EpatchTestLanguagePackage.ASSIGNMENT_VALUE__IMPORT:
        setImport((Import)newValue);
        return;
      case EpatchTestLanguagePackage.ASSIGNMENT_VALUE__IMP_FRAG:
        setImpFrag((String)newValue);
        return;
      case EpatchTestLanguagePackage.ASSIGNMENT_VALUE__INDEX:
        setIndex((Integer)newValue);
        return;
      case EpatchTestLanguagePackage.ASSIGNMENT_VALUE__KEYWORD:
        setKeyword((String)newValue);
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
      case EpatchTestLanguagePackage.ASSIGNMENT_VALUE__VALUE:
        setValue(VALUE_EDEFAULT);
        return;
      case EpatchTestLanguagePackage.ASSIGNMENT_VALUE__REF_OBJECT:
        setRefObject((NamedObject)null);
        return;
      case EpatchTestLanguagePackage.ASSIGNMENT_VALUE__REF_FEATURE:
        setRefFeature(REF_FEATURE_EDEFAULT);
        return;
      case EpatchTestLanguagePackage.ASSIGNMENT_VALUE__REF_INDEX:
        setRefIndex(REF_INDEX_EDEFAULT);
        return;
      case EpatchTestLanguagePackage.ASSIGNMENT_VALUE__NEW_OBJECT:
        setNewObject((CreatedObject)null);
        return;
      case EpatchTestLanguagePackage.ASSIGNMENT_VALUE__IMPORT:
        setImport((Import)null);
        return;
      case EpatchTestLanguagePackage.ASSIGNMENT_VALUE__IMP_FRAG:
        setImpFrag(IMP_FRAG_EDEFAULT);
        return;
      case EpatchTestLanguagePackage.ASSIGNMENT_VALUE__INDEX:
        setIndex(INDEX_EDEFAULT);
        return;
      case EpatchTestLanguagePackage.ASSIGNMENT_VALUE__KEYWORD:
        setKeyword(KEYWORD_EDEFAULT);
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
      case EpatchTestLanguagePackage.ASSIGNMENT_VALUE__VALUE:
        return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
      case EpatchTestLanguagePackage.ASSIGNMENT_VALUE__REF_OBJECT:
        return refObject != null;
      case EpatchTestLanguagePackage.ASSIGNMENT_VALUE__REF_FEATURE:
        return REF_FEATURE_EDEFAULT == null ? refFeature != null : !REF_FEATURE_EDEFAULT.equals(refFeature);
      case EpatchTestLanguagePackage.ASSIGNMENT_VALUE__REF_INDEX:
        return refIndex != REF_INDEX_EDEFAULT;
      case EpatchTestLanguagePackage.ASSIGNMENT_VALUE__NEW_OBJECT:
        return newObject != null;
      case EpatchTestLanguagePackage.ASSIGNMENT_VALUE__IMPORT:
        return import_ != null;
      case EpatchTestLanguagePackage.ASSIGNMENT_VALUE__IMP_FRAG:
        return IMP_FRAG_EDEFAULT == null ? impFrag != null : !IMP_FRAG_EDEFAULT.equals(impFrag);
      case EpatchTestLanguagePackage.ASSIGNMENT_VALUE__INDEX:
        return index != INDEX_EDEFAULT;
      case EpatchTestLanguagePackage.ASSIGNMENT_VALUE__KEYWORD:
        return KEYWORD_EDEFAULT == null ? keyword != null : !KEYWORD_EDEFAULT.equals(keyword);
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
    result.append(" (value: ");
    result.append(value);
    result.append(", refFeature: ");
    result.append(refFeature);
    result.append(", refIndex: ");
    result.append(refIndex);
    result.append(", impFrag: ");
    result.append(impFrag);
    result.append(", index: ");
    result.append(index);
    result.append(", keyword: ");
    result.append(keyword);
    result.append(')');
    return result.toString();
  }

} //AssignmentValueImpl
