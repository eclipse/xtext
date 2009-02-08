/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.epatch.parser.packrat;

import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;

import org.eclipse.xtext.builtin.parser.packrat.XtextBuiltinParserConfiguration; 

import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageEPatchConsumer;
import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageImportConsumer;
import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageModelImportConsumer;
import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageResourceImportConsumer;
import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageEPackageImportConsumer;
import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageJavaImportConsumer;
import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageExtensionImportConsumer;
import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageNamedResourceConsumer;
import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageNamedObjectConsumer;
import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageObjectRefConsumer;
import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageAssignmentConsumer;
import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageBiSingleAssignmentConsumer;
import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageBiListAssignmentConsumer;
import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageMonoSingleAssignmentConsumer;
import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageMonoListAssignmentConsumer;
import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageAssignmentValueConsumer;
import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageListAssignmentValueConsumer;
import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageSingleAssignmentValueConsumer;
import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageCreatedObjectConsumer;
import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageObjectNewConsumer;
import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageObjectCopyConsumer;
import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageFRAGMENTConsumer;
import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageMigrationConsumer;
import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageExecutableConsumer;
import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageJavaExecutableConsumer;
import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageExpressionExecutableConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinML_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSL_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinWSConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinANY_OTHERConsumer;

@SuppressWarnings("unused")
public class EpatchTestLanguageParserConfiguration extends AbstractParserConfiguration {

	private XtextBuiltinParserConfiguration xtextBuiltinConfiguration; 

    private EpatchTestLanguageEPatchConsumer ePatchConsumer;
    private EpatchTestLanguageImportConsumer importConsumer;
    private EpatchTestLanguageModelImportConsumer modelImportConsumer;
    private EpatchTestLanguageResourceImportConsumer resourceImportConsumer;
    private EpatchTestLanguageEPackageImportConsumer ePackageImportConsumer;
    private EpatchTestLanguageJavaImportConsumer javaImportConsumer;
    private EpatchTestLanguageExtensionImportConsumer extensionImportConsumer;
    private EpatchTestLanguageNamedResourceConsumer namedResourceConsumer;
    private EpatchTestLanguageNamedObjectConsumer namedObjectConsumer;
    private EpatchTestLanguageObjectRefConsumer objectRefConsumer;
    private EpatchTestLanguageAssignmentConsumer assignmentConsumer;
    private EpatchTestLanguageBiSingleAssignmentConsumer biSingleAssignmentConsumer;
    private EpatchTestLanguageBiListAssignmentConsumer biListAssignmentConsumer;
    private EpatchTestLanguageMonoSingleAssignmentConsumer monoSingleAssignmentConsumer;
    private EpatchTestLanguageMonoListAssignmentConsumer monoListAssignmentConsumer;
    private EpatchTestLanguageAssignmentValueConsumer assignmentValueConsumer;
    private EpatchTestLanguageListAssignmentValueConsumer listAssignmentValueConsumer;
    private EpatchTestLanguageSingleAssignmentValueConsumer singleAssignmentValueConsumer;
    private EpatchTestLanguageCreatedObjectConsumer createdObjectConsumer;
    private EpatchTestLanguageObjectNewConsumer objectNewConsumer;
    private EpatchTestLanguageObjectCopyConsumer objectCopyConsumer;
    private EpatchTestLanguageFRAGMENTConsumer fragmentConsumer;
    private EpatchTestLanguageMigrationConsumer migrationConsumer;
    private EpatchTestLanguageExecutableConsumer executableConsumer;
    private EpatchTestLanguageJavaExecutableConsumer javaExecutableConsumer;
    private EpatchTestLanguageExpressionExecutableConsumer expressionExecutableConsumer;

	public EpatchTestLanguageParserConfiguration(IInternalParserConfiguration configuration) {
		super(configuration);
		this.xtextBuiltinConfiguration = new XtextBuiltinParserConfiguration(configuration);
	}

	public EpatchTestLanguageEPatchConsumer getRootConsumer() {
		return ePatchConsumer;
	} 

