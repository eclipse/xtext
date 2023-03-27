# Regenerate Languages

This document describes the necessary steps to regenerate the test- and production Xtext languages.

1. **xtext-core:** execute the `generateTestLanguages` Gradle task and the `GenerateXtext.mwe2` MWE2 workflow in Eclipse 
	```
	./gradlew -PuseJenkinsSnapshots=true generateTestLanguages
	```
	```
	org.eclipse.xtext.xtext.bootstrap\src\org\eclipse\xtext\xtext\bootstrap\GenerateXtext.mwe2
	```
1. **xtext-extras:** execute the `generateXbase`, `generatePureXbase` and `generateTestLanguages` Gradle tasks
	```
	./gradlew -PuseJenkinsSnapshots=true generateXbase generatePureXbase generateTestLanguages
	```
1. **xtext-eclipse:** execute the following `MWE2` workflows in Eclipse
	```
	org.eclipse.xtext.builder.tests\src\org\eclipse\xtext\builder\tests\GenerateBuilderTestLanguages.mwe2
	org.eclipse.xtext.common.types.eclipse.tests\src\org\eclipse\xtext\common\types\xtext\ui\GenerateTypesTestLanguages.mwe2
	org.eclipse.xtext.ui.codetemplates\src\org\eclipse\xtext\ui\codetemplates\GenerateCodetemplateLanguages.mwe2
	org.eclipse.xtext.ui.tests\src\org\eclipse\xtext\ui\tests\GenerateTestLanguages.mwe2
	org.eclipse.xtext.xtext.ui.examples\projects\arithmetics\org.eclipse.xtext.example.arithmetics\src\org\eclipse\xtext\example\arithmetics\GenerateArithmetics.mwe2
	org.eclipse.xtext.xtext.ui.examples\projects\domainmodel\org.eclipse.xtext.example.domainmodel\src\org\eclipse\xtext\example\domainmodel\GenerateDomainmodel.mwe2
	org.eclipse.xtext.xtext.ui.examples\projects\fowlerdsl\org.eclipse.xtext.example.fowlerdsl\src\org\eclipse\xtext\example\fowlerdsl\GenerateStatemachine.mwe2
	org.eclipse.xtext.xtext.ui.examples\projects\homeautomation\org.eclipse.xtext.example.homeautomation\src\org\eclipse\xtext\example\homeautomation\GenerateRuleEngine.mwe2
	org.eclipse.xtext.xtext.ui.tests\generator\org\eclipse\xtext\xtext\ui\ecore2xtext\GenerateEcore2XtextTestGrammar.mwe2
	org.eclipse.xtext.xtext.ui.tests\src\org\eclipse\xtext\xtext\ui\GenerateTestLanguages.mwe2
	```
1. **xtext-web:** execute the `generateExampleLanguages` Gradle task
	```
	./gradlew -PuseJenkinsSnapshots=true generateExampleLanguages
	```
1. **xtext-xtend:** execute the `generateXtend` Gradle task
	```
	./gradlew -PuseJenkinsSnapshots=true generateXtend
	```
