![GWT3/J2CL compatible](https://img.shields.io/badge/GWT3/J2CL-compatible-brightgreen.svg)

# dominodo
Domino-ui sample todo app using the Nalu framework.

The purpose of this sample is to show the power of domino-ui and Nalu and to create a more complex J2CL showcase.

**This is not the encouraged way of writing apps with domino-ui and Nalu, but rather a demonostration of domino-ui and Nalu project for J2CL.**

# Run as a GWT2 app

## Run the sample in dev mode

1- execute `mvn clean install`

2- in one terminal execute `mvn gwt:codeserver -pl *-gwt -am` to start the super dev mode.

3- in another terminal execute `mvn tomcat7:run -pl *-server -am -Denv=dev`

wait for both servers to start then access the app at `http://localhost:8080`

## Deploy to tomcat

Find the war file i the target folder of the `dominodo-server` module.


# Run as a J2CL app

1- cd into `dominodo-j2cl`

2- execute `mvn -Pdevmode`

3- when the compilation is completed open out/index.html in your browser.