	public void createNonTerminalConsumers() {
		getXtextBuiltinConfiguration().createNonTerminalConsumers();
		ePatchConsumer = new EpatchTestLanguageEPatchConsumer(
    		this, null
    	);
		importConsumer = new EpatchTestLanguageImportConsumer(
    		this, null
    	);
		modelImportConsumer = new EpatchTestLanguageModelImportConsumer(
    		this, null
    	);
		resourceImportConsumer = new EpatchTestLanguageResourceImportConsumer(
    		this, null
    	);
		ePackageImportConsumer = new EpatchTestLanguageEPackageImportConsumer(
    		this, null
    	);
		javaImportConsumer = new EpatchTestLanguageJavaImportConsumer(
    		this, null
    	);
		extensionImportConsumer = new EpatchTestLanguageExtensionImportConsumer(
    		this, null
    	);
		namedResourceConsumer = new EpatchTestLanguageNamedResourceConsumer(
    		this, null
    	);
		namedObjectConsumer = new EpatchTestLanguageNamedObjectConsumer(
    		this, null
    	);
		objectRefConsumer = new EpatchTestLanguageObjectRefConsumer(
    		this, null
    	);
		assignmentConsumer = new EpatchTestLanguageAssignmentConsumer(
    		this, null
    	);
		biSingleAssignmentConsumer = new EpatchTestLanguageBiSingleAssignmentConsumer(
    		this, null
    	);
		biListAssignmentConsumer = new EpatchTestLanguageBiListAssignmentConsumer(
    		this, null
    	);
		monoSingleAssignmentConsumer = new EpatchTestLanguageMonoSingleAssignmentConsumer(
    		this, null
    	);
		monoListAssignmentConsumer = new EpatchTestLanguageMonoListAssignmentConsumer(
    		this, null
    	);
		assignmentValueConsumer = new EpatchTestLanguageAssignmentValueConsumer(
    		this, null
    	);
		listAssignmentValueConsumer = new EpatchTestLanguageListAssignmentValueConsumer(
    		this, null
    	);
		singleAssignmentValueConsumer = new EpatchTestLanguageSingleAssignmentValueConsumer(
    		this, null
    	);
		createdObjectConsumer = new EpatchTestLanguageCreatedObjectConsumer(
    		this, null
    	);
		objectNewConsumer = new EpatchTestLanguageObjectNewConsumer(
    		this, null
    	);
		objectCopyConsumer = new EpatchTestLanguageObjectCopyConsumer(
    		this, null
    	);
		migrationConsumer = new EpatchTestLanguageMigrationConsumer(
    		this, null
    	);
		executableConsumer = new EpatchTestLanguageExecutableConsumer(
    		this, null
    	);
		javaExecutableConsumer = new EpatchTestLanguageJavaExecutableConsumer(
    		this, null
    	);
		expressionExecutableConsumer = new EpatchTestLanguageExpressionExecutableConsumer(
    		this, null
    	);
	}
	
	public void createTerminalConsumers() {
		getXtextBuiltinConfiguration().createTerminalConsumers();
		fragmentConsumer = new EpatchTestLanguageFRAGMENTConsumer(this);
	}
	
