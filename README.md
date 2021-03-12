[![Gitter](https://badges.gitter.im/eclipse/xtext.svg)](https://gitter.im/eclipse/xtext?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge)

# Eclipse Xtext™

Eclipse Xtext is a framework for development of programming languages and [domain specific languages](https://en.wikipedia.org/wiki/Domain-specific_language). It covers all aspects of a complete language infrastructure, from parsers, over linker, compiler or interpreter to fully-blown top-notch IDE integration for Eclipse and Web-based IDEs. Further, languages developed with Xtext can be integrated into editors supporting the [Language Server Protocol](https://github.com/Microsoft/language-server-protocol) (e.g. [VS Code](https://code.visualstudio.com/), [Eclipse Che](https://www.eclipse.org/che/)). Xtext comes with great defaults for all these aspects, which at the same time can be easily tailored to your individual needs.

More information can be found on [xtext.org](http://xtext.org).

## Repositories

This repository contains the [website](https://www.eclipse.org/Xtext/) and documentation of Xtext, which is tracked in the [website-published](https://github.com/eclipse/xtext/tree/website-published) branch. The actual Xtext code is available in the following modules:

- [xtext-core](https://github.com/eclipse/xtext-core): The core framework and [Language Server](https://github.com/Microsoft/language-server-protocol) support
- [xtext-lib](https://github.com/eclipse/xtext-lib): Libraries for [Xbase](https://www.eclipse.org/Xtext/documentation/305_xbase.html) and [Xtend](http://www.xtend-lang.org)
- [xtext-extras](https://github.com/eclipse/xtext-extras): Additional editor-independent features, mostly Java support
- [xtext-eclipse](https://github.com/eclipse/xtext-eclipse): Plug-ins for [Eclipse](http://eclipse.org)
- [xtext-web](https://github.com/eclipse/xtext-web): Support for [Orion](http://eclipse.org/orion/), [Ace](http://ace.c9.io) and [CodeMirror](https://codemirror.net)
- [xtext-maven](https://github.com/eclipse/xtext-maven): Support for [Maven](https://maven.apache.org)
- [xtext-xtend](https://github.com/eclipse/xtext-xtend): The [Xtend](http://www.xtend-lang.org) language
- [xtext-umbrella](https://github.com/eclipse/xtext-umbrella): Common Eclipse features and P2 update sites

Please check the individual repositories for instructions for building and contributing.

## Quick Access

- [All Open Pull Requests](https://github.com/search?utf8=✓&q=is%3Apr+is%3Aopen+repo%3Aeclipse%2Fxtext+repo%3Aeclipse%2Fxtext-umbrella+repo%3Aeclipse%2Fxtext-core+repo%3Aeclipse%2Fxtext-lib+repo%3Aeclipse%2Fxtext-extras+repo%3Aeclipse%2Fxtext-eclipse+repo%3Aeclipse%2Fxtext-web+repo%3Aeclipse%2Fxtext-maven+repo%3Aeclipse%2Fxtext-xtend&type=Issues&ref=searchresults)
- [All Open Issues](https://github.com/search?utf8=✓&q=is%3Aissue+is%3Aopen+repo%3Aeclipse%2Fxtext+repo%3Aeclipse%2Fxtext-umbrella+repo%3Aeclipse%2Fxtext-core+repo%3Aeclipse%2Fxtext-lib+repo%3Aeclipse%2Fxtext-extras+repo%3Aeclipse%2Fxtext-eclipse+repo%3Aeclipse%2Fxtext-web+repo%3Aeclipse%2Fxtext-maven+repo%3Aeclipse%2Fxtext-xtend&type=Issues&ref=searchresults)
- [Good First Issues](https://github.com/search?utf8=%E2%9C%93&q=is%3Aissue+is%3Aopen+repo%3Aeclipse%2Fxtext+repo%3Aeclipse%2Fxtext-umbrella+repo%3Aeclipse%2Fxtext-core+repo%3Aeclipse%2Fxtext-lib+repo%3Aeclipse%2Fxtext-extras+repo%3Aeclipse%2Fxtext-eclipse+repo%3Aeclipse%2Fxtext-web+repo%3Aeclipse%2Fxtext-maven+repo%3Aeclipse%2Fxtext-xtend+label%3A%22good+first+issue%22&type=Issues&ref=advsearch&l=&l=)
- [All Open Issues of Milestone Release_2.26](https://github.com/search?utf8=✓&q=is%3Aissue+milestone%3ARelease_2.26+is%3Aopen+repo%3Aeclipse%2Fxtext+repo%3Aeclipse%2Fxtext-umbrella+repo%3Aeclipse%2Fxtext-core+repo%3Aeclipse%2Fxtext-lib+repo%3Aeclipse%2Fxtext-extras+repo%3Aeclipse%2Fxtext-eclipse+repo%3Aeclipse%2Fxtext-web+repo%3Aeclipse%2Fxtext-maven+repo%3Aeclipse%2Fxtext-xtend&type=Issues&ref=searchresults)

## Developer Resources

- [Contributing](CONTRIBUTING.md): report bugs, setup your workspace, submit your changes, etc.
- [Quality Guidelines](QUALITY_GUIDELINES.md): how to craft high-quality code changes, commits and pull-requests.
- [Builds](Builds.md): details about the build infrastructure and release process.
