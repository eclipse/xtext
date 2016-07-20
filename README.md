# Xtext

Xtext is a framework for development of programming languages and domain specific languages. It covers all aspects of a complete language infrastructure, from parsers, over linker, compiler or interpreter to fully-blown top-notch IDE integration for Eclipse, IntelliJ and Web-based IDEs. It comes with great defaults for all these aspects, which at the same time can be easily tailored to your individual needs.

## Repositories

This is an umbrella repository for the following modules:

- [xtext-core](https://github.com/eclipse/xtext-core): The core framework, [Language Server](https://github.com/Microsoft/vscode-languageserver-protocol) support
- [xtext-lib](https://github.com/eclipse/xtext-lib): Libraries for [Xbase](https://www.eclipse.org/Xtext/documentation/305_xbase.html) and [Xtend](http://www.xtend-lang.org)
- [xtext-extras](https://github.com/eclipse/xtext-extras): Additional editor-independent features, mostly Java support
- [xtext-eclipse](https://github.com/eclipse/xtext-eclipse): Plug-ins for [Eclipse](http://eclipse.org)
- [xtext-idea](https://github.com/eclipse/xtext-idea): Plug-ins for [IntelliJ IDEA](https://www.jetbrains.com/idea/)
- [xtext-web](https://github.com/eclipse/xtext-web): Support for [Orion](http://eclipse.org/orion/), [Ace](http://ace.c9.io) and [CodeMirror](https://codemirror.net)
- [xtext-maven](https://github.com/eclipse/xtext-maven): Support for [Maven](https://maven.apache.org)
- [xtext-xtend](https://github.com/eclipse/xtext-xtend): The [Xtend](http://www.xtend-lang.org) language

Please check the individual repositories for instructions for building and contributing.

## Issues

This project doesn't have 'Issues' enabled. Please add any issues on the individual projects (see above).
When in doubt, use [xtext-core](https://github.com/eclipse/xtext-core/issues).

## How to Contribute

1. Download and start the [Eclipse Installer](https://wiki.eclipse.org/Eclipse_Oomph_Installer).
2. On the initial page, click on the *Switch to Advanced Mode* button in the top right.
3. On the *Product* page, select *Eclipse IDE for Eclipse Committers*.
4. On the *Projects* page, expand the *Xtext* node.
5. Below the *Xtext* node there is an subproject entry for each module. Select those you would like to install. If in doubt, select all of them.
6. Choose your preferred installation settings on the *Variables* page. Enter credentials for your Bugzilla and GitHub account.
7. Finish the wizard, drink a cup of coffee, and watch how your Xtext development environment is assembled.

The Xtext project accepts normal [GitHub pull requests](https://help.github.com/categories/collaborating/). Before your contribution can be accepted by the project, you need to create and electronically sign the [Eclipse Foundation Contributor License Agreement (CLA)](http://www.eclipse.org/legal/CLA.php).

1. Log in at [dev.eclipse.org](https://dev.eclipse.org/site_login/createaccount.php) and enter your GitHub user name in the account settings.
2. Submit the CLA at [projects.eclipse.org](https://projects.eclipse.org/user/login/sso).
3. Sign off all commits of your contribution (`git commit -s`).

The CLA and sign-off status is verified by the *ip-validation* check automatically. If you forgot to sign off your commit, the pull request is rejected. If so, revert your commit, sign it off, and overwrite your branch.

<!-- TODO Jenkins Test -->

## Additional Information
* Project Website: [xtext.org](http://xtext.org)
* Release Plan and Project Metadata: [projects.eclipse.org](https://projects.eclipse.org/projects/modeling.tmf.xtext).

