/*
Generated with Xtext
*/
package org.eclipse.xtext.example.parser.packrat;

import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;

import org.eclipse.xtext.builtin.parser.packrat.XtextBuiltinParserConfiguration; 

import org.eclipse.xtext.example.parser.packrat.consumers.EcoreDslEcoreDslConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.EcoreDslImportStatementDeclConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.EcoreDslEPackageDeclConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.EcoreDslSubEPackageDeclConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.EcoreDslEClassifierDeclConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.EcoreDslEDataTypeDeclConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.EcoreDslEAnnotationDeclConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.EcoreDslEClassDeclConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.EcoreDslEStructuralFeatureDeclConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.EcoreDslEAttributeDeclConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.EcoreDslEReferenceDeclConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.EcoreDslEEnumDeclConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.EcoreDslEEnumLiteralDeclConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.EcoreDslETypeParameterDeclConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.EcoreDslEGenericTypeReferenceDeclConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.EcoreDslEGenericTypeDeclConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.EcoreDslEOperationDeclConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.EcoreDslEParameterDeclConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.EcoreDslMapEntrySuperConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.EcoreDslMapEntryConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.EcoreDslMultiplicityExprConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.EcoreDslQIDConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.EcoreDslSTRING_OR_QIDConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.EcoreDslSINTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinML_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSL_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinWSConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinANY_OTHERConsumer;

@SuppressWarnings("unused")
public class EcoreDslParserConfiguration extends AbstractParserConfiguration {

	private XtextBuiltinParserConfiguration xtextBuiltinConfiguration; 

    private EcoreDslEcoreDslConsumer ecoreDslConsumer;
    private EcoreDslImportStatementDeclConsumer importStatementDeclConsumer;
    private EcoreDslEPackageDeclConsumer ePackageDeclConsumer;
    private EcoreDslSubEPackageDeclConsumer subEPackageDeclConsumer;
    private EcoreDslEClassifierDeclConsumer eClassifierDeclConsumer;
    private EcoreDslEDataTypeDeclConsumer eDataTypeDeclConsumer;
    private EcoreDslEAnnotationDeclConsumer eAnnotationDeclConsumer;
    private EcoreDslEClassDeclConsumer eClassDeclConsumer;
    private EcoreDslEStructuralFeatureDeclConsumer eStructuralFeatureDeclConsumer;
    private EcoreDslEAttributeDeclConsumer eAttributeDeclConsumer;
    private EcoreDslEReferenceDeclConsumer eReferenceDeclConsumer;
    private EcoreDslEEnumDeclConsumer eEnumDeclConsumer;
    private EcoreDslEEnumLiteralDeclConsumer eEnumLiteralDeclConsumer;
    private EcoreDslETypeParameterDeclConsumer eTypeParameterDeclConsumer;
    private EcoreDslEGenericTypeReferenceDeclConsumer eGenericTypeReferenceDeclConsumer;
    private EcoreDslEGenericTypeDeclConsumer eGenericTypeDeclConsumer;
    private EcoreDslEOperationDeclConsumer eOperationDeclConsumer;
    private EcoreDslEParameterDeclConsumer eParameterDeclConsumer;
    private EcoreDslMapEntrySuperConsumer mapEntrySuperConsumer;
    private EcoreDslMapEntryConsumer mapEntryConsumer;
    private EcoreDslMultiplicityExprConsumer multiplicityExprConsumer;
    private EcoreDslQIDConsumer qidConsumer;
    private EcoreDslSTRING_OR_QIDConsumer stringOrQidConsumer;
    private EcoreDslSINTConsumer sintConsumer;

	public EcoreDslParserConfiguration(IInternalParserConfiguration configuration) {
		super(configuration);
		this.xtextBuiltinConfiguration = new XtextBuiltinParserConfiguration(configuration);
	}

	public EcoreDslEcoreDslConsumer getRootConsumer() {
		return ecoreDslConsumer;
	} 

