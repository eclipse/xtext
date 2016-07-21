# Eclipse Support For The Xtext Framework

This repository contains all Eclipse related code for Xtext, including
 - the general Eclipse support for Xtext languages
 - the Xtext SDK for Eclipse itself
 
## How To Build

Checkout and run `mvn clean install`.

## How to Contribute

We accept PRs. You need to sign a CLA (https://eclipse.org/contribute/)

### Workspace Setup with Eclipse Ooomph

1. Download and start the [Eclipse Installer](https://wiki.eclipse.org/Eclipse_Oomph_Installer).
2. On the initial page, click on the *Switch to Advanced Mode* button in the top right.
3. On the *Product* page, select *Eclipse IDE for Eclipse Committers*.
4. On the *Projects* page, expand the *Xtext* node.
5. Below the *Xtext* node there is an subproject entry for each module. Select those you would like to install. If in doubt, select all of them.
6. Choose your preferred installation settings on the *Variables* page. Enter credentials for your Bugzilla and GitHub account.
7. Finish the wizard, drink a cup of coffee, and watch how your Xtext development environment is assembled.
