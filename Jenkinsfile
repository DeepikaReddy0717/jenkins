pipeline {
    agent any

    stages {

        // ===== FRONTEND BUILD =====
        stage('Build Frontend') {
            steps {
                dir('reactfrontend') {
                    bat 'npm install'
                    bat 'npm run build'
                }
            }
        }

        // ===== FRONTEND DEPLOY =====
        stage('Deploy Frontend to Tomcat') {
            steps {
                bat '''
                if exist "C:\\Program Files\\Apache Software Foundation\\Tomcat 10.1\\webapps\\pf" (
                    rmdir /S /Q "C:\\Program Files\\Apache Software Foundation\\Tomcat 10.1\\webapps\\pf"
                )

                mkdir "C:\\Program Files\\Apache Software Foundation\\Tomcat 10.1\\webapps\\pf"
                xcopy /E /I /Y reactfrontend\\dist\\* "C:\\Program Files\\Apache Software Foundation\\Tomcat 10.1\\webapps\\pf"

                '''
            }
        }

        // ===== BACKEND BUILD =====
        stage('Build Backend') {
            steps {
                dir('springbootbackend') {
                    bat 'mvn clean package -DskipTests'
                }
            }
        }

        // ===== BACKEND DEPLOY =====
        stage('Deploy Backend to Tomcat') {
    steps {
        bat '''
        if exist "C:\\Program Files\\Apache Software Foundation\\Tomcat 10.1\\webapps\\pb.war" (
            del /Q "C:\\Program Files\\Apache Software Foundation\\Tomcat 10.1\\webapps\\pb.war"
        )
        if exist "C:\\Program Files\\Apache Software Foundation\\Tomcat 10.1\\webapps\\pb" (
            rmdir /S /Q "C:\\Program Files\\Apache Software Foundation\\Tomcat 10.1\\webapps\\pb"
        )
        copy "springbootbackend\\target\\pb.war" "C:\\Program Files\\Apache Software Foundation\\Tomcat 10.1\\webapps\\pb.war"
        '''
    }
}

    }

    post {
        success {
            echo ' Deployment Successful!'
        }
        failure {
            echo ' Pipeline Failed. Check Jenkins logs.'
        }
    }
}