	public void createNonTerminalConsumers() {
		getXtextBuiltinConfiguration().createNonTerminalConsumers();
		ecoreDslConsumer = new EcoreDslEcoreDslConsumer(
    		this, null
    	);
		importStatementDeclConsumer = new EcoreDslImportStatementDeclConsumer(
    		this, null
    	);
		ePackageDeclConsumer = new EcoreDslEPackageDeclConsumer(
    		this, null
    	);
		subEPackageDeclConsumer = new EcoreDslSubEPackageDeclConsumer(
    		this, null
    	);
		eClassifierDeclConsumer = new EcoreDslEClassifierDeclConsumer(
    		this, null
    	);
		eDataTypeDeclConsumer = new EcoreDslEDataTypeDeclConsumer(
    		this, null
    	);
		eAnnotationDeclConsumer = new EcoreDslEAnnotationDeclConsumer(
    		this, null
    	);
		eClassDeclConsumer = new EcoreDslEClassDeclConsumer(
    		this, null
    	);
		eStructuralFeatureDeclConsumer = new EcoreDslEStructuralFeatureDeclConsumer(
    		this, null
    	);
		eAttributeDeclConsumer = new EcoreDslEAttributeDeclConsumer(
    		this, null
    	);
		eReferenceDeclConsumer = new EcoreDslEReferenceDeclConsumer(
    		this, null
    	);
		eEnumDeclConsumer = new EcoreDslEEnumDeclConsumer(
    		this, null
    	);
		eEnumLiteralDeclConsumer = new EcoreDslEEnumLiteralDeclConsumer(
    		this, null
    	);
		eTypeParameterDeclConsumer = new EcoreDslETypeParameterDeclConsumer(
    		this, null
    	);
		eGenericTypeReferenceDeclConsumer = new EcoreDslEGenericTypeReferenceDeclConsumer(
    		this, null
    	);
		eGenericTypeDeclConsumer = new EcoreDslEGenericTypeDeclConsumer(
    		this, null
    	);
		eOperationDeclConsumer = new EcoreDslEOperationDeclConsumer(
    		this, null
    	);
		eParameterDeclConsumer = new EcoreDslEParameterDeclConsumer(
    		this, null
    	);
		mapEntrySuperConsumer = new EcoreDslMapEntrySuperConsumer(
    		this, null
    	);
		mapEntryConsumer = new EcoreDslMapEntryConsumer(
    		this, null
    	);
		multiplicityExprConsumer = new EcoreDslMultiplicityExprConsumer(
    		this, null
    	);
		qidConsumer = new EcoreDslQIDConsumer(
    		this, null
    	);
		stringOrQidConsumer = new EcoreDslSTRING_OR_QIDConsumer(
    		this, null
    	);
		sintConsumer = new EcoreDslSINTConsumer(
    		this, null
    	);
	}
	
	public void createTerminalConsumers() {
		getXtextBuiltinConfiguration().createTerminalConsumers();
	}
	
