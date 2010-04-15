/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Attribut;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Bug304681TestLanguagePackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.ConstraintDefinition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribut</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.AttributImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.AttributImpl#getShortDescription <em>Short Description</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.AttributImpl#getLongDescription <em>Long Description</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.AttributImpl#getConstraintDefinitions <em>Constraint Definitions</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.AttributImpl#isRequired <em>Required</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.AttributImpl#isTechnical <em>Technical</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AttributImpl extends FeatureImpl implements Attribut
{
  /**
   * The default value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected static final String TYPE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected String type = TYPE_EDEFAULT;

  /**
   * The default value of the '{@link #getShortDescription() <em>Short Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getShortDescription()
   * @generated
   * @ordered
   */
  protected static final String SHORT_DESCRIPTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getShortDescription() <em>Short Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getShortDescription()
   * @generated
   * @ordered
   */
  protected String shortDescription = SHORT_DESCRIPTION_EDEFAULT;

  /**
   * The default value of the '{@link #getLongDescription() <em>Long Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLongDescription()
   * @generated
   * @ordered
   */
  protected static final String LONG_DESCRIPTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLongDescription() <em>Long Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLongDescription()
   * @generated
   * @ordered
   */
  protected String longDescription = LONG_DESCRIPTION_EDEFAULT;

  /**
   * The cached value of the '{@link #getConstraintDefinitions() <em>Constraint Definitions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstraintDefinitions()
   * @generated
   * @ordered
   */
  protected EList<ConstraintDefinition> constraintDefinitions;

  /**
   * The default value of the '{@link #isRequired() <em>Required</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isRequired()
   * @generated
   * @ordered
   */
  protected static final boolean REQUIRED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isRequired() <em>Required</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isRequired()
   * @generated
   * @ordered
   */
  protected boolean required = REQUIRED_EDEFAULT;

  /**
   * The default value of the '{@link #isTechnical() <em>Technical</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isTechnical()
   * @generated
   * @ordered
   */
  protected static final boolean TECHNICAL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isTechnical() <em>Technical</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isTechnical()
   * @generated
   * @ordered
   */
  protected boolean technical = TECHNICAL_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AttributImpl()
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
    return Bug304681TestLanguagePackage.Literals.ATTRIBUT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(String newType)
  {
    String oldType = type;
    type = newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug304681TestLanguagePackage.ATTRIBUT__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getShortDescription()
  {
    return shortDescription;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setShortDescription(String newShortDescription)
  {
    String oldShortDescription = shortDescription;
    shortDescription = newShortDescription;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug304681TestLanguagePackage.ATTRIBUT__SHORT_DESCRIPTION, oldShortDescription, shortDescription));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLongDescription()
  {
    return longDescription;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLongDescription(String newLongDescription)
  {
    String oldLongDescription = longDescription;
    longDescription = newLongDescription;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug304681TestLanguagePackage.ATTRIBUT__LONG_DESCRIPTION, oldLongDescription, longDescription));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ConstraintDefinition> getConstraintDefinitions()
  {
    if (constraintDefinitions == null)
    {
      constraintDefinitions = new EObjectContainmentEList<ConstraintDefinition>(ConstraintDefinition.class, this, Bug304681TestLanguagePackage.ATTRIBUT__CONSTRAINT_DEFINITIONS);
    }
    return constraintDefinitions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isRequired()
  {
    return required;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRequired(boolean newRequired)
  {
    boolean oldRequired = required;
    required = newRequired;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug304681TestLanguagePackage.ATTRIBUT__REQUIRED, oldRequired, required));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isTechnical()
  {
    return technical;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTechnical(boolean newTechnical)
  {
    boolean oldTechnical = technical;
    technical = newTechnical;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug304681TestLanguagePackage.ATTRIBUT__TECHNICAL, oldTechnical, technical));
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
      case Bug304681TestLanguagePackage.ATTRIBUT__CONSTRAINT_DEFINITIONS:
        return ((InternalEList<?>)getConstraintDefinitions()).basicRemove(otherEnd, msgs);
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
      case Bug304681TestLanguagePackage.ATTRIBUT__TYPE:
        return getType();
      case Bug304681TestLanguagePackage.ATTRIBUT__SHORT_DESCRIPTION:
        return getShortDescription();
      case Bug304681TestLanguagePackage.ATTRIBUT__LONG_DESCRIPTION:
        return getLongDescription();
      case Bug304681TestLanguagePackage.ATTRIBUT__CONSTRAINT_DEFINITIONS:
        return getConstraintDefinitions();
      case Bug304681TestLanguagePackage.ATTRIBUT__REQUIRED:
        return isRequired();
      case Bug304681TestLanguagePackage.ATTRIBUT__TECHNICAL:
        return isTechnical();
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
      case Bug304681TestLanguagePackage.ATTRIBUT__TYPE:
        setType((String)newValue);
        return;
      case Bug304681TestLanguagePackage.ATTRIBUT__SHORT_DESCRIPTION:
        setShortDescription((String)newValue);
        return;
      case Bug304681TestLanguagePackage.ATTRIBUT__LONG_DESCRIPTION:
        setLongDescription((String)newValue);
        return;
      case Bug304681TestLanguagePackage.ATTRIBUT__CONSTRAINT_DEFINITIONS:
        getConstraintDefinitions().clear();
        getConstraintDefinitions().addAll((Collection<? extends ConstraintDefinition>)newValue);
        return;
      case Bug304681TestLanguagePackage.ATTRIBUT__REQUIRED:
        setRequired((Boolean)newValue);
        return;
      case Bug304681TestLanguagePackage.ATTRIBUT__TECHNICAL:
        setTechnical((Boolean)newValue);
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
      case Bug304681TestLanguagePackage.ATTRIBUT__TYPE:
        setType(TYPE_EDEFAULT);
        return;
      case Bug304681TestLanguagePackage.ATTRIBUT__SHORT_DESCRIPTION:
        setShortDescription(SHORT_DESCRIPTION_EDEFAULT);
        return;
      case Bug304681TestLanguagePackage.ATTRIBUT__LONG_DESCRIPTION:
        setLongDescription(LONG_DESCRIPTION_EDEFAULT);
        return;
      case Bug304681TestLanguagePackage.ATTRIBUT__CONSTRAINT_DEFINITIONS:
        getConstraintDefinitions().clear();
        return;
      case Bug304681TestLanguagePackage.ATTRIBUT__REQUIRED:
        setRequired(REQUIRED_EDEFAULT);
        return;
      case Bug304681TestLanguagePackage.ATTRIBUT__TECHNICAL:
        setTechnical(TECHNICAL_EDEFAULT);
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
      case Bug304681TestLanguagePackage.ATTRIBUT__TYPE:
        return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
      case Bug304681TestLanguagePackage.ATTRIBUT__SHORT_DESCRIPTION:
        return SHORT_DESCRIPTION_EDEFAULT == null ? shortDescription != null : !SHORT_DESCRIPTION_EDEFAULT.equals(shortDescription);
      case Bug304681TestLanguagePackage.ATTRIBUT__LONG_DESCRIPTION:
        return LONG_DESCRIPTION_EDEFAULT == null ? longDescription != null : !LONG_DESCRIPTION_EDEFAULT.equals(longDescription);
      case Bug304681TestLanguagePackage.ATTRIBUT__CONSTRAINT_DEFINITIONS:
        return constraintDefinitions != null && !constraintDefinitions.isEmpty();
      case Bug304681TestLanguagePackage.ATTRIBUT__REQUIRED:
        return required != REQUIRED_EDEFAULT;
      case Bug304681TestLanguagePackage.ATTRIBUT__TECHNICAL:
        return technical != TECHNICAL_EDEFAULT;
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
    result.append(", shortDescription: ");
    result.append(shortDescription);
    result.append(", longDescription: ");
    result.append(longDescription);
    result.append(", required: ");
    result.append(required);
    result.append(", technical: ");
    result.append(technical);
    result.append(')');
    return result.toString();
  }

} //AttributImpl
