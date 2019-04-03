pipeline {
  agent any

  options {
    buildDiscarder(logRotator(numToKeepStr:'15'))
    disableConcurrentBuilds()
  }

  tools {
    // see https://wiki.eclipse.org/Jenkins#Jenkins_configuration_and_tools_.28clustered_infra.29
    maven 'apache-maven-latest'
    jdk 'oracle-jdk8-latest'
  }
  
  
  // https://jenkins.io/doc/book/pipeline/syntax/#triggers
  triggers {
    pollSCM('H/5 * * * *')
  }
  
  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }

    stage('Maven Build') {
      steps {
        dir('build') { deleteDir() }
        dir('.m2/repository/org/eclipse/xtext') { deleteDir() }
        dir('.m2/repository/org/eclipse/xtend') { deleteDir() }
        sh '''
          mvn \
            -f org.eclipse.xtext.maven.parent/pom.xml \
            --batch-mode \
            --update-snapshots \
            -fae \
            -PuseJenkinsSnapshots \
            -DJENKINS_URL=$JENKINS_URL \
            -Dmaven.test.failure.ignore=true \
            -Dmaven.repo.local=${WORKSPACE}/.m2/repository \
            -DJENKINS_URL=$JENKINS_URL \
            -Dorg.slf4j.simpleLogger.log.org.apache.maven.cli.transfer.Slf4jMavenTransferListener=warn \
            clean deploy
        '''
      }
    }
  }

  post {
    success {
      archiveArtifacts artifacts: 'build/**'
    }
    changed {
      script {
        def envName = ''
        if (env.JENKINS_URL.contains('ci.eclipse.org/xtext')) {
          envName = ' (JIPP)'
        } else if (env.JENKINS_URL.contains('jenkins.eclipse.org/xtext')) {
          envName = ' (CBI)'
        } else if (env.JENKINS_URL.contains('typefox.io')) {
          envName = ' (TF)'
        }
        
        def curResult = currentBuild.currentResult
        def color = '#00FF00'
        if (curResult == 'SUCCESS' && currentBuild.previousBuild != null) {
          curResult = 'FIXED'
        } else if (curResult == 'UNSTABLE') {
          color = '#FFFF00'
        } else if (curResult == 'FAILURE') {
          color = '#FF0000'
        }
        
        slackSend message: "${curResult}: <${env.BUILD_URL}|${env.JOB_NAME}#${env.BUILD_NUMBER}${envName}>", botUser: true, channel: 'xtext-builds', color: "${color}"
      }
    }
  }
}