	public void configureConsumers() {
		getEcoreDslConsumer().setEPackageDeclConsumer(getEPackageDeclConsumer());
		getEcoreDslConsumer().setImportStatementDeclConsumer(getImportStatementDeclConsumer());

		getImportStatementDeclConsumer().setIdConsumer(getIdConsumer());
		getImportStatementDeclConsumer().setStringConsumer(getStringConsumer());

		getEPackageDeclConsumer().setEAnnotationDeclConsumer(getEAnnotationDeclConsumer());
		getEPackageDeclConsumer().setEClassifierDeclConsumer(getEClassifierDeclConsumer());
		getEPackageDeclConsumer().setQidConsumer(getQidConsumer());
		getEPackageDeclConsumer().setStringConsumer(getStringConsumer());
		getEPackageDeclConsumer().setSubEPackageDeclConsumer(getSubEPackageDeclConsumer());

		getSubEPackageDeclConsumer().setEAnnotationDeclConsumer(getEAnnotationDeclConsumer());
		getSubEPackageDeclConsumer().setEClassifierDeclConsumer(getEClassifierDeclConsumer());
		getSubEPackageDeclConsumer().setIdConsumer(getIdConsumer());
		getSubEPackageDeclConsumer().setSubEPackageDeclConsumer(getSubEPackageDeclConsumer());

		getEClassifierDeclConsumer().setEClassDeclConsumer(getEClassDeclConsumer());
		getEClassifierDeclConsumer().setEDataTypeDeclConsumer(getEDataTypeDeclConsumer());

		getEDataTypeDeclConsumer().setEAnnotationDeclConsumer(getEAnnotationDeclConsumer());
		getEDataTypeDeclConsumer().setEEnumDeclConsumer(getEEnumDeclConsumer());
		getEDataTypeDeclConsumer().setIdConsumer(getIdConsumer());
		getEDataTypeDeclConsumer().setStringOrQidConsumer(getStringOrQidConsumer());

		getEAnnotationDeclConsumer().setIdConsumer(getIdConsumer());
		getEAnnotationDeclConsumer().setMapEntrySuperConsumer(getMapEntrySuperConsumer());
		getEAnnotationDeclConsumer().setStringConsumer(getStringConsumer());

		getEClassDeclConsumer().setEAnnotationDeclConsumer(getEAnnotationDeclConsumer());
		getEClassDeclConsumer().setEGenericTypeReferenceDeclConsumer(getEGenericTypeReferenceDeclConsumer());
		getEClassDeclConsumer().setEOperationDeclConsumer(getEOperationDeclConsumer());
		getEClassDeclConsumer().setEStructuralFeatureDeclConsumer(getEStructuralFeatureDeclConsumer());
		getEClassDeclConsumer().setETypeParameterDeclConsumer(getETypeParameterDeclConsumer());
		getEClassDeclConsumer().setIdConsumer(getIdConsumer());
		getEClassDeclConsumer().setStringOrQidConsumer(getStringOrQidConsumer());

		getEStructuralFeatureDeclConsumer().setEAttributeDeclConsumer(getEAttributeDeclConsumer());
		getEStructuralFeatureDeclConsumer().setEReferenceDeclConsumer(getEReferenceDeclConsumer());

		getEAttributeDeclConsumer().setEAnnotationDeclConsumer(getEAnnotationDeclConsumer());
		getEAttributeDeclConsumer().setEGenericTypeReferenceDeclConsumer(getEGenericTypeReferenceDeclConsumer());
		getEAttributeDeclConsumer().setIdConsumer(getIdConsumer());
		getEAttributeDeclConsumer().setIntConsumer(getIntConsumer());
		getEAttributeDeclConsumer().setSintConsumer(getSintConsumer());
		getEAttributeDeclConsumer().setStringConsumer(getStringConsumer());

		getEReferenceDeclConsumer().setEAnnotationDeclConsumer(getEAnnotationDeclConsumer());
		getEReferenceDeclConsumer().setEGenericTypeReferenceDeclConsumer(getEGenericTypeReferenceDeclConsumer());
		getEReferenceDeclConsumer().setIdConsumer(getIdConsumer());
		getEReferenceDeclConsumer().setIntConsumer(getIntConsumer());
		getEReferenceDeclConsumer().setSintConsumer(getSintConsumer());

		getEEnumDeclConsumer().setEAnnotationDeclConsumer(getEAnnotationDeclConsumer());
		getEEnumDeclConsumer().setEEnumLiteralDeclConsumer(getEEnumLiteralDeclConsumer());
		getEEnumDeclConsumer().setIdConsumer(getIdConsumer());

		getEEnumLiteralDeclConsumer().setEAnnotationDeclConsumer(getEAnnotationDeclConsumer());
		getEEnumLiteralDeclConsumer().setIdConsumer(getIdConsumer());
		getEEnumLiteralDeclConsumer().setIntConsumer(getIntConsumer());
		getEEnumLiteralDeclConsumer().setStringConsumer(getStringConsumer());

		getETypeParameterDeclConsumer().setEGenericTypeDeclConsumer(getEGenericTypeDeclConsumer());
		getETypeParameterDeclConsumer().setIdConsumer(getIdConsumer());

		getEGenericTypeReferenceDeclConsumer().setEGenericTypeDeclConsumer(getEGenericTypeDeclConsumer());
		getEGenericTypeReferenceDeclConsumer().setIdConsumer(getIdConsumer());

		getEGenericTypeDeclConsumer().setEGenericTypeDeclConsumer(getEGenericTypeDeclConsumer());
		getEGenericTypeDeclConsumer().setIdConsumer(getIdConsumer());

		getEOperationDeclConsumer().setEAnnotationDeclConsumer(getEAnnotationDeclConsumer());
		getEOperationDeclConsumer().setEGenericTypeReferenceDeclConsumer(getEGenericTypeReferenceDeclConsumer());
		getEOperationDeclConsumer().setEParameterDeclConsumer(getEParameterDeclConsumer());
		getEOperationDeclConsumer().setETypeParameterDeclConsumer(getETypeParameterDeclConsumer());
		getEOperationDeclConsumer().setIdConsumer(getIdConsumer());

		getEParameterDeclConsumer().setEAnnotationDeclConsumer(getEAnnotationDeclConsumer());
		getEParameterDeclConsumer().setEGenericTypeReferenceDeclConsumer(getEGenericTypeReferenceDeclConsumer());
		getEParameterDeclConsumer().setIdConsumer(getIdConsumer());

		getMapEntrySuperConsumer().setMapEntryConsumer(getMapEntryConsumer());

		getMapEntryConsumer().setIdConsumer(getIdConsumer());
		getMapEntryConsumer().setStringConsumer(getStringConsumer());

		getQidConsumer().setIdConsumer(getIdConsumer());

		getStringOrQidConsumer().setQidConsumer(getQidConsumer());
		getStringOrQidConsumer().setStringConsumer(getStringConsumer());

		getSintConsumer().setIntConsumer(getIntConsumer());

		getImportStatementDeclConsumer().setKeyword$4$Delimiter(EcoreDslDelimiters.keyword$14$Delimiter);
		getImportStatementDeclConsumer().setKeyword$8$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getImportStatementDeclConsumer().setKeyword$11$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getImportStatementDeclConsumer().setRuleCall$7$Delimiter(EcoreDslDelimiters.ruleCall$17$Delimiter);
		getImportStatementDeclConsumer().setRuleCall$10$Delimiter(EcoreDslDelimiters.ruleCall$20$Delimiter);
		getEPackageDeclConsumer().setKeyword$14$Delimiter(EcoreDslDelimiters.keyword$14$Delimiter);
		getEPackageDeclConsumer().setKeyword$17$Delimiter(EcoreDslDelimiters.keyword$14$Delimiter);
		getEPackageDeclConsumer().setKeyword$18$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getEPackageDeclConsumer().setKeyword$21$Delimiter(EcoreDslDelimiters.keyword$14$Delimiter);
		getEPackageDeclConsumer().setKeyword$22$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getEPackageDeclConsumer().setKeyword$25$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getEPackageDeclConsumer().setKeyword$31$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getEPackageDeclConsumer().setRuleCall$20$Delimiter(EcoreDslDelimiters.ruleCall$20$Delimiter);
		getSubEPackageDeclConsumer().setKeyword$8$Delimiter(EcoreDslDelimiters.keyword$14$Delimiter);
		getSubEPackageDeclConsumer().setKeyword$11$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getSubEPackageDeclConsumer().setKeyword$17$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getSubEPackageDeclConsumer().setRuleCall$10$Delimiter(EcoreDslDelimiters.ruleCall$17$Delimiter);
		getEDataTypeDeclConsumer().setKeyword$7$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getEDataTypeDeclConsumer().setKeyword$12$Delimiter(EcoreDslDelimiters.keyword$14$Delimiter);
		getEDataTypeDeclConsumer().setKeyword$15$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getEDataTypeDeclConsumer().setKeyword$18$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getEDataTypeDeclConsumer().setRuleCall$14$Delimiter(EcoreDslDelimiters.ruleCall$17$Delimiter);
		getEAnnotationDeclConsumer().setCrossReference$11$Delimiter(EcoreDslDelimiters.ruleCall$17$Delimiter);
		getEAnnotationDeclConsumer().setKeyword$7$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getEAnnotationDeclConsumer().setKeyword$13$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getEAnnotationDeclConsumer().setKeyword$17$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getEAnnotationDeclConsumer().setKeyword$20$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getEAnnotationDeclConsumer().setRuleCall$9$Delimiter(EcoreDslDelimiters.ruleCall$20$Delimiter);
		getEClassDeclConsumer().setKeyword$13$Delimiter(EcoreDslDelimiters.keyword$14$Delimiter);
		getEClassDeclConsumer().setKeyword$16$Delimiter(EcoreDslDelimiters.keyword$14$Delimiter);
		getEClassDeclConsumer().setKeyword$17$Delimiter(EcoreDslDelimiters.keyword$14$Delimiter);
		getEClassDeclConsumer().setKeyword$23$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getEClassDeclConsumer().setKeyword$27$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getEClassDeclConsumer().setKeyword$30$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getEClassDeclConsumer().setKeyword$33$Delimiter(EcoreDslDelimiters.keyword$14$Delimiter);
		getEClassDeclConsumer().setKeyword$37$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getEClassDeclConsumer().setKeyword$41$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getEClassDeclConsumer().setKeyword$44$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getEClassDeclConsumer().setKeyword$50$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getEClassDeclConsumer().setRuleCall$19$Delimiter(EcoreDslDelimiters.ruleCall$17$Delimiter);
		getEAttributeDeclConsumer().setKeyword$18$Delimiter(EcoreDslDelimiters.keyword$14$Delimiter);
		getEAttributeDeclConsumer().setKeyword$20$Delimiter(EcoreDslDelimiters.keyword$14$Delimiter);
		getEAttributeDeclConsumer().setKeyword$22$Delimiter(EcoreDslDelimiters.keyword$14$Delimiter);
		getEAttributeDeclConsumer().setKeyword$24$Delimiter(EcoreDslDelimiters.keyword$14$Delimiter);
		getEAttributeDeclConsumer().setKeyword$26$Delimiter(EcoreDslDelimiters.keyword$14$Delimiter);
		getEAttributeDeclConsumer().setKeyword$28$Delimiter(EcoreDslDelimiters.keyword$14$Delimiter);
		getEAttributeDeclConsumer().setKeyword$30$Delimiter(EcoreDslDelimiters.keyword$14$Delimiter);
		getEAttributeDeclConsumer().setKeyword$32$Delimiter(EcoreDslDelimiters.keyword$14$Delimiter);
		getEAttributeDeclConsumer().setKeyword$33$Delimiter(EcoreDslDelimiters.keyword$14$Delimiter);
		getEAttributeDeclConsumer().setKeyword$39$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getEAttributeDeclConsumer().setKeyword$43$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getEAttributeDeclConsumer().setKeyword$46$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getEAttributeDeclConsumer().setKeyword$50$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getEAttributeDeclConsumer().setKeyword$53$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getEAttributeDeclConsumer().setRuleCall$41$Delimiter(EcoreDslDelimiters.ruleCall$20$Delimiter);
		getEAttributeDeclConsumer().setRuleCall$48$Delimiter(EcoreDslDelimiters.ruleCall$17$Delimiter);
		getEAttributeDeclConsumer().setRuleCall$52$Delimiter(EcoreDslDelimiters.ruleCall$20$Delimiter);
		getEReferenceDeclConsumer().setCrossReference$53$Delimiter(EcoreDslDelimiters.ruleCall$17$Delimiter);
		getEReferenceDeclConsumer().setKeyword$18$Delimiter(EcoreDslDelimiters.keyword$14$Delimiter);
		getEReferenceDeclConsumer().setKeyword$20$Delimiter(EcoreDslDelimiters.keyword$14$Delimiter);
		getEReferenceDeclConsumer().setKeyword$22$Delimiter(EcoreDslDelimiters.keyword$14$Delimiter);
		getEReferenceDeclConsumer().setKeyword$24$Delimiter(EcoreDslDelimiters.keyword$14$Delimiter);
		getEReferenceDeclConsumer().setKeyword$26$Delimiter(EcoreDslDelimiters.keyword$14$Delimiter);
		getEReferenceDeclConsumer().setKeyword$28$Delimiter(EcoreDslDelimiters.keyword$14$Delimiter);
		getEReferenceDeclConsumer().setKeyword$30$Delimiter(EcoreDslDelimiters.keyword$14$Delimiter);
		getEReferenceDeclConsumer().setKeyword$32$Delimiter(EcoreDslDelimiters.keyword$14$Delimiter);
		getEReferenceDeclConsumer().setKeyword$35$Delimiter(EcoreDslDelimiters.keyword$14$Delimiter);
		getEReferenceDeclConsumer().setKeyword$36$Delimiter(EcoreDslDelimiters.keyword$14$Delimiter);
		getEReferenceDeclConsumer().setKeyword$42$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getEReferenceDeclConsumer().setKeyword$46$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getEReferenceDeclConsumer().setKeyword$49$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getEReferenceDeclConsumer().setKeyword$51$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getEReferenceDeclConsumer().setKeyword$57$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getEReferenceDeclConsumer().setRuleCall$44$Delimiter(EcoreDslDelimiters.ruleCall$20$Delimiter);
		getEReferenceDeclConsumer().setRuleCall$56$Delimiter(EcoreDslDelimiters.ruleCall$17$Delimiter);
		getEEnumDeclConsumer().setKeyword$8$Delimiter(EcoreDslDelimiters.keyword$14$Delimiter);
		getEEnumDeclConsumer().setKeyword$11$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getEEnumDeclConsumer().setKeyword$14$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getEEnumDeclConsumer().setRuleCall$10$Delimiter(EcoreDslDelimiters.ruleCall$17$Delimiter);
		getEEnumLiteralDeclConsumer().setKeyword$10$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getEEnumLiteralDeclConsumer().setKeyword$15$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getEEnumLiteralDeclConsumer().setRuleCall$8$Delimiter(EcoreDslDelimiters.ruleCall$17$Delimiter);
		getEEnumLiteralDeclConsumer().setRuleCall$12$Delimiter(EcoreDslDelimiters.ruleCall$20$Delimiter);
		getEEnumLiteralDeclConsumer().setRuleCall$14$Delimiter(EcoreDslDelimiters.ruleCall$20$Delimiter);
		getETypeParameterDeclConsumer().setKeyword$5$Delimiter(EcoreDslDelimiters.keyword$14$Delimiter);
		getETypeParameterDeclConsumer().setRuleCall$3$Delimiter(EcoreDslDelimiters.ruleCall$17$Delimiter);
		getEGenericTypeReferenceDeclConsumer().setCrossReference$4$Delimiter(EcoreDslDelimiters.ruleCall$17$Delimiter);
		getEGenericTypeReferenceDeclConsumer().setCrossReference$20$Delimiter(EcoreDslDelimiters.ruleCall$17$Delimiter);
		getEGenericTypeReferenceDeclConsumer().setKeyword$9$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getEGenericTypeReferenceDeclConsumer().setKeyword$13$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getEGenericTypeReferenceDeclConsumer().setKeyword$16$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getEGenericTypeReferenceDeclConsumer().setKeyword$18$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getEGenericTypeDeclConsumer().setCrossReference$5$Delimiter(EcoreDslDelimiters.ruleCall$17$Delimiter);
		getEGenericTypeDeclConsumer().setCrossReference$21$Delimiter(EcoreDslDelimiters.ruleCall$17$Delimiter);
		getEGenericTypeDeclConsumer().setKeyword$10$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getEGenericTypeDeclConsumer().setKeyword$14$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getEGenericTypeDeclConsumer().setKeyword$17$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getEGenericTypeDeclConsumer().setKeyword$19$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getEGenericTypeDeclConsumer().setKeyword$24$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getEGenericTypeDeclConsumer().setKeyword$27$Delimiter(EcoreDslDelimiters.keyword$14$Delimiter);
		getEGenericTypeDeclConsumer().setKeyword$31$Delimiter(EcoreDslDelimiters.keyword$14$Delimiter);
		getEOperationDeclConsumer().setKeyword$15$Delimiter(EcoreDslDelimiters.keyword$14$Delimiter);
		getEOperationDeclConsumer().setKeyword$17$Delimiter(EcoreDslDelimiters.keyword$14$Delimiter);
		getEOperationDeclConsumer().setKeyword$18$Delimiter(EcoreDslDelimiters.keyword$14$Delimiter);
		getEOperationDeclConsumer().setKeyword$22$Delimiter(EcoreDslDelimiters.keyword$14$Delimiter);
		getEOperationDeclConsumer().setKeyword$28$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getEOperationDeclConsumer().setKeyword$32$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getEOperationDeclConsumer().setKeyword$35$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getEOperationDeclConsumer().setKeyword$36$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getEOperationDeclConsumer().setKeyword$41$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getEOperationDeclConsumer().setKeyword$44$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getEOperationDeclConsumer().setKeyword$47$Delimiter(EcoreDslDelimiters.keyword$14$Delimiter);
		getEOperationDeclConsumer().setKeyword$51$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getEOperationDeclConsumer().setKeyword$54$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getEOperationDeclConsumer().setRuleCall$24$Delimiter(EcoreDslDelimiters.ruleCall$17$Delimiter);
		getEParameterDeclConsumer().setRuleCall$8$Delimiter(EcoreDslDelimiters.ruleCall$17$Delimiter);
		getMapEntryConsumer().setKeyword$5$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getMapEntryConsumer().setRuleCall$4$Delimiter(EcoreDslDelimiters.ruleCall$17$Delimiter);
		getMapEntryConsumer().setRuleCall$7$Delimiter(EcoreDslDelimiters.ruleCall$20$Delimiter);
		getMultiplicityExprConsumer().setKeyword$3$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getMultiplicityExprConsumer().setKeyword$4$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getMultiplicityExprConsumer().setKeyword$5$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getQidConsumer().setKeyword$5$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getQidConsumer().setKeyword$6$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getQidConsumer().setRuleCall$2$Delimiter(EcoreDslDelimiters.ruleCall$17$Delimiter);
		getQidConsumer().setRuleCall$7$Delimiter(EcoreDslDelimiters.ruleCall$17$Delimiter);
		getStringOrQidConsumer().setRuleCall$2$Delimiter(EcoreDslDelimiters.ruleCall$20$Delimiter);
		getSintConsumer().setKeyword$2$Delimiter(EcoreDslDelimiters.keyword$18$Delimiter);
		getSintConsumer().setRuleCall$3$Delimiter(EcoreDslDelimiters.ruleCall$20$Delimiter);
	}
	
