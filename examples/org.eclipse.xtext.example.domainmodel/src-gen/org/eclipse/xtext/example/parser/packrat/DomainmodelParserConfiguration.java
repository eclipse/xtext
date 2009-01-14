/*
Generated with Xtext
*/
package org.eclipse.xtext.example.parser.packrat;

import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.builtin.parser.packrat.XtextBuiltinParserConfiguration; 

import org.eclipse.xtext.example.parser.packrat.consumers.DomainmodelFileConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.DomainmodelImportConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.DomainmodelNamedElementConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.DomainmodelPackageConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.DomainmodelTypeConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.DomainmodelDataTypeConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.DomainmodelEntityConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.DomainmodelFeatureConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.DomainmodelStructuralFeatureConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.DomainmodelAttributeConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.DomainmodelReferenceConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.DomainmodelOperationConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.DomainmodelParameterConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.DomainmodelTypedElementConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.DomainmodelTypeRefConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.DomainmodelQualifiedNameConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinML_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSL_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinWSConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinANY_OTHERConsumer;

public class DomainmodelParserConfiguration extends AbstractParserConfiguration {

	private XtextBuiltinParserConfiguration xtextBuiltinConfiguration; 

    private DomainmodelFileConsumer fileConsumer;
    private DomainmodelImportConsumer importConsumer;
    private DomainmodelNamedElementConsumer namedElementConsumer;
    private DomainmodelPackageConsumer packageConsumer;
    private DomainmodelTypeConsumer typeConsumer;
    private DomainmodelDataTypeConsumer dataTypeConsumer;
    private DomainmodelEntityConsumer entityConsumer;
    private DomainmodelFeatureConsumer featureConsumer;
    private DomainmodelStructuralFeatureConsumer structuralFeatureConsumer;
    private DomainmodelAttributeConsumer attributeConsumer;
    private DomainmodelReferenceConsumer referenceConsumer;
    private DomainmodelOperationConsumer operationConsumer;
    private DomainmodelParameterConsumer parameterConsumer;
    private DomainmodelTypedElementConsumer typedElementConsumer;
    private DomainmodelTypeRefConsumer typeRefConsumer;
    private DomainmodelQualifiedNameConsumer qualifiedNameConsumer;

