---
layout: post
title:  Xtext 2.13.0 Release Notes
date:   TBA
categories: releasenotes
---

Xtext 2.13.0 improves the support of language servers.

## New Project Wizard: Language Server Build

The New Project Wizard allows now to build an executable distribution of language server. On the advanced page a new option was added which is enabled when a Build System was selected. The option allows the selection of a distribution type:

* **Regular**: A batch script is created that is used to start the server. The DSL jars and all of its runtime dependencies are copied to the output folder.
* **Fat Jar**: The language server is packaged in a single executable jar.

Both Gradle and Maven are supported. When activated, the build script of the language's Generic IDE project is extended and the language server is packaged to the project's build 

![]({{site.baseurl}}/images/releasenotes/2_13_project-wizard-ls.png)

## Configuration Error Detection

Invalid combinations of bundles are a frequent source of errors. This can be caused by an invalid mixture of Xtext's UI and runtime plugins, or by DSL plugins developed with a different version of Xtext than used in the environment where it fails.

Although there can't be done anything to get the plugins working on an invalid environment, the resulting failure messages were not good for the user, leaving an impression of an unstable framework.

When running in an error during the initial creation of Guice injectors in the DSL's UI or Xtext's Shared UI bundle, the error is catched and an analysis of the runtime environment is included in the failure message. This allows better analysis of the root cause.

## Xbase Lib: flatMap extension method

A new convenience method `flatMap` has been added to `IterableExtensions` and `IteratorExtensions`, which combines `map` and `flatten`.

```
@FinalFieldsConstructor
@Accessors
class Planet {
	final String name
	final List<Moon> moons
}

@FinalFieldsConstructor
@Accessors
class Moon {
	final String name
}


class Planets {
	def static void main (String[] args) {
		
		val Iterable<Planet> planets = #[
			new Planet("Earth", #[new Moon ("Moon")]),
			new Planet("Mars", #[new Moon ("Phobos"), new Moon("Deimos")])
		]
		
		val moonNames_old = planets.map[moons].flatten.map[name]
		val moonNames_new = planets.flatMap[moons].map[name]
	}
}
```


## Bug Lists

- [Fixed GitHub issues](https://github.com/search?utf8=%E2%9C%93&q=is%3Aissue+milestone%3ARelease_2.13+is%3Aclosed+repo%3Aeclipse%2Fxtext+repo%3Aeclipse%2Fxtext-core+repo%3Aeclipse%2Fxtext-lib+repo%3Aeclipse%2Fxtext-extras+repo%3Aeclipse%2Fxtext-eclipse+repo%3Aeclipse%2Fxtext-idea+repo%3Aeclipse%2Fxtext-web+repo%3Aeclipse%2Fxtext-maven+repo%3Aeclipse%2Fxtext-xtend&type=Issues&ref=searchresults)

- [Closed Pull Requests](https://github.com/search?utf8=%E2%9C%93&q=is%3Apr+milestone%3ARelease_2.13+is%3Aclosed+repo%3Aeclipse%2Fxtext+repo%3Aeclipse%2Fxtext-core+repo%3Aeclipse%2Fxtext-lib+repo%3Aeclipse%2Fxtext-extras+repo%3Aeclipse%2Fxtext-eclipse+repo%3Aeclipse%2Fxtext-idea+repo%3Aeclipse%2Fxtext-web+repo%3Aeclipse%2Fxtext-maven+repo%3Aeclipse%2Fxtext-xtend&type=Issues&ref=searchresults)

- [Fixed Eclipse Bugzilla tickets](https://bugs.eclipse.org/bugs/buglist.cgi?bug_status=RESOLVED&bug_status=VERIFIED&bug_status=CLOSED&classification=Modeling&classification=Tools&columnlist=product%2Ccomponent%2Cassigned_to%2Cbug_status%2Cresolution%2Cshort_desc%2Cchangeddate%2Ckeywords&f0=OP&f1=OP&f3=CP&f4=CP&known_name=Xtext%202.13&list_id=16618269&product=TMF&product=Xtend&query_based_on=Xtext%202.13&query_format=advanced&status_whiteboard=v2.13&status_whiteboard_type=allwordssubstr)
