// tell Jenkins how to build projects from this repository
node {
   stage 'Checkout'
   checkout scm

   stage 'Build'
   sh "./gradlew build uploadArchives"
   archive '**/build/**/*.jar'
}