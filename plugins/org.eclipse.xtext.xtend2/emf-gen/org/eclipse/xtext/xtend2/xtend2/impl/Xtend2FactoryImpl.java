/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xtend2.xtend2.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.xtend2.xtend2.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Xtend2FactoryImpl extends EFactoryImpl implements Xtend2Factory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Xtend2Factory init()
	{
		try
		{
			Xtend2Factory theXtend2Factory = (Xtend2Factory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/xtext/Xtend2"); 
			if (theXtend2Factory != null)
			{
				return theXtend2Factory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Xtend2FactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Xtend2FactoryImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass)
	{
		switch (eClass.getClassifierID())
		{
			case Xtend2Package.XTEND_FILE: return createXtendFile();
			case Xtend2Package.XTEND_IMPORT: return createXtendImport();
			case Xtend2Package.XTEND_CLASS: return createXtendClass();
			case Xtend2Package.XTEND_CLASS_SUPER_CALL_REFERABLE: return createXtendClassSuperCallReferable();
			case Xtend2Package.XTEND_MEMBER: return createXtendMember();
			case Xtend2Package.XTEND_FUNCTION: return createXtendFunction();
			case Xtend2Package.XTEND_FIELD: return createXtendField();
			case Xtend2Package.XTEND_PARAMETER: return createXtendParameter();
			case Xtend2Package.RICH_STRING: return createRichString();
			case Xtend2Package.RICH_STRING_LITERAL: return createRichStringLiteral();
			case Xtend2Package.RICH_STRING_FOR_LOOP: return createRichStringForLoop();
			case Xtend2Package.RICH_STRING_IF: return createRichStringIf();
			case Xtend2Package.RICH_STRING_ELSE_IF: return createRichStringElseIf();
			case Xtend2Package.CREATE_EXTENSION_INFO: return createCreateExtensionInfo();
			case Xtend2Package.XTEND_CONSTRUCTOR: return createXtendConstructor();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XtendFile createXtendFile()
	{
		XtendFileImpl xtendFile = new XtendFileImpl();
		return xtendFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XtendImport createXtendImport()
	{
		XtendImportImplCustom xtendImport = new XtendImportImplCustom();
		return xtendImport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XtendClass createXtendClass()
	{
		XtendClassImplCustom xtendClass = new XtendClassImplCustom();
		return xtendClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XtendClassSuperCallReferable createXtendClassSuperCallReferable()
	{
		XtendClassSuperCallReferableImpl xtendClassSuperCallReferable = new XtendClassSuperCallReferableImpl();
		return xtendClassSuperCallReferable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XtendMember createXtendMember()
	{
		XtendMemberImplCustom xtendMember = new XtendMemberImplCustom();
		return xtendMember;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XtendFunction createXtendFunction()
	{
		XtendFunctionImpl xtendFunction = new XtendFunctionImpl();
		return xtendFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XtendField createXtendField()
	{
		XtendFieldImpl xtendField = new XtendFieldImpl();
		return xtendField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XtendParameter createXtendParameter()
	{
		XtendParameterImpl xtendParameter = new XtendParameterImpl();
		return xtendParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RichString createRichString()
	{
		RichStringImpl richString = new RichStringImpl();
		return richString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RichStringLiteral createRichStringLiteral()
	{
		RichStringLiteralImpl richStringLiteral = new RichStringLiteralImpl();
		return richStringLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RichStringForLoop createRichStringForLoop()
	{
		RichStringForLoopImpl richStringForLoop = new RichStringForLoopImpl();
		return richStringForLoop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RichStringIf createRichStringIf()
	{
		RichStringIfImpl richStringIf = new RichStringIfImpl();
		return richStringIf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RichStringElseIf createRichStringElseIf()
	{
		RichStringElseIfImpl richStringElseIf = new RichStringElseIfImpl();
		return richStringElseIf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreateExtensionInfo createCreateExtensionInfo()
	{
		CreateExtensionInfoImpl createExtensionInfo = new CreateExtensionInfoImpl();
		return createExtensionInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XtendConstructor createXtendConstructor()
	{
		XtendConstructorImpl xtendConstructor = new XtendConstructorImpl();
		return xtendConstructor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Xtend2Package getXtend2Package()
	{
		return (Xtend2Package)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Xtend2Package getPackage()
	{
		return Xtend2Package.eINSTANCE;
	}

} //Xtend2FactoryImpl
