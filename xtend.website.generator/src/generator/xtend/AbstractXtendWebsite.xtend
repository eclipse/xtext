package generator.xtend

import generator.AbstractWebsite

abstract class AbstractXtendWebsite extends AbstractWebsite {
	
	override websiteDescription() {
		'Xtend is a statically typed programming language sitting on top of Java.'
	}
	
	override websiteTitle() {
		'Xtend - Modernized Java'
	}
	
	override twitterID() {
		'xtendlang'
	}
	
	override analyticsAccount() {
		'UA-2429174-4'
	}
	
	override headline(String title) {
		''
	}
	
	override plusoneURL() { 
		'http://www.xtend-lang.org' 
	}
	
	override topLevelMenu() {
		newArrayList(
			'news.html' -> 'News',
			'download.html' -> 'Download',
			'documentation.html' -> 'Documentation',
			'community.html' -> 'Community',
			'http://xtext.org' -> 'Xtext',
			'http://www.eclipse.org' -> 'Eclipse.org'
		)
	}
}