	// TODO collect superGrammars transitive
	public XtextBuiltinParserConfiguration getXtextBuiltinConfiguration() {
		return xtextBuiltinConfiguration;
	} 
	
    public EcoreDslEcoreDslConsumer getEcoreDslConsumer() {
    	return ecoreDslConsumer;
    }

    public EcoreDslImportStatementDeclConsumer getImportStatementDeclConsumer() {
    	return importStatementDeclConsumer;
    }

    public EcoreDslEPackageDeclConsumer getEPackageDeclConsumer() {
    	return ePackageDeclConsumer;
    }

    public EcoreDslSubEPackageDeclConsumer getSubEPackageDeclConsumer() {
    	return subEPackageDeclConsumer;
    }

    public EcoreDslEClassifierDeclConsumer getEClassifierDeclConsumer() {
    	return eClassifierDeclConsumer;
    }

    public EcoreDslEDataTypeDeclConsumer getEDataTypeDeclConsumer() {
    	return eDataTypeDeclConsumer;
    }

    public EcoreDslEAnnotationDeclConsumer getEAnnotationDeclConsumer() {
    	return eAnnotationDeclConsumer;
    }

    public EcoreDslEClassDeclConsumer getEClassDeclConsumer() {
    	return eClassDeclConsumer;
    }

