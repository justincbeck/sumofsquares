Instructions:

Follow these instructions:  https://computefarm.dev.java.net/installation.html

Or do the following:

1. Install the Jini Starter Kit (jini2.1.zip) by unzipping the file and running the installer app.

2. Install Blitz JavaSpaces (installer_pj_2_0beta.jar) by executing the following:

      	java -jar installer_pj_2_0beta.jar
      	
3. Make sure the JINI_HOME environment variable is set to the directory where Jini is installed.

4. Start the JavaSpaces and Transaction Manager services by typing ./blitz.sh in the blitz install dir.

5. Install computefarm (computefarm-0.8.2.zip) by unzipping it to a directory.

6. Start a computefarm worker by executing ./run in the computefarm base directory.

7. Run the squares Ant task in the this project.