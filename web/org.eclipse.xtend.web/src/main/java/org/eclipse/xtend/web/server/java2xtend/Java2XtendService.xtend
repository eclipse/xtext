package org.eclipse.xtend.web.server.java2xtend

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.xtend.core.formatting2.FormatterFacade
import org.eclipse.xtend.core.javaconverter.JavaConverter
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess

@Singleton
class Java2XtendService {

	@Inject JavaConverter javaConverter
	@Inject FormatterFacade formatter

	def generate(String javaSrc, XtextWebDocumentAccess document) {
		val xtendSrc = javaConverter.toXtend("Clazz", javaSrc)
		
		if (xtendSrc.xtendCode == null) { 
			return new Java2XtendResult(0, null)
		}
		//here sometimes we get exception when we do formatting
		var generateCode = try {
			formatter.format(xtendSrc.xtendCode)
		} catch (Exception e) {//but this can't catch this exception, expecting someone can improve it.
			return new Java2XtendResult(1, xtendSrc.xtendCode)
		}
		return new Java2XtendResult(1, generateCode)
	}

}