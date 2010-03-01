/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.parsetree.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.ParsetreePackage;
import org.eclipse.xtext.parsetree.SyntaxError;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Syntax Error</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.impl.SyntaxErrorImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.impl.SyntaxErrorImpl#getNode <em>Node</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.impl.SyntaxErrorImpl#getIssueCode <em>Issue Code</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SyntaxErrorImpl extends MinimalEObjectImpl.Container implements SyntaxError {
	/**
	 * The default value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected static final String MESSAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected String message = MESSAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getIssueCode() <em>Issue Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIssueCode()
	 * @generated
	 * @ordered
	 */
	protected static final String ISSUE_CODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIssueCode() <em>Issue Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIssueCode()
	 * @generated
	 * @ordered
	 */
	protected String issueCode = ISSUE_CODE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SyntaxErrorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ParsetreePackage.Literals.SYNTAX_ERROR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessage(String newMessage) {
		String oldMessage = message;
		message = newMessage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParsetreePackage.SYNTAX_ERROR__MESSAGE, oldMessage, message));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractNode getNode() {
		if (eContainerFeatureID() != ParsetreePackage.SYNTAX_ERROR__NODE) return null;
		return (AbstractNode)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNode(AbstractNode newNode, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newNode, ParsetreePackage.SYNTAX_ERROR__NODE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNode(AbstractNode newNode) {
		if (newNode != eInternalContainer() || (eContainerFeatureID() != ParsetreePackage.SYNTAX_ERROR__NODE && newNode != null)) {
			if (EcoreUtil.isAncestor(this, newNode))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newNode != null)
				msgs = ((InternalEObject)newNode).eInverseAdd(this, ParsetreePackage.ABSTRACT_NODE__SYNTAX_ERROR, AbstractNode.class, msgs);
			msgs = basicSetNode(newNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParsetreePackage.SYNTAX_ERROR__NODE, newNode, newNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIssueCode() {
		return issueCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIssueCode(String newIssueCode) {
		String oldIssueCode = issueCode;
		issueCode = newIssueCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParsetreePackage.SYNTAX_ERROR__ISSUE_CODE, oldIssueCode, issueCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ParsetreePackage.SYNTAX_ERROR__NODE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetNode((AbstractNode)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ParsetreePackage.SYNTAX_ERROR__NODE:
				return basicSetNode(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case ParsetreePackage.SYNTAX_ERROR__NODE:
				return eInternalContainer().eInverseRemove(this, ParsetreePackage.ABSTRACT_NODE__SYNTAX_ERROR, AbstractNode.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ParsetreePackage.SYNTAX_ERROR__MESSAGE:
				return getMessage();
			case ParsetreePackage.SYNTAX_ERROR__NODE:
				return getNode();
			case ParsetreePackage.SYNTAX_ERROR__ISSUE_CODE:
				return getIssueCode();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ParsetreePackage.SYNTAX_ERROR__MESSAGE:
				setMessage((String)newValue);
				return;
			case ParsetreePackage.SYNTAX_ERROR__NODE:
				setNode((AbstractNode)newValue);
				return;
			case ParsetreePackage.SYNTAX_ERROR__ISSUE_CODE:
				setIssueCode((String)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case ParsetreePackage.SYNTAX_ERROR__MESSAGE:
				setMessage(MESSAGE_EDEFAULT);
				return;
			case ParsetreePackage.SYNTAX_ERROR__NODE:
				setNode((AbstractNode)null);
				return;
			case ParsetreePackage.SYNTAX_ERROR__ISSUE_CODE:
				setIssueCode(ISSUE_CODE_EDEFAULT);
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ParsetreePackage.SYNTAX_ERROR__MESSAGE:
				return MESSAGE_EDEFAULT == null ? message != null : !MESSAGE_EDEFAULT.equals(message);
			case ParsetreePackage.SYNTAX_ERROR__NODE:
				return getNode() != null;
			case ParsetreePackage.SYNTAX_ERROR__ISSUE_CODE:
				return ISSUE_CODE_EDEFAULT == null ? issueCode != null : !ISSUE_CODE_EDEFAULT.equals(issueCode);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (message: ");
		result.append(message);
		result.append(", issueCode: ");
		result.append(issueCode);
		result.append(')');
		return result.toString();
	}

} //SyntaxErrorImpl
