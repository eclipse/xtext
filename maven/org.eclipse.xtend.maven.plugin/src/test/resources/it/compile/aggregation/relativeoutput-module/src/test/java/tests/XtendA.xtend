package tests

class XtendA extends JavaB {
	
	def test.JavaB test2(XtendC s) {
		return s.foo.newJavaB
	}
	
	def test.JavaB newJavaB() {
		return new test.JavaB()
	}
	
}