    public EcoreDslEStructuralFeatureDeclConsumer getEStructuralFeatureDeclConsumer() {
    	return eStructuralFeatureDeclConsumer;
    }

    public EcoreDslEAttributeDeclConsumer getEAttributeDeclConsumer() {
    	return eAttributeDeclConsumer;
    }

    public EcoreDslEReferenceDeclConsumer getEReferenceDeclConsumer() {
    	return eReferenceDeclConsumer;
    }

    public EcoreDslEEnumDeclConsumer getEEnumDeclConsumer() {
    	return eEnumDeclConsumer;
    }

    public EcoreDslEEnumLiteralDeclConsumer getEEnumLiteralDeclConsumer() {
    	return eEnumLiteralDeclConsumer;
    }

    public EcoreDslETypeParameterDeclConsumer getETypeParameterDeclConsumer() {
    	return eTypeParameterDeclConsumer;
    }

    public EcoreDslEGenericTypeReferenceDeclConsumer getEGenericTypeReferenceDeclConsumer() {
    	return eGenericTypeReferenceDeclConsumer;
    }

    public EcoreDslEGenericTypeDeclConsumer getEGenericTypeDeclConsumer() {
    	return eGenericTypeDeclConsumer;
    }

    public EcoreDslEOperationDeclConsumer getEOperationDeclConsumer() {
    	return eOperationDeclConsumer;
    }

