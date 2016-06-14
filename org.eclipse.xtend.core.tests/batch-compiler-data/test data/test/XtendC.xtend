package test

import test.JavaB
import test.XtendA

@SuppressWarnings("just here to trigger annotation processing")
class XtendC {
	def JavaB test(XtendA s) {
		return null
	}
}