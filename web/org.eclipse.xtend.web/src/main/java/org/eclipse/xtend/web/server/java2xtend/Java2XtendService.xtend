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
		
		if (xtendSrc.xtendCode == null) { // || xtendSrc.problems.size>0
			return new Java2XtendResult(0, null)
		}
		var generateCode = try {
			formatter.format(xtendSrc.xtendCode)
		} catch (Exception e) {
			return new Java2XtendResult(0, "")
		}
		return new Java2XtendResult(1, generateCode)
	}

}