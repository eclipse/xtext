package org.eclipse.xtext.xbase.compiler

import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class GeneratorConfig {
	boolean generateExpressions = true
	boolean generateSyntheticSuppressWarnings = true
}