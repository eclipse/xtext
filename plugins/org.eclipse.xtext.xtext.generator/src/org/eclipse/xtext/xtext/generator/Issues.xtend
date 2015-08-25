package org.eclipse.xtext.xtext.generator

interface Issues {
	def void addError(String message)
	def void addError(String message, Object source)
	def void addWarning(String message)
	def void addWarning(String message, Object source)
}