	public void configureConsumers() {
		getEPatchConsumer().setIdConsumer(getIdConsumer());
		getEPatchConsumer().setImportConsumer(getImportConsumer());
		getEPatchConsumer().setNamedResourceConsumer(getNamedResourceConsumer());
		getEPatchConsumer().setObjectRefConsumer(getObjectRefConsumer());

		getImportConsumer().setExtensionImportConsumer(getExtensionImportConsumer());
		getImportConsumer().setJavaImportConsumer(getJavaImportConsumer());
		getImportConsumer().setModelImportConsumer(getModelImportConsumer());

		getModelImportConsumer().setEPackageImportConsumer(getEPackageImportConsumer());
		getModelImportConsumer().setResourceImportConsumer(getResourceImportConsumer());

		getResourceImportConsumer().setIdConsumer(getIdConsumer());
		getResourceImportConsumer().setStringConsumer(getStringConsumer());

		getEPackageImportConsumer().setIdConsumer(getIdConsumer());
		getEPackageImportConsumer().setStringConsumer(getStringConsumer());

		getJavaImportConsumer().setIdConsumer(getIdConsumer());

		getExtensionImportConsumer().setIdConsumer(getIdConsumer());

		getNamedResourceConsumer().setCreatedObjectConsumer(getCreatedObjectConsumer());
		getNamedResourceConsumer().setIdConsumer(getIdConsumer());
		getNamedResourceConsumer().setStringConsumer(getStringConsumer());

		getNamedObjectConsumer().setCreatedObjectConsumer(getCreatedObjectConsumer());
		getNamedObjectConsumer().setObjectRefConsumer(getObjectRefConsumer());

		getObjectRefConsumer().setBiListAssignmentConsumer(getBiListAssignmentConsumer());
		getObjectRefConsumer().setBiSingleAssignmentConsumer(getBiSingleAssignmentConsumer());
		getObjectRefConsumer().setFragmentConsumer(getFragmentConsumer());
		getObjectRefConsumer().setIdConsumer(getIdConsumer());
		getObjectRefConsumer().setMigrationConsumer(getMigrationConsumer());

		getAssignmentConsumer().setBiListAssignmentConsumer(getBiListAssignmentConsumer());
		getAssignmentConsumer().setBiSingleAssignmentConsumer(getBiSingleAssignmentConsumer());
		getAssignmentConsumer().setMonoListAssignmentConsumer(getMonoListAssignmentConsumer());
		getAssignmentConsumer().setMonoSingleAssignmentConsumer(getMonoSingleAssignmentConsumer());

		getBiSingleAssignmentConsumer().setIdConsumer(getIdConsumer());
		getBiSingleAssignmentConsumer().setSingleAssignmentValueConsumer(getSingleAssignmentValueConsumer());

		getBiListAssignmentConsumer().setIdConsumer(getIdConsumer());
		getBiListAssignmentConsumer().setListAssignmentValueConsumer(getListAssignmentValueConsumer());

		getMonoSingleAssignmentConsumer().setIdConsumer(getIdConsumer());
		getMonoSingleAssignmentConsumer().setSingleAssignmentValueConsumer(getSingleAssignmentValueConsumer());

		getMonoListAssignmentConsumer().setAssignmentValueConsumer(getAssignmentValueConsumer());
		getMonoListAssignmentConsumer().setIdConsumer(getIdConsumer());

		getAssignmentValueConsumer().setCreatedObjectConsumer(getCreatedObjectConsumer());
		getAssignmentValueConsumer().setFragmentConsumer(getFragmentConsumer());
		getAssignmentValueConsumer().setIdConsumer(getIdConsumer());
		getAssignmentValueConsumer().setIntConsumer(getIntConsumer());
		getAssignmentValueConsumer().setStringConsumer(getStringConsumer());

		getListAssignmentValueConsumer().setCreatedObjectConsumer(getCreatedObjectConsumer());
		getListAssignmentValueConsumer().setFragmentConsumer(getFragmentConsumer());
		getListAssignmentValueConsumer().setIdConsumer(getIdConsumer());
		getListAssignmentValueConsumer().setIntConsumer(getIntConsumer());
		getListAssignmentValueConsumer().setStringConsumer(getStringConsumer());

		getSingleAssignmentValueConsumer().setCreatedObjectConsumer(getCreatedObjectConsumer());
		getSingleAssignmentValueConsumer().setFragmentConsumer(getFragmentConsumer());
		getSingleAssignmentValueConsumer().setIdConsumer(getIdConsumer());
		getSingleAssignmentValueConsumer().setIntConsumer(getIntConsumer());
		getSingleAssignmentValueConsumer().setStringConsumer(getStringConsumer());

		getCreatedObjectConsumer().setIdConsumer(getIdConsumer());
		getCreatedObjectConsumer().setMigrationConsumer(getMigrationConsumer());
		getCreatedObjectConsumer().setMonoListAssignmentConsumer(getMonoListAssignmentConsumer());
		getCreatedObjectConsumer().setMonoSingleAssignmentConsumer(getMonoSingleAssignmentConsumer());
		getCreatedObjectConsumer().setObjectCopyConsumer(getObjectCopyConsumer());
		getCreatedObjectConsumer().setObjectNewConsumer(getObjectNewConsumer());

		getObjectNewConsumer().setFragmentConsumer(getFragmentConsumer());
		getObjectNewConsumer().setIdConsumer(getIdConsumer());

		getObjectCopyConsumer().setFragmentConsumer(getFragmentConsumer());
		getObjectCopyConsumer().setIdConsumer(getIdConsumer());

		getMigrationConsumer().setExecutableConsumer(getExecutableConsumer());

		getExecutableConsumer().setExpressionExecutableConsumer(getExpressionExecutableConsumer());
		getExecutableConsumer().setJavaExecutableConsumer(getJavaExecutableConsumer());

		getJavaExecutableConsumer().setIdConsumer(getIdConsumer());

		getExpressionExecutableConsumer().setStringConsumer(getStringConsumer());

		getEPatchConsumer().setKeyword$10$Delimiter(EpatchTestLanguageDelimiters.keyword$12$Delimiter);
		getEPatchConsumer().setKeyword$17$Delimiter(EpatchTestLanguageDelimiters.keyword$12$Delimiter);
		getEPatchConsumer().setKeyword$7$Delimiter(EpatchTestLanguageDelimiters.keyword$9$Delimiter);
		getEPatchConsumer().setRuleCall$9$Delimiter(EpatchTestLanguageDelimiters.ruleCall$11$Delimiter);
		getResourceImportConsumer().setKeyword$4$Delimiter(EpatchTestLanguageDelimiters.keyword$9$Delimiter);
		getResourceImportConsumer().setKeyword$7$Delimiter(EpatchTestLanguageDelimiters.keyword$9$Delimiter);
		getResourceImportConsumer().setRuleCall$6$Delimiter(EpatchTestLanguageDelimiters.ruleCall$11$Delimiter);
		getResourceImportConsumer().setRuleCall$9$Delimiter(EpatchTestLanguageDelimiters.ruleCall$42$Delimiter);
		getEPackageImportConsumer().setKeyword$4$Delimiter(EpatchTestLanguageDelimiters.keyword$9$Delimiter);
		getEPackageImportConsumer().setKeyword$7$Delimiter(EpatchTestLanguageDelimiters.keyword$9$Delimiter);
		getEPackageImportConsumer().setRuleCall$6$Delimiter(EpatchTestLanguageDelimiters.ruleCall$11$Delimiter);
		getEPackageImportConsumer().setRuleCall$9$Delimiter(EpatchTestLanguageDelimiters.ruleCall$42$Delimiter);
		getJavaImportConsumer().setKeyword$4$Delimiter(EpatchTestLanguageDelimiters.keyword$9$Delimiter);
		getJavaImportConsumer().setKeyword$5$Delimiter(EpatchTestLanguageDelimiters.keyword$9$Delimiter);
		getJavaImportConsumer().setKeyword$9$Delimiter(EpatchTestLanguageDelimiters.keyword$12$Delimiter);
		getJavaImportConsumer().setRuleCall$7$Delimiter(EpatchTestLanguageDelimiters.ruleCall$11$Delimiter);
		getJavaImportConsumer().setRuleCall$11$Delimiter(EpatchTestLanguageDelimiters.ruleCall$11$Delimiter);
		getExtensionImportConsumer().setKeyword$4$Delimiter(EpatchTestLanguageDelimiters.keyword$9$Delimiter);
		getExtensionImportConsumer().setKeyword$5$Delimiter(EpatchTestLanguageDelimiters.keyword$9$Delimiter);
		getExtensionImportConsumer().setKeyword$9$Delimiter(EpatchTestLanguageDelimiters.keyword$12$Delimiter);
		getExtensionImportConsumer().setRuleCall$7$Delimiter(EpatchTestLanguageDelimiters.ruleCall$11$Delimiter);
		getExtensionImportConsumer().setRuleCall$11$Delimiter(EpatchTestLanguageDelimiters.ruleCall$11$Delimiter);
		getNamedResourceConsumer().setKeyword$22$Delimiter(EpatchTestLanguageDelimiters.keyword$12$Delimiter);
		getNamedResourceConsumer().setKeyword$23$Delimiter(EpatchTestLanguageDelimiters.keyword$9$Delimiter);
		getNamedResourceConsumer().setKeyword$26$Delimiter(EpatchTestLanguageDelimiters.keyword$9$Delimiter);
		getNamedResourceConsumer().setKeyword$31$Delimiter(EpatchTestLanguageDelimiters.keyword$12$Delimiter);
		getNamedResourceConsumer().setKeyword$32$Delimiter(EpatchTestLanguageDelimiters.keyword$12$Delimiter);
		getNamedResourceConsumer().setKeyword$10$Delimiter(EpatchTestLanguageDelimiters.keyword$9$Delimiter);
		getNamedResourceConsumer().setKeyword$13$Delimiter(EpatchTestLanguageDelimiters.keyword$12$Delimiter);
		getNamedResourceConsumer().setKeyword$14$Delimiter(EpatchTestLanguageDelimiters.keyword$9$Delimiter);
		getNamedResourceConsumer().setKeyword$17$Delimiter(EpatchTestLanguageDelimiters.keyword$9$Delimiter);
		getNamedResourceConsumer().setRuleCall$19$Delimiter(EpatchTestLanguageDelimiters.ruleCall$42$Delimiter);
		getNamedResourceConsumer().setRuleCall$28$Delimiter(EpatchTestLanguageDelimiters.ruleCall$42$Delimiter);
		getNamedResourceConsumer().setRuleCall$12$Delimiter(EpatchTestLanguageDelimiters.ruleCall$11$Delimiter);
		getObjectRefConsumer().setCrossReference$10$Delimiter(EpatchTestLanguageDelimiters.ruleCall$11$Delimiter);
		getObjectRefConsumer().setCrossReference$21$Delimiter(EpatchTestLanguageDelimiters.ruleCall$11$Delimiter);
		getObjectRefConsumer().setCrossReference$27$Delimiter(EpatchTestLanguageDelimiters.ruleCall$11$Delimiter);
		getObjectRefConsumer().setKeyword$4$Delimiter(EpatchTestLanguageDelimiters.keyword$9$Delimiter);
		getObjectRefConsumer().setKeyword$19$Delimiter(EpatchTestLanguageDelimiters.keyword$9$Delimiter);
		getObjectRefConsumer().setKeyword$25$Delimiter(EpatchTestLanguageDelimiters.keyword$9$Delimiter);
		getObjectRefConsumer().setKeyword$35$Delimiter(EpatchTestLanguageDelimiters.keyword$12$Delimiter);
		getObjectRefConsumer().setKeyword$42$Delimiter(EpatchTestLanguageDelimiters.keyword$9$Delimiter);
		getObjectRefConsumer().setKeyword$46$Delimiter(EpatchTestLanguageDelimiters.keyword$9$Delimiter);
		getObjectRefConsumer().setKeyword$49$Delimiter(EpatchTestLanguageDelimiters.keyword$12$Delimiter);
		getObjectRefConsumer().setRuleCall$6$Delimiter(EpatchTestLanguageDelimiters.ruleCall$11$Delimiter);
		getObjectRefConsumer().setRuleCall$13$Delimiter(EpatchTestLanguageDelimiters.ruleCall$42$Delimiter);
		getObjectRefConsumer().setRuleCall$24$Delimiter(EpatchTestLanguageDelimiters.ruleCall$42$Delimiter);
		getObjectRefConsumer().setRuleCall$30$Delimiter(EpatchTestLanguageDelimiters.ruleCall$42$Delimiter);
		getBiSingleAssignmentConsumer().setKeyword$8$Delimiter(EpatchTestLanguageDelimiters.keyword$12$Delimiter);
		getBiSingleAssignmentConsumer().setKeyword$11$Delimiter(EpatchTestLanguageDelimiters.keyword$12$Delimiter);
		getBiSingleAssignmentConsumer().setKeyword$14$Delimiter(EpatchTestLanguageDelimiters.keyword$12$Delimiter);
		getBiSingleAssignmentConsumer().setRuleCall$7$Delimiter(EpatchTestLanguageDelimiters.ruleCall$11$Delimiter);
		getBiListAssignmentConsumer().setKeyword$10$Delimiter(EpatchTestLanguageDelimiters.keyword$12$Delimiter);
		getBiListAssignmentConsumer().setKeyword$11$Delimiter(EpatchTestLanguageDelimiters.keyword$12$Delimiter);
		getBiListAssignmentConsumer().setKeyword$16$Delimiter(EpatchTestLanguageDelimiters.keyword$12$Delimiter);
		getBiListAssignmentConsumer().setKeyword$19$Delimiter(EpatchTestLanguageDelimiters.keyword$12$Delimiter);
		getBiListAssignmentConsumer().setKeyword$24$Delimiter(EpatchTestLanguageDelimiters.keyword$12$Delimiter);
		getBiListAssignmentConsumer().setKeyword$27$Delimiter(EpatchTestLanguageDelimiters.keyword$12$Delimiter);
		getBiListAssignmentConsumer().setKeyword$28$Delimiter(EpatchTestLanguageDelimiters.keyword$12$Delimiter);
		getBiListAssignmentConsumer().setRuleCall$9$Delimiter(EpatchTestLanguageDelimiters.ruleCall$11$Delimiter);
		getMonoSingleAssignmentConsumer().setKeyword$6$Delimiter(EpatchTestLanguageDelimiters.keyword$12$Delimiter);
		getMonoSingleAssignmentConsumer().setKeyword$9$Delimiter(EpatchTestLanguageDelimiters.keyword$12$Delimiter);
		getMonoSingleAssignmentConsumer().setRuleCall$5$Delimiter(EpatchTestLanguageDelimiters.ruleCall$11$Delimiter);
		getMonoListAssignmentConsumer().setKeyword$8$Delimiter(EpatchTestLanguageDelimiters.keyword$12$Delimiter);
		getMonoListAssignmentConsumer().setKeyword$9$Delimiter(EpatchTestLanguageDelimiters.keyword$12$Delimiter);
		getMonoListAssignmentConsumer().setKeyword$14$Delimiter(EpatchTestLanguageDelimiters.keyword$12$Delimiter);
		getMonoListAssignmentConsumer().setKeyword$17$Delimiter(EpatchTestLanguageDelimiters.keyword$12$Delimiter);
		getMonoListAssignmentConsumer().setKeyword$18$Delimiter(EpatchTestLanguageDelimiters.keyword$12$Delimiter);
		getMonoListAssignmentConsumer().setRuleCall$7$Delimiter(EpatchTestLanguageDelimiters.ruleCall$11$Delimiter);
		getAssignmentValueConsumer().setCrossReference$8$Delimiter(EpatchTestLanguageDelimiters.ruleCall$11$Delimiter);
		getAssignmentValueConsumer().setCrossReference$25$Delimiter(EpatchTestLanguageDelimiters.ruleCall$11$Delimiter);
		getAssignmentValueConsumer().setKeyword$12$Delimiter(EpatchTestLanguageDelimiters.keyword$12$Delimiter);
		getAssignmentValueConsumer().setKeyword$17$Delimiter(EpatchTestLanguageDelimiters.keyword$12$Delimiter);
		getAssignmentValueConsumer().setKeyword$20$Delimiter(EpatchTestLanguageDelimiters.keyword$12$Delimiter);
		getAssignmentValueConsumer().setRuleCall$5$Delimiter(EpatchTestLanguageDelimiters.ruleCall$42$Delimiter);
		getAssignmentValueConsumer().setRuleCall$14$Delimiter(EpatchTestLanguageDelimiters.ruleCall$11$Delimiter);
		getAssignmentValueConsumer().setRuleCall$19$Delimiter(EpatchTestLanguageDelimiters.ruleCall$42$Delimiter);
		getAssignmentValueConsumer().setRuleCall$28$Delimiter(EpatchTestLanguageDelimiters.ruleCall$42$Delimiter);
		getListAssignmentValueConsumer().setCrossReference$20$Delimiter(EpatchTestLanguageDelimiters.ruleCall$11$Delimiter);
		getListAssignmentValueConsumer().setCrossReference$37$Delimiter(EpatchTestLanguageDelimiters.ruleCall$11$Delimiter);
		getListAssignmentValueConsumer().setKeyword$5$Delimiter(EpatchTestLanguageDelimiters.keyword$12$Delimiter);
		getListAssignmentValueConsumer().setKeyword$12$Delimiter(EpatchTestLanguageDelimiters.keyword$12$Delimiter);
		getListAssignmentValueConsumer().setKeyword$15$Delimiter(EpatchTestLanguageDelimiters.keyword$12$Delimiter);
		getListAssignmentValueConsumer().setKeyword$24$Delimiter(EpatchTestLanguageDelimiters.keyword$12$Delimiter);
		getListAssignmentValueConsumer().setKeyword$29$Delimiter(EpatchTestLanguageDelimiters.keyword$12$Delimiter);
		getListAssignmentValueConsumer().setKeyword$32$Delimiter(EpatchTestLanguageDelimiters.keyword$12$Delimiter);
		getListAssignmentValueConsumer().setRuleCall$4$Delimiter(EpatchTestLanguageDelimiters.ruleCall$42$Delimiter);
		getListAssignmentValueConsumer().setRuleCall$14$Delimiter(EpatchTestLanguageDelimiters.ruleCall$42$Delimiter);
		getListAssignmentValueConsumer().setRuleCall$17$Delimiter(EpatchTestLanguageDelimiters.ruleCall$42$Delimiter);
		getListAssignmentValueConsumer().setRuleCall$26$Delimiter(EpatchTestLanguageDelimiters.ruleCall$11$Delimiter);
		getListAssignmentValueConsumer().setRuleCall$31$Delimiter(EpatchTestLanguageDelimiters.ruleCall$42$Delimiter);
		getListAssignmentValueConsumer().setRuleCall$40$Delimiter(EpatchTestLanguageDelimiters.ruleCall$42$Delimiter);
		getSingleAssignmentValueConsumer().setCrossReference$11$Delimiter(EpatchTestLanguageDelimiters.ruleCall$11$Delimiter);
		getSingleAssignmentValueConsumer().setCrossReference$28$Delimiter(EpatchTestLanguageDelimiters.ruleCall$11$Delimiter);
		getSingleAssignmentValueConsumer().setKeyword$6$Delimiter(EpatchTestLanguageDelimiters.keyword$9$Delimiter);
		getSingleAssignmentValueConsumer().setKeyword$15$Delimiter(EpatchTestLanguageDelimiters.keyword$12$Delimiter);
		getSingleAssignmentValueConsumer().setKeyword$20$Delimiter(EpatchTestLanguageDelimiters.keyword$12$Delimiter);
		getSingleAssignmentValueConsumer().setKeyword$23$Delimiter(EpatchTestLanguageDelimiters.keyword$12$Delimiter);
		getSingleAssignmentValueConsumer().setRuleCall$8$Delimiter(EpatchTestLanguageDelimiters.ruleCall$42$Delimiter);
		getSingleAssignmentValueConsumer().setRuleCall$17$Delimiter(EpatchTestLanguageDelimiters.ruleCall$11$Delimiter);
		getSingleAssignmentValueConsumer().setRuleCall$22$Delimiter(EpatchTestLanguageDelimiters.ruleCall$42$Delimiter);
		getSingleAssignmentValueConsumer().setRuleCall$31$Delimiter(EpatchTestLanguageDelimiters.ruleCall$42$Delimiter);
		getCreatedObjectConsumer().setKeyword$11$Delimiter(EpatchTestLanguageDelimiters.keyword$12$Delimiter);
		getCreatedObjectConsumer().setKeyword$19$Delimiter(EpatchTestLanguageDelimiters.keyword$12$Delimiter);
		getCreatedObjectConsumer().setRuleCall$7$Delimiter(EpatchTestLanguageDelimiters.ruleCall$11$Delimiter);
		getObjectNewConsumer().setCrossReference$5$Delimiter(EpatchTestLanguageDelimiters.ruleCall$11$Delimiter);
		getObjectNewConsumer().setKeyword$3$Delimiter(EpatchTestLanguageDelimiters.keyword$9$Delimiter);
		getObjectNewConsumer().setRuleCall$8$Delimiter(EpatchTestLanguageDelimiters.ruleCall$42$Delimiter);
		getObjectCopyConsumer().setCrossReference$5$Delimiter(EpatchTestLanguageDelimiters.ruleCall$11$Delimiter);
		getObjectCopyConsumer().setKeyword$3$Delimiter(EpatchTestLanguageDelimiters.keyword$9$Delimiter);
		getObjectCopyConsumer().setRuleCall$8$Delimiter(EpatchTestLanguageDelimiters.ruleCall$42$Delimiter);
		getMigrationConsumer().setKeyword$4$Delimiter(EpatchTestLanguageDelimiters.keyword$9$Delimiter);
		getMigrationConsumer().setKeyword$9$Delimiter(EpatchTestLanguageDelimiters.keyword$9$Delimiter);
		getMigrationConsumer().setKeyword$13$Delimiter(EpatchTestLanguageDelimiters.keyword$9$Delimiter);
		getMigrationConsumer().setKeyword$16$Delimiter(EpatchTestLanguageDelimiters.keyword$12$Delimiter);
		getJavaExecutableConsumer().setKeyword$4$Delimiter(EpatchTestLanguageDelimiters.keyword$9$Delimiter);
		getJavaExecutableConsumer().setKeyword$7$Delimiter(EpatchTestLanguageDelimiters.keyword$12$Delimiter);
		getJavaExecutableConsumer().setKeyword$8$Delimiter(EpatchTestLanguageDelimiters.keyword$12$Delimiter);
		getJavaExecutableConsumer().setRuleCall$6$Delimiter(EpatchTestLanguageDelimiters.ruleCall$11$Delimiter);
		getExpressionExecutableConsumer().setRuleCall$2$Delimiter(EpatchTestLanguageDelimiters.ruleCall$42$Delimiter);
	}
	
