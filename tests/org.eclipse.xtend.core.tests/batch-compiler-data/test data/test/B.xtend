package test
// Test for Bug 377648
class B implements TestInterface{

	override void test() {
		new C().test()
	}
}