	public DomainmodelParserConfiguration(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil);
		this.xtextBuiltinConfiguration = new XtextBuiltinParserConfiguration(
			input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil);
	}

	public DomainmodelFileConsumer getRootConsumer() {
		return fileConsumer;
	} 
	
	public void createNonTerminalConsumers() {
		getXtextBuiltinConfiguration().createNonTerminalConsumers();
		fileConsumer = new DomainmodelFileConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(),
    		new ITerminalConsumer[]{ getWsConsumer(), getMlCommentConsumer(), getSlCommentConsumer() }
    	);
		importConsumer = new DomainmodelImportConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		namedElementConsumer = new DomainmodelNamedElementConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		packageConsumer = new DomainmodelPackageConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		typeConsumer = new DomainmodelTypeConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		dataTypeConsumer = new DomainmodelDataTypeConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		entityConsumer = new DomainmodelEntityConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		featureConsumer = new DomainmodelFeatureConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		structuralFeatureConsumer = new DomainmodelStructuralFeatureConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		attributeConsumer = new DomainmodelAttributeConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		referenceConsumer = new DomainmodelReferenceConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		operationConsumer = new DomainmodelOperationConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		parameterConsumer = new DomainmodelParameterConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		typedElementConsumer = new DomainmodelTypedElementConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		typeRefConsumer = new DomainmodelTypeRefConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		qualifiedNameConsumer = new DomainmodelQualifiedNameConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
	}
	
	public void createTerminalConsumers() {
		getXtextBuiltinConfiguration().createTerminalConsumers();
	}
	
	public void configureConsumers() {
		getFileConsumer().setImportConsumer(getImportConsumer());
		getFileConsumer().setNamedElementConsumer(getNamedElementConsumer());

		getImportConsumer().setStringConsumer(getStringConsumer());

		getNamedElementConsumer().setPackageConsumer(getPackageConsumer());
		getNamedElementConsumer().setTypeConsumer(getTypeConsumer());

		getPackageConsumer().setQualifiedNameConsumer(getQualifiedNameConsumer());
		getPackageConsumer().setNamedElementConsumer(getNamedElementConsumer());

		getTypeConsumer().setDataTypeConsumer(getDataTypeConsumer());
		getTypeConsumer().setEntityConsumer(getEntityConsumer());

		getDataTypeConsumer().setIdConsumer(getIdConsumer());

		getEntityConsumer().setFeatureConsumer(getFeatureConsumer());
		getEntityConsumer().setIdConsumer(getIdConsumer());

		getFeatureConsumer().setStructuralFeatureConsumer(getStructuralFeatureConsumer());
		getFeatureConsumer().setOperationConsumer(getOperationConsumer());

		getStructuralFeatureConsumer().setReferenceConsumer(getReferenceConsumer());
		getStructuralFeatureConsumer().setAttributeConsumer(getAttributeConsumer());

		getAttributeConsumer().setIdConsumer(getIdConsumer());
		getAttributeConsumer().setTypeRefConsumer(getTypeRefConsumer());

		getReferenceConsumer().setIdConsumer(getIdConsumer());
		getReferenceConsumer().setTypeRefConsumer(getTypeRefConsumer());

		getOperationConsumer().setParameterConsumer(getParameterConsumer());
		getOperationConsumer().setIdConsumer(getIdConsumer());
		getOperationConsumer().setTypeRefConsumer(getTypeRefConsumer());

		getParameterConsumer().setIdConsumer(getIdConsumer());
		getParameterConsumer().setTypeRefConsumer(getTypeRefConsumer());

		getTypedElementConsumer().setParameterConsumer(getParameterConsumer());
		getTypedElementConsumer().setFeatureConsumer(getFeatureConsumer());

		getTypeRefConsumer().setIdConsumer(getIdConsumer());

		getQualifiedNameConsumer().setIdConsumer(getIdConsumer());

		getIdConsumer().initFields(this);
		getIntConsumer().initFields(this);
		getStringConsumer().initFields(this);
		getMlCommentConsumer().initFields(this);
		getSlCommentConsumer().initFields(this);
		getWsConsumer().initFields(this);
		getAnyOtherConsumer().initFields(this);
	}
	
	// TODO collect superGrammars transitive
	public XtextBuiltinParserConfiguration getXtextBuiltinConfiguration() {
		return xtextBuiltinConfiguration;
	} 
	
    public DomainmodelFileConsumer getFileConsumer() {
    	return fileConsumer;
    }

    public DomainmodelImportConsumer getImportConsumer() {
    	return importConsumer;
    }

    public DomainmodelNamedElementConsumer getNamedElementConsumer() {
    	return namedElementConsumer;
    }

    public DomainmodelPackageConsumer getPackageConsumer() {
    	return packageConsumer;
    }

    public DomainmodelTypeConsumer getTypeConsumer() {
    	return typeConsumer;
    }

    public DomainmodelDataTypeConsumer getDataTypeConsumer() {
    	return dataTypeConsumer;
    }

    public DomainmodelEntityConsumer getEntityConsumer() {
    	return entityConsumer;
    }

    public DomainmodelFeatureConsumer getFeatureConsumer() {
    	return featureConsumer;
    }

    public DomainmodelStructuralFeatureConsumer getStructuralFeatureConsumer() {
    	return structuralFeatureConsumer;
    }

    public DomainmodelAttributeConsumer getAttributeConsumer() {
    	return attributeConsumer;
    }

    public DomainmodelReferenceConsumer getReferenceConsumer() {
    	return referenceConsumer;
    }

    public DomainmodelOperationConsumer getOperationConsumer() {
    	return operationConsumer;
    }

    public DomainmodelParameterConsumer getParameterConsumer() {
    	return parameterConsumer;
    }

    public DomainmodelTypedElementConsumer getTypedElementConsumer() {
    	return typedElementConsumer;
    }

    public DomainmodelTypeRefConsumer getTypeRefConsumer() {
    	return typeRefConsumer;
    }

    public DomainmodelQualifiedNameConsumer getQualifiedNameConsumer() {
    	return qualifiedNameConsumer;
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


}