	// TODO collect superGrammars transitive
	public XtextBuiltinParserConfiguration getXtextBuiltinConfiguration() {
		return xtextBuiltinConfiguration;
	} 
	
    public EpatchTestLanguageEPatchConsumer getEPatchConsumer() {
    	return ePatchConsumer;
    }

    public EpatchTestLanguageImportConsumer getImportConsumer() {
    	return importConsumer;
    }

    public EpatchTestLanguageModelImportConsumer getModelImportConsumer() {
    	return modelImportConsumer;
    }

    public EpatchTestLanguageResourceImportConsumer getResourceImportConsumer() {
    	return resourceImportConsumer;
    }

    public EpatchTestLanguageEPackageImportConsumer getEPackageImportConsumer() {
    	return ePackageImportConsumer;
    }

    public EpatchTestLanguageJavaImportConsumer getJavaImportConsumer() {
    	return javaImportConsumer;
    }

    public EpatchTestLanguageExtensionImportConsumer getExtensionImportConsumer() {
    	return extensionImportConsumer;
    }

    public EpatchTestLanguageNamedResourceConsumer getNamedResourceConsumer() {
    	return namedResourceConsumer;
    }

    public EpatchTestLanguageNamedObjectConsumer getNamedObjectConsumer() {
    	return namedObjectConsumer;
    }

