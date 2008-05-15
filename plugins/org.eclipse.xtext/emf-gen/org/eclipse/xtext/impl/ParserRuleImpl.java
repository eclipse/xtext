/**
 * <copyright>
 * </copyright>
 *
 * $Id: ParserRuleImpl.java,v 1.5 2008/05/15 15:53:45 jkohnlein Exp $
 */
package org.eclipse.xtext.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.XtextPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parser Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.impl.ParserRuleImpl#getAlternatives <em>Alternatives</em>}</li>
 *   <li>{@link org.eclipse.xtext.impl.ParserRuleImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParserRuleImpl extends AbstractRuleImpl implements ParserRule
{
  /**
	 * The cached value of the '{@link #getAlternatives() <em>Alternatives</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getAlternatives()
	 * @generated
	 * @ordered
	 */
				protected AbstractElement alternatives;

				/**
				* The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
				* <!-- begin-user-doc -->
				 * <!-- end-user-doc -->
				* @see #getType()
				* @generated
				* @ordered
				*/
				  protected TypeRef type;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected ParserRuleImpl()
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
		return XtextPackage.Literals.PARSER_RULE;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AbstractElement getAlternatives()
  {
		return alternatives;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetAlternatives(AbstractElement newAlternatives, NotificationChain msgs)
  {
		AbstractElement oldAlternatives = alternatives;
		alternatives = newAlternatives;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XtextPackage.PARSER_RULE__ALTERNATIVES, oldAlternatives, newAlternatives);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setAlternatives(AbstractElement newAlternatives)
  {
		if (newAlternatives != alternatives) {
			NotificationChain msgs = null;
			if (alternatives != null)
				msgs = ((InternalEObject)alternatives).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XtextPackage.PARSER_RULE__ALTERNATIVES, null, msgs);
			if (newAlternatives != null)
				msgs = ((InternalEObject)newAlternatives).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XtextPackage.PARSER_RULE__ALTERNATIVES, null, msgs);
			msgs = basicSetAlternatives(newAlternatives, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtextPackage.PARSER_RULE__ALTERNATIVES, newAlternatives, newAlternatives));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TypeRef getType()
  {
		return type;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetType(TypeRef newType, NotificationChain msgs)
  {
		TypeRef oldType = type;
		type = newType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XtextPackage.PARSER_RULE__TYPE, oldType, newType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setType(TypeRef newType)
  {
		if (newType != type) {
			NotificationChain msgs = null;
			if (type != null)
				msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XtextPackage.PARSER_RULE__TYPE, null, msgs);
			if (newType != null)
				msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XtextPackage.PARSER_RULE__TYPE, null, msgs);
			msgs = basicSetType(newType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XtextPackage.PARSER_RULE__TYPE, newType, newType));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
		switch (featureID) {
			case XtextPackage.PARSER_RULE__ALTERNATIVES:
				return basicSetAlternatives(null, msgs);
			case XtextPackage.PARSER_RULE__TYPE:
				return basicSetType(null, msgs);
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
		switch (featureID) {
			case XtextPackage.PARSER_RULE__ALTERNATIVES:
				return getAlternatives();
			case XtextPackage.PARSER_RULE__TYPE:
				return getType();
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
		switch (featureID) {
			case XtextPackage.PARSER_RULE__ALTERNATIVES:
				setAlternatives((AbstractElement)newValue);
				return;
			case XtextPackage.PARSER_RULE__TYPE:
				setType((TypeRef)newValue);
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
		switch (featureID) {
			case XtextPackage.PARSER_RULE__ALTERNATIVES:
				setAlternatives((AbstractElement)null);
				return;
			case XtextPackage.PARSER_RULE__TYPE:
				setType((TypeRef)null);
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
		switch (featureID) {
			case XtextPackage.PARSER_RULE__ALTERNATIVES:
				return alternatives != null;
			case XtextPackage.PARSER_RULE__TYPE:
				return type != null;
		}
		return super.eIsSet(featureID);
	}

} //ParserRuleImpl