    public EcoreDslEParameterDeclConsumer getEParameterDeclConsumer() {
    	return eParameterDeclConsumer;
    }

    public EcoreDslMapEntrySuperConsumer getMapEntrySuperConsumer() {
    	return mapEntrySuperConsumer;
    }

    public EcoreDslMapEntryConsumer getMapEntryConsumer() {
    	return mapEntryConsumer;
    }

    public EcoreDslMultiplicityExprConsumer getMultiplicityExprConsumer() {
    	return multiplicityExprConsumer;
    }

    public EcoreDslQIDConsumer getQidConsumer() {
    	return qidConsumer;
    }

    public EcoreDslSTRING_OR_QIDConsumer getStringOrQidConsumer() {
    	return stringOrQidConsumer;
    }

    public EcoreDslSINTConsumer getSintConsumer() {
    	return sintConsumer;
    }

    public XtextBuiltinIDConsumer getIdConsumer() {
    	return getXtextBuiltinConfiguration().getIdConsumer();
    }

    public XtextBuiltinINTConsumer getIntConsumer() {
    	return getXtextBuiltinConfiguration().getIntConsumer();
    }

    public XtextBuiltinSTRINGConsumer getStringConsumer() {
    	return getXtextBuiltinConfiguration().getStringConsumer();
    }

    public XtextBuiltinML_COMMENTConsumer getMlCommentConsumer() {
    	return getXtextBuiltinConfiguration().getMlCommentConsumer();
    }

    public XtextBuiltinSL_COMMENTConsumer getSlCommentConsumer() {
    	return getXtextBuiltinConfiguration().getSlCommentConsumer();
    }

    public XtextBuiltinWSConsumer getWsConsumer() {
    	return getXtextBuiltinConfiguration().getWsConsumer();
    }

    public XtextBuiltinANY_OTHERConsumer getAnyOtherConsumer() {
    	return getXtextBuiltinConfiguration().getAnyOtherConsumer();
    }


	@Override
	public ITerminalConsumer[] getInitialHiddenTerminals() {
		return getXtextBuiltinConfiguration().getInitialHiddenTerminals();
	}
	
}