    public EpatchTestLanguageObjectRefConsumer getObjectRefConsumer() {
    	return objectRefConsumer;
    }

    public EpatchTestLanguageAssignmentConsumer getAssignmentConsumer() {
    	return assignmentConsumer;
    }

    public EpatchTestLanguageBiSingleAssignmentConsumer getBiSingleAssignmentConsumer() {
    	return biSingleAssignmentConsumer;
    }

    public EpatchTestLanguageBiListAssignmentConsumer getBiListAssignmentConsumer() {
    	return biListAssignmentConsumer;
    }

    public EpatchTestLanguageMonoSingleAssignmentConsumer getMonoSingleAssignmentConsumer() {
    	return monoSingleAssignmentConsumer;
    }

    public EpatchTestLanguageMonoListAssignmentConsumer getMonoListAssignmentConsumer() {
    	return monoListAssignmentConsumer;
    }

    public EpatchTestLanguageAssignmentValueConsumer getAssignmentValueConsumer() {
    	return assignmentValueConsumer;
    }

    public EpatchTestLanguageListAssignmentValueConsumer getListAssignmentValueConsumer() {
    	return listAssignmentValueConsumer;
    }

    public EpatchTestLanguageSingleAssignmentValueConsumer getSingleAssignmentValueConsumer() {
    	return singleAssignmentValueConsumer;
    }

    public EpatchTestLanguageCreatedObjectConsumer getCreatedObjectConsumer() {
    	return createdObjectConsumer;
    }

    public EpatchTestLanguageObjectNewConsumer getObjectNewConsumer() {
    	return objectNewConsumer;
    }

    public EpatchTestLanguageObjectCopyConsumer getObjectCopyConsumer() {
    	return objectCopyConsumer;
    }

    public EpatchTestLanguageFRAGMENTConsumer getFragmentConsumer() {
    	return fragmentConsumer;
    }

    public EpatchTestLanguageMigrationConsumer getMigrationConsumer() {
    	return migrationConsumer;
    }

    public EpatchTestLanguageExecutableConsumer getExecutableConsumer() {
    	return executableConsumer;
    }

    public EpatchTestLanguageJavaExecutableConsumer getJavaExecutableConsumer() {
    	return javaExecutableConsumer;
    }

    public EpatchTestLanguageExpressionExecutableConsumer getExpressionExecutableConsumer() {
    	return expressionExecutableConsumer;
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
