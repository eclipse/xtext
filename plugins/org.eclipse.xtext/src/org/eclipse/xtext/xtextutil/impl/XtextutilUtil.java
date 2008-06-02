package org.eclipse.xtext.xtextutil.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.xtextutil.MetaModel;

public class XtextutilUtil {
	
	private static Log log = LogFactory.getLog(XtextutilUtil.class);

	public static String alias(MetaModelImpl metaModelImpl) {
		AbstractMetamodelDeclaration declaration = metaModelImpl.getDeclaration();
		if (declaration == null)
			return null;
		return declaration.getAlias();
	}

	public static boolean isGenerate(MetaModelImpl metaModelImpl) {
		return metaModelImpl.getDeclaration() instanceof GeneratedMetamodel;
	}

	public static String getQualifiedName(AbstractTypeImpl complexTypeImpl) {
		MetaModel metaModel = complexTypeImpl.getMetaModel();
		if (metaModel == null) {
			log.error("No metamodel set for type "+complexTypeImpl.getName());
		}
		String alias = metaModel.alias();
		return (alias==null ? "" : alias+"::")+complexTypeImpl.getName();
	}
	
}
