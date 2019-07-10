pipeline {
  agent any

  environment {
    DOWNSTREAM_JOBS = 'xtext-extras'
  }

  parameters {
    booleanParam(
      name: 'TRIGGER_DOWNSTREAM_BUILD', 
      defaultValue: (env.BRANCH_NAME.startsWith('milestone')||env.BRANCH_NAME.startsWith('release')), 
      description: 'Should downstream jobs for the same branch be triggered on successful build?'
    )
  }

  options {
    buildDiscarder(logRotator(numToKeepStr:'15'))
    disableConcurrentBuilds()
    timeout(time: 60, unit: 'MINUTES')
    timestamps()
  }

  tools { 
    maven 'M3'
  }

  stages {
    stage('Checkout') {
      steps {
        checkout scm
        dir('.m2/repository/org/eclipse/xtext') { deleteDir() }
        dir('.m2/repository/org/eclipse/xtend') { deleteDir() }
      }
    }

    stage('Gradle Build') {
      steps {
        sh './1-gradle-build.sh'
      }
    }
    
    stage('Maven Build') {
      steps {
        sh './2-maven-build.sh'
      }
    }
  }

  post {
    always {
      junit testResults: '**/build/test-results/test/*.xml'
    }
    success {
      archiveArtifacts artifacts: 'build/**'
      script {
        if (params.TRIGGER_DOWNSTREAM_BUILD==true) {
          DOWNSTREAM_JOBS.split(',').each {
            def downstreamUrl = new URL("${env.JENKINS_URL}/job/$it/job/${env.BRANCH_NAME}")
            def boolean downstreamJobExists = sh(script: "curl -L -s -o /dev/null -I -w '%{http_code}' ${downstreamUrl}", returnStdout: true) == "200"
            if (downstreamJobExists) {
              build job: "$it/${env.BRANCH_NAME}", wait: false, parameters: [booleanParam(name: 'TRIGGER_DOWNSTREAM_BUILD', value: "${params.TRIGGER_DOWNSTREAM_BUILD}")]
            }
          }
        }
      }
    }
    changed {
      script {
        def envName = ''
        if (env.JENKINS_URL.contains('ci.eclipse.org/xtext')) {
          envName = ' (JIPP)'
        } else if (env.JENKINS_URL.contains('typefox.io')) {
          envName = ' (TF)'
        }
        
        def curResult = currentBuild.currentResult
        def color = '#00FF00'
        if (curResult == 'SUCCESS') {
           if (currentBuild.previousBuild != null && currentBuild.previousBuild.result != 'SUCCESS') {
             curResult = 'FIXED'
           }
        } else if (curResult == 'UNSTABLE') {
          color = '#FFFF00'
        } else { // FAILURE, ABORTED, NOT_BUILD
          color = '#FF0000'
        }
        
        slackSend message: "${curResult}: <${env.BUILD_URL}|${env.JOB_NAME}#${env.BUILD_NUMBER}${envName}>", botUser: true, channel: 'xtext-builds', color: "${color}"
      }
    }
